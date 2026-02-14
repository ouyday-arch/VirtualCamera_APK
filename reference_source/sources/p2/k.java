package p2;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k implements h {

    /* renamed from: a, reason: collision with root package name */
    private Collection<g1.a> f5454a;

    /* renamed from: b, reason: collision with root package name */
    private Map<g1.e, ?> f5455b;

    /* renamed from: c, reason: collision with root package name */
    private String f5456c;

    /* renamed from: d, reason: collision with root package name */
    private int f5457d;

    public k() {
    }

    public k(Collection<g1.a> collection, Map<g1.e, ?> map, String str, int i4) {
        this.f5454a = collection;
        this.f5455b = map;
        this.f5456c = str;
        this.f5457d = i4;
    }

    @Override // p2.h
    public g a(Map<g1.e, ?> map) {
        EnumMap enumMap = new EnumMap(g1.e.class);
        enumMap.putAll(map);
        Map<g1.e, ?> map2 = this.f5455b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection<g1.a> collection = this.f5454a;
        if (collection != null) {
            enumMap.put((EnumMap) g1.e.POSSIBLE_FORMATS, (g1.e) collection);
        }
        String str = this.f5456c;
        if (str != null) {
            enumMap.put((EnumMap) g1.e.CHARACTER_SET, (g1.e) str);
        }
        g1.k kVar = new g1.k();
        kVar.f(enumMap);
        int i4 = this.f5457d;
        return i4 != 0 ? i4 != 1 ? i4 != 2 ? new g(kVar) : new m(kVar) : new l(kVar) : new g(kVar);
    }
}
