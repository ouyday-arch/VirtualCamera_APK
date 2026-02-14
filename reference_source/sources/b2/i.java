package b2;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final float[][] f2289a = (float[][]) Array.newInstance((Class<?>) float.class, a2.a.f290b.length, 8);

    static {
        int i4;
        int i5 = 0;
        while (true) {
            int[] iArr = a2.a.f290b;
            if (i5 >= iArr.length) {
                return;
            }
            int i6 = iArr[i5];
            int i7 = i6 & 1;
            int i8 = 0;
            while (i8 < 8) {
                float f4 = 0.0f;
                while (true) {
                    i4 = i6 & 1;
                    if (i4 == i7) {
                        f4 += 1.0f;
                        i6 >>= 1;
                    }
                }
                f2289a[i5][(8 - i8) - 1] = f4 / 17.0f;
                i8++;
                i7 = i4;
            }
            i5++;
        }
    }

    private static int a(int[] iArr) {
        long j4 = 0;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            for (int i5 = 0; i5 < iArr[i4]; i5++) {
                int i6 = 1;
                long j5 = j4 << 1;
                if (i4 % 2 != 0) {
                    i6 = 0;
                }
                j4 = j5 | i6;
            }
        }
        return (int) j4;
    }

    private static int b(int[] iArr) {
        int d5 = o1.a.d(iArr);
        float[] fArr = new float[8];
        if (d5 > 1) {
            for (int i4 = 0; i4 < 8; i4++) {
                fArr[i4] = iArr[i4] / d5;
            }
        }
        float f4 = Float.MAX_VALUE;
        int i5 = -1;
        int i6 = 0;
        while (true) {
            float[][] fArr2 = f2289a;
            if (i6 >= fArr2.length) {
                return i5;
            }
            float f5 = 0.0f;
            float[] fArr3 = fArr2[i6];
            for (int i7 = 0; i7 < 8; i7++) {
                float f6 = fArr3[i7] - fArr[i7];
                f5 += f6 * f6;
                if (f5 >= f4) {
                    break;
                }
            }
            if (f5 < f4) {
                i5 = a2.a.f290b[i6];
                f4 = f5;
            }
            i6++;
        }
    }

    private static int c(int[] iArr) {
        int a5 = a(iArr);
        if (a2.a.a(a5) == -1) {
            return -1;
        }
        return a5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int[] iArr) {
        int c5 = c(e(iArr));
        return c5 != -1 ? c5 : b(iArr);
    }

    private static int[] e(int[] iArr) {
        float d5 = o1.a.d(iArr);
        int[] iArr2 = new int[8];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < 17; i6++) {
            if (iArr[i5] + i4 <= (d5 / 34.0f) + ((i6 * d5) / 17.0f)) {
                i4 += iArr[i5];
                i5++;
            }
            iArr2[i5] = iArr2[i5] + 1;
        }
        return iArr2;
    }
}
