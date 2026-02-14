package b4;

import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements e0 {

    /* renamed from: b, reason: collision with root package name */
    private final OutputStream f2391b;

    /* renamed from: c, reason: collision with root package name */
    private final h0 f2392c;

    public x(OutputStream outputStream, h0 h0Var) {
        e3.f.e(outputStream, "out");
        e3.f.e(h0Var, "timeout");
        this.f2391b = outputStream;
        this.f2392c = h0Var;
    }

    @Override // b4.e0
    public void F(d dVar, long j4) {
        e3.f.e(dVar, "source");
        b.b(dVar.c0(), 0L, j4);
        while (j4 > 0) {
            this.f2392c.f();
            b0 b0Var = dVar.f2325b;
            e3.f.b(b0Var);
            int min = (int) Math.min(j4, b0Var.f2302c - b0Var.f2301b);
            this.f2391b.write(b0Var.f2300a, b0Var.f2301b, min);
            b0Var.f2301b += min;
            long j5 = min;
            j4 -= j5;
            dVar.b0(dVar.c0() - j5);
            if (b0Var.f2301b == b0Var.f2302c) {
                dVar.f2325b = b0Var.b();
                c0.b(b0Var);
            }
        }
    }

    @Override // b4.e0
    public h0 b() {
        return this.f2392c;
    }

    @Override // b4.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2391b.close();
    }

    @Override // b4.e0, java.io.Flushable
    public void flush() {
        this.f2391b.flush();
    }

    public String toString() {
        return "sink(" + this.f2391b + ')';
    }
}
