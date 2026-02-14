package u2;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class g<A, B> implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    private final A f6217b;

    /* renamed from: c, reason: collision with root package name */
    private final B f6218c;

    public g(A a5, B b5) {
        this.f6217b = a5;
        this.f6218c = b5;
    }

    public final A a() {
        return this.f6217b;
    }

    public final B b() {
        return this.f6218c;
    }

    public final A c() {
        return this.f6217b;
    }

    public final B d() {
        return this.f6218c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return e3.f.a(this.f6217b, gVar.f6217b) && e3.f.a(this.f6218c, gVar.f6218c);
    }

    public int hashCode() {
        A a5 = this.f6217b;
        int hashCode = (a5 == null ? 0 : a5.hashCode()) * 31;
        B b5 = this.f6218c;
        return hashCode + (b5 != null ? b5.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f6217b + ", " + this.f6218c + ')';
    }
}
