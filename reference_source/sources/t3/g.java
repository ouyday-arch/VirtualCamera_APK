package t3;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import m3.p;
import m3.s;
import t3.c;
import t3.i;

/* loaded from: classes.dex */
public final class g implements Closeable {
    public static final c D = new c(null);
    private static final n E;
    private final t3.k A;
    private final e B;
    private final Set<Integer> C;

    /* renamed from: b */
    private final boolean f6062b;

    /* renamed from: c */
    private final d f6063c;

    /* renamed from: d */
    private final Map<Integer, t3.j> f6064d;

    /* renamed from: e */
    private final String f6065e;

    /* renamed from: f */
    private int f6066f;

    /* renamed from: g */
    private int f6067g;

    /* renamed from: h */
    private boolean f6068h;

    /* renamed from: i */
    private final p3.d f6069i;

    /* renamed from: j */
    private final p3.c f6070j;

    /* renamed from: k */
    private final p3.c f6071k;

    /* renamed from: l */
    private final p3.c f6072l;

    /* renamed from: m */
    private final m f6073m;

    /* renamed from: n */
    private long f6074n;

    /* renamed from: o */
    private long f6075o;

    /* renamed from: p */
    private long f6076p;

    /* renamed from: q */
    private long f6077q;

    /* renamed from: r */
    private long f6078r;

    /* renamed from: s */
    private long f6079s;

    /* renamed from: t */
    private final t3.c f6080t;

    /* renamed from: u */
    private final n f6081u;

    /* renamed from: v */
    private n f6082v;

    /* renamed from: w */
    private final u3.a f6083w;

    /* renamed from: x */
    private long f6084x;

    /* renamed from: y */
    private long f6085y;

    /* renamed from: z */
    private final Socket f6086z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends e3.g implements d3.a<Long> {

        /* renamed from: d */
        final /* synthetic */ long f6088d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j4) {
            super(0);
            this.f6088d = j4;
        }

