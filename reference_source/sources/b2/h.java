package b2;

import g1.s;

/* loaded from: classes.dex */
final class h extends g {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f2288c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, boolean z4) {
        super(cVar);
        this.f2288c = z4;
    }

    private void h(a aVar) {
        c a5 = a();
        s h4 = this.f2288c ? a5.h() : a5.i();
        s b5 = this.f2288c ? a5.b() : a5.c();
        int e4 = e((int) b5.d());
        d[] d5 = d();
        int i4 = -1;
        int i5 = 0;
        int i6 = 1;
        for (int e5 = e((int) h4.d()); e5 < e4; e5++) {
            if (d5[e5] != null) {
                d dVar = d5[e5];
                dVar.j();
                int c5 = dVar.c() - i4;
                if (c5 == 0) {
                    i5++;
                } else {
                    if (c5 == 1) {
                        i6 = Math.max(i6, i5);
                    } else if (dVar.c() >= aVar.c()) {
                        d5[e5] = null;
                    }
                    i4 = dVar.c();
                    i5 = 1;
                }
            }
        }
    }

    private void l(d[] dVarArr, a aVar) {
        for (int i4 = 0; i4 < dVarArr.length; i4++) {
            d dVar = dVarArr[i4];
            if (dVarArr[i4] != null) {
                int e4 = dVar.e() % 30;
                int c5 = dVar.c();
                if (c5 > aVar.c()) {
                    dVarArr[i4] = null;
                } else {
                    if (!this.f2288c) {
                        c5 += 2;
                    }
                    int i5 = c5 % 3;
                    if (i5 != 0) {
                        if (i5 != 1) {
                            if (i5 == 2 && e4 + 1 != aVar.a()) {
                                dVarArr[i4] = null;
                            }
                        } else if (e4 / 3 != aVar.b() || e4 % 3 != aVar.d()) {
                            dVarArr[i4] = null;
                        }
                    } else if ((e4 * 3) + 1 != aVar.e()) {
                        dVarArr[i4] = null;
                    }
                }
            }
        }
    }

    private void m() {
        for (d dVar : d()) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(a aVar) {
        d[] d5 = d();
        m();
        l(d5, aVar);
        c a5 = a();
        s h4 = this.f2288c ? a5.h() : a5.i();
        s b5 = this.f2288c ? a5.b() : a5.c();
        int e4 = e((int) h4.d());
        int e5 = e((int) b5.d());
        int i4 = -1;
        int i5 = 0;
        int i6 = 1;
        while (e4 < e5) {
            if (d5[e4] != null) {
                d dVar = d5[e4];
                int c5 = dVar.c() - i4;
                if (c5 == 0) {
                    i5++;
                } else {
                    if (c5 == 1) {
                        i6 = Math.max(i6, i5);
                    } else if (c5 < 0 || dVar.c() >= aVar.c() || c5 > e4) {
                        d5[e4] = null;
                    } else {
                        if (i6 > 2) {
                            c5 *= i6 - 2;
                        }
                        boolean z4 = c5 >= e4;
                        for (int i7 = 1; i7 <= c5 && !z4; i7++) {
                            z4 = d5[e4 - i7] != null;
                        }
                        if (z4) {
                            d5[e4] = null;
                        }
                    }
                    i4 = dVar.c();
                    i5 = 1;
                }
            }
            e4++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a i() {
        d[] d5 = d();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : d5) {
            if (dVar != null) {
                dVar.j();
                int e4 = dVar.e() % 30;
                int c5 = dVar.c();
                if (!this.f2288c) {
                    c5 += 2;
                }
                int i4 = c5 % 3;
                if (i4 == 0) {
                    bVar2.b((e4 * 3) + 1);
                } else if (i4 == 1) {
                    bVar4.b(e4 / 3);
                    bVar3.b(e4 % 3);
                } else if (i4 == 2) {
                    bVar.b(e4 + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] <= 0 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        l(d5, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] j() {
        int c5;
        a i4 = i();
        if (i4 == null) {
            return null;
        }
        h(i4);
        int c6 = i4.c();
        int[] iArr = new int[c6];
        for (d dVar : d()) {
            if (dVar != null && (c5 = dVar.c()) < c6) {
                iArr[c5] = iArr[c5] + 1;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f2288c;
    }

    @Override // b2.g
    public String toString() {
        return "IsLeft: " + this.f2288c + '\n' + super.toString();
    }
}
