package g1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class k implements o {

    /* renamed from: c, reason: collision with root package name */
    private static final o[] f3949c = new o[0];

    /* renamed from: a, reason: collision with root package name */
    private Map<e, ?> f3950a;

    /* renamed from: b, reason: collision with root package name */
    private o[] f3951b;

    private q d(c cVar) {
        o[] oVarArr = this.f3951b;
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                try {
                    return oVar.a(cVar, this.f3950a);
                } catch (p unused) {
                }
            }
        }
        throw m.a();
    }

    @Override // g1.o
    public q a(c cVar, Map<e, ?> map) {
        f(map);
        return d(cVar);
    }

    @Override // g1.o
    public q b(c cVar) {
        f(null);
        return d(cVar);
    }

    @Override // g1.o
    public void c() {
        o[] oVarArr = this.f3951b;
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                oVar.c();
            }
        }
    }

    public q e(c cVar) {
        if (this.f3951b == null) {
            f(null);
        }
        return d(cVar);
    }

    public void f(Map<e, ?> map) {
        this.f3950a = map;
        boolean z4 = true;
        boolean z5 = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(a.UPC_A) && !collection.contains(a.UPC_E) && !collection.contains(a.EAN_13) && !collection.contains(a.EAN_8) && !collection.contains(a.CODABAR) && !collection.contains(a.CODE_39) && !collection.contains(a.CODE_93) && !collection.contains(a.CODE_128) && !collection.contains(a.ITF) && !collection.contains(a.RSS_14) && !collection.contains(a.RSS_EXPANDED)) {
                z4 = false;
            }
            if (z4 && !z5) {
                arrayList.add(new w1.p(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new f2.a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new q1.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new h1.b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new a2.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new u1.a());
            }
            if (z4 && z5) {
                arrayList.add(new w1.p(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z5) {
                arrayList.add(new w1.p(map));
            }
            arrayList.add(new f2.a());
            arrayList.add(new q1.a());
            arrayList.add(new h1.b());
            arrayList.add(new a2.b());
            arrayList.add(new u1.a());
            if (z5) {
                arrayList.add(new w1.p(map));
            }
        }
        this.f3951b = (o[]) arrayList.toArray(f3949c);
    }
}
