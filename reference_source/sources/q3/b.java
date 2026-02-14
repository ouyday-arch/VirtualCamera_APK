package q3;

import b4.h0;
import j3.u;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import l3.a0;
import l3.c0;
import l3.e0;
import l3.s;
import l3.t;
import l3.w;
import l3.y;
import l3.z;
import q3.n;
import r3.d;

/* loaded from: classes.dex */
public final class b implements n.b, d.a {

    /* renamed from: u, reason: collision with root package name */
    public static final a f5621u = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final y f5622a;

    /* renamed from: b, reason: collision with root package name */
    private final h f5623b;

    /* renamed from: c, reason: collision with root package name */
    private final w.a f5624c;

    /* renamed from: d, reason: collision with root package name */
    private final k f5625d;

    /* renamed from: e, reason: collision with root package name */
    private final e0 f5626e;

    /* renamed from: f, reason: collision with root package name */
    private final List<e0> f5627f;

    /* renamed from: g, reason: collision with root package name */
    private final int f5628g;

    /* renamed from: h, reason: collision with root package name */
    private final a0 f5629h;

    /* renamed from: i, reason: collision with root package name */
    private final int f5630i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f5631j;

    /* renamed from: k, reason: collision with root package name */
    private final l3.k f5632k;

    /* renamed from: l, reason: collision with root package name */
    private final s f5633l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f5634m;

    /* renamed from: n, reason: collision with root package name */
    private Socket f5635n;

    /* renamed from: o, reason: collision with root package name */
    private Socket f5636o;

    /* renamed from: p, reason: collision with root package name */
    private t f5637p;

    /* renamed from: q, reason: collision with root package name */
    private z f5638q;

    /* renamed from: r, reason: collision with root package name */
    private b4.f f5639r;

    /* renamed from: s, reason: collision with root package name */
    private b4.e f5640s;

