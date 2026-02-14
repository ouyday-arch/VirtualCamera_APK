package c4;

import b4.d0;

/* loaded from: classes.dex */
public final class d {
    public static final int a(int[] iArr, int i4, int i5, int i6) {
        e3.f.e(iArr, "<this>");
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int i9 = iArr[i8];
            if (i9 < i4) {
                i5 = i8 + 1;
            } else {
                if (i9 <= i4) {
                    return i8;
                }
                i7 = i8 - 1;
            }
        }
        return (-i5) - 1;
    }

    public static final int b(d0 d0Var, int i4) {
        e3.f.e(d0Var, "<this>");
        int a5 = a(d0Var.F(), i4 + 1, 0, d0Var.G().length);
        return a5 >= 0 ? a5 : ~a5;
    }
}
