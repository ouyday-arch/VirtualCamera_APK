package b4;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class h0 {

    /* renamed from: d, reason: collision with root package name */
    public static final b f2349d = new b(null);

    /* renamed from: e, reason: collision with root package name */
    public static final h0 f2350e = new a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f2351a;

    /* renamed from: b, reason: collision with root package name */
    private long f2352b;

    /* renamed from: c, reason: collision with root package name */
    private long f2353c;

    /* loaded from: classes.dex */
    public static final class a extends h0 {
        a() {
        }

        @Override // b4.h0
        public h0 d(long j4) {
            return this;
        }

        @Override // b4.h0
        public void f() {
        }

        @Override // b4.h0
        public h0 g(long j4, TimeUnit timeUnit) {
            e3.f.e(timeUnit, "unit");
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }
    }

    public h0 a() {
        this.f2351a = false;
        return this;
    }

    public h0 b() {
        this.f2353c = 0L;
        return this;
    }

    public long c() {
        if (this.f2351a) {
            return this.f2352b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public h0 d(long j4) {
        this.f2351a = true;
        this.f2352b = j4;
        return this;
    }

    public boolean e() {
        return this.f2351a;
    }

    public void f() {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f2351a && this.f2352b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public h0 g(long j4, TimeUnit timeUnit) {
        e3.f.e(timeUnit, "unit");
        if (j4 >= 0) {
            this.f2353c = timeUnit.toNanos(j4);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j4).toString());
    }

    public long h() {
        return this.f2353c;
    }
}
