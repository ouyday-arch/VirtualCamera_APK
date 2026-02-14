package b4;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class n implements g0 {

    /* renamed from: b, reason: collision with root package name */
    private byte f2375b;

    /* renamed from: c, reason: collision with root package name */
    private final a0 f2376c;

    /* renamed from: d, reason: collision with root package name */
    private final Inflater f2377d;

    /* renamed from: e, reason: collision with root package name */
    private final o f2378e;

    /* renamed from: f, reason: collision with root package name */
    private final CRC32 f2379f;

    public n(g0 g0Var) {
        e3.f.e(g0Var, "source");
        a0 a0Var = new a0(g0Var);
        this.f2376c = a0Var;
        Inflater inflater = new Inflater(true);
        this.f2377d = inflater;
        this.f2378e = new o((f) a0Var, inflater);
        this.f2379f = new CRC32();
    }

    private final void I() {
        this.f2376c.w(10L);
        byte N = this.f2376c.f2294c.N(3L);
        boolean z4 = ((N >> 1) & 1) == 1;
        if (z4) {
            K(this.f2376c.f2294c, 0L, 10L);
        }
        i("ID1ID2", 8075, this.f2376c.p());
        this.f2376c.o(8L);
        if (((N >> 2) & 1) == 1) {
            this.f2376c.w(2L);
            if (z4) {
                K(this.f2376c.f2294c, 0L, 2L);
            }
            long f4 = this.f2376c.f2294c.f() & 65535;
            this.f2376c.w(f4);
            if (z4) {
                K(this.f2376c.f2294c, 0L, f4);
            }
            this.f2376c.o(f4);
        }
        if (((N >> 3) & 1) == 1) {
            long i4 = this.f2376c.i((byte) 0);
            if (i4 == -1) {
                throw new EOFException();
            }
            if (z4) {
                K(this.f2376c.f2294c, 0L, i4 + 1);
            }
            this.f2376c.o(i4 + 1);
        }
        if (((N >> 4) & 1) == 1) {
            long i5 = this.f2376c.i((byte) 0);
            if (i5 == -1) {
                throw new EOFException();
            }
            if (z4) {
                K(this.f2376c.f2294c, 0L, i5 + 1);
            }
            this.f2376c.o(i5 + 1);
        }
        if (z4) {
            i("FHCRC", this.f2376c.f(), (short) this.f2379f.getValue());
            this.f2379f.reset();
        }
    }

    private final void J() {
        i("CRC", this.f2376c.y(), (int) this.f2379f.getValue());
        i("ISIZE", this.f2376c.y(), (int) this.f2377d.getBytesWritten());
    }

    private final void K(d dVar, long j4, long j5) {
        b0 b0Var = dVar.f2325b;
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
            int min = (int) Math.min(b0Var.f2302c - r6, j5);
            this.f2379f.update(b0Var.f2300a, (int) (b0Var.f2301b + j4), min);
            j5 -= min;
            b0Var = b0Var.f2305f;
            e3.f.b(b0Var);
            j4 = 0;
        }
    }

    private final void i(String str, int i4, int i5) {
        if (i5 == i4) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i5), Integer.valueOf(i4)}, 3));
        e3.f.d(format, "format(...)");
        throw new IOException(format);
    }

    @Override // b4.g0
    public h0 b() {
        return this.f2376c.b();
    }

    @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.f2378e.close();
    }

    @Override // b4.g0
    public long u(d dVar, long j4) {
        e3.f.e(dVar, "sink");
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        if (j4 == 0) {
            return 0L;
        }
        if (this.f2375b == 0) {
            I();
            this.f2375b = (byte) 1;
        }
        if (this.f2375b == 1) {
            long c02 = dVar.c0();
            long u4 = this.f2378e.u(dVar, j4);
            if (u4 != -1) {
                K(dVar, c02, u4);
                return u4;
            }
            this.f2375b = (byte) 2;
        }
        if (this.f2375b == 2) {
            J();
            this.f2375b = (byte) 3;
            if (!this.f2376c.z()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }
}
