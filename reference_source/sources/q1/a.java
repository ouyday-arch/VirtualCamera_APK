package q1;

import g1.c;
import g1.e;
import g1.m;
import g1.o;
import g1.q;
import g1.r;
import g1.s;
import java.util.List;
import java.util.Map;
import n1.g;
import r1.d;

/* loaded from: classes.dex */
public final class a implements o {

    /* renamed from: b, reason: collision with root package name */
    private static final s[] f5533b = new s[0];

    /* renamed from: a, reason: collision with root package name */
    private final d f5534a = new d();

    private static n1.b d(n1.b bVar) {
        int[] k4 = bVar.k();
        int[] f4 = bVar.f();
        if (k4 == null || f4 == null) {
            throw m.a();
        }
        int e4 = e(k4, bVar);
        int i4 = k4[1];
        int i5 = f4[1];
        int i6 = k4[0];
        int i7 = ((f4[0] - i6) + 1) / e4;
        int i8 = ((i5 - i4) + 1) / e4;
        if (i7 <= 0 || i8 <= 0) {
            throw m.a();
        }
        int i9 = e4 / 2;
        int i10 = i4 + i9;
        int i11 = i6 + i9;
        n1.b bVar2 = new n1.b(i7, i8);
        for (int i12 = 0; i12 < i8; i12++) {
            int i13 = (i12 * e4) + i10;
            for (int i14 = 0; i14 < i7; i14++) {
                if (bVar.e((i14 * e4) + i11, i13)) {
                    bVar2.n(i14, i12);
                }
            }
        }
        return bVar2;
    }

    private static int e(int[] iArr, n1.b bVar) {
        int l4 = bVar.l();
        int i4 = iArr[0];
        int i5 = iArr[1];
        while (i4 < l4 && bVar.e(i4, i5)) {
            i4++;
        }
        if (i4 == l4) {
            throw m.a();
        }
        int i6 = i4 - iArr[0];
        if (i6 != 0) {
            return i6;
        }
        throw m.a();
    }

    @Override // g1.o
    public q a(c cVar, Map<e, ?> map) {
        s[] b5;
        n1.e eVar;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g b6 = new s1.a(cVar.a()).b();
            n1.e b7 = this.f5534a.b(b6.a());
            b5 = b6.b();
            eVar = b7;
        } else {
            eVar = this.f5534a.b(d(cVar.a()));
            b5 = f5533b;
        }
        q qVar = new q(eVar.h(), eVar.e(), b5, g1.a.DATA_MATRIX);
        List<byte[]> a5 = eVar.a();
        if (a5 != null) {
            qVar.h(r.BYTE_SEGMENTS, a5);
        }
        String b8 = eVar.b();
        if (b8 != null) {
            qVar.h(r.ERROR_CORRECTION_LEVEL, b8);
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
