package l3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import l3.s;

/* loaded from: classes.dex */
public class y {
    public static final b F = new b(null);
    private static final List<z> G = m3.s.j(z.f4875g, z.f4873e);
    private static final List<m> H = m3.s.j(m.f4744i, m.f4746k);
    private final int A;
    private final int B;
    private final long C;
    private final q3.m D;
    private final p3.d E;

    /* renamed from: a, reason: collision with root package name */
    private final q f4819a;

    /* renamed from: b, reason: collision with root package name */
    private final l f4820b;

    /* renamed from: c, reason: collision with root package name */
    private final List<w> f4821c;

    /* renamed from: d, reason: collision with root package name */
    private final List<w> f4822d;

    /* renamed from: e, reason: collision with root package name */
    private final s.c f4823e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f4824f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f4825g;

    /* renamed from: h, reason: collision with root package name */
    private final l3.b f4826h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f4827i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f4828j;

    /* renamed from: k, reason: collision with root package name */
    private final o f4829k;

    /* renamed from: l, reason: collision with root package name */
    private final r f4830l;

    /* renamed from: m, reason: collision with root package name */
    private final Proxy f4831m;

    /* renamed from: n, reason: collision with root package name */
    private final ProxySelector f4832n;

    /* renamed from: o, reason: collision with root package name */
    private final l3.b f4833o;

    /* renamed from: p, reason: collision with root package name */
    private final SocketFactory f4834p;

    /* renamed from: q, reason: collision with root package name */
    private final SSLSocketFactory f4835q;

    /* renamed from: r, reason: collision with root package name */
    private final X509TrustManager f4836r;

    /* renamed from: s, reason: collision with root package name */
    private final List<m> f4837s;

    /* renamed from: t, reason: collision with root package name */
    private final List<z> f4838t;

    /* renamed from: u, reason: collision with root package name */
    private final HostnameVerifier f4839u;

    /* renamed from: v, reason: collision with root package name */
    private final g f4840v;

    /* renamed from: w, reason: collision with root package name */
    private final a4.c f4841w;

    /* renamed from: x, reason: collision with root package name */
    private final int f4842x;

    /* renamed from: y, reason: collision with root package name */
    private final int f4843y;

    /* renamed from: z, reason: collision with root package name */
    private final int f4844z;

    /* loaded from: classes.dex */
    public static final class a {
        private int A;
        private int B;
        private long C;
        private q3.m D;
        private p3.d E;

        /* renamed from: a, reason: collision with root package name */
        private q f4845a = new q();

        /* renamed from: b, reason: collision with root package name */
        private l f4846b = new l();

        /* renamed from: c, reason: collision with root package name */
        private final List<w> f4847c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private final List<w> f4848d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private s.c f4849e = m3.s.c(s.f4785b);

        /* renamed from: f, reason: collision with root package name */
        private boolean f4850f = true;

        /* renamed from: g, reason: collision with root package name */
        private boolean f4851g = true;

        /* renamed from: h, reason: collision with root package name */
        private l3.b f4852h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f4853i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f4854j;

        /* renamed from: k, reason: collision with root package name */
        private o f4855k;

        /* renamed from: l, reason: collision with root package name */
        private r f4856l;

        /* renamed from: m, reason: collision with root package name */
        private Proxy f4857m;

        /* renamed from: n, reason: collision with root package name */
        private ProxySelector f4858n;

        /* renamed from: o, reason: collision with root package name */
        private l3.b f4859o;

        /* renamed from: p, reason: collision with root package name */
        private SocketFactory f4860p;

        /* renamed from: q, reason: collision with root package name */
        private SSLSocketFactory f4861q;

        /* renamed from: r, reason: collision with root package name */
        private X509TrustManager f4862r;

        /* renamed from: s, reason: collision with root package name */
        private List<m> f4863s;

        /* renamed from: t, reason: collision with root package name */
        private List<? extends z> f4864t;

        /* renamed from: u, reason: collision with root package name */
        private HostnameVerifier f4865u;

        /* renamed from: v, reason: collision with root package name */
        private g f4866v;

        /* renamed from: w, reason: collision with root package name */
        private a4.c f4867w;

        /* renamed from: x, reason: collision with root package name */
        private int f4868x;

        /* renamed from: y, reason: collision with root package name */
        private int f4869y;

        /* renamed from: z, reason: collision with root package name */
        private int f4870z;

        public a() {
            l3.b bVar = l3.b.f4579b;
            this.f4852h = bVar;
            this.f4853i = true;
            this.f4854j = true;
            this.f4855k = o.f4771b;
            this.f4856l = r.f4782b;
            this.f4859o = bVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            e3.f.d(socketFactory, "getDefault(...)");
            this.f4860p = socketFactory;
            b bVar2 = y.F;
            this.f4863s = bVar2.a();
            this.f4864t = bVar2.b();
            this.f4865u = a4.d.f310a;
            this.f4866v = g.f4654d;
            this.f4869y = 10000;
            this.f4870z = 10000;
            this.A = 10000;
            this.C = 1024L;
        }

