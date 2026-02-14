package b2;

import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2271a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f2272b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    private static final BigInteger[] f2273c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2274a;

        static {
            int[] iArr = new int[b.values().length];
            f2274a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2274a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2274a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2274a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2274a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2274a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f2273c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i4 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f2273c;
            if (i4 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i4] = bigIntegerArr2[i4 - 1].multiply(valueOf);
            i4++;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0035. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x0077. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:45:0x007a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0021 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00aa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.e.a(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x001e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static n1.e b(int[] r6, java.lang.String r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            a2.c r3 = new a2.c
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L69
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L54
            switch(r2) {
                case 900: goto L4f;
                case 901: goto L4a;
                case 902: goto L45;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L40;
                case 923: goto L40;
                case 924: goto L4a;
                case 925: goto L3d;
                case 926: goto L3a;
                case 927: goto L29;
                case 928: goto L24;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
            goto L4f
        L24:
            int r2 = d(r6, r4, r3)
            goto L5c
        L29:
            int r2 = r4 + 1
            r1 = r6[r4]
            n1.d r1 = n1.d.b(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L5c
        L3a:
            int r2 = r4 + 2
            goto L5c
        L3d:
            int r2 = r4 + 1
            goto L5c
        L40:
            g1.h r6 = g1.h.a()
            throw r6
        L45:
            int r2 = f(r6, r4, r0)
            goto L5c
        L4a:
            int r2 = a(r2, r6, r1, r4, r0)
            goto L5c
        L4f:
            int r2 = g(r6, r4, r0)
            goto L5c
        L54:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L5c:
            int r4 = r6.length
            if (r2 >= r4) goto L64
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L64:
            g1.h r6 = g1.h.a()
            throw r6
        L69:
            int r6 = r0.length()
            if (r6 == 0) goto L7d
            n1.e r6 = new n1.e
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.m(r3)
            return r6
        L7d:
            g1.h r6 = g1.h.a()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.e.b(int[], java.lang.String):n1.e");
    }

    private static String c(int[] iArr, int i4) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i5 = 0; i5 < i4; i5++) {
            bigInteger = bigInteger.add(f2273c[(i4 - i5) - 1].multiply(BigInteger.valueOf(iArr[i5])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw g1.h.a();
    }

    static int d(int[] iArr, int i4, a2.c cVar) {
        if (i4 + 2 > iArr[0]) {
            throw g1.h.a();
        }
        int[] iArr2 = new int[2];
        int i5 = 0;
        while (i5 < 2) {
            iArr2[i5] = iArr[i4];
            i5++;
            i4++;
        }
        cVar.j(Integer.parseInt(c(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int g4 = g(iArr, i4, sb);
        cVar.d(sb.toString());
        int i6 = iArr[g4] == 923 ? g4 + 1 : -1;
        while (g4 < iArr[0]) {
            int i7 = iArr[g4];
            if (i7 == 922) {
                g4++;
                cVar.g(true);
            } else {
                if (i7 != 923) {
                    throw g1.h.a();
                }
                int i8 = g4 + 1;
                switch (iArr[i8]) {
                    case 0:
                        StringBuilder sb2 = new StringBuilder();
                        g4 = g(iArr, i8 + 1, sb2);
                        cVar.e(sb2.toString());
                        break;
                    case 1:
                        StringBuilder sb3 = new StringBuilder();
                        g4 = f(iArr, i8 + 1, sb3);
                        cVar.i(Integer.parseInt(sb3.toString()));
                        break;
                    case 2:
                        StringBuilder sb4 = new StringBuilder();
                        g4 = f(iArr, i8 + 1, sb4);
                        cVar.l(Long.parseLong(sb4.toString()));
                        break;
                    case 3:
                        StringBuilder sb5 = new StringBuilder();
                        g4 = g(iArr, i8 + 1, sb5);
                        cVar.k(sb5.toString());
                        break;
                    case 4:
                        StringBuilder sb6 = new StringBuilder();
                        g4 = g(iArr, i8 + 1, sb6);
                        cVar.b(sb6.toString());
                        break;
                    case 5:
                        StringBuilder sb7 = new StringBuilder();
                        g4 = f(iArr, i8 + 1, sb7);
                        cVar.f(Long.parseLong(sb7.toString()));
                        break;
                    case 6:
                        StringBuilder sb8 = new StringBuilder();
                        g4 = f(iArr, i8 + 1, sb8);
                        cVar.c(Integer.parseInt(sb8.toString()));
                        break;
                    default:
                        throw g1.h.a();
                }
            }
        }
        if (i6 != -1) {
            int i9 = g4 - i6;
            if (cVar.a()) {
                i9--;
            }
            cVar.h(Arrays.copyOfRange(iArr, i6, i9 + i6));
        }
        return g4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:36:0x0065. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:47:0x007b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:55:0x008f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6 A[PHI: r0
  0x00a6: PHI (r0v2 b2.e$b) = 
  (r0v1 b2.e$b)
  (r0v1 b2.e$b)
  (r0v3 b2.e$b)
  (r0v1 b2.e$b)
  (r0v4 b2.e$b)
  (r0v1 b2.e$b)
  (r0v6 b2.e$b)
  (r0v1 b2.e$b)
  (r0v1 b2.e$b)
  (r0v7 b2.e$b)
  (r0v8 b2.e$b)
 binds: [B:4:0x001b, B:55:0x008f, B:49:0x009a, B:47:0x007b, B:40:0x009d, B:36:0x0065, B:37:0x0069, B:30:0x00a2, B:28:0x0051, B:23:0x0042, B:18:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.e.e(int[], int[], int, java.lang.StringBuilder):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x002a. Please report as an issue. */
    private static int f(int[] iArr, int i4, StringBuilder sb) {
        int[] iArr2 = new int[15];
        boolean z4 = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z4) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i6 == iArr[0]) {
                z4 = true;
            }
            if (i7 < 900) {
                iArr2[i5] = i7;
                i5++;
            } else {
                if (i7 != 900 && i7 != 901 && i7 != 928) {
                    switch (i7) {
                    }
                }
                i6--;
                z4 = true;
            }
            if ((i5 % 15 == 0 || i7 == 902 || z4) && i5 > 0) {
                sb.append(c(iArr2, i5));
                i5 = 0;
            }
            i4 = i6;
        }
        return i4;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0034. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0037. Please report as an issue. */
    private static int g(int[] iArr, int i4, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i4) << 1];
        int[] iArr3 = new int[(iArr[0] - i4) << 1];
        boolean z4 = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z4) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i7 < 900) {
                iArr2[i5] = i7 / 30;
                iArr2[i5 + 1] = i7 % 30;
                i5 += 2;
            } else if (i7 != 913) {
                if (i7 != 928) {
                    switch (i7) {
                        case 900:
                            iArr2[i5] = 900;
                            i5++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i7) {
                            }
                    }
                }
                i4 = i6 - 1;
                z4 = true;
            } else {
                iArr2[i5] = 913;
                i4 = i6 + 1;
                iArr3[i5] = iArr[i6];
                i5++;
            }
            i4 = i6;
        }
        e(iArr2, iArr3, i5, sb);
        return i4;
    }
}
