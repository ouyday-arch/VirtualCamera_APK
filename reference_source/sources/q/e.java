package q;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import p.a;
import v.b;

/* loaded from: classes.dex */
public class e extends c {

    /* renamed from: g, reason: collision with root package name */
    protected final Class<?> f5515g;

    /* renamed from: h, reason: collision with root package name */
    protected final Constructor<?> f5516h;

    /* renamed from: i, reason: collision with root package name */
    protected final Method f5517i;

    /* renamed from: j, reason: collision with root package name */
    protected final Method f5518j;

    /* renamed from: k, reason: collision with root package name */
    protected final Method f5519k;

    /* renamed from: l, reason: collision with root package name */
    protected final Method f5520l;

    /* renamed from: m, reason: collision with root package name */
    protected final Method f5521m;

    public e() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> u4 = u();
            constructor = v(u4);
            method2 = r(u4);
            method3 = s(u4);
            method4 = w(u4);
            method5 = q(u4);
            method = t(u4);
            cls = u4;
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e4.getClass().getName(), e4);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f5515g = cls;
        this.f5516h = constructor;
        this.f5517i = method2;
        this.f5518j = method3;
        this.f5519k = method4;
        this.f5520l = method5;
        this.f5521m = method;
    }

    private Object k() {
        try {
            return this.f5516h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void l(Object obj) {
        try {
            this.f5520l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean m(Context context, Object obj, String str, int i4, int i5, int i6, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f5517i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean n(Object obj, ByteBuffer byteBuffer, int i4, int i5, int i6) {
        try {
            return ((Boolean) this.f5518j.invoke(obj, byteBuffer, Integer.valueOf(i4), null, Integer.valueOf(i5), Integer.valueOf(i6))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean o(Object obj) {
        try {
            return ((Boolean) this.f5519k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean p() {
        if (this.f5517i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f5517i != null;
    }

    @Override // q.c, q.h
    public Typeface a(Context context, a.b bVar, Resources resources, int i4) {
        if (!p()) {
            return super.a(context, bVar, resources, i4);
        }
        Object k4 = k();
        if (k4 == null) {
            return null;
        }
        for (a.c cVar : bVar.a()) {
            if (!m(context, k4, cVar.a(), cVar.c(), cVar.e(), cVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                l(k4);
                return null;
            }
        }
        if (o(k4)) {
            return h(k4);
        }
        return null;
    }

    @Override // q.c, q.h
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i4) {
        Typeface h4;
        if (fVarArr.length < 1) {
            return null;
        }
        if (p()) {
            Map<Uri, ByteBuffer> i5 = v.b.i(context, fVarArr, cancellationSignal);
            Object k4 = k();
            if (k4 == null) {
                return null;
            }
            boolean z4 = false;
            for (b.f fVar : fVarArr) {
                ByteBuffer byteBuffer = i5.get(fVar.c());
                if (byteBuffer != null) {
                    if (!n(k4, byteBuffer, fVar.b(), fVar.d(), fVar.e() ? 1 : 0)) {
                        l(k4);
                        return null;
                    }
                    z4 = true;
                }
            }
            if (!z4) {
                l(k4);
                return null;
            }
            if (o(k4) && (h4 = h(k4)) != null) {
                return Typeface.create(h4, i4);
            }
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
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(f4.d()).setItalic(f4.e()).build();
                openFileDescriptor.close();
                return build;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // q.h
    public Typeface d(Context context, Resources resources, int i4, String str, int i5) {
        if (!p()) {
            return super.d(context, resources, i4, str, i5);
        }
        Object k4 = k();
        if (k4 == null) {
            return null;
        }
        if (!m(context, k4, str, 0, -1, -1, null)) {
            l(k4);
            return null;
        }
        if (o(k4)) {
            return h(k4);
        }
        return null;
    }

    protected Typeface h(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f5515g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f5521m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method q(Class<?> cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method r(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method s(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method t(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class<?> u() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> v(Class<?> cls) {
        return cls.getConstructor(new Class[0]);
    }

    protected Method w(Class<?> cls) {
        return cls.getMethod("freeze", new Class[0]);
    }
}
