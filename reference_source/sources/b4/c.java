package b4;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class c extends h0 {

    /* renamed from: i, reason: collision with root package name */
    private static final a f2307i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static final ReentrantLock f2308j;

    /* renamed from: k, reason: collision with root package name */
    private static final Condition f2309k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f2310l;

    /* renamed from: m, reason: collision with root package name */
    private static final long f2311m;

    /* renamed from: n, reason: collision with root package name */
    private static c f2312n;

    /* renamed from: f, reason: collision with root package name */
    private int f2313f;

    /* renamed from: g, reason: collision with root package name */
    private c f2314g;

    /* renamed from: h, reason: collision with root package name */
    private long f2315h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[EDGE_INSN: B:23:0x0060->B:17:0x0060 BREAK  A[LOOP:0: B:11:0x0042->B:15:0x005b], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void f(b4.c r5, long r6, boolean r8) {
            /*
                r4 = this;
                b4.c r0 = b4.c.k()
                if (r0 != 0) goto L16
                b4.c r0 = new b4.c
                r0.<init>()
                b4.c.r(r0)
                b4.c$b r0 = new b4.c$b
                r0.<init>()
                r0.start()
            L16:
                long r0 = java.lang.System.nanoTime()
                r2 = 0
                int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r2 == 0) goto L2c
                if (r8 == 0) goto L2c
                long r2 = r5.c()
                long r2 = r2 - r0
                long r6 = java.lang.Math.min(r6, r2)
                goto L2e
            L2c:
                if (r2 == 0) goto L33
            L2e:
                long r6 = r6 + r0
            L2f:
                b4.c.u(r5, r6)
                goto L3a
            L33:
                if (r8 == 0) goto L78
                long r6 = r5.c()
                goto L2f
            L3a:
                long r6 = b4.c.q(r5, r0)
                b4.c r8 = b4.c.k()
            L42:
                e3.f.b(r8)
                b4.c r2 = b4.c.o(r8)
                if (r2 == 0) goto L60
                b4.c r2 = b4.c.o(r8)
                e3.f.b(r2)
                long r2 = b4.c.q(r2, r0)
                int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r2 >= 0) goto L5b
                goto L60
            L5b:
                b4.c r8 = b4.c.o(r8)
                goto L42
            L60:
                b4.c r6 = b4.c.o(r8)
                b4.c.s(r5, r6)
                b4.c.s(r8, r5)
                b4.c r5 = b4.c.k()
                if (r8 != r5) goto L77
                java.util.concurrent.locks.Condition r5 = r4.d()
                r5.signal()
            L77:
                return
            L78:
                java.lang.AssertionError r5 = new java.lang.AssertionError
                r5.<init>()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: b4.c.a.f(b4.c, long, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(c cVar) {
            for (c cVar2 = c.f2312n; cVar2 != null; cVar2 = cVar2.f2314g) {
                if (cVar2.f2314g == cVar) {
                    cVar2.f2314g = cVar.f2314g;
                    cVar.f2314g = null;
                    return;
                }
            }
            throw new IllegalStateException("node was not found in the queue".toString());
        }

        public final c c() {
            c cVar = c.f2312n;
            e3.f.b(cVar);
            c cVar2 = cVar.f2314g;
            long nanoTime = System.nanoTime();
            if (cVar2 == null) {
                d().await(c.f2310l, TimeUnit.MILLISECONDS);
                c cVar3 = c.f2312n;
                e3.f.b(cVar3);
                if (cVar3.f2314g != null || System.nanoTime() - nanoTime < c.f2311m) {
                    return null;
                }
                return c.f2312n;
            }
            long y4 = cVar2.y(nanoTime);
            if (y4 > 0) {
                d().await(y4, TimeUnit.NANOSECONDS);
                return null;
            }
            c cVar4 = c.f2312n;
            e3.f.b(cVar4);
            cVar4.f2314g = cVar2.f2314g;
            cVar2.f2314g = null;
            cVar2.f2313f = 2;
            return cVar2;
        }

        public final Condition d() {
            return c.f2309k;
        }

        public final ReentrantLock e() {
            return c.f2308j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock e4;
            c c5;
            while (true) {
                try {
                    e4 = c.f2307i.e();
                    e4.lock();
                    try {
                        c5 = c.f2307i.c();
                    } finally {
                        e4.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (c5 == c.f2312n) {
                    a unused2 = c.f2307i;
                    c.f2312n = null;
                    return;
                } else {
                    u2.l lVar = u2.l.f6223a;
                    e4.unlock();
                    if (c5 != null) {
                        c5.B();
                    }
                }
            }
        }
    }

    /* renamed from: b4.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0020c implements e0 {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e0 f2317c;

        C0020c(e0 e0Var) {
            this.f2317c = e0Var;
        }

        @Override // b4.e0
        public void F(b4.d dVar, long j4) {
            e3.f.e(dVar, "source");
            b4.b.b(dVar.c0(), 0L, j4);
            while (true) {
                long j5 = 0;
                if (j4 <= 0) {
                    return;
                }
                b0 b0Var = dVar.f2325b;
                while (true) {
                    e3.f.b(b0Var);
                    if (j5 >= 65536) {
                        break;
                    }
                    j5 += b0Var.f2302c - b0Var.f2301b;
                    if (j5 >= j4) {
                        j5 = j4;
                        break;
                    }
                    b0Var = b0Var.f2305f;
                }
                c cVar = c.this;
                e0 e0Var = this.f2317c;
                cVar.v();
                try {
                    e0Var.F(dVar, j5);
                    u2.l lVar = u2.l.f6223a;
                    if (cVar.w()) {
                        throw cVar.p(null);
                    }
                    j4 -= j5;
                } catch (IOException e4) {
                    if (!cVar.w()) {
                        throw e4;
                    }
                    throw cVar.p(e4);
                } finally {
                    cVar.w();
                }
            }
        }

        @Override // b4.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            c cVar = c.this;
            e0 e0Var = this.f2317c;
            cVar.v();
            try {
                e0Var.close();
                u2.l lVar = u2.l.f6223a;
                if (cVar.w()) {
                    throw cVar.p(null);
                }
            } catch (IOException e4) {
                if (!cVar.w()) {
                    throw e4;
                }
                throw cVar.p(e4);
            } finally {
                cVar.w();
            }
        }

        @Override // b4.e0, java.io.Flushable
        public void flush() {
            c cVar = c.this;
            e0 e0Var = this.f2317c;
            cVar.v();
            try {
                e0Var.flush();
                u2.l lVar = u2.l.f6223a;
                if (cVar.w()) {
                    throw cVar.p(null);
                }
            } catch (IOException e4) {
                if (!cVar.w()) {
                    throw e4;
                }
                throw cVar.p(e4);
            } finally {
                cVar.w();
            }
        }

        @Override // b4.e0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public c b() {
            return c.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f2317c + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements g0 {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g0 f2319c;

        d(g0 g0Var) {
            this.f2319c = g0Var;
        }

        @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            c cVar = c.this;
            g0 g0Var = this.f2319c;
            cVar.v();
            try {
                g0Var.close();
                u2.l lVar = u2.l.f6223a;
                if (cVar.w()) {
                    throw cVar.p(null);
                }
            } catch (IOException e4) {
                if (!cVar.w()) {
                    throw e4;
                }
                throw cVar.p(e4);
            } finally {
                cVar.w();
            }
        }

        @Override // b4.g0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public c b() {
            return c.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f2319c + ')';
        }

        @Override // b4.g0
        public long u(b4.d dVar, long j4) {
            e3.f.e(dVar, "sink");
            c cVar = c.this;
            g0 g0Var = this.f2319c;
            cVar.v();
            try {
                long u4 = g0Var.u(dVar, j4);
                if (cVar.w()) {
                    throw cVar.p(null);
                }
                return u4;
            } catch (IOException e4) {
                if (cVar.w()) {
                    throw cVar.p(e4);
                }
                throw e4;
            } finally {
                cVar.w();
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f2308j = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        e3.f.d(newCondition, "newCondition(...)");
        f2309k = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f2310l = millis;
        f2311m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long y(long j4) {
        return this.f2315h - j4;
    }

    public final g0 A(g0 g0Var) {
        e3.f.e(g0Var, "source");
        return new d(g0Var);
    }

    protected void B() {
    }

    public final IOException p(IOException iOException) {
        return x(iOException);
    }

    public final void v() {
        long h4 = h();
        boolean e4 = e();
        if (h4 != 0 || e4) {
            ReentrantLock reentrantLock = f2308j;
            reentrantLock.lock();
            try {
                if (!(this.f2313f == 0)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                this.f2313f = 1;
                f2307i.f(this, h4, e4);
                u2.l lVar = u2.l.f6223a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean w() {
        ReentrantLock reentrantLock = f2308j;
        reentrantLock.lock();
        try {
            int i4 = this.f2313f;
            this.f2313f = 0;
            if (i4 != 1) {
                return i4 == 2;
            }
            f2307i.g(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    protected IOException x(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final e0 z(e0 e0Var) {
        e3.f.e(e0Var, "sink");
        return new C0020c(e0Var);
    }
}
