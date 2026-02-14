package k;

/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f4301f = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f4302b;

    /* renamed from: c, reason: collision with root package name */
    private long[] f4303c;

    /* renamed from: d, reason: collision with root package name */
    private Object[] f4304d;

    /* renamed from: e, reason: collision with root package name */
    private int f4305e;

    public d() {
        this(10);
    }

    public d(int i4) {
        this.f4302b = false;
        if (i4 == 0) {
            this.f4303c = c.f4299b;
            this.f4304d = c.f4300c;
        } else {
            int f4 = c.f(i4);
            this.f4303c = new long[f4];
            this.f4304d = new Object[f4];
        }
    }

    private void d() {
        int i4 = this.f4305e;
        long[] jArr = this.f4303c;
        Object[] objArr = this.f4304d;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            Object obj = objArr[i6];
            if (obj != f4301f) {
                if (i6 != i5) {
                    jArr[i5] = jArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.f4302b = false;
        this.f4305e = i5;
    }

    public void a() {
        int i4 = this.f4305e;
        Object[] objArr = this.f4304d;
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = null;
        }
        this.f4305e = 0;
        this.f4302b = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f4303c = (long[]) this.f4303c.clone();
            dVar.f4304d = (Object[]) this.f4304d.clone();
            return dVar;
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    @Deprecated
    public void c(long j4) {
        k(j4);
    }

    public E e(long j4) {
        return f(j4, null);
    }

    public E f(long j4, E e4) {
        int b5 = c.b(this.f4303c, this.f4305e, j4);
        if (b5 >= 0) {
            Object[] objArr = this.f4304d;
            if (objArr[b5] != f4301f) {
                return (E) objArr[b5];
            }
        }
        return e4;
    }

    public int g(long j4) {
        if (this.f4302b) {
            d();
        }
        return c.b(this.f4303c, this.f4305e, j4);
    }

    public long h(int i4) {
        if (this.f4302b) {
            d();
        }
        return this.f4303c[i4];
    }

    public void j(long j4, E e4) {
        int b5 = c.b(this.f4303c, this.f4305e, j4);
        if (b5 >= 0) {
            this.f4304d[b5] = e4;
            return;
        }
        int i4 = ~b5;
        int i5 = this.f4305e;
        if (i4 < i5) {
            Object[] objArr = this.f4304d;
            if (objArr[i4] == f4301f) {
                this.f4303c[i4] = j4;
                objArr[i4] = e4;
                return;
            }
        }
        if (this.f4302b && i5 >= this.f4303c.length) {
            d();
            i4 = ~c.b(this.f4303c, this.f4305e, j4);
        }
        int i6 = this.f4305e;
        if (i6 >= this.f4303c.length) {
            int f4 = c.f(i6 + 1);
            long[] jArr = new long[f4];
            Object[] objArr2 = new Object[f4];
            long[] jArr2 = this.f4303c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f4304d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f4303c = jArr;
            this.f4304d = objArr2;
        }
        int i7 = this.f4305e;
        if (i7 - i4 != 0) {
            long[] jArr3 = this.f4303c;
            int i8 = i4 + 1;
            System.arraycopy(jArr3, i4, jArr3, i8, i7 - i4);
            Object[] objArr4 = this.f4304d;
            System.arraycopy(objArr4, i4, objArr4, i8, this.f4305e - i4);
        }
        this.f4303c[i4] = j4;
        this.f4304d[i4] = e4;
        this.f4305e++;
    }

    public void k(long j4) {
        int b5 = c.b(this.f4303c, this.f4305e, j4);
        if (b5 >= 0) {
            Object[] objArr = this.f4304d;
            Object obj = objArr[b5];
            Object obj2 = f4301f;
            if (obj != obj2) {
                objArr[b5] = obj2;
                this.f4302b = true;
            }
        }
    }

    public void l(int i4) {
        Object[] objArr = this.f4304d;
        Object obj = objArr[i4];
        Object obj2 = f4301f;
        if (obj != obj2) {
            objArr[i4] = obj2;
            this.f4302b = true;
        }
    }

    public int m() {
        if (this.f4302b) {
            d();
        }
        return this.f4305e;
    }

    public E n(int i4) {
        if (this.f4302b) {
            d();
        }
        return (E) this.f4304d[i4];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4305e * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f4305e; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(h(i4));
            sb.append('=');
            E n4 = n(i4);
            if (n4 != this) {
                sb.append(n4);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
