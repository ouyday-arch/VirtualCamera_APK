package t2;

import java.util.concurrent.Executor;
import s2.b;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final p[] f5964a = new p[1];

    /* renamed from: b, reason: collision with root package name */
    private static boolean f5965b;

    /* renamed from: c, reason: collision with root package name */
    private static a f5966c;

    public static synchronized p c() {
        p e4;
        synchronized (g.class) {
            e4 = e();
            if (e4 == null) {
                f5965b = true;
                if (f5966c == null) {
                    f5966c = new a();
                }
                e4 = f5966c.d();
                f5965b = false;
            }
        }
        return e4;
    }

    public static void d(final Executor executor, final b.InterfaceC0076b interfaceC0076b) {
        p e4 = e();
        if (e4 != null) {
            i(e4, executor, interfaceC0076b);
        } else {
            s2.b.f5886b.execute(new Runnable() { // from class: t2.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.f(executor, interfaceC0076b);
                }
            });
        }
    }

    public static p e() {
        p pVar;
        p[] pVarArr = f5964a;
        synchronized (pVarArr) {
            pVar = pVarArr[0];
            if (pVar != null && pVar.L() < 0) {
                pVarArr[0] = null;
            }
        }
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Executor executor, b.InterfaceC0076b interfaceC0076b) {
        try {
            i(c(), executor, interfaceC0076b);
        } catch (s2.a unused) {
        }
    }

    public static b.d h(boolean z4, String... strArr) {
        return new k(z4).M(strArr);
    }

    private static void i(final s2.b bVar, Executor executor, final b.InterfaceC0076b interfaceC0076b) {
        if (executor == null) {
            interfaceC0076b.a(bVar);
        } else {
            executor.execute(new Runnable() { // from class: t2.f
                @Override // java.lang.Runnable
                public final void run() {
                    b.InterfaceC0076b.this.a(bVar);
                }
            });
        }
    }

    public static synchronized void j(b.a aVar) {
        synchronized (g.class) {
            if (f5965b || e() != null) {
                throw new IllegalStateException("The main shell was already created");
            }
            f5966c = (a) aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void k(p pVar) {
        synchronized (g.class) {
            if (f5965b) {
                p[] pVarArr = f5964a;
                synchronized (pVarArr) {
                    pVarArr[0] = pVar;
                }
            }
        }
    }
}