        @Override // d3.a
        /* renamed from: c */
        public final Long d() {
            boolean z4;
            long j4;
            g gVar = g.this;
            synchronized (gVar) {
                if (gVar.f6075o < gVar.f6074n) {
                    z4 = true;
                } else {
                    gVar.f6074n++;
                    z4 = false;
                }
            }
            g gVar2 = g.this;
            if (z4) {
                gVar2.a0(null);
                j4 = -1;
            } else {
                gVar2.F0(false, 1, 0);
                j4 = this.f6088d;
            }
            return Long.valueOf(j4);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a */
        private boolean f6089a;

        /* renamed from: b */
        private final p3.d f6090b;

        /* renamed from: c */
        public Socket f6091c;

        /* renamed from: d */
        public String f6092d;

        /* renamed from: e */
        public b4.f f6093e;

        /* renamed from: f */
        public b4.e f6094f;

        /* renamed from: g */
        private d f6095g;

        /* renamed from: h */
        private m f6096h;

        /* renamed from: i */
        private int f6097i;

        /* renamed from: j */
        private t3.c f6098j;

        public b(boolean z4, p3.d dVar) {
            e3.f.e(dVar, "taskRunner");
            this.f6089a = z4;
            this.f6090b = dVar;
            this.f6095g = d.f6100b;
            this.f6096h = m.f6200b;
            this.f6098j = c.a.f6025a;
        }

        public final g a() {
            return new g(this);
        }

        public final b b(t3.c cVar) {
            e3.f.e(cVar, "flowControlListener");
            this.f6098j = cVar;
            return this;
        }

        public final boolean c() {
            return this.f6089a;
        }

        public final String d() {
            String str = this.f6092d;
            if (str != null) {
                return str;
            }
            e3.f.o("connectionName");
            return null;
        }

        public final t3.c e() {
            return this.f6098j;
        }

        public final d f() {
            return this.f6095g;
        }

        public final int g() {
            return this.f6097i;
        }

        public final m h() {
            return this.f6096h;
        }

        public final b4.e i() {
            b4.e eVar = this.f6094f;
            if (eVar != null) {
                return eVar;
            }
            e3.f.o("sink");
            return null;
        }

        public final Socket j() {
            Socket socket = this.f6091c;
            if (socket != null) {
                return socket;
            }
            e3.f.o("socket");
            return null;
        }

        public final b4.f k() {
            b4.f fVar = this.f6093e;
            if (fVar != null) {
                return fVar;
            }
            e3.f.o("source");
            return null;
        }

        public final p3.d l() {
            return this.f6090b;
        }

        public final b m(d dVar) {
            e3.f.e(dVar, "listener");
            this.f6095g = dVar;
            return this;
        }

        public final b n(int i4) {
            this.f6097i = i4;
            return this;
        }

        public final void o(String str) {
            e3.f.e(str, "<set-?>");
            this.f6092d = str;
        }

        public final void p(b4.e eVar) {
            e3.f.e(eVar, "<set-?>");
            this.f6094f = eVar;
        }

        public final void q(Socket socket) {
            e3.f.e(socket, "<set-?>");
            this.f6091c = socket;
        }

        public final void r(b4.f fVar) {
            e3.f.e(fVar, "<set-?>");
            this.f6093e = fVar;
        }

        public final b s(Socket socket, String str, b4.f fVar, b4.e eVar) {
            StringBuilder sb;
            e3.f.e(socket, "socket");
            e3.f.e(str, "peerName");
            e3.f.e(fVar, "source");
            e3.f.e(eVar, "sink");
            q(socket);
            if (this.f6089a) {
                sb = new StringBuilder();
                sb.append(s.f5214f);
                sb.append(' ');
            } else {
                sb = new StringBuilder();
                sb.append("MockWebServer ");
            }
            sb.append(str);
            o(sb.toString());
            r(fVar);
            p(eVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(e3.d dVar) {
            this();
        }

        public final n a() {
            return g.E;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {

        /* renamed from: a */
        public static final b f6099a = new b(null);

        /* renamed from: b */
        public static final d f6100b = new a();

        /* loaded from: classes.dex */
        public static final class a extends d {
            a() {
            }

            @Override // t3.g.d
            public void b(t3.j jVar) {
                e3.f.e(jVar, "stream");
                jVar.e(t3.b.f6015k, null);
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

        public void a(g gVar, n nVar) {
            e3.f.e(gVar, "connection");
            e3.f.e(nVar, "settings");
        }

        public abstract void b(t3.j jVar);
    }

    /* loaded from: classes.dex */
    public final class e implements i.c, d3.a<u2.l> {

        /* renamed from: b */
        private final t3.i f6101b;

        /* renamed from: c */
        final /* synthetic */ g f6102c;

        /* loaded from: classes.dex */
        public static final class a extends e3.g implements d3.a<u2.l> {

            /* renamed from: c */
            final /* synthetic */ g f6103c;

            /* renamed from: d */
            final /* synthetic */ e3.k<n> f6104d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar, e3.k<n> kVar) {
                super(0);
                this.f6103c = gVar;
                this.f6104d = kVar;
            }

            public final void c() {
                this.f6103c.f0().a(this.f6103c, this.f6104d.f3630b);
            }

            @Override // d3.a
            public /* bridge */ /* synthetic */ u2.l d() {
                c();
                return u2.l.f6223a;
            }
        }

        /* loaded from: classes.dex */
        static final class b extends e3.g implements d3.a<u2.l> {

            /* renamed from: c */
            final /* synthetic */ g f6105c;

            /* renamed from: d */
            final /* synthetic */ t3.j f6106d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(g gVar, t3.j jVar) {
                super(0);
                this.f6105c = gVar;
                this.f6106d = jVar;
            }

            public final void c() {
                try {
                    this.f6105c.f0().b(this.f6106d);
                } catch (IOException e4) {
                    w3.h.f6456a.g().j("Http2Connection.Listener failure for " + this.f6105c.c0(), 4, e4);
                    try {
                        this.f6106d.e(t3.b.f6009e, e4);
                    } catch (IOException unused) {
                    }
                }
            }

            @Override // d3.a
            public /* bridge */ /* synthetic */ u2.l d() {
                c();
                return u2.l.f6223a;
            }
        }

        /* loaded from: classes.dex */
        static final class c extends e3.g implements d3.a<u2.l> {

            /* renamed from: c */
            final /* synthetic */ g f6107c;

            /* renamed from: d */
            final /* synthetic */ int f6108d;

            /* renamed from: e */
            final /* synthetic */ int f6109e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(g gVar, int i4, int i5) {
                super(0);
                this.f6107c = gVar;
                this.f6108d = i4;
                this.f6109e = i5;
            }

            public final void c() {
                this.f6107c.F0(true, this.f6108d, this.f6109e);
            }

            @Override // d3.a
            public /* bridge */ /* synthetic */ u2.l d() {
                c();
                return u2.l.f6223a;
            }
        }

        /* loaded from: classes.dex */
        static final class d extends e3.g implements d3.a<u2.l> {

            /* renamed from: d */
            final /* synthetic */ boolean f6111d;

            /* renamed from: e */
            final /* synthetic */ n f6112e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(boolean z4, n nVar) {
                super(0);
                this.f6111d = z4;
                this.f6112e = nVar;
            }

            public final void c() {
                e.this.l(this.f6111d, this.f6112e);
            }

            @Override // d3.a
            public /* bridge */ /* synthetic */ u2.l d() {
                c();
                return u2.l.f6223a;
            }
        }

        public e(g gVar, t3.i iVar) {
            e3.f.e(iVar, "reader");
            this.f6102c = gVar;
            this.f6101b = iVar;
        }

        @Override // t3.i.c
        public void a(int i4, t3.b bVar, b4.g gVar) {
            int i5;
            Object[] array;
            e3.f.e(bVar, "errorCode");
            e3.f.e(gVar, "debugData");
            gVar.y();
            g gVar2 = this.f6102c;
            synchronized (gVar2) {
                array = gVar2.k0().values().toArray(new t3.j[0]);
                gVar2.f6068h = true;
                u2.l lVar = u2.l.f6223a;
            }
            for (t3.j jVar : (t3.j[]) array) {
                if (jVar.l() > i4 && jVar.u()) {
                    jVar.z(t3.b.f6015k);
                    this.f6102c.v0(jVar.l());
                }
            }
        }

        @Override // t3.i.c
        public void b(boolean z4, int i4, int i5, List<t3.d> list) {
            e3.f.e(list, "headerBlock");
            if (this.f6102c.u0(i4)) {
                this.f6102c.r0(i4, list, z4);
                return;
            }
            g gVar = this.f6102c;
            synchronized (gVar) {
                t3.j j02 = gVar.j0(i4);
                if (j02 != null) {
                    u2.l lVar = u2.l.f6223a;
                    j02.y(s.q(list), z4);
                    return;
                }
                if (gVar.f6068h) {
                    return;
                }
                if (i4 <= gVar.e0()) {
                    return;
                }
                if (i4 % 2 == gVar.g0() % 2) {
                    return;
                }
                t3.j jVar = new t3.j(i4, gVar, false, z4, s.q(list));
                gVar.x0(i4);
                gVar.k0().put(Integer.valueOf(i4), jVar);
                p3.c.d(gVar.f6069i.k(), gVar.c0() + '[' + i4 + "] onStream", 0L, false, new b(gVar, jVar), 6, null);
            }
        }

        @Override // t3.i.c
        public void c(boolean z4, int i4, b4.f fVar, int i5) {
            e3.f.e(fVar, "source");
            if (this.f6102c.u0(i4)) {
                this.f6102c.q0(i4, fVar, i5, z4);
                return;
            }
            t3.j j02 = this.f6102c.j0(i4);
            if (j02 == null) {
                this.f6102c.H0(i4, t3.b.f6009e);
                long j4 = i5;
                this.f6102c.C0(j4);
                fVar.o(j4);
                return;
            }
            j02.x(fVar, i5);
            if (z4) {
                j02.y(s.f5209a, true);
            }
        }

        @Override // d3.a
        public /* bridge */ /* synthetic */ u2.l d() {
            m();
            return u2.l.f6223a;
        }

        @Override // t3.i.c
        public void e(int i4, t3.b bVar) {
            e3.f.e(bVar, "errorCode");
            if (this.f6102c.u0(i4)) {
                this.f6102c.t0(i4, bVar);
                return;
            }
            t3.j v02 = this.f6102c.v0(i4);
            if (v02 != null) {
                v02.z(bVar);
            }
        }

        @Override // t3.i.c
        public void f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // t3.i.c
        public void g(int i4, long j4) {
            t3.j jVar;
            if (i4 == 0) {
                g gVar = this.f6102c;
                synchronized (gVar) {
                    gVar.f6085y = gVar.l0() + j4;
                    e3.f.c(gVar, "null cannot be cast to non-null type java.lang.Object");
                    gVar.notifyAll();
                    u2.l lVar = u2.l.f6223a;
                    jVar = gVar;
                }
            } else {
                t3.j j02 = this.f6102c.j0(i4);
                if (j02 == null) {
                    return;
                }
                synchronized (j02) {
                    j02.b(j4);
                    u2.l lVar2 = u2.l.f6223a;
                    jVar = j02;
                }
            }
        }

        @Override // t3.i.c
        public void h(int i4, int i5, List<t3.d> list) {
            e3.f.e(list, "requestHeaders");
            this.f6102c.s0(i5, list);
        }

        @Override // t3.i.c
        public void i(boolean z4, int i4, int i5) {
            if (!z4) {
                p3.c.d(this.f6102c.f6070j, this.f6102c.c0() + " ping", 0L, false, new c(this.f6102c, i4, i5), 6, null);
                return;
            }
            g gVar = this.f6102c;
            synchronized (gVar) {
                if (i4 == 1) {
                    gVar.f6075o++;
                } else if (i4 != 2) {
                    if (i4 == 3) {
                        gVar.f6078r++;
                        e3.f.c(gVar, "null cannot be cast to non-null type java.lang.Object");
                        gVar.notifyAll();
                    }
                    u2.l lVar = u2.l.f6223a;
                } else {
                    gVar.f6077q++;
                }
            }
        }

        @Override // t3.i.c
        public void j(int i4, int i5, int i6, boolean z4) {
        }

        @Override // t3.i.c
        public void k(boolean z4, n nVar) {
            e3.f.e(nVar, "settings");
            p3.c.d(this.f6102c.f6070j, this.f6102c.c0() + " applyAndAckSettings", 0L, false, new d(z4, nVar), 6, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4, types: [T, t3.n] */
        public final void l(boolean z4, n nVar) {
            ?? r02;
            long c5;
            int i4;
            t3.j[] jVarArr;
            t3.j[] jVarArr2;
            n nVar2 = nVar;
            e3.f.e(nVar2, "settings");
            e3.k kVar = new e3.k();
            t3.k m02 = this.f6102c.m0();
            g gVar = this.f6102c;
            synchronized (m02) {
                synchronized (gVar) {
                    n i02 = gVar.i0();
                    if (z4) {
                        r02 = nVar2;
                    } else {
                        n nVar3 = new n();
                        nVar3.g(i02);
                        nVar3.g(nVar2);
                        r02 = nVar3;
                    }
                    kVar.f3630b = r02;
                    c5 = r02.c() - i02.c();
                    if (c5 != 0 && !gVar.k0().isEmpty()) {
                        jVarArr = (t3.j[]) gVar.k0().values().toArray(new t3.j[0]);
                        jVarArr2 = jVarArr;
                        gVar.y0((n) kVar.f3630b);
                        p3.c.d(gVar.f6072l, gVar.c0() + " onSettings", 0L, false, new a(gVar, kVar), 6, null);
                        u2.l lVar = u2.l.f6223a;
                    }
                    jVarArr = null;
                    jVarArr2 = jVarArr;
                    gVar.y0((n) kVar.f3630b);
                    p3.c.d(gVar.f6072l, gVar.c0() + " onSettings", 0L, false, new a(gVar, kVar), 6, null);
                    u2.l lVar2 = u2.l.f6223a;
                }
                try {
                    gVar.m0().i((n) kVar.f3630b);
                } catch (IOException e4) {
                    gVar.a0(e4);
                }
                u2.l lVar3 = u2.l.f6223a;
            }
            if (jVarArr2 != null) {
                for (t3.j jVar : jVarArr2) {
                    synchronized (jVar) {
                        jVar.b(c5);
                        u2.l lVar4 = u2.l.f6223a;
                    }
                }
            }
        }

        public void m() {
            t3.b bVar;
            t3.b bVar2 = t3.b.f6010f;
            IOException e4 = null;
            try {
                this.f6101b.J(this);
                do {
                } while (this.f6101b.I(false, this));
                bVar = t3.b.f6008d;
                try {
                    try {
                        this.f6102c.Z(bVar, t3.b.f6016l, null);
                    } catch (IOException e5) {
                        e4 = e5;
                        t3.b bVar3 = t3.b.f6009e;
                        this.f6102c.Z(bVar3, bVar3, e4);
                        p.f(this.f6101b);
                    }
                } catch (Throwable th) {
                    th = th;
                    this.f6102c.Z(bVar, bVar2, e4);
                    p.f(this.f6101b);
                    throw th;
                }
            } catch (IOException e6) {
                e4 = e6;
                bVar = bVar2;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                this.f6102c.Z(bVar, bVar2, e4);
                p.f(this.f6101b);
                throw th;
            }
            p.f(this.f6101b);
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends e3.g implements d3.a<u2.l> {

        /* renamed from: d */
        final /* synthetic */ int f6114d;

        /* renamed from: e */
        final /* synthetic */ b4.d f6115e;

        /* renamed from: f */
        final /* synthetic */ int f6116f;

        /* renamed from: g */
        final /* synthetic */ boolean f6117g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(int i4, b4.d dVar, int i5, boolean z4) {
            super(0);
            this.f6114d = i4;
            this.f6115e = dVar;
            this.f6116f = i5;
            this.f6117g = z4;
        }

        public final void c() {
            g gVar = g.this;
            int i4 = this.f6114d;
            b4.d dVar = this.f6115e;
            int i5 = this.f6116f;
            boolean z4 = this.f6117g;
            try {
                boolean d5 = gVar.f6073m.d(i4, dVar, i5, z4);
                if (d5) {
                    gVar.m0().R(i4, t3.b.f6016l);
                }
                if (d5 || z4) {
                    synchronized (gVar) {
                        gVar.C.remove(Integer.valueOf(i4));
                    }
                }
            } catch (IOException unused) {
            }
        }

        @Override // d3.a
        public /* bridge */ /* synthetic */ u2.l d() {
            c();
            return u2.l.f6223a;
        }
    }

    /* renamed from: t3.g$g */
    /* loaded from: classes.dex */
    public static final class C0079g extends e3.g implements d3.a<u2.l> {

        /* renamed from: d */
        final /* synthetic */ int f6119d;

        /* renamed from: e */
        final /* synthetic */ List<t3.d> f6120e;

        /* renamed from: f */
        final /* synthetic */ boolean f6121f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0079g(int i4, List<t3.d> list, boolean z4) {
            super(0);
            this.f6119d = i4;
            this.f6120e = list;
            this.f6121f = z4;
        }

        public final void c() {
            boolean b5 = g.this.f6073m.b(this.f6119d, this.f6120e, this.f6121f);
            g gVar = g.this;
            int i4 = this.f6119d;
            boolean z4 = this.f6121f;
            if (b5) {
                try {
                    gVar.m0().R(i4, t3.b.f6016l);
                } catch (IOException unused) {
                    return;
                }
            }
            if (b5 || z4) {
                synchronized (gVar) {
                    gVar.C.remove(Integer.valueOf(i4));
                }
            }
        }

        @Override // d3.a
        public /* bridge */ /* synthetic */ u2.l d() {
            c();
            return u2.l.f6223a;
        }
    }

    /* loaded from: classes.dex */
    public static final class h extends e3.g implements d3.a<u2.l> {

        /* renamed from: d */
        final /* synthetic */ int f6123d;

        /* renamed from: e */
        final /* synthetic */ List<t3.d> f6124e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i4, List<t3.d> list) {
            super(0);
            this.f6123d = i4;
            this.f6124e = list;
        }

        public final void c() {
            boolean a5 = g.this.f6073m.a(this.f6123d, this.f6124e);
            g gVar = g.this;
            int i4 = this.f6123d;
            if (a5) {
                try {
                    gVar.m0().R(i4, t3.b.f6016l);
                    synchronized (gVar) {
                        gVar.C.remove(Integer.valueOf(i4));
                    }
                } catch (IOException unused) {
                }
            }
        }

        @Override // d3.a
        public /* bridge */ /* synthetic */ u2.l d() {
            c();
            return u2.l.f6223a;
        }
    }

    /* loaded from: classes.dex */
    public static final class i extends e3.g implements d3.a<u2.l> {

        /* renamed from: d */
        final /* synthetic */ int f6126d;

        /* renamed from: e */
        final /* synthetic */ t3.b f6127e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(int i4, t3.b bVar) {
            super(0);
            this.f6126d = i4;
            this.f6127e = bVar;
        }

        public final void c() {
            g.this.f6073m.c(this.f6126d, this.f6127e);
            g gVar = g.this;
            int i4 = this.f6126d;
            synchronized (gVar) {
                gVar.C.remove(Integer.valueOf(i4));
                u2.l lVar = u2.l.f6223a;
            }
        }

        @Override // d3.a
        public /* bridge */ /* synthetic */ u2.l d() {
            c();
            return u2.l.f6223a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class j extends e3.g implements d3.a<u2.l> {
        j() {
            super(0);
        }

        public final void c() {
            g.this.F0(false, 2, 0);
        }

        @Override // d3.a
        public /* bridge */ /* synthetic */ u2.l d() {
            c();
            return u2.l.f6223a;
        }
    }

    /* loaded from: classes.dex */
    public static final class k extends e3.g implements d3.a<u2.l> {

        /* renamed from: d */
        final /* synthetic */ int f6130d;

        /* renamed from: e */
        final /* synthetic */ t3.b f6131e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(int i4, t3.b bVar) {
            super(0);
            this.f6130d = i4;
            this.f6131e = bVar;
        }

        public final void c() {
            try {
                g.this.G0(this.f6130d, this.f6131e);
            } catch (IOException e4) {
                g.this.a0(e4);
            }
        }

        @Override // d3.a
        public /* bridge */ /* synthetic */ u2.l d() {
            c();
            return u2.l.f6223a;
        }
    }

    /* loaded from: classes.dex */
    public static final class l extends e3.g implements d3.a<u2.l> {

        /* renamed from: d */
        final /* synthetic */ int f6133d;

        /* renamed from: e */
        final /* synthetic */ long f6134e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(int i4, long j4) {
            super(0);
            this.f6133d = i4;
            this.f6134e = j4;
        }

        public final void c() {
            try {
                g.this.m0().T(this.f6133d, this.f6134e);
            } catch (IOException e4) {
                g.this.a0(e4);
            }
        }

        @Override // d3.a
        public /* bridge */ /* synthetic */ u2.l d() {
            c();
            return u2.l.f6223a;
        }
    }

    static {
        n nVar = new n();
        nVar.h(7, 65535);
        nVar.h(5, 16384);
        E = nVar;
    }

    public g(b bVar) {
        e3.f.e(bVar, "builder");
        boolean c5 = bVar.c();
        this.f6062b = c5;
        this.f6063c = bVar.f();
        this.f6064d = new LinkedHashMap();
        String d5 = bVar.d();
        this.f6065e = d5;
        this.f6067g = bVar.c() ? 3 : 2;
        p3.d l4 = bVar.l();
        this.f6069i = l4;
        p3.c k4 = l4.k();
        this.f6070j = k4;
        this.f6071k = l4.k();
        this.f6072l = l4.k();
        this.f6073m = bVar.h();
        this.f6080t = bVar.e();
        n nVar = new n();
        if (bVar.c()) {
            nVar.h(7, 16777216);
        }
        this.f6081u = nVar;
        this.f6082v = E;
        this.f6083w = new u3.a(0);
        this.f6085y = this.f6082v.c();
        this.f6086z = bVar.j();
        this.A = new t3.k(bVar.i(), c5);
        this.B = new e(this, new t3.i(bVar.k(), c5));
        this.C = new LinkedHashSet();
        if (bVar.g() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(bVar.g());
            k4.k(d5 + " ping", nanos, new a(nanos));
        }
    }

    public static /* synthetic */ void B0(g gVar, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = true;
        }
        gVar.A0(z4);
    }

    public final void a0(IOException iOException) {
        t3.b bVar = t3.b.f6009e;
        Z(bVar, bVar, iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[Catch: all -> 0x0081, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x002a, B:15:0x0032, B:19:0x0042, B:21:0x0048, B:22:0x0051, B:37:0x007b, B:38:0x0080), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final t3.j o0(int r11, java.util.List<t3.d> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            t3.k r7 = r10.A
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L84
            int r0 = r10.f6067g     // Catch: java.lang.Throwable -> L81
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            t3.b r0 = t3.b.f6015k     // Catch: java.lang.Throwable -> L81
            r10.z0(r0)     // Catch: java.lang.Throwable -> L81
        L13:
            boolean r0 = r10.f6068h     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L7b
            int r8 = r10.f6067g     // Catch: java.lang.Throwable -> L81
            int r0 = r8 + 2
            r10.f6067g = r0     // Catch: java.lang.Throwable -> L81
            t3.j r9 = new t3.j     // Catch: java.lang.Throwable -> L81
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L81
            r0 = 1
            if (r13 == 0) goto L41
            long r1 = r10.f6084x     // Catch: java.lang.Throwable -> L81
            long r3 = r10.f6085y     // Catch: java.lang.Throwable -> L81
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 >= 0) goto L41
            long r1 = r9.s()     // Catch: java.lang.Throwable -> L81
            long r3 = r9.r()     // Catch: java.lang.Throwable -> L81
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 < 0) goto L3f
            goto L41
        L3f:
            r13 = 0
            goto L42
        L41:
            r13 = r0
        L42:
            boolean r1 = r9.v()     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L51
            java.util.Map<java.lang.Integer, t3.j> r1 = r10.f6064d     // Catch: java.lang.Throwable -> L81
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L81
            r1.put(r2, r9)     // Catch: java.lang.Throwable -> L81
        L51:
            u2.l r1 = u2.l.f6223a     // Catch: java.lang.Throwable -> L81
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L84
            if (r11 != 0) goto L5c
            t3.k r11 = r10.A     // Catch: java.lang.Throwable -> L84
            r11.N(r6, r8, r12)     // Catch: java.lang.Throwable -> L84
            goto L66
        L5c:
            boolean r1 = r10.f6062b     // Catch: java.lang.Throwable -> L84
            r0 = r0 ^ r1
            if (r0 == 0) goto L6f
            t3.k r0 = r10.A     // Catch: java.lang.Throwable -> L84
            r0.Q(r11, r8, r12)     // Catch: java.lang.Throwable -> L84
        L66:
            monitor-exit(r7)
            if (r13 == 0) goto L6e
            t3.k r11 = r10.A
            r11.flush()
        L6e:
            return r9
        L6f:
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L84
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L84
            r12.<init>(r11)     // Catch: java.lang.Throwable -> L84
            throw r12     // Catch: java.lang.Throwable -> L84
        L7b:
            t3.a r11 = new t3.a     // Catch: java.lang.Throwable -> L81
            r11.<init>()     // Catch: java.lang.Throwable -> L81
            throw r11     // Catch: java.lang.Throwable -> L81
        L81:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L84
            throw r11     // Catch: java.lang.Throwable -> L84
        L84:
            r11 = move-exception
            monitor-exit(r7)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.g.o0(int, java.util.List, boolean):t3.j");
    }

    public final void A0(boolean z4) {
        if (z4) {
            this.A.I();
            this.A.S(this.f6081u);
            if (this.f6081u.c() != 65535) {
                this.A.T(0, r9 - 65535);
            }
        }
        p3.c.d(this.f6069i.k(), this.f6065e, 0L, false, this.B, 6, null);
    }

    public final synchronized void C0(long j4) {
        u3.a.c(this.f6083w, j4, 0L, 2, null);
        long a5 = this.f6083w.a();
        if (a5 >= this.f6081u.c() / 2) {
            I0(0, a5);
            u3.a.c(this.f6083w, 0L, a5, 1, null);
        }
        this.f6080t.b(this.f6083w);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.A.O());
        r6 = r2;
        r8.f6084x += r6;
        r4 = u2.l.f6223a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D0(int r9, boolean r10, b4.d r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            t3.k r12 = r8.A
            r12.J(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L71
            monitor-enter(r8)
        L12:
            long r4 = r8.f6084x     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            long r6 = r8.f6085y     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L37
            java.util.Map<java.lang.Integer, t3.j> r2 = r8.f6064d     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            if (r2 == 0) goto L2f
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.Object"
            e3.f.c(r8, r2)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            r8.wait()     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            goto L12
        L2f:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            throw r9     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
        L37:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L60
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L60
            t3.k r4 = r8.A     // Catch: java.lang.Throwable -> L60
            int r4 = r4.O()     // Catch: java.lang.Throwable -> L60
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L60
            long r4 = r8.f6084x     // Catch: java.lang.Throwable -> L60
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L60
            long r4 = r4 + r6
            r8.f6084x = r4     // Catch: java.lang.Throwable -> L60
            u2.l r4 = u2.l.f6223a     // Catch: java.lang.Throwable -> L60
            monitor-exit(r8)
            long r12 = r12 - r6
            t3.k r4 = r8.A
            if (r10 == 0) goto L5b
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L5b
            r5 = 1
            goto L5c
        L5b:
            r5 = r3
        L5c:
            r4.J(r5, r9, r11, r2)
            goto Ld
        L60:
            r9 = move-exception
            goto L6f
        L62:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L60
            r9.interrupt()     // Catch: java.lang.Throwable -> L60
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L60
            r9.<init>()     // Catch: java.lang.Throwable -> L60
            throw r9     // Catch: java.lang.Throwable -> L60
        L6f:
            monitor-exit(r8)
            throw r9
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.g.D0(int, boolean, b4.d, long):void");
    }

    public final void E0(int i4, boolean z4, List<t3.d> list) {
        e3.f.e(list, "alternating");
        this.A.N(z4, i4, list);
    }

    public final void F0(boolean z4, int i4, int i5) {
        try {
            this.A.P(z4, i4, i5);
        } catch (IOException e4) {
            a0(e4);
        }
    }

    public final void G0(int i4, t3.b bVar) {
        e3.f.e(bVar, "statusCode");
        this.A.R(i4, bVar);
    }

    public final void H0(int i4, t3.b bVar) {
        e3.f.e(bVar, "errorCode");
        p3.c.d(this.f6070j, this.f6065e + '[' + i4 + "] writeSynReset", 0L, false, new k(i4, bVar), 6, null);
    }

    public final void I0(int i4, long j4) {
        p3.c.d(this.f6070j, this.f6065e + '[' + i4 + "] windowUpdate", 0L, false, new l(i4, j4), 6, null);
    }

    public final void Z(t3.b bVar, t3.b bVar2, IOException iOException) {
        int i4;
        e3.f.e(bVar, "connectionCode");
        e3.f.e(bVar2, "streamCode");
        if (s.f5213e && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            z0(bVar);
        } catch (IOException unused) {
        }
        Object[] objArr = null;
        synchronized (this) {
            if (!this.f6064d.isEmpty()) {
                objArr = this.f6064d.values().toArray(new t3.j[0]);
                this.f6064d.clear();
            }
            u2.l lVar = u2.l.f6223a;
        }
        t3.j[] jVarArr = (t3.j[]) objArr;
        if (jVarArr != null) {
            for (t3.j jVar : jVarArr) {
                try {
                    jVar.e(bVar2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.A.close();
        } catch (IOException unused3) {
        }
        try {
            this.f6086z.close();
        } catch (IOException unused4) {
        }
        this.f6070j.q();
        this.f6071k.q();
        this.f6072l.q();
    }

    public final boolean b0() {
        return this.f6062b;
    }

    public final String c0() {
        return this.f6065e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Z(t3.b.f6008d, t3.b.f6016l, null);
    }

    public final t3.c d0() {
        return this.f6080t;
    }

    public final int e0() {
        return this.f6066f;
    }

    public final d f0() {
        return this.f6063c;
    }

    public final void flush() {
        this.A.flush();
    }

    public final int g0() {
        return this.f6067g;
    }

    public final n h0() {
        return this.f6081u;
    }

    public final n i0() {
        return this.f6082v;
    }

    public final synchronized t3.j j0(int i4) {
        return this.f6064d.get(Integer.valueOf(i4));
    }

    public final Map<Integer, t3.j> k0() {
        return this.f6064d;
    }

    public final long l0() {
        return this.f6085y;
    }

    public final t3.k m0() {
        return this.A;
    }

    public final synchronized boolean n0(long j4) {
        if (this.f6068h) {
            return false;
        }
        if (this.f6077q < this.f6076p) {
            if (j4 >= this.f6079s) {
                return false;
            }
        }
        return true;
    }

    public final t3.j p0(List<t3.d> list, boolean z4) {
        e3.f.e(list, "requestHeaders");
        return o0(0, list, z4);
    }

    public final void q0(int i4, b4.f fVar, int i5, boolean z4) {
        e3.f.e(fVar, "source");
        b4.d dVar = new b4.d();
        long j4 = i5;
        fVar.w(j4);
        fVar.u(dVar, j4);
        p3.c.d(this.f6071k, this.f6065e + '[' + i4 + "] onData", 0L, false, new f(i4, dVar, i5, z4), 6, null);
    }

    public final void r0(int i4, List<t3.d> list, boolean z4) {
        e3.f.e(list, "requestHeaders");
        p3.c.d(this.f6071k, this.f6065e + '[' + i4 + "] onHeaders", 0L, false, new C0079g(i4, list, z4), 6, null);
    }

    public final void s0(int i4, List<t3.d> list) {
        e3.f.e(list, "requestHeaders");
        synchronized (this) {
            if (this.C.contains(Integer.valueOf(i4))) {
                H0(i4, t3.b.f6009e);
                return;
            }
            this.C.add(Integer.valueOf(i4));
            p3.c.d(this.f6071k, this.f6065e + '[' + i4 + "] onRequest", 0L, false, new h(i4, list), 6, null);
        }
    }

    public final void t0(int i4, t3.b bVar) {
        e3.f.e(bVar, "errorCode");
        p3.c.d(this.f6071k, this.f6065e + '[' + i4 + "] onReset", 0L, false, new i(i4, bVar), 6, null);
    }

    public final boolean u0(int i4) {
        return i4 != 0 && (i4 & 1) == 0;
    }

    public final synchronized t3.j v0(int i4) {
        t3.j remove;
        remove = this.f6064d.remove(Integer.valueOf(i4));
        e3.f.c(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return remove;
    }

    public final void w0() {
        synchronized (this) {
            long j4 = this.f6077q;
            long j5 = this.f6076p;
            if (j4 < j5) {
                return;
            }
            this.f6076p = j5 + 1;
            this.f6079s = System.nanoTime() + 1000000000;
            u2.l lVar = u2.l.f6223a;
            p3.c.d(this.f6070j, this.f6065e + " ping", 0L, false, new j(), 6, null);
        }
    }

    public final void x0(int i4) {
        this.f6066f = i4;
    }

    public final void y0(n nVar) {
        e3.f.e(nVar, "<set-?>");
        this.f6082v = nVar;
    }

    public final void z0(t3.b bVar) {
        e3.f.e(bVar, "statusCode");
        synchronized (this.A) {
            e3.i iVar = new e3.i();
            synchronized (this) {
                if (this.f6068h) {
                    return;
                }
                this.f6068h = true;
                int i4 = this.f6066f;
                iVar.f3628b = i4;
                u2.l lVar = u2.l.f6223a;
                this.A.M(i4, bVar, p.f5201a);
            }
        }
    }
}
