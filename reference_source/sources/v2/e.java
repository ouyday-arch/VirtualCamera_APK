package v2;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class e<E> extends c<E> {

    /* renamed from: e, reason: collision with root package name */
    public static final a f6290e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Object[] f6291f = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    private int f6292b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f6293c = f6291f;

    /* renamed from: d, reason: collision with root package name */
    private int f6294d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    private final void e(int i4, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f6293c.length;
        while (i4 < length && it.hasNext()) {
            this.f6293c[i4] = it.next();
            i4++;
        }
        int i5 = this.f6292b;
        for (int i6 = 0; i6 < i5 && it.hasNext(); i6++) {
            this.f6293c[i6] = it.next();
        }
        this.f6294d = size() + collection.size();
    }

    private final void f(int i4) {
        Object[] objArr = new Object[i4];
        Object[] objArr2 = this.f6293c;
        i.e(objArr2, objArr, 0, this.f6292b, objArr2.length);
        Object[] objArr3 = this.f6293c;
        int length = objArr3.length;
        int i5 = this.f6292b;
        i.e(objArr3, objArr, length - i5, 0, i5);
        this.f6292b = 0;
        this.f6293c = objArr;
    }

    private final int g(int i4) {
        int q4;
        if (i4 != 0) {
            return i4 - 1;
        }
        q4 = j.q(this.f6293c);
        return q4;
    }

    private final void h(int i4) {
        int b5;
        if (i4 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f6293c;
        if (i4 <= objArr.length) {
            return;
        }
        if (objArr != f6291f) {
            f(b.f6281b.e(objArr.length, i4));
        } else {
            b5 = g3.l.b(i4, 10);
            this.f6293c = new Object[b5];
        }
    }

    private final int i(int i4) {
        int q4;
        q4 = j.q(this.f6293c);
        if (i4 == q4) {
            return 0;
        }
        return i4 + 1;
    }

    private final int j(int i4) {
        return i4 < 0 ? i4 + this.f6293c.length : i4;
    }

    private final int k(int i4) {
        Object[] objArr = this.f6293c;
        return i4 >= objArr.length ? i4 - objArr.length : i4;
    }

    @Override // v2.c
    public int a() {
        return this.f6294d;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i4, E e4) {
        b.f6281b.c(i4, size());
        if (i4 == size()) {
            d(e4);
            return;
        }
        if (i4 == 0) {
            c(e4);
            return;
        }
        h(size() + 1);
        int k4 = k(this.f6292b + i4);
        if (i4 < ((size() + 1) >> 1)) {
            int g4 = g(k4);
            int g5 = g(this.f6292b);
            int i5 = this.f6292b;
            if (g4 >= i5) {
                Object[] objArr = this.f6293c;
                objArr[g5] = objArr[i5];
                i.e(objArr, objArr, i5, i5 + 1, g4 + 1);
            } else {
                Object[] objArr2 = this.f6293c;
                i.e(objArr2, objArr2, i5 - 1, i5, objArr2.length);
                Object[] objArr3 = this.f6293c;
                objArr3[objArr3.length - 1] = objArr3[0];
                i.e(objArr3, objArr3, 0, 1, g4 + 1);
            }
            this.f6293c[g4] = e4;
            this.f6292b = g5;
        } else {
            int k5 = k(this.f6292b + size());
            Object[] objArr4 = this.f6293c;
            if (k4 < k5) {
                i.e(objArr4, objArr4, k4 + 1, k4, k5);
            } else {
                i.e(objArr4, objArr4, 1, 0, k5);
                Object[] objArr5 = this.f6293c;
                objArr5[0] = objArr5[objArr5.length - 1];
                i.e(objArr5, objArr5, k4 + 1, k4, objArr5.length - 1);
            }
            this.f6293c[k4] = e4;
        }
        this.f6294d = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e4) {
        d(e4);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i4, Collection<? extends E> collection) {
        e3.f.e(collection, "elements");
        b.f6281b.c(i4, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i4 == size()) {
            return addAll(collection);
        }
        h(size() + collection.size());
        int k4 = k(this.f6292b + size());
        int k5 = k(this.f6292b + i4);
        int size = collection.size();
        if (i4 < ((size() + 1) >> 1)) {
            int i5 = this.f6292b;
            int i6 = i5 - size;
            if (k5 < i5) {
                Object[] objArr = this.f6293c;
                i.e(objArr, objArr, i6, i5, objArr.length);
                Object[] objArr2 = this.f6293c;
                if (size >= k5) {
                    i.e(objArr2, objArr2, objArr2.length - size, 0, k5);
                } else {
                    i.e(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.f6293c;
                    i.e(objArr3, objArr3, 0, size, k5);
                }
            } else if (i6 >= 0) {
                Object[] objArr4 = this.f6293c;
                i.e(objArr4, objArr4, i6, i5, k5);
            } else {
                Object[] objArr5 = this.f6293c;
                i6 += objArr5.length;
                int i7 = k5 - i5;
                int length = objArr5.length - i6;
                if (length >= i7) {
                    i.e(objArr5, objArr5, i6, i5, k5);
                } else {
                    i.e(objArr5, objArr5, i6, i5, i5 + length);
                    Object[] objArr6 = this.f6293c;
                    i.e(objArr6, objArr6, 0, this.f6292b + length, k5);
                }
            }
            this.f6292b = i6;
            e(j(k5 - size), collection);
        } else {
            int i8 = k5 + size;
            if (k5 < k4) {
                int i9 = size + k4;
                Object[] objArr7 = this.f6293c;
                if (i9 > objArr7.length) {
                    if (i8 >= objArr7.length) {
                        i8 -= objArr7.length;
                    } else {
                        int length2 = k4 - (i9 - objArr7.length);
                        i.e(objArr7, objArr7, 0, length2, k4);
                        Object[] objArr8 = this.f6293c;
                        i.e(objArr8, objArr8, i8, k5, length2);
                    }
                }
                i.e(objArr7, objArr7, i8, k5, k4);
            } else {
                Object[] objArr9 = this.f6293c;
                i.e(objArr9, objArr9, size, 0, k4);
                Object[] objArr10 = this.f6293c;
                if (i8 >= objArr10.length) {
                    i.e(objArr10, objArr10, i8 - objArr10.length, k5, objArr10.length);
                } else {
                    i.e(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.f6293c;
                    i.e(objArr11, objArr11, i8, k5, objArr11.length - size);
                }
            }
            e(k5, collection);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        e3.f.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        h(size() + collection.size());
        e(k(this.f6292b + size()), collection);
        return true;
    }

    @Override // v2.c
    public E b(int i4) {
        int k4;
        int k5;
        b.f6281b.b(i4, size());
        k4 = o.k(this);
        if (i4 == k4) {
            return m();
        }
        if (i4 == 0) {
            return l();
        }
        int k6 = k(this.f6292b + i4);
        E e4 = (E) this.f6293c[k6];
        if (i4 < (size() >> 1)) {
            int i5 = this.f6292b;
            if (k6 >= i5) {
                Object[] objArr = this.f6293c;
                i.e(objArr, objArr, i5 + 1, i5, k6);
            } else {
                Object[] objArr2 = this.f6293c;
                i.e(objArr2, objArr2, 1, 0, k6);
                Object[] objArr3 = this.f6293c;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i6 = this.f6292b;
                i.e(objArr3, objArr3, i6 + 1, i6, objArr3.length - 1);
            }
            Object[] objArr4 = this.f6293c;
            int i7 = this.f6292b;
            objArr4[i7] = null;
            this.f6292b = i(i7);
        } else {
            int i8 = this.f6292b;
            k5 = o.k(this);
            int k7 = k(i8 + k5);
            Object[] objArr5 = this.f6293c;
            if (k6 <= k7) {
                i.e(objArr5, objArr5, k6, k6 + 1, k7 + 1);
            } else {
                i.e(objArr5, objArr5, k6, k6 + 1, objArr5.length);
                Object[] objArr6 = this.f6293c;
                objArr6[objArr6.length - 1] = objArr6[0];
                i.e(objArr6, objArr6, 0, 1, k7 + 1);
            }
            this.f6293c[k7] = null;
        }
        this.f6294d = size() - 1;
        return e4;
    }

    public final void c(E e4) {
        h(size() + 1);
        int g4 = g(this.f6292b);
        this.f6292b = g4;
        this.f6293c[g4] = e4;
        this.f6294d = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int k4 = k(this.f6292b + size());
        int i4 = this.f6292b;
        if (i4 < k4) {
            i.k(this.f6293c, null, i4, k4);
        } else if (!isEmpty()) {
            Object[] objArr = this.f6293c;
            i.k(objArr, null, this.f6292b, objArr.length);
            i.k(this.f6293c, null, 0, k4);
        }
        this.f6292b = 0;
        this.f6294d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(E e4) {
        h(size() + 1);
        this.f6293c[k(this.f6292b + size())] = e4;
        this.f6294d = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i4) {
        b.f6281b.b(i4, size());
        return (E) this.f6293c[k(this.f6292b + i4)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int k4 = k(this.f6292b + size());
        int i4 = this.f6292b;
        if (i4 < k4) {
            while (i4 < k4) {
                if (!e3.f.a(obj, this.f6293c[i4])) {
                    i4++;
                }
            }
            return -1;
        }
        if (i4 < k4) {
            return -1;
        }
        int length = this.f6293c.length;
        while (true) {
            if (i4 >= length) {
                for (int i5 = 0; i5 < k4; i5++) {
                    if (e3.f.a(obj, this.f6293c[i5])) {
                        i4 = i5 + this.f6293c.length;
                    }
                }
                return -1;
            }
            if (e3.f.a(obj, this.f6293c[i4])) {
                break;
            }
            i4++;
        }
        return i4 - this.f6292b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E l() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f6293c;
        int i4 = this.f6292b;
        E e4 = (E) objArr[i4];
        objArr[i4] = null;
        this.f6292b = i(i4);
        this.f6294d = size() - 1;
        return e4;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int q4;
        int k4 = k(this.f6292b + size());
        int i4 = this.f6292b;
        if (i4 < k4) {
            q4 = k4 - 1;
            if (i4 <= q4) {
                while (!e3.f.a(obj, this.f6293c[q4])) {
                    if (q4 != i4) {
                        q4--;
                    }
                }
                return q4 - this.f6292b;
            }
            return -1;
        }
        if (i4 > k4) {
            int i5 = k4 - 1;
            while (true) {
                if (-1 >= i5) {
                    q4 = j.q(this.f6293c);
                    int i6 = this.f6292b;
                    if (i6 <= q4) {
                        while (!e3.f.a(obj, this.f6293c[q4])) {
                            if (q4 != i6) {
                                q4--;
                            }
                        }
                    }
                } else {
                    if (e3.f.a(obj, this.f6293c[i5])) {
                        q4 = i5 + this.f6293c.length;
                        break;
                    }
                    i5--;
                }
            }
        }
        return -1;
    }

    public final E m() {
        int k4;
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int i4 = this.f6292b;
        k4 = o.k(this);
        int k5 = k(i4 + k4);
        Object[] objArr = this.f6293c;
        E e4 = (E) objArr[k5];
        objArr[k5] = null;
        this.f6294d = size() - 1;
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> collection) {
        int k4;
        e3.f.e(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty()) {
            if ((this.f6293c.length == 0) == false) {
                int k5 = k(this.f6292b + size());
                int i4 = this.f6292b;
                if (i4 < k5) {
                    k4 = i4;
                    while (i4 < k5) {
                        Object obj = this.f6293c[i4];
                        if (!collection.contains(obj)) {
                            this.f6293c[k4] = obj;
                            k4++;
                        } else {
                            z4 = true;
                        }
                        i4++;
                    }
                    i.k(this.f6293c, null, k4, k5);
                } else {
                    int length = this.f6293c.length;
                    boolean z5 = false;
                    int i5 = i4;
                    while (i4 < length) {
                        Object[] objArr = this.f6293c;
                        Object obj2 = objArr[i4];
                        objArr[i4] = null;
                        if (!collection.contains(obj2)) {
                            this.f6293c[i5] = obj2;
                            i5++;
                        } else {
                            z5 = true;
                        }
                        i4++;
                    }
                    k4 = k(i5);
                    for (int i6 = 0; i6 < k5; i6++) {
                        Object[] objArr2 = this.f6293c;
                        Object obj3 = objArr2[i6];
                        objArr2[i6] = null;
                        if (!collection.contains(obj3)) {
                            this.f6293c[k4] = obj3;
                            k4 = i(k4);
                        } else {
                            z5 = true;
                        }
                    }
                    z4 = z5;
                }
                if (z4) {
                    this.f6294d = j(k4 - this.f6292b);
                }
            }
        }
        return z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> collection) {
        int k4;
        e3.f.e(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty()) {
            if ((this.f6293c.length == 0) == false) {
                int k5 = k(this.f6292b + size());
                int i4 = this.f6292b;
                if (i4 < k5) {
                    k4 = i4;
                    while (i4 < k5) {
                        Object obj = this.f6293c[i4];
                        if (collection.contains(obj)) {
                            this.f6293c[k4] = obj;
                            k4++;
                        } else {
                            z4 = true;
                        }
                        i4++;
                    }
                    i.k(this.f6293c, null, k4, k5);
                } else {
                    int length = this.f6293c.length;
                    boolean z5 = false;
                    int i5 = i4;
                    while (i4 < length) {
                        Object[] objArr = this.f6293c;
                        Object obj2 = objArr[i4];
                        objArr[i4] = null;
                        if (collection.contains(obj2)) {
                            this.f6293c[i5] = obj2;
                            i5++;
                        } else {
                            z5 = true;
                        }
                        i4++;
                    }
                    k4 = k(i5);
                    for (int i6 = 0; i6 < k5; i6++) {
                        Object[] objArr2 = this.f6293c;
                        Object obj3 = objArr2[i6];
                        objArr2[i6] = null;
                        if (collection.contains(obj3)) {
                            this.f6293c[k4] = obj3;
                            k4 = i(k4);
                        } else {
                            z5 = true;
                        }
                    }
                    z4 = z5;
                }
                if (z4) {
                    this.f6294d = j(k4 - this.f6292b);
                }
            }
        }
        return z4;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i4, E e4) {
        b.f6281b.b(i4, size());
        int k4 = k(this.f6292b + i4);
        Object[] objArr = this.f6293c;
        E e5 = (E) objArr[k4];
        objArr[k4] = e4;
        return e5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        Object[] e4;
        e3.f.e(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) g.a(tArr, size());
        }
        int k4 = k(this.f6292b + size());
        int i4 = this.f6292b;
        if (i4 < k4) {
            i.g(this.f6293c, tArr, 0, i4, k4, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f6293c;
            i.e(objArr, tArr, 0, this.f6292b, objArr.length);
            Object[] objArr2 = this.f6293c;
            i.e(objArr2, tArr, objArr2.length - this.f6292b, 0, k4);
        }
        e4 = n.e(size(), tArr);
        return (T[]) e4;
    }
}
