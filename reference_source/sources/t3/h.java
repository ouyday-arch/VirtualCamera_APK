package t3;

import b4.e0;
import b4.g0;
import b4.h0;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import l3.a0;
import l3.c0;
import l3.u;
import l3.y;
import l3.z;
import m3.s;
import r3.d;

/* loaded from: classes.dex */
public final class h implements r3.d {

    /* renamed from: g, reason: collision with root package name */
    public static final a f6135g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private static final List<String> f6136h = s.j("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: i, reason: collision with root package name */
    private static final List<String> f6137i = s.j("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    private final d.a f6138a;

    /* renamed from: b, reason: collision with root package name */
    private final r3.g f6139b;

    /* renamed from: c, reason: collision with root package name */
    private final g f6140c;

    /* renamed from: d, reason: collision with root package name */
    private volatile j f6141d;

    /* renamed from: e, reason: collision with root package name */
    private final z f6142e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f6143f;

    /* loaded from: classes.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: t3.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0080a extends e3.g implements d3.a<u> {

            /* renamed from: c, reason: collision with root package name */
            public static final C0080a f6144c = new C0080a();

            C0080a() {
                super(0);
            }

            @Override // d3.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public final u d() {
                throw new IllegalStateException("trailers not available".toString());
            }
        }

        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final List<d> a(a0 a0Var) {
            e3.f.e(a0Var, "request");
            u e4 = a0Var.e();
            ArrayList arrayList = new ArrayList(e4.size() + 4);
            arrayList.add(new d(d.f6029g, a0Var.g()));
            arrayList.add(new d(d.f6030h, r3.i.f5877a.c(a0Var.i())));
            String d5 = a0Var.d("Host");
            if (d5 != null) {
                arrayList.add(new d(d.f6032j, d5));
            }
            arrayList.add(new d(d.f6031i, a0Var.i().s()));
            int size = e4.size();
            for (int i4 = 0; i4 < size; i4++) {
                String c5 = e4.c(i4);
                Locale locale = Locale.US;
                e3.f.d(locale, "US");
                String lowerCase = c5.toLowerCase(locale);
                e3.f.d(lowerCase, "toLowerCase(...)");
                if (!h.f6136h.contains(lowerCase) || (e3.f.a(lowerCase, "te") && e3.f.a(e4.e(i4), "trailers"))) {
                    arrayList.add(new d(lowerCase, e4.e(i4)));
                }
            }
            return arrayList;
        }

        public final c0.a b(u uVar, z zVar) {
            e3.f.e(uVar, "headerBlock");
            e3.f.e(zVar, "protocol");
            u.a aVar = new u.a();
            int size = uVar.size();
            r3.k kVar = null;
            for (int i4 = 0; i4 < size; i4++) {
                String c5 = uVar.c(i4);
                String e4 = uVar.e(i4);
                if (e3.f.a(c5, ":status")) {
                    kVar = r3.k.f5880d.a("HTTP/1.1 " + e4);
                } else if (!h.f6137i.contains(c5)) {
                    aVar.c(c5, e4);
                }
            }
            if (kVar != null) {
                return new c0.a().o(zVar).e(kVar.f5882b).l(kVar.f5883c).j(aVar.d()).C(C0080a.f6144c);
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public h(y yVar, d.a aVar, r3.g gVar, g gVar2) {
        e3.f.e(yVar, "client");
        e3.f.e(aVar, "carrier");
        e3.f.e(gVar, "chain");
        e3.f.e(gVar2, "http2Connection");
        this.f6138a = aVar;
        this.f6139b = gVar;
        this.f6140c = gVar2;
        List<z> x4 = yVar.x();
        z zVar = z.f4876h;
        this.f6142e = x4.contains(zVar) ? zVar : z.f4875g;
    }

    @Override // r3.d
    public void a(a0 a0Var) {
        e3.f.e(a0Var, "request");
        if (this.f6141d != null) {
            return;
        }
        this.f6141d = this.f6140c.p0(f6135g.a(a0Var), a0Var.a() != null);
        if (this.f6143f) {
            j jVar = this.f6141d;
            e3.f.b(jVar);
            jVar.g(b.f6016l);
            throw new IOException("Canceled");
        }
        j jVar2 = this.f6141d;
        e3.f.b(jVar2);
        h0 w4 = jVar2.w();
        long i4 = this.f6139b.i();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        w4.g(i4, timeUnit);
        j jVar3 = this.f6141d;
        e3.f.b(jVar3);
        jVar3.E().g(this.f6139b.k(), timeUnit);
    }

    @Override // r3.d
    public u b() {
        j jVar = this.f6141d;
        e3.f.b(jVar);
        return jVar.C();
    }

    @Override // r3.d
    public void c() {
        j jVar = this.f6141d;
        e3.f.b(jVar);
        jVar.o().close();
    }

    @Override // r3.d
    public void cancel() {
        this.f6143f = true;
        j jVar = this.f6141d;
        if (jVar != null) {
            jVar.g(b.f6016l);
        }
    }

    @Override // r3.d
    public e0 d(a0 a0Var, long j4) {
        e3.f.e(a0Var, "request");
        j jVar = this.f6141d;
        e3.f.b(jVar);
        return jVar.o();
    }

    @Override // r3.d
    public void e() {
        this.f6140c.flush();
    }

    @Override // r3.d
    public g0 f(c0 c0Var) {
        e3.f.e(c0Var, "response");
        j jVar = this.f6141d;
        e3.f.b(jVar);
        return jVar.q();
    }

    @Override // r3.d
    public c0.a g(boolean z4) {
        j jVar = this.f6141d;
        if (jVar == null) {
            throw new IOException("stream wasn't created");
        }
        c0.a b5 = f6135g.b(jVar.B(z4), this.f6142e);
        if (z4 && b5.f() == 100) {
            return null;
        }
        return b5;
    }

    @Override // r3.d
    public d.a h() {
        return this.f6138a;
    }

    @Override // r3.d
    public long i(c0 c0Var) {
        e3.f.e(c0Var, "response");
        if (r3.e.b(c0Var)) {
            return s.i(c0Var);
        }
        return 0L;
    }
}
