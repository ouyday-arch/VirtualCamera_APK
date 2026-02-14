package h1;

import g1.o;
import g1.q;

/* loaded from: classes.dex */
public final class b implements o {
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e A[LOOP:0: B:25:0x005c->B:26:0x005e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // g1.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g1.q a(g1.c r11, java.util.Map<g1.e, ?> r12) {
        /*
            r10 = this;
            j1.a r0 = new j1.a
            n1.b r11 = r11.a()
            r0.<init>(r11)
            r11 = 0
            r1 = 0
            h1.a r2 = r0.a(r11)     // Catch: g1.h -> L25 g1.m -> L2b
            g1.s[] r3 = r2.b()     // Catch: g1.h -> L25 g1.m -> L2b
            i1.a r4 = new i1.a     // Catch: g1.h -> L21 g1.m -> L23
            r4.<init>()     // Catch: g1.h -> L21 g1.m -> L23
            n1.e r2 = r4.c(r2)     // Catch: g1.h -> L21 g1.m -> L23
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L2f
        L21:
            r2 = move-exception
            goto L27
        L23:
            r2 = move-exception
            goto L2d
        L25:
            r2 = move-exception
            r3 = r1
        L27:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L2f
        L2b:
            r2 = move-exception
            r3 = r1
        L2d:
            r4 = r3
            r3 = r1
        L2f:
            if (r1 != 0) goto L4e
            r1 = 1
            h1.a r0 = r0.a(r1)     // Catch: g1.h -> L44 g1.m -> L46
            g1.s[] r4 = r0.b()     // Catch: g1.h -> L44 g1.m -> L46
            i1.a r1 = new i1.a     // Catch: g1.h -> L44 g1.m -> L46
            r1.<init>()     // Catch: g1.h -> L44 g1.m -> L46
            n1.e r1 = r1.c(r0)     // Catch: g1.h -> L44 g1.m -> L46
            goto L4e
        L44:
            r11 = move-exception
            goto L47
        L46:
            r11 = move-exception
        L47:
            if (r2 != 0) goto L4d
            if (r3 == 0) goto L4c
            throw r3
        L4c:
            throw r11
        L4d:
            throw r2
        L4e:
            r6 = r4
            if (r12 == 0) goto L66
            g1.e r0 = g1.e.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r12 = r12.get(r0)
            g1.t r12 = (g1.t) r12
            if (r12 == 0) goto L66
            int r0 = r6.length
        L5c:
            if (r11 >= r0) goto L66
            r2 = r6[r11]
            r12.a(r2)
            int r11 = r11 + 1
            goto L5c
        L66:
            g1.q r11 = new g1.q
            java.lang.String r3 = r1.h()
            byte[] r4 = r1.e()
            int r5 = r1.c()
            g1.a r7 = g1.a.AZTEC
            long r8 = java.lang.System.currentTimeMillis()
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            java.util.List r12 = r1.a()
            if (r12 == 0) goto L89
            g1.r r0 = g1.r.BYTE_SEGMENTS
            r11.h(r0, r12)
        L89:
            java.lang.String r12 = r1.b()
            if (r12 == 0) goto L94
            g1.r r0 = g1.r.ERROR_CORRECTION_LEVEL
            r11.h(r0, r12)
        L94:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.b.a(g1.c, java.util.Map):g1.q");
    }

    @Override // g1.o
    public q b(g1.c cVar) {
        return a(cVar, null);
    }

    @Override // g1.o
    public void c() {
    }
}
