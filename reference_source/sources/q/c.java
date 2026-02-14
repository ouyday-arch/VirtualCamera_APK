package q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p.a;
import v.b;

/* loaded from: classes.dex */
class c extends h {

    /* renamed from: b, reason: collision with root package name */
    private static Class<?> f5506b;

    /* renamed from: c, reason: collision with root package name */
    private static Constructor<?> f5507c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f5508d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f5509e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f5510f;

    private static boolean g(Object obj, String str, int i4, boolean z4) {
        j();
        try {
            return ((Boolean) f5508d.invoke(obj, str, Integer.valueOf(i4), Boolean.valueOf(z4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static Typeface h(Object obj) {
        j();
        try {
            Object newInstance = Array.newInstance(f5506b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f5509e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    private File i(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void j() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f5510f) {
            return;
        }
        f5510f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi21Impl", e4.getClass().getName(), e4);
            method = null;
            cls = null;
            method2 = null;
        }
        f5507c = constructor;
        f5506b = cls;
        f5508d = method2;
        f5509e = method;
    }

    private static Object k() {
        j();
        try {
            return f5507c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // q.h
    public Typeface a(Context context, a.b bVar, Resources resources, int i4) {
        Object k4 = k();
        for (a.c cVar : bVar.a()) {
            File e4 = i.e(context);
            if (e4 == null) {
                return null;
            }
            try {
                if (!i.c(e4, resources, cVar.b())) {
                    return null;
                }
                if (!g(k4, e4.getPath(), cVar.e(), cVar.f())) {
                    return null;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e4.delete();
            }
        }
        return h(k4);
    }

    @Override // q.h
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i4) {
        if (fVarArr.length < 1) {
            return null;
        }
        b.f f4 = f(fVarArr, i4);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(f4.c(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File i5 = i(openFileDescriptor);
                if (i5 != null && i5.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(i5);
                    openFileDescriptor.close();
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    Typeface c5 = super.c(context, fileInputStream);
                    fileInputStream.close();
                    openFileDescriptor.close();
                    return c5;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
