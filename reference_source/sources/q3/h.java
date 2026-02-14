package q3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import l3.a0;
import l3.s;
import l3.v;
import l3.y;
import q3.n;

/* loaded from: classes.dex */
public final class h implements l3.e, Cloneable {

    /* renamed from: b, reason: collision with root package name */
    private final y f5674b;

    /* renamed from: c, reason: collision with root package name */
    private final a0 f5675c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f5676d;

    /* renamed from: e, reason: collision with root package name */
    private final j f5677e;

    /* renamed from: f, reason: collision with root package name */
    private final s f5678f;

    /* renamed from: g, reason: collision with root package name */
    private final c f5679g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f5680h;

    /* renamed from: i, reason: collision with root package name */
    private Object f5681i;

    /* renamed from: j, reason: collision with root package name */
    private d f5682j;

    /* renamed from: k, reason: collision with root package name */
    private i f5683k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5684l;

    /* renamed from: m, reason: collision with root package name */
    private q3.c f5685m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5686n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5687o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5688p;

    /* renamed from: q, reason: collision with root package name */
    private volatile boolean f5689q;

    /* renamed from: r, reason: collision with root package name */
    private volatile q3.c f5690r;

    /* renamed from: s, reason: collision with root package name */
    private final CopyOnWriteArrayList<n.b> f5691s;

    /* loaded from: classes.dex */
    public final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final l3.f f5692b;

        /* renamed from: c, reason: collision with root package name */
        private volatile AtomicInteger f5693c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f5694d;

        public a(h hVar, l3.f fVar) {
            e3.f.e(fVar, "responseCallback");
            this.f5694d = hVar;
            this.f5692b = fVar;
            this.f5693c = new AtomicInteger(0);
        }

