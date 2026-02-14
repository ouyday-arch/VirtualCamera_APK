package v2;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class a<E> implements Collection<E>, f3.a {

    /* renamed from: v2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0084a extends e3.g implements d3.b<E, CharSequence> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a<E> f6279c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0084a(a<? extends E> aVar) {
            super(1);
            this.f6279c = aVar;
        }

        @Override // d3.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final CharSequence b(E e4) {
            return e4 == this.f6279c ? "(this Collection)" : String.valueOf(e4);
        }
    }

    public abstract int a();

    @Override // java.util.Collection
    public boolean add(E e4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean contains(E e4) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (e3.f.a(it.next(), e4)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        e3.f.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return e3.c.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        e3.f.e(tArr, "array");
        return (T[]) e3.c.b(this, tArr);
    }

    public String toString() {
        String E;
        E = w.E(this, ", ", "[", "]", 0, null, new C0084a(this), 24, null);
        return E;
    }
}
