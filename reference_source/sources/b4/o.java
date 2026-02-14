package b4;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class o implements g0 {

    /* renamed from: b, reason: collision with root package name */
    private final f f2380b;

    /* renamed from: c, reason: collision with root package name */
    private final Inflater f2381c;

    /* renamed from: d, reason: collision with root package name */
    private int f2382d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2383e;

    public o(f fVar, Inflater inflater) {
        e3.f.e(fVar, "source");
        e3.f.e(inflater, "inflater");
        this.f2380b = fVar;
        this.f2381c = inflater;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(g0 g0Var, Inflater inflater) {
        this(t.b(g0Var), inflater);
        e3.f.e(g0Var, "source");
        e3.f.e(inflater, "inflater");
    }

    private final void J() {
        int i4 = this.f2382d;
        if (i4 == 0) {
            return;
        }
        int remaining = i4 - this.f2381c.getRemaining();
        this.f2382d -= remaining;
        this.f2380b.o(remaining);
    }

    public final boolean I() {
        if (!this.f2381c.needsInput()) {
            return false;
        }
        if (this.f2380b.z()) {
            return true;
        }
        b0 b0Var = this.f2380b.a().f2325b;
        e3.f.b(b0Var);
        int i4 = b0Var.f2302c;
        int i5 = b0Var.f2301b;
        int i6 = i4 - i5;
        this.f2382d = i6;
        this.f2381c.setInput(b0Var.f2300a, i5, i6);
        return false;
    }

    @Override // b4.g0
    public h0 b() {
        return this.f2380b.b();
    }

    @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (this.f2383e) {
            return;
        }
        this.f2381c.end();
        this.f2383e = true;
        this.f2380b.close();
    }

    public final long i(d dVar, long j4) {
        e3.f.e(dVar, "sink");
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        if (!(!this.f2383e)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j4 == 0) {
            return 0L;
        }
        try {
            b0 f02 = dVar.f0(1);
            int min = (int) Math.min(j4, 8192 - f02.f2302c);
            I();
            int inflate = this.f2381c.inflate(f02.f2300a, f02.f2302c, min);
            J();
            if (inflate > 0) {
                f02.f2302c += inflate;
                long j5 = inflate;
                dVar.b0(dVar.c0() + j5);
                return j5;
            }
            if (f02.f2301b == f02.f2302c) {
                dVar.f2325b = f02.b();
                c0.b(f02);
            }
            return 0L;
        } catch (DataFormatException e4) {
            throw new IOException(e4);
        }
    }

    @Override // b4.g0
    public long u(d dVar, long j4) {
        e3.f.e(dVar, "sink");
        do {
            long i4 = i(dVar, j4);
            if (i4 > 0) {
                return i4;
            }
            if (this.f2381c.finished() || this.f2381c.needsDictionary()) {
                return -1L;
            }
        } while (!this.f2380b.z());
        throw new EOFException("source exhausted prematurely");
    }
}
