package q1;

import g1.f;
import g1.g;
import g1.u;
import java.util.Map;
import t1.e;
import t1.i;
import t1.j;
import t1.k;
import t1.l;

/* loaded from: classes.dex */
public final class b implements u {
    private static n1.b b(i2.b bVar, int i4, int i5) {
        n1.b bVar2;
        int e4 = bVar.e();
        int d5 = bVar.d();
        int max = Math.max(i4, e4);
        int max2 = Math.max(i5, d5);
        int min = Math.min(max / e4, max2 / d5);
        int i6 = (max - (e4 * min)) / 2;
        int i7 = (max2 - (d5 * min)) / 2;
        if (i5 < d5 || i4 < e4) {
            bVar2 = new n1.b(e4, d5);
            i6 = 0;
            i7 = 0;
        } else {
            bVar2 = new n1.b(i4, i5);
        }
        bVar2.b();
        int i8 = 0;
        while (i8 < d5) {
            int i9 = i6;
            int i10 = 0;
            while (i10 < e4) {
                if (bVar.b(i10, i8) == 1) {
                    bVar2.o(i9, i7, min, min);
                }
                i10++;
                i9 += min;
            }
            i8++;
            i7 += min;
        }
        return bVar2;
    }

    private static n1.b c(e eVar, k kVar, int i4, int i5) {
        int h4 = kVar.h();
        int g4 = kVar.g();
        i2.b bVar = new i2.b(kVar.j(), kVar.i());
        int i6 = 0;
        for (int i7 = 0; i7 < g4; i7++) {
            if (i7 % kVar.f5940e == 0) {
                int i8 = 0;
                for (int i9 = 0; i9 < kVar.j(); i9++) {
                    bVar.g(i8, i6, i9 % 2 == 0);
                    i8++;
                }
                i6++;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < h4; i11++) {
                if (i11 % kVar.f5939d == 0) {
                    bVar.g(i10, i6, true);
                    i10++;
                }
                bVar.g(i10, i6, eVar.e(i11, i7));
                i10++;
                int i12 = kVar.f5939d;
                if (i11 % i12 == i12 - 1) {
                    bVar.g(i10, i6, i7 % 2 == 0);
                    i10++;
                }
            }
            i6++;
            int i13 = kVar.f5940e;
            if (i7 % i13 == i13 - 1) {
                int i14 = 0;
                for (int i15 = 0; i15 < kVar.j(); i15++) {
                    bVar.g(i14, i6, true);
                    i14++;
                }
                i6++;
            }
        }
        return b(bVar, i4, i5);
    }

    @Override // g1.u
    public n1.b a(String str, g1.a aVar, int i4, int i5, Map<g, ?> map) {
        f fVar;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != g1.a.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(aVar)));
        }
        if (i4 < 0 || i5 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i4 + 'x' + i5);
        }
        l lVar = l.FORCE_NONE;
        f fVar2 = null;
        if (map != null) {
            l lVar2 = (l) map.get(g.DATA_MATRIX_SHAPE);
            if (lVar2 != null) {
                lVar = lVar2;
            }
            f fVar3 = (f) map.get(g.MIN_SIZE);
            if (fVar3 == null) {
                fVar3 = null;
            }
            fVar = (f) map.get(g.MAX_SIZE);
            if (fVar == null) {
                fVar = null;
            }
            fVar2 = fVar3;
        } else {
            fVar = null;
        }
        String b5 = j.b(str, lVar, fVar2, fVar);
        k l4 = k.l(b5.length(), lVar, fVar2, fVar, true);
        e eVar = new e(i.b(b5, l4), l4.h(), l4.g());
        eVar.h();
        return c(eVar, l4, i4, i5);
    }
}
