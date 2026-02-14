package x;

/* loaded from: classes.dex */
public class d<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public final F f6461a;

    /* renamed from: b, reason: collision with root package name */
    public final S f6462b;

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f6461a, this.f6461a) && c.a(dVar.f6462b, this.f6462b);
    }

    public int hashCode() {
        F f4 = this.f6461a;
        int hashCode = f4 == null ? 0 : f4.hashCode();
        S s4 = this.f6462b;
        return hashCode ^ (s4 != null ? s4.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f6461a) + " " + String.valueOf(this.f6462b) + "}";
    }
}
