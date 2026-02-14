package i1;

import g1.h;
import java.util.Arrays;
import p1.c;
import p1.e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f4114b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f4115c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f4116d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f4117e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f4118f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: a, reason: collision with root package name */
    private h1.a f4119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0047a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4120a;

        static {
            int[] iArr = new int[b.values().length];
            f4120a = iArr;
            try {
                iArr[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4120a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4120a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4120a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4120a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = h(zArr, i4 << 3);
        }
        return bArr;
    }

    private boolean[] b(boolean[] zArr) {
        p1.a aVar;
        int i4 = 8;
        if (this.f4119a.d() <= 2) {
            i4 = 6;
            aVar = p1.a.f5414j;
        } else if (this.f4119a.d() <= 8) {
            aVar = p1.a.f5418n;
        } else if (this.f4119a.d() <= 22) {
            i4 = 10;
            aVar = p1.a.f5413i;
        } else {
            i4 = 12;
            aVar = p1.a.f5412h;
        }
        int c5 = this.f4119a.c();
        int length = zArr.length / i4;
        if (length < c5) {
            throw h.a();
        }
        int length2 = zArr.length % i4;
        int[] iArr = new int[length];
        int i5 = 0;
        while (i5 < length) {
            iArr[i5] = i(zArr, length2, i4);
            i5++;
            length2 += i4;
        }
        try {
            new c(aVar).a(iArr, length - c5);
            int i6 = (1 << i4) - 1;
            int i7 = 0;
            for (int i8 = 0; i8 < c5; i8++) {
                int i9 = iArr[i8];
                if (i9 == 0 || i9 == i6) {
                    throw h.a();
                }
                if (i9 == 1 || i9 == i6 - 1) {
                    i7++;
                }
            }
            boolean[] zArr2 = new boolean[(c5 * i4) - i7];
            int i10 = 0;
            for (int i11 = 0; i11 < c5; i11++) {
                int i12 = iArr[i11];
                if (i12 == 1 || i12 == i6 - 1) {
                    Arrays.fill(zArr2, i10, (i10 + i4) - 1, i12 > 1);
                    i10 += i4 - 1;
                } else {
                    int i13 = i4 - 1;
                    while (i13 >= 0) {
                        int i14 = i10 + 1;
                        zArr2[i10] = ((1 << i13) & i12) != 0;
                        i13--;
                        i10 = i14;
                    }
                }
            }
            return zArr2;
        } catch (e e4) {
            throw h.b(e4);
        }
    }

    private boolean[] d(n1.b bVar) {
        boolean e4 = this.f4119a.e();
        int d5 = this.f4119a.d();
        int i4 = (e4 ? 11 : 14) + (d5 << 2);
        int[] iArr = new int[i4];
        boolean[] zArr = new boolean[j(d5, e4)];
        int i5 = 2;
        if (e4) {
            for (int i6 = 0; i6 < i4; i6++) {
                iArr[i6] = i6;
            }
        } else {
            int i7 = i4 / 2;
            int i8 = ((i4 + 1) + (((i7 - 1) / 15) * 2)) / 2;
            for (int i9 = 0; i9 < i7; i9++) {
                iArr[(i7 - i9) - 1] = (i8 - r12) - 1;
                iArr[i7 + i9] = (i9 / 15) + i9 + i8 + 1;
            }
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < d5) {
            int i12 = ((d5 - i10) << i5) + (e4 ? 9 : 12);
            int i13 = i10 << 1;
            int i14 = (i4 - 1) - i13;
            int i15 = 0;
            while (i15 < i12) {
                int i16 = i15 << 1;
                int i17 = 0;
                while (i17 < i5) {
                    int i18 = i13 + i17;
                    int i19 = i13 + i15;
                    zArr[i11 + i16 + i17] = bVar.e(iArr[i18], iArr[i19]);
                    int i20 = iArr[i19];
                    int i21 = i14 - i17;
                    zArr[(i12 * 2) + i11 + i16 + i17] = bVar.e(i20, iArr[i21]);
                    int i22 = i14 - i15;
                    zArr[(i12 * 4) + i11 + i16 + i17] = bVar.e(iArr[i21], iArr[i22]);
                    zArr[(i12 * 6) + i11 + i16 + i17] = bVar.e(iArr[i22], iArr[i18]);
                    i17++;
                    d5 = d5;
                    e4 = e4;
                    i5 = 2;
                }
                i15++;
                i5 = 2;
            }
            i11 += i12 << 3;
            i10++;
            i5 = 2;
        }
        return zArr;
    }

    private static String e(b bVar, int i4) {
        int i5 = C0047a.f4120a[bVar.ordinal()];
        if (i5 == 1) {
            return f4114b[i4];
        }
        if (i5 == 2) {
            return f4115c[i4];
        }
        if (i5 == 3) {
            return f4116d[i4];
        }
        if (i5 == 4) {
            return f4117e[i4];
        }
        if (i5 == 5) {
            return f4118f[i4];
        }
        throw new IllegalStateException("Bad table");
    }

    private static String f(boolean[] zArr) {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb = new StringBuilder(20);
        b bVar2 = bVar;
        int i4 = 0;
        while (i4 < length) {
            if (bVar != b.BINARY) {
                int i5 = bVar == b.DIGIT ? 4 : 5;
                if (length - i4 < i5) {
                    break;
                }
                int i6 = i(zArr, i4, i5);
                i4 += i5;
                String e4 = e(bVar, i6);
                if (e4.startsWith("CTRL_")) {
                    bVar2 = g(e4.charAt(5));
                    if (e4.charAt(6) != 'L') {
                        bVar2 = bVar;
                        bVar = bVar2;
                    }
                } else {
                    sb.append(e4);
                }
                bVar = bVar2;
            } else {
                if (length - i4 < 5) {
                    break;
                }
                int i7 = i(zArr, i4, 5);
                i4 += 5;
                if (i7 == 0) {
                    if (length - i4 < 11) {
                        break;
                    }
                    i7 = i(zArr, i4, 11) + 31;
                    i4 += 11;
                }
                int i8 = 0;
                while (true) {
                    if (i8 >= i7) {
                        break;
                    }
                    if (length - i4 < 8) {
                        i4 = length;
                        break;
                    }
                    sb.append((char) i(zArr, i4, 8));
                    i4 += 8;
                    i8++;
                }
                bVar = bVar2;
            }
        }
        return sb.toString();
    }

    private static b g(char c5) {
        return c5 != 'B' ? c5 != 'D' ? c5 != 'P' ? c5 != 'L' ? c5 != 'M' ? b.UPPER : b.MIXED : b.LOWER : b.PUNCT : b.DIGIT : b.BINARY;
    }

    private static byte h(boolean[] zArr, int i4) {
        int length = zArr.length - i4;
        return (byte) (length >= 8 ? i(zArr, i4, 8) : i(zArr, i4, length) << (8 - length));
    }

    private static int i(boolean[] zArr, int i4, int i5) {
        int i6 = 0;
        for (int i7 = i4; i7 < i4 + i5; i7++) {
            i6 <<= 1;
            if (zArr[i7]) {
                i6 |= 1;
            }
        }
        return i6;
    }

    private static int j(int i4, boolean z4) {
        return ((z4 ? 88 : 112) + (i4 << 4)) * i4;
    }

    public n1.e c(h1.a aVar) {
        this.f4119a = aVar;
        boolean[] b5 = b(d(aVar.a()));
        n1.e eVar = new n1.e(a(b5), f(b5), null, null);
        eVar.l(b5.length);
        return eVar;
    }
}
