package k1;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f4378a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] a(n1.a aVar, int i4, int i5) {
        int[] iArr = new int[i5];
        int l4 = aVar.l() / i4;
        for (int i6 = 0; i6 < l4; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 |= aVar.g((i6 * i4) + i8) ? 1 << ((i4 - i8) - 1) : 0;
            }
            iArr[i6] = i7;
        }
        return iArr;
    }

    private static void b(n1.b bVar, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6 += 2) {
            int i7 = i4 - i6;
            int i8 = i7;
            while (true) {
                int i9 = i4 + i6;
                if (i8 <= i9) {
                    bVar.n(i8, i7);
                    bVar.n(i8, i9);
                    bVar.n(i7, i8);
                    bVar.n(i9, i8);
                    i8++;
                }
            }
        }
        int i10 = i4 - i5;
        bVar.n(i10, i10);
        int i11 = i10 + 1;
        bVar.n(i11, i10);
        bVar.n(i10, i11);
        int i12 = i4 + i5;
        bVar.n(i12, i10);
        bVar.n(i12, i11);
        bVar.n(i12, i12 - 1);
    }

    private static void c(n1.b bVar, boolean z4, int i4, n1.a aVar) {
        int i5 = i4 / 2;
        int i6 = 0;
        if (z4) {
            while (i6 < 7) {
                int i7 = (i5 - 3) + i6;
                if (aVar.g(i6)) {
                    bVar.n(i7, i5 - 5);
                }
                if (aVar.g(i6 + 7)) {
                    bVar.n(i5 + 5, i7);
                }
                if (aVar.g(20 - i6)) {
                    bVar.n(i7, i5 + 5);
                }
                if (aVar.g(27 - i6)) {
                    bVar.n(i5 - 5, i7);
                }
                i6++;
            }
            return;
        }
        while (i6 < 10) {
            int i8 = (i5 - 5) + i6 + (i6 / 5);
            if (aVar.g(i6)) {
                bVar.n(i8, i5 - 7);
            }
            if (aVar.g(i6 + 10)) {
                bVar.n(i5 + 7, i8);
            }
            if (aVar.g(29 - i6)) {
                bVar.n(i8, i5 + 7);
            }
            if (aVar.g(39 - i6)) {
                bVar.n(i5 - 7, i8);
            }
            i6++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a d(byte[] bArr, int i4, int i5) {
        n1.a aVar;
        int i6;
        boolean z4;
        int i7;
        int i8;
        int i9;
        n1.a a5 = new d(bArr).a();
        int l4 = ((a5.l() * i4) / 100) + 11;
        int l5 = a5.l() + l4;
        int i10 = 0;
        int i11 = 1;
        if (i5 == 0) {
            n1.a aVar2 = null;
            int i12 = 0;
            int i13 = 0;
            while (i12 <= 32) {
                boolean z5 = i12 <= 3 ? i11 : i10;
                int i14 = z5 != 0 ? i12 + 1 : i12;
                int i15 = i(i14, z5);
                if (l5 <= i15) {
                    if (aVar2 == null || i13 != f4378a[i14]) {
                        int i16 = f4378a[i14];
                        i13 = i16;
                        aVar2 = h(a5, i16);
                    }
                    int i17 = i15 - (i15 % i13);
                    if ((z5 == 0 || aVar2.l() <= (i13 << 6)) && aVar2.l() + l4 <= i17) {
                        aVar = aVar2;
                        i6 = i13;
                        z4 = z5;
                        i7 = i14;
                        i8 = i15;
                    }
                }
                i12++;
                i11 = i11;
                i10 = 0;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z4 = i5 < 0;
        i7 = Math.abs(i5);
        if (i7 > (z4 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i5)));
        }
        i8 = i(i7, z4);
        i6 = f4378a[i7];
        int i18 = i8 - (i8 % i6);
        aVar = h(a5, i6);
        if (aVar.l() + l4 > i18) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z4 && aVar.l() > (i6 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        n1.a e4 = e(aVar, i8, i6);
        int l6 = aVar.l() / i6;
        n1.a f4 = f(z4, i7, l6);
        int i19 = (z4 ? 11 : 14) + (i7 << 2);
        int[] iArr = new int[i19];
        int i20 = 2;
        if (z4) {
            for (int i21 = i10; i21 < i19; i21++) {
                iArr[i21] = i21;
            }
            i9 = i19;
        } else {
            int i22 = i19 / 2;
            i9 = i19 + 1 + (((i22 - 1) / 15) * 2);
            int i23 = i9 / 2;
            for (int i24 = i10; i24 < i22; i24++) {
                iArr[(i22 - i24) - i11] = (i23 - r14) - 1;
                iArr[i22 + i24] = (i24 / 15) + i24 + i23 + i11;
            }
        }
        n1.b bVar = new n1.b(i9);
        int i25 = i10;
        int i26 = i25;
        while (i25 < i7) {
            int i27 = ((i7 - i25) << i20) + (z4 ? 9 : 12);
            int i28 = i10;
            while (i28 < i27) {
                int i29 = i28 << 1;
                while (i10 < i20) {
                    if (e4.g(i26 + i29 + i10)) {
                        int i30 = i25 << 1;
                        bVar.n(iArr[i30 + i10], iArr[i30 + i28]);
                    }
                    if (e4.g((i27 << 1) + i26 + i29 + i10)) {
                        int i31 = i25 << 1;
                        bVar.n(iArr[i31 + i28], iArr[((i19 - 1) - i31) - i10]);
                    }
                    if (e4.g((i27 << 2) + i26 + i29 + i10)) {
                        int i32 = (i19 - 1) - (i25 << 1);
                        bVar.n(iArr[i32 - i10], iArr[i32 - i28]);
                    }
                    if (e4.g((i27 * 6) + i26 + i29 + i10)) {
                        int i33 = i25 << 1;
                        bVar.n(iArr[((i19 - 1) - i33) - i28], iArr[i33 + i10]);
                    }
                    i10++;
                    i20 = 2;
                }
                i28++;
                i10 = 0;
                i20 = 2;
            }
            i26 += i27 << 3;
            i25++;
            i10 = 0;
            i20 = 2;
        }
        c(bVar, z4, i9, f4);
        int i34 = i9 / 2;
        if (z4) {
            b(bVar, i34, 5);
        } else {
            b(bVar, i34, 7);
            int i35 = 0;
            int i36 = 0;
            while (i36 < (i19 / 2) - 1) {
                for (int i37 = i34 & 1; i37 < i9; i37 += 2) {
                    int i38 = i34 - i35;
                    bVar.n(i38, i37);
                    int i39 = i34 + i35;
                    bVar.n(i39, i37);
                    bVar.n(i37, i38);
                    bVar.n(i37, i39);
                }
                i36 += 15;
                i35 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.c(z4);
        aVar3.f(i9);
        aVar3.d(i7);
        aVar3.b(l6);
        aVar3.e(bVar);
        return aVar3;
    }

    private static n1.a e(n1.a aVar, int i4, int i5) {
        int l4 = aVar.l() / i5;
        p1.d dVar = new p1.d(g(i5));
        int i6 = i4 / i5;
        int[] a5 = a(aVar, i5, i6);
        dVar.b(a5, i6 - l4);
        n1.a aVar2 = new n1.a();
        aVar2.c(0, i4 % i5);
        for (int i7 : a5) {
            aVar2.c(i7, i5);
        }
        return aVar2;
    }

    static n1.a f(boolean z4, int i4, int i5) {
        int i6;
        n1.a aVar = new n1.a();
        int i7 = i4 - 1;
        if (z4) {
            aVar.c(i7, 2);
            aVar.c(i5 - 1, 6);
            i6 = 28;
        } else {
            aVar.c(i7, 5);
            aVar.c(i5 - 1, 11);
            i6 = 40;
        }
        return e(aVar, i6, 4);
    }

    private static p1.a g(int i4) {
        if (i4 == 4) {
            return p1.a.f5415k;
        }
        if (i4 == 6) {
            return p1.a.f5414j;
        }
        if (i4 == 8) {
            return p1.a.f5418n;
        }
        if (i4 == 10) {
            return p1.a.f5413i;
        }
        if (i4 == 12) {
            return p1.a.f5412h;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i4)));
    }

    static n1.a h(n1.a aVar, int i4) {
        n1.a aVar2 = new n1.a();
        int l4 = aVar.l();
        int i5 = (1 << i4) - 2;
        int i6 = 0;
        while (i6 < l4) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = i6 + i8;
                if (i9 >= l4 || aVar.g(i9)) {
                    i7 |= 1 << ((i4 - 1) - i8);
                }
            }
            int i10 = i7 & i5;
            if (i10 != i5) {
                if (i10 == 0) {
                    i10 = i7 | 1;
                } else {
                    aVar2.c(i7, i4);
                    i6 += i4;
                }
            }
            aVar2.c(i10, i4);
            i6--;
            i6 += i4;
        }
        return aVar2;
    }

    private static int i(int i4, boolean z4) {
        return ((z4 ? 88 : 112) + (i4 << 4)) * i4;
    }
}
