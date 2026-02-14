package b4;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements g0 {

    /* renamed from: b, reason: collision with root package name */
    private final InputStream f2384b;

    /* renamed from: c, reason: collision with root package name */
    private final h0 f2385c;

    public p(InputStream inputStream, h0 h0Var) {
        e3.f.e(inputStream, "input");
        e3.f.e(h0Var, "timeout");
        this.f2384b = inputStream;
        this.f2385c = h0Var;
    }

    @Override // b4.g0
    public h0 b() {
        return this.f2385c;
    }

    @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.f2384b.close();
    }

    public String toString() {
        return "source(" + this.f2384b + ')';
    }

    @Override // b4.g0
    public long u(d dVar, long j4) {
        e3.f.e(dVar, "sink");
        if (j4 == 0) {
            return 0L;
        }
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        try {
            this.f2385c.f();
            b0 f02 = dVar.f0(1);
            int read = this.f2384b.read(f02.f2300a, f02.f2302c, (int) Math.min(j4, 8192 - f02.f2302c));
            if (read != -1) {
                f02.f2302c += read;
                long j5 = read;
                dVar.b0(dVar.c0() + j5);
                return j5;
            }
            if (f02.f2301b != f02.f2302c) {
                return -1L;
            }
            dVar.f2325b = f02.b();
            c0.b(f02);
            return -1L;
        } catch (AssertionError e4) {
            if (t.c(e4)) {
                throw new IOException(e4);
            }
            throw e4;
        }
    }
}