    /* renamed from: t, reason: collision with root package name */
    private i f5641t;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    /* renamed from: q3.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class C0072b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5642a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5642a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends e3.g implements d3.a<List<? extends X509Certificate>> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ t f5643c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(t tVar) {
            super(0);
            this.f5643c = tVar;
        }

        @Override // d3.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List<X509Certificate> d() {
            int r4;
            List<Certificate> d5 = this.f5643c.d();
            r4 = v2.p.r(d5, 10);
            ArrayList arrayList = new ArrayList(r4);
            for (Certificate certificate : d5) {
                e3.f.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d extends e3.g implements d3.a<List<? extends Certificate>> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ l3.g f5644c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ t f5645d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ l3.a f5646e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(l3.g gVar, t tVar, l3.a aVar) {
            super(0);
            this.f5644c = gVar;
            this.f5645d = tVar;
            this.f5646e = aVar;
        }

        @Override // d3.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List<Certificate> d() {
            a4.c d5 = this.f5644c.d();
            e3.f.b(d5);
            return d5.a(this.f5645d.d(), this.f5646e.l().j());
        }
    }

    public b(y yVar, h hVar, w.a aVar, k kVar, e0 e0Var, List<e0> list, int i4, a0 a0Var, int i5, boolean z4, l3.k kVar2) {
        e3.f.e(yVar, "client");
        e3.f.e(hVar, "call");
        e3.f.e(aVar, "chain");
        e3.f.e(kVar, "routePlanner");
        e3.f.e(e0Var, "route");
        e3.f.e(kVar2, "connectionListener");
        this.f5622a = yVar;
        this.f5623b = hVar;
        this.f5624c = aVar;
        this.f5625d = kVar;
        this.f5626e = e0Var;
        this.f5627f = list;
        this.f5628g = i4;
        this.f5629h = a0Var;
        this.f5630i = i5;
        this.f5631j = z4;
        this.f5632k = kVar2;
        this.f5633l = hVar.n();
    }

    private final void j() {
        Socket createSocket;
        Proxy.Type type = c().b().type();
        int i4 = type == null ? -1 : C0072b.f5642a[type.ordinal()];
        if (i4 == 1 || i4 == 2) {
            createSocket = c().a().j().createSocket();
            e3.f.b(createSocket);
        } else {
            createSocket = new Socket(c().b());
        }
        this.f5635n = createSocket;
        if (this.f5634m) {
            throw new IOException("canceled");
        }
        createSocket.setSoTimeout(this.f5624c.d());
        try {
            w3.h.f6456a.g().f(createSocket, c().d(), this.f5624c.c());
            try {
                this.f5639r = b4.t.b(b4.t.g(createSocket));
                this.f5640s = b4.t.a(b4.t.d(createSocket));
            } catch (NullPointerException e4) {
                if (e3.f.a(e4.getMessage(), "throw with null exception")) {
                    throw new IOException(e4);
                }
            }
        } catch (ConnectException e5) {
            ConnectException connectException = new ConnectException("Failed to connect to " + c().d());
            connectException.initCause(e5);
            throw connectException;
        }
    }

    private final void k(SSLSocket sSLSocket, l3.m mVar) {
        String e4;
        l3.a a5 = c().a();
        try {
            if (mVar.h()) {
                w3.h.f6456a.g().e(sSLSocket, a5.l().j(), a5.f());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            t.a aVar = t.f4786e;
            e3.f.b(session);
            t a6 = aVar.a(session);
            HostnameVerifier e5 = a5.e();
            e3.f.b(e5);
            if (e5.verify(a5.l().j(), session)) {
                l3.g a7 = a5.a();
                e3.f.b(a7);
                t tVar = new t(a6.e(), a6.a(), a6.c(), new d(a7, a6, a5));
                this.f5637p = tVar;
                a7.b(a5.l().j(), new c(tVar));
                String g4 = mVar.h() ? w3.h.f6456a.g().g(sSLSocket) : null;
                this.f5636o = sSLSocket;
                this.f5639r = b4.t.b(b4.t.g(sSLSocket));
                this.f5640s = b4.t.a(b4.t.d(sSLSocket));
                this.f5638q = g4 != null ? z.f4871c.a(g4) : z.f4873e;
                w3.h.f6456a.g().b(sSLSocket);
                return;
            }
            List<Certificate> d5 = a6.d();
            if (!(!d5.isEmpty())) {
                throw new SSLPeerUnverifiedException("Hostname " + a5.l().j() + " not verified (no certificates)");
            }
            Certificate certificate = d5.get(0);
            e3.f.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) certificate;
            e4 = j3.n.e("\n            |Hostname " + a5.l().j() + " not verified:\n            |    certificate: " + l3.g.f4653c.a(x509Certificate) + "\n            |    DN: " + x509Certificate.getSubjectDN().getName() + "\n            |    subjectAltNames: " + a4.d.f310a.a(x509Certificate) + "\n            ", null, 1, null);
            throw new SSLPeerUnverifiedException(e4);
        } catch (Throwable th) {
            w3.h.f6456a.g().b(sSLSocket);
            m3.s.f(sSLSocket);
            throw th;
        }
    }

    private final b m(int i4, a0 a0Var, int i5, boolean z4) {
        return new b(this.f5622a, this.f5623b, this.f5624c, this.f5625d, c(), this.f5627f, i4, a0Var, i5, z4, this.f5632k);
    }

    static /* synthetic */ b n(b bVar, int i4, a0 a0Var, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = bVar.f5628g;
        }
        if ((i6 & 2) != 0) {
            a0Var = bVar.f5629h;
        }
        if ((i6 & 4) != 0) {
            i5 = bVar.f5630i;
        }
        if ((i6 & 8) != 0) {
            z4 = bVar.f5631j;
        }
        return bVar.m(i4, a0Var, i5, z4);
    }

    private final a0 o() {
        boolean l4;
        a0 a0Var = this.f5629h;
        e3.f.b(a0Var);
        String str = "CONNECT " + m3.s.r(c().a().l(), true) + " HTTP/1.1";
        while (true) {
            b4.f fVar = this.f5639r;
            e3.f.b(fVar);
            b4.e eVar = this.f5640s;
            e3.f.b(eVar);
            s3.b bVar = new s3.b(null, this, fVar, eVar);
            h0 b5 = fVar.b();
            long B = this.f5622a.B();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            b5.g(B, timeUnit);
            eVar.b().g(this.f5622a.G(), timeUnit);
            bVar.B(a0Var.e(), str);
            bVar.c();
            c0.a g4 = bVar.g(false);
            e3.f.b(g4);
            c0 c5 = g4.q(a0Var).c();
            bVar.A(c5);
            int M = c5.M();
            if (M == 200) {
                return null;
            }
            if (M != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + c5.M());
            }
            a0 a5 = c().a().h().a(c(), c5);
            if (a5 == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            l4 = u.l("close", c0.R(c5, "Connection", null, 2, null), true);
            if (l4) {
                return a5;
            }
            a0Var = a5;
        }
    }

    @Override // q3.n.b
    public n.b a() {
        return new b(this.f5622a, this.f5623b, this.f5624c, this.f5625d, c(), this.f5627f, this.f5628g, this.f5629h, this.f5630i, this.f5631j, this.f5632k);
    }

    @Override // q3.n.b
    public boolean b() {
        return this.f5638q != null;
    }

    @Override // r3.d.a
    public e0 c() {
        return this.f5626e;
    }

    @Override // q3.n.b, r3.d.a
    public void cancel() {
        this.f5634m = true;
        Socket socket = this.f5635n;
        if (socket != null) {
            m3.s.f(socket);
        }
    }

    @Override // q3.n.b
    public n.a d() {
        Socket socket;
        Socket socket2;
        boolean z4 = true;
        if (!(this.f5635n == null)) {
            throw new IllegalStateException("TCP already connected".toString());
        }
        this.f5623b.r().add(this);
        try {
            try {
                this.f5633l.i(this.f5623b, c().d(), c().b());
                this.f5632k.d(c(), this.f5623b);
                j();
                try {
                    n.a aVar = new n.a(this, null, null, 6, null);
                    this.f5623b.r().remove(this);
                    return aVar;
                } catch (IOException e4) {
                    e = e4;
                    this.f5633l.h(this.f5623b, c().d(), c().b(), null, e);
                    this.f5632k.c(c(), this.f5623b, e);
                    n.a aVar2 = new n.a(this, null, e, 2, null);
                    this.f5623b.r().remove(this);
                    if (!z4 && (socket2 = this.f5635n) != null) {
                        m3.s.f(socket2);
                    }
                    return aVar2;
                }
            } catch (Throwable th) {
                th = th;
                this.f5623b.r().remove(this);
                if (!z4 && (socket = this.f5635n) != null) {
                    m3.s.f(socket);
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            z4 = false;
        } catch (Throwable th2) {
            th = th2;
            z4 = false;
            this.f5623b.r().remove(this);
            if (!z4) {
                m3.s.f(socket);
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fa  */
    @Override // q3.n.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q3.n.a e() {
        /*
            Method dump skipped, instructions count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.b.e():q3.n$a");
    }

    @Override // q3.n.b
    public i f() {
        this.f5623b.l().q().a(c());
        i iVar = this.f5641t;
        e3.f.b(iVar);
        this.f5632k.b(iVar, c(), this.f5623b);
        l m4 = this.f5625d.m(this, this.f5627f);
        if (m4 != null) {
            return m4.i();
        }
        synchronized (iVar) {
            this.f5622a.h().b().f(iVar);
            this.f5623b.c(iVar);
            u2.l lVar = u2.l.f6223a;
        }
        this.f5633l.j(this.f5623b, iVar);
        iVar.i().e(iVar, this.f5623b);
        return iVar;
    }

    @Override // r3.d.a
    public void g(h hVar, IOException iOException) {
        e3.f.e(hVar, "call");
    }

    @Override // r3.d.a
    public void h() {
    }

    public final void i() {
        Socket socket = this.f5636o;
        if (socket != null) {
            m3.s.f(socket);
        }
    }

    public final n.a l() {
        a0 o4 = o();
        if (o4 == null) {
            return new n.a(this, null, null, 6, null);
        }
        Socket socket = this.f5635n;
        if (socket != null) {
            m3.s.f(socket);
        }
        int i4 = this.f5628g + 1;
        if (i4 < 21) {
            this.f5633l.g(this.f5623b, c().d(), c().b(), null);
            return new n.a(this, n(this, i4, o4, 0, false, 12, null), null, 4, null);
        }
        ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
        this.f5633l.h(this.f5623b, c().d(), c().b(), null, protocolException);
        this.f5632k.c(c(), this.f5623b, protocolException);
        return new n.a(this, null, protocolException, 2, null);
    }

    public final List<e0> p() {
        return this.f5627f;
    }

    public final b q(List<l3.m> list, SSLSocket sSLSocket) {
        e3.f.e(list, "connectionSpecs");
        e3.f.e(sSLSocket, "sslSocket");
        int i4 = this.f5630i + 1;
        int size = list.size();
        for (int i5 = i4; i5 < size; i5++) {
            if (list.get(i5).e(sSLSocket)) {
                return n(this, 0, null, i5, this.f5630i != -1, 3, null);
            }
        }
        return null;
    }

    public final b r(List<l3.m> list, SSLSocket sSLSocket) {
        e3.f.e(list, "connectionSpecs");
        e3.f.e(sSLSocket, "sslSocket");
        if (this.f5630i != -1) {
            return this;
        }
        b q4 = q(list, sSLSocket);
        if (q4 != null) {
            return q4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f5631j);
        sb.append(", modes=");
        sb.append(list);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        e3.f.b(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        e3.f.d(arrays, "toString(...)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }
}
