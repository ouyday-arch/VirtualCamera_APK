package n1;

import g1.m;

/* loaded from: classes.dex */
public class h extends g1.b {

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f5307d = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private byte[] f5308b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f5309c;

    public h(g1.j jVar) {
        super(jVar);
        this.f5308b = f5307d;
        this.f5309c = new int[32];
    }

    private static int g(int[] iArr) {
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (iArr[i7] > i4) {
                i4 = iArr[i7];
                i6 = i7;
            }
            if (iArr[i7] > i5) {
                i5 = iArr[i7];
            }
        }
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 - i6;
            int i12 = iArr[i10] * i11 * i11;
            if (i12 > i9) {
                i8 = i10;
                i9 = i12;
            }
        }
        if (i6 <= i8) {
            int i13 = i6;
            i6 = i8;
            i8 = i13;
        }
        if (i6 - i8 <= length / 16) {
            throw m.a();
        }
        int i14 = i6 - 1;
        int i15 = -1;
        int i16 = i14;
        while (i14 > i8) {
            int i17 = i14 - i8;
            int i18 = i17 * i17 * (i6 - i14) * (i5 - iArr[i14]);
            if (i18 > i15) {
                i16 = i14;
                i15 = i18;
            }
            i14--;
        }
        return i16 << 3;
    }

    private void h(int i4) {
        if (this.f5308b.length < i4) {
            this.f5308b = new byte[i4];
        }
        for (int i5 = 0; i5 < 32; i5++) {
            this.f5309c[i5] = 0;
        }
    }

    @Override // g1.b
    public b b() {
        g1.j e4 = e();
        int d5 = e4.d();
        int a5 = e4.a();
        b bVar = new b(d5, a5);
        h(d5);
        int[] iArr = this.f5309c;
        for (int i4 = 1; i4 < 5; i4++) {
            byte[] c5 = e4.c((a5 * i4) / 5, this.f5308b);
            int i5 = (d5 << 2) / 5;
            for (int i6 = d5 / 5; i6 < i5; i6++) {
                int i7 = (c5[i6] & 255) >> 3;
                iArr[i7] = iArr[i7] + 1;
            }
        }
        int g4 = g(iArr);
        byte[] b5 = e4.b();
        for (int i8 = 0; i8 < a5; i8++) {
            int i9 = i8 * d5;
            for (int i10 = 0; i10 < d5; i10++) {
                if ((b5[i9 + i10] & 255) < g4) {
                    bVar.n(i10, i8);
                }
            }
        }
        return bVar;
    }

    @Override // g1.b
    public a c(int i4, a aVar) {
        g1.j e4 = e();
        int d5 = e4.d();
        if (aVar == null || aVar.l() < d5) {
            aVar = new a(d5);
        } else {
            aVar.d();
        }
        h(d5);
        byte[] c5 = e4.c(i4, this.f5308b);
        int[] iArr = this.f5309c;
        for (int i5 = 0; i5 < d5; i5++) {
            int i6 = (c5[i5] & 255) >> 3;
            iArr[i6] = iArr[i6] + 1;
        }
        int g4 = g(iArr);
        if (d5 < 3) {
            for (int i7 = 0; i7 < d5; i7++) {
                if ((c5[i7] & 255) < g4) {
                    aVar.q(i7);
                }
            }
        } else {
            int i8 = 1;
            int i9 = c5[0] & 255;
            int i10 = c5[1] & 255;
            while (i8 < d5 - 1) {
                int i11 = i8 + 1;
                int i12 = c5[i11] & 255;
                if ((((i10 << 2) - i9) - i12) / 2 < g4) {
                    aVar.q(i8);
                }
                i9 = i10;
                i8 = i11;
                i10 = i12;
            }
        }
        return aVar;
    }
}
