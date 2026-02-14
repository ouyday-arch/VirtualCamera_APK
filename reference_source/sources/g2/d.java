package g2;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import n1.l;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f3997a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3998a;

        static {
            int[] iArr = new int[h.values().length];
            f3998a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3998a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3998a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3998a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3998a[h.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3998a[h.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3998a[h.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3998a[h.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3998a[h.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3998a[h.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x003a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d8 A[LOOP:0: B:2:0x001e->B:25:0x00d8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static n1.e a(byte[] r17, g2.j r18, g2.f r19, java.util.Map<g1.e, ?> r20) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.d.a(byte[], g2.j, g2.f, java.util.Map):n1.e");
    }

    private static void b(n1.c cVar, StringBuilder sb, int i4, boolean z4) {
        while (i4 > 1) {
            if (cVar.a() < 11) {
                throw g1.h.a();
            }
            int d5 = cVar.d(11);
            sb.append(h(d5 / 45));
            sb.append(h(d5 % 45));
            i4 -= 2;
        }
        if (i4 == 1) {
            if (cVar.a() < 6) {
                throw g1.h.a();
            }
            sb.append(h(cVar.d(6)));
        }
        if (z4) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i5 = length + 1;
                        if (sb.charAt(i5) == '%') {
                            sb.deleteCharAt(i5);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void c(n1.c cVar, StringBuilder sb, int i4, n1.d dVar, Collection<byte[]> collection, Map<g1.e, ?> map) {
        if ((i4 << 3) > cVar.a()) {
            throw g1.h.a();
        }
        byte[] bArr = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i5] = (byte) cVar.d(8);
        }
        try {
            sb.append(new String(bArr, dVar == null ? l.a(bArr, map) : dVar.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw g1.h.a();
        }
    }

    private static void d(n1.c cVar, StringBuilder sb, int i4) {
        if (i4 * 13 > cVar.a()) {
            throw g1.h.a();
        }
        byte[] bArr = new byte[i4 * 2];
        int i5 = 0;
        while (i4 > 0) {
            int d5 = cVar.d(13);
            int i6 = (d5 % 96) | ((d5 / 96) << 8);
            int i7 = i6 + (i6 < 2560 ? 41377 : 42657);
            bArr[i5] = (byte) (i7 >> 8);
            bArr[i5 + 1] = (byte) i7;
            i5 += 2;
            i4--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw g1.h.a();
        }
    }

    private static void e(n1.c cVar, StringBuilder sb, int i4) {
        if (i4 * 13 > cVar.a()) {
            throw g1.h.a();
        }
        byte[] bArr = new byte[i4 * 2];
        int i5 = 0;
        while (i4 > 0) {
            int d5 = cVar.d(13);
            int i6 = (d5 % 192) | ((d5 / 192) << 8);
            int i7 = i6 + (i6 < 7936 ? 33088 : 49472);
            bArr[i5] = (byte) (i7 >> 8);
            bArr[i5 + 1] = (byte) i7;
            i5 += 2;
            i4--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw g1.h.a();
        }
    }

    private static void f(n1.c cVar, StringBuilder sb, int i4) {
        while (i4 >= 3) {
            if (cVar.a() < 10) {
                throw g1.h.a();
            }
            int d5 = cVar.d(10);
            if (d5 >= 1000) {
                throw g1.h.a();
            }
            sb.append(h(d5 / 100));
            sb.append(h((d5 / 10) % 10));
            sb.append(h(d5 % 10));
            i4 -= 3;
        }
        if (i4 == 2) {
            if (cVar.a() < 7) {
                throw g1.h.a();
            }
            int d6 = cVar.d(7);
            if (d6 >= 100) {
                throw g1.h.a();
            }
            sb.append(h(d6 / 10));
            sb.append(h(d6 % 10));
            return;
        }
        if (i4 == 1) {
            if (cVar.a() < 4) {
                throw g1.h.a();
            }
            int d7 = cVar.d(4);
            if (d7 >= 10) {
                throw g1.h.a();
            }
            sb.append(h(d7));
        }
    }

    private static int g(n1.c cVar) {
        int d5 = cVar.d(8);
        if ((d5 & 128) == 0) {
            return d5 & 127;
        }
        if ((d5 & 192) == 128) {
            return cVar.d(8) | ((d5 & 63) << 8);
        }
        if ((d5 & 224) == 192) {
            return cVar.d(16) | ((d5 & 31) << 16);
        }
        throw g1.h.a();
    }

    private static char h(int i4) {
        char[] cArr = f3997a;
        if (i4 < cArr.length) {
            return cArr[i4];
        }
        throw g1.h.a();
    }
}
