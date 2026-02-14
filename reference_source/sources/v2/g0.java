package v2;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g0 extends f0 {
    public static <K, V> Map<K, V> c() {
        z zVar = z.f6298b;
        e3.f.c(zVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return zVar;
    }

    public static <K, V> Map<K, V> d(u2.g<? extends K, ? extends V>... gVarArr) {
        e3.f.e(gVarArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(f0.a(gVarArr.length));
        e(linkedHashMap, gVarArr);
        return linkedHashMap;
    }

    public static final <K, V> void e(Map<? super K, ? super V> map, u2.g<? extends K, ? extends V>[] gVarArr) {
        e3.f.e(map, "<this>");
        e3.f.e(gVarArr, "pairs");
        for (u2.g<? extends K, ? extends V> gVar : gVarArr) {
            map.put(gVar.a(), gVar.b());
        }
    }

    public static <K, V> Map<K, V> f(Map<? extends K, ? extends V> map) {
        e3.f.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? d0.g(map) : f0.b(map) : d0.c();
    }

    public static <K, V> Map<K, V> g(Map<? extends K, ? extends V> map) {
        e3.f.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
