package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final k.a<String, Method> f2111a;

    /* renamed from: b, reason: collision with root package name */
    protected final k.a<String, Method> f2112b;

    /* renamed from: c, reason: collision with root package name */
    protected final k.a<String, Class> f2113c;

    public a(k.a<String, Method> aVar, k.a<String, Method> aVar2, k.a<String, Class> aVar3) {
        this.f2111a = aVar;
        this.f2112b = aVar2;
        this.f2113c = aVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(i0.a aVar) {
        try {
            I(c(aVar.getClass()).getName());
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException(aVar.getClass().getSimpleName() + " does not have a Parcelizer", e4);
        }
    }

    private Class c(Class<? extends i0.a> cls) {
        Class cls2 = this.f2113c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f2113c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) {
        Method method = this.f2111a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f2111a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method e(Class cls) {
        Method method = this.f2112b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c5 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c5.getDeclaredMethod("write", cls, a.class);
        this.f2112b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i4) {
        w(i4);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i4) {
        w(i4);
        C(charSequence);
    }

    protected abstract void E(int i4);

    public void F(int i4, int i5) {
        w(i5);
        E(i4);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i4) {
        w(i4);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i4) {
        w(i4);
        I(str);
    }

    protected <T extends i0.a> void K(T t4, a aVar) {
        try {
            e(t4.getClass()).invoke(null, t4, aVar);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
        } catch (InvocationTargetException e7) {
            if (!(e7.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
            }
            throw ((RuntimeException) e7.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(i0.a aVar) {
        if (aVar == null) {
            I(null);
            return;
        }
        N(aVar);
        a b5 = b();
        K(aVar, b5);
        b5.a();
    }

    public void M(i0.a aVar, int i4) {
        w(i4);
        L(aVar);
    }

    protected abstract void a();

    protected abstract a b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z4, int i4) {
        return !m(i4) ? z4 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i4) {
        return !m(i4) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i4) {
        return !m(i4) ? charSequence : k();
    }

    protected abstract boolean m(int i4);

    protected <T extends i0.a> T n(String str, a aVar) {
        try {
            return (T) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
        } catch (InvocationTargetException e7) {
            if (e7.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e7.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
        }
    }

    protected abstract int o();

    public int p(int i4, int i5) {
        return !m(i5) ? i4 : o();
    }

    protected abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t4, int i4) {
        return !m(i4) ? t4 : (T) q();
    }

    protected abstract String s();

    public String t(String str, int i4) {
        return !m(i4) ? str : s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends i0.a> T u() {
        String s4 = s();
        if (s4 == null) {
            return null;
        }
        return (T) n(s4, b());
    }

    public <T extends i0.a> T v(T t4, int i4) {
        return !m(i4) ? t4 : (T) u();
    }

    protected abstract void w(int i4);

    public void x(boolean z4, boolean z5) {
    }

    protected abstract void y(boolean z4);

    public void z(boolean z4, int i4) {
        w(i4);
        y(z4);
    }
}
