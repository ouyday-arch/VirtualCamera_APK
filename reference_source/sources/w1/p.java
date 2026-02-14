package w1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class p extends r {

    /* renamed from: b, reason: collision with root package name */
    private static final r[] f6391b = new r[0];

    /* renamed from: a, reason: collision with root package name */
    private final r[] f6392a;

    public p(Map<g1.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(g1.e.POSSIBLE_FORMATS);
        boolean z4 = (map == null || map.get(g1.e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(g1.a.EAN_13) || collection.contains(g1.a.UPC_A) || collection.contains(g1.a.EAN_8) || collection.contains(g1.a.UPC_E)) {
                arrayList.add(new q(map));
            }
            if (collection.contains(g1.a.CODE_39)) {
                arrayList.add(new e(z4));
            }
            if (collection.contains(g1.a.CODE_93)) {
                arrayList.add(new g());
            }
            if (collection.contains(g1.a.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(g1.a.ITF)) {
                arrayList.add(new n());
            }
            if (collection.contains(g1.a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(g1.a.RSS_14)) {
                arrayList.add(new x1.e());
            }
            if (collection.contains(g1.a.RSS_EXPANDED)) {
                arrayList.add(new y1.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new q(map));
            arrayList.add(new e());
            arrayList.add(new a());
            arrayList.add(new g());
            arrayList.add(new c());
            arrayList.add(new n());
            arrayList.add(new x1.e());
            arrayList.add(new y1.d());
        }
        this.f6392a = (r[]) arrayList.toArray(f6391b);
    }

    @Override // w1.r, g1.o
    public void c() {
        for (r rVar : this.f6392a) {
            rVar.c();
        }
    }

    @Override // w1.r
    public g1.q d(int i4, n1.a aVar, Map<g1.e, ?> map) {
        for (r rVar : this.f6392a) {
            try {
                return rVar.d(i4, aVar, map);
            } catch (g1.p unused) {
            }
        }
        throw g1.m.a();
    }
}
