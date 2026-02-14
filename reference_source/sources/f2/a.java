package f2;

import g1.c;
import g1.m;
import g1.o;
import g1.q;
import g1.r;
import g1.s;
import g2.e;
import g2.i;
import java.util.List;
import java.util.Map;
import n1.g;

/* loaded from: classes.dex */
public class a implements o {

    /* renamed from: b, reason: collision with root package name */
    private static final s[] f3722b = new s[0];

    /* renamed from: a, reason: collision with root package name */
    private final e f3723a = new e();

    private static n1.b d(n1.b bVar) {
        int[] k4 = bVar.k();
        int[] f4 = bVar.f();
        if (k4 == null || f4 == null) {
            throw m.a();
        }
        float e4 = e(k4, bVar);
        int i4 = k4[1];
        int i5 = f4[1];
        int i6 = k4[0];
        int i7 = f4[0];
        if (i6 >= i7 || i4 >= i5) {
            throw m.a();
        }
        int i8 = i5 - i4;
        if (i8 != i7 - i6 && (i7 = i6 + i8) >= bVar.l()) {
            throw m.a();
        }
        int round = Math.round(((i7 - i6) + 1) / e4);
        int round2 = Math.round((i8 + 1) / e4);
        if (round <= 0 || round2 <= 0) {
            throw m.a();
        }
        if (round2 != round) {
            throw m.a();
        }
        int i9 = (int) (e4 / 2.0f);
        int i10 = i4 + i9;
        int i11 = i6 + i9;
        int i12 = (((int) ((round - 1) * e4)) + i11) - i7;
        if (i12 > 0) {
            if (i12 > i9) {
                throw m.a();
            }
            i11 -= i12;
        }
        int i13 = (((int) ((round2 - 1) * e4)) + i10) - i5;
        if (i13 > 0) {
            if (i13 > i9) {
                throw m.a();
            }
            i10 -= i13;
        }
        n1.b bVar2 = new n1.b(round, round2);
        for (int i14 = 0; i14 < round2; i14++) {
            int i15 = ((int) (i14 * e4)) + i10;
            for (int i16 = 0; i16 < round; i16++) {
                if (bVar.e(((int) (i16 * e4)) + i11, i15)) {
                    bVar2.n(i16, i14);
                }
            }
        }
        return bVar2;
    }

    private static float e(int[] iArr, n1.b bVar) {
        int h4 = bVar.h();
        int l4 = bVar.l();
        int i4 = iArr[0];
        boolean z4 = true;
        int i5 = iArr[1];
        int i6 = 0;
        while (i4 < l4 && i5 < h4) {
            if (z4 != bVar.e(i4, i5)) {
                i6++;
                if (i6 == 5) {
                    break;
                }
                z4 = !z4;
            }
            i4++;
            i5++;
        }
        if (i4 == l4 || i5 == h4) {
            throw m.a();
        }
        return (i4 - iArr[0]) / 7.0f;
    }

    @Override // g1.o
    public final q a(c cVar, Map<g1.e, ?> map) {
        s[] b5;
        n1.e eVar;
        if (map == null || !map.containsKey(g1.e.PURE_BARCODE)) {
            g e4 = new h2.c(cVar.a()).e(map);
            n1.e c5 = this.f3723a.c(e4.a(), map);
            b5 = e4.b();
            eVar = c5;
        } else {
            eVar = this.f3723a.c(d(cVar.a()), map);
            b5 = f3722b;
        }
        if (eVar.d() instanceof i) {
            ((i) eVar.d()).a(b5);
        }
        q qVar = new q(eVar.h(), eVar.e(), b5, g1.a.QR_CODE);
        List<byte[]> a5 = eVar.a();
        if (a5 != null) {
            qVar.h(r.BYTE_SEGMENTS, a5);
        }
        String b6 = eVar.b();
        if (b6 != null) {
            qVar.h(r.ERROR_CORRECTION_LEVEL, b6);
        }
        if (eVar.i()) {
            qVar.h(r.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVar.g()));
            qVar.h(r.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVar.f()));
        }
        return qVar;
    }

    @Override // g1.o
    public q b(c cVar) {
        return a(cVar, null);
    }

    @Override // g1.o
    public void c() {
    }
}
