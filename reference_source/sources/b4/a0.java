package b4;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class a0 implements f {

    /* renamed from: b, reason: collision with root package name */
    public final g0 f2293b;

    /* renamed from: c, reason: collision with root package name */
    public final d f2294c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2295d;

    /* loaded from: classes.dex */
    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            a0 a0Var = a0.this;
            if (a0Var.f2295d) {
                throw new IOException("closed");
            }
            return (int) Math.min(a0Var.f2294c.c0(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a0.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            a0 a0Var = a0.this;
            if (a0Var.f2295d) {
                throw new IOException("closed");
            }
            if (a0Var.f2294c.c0() == 0) {
                a0 a0Var2 = a0.this;
                if (a0Var2.f2293b.u(a0Var2.f2294c, 8192L) == -1) {
                    return -1;
                }
            }
            return a0.this.f2294c.H() & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) {
            e3.f.e(bArr, "data");
            if (a0.this.f2295d) {
                throw new IOException("closed");
            }
            b.b(bArr.length, i4, i5);
            if (a0.this.f2294c.c0() == 0) {
                a0 a0Var = a0.this;
                if (a0Var.f2293b.u(a0Var.f2294c, 8192L) == -1) {
                    return -1;
                }
            }
            return a0.this.f2294c.T(bArr, i4, i5);
        }

        public String toString() {
            return a0.this + ".inputStream()";
        }
    }

    public a0(g0 g0Var) {
        e3.f.e(g0Var, "source");
        this.f2293b = g0Var;
        this.f2294c = new d();
    }

    @Override // b4.f
    public byte[] C(long j4) {
        w(j4);
        return this.f2294c.C(j4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("Expected leading [0-9a-fA-F] character but was 0x");
        r3 = j3.b.a(16);
        r2 = java.lang.Integer.toString(r2, r3);
        e3.f.d(r2, "toString(...)");
        r1.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        throw new java.lang.NumberFormatException(r1.toString());
     */
    @Override // b4.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long D() {
        /*
            r5 = this;
            r0 = 1
            r5.w(r0)
            r0 = 0
        L6:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.J(r2)
            if (r2 == 0) goto L5a
            b4.d r2 = r5.f2294c
            long r3 = (long) r0
            byte r2 = r2.N(r3)
            r3 = 48
            if (r2 < r3) goto L1e
            r3 = 57
            if (r2 <= r3) goto L2f
        L1e:
            r3 = 97
            if (r2 < r3) goto L26
            r3 = 102(0x66, float:1.43E-43)
            if (r2 <= r3) goto L2f
        L26:
            r3 = 65
            if (r2 < r3) goto L31
            r3 = 70
            if (r2 <= r3) goto L2f
            goto L31
        L2f:
            r0 = r1
            goto L6
        L31:
            if (r0 == 0) goto L34
            goto L5a
        L34:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r3)
            r3 = 16
            int r3 = j3.a.a(r3)
            java.lang.String r2 = java.lang.Integer.toString(r2, r3)
            java.lang.String r3 = "toString(...)"
            e3.f.d(r2, r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L5a:
            b4.d r0 = r5.f2294c
            long r0 = r0.D()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.a0.D():long");
    }

    @Override // b4.f
    public String E(Charset charset) {
        e3.f.e(charset, "charset");
        this.f2294c.j0(this.f2293b);
        return this.f2294c.E(charset);
    }

    @Override // b4.f
    public InputStream G() {
        return new a();
    }

    @Override // b4.f
    public byte H() {
        w(1L);
        return this.f2294c.H();
    }

    public long I(byte b5, long j4, long j5) {
        if (!(!this.f2295d)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j4 && j4 <= j5)) {
            throw new IllegalArgumentException(("fromIndex=" + j4 + " toIndex=" + j5).toString());
        }
        while (j4 < j5) {
            long O = this.f2294c.O(b5, j4, j5);
            if (O != -1) {
                return O;
            }
            long c02 = this.f2294c.c0();
            if (c02 >= j5 || this.f2293b.u(this.f2294c, 8192L) == -1) {
                return -1L;
            }
            j4 = Math.max(j4, c02);
        }
        return -1L;
    }

    public boolean J(long j4) {
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        if (!(!this.f2295d)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.f2294c.c0() < j4) {
            if (this.f2293b.u(this.f2294c, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // b4.f
    public d a() {
        return this.f2294c;
    }

    @Override // b4.g0
    public h0 b() {
        return this.f2293b.b();
    }

    @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (this.f2295d) {
            return;
        }
        this.f2295d = true;
        this.f2293b.close();
        this.f2294c.I();
    }

    @Override // b4.f
    public String e(long j4) {
        w(j4);
        return this.f2294c.e(j4);
    }

    @Override // b4.f
    public short f() {
        w(2L);
        return this.f2294c.f();
    }

    public long i(byte b5) {
        return I(b5, 0L, Long.MAX_VALUE);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f2295d;
    }

    @Override // b4.f
    public int k(w wVar) {
        e3.f.e(wVar, "options");
        if (!(!this.f2295d)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int c5 = c4.a.c(this.f2294c, wVar, true);
            if (c5 != -2) {
                if (c5 != -1) {
                    this.f2294c.o(wVar.d()[c5].y());
                    return c5;
                }
            } else if (this.f2293b.u(this.f2294c, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // b4.f
    public g l(long j4) {
        w(j4);
        return this.f2294c.l(j4);
    }

    @Override // b4.f
    public long m() {
        w(8L);
        return this.f2294c.m();
    }

    @Override // b4.f
    public String n(long j4) {
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j4).toString());
        }
        long j5 = j4 == Long.MAX_VALUE ? Long.MAX_VALUE : j4 + 1;
        long I = I((byte) 10, 0L, j5);
        if (I != -1) {
            return c4.a.b(this.f2294c, I);
        }
        if (j5 < Long.MAX_VALUE && J(j5) && this.f2294c.N(j5 - 1) == 13 && J(1 + j5) && this.f2294c.N(j5) == 10) {
            return c4.a.b(this.f2294c, j5);
        }
        d dVar = new d();
        d dVar2 = this.f2294c;
        dVar2.M(dVar, 0L, Math.min(32, dVar2.c0()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f2294c.c0(), j4) + " content=" + dVar.V().j() + (char) 8230);
    }

    @Override // b4.f
    public void o(long j4) {
        if (!(!this.f2295d)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j4 > 0) {
            if (this.f2294c.c0() == 0 && this.f2293b.u(this.f2294c, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j4, this.f2294c.c0());
            this.f2294c.o(min);
            j4 -= min;
        }
    }

    @Override // b4.f
    public short p() {
        w(2L);
        return this.f2294c.p();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        e3.f.e(byteBuffer, "sink");
        if (this.f2294c.c0() == 0 && this.f2293b.u(this.f2294c, 8192L) == -1) {
            return -1;
        }
        return this.f2294c.read(byteBuffer);
    }

    @Override // b4.f
    public int s() {
        w(4L);
        return this.f2294c.s();
    }

    public String toString() {
        return "buffer(" + this.f2293b + ')';
    }

    @Override // b4.g0
    public long u(d dVar, long j4) {
        e3.f.e(dVar, "sink");
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        if (!(!this.f2295d)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f2294c.c0() == 0 && this.f2293b.u(this.f2294c, 8192L) == -1) {
            return -1L;
        }
        return this.f2294c.u(dVar, Math.min(j4, this.f2294c.c0()));
    }

    @Override // b4.f
    public String v() {
        return n(Long.MAX_VALUE);
    }

    @Override // b4.f
    public void w(long j4) {
        if (!J(j4)) {
            throw new EOFException();
        }
    }

    @Override // b4.f
    public int y() {
        w(4L);
        return this.f2294c.y();
    }

    @Override // b4.f
    public boolean z() {
        if (!this.f2295d) {
            return this.f2294c.z() && this.f2293b.u(this.f2294c, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }
}
