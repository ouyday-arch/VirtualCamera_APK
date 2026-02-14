package i;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b, reason: collision with root package name */
    c<K, V> f4101b;

    /* renamed from: c, reason: collision with root package name */
    private c<K, V> f4102c;

    /* renamed from: d, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f4103d = new WeakHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private int f4104e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // i.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f4108e;
        }

        @Override // i.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f4107d;
        }
    }

    /* renamed from: i.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0046b<K, V> extends e<K, V> {
        C0046b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // i.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f4107d;
        }

        @Override // i.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f4108e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        final K f4105b;

        /* renamed from: c, reason: collision with root package name */
        final V f4106c;

        /* renamed from: d, reason: collision with root package name */
        c<K, V> f4107d;

        /* renamed from: e, reason: collision with root package name */
        c<K, V> f4108e;

        c(K k4, V v4) {
            this.f4105b = k4;
            this.f4106c = v4;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f4105b.equals(cVar.f4105b) && this.f4106c.equals(cVar.f4106c);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4105b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f4106c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f4105b.hashCode() ^ this.f4106c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v4) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f4105b + "=" + this.f4106c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b, reason: collision with root package name */
        private c<K, V> f4109b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4110c = true;

        d() {
        }

        @Override // i.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f4109b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f4108e;
                this.f4109b = cVar3;
                this.f4110c = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f4110c) {
                this.f4110c = false;
                cVar = b.this.f4101b;
            } else {
                c<K, V> cVar2 = this.f4109b;
                cVar = cVar2 != null ? cVar2.f4107d : null;
            }
            this.f4109b = cVar;
            return this.f4109b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f4110c) {
                return b.this.f4101b != null;
            }
            c<K, V> cVar = this.f4109b;
            return (cVar == null || cVar.f4107d == null) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b, reason: collision with root package name */
        c<K, V> f4112b;

        /* renamed from: c, reason: collision with root package name */
        c<K, V> f4113c;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f4112b = cVar2;
            this.f4113c = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f4113c;
            c<K, V> cVar2 = this.f4112b;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // i.b.f
        public void a(c<K, V> cVar) {
            if (this.f4112b == cVar && cVar == this.f4113c) {
                this.f4113c = null;
                this.f4112b = null;
            }
            c<K, V> cVar2 = this.f4112b;
            if (cVar2 == cVar) {
                this.f4112b = b(cVar2);
            }
            if (this.f4113c == cVar) {
                this.f4113c = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f4113c;
            this.f4113c = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4113c != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> a() {
        C0046b c0046b = new C0046b(this.f4102c, this.f4101b);
        this.f4103d.put(c0046b, Boolean.FALSE);
        return c0046b;
    }

    public Map.Entry<K, V> b() {
        return this.f4101b;
    }

    protected c<K, V> c(K k4) {
        c<K, V> cVar = this.f4101b;
        while (cVar != null && !cVar.f4105b.equals(k4)) {
            cVar = cVar.f4107d;
        }
        return cVar;
    }

    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.f4103d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> e() {
        return this.f4102c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> f(K k4, V v4) {
        c<K, V> cVar = new c<>(k4, v4);
        this.f4104e++;
        c<K, V> cVar2 = this.f4102c;
        if (cVar2 == null) {
            this.f4101b = cVar;
        } else {
            cVar2.f4107d = cVar;
            cVar.f4108e = cVar2;
        }
        this.f4102c = cVar;
        return cVar;
    }

    public V g(K k4) {
        c<K, V> c5 = c(k4);
        if (c5 == null) {
            return null;
        }
        this.f4104e--;
        if (!this.f4103d.isEmpty()) {
            Iterator<f<K, V>> it = this.f4103d.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(c5);
            }
        }
        c<K, V> cVar = c5.f4108e;
        c<K, V> cVar2 = c5.f4107d;
        if (cVar != null) {
            cVar.f4107d = cVar2;
        } else {
            this.f4101b = cVar2;
        }
        c<K, V> cVar3 = c5.f4107d;
        if (cVar3 != null) {
            cVar3.f4108e = cVar;
        } else {
            this.f4102c = cVar;
        }
        c5.f4107d = null;
        c5.f4108e = null;
        return c5.f4106c;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i4 = 0;
        while (it.hasNext()) {
            i4 += it.next().hashCode();
        }
        return i4;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f4101b, this.f4102c);
        this.f4103d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f4104e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
