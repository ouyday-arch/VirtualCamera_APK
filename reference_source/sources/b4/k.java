package b4;

/* loaded from: classes.dex */
public abstract class k implements e0 {

    /* renamed from: b, reason: collision with root package name */
    private final e0 f2372b;

    public k(e0 e0Var) {
        e3.f.e(e0Var, "delegate");
        this.f2372b = e0Var;
    }

    @Override // b4.e0
    public void F(d dVar, long j4) {
        e3.f.e(dVar, "source");
        this.f2372b.F(dVar, j4);
    }

    @Override // b4.e0
    public h0 b() {
        return this.f2372b.b();
    }

    @Override // b4.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2372b.close();
    }

    @Override // b4.e0, java.io.Flushable
    public void flush() {
        this.f2372b.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f2372b + ')';
    }
}
