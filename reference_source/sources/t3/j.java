package t3;

import b4.e0;
import b4.g0;
import b4.h0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import l3.u;
import m3.s;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: n, reason: collision with root package name */
    public static final a f6157n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f6158a;

    /* renamed from: b, reason: collision with root package name */
    private final g f6159b;

    /* renamed from: c, reason: collision with root package name */
    private final u3.a f6160c;

    /* renamed from: d, reason: collision with root package name */
    private long f6161d;

    /* renamed from: e, reason: collision with root package name */
    private long f6162e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque<u> f6163f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6164g;

    /* renamed from: h, reason: collision with root package name */
    private final c f6165h;

    /* renamed from: i, reason: collision with root package name */
    private final b f6166i;

    /* renamed from: j, reason: collision with root package name */
    private final d f6167j;

    /* renamed from: k, reason: collision with root package name */
    private final d f6168k;

    /* renamed from: l, reason: collision with root package name */
    private t3.b f6169l;

    /* renamed from: m, reason: collision with root package name */
    private IOException f6170m;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public final class b implements e0 {

        /* renamed from: b, reason: collision with root package name */
        private boolean f6171b;

        /* renamed from: c, reason: collision with root package name */
        private final b4.d f6172c = new b4.d();

        /* renamed from: d, reason: collision with root package name */
        private u f6173d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f6174e;

        public b(boolean z4) {
            this.f6171b = z4;
        }

        private final void i(boolean z4) {
            long min;
            boolean z5;
            j jVar = j.this;
            synchronized (jVar) {
                jVar.t().v();
                while (jVar.s() >= jVar.r() && !this.f6171b && !this.f6174e && jVar.j() == null) {
                    try {
                        jVar.D();
                    } finally {
                        jVar.t().C();
                    }
                }
                jVar.t().C();
                jVar.d();
                min = Math.min(jVar.r() - jVar.s(), this.f6172c.c0());
                jVar.A(jVar.s() + min);
                z5 = z4 && min == this.f6172c.c0();
                u2.l lVar = u2.l.f6223a;
            }
            j.this.t().v();
            try {
                j.this.i().D0(j.this.l(), z5, this.f6172c, min);
            } finally {
                jVar = j.this;
            }
        }

        @Override // b4.e0
        public void F(b4.d dVar, long j4) {
            e3.f.e(dVar, "source");
            j jVar = j.this;
            if (!s.f5213e || !Thread.holdsLock(jVar)) {
                this.f6172c.F(dVar, j4);
                while (this.f6172c.c0() >= 16384) {
                    i(false);
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + jVar);
            }
        }

        public final boolean I() {
            return this.f6174e;
        }

        public final boolean J() {
            return this.f6171b;
        }

        @Override // b4.e0
        public h0 b() {
            return j.this.t();
        }

        @Override // b4.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            j jVar = j.this;
            if (s.f5213e && Thread.holdsLock(jVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + jVar);
            }
            j jVar2 = j.this;
            synchronized (jVar2) {
                if (this.f6174e) {
                    return;
                }
                boolean z4 = jVar2.j() == null;
                u2.l lVar = u2.l.f6223a;
                if (!j.this.p().f6171b) {
                    boolean z5 = this.f6172c.c0() > 0;
                    if (this.f6173d != null) {
                        while (this.f6172c.c0() > 0) {
                            i(false);
                        }
                        g i4 = j.this.i();
                        int l4 = j.this.l();
                        u uVar = this.f6173d;
                        e3.f.b(uVar);
                        i4.E0(l4, z4, s.p(uVar));
                    } else if (z5) {
                        while (this.f6172c.c0() > 0) {
                            i(true);
                        }
                    } else if (z4) {
                        j.this.i().D0(j.this.l(), true, null, 0L);
                    }
                }
                j jVar3 = j.this;
                synchronized (jVar3) {
                    this.f6174e = true;
                    e3.f.c(jVar3, "null cannot be cast to non-null type java.lang.Object");
                    jVar3.notifyAll();
                    u2.l lVar2 = u2.l.f6223a;
                }
                j.this.i().flush();
                j.this.c();
            }
        }

        @Override // b4.e0, java.io.Flushable
        public void flush() {
            j jVar = j.this;
            if (s.f5213e && Thread.holdsLock(jVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + jVar);
            }
            j jVar2 = j.this;
            synchronized (jVar2) {
                jVar2.d();
                u2.l lVar = u2.l.f6223a;
            }
            while (this.f6172c.c0() > 0) {
                i(false);
                j.this.i().flush();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class c implements g0 {

        /* renamed from: b, reason: collision with root package name */
        private final long f6176b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f6177c;

        /* renamed from: d, reason: collision with root package name */
        private final b4.d f6178d = new b4.d();

        /* renamed from: e, reason: collision with root package name */
        private final b4.d f6179e = new b4.d();

        /* renamed from: f, reason: collision with root package name */
        private u f6180f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f6181g;

        public c(long j4, boolean z4) {
            this.f6176b = j4;
            this.f6177c = z4;
        }

        private final void P(long j4) {
            j jVar = j.this;
            if (!s.f5213e || !Thread.holdsLock(jVar)) {
                j.this.i().C0(j4);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + jVar);
        }

        public final boolean I() {
            return this.f6177c;
        }

        public final b4.d J() {
            return this.f6179e;
        }

        public final b4.d K() {
            return this.f6178d;
        }

        public final u L() {
            return this.f6180f;
        }

        public final void M(b4.f fVar, long j4) {
            boolean z4;
            boolean z5;
            boolean z6;
            e3.f.e(fVar, "source");
            j jVar = j.this;
            if (s.f5213e && Thread.holdsLock(jVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + jVar);
            }
            long j5 = j4;
            while (j5 > 0) {
                synchronized (j.this) {
                    z4 = this.f6177c;
                    z5 = true;
                    z6 = this.f6179e.c0() + j5 > this.f6176b;
                    u2.l lVar = u2.l.f6223a;
                }
                if (z6) {
                    fVar.o(j5);
                    j.this.g(t3.b.f6011g);
                    return;
                }
                if (z4) {
                    fVar.o(j5);
                    return;
                }
                long u4 = fVar.u(this.f6178d, j5);
                if (u4 == -1) {
                    throw new EOFException();
                }
                j5 -= u4;
                j jVar2 = j.this;
                synchronized (jVar2) {
                    if (this.f6181g) {
                        this.f6178d.I();
                    } else {
                        if (this.f6179e.c0() != 0) {
                            z5 = false;
                        }
                        this.f6179e.j0(this.f6178d);
                        if (z5) {
                            e3.f.c(jVar2, "null cannot be cast to non-null type java.lang.Object");
                            jVar2.notifyAll();
                        }
                    }
                }
            }
            P(j4);
            j.this.i().d0().a(j.this.l(), j.this.m(), this.f6179e.c0());
        }

        public final void N(boolean z4) {
            this.f6177c = z4;
        }

        public final void O(u uVar) {
            this.f6180f = uVar;
        }

        @Override // b4.g0
        public h0 b() {
            return j.this.n();
        }

        @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            long c02;
            j jVar = j.this;
            synchronized (jVar) {
                this.f6181g = true;
                c02 = this.f6179e.c0();
                this.f6179e.I();
                e3.f.c(jVar, "null cannot be cast to non-null type java.lang.Object");
                jVar.notifyAll();
                u2.l lVar = u2.l.f6223a;
            }
            if (c02 > 0) {
                P(c02);
            }
            j.this.c();
        }

        public final boolean i() {
            return this.f6181g;
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x00f7, code lost:
        
            throw new java.io.IOException("stream closed");
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b8 A[Catch: all -> 0x0103, DONT_GENERATE, TRY_ENTER, TryCatch #0 {, blocks: (B:8:0x001a, B:10:0x0020, B:30:0x00b8, B:31:0x00bf, B:56:0x00fb, B:57:0x0102, B:12:0x0027, B:14:0x002d, B:16:0x0031, B:18:0x0037, B:19:0x0043, B:21:0x0047, B:23:0x0053, B:25:0x007a, B:27:0x008d, B:44:0x00a8, B:47:0x00ae, B:51:0x00f0, B:52:0x00f7), top: B:7:0x001a, inners: #1 }] */
        @Override // b4.g0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long u(b4.d r24, long r25) {
            /*
                Method dump skipped, instructions count: 289
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: t3.j.c.u(b4.d, long):long");
        }
    }

    /* loaded from: classes.dex */
    public final class d extends b4.c {
        public d() {
        }

        @Override // b4.c
        protected void B() {
            j.this.g(t3.b.f6016l);
            j.this.i().w0();
        }

        public final void C() {
            if (w()) {
                throw x(null);
            }
        }

        @Override // b4.c
        protected IOException x(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    public j(int i4, g gVar, boolean z4, boolean z5, u uVar) {
        e3.f.e(gVar, "connection");
        this.f6158a = i4;
        this.f6159b = gVar;
        this.f6160c = new u3.a(i4);
        this.f6162e = gVar.i0().c();
        ArrayDeque<u> arrayDeque = new ArrayDeque<>();
        this.f6163f = arrayDeque;
        this.f6165h = new c(gVar.h0().c(), z5);
        this.f6166i = new b(z4);
        this.f6167j = new d();
        this.f6168k = new d();
        if (uVar == null) {
            if (!u()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!u())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(uVar);
        }
    }

    private final boolean f(t3.b bVar, IOException iOException) {
        if (s.f5213e && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.f6169l != null) {
                return false;
            }
            this.f6169l = bVar;
            this.f6170m = iOException;
            e3.f.c(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            if (this.f6165h.I() && this.f6166i.J()) {
                return false;
            }
            u2.l lVar = u2.l.f6223a;
            this.f6159b.v0(this.f6158a);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h() {
        return !this.f6159b.b0() || this.f6166i.I() || this.f6166i.J();
    }

    public final void A(long j4) {
        this.f6161d = j4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
    
        r2.f6167j.v();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized l3.u B(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
        L1:
            java.util.ArrayDeque<l3.u> r0 = r2.f6163f     // Catch: java.lang.Throwable -> L5b
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L5b
            r1 = 1
            if (r0 == 0) goto L33
            t3.b r0 = r2.f6169l     // Catch: java.lang.Throwable -> L5b
            if (r0 != 0) goto L33
            if (r3 != 0) goto L18
            boolean r0 = r2.h()     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L17
            goto L18
        L17:
            r1 = 0
        L18:
            if (r1 == 0) goto L1f
            t3.j$d r0 = r2.f6167j     // Catch: java.lang.Throwable -> L5b
            r0.v()     // Catch: java.lang.Throwable -> L5b
        L1f:
            r2.D()     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L1
            t3.j$d r0 = r2.f6167j     // Catch: java.lang.Throwable -> L5b
            r0.C()     // Catch: java.lang.Throwable -> L5b
            goto L1
        L2a:
            r3 = move-exception
            if (r1 == 0) goto L32
            t3.j$d r0 = r2.f6167j     // Catch: java.lang.Throwable -> L5b
            r0.C()     // Catch: java.lang.Throwable -> L5b
        L32:
            throw r3     // Catch: java.lang.Throwable -> L5b
        L33:
            java.util.ArrayDeque<l3.u> r3 = r2.f6163f     // Catch: java.lang.Throwable -> L5b
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L5b
            r3 = r3 ^ r1
            if (r3 == 0) goto L4b
            java.util.ArrayDeque<l3.u> r3 = r2.f6163f     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r3 = r3.removeFirst()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r0 = "removeFirst(...)"
            e3.f.d(r3, r0)     // Catch: java.lang.Throwable -> L5b
            l3.u r3 = (l3.u) r3     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r2)
            return r3
        L4b:
            java.io.IOException r3 = r2.f6170m     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L50
            goto L5a
        L50:
            t3.o r3 = new t3.o     // Catch: java.lang.Throwable -> L5b
            t3.b r0 = r2.f6169l     // Catch: java.lang.Throwable -> L5b
            e3.f.b(r0)     // Catch: java.lang.Throwable -> L5b
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L5b
        L5a:
            throw r3     // Catch: java.lang.Throwable -> L5b
        L5b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.j.B(boolean):l3.u");
    }

    public final synchronized u C() {
        u L;
        if (!this.f6165h.I() || !this.f6165h.K().z() || !this.f6165h.J().z()) {
            if (this.f6169l == null) {
                throw new IllegalStateException("too early; can't read the trailers yet");
            }
            IOException iOException = this.f6170m;
            if (iOException != null) {
                throw iOException;
            }
            t3.b bVar = this.f6169l;
            e3.f.b(bVar);
            throw new o(bVar);
        }
        L = this.f6165h.L();
        if (L == null) {
            L = s.f5209a;
        }
        return L;
    }

    public final void D() {
        try {
            e3.f.c(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final h0 E() {
        return this.f6168k;
    }

    public final void b(long j4) {
        this.f6162e += j4;
        if (j4 > 0) {
            e3.f.c(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void c() {
        boolean z4;
        boolean v4;
        if (s.f5213e && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z4 = !this.f6165h.I() && this.f6165h.i() && (this.f6166i.J() || this.f6166i.I());
            v4 = v();
            u2.l lVar = u2.l.f6223a;
        }
        if (z4) {
            e(t3.b.f6016l, null);
        } else {
            if (v4) {
                return;
            }
            this.f6159b.v0(this.f6158a);
        }
    }

    public final void d() {
        if (this.f6166i.I()) {
            throw new IOException("stream closed");
        }
        if (this.f6166i.J()) {
            throw new IOException("stream finished");
        }
        if (this.f6169l != null) {
            IOException iOException = this.f6170m;
            if (iOException != null) {
                throw iOException;
            }
            t3.b bVar = this.f6169l;
            e3.f.b(bVar);
            throw new o(bVar);
        }
    }

    public final void e(t3.b bVar, IOException iOException) {
        e3.f.e(bVar, "rstStatusCode");
        if (f(bVar, iOException)) {
            this.f6159b.G0(this.f6158a, bVar);
        }
    }

    public final void g(t3.b bVar) {
        e3.f.e(bVar, "errorCode");
        if (f(bVar, null)) {
            this.f6159b.H0(this.f6158a, bVar);
        }
    }

    public final g i() {
        return this.f6159b;
    }

    public final synchronized t3.b j() {
        return this.f6169l;
    }

    public final IOException k() {
        return this.f6170m;
    }

    public final int l() {
        return this.f6158a;
    }

    public final u3.a m() {
        return this.f6160c;
    }

    public final d n() {
        return this.f6167j;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0011, B:15:0x0017, B:16:0x0022), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0017 A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0011, B:15:0x0017, B:16:0x0022), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b4.e0 o() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f6164g     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto Le
            boolean r0 = r2.u()     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto Lc
            goto Le
        Lc:
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            if (r0 == 0) goto L17
            u2.l r0 = u2.l.f6223a     // Catch: java.lang.Throwable -> L23
            monitor-exit(r2)
            t3.j$b r0 = r2.f6166i
            return r0
        L17:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L23
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L23
            throw r1     // Catch: java.lang.Throwable -> L23
        L23:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.j.o():b4.e0");
    }

    public final b p() {
        return this.f6166i;
    }

    public final c q() {
        return this.f6165h;
    }

    public final long r() {
        return this.f6162e;
    }

    public final long s() {
        return this.f6161d;
    }

    public final d t() {
        return this.f6168k;
    }

    public final boolean u() {
        return this.f6159b.b0() == ((this.f6158a & 1) == 1);
    }

    public final synchronized boolean v() {
        if (this.f6169l != null) {
            return false;
        }
        if ((this.f6165h.I() || this.f6165h.i()) && (this.f6166i.J() || this.f6166i.I())) {
            if (this.f6164g) {
                return false;
            }
        }
        return true;
    }

    public final h0 w() {
        return this.f6167j;
    }

    public final void x(b4.f fVar, int i4) {
        e3.f.e(fVar, "source");
        if (!s.f5213e || !Thread.holdsLock(this)) {
            this.f6165h.M(fVar, i4);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d A[Catch: all -> 0x007b, TryCatch #0 {, blocks: (B:10:0x0038, B:12:0x003d, B:14:0x0045, B:17:0x004e, B:19:0x005d, B:20:0x0062, B:27:0x0054), top: B:9:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(l3.u r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            e3.f.e(r3, r0)
            boolean r0 = m3.s.f5213e
            if (r0 == 0) goto L37
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L10
            goto L37
        L10:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Thread "
            r4.append(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L37:
            monitor-enter(r2)
            boolean r0 = r2.f6164g     // Catch: java.lang.Throwable -> L7b
            r1 = 1
            if (r0 == 0) goto L54
            java.lang.String r0 = ":status"
            java.lang.String r0 = r3.a(r0)     // Catch: java.lang.Throwable -> L7b
            if (r0 != 0) goto L54
            java.lang.String r0 = ":method"
            java.lang.String r0 = r3.a(r0)     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L4e
            goto L54
        L4e:
            t3.j$c r0 = r2.f6165h     // Catch: java.lang.Throwable -> L7b
            r0.O(r3)     // Catch: java.lang.Throwable -> L7b
            goto L5b
        L54:
            r2.f6164g = r1     // Catch: java.lang.Throwable -> L7b
            java.util.ArrayDeque<l3.u> r0 = r2.f6163f     // Catch: java.lang.Throwable -> L7b
            r0.add(r3)     // Catch: java.lang.Throwable -> L7b
        L5b:
            if (r4 == 0) goto L62
            t3.j$c r3 = r2.f6165h     // Catch: java.lang.Throwable -> L7b
            r3.N(r1)     // Catch: java.lang.Throwable -> L7b
        L62:
            boolean r3 = r2.v()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.Object"
            e3.f.c(r2, r4)     // Catch: java.lang.Throwable -> L7b
            r2.notifyAll()     // Catch: java.lang.Throwable -> L7b
            u2.l r4 = u2.l.f6223a     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r2)
            if (r3 != 0) goto L7a
            t3.g r3 = r2.f6159b
            int r4 = r2.f6158a
            r3.v0(r4)
        L7a:
            return
        L7b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.j.y(l3.u, boolean):void");
    }

    public final synchronized void z(t3.b bVar) {
        e3.f.e(bVar, "errorCode");
        if (this.f6169l == null) {
            this.f6169l = bVar;
            e3.f.c(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }
}
