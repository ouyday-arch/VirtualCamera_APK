package h;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f4064c;

    /* renamed from: d, reason: collision with root package name */
    private static final Executor f4065d = new ExecutorC0045a();

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f4066e = new b();

    /* renamed from: a, reason: collision with root package name */
    private c f4067a;

    /* renamed from: b, reason: collision with root package name */
    private c f4068b;

    /* renamed from: h.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class ExecutorC0045a implements Executor {
        ExecutorC0045a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().c(runnable);
        }
    }

    /* loaded from: classes.dex */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().a(runnable);
        }
    }

    private a() {
        h.b bVar = new h.b();
        this.f4068b = bVar;
        this.f4067a = bVar;
    }

    public static a d() {
        if (f4064c != null) {
            return f4064c;
        }
        synchronized (a.class) {
            if (f4064c == null) {
                f4064c = new a();
            }
        }
        return f4064c;
    }

    @Override // h.c
    public void a(Runnable runnable) {
        this.f4067a.a(runnable);
    }

    @Override // h.c
    public boolean b() {
        return this.f4067a.b();
    }

    @Override // h.c
    public void c(Runnable runnable) {
        this.f4067a.c(runnable);
    }
}
