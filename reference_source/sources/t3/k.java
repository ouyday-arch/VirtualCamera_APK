package t3;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import m3.p;
import m3.s;
import t3.e;

/* loaded from: classes.dex */
public final class k implements Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final a f6184h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final Logger f6185i = Logger.getLogger(f.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private final b4.e f6186b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6187c;

    /* renamed from: d, reason: collision with root package name */
    private final b4.d f6188d;

    /* renamed from: e, reason: collision with root package name */
    private int f6189e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6190f;

    /* renamed from: g, reason: collision with root package name */
    private final e.b f6191g;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    public k(b4.e eVar, boolean z4) {
        e3.f.e(eVar, "sink");
        this.f6186b = eVar;
        this.f6187c = z4;
        b4.d dVar = new b4.d();
        this.f6188d = dVar;
        this.f6189e = 16384;
        this.f6191g = new e.b(0, false, dVar, 3, null);
    }

    private final void U(int i4, long j4) {
        while (j4 > 0) {
            long min = Math.min(this.f6189e, j4);
            j4 -= min;
            L(i4, (int) min, 9, j4 == 0 ? 4 : 0);
            this.f6186b.F(this.f6188d, min);
        }
    }

    public final synchronized void I() {
        if (this.f6190f) {
            throw new IOException("closed");
        }
        if (this.f6187c) {
            Logger logger = f6185i;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(s.h(">> CONNECTION " + f.f6058b.j(), new Object[0]));
            }
            this.f6186b.A(f.f6058b);
            this.f6186b.flush();
        }
    }

    public final synchronized void J(boolean z4, int i4, b4.d dVar, int i5) {
        if (this.f6190f) {
            throw new IOException("closed");
        }
        K(i4, z4 ? 1 : 0, dVar, i5);
    }

    public final void K(int i4, int i5, b4.d dVar, int i6) {
        L(i4, i6, 0, i5);
        if (i6 > 0) {
            b4.e eVar = this.f6186b;
            e3.f.b(dVar);
            eVar.F(dVar, i6);
        }
    }

    public final void L(int i4, int i5, int i6, int i7) {
        if (i6 != 8) {
            Logger logger = f6185i;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(f.f6057a.c(false, i4, i5, i6, i7));
            }
        }
        if (!(i5 <= this.f6189e)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f6189e + ": " + i5).toString());
        }
        if (!((Integer.MIN_VALUE & i4) == 0)) {
            throw new IllegalArgumentException(("reserved bit set: " + i4).toString());
        }
        p.I(this.f6186b, i5);
        this.f6186b.B(i6 & 255);
        this.f6186b.B(i7 & 255);
        this.f6186b.t(i4 & Integer.MAX_VALUE);
    }

    public final synchronized void M(int i4, b bVar, byte[] bArr) {
        e3.f.e(bVar, "errorCode");
        e3.f.e(bArr, "debugData");
        if (this.f6190f) {
            throw new IOException("closed");
        }
        if (!(bVar.b() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        L(0, bArr.length + 8, 7, 0);
        this.f6186b.t(i4);
        this.f6186b.t(bVar.b());
        if (!(bArr.length == 0)) {
            this.f6186b.c(bArr);
        }
        this.f6186b.flush();
    }

    public final synchronized void N(boolean z4, int i4, List<d> list) {
        e3.f.e(list, "headerBlock");
        if (this.f6190f) {
            throw new IOException("closed");
        }
        this.f6191g.g(list);
        long c02 = this.f6188d.c0();
        long min = Math.min(this.f6189e, c02);
        int i5 = c02 == min ? 4 : 0;
        if (z4) {
            i5 |= 1;
        }
        L(i4, (int) min, 1, i5);
        this.f6186b.F(this.f6188d, min);
        if (c02 > min) {
            U(i4, c02 - min);
        }
    }

    public final int O() {
        return this.f6189e;
    }

    public final synchronized void P(boolean z4, int i4, int i5) {
        if (this.f6190f) {
            throw new IOException("closed");
        }
        L(0, 8, 6, z4 ? 1 : 0);
        this.f6186b.t(i4);
        this.f6186b.t(i5);
        this.f6186b.flush();
    }

    public final synchronized void Q(int i4, int i5, List<d> list) {
        e3.f.e(list, "requestHeaders");
        if (this.f6190f) {
            throw new IOException("closed");
        }
        this.f6191g.g(list);
        long c02 = this.f6188d.c0();
        int min = (int) Math.min(this.f6189e - 4, c02);
        long j4 = min;
        L(i4, min + 4, 5, c02 == j4 ? 4 : 0);
        this.f6186b.t(i5 & Integer.MAX_VALUE);
        this.f6186b.F(this.f6188d, j4);
        if (c02 > j4) {
            U(i4, c02 - j4);
        }
    }

    public final synchronized void R(int i4, b bVar) {
        e3.f.e(bVar, "errorCode");
        if (this.f6190f) {
            throw new IOException("closed");
        }
        if (!(bVar.b() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        L(i4, 4, 3, 0);
        this.f6186b.t(bVar.b());
        this.f6186b.flush();
    }

    public final synchronized void S(n nVar) {
        e3.f.e(nVar, "settings");
        if (this.f6190f) {
            throw new IOException("closed");
        }
        int i4 = 0;
        L(0, nVar.i() * 6, 4, 0);
        while (i4 < 10) {
            if (nVar.f(i4)) {
                this.f6186b.q(i4 != 4 ? i4 != 7 ? i4 : 4 : 3);
                this.f6186b.t(nVar.a(i4));
            }
            i4++;
        }
        this.f6186b.flush();
    }

    public final synchronized void T(int i4, long j4) {
        if (this.f6190f) {
            throw new IOException("closed");
        }
        if (!(j4 != 0 && j4 <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j4).toString());
        }
        Logger logger = f6185i;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(f.f6057a.d(false, i4, 4, j4));
        }
        L(i4, 4, 8, 0);
        this.f6186b.t((int) j4);
        this.f6186b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f6190f = true;
        this.f6186b.close();
    }

    public final synchronized void flush() {
        if (this.f6190f) {
            throw new IOException("closed");
        }
        this.f6186b.flush();
    }

    public final synchronized void i(n nVar) {
        e3.f.e(nVar, "peerSettings");
        if (this.f6190f) {
            throw new IOException("closed");
        }
        this.f6189e = nVar.e(this.f6189e);
        if (nVar.b() != -1) {
            this.f6191g.e(nVar.b());
        }
        L(0, 0, 4, 1);
        this.f6186b.flush();
    }
}
