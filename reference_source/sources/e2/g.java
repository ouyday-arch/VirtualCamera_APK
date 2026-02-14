package e2;

import g1.v;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes.dex */
final class g {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f3619c;

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f3617a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f3618b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f3620d = new byte[128];

    /* renamed from: e, reason: collision with root package name */
    private static final Charset f3621e = StandardCharsets.ISO_8859_1;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3622a;

        static {
            int[] iArr = new int[c.values().length];
            f3622a = iArr;
            try {
                iArr[c.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3622a[c.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3622a[c.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        byte[] bArr = new byte[128];
        f3619c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            byte[] bArr2 = f3617a;
            if (i5 >= bArr2.length) {
                break;
            }
            byte b5 = bArr2[i5];
            if (b5 > 0) {
                f3619c[b5] = (byte) i5;
            }
            i5++;
        }
        Arrays.fill(f3620d, (byte) -1);
        while (true) {
            byte[] bArr3 = f3618b;
            if (i4 >= bArr3.length) {
                return;
            }
            byte b6 = bArr3[i4];
            if (b6 > 0) {
                f3620d[b6] = (byte) i4;
            }
            i4++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0028, code lost:
    
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(java.lang.String r5, int r6, java.nio.charset.Charset r7) {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L9:
            if (r1 >= r0) goto L57
            char r2 = r5.charAt(r1)
            r3 = 0
        L10:
            r4 = 13
            if (r3 >= r4) goto L25
            boolean r2 = k(r2)
            if (r2 == 0) goto L25
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 >= r0) goto L25
            char r2 = r5.charAt(r2)
            goto L10
        L25:
            if (r3 < r4) goto L29
            int r1 = r1 - r6
            return r1
        L29:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 == 0) goto L36
            int r1 = r1 + 1
            goto L9
        L36:
            g1.v r5 = new g1.v
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Non-encodable character detected: "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L57:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.g.a(java.lang.String, int, java.nio.charset.Charset):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0005, code lost:
    
        if (r5 < r0) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
    
        r2 = r4.charAt(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        if (k(r2) == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r5 >= r0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        r1 = r1 + 1;
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r5 >= r0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int b(java.lang.CharSequence r4, int r5) {
        /*
            int r0 = r4.length()
            r1 = 0
            if (r5 >= r0) goto L1a
        L7:
            char r2 = r4.charAt(r5)
        Lb:
            boolean r3 = k(r2)
            if (r3 == 0) goto L1a
            if (r5 >= r0) goto L1a
            int r1 = r1 + 1
            int r5 = r5 + 1
            if (r5 >= r0) goto Lb
            goto L7
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.g.b(java.lang.CharSequence, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0027, code lost:
    
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int c(java.lang.CharSequence r6, int r7) {
        /*
            int r0 = r6.length()
            r1 = r7
        L5:
            if (r1 >= r0) goto L37
            char r2 = r6.charAt(r1)
            r3 = 0
        Lc:
            r4 = 13
            if (r3 >= r4) goto L23
            boolean r5 = k(r2)
            if (r5 == 0) goto L23
            if (r1 >= r0) goto L23
            int r3 = r3 + 1
            int r1 = r1 + 1
            if (r1 >= r0) goto Lc
            char r2 = r6.charAt(r1)
            goto Lc
        L23:
            if (r3 < r4) goto L28
            int r1 = r1 - r7
            int r1 = r1 - r3
            return r1
        L28:
            if (r3 > 0) goto L5
            char r2 = r6.charAt(r1)
            boolean r2 = n(r2)
            if (r2 == 0) goto L37
            int r1 = r1 + 1
            goto L5
        L37:
            int r1 = r1 - r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.g.c(java.lang.CharSequence, int):int");
    }

    private static void d(byte[] bArr, int i4, int i5, int i6, StringBuilder sb) {
        int i7;
        sb.append((i5 == 1 && i6 == 0) ? (char) 913 : i5 % 6 == 0 ? (char) 924 : (char) 901);
        if (i5 >= 6) {
            char[] cArr = new char[5];
            i7 = i4;
            while ((i4 + i5) - i7 >= 6) {
                long j4 = 0;
                for (int i8 = 0; i8 < 6; i8++) {
                    j4 = (j4 << 8) + (bArr[i7 + i8] & 255);
                }
                for (int i9 = 0; i9 < 5; i9++) {
                    cArr[i9] = (char) (j4 % 900);
                    j4 /= 900;
                }
                for (int i10 = 4; i10 >= 0; i10--) {
                    sb.append(cArr[i10]);
                }
                i7 += 6;
            }
        } else {
            i7 = i4;
        }
        while (i7 < i4 + i5) {
            sb.append((char) (bArr[i7] & 255));
            i7++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str, c cVar, Charset charset) {
        n1.d a5;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = f3621e;
        } else if (!f3621e.equals(charset) && (a5 = n1.d.a(charset.name())) != null) {
            h(a5.c(), sb);
        }
        int length = str.length();
        int i4 = a.f3622a[cVar.ordinal()];
        if (i4 == 1) {
            g(str, 0, length, sb, 0);
        } else if (i4 == 2) {
            byte[] bytes = str.getBytes(charset);
            d(bytes, 0, bytes.length, 1, sb);
        } else if (i4 != 3) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < length) {
                int b5 = b(str, i5);
                if (b5 >= 13) {
                    sb.append((char) 902);
                    f(str, i5, b5, sb);
                    i5 += b5;
                    i6 = 0;
                    i7 = 2;
                } else {
                    int c5 = c(str, i5);
                    if (c5 >= 5 || b5 == length) {
                        if (i7 != 0) {
                            sb.append((char) 900);
                            i6 = 0;
                            i7 = 0;
                        }
                        i6 = g(str, i5, c5, sb, i6);
                        i5 += c5;
                    } else {
                        int a6 = a(str, i5, charset);
                        if (a6 == 0) {
                            a6 = 1;
                        }
                        int i8 = a6 + i5;
                        byte[] bytes2 = str.substring(i5, i8).getBytes(charset);
                        if (bytes2.length == 1 && i7 == 0) {
                            d(bytes2, 0, 1, 0, sb);
                        } else {
                            d(bytes2, 0, bytes2.length, i7, sb);
                            i7 = 1;
                            i6 = 0;
                        }
                        i5 = i8;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            f(str, 0, length, sb);
        }
        return sb.toString();
    }

    private static void f(String str, int i4, int i5, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i5 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i6 = 0;
        while (i6 < i5) {
            sb2.setLength(0);
            int min = Math.min(44, i5 - i6);
            StringBuilder sb3 = new StringBuilder("1");
            int i7 = i4 + i6;
            sb3.append(str.substring(i7, i7 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i6 += min;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x00a0, code lost:
    
        if (r10 == ' ') goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int g(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.g.g(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void h(int i4, StringBuilder sb) {
        char c5;
        if (i4 >= 0 && i4 < 900) {
            sb.append((char) 927);
        } else {
            if (i4 >= 810900) {
                if (i4 >= 811800) {
                    throw new v("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i4)));
                }
                sb.append((char) 925);
                c5 = (char) (810900 - i4);
                sb.append(c5);
            }
            sb.append((char) 926);
            sb.append((char) ((i4 / 900) - 1));
            i4 %= 900;
        }
        c5 = (char) i4;
        sb.append(c5);
    }

    private static boolean i(char c5) {
        if (c5 != ' ') {
            return c5 >= 'a' && c5 <= 'z';
        }
        return true;
    }

    private static boolean j(char c5) {
        if (c5 != ' ') {
            return c5 >= 'A' && c5 <= 'Z';
        }
        return true;
    }

    private static boolean k(char c5) {
        return c5 >= '0' && c5 <= '9';
    }

    private static boolean l(char c5) {
        return f3619c[c5] != -1;
    }

    private static boolean m(char c5) {
        return f3620d[c5] != -1;
    }

    private static boolean n(char c5) {
        if (c5 == '\t' || c5 == '\n' || c5 == '\r') {
            return true;
        }
        return c5 >= ' ' && c5 <= '~';
    }
}
