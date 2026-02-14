package x1;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f6476a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6477b;

    public b(int i4, int i5) {
        this.f6476a = i4;
        this.f6477b = i5;
    }

    public final int a() {
        return this.f6477b;
    }

    public final int b() {
        return this.f6476a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6476a == bVar.f6476a && this.f6477b == bVar.f6477b;
    }

    public final int hashCode() {
        return this.f6476a ^ this.f6477b;
    }

    public final String toString() {
        return this.f6476a + "(" + this.f6477b + ')';
    }
}
