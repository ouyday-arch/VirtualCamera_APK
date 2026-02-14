package k;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f4287f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private static final Object[] f4288g = new Object[0];

    /* renamed from: h, reason: collision with root package name */
    private static Object[] f4289h;

    /* renamed from: i, reason: collision with root package name */
    private static int f4290i;

    /* renamed from: j, reason: collision with root package name */
    private static Object[] f4291j;

    /* renamed from: k, reason: collision with root package name */
    private static int f4292k;

    /* renamed from: b, reason: collision with root package name */
    private int[] f4293b;

    /* renamed from: c, reason: collision with root package name */
    Object[] f4294c;

    /* renamed from: d, reason: collision with root package name */
    int f4295d;

    /* renamed from: e, reason: collision with root package name */
    private f<E, E> f4296e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f<E, E> {
        a() {
        }

        @Override // k.f
        protected void a() {
            b.this.clear();
        }

        @Override // k.f
        protected Object b(int i4, int i5) {
            return b.this.f4294c[i4];
        }

        @Override // k.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // k.f
        protected int d() {
            return b.this.f4295d;
        }

        @Override // k.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // k.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // k.f
        protected void g(E e4, E e5) {
            b.this.add(e4);
        }

        @Override // k.f
        protected void h(int i4) {
            b.this.g(i4);
        }

        @Override // k.f
        protected E i(int i4, E e4) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i4) {
        if (i4 == 0) {
            this.f4293b = f4287f;
            this.f4294c = f4288g;
        } else {
            a(i4);
        }
        this.f4295d = 0;
    }

    private void a(int i4) {
        if (i4 == 8) {
            synchronized (b.class) {
                Object[] objArr = f4291j;
                if (objArr != null) {
                    this.f4294c = objArr;
                    f4291j = (Object[]) objArr[0];
                    this.f4293b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f4292k--;
                    return;
                }
            }
        } else if (i4 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f4289h;
                if (objArr2 != null) {
                    this.f4294c = objArr2;
                    f4289h = (Object[]) objArr2[0];
                    this.f4293b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f4290i--;
                    return;
                }
            }
        }
        this.f4293b = new int[i4];
        this.f4294c = new Object[i4];
    }

    private static void c(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f4292k < 10) {
                    objArr[0] = f4291j;
                    objArr[1] = iArr;
                    for (int i5 = i4 - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    f4291j = objArr;
                    f4292k++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f4290i < 10) {
                    objArr[0] = f4289h;
                    objArr[1] = iArr;
                    for (int i6 = i4 - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    f4289h = objArr;
                    f4290i++;
                }
            }
        }
    }

    private f<E, E> d() {
        if (this.f4296e == null) {
            this.f4296e = new a();
        }
        return this.f4296e;
    }

    private int e(Object obj, int i4) {
        int i5 = this.f4295d;
        if (i5 == 0) {
            return -1;
        }
        int a5 = c.a(this.f4293b, i5, i4);
        if (a5 < 0 || obj.equals(this.f4294c[a5])) {
            return a5;
        }
        int i6 = a5 + 1;
        while (i6 < i5 && this.f4293b[i6] == i4) {
            if (obj.equals(this.f4294c[i6])) {
                return i6;
            }
            i6++;
        }
        for (int i7 = a5 - 1; i7 >= 0 && this.f4293b[i7] == i4; i7--) {
            if (obj.equals(this.f4294c[i7])) {
                return i7;
            }
        }
        return ~i6;
    }

    private int f() {
        int i4 = this.f4295d;
        if (i4 == 0) {
            return -1;
        }
        int a5 = c.a(this.f4293b, i4, 0);
        if (a5 < 0 || this.f4294c[a5] == null) {
            return a5;
        }
        int i5 = a5 + 1;
        while (i5 < i4 && this.f4293b[i5] == 0) {
            if (this.f4294c[i5] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = a5 - 1; i6 >= 0 && this.f4293b[i6] == 0; i6--) {
            if (this.f4294c[i6] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e4) {
        int i4;
        int e5;
        if (e4 == null) {
            e5 = f();
            i4 = 0;
        } else {
            int hashCode = e4.hashCode();
            i4 = hashCode;
            e5 = e(e4, hashCode);
        }
        if (e5 >= 0) {
            return false;
        }
        int i5 = ~e5;
        int i6 = this.f4295d;
        int[] iArr = this.f4293b;
        if (i6 >= iArr.length) {
            int i7 = 4;
            if (i6 >= 8) {
                i7 = (i6 >> 1) + i6;
            } else if (i6 >= 4) {
                i7 = 8;
            }
            Object[] objArr = this.f4294c;
            a(i7);
            int[] iArr2 = this.f4293b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f4294c, 0, objArr.length);
            }
            c(iArr, objArr, this.f4295d);
        }
        int i8 = this.f4295d;
        if (i5 < i8) {
            int[] iArr3 = this.f4293b;
            int i9 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i9, i8 - i5);
            Object[] objArr2 = this.f4294c;
            System.arraycopy(objArr2, i5, objArr2, i9, this.f4295d - i5);
        }
        this.f4293b[i5] = i4;
        this.f4294c[i5] = e4;
        this.f4295d++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.f4295d + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 |= add(it.next());
        }
        return z4;
    }

    public void b(int i4) {
        int[] iArr = this.f4293b;
        if (iArr.length < i4) {
            Object[] objArr = this.f4294c;
            a(i4);
            int i5 = this.f4295d;
            if (i5 > 0) {
                System.arraycopy(iArr, 0, this.f4293b, 0, i5);
                System.arraycopy(objArr, 0, this.f4294c, 0, this.f4295d);
            }
            c(iArr, objArr, this.f4295d);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i4 = this.f4295d;
        if (i4 != 0) {
            c(this.f4293b, this.f4294c, i4);
            this.f4293b = f4287f;
            this.f4294c = f4288g;
            this.f4295d = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f4295d; i4++) {
                try {
                    if (!set.contains(h(i4))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E g(int i4) {
        Object[] objArr = this.f4294c;
        E e4 = (E) objArr[i4];
        int i5 = this.f4295d;
        if (i5 <= 1) {
            c(this.f4293b, objArr, i5);
            this.f4293b = f4287f;
            this.f4294c = f4288g;
            this.f4295d = 0;
        } else {
            int[] iArr = this.f4293b;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                int i6 = i5 - 1;
                this.f4295d = i6;
                if (i4 < i6) {
                    int i7 = i4 + 1;
                    System.arraycopy(iArr, i7, iArr, i4, i6 - i4);
                    Object[] objArr2 = this.f4294c;
                    System.arraycopy(objArr2, i7, objArr2, i4, this.f4295d - i4);
                }
                this.f4294c[this.f4295d] = null;
            } else {
                a(i5 > 8 ? i5 + (i5 >> 1) : 8);
                this.f4295d--;
                if (i4 > 0) {
                    System.arraycopy(iArr, 0, this.f4293b, 0, i4);
                    System.arraycopy(objArr, 0, this.f4294c, 0, i4);
                }
                int i8 = this.f4295d;
                if (i4 < i8) {
                    int i9 = i4 + 1;
                    System.arraycopy(iArr, i9, this.f4293b, i4, i8 - i4);
                    System.arraycopy(objArr, i9, this.f4294c, i4, this.f4295d - i4);
                }
            }
        }
        return e4;
    }

    public E h(int i4) {
        return (E) this.f4294c[i4];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f4293b;
        int i4 = this.f4295d;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += iArr[i6];
        }
        return i5;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f4295d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        g(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 |= remove(it.next());
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z4 = false;
        for (int i4 = this.f4295d - 1; i4 >= 0; i4--) {
            if (!collection.contains(this.f4294c[i4])) {
                g(i4);
                z4 = true;
            }
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f4295d;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i4 = this.f4295d;
        Object[] objArr = new Object[i4];
        System.arraycopy(this.f4294c, 0, objArr, 0, i4);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f4295d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f4295d));
        }
        System.arraycopy(this.f4294c, 0, tArr, 0, this.f4295d);
        int length = tArr.length;
        int i4 = this.f4295d;
        if (length > i4) {
            tArr[i4] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4295d * 14);
        sb.append('{');
        for (int i4 = 0; i4 < this.f4295d; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            E h4 = h(i4);
            if (h4 != this) {
                sb.append(h4);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
