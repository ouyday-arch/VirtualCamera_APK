package s1;

import g1.m;
import g1.s;
import n1.b;
import n1.g;
import n1.i;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f5884a;

    /* renamed from: b, reason: collision with root package name */
    private final o1.b f5885b;

    public a(b bVar) {
        this.f5884a = bVar;
        this.f5885b = new o1.b(bVar);
    }

    private s a(s[] sVarArr) {
        s sVar = sVarArr[0];
        s sVar2 = sVarArr[1];
        s sVar3 = sVarArr[2];
        s sVar4 = sVarArr[3];
        int j4 = j(sVar, sVar4);
        s h4 = h(sVar, sVar2, (j(sVar2, sVar4) + 1) << 2);
        s h5 = h(sVar3, sVar2, (j4 + 1) << 2);
        int j5 = j(h4, sVar4);
        int j6 = j(h5, sVar4);
        float f4 = j5 + 1;
        s sVar5 = new s(sVar4.c() + ((sVar3.c() - sVar2.c()) / f4), sVar4.d() + ((sVar3.d() - sVar2.d()) / f4));
        float f5 = j6 + 1;
        s sVar6 = new s(sVar4.c() + ((sVar.c() - sVar2.c()) / f5), sVar4.d() + ((sVar.d() - sVar2.d()) / f5));
        if (e(sVar5)) {
            return (e(sVar6) && j(h4, sVar5) + j(h5, sVar5) <= j(h4, sVar6) + j(h5, sVar6)) ? sVar6 : sVar5;
        }
        if (e(sVar6)) {
            return sVar6;
        }
        return null;
    }

    private s[] c(s[] sVarArr) {
        s sVar = sVarArr[0];
        s sVar2 = sVarArr[1];
        s sVar3 = sVarArr[3];
        s sVar4 = sVarArr[2];
        int j4 = j(sVar, sVar2);
        int j5 = j(sVar2, sVar3);
        int j6 = j(sVar3, sVar4);
        int j7 = j(sVar4, sVar);
        s[] sVarArr2 = {sVar4, sVar, sVar2, sVar3};
        if (j4 > j5) {
            sVarArr2[0] = sVar;
            sVarArr2[1] = sVar2;
            sVarArr2[2] = sVar3;
            sVarArr2[3] = sVar4;
            j4 = j5;
        }
        if (j4 > j6) {
            sVarArr2[0] = sVar2;
            sVarArr2[1] = sVar3;
            sVarArr2[2] = sVar4;
            sVarArr2[3] = sVar;
        } else {
            j6 = j4;
        }
        if (j6 > j7) {
            sVarArr2[0] = sVar3;
            sVarArr2[1] = sVar4;
            sVarArr2[2] = sVar;
            sVarArr2[3] = sVar2;
        }
        return sVarArr2;
    }

    private s[] d(s[] sVarArr) {
        s sVar = sVarArr[0];
        s sVar2 = sVarArr[1];
        s sVar3 = sVarArr[2];
        s sVar4 = sVarArr[3];
        int j4 = (j(sVar, sVar4) + 1) << 2;
        if (j(h(sVar2, sVar3, j4), sVar) < j(h(sVar3, sVar2, j4), sVar4)) {
            sVarArr[0] = sVar;
            sVarArr[1] = sVar2;
            sVarArr[2] = sVar3;
            sVarArr[3] = sVar4;
        } else {
            sVarArr[0] = sVar2;
            sVarArr[1] = sVar3;
            sVarArr[2] = sVar4;
            sVarArr[3] = sVar;
        }
        return sVarArr;
    }

    private boolean e(s sVar) {
        return sVar.c() >= 0.0f && sVar.c() < ((float) this.f5884a.l()) && sVar.d() > 0.0f && sVar.d() < ((float) this.f5884a.h());
    }

    private static s f(s sVar, float f4, float f5) {
        float c5 = sVar.c();
        float d5 = sVar.d();
        return new s(c5 < f4 ? c5 - 1.0f : c5 + 1.0f, d5 < f5 ? d5 - 1.0f : d5 + 1.0f);
    }

    private static b g(b bVar, s sVar, s sVar2, s sVar3, s sVar4, int i4, int i5) {
        float f4 = i4 - 0.5f;
        float f5 = i5 - 0.5f;
        return i.b().c(bVar, i4, i5, 0.5f, 0.5f, f4, 0.5f, f4, f5, 0.5f, f5, sVar.c(), sVar.d(), sVar4.c(), sVar4.d(), sVar3.c(), sVar3.d(), sVar2.c(), sVar2.d());
    }

    private static s h(s sVar, s sVar2, int i4) {
        float f4 = i4 + 1;
        return new s(sVar.c() + ((sVar2.c() - sVar.c()) / f4), sVar.d() + ((sVar2.d() - sVar.d()) / f4));
    }

    private s[] i(s[] sVarArr) {
        s sVar = sVarArr[0];
        s sVar2 = sVarArr[1];
        s sVar3 = sVarArr[2];
        s sVar4 = sVarArr[3];
        int j4 = j(sVar, sVar4) + 1;
        s h4 = h(sVar, sVar2, (j(sVar3, sVar4) + 1) << 2);
        s h5 = h(sVar3, sVar2, j4 << 2);
        int j5 = j(h4, sVar4) + 1;
        int j6 = j(h5, sVar4) + 1;
        if ((j5 & 1) == 1) {
            j5++;
        }
        if ((j6 & 1) == 1) {
            j6++;
        }
        float c5 = (((sVar.c() + sVar2.c()) + sVar3.c()) + sVar4.c()) / 4.0f;
        float d5 = (((sVar.d() + sVar2.d()) + sVar3.d()) + sVar4.d()) / 4.0f;
        s f4 = f(sVar, c5, d5);
        s f5 = f(sVar2, c5, d5);
        s f6 = f(sVar3, c5, d5);
        s f7 = f(sVar4, c5, d5);
        int i4 = j6 << 2;
        int i5 = j5 << 2;
        return new s[]{h(h(f4, f5, i4), f7, i5), h(h(f5, f4, i4), f6, i5), h(h(f6, f7, i4), f5, i5), h(h(f7, f6, i4), f4, i5)};
    }

    private int j(s sVar, s sVar2) {
        int c5 = (int) sVar.c();
        int d5 = (int) sVar.d();
        int c6 = (int) sVar2.c();
        int d6 = (int) sVar2.d();
        int i4 = 0;
        boolean z4 = Math.abs(d6 - d5) > Math.abs(c6 - c5);
        if (z4) {
            d5 = c5;
            c5 = d5;
            d6 = c6;
            c6 = d6;
        }
        int abs = Math.abs(c6 - c5);
        int abs2 = Math.abs(d6 - d5);
        int i5 = (-abs) / 2;
        int i6 = d5 < d6 ? 1 : -1;
        int i7 = c5 >= c6 ? -1 : 1;
        boolean e4 = this.f5884a.e(z4 ? d5 : c5, z4 ? c5 : d5);
        while (c5 != c6) {
            boolean e5 = this.f5884a.e(z4 ? d5 : c5, z4 ? c5 : d5);
            if (e5 != e4) {
                i4++;
                e4 = e5;
            }
            i5 += abs2;
            if (i5 > 0) {
                if (d5 == d6) {
                    break;
                }
                d5 += i6;
                i5 -= abs;
            }
            c5 += i7;
        }
        return i4;
    }

    public g b() {
        int i4;
        int i5;
        s[] d5 = d(c(this.f5885b.c()));
        d5[3] = a(d5);
        if (d5[3] == null) {
            throw m.a();
        }
        s[] i6 = i(d5);
        s sVar = i6[0];
        s sVar2 = i6[1];
        s sVar3 = i6[2];
        s sVar4 = i6[3];
        int j4 = j(sVar, sVar4) + 1;
        int j5 = j(sVar3, sVar4) + 1;
        if ((j4 & 1) == 1) {
            j4++;
        }
        if ((j5 & 1) == 1) {
            j5++;
        }
        if (j4 * 4 >= j5 * 7 || j5 * 4 >= j4 * 7) {
            i4 = j4;
            i5 = j5;
        } else {
            i4 = Math.max(j4, j5);
            i5 = i4;
        }
        return new g(g(this.f5884a, sVar, sVar2, sVar3, sVar4, i4, i5), new s[]{sVar, sVar2, sVar3, sVar4});
    }
}
