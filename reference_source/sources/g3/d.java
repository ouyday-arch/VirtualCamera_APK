package g3;

import v2.b0;

/* loaded from: classes.dex */
public class d implements Iterable<Integer>, f3.a {

    /* renamed from: e, reason: collision with root package name */
    public static final a f4044e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final int f4045b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4046c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4047d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final d a(int i4, int i5, int i6) {
            return new d(i4, i5, i6);
        }
    }

    public d(int i4, int i5, int i6) {
        if (i6 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i6 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f4045b = i4;
        this.f4046c = z2.c.c(i4, i5, i6);
        this.f4047d = i6;
    }

    public final int a() {
        return this.f4045b;
    }

    public final int b() {
        return this.f4046c;
    }

    public final int c() {
        return this.f4047d;
    }

    @Override // java.lang.Iterable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b0 iterator() {
        return new e(this.f4045b, this.f4046c, this.f4047d);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (this.f4045b != dVar.f4045b || this.f4046c != dVar.f4046c || this.f4047d != dVar.f4047d) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f4045b * 31) + this.f4046c) * 31) + this.f4047d;
    }

    public boolean isEmpty() {
        if (this.f4047d > 0) {
            if (this.f4045b > this.f4046c) {
                return true;
            }
        } else if (this.f4045b < this.f4046c) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i4;
        if (this.f4047d > 0) {
            sb = new StringBuilder();
            sb.append(this.f4045b);
            sb.append("..");
            sb.append(this.f4046c);
            sb.append(" step ");
            i4 = this.f4047d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f4045b);
            sb.append(" downTo ");
            sb.append(this.f4046c);
            sb.append(" step ");
            i4 = -this.f4047d;
        }
        sb.append(i4);
        return sb.toString();
    }
}
