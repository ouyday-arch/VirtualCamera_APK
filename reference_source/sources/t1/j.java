package t1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class j {
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
    
        if (f(r2) == false) goto L13;
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
    public static int a(java.lang.CharSequence r4, int r5) {
        /*
            int r0 = r4.length()
            r1 = 0
            if (r5 >= r0) goto L1a
        L7:
            char r2 = r4.charAt(r5)
        Lb:
            boolean r3 = f(r2)
            if (r3 == 0) goto L1a
            if (r5 >= r0) goto L1a
            int r1 = r1 + 1
            int r5 = r5 + 1
            if (r5 >= r0) goto Lb
            goto L7
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.j.a(java.lang.CharSequence, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r7, t1.l r8, g1.f r9, g1.f r10) {
        /*
            r0 = 6
            t1.g[] r0 = new t1.g[r0]
            t1.a r1 = new t1.a
            r1.<init>()
            r2 = 0
            r0[r2] = r1
            t1.c r1 = new t1.c
            r1.<init>()
            r3 = 1
            r0[r3] = r1
            t1.m r1 = new t1.m
            r1.<init>()
            r4 = 2
            r0[r4] = r1
            t1.n r1 = new t1.n
            r1.<init>()
            r5 = 3
            r0[r5] = r1
            t1.f r1 = new t1.f
            r1.<init>()
            r5 = 4
            r0[r5] = r1
            t1.b r1 = new t1.b
            r1.<init>()
            r6 = 5
            r0[r6] = r1
            t1.h r1 = new t1.h
            r1.<init>(r7)
            r1.n(r8)
            r1.l(r9, r10)
            java.lang.String r8 = "[)>\u001e05\u001d"
            boolean r8 = r7.startsWith(r8)
            java.lang.String r9 = "\u001e\u0004"
            if (r8 == 0) goto L5d
            boolean r8 = r7.endsWith(r9)
            if (r8 == 0) goto L5d
            r7 = 236(0xec, float:3.31E-43)
        L50:
            r1.r(r7)
            r1.m(r4)
            int r7 = r1.f5926f
            int r7 = r7 + 7
            r1.f5926f = r7
            goto L6e
        L5d:
            java.lang.String r8 = "[)>\u001e06\u001d"
            boolean r8 = r7.startsWith(r8)
            if (r8 == 0) goto L6e
            boolean r7 = r7.endsWith(r9)
            if (r7 == 0) goto L6e
            r7 = 237(0xed, float:3.32E-43)
            goto L50
        L6e:
            boolean r7 = r1.i()
            if (r7 == 0) goto L87
            r7 = r0[r2]
            r7.a(r1)
            int r7 = r1.e()
            if (r7 < 0) goto L6e
            int r2 = r1.e()
            r1.j()
            goto L6e
        L87:
            int r7 = r1.a()
            r1.p()
            t1.k r8 = r1.g()
            int r8 = r8.a()
            if (r7 >= r8) goto La3
            if (r2 == 0) goto La3
            if (r2 == r6) goto La3
            if (r2 == r5) goto La3
            r7 = 254(0xfe, float:3.56E-43)
            r1.r(r7)
        La3:
            java.lang.StringBuilder r7 = r1.b()
            int r9 = r7.length()
            if (r9 >= r8) goto Lb2
            r9 = 129(0x81, float:1.81E-43)
        Laf:
            r7.append(r9)
        Lb2:
            int r9 = r7.length()
            if (r9 >= r8) goto Lc2
            int r9 = r7.length()
            int r9 = r9 + r3
            char r9 = o(r9)
            goto Laf
        Lc2:
            java.lang.StringBuilder r7 = r1.b()
            java.lang.String r7 = r7.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.j.b(java.lang.String, t1.l, g1.f, g1.f):java.lang.String");
    }

    private static int c(float[] fArr, int[] iArr, int i4, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i5 = 0; i5 < 6; i5++) {
            iArr[i5] = (int) Math.ceil(fArr[i5]);
            int i6 = iArr[i5];
            if (i4 > i6) {
                Arrays.fill(bArr, (byte) 0);
                i4 = i6;
            }
            if (i4 == i6) {
                bArr[i5] = (byte) (bArr[i5] + 1);
            }
        }
        return i4;
    }

    private static int d(byte[] bArr) {
        int i4 = 0;
        for (int i5 = 0; i5 < 6; i5++) {
            i4 += bArr[i5];
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(char c5) {
        String hexString = Integer.toHexString(c5);
        throw new IllegalArgumentException("Illegal character: " + c5 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(char c5) {
        return c5 >= '0' && c5 <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(char c5) {
        return c5 >= 128 && c5 <= 255;
    }

    private static boolean h(char c5) {
        if (c5 == ' ') {
            return true;
        }
        if (c5 < '0' || c5 > '9') {
            return c5 >= 'A' && c5 <= 'Z';
        }
        return true;
    }

    private static boolean i(char c5) {
        return c5 >= ' ' && c5 <= '^';
    }

    private static boolean j(char c5) {
        if (c5 == ' ') {
            return true;
        }
        if (c5 < '0' || c5 > '9') {
            return c5 >= 'a' && c5 <= 'z';
        }
        return true;
    }

    private static boolean k(char c5) {
        if (m(c5) || c5 == ' ') {
            return true;
        }
        if (c5 < '0' || c5 > '9') {
            return c5 >= 'A' && c5 <= 'Z';
        }
        return true;
    }

    private static boolean l(char c5) {
        return false;
    }

    private static boolean m(char c5) {
        return c5 == '\r' || c5 == '*' || c5 == '>';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(CharSequence charSequence, int i4, int i5) {
        char c5;
        if (i4 >= charSequence.length()) {
            return i5;
        }
        float[] fArr = {1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
        if (i5 == 0) {
            // fill-array-data instruction
            fArr[0] = 0.0f;
            fArr[1] = 1.0f;
            fArr[2] = 1.0f;
            fArr[3] = 1.0f;
            fArr[4] = 1.0f;
            fArr[5] = 1.25f;
        } else {
            fArr[i5] = 0.0f;
        }
        int i6 = 0;
        while (true) {
            int i7 = i4 + i6;
            if (i7 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int c6 = c(fArr, iArr, Integer.MAX_VALUE, bArr);
                int d5 = d(bArr);
                if (iArr[0] == c6) {
                    return 0;
                }
                if (d5 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (d5 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (d5 != 1 || bArr[2] <= 0) {
                    return (d5 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence.charAt(i7);
            i6++;
            if (f(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (g(charAt)) {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (h(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (j(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (k(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (i(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (g(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (l(charAt)) {
                c5 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c5 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i6 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                c(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int d6 = d(bArr2);
                if (iArr2[0] < iArr2[c5] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (d6 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (d6 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (d6 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i8 = i4 + i6 + 1; i8 < charSequence.length(); i8++) {
                            char charAt2 = charSequence.charAt(i8);
                            if (m(charAt2)) {
                                return 3;
                            }
                            if (!k(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static char o(int i4) {
        int i5 = ((i4 * 149) % 253) + 1 + 129;
        if (i5 > 254) {
            i5 -= 254;
        }
        return (char) i5;
    }
}
