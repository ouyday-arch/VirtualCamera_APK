package q3;

import b4.e0;
import b4.g0;
import b4.t;
import java.io.IOException;
import java.net.ProtocolException;
import l3.a0;
import l3.b0;
import l3.c0;
import l3.d0;
import l3.s;
import l3.u;
import r3.d;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final h f5647a;

    /* renamed from: b, reason: collision with root package name */
    private final s f5648b;

    /* renamed from: c, reason: collision with root package name */
    private final d f5649c;

    /* renamed from: d, reason: collision with root package name */
    private final r3.d f5650d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5651e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5652f;

    /* loaded from: classes.dex */
    private final class a extends b4.k {

        /* renamed from: c, reason: collision with root package name */
        private final long f5653c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5654d;

        /* renamed from: e, reason: collision with root package name */
        private long f5655e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f5656f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f5657g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, e0 e0Var, long j4) {
            super(e0Var);
            e3.f.e(e0Var, "delegate");
            this.f5657g = cVar;
            this.f5653c = j4;
        }

        private final <E extends IOException> E i(E e4) {
            if (this.f5654d) {
                return e4;
            }
            this.f5654d = true;
            return (E) this.f5657g.a(this.f5655e, false, true, e4);
        }

        @Override // b4.k, b4.e0
        public void F(b4.d dVar, long j4) {
            e3.f.e(dVar, "source");
            if (!(!this.f5656f)) {
                throw new IllegalStateException("closed".toString());
            }
            long j5 = this.f5653c;
            if (j5 == -1 || this.f5655e + j4 <= j5) {
                try {
                    super.F(dVar, j4);
                    this.f5655e += j4;
                    return;
                } catch (IOException e4) {
                    throw i(e4);
                }
            }
            throw new ProtocolException("expected " + this.f5653c + " bytes but received " + (this.f5655e + j4));
        }

        @Override // b4.k, b4.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5656f) {
                return;
            }
            this.f5656f = true;
            long j4 = this.f5653c;
            if (j4 != -1 && this.f5655e != j4) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                i(null);
            } catch (IOException e4) {
                throw i(e4);
            }
        }

        @Override // b4.k, b4.e0, java.io.Flushable
        public void flush() {
            try {
                super.flush();
            } catch (IOException e4) {
                throw i(e4);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class b extends b4.l {

        /* renamed from: c, reason: collision with root package name */
        private final long f5658c;

        /* renamed from: d, reason: collision with root package name */
        private long f5659d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f5660e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f5661f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f5662g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f5663h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, g0 g0Var, long j4) {
            super(g0Var);
            e3.f.e(g0Var, "delegate");
            this.f5663h = cVar;
            this.f5658c = j4;
            this.f5660e = true;
            if (j4 == 0) {
                I(null);
            }
        }

        public final <E extends IOException> E I(E e4) {
            if (this.f5661f) {
                return e4;
            }
            this.f5661f = true;
            if (e4 == null && this.f5660e) {
                this.f5660e = false;
                this.f5663h.i().v(this.f5663h.g());
            }
            return (E) this.f5663h.a(this.f5659d, true, false, e4);
        }

        @Override // b4.l, b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            if (this.f5662g) {
                return;
            }
            this.f5662g = true;
            try {
                super.close();
                I(null);
            } catch (IOException e4) {
                throw I(e4);
            }
        }

        @Override // b4.l, b4.g0
        public long u(b4.d dVar, long j4) {
            e3.f.e(dVar, "sink");
            if (!(!this.f5662g)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long u4 = i().u(dVar, j4);
                if (this.f5660e) {
                    this.f5660e = false;
                    this.f5663h.i().v(this.f5663h.g());
                }
                if (u4 == -1) {
                    I(null);
                    return -1L;
                }
                long j5 = this.f5659d + u4;
                long j6 = this.f5658c;
                if (j6 != -1 && j5 > j6) {
                    throw new ProtocolException("expected " + this.f5658c + " bytes but received " + j5);
                }
                this.f5659d = j5;
                if (j5 == j6) {
                    I(null);
                }
                return u4;
            } catch (IOException e4) {
                throw I(e4);
            }
        }
    }

    public c(h hVar, s sVar, d dVar, r3.d dVar2) {
        e3.f.e(hVar, "call");
        e3.f.e(sVar, "eventListener");
        e3.f.e(dVar, "finder");
        e3.f.e(dVar2, "codec");
        this.f5647a = hVar;
        this.f5648b = sVar;
        this.f5649c = dVar;
        this.f5650d = dVar2;
    }

    private final void t(IOException iOException) {
        this.f5652f = true;
        this.f5650d.h().g(this.f5647a, iOException);
    }

    public final <E extends IOException> E a(long j4, boolean z4, boolean z5, E e4) {
        if (e4 != null) {
            t(e4);
        }
        if (z5) {
            s sVar = this.f5648b;
            h hVar = this.f5647a;
            if (e4 != null) {
                sVar.r(hVar, e4);
            } else {
                sVar.p(hVar, j4);
            }
        }
        if (z4) {
            if (e4 != null) {
                this.f5648b.w(this.f5647a, e4);
            } else {
                this.f5648b.u(this.f5647a, j4);
            }
        }
        return (E) this.f5647a.v(this, z5, z4, e4);
    }

    public final void b() {
        this.f5650d.cancel();
    }

    public final e0 c(a0 a0Var, boolean z4) {
        e3.f.e(a0Var, "request");
        this.f5651e = z4;
        b0 a5 = a0Var.a();
        e3.f.b(a5);
        long a6 = a5.a();
        this.f5648b.q(this.f5647a);
        return new a(this, this.f5650d.d(a0Var, a6), a6);
    }

    public final void d() {
        this.f5650d.cancel();
        this.f5647a.v(this, true, true, null);
    }

    public final void e() {
        try {
            this.f5650d.c();
        } catch (IOException e4) {
            this.f5648b.r(this.f5647a, e4);
            t(e4);
            throw e4;
        }
    }

    public final void f() {
        try {
            this.f5650d.e();
        } catch (IOException e4) {
            this.f5648b.r(this.f5647a, e4);
            t(e4);
            throw e4;
        }
    }

    public final h g() {
        return this.f5647a;
    }

    public final i h() {
        d.a h4 = this.f5650d.h();
        i iVar = h4 instanceof i ? (i) h4 : null;
        if (iVar != null) {
            return iVar;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels".toString());
    }

    public final s i() {
        return this.f5648b;
    }

    public final d j() {
        return this.f5649c;
    }

    public final boolean k() {
        return this.f5652f;
    }

    public final boolean l() {
        return !e3.f.a(this.f5649c.b().e().l().j(), this.f5650d.h().c().a().l().j());
    }

    public final boolean m() {
        return this.f5651e;
    }

    public final void n() {
        this.f5650d.h().h();
    }

    public final void o() {
        this.f5647a.v(this, true, false, null);
    }

    public final d0 p(c0 c0Var) {
        e3.f.e(c0Var, "response");
        try {
            String R = c0.R(c0Var, "Content-Type", null, 2, null);
            long i4 = this.f5650d.i(c0Var);
            return new r3.h(R, i4, t.b(new b(this, this.f5650d.f(c0Var), i4)));
        } catch (IOException e4) {
            this.f5648b.w(this.f5647a, e4);
            t(e4);
            throw e4;
        }
    }

    public final c0.a q(boolean z4) {
        try {
            c0.a g4 = this.f5650d.g(z4);
            if (g4 != null) {
                g4.k(this);
            }
            return g4;
        } catch (IOException e4) {
            this.f5648b.w(this.f5647a, e4);
            t(e4);
            throw e4;
        }
    }

    public final void r(c0 c0Var) {
        e3.f.e(c0Var, "response");
        this.f5648b.x(this.f5647a, c0Var);
    }

    public final void s() {
        this.f5648b.y(this.f5647a);
    }

    public final u u() {
        return this.f5650d.b();
    }

    public final void v(a0 a0Var) {
        e3.f.e(a0Var, "request");
        try {
            this.f5648b.t(this.f5647a);
            this.f5650d.a(a0Var);
            this.f5648b.s(this.f5647a, a0Var);
        } catch (IOException e4) {
            this.f5648b.r(this.f5647a, e4);
            t(e4);
            throw e4;
        }
    }
}
