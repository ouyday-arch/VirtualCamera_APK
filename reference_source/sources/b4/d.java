package b4;

import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class d implements f, e, Cloneable, ByteChannel {

    /* renamed from: b, reason: collision with root package name */
    public b0 f2325b;

    /* renamed from: c, reason: collision with root package name */
    private long f2326c;

    /* loaded from: classes.dex */
    public static final class a implements Closeable {

        /* renamed from: b, reason: collision with root package name */
        public d f2327b;

        /* renamed from: c, reason: collision with root package name */
        private b0 f2328c;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f2330e;

        /* renamed from: d, reason: collision with root package name */
        public long f2329d = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f2331f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f2332g = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.f2327b != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.f2327b = null;
            i(null);
            this.f2329d = -1L;
            this.f2330e = null;
            this.f2331f = -1;
            this.f2332g = -1;
        }

        public final void i(b0 b0Var) {
            this.f2328c = b0Var;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(d.this.c0(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (d.this.c0() > 0) {
                return d.this.H() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) {
            e3.f.e(bArr, "sink");
            return d.this.T(bArr, i4, i5);
        }

        public String toString() {
            return d.this + ".inputStream()";
        }
    }

    @Override // b4.f
    public byte[] C(long j4) {
        if (!(j4 >= 0 && j4 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        }
        if (c0() < j4) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j4];
        W(bArr);
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa A[EDGE_INSN: B:41:0x00aa->B:38:0x00aa BREAK  A[LOOP:0: B:4:0x000d->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a2  */
    @Override // b4.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long D() {
        /*
            r14 = this;
            long r0 = r14.c0()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb4
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            b4.b0 r6 = r14.f2325b
            e3.f.b(r6)
            byte[] r7 = r6.f2300a
            int r8 = r6.f2301b
            int r9 = r6.f2302c
        L18:
            if (r8 >= r9) goto L96
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L27
            r11 = 57
            if (r10 > r11) goto L27
            int r11 = r10 + (-48)
            goto L3f
        L27:
            r11 = 97
            if (r10 < r11) goto L34
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L34
            int r11 = r10 + (-97)
        L31:
            int r11 = r11 + 10
            goto L3f
        L34:
            r11 = 65
            if (r10 < r11) goto L77
            r11 = 70
            if (r10 > r11) goto L77
            int r11 = r10 + (-65)
            goto L31
        L3f:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4f
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L4f:
            b4.d r0 = new b4.d
            r0.<init>()
            b4.d r0 = r0.j(r4)
            b4.d r0 = r0.B(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.Z()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L77:
            if (r0 == 0) goto L7b
            r1 = 1
            goto L96
        L7b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = b4.b.i(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L96:
            if (r8 != r9) goto La2
            b4.b0 r7 = r6.b()
            r14.f2325b = r7
            b4.c0.b(r6)
            goto La4
        La2:
            r6.f2301b = r8
        La4:
            if (r1 != 0) goto Laa
            b4.b0 r6 = r14.f2325b
            if (r6 != 0) goto Ld
        Laa:
            long r1 = r14.c0()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.b0(r1)
            return r4
        Lb4:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.d.D():long");
    }

    @Override // b4.f
    public String E(Charset charset) {
        e3.f.e(charset, "charset");
        return Y(this.f2326c, charset);
    }

    @Override // b4.e0
    public void F(d dVar, long j4) {
        b0 b0Var;
        e3.f.e(dVar, "source");
        if (!(dVar != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        b4.b.b(dVar.c0(), 0L, j4);
        while (j4 > 0) {
            b0 b0Var2 = dVar.f2325b;
            e3.f.b(b0Var2);
            int i4 = b0Var2.f2302c;
            e3.f.b(dVar.f2325b);
            if (j4 < i4 - r2.f2301b) {
                b0 b0Var3 = this.f2325b;
                if (b0Var3 != null) {
                    e3.f.b(b0Var3);
                    b0Var = b0Var3.f2306g;
                } else {
                    b0Var = null;
                }
                if (b0Var != null && b0Var.f2304e) {
                    if ((b0Var.f2302c + j4) - (b0Var.f2303d ? 0 : b0Var.f2301b) <= 8192) {
                        b0 b0Var4 = dVar.f2325b;
                        e3.f.b(b0Var4);
                        b0Var4.f(b0Var, (int) j4);
                        dVar.b0(dVar.c0() - j4);
                        b0(c0() + j4);
                        return;
                    }
                }
                b0 b0Var5 = dVar.f2325b;
                e3.f.b(b0Var5);
                dVar.f2325b = b0Var5.e((int) j4);
            }
            b0 b0Var6 = dVar.f2325b;
            e3.f.b(b0Var6);
            long j5 = b0Var6.f2302c - b0Var6.f2301b;
            dVar.f2325b = b0Var6.b();
            b0 b0Var7 = this.f2325b;
            if (b0Var7 == null) {
                this.f2325b = b0Var6;
                b0Var6.f2306g = b0Var6;
                b0Var6.f2305f = b0Var6;
            } else {
                e3.f.b(b0Var7);
                b0 b0Var8 = b0Var7.f2306g;
                e3.f.b(b0Var8);
                b0Var8.c(b0Var6).a();
            }
            dVar.b0(dVar.c0() - j5);
            b0(c0() + j5);
            j4 -= j5;
        }
    }

    @Override // b4.f
    public InputStream G() {
        return new b();
    }

    @Override // b4.f
    public byte H() {
        if (c0() == 0) {
            throw new EOFException();
        }
        b0 b0Var = this.f2325b;
        e3.f.b(b0Var);
        int i4 = b0Var.f2301b;
        int i5 = b0Var.f2302c;
        int i6 = i4 + 1;
        byte b5 = b0Var.f2300a[i4];
        b0(c0() - 1);
        if (i6 == i5) {
            this.f2325b = b0Var.b();
            c0.b(b0Var);
        } else {
            b0Var.f2301b = i6;
        }
        return b5;
    }

    public final void I() {
        o(c0());
    }

    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return L();
    }

    public final long K() {
        long c02 = c0();
        if (c02 == 0) {
            return 0L;
        }
        b0 b0Var = this.f2325b;
        e3.f.b(b0Var);
        b0 b0Var2 = b0Var.f2306g;
        e3.f.b(b0Var2);
        if (b0Var2.f2302c < 8192 && b0Var2.f2304e) {
            c02 -= r3 - b0Var2.f2301b;
        }
        return c02;
    }

    public final d L() {
        d dVar = new d();
        if (c0() != 0) {
            b0 b0Var = this.f2325b;
            e3.f.b(b0Var);
            b0 d5 = b0Var.d();
            dVar.f2325b = d5;
            d5.f2306g = d5;
            d5.f2305f = d5;
            for (b0 b0Var2 = b0Var.f2305f; b0Var2 != b0Var; b0Var2 = b0Var2.f2305f) {
                b0 b0Var3 = d5.f2306g;
                e3.f.b(b0Var3);
                e3.f.b(b0Var2);
                b0Var3.c(b0Var2.d());
            }
            dVar.b0(c0());
        }
        return dVar;
    }

    public final d M(d dVar, long j4, long j5) {
        e3.f.e(dVar, "out");
        b4.b.b(c0(), j4, j5);
        if (j5 != 0) {
            dVar.b0(dVar.c0() + j5);
            b0 b0Var = this.f2325b;
            while (true) {
                e3.f.b(b0Var);
                int i4 = b0Var.f2302c;
                int i5 = b0Var.f2301b;
                if (j4 < i4 - i5) {
                    break;
                }
                j4 -= i4 - i5;
                b0Var = b0Var.f2305f;
            }
            while (j5 > 0) {
                e3.f.b(b0Var);
                b0 d5 = b0Var.d();
                int i6 = d5.f2301b + ((int) j4);
                d5.f2301b = i6;
                d5.f2302c = Math.min(i6 + ((int) j5), d5.f2302c);
                b0 b0Var2 = dVar.f2325b;
                if (b0Var2 == null) {
                    d5.f2306g = d5;
                    d5.f2305f = d5;
                    dVar.f2325b = d5;
                } else {
                    e3.f.b(b0Var2);
                    b0 b0Var3 = b0Var2.f2306g;
                    e3.f.b(b0Var3);
                    b0Var3.c(d5);
                }
                j5 -= d5.f2302c - d5.f2301b;
                b0Var = b0Var.f2305f;
                j4 = 0;
            }
        }
        return this;
    }

    public final byte N(long j4) {
        b4.b.b(c0(), j4, 1L);
        b0 b0Var = this.f2325b;
        if (b0Var == null) {
            e3.f.b(null);
            throw null;
        }
        if (c0() - j4 < j4) {
            long c02 = c0();
            while (c02 > j4) {
                b0Var = b0Var.f2306g;
                e3.f.b(b0Var);
                c02 -= b0Var.f2302c - b0Var.f2301b;
            }
            e3.f.b(b0Var);
            return b0Var.f2300a[(int) ((b0Var.f2301b + j4) - c02)];
        }
        long j5 = 0;
        while (true) {
            long j6 = (b0Var.f2302c - b0Var.f2301b) + j5;
            if (j6 > j4) {
                e3.f.b(b0Var);
                return b0Var.f2300a[(int) ((b0Var.f2301b + j4) - j5)];
            }
            b0Var = b0Var.f2305f;
            e3.f.b(b0Var);
            j5 = j6;
        }
    }

    public long O(byte b5, long j4, long j5) {
        b0 b0Var;
        int i4;
        long j6 = 0;
        boolean z4 = false;
        if (0 <= j4 && j4 <= j5) {
            z4 = true;
        }
        if (!z4) {
            throw new IllegalArgumentException(("size=" + c0() + " fromIndex=" + j4 + " toIndex=" + j5).toString());
        }
        if (j5 > c0()) {
            j5 = c0();
        }
        if (j4 == j5 || (b0Var = this.f2325b) == null) {
            return -1L;
        }
        if (c0() - j4 < j4) {
            j6 = c0();
            while (j6 > j4) {
                b0Var = b0Var.f2306g;
                e3.f.b(b0Var);
                j6 -= b0Var.f2302c - b0Var.f2301b;
            }
            while (j6 < j5) {
                byte[] bArr = b0Var.f2300a;
                int min = (int) Math.min(b0Var.f2302c, (b0Var.f2301b + j5) - j6);
                i4 = (int) ((b0Var.f2301b + j4) - j6);
                while (i4 < min) {
                    if (bArr[i4] != b5) {
                        i4++;
                    }
                }
                j6 += b0Var.f2302c - b0Var.f2301b;
                b0Var = b0Var.f2305f;
                e3.f.b(b0Var);
                j4 = j6;
            }
            return -1L;
        }
        while (true) {
            long j7 = (b0Var.f2302c - b0Var.f2301b) + j6;
            if (j7 > j4) {
                break;
            }
            b0Var = b0Var.f2305f;
            e3.f.b(b0Var);
            j6 = j7;
        }
        while (j6 < j5) {
            byte[] bArr2 = b0Var.f2300a;
            int min2 = (int) Math.min(b0Var.f2302c, (b0Var.f2301b + j5) - j6);
            i4 = (int) ((b0Var.f2301b + j4) - j6);
            while (i4 < min2) {
                if (bArr2[i4] != b5) {
                    i4++;
                }
            }
            j6 += b0Var.f2302c - b0Var.f2301b;
            b0Var = b0Var.f2305f;
            e3.f.b(b0Var);
            j4 = j6;
        }
        return -1L;
        return (i4 - b0Var.f2301b) + j6;
    }

    public long P(g gVar) {
        e3.f.e(gVar, "targetBytes");
        return Q(gVar, 0L);
    }

    public long Q(g gVar, long j4) {
        int i4;
        e3.f.e(gVar, "targetBytes");
        long j5 = 0;
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j4).toString());
        }
        b0 b0Var = this.f2325b;
        if (b0Var == null) {
            return -1L;
        }
        if (c0() - j4 < j4) {
            j5 = c0();
            while (j5 > j4) {
                b0Var = b0Var.f2306g;
                e3.f.b(b0Var);
                j5 -= b0Var.f2302c - b0Var.f2301b;
            }
            if (gVar.y() == 2) {
                byte e4 = gVar.e(0);
                byte e5 = gVar.e(1);
                while (j5 < c0()) {
                    byte[] bArr = b0Var.f2300a;
                    i4 = (int) ((b0Var.f2301b + j4) - j5);
                    int i5 = b0Var.f2302c;
                    while (i4 < i5) {
                        byte b5 = bArr[i4];
                        if (b5 != e4 && b5 != e5) {
                            i4++;
                        }
                    }
                    j5 += b0Var.f2302c - b0Var.f2301b;
                    b0Var = b0Var.f2305f;
                    e3.f.b(b0Var);
                    j4 = j5;
                }
                return -1L;
            }
            byte[] n4 = gVar.n();
            while (j5 < c0()) {
                byte[] bArr2 = b0Var.f2300a;
                i4 = (int) ((b0Var.f2301b + j4) - j5);
                int i6 = b0Var.f2302c;
                while (i4 < i6) {
                    byte b6 = bArr2[i4];
                    for (byte b7 : n4) {
                        if (b6 != b7) {
                        }
                    }
                    i4++;
                }
                j5 += b0Var.f2302c - b0Var.f2301b;
                b0Var = b0Var.f2305f;
                e3.f.b(b0Var);
                j4 = j5;
            }
            return -1L;
        }
        while (true) {
            long j6 = (b0Var.f2302c - b0Var.f2301b) + j5;
            if (j6 > j4) {
                break;
            }
            b0Var = b0Var.f2305f;
            e3.f.b(b0Var);
            j5 = j6;
        }
        if (gVar.y() == 2) {
            byte e6 = gVar.e(0);
            byte e7 = gVar.e(1);
            while (j5 < c0()) {
                byte[] bArr3 = b0Var.f2300a;
                i4 = (int) ((b0Var.f2301b + j4) - j5);
                int i7 = b0Var.f2302c;
                while (i4 < i7) {
                    byte b8 = bArr3[i4];
                    if (b8 != e6 && b8 != e7) {
                        i4++;
                    }
                }
                j5 += b0Var.f2302c - b0Var.f2301b;
                b0Var = b0Var.f2305f;
                e3.f.b(b0Var);
                j4 = j5;
            }
            return -1L;
        }
        byte[] n5 = gVar.n();
        while (j5 < c0()) {
            byte[] bArr4 = b0Var.f2300a;
            i4 = (int) ((b0Var.f2301b + j4) - j5);
            int i8 = b0Var.f2302c;
            while (i4 < i8) {
                byte b9 = bArr4[i4];
                for (byte b10 : n5) {
                    if (b9 != b10) {
                    }
                }
                i4++;
            }
            j5 += b0Var.f2302c - b0Var.f2301b;
            b0Var = b0Var.f2305f;
            e3.f.b(b0Var);
            j4 = j5;
        }
        return -1L;
        return (i4 - b0Var.f2301b) + j5;
    }

    public boolean R(long j4, g gVar) {
        e3.f.e(gVar, "bytes");
        return S(j4, gVar, 0, gVar.y());
    }

    public boolean S(long j4, g gVar, int i4, int i5) {
        e3.f.e(gVar, "bytes");
        if (j4 < 0 || i4 < 0 || i5 < 0 || c0() - j4 < i5 || gVar.y() - i4 < i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (N(i6 + j4) != gVar.e(i4 + i6)) {
                return false;
            }
        }
        return true;
    }

    public int T(byte[] bArr, int i4, int i5) {
        e3.f.e(bArr, "sink");
        b4.b.b(bArr.length, i4, i5);
        b0 b0Var = this.f2325b;
        if (b0Var == null) {
            return -1;
        }
        int min = Math.min(i5, b0Var.f2302c - b0Var.f2301b);
        byte[] bArr2 = b0Var.f2300a;
        int i6 = b0Var.f2301b;
        v2.i.d(bArr2, bArr, i4, i6, i6 + min);
        b0Var.f2301b += min;
        b0(c0() - min);
        if (b0Var.f2301b == b0Var.f2302c) {
            this.f2325b = b0Var.b();
            c0.b(b0Var);
        }
        return min;
    }

    public byte[] U() {
        return C(c0());
    }

    public g V() {
        return l(c0());
    }

    public void W(byte[] bArr) {
        e3.f.e(bArr, "sink");
        int i4 = 0;
        while (i4 < bArr.length) {
            int T = T(bArr, i4, bArr.length - i4);
            if (T == -1) {
                throw new EOFException();
            }
            i4 += T;
        }
    }

    public long X() {
        if (c0() < 8) {
            throw new EOFException();
        }
        b0 b0Var = this.f2325b;
        e3.f.b(b0Var);
        int i4 = b0Var.f2301b;
        int i5 = b0Var.f2302c;
        if (i5 - i4 < 8) {
            return ((s() & 4294967295L) << 32) | (4294967295L & s());
        }
        byte[] bArr = b0Var.f2300a;
        long j4 = (bArr[i4] & 255) << 56;
        int i6 = i4 + 1 + 1 + 1;
        long j5 = j4 | ((bArr[r7] & 255) << 48) | ((bArr[r1] & 255) << 40);
        long j6 = j5 | ((bArr[i6] & 255) << 32) | ((bArr[r1] & 255) << 24);
        long j7 = j6 | ((bArr[r8] & 255) << 16);
        long j8 = j7 | ((bArr[r1] & 255) << 8);
        int i7 = i6 + 1 + 1 + 1 + 1 + 1;
        long j9 = j8 | (bArr[r8] & 255);
        b0(c0() - 8);
        if (i7 == i5) {
            this.f2325b = b0Var.b();
            c0.b(b0Var);
        } else {
            b0Var.f2301b = i7;
        }
        return j9;
    }

    public String Y(long j4, Charset charset) {
        e3.f.e(charset, "charset");
        if (!(j4 >= 0 && j4 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        }
        if (this.f2326c < j4) {
            throw new EOFException();
        }
        if (j4 == 0) {
            return "";
        }
        b0 b0Var = this.f2325b;
        e3.f.b(b0Var);
        int i4 = b0Var.f2301b;
        if (i4 + j4 > b0Var.f2302c) {
            return new String(C(j4), charset);
        }
        int i5 = (int) j4;
        String str = new String(b0Var.f2300a, i4, i5, charset);
        int i6 = b0Var.f2301b + i5;
        b0Var.f2301b = i6;
        this.f2326c -= j4;
        if (i6 == b0Var.f2302c) {
            this.f2325b = b0Var.b();
            c0.b(b0Var);
        }
        return str;
    }

    public String Z() {
        return Y(this.f2326c, j3.d.f4249b);
    }

    @Override // b4.f
    public d a() {
        return this;
    }

    public int a0() {
        int i4;
        int i5;
        int i6;
        if (c0() == 0) {
            throw new EOFException();
        }
        byte N = N(0L);
        boolean z4 = false;
        if ((N & 128) == 0) {
            i4 = N & Byte.MAX_VALUE;
            i6 = 0;
            i5 = 1;
        } else if ((N & 224) == 192) {
            i4 = N & 31;
            i5 = 2;
            i6 = 128;
        } else if ((N & 240) == 224) {
            i4 = N & 15;
            i5 = 3;
            i6 = 2048;
        } else {
            if ((N & 248) != 240) {
                o(1L);
                return 65533;
            }
            i4 = N & 7;
            i5 = 4;
            i6 = 65536;
        }
        long j4 = i5;
        if (c0() < j4) {
            throw new EOFException("size < " + i5 + ": " + c0() + " (to read code point prefixed 0x" + b4.b.i(N) + ')');
        }
        for (int i7 = 1; i7 < i5; i7++) {
            long j5 = i7;
            byte N2 = N(j5);
            if ((N2 & 192) != 128) {
                o(j5);
                return 65533;
            }
            i4 = (i4 << 6) | (N2 & 63);
        }
        o(j4);
        if (i4 > 1114111) {
            return 65533;
        }
        if (55296 <= i4 && i4 < 57344) {
            z4 = true;
        }
        if (!z4 && i4 >= i6) {
            return i4;
        }
        return 65533;
    }

    @Override // b4.g0
    public h0 b() {
        return h0.f2350e;
    }

    public final void b0(long j4) {
        this.f2326c = j4;
    }

    public final long c0() {
        return this.f2326c;
    }

    @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public final g d0() {
        if (c0() <= 2147483647L) {
            return e0((int) c0());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + c0()).toString());
    }

    @Override // b4.f
    public String e(long j4) {
        return Y(j4, j3.d.f4249b);
    }

    public final g e0(int i4) {
        if (i4 == 0) {
            return g.f2338f;
        }
        b4.b.b(c0(), 0L, i4);
        b0 b0Var = this.f2325b;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            e3.f.b(b0Var);
            int i8 = b0Var.f2302c;
            int i9 = b0Var.f2301b;
            if (i8 == i9) {
                throw new AssertionError("s.limit == s.pos");
            }
            i6 += i8 - i9;
            i7++;
            b0Var = b0Var.f2305f;
        }
        byte[][] bArr = new byte[i7];
        int[] iArr = new int[i7 * 2];
        b0 b0Var2 = this.f2325b;
        int i10 = 0;
        while (i5 < i4) {
            e3.f.b(b0Var2);
            bArr[i10] = b0Var2.f2300a;
            i5 += b0Var2.f2302c - b0Var2.f2301b;
            iArr[i10] = Math.min(i5, i4);
            iArr[i10 + i7] = b0Var2.f2301b;
            b0Var2.f2303d = true;
            i10++;
            b0Var2 = b0Var2.f2305f;
        }
        return new d0(bArr, iArr);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (c0() != dVar.c0()) {
                return false;
            }
            if (c0() != 0) {
                b0 b0Var = this.f2325b;
                e3.f.b(b0Var);
                b0 b0Var2 = dVar.f2325b;
                e3.f.b(b0Var2);
                int i4 = b0Var.f2301b;
                int i5 = b0Var2.f2301b;
                long j4 = 0;
                while (j4 < c0()) {
                    long min = Math.min(b0Var.f2302c - i4, b0Var2.f2302c - i5);
                    long j5 = 0;
                    while (j5 < min) {
                        int i6 = i4 + 1;
                        int i7 = i5 + 1;
                        if (b0Var.f2300a[i4] != b0Var2.f2300a[i5]) {
                            return false;
                        }
                        j5++;
                        i4 = i6;
                        i5 = i7;
                    }
                    if (i4 == b0Var.f2302c) {
                        b0Var = b0Var.f2305f;
                        e3.f.b(b0Var);
                        i4 = b0Var.f2301b;
                    }
                    if (i5 == b0Var2.f2302c) {
                        b0Var2 = b0Var2.f2305f;
                        e3.f.b(b0Var2);
                        i5 = b0Var2.f2301b;
                    }
                    j4 += min;
                }
            }
        }
        return true;
    }

    @Override // b4.f
    public short f() {
        return b4.b.h(p());
    }

    public final b0 f0(int i4) {
        if (!(i4 >= 1 && i4 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        b0 b0Var = this.f2325b;
        if (b0Var != null) {
            e3.f.b(b0Var);
            b0 b0Var2 = b0Var.f2306g;
            e3.f.b(b0Var2);
            return (b0Var2.f2302c + i4 > 8192 || !b0Var2.f2304e) ? b0Var2.c(c0.c()) : b0Var2;
        }
        b0 c5 = c0.c();
        this.f2325b = c5;
        c5.f2306g = c5;
        c5.f2305f = c5;
        return c5;
    }

    @Override // b4.e, b4.e0, java.io.Flushable
    public void flush() {
    }

    @Override // b4.e
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public d A(g gVar) {
        e3.f.e(gVar, "byteString");
        gVar.E(this, 0, gVar.y());
        return this;
    }

    @Override // b4.e
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public d c(byte[] bArr) {
        e3.f.e(bArr, "source");
        return d(bArr, 0, bArr.length);
    }

    public int hashCode() {
        b0 b0Var = this.f2325b;
        if (b0Var == null) {
            return 0;
        }
        int i4 = 1;
        do {
            int i5 = b0Var.f2302c;
            for (int i6 = b0Var.f2301b; i6 < i5; i6++) {
                i4 = (i4 * 31) + b0Var.f2300a[i6];
            }
            b0Var = b0Var.f2305f;
            e3.f.b(b0Var);
        } while (b0Var != this.f2325b);
        return i4;
    }

    @Override // b4.e
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public d d(byte[] bArr, int i4, int i5) {
        e3.f.e(bArr, "source");
        long j4 = i5;
        b4.b.b(bArr.length, i4, j4);
        int i6 = i5 + i4;
        while (i4 < i6) {
            b0 f02 = f0(1);
            int min = Math.min(i6 - i4, 8192 - f02.f2302c);
            int i7 = i4 + min;
            v2.i.d(bArr, f02.f2300a, f02.f2302c, i4, i7);
            f02.f2302c += min;
            i4 = i7;
        }
        b0(c0() + j4);
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public long j0(g0 g0Var) {
        e3.f.e(g0Var, "source");
        long j4 = 0;
        while (true) {
            long u4 = g0Var.u(this, 8192L);
            if (u4 == -1) {
                return j4;
            }
            j4 += u4;
        }
    }

    @Override // b4.f
    public int k(w wVar) {
        e3.f.e(wVar, "options");
        int d5 = c4.a.d(this, wVar, false, 2, null);
        if (d5 == -1) {
            return -1;
        }
        o(wVar.d()[d5].y());
        return d5;
    }

    @Override // b4.e
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public d B(int i4) {
        b0 f02 = f0(1);
        byte[] bArr = f02.f2300a;
        int i5 = f02.f2302c;
        f02.f2302c = i5 + 1;
        bArr[i5] = (byte) i4;
        b0(c0() + 1);
        return this;
    }

    @Override // b4.f
    public g l(long j4) {
        if (!(j4 >= 0 && j4 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        }
        if (c0() < j4) {
            throw new EOFException();
        }
        if (j4 < 4096) {
            return new g(C(j4));
        }
        g e02 = e0((int) j4);
        o(j4);
        return e02;
    }

    public d l0(long j4) {
        if (j4 == 0) {
            return B(48);
        }
        boolean z4 = false;
        int i4 = 1;
        if (j4 < 0) {
            j4 = -j4;
            if (j4 < 0) {
                return x("-9223372036854775808");
            }
            z4 = true;
        }
        if (j4 >= 100000000) {
            i4 = j4 < 1000000000000L ? j4 < 10000000000L ? j4 < 1000000000 ? 9 : 10 : j4 < 100000000000L ? 11 : 12 : j4 < 1000000000000000L ? j4 < 10000000000000L ? 13 : j4 < 100000000000000L ? 14 : 15 : j4 < 100000000000000000L ? j4 < 10000000000000000L ? 16 : 17 : j4 < 1000000000000000000L ? 18 : 19;
        } else if (j4 >= 10000) {
            i4 = j4 < 1000000 ? j4 < 100000 ? 5 : 6 : j4 < 10000000 ? 7 : 8;
        } else if (j4 >= 100) {
            i4 = j4 < 1000 ? 3 : 4;
        } else if (j4 >= 10) {
            i4 = 2;
        }
        if (z4) {
            i4++;
        }
        b0 f02 = f0(i4);
        byte[] bArr = f02.f2300a;
        int i5 = f02.f2302c + i4;
        while (j4 != 0) {
            long j5 = 10;
            i5--;
            bArr[i5] = c4.a.a()[(int) (j4 % j5)];
            j4 /= j5;
        }
        if (z4) {
            bArr[i5 - 1] = 45;
        }
        f02.f2302c += i4;
        b0(c0() + i4);
        return this;
    }

    @Override // b4.f
    public long m() {
        return b4.b.g(X());
    }

    @Override // b4.e
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public d j(long j4) {
        if (j4 == 0) {
            return B(48);
        }
        long j5 = (j4 >>> 1) | j4;
        long j6 = j5 | (j5 >>> 2);
        long j7 = j6 | (j6 >>> 4);
        long j8 = j7 | (j7 >>> 8);
        long j9 = j8 | (j8 >>> 16);
        long j10 = j9 | (j9 >>> 32);
        long j11 = j10 - ((j10 >>> 1) & 6148914691236517205L);
        long j12 = ((j11 >>> 2) & 3689348814741910323L) + (j11 & 3689348814741910323L);
        long j13 = ((j12 >>> 4) + j12) & 1085102592571150095L;
        long j14 = j13 + (j13 >>> 8);
        long j15 = j14 + (j14 >>> 16);
        int i4 = (int) ((((j15 & 63) + ((j15 >>> 32) & 63)) + 3) / 4);
        b0 f02 = f0(i4);
        byte[] bArr = f02.f2300a;
        int i5 = f02.f2302c;
        for (int i6 = (i5 + i4) - 1; i6 >= i5; i6--) {
            bArr[i6] = c4.a.a()[(int) (15 & j4)];
            j4 >>>= 4;
        }
        f02.f2302c += i4;
        b0(c0() + i4);
        return this;
    }

    @Override // b4.f
    public String n(long j4) {
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j4).toString());
        }
        long j5 = j4 != Long.MAX_VALUE ? j4 + 1 : Long.MAX_VALUE;
        long O = O((byte) 10, 0L, j5);
        if (O != -1) {
            return c4.a.b(this, O);
        }
        if (j5 < c0() && N(j5 - 1) == 13 && N(j5) == 10) {
            return c4.a.b(this, j5);
        }
        d dVar = new d();
        M(dVar, 0L, Math.min(32, c0()));
        throw new EOFException("\\n not found: limit=" + Math.min(c0(), j4) + " content=" + dVar.V().j() + (char) 8230);
    }

    @Override // b4.e
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public d t(int i4) {
        b0 f02 = f0(4);
        byte[] bArr = f02.f2300a;
        int i5 = f02.f2302c;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i4 >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i4 >>> 8) & 255);
        bArr[i8] = (byte) (i4 & 255);
        f02.f2302c = i8 + 1;
        b0(c0() + 4);
        return this;
    }

    @Override // b4.f
    public void o(long j4) {
        while (j4 > 0) {
            b0 b0Var = this.f2325b;
            if (b0Var == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j4, b0Var.f2302c - b0Var.f2301b);
            long j5 = min;
            b0(c0() - j5);
            j4 -= j5;
            int i4 = b0Var.f2301b + min;
            b0Var.f2301b = i4;
            if (i4 == b0Var.f2302c) {
                this.f2325b = b0Var.b();
                c0.b(b0Var);
            }
        }
    }

    @Override // b4.e
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public d q(int i4) {
        b0 f02 = f0(2);
        byte[] bArr = f02.f2300a;
        int i5 = f02.f2302c;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i6] = (byte) (i4 & 255);
        f02.f2302c = i6 + 1;
        b0(c0() + 2);
        return this;
    }

    @Override // b4.f
    public short p() {
        if (c0() < 2) {
            throw new EOFException();
        }
        b0 b0Var = this.f2325b;
        e3.f.b(b0Var);
        int i4 = b0Var.f2301b;
        int i5 = b0Var.f2302c;
        if (i5 - i4 < 2) {
            return (short) (((H() & 255) << 8) | (H() & 255));
        }
        byte[] bArr = b0Var.f2300a;
        int i6 = i4 + 1;
        int i7 = i6 + 1;
        int i8 = ((bArr[i4] & 255) << 8) | (bArr[i6] & 255);
        b0(c0() - 2);
        if (i7 == i5) {
            this.f2325b = b0Var.b();
            c0.b(b0Var);
        } else {
            b0Var.f2301b = i7;
        }
        return (short) i8;
    }

    public d p0(String str, int i4, int i5, Charset charset) {
        e3.f.e(str, "string");
        e3.f.e(charset, "charset");
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i4).toString());
        }
        if (!(i5 >= i4)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
        }
        if (!(i5 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + str.length()).toString());
        }
        if (e3.f.a(charset, j3.d.f4249b)) {
            return h(str, i4, i5);
        }
        String substring = str.substring(i4, i5);
        e3.f.d(substring, "substring(...)");
        byte[] bytes = substring.getBytes(charset);
        e3.f.d(bytes, "getBytes(...)");
        return d(bytes, 0, bytes.length);
    }

    @Override // b4.e
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public d x(String str) {
        e3.f.e(str, "string");
        return h(str, 0, str.length());
    }

    @Override // b4.e
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public d h(String str, int i4, int i5) {
        char charAt;
        long c02;
        long j4;
        e3.f.e(str, "string");
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i4).toString());
        }
        if (!(i5 >= i4)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
        }
        if (!(i5 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + str.length()).toString());
        }
        while (i4 < i5) {
            char charAt2 = str.charAt(i4);
            if (charAt2 < 128) {
                b0 f02 = f0(1);
                byte[] bArr = f02.f2300a;
                int i6 = f02.f2302c - i4;
                int min = Math.min(i5, 8192 - i6);
                int i7 = i4 + 1;
                bArr[i4 + i6] = (byte) charAt2;
                while (true) {
                    i4 = i7;
                    if (i4 >= min || (charAt = str.charAt(i4)) >= 128) {
                        break;
                    }
                    i7 = i4 + 1;
                    bArr[i4 + i6] = (byte) charAt;
                }
                int i8 = f02.f2302c;
                int i9 = (i6 + i4) - i8;
                f02.f2302c = i8 + i9;
                b0(c0() + i9);
            } else {
                if (charAt2 < 2048) {
                    b0 f03 = f0(2);
                    byte[] bArr2 = f03.f2300a;
                    int i10 = f03.f2302c;
                    bArr2[i10] = (byte) ((charAt2 >> 6) | 192);
                    bArr2[i10 + 1] = (byte) ((charAt2 & '?') | 128);
                    f03.f2302c = i10 + 2;
                    c02 = c0();
                    j4 = 2;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    b0 f04 = f0(3);
                    byte[] bArr3 = f04.f2300a;
                    int i11 = f04.f2302c;
                    bArr3[i11] = (byte) ((charAt2 >> '\f') | 224);
                    bArr3[i11 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                    bArr3[i11 + 2] = (byte) ((charAt2 & '?') | 128);
                    f04.f2302c = i11 + 3;
                    c02 = c0();
                    j4 = 3;
                } else {
                    int i12 = i4 + 1;
                    char charAt3 = i12 < i5 ? str.charAt(i12) : (char) 0;
                    if (charAt2 <= 56319) {
                        if (56320 <= charAt3 && charAt3 < 57344) {
                            int i13 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                            b0 f05 = f0(4);
                            byte[] bArr4 = f05.f2300a;
                            int i14 = f05.f2302c;
                            bArr4[i14] = (byte) ((i13 >> 18) | 240);
                            bArr4[i14 + 1] = (byte) (((i13 >> 12) & 63) | 128);
                            bArr4[i14 + 2] = (byte) (((i13 >> 6) & 63) | 128);
                            bArr4[i14 + 3] = (byte) ((i13 & 63) | 128);
                            f05.f2302c = i14 + 4;
                            b0(c0() + 4);
                            i4 += 2;
                        }
                    }
                    B(63);
                    i4 = i12;
                }
                b0(c02 + j4);
                i4++;
            }
        }
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        e3.f.e(byteBuffer, "sink");
        b0 b0Var = this.f2325b;
        if (b0Var == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), b0Var.f2302c - b0Var.f2301b);
        byteBuffer.put(b0Var.f2300a, b0Var.f2301b, min);
        int i4 = b0Var.f2301b + min;
        b0Var.f2301b = i4;
        this.f2326c -= min;
        if (i4 == b0Var.f2302c) {
            this.f2325b = b0Var.b();
            c0.b(b0Var);
        }
        return min;
    }

    @Override // b4.f
    public int s() {
        if (c0() < 4) {
            throw new EOFException();
        }
        b0 b0Var = this.f2325b;
        e3.f.b(b0Var);
        int i4 = b0Var.f2301b;
        int i5 = b0Var.f2302c;
        if (i5 - i4 < 4) {
            return ((H() & 255) << 24) | ((H() & 255) << 16) | ((H() & 255) << 8) | (H() & 255);
        }
        byte[] bArr = b0Var.f2300a;
        int i6 = i4 + 1;
        int i7 = i6 + 1;
        int i8 = ((bArr[i4] & 255) << 24) | ((bArr[i6] & 255) << 16);
        int i9 = i7 + 1;
        int i10 = i8 | ((bArr[i7] & 255) << 8);
        int i11 = i9 + 1;
        int i12 = i10 | (bArr[i9] & 255);
        b0(c0() - 4);
        if (i11 == i5) {
            this.f2325b = b0Var.b();
            c0.b(b0Var);
        } else {
            b0Var.f2301b = i11;
        }
        return i12;
    }

    @Override // b4.e
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public d r(int i4) {
        long c02;
        long j4;
        if (i4 < 128) {
            B(i4);
        } else {
            if (i4 < 2048) {
                b0 f02 = f0(2);
                byte[] bArr = f02.f2300a;
                int i5 = f02.f2302c;
                bArr[i5] = (byte) ((i4 >> 6) | 192);
                bArr[i5 + 1] = (byte) ((i4 & 63) | 128);
                f02.f2302c = i5 + 2;
                c02 = c0();
                j4 = 2;
            } else {
                boolean z4 = false;
                if (55296 <= i4 && i4 < 57344) {
                    z4 = true;
                }
                if (z4) {
                    B(63);
                } else if (i4 < 65536) {
                    b0 f03 = f0(3);
                    byte[] bArr2 = f03.f2300a;
                    int i6 = f03.f2302c;
                    bArr2[i6] = (byte) ((i4 >> 12) | 224);
                    bArr2[i6 + 1] = (byte) (((i4 >> 6) & 63) | 128);
                    bArr2[i6 + 2] = (byte) ((i4 & 63) | 128);
                    f03.f2302c = i6 + 3;
                    c02 = c0();
                    j4 = 3;
                } else {
                    if (i4 > 1114111) {
                        throw new IllegalArgumentException("Unexpected code point: 0x" + b4.b.j(i4));
                    }
                    b0 f04 = f0(4);
                    byte[] bArr3 = f04.f2300a;
                    int i7 = f04.f2302c;
                    bArr3[i7] = (byte) ((i4 >> 18) | 240);
                    bArr3[i7 + 1] = (byte) (((i4 >> 12) & 63) | 128);
                    bArr3[i7 + 2] = (byte) (((i4 >> 6) & 63) | 128);
                    bArr3[i7 + 3] = (byte) ((i4 & 63) | 128);
                    f04.f2302c = i7 + 4;
                    c02 = c0();
                    j4 = 4;
                }
            }
            b0(c02 + j4);
        }
        return this;
    }

    public String toString() {
        return d0().toString();
    }

    @Override // b4.g0
    public long u(d dVar, long j4) {
        e3.f.e(dVar, "sink");
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        if (c0() == 0) {
            return -1L;
        }
        if (j4 > c0()) {
            j4 = c0();
        }
        dVar.F(this, j4);
        return j4;
    }

    @Override // b4.f
    public String v() {
        return n(Long.MAX_VALUE);
    }

    @Override // b4.f
    public void w(long j4) {
        if (this.f2326c < j4) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        e3.f.e(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i4 = remaining;
        while (i4 > 0) {
            b0 f02 = f0(1);
            int min = Math.min(i4, 8192 - f02.f2302c);
            byteBuffer.get(f02.f2300a, f02.f2302c, min);
            i4 -= min;
            f02.f2302c += min;
        }
        this.f2326c += remaining;
        return remaining;
    }

    @Override // b4.f
    public int y() {
        return b4.b.f(s());
    }

    @Override // b4.f
    public boolean z() {
        return this.f2326c == 0;
    }
}
