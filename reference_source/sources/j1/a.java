package j1;

import g1.m;
import g1.s;
import n1.b;
import n1.i;
import p1.c;
import p1.e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f4180g = {3808, 476, 2107, 1799};

    /* renamed from: a, reason: collision with root package name */
    private final b f4181a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4182b;

    /* renamed from: c, reason: collision with root package name */
    private int f4183c;

    /* renamed from: d, reason: collision with root package name */
    private int f4184d;

    /* renamed from: e, reason: collision with root package name */
    private int f4185e;

    /* renamed from: f, reason: collision with root package name */
    private int f4186f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0050a {

        /* renamed from: a, reason: collision with root package name */
        private final int f4187a;

        /* renamed from: b, reason: collision with root package name */
        private final int f4188b;

        C0050a(int i4, int i5) {
            this.f4187a = i4;
            this.f4188b = i5;
        }

        int a() {
            return this.f4187a;
        }

        int b() {
            return this.f4188b;
        }

        s c() {
            return new s(this.f4187a, this.f4188b);
        }

        public String toString() {
            return "<" + this.f4187a + ' ' + this.f4188b + '>';
        }
    }

    public a(b bVar) {
        this.f4181a = bVar;
    }

    private static float b(s sVar, s sVar2) {
        return o1.a.a(sVar.c(), sVar.d(), sVar2.c(), sVar2.d());
    }

    private static float c(C0050a c0050a, C0050a c0050a2) {
        return o1.a.b(c0050a.a(), c0050a.b(), c0050a2.a(), c0050a2.b());
    }

    private static s[] d(s[] sVarArr, int i4, int i5) {
        float f4 = i5 / (i4 * 2.0f);
        float c5 = sVarArr[0].c() - sVarArr[2].c();
        float d5 = sVarArr[0].d() - sVarArr[2].d();
        float c6 = (sVarArr[0].c() + sVarArr[2].c()) / 2.0f;
        float d6 = (sVarArr[0].d() + sVarArr[2].d()) / 2.0f;
        float f5 = c5 * f4;
        float f6 = d5 * f4;
        s sVar = new s(c6 + f5, d6 + f6);
        s sVar2 = new s(c6 - f5, d6 - f6);
        float c7 = sVarArr[1].c() - sVarArr[3].c();
        float d7 = sVarArr[1].d() - sVarArr[3].d();
        float c8 = (sVarArr[1].c() + sVarArr[3].c()) / 2.0f;
        float d8 = (sVarArr[1].d() + sVarArr[3].d()) / 2.0f;
        float f7 = c7 * f4;
        float f8 = f4 * d7;
        return new s[]{sVar, new s(c8 + f7, d8 + f8), sVar2, new s(c8 - f7, d8 - f8)};
    }

    private void e(s[] sVarArr) {
        int i4;
        long j4;
        long j5;
        if (!o(sVarArr[0]) || !o(sVarArr[1]) || !o(sVarArr[2]) || !o(sVarArr[3])) {
            throw m.a();
        }
        int i5 = this.f4185e * 2;
        int[] iArr = {r(sVarArr[0], sVarArr[1], i5), r(sVarArr[1], sVarArr[2], i5), r(sVarArr[2], sVarArr[3], i5), r(sVarArr[3], sVarArr[0], i5)};
        this.f4186f = m(iArr, i5);
        long j6 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = iArr[(this.f4186f + i6) % 4];
            if (this.f4182b) {
                j4 = j6 << 7;
                j5 = (i7 >> 1) & 127;
            } else {
                j4 = j6 << 10;
                j5 = ((i7 >> 2) & 992) + ((i7 >> 1) & 31);
            }
            j6 = j4 + j5;
        }
        int h4 = h(j6, this.f4182b);
        if (this.f4182b) {
            this.f4183c = (h4 >> 6) + 1;
            i4 = h4 & 63;
        } else {
            this.f4183c = (h4 >> 11) + 1;
            i4 = h4 & 2047;
        }
        this.f4184d = i4 + 1;
    }

    private s[] f(C0050a c0050a) {
        this.f4185e = 1;
        C0050a c0050a2 = c0050a;
        C0050a c0050a3 = c0050a2;
        C0050a c0050a4 = c0050a3;
        boolean z4 = true;
        while (this.f4185e < 9) {
            C0050a j4 = j(c0050a, z4, 1, -1);
            C0050a j5 = j(c0050a2, z4, 1, 1);
            C0050a j6 = j(c0050a3, z4, -1, 1);
            C0050a j7 = j(c0050a4, z4, -1, -1);
            if (this.f4185e > 2) {
                double c5 = (c(j7, j4) * this.f4185e) / (c(c0050a4, c0050a) * (this.f4185e + 2));
                if (c5 < 0.75d || c5 > 1.25d || !p(j4, j5, j6, j7)) {
                    break;
                }
            }
            z4 = !z4;
            this.f4185e++;
            c0050a4 = j7;
            c0050a = j4;
            c0050a2 = j5;
            c0050a3 = j6;
        }
        int i4 = this.f4185e;
        if (i4 != 5 && i4 != 7) {
            throw m.a();
        }
        this.f4182b = i4 == 5;
        s[] sVarArr = {new s(c0050a.a() + 0.5f, c0050a.b() - 0.5f), new s(c0050a2.a() + 0.5f, c0050a2.b() + 0.5f), new s(c0050a3.a() - 0.5f, c0050a3.b() + 0.5f), new s(c0050a4.a() - 0.5f, c0050a4.b() - 0.5f)};
        int i5 = this.f4185e;
        return d(sVarArr, (i5 * 2) - 3, i5 * 2);
    }

    private int g(C0050a c0050a, C0050a c0050a2) {
        float c5 = c(c0050a, c0050a2);
        float a5 = (c0050a2.a() - c0050a.a()) / c5;
        float b5 = (c0050a2.b() - c0050a.b()) / c5;
        float a6 = c0050a.a();
        float b6 = c0050a.b();
        boolean e4 = this.f4181a.e(c0050a.a(), c0050a.b());
        int ceil = (int) Math.ceil(c5);
        int i4 = 0;
        for (int i5 = 0; i5 < ceil; i5++) {
            a6 += a5;
            b6 += b5;
            if (this.f4181a.e(o1.a.c(a6), o1.a.c(b6)) != e4) {
                i4++;
            }
        }
        float f4 = i4 / c5;
        if (f4 <= 0.1f || f4 >= 0.9f) {
            return (f4 <= 0.1f) == e4 ? 1 : -1;
        }
        return 0;
    }

    private static int h(long j4, boolean z4) {
        int i4;
        int i5;
        if (z4) {
            i4 = 7;
            i5 = 2;
        } else {
            i4 = 10;
            i5 = 4;
        }
        int i6 = i4 - i5;
        int[] iArr = new int[i4];
        for (int i7 = i4 - 1; i7 >= 0; i7--) {
            iArr[i7] = ((int) j4) & 15;
            j4 >>= 4;
        }
        try {
            new c(p1.a.f5415k).a(iArr, i6);
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 = (i8 << 4) + iArr[i9];
            }
            return i8;
        } catch (e unused) {
            throw m.a();
        }
    }

    private int i() {
        if (this.f4182b) {
            return (this.f4183c * 4) + 11;
        }
        int i4 = this.f4183c;
        return i4 <= 4 ? (i4 * 4) + 15 : (i4 * 4) + ((((i4 - 4) / 8) + 1) * 2) + 15;
    }

    private C0050a j(C0050a c0050a, boolean z4, int i4, int i5) {
        int a5 = c0050a.a() + i4;
        int b5 = c0050a.b();
        while (true) {
            b5 += i5;
            if (!n(a5, b5) || this.f4181a.e(a5, b5) != z4) {
                break;
            }
            a5 += i4;
        }
        int i6 = a5 - i4;
        int i7 = b5 - i5;
        while (n(i6, i7) && this.f4181a.e(i6, i7) == z4) {
            i6 += i4;
        }
        int i8 = i6 - i4;
        while (n(i8, i7) && this.f4181a.e(i8, i7) == z4) {
            i7 += i5;
        }
        return new C0050a(i8, i7 - i5);
    }

    private C0050a k() {
        s c5;
        s sVar;
        s sVar2;
        s sVar3;
        s c6;
        s c7;
        s c8;
        s c9;
        try {
            s[] c10 = new o1.b(this.f4181a).c();
            sVar2 = c10[0];
            sVar3 = c10[1];
            sVar = c10[2];
            c5 = c10[3];
        } catch (m unused) {
            int l4 = this.f4181a.l() / 2;
            int h4 = this.f4181a.h() / 2;
            int i4 = l4 + 7;
            int i5 = h4 - 7;
            s c11 = j(new C0050a(i4, i5), false, 1, -1).c();
            int i6 = h4 + 7;
            s c12 = j(new C0050a(i4, i6), false, 1, 1).c();
            int i7 = l4 - 7;
            s c13 = j(new C0050a(i7, i6), false, -1, 1).c();
            c5 = j(new C0050a(i7, i5), false, -1, -1).c();
            sVar = c13;
            sVar2 = c11;
            sVar3 = c12;
        }
        int c14 = o1.a.c((((sVar2.c() + c5.c()) + sVar3.c()) + sVar.c()) / 4.0f);
        int c15 = o1.a.c((((sVar2.d() + c5.d()) + sVar3.d()) + sVar.d()) / 4.0f);
        try {
            s[] c16 = new o1.b(this.f4181a, 15, c14, c15).c();
            c6 = c16[0];
            c7 = c16[1];
            c8 = c16[2];
            c9 = c16[3];
        } catch (m unused2) {
            int i8 = c14 + 7;
            int i9 = c15 - 7;
            c6 = j(new C0050a(i8, i9), false, 1, -1).c();
            int i10 = c15 + 7;
            c7 = j(new C0050a(i8, i10), false, 1, 1).c();
            int i11 = c14 - 7;
            c8 = j(new C0050a(i11, i10), false, -1, 1).c();
            c9 = j(new C0050a(i11, i9), false, -1, -1).c();
        }
        return new C0050a(o1.a.c((((c6.c() + c9.c()) + c7.c()) + c8.c()) / 4.0f), o1.a.c((((c6.d() + c9.d()) + c7.d()) + c8.d()) / 4.0f));
    }

    private s[] l(s[] sVarArr) {
        return d(sVarArr, this.f4185e * 2, i());
    }

    private static int m(int[] iArr, int i4) {
        int i5 = 0;
        for (int i6 : iArr) {
            i5 = (i5 << 3) + ((i6 >> (i4 - 2)) << 1) + (i6 & 1);
        }
        int i7 = ((i5 & 1) << 11) + (i5 >> 1);
        for (int i8 = 0; i8 < 4; i8++) {
            if (Integer.bitCount(f4180g[i8] ^ i7) <= 2) {
                return i8;
            }
        }
        throw m.a();
    }

    private boolean n(int i4, int i5) {
        return i4 >= 0 && i4 < this.f4181a.l() && i5 > 0 && i5 < this.f4181a.h();
    }

    private boolean o(s sVar) {
        return n(o1.a.c(sVar.c()), o1.a.c(sVar.d()));
    }

    private boolean p(C0050a c0050a, C0050a c0050a2, C0050a c0050a3, C0050a c0050a4) {
        C0050a c0050a5 = new C0050a(c0050a.a() - 3, c0050a.b() + 3);
        C0050a c0050a6 = new C0050a(c0050a2.a() - 3, c0050a2.b() - 3);
        C0050a c0050a7 = new C0050a(c0050a3.a() + 3, c0050a3.b() - 3);
        C0050a c0050a8 = new C0050a(c0050a4.a() + 3, c0050a4.b() + 3);
        int g4 = g(c0050a8, c0050a5);
        return g4 != 0 && g(c0050a5, c0050a6) == g4 && g(c0050a6, c0050a7) == g4 && g(c0050a7, c0050a8) == g4;
    }

    private b q(b bVar, s sVar, s sVar2, s sVar3, s sVar4) {
        i b5 = i.b();
        int i4 = i();
        float f4 = i4 / 2.0f;
        int i5 = this.f4185e;
        float f5 = f4 - i5;
        float f6 = f4 + i5;
        return b5.c(bVar, i4, i4, f5, f5, f6, f5, f6, f6, f5, f6, sVar.c(), sVar.d(), sVar2.c(), sVar2.d(), sVar3.c(), sVar3.d(), sVar4.c(), sVar4.d());
    }

    private int r(s sVar, s sVar2, int i4) {
        float b5 = b(sVar, sVar2);
        float f4 = b5 / i4;
        float c5 = sVar.c();
        float d5 = sVar.d();
        float c6 = ((sVar2.c() - sVar.c()) * f4) / b5;
        float d6 = (f4 * (sVar2.d() - sVar.d())) / b5;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            float f5 = i6;
            if (this.f4181a.e(o1.a.c((f5 * c6) + c5), o1.a.c((f5 * d6) + d5))) {
                i5 |= 1 << ((i4 - i6) - 1);
            }
        }
        return i5;
    }

    public h1.a a(boolean z4) {
        s[] f4 = f(k());
        if (z4) {
            s sVar = f4[0];
            f4[0] = f4[2];
            f4[2] = sVar;
        }
        e(f4);
        b bVar = this.f4181a;
        int i4 = this.f4186f;
        return new h1.a(q(bVar, f4[i4 % 4], f4[(i4 + 1) % 4], f4[(i4 + 2) % 4], f4[(i4 + 3) % 4]), l(f4), this.f4182b, this.f4184d, this.f4183c);
    }
}
