package k;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class g<K, V> {

    /* renamed from: e, reason: collision with root package name */
    static Object[] f4329e;

    /* renamed from: f, reason: collision with root package name */
    static int f4330f;

    /* renamed from: g, reason: collision with root package name */
    static Object[] f4331g;

    /* renamed from: h, reason: collision with root package name */
    static int f4332h;

    /* renamed from: b, reason: collision with root package name */
    int[] f4333b;

    /* renamed from: c, reason: collision with root package name */
    Object[] f4334c;

    /* renamed from: d, reason: collision with root package name */
    int f4335d;

    public g() {
        this.f4333b = c.f4298a;
        this.f4334c = c.f4300c;
        this.f4335d = 0;
    }

    public g(int i4) {
        if (i4 == 0) {
            this.f4333b = c.f4298a;
            this.f4334c = c.f4300c;
        } else {
            a(i4);
        }
        this.f4335d = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(g<K, V> gVar) {
        this();
        if (gVar != 0) {
            j(gVar);
        }
    }

    private void a(int i4) {
        if (i4 == 8) {
            synchronized (g.class) {
                Object[] objArr = f4331g;
                if (objArr != null) {
                    this.f4334c = objArr;
                    f4331g = (Object[]) objArr[0];
                    this.f4333b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f4332h--;
                    return;
                }
            }
        } else if (i4 == 4) {
            synchronized (g.class) {
                Object[] objArr2 = f4329e;
                if (objArr2 != null) {
                    this.f4334c = objArr2;
                    f4329e = (Object[]) objArr2[0];
                    this.f4333b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f4330f--;
                    return;
                }
            }
        }
        this.f4333b = new int[i4];
        this.f4334c = new Object[i4 << 1];
    }

    private static int b(int[] iArr, int i4, int i5) {
        try {
            return c.a(iArr, i4, i5);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (f4332h < 10) {
                    objArr[0] = f4331g;
                    objArr[1] = iArr;
                    for (int i5 = (i4 << 1) - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    f4331g = objArr;
                    f4332h++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                if (f4330f < 10) {
                    objArr[0] = f4329e;
                    objArr[1] = iArr;
                    for (int i6 = (i4 << 1) - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    f4329e = objArr;
                    f4330f++;
                }
            }
        }
    }

    public void c(int i4) {
        int i5 = this.f4335d;
        int[] iArr = this.f4333b;
        if (iArr.length < i4) {
            Object[] objArr = this.f4334c;
            a(i4);
            if (this.f4335d > 0) {
                System.arraycopy(iArr, 0, this.f4333b, 0, i5);
                System.arraycopy(objArr, 0, this.f4334c, 0, i5 << 1);
            }
            d(iArr, objArr, i5);
        }
        if (this.f4335d != i5) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i4 = this.f4335d;
        if (i4 > 0) {
            int[] iArr = this.f4333b;
            Object[] objArr = this.f4334c;
            this.f4333b = c.f4298a;
            this.f4334c = c.f4300c;
            this.f4335d = 0;
            d(iArr, objArr, i4);
        }
        if (this.f4335d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i4) {
        int i5 = this.f4335d;
        if (i5 == 0) {
            return -1;
        }
        int b5 = b(this.f4333b, i5, i4);
        if (b5 < 0 || obj.equals(this.f4334c[b5 << 1])) {
            return b5;
        }
        int i6 = b5 + 1;
        while (i6 < i5 && this.f4333b[i6] == i4) {
            if (obj.equals(this.f4334c[i6 << 1])) {
                return i6;
            }
            i6++;
        }
        for (int i7 = b5 - 1; i7 >= 0 && this.f4333b[i7] == i4; i7--) {
            if (obj.equals(this.f4334c[i7 << 1])) {
                return i7;
            }
        }
        return ~i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f4335d; i4++) {
                try {
                    K i5 = i(i4);
                    V m4 = m(i4);
                    Object obj2 = gVar.get(i5);
                    if (m4 == null) {
                        if (obj2 != null || !gVar.containsKey(i5)) {
                            return false;
                        }
                    } else if (!m4.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i6 = 0; i6 < this.f4335d; i6++) {
                try {
                    K i7 = i(i6);
                    V m5 = m(i6);
                    Object obj3 = map.get(i7);
                    if (m5 == null) {
                        if (obj3 != null || !map.containsKey(i7)) {
                            return false;
                        }
                    } else if (!m5.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i4 = this.f4335d;
        if (i4 == 0) {
            return -1;
        }
        int b5 = b(this.f4333b, i4, 0);
        if (b5 < 0 || this.f4334c[b5 << 1] == null) {
            return b5;
        }
        int i5 = b5 + 1;
        while (i5 < i4 && this.f4333b[i5] == 0) {
            if (this.f4334c[i5 << 1] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = b5 - 1; i6 >= 0 && this.f4333b[i6] == 0; i6--) {
            if (this.f4334c[i6 << 1] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v4) {
        int f4 = f(obj);
        return f4 >= 0 ? (V) this.f4334c[(f4 << 1) + 1] : v4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(Object obj) {
        int i4 = this.f4335d * 2;
        Object[] objArr = this.f4334c;
        if (obj == null) {
            for (int i5 = 1; i5 < i4; i5 += 2) {
                if (objArr[i5] == null) {
                    return i5 >> 1;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i4; i6 += 2) {
            if (obj.equals(objArr[i6])) {
                return i6 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f4333b;
        Object[] objArr = this.f4334c;
        int i4 = this.f4335d;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            Object obj = objArr[i5];
            i7 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i6];
            i6++;
            i5 += 2;
        }
        return i7;
    }

    public K i(int i4) {
        return (K) this.f4334c[i4 << 1];
    }

    public boolean isEmpty() {
        return this.f4335d <= 0;
    }

    public void j(g<? extends K, ? extends V> gVar) {
        int i4 = gVar.f4335d;
        c(this.f4335d + i4);
        if (this.f4335d != 0) {
            for (int i5 = 0; i5 < i4; i5++) {
                put(gVar.i(i5), gVar.m(i5));
            }
        } else if (i4 > 0) {
            System.arraycopy(gVar.f4333b, 0, this.f4333b, 0, i4);
            System.arraycopy(gVar.f4334c, 0, this.f4334c, 0, i4 << 1);
            this.f4335d = i4;
        }
    }

    public V k(int i4) {
        Object[] objArr = this.f4334c;
        int i5 = i4 << 1;
        V v4 = (V) objArr[i5 + 1];
        int i6 = this.f4335d;
        int i7 = 0;
        if (i6 <= 1) {
            d(this.f4333b, objArr, i6);
            this.f4333b = c.f4298a;
            this.f4334c = c.f4300c;
        } else {
            int i8 = i6 - 1;
            int[] iArr = this.f4333b;
            if (iArr.length <= 8 || i6 >= iArr.length / 3) {
                if (i4 < i8) {
                    int i9 = i4 + 1;
                    int i10 = i8 - i4;
                    System.arraycopy(iArr, i9, iArr, i4, i10);
                    Object[] objArr2 = this.f4334c;
                    System.arraycopy(objArr2, i9 << 1, objArr2, i5, i10 << 1);
                }
                Object[] objArr3 = this.f4334c;
                int i11 = i8 << 1;
                objArr3[i11] = null;
                objArr3[i11 + 1] = null;
            } else {
                a(i6 > 8 ? i6 + (i6 >> 1) : 8);
                if (i6 != this.f4335d) {
                    throw new ConcurrentModificationException();
                }
                if (i4 > 0) {
                    System.arraycopy(iArr, 0, this.f4333b, 0, i4);
                    System.arraycopy(objArr, 0, this.f4334c, 0, i5);
                }
                if (i4 < i8) {
                    int i12 = i4 + 1;
                    int i13 = i8 - i4;
                    System.arraycopy(iArr, i12, this.f4333b, i4, i13);
                    System.arraycopy(objArr, i12 << 1, this.f4334c, i5, i13 << 1);
                }
            }
            i7 = i8;
        }
        if (i6 != this.f4335d) {
            throw new ConcurrentModificationException();
        }
        this.f4335d = i7;
        return v4;
    }

    public V l(int i4, V v4) {
        int i5 = (i4 << 1) + 1;
        Object[] objArr = this.f4334c;
        V v5 = (V) objArr[i5];
        objArr[i5] = v4;
        return v5;
    }

    public V m(int i4) {
        return (V) this.f4334c[(i4 << 1) + 1];
    }

    public V put(K k4, V v4) {
        int i4;
        int e4;
        int i5 = this.f4335d;
        if (k4 == null) {
            e4 = g();
            i4 = 0;
        } else {
            int hashCode = k4.hashCode();
            i4 = hashCode;
            e4 = e(k4, hashCode);
        }
        if (e4 >= 0) {
            int i6 = (e4 << 1) + 1;
            Object[] objArr = this.f4334c;
            V v5 = (V) objArr[i6];
            objArr[i6] = v4;
            return v5;
        }
        int i7 = ~e4;
        int[] iArr = this.f4333b;
        if (i5 >= iArr.length) {
            int i8 = 4;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i8 = 8;
            }
            Object[] objArr2 = this.f4334c;
            a(i8);
            if (i5 != this.f4335d) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f4333b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f4334c, 0, objArr2.length);
            }
            d(iArr, objArr2, i5);
        }
        if (i7 < i5) {
            int[] iArr3 = this.f4333b;
            int i9 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i9, i5 - i7);
            Object[] objArr3 = this.f4334c;
            System.arraycopy(objArr3, i7 << 1, objArr3, i9 << 1, (this.f4335d - i7) << 1);
        }
        int i10 = this.f4335d;
        if (i5 == i10) {
            int[] iArr4 = this.f4333b;
            if (i7 < iArr4.length) {
                iArr4[i7] = i4;
                Object[] objArr4 = this.f4334c;
                int i11 = i7 << 1;
                objArr4[i11] = k4;
                objArr4[i11 + 1] = v4;
                this.f4335d = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k4, V v4) {
        V v5 = get(k4);
        return v5 == null ? put(k4, v4) : v5;
    }

    public V remove(Object obj) {
        int f4 = f(obj);
        if (f4 >= 0) {
            return k(f4);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int f4 = f(obj);
        if (f4 < 0) {
            return false;
        }
        V m4 = m(f4);
        if (obj2 != m4 && (obj2 == null || !obj2.equals(m4))) {
            return false;
        }
        k(f4);
        return true;
    }

    public V replace(K k4, V v4) {
        int f4 = f(k4);
        if (f4 >= 0) {
            return l(f4, v4);
        }
        return null;
    }

    public boolean replace(K k4, V v4, V v5) {
        int f4 = f(k4);
        if (f4 < 0) {
            return false;
        }
        V m4 = m(f4);
        if (m4 != v4 && (v4 == null || !v4.equals(m4))) {
            return false;
        }
        l(f4, v5);
        return true;
    }

    public int size() {
        return this.f4335d;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4335d * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f4335d; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            K i5 = i(i4);
            if (i5 != this) {
                sb.append(i5);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V m4 = m(i4);
            if (m4 != this) {
                sb.append(m4);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
