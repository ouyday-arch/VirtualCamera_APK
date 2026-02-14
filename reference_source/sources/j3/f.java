package j3;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f4267a;

    /* renamed from: b, reason: collision with root package name */
    private final g3.f f4268b;

    public f(String str, g3.f fVar) {
        e3.f.e(str, "value");
        e3.f.e(fVar, "range");
        this.f4267a = str;
        this.f4268b = fVar;
    }

    public final String a() {
        return this.f4267a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return e3.f.a(this.f4267a, fVar.f4267a) && e3.f.a(this.f4268b, fVar.f4268b);
    }

    public int hashCode() {
        return (this.f4267a.hashCode() * 31) + this.f4268b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f4267a + ", range=" + this.f4268b + ')';
    }
}
