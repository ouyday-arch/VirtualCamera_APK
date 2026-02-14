package v2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class b<E> extends v2.a<E> implements List<E> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6281b = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final void a(int i4, int i5, int i6) {
            if (i4 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("startIndex: " + i4 + ", endIndex: " + i5 + ", size: " + i6);
            }
            if (i4 <= i5) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i4 + " > endIndex: " + i5);
        }

        public final void b(int i4, int i5) {
            if (i4 < 0 || i4 >= i5) {
                throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
            }
        }

        public final void c(int i4, int i5) {
            if (i4 < 0 || i4 > i5) {
                throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
            }
        }

        public final void d(int i4, int i5, int i6) {
            if (i4 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("fromIndex: " + i4 + ", toIndex: " + i5 + ", size: " + i6);
            }
            if (i4 <= i5) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i4 + " > toIndex: " + i5);
        }

        public final int e(int i4, int i5) {
            int i6 = i4 + (i4 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            return i6 - 2147483639 > 0 ? i5 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i6;
        }

        public final boolean f(Collection<?> collection, Collection<?> collection2) {
            e3.f.e(collection, "c");
            e3.f.e(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!e3.f.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection<?> collection) {
            e3.f.e(collection, "c");
            Iterator<?> it = collection.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i4 = (i4 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v2.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0085b implements Iterator<E>, f3.a {

        /* renamed from: b, reason: collision with root package name */
        private int f6282b;

        public C0085b() {
        }

        protected final int a() {
            return this.f6282b;
        }

        protected final void b(int i4) {
            this.f6282b = i4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6282b < b.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b<E> bVar = b.this;
            int i4 = this.f6282b;
            this.f6282b = i4 + 1;
            return bVar.get(i4);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes.dex */
    private class c extends b<E>.C0085b implements ListIterator<E> {
        public c(int i4) {
            super();
            b.f6281b.c(i4, b.this.size());
            b(i4);
        }

        @Override // java.util.ListIterator
        public void add(E e4) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            b<E> bVar = b.this;
            b(a() - 1);
            return bVar.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e4) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes.dex */
    private static final class d<E> extends b<E> implements RandomAccess {

        /* renamed from: c, reason: collision with root package name */
        private final b<E> f6285c;

        /* renamed from: d, reason: collision with root package name */
        private final int f6286d;

        /* renamed from: e, reason: collision with root package name */
        private int f6287e;

        /* JADX WARN: Multi-variable type inference failed */
        public d(b<? extends E> bVar, int i4, int i5) {
            e3.f.e(bVar, "list");
            this.f6285c = bVar;
            this.f6286d = i4;
            b.f6281b.d(i4, i5, bVar.size());
            this.f6287e = i5 - i4;
        }

        @Override // v2.a
        public int a() {
            return this.f6287e;
        }

        @Override // v2.b, java.util.List
        public E get(int i4) {
            b.f6281b.b(i4, this.f6287e);
            return this.f6285c.get(this.f6286d + i4);
        }
    }

    @Override // java.util.List
    public void add(int i4, E e4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i4, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f6281b.f(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i4);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f6281b.g(this);
    }

    public int indexOf(E e4) {
        Iterator<E> it = iterator();
        int i4 = 0;
        while (it.hasNext()) {
            if (e3.f.a(it.next(), e4)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new C0085b();
    }

    public int lastIndexOf(E e4) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (e3.f.a(listIterator.previous(), e4)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i4) {
        return new c(i4);
    }

    @Override // java.util.List
    public E remove(int i4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i4, E e4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i4, int i5) {
        return new d(this, i4, i5);
    }
}
