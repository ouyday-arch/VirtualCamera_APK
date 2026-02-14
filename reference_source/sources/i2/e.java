package i2;

import a.j;
import g1.v;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f4135a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f4136b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f4137c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, j.D0, -1, -1}, new int[]{6, 34, 62, 90, j.H0, -1, -1}, new int[]{6, 26, 50, 74, 98, j.L0, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, j.D0, 142, -1}, new int[]{6, 34, 62, 90, j.H0, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, j.D0, 142, 170}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f4138d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(n1.a aVar, g2.f fVar, g2.j jVar, int i4, b bVar) {
        c(bVar);
        d(jVar, bVar);
        l(fVar, i4, bVar);
        s(jVar, bVar);
        f(aVar, i4, bVar);
    }

    static int b(int i4, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int n4 = n(i5);
        int i6 = i4 << (n4 - 1);
        while (n(i6) >= n4) {
            i6 ^= i5 << (n(i6) - n4);
        }
        return i6;
    }

    static void c(b bVar) {
        bVar.a((byte) -1);
    }

    static void d(g2.j jVar, b bVar) {
        j(bVar);
        e(bVar);
        r(jVar, bVar);
        k(bVar);
    }

    private static void e(b bVar) {
        if (bVar.b(8, bVar.d() - 8) == 0) {
            throw new v();
        }
        bVar.f(8, bVar.d() - 8, 1);
    }

    static void f(n1.a aVar, int i4, b bVar) {
        boolean z4;
        int e4 = bVar.e() - 1;
        int d5 = bVar.d() - 1;
        int i5 = -1;
        int i6 = 0;
        while (e4 > 0) {
            if (e4 == 6) {
                e4--;
            }
            while (d5 >= 0 && d5 < bVar.d()) {
                for (int i7 = 0; i7 < 2; i7++) {
                    int i8 = e4 - i7;
                    if (o(bVar.b(i8, d5))) {
                        if (i6 < aVar.l()) {
                            z4 = aVar.g(i6);
                            i6++;
                        } else {
                            z4 = false;
                        }
                        if (i4 != -1 && d.f(i4, i8, d5)) {
                            z4 = !z4;
                        }
                        bVar.g(i8, d5, z4);
                    }
                }
                d5 += i5;
            }
            i5 = -i5;
            d5 += i5;
            e4 -= 2;
        }
        if (i6 == aVar.l()) {
            return;
        }
        throw new v("Not all bits consumed: " + i6 + '/' + aVar.l());
    }

    private static void g(int i4, int i5, b bVar) {
        for (int i6 = 0; i6 < 8; i6++) {
            int i7 = i4 + i6;
            if (!o(bVar.b(i7, i5))) {
                throw new v();
            }
            bVar.f(i7, i5, 0);
        }
    }

    private static void h(int i4, int i5, b bVar) {
        for (int i6 = 0; i6 < 5; i6++) {
            int[] iArr = f4136b[i6];
            for (int i7 = 0; i7 < 5; i7++) {
                bVar.f(i4 + i7, i5 + i6, iArr[i7]);
            }
        }
    }

    private static void i(int i4, int i5, b bVar) {
        for (int i6 = 0; i6 < 7; i6++) {
            int[] iArr = f4135a[i6];
            for (int i7 = 0; i7 < 7; i7++) {
                bVar.f(i4 + i7, i5 + i6, iArr[i7]);
            }
        }
    }

    private static void j(b bVar) {
        int length = f4135a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m((bVar.d() - 7) - 1, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    private static void k(b bVar) {
        int i4 = 8;
        while (i4 < bVar.e() - 8) {
            int i5 = i4 + 1;
            int i6 = i5 % 2;
            if (o(bVar.b(i4, 6))) {
                bVar.f(i4, 6, i6);
            }
            if (o(bVar.b(6, i4))) {
                bVar.f(6, i4, i6);
            }
            i4 = i5;
        }
    }

    static void l(g2.f fVar, int i4, b bVar) {
        int d5;
        n1.a aVar = new n1.a();
        p(fVar, i4, aVar);
        for (int i5 = 0; i5 < aVar.l(); i5++) {
            boolean g4 = aVar.g((aVar.l() - 1) - i5);
            int[] iArr = f4138d[i5];
            bVar.g(iArr[0], iArr[1], g4);
            int i6 = 8;
            if (i5 < 8) {
                d5 = 8;
                i6 = (bVar.e() - i5) - 1;
            } else {
                d5 = (bVar.d() - 7) + (i5 - 8);
            }
            bVar.g(i6, d5, g4);
        }
    }

    private static void m(int i4, int i5, b bVar) {
        for (int i6 = 0; i6 < 7; i6++) {
            int i7 = i5 + i6;
            if (!o(bVar.b(i4, i7))) {
                throw new v();
            }
            bVar.f(i4, i7, 0);
        }
    }

    static int n(int i4) {
        return 32 - Integer.numberOfLeadingZeros(i4);
    }

    private static boolean o(int i4) {
        return i4 == -1;
    }

    static void p(g2.f fVar, int i4, n1.a aVar) {
        if (!f.b(i4)) {
            throw new v("Invalid mask pattern");
        }
        int b5 = (fVar.b() << 3) | i4;
        aVar.c(b5, 5);
        aVar.c(b(b5, 1335), 10);
        n1.a aVar2 = new n1.a();
        aVar2.c(21522, 15);
        aVar.t(aVar2);
        if (aVar.l() == 15) {
            return;
        }
        throw new v("should not happen but we got: " + aVar.l());
    }

    static void q(g2.j jVar, n1.a aVar) {
        aVar.c(jVar.j(), 6);
        aVar.c(b(jVar.j(), 7973), 12);
        if (aVar.l() == 18) {
            return;
        }
        throw new v("should not happen but we got: " + aVar.l());
    }

    private static void r(g2.j jVar, b bVar) {
        if (jVar.j() < 2) {
            return;
        }
        int[] iArr = f4137c[jVar.j() - 1];
        for (int i4 : iArr) {
            if (i4 >= 0) {
                for (int i5 : iArr) {
                    if (i5 >= 0 && o(bVar.b(i5, i4))) {
                        h(i5 - 2, i4 - 2, bVar);
                    }
                }
            }
        }
    }

    static void s(g2.j jVar, b bVar) {
        if (jVar.j() < 7) {
            return;
        }
        n1.a aVar = new n1.a();
        q(jVar, aVar);
        int i4 = 17;
        for (int i5 = 0; i5 < 6; i5++) {
            for (int i6 = 0; i6 < 3; i6++) {
                boolean g4 = aVar.g(i4);
                i4--;
                bVar.g(i5, (bVar.d() - 11) + i6, g4);
                bVar.g((bVar.d() - 11) + i6, i5, g4);
            }
        }
    }
}