        public static /* synthetic */ void c(a aVar, RejectedExecutionException rejectedExecutionException, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                rejectedExecutionException = null;
            }
            aVar.b(rejectedExecutionException);
        }

        public final void a(ExecutorService executorService) {
            e3.f.e(executorService, "executorService");
            l3.q k4 = this.f5694d.l().k();
            if (m3.s.f5213e && Thread.holdsLock(k4)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + k4);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e4) {
                    b(e4);
                    this.f5694d.l().k().e(this);
                }
            } catch (Throwable th) {
                this.f5694d.l().k().e(this);
                throw th;
            }
        }

        public final void b(RejectedExecutionException rejectedExecutionException) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
            interruptedIOException.initCause(rejectedExecutionException);
            this.f5694d.w(interruptedIOException);
            this.f5692b.b(this.f5694d, interruptedIOException);
        }

        public final h d() {
            return this.f5694d;
        }

        public final AtomicInteger e() {
            return this.f5693c;
        }

        public final String f() {
            return this.f5694d.q().i().j();
        }

        public final void g(a aVar) {
            e3.f.e(aVar, "other");
            this.f5693c = aVar.f5693c;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z4;
            Throwable th;
            IOException e4;
            l3.q k4;
            String str = "OkHttp " + this.f5694d.x();
            h hVar = this.f5694d;
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName(str);
            try {
                try {
                    hVar.f5679g.v();
                    try {
                        z4 = true;
                        try {
                            this.f5692b.a(hVar, hVar.s());
                            k4 = hVar.l().k();
                        } catch (IOException e5) {
                            e4 = e5;
                            if (z4) {
                                w3.h.f6456a.g().j("Callback failure for " + hVar.C(), 4, e4);
                            } else {
                                this.f5692b.b(hVar, e4);
                            }
                            k4 = hVar.l().k();
                            k4.e(this);
                        } catch (Throwable th2) {
                            th = th2;
                            hVar.f();
                            if (!z4) {
                                IOException iOException = new IOException("canceled due to " + th);
                                u2.b.a(iOException, th);
                                this.f5692b.b(hVar, iOException);
                            }
                            throw th;
                        }
                    } catch (IOException e6) {
                        z4 = false;
                        e4 = e6;
                    } catch (Throwable th3) {
                        z4 = false;
                        th = th3;
                    }
                    k4.e(this);
                } catch (Throwable th4) {
                    hVar.l().k().e(this);
                    throw th4;
                }
            } finally {
                currentThread.setName(name);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends WeakReference<h> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f5695a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, Object obj) {
            super(hVar);
            e3.f.e(hVar, "referent");
            this.f5695a = obj;
        }

        public final Object a() {
            return this.f5695a;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends b4.c {
        c() {
        }

        @Override // b4.c
        protected void B() {
            h.this.f();
        }
    }

    public h(y yVar, a0 a0Var, boolean z4) {
        e3.f.e(yVar, "client");
        e3.f.e(a0Var, "originalRequest");
        this.f5674b = yVar;
        this.f5675c = a0Var;
        this.f5676d = z4;
        this.f5677e = yVar.h().b();
        this.f5678f = yVar.m().a(this);
        c cVar = new c();
        cVar.g(yVar.e(), TimeUnit.MILLISECONDS);
        this.f5679g = cVar;
        this.f5680h = new AtomicBoolean();
        this.f5688p = true;
        this.f5691s = new CopyOnWriteArrayList<>();
    }

    private final <E extends IOException> E B(E e4) {
        if (this.f5684l || !this.f5679g.w()) {
            return e4;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (e4 != null) {
            interruptedIOException.initCause(e4);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String C() {
        StringBuilder sb = new StringBuilder();
        sb.append(u() ? "canceled " : "");
        sb.append(this.f5676d ? "web socket" : "call");
        sb.append(" to ");
        sb.append(x());
        return sb.toString();
    }

    private final <E extends IOException> E d(E e4) {
        Socket y4;
        boolean z4 = m3.s.f5213e;
        if (z4 && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        i iVar = this.f5683k;
        if (iVar != null) {
            if (z4 && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            synchronized (iVar) {
                y4 = y();
            }
            if (this.f5683k == null) {
                if (y4 != null) {
                    m3.s.f(y4);
                }
                this.f5678f.k(this, iVar);
                iVar.i().g(iVar, this);
                if (y4 != null) {
                    iVar.i().f(iVar);
                }
            } else {
                if (!(y4 == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        E e5 = (E) B(e4);
        if (e4 != null) {
            s sVar = this.f5678f;
            e3.f.b(e5);
            sVar.d(this, e5);
        } else {
            this.f5678f.c(this);
        }
        return e5;
    }

    private final void e() {
        this.f5681i = w3.h.f6456a.g().h("response.body().close()");
        this.f5678f.e(this);
    }

    private final l3.a h(v vVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        l3.g gVar;
        if (vVar.k()) {
            SSLSocketFactory E = this.f5674b.E();
            hostnameVerifier = this.f5674b.s();
            sSLSocketFactory = E;
            gVar = this.f5674b.f();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new l3.a(vVar.j(), vVar.o(), this.f5674b.l(), this.f5674b.D(), sSLSocketFactory, hostnameVerifier, gVar, this.f5674b.z(), this.f5674b.y(), this.f5674b.x(), this.f5674b.i(), this.f5674b.A());
    }

    public final void A() {
        if (!(!this.f5684l)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f5684l = true;
        this.f5679g.w();
    }

    public final void c(i iVar) {
        e3.f.e(iVar, "connection");
        if (!m3.s.f5213e || Thread.holdsLock(iVar)) {
            if (!(this.f5683k == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.f5683k = iVar;
            iVar.f().add(new b(this, this.f5681i));
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + iVar);
    }

    public void f() {
        if (this.f5689q) {
            return;
        }
        this.f5689q = true;
        q3.c cVar = this.f5690r;
        if (cVar != null) {
            cVar.b();
        }
        Iterator<n.b> it = this.f5691s.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.f5678f.f(this);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public l3.e clone() {
        return new h(this.f5674b, this.f5675c, this.f5676d);
    }

    @Override // l3.e
    public void i(l3.f fVar) {
        e3.f.e(fVar, "responseCallback");
        if (!this.f5680h.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        e();
        this.f5674b.k().a(new a(this, fVar));
    }

    public final void j(a0 a0Var, boolean z4, r3.g gVar) {
        e3.f.e(a0Var, "request");
        e3.f.e(gVar, "chain");
        if (!(this.f5685m == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.f5687o)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.f5686n)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            u2.l lVar = u2.l.f6223a;
        }
        if (z4) {
            k kVar = new k(this.f5674b, h(a0Var.i()), this, gVar, this.f5677e.d());
            this.f5682j = this.f5674b.n() ? new f(kVar, this.f5674b.r()) : new p(kVar);
        }
    }

    public final void k(boolean z4) {
        q3.c cVar;
        synchronized (this) {
            if (!this.f5688p) {
                throw new IllegalStateException("released".toString());
            }
            u2.l lVar = u2.l.f6223a;
        }
        if (z4 && (cVar = this.f5690r) != null) {
            cVar.d();
        }
        this.f5685m = null;
    }

    public final y l() {
        return this.f5674b;
    }

    public final i m() {
        return this.f5683k;
    }

    public final s n() {
        return this.f5678f;
    }

    public final boolean o() {
        return this.f5676d;
    }

    public final q3.c p() {
        return this.f5685m;
    }

    public final a0 q() {
        return this.f5675c;
    }

    public final CopyOnWriteArrayList<n.b> r() {
        return this.f5691s;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final l3.c0 s() {
        /*
            r12 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            l3.y r0 = r12.f5674b
            java.util.List r0 = r0.t()
            v2.m.u(r2, r0)
            r3.j r0 = new r3.j
            l3.y r1 = r12.f5674b
            r0.<init>(r1)
            r2.add(r0)
            r3.a r0 = new r3.a
            l3.y r1 = r12.f5674b
            l3.o r1 = r1.j()
            r0.<init>(r1)
            r2.add(r0)
            o3.a r0 = new o3.a
            l3.y r1 = r12.f5674b
            r1.d()
            r9 = 0
            r0.<init>(r9)
            r2.add(r0)
            q3.a r0 = q3.a.f5620a
            r2.add(r0)
            boolean r0 = r12.f5676d
            if (r0 != 0) goto L46
            l3.y r0 = r12.f5674b
            java.util.List r0 = r0.u()
            v2.m.u(r2, r0)
        L46:
            r3.b r0 = new r3.b
            boolean r1 = r12.f5676d
            r0.<init>(r1)
            r2.add(r0)
            r3.g r10 = new r3.g
            r3 = 0
            r4 = 0
            l3.a0 r5 = r12.f5675c
            l3.y r0 = r12.f5674b
            int r6 = r0.g()
            l3.y r0 = r12.f5674b
            int r7 = r0.B()
            l3.y r0 = r12.f5674b
            int r8 = r0.G()
            r0 = r10
            r1 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            l3.a0 r1 = r12.f5675c     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            l3.c0 r1 = r10.a(r1)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            boolean r2 = r12.u()     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            if (r2 != 0) goto L7e
            r12.w(r9)
            return r1
        L7e:
            m3.p.f(r1)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            java.lang.String r2 = "Canceled"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            throw r1     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
        L89:
            r1 = move-exception
            goto L9b
        L8b:
            r0 = move-exception
            r1 = 1
            java.io.IOException r0 = r12.w(r0)     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Throwable"
            e3.f.c(r0, r2)     // Catch: java.lang.Throwable -> L97
            throw r0     // Catch: java.lang.Throwable -> L97
        L97:
            r0 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
        L9b:
            if (r0 != 0) goto La0
            r12.w(r9)
        La0:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.h.s():l3.c0");
    }

    public final q3.c t(r3.g gVar) {
        e3.f.e(gVar, "chain");
        synchronized (this) {
            if (!this.f5688p) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.f5687o)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.f5686n)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            u2.l lVar = u2.l.f6223a;
        }
        d dVar = this.f5682j;
        e3.f.b(dVar);
        q3.c cVar = new q3.c(this, this.f5678f, dVar, dVar.a().r(this.f5674b, gVar));
        this.f5685m = cVar;
        this.f5690r = cVar;
        synchronized (this) {
            this.f5686n = true;
            this.f5687o = true;
        }
        if (this.f5689q) {
            throw new IOException("Canceled");
        }
        return cVar;
    }

    public boolean u() {
        return this.f5689q;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:44:0x0012, B:12:0x0021, B:14:0x0025, B:15:0x0027, B:17:0x002c, B:21:0x0035, B:23:0x0039, B:27:0x0042, B:9:0x001b), top: B:43:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0025 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:44:0x0012, B:12:0x0021, B:14:0x0025, B:15:0x0027, B:17:0x002c, B:21:0x0035, B:23:0x0039, B:27:0x0042, B:9:0x001b), top: B:43:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <E extends java.io.IOException> E v(q3.c r2, boolean r3, boolean r4, E r5) {
        /*
            r1 = this;
            java.lang.String r0 = "exchange"
            e3.f.e(r2, r0)
            q3.c r0 = r1.f5690r
            boolean r2 = e3.f.a(r2, r0)
            if (r2 != 0) goto Le
            return r5
        Le:
            monitor-enter(r1)
            r2 = 0
            if (r3 == 0) goto L19
            boolean r0 = r1.f5686n     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L1f
            goto L19
        L17:
            r2 = move-exception
            goto L59
        L19:
            if (r4 == 0) goto L41
            boolean r0 = r1.f5687o     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L41
        L1f:
            if (r3 == 0) goto L23
            r1.f5686n = r2     // Catch: java.lang.Throwable -> L17
        L23:
            if (r4 == 0) goto L27
            r1.f5687o = r2     // Catch: java.lang.Throwable -> L17
        L27:
            boolean r3 = r1.f5686n     // Catch: java.lang.Throwable -> L17
            r4 = 1
            if (r3 != 0) goto L32
            boolean r0 = r1.f5687o     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L32
            r0 = r4
            goto L33
        L32:
            r0 = r2
        L33:
            if (r3 != 0) goto L3e
            boolean r3 = r1.f5687o     // Catch: java.lang.Throwable -> L17
            if (r3 != 0) goto L3e
            boolean r3 = r1.f5688p     // Catch: java.lang.Throwable -> L17
            if (r3 != 0) goto L3e
            r2 = r4
        L3e:
            r3 = r2
            r2 = r0
            goto L42
        L41:
            r3 = r2
        L42:
            u2.l r4 = u2.l.f6223a     // Catch: java.lang.Throwable -> L17
            monitor-exit(r1)
            if (r2 == 0) goto L51
            r2 = 0
            r1.f5690r = r2
            q3.i r2 = r1.f5683k
            if (r2 == 0) goto L51
            r2.n()
        L51:
            if (r3 == 0) goto L58
            java.io.IOException r2 = r1.d(r5)
            return r2
        L58:
            return r5
        L59:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.h.v(q3.c, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException w(IOException iOException) {
        boolean z4;
        synchronized (this) {
            z4 = false;
            if (this.f5688p) {
                this.f5688p = false;
                if (!this.f5686n && !this.f5687o) {
                    z4 = true;
                }
            }
            u2.l lVar = u2.l.f6223a;
        }
        return z4 ? d(iOException) : iOException;
    }

    public final String x() {
        return this.f5675c.i().q();
    }

    public final Socket y() {
        i iVar = this.f5683k;
        e3.f.b(iVar);
        if (m3.s.f5213e && !Thread.holdsLock(iVar)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + iVar);
        }
        List<Reference<h>> f4 = iVar.f();
        Iterator<Reference<h>> it = f4.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            if (e3.f.a(it.next().get(), this)) {
                break;
            }
            i4++;
        }
        if (!(i4 != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        f4.remove(i4);
        this.f5683k = null;
        if (f4.isEmpty()) {
            iVar.v(System.nanoTime());
            if (this.f5677e.c(iVar)) {
                return iVar.x();
            }
        }
        return null;
    }

    public final boolean z() {
        q3.c cVar = this.f5690r;
        if (cVar != null && cVar.k()) {
            d dVar = this.f5682j;
            e3.f.b(dVar);
            n b5 = dVar.b();
            q3.c cVar2 = this.f5690r;
            if (b5.f(cVar2 != null ? cVar2.h() : null)) {
                return true;
            }
        }
        return false;
    }
}
