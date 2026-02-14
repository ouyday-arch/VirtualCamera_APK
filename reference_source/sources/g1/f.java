package g1;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final int f3929a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3930b;

    public int a() {
        return this.f3930b;
    }

    public int b() {
        return this.f3929a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f3929a == fVar.f3929a && this.f3930b == fVar.f3930b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f3929a * 32713) + this.f3930b;
    }

    public String toString() {
        return this.f3929a + "x" + this.f3930b;
    }
}
