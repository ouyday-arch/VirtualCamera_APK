package w1;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends r {

    /* renamed from: d, reason: collision with root package name */
    static final char[] f6349d = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: e, reason: collision with root package name */
    static final int[] f6350e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: f, reason: collision with root package name */
    private static final char[] f6351f = {'A', 'B', 'C', 'D'};

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f6352a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private int[] f6353b = new int[80];

    /* renamed from: c, reason: collision with root package name */
    private int f6354c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(char[] cArr, char c5) {
        if (cArr != null) {
            for (char c6 : cArr) {
                if (c6 == c5) {
                    return true;
                }
            }
        }
        return false;
    }

    private void j(int i4) {
        int[] iArr = this.f6353b;
        int i5 = this.f6354c;
        iArr[i5] = i4;
        int i6 = i5 + 1;
        this.f6354c = i6;
        if (i6 >= iArr.length) {
            int[] iArr2 = new int[i6 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.f6353b = iArr2;
        }
    }

    private int k() {
        for (int i4 = 1; i4 < this.f6354c; i4 += 2) {
            int m4 = m(i4);
            if (m4 != -1 && i(f6351f, f6349d[m4])) {
                int i5 = 0;
                for (int i6 = i4; i6 < i4 + 7; i6++) {
                    i5 += this.f6353b[i6];
                }
                if (i4 == 1 || this.f6353b[i4 - 1] >= i5 / 2) {
                    return i4;
                }
            }
        }
        throw g1.m.a();
    }

    private void l(n1.a aVar) {
        int i4 = 0;
        this.f6354c = 0;
        int k4 = aVar.k(0);
        int l4 = aVar.l();
        if (k4 >= l4) {
            throw g1.m.a();
        }
        boolean z4 = true;
        while (k4 < l4) {
            if (aVar.g(k4) != z4) {
                i4++;
            } else {
                j(i4);
                z4 = !z4;
                i4 = 1;
            }
            k4++;
        }
        j(i4);
    }

    private int m(int i4) {
        int i5 = i4 + 7;
        if (i5 >= this.f6354c) {
            return -1;
        }
        int[] iArr = this.f6353b;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        int i8 = Integer.MAX_VALUE;
        int i9 = 0;
        for (int i10 = i4; i10 < i5; i10 += 2) {
            int i11 = iArr[i10];
            if (i11 < i8) {
                i8 = i11;
            }
            if (i11 > i9) {
                i9 = i11;
            }
        }
        int i12 = (i8 + i9) / 2;
        int i13 = 0;
        for (int i14 = i4 + 1; i14 < i5; i14 += 2) {
            int i15 = iArr[i14];
            if (i15 < i6) {
                i6 = i15;
            }
            if (i15 > i13) {
                i13 = i15;
            }
        }
        int i16 = (i6 + i13) / 2;
        int i17 = 128;
        int i18 = 0;
        for (int i19 = 0; i19 < 7; i19++) {
            i17 >>= 1;
            if (iArr[i4 + i19] > ((i19 & 1) == 0 ? i12 : i16)) {
                i18 |= i17;
            }
        }
        while (true) {
            int[] iArr2 = f6350e;
            if (i7 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i7] == i18) {
                return i7;
            }
            i7++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ad, code lost:
    
        throw g1.m.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void n(int r15) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.a.n(int):void");
    }

    @Override // w1.r
    public g1.q d(int i4, n1.a aVar, Map<g1.e, ?> map) {
        Arrays.fill(this.f6353b, 0);
        l(aVar);
        int k4 = k();
        this.f6352a.setLength(0);
        int i5 = k4;
        do {
            int m4 = m(i5);
            if (m4 == -1) {
                throw g1.m.a();
            }
            this.f6352a.append((char) m4);
            i5 += 8;
            if (this.f6352a.length() > 1 && i(f6351f, f6349d[m4])) {
                break;
            }
        } while (i5 < this.f6354c);
        int i6 = i5 - 1;
        int i7 = this.f6353b[i6];
        int i8 = 0;
        for (int i9 = -8; i9 < -1; i9++) {
            i8 += this.f6353b[i5 + i9];
        }
        if (i5 < this.f6354c && i7 < i8 / 2) {
            throw g1.m.a();
        }
        n(k4);
        for (int i10 = 0; i10 < this.f6352a.length(); i10++) {
            StringBuilder sb = this.f6352a;
            sb.setCharAt(i10, f6349d[sb.charAt(i10)]);
        }
        char charAt = this.f6352a.charAt(0);
        char[] cArr = f6351f;
        if (!i(cArr, charAt)) {
            throw g1.m.a();
        }
        StringBuilder sb2 = this.f6352a;
        if (!i(cArr, sb2.charAt(sb2.length() - 1))) {
            throw g1.m.a();
        }
        if (this.f6352a.length() <= 3) {
            throw g1.m.a();
        }
        if (map == null || !map.containsKey(g1.e.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f6352a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f6352a.deleteCharAt(0);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < k4; i12++) {
            i11 += this.f6353b[i12];
        }
        float f4 = i11;
        while (k4 < i6) {
            i11 += this.f6353b[k4];
            k4++;
        }
        float f5 = i4;
        return new g1.q(this.f6352a.toString(), null, new g1.s[]{new g1.s(f4, f5), new g1.s(i11, f5)}, g1.a.CODABAR);
    }
}
