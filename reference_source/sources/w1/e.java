package w1;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends r {

    /* renamed from: e, reason: collision with root package name */
    static final int[] f6368e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6369a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f6370b;

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f6371c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f6372d;

    public e() {
        this(false);
    }

    public e(boolean z4) {
        this(z4, false);
    }

    public e(boolean z4, boolean z5) {
        this.f6369a = z4;
        this.f6370b = z5;
        this.f6371c = new StringBuilder(20);
        this.f6372d = new int[9];
    }

    private static String i(CharSequence charSequence) {
        int i4;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i5 = 0;
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i5++;
                char charAt2 = charSequence.charAt(i5);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt == '/') {
                                if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i4 = charAt2 - ' ';
                                } else {
                                    if (charAt2 != 'Z') {
                                        throw g1.h.a();
                                    }
                                    charAt = ':';
                                }
                            }
                            charAt = 0;
                        } else {
                            if (charAt2 < 'A' || charAt2 > 'Z') {
                                throw g1.h.a();
                            }
                            i4 = charAt2 + ' ';
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i4 = charAt2 - '&';
                    } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                        i4 = charAt2 - 11;
                    } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                        i4 = charAt2 + 16;
                    } else if (charAt2 < 'P' || charAt2 > 'T') {
                        if (charAt2 != 'U') {
                            if (charAt2 == 'V') {
                                charAt = '@';
                            } else if (charAt2 == 'W') {
                                charAt = '`';
                            } else {
                                if (charAt2 != 'X' && charAt2 != 'Y' && charAt2 != 'Z') {
                                    throw g1.h.a();
                                }
                                charAt = 127;
                            }
                        }
                        charAt = 0;
                    } else {
                        i4 = charAt2 + '+';
                    }
                } else {
                    if (charAt2 < 'A' || charAt2 > 'Z') {
                        throw g1.h.a();
                    }
                    i4 = charAt2 - '@';
                }
                charAt = (char) i4;
            }
            sb.append(charAt);
            i5++;
        }
        return sb.toString();
    }

    private static int[] j(n1.a aVar, int[] iArr) {
        int l4 = aVar.l();
        int j4 = aVar.j(0);
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
                    if (l(iArr) == 148 && aVar.n(Math.max(0, i5 - ((j4 - i5) / 2)), i5, false)) {
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

    private static char k(int i4) {
        int i5 = 0;
        while (true) {
            int[] iArr = f6368e;
            if (i5 >= iArr.length) {
                if (i4 == 148) {
                    return '*';
                }
                throw g1.m.a();
            }
            if (iArr[i5] == i4) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i5);
            }
            i5++;
        }
    }

    private static int l(int[] iArr) {
        int length = iArr.length;
        int i4 = 0;
        while (true) {
            int i5 = Integer.MAX_VALUE;
            for (int i6 : iArr) {
                if (i6 < i5 && i6 > i4) {
                    i5 = i6;
                }
            }
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = iArr[i10];
                if (i11 > i5) {
                    i8 |= 1 << ((length - 1) - i10);
                    i7++;
                    i9 += i11;
                }
            }
            if (i7 == 3) {
                for (int i12 = 0; i12 < length && i7 > 0; i12++) {
                    int i13 = iArr[i12];
                    if (i13 > i5) {
                        i7--;
                        if ((i13 << 1) >= i9) {
                            return -1;
                        }
                    }
                }
                return i8;
            }
            if (i7 <= 3) {
                return -1;
            }
            i4 = i5;
        }
    }

    @Override // w1.r
    public g1.q d(int i4, n1.a aVar, Map<g1.e, ?> map) {
        int[] iArr = this.f6372d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f6371c;
        sb.setLength(0);
        int j4 = aVar.j(j(aVar, iArr)[1]);
        int l4 = aVar.l();
        while (true) {
            r.g(aVar, j4, iArr);
            int l5 = l(iArr);
            if (l5 < 0) {
                throw g1.m.a();
            }
            char k4 = k(l5);
            sb.append(k4);
            int i5 = j4;
            for (int i6 : iArr) {
                i5 += i6;
            }
            int j5 = aVar.j(i5);
            if (k4 == '*') {
                sb.setLength(sb.length() - 1);
                int i7 = 0;
                for (int i8 : iArr) {
                    i7 += i8;
                }
                int i9 = (j5 - j4) - i7;
                if (j5 != l4 && (i9 << 1) < i7) {
                    throw g1.m.a();
                }
                if (this.f6369a) {
                    int length = sb.length() - 1;
                    int i10 = 0;
                    for (int i11 = 0; i11 < length; i11++) {
                        i10 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f6371c.charAt(i11));
                    }
                    if (sb.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i10 % 43)) {
                        throw g1.d.a();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw g1.m.a();
                }
                float f4 = i4;
                return new g1.q(this.f6370b ? i(sb) : sb.toString(), null, new g1.s[]{new g1.s((r2[1] + r2[0]) / 2.0f, f4), new g1.s(j4 + (i7 / 2.0f), f4)}, g1.a.CODE_39);
            }
            j4 = j5;
        }
    }
}
