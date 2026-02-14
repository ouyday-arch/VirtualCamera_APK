package c2;

import g1.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f2445a = b.f2446f;

    private int[] b(c cVar) {
        int d5 = cVar.d();
        int[] iArr = new int[d5];
        int i4 = 0;
        for (int i5 = 1; i5 < this.f2445a.e() && i4 < d5; i5++) {
            if (cVar.b(i5) == 0) {
                iArr[i4] = this.f2445a.g(i5);
                i4++;
            }
        }
        if (i4 == d5) {
            return iArr;
        }
        throw d.a();
    }

    private int[] c(c cVar, c cVar2, int[] iArr) {
        int d5 = cVar2.d();
        int[] iArr2 = new int[d5];
        for (int i4 = 1; i4 <= d5; i4++) {
            iArr2[d5 - i4] = this.f2445a.i(i4, cVar2.c(i4));
        }
        c cVar3 = new c(this.f2445a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            int g4 = this.f2445a.g(iArr[i5]);
            iArr3[i5] = this.f2445a.i(this.f2445a.j(0, cVar.b(g4)), this.f2445a.g(cVar3.b(g4)));
        }
        return iArr3;
    }

    private c[] d(c cVar, c cVar2, int i4) {
        if (cVar.d() < cVar2.d()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c f4 = this.f2445a.f();
        c d5 = this.f2445a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = d5;
            c cVar5 = f4;
            f4 = cVar4;
            if (cVar.d() < i4 / 2) {
                int c5 = f4.c(0);
                if (c5 == 0) {
                    throw d.a();
                }
                int g4 = this.f2445a.g(c5);
                return new c[]{f4.f(g4), cVar.f(g4)};
            }
            if (cVar.e()) {
                throw d.a();
            }
            c f5 = this.f2445a.f();
            int g5 = this.f2445a.g(cVar.c(cVar.d()));
            while (cVar2.d() >= cVar.d() && !cVar2.e()) {
                int d6 = cVar2.d() - cVar.d();
                int i5 = this.f2445a.i(cVar2.c(cVar2.d()), g5);
                f5 = f5.a(this.f2445a.b(d6, i5));
                cVar2 = cVar2.j(cVar.h(d6, i5));
            }
            d5 = f5.g(f4).j(cVar5).i();
        }
    }

    public int a(int[] iArr, int i4, int[] iArr2) {
        c cVar = new c(this.f2445a, iArr);
        int[] iArr3 = new int[i4];
        boolean z4 = false;
        for (int i5 = i4; i5 > 0; i5--) {
            int b5 = cVar.b(this.f2445a.c(i5));
            iArr3[i4 - i5] = b5;
            if (b5 != 0) {
                z4 = true;
            }
        }
        if (!z4) {
            return 0;
        }
        c d5 = this.f2445a.d();
        if (iArr2 != null) {
            for (int i6 : iArr2) {
                int c5 = this.f2445a.c((iArr.length - 1) - i6);
                b bVar = this.f2445a;
                d5 = d5.g(new c(bVar, new int[]{bVar.j(0, c5), 1}));
            }
        }
        c[] d6 = d(this.f2445a.b(i4, 1), new c(this.f2445a, iArr3), i4);
        c cVar2 = d6[0];
        c cVar3 = d6[1];
        int[] b6 = b(cVar2);
        int[] c6 = c(cVar3, cVar2, b6);
        for (int i7 = 0; i7 < b6.length; i7++) {
            int length = (iArr.length - 1) - this.f2445a.h(b6[i7]);
            if (length < 0) {
                throw d.a();
            }
            iArr[length] = this.f2445a.j(iArr[length], c6[i7]);
        }
        return b6.length;
    }
}