        public final boolean A() {
            return this.f4850f;
        }

        public final q3.m B() {
            return this.D;
        }

        public final SocketFactory C() {
            return this.f4860p;
        }

        public final SSLSocketFactory D() {
            return this.f4861q;
        }

        public final p3.d E() {
            return this.E;
        }

        public final int F() {
            return this.A;
        }

        public final X509TrustManager G() {
            return this.f4862r;
        }

        public final a H(Proxy proxy) {
            if (!e3.f.a(proxy, this.f4857m)) {
                this.D = null;
            }
            this.f4857m = proxy;
            return this;
        }

        public final a I(l3.b bVar) {
            e3.f.e(bVar, "proxyAuthenticator");
            if (!e3.f.a(bVar, this.f4859o)) {
                this.D = null;
            }
            this.f4859o = bVar;
            return this;
        }

        public final y a() {
            return new y(this);
        }

        public final l3.b b() {
            return this.f4852h;
        }

        public final c c() {
            return null;
        }

        public final int d() {
            return this.f4868x;
        }

        public final a4.c e() {
            return this.f4867w;
        }

        public final g f() {
            return this.f4866v;
        }

        public final int g() {
            return this.f4869y;
        }

        public final l h() {
            return this.f4846b;
        }

        public final List<m> i() {
            return this.f4863s;
        }

        public final o j() {
            return this.f4855k;
        }

        public final q k() {
            return this.f4845a;
        }

        public final r l() {
            return this.f4856l;
        }

        public final s.c m() {
            return this.f4849e;
        }

        public final boolean n() {
            return this.f4851g;
        }

        public final boolean o() {
            return this.f4853i;
        }

        public final boolean p() {
            return this.f4854j;
        }

        public final HostnameVerifier q() {
            return this.f4865u;
        }

        public final List<w> r() {
            return this.f4847c;
        }

        public final long s() {
            return this.C;
        }

        public final List<w> t() {
            return this.f4848d;
        }

        public final int u() {
            return this.B;
        }

        public final List<z> v() {
            return this.f4864t;
        }

        public final Proxy w() {
            return this.f4857m;
        }

        public final l3.b x() {
            return this.f4859o;
        }

        public final ProxySelector y() {
            return this.f4858n;
        }

        public final int z() {
            return this.f4870z;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }

        public final List<m> a() {
            return y.H;
        }

        public final List<z> b() {
            return y.G;
        }
    }

    public y() {
        this(new a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
    
        if (r0 == null) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y(l3.y.a r4) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.y.<init>(l3.y$a):void");
    }

    private final void F() {
        boolean z4;
        e3.f.c(this.f4821c, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (!(!r0.contains(null))) {
            throw new IllegalStateException(("Null interceptor: " + this.f4821c).toString());
        }
        e3.f.c(this.f4822d, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (!(!r0.contains(null))) {
            throw new IllegalStateException(("Null network interceptor: " + this.f4822d).toString());
        }
        List<m> list = this.f4837s;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((m) it.next()).f()) {
                    z4 = false;
                    break;
                }
            }
        }
        z4 = true;
        if (!z4) {
            if (this.f4835q == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.f4841w == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.f4836r == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.f4835q == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f4841w == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f4836r == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!e3.f.a(this.f4840v, g.f4654d)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final ProxySelector A() {
        return this.f4832n;
    }

    public final int B() {
        return this.f4844z;
    }

    public final boolean C() {
        return this.f4824f;
    }

    public final SocketFactory D() {
        return this.f4834p;
    }

    public final SSLSocketFactory E() {
        SSLSocketFactory sSLSocketFactory = this.f4835q;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int G() {
        return this.A;
    }

    public final l3.b c() {
        return this.f4826h;
    }

    public final c d() {
        return null;
    }

    public final int e() {
        return this.f4842x;
    }

    public final g f() {
        return this.f4840v;
    }

    public final int g() {
        return this.f4843y;
    }

    public final l h() {
        return this.f4820b;
    }

    public final List<m> i() {
        return this.f4837s;
    }

    public final o j() {
        return this.f4829k;
    }

    public final q k() {
        return this.f4819a;
    }

    public final r l() {
        return this.f4830l;
    }

    public final s.c m() {
        return this.f4823e;
    }

    public final boolean n() {
        return this.f4825g;
    }

    public final boolean o() {
        return this.f4827i;
    }

    public final boolean p() {
        return this.f4828j;
    }

    public final q3.m q() {
        return this.D;
    }

    public final p3.d r() {
        return this.E;
    }

    public final HostnameVerifier s() {
        return this.f4839u;
    }

    public final List<w> t() {
        return this.f4821c;
    }

    public final List<w> u() {
        return this.f4822d;
    }

    public e v(a0 a0Var) {
        e3.f.e(a0Var, "request");
        return new q3.h(this, a0Var, false);
    }

    public final int w() {
        return this.B;
    }

    public final List<z> x() {
        return this.f4838t;
    }

    public final Proxy y() {
        return this.f4831m;
    }

    public final l3.b z() {
        return this.f4833o;
    }
}
