package g1;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final b f3913a;

    /* renamed from: b, reason: collision with root package name */
    private n1.b f3914b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f3913a = bVar;
    }

    public n1.b a() {
        if (this.f3914b == null) {
            this.f3914b = this.f3913a.b();
        }
        return this.f3914b;
    }

    public n1.a b(int i4, n1.a aVar) {
        return this.f3913a.c(i4, aVar);
    }

    public int c() {
        return this.f3913a.d();
    }

    public int d() {
        return this.f3913a.f();
    }

    public boolean e() {
        return this.f3913a.e().f();
    }

    public c f() {
        return new c(this.f3913a.a(this.f3913a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (m unused) {
            return "";
        }
    }
}
