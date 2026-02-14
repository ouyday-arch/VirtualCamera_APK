package q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import p.a;
import v.b;

/* loaded from: classes.dex */
class d extends h {

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?> f5511b;

    /* renamed from: c, reason: collision with root package name */
    private static final Constructor<?> f5512c;

    /* renamed from: d, reason: collision with root package name */
    private static final Method f5513d;

    /* renamed from: e, reason: collision with root package name */
    private static final Method f5514e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi24Impl", e4.getClass().getName(), e4);
            cls = null;
            method = null;
            method2 = null;
        }
        f5512c = constructor;
        f5511b = cls;
        f5513d = method2;
        f5514e = method;
    }

    private static boolean g(Object obj, ByteBuffer byteBuffer, int i4, int i5, boolean z4) {
        try {
            return ((Boolean) f5513d.invoke(obj, byteBuffer, Integer.valueOf(i4), null, Integer.valueOf(i5), Boolean.valueOf(z4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface h(Object obj) {
        try {
            Object newInstance = Array.newInstance(f5511b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f5514e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean i() {
        Method method = f5513d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object j() {
        try {
            return f5512c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // q.h
    public Typeface a(Context context, a.b bVar, Resources resources, int i4) {
        Object j4 = j();
        if (j4 == null) {
            return null;
        }
        for (a.c cVar : bVar.a()) {
            ByteBuffer b5 = i.b(context, resources, cVar.b());
            if (b5 == null || !g(j4, b5, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        return h(j4);
    }

    @Override // q.h
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i4) {
        Object j4 = j();
        if (j4 == null) {
            return null;
        }
        k.g gVar = new k.g();
        for (b.f fVar : fVarArr) {
            Uri c5 = fVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(c5);
            if (byteBuffer == null) {
                byteBuffer = i.f(context, cancellationSignal, c5);
                gVar.put(c5, byteBuffer);
            }
            if (byteBuffer == null || !g(j4, byteBuffer, fVar.b(), fVar.d(), fVar.e())) {
                return null;
            }
        }
        Typeface h4 = h(j4);
        if (h4 == null) {
            return null;
        }
        return Typeface.create(h4, i4);
    }
}
