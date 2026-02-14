package i2;

/* loaded from: classes.dex */
final class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    private static int b(b bVar, boolean z4) {
        int d5 = z4 ? bVar.d() : bVar.e();
        int e4 = z4 ? bVar.e() : bVar.d();
        byte[][] c5 = bVar.c();
        int i4 = 0;
        for (int i5 = 0; i5 < d5; i5++) {
            byte b5 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < e4; i7++) {
                byte b6 = z4 ? c5[i5][i7] : c5[i7][i5];
                if (b6 == b5) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i4 += (i6 - 5) + 3;
                    }
                    i6 = 1;
                    b5 = b6;
                }
            }
            if (i6 >= 5) {
                i4 += (i6 - 5) + 3;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(b bVar) {
        byte[][] c5 = bVar.c();
        int e4 = bVar.e();
        int d5 = bVar.d();
        int i4 = 0;
        for (int i5 = 0; i5 < d5 - 1; i5++) {
            byte[] bArr = c5[i5];
            int i6 = 0;
            while (i6 < e4 - 1) {
                byte b5 = bArr[i6];
                int i7 = i6 + 1;
                if (b5 == bArr[i7]) {
                    int i8 = i5 + 1;
                    if (b5 == c5[i8][i6] && b5 == c5[i8][i7]) {
                        i4++;
                    }
                }
                i6 = i7;
            }
        }
        return i4 * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(b bVar) {
        byte[][] c5 = bVar.c();
        int e4 = bVar.e();
        int d5 = bVar.d();
        int i4 = 0;
        for (int i5 = 0; i5 < d5; i5++) {
            for (int i6 = 0; i6 < e4; i6++) {
                byte[] bArr = c5[i5];
                int i7 = i6 + 6;
                if (i7 < e4 && bArr[i6] == 1 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 1 && bArr[i6 + 3] == 1 && bArr[i6 + 4] == 1 && bArr[i6 + 5] == 0 && bArr[i7] == 1 && (g(bArr, i6 - 4, i6) || g(bArr, i6 + 7, i6 + 11))) {
                    i4++;
                }
                int i8 = i5 + 6;
                if (i8 < d5 && c5[i5][i6] == 1 && c5[i5 + 1][i6] == 0 && c5[i5 + 2][i6] == 1 && c5[i5 + 3][i6] == 1 && c5[i5 + 4][i6] == 1 && c5[i5 + 5][i6] == 0 && c5[i8][i6] == 1 && (h(c5, i6, i5 - 4, i5) || h(c5, i6, i5 + 7, i5 + 11))) {
                    i4++;
                }
            }
        }
        return i4 * 40;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(b bVar) {
        byte[][] c5 = bVar.c();
        int e4 = bVar.e();
        int d5 = bVar.d();
        int i4 = 0;
        for (int i5 = 0; i5 < d5; i5++) {
            byte[] bArr = c5[i5];
            for (int i6 = 0; i6 < e4; i6++) {
                if (bArr[i6] == 1) {
                    i4++;
                }
            }
        }
        int d6 = bVar.d() * bVar.e();
        return ((Math.abs((i4 << 1) - d6) * 10) / d6) * 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean f(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L38;
                case 1: goto L39;
                case 2: goto L35;
                case 3: goto L31;
                case 4: goto L2c;
                case 5: goto L25;
                case 6: goto L1d;
                case 7: goto L14;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "Invalid mask pattern: "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L14:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L23
        L1d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L23:
            r1 = r1 & r0
            goto L3b
        L25:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L3b
        L2c:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L38
        L31:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L3b
        L35:
            int r1 = r2 % 3
            goto L3b
        L38:
            int r3 = r3 + r2
        L39:
            r1 = r3 & 1
        L3b:
            if (r1 != 0) goto L3e
            return r0
        L3e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.d.f(int, int, int):boolean");
    }

    private static boolean g(byte[] bArr, int i4, int i5) {
        int min = Math.min(i5, bArr.length);
        for (int max = Math.max(i4, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i4, int i5, int i6) {
        int min = Math.min(i6, bArr.length);
        for (int max = Math.max(i5, 0); max < min; max++) {
            if (bArr[max][i4] == 1) {
                return false;
            }
        }
        return true;
    }
}
