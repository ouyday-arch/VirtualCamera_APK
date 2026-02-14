package n1;

import g1.m;

/* loaded from: classes.dex */
public final class f extends i {
    @Override // n1.i
    public b c(b bVar, int i4, int i5, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        return d(bVar, i4, i5, k.b(f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19));
    }

    @Override // n1.i
    public b d(b bVar, int i4, int i5, k kVar) {
        if (i4 <= 0 || i5 <= 0) {
            throw m.a();
        }
        b bVar2 = new b(i4, i5);
        int i6 = i4 * 2;
        float[] fArr = new float[i6];
        for (int i7 = 0; i7 < i5; i7++) {
            float f4 = i7 + 0.5f;
            for (int i8 = 0; i8 < i6; i8 += 2) {
                fArr[i8] = (i8 / 2) + 0.5f;
                fArr[i8 + 1] = f4;
            }
            kVar.f(fArr);
            i.a(bVar, fArr);
            for (int i9 = 0; i9 < i6; i9 += 2) {
                try {
                    if (bVar.e((int) fArr[i9], (int) fArr[i9 + 1])) {
                        bVar2.n(i9 / 2, i7);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw m.a();
                }
            }
        }
        return bVar2;
    }
}
