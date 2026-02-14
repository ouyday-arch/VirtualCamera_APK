package h2;

import g1.m;
import g1.s;
import g1.t;
import g2.j;
import java.util.Map;
import n1.g;
import n1.i;
import n1.k;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final n1.b f4087a;

    /* renamed from: b, reason: collision with root package name */
    private t f4088b;

    public c(n1.b bVar) {
        this.f4087a = bVar;
    }

    private float b(s sVar, s sVar2) {
        float j4 = j((int) sVar.c(), (int) sVar.d(), (int) sVar2.c(), (int) sVar2.d());
        float j5 = j((int) sVar2.c(), (int) sVar2.d(), (int) sVar.c(), (int) sVar.d());
        return Float.isNaN(j4) ? j5 / 7.0f : Float.isNaN(j5) ? j4 / 7.0f : (j4 + j5) / 14.0f;
    }

    private static int c(s sVar, s sVar2, s sVar3, float f4) {
        int c5 = ((o1.a.c(s.b(sVar, sVar2) / f4) + o1.a.c(s.b(sVar, sVar3) / f4)) / 2) + 7;
        int i4 = c5 & 3;
        if (i4 == 0) {
            return c5 + 1;
        }
        if (i4 == 2) {
            return c5 - 1;
        }
        if (i4 != 3) {
            return c5;
        }
        throw m.a();
    }

    private static k d(s sVar, s sVar2, s sVar3, s sVar4, int i4) {
        float c5;
        float d5;
        float f4;
        float f5 = i4 - 3.5f;
        if (sVar4 != null) {
            c5 = sVar4.c();
            d5 = sVar4.d();
            f4 = f5 - 3.0f;
        } else {
            c5 = (sVar2.c() - sVar.c()) + sVar3.c();
            d5 = (sVar2.d() - sVar.d()) + sVar3.d();
            f4 = f5;
        }
        return k.b(3.5f, 3.5f, f5, 3.5f, f4, f4, 3.5f, f5, sVar.c(), sVar.d(), sVar2.c(), sVar2.d(), c5, d5, sVar3.c(), sVar3.d());
    }

    private static n1.b h(n1.b bVar, k kVar, int i4) {
        return i.b().d(bVar, i4, i4, kVar);
    }

    private float i(int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        c cVar;
        boolean z4;
        int i14;
        int i15 = 1;
        boolean z5 = Math.abs(i7 - i5) > Math.abs(i6 - i4);
        if (z5) {
            i9 = i4;
            i8 = i5;
            i11 = i6;
            i10 = i7;
        } else {
            i8 = i4;
            i9 = i5;
            i10 = i6;
            i11 = i7;
        }
        int abs = Math.abs(i10 - i8);
        int abs2 = Math.abs(i11 - i9);
        int i16 = 2;
        int i17 = (-abs) / 2;
        int i18 = i8 < i10 ? 1 : -1;
        int i19 = i9 < i11 ? 1 : -1;
        int i20 = i10 + i18;
        int i21 = i8;
        int i22 = i9;
        int i23 = 0;
        while (true) {
            if (i21 == i20) {
                i12 = i20;
                i13 = i16;
                break;
            }
            int i24 = z5 ? i22 : i21;
            int i25 = z5 ? i21 : i22;
            if (i23 == i15) {
                z4 = z5;
                i14 = i15;
                i12 = i20;
                cVar = this;
            } else {
                cVar = this;
                z4 = z5;
                i12 = i20;
                i14 = 0;
            }
            if (i14 == cVar.f4087a.e(i24, i25)) {
                if (i23 == 2) {
                    return o1.a.b(i21, i22, i8, i9);
                }
                i23++;
            }
            i17 += abs2;
            if (i17 > 0) {
                if (i22 == i11) {
                    i13 = 2;
                    break;
                }
                i22 += i19;
                i17 -= abs;
            }
            i21 += i18;
            i20 = i12;
            z5 = z4;
            i15 = 1;
            i16 = 2;
        }
        if (i23 == i13) {
            return o1.a.b(i12, i11, i8, i9);
        }
        return Float.NaN;
    }

    private float j(int i4, int i5, int i6, int i7) {
        float f4;
        float f5;
        float i8 = i(i4, i5, i6, i7);
        int i9 = i4 - (i6 - i4);
        int i10 = 0;
        if (i9 < 0) {
            f4 = i4 / (i4 - i9);
            i9 = 0;
        } else if (i9 >= this.f4087a.l()) {
            f4 = ((this.f4087a.l() - 1) - i4) / (i9 - i4);
            i9 = this.f4087a.l() - 1;
        } else {
            f4 = 1.0f;
        }
        float f6 = i5;
        int i11 = (int) (f6 - ((i7 - i5) * f4));
        if (i11 < 0) {
            f5 = f6 / (i5 - i11);
        } else if (i11 >= this.f4087a.h()) {
            f5 = ((this.f4087a.h() - 1) - i5) / (i11 - i5);
            i10 = this.f4087a.h() - 1;
        } else {
            i10 = i11;
            f5 = 1.0f;
        }
        return (i8 + i(i4, i5, (int) (i4 + ((i9 - i4) * f5)), i10)) - 1.0f;
    }

    protected final float a(s sVar, s sVar2, s sVar3) {
        return (b(sVar, sVar2) + b(sVar, sVar3)) / 2.0f;
    }

    public final g e(Map<g1.e, ?> map) {
        this.f4088b = map == null ? null : (t) map.get(g1.e.NEED_RESULT_POINT_CALLBACK);
        return g(new e(this.f4087a, this.f4088b).g(map));
    }

    protected final a f(float f4, int i4, int i5, float f5) {
        int i6 = (int) (f5 * f4);
        int max = Math.max(0, i4 - i6);
        int min = Math.min(this.f4087a.l() - 1, i4 + i6) - max;
        float f6 = 3.0f * f4;
        if (min < f6) {
            throw m.a();
        }
        int max2 = Math.max(0, i5 - i6);
        int min2 = Math.min(this.f4087a.h() - 1, i5 + i6) - max2;
        if (min2 >= f6) {
            return new b(this.f4087a, max, max2, min, min2, f4, this.f4088b).c();
        }
        throw m.a();
    }

    protected final g g(f fVar) {
        d b5 = fVar.b();
        d c5 = fVar.c();
        d a5 = fVar.a();
        float a6 = a(b5, c5, a5);
        if (a6 < 1.0f) {
            throw m.a();
        }
        int c6 = c(b5, c5, a5, a6);
        j g4 = j.g(c6);
        int e4 = g4.e() - 7;
        a aVar = null;
        if (g4.d().length > 0) {
            float c7 = (c5.c() - b5.c()) + a5.c();
            float d5 = (c5.d() - b5.d()) + a5.d();
            float f4 = 1.0f - (3.0f / e4);
            int c8 = (int) (b5.c() + ((c7 - b5.c()) * f4));
            int d6 = (int) (b5.d() + (f4 * (d5 - b5.d())));
            for (int i4 = 4; i4 <= 16; i4 <<= 1) {
                try {
                    aVar = f(a6, c8, d6, i4);
                    break;
                } catch (m unused) {
                }
            }
        }
        return new g(h(this.f4087a, d(b5, c5, a5, aVar, c6), c6), aVar == null ? new s[]{a5, b5, c5} : new s[]{a5, b5, c5, aVar});
    }
}
