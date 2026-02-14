package n1;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: e, reason: collision with root package name */
    private b f5311e;

    public j(g1.j jVar) {
        super(jVar);
    }

    private static int[][] i(byte[] bArr, int i4, int i5, int i6, int i7) {
        char c5;
        int i8 = 8;
        int i9 = i7 - 8;
        int i10 = i6 - 8;
        char c6 = 2;
        boolean z4 = true;
        int i11 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i5, i4);
        int i12 = 0;
        while (i12 < i5) {
            int i13 = i12 << 3;
            if (i13 > i9) {
                i13 = i9;
            }
            int i14 = i11;
            while (i14 < i4) {
                int i15 = i14 << 3;
                if (i15 > i10) {
                    i15 = i10;
                }
                int i16 = (i13 * i6) + i15;
                int i17 = i11;
                int i18 = i17;
                int i19 = i18;
                int i20 = 255;
                while (i17 < i8) {
                    int i21 = i19;
                    int i22 = 0;
                    while (i22 < i8) {
                        int i23 = bArr[i16 + i22] & 255;
                        i18 += i23;
                        if (i23 < i20) {
                            i20 = i23;
                        }
                        if (i23 > i21) {
                            i21 = i23;
                        }
                        i22++;
                        i8 = 8;
                    }
                    if (i21 - i20 <= 24) {
                        i17++;
                        i16 += i6;
                        i19 = i21;
                        z4 = true;
                        i8 = 8;
                    }
                    while (true) {
                        i17++;
                        i16 += i6;
                        if (i17 < 8) {
                            int i24 = 0;
                            for (int i25 = 8; i24 < i25; i25 = 8) {
                                i18 += bArr[i16 + i24] & 255;
                                i24++;
                            }
                        }
                    }
                    i17++;
                    i16 += i6;
                    i19 = i21;
                    z4 = true;
                    i8 = 8;
                }
                boolean z5 = z4;
                int i26 = i18 >> 6;
                if (i19 - i20 <= 24) {
                    i26 = i20 / 2;
                    if (i12 > 0 && i14 > 0) {
                        int i27 = i12 - 1;
                        int i28 = i14 - 1;
                        c5 = 2;
                        int i29 = ((iArr[i27][i14] + (iArr[i12][i28] * 2)) + iArr[i27][i28]) / 4;
                        if (i20 < i29) {
                            i26 = i29;
                        }
                        iArr[i12][i14] = i26;
                        i14++;
                        z4 = z5;
                        c6 = c5;
                        i8 = 8;
                        i11 = 0;
                    }
                }
                c5 = 2;
                iArr[i12][i14] = i26;
                i14++;
                z4 = z5;
                c6 = c5;
                i8 = 8;
                i11 = 0;
            }
            i12++;
            i8 = 8;
            i11 = 0;
        }
        return iArr;
    }

    private static void j(byte[] bArr, int i4, int i5, int i6, int i7, int[][] iArr, b bVar) {
        int i8 = i7 - 8;
        int i9 = i6 - 8;
        for (int i10 = 0; i10 < i5; i10++) {
            int i11 = i10 << 3;
            int i12 = i11 > i8 ? i8 : i11;
            int k4 = k(i10, i5 - 3);
            for (int i13 = 0; i13 < i4; i13++) {
                int i14 = i13 << 3;
                int i15 = i14 > i9 ? i9 : i14;
                int k5 = k(i13, i4 - 3);
                int i16 = 0;
                for (int i17 = -2; i17 <= 2; i17++) {
                    int[] iArr2 = iArr[k4 + i17];
                    i16 += iArr2[k5 - 2] + iArr2[k5 - 1] + iArr2[k5] + iArr2[k5 + 1] + iArr2[2 + k5];
                }
                l(bArr, i15, i12, i16 / 25, i6, bVar);
            }
        }
    }

    private static int k(int i4, int i5) {
        if (i4 < 2) {
            return 2;
        }
        return Math.min(i4, i5);
    }

    private static void l(byte[] bArr, int i4, int i5, int i6, int i7, b bVar) {
        int i8 = (i5 * i7) + i4;
        int i9 = 0;
        while (i9 < 8) {
            for (int i10 = 0; i10 < 8; i10++) {
                if ((bArr[i8 + i10] & 255) <= i6) {
                    bVar.n(i4 + i10, i5 + i9);
                }
            }
            i9++;
            i8 += i7;
        }
    }

    @Override // g1.b
    public g1.b a(g1.j jVar) {
        return new j(jVar);
    }

    @Override // n1.h, g1.b
    public b b() {
        b b5;
        b bVar = this.f5311e;
        if (bVar != null) {
            return bVar;
        }
        g1.j e4 = e();
        int d5 = e4.d();
        int a5 = e4.a();
        if (d5 < 40 || a5 < 40) {
            b5 = super.b();
        } else {
            byte[] b6 = e4.b();
            int i4 = d5 >> 3;
            if ((d5 & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int i6 = a5 >> 3;
            if ((a5 & 7) != 0) {
                i6++;
            }
            int i7 = i6;
            int[][] i8 = i(b6, i5, i7, d5, a5);
            b5 = new b(d5, a5);
            j(b6, i5, i7, d5, a5, i8, b5);
        }
        this.f5311e = b5;
        return this.f5311e;
    }
}
