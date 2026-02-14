package i2;

import g1.v;
import g2.h;
import g2.j;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f4133a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4134a;

        static {
            int[] iArr = new int[h.values().length];
            f4134a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4134a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4134a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4134a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void a(String str, n1.a aVar, String str2) {
        try {
            for (byte b5 : str.getBytes(str2)) {
                aVar.c(b5, 8);
            }
        } catch (UnsupportedEncodingException e4) {
            throw new v(e4);
        }
    }

    static void b(CharSequence charSequence, n1.a aVar) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            int p4 = p(charSequence.charAt(i4));
            if (p4 == -1) {
                throw new v();
            }
            int i5 = i4 + 1;
            if (i5 < length) {
                int p5 = p(charSequence.charAt(i5));
                if (p5 == -1) {
                    throw new v();
                }
                aVar.c((p4 * 45) + p5, 11);
                i4 += 2;
            } else {
                aVar.c(p4, 6);
                i4 = i5;
            }
        }
    }

    static void c(String str, h hVar, n1.a aVar, String str2) {
        int i4 = a.f4134a[hVar.ordinal()];
        if (i4 == 1) {
            h(str, aVar);
            return;
        }
        if (i4 == 2) {
            b(str, aVar);
        } else if (i4 == 3) {
            a(str, aVar, str2);
        } else {
            if (i4 != 4) {
                throw new v("Invalid mode: ".concat(String.valueOf(hVar)));
            }
            e(str, aVar);
        }
    }

    private static void d(n1.d dVar, n1.a aVar) {
        aVar.c(h.ECI.b(), 4);
        aVar.c(dVar.c(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c A[LOOP:0: B:6:0x000f->B:13:0x003c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void e(java.lang.String r6, n1.a r7) {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L5c
            int r0 = r6.length
            int r0 = r0 % 2
            if (r0 != 0) goto L54
            int r0 = r6.length
            int r0 = r0 + (-1)
            r1 = 0
        Lf:
            if (r1 >= r0) goto L53
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L2b
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L2b
        L29:
            int r2 = r2 - r3
            goto L3a
        L2b:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L39
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L39
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L29
        L39:
            r2 = r4
        L3a:
            if (r2 == r4) goto L4b
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.c(r3, r2)
            int r1 = r1 + 2
            goto Lf
        L4b:
            g1.v r6 = new g1.v
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L53:
            return
        L54:
            g1.v r6 = new g1.v
            java.lang.String r7 = "Kanji byte size not even"
            r6.<init>(r7)
            throw r6
        L5c:
            r6 = move-exception
            g1.v r7 = new g1.v
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.c.e(java.lang.String, n1.a):void");
    }

    static void f(int i4, j jVar, h hVar, n1.a aVar) {
        int c5 = hVar.c(jVar);
        int i5 = 1 << c5;
        if (i4 < i5) {
            aVar.c(i4, c5);
            return;
        }
        throw new v(i4 + " is bigger than " + (i5 - 1));
    }

    static void g(h hVar, n1.a aVar) {
        aVar.c(hVar.b(), 4);
    }

    static void h(CharSequence charSequence, n1.a aVar) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            int charAt = charSequence.charAt(i4) - '0';
            int i5 = i4 + 2;
            if (i5 < length) {
                aVar.c((charAt * 100) + ((charSequence.charAt(i4 + 1) - '0') * 10) + (charSequence.charAt(i5) - '0'), 10);
                i4 += 3;
            } else {
                i4++;
                if (i4 < length) {
                    aVar.c((charAt * 10) + (charSequence.charAt(i4) - '0'), 7);
                    i4 = i5;
                } else {
                    aVar.c(charAt, 4);
                }
            }
        }
    }

    private static int i(h hVar, n1.a aVar, n1.a aVar2, j jVar) {
        return aVar.l() + hVar.c(jVar) + aVar2.l();
    }

    private static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    private static int k(n1.a aVar, g2.f fVar, j jVar, b bVar) {
        int i4 = Integer.MAX_VALUE;
        int i5 = -1;
        for (int i6 = 0; i6 < 8; i6++) {
            e.a(aVar, fVar, jVar, i6, bVar);
            int j4 = j(bVar);
            if (j4 < i4) {
                i5 = i6;
                i4 = j4;
            }
        }
        return i5;
    }

    private static h l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && s(str)) {
            return h.KANJI;
        }
        boolean z4 = false;
        boolean z5 = false;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt >= '0' && charAt <= '9') {
                z5 = true;
            } else {
                if (p(charAt) == -1) {
                    return h.BYTE;
                }
                z4 = true;
            }
        }
        return z4 ? h.ALPHANUMERIC : z5 ? h.NUMERIC : h.BYTE;
    }

    private static j m(int i4, g2.f fVar) {
        for (int i5 = 1; i5 <= 40; i5++) {
            j i6 = j.i(i5);
            if (v(i4, i6, fVar)) {
                return i6;
            }
        }
        throw new v("Data too big");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00fc, code lost:
    
        if (i2.f.b(r9) != false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i2.f n(java.lang.String r7, g2.f r8, java.util.Map<g1.g, ?> r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.c.n(java.lang.String, g2.f, java.util.Map):i2.f");
    }

    static byte[] o(byte[] bArr, int i4) {
        int length = bArr.length;
        int[] iArr = new int[length + i4];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = bArr[i5] & 255;
        }
        new p1.d(p1.a.f5416l).b(iArr, i4);
        byte[] bArr2 = new byte[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            bArr2[i6] = (byte) iArr[length + i6];
        }
        return bArr2;
    }

    static int p(int i4) {
        int[] iArr = f4133a;
        if (i4 < iArr.length) {
            return iArr[i4];
        }
        return -1;
    }

    static void q(int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2) {
        if (i7 >= i6) {
            throw new v("Block ID too large");
        }
        int i8 = i4 % i6;
        int i9 = i6 - i8;
        int i10 = i4 / i6;
        int i11 = i10 + 1;
        int i12 = i5 / i6;
        int i13 = i12 + 1;
        int i14 = i10 - i12;
        int i15 = i11 - i13;
        if (i14 != i15) {
            throw new v("EC bytes mismatch");
        }
        if (i6 != i9 + i8) {
            throw new v("RS blocks mismatch");
        }
        if (i4 != ((i12 + i14) * i9) + ((i13 + i15) * i8)) {
            throw new v("Total bytes mismatch");
        }
        if (i7 < i9) {
            iArr[0] = i12;
            iArr2[0] = i14;
        } else {
            iArr[0] = i13;
            iArr2[0] = i15;
        }
    }

    static n1.a r(n1.a aVar, int i4, int i5, int i6) {
        if (aVar.m() != i5) {
            throw new v("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            q(i4, i5, i6, i10, iArr, iArr2);
            int i11 = iArr[0];
            byte[] bArr = new byte[i11];
            aVar.s(i7 << 3, bArr, 0, i11);
            byte[] o4 = o(bArr, iArr2[0]);
            arrayList.add(new i2.a(bArr, o4));
            i8 = Math.max(i8, i11);
            i9 = Math.max(i9, o4.length);
            i7 += iArr[0];
        }
        if (i5 != i7) {
            throw new v("Data bytes does not match offset");
        }
        n1.a aVar2 = new n1.a();
        for (int i12 = 0; i12 < i8; i12++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] a5 = ((i2.a) it.next()).a();
                if (i12 < a5.length) {
                    aVar2.c(a5[i12], 8);
                }
            }
        }
        for (int i13 = 0; i13 < i9; i13++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] b5 = ((i2.a) it2.next()).b();
                if (i13 < b5.length) {
                    aVar2.c(b5[i13], 8);
                }
            }
        }
        if (i4 == aVar2.m()) {
            return aVar2;
        }
        throw new v("Interleaving error: " + i4 + " and " + aVar2.m() + " differ.");
    }

    private static boolean s(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i4 = 0; i4 < length; i4 += 2) {
                int i5 = bytes[i4] & 255;
                if ((i5 < 129 || i5 > 159) && (i5 < 224 || i5 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static j t(g2.f fVar, h hVar, n1.a aVar, n1.a aVar2) {
        return m(i(hVar, aVar, aVar2, m(i(hVar, aVar, aVar2, j.i(1)), fVar)), fVar);
    }

    static void u(int i4, n1.a aVar) {
        int i5 = i4 << 3;
        if (aVar.l() > i5) {
            throw new v("data bits cannot fit in the QR Code" + aVar.l() + " > " + i5);
        }
        for (int i6 = 0; i6 < 4 && aVar.l() < i5; i6++) {
            aVar.a(false);
        }
        int l4 = aVar.l() & 7;
        if (l4 > 0) {
            while (l4 < 8) {
                aVar.a(false);
                l4++;
            }
        }
        int m4 = i4 - aVar.m();
        for (int i7 = 0; i7 < m4; i7++) {
            aVar.c((i7 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.l() != i5) {
            throw new v("Bits size does not equal capacity");
        }
    }

    private static boolean v(int i4, j jVar, g2.f fVar) {
        return jVar.h() - jVar.f(fVar).d() >= (i4 + 7) / 8;
    }
}
