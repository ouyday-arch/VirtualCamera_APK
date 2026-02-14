package x1;

/* loaded from: classes.dex */
public final class f {
    private static int a(int i4, int i5) {
        int i6 = i4 - i5;
        if (i6 > i5) {
            i6 = i5;
            i5 = i6;
        }
        int i7 = 1;
        int i8 = 1;
        while (i4 > i5) {
            i7 *= i4;
            if (i8 <= i6) {
                i7 /= i8;
                i8++;
            }
            i4--;
        }
        while (i8 <= i6) {
            i7 /= i8;
            i8++;
        }
        return i7;
    }

    public static int b(int[] iArr, int i4, boolean z4) {
        int[] iArr2 = iArr;
        int i5 = 0;
        for (int i6 : iArr2) {
            i5 += i6;
        }
        int length = iArr2.length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = length - 1;
            if (i7 >= i10) {
                return i8;
            }
            int i11 = 1 << i7;
            i9 |= i11;
            int i12 = 1;
            while (i12 < iArr2[i7]) {
                int i13 = i5 - i12;
                int i14 = length - i7;
                int i15 = i14 - 2;
                int a5 = a(i13 - 1, i15);
                if (z4 && i9 == 0) {
                    int i16 = i14 - 1;
                    if (i13 - i16 >= i16) {
                        a5 -= a(i13 - i14, i15);
                    }
                }
                if (i14 - 1 > 1) {
                    int i17 = 0;
                    for (int i18 = i13 - i15; i18 > i4; i18--) {
                        i17 += a((i13 - i18) - 1, i14 - 3);
                    }
                    a5 -= i17 * (i10 - i7);
                } else if (i13 > i4) {
                    a5--;
                }
                i8 += a5;
                i12++;
                i9 &= ~i11;
                iArr2 = iArr;
            }
            i5 -= i12;
            i7++;
            iArr2 = iArr;
        }
    }
}
