package p2;

/* loaded from: classes.dex */
public class q implements Comparable<q> {

    /* renamed from: b, reason: collision with root package name */
    public final int f5467b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5468c;

    public q(int i4, int i5) {
        this.f5467b = i4;
        this.f5468c = i5;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(q qVar) {
        int i4 = this.f5468c * this.f5467b;
        int i5 = qVar.f5468c * qVar.f5467b;
        if (i5 < i4) {
            return 1;
        }
        return i5 > i4 ? -1 : 0;
    }

    public q b() {
        return new q(this.f5468c, this.f5467b);
    }

    public q c(q qVar) {
        int i4 = this.f5467b;
        int i5 = qVar.f5468c;
        int i6 = i4 * i5;
        int i7 = qVar.f5467b;
        int i8 = this.f5468c;
        return i6 <= i7 * i8 ? new q(i7, (i8 * i7) / i4) : new q((i4 * i5) / i8, i5);
    }

    public q d(q qVar) {
        int i4 = this.f5467b;
        int i5 = qVar.f5468c;
        int i6 = i4 * i5;
        int i7 = qVar.f5467b;
        int i8 = this.f5468c;
        return i6 >= i7 * i8 ? new q(i7, (i8 * i7) / i4) : new q((i4 * i5) / i8, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return this.f5467b == qVar.f5467b && this.f5468c == qVar.f5468c;
    }

    public int hashCode() {
        return (this.f5467b * 31) + this.f5468c;
    }

    public String toString() {
        return this.f5467b + "x" + this.f5468c;
    }
}
