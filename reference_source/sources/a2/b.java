package a2;

import b2.j;
import g1.e;
import g1.m;
import g1.o;
import g1.q;
import g1.r;
import g1.s;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements o {

    /* renamed from: a, reason: collision with root package name */
    private static final q[] f292a = new q[0];

    private static q[] d(g1.c cVar, Map<e, ?> map, boolean z4) {
        ArrayList arrayList = new ArrayList();
        d2.b b5 = d2.a.b(cVar, map, z4);
        for (s[] sVarArr : b5.b()) {
            n1.e i4 = j.i(b5.a(), sVarArr[4], sVarArr[5], sVarArr[6], sVarArr[7], g(sVarArr), e(sVarArr));
            q qVar = new q(i4.h(), i4.e(), sVarArr, g1.a.PDF_417);
            qVar.h(r.ERROR_CORRECTION_LEVEL, i4.b());
            c cVar2 = (c) i4.d();
            if (cVar2 != null) {
                qVar.h(r.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(qVar);
        }
        return (q[]) arrayList.toArray(f292a);
    }

    private static int e(s[] sVarArr) {
        return Math.max(Math.max(f(sVarArr[0], sVarArr[4]), (f(sVarArr[6], sVarArr[2]) * 17) / 18), Math.max(f(sVarArr[1], sVarArr[5]), (f(sVarArr[7], sVarArr[3]) * 17) / 18));
    }

    private static int f(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return 0;
        }
        return (int) Math.abs(sVar.c() - sVar2.c());
    }

    private static int g(s[] sVarArr) {
        return Math.min(Math.min(h(sVarArr[0], sVarArr[4]), (h(sVarArr[6], sVarArr[2]) * 17) / 18), Math.min(h(sVarArr[1], sVarArr[5]), (h(sVarArr[7], sVarArr[3]) * 17) / 18));
    }

    private static int h(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(sVar.c() - sVar2.c());
    }

    @Override // g1.o
    public q a(g1.c cVar, Map<e, ?> map) {
        q[] d5 = d(cVar, map, false);
        if (d5.length == 0 || d5[0] == null) {
            throw m.a();
        }
        return d5[0];
    }

    @Override // g1.o
    public q b(g1.c cVar) {
        return a(cVar, null);
    }

    @Override // g1.o
    public void c() {
    }
}
