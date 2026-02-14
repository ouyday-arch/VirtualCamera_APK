package t3;

import b4.g0;
import b4.h0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import m3.p;
import m3.s;
import t3.e;

/* loaded from: classes.dex */
public final class i implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static final a f6145f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Logger f6146g;

    /* renamed from: b, reason: collision with root package name */
    private final b4.f f6147b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6148c;

    /* renamed from: d, reason: collision with root package name */
    private final b f6149d;

    /* renamed from: e, reason: collision with root package name */
    private final e.a f6150e;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final Logger a() {
            return i.f6146g;
        }

        public final int b(int i4, int i5, int i6) {
            if ((i5 & 8) != 0) {
                i4--;
            }
            if (i6 <= i4) {
                return i4 - i6;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i6 + " > remaining length " + i4);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements g0 {

        /* renamed from: b, reason: collision with root package name */
        private final b4.f f6151b;

        /* renamed from: c, reason: collision with root package name */
        private int f6152c;

        /* renamed from: d, reason: collision with root package name */
        private int f6153d;

        /* renamed from: e, reason: collision with root package name */
        private int f6154e;

        /* renamed from: f, reason: collision with root package name */
        private int f6155f;

        /* renamed from: g, reason: collision with root package name */
        private int f6156g;

        public b(b4.f fVar) {
            e3.f.e(fVar, "source");
            this.f6151b = fVar;
        }

        private final void I() {
            int i4 = this.f6154e;
            int B = p.B(this.f6151b);
            this.f6155f = B;
            this.f6152c = B;
            int b5 = p.b(this.f6151b.H(), 255);
            this.f6153d = p.b(this.f6151b.H(), 255);
            a aVar = i.f6145f;
            if (aVar.a().isLoggable(Level.FINE)) {
                aVar.a().fine(f.f6057a.c(true, this.f6154e, this.f6152c, b5, this.f6153d));
            }
            int s4 = this.f6151b.s() & Integer.MAX_VALUE;
            this.f6154e = s4;
            if (b5 == 9) {
                if (s4 != i4) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(b5 + " != TYPE_CONTINUATION");
            }
        }

        public final void J(int i4) {
            this.f6153d = i4;
        }

        public final void K(int i4) {
            this.f6155f = i4;
        }

        public final void L(int i4) {
            this.f6152c = i4;
        }

        public final void M(int i4) {
            this.f6156g = i4;
        }

        public final void N(int i4) {
            this.f6154e = i4;
        }

        @Override // b4.g0
        public h0 b() {
            return this.f6151b.b();
        }

        @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
        }

        public final int i() {
            return this.f6155f;
        }

        @Override // b4.g0
        public long u(b4.d dVar, long j4) {
            e3.f.e(dVar, "sink");
            while (true) {
                int i4 = this.f6155f;
                if (i4 != 0) {
                    long u4 = this.f6151b.u(dVar, Math.min(j4, i4));
                    if (u4 == -1) {
                        return -1L;
                    }
                    this.f6155f -= (int) u4;
                    return u4;
                }
                this.f6151b.o(this.f6156g);
                this.f6156g = 0;
                if ((this.f6153d & 4) != 0) {
                    return -1L;
                }
                I();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(int i4, t3.b bVar, b4.g gVar);

        void b(boolean z4, int i4, int i5, List<d> list);

        void c(boolean z4, int i4, b4.f fVar, int i5);

        void e(int i4, t3.b bVar);

        void f();

        void g(int i4, long j4);

        void h(int i4, int i5, List<d> list);

        void i(boolean z4, int i4, int i5);

        void j(int i4, int i5, int i6, boolean z4);

        void k(boolean z4, n nVar);
    }

    static {
        Logger logger = Logger.getLogger(f.class.getName());
        e3.f.d(logger, "getLogger(...)");
        f6146g = logger;
    }

    public i(b4.f fVar, boolean z4) {
        e3.f.e(fVar, "source");
        this.f6147b = fVar;
        this.f6148c = z4;
        b bVar = new b(fVar);
        this.f6149d = bVar;
        this.f6150e = new e.a(bVar, 4096, 0, 4, null);
    }

    private final void K(c cVar, int i4, int i5, int i6) {
        if (i6 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z4 = (i5 & 1) != 0;
        if ((i5 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int b5 = (i5 & 8) != 0 ? p.b(this.f6147b.H(), 255) : 0;
        cVar.c(z4, i6, this.f6147b, f6145f.b(i4, i5, b5));
        this.f6147b.o(b5);
    }

    private final void L(c cVar, int i4, int i5, int i6) {
        if (i4 < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i4);
        }
        if (i6 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int s4 = this.f6147b.s();
        int s5 = this.f6147b.s();
        int i7 = i4 - 8;
        t3.b a5 = t3.b.f6007c.a(s5);
        if (a5 == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + s5);
        }
        b4.g gVar = b4.g.f2338f;
        if (i7 > 0) {
            gVar = this.f6147b.l(i7);
        }
        cVar.a(s4, a5, gVar);
    }

    private final List<d> M(int i4, int i5, int i6, int i7) {
        this.f6149d.K(i4);
        b bVar = this.f6149d;
        bVar.L(bVar.i());
        this.f6149d.M(i5);
        this.f6149d.J(i6);
        this.f6149d.N(i7);
        this.f6150e.k();
        return this.f6150e.e();
    }

    private final void N(c cVar, int i4, int i5, int i6) {
        if (i6 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z4 = (i5 & 1) != 0;
        int b5 = (i5 & 8) != 0 ? p.b(this.f6147b.H(), 255) : 0;
        if ((i5 & 32) != 0) {
            P(cVar, i6);
            i4 -= 5;
        }
        cVar.b(z4, i6, -1, M(f6145f.b(i4, i5, b5), b5, i5, i6));
    }

    private final void O(c cVar, int i4, int i5, int i6) {
        if (i4 != 8) {
            throw new IOException("TYPE_PING length != 8: " + i4);
        }
        if (i6 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        cVar.i((i5 & 1) != 0, this.f6147b.s(), this.f6147b.s());
    }

    private final void P(c cVar, int i4) {
        int s4 = this.f6147b.s();
        cVar.j(i4, s4 & Integer.MAX_VALUE, p.b(this.f6147b.H(), 255) + 1, (Integer.MIN_VALUE & s4) != 0);
    }

    private final void Q(c cVar, int i4, int i5, int i6) {
        if (i4 == 5) {
            if (i6 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            P(cVar, i6);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i4 + " != 5");
        }
    }

    private final void R(c cVar, int i4, int i5, int i6) {
        if (i6 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int b5 = (i5 & 8) != 0 ? p.b(this.f6147b.H(), 255) : 0;
        cVar.h(i6, this.f6147b.s() & Integer.MAX_VALUE, M(f6145f.b(i4 - 4, i5, b5), b5, i5, i6));
    }

    private final void S(c cVar, int i4, int i5, int i6) {
        if (i4 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i4 + " != 4");
        }
        if (i6 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int s4 = this.f6147b.s();
        t3.b a5 = t3.b.f6007c.a(s4);
        if (a5 != null) {
            cVar.e(i6, a5);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + s4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
    
        throw new java.io.IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void T(t3.i.c r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            if (r11 != 0) goto Lb9
            r11 = 1
            r10 = r10 & r11
            if (r10 == 0) goto L14
            if (r9 != 0) goto Lc
            r8.f()
            return
        Lc:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "FRAME_SIZE_ERROR ack frame should be empty!"
            r8.<init>(r9)
            throw r8
        L14:
            int r10 = r9 % 6
            if (r10 != 0) goto La2
            t3.n r10 = new t3.n
            r10.<init>()
            r0 = 0
            g3.f r9 = g3.j.h(r0, r9)
            r1 = 6
            g3.d r9 = g3.j.g(r9, r1)
            int r1 = r9.a()
            int r2 = r9.b()
            int r9 = r9.c()
            if (r9 <= 0) goto L37
            if (r1 <= r2) goto L3b
        L37:
            if (r9 >= 0) goto L9e
            if (r2 > r1) goto L9e
        L3b:
            b4.f r3 = r7.f6147b
            short r3 = r3.p()
            r4 = 65535(0xffff, float:9.1834E-41)
            int r3 = m3.p.c(r3, r4)
            b4.f r4 = r7.f6147b
            int r4 = r4.s()
            r5 = 2
            r6 = 4
            if (r3 == r5) goto L8a
            r5 = 3
            if (r3 == r5) goto L88
            if (r3 == r6) goto L7c
            r5 = 5
            if (r3 == r5) goto L5b
            goto L97
        L5b:
            r5 = 16384(0x4000, float:2.2959E-41)
            if (r4 < r5) goto L65
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            if (r4 > r5) goto L65
            goto L97
        L65:
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L7c:
            r3 = 7
            if (r4 < 0) goto L80
            goto L97
        L80:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            r8.<init>(r9)
            throw r8
        L88:
            r3 = r6
            goto L97
        L8a:
            if (r4 == 0) goto L97
            if (r4 != r11) goto L8f
            goto L97
        L8f:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            r8.<init>(r9)
            throw r8
        L97:
            r10.h(r3, r4)
            if (r1 == r2) goto L9e
            int r1 = r1 + r9
            goto L3b
        L9e:
            r8.k(r0, r10)
            return
        La2:
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "TYPE_SETTINGS length % 6 != 0: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        Lb9:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "TYPE_SETTINGS streamId != 0"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.i.T(t3.i$c, int, int, int):void");
    }

    private final void U(c cVar, int i4, int i5, int i6) {
        try {
            if (i4 != 4) {
                throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i4);
            }
            long d5 = p.d(this.f6147b.s(), 2147483647L);
            if (d5 == 0) {
                throw new IOException("windowSizeIncrement was 0");
            }
            Logger logger = f6146g;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(f.f6057a.d(true, i6, i4, d5));
            }
            cVar.g(i6, d5);
        } catch (Exception e4) {
            f6146g.fine(f.f6057a.c(true, i6, i4, 8, i5));
            throw e4;
        }
    }

    public final boolean I(boolean z4, c cVar) {
        e3.f.e(cVar, "handler");
        try {
            this.f6147b.w(9L);
            int B = p.B(this.f6147b);
            if (B > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + B);
            }
            int b5 = p.b(this.f6147b.H(), 255);
            int b6 = p.b(this.f6147b.H(), 255);
            int s4 = this.f6147b.s() & Integer.MAX_VALUE;
            if (b5 != 8) {
                Logger logger = f6146g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(f.f6057a.c(true, s4, B, b5, b6));
                }
            }
            if (z4 && b5 != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + f.f6057a.b(b5));
            }
            switch (b5) {
                case 0:
                    K(cVar, B, b6, s4);
                    return true;
                case 1:
                    N(cVar, B, b6, s4);
                    return true;
                case 2:
                    Q(cVar, B, b6, s4);
                    return true;
                case 3:
                    S(cVar, B, b6, s4);
                    return true;
                case 4:
                    T(cVar, B, b6, s4);
                    return true;
                case 5:
                    R(cVar, B, b6, s4);
                    return true;
                case 6:
                    O(cVar, B, b6, s4);
                    return true;
                case 7:
                    L(cVar, B, b6, s4);
                    return true;
                case 8:
                    U(cVar, B, b6, s4);
                    return true;
                default:
                    this.f6147b.o(B);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void J(c cVar) {
        e3.f.e(cVar, "handler");
        if (this.f6148c) {
            if (!I(true, cVar)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        b4.f fVar = this.f6147b;
        b4.g gVar = f.f6058b;
        b4.g l4 = fVar.l(gVar.y());
        Logger logger = f6146g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(s.h("<< CONNECTION " + l4.j(), new Object[0]));
        }
        if (e3.f.a(gVar, l4)) {
            return;
        }
        throw new IOException("Expected a connection header but was " + l4.D());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6147b.close();
    }
}
