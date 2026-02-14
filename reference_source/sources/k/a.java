package k;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: i, reason: collision with root package name */
    f<K, V> f4285i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0053a extends f<K, V> {
        C0053a() {
        }

        @Override // k.f
        protected void a() {
            a.this.clear();
        }

        @Override // k.f
        protected Object b(int i4, int i5) {
            return a.this.f4334c[(i4 << 1) + i5];
        }

        @Override // k.f
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // k.f
        protected int d() {
            return a.this.f4335d;
        }

        @Override // k.f
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // k.f
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // k.f
        protected void g(K k4, V v4) {
            a.this.put(k4, v4);
        }

        @Override // k.f
        protected void h(int i4) {
            a.this.k(i4);
        }

        @Override // k.f
        protected V i(int i4, V v4) {
            return a.this.l(i4, v4);
        }
    }

    public a() {
    }

    public a(g gVar) {
        super(gVar);
    }

    private f<K, V> n() {
        if (this.f4285i == null) {
            this.f4285i = new C0053a();
        }
        return this.f4285i;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return n().m();
    }

    public boolean o(Collection<?> collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f4335d + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n().n();
    }
}
