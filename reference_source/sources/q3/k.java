package q3;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import l3.a0;
import l3.c0;
import l3.e0;
import l3.v;
import l3.y;
import l3.z;
import m3.s;
import q3.n;
import q3.o;

/* loaded from: classes.dex */
public final class k implements n {

    /* renamed from: a, reason: collision with root package name */
    private final y f5726a;

    /* renamed from: b, reason: collision with root package name */
    private final l3.a f5727b;

    /* renamed from: c, reason: collision with root package name */
    private final h f5728c;

    /* renamed from: d, reason: collision with root package name */
    private final r3.g f5729d;

    /* renamed from: e, reason: collision with root package name */
    private final l3.k f5730e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f5731f;

    /* renamed from: g, reason: collision with root package name */
    private o.b f5732g;

    /* renamed from: h, reason: collision with root package name */
    private o f5733h;

    /* renamed from: i, reason: collision with root package name */
    private e0 f5734i;

    /* renamed from: j, reason: collision with root package name */
    private final v2.e<n.b> f5735j;

    public k(y yVar, l3.a aVar, h hVar, r3.g gVar, l3.k kVar) {
        e3.f.e(yVar, "client");
        e3.f.e(aVar, "address");
        e3.f.e(hVar, "call");
        e3.f.e(gVar, "chain");
        e3.f.e(kVar, "connectionListener");
        this.f5726a = yVar;
        this.f5727b = aVar;
        this.f5728c = hVar;
        this.f5729d = gVar;
        this.f5730e = kVar;
        this.f5731f = !e3.f.a(gVar.j().g(), "GET");
        this.f5735j = new v2.e<>();
    }

    private final a0 h(e0 e0Var) {
        a0 b5 = new a0.a().q(e0Var.a().l()).j("CONNECT", null).h("Host", s.r(e0Var.a().l(), true)).h("Proxy-Connection", "Keep-Alive").h("User-Agent", "okhttp/5.0.0-alpha.12").b();
        a0 a5 = e0Var.a().h().a(e0Var, new c0.a().q(b5).o(z.f4873e).e(407).l("Preemptive Authenticate").r(-1L).p(-1L).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return a5 == null ? b5 : a5;
    }

    private final b i() {
        e0 e0Var = this.f5734i;
        if (e0Var != null) {
            this.f5734i = null;
            return k(this, e0Var, null, 2, null);
        }
        o.b bVar = this.f5732g;
        if (bVar != null && bVar.b()) {
            return k(this, bVar.c(), null, 2, null);
        }
        o oVar = this.f5733h;
        if (oVar == null) {
            oVar = new o(e(), this.f5728c.l().q(), this.f5728c, this.f5726a.n(), this.f5728c.n());
            this.f5733h = oVar;
        }
        if (!oVar.a()) {
            throw new IOException("exhausted all routes");
        }
        o.b c5 = oVar.c();
        this.f5732g = c5;
        if (this.f5728c.u()) {
            throw new IOException("Canceled");
        }
        return j(c5.c(), c5.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b k(k kVar, e0 e0Var, List list, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            list = null;
        }
        return kVar.j(e0Var, list);
    }

    private final l l() {
        Socket y4;
        boolean z4;
        i m4 = this.f5728c.m();
        if (m4 == null) {
            return null;
        }
        boolean p4 = m4.p(this.f5731f);
        synchronized (m4) {
            if (p4) {
                if (!m4.k() && c(m4.t().a().l())) {
                    y4 = null;
                    z4 = false;
                }
                y4 = this.f5728c.y();
                z4 = false;
            } else {
                z4 = !m4.k();
                m4.w(true);
                y4 = this.f5728c.y();
            }
        }
        if (this.f5728c.m() != null) {
            if (y4 == null) {
                return new l(m4);
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        if (y4 != null) {
            s.f(y4);
        }
        this.f5728c.n().k(this.f5728c, m4);
        m4.i().g(m4, this.f5728c);
        if (y4 != null) {
            m4.i().f(m4);
        } else if (z4) {
            m4.i().h(m4);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ l n(k kVar, b bVar, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            bVar = null;
        }
        if ((i4 & 2) != 0) {
            list = null;
        }
        return kVar.m(bVar, list);
    }

    private final e0 o(i iVar) {
        e0 e0Var;
        synchronized (iVar) {
            e0Var = null;
            if (iVar.l() == 0 && iVar.k() && s.e(iVar.t().a().l(), e().l())) {
                e0Var = iVar.t();
            }
        }
        return e0Var;
    }

    @Override // q3.n
    public v2.e<n.b> a() {
        return this.f5735j;
    }

    @Override // q3.n
    public n.b b() {
        l l4 = l();
        if (l4 != null) {
            return l4;
        }
        l n4 = n(this, null, null, 3, null);
        if (n4 != null) {
            return n4;
        }
        if (!a().isEmpty()) {
            return a().l();
        }
        b i4 = i();
        l m4 = m(i4, i4.p());
        return m4 != null ? m4 : i4;
    }

    @Override // q3.n
    public boolean c(v vVar) {
        e3.f.e(vVar, "url");
        v l4 = e().l();
        return vVar.o() == l4.o() && e3.f.a(vVar.j(), l4.j());
    }

    @Override // q3.n
    public l3.a e() {
        return this.f5727b;
    }

    @Override // q3.n
    public boolean f(i iVar) {
        o oVar;
        e0 o4;
        if ((!a().isEmpty()) || this.f5734i != null) {
            return true;
        }
        if (iVar != null && (o4 = o(iVar)) != null) {
            this.f5734i = o4;
            return true;
        }
        o.b bVar = this.f5732g;
        boolean z4 = false;
        if (bVar != null && bVar.b()) {
            z4 = true;
        }
        if (z4 || (oVar = this.f5733h) == null) {
            return true;
        }
        return oVar.a();
    }

    @Override // q3.n
    public boolean g() {
        return this.f5728c.u();
    }

    public final b j(e0 e0Var, List<e0> list) {
        e3.f.e(e0Var, "route");
        if (e0Var.a().k() == null) {
            if (!e0Var.a().b().contains(l3.m.f4746k)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String j4 = e0Var.a().l().j();
            if (!w3.h.f6456a.g().i(j4)) {
                throw new UnknownServiceException("CLEARTEXT communication to " + j4 + " not permitted by network security policy");
            }
        } else if (e0Var.a().f().contains(z.f4876h)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        return new b(this.f5726a, this.f5728c, this.f5729d, this, e0Var, list, 0, e0Var.c() ? h(e0Var) : null, -1, false, this.f5730e);
    }

    public final l m(b bVar, List<e0> list) {
        i a5 = this.f5726a.h().b().a(this.f5731f, e(), this.f5728c, list, bVar != null && bVar.b());
        if (a5 == null) {
            return null;
        }
        if (bVar != null) {
            this.f5734i = bVar.c();
            bVar.i();
        }
        this.f5728c.n().j(this.f5728c, a5);
        a5.i().e(a5, this.f5728c);
        return new l(a5);
    }
}
