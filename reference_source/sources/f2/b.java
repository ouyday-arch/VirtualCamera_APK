package f2;

import g1.g;
import g1.u;
import i2.c;
import i2.f;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements u {
    private static n1.b b(f fVar, int i4, int i5, int i6) {
        i2.b a5 = fVar.a();
        if (a5 == null) {
            throw new IllegalStateException();
        }
        int e4 = a5.e();
        int d5 = a5.d();
        int i7 = i6 << 1;
        int i8 = e4 + i7;
        int i9 = i7 + d5;
        int max = Math.max(i4, i8);
        int max2 = Math.max(i5, i9);
        int min = Math.min(max / i8, max2 / i9);
        int i10 = (max - (e4 * min)) / 2;
        int i11 = (max2 - (d5 * min)) / 2;
        n1.b bVar = new n1.b(max, max2);
        int i12 = 0;
        while (i12 < d5) {
            int i13 = 0;
            int i14 = i10;
            while (i13 < e4) {
                if (a5.b(i13, i12) == 1) {
                    bVar.o(i14, i11, min, min);
                }
                i13++;
                i14 += min;
            }
            i12++;
            i11 += min;
        }
        return bVar;
    }

    @Override // g1.u
    public n1.b a(String str, g1.a aVar, int i4, int i5, Map<g, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != g1.a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(aVar)));
        }
        if (i4 < 0 || i5 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i4 + 'x' + i5);
        }
        g2.f fVar = g2.f.L;
        int i6 = 4;
        if (map != null) {
            g gVar = g.ERROR_CORRECTION;
            if (map.containsKey(gVar)) {
                fVar = g2.f.valueOf(map.get(gVar).toString());
            }
            g gVar2 = g.MARGIN;
            if (map.containsKey(gVar2)) {
                i6 = Integer.parseInt(map.get(gVar2).toString());
            }
        }
        return b(c.n(str, fVar, map), i4, i5, i6);
    }
}
