package j0;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class b {

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final b f4179a = new k0.c();
    }

    public static b a() {
        if (c.a("PROXY_OVERRIDE")) {
            return a.f4179a;
        }
        throw new UnsupportedOperationException("Proxy override not supported");
    }

    public abstract void b(j0.a aVar, Executor executor, Runnable runnable);
}
