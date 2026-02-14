package w1;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class r implements g1.o {
    /* JADX WARN: Removed duplicated region for block: B:36:0x007c A[Catch: p -> 0x00cc, TRY_LEAVE, TryCatch #0 {p -> 0x00cc, blocks: (B:34:0x0076, B:36:0x007c), top: B:33:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private g1.q e(g1.c r22, java.util.Map<g1.e, ?> r23) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.r.e(g1.c, java.util.Map):g1.q");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static float f(int[] iArr, int[] iArr2, float f4) {
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            i4 += iArr[i6];
            i5 += iArr2[i6];
        }
        if (i4 < i5) {
            return Float.POSITIVE_INFINITY;
        }
        float f5 = i4;
        float f6 = f5 / i5;
        float f7 = f4 * f6;
        float f8 = 0.0f;
        for (int i7 = 0; i7 < length; i7++) {
            float f9 = iArr2[i7] * f6;
            float f10 = iArr[i7];
            float f11 = f10 > f9 ? f10 - f9 : f9 - f10;
            if (f11 > f7) {
                return Float.POSITIVE_INFINITY;
            }
            f8 += f11;
        }
        return f8 / f5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void g(n1.a aVar, int i4, int[] iArr) {
        int length = iArr.length;
        int i5 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int l4 = aVar.l();
        if (i4 >= l4) {
            throw g1.m.a();
        }
        boolean z4 = !aVar.g(i4);
        while (i4 < l4) {
            if (aVar.g(i4) == z4) {
                i5++;
                if (i5 == length) {
                    break;
                }
                iArr[i5] = 1;
                z4 = !z4;
            } else {
                iArr[i5] = iArr[i5] + 1;
            }
            i4++;
        }
        if (i5 != length) {
            if (i5 != length - 1 || i4 != l4) {
                throw g1.m.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void h(n1.a aVar, int i4, int[] iArr) {
        int length = iArr.length;
        boolean g4 = aVar.g(i4);
        while (i4 > 0 && length >= 0) {
            i4--;
            if (aVar.g(i4) != g4) {
                length--;
                g4 = !g4;
            }
        }
        if (length >= 0) {
            throw g1.m.a();
        }
        g(aVar, i4 + 1, iArr);
    }

    @Override // g1.o
    public g1.q a(g1.c cVar, Map<g1.e, ?> map) {
        try {
            return e(cVar, map);
        } catch (g1.m e4) {
            if (!(map != null && map.containsKey(g1.e.TRY_HARDER)) || !cVar.e()) {
                throw e4;
            }
            g1.c f4 = cVar.f();
            g1.q e5 = e(f4, map);
            Map<g1.r, Object> d5 = e5.d();
            int i4 = 270;
            if (d5 != null) {
                g1.r rVar = g1.r.ORIENTATION;
                if (d5.containsKey(rVar)) {
                    i4 = (((Integer) d5.get(rVar)).intValue() + 270) % 360;
                }
            }
            e5.h(g1.r.ORIENTATION, Integer.valueOf(i4));
            g1.s[] e6 = e5.e();
            if (e6 != null) {
                int c5 = f4.c();
                for (int i5 = 0; i5 < e6.length; i5++) {
                    e6[i5] = new g1.s((c5 - e6[i5].d()) - 1.0f, e6[i5].c());
                }
            }
            return e5;
        }
    }

    @Override // g1.o
    public g1.q b(g1.c cVar) {
        return a(cVar, null);
    }

    @Override // g1.o
    public void c() {
    }

    public abstract g1.q d(int i4, n1.a aVar, Map<g1.e, ?> map);
}
