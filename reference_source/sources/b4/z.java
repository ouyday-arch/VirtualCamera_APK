package b4;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class z implements e {

    /* renamed from: b, reason: collision with root package name */
    public final e0 f2396b;

    /* renamed from: c, reason: collision with root package name */
    public final d f2397c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2398d;

    public z(e0 e0Var) {
        e3.f.e(e0Var, "sink");
        this.f2396b = e0Var;
        this.f2397c = new d();
    }

    @Override // b4.e
    public e A(g gVar) {
        e3.f.e(gVar, "byteString");
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.A(gVar);
        return i();
    }

    @Override // b4.e
    public e B(int i4) {
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.B(i4);
        return i();
    }

    @Override // b4.e0
    public void F(d dVar, long j4) {
        e3.f.e(dVar, "source");
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.F(dVar, j4);
        i();
    }

    @Override // b4.e
    public d a() {
        return this.f2397c;
    }

    @Override // b4.e0
    public h0 b() {
        return this.f2396b.b();
    }

    @Override // b4.e
    public e c(byte[] bArr) {
        e3.f.e(bArr, "source");
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.c(bArr);
        return i();
    }

    @Override // b4.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f2398d) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f2397c.c0() > 0) {
                e0 e0Var = this.f2396b;
                d dVar = this.f2397c;
                e0Var.F(dVar, dVar.c0());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f2396b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f2398d = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // b4.e
    public e d(byte[] bArr, int i4, int i5) {
        e3.f.e(bArr, "source");
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.d(bArr, i4, i5);
        return i();
    }

    @Override // b4.e, b4.e0, java.io.Flushable
    public void flush() {
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f2397c.c0() > 0) {
            e0 e0Var = this.f2396b;
            d dVar = this.f2397c;
            e0Var.F(dVar, dVar.c0());
        }
        this.f2396b.flush();
    }

    @Override // b4.e
    public e h(String str, int i4, int i5) {
        e3.f.e(str, "string");
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.h(str, i4, i5);
        return i();
    }

    public e i() {
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        long K = this.f2397c.K();
        if (K > 0) {
            this.f2396b.F(this.f2397c, K);
        }
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f2398d;
    }

    @Override // b4.e
    public e j(long j4) {
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.j(j4);
        return i();
    }

    @Override // b4.e
    public e q(int i4) {
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.q(i4);
        return i();
    }

    @Override // b4.e
    public e r(int i4) {
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.r(i4);
        return i();
    }

    @Override // b4.e
    public e t(int i4) {
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.t(i4);
        return i();
    }

    public String toString() {
        return "buffer(" + this.f2396b + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        e3.f.e(byteBuffer, "source");
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        int write = this.f2397c.write(byteBuffer);
        i();
        return write;
    }

    @Override // b4.e
    public e x(String str) {
        e3.f.e(str, "string");
        if (!(!this.f2398d)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2397c.x(str);
        return i();
    }
}
