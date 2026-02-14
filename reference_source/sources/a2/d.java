package a2;

import e2.e;
import g1.g;
import g1.u;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes.dex */
public final class d implements u {
    private static n1.b b(byte[][] bArr, int i4) {
        int i5 = i4 * 2;
        n1.b bVar = new n1.b(bArr[0].length + i5, bArr.length + i5);
        bVar.b();
        int h4 = (bVar.h() - i4) - 1;
        int i6 = 0;
        while (i6 < bArr.length) {
            byte[] bArr2 = bArr[i6];
            for (int i7 = 0; i7 < bArr[0].length; i7++) {
                if (bArr2[i7] == 1) {
                    bVar.n(i7 + i4, h4);
                }
            }
            i6++;
            h4--;
        }
        return bVar;
    }

    private static n1.b c(e eVar, String str, int i4, int i5, int i6, int i7) {
        boolean z4;
        eVar.e(str, i4);
        byte[][] b5 = eVar.f().b(1, 4);
        if ((i6 > i5) != (b5[0].length < b5.length)) {
            b5 = d(b5);
            z4 = true;
        } else {
            z4 = false;
        }
        int min = Math.min(i5 / b5[0].length, i6 / b5.length);
        if (min <= 1) {
            return b(b5, i7);
        }
        byte[][] b6 = eVar.f().b(min, min << 2);
        if (z4) {
            b6 = d(b6);
        }
        return b(b6, i7);
    }

    private static byte[][] d(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) byte.class, bArr[0].length, bArr.length);
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int length = (bArr.length - i4) - 1;
            for (int i5 = 0; i5 < bArr[0].length; i5++) {
                bArr2[i5][length] = bArr[i4][i5];
            }
        }
        return bArr2;
    }

    @Override // g1.u
    public n1.b a(String str, g1.a aVar, int i4, int i5, Map<g, ?> map) {
        if (aVar != g1.a.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(aVar)));
        }
        e eVar = new e();
        if (map != null) {
            g gVar = g.PDF417_COMPACT;
            if (map.containsKey(gVar)) {
                eVar.h(Boolean.parseBoolean(map.get(gVar).toString()));
            }
            g gVar2 = g.PDF417_COMPACTION;
            if (map.containsKey(gVar2)) {
                eVar.i(e2.c.valueOf(map.get(gVar2).toString()));
            }
            g gVar3 = g.PDF417_DIMENSIONS;
            if (map.containsKey(gVar3)) {
                e2.d dVar = (e2.d) map.get(gVar3);
                eVar.j(dVar.a(), dVar.c(), dVar.b(), dVar.d());
            }
            g gVar4 = g.MARGIN;
            r9 = map.containsKey(gVar4) ? Integer.parseInt(map.get(gVar4).toString()) : 30;
            g gVar5 = g.ERROR_CORRECTION;
            r0 = map.containsKey(gVar5) ? Integer.parseInt(map.get(gVar5).toString()) : 2;
            g gVar6 = g.CHARACTER_SET;
            if (map.containsKey(gVar6)) {
                eVar.k(Charset.forName(map.get(gVar6).toString()));
            }
        }
        return c(eVar, str, r0, i4, i5, r9);
    }
}
