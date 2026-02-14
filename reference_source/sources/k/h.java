package k;

/* loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f4336f = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f4337b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f4338c;

    /* renamed from: d, reason: collision with root package name */
    private Object[] f4339d;

    /* renamed from: e, reason: collision with root package name */
    private int f4340e;

    public h() {
        this(10);
    }

    public h(int i4) {
        this.f4337b = false;
        if (i4 == 0) {
            this.f4338c = c.f4298a;
            this.f4339d = c.f4300c;
        } else {
            int e4 = c.e(i4);
            this.f4338c = new int[e4];
            this.f4339d = new Object[e4];
        }
    }

    private void d() {
        int i4 = this.f4340e;
        int[] iArr = this.f4338c;
        Object[] objArr = this.f4339d;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            Object obj = objArr[i6];
            if (obj != f4336f) {
                if (i6 != i5) {
                    iArr[i5] = iArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.f4337b = false;
        this.f4340e = i5;
    }

    public void a(int i4, E e4) {
        int i5 = this.f4340e;
        if (i5 != 0 && i4 <= this.f4338c[i5 - 1]) {
            k(i4, e4);
            return;
        }
        if (this.f4337b && i5 >= this.f4338c.length) {
            d();
        }
        int i6 = this.f4340e;
        if (i6 >= this.f4338c.length) {
            int e5 = c.e(i6 + 1);
            int[] iArr = new int[e5];
            Object[] objArr = new Object[e5];
            int[] iArr2 = this.f4338c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f4339d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f4338c = iArr;
            this.f4339d = objArr;
        }
        this.f4338c[i6] = i4;
        this.f4339d[i6] = e4;
        this.f4340e = i6 + 1;
    }

    public void b() {
        int i4 = this.f4340e;
        Object[] objArr = this.f4339d;
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = null;
        }
        this.f4340e = 0;
        this.f4337b = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f4338c = (int[]) this.f4338c.clone();
            hVar.f4339d = (Object[]) this.f4339d.clone();
            return hVar;
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    public E e(int i4) {
        return f(i4, null);
    }

    public E f(int i4, E e4) {
        int a5 = c.a(this.f4338c, this.f4340e, i4);
        if (a5 >= 0) {
            Object[] objArr = this.f4339d;
            if (objArr[a5] != f4336f) {
                return (E) objArr[a5];
            }
        }
        return e4;
    }

    public int g(int i4) {
        if (this.f4337b) {
            d();
        }
        return c.a(this.f4338c, this.f4340e, i4);
    }

    public int h(E e4) {
        if (this.f4337b) {
            d();
        }
        for (int i4 = 0; i4 < this.f4340e; i4++) {
            if (this.f4339d[i4] == e4) {
                return i4;
            }
        }
        return -1;
    }

    public int j(int i4) {
        if (this.f4337b) {
            d();
        }
        return this.f4338c[i4];
    }

    public void k(int i4, E e4) {
        int a5 = c.a(this.f4338c, this.f4340e, i4);
        if (a5 >= 0) {
            this.f4339d[a5] = e4;
            return;
        }
        int i5 = ~a5;
        int i6 = this.f4340e;
        if (i5 < i6) {
            Object[] objArr = this.f4339d;
            if (objArr[i5] == f4336f) {
                this.f4338c[i5] = i4;
                objArr[i5] = e4;
                return;
            }
        }
        if (this.f4337b && i6 >= this.f4338c.length) {
            d();
            i5 = ~c.a(this.f4338c, this.f4340e, i4);
        }
        int i7 = this.f4340e;
        if (i7 >= this.f4338c.length) {
            int e5 = c.e(i7 + 1);
            int[] iArr = new int[e5];
            Object[] objArr2 = new Object[e5];
            int[] iArr2 = this.f4338c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f4339d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f4338c = iArr;
            this.f4339d = objArr2;
        }
        int i8 = this.f4340e;
        if (i8 - i5 != 0) {
            int[] iArr3 = this.f4338c;
            int i9 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i9, i8 - i5);
            Object[] objArr4 = this.f4339d;
            System.arraycopy(objArr4, i5, objArr4, i9, this.f4340e - i5);
        }
        this.f4338c[i5] = i4;
        this.f4339d[i5] = e4;
        this.f4340e++;
    }

    public void l(int i4) {
        int a5 = c.a(this.f4338c, this.f4340e, i4);
        if (a5 >= 0) {
            Object[] objArr = this.f4339d;
            Object obj = objArr[a5];
            Object obj2 = f4336f;
            if (obj != obj2) {
                objArr[a5] = obj2;
                this.f4337b = true;
            }
        }
    }

    public int m() {
        if (this.f4337b) {
            d();
        }
        return this.f4340e;
    }

    public E n(int i4) {
        if (this.f4337b) {
            d();
        }
        return (E) this.f4339d[i4];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4340e * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f4340e; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(j(i4));
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
