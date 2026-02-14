package w1;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class g extends r {

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f6373c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    static final int[] f6374d;

    /* renamed from: e, reason: collision with root package name */
    static final int f6375e;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f6376a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private final int[] f6377b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f6374d = iArr;
        f6375e = iArr[47];
    }

    private static void i(CharSequence charSequence) {
        int length = charSequence.length();
        j(charSequence, length - 2, 20);
        j(charSequence, length - 1, 15);
    }

    private static void j(CharSequence charSequence, int i4, int i5) {
        int i6 = 0;
        int i7 = 1;
        for (int i8 = i4 - 1; i8 >= 0; i8--) {
            i6 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i8)) * i7;
            i7++;
            if (i7 > i5) {
                i7 = 1;
            }
        }
        if (charSequence.charAt(i4) != f6373c[i6 % 47]) {
            throw g1.d.a();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0029. Please report as an issue. */
    private static String k(CharSequence charSequence) {
        int i4;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i5 = 0;
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt >= 'a' && charAt <= 'd') {
                if (i5 >= length - 1) {
                    throw g1.h.a();
                }
                i5++;
                char charAt2 = charSequence.charAt(i5);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i4 = charAt2 - '@';
                            charAt = (char) i4;
                            break;
                        } else {
                            throw g1.h.a();
                        }
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i4 = charAt2 - '&';
                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                            i4 = charAt2 - 11;
                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                            i4 = charAt2 + 16;
                        } else if (charAt2 < 'P' || charAt2 > 'T') {
                            if (charAt2 != 'U') {
                                if (charAt2 != 'V') {
                                    if (charAt2 != 'W') {
                                        if (charAt2 >= 'X' && charAt2 <= 'Z') {
                                            charAt = 127;
                                            break;
                                        } else {
                                            throw g1.h.a();
                                        }
                                    } else {
                                        charAt = '`';
                                        break;
                                    }
                                } else {
                                    charAt = '@';
                                    break;
                                }
                            }
                            charAt = 0;
                            break;
                        } else {
                            i4 = charAt2 + '+';
                        }
                        charAt = (char) i4;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i4 = charAt2 - ' ';
                            charAt = (char) i4;
                            break;
                        } else {
                            if (charAt2 != 'Z') {
                                throw g1.h.a();
                            }
                            charAt = ':';
                            break;
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i4 = charAt2 + ' ';
                            charAt = (char) i4;
                            break;
                        } else {
                            throw g1.h.a();
                        }
                    default:
                        charAt = 0;
                        break;
                }
            }
            sb.append(charAt);
            i5++;
        }
        return sb.toString();
    }

    private int[] l(n1.a aVar) {
        int l4 = aVar.l();
        int j4 = aVar.j(0);
        Arrays.fill(this.f6377b, 0);
        int[] iArr = this.f6377b;
        int length = iArr.length;
        boolean z4 = false;
        int i4 = 0;
        int i5 = j4;
        while (j4 < l4) {
            if (aVar.g(j4) != z4) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (n(iArr) == f6375e) {
                        return new int[]{i5, j4};
                    }
                    i5 += iArr[0] + iArr[1];
                    int i6 = i4 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i6);
                    iArr[i6] = 0;
                    iArr[i4] = 0;
                    i4--;
                }
                iArr[i4] = 1;
                z4 = !z4;
            }
            j4++;
        }
        throw g1.m.a();
    }

    private static char m(int i4) {
        int i5 = 0;
        while (true) {
            int[] iArr = f6374d;
            if (i5 >= iArr.length) {
                throw g1.m.a();
            }
            if (iArr[i5] == i4) {
                return f6373c[i5];
            }
            i5++;
        }
    }

    private static int n(int[] iArr) {
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        int length = iArr.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int round = Math.round((iArr[i7] * 9.0f) / i4);
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i7 & 1) == 0) {
                for (int i8 = 0; i8 < round; i8++) {
                    i6 = (i6 << 1) | 1;
                }
            } else {
                i6 <<= round;
            }
        }
        return i6;
    }

    @Override // w1.r
    public g1.q d(int i4, n1.a aVar, Map<g1.e, ?> map) {
        int j4 = aVar.j(l(aVar)[1]);
        int l4 = aVar.l();
        int[] iArr = this.f6377b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f6376a;
        sb.setLength(0);
        while (true) {
            r.g(aVar, j4, iArr);
            int n4 = n(iArr);
            if (n4 < 0) {
                throw g1.m.a();
            }
            char m4 = m(n4);
            sb.append(m4);
            int i5 = j4;
            for (int i6 : iArr) {
                i5 += i6;
            }
            int j5 = aVar.j(i5);
            if (m4 == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i7 = 0;
                for (int i8 : iArr) {
                    i7 += i8;
                }
                if (j5 == l4 || !aVar.g(j5)) {
                    throw g1.m.a();
                }
                if (sb.length() < 2) {
                    throw g1.m.a();
                }
                i(sb);
                sb.setLength(sb.length() - 2);
                float f4 = i4;
                return new g1.q(k(sb), null, new g1.s[]{new g1.s((r14[1] + r14[0]) / 2.0f, f4), new g1.s(j4 + (i7 / 2.0f), f4)}, g1.a.CODE_93);
            }
            j4 = j5;
        }
    }
}
