package b4;

/* loaded from: classes.dex */
public abstract class l implements g0 {

    /* renamed from: b, reason: collision with root package name */
    private final g0 f2373b;

    public l(g0 g0Var) {
        e3.f.e(g0Var, "delegate");
        this.f2373b = g0Var;
    }

    @Override // b4.g0
    public h0 b() {
        return this.f2373b.b();
    }

    @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.f2373b.close();
    }

    public final g0 i() {
        return this.f2373b;
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f2373b + ')';
    }

    @Override // b4.g0
    public long u(d dVar, long j4) {
        e3.f.e(dVar, "sink");
        return this.f2373b.u(dVar, j4);
    }
}
