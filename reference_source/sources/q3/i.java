package q3;

import b4.h0;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import l3.e0;
import l3.t;
import l3.v;
import l3.y;
import l3.z;
import m3.s;
import r3.d;
import t3.c;
import t3.g;

/* loaded from: classes.dex */
public final class i extends g.d implements l3.j, d.a {

    /* renamed from: w, reason: collision with root package name */
    public static final a f5697w = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private final p3.d f5698c;

    /* renamed from: d, reason: collision with root package name */
    private final j f5699d;

    /* renamed from: e, reason: collision with root package name */
    private final e0 f5700e;

    /* renamed from: f, reason: collision with root package name */
    private Socket f5701f;

    /* renamed from: g, reason: collision with root package name */
    private Socket f5702g;

    /* renamed from: h, reason: collision with root package name */
    private t f5703h;

    /* renamed from: i, reason: collision with root package name */
    private z f5704i;

    /* renamed from: j, reason: collision with root package name */
    private b4.f f5705j;

    /* renamed from: k, reason: collision with root package name */
    private b4.e f5706k;

    /* renamed from: l, reason: collision with root package name */
    private final int f5707l;

    /* renamed from: m, reason: collision with root package name */
    private final l3.k f5708m;

    /* renamed from: n, reason: collision with root package name */
    private t3.g f5709n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5710o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5711p;

    /* renamed from: q, reason: collision with root package name */
    private int f5712q;

    /* renamed from: r, reason: collision with root package name */
    private int f5713r;

    /* renamed from: s, reason: collision with root package name */
    private int f5714s;

    /* renamed from: t, reason: collision with root package name */
    private int f5715t;

    /* renamed from: u, reason: collision with root package name */
    private final List<Reference<h>> f5716u;

    /* renamed from: v, reason: collision with root package name */
    private long f5717v;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    public i(p3.d dVar, j jVar, e0 e0Var, Socket socket, Socket socket2, t tVar, z zVar, b4.f fVar, b4.e eVar, int i4, l3.k kVar) {
        e3.f.e(dVar, "taskRunner");
        e3.f.e(jVar, "connectionPool");
        e3.f.e(e0Var, "route");
        e3.f.e(kVar, "connectionListener");
        this.f5698c = dVar;
        this.f5699d = jVar;
        this.f5700e = e0Var;
        this.f5701f = socket;
        this.f5702g = socket2;
        this.f5703h = tVar;
        this.f5704i = zVar;
        this.f5705j = fVar;
        this.f5706k = eVar;
        this.f5707l = i4;
        this.f5708m = kVar;
        this.f5715t = 1;
        this.f5716u = new ArrayList();
        this.f5717v = Long.MAX_VALUE;
    }

