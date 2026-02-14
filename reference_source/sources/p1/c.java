package p1;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f5429a;

    public c(a aVar) {
        this.f5429a = aVar;
    }

    private int[] b(b bVar) {
        int f4 = bVar.f();
        int i4 = 0;
        if (f4 == 1) {
            return new int[]{bVar.d(1)};
        }
        int[] iArr = new int[f4];
        for (int i5 = 1; i5 < this.f5429a.f() && i4 < f4; i5++) {
            if (bVar.c(i5) == 0) {
                iArr[i4] = this.f5429a.h(i5);
                i4++;
            }
        }
        if (i4 == f4) {
            return iArr;
        }
        throw new e("Error locator degree does not match number of roots");
    }

    private int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i4 = 0; i4 < length; i4++) {
            int h4 = this.f5429a.h(iArr[i4]);
            int i5 = 1;
            for (int i6 = 0; i6 < length; i6++) {
                if (i4 != i6) {
                    int j4 = this.f5429a.j(iArr[i6], h4);
                    i5 = this.f5429a.j(i5, (j4 & 1) == 0 ? j4 | 1 : j4 & (-2));
                }
            }
            iArr2[i4] = this.f5429a.j(bVar.c(h4), this.f5429a.h(i5));
            if (this.f5429a.d() != 0) {
                iArr2[i4] = this.f5429a.j(iArr2[i4], h4);
            }
        }
        return iArr2;
    }

    private b[] d(b bVar, b bVar2, int i4) {
        if (bVar.f() < bVar2.f()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b g4 = this.f5429a.g();
        b e4 = this.f5429a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = e4;
            b bVar5 = g4;
            g4 = bVar4;
            if (bVar.f() < i4 / 2) {
                int d5 = g4.d(0);
                if (d5 == 0) {
                    throw new e("sigmaTilde(0) was zero");
                }
                int h4 = this.f5429a.h(d5);
                return new b[]{g4.h(h4), bVar.h(h4)};
            }
            if (bVar.g()) {
                throw new e("r_{i-1} was zero");
            }
            b g5 = this.f5429a.g();
            int h5 = this.f5429a.h(bVar.d(bVar.f()));
            while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                int f4 = bVar2.f() - bVar.f();
                int j4 = this.f5429a.j(bVar2.d(bVar2.f()), h5);
                g5 = g5.a(this.f5429a.b(f4, j4));
                bVar2 = bVar2.a(bVar.j(f4, j4));
            }
            e4 = g5.i(g4).a(bVar5);
        } while (bVar2.f() < bVar.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    public void a(int[] iArr, int i4) {
        b bVar = new b(this.f5429a, iArr);
        int[] iArr2 = new int[i4];
        boolean z4 = true;
        for (int i5 = 0; i5 < i4; i5++) {
            a aVar = this.f5429a;
            int c5 = bVar.c(aVar.c(aVar.d() + i5));
            iArr2[(i4 - 1) - i5] = c5;
            if (c5 != 0) {
                z4 = false;
            }
        }
        if (z4) {
            return;
        }
        b[] d5 = d(this.f5429a.b(i4, 1), new b(this.f5429a, iArr2), i4);
        b bVar2 = d5[0];
        b bVar3 = d5[1];
        int[] b5 = b(bVar2);
        int[] c6 = c(bVar3, b5);
        for (int i6 = 0; i6 < b5.length; i6++) {
            int length = (iArr.length - 1) - this.f5429a.i(b5[i6]);
            if (length < 0) {
                throw new e("Bad error location");
            }
            iArr[length] = a.a(iArr[length], c6[i6]);
        }
    }
}
