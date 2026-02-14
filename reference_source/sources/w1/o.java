package w1;

import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public final class o extends s {

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f6388b = {1, 1, 1, 1};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f6389c = {3, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f6390d = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // w1.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        s.c(str);
        boolean[] zArr = new boolean[(length * 9) + 9];
        int b5 = s.b(zArr, 0, f6388b, true);
        for (int i4 = 0; i4 < length; i4 += 2) {
            int digit = Character.digit(str.charAt(i4), 10);
            int digit2 = Character.digit(str.charAt(i4 + 1), 10);
            int[] iArr = new int[10];
            for (int i5 = 0; i5 < 5; i5++) {
                int i6 = i5 * 2;
                int[][] iArr2 = f6390d;
                iArr[i6] = iArr2[digit][i5];
                iArr[i6 + 1] = iArr2[digit2][i5];
            }
            b5 += s.b(zArr, b5, iArr, true);
        }
        s.b(zArr, b5, f6389c, true);
        return zArr;
    }

    @Override // w1.s
    protected Collection<g1.a> f() {
        return Collections.singleton(g1.a.ITF);
    }
}
