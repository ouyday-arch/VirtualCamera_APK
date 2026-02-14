package l3;

import java.io.Closeable;
import java.util.List;
import l3.u;

/* loaded from: classes.dex */
public final class c0 implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    private final a0 f4583b;

    /* renamed from: c, reason: collision with root package name */
    private final z f4584c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4585d;

    /* renamed from: e, reason: collision with root package name */
    private final int f4586e;

    /* renamed from: f, reason: collision with root package name */
    private final t f4587f;

    /* renamed from: g, reason: collision with root package name */
    private final u f4588g;

    /* renamed from: h, reason: collision with root package name */
    private final d0 f4589h;

    /* renamed from: i, reason: collision with root package name */
    private final c0 f4590i;

    /* renamed from: j, reason: collision with root package name */
    private final c0 f4591j;

    /* renamed from: k, reason: collision with root package name */
    private final c0 f4592k;

    /* renamed from: l, reason: collision with root package name */
    private final long f4593l;

    /* renamed from: m, reason: collision with root package name */
    private final long f4594m;

    /* renamed from: n, reason: collision with root package name */
    private final q3.c f4595n;

    /* renamed from: o, reason: collision with root package name */
    private d3.a<u> f4596o;

    /* renamed from: p, reason: collision with root package name */
    private d f4597p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f4598q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f4599r;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private a0 f4600a;

        /* renamed from: b, reason: collision with root package name */
        private z f4601b;

        /* renamed from: c, reason: collision with root package name */
        private int f4602c;

        /* renamed from: d, reason: collision with root package name */
        private String f4603d;

        /* renamed from: e, reason: collision with root package name */
        private t f4604e;

        /* renamed from: f, reason: collision with root package name */
        private u.a f4605f;

        /* renamed from: g, reason: collision with root package name */
        private d0 f4606g;

        /* renamed from: h, reason: collision with root package name */
        private c0 f4607h;

        /* renamed from: i, reason: collision with root package name */
        private c0 f4608i;

        /* renamed from: j, reason: collision with root package name */
        private c0 f4609j;

        /* renamed from: k, reason: collision with root package name */
        private long f4610k;

        /* renamed from: l, reason: collision with root package name */
        private long f4611l;

        /* renamed from: m, reason: collision with root package name */
        private q3.c f4612m;

        /* renamed from: n, reason: collision with root package name */
        private d3.a<u> f4613n;

        /* renamed from: l3.c0$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0056a extends e3.g implements d3.a<u> {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ q3.c f4614c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0056a(q3.c cVar) {
                super(0);
                this.f4614c = cVar;
            }

            @Override // d3.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public final u d() {
                return this.f4614c.u();
            }
        }

        /* loaded from: classes.dex */
        static final class b extends e3.g implements d3.a<u> {

            /* renamed from: c, reason: collision with root package name */
            public static final b f4615c = new b();

            b() {
                super(0);
            }

            @Override // d3.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public final u d() {
                return u.f4793c.a(new String[0]);
            }
        }

        public a() {
            this.f4602c = -1;
            this.f4606g = m3.p.m();
            this.f4613n = b.f4615c;
            this.f4605f = new u.a();
        }

        public a(c0 c0Var) {
            e3.f.e(c0Var, "response");
            this.f4602c = -1;
            this.f4606g = m3.p.m();
            this.f4613n = b.f4615c;
            this.f4600a = c0Var.Z();
            this.f4601b = c0Var.X();
            this.f4602c = c0Var.M();
            this.f4603d = c0Var.T();
            this.f4604e = c0Var.P();
            this.f4605f = c0Var.S().d();
            this.f4606g = c0Var.I();
            this.f4607h = c0Var.U();
            this.f4608i = c0Var.K();
            this.f4609j = c0Var.W();
            this.f4610k = c0Var.a0();
            this.f4611l = c0Var.Y();
            this.f4612m = c0Var.N();
            this.f4613n = c0Var.f4596o;
        }

        public final void A(a0 a0Var) {
            this.f4600a = a0Var;
        }

        public final void B(d3.a<u> aVar) {
            e3.f.e(aVar, "<set-?>");
            this.f4613n = aVar;
        }

        public a C(d3.a<u> aVar) {
            e3.f.e(aVar, "trailersFn");
            return m3.o.q(this, aVar);
        }

        public a a(String str, String str2) {
            e3.f.e(str, "name");
            e3.f.e(str2, "value");
            return m3.o.b(this, str, str2);
        }

        public a b(d0 d0Var) {
            e3.f.e(d0Var, "body");
            return m3.o.c(this, d0Var);
        }

        public c0 c() {
            int i4 = this.f4602c;
            if (!(i4 >= 0)) {
                throw new IllegalStateException(("code < 0: " + this.f4602c).toString());
            }
            a0 a0Var = this.f4600a;
            if (a0Var == null) {
                throw new IllegalStateException("request == null".toString());
            }
            z zVar = this.f4601b;
            if (zVar == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.f4603d;
            if (str != null) {
                return new c0(a0Var, zVar, str, i4, this.f4604e, this.f4605f.d(), this.f4606g, this.f4607h, this.f4608i, this.f4609j, this.f4610k, this.f4611l, this.f4612m, this.f4613n);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public a d(c0 c0Var) {
            return m3.o.d(this, c0Var);
        }

        public a e(int i4) {
            return m3.o.f(this, i4);
        }

        public final int f() {
            return this.f4602c;
        }

        public final u.a g() {
            return this.f4605f;
        }

        public a h(t tVar) {
            this.f4604e = tVar;
            return this;
        }

        public a i(String str, String str2) {
            e3.f.e(str, "name");
            e3.f.e(str2, "value");
            return m3.o.h(this, str, str2);
        }

        public a j(u uVar) {
            e3.f.e(uVar, "headers");
            return m3.o.i(this, uVar);
        }

        public final void k(q3.c cVar) {
            e3.f.e(cVar, "exchange");
            this.f4612m = cVar;
            this.f4613n = new C0056a(cVar);
        }

        public a l(String str) {
            e3.f.e(str, "message");
            return m3.o.j(this, str);
        }

        public a m(c0 c0Var) {
            return m3.o.k(this, c0Var);
        }

        public a n(c0 c0Var) {
            return m3.o.m(this, c0Var);
        }

        public a o(z zVar) {
            e3.f.e(zVar, "protocol");
            return m3.o.n(this, zVar);
        }

        public a p(long j4) {
            this.f4611l = j4;
            return this;
        }

        public a q(a0 a0Var) {
            e3.f.e(a0Var, "request");
            return m3.o.o(this, a0Var);
        }

        public a r(long j4) {
            this.f4610k = j4;
            return this;
        }

        public final void s(d0 d0Var) {
            e3.f.e(d0Var, "<set-?>");
            this.f4606g = d0Var;
        }

        public final void t(c0 c0Var) {
            this.f4608i = c0Var;
        }

        public final void u(int i4) {
            this.f4602c = i4;
        }

        public final void v(u.a aVar) {
            e3.f.e(aVar, "<set-?>");
            this.f4605f = aVar;
        }

        public final void w(String str) {
            this.f4603d = str;
        }

        public final void x(c0 c0Var) {
            this.f4607h = c0Var;
        }

        public final void y(c0 c0Var) {
            this.f4609j = c0Var;
        }

        public final void z(z zVar) {
            this.f4601b = zVar;
        }
    }

    public c0(a0 a0Var, z zVar, String str, int i4, t tVar, u uVar, d0 d0Var, c0 c0Var, c0 c0Var2, c0 c0Var3, long j4, long j5, q3.c cVar, d3.a<u> aVar) {
        e3.f.e(a0Var, "request");
        e3.f.e(zVar, "protocol");
        e3.f.e(str, "message");
        e3.f.e(uVar, "headers");
        e3.f.e(d0Var, "body");
        e3.f.e(aVar, "trailersFn");
        this.f4583b = a0Var;
        this.f4584c = zVar;
        this.f4585d = str;
        this.f4586e = i4;
        this.f4587f = tVar;
        this.f4588g = uVar;
        this.f4589h = d0Var;
        this.f4590i = c0Var;
        this.f4591j = c0Var2;
        this.f4592k = c0Var3;
        this.f4593l = j4;
        this.f4594m = j5;
        this.f4595n = cVar;
        this.f4596o = aVar;
        this.f4598q = m3.o.t(this);
        this.f4599r = m3.o.s(this);
    }

    public static /* synthetic */ String R(c0 c0Var, String str, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = null;
        }
        return c0Var.Q(str, str2);
    }

    public final d0 I() {
        return this.f4589h;
    }

    public final d J() {
        return m3.o.r(this);
    }

    public final c0 K() {
        return this.f4591j;
    }

    public final List<h> L() {
        String str;
        u uVar = this.f4588g;
        int i4 = this.f4586e;
        if (i4 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i4 != 407) {
                return v2.m.i();
            }
            str = "Proxy-Authenticate";
        }
        return r3.e.a(uVar, str);
    }

    public final int M() {
        return this.f4586e;
    }

    public final q3.c N() {
        return this.f4595n;
    }

    public final d O() {
        return this.f4597p;
    }

    public final t P() {
        return this.f4587f;
    }

    public final String Q(String str, String str2) {
        e3.f.e(str, "name");
        return m3.o.g(this, str, str2);
    }

    public final u S() {
        return this.f4588g;
    }

    public final String T() {
        return this.f4585d;
    }

    public final c0 U() {
        return this.f4590i;
    }

    public final a V() {
        return m3.o.l(this);
    }

    public final c0 W() {
        return this.f4592k;
    }

    public final z X() {
        return this.f4584c;
    }

    public final long Y() {
        return this.f4594m;
    }

    public final a0 Z() {
        return this.f4583b;
    }

    public final long a0() {
        return this.f4593l;
    }

    public final void b0(d dVar) {
        this.f4597p = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m3.o.e(this);
    }

    public String toString() {
        return m3.o.p(this);
    }
}
