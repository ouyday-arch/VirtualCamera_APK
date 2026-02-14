package w1;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class q extends r {

    /* renamed from: b, reason: collision with root package name */
    private static final y[] f6393b = new y[0];

    /* renamed from: a, reason: collision with root package name */
    private final y[] f6394a;

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q(java.util.Map<g1.e, ?> r3) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 != 0) goto L7
            r3 = 0
            goto Lf
        L7:
            g1.e r0 = g1.e.POSSIBLE_FORMATS
            java.lang.Object r3 = r3.get(r0)
            java.util.Collection r3 = (java.util.Collection) r3
        Lf:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L55
            g1.a r1 = g1.a.EAN_13
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L27
            w1.i r1 = new w1.i
            r1.<init>()
        L23:
            r0.add(r1)
            goto L35
        L27:
            g1.a r1 = g1.a.UPC_A
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L35
            w1.t r1 = new w1.t
            r1.<init>()
            goto L23
        L35:
            g1.a r1 = g1.a.EAN_8
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L45
            w1.k r1 = new w1.k
            r1.<init>()
            r0.add(r1)
        L45:
            g1.a r1 = g1.a.UPC_E
            boolean r3 = r3.contains(r1)
            if (r3 == 0) goto L55
            w1.a0 r3 = new w1.a0
            r3.<init>()
            r0.add(r3)
        L55:
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L73
            w1.i r3 = new w1.i
            r3.<init>()
            r0.add(r3)
            w1.k r3 = new w1.k
            r3.<init>()
            r0.add(r3)
            w1.a0 r3 = new w1.a0
            r3.<init>()
            r0.add(r3)
        L73:
            w1.y[] r3 = w1.q.f6393b
            java.lang.Object[] r3 = r0.toArray(r3)
            w1.y[] r3 = (w1.y[]) r3
            r2.f6394a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.q.<init>(java.util.Map):void");
    }

    @Override // w1.r, g1.o
    public void c() {
        for (y yVar : this.f6394a) {
            yVar.c();
        }
    }

    @Override // w1.r
    public g1.q d(int i4, n1.a aVar, Map<g1.e, ?> map) {
        boolean z4;
        int[] q4 = y.q(aVar);
        for (y yVar : this.f6394a) {
            try {
                g1.q n4 = yVar.n(i4, aVar, q4, map);
                boolean z5 = n4.b() == g1.a.EAN_13 && n4.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(g1.e.POSSIBLE_FORMATS);
                if (collection != null && !collection.contains(g1.a.UPC_A)) {
                    z4 = false;
                    if (z5 || !z4) {
                        return n4;
                    }
                    g1.q qVar = new g1.q(n4.f().substring(1), n4.c(), n4.e(), g1.a.UPC_A);
                    qVar.g(n4.d());
                    return qVar;
                }
                z4 = true;
                if (z5) {
                }
                return n4;
            } catch (g1.p unused) {
            }
        }
        throw g1.m.a();
    }
}
