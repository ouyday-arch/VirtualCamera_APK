package h1;

import g1.g;
import g1.u;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* loaded from: classes.dex */
public final class c implements u {
    private static n1.b b(String str, g1.a aVar, int i4, int i5, Charset charset, int i6, int i7) {
        if (aVar == g1.a.AZTEC) {
            return c(k1.c.d(str.getBytes(charset), i6, i7), i4, i5);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
    }

    private static n1.b c(k1.a aVar, int i4, int i5) {
        n1.b a5 = aVar.a();
        if (a5 == null) {
            throw new IllegalStateException();
        }
        int l4 = a5.l();
        int h4 = a5.h();
        int max = Math.max(i4, l4);
        int max2 = Math.max(i5, h4);
        int min = Math.min(max / l4, max2 / h4);
        int i6 = (max - (l4 * min)) / 2;
        int i7 = (max2 - (h4 * min)) / 2;
        n1.b bVar = new n1.b(max, max2);
        int i8 = 0;
        while (i8 < h4) {
            int i9 = 0;
            int i10 = i6;
            while (i9 < l4) {
                if (a5.e(i9, i8)) {
                    bVar.o(i10, i7, min, min);
                }
                i9++;
                i10 += min;
            }
            i8++;
            i7 += min;
        }
        return bVar;
    }

    @Override // g1.u
    public n1.b a(String str, g1.a aVar, int i4, int i5, Map<g, ?> map) {
        Charset charset = StandardCharsets.ISO_8859_1;
        int i6 = 0;
        if (map != null) {
            g gVar = g.CHARACTER_SET;
            if (map.containsKey(gVar)) {
                charset = Charset.forName(map.get(gVar).toString());
            }
            g gVar2 = g.ERROR_CORRECTION;
            r1 = map.containsKey(gVar2) ? Integer.parseInt(map.get(gVar2).toString()) : 33;
            g gVar3 = g.AZTEC_LAYERS;
            if (map.containsKey(gVar3)) {
                i6 = Integer.parseInt(map.get(gVar3).toString());
            }
        }
        return b(str, aVar, i4, i5, charset, r1, i6);
    }
}
