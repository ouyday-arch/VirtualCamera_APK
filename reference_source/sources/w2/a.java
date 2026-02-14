package w2;

import e3.d;
import e3.f;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import v2.c;
import v2.i;
import v2.n;

/* loaded from: classes.dex */
public final class a<E> extends c<E> implements RandomAccess, Serializable {

    /* renamed from: h, reason: collision with root package name */
    private static final C0089a f6414h = new C0089a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final a f6415i;

    /* renamed from: b, reason: collision with root package name */
    private E[] f6416b;

    /* renamed from: c, reason: collision with root package name */
    private int f6417c;

    /* renamed from: d, reason: collision with root package name */
    private int f6418d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6419e;

    /* renamed from: f, reason: collision with root package name */
    private final a<E> f6420f;

    /* renamed from: g, reason: collision with root package name */
    private final a<E> f6421g;

    /* renamed from: w2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0089a {
        private C0089a() {
        }

        public /* synthetic */ C0089a(d dVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b<E> implements ListIterator<E>, f3.a {

        /* renamed from: b, reason: collision with root package name */
        private final a<E> f6422b;

        /* renamed from: c, reason: collision with root package name */
        private int f6423c;

        /* renamed from: d, reason: collision with root package name */
        private int f6424d;

        /* renamed from: e, reason: collision with root package name */
        private int f6425e;

        public b(a<E> aVar, int i4) {
            f.e(aVar, "list");
            this.f6422b = aVar;
            this.f6423c = i4;
            this.f6424d = -1;
            this.f6425e = ((AbstractList) aVar).modCount;
        }

        private final void a() {
            if (((AbstractList) this.f6422b).modCount != this.f6425e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(E e4) {
            a();
            a<E> aVar = this.f6422b;
            int i4 = this.f6423c;
            this.f6423c = i4 + 1;
            aVar.add(i4, e4);
            this.f6424d = -1;
            this.f6425e = ((AbstractList) this.f6422b).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f6423c < ((a) this.f6422b).f6418d;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f6423c > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            a();
            if (this.f6423c >= ((a) this.f6422b).f6418d) {
                throw new NoSuchElementException();
            }
            int i4 = this.f6423c;
            this.f6423c = i4 + 1;
            this.f6424d = i4;
            return (E) ((a) this.f6422b).f6416b[((a) this.f6422b).f6417c + this.f6424d];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f6423c;
        }

        @Override // java.util.ListIterator
        public E previous() {
            a();
            int i4 = this.f6423c;
            if (i4 <= 0) {
                throw new NoSuchElementException();
            }
            int i5 = i4 - 1;
            this.f6423c = i5;
            this.f6424d = i5;
            return (E) ((a) this.f6422b).f6416b[((a) this.f6422b).f6417c + this.f6424d];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f6423c - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int i4 = this.f6424d;
            if (!(i4 != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f6422b.remove(i4);
            this.f6423c = this.f6424d;
            this.f6424d = -1;
            this.f6425e = ((AbstractList) this.f6422b).modCount;
        }

        @Override // java.util.ListIterator
        public void set(E e4) {
            a();
            int i4 = this.f6424d;
            if (!(i4 != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f6422b.set(i4, e4);
        }
    }

    static {
        a aVar = new a(0);
        aVar.f6419e = true;
        f6415i = aVar;
    }

    public a() {
        this(10);
    }

    public a(int i4) {
        this(w2.b.d(i4), 0, 0, false, null, null);
    }

    private a(E[] eArr, int i4, int i5, boolean z4, a<E> aVar, a<E> aVar2) {
        this.f6416b = eArr;
        this.f6417c = i4;
        this.f6418d = i5;
        this.f6419e = z4;
        this.f6420f = aVar;
        this.f6421g = aVar2;
        if (aVar != null) {
            ((AbstractList) this).modCount = ((AbstractList) aVar).modCount;
        }
    }

    private final void g(int i4, Collection<? extends E> collection, int i5) {
        q();
        a<E> aVar = this.f6420f;
        if (aVar != null) {
            aVar.g(i4, collection, i5);
            this.f6416b = this.f6420f.f6416b;
            this.f6418d += i5;
        } else {
            o(i4, i5);
            Iterator<? extends E> it = collection.iterator();
            for (int i6 = 0; i6 < i5; i6++) {
                this.f6416b[i4 + i6] = it.next();
            }
        }
    }

    private final void h(int i4, E e4) {
        q();
        a<E> aVar = this.f6420f;
        if (aVar == null) {
            o(i4, 1);
            this.f6416b[i4] = e4;
        } else {
            aVar.h(i4, e4);
            this.f6416b = this.f6420f.f6416b;
            this.f6418d++;
        }
    }

    private final void j() {
        a<E> aVar = this.f6421g;
        if (aVar != null && ((AbstractList) aVar).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void k() {
        if (p()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean l(List<?> list) {
        boolean h4;
        h4 = w2.b.h(this.f6416b, this.f6417c, this.f6418d, list);
        return h4;
    }

    private final void m(int i4) {
        if (i4 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.f6416b;
        if (i4 > eArr.length) {
            this.f6416b = (E[]) w2.b.e(this.f6416b, v2.b.f6281b.e(eArr.length, i4));
        }
    }

    private final void n(int i4) {
        m(this.f6418d + i4);
    }

    private final void o(int i4, int i5) {
        n(i5);
        E[] eArr = this.f6416b;
        i.e(eArr, eArr, i4 + i5, i4, this.f6417c + this.f6418d);
        this.f6418d += i5;
    }

    private final boolean p() {
        a<E> aVar;
        return this.f6419e || ((aVar = this.f6421g) != null && aVar.f6419e);
    }

    private final void q() {
        ((AbstractList) this).modCount++;
    }

    private final E r(int i4) {
        q();
        a<E> aVar = this.f6420f;
        if (aVar != null) {
            this.f6418d--;
            return aVar.r(i4);
        }
        E[] eArr = this.f6416b;
        E e4 = eArr[i4];
        i.e(eArr, eArr, i4, i4 + 1, this.f6417c + this.f6418d);
        w2.b.f(this.f6416b, (this.f6417c + this.f6418d) - 1);
        this.f6418d--;
        return e4;
    }

    private final void s(int i4, int i5) {
        if (i5 > 0) {
            q();
        }
        a<E> aVar = this.f6420f;
        if (aVar != null) {
            aVar.s(i4, i5);
        } else {
            E[] eArr = this.f6416b;
            i.e(eArr, eArr, i4, i4 + i5, this.f6418d);
            E[] eArr2 = this.f6416b;
            int i6 = this.f6418d;
            w2.b.g(eArr2, i6 - i5, i6);
        }
        this.f6418d -= i5;
    }

    private final int t(int i4, int i5, Collection<? extends E> collection, boolean z4) {
        int i6;
        a<E> aVar = this.f6420f;
        if (aVar != null) {
            i6 = aVar.t(i4, i5, collection, z4);
        } else {
            int i7 = 0;
            int i8 = 0;
            while (i7 < i5) {
                int i9 = i4 + i7;
                if (collection.contains(this.f6416b[i9]) == z4) {
                    E[] eArr = this.f6416b;
                    i7++;
                    eArr[i8 + i4] = eArr[i9];
                    i8++;
                } else {
                    i7++;
                }
            }
            int i10 = i5 - i8;
            E[] eArr2 = this.f6416b;
            i.e(eArr2, eArr2, i4 + i8, i5 + i4, this.f6418d);
            E[] eArr3 = this.f6416b;
            int i11 = this.f6418d;
            w2.b.g(eArr3, i11 - i10, i11);
            i6 = i10;
        }
        if (i6 > 0) {
            q();
        }
        this.f6418d -= i6;
        return i6;
    }

    @Override // v2.c
    public int a() {
        j();
        return this.f6418d;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i4, E e4) {
        k();
        j();
        v2.b.f6281b.c(i4, this.f6418d);
        h(this.f6417c + i4, e4);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e4) {
        k();
        j();
        h(this.f6417c + this.f6418d, e4);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i4, Collection<? extends E> collection) {
        f.e(collection, "elements");
        k();
        j();
        v2.b.f6281b.c(i4, this.f6418d);
        int size = collection.size();
        g(this.f6417c + i4, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        f.e(collection, "elements");
        k();
        j();
        int size = collection.size();
        g(this.f6417c + this.f6418d, collection, size);
        return size > 0;
    }

    @Override // v2.c
    public E b(int i4) {
        k();
        j();
        v2.b.f6281b.b(i4, this.f6418d);
        return r(this.f6417c + i4);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        k();
        j();
        s(this.f6417c, this.f6418d);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        j();
        return obj == this || ((obj instanceof List) && l((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i4) {
        j();
        v2.b.f6281b.b(i4, this.f6418d);
        return this.f6416b[this.f6417c + i4];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i4;
        j();
        i4 = w2.b.i(this.f6416b, this.f6417c, this.f6418d);
        return i4;
    }

    public final List<E> i() {
        if (this.f6420f != null) {
            throw new IllegalStateException();
        }
        k();
        this.f6419e = true;
        return this.f6418d > 0 ? this : f6415i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        j();
        for (int i4 = 0; i4 < this.f6418d; i4++) {
            if (f.a(this.f6416b[this.f6417c + i4], obj)) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        j();
        return this.f6418d == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        j();
        for (int i4 = this.f6418d - 1; i4 >= 0; i4--) {
            if (f.a(this.f6416b[this.f6417c + i4], obj)) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i4) {
        j();
        v2.b.f6281b.c(i4, this.f6418d);
        return new b(this, i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        k();
        j();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> collection) {
        f.e(collection, "elements");
        k();
        j();
        return t(this.f6417c, this.f6418d, collection, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> collection) {
        f.e(collection, "elements");
        k();
        j();
        return t(this.f6417c, this.f6418d, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i4, E e4) {
        k();
        j();
        v2.b.f6281b.b(i4, this.f6418d);
        E[] eArr = this.f6416b;
        int i5 = this.f6417c;
        E e5 = eArr[i5 + i4];
        eArr[i5 + i4] = e4;
        return e5;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i4, int i5) {
        v2.b.f6281b.d(i4, i5, this.f6418d);
        E[] eArr = this.f6416b;
        int i6 = this.f6417c + i4;
        int i7 = i5 - i4;
        boolean z4 = this.f6419e;
        a<E> aVar = this.f6421g;
        return new a(eArr, i6, i7, z4, this, aVar == null ? this : aVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] i4;
        j();
        E[] eArr = this.f6416b;
        int i5 = this.f6417c;
        i4 = i.i(eArr, i5, this.f6418d + i5);
        return i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        Object[] e4;
        f.e(tArr, "destination");
        j();
        int length = tArr.length;
        int i4 = this.f6418d;
        if (length < i4) {
            E[] eArr = this.f6416b;
            int i5 = this.f6417c;
            T[] tArr2 = (T[]) Arrays.copyOfRange(eArr, i5, i4 + i5, tArr.getClass());
            f.d(tArr2, "copyOfRange(...)");
            return tArr2;
        }
        E[] eArr2 = this.f6416b;
        int i6 = this.f6417c;
        i.e(eArr2, tArr, 0, i6, i4 + i6);
        e4 = n.e(this.f6418d, tArr);
        return (T[]) e4;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String j4;
        j();
        j4 = w2.b.j(this.f6416b, this.f6417c, this.f6418d, this);
        return j4;
    }
}
