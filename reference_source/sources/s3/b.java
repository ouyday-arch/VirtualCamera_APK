package s3;

import b4.e0;
import b4.g0;
import b4.h0;
import b4.m;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import l3.a0;
import l3.b0;
import l3.c0;
import l3.u;
import l3.v;
import l3.y;
import m3.p;
import m3.s;
import r3.d;
import r3.i;
import r3.k;

/* loaded from: classes.dex */
public final class b implements r3.d {

    /* renamed from: h, reason: collision with root package name */
    public static final d f5891h = new d(null);

    /* renamed from: a, reason: collision with root package name */
    private final y f5892a;

    /* renamed from: b, reason: collision with root package name */
    private final d.a f5893b;

    /* renamed from: c, reason: collision with root package name */
    private final b4.f f5894c;

    /* renamed from: d, reason: collision with root package name */
    private final b4.e f5895d;

    /* renamed from: e, reason: collision with root package name */
    private int f5896e;

    /* renamed from: f, reason: collision with root package name */
    private final s3.a f5897f;

    /* renamed from: g, reason: collision with root package name */
    private u f5898g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class a implements g0 {

        /* renamed from: b, reason: collision with root package name */
        private final m f5899b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5900c;

        public a() {
            this.f5899b = new m(b.this.f5894c.b());
        }

        public final void I() {
            if (b.this.f5896e == 6) {
                return;
            }
            if (b.this.f5896e == 5) {
                b.this.s(this.f5899b);
                b.this.f5896e = 6;
            } else {
                throw new IllegalStateException("state: " + b.this.f5896e);
            }
        }

        protected final void J(boolean z4) {
            this.f5900c = z4;
        }

        @Override // b4.g0
        public h0 b() {
            return this.f5899b;
        }

        protected final boolean i() {
            return this.f5900c;
        }

        @Override // b4.g0
        public long u(b4.d dVar, long j4) {
            e3.f.e(dVar, "sink");
            try {
                return b.this.f5894c.u(dVar, j4);
            } catch (IOException e4) {
                b.this.h().h();
                I();
                throw e4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s3.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0078b implements e0 {

        /* renamed from: b, reason: collision with root package name */
        private final m f5902b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5903c;

        public C0078b() {
            this.f5902b = new m(b.this.f5895d.b());
        }

        @Override // b4.e0
        public void F(b4.d dVar, long j4) {
            e3.f.e(dVar, "source");
            if (!(!this.f5903c)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j4 == 0) {
                return;
            }
            b.this.f5895d.j(j4);
            b.this.f5895d.x("\r\n");
            b.this.f5895d.F(dVar, j4);
            b.this.f5895d.x("\r\n");
        }

        @Override // b4.e0
        public h0 b() {
            return this.f5902b;
        }

        @Override // b4.e0, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f5903c) {
                return;
            }
            this.f5903c = true;
            b.this.f5895d.x("0\r\n\r\n");
            b.this.s(this.f5902b);
            b.this.f5896e = 3;
        }

        @Override // b4.e0, java.io.Flushable
        public synchronized void flush() {
            if (this.f5903c) {
                return;
            }
            b.this.f5895d.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c extends a {

        /* renamed from: e, reason: collision with root package name */
        private final v f5905e;

        /* renamed from: f, reason: collision with root package name */
        private long f5906f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f5907g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f5908h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, v vVar) {
            super();
            e3.f.e(vVar, "url");
            this.f5908h = bVar;
            this.f5905e = vVar;
            this.f5906f = -1L;
            this.f5907g = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x004b, code lost:
        
            if (r1 != false) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void K() {
            /*
                r7 = this;
                long r0 = r7.f5906f
                r2 = -1
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 == 0) goto L11
                s3.b r0 = r7.f5908h
                b4.f r0 = s3.b.n(r0)
                r0.v()
            L11:
                s3.b r0 = r7.f5908h     // Catch: java.lang.NumberFormatException -> La2
                b4.f r0 = s3.b.n(r0)     // Catch: java.lang.NumberFormatException -> La2
                long r0 = r0.D()     // Catch: java.lang.NumberFormatException -> La2
                r7.f5906f = r0     // Catch: java.lang.NumberFormatException -> La2
                s3.b r0 = r7.f5908h     // Catch: java.lang.NumberFormatException -> La2
                b4.f r0 = s3.b.n(r0)     // Catch: java.lang.NumberFormatException -> La2
                java.lang.String r0 = r0.v()     // Catch: java.lang.NumberFormatException -> La2
                java.lang.CharSequence r0 = j3.l.o0(r0)     // Catch: java.lang.NumberFormatException -> La2
                java.lang.String r0 = r0.toString()     // Catch: java.lang.NumberFormatException -> La2
                long r1 = r7.f5906f     // Catch: java.lang.NumberFormatException -> La2
                r3 = 0
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 < 0) goto L81
                int r1 = r0.length()     // Catch: java.lang.NumberFormatException -> La2
                r2 = 0
                if (r1 <= 0) goto L40
                r1 = 1
                goto L41
            L40:
                r1 = r2
            L41:
                if (r1 == 0) goto L4d
                java.lang.String r1 = ";"
                r5 = 2
                r6 = 0
                boolean r1 = j3.l.x(r0, r1, r2, r5, r6)     // Catch: java.lang.NumberFormatException -> La2
                if (r1 == 0) goto L81
            L4d:
                long r0 = r7.f5906f
                int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r0 != 0) goto L80
                r7.f5907g = r2
                s3.b r0 = r7.f5908h
                s3.a r1 = s3.b.l(r0)
                l3.u r1 = r1.a()
                s3.b.r(r0, r1)
                s3.b r0 = r7.f5908h
                l3.y r0 = s3.b.k(r0)
                e3.f.b(r0)
                l3.o r0 = r0.j()
                l3.v r1 = r7.f5905e
                s3.b r2 = r7.f5908h
                l3.u r2 = s3.b.p(r2)
                e3.f.b(r2)
                r3.e.f(r0, r1, r2)
                r7.I()
            L80:
                return
            L81:
                java.net.ProtocolException r1 = new java.net.ProtocolException     // Catch: java.lang.NumberFormatException -> La2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> La2
                r2.<init>()     // Catch: java.lang.NumberFormatException -> La2
                java.lang.String r3 = "expected chunk size and optional extensions but was \""
                r2.append(r3)     // Catch: java.lang.NumberFormatException -> La2
                long r3 = r7.f5906f     // Catch: java.lang.NumberFormatException -> La2
                r2.append(r3)     // Catch: java.lang.NumberFormatException -> La2
                r2.append(r0)     // Catch: java.lang.NumberFormatException -> La2
                r0 = 34
                r2.append(r0)     // Catch: java.lang.NumberFormatException -> La2
                java.lang.String r0 = r2.toString()     // Catch: java.lang.NumberFormatException -> La2
                r1.<init>(r0)     // Catch: java.lang.NumberFormatException -> La2
                throw r1     // Catch: java.lang.NumberFormatException -> La2
            La2:
                r0 = move-exception
                java.net.ProtocolException r1 = new java.net.ProtocolException
                java.lang.String r0 = r0.getMessage()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: s3.b.c.K():void");
        }

        @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            if (i()) {
                return;
            }
            if (this.f5907g && !s.g(this, 100, TimeUnit.MILLISECONDS)) {
                this.f5908h.h().h();
                I();
            }
            J(true);
        }

        @Override // s3.b.a, b4.g0
        public long u(b4.d dVar, long j4) {
            e3.f.e(dVar, "sink");
            if (!(j4 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
            }
            if (!(!i())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f5907g) {
                return -1L;
            }
            long j5 = this.f5906f;
            if (j5 == 0 || j5 == -1) {
                K();
                if (!this.f5907g) {
                    return -1L;
                }
            }
            long u4 = super.u(dVar, Math.min(j4, this.f5906f));
            if (u4 != -1) {
                this.f5906f -= u4;
                return u4;
            }
            this.f5908h.h().h();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            I();
            throw protocolException;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(e3.d dVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class e extends a {

        /* renamed from: e, reason: collision with root package name */
        private long f5909e;

        public e(long j4) {
            super();
            this.f5909e = j4;
            if (j4 == 0) {
                I();
            }
        }

        @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            if (i()) {
                return;
            }
            if (this.f5909e != 0 && !s.g(this, 100, TimeUnit.MILLISECONDS)) {
                b.this.h().h();
                I();
            }
            J(true);
        }

        @Override // s3.b.a, b4.g0
        public long u(b4.d dVar, long j4) {
            e3.f.e(dVar, "sink");
            if (!(j4 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
            }
            if (!(!i())) {
                throw new IllegalStateException("closed".toString());
            }
            long j5 = this.f5909e;
            if (j5 == 0) {
                return -1L;
            }
            long u4 = super.u(dVar, Math.min(j5, j4));
            if (u4 == -1) {
                b.this.h().h();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                I();
                throw protocolException;
            }
            long j6 = this.f5909e - u4;
            this.f5909e = j6;
            if (j6 == 0) {
                I();
            }
            return u4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class f implements e0 {

        /* renamed from: b, reason: collision with root package name */
        private final m f5911b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5912c;

        public f() {
            this.f5911b = new m(b.this.f5895d.b());
        }

        @Override // b4.e0
        public void F(b4.d dVar, long j4) {
            e3.f.e(dVar, "source");
            if (!(!this.f5912c)) {
                throw new IllegalStateException("closed".toString());
            }
            p.e(dVar.c0(), 0L, j4);
            b.this.f5895d.F(dVar, j4);
        }

        @Override // b4.e0
        public h0 b() {
            return this.f5911b;
        }

        @Override // b4.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5912c) {
                return;
            }
            this.f5912c = true;
            b.this.s(this.f5911b);
            b.this.f5896e = 3;
        }

        @Override // b4.e0, java.io.Flushable
        public void flush() {
            if (this.f5912c) {
                return;
            }
            b.this.f5895d.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class g extends a {

        /* renamed from: e, reason: collision with root package name */
        private boolean f5914e;

        public g() {
            super();
        }

        @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            if (i()) {
                return;
            }
            if (!this.f5914e) {
                I();
            }
            J(true);
        }

        @Override // s3.b.a, b4.g0
        public long u(b4.d dVar, long j4) {
            e3.f.e(dVar, "sink");
            if (!(j4 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
            }
            if (!(!i())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f5914e) {
                return -1L;
            }
            long u4 = super.u(dVar, j4);
            if (u4 != -1) {
                return u4;
            }
            this.f5914e = true;
            I();
            return -1L;
        }
    }

    /* loaded from: classes.dex */
    static final class h extends e3.g implements d3.a<u> {

        /* renamed from: c, reason: collision with root package name */
        public static final h f5916c = new h();

        h() {
            super(0);
        }

        @Override // d3.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final u d() {
            throw new IllegalStateException("trailers not available".toString());
        }
    }

    public b(y yVar, d.a aVar, b4.f fVar, b4.e eVar) {
        e3.f.e(aVar, "carrier");
        e3.f.e(fVar, "source");
        e3.f.e(eVar, "sink");
        this.f5892a = yVar;
        this.f5893b = aVar;
        this.f5894c = fVar;
        this.f5895d = eVar;
        this.f5897f = new s3.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(m mVar) {
        h0 i4 = mVar.i();
        mVar.j(h0.f2350e);
        i4.a();
        i4.b();
    }

    private final boolean t(a0 a0Var) {
        boolean l4;
        l4 = j3.u.l("chunked", a0Var.d("Transfer-Encoding"), true);
        return l4;
    }

    private final boolean u(c0 c0Var) {
        boolean l4;
        l4 = j3.u.l("chunked", c0.R(c0Var, "Transfer-Encoding", null, 2, null), true);
        return l4;
    }

    private final e0 v() {
        if (this.f5896e == 1) {
            this.f5896e = 2;
            return new C0078b();
        }
        throw new IllegalStateException(("state: " + this.f5896e).toString());
    }

    private final g0 w(v vVar) {
        if (this.f5896e == 4) {
            this.f5896e = 5;
            return new c(this, vVar);
        }
        throw new IllegalStateException(("state: " + this.f5896e).toString());
    }

    private final g0 x(long j4) {
        if (this.f5896e == 4) {
            this.f5896e = 5;
            return new e(j4);
        }
        throw new IllegalStateException(("state: " + this.f5896e).toString());
    }

    private final e0 y() {
        if (this.f5896e == 1) {
            this.f5896e = 2;
            return new f();
        }
        throw new IllegalStateException(("state: " + this.f5896e).toString());
    }

    private final g0 z() {
        if (this.f5896e == 4) {
            this.f5896e = 5;
            h().h();
            return new g();
        }
        throw new IllegalStateException(("state: " + this.f5896e).toString());
    }

    public final void A(c0 c0Var) {
        e3.f.e(c0Var, "response");
        long i4 = s.i(c0Var);
        if (i4 == -1) {
            return;
        }
        g0 x4 = x(i4);
        s.m(x4, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        x4.close();
    }

    public final void B(u uVar, String str) {
        e3.f.e(uVar, "headers");
        e3.f.e(str, "requestLine");
        if (!(this.f5896e == 0)) {
            throw new IllegalStateException(("state: " + this.f5896e).toString());
        }
        this.f5895d.x(str).x("\r\n");
        int size = uVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f5895d.x(uVar.c(i4)).x(": ").x(uVar.e(i4)).x("\r\n");
        }
        this.f5895d.x("\r\n");
        this.f5896e = 1;
    }

    @Override // r3.d
    public void a(a0 a0Var) {
        e3.f.e(a0Var, "request");
        i iVar = i.f5877a;
        Proxy.Type type = h().c().b().type();
        e3.f.d(type, "type(...)");
        B(a0Var.e(), iVar.a(a0Var, type));
    }

    @Override // r3.d
    public u b() {
        if (!(this.f5896e == 6)) {
            throw new IllegalStateException("too early; can't read the trailers yet".toString());
        }
        u uVar = this.f5898g;
        return uVar == null ? s.f5209a : uVar;
    }

    @Override // r3.d
    public void c() {
        this.f5895d.flush();
    }

    @Override // r3.d
    public void cancel() {
        h().cancel();
    }

    @Override // r3.d
    public e0 d(a0 a0Var, long j4) {
        e3.f.e(a0Var, "request");
        b0 a5 = a0Var.a();
        if (a5 != null && a5.d()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (t(a0Var)) {
            return v();
        }
        if (j4 != -1) {
            return y();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // r3.d
    public void e() {
        this.f5895d.flush();
    }

    @Override // r3.d
    public g0 f(c0 c0Var) {
        long i4;
        e3.f.e(c0Var, "response");
        if (!r3.e.b(c0Var)) {
            i4 = 0;
        } else {
            if (u(c0Var)) {
                return w(c0Var.Z().i());
            }
            i4 = s.i(c0Var);
            if (i4 == -1) {
                return z();
            }
        }
        return x(i4);
    }

    @Override // r3.d
    public c0.a g(boolean z4) {
        int i4 = this.f5896e;
        boolean z5 = false;
        if (!(i4 == 1 || i4 == 2 || i4 == 3)) {
            throw new IllegalStateException(("state: " + this.f5896e).toString());
        }
        try {
            k a5 = k.f5880d.a(this.f5897f.b());
            c0.a C = new c0.a().o(a5.f5881a).e(a5.f5882b).l(a5.f5883c).j(this.f5897f.a()).C(h.f5916c);
            if (z4 && a5.f5882b == 100) {
                return null;
            }
            int i5 = a5.f5882b;
            if (i5 != 100) {
                if (102 <= i5 && i5 < 200) {
                    z5 = true;
                }
                if (!z5) {
                    this.f5896e = 4;
                    return C;
                }
            }
            this.f5896e = 3;
            return C;
        } catch (EOFException e4) {
            throw new IOException("unexpected end of stream on " + h().c().a().l().q(), e4);
        }
    }

    @Override // r3.d
    public d.a h() {
        return this.f5893b;
    }

    @Override // r3.d
    public long i(c0 c0Var) {
        e3.f.e(c0Var, "response");
        if (!r3.e.b(c0Var)) {
            return 0L;
        }
        if (u(c0Var)) {
            return -1L;
        }
        return s.i(c0Var);
    }
}
