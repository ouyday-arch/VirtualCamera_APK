package i;

import i.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f4100f = new HashMap<>();

    @Override // i.b
    protected b.c<K, V> c(K k4) {
        return this.f4100f.get(k4);
    }

    public boolean contains(K k4) {
        return this.f4100f.containsKey(k4);
    }

    @Override // i.b
    public V g(K k4) {
        V v4 = (V) super.g(k4);
        this.f4100f.remove(k4);
        return v4;
    }

    public Map.Entry<K, V> h(K k4) {
        if (contains(k4)) {
            return this.f4100f.get(k4).f4108e;
        }
        return null;
    }

    public V i(K k4, V v4) {
        b.c<K, V> c5 = c(k4);
        if (c5 != null) {
            return c5.f4106c;
        }
        this.f4100f.put(k4, f(k4, v4));
        return null;
    }
}