    private final boolean A(v vVar) {
        t tVar;
        if (s.f5213e && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        v l4 = c().a().l();
        if (vVar.o() != l4.o()) {
            return false;
        }
        if (e3.f.a(vVar.j(), l4.j())) {
            return true;
        }
        if (this.f5711p || (tVar = this.f5703h) == null) {
            return false;
        }
        e3.f.b(tVar);
        return d(vVar, tVar);
    }

    private final boolean d(v vVar, t tVar) {
        List<Certificate> d5 = tVar.d();
        if (!d5.isEmpty()) {
            a4.d dVar = a4.d.f310a;
            String j4 = vVar.j();
            Certificate certificate = d5.get(0);
            e3.f.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (dVar.e(j4, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    private final boolean u(List<e0> list) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (e0 e0Var : list) {
                if (e0Var.b().type() == Proxy.Type.DIRECT && c().b().type() == Proxy.Type.DIRECT && e3.f.a(c().d(), e0Var.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void z() {
        Socket socket = this.f5702g;
        e3.f.b(socket);
        b4.f fVar = this.f5705j;
        e3.f.b(fVar);
        b4.e eVar = this.f5706k;
        e3.f.b(eVar);
        socket.setSoTimeout(0);
        Object obj = this.f5708m;
        t3.c cVar = obj instanceof t3.c ? (t3.c) obj : null;
        if (cVar == null) {
            cVar = c.a.f6025a;
        }
        t3.g a5 = new g.b(true, this.f5698c).s(socket, c().a().l().j(), fVar, eVar).m(this).n(this.f5707l).b(cVar).a();
        this.f5709n = a5;
        this.f5715t = t3.g.D.a().d();
        t3.g.B0(a5, false, 1, null);
    }

    @Override // t3.g.d
    public synchronized void a(t3.g gVar, t3.n nVar) {
        e3.f.e(gVar, "connection");
        e3.f.e(nVar, "settings");
        this.f5715t = nVar.d();
    }

    @Override // t3.g.d
    public void b(t3.j jVar) {
        e3.f.e(jVar, "stream");
        jVar.e(t3.b.f6015k, null);
    }

    @Override // r3.d.a
    public e0 c() {
        return this.f5700e;
    }

    @Override // r3.d.a
    public void cancel() {
        Socket socket = this.f5701f;
        if (socket != null) {
            s.f(socket);
        }
    }

    public final void e(y yVar, e0 e0Var, IOException iOException) {
        e3.f.e(yVar, "client");
        e3.f.e(e0Var, "failedRoute");
        e3.f.e(iOException, "failure");
        if (e0Var.b().type() != Proxy.Type.DIRECT) {
            l3.a a5 = e0Var.a();
            a5.i().connectFailed(a5.l().t(), e0Var.b().address(), iOException);
        }
        yVar.q().b(e0Var);
    }

    public final List<Reference<h>> f() {
        return this.f5716u;
    }

    @Override // r3.d.a
    public void g(h hVar, IOException iOException) {
        boolean z4;
        int i4;
        e3.f.e(hVar, "call");
        synchronized (this) {
            if (!(iOException instanceof t3.o)) {
                if (!q() || (iOException instanceof t3.a)) {
                    z4 = this.f5710o ? false : true;
                    this.f5710o = true;
                    if (this.f5713r == 0) {
                        if (iOException != null) {
                            e(hVar.l(), c(), iOException);
                        }
                        i4 = this.f5712q;
                        this.f5712q = i4 + 1;
                    }
                }
                u2.l lVar = u2.l.f6223a;
            } else if (((t3.o) iOException).f6205b == t3.b.f6015k) {
                int i5 = this.f5714s + 1;
                this.f5714s = i5;
                if (i5 > 1) {
                    z4 = this.f5710o ? false : true;
                    this.f5710o = true;
                    i4 = this.f5712q;
                    this.f5712q = i4 + 1;
                }
                u2.l lVar2 = u2.l.f6223a;
            } else {
                if (((t3.o) iOException).f6205b != t3.b.f6016l || !hVar.u()) {
                    z4 = this.f5710o ? false : true;
                    this.f5710o = true;
                    i4 = this.f5712q;
                    this.f5712q = i4 + 1;
                }
                u2.l lVar22 = u2.l.f6223a;
            }
        }
        if (z4) {
            this.f5708m.h(this);
        }
    }

    @Override // r3.d.a
    public void h() {
        synchronized (this) {
            this.f5710o = true;
            u2.l lVar = u2.l.f6223a;
        }
        this.f5708m.h(this);
    }

    public final l3.k i() {
        return this.f5708m;
    }

    public final long j() {
        return this.f5717v;
    }

    public final boolean k() {
        return this.f5710o;
    }

    public final int l() {
        return this.f5712q;
    }

    public t m() {
        return this.f5703h;
    }

    public final synchronized void n() {
        this.f5713r++;
    }

    public final boolean o(l3.a aVar, List<e0> list) {
        e3.f.e(aVar, "address");
        if (s.f5213e && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.f5716u.size() >= this.f5715t || this.f5710o || !c().a().d(aVar)) {
            return false;
        }
        if (e3.f.a(aVar.l().j(), t().a().l().j())) {
            return true;
        }
        if (this.f5709n == null || list == null || !u(list) || aVar.e() != a4.d.f310a || !A(aVar.l())) {
            return false;
        }
        try {
            l3.g a5 = aVar.a();
            e3.f.b(a5);
            String j4 = aVar.l().j();
            t m4 = m();
            e3.f.b(m4);
            a5.a(j4, m4.d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean p(boolean z4) {
        long j4;
        if (s.f5213e && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long nanoTime = System.nanoTime();
        Socket socket = this.f5701f;
        e3.f.b(socket);
        Socket socket2 = this.f5702g;
        e3.f.b(socket2);
        b4.f fVar = this.f5705j;
        e3.f.b(fVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        t3.g gVar = this.f5709n;
        if (gVar != null) {
            return gVar.n0(nanoTime);
        }
        synchronized (this) {
            j4 = nanoTime - this.f5717v;
        }
        if (j4 < 10000000000L || !z4) {
            return true;
        }
        return s.k(socket2, fVar);
    }

    public final boolean q() {
        return this.f5709n != null;
    }

    public final r3.d r(y yVar, r3.g gVar) {
        e3.f.e(yVar, "client");
        e3.f.e(gVar, "chain");
        Socket socket = this.f5702g;
        e3.f.b(socket);
        b4.f fVar = this.f5705j;
        e3.f.b(fVar);
        b4.e eVar = this.f5706k;
        e3.f.b(eVar);
        t3.g gVar2 = this.f5709n;
        if (gVar2 != null) {
            return new t3.h(yVar, this, gVar, gVar2);
        }
        socket.setSoTimeout(gVar.d());
        h0 b5 = fVar.b();
        long i4 = gVar.i();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        b5.g(i4, timeUnit);
        eVar.b().g(gVar.k(), timeUnit);
        return new s3.b(yVar, this, fVar, eVar);
    }

    public final synchronized void s() {
        this.f5711p = true;
    }

    public e0 t() {
        return c();
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(c().a().l().j());
        sb.append(':');
        sb.append(c().a().l().o());
        sb.append(", proxy=");
        sb.append(c().b());
        sb.append(" hostAddress=");
        sb.append(c().d());
        sb.append(" cipherSuite=");
        t tVar = this.f5703h;
        if (tVar == null || (obj = tVar.a()) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f5704i);
        sb.append('}');
        return sb.toString();
    }

    public final void v(long j4) {
        this.f5717v = j4;
    }

    public final void w(boolean z4) {
        this.f5710o = z4;
    }

    public Socket x() {
        Socket socket = this.f5702g;
        e3.f.b(socket);
        return socket;
    }

    public final void y() {
        this.f5717v = System.nanoTime();
        z zVar = this.f5704i;
        if (zVar == z.f4875g || zVar == z.f4876h) {
            z();
        }
    }
}
