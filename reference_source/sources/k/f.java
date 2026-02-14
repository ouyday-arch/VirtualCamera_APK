package k;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f<K, V> {

    /* renamed from: a, reason: collision with root package name */
    f<K, V>.b f4314a;

    /* renamed from: b, reason: collision with root package name */
    f<K, V>.c f4315b;

    /* renamed from: c, reason: collision with root package name */
    f<K, V>.e f4316c;

    /* loaded from: classes.dex */
    final class a<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        final int f4317b;

        /* renamed from: c, reason: collision with root package name */
        int f4318c;

        /* renamed from: d, reason: collision with root package name */
        int f4319d;

        /* renamed from: e, reason: collision with root package name */
        boolean f4320e = false;

        a(int i4) {
            this.f4317b = i4;
            this.f4318c = f.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4319d < this.f4318c;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t4 = (T) f.this.b(this.f4319d, this.f4317b);
            this.f4319d++;
            this.f4320e = true;
            return t4;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f4320e) {
                throw new IllegalStateException();
            }
            int i4 = this.f4319d - 1;
            this.f4319d = i4;
            this.f4318c--;
            this.f4320e = false;
            f.this.h(i4);
        }
    }

    /* loaded from: classes.dex */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d5 = f.this.d();
            for (Map.Entry<K, V> entry : collection) {
                f.this.g(entry.getKey(), entry.getValue());
            }
            return d5 != f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e4 = f.this.e(entry.getKey());
            if (e4 < 0) {
                return false;
            }
            return k.c.c(f.this.b(e4, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i4 = 0;
            for (int d5 = f.this.d() - 1; d5 >= 0; d5--) {
                Object b5 = f.this.b(d5, 0);
                Object b6 = f.this.b(d5, 1);
                i4 += (b5 == null ? 0 : b5.hashCode()) ^ (b6 == null ? 0 : b6.hashCode());
            }
            return i4;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k4) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return f.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return f.j(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i4 = 0;
            for (int d5 = f.this.d() - 1; d5 >= 0; d5--) {
                Object b5 = f.this.b(d5, 0);
                i4 += b5 == null ? 0 : b5.hashCode();
            }
            return i4;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e4 = f.this.e(obj);
            if (e4 < 0) {
                return false;
            }
            f.this.h(e4);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return f.o(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return f.p(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return f.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.r(tArr, 0);
        }
    }

    /* loaded from: classes.dex */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        int f4324b;

        /* renamed from: d, reason: collision with root package name */
        boolean f4326d = false;

        /* renamed from: c, reason: collision with root package name */
        int f4325c = -1;

        d() {
            this.f4324b = f.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f4325c++;
            this.f4326d = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f4326d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return k.c.c(entry.getKey(), f.this.b(this.f4325c, 0)) && k.c.c(entry.getValue(), f.this.b(this.f4325c, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f4326d) {
                return (K) f.this.b(this.f4325c, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f4326d) {
                return (V) f.this.b(this.f4325c, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4325c < this.f4324b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f4326d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object b5 = f.this.b(this.f4325c, 0);
            Object b6 = f.this.b(this.f4325c, 1);
            return (b5 == null ? 0 : b5.hashCode()) ^ (b6 != null ? b6.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f4326d) {
                throw new IllegalStateException();
            }
            f.this.h(this.f4325c);
            this.f4325c--;
            this.f4324b--;
            this.f4326d = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v4) {
            if (this.f4326d) {
                return (V) f.this.i(this.f4325c, v4);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes.dex */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v4) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return f.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f4 = f.this.f(obj);
            if (f4 < 0) {
                return false;
            }
            f.this.h(f4);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d5 = f.this.d();
            int i4 = 0;
            boolean z4 = false;
            while (i4 < d5) {
                if (collection.contains(f.this.b(i4, 1))) {
                    f.this.h(i4);
                    i4--;
                    d5--;
                    z4 = true;
                }
                i4++;
            }
            return z4;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d5 = f.this.d();
            int i4 = 0;
            boolean z4 = false;
            while (i4 < d5) {
                if (!collection.contains(f.this.b(i4, 1))) {
                    f.this.h(i4);
                    i4--;
                    d5--;
                    z4 = true;
                }
                i4++;
            }
            return z4;
        }

        @Override // java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return f.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i4, int i5);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k4, V v4);

    protected abstract void h(int i4);

    protected abstract V i(int i4, V v4);

    public Set<Map.Entry<K, V>> l() {
        if (this.f4314a == null) {
            this.f4314a = new b();
        }
        return this.f4314a;
    }

    public Set<K> m() {
        if (this.f4315b == null) {
            this.f4315b = new c();
        }
        return this.f4315b;
    }

    public Collection<V> n() {
        if (this.f4316c == null) {
            this.f4316c = new e();
        }
        return this.f4316c;
    }

    public Object[] q(int i4) {
        int d5 = d();
        Object[] objArr = new Object[d5];
        for (int i5 = 0; i5 < d5; i5++) {
            objArr[i5] = b(i5, i4);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i4) {
        int d5 = d();
        if (tArr.length < d5) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d5));
        }
        for (int i5 = 0; i5 < d5; i5++) {
            tArr[i5] = b(i5, i4);
        }
        if (tArr.length > d5) {
            tArr[d5] = null;
        }
        return tArr;
    }
}
