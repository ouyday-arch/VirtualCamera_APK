package k2;

import android.app.Application;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static Application f4440a;

    /* renamed from: b, reason: collision with root package name */
    private static l2.c f4441b;

    /* renamed from: c, reason: collision with root package name */
    private static l2.d<?> f4442c;

    /* renamed from: d, reason: collision with root package name */
    private static l2.b f4443d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f4444e;

    private o() {
    }

    private static void a() {
        if (f4440a == null) {
            throw new IllegalStateException("Toaster has not been initialized");
        }
    }

    public static void b(Application application) {
        d(application, f4442c);
    }

    public static void c(Application application, l2.c cVar, l2.d<?> dVar) {
        f4440a = application;
        if (cVar == null) {
            cVar = new n();
        }
        f(cVar);
        if (dVar == null) {
            dVar = new m2.a();
        }
        g(dVar);
    }

    public static void d(Application application, l2.d<?> dVar) {
        c(application, null, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e() {
        if (f4444e == null) {
            a();
            f4444e = Boolean.valueOf((f4440a.getApplicationInfo().flags & 2) != 0);
        }
        return f4444e.booleanValue();
    }

    public static void f(l2.c cVar) {
        f4441b = cVar;
        cVar.a(f4440a);
    }

    public static void g(l2.d<?> dVar) {
        f4442c = dVar;
    }

    public static void h(CharSequence charSequence) {
        m mVar = new m();
        mVar.f4425a = charSequence;
        i(mVar);
    }

    public static void i(m mVar) {
        a();
        CharSequence charSequence = mVar.f4425a;
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        if (mVar.f4429e == null) {
            mVar.f4429e = f4441b;
        }
        if (mVar.f4430f == null) {
            if (f4443d == null) {
                f4443d = new l();
            }
            mVar.f4430f = f4443d;
        }
        if (mVar.f4428d == null) {
            mVar.f4428d = f4442c;
        }
        if (mVar.f4430f.a(mVar)) {
            return;
        }
        if (mVar.f4426b == -1) {
            mVar.f4426b = mVar.f4425a.length() > 20 ? 1 : 0;
        }
        mVar.f4429e.b(mVar);
    }

    public static void j(CharSequence charSequence) {
        m mVar = new m();
        mVar.f4425a = charSequence;
        mVar.f4426b = 1;
        i(mVar);
    }
}
