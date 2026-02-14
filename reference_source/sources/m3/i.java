package m3;

import j3.v;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final j3.j f5191a = new j3.j("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final boolean a(String str) {
        e3.f.e(str, "<this>");
        return f5191a.b(str);
    }

    public static final byte[] b(byte[] bArr) {
        g3.f h4;
        byte[] v4;
        e3.f.e(bArr, "address");
        if (!j(bArr)) {
            return bArr;
        }
        h4 = g3.l.h(12, 16);
        v4 = v2.j.v(bArr, h4);
        return v4;
    }

    public static final boolean c(String str) {
        int M;
        e3.f.e(str, "<this>");
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (e3.f.f(charAt, 31) <= 0 || e3.f.f(charAt, 127) >= 0) {
                return true;
            }
            M = v.M(" #%/:?@[\\]", charAt, 0, false, 6, null);
            if (M != -1) {
                return true;
            }
        }
        return false;
    }

    public static final boolean d(String str) {
        int M;
        e3.f.e(str, "<this>");
        int length = str.length();
        if (!(1 <= length && length < 254)) {
            return true;
        }
        int i4 = 0;
        while (true) {
            M = v.M(str, '.', i4, false, 4, null);
            int length2 = M == -1 ? str.length() - i4 : M - i4;
            if (!(1 <= length2 && length2 < 64)) {
                return true;
            }
            if (M == -1 || M == str.length() - 1) {
                break;
            }
            i4 = M + 1;
        }
        return false;
    }

    public static final boolean e(String str, int i4, int i5, byte[] bArr, int i6) {
        e3.f.e(str, "input");
        e3.f.e(bArr, "address");
        int i7 = i6;
        while (i4 < i5) {
            if (i7 == bArr.length) {
                return false;
            }
            if (i7 != i6) {
                if (str.charAt(i4) != '.') {
                    return false;
                }
                i4++;
            }
            int i8 = i4;
            int i9 = 0;
            while (i8 < i5) {
                char charAt = str.charAt(i8);
                if (e3.f.f(charAt, 48) < 0 || e3.f.f(charAt, 57) > 0) {
                    break;
                }
                if ((i9 == 0 && i4 != i8) || (i9 = ((i9 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i8++;
            }
            if (i8 - i4 == 0) {
                return false;
            }
            bArr[i7] = (byte) i9;
            i7++;
            i4 = i8;
        }
        return i7 == i6 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009a, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final byte[] f(java.lang.String r18, int r19, int r20) {
        /*
            r6 = r18
            r7 = r20
            java.lang.String r0 = "input"
            e3.f.e(r6, r0)
            r8 = 16
            byte[] r9 = new byte[r8]
            r11 = -1
            r12 = r19
            r14 = r11
            r15 = r14
            r13 = 0
        L13:
            r16 = 0
            if (r12 >= r7) goto L9b
            if (r13 != r8) goto L1a
            return r16
        L1a:
            int r5 = r12 + 2
            if (r5 > r7) goto L3d
            r3 = 0
            r4 = 4
            r17 = 0
            java.lang.String r1 = "::"
            r0 = r18
            r2 = r12
            r10 = r5
            r5 = r17
            boolean r0 = j3.l.w(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L3d
            if (r14 == r11) goto L33
            return r16
        L33:
            int r13 = r13 + 2
            if (r10 != r7) goto L3a
            r14 = r13
            goto L9b
        L3a:
            r15 = r10
            r14 = r13
            goto L6c
        L3d:
            if (r13 == 0) goto L6b
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = ":"
            r0 = r18
            r2 = r12
            boolean r0 = j3.l.w(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L50
            int r12 = r12 + 1
            goto L6b
        L50:
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "."
            r0 = r18
            r2 = r12
            boolean r0 = j3.l.w(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L6a
            int r0 = r13 + (-2)
            boolean r0 = e(r6, r15, r7, r9, r0)
            if (r0 != 0) goto L67
            return r16
        L67:
            int r13 = r13 + 2
            goto L9b
        L6a:
            return r16
        L6b:
            r15 = r12
        L6c:
            r12 = r15
            r0 = 0
        L6e:
            if (r12 >= r7) goto L80
            char r1 = r6.charAt(r12)
            int r1 = m3.p.A(r1)
            if (r1 == r11) goto L80
            int r0 = r0 << 4
            int r0 = r0 + r1
            int r12 = r12 + 1
            goto L6e
        L80:
            int r1 = r12 - r15
            if (r1 == 0) goto L9a
            r2 = 4
            if (r1 <= r2) goto L88
            goto L9a
        L88:
            int r1 = r13 + 1
            int r2 = r0 >>> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r9[r13] = r2
            int r13 = r1 + 1
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r9[r1] = r0
            goto L13
        L9a:
            return r16
        L9b:
            if (r13 == r8) goto Lad
            if (r14 != r11) goto La0
            return r16
        La0:
            int r0 = r13 - r14
            int r0 = 16 - r0
            v2.f.d(r9, r9, r0, r14, r13)
            int r8 = r8 - r13
            int r8 = r8 + r14
            r0 = 0
            v2.f.j(r9, r0, r14, r8)
        Lad:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.i.f(java.lang.String, int, int):byte[]");
    }

    public static final String g(String str) {
        e3.f.e(str, "host");
        b4.d x4 = new b4.d().x(str);
        b4.d dVar = new b4.d();
        while (!x4.z()) {
            if (!v3.b.a().c(x4.a0(), dVar)) {
                return null;
            }
        }
        x4.x(k.a(dVar.Z()));
        v3.d dVar2 = v3.d.f6303a;
        String c5 = dVar2.c(x4.Z());
        if (c5 != null && e3.f.a(c5, k.a(c5))) {
            return dVar2.e(c5);
        }
        return null;
    }

    public static final String h(byte[] bArr) {
        e3.f.e(bArr, "address");
        if (bArr.length == 4) {
            return new b4.d().l0(p.b(bArr[0], 255)).B(46).l0(p.b(bArr[1], 255)).B(46).l0(p.b(bArr[2], 255)).B(46).l0(p.b(bArr[3], 255)).Z();
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final String i(byte[] bArr) {
        e3.f.e(bArr, "address");
        int i4 = 0;
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < bArr.length) {
            int i8 = i6;
            while (i8 < 16 && bArr[i8] == 0 && bArr[i8 + 1] == 0) {
                i8 += 2;
            }
            int i9 = i8 - i6;
            if (i9 > i7 && i9 >= 4) {
                i5 = i6;
                i7 = i9;
            }
            i6 = i8 + 2;
        }
        b4.d dVar = new b4.d();
        while (i4 < bArr.length) {
            if (i4 == i5) {
                dVar.B(58);
                i4 += i7;
                if (i4 == 16) {
                    dVar.B(58);
                }
            } else {
                if (i4 > 0) {
                    dVar.B(58);
                }
                dVar.j((p.b(bArr[i4], 255) << 8) | p.b(bArr[i4 + 1], 255));
                i4 += 2;
            }
        }
        return dVar.Z();
    }

    private static final boolean j(byte[] bArr) {
        if (bArr.length != 16) {
            return false;
        }
        for (int i4 = 0; i4 < 10; i4++) {
            if (bArr[i4] != 0) {
                return false;
            }
        }
        return bArr[10] == -1 && bArr[11] == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String k(java.lang.String r5) {
        /*
            java.lang.String r0 = "<this>"
            e3.f.e(r5, r0)
            java.lang.String r0 = ":"
            r1 = 0
            r2 = 2
            r3 = 0
            boolean r0 = j3.l.C(r5, r0, r1, r2, r3)
            r4 = 1
            if (r0 == 0) goto L69
            java.lang.String r0 = "["
            boolean r0 = j3.l.x(r5, r0, r1, r2, r3)
            if (r0 == 0) goto L2b
            java.lang.String r0 = "]"
            boolean r0 = j3.l.k(r5, r0, r1, r2, r3)
            if (r0 == 0) goto L2b
            int r0 = r5.length()
            int r0 = r0 - r4
            byte[] r0 = f(r5, r4, r0)
            goto L33
        L2b:
            int r0 = r5.length()
            byte[] r0 = f(r5, r1, r0)
        L33:
            if (r0 != 0) goto L36
            return r3
        L36:
            byte[] r0 = b(r0)
            int r1 = r0.length
            r2 = 16
            if (r1 != r2) goto L44
            java.lang.String r5 = i(r0)
            return r5
        L44:
            int r1 = r0.length
            r2 = 4
            if (r1 != r2) goto L4d
            java.lang.String r5 = h(r0)
            return r5
        L4d:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid IPv6 address: '"
            r1.append(r2)
            r1.append(r5)
            r5 = 39
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L69:
            java.lang.String r5 = g(r5)
            if (r5 != 0) goto L70
            return r3
        L70:
            int r0 = r5.length()
            if (r0 != 0) goto L77
            r1 = r4
        L77:
            if (r1 == 0) goto L7a
            return r3
        L7a:
            boolean r0 = c(r5)
            if (r0 == 0) goto L81
            return r3
        L81:
            boolean r0 = d(r5)
            if (r0 == 0) goto L88
            return r3
        L88:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.i.k(java.lang.String):java.lang.String");
    }
}
