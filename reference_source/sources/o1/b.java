package o1;

import g1.m;
import g1.s;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final n1.b f5348a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5349b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5350c;

    /* renamed from: d, reason: collision with root package name */
    private final int f5351d;

    /* renamed from: e, reason: collision with root package name */
    private final int f5352e;

    /* renamed from: f, reason: collision with root package name */
    private final int f5353f;

    /* renamed from: g, reason: collision with root package name */
    private final int f5354g;

    public b(n1.b bVar) {
        this(bVar, 10, bVar.l() / 2, bVar.h() / 2);
    }

    public b(n1.b bVar, int i4, int i5, int i6) {
        this.f5348a = bVar;
        int h4 = bVar.h();
        this.f5349b = h4;
        int l4 = bVar.l();
        this.f5350c = l4;
        int i7 = i4 / 2;
        int i8 = i5 - i7;
        this.f5351d = i8;
        int i9 = i5 + i7;
        this.f5352e = i9;
        int i10 = i6 - i7;
        this.f5354g = i10;
        int i11 = i6 + i7;
        this.f5353f = i11;
        if (i10 < 0 || i8 < 0 || i11 >= h4 || i9 >= l4) {
            throw m.a();
        }
    }

    private s[] a(s sVar, s sVar2, s sVar3, s sVar4) {
        float c5 = sVar.c();
        float d5 = sVar.d();
        float c6 = sVar2.c();
        float d6 = sVar2.d();
        float c7 = sVar3.c();
        float d7 = sVar3.d();
        float c8 = sVar4.c();
        float d8 = sVar4.d();
        return c5 < ((float) this.f5350c) / 2.0f ? new s[]{new s(c8 - 1.0f, d8 + 1.0f), new s(c6 + 1.0f, d6 + 1.0f), new s(c7 - 1.0f, d7 - 1.0f), new s(c5 + 1.0f, d5 - 1.0f)} : new s[]{new s(c8 + 1.0f, d8 + 1.0f), new s(c6 + 1.0f, d6 - 1.0f), new s(c7 - 1.0f, d7 + 1.0f), new s(c5 - 1.0f, d5 - 1.0f)};
    }

    private boolean b(int i4, int i5, int i6, boolean z4) {
        if (z4) {
            while (i4 <= i5) {
                if (this.f5348a.e(i4, i6)) {
                    return true;
                }
                i4++;
            }
            return false;
        }
        while (i4 <= i5) {
            if (this.f5348a.e(i6, i4)) {
                return true;
            }
            i4++;
        }
        return false;
    }

    private s d(float f4, float f5, float f6, float f7) {
        int c5 = a.c(a.a(f4, f5, f6, f7));
        float f8 = c5;
        float f9 = (f6 - f4) / f8;
        float f10 = (f7 - f5) / f8;
        for (int i4 = 0; i4 < c5; i4++) {
            float f11 = i4;
            int c6 = a.c((f11 * f9) + f4);
            int c7 = a.c((f11 * f10) + f5);
            if (this.f5348a.e(c6, c7)) {
                return new s(c6, c7);
            }
        }
        return null;
    }

    public s[] c() {
        int i4 = this.f5351d;
        int i5 = this.f5352e;
        int i6 = this.f5354g;
        int i7 = this.f5353f;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = true;
        while (z9) {
            boolean z10 = false;
            boolean z11 = true;
            while (true) {
                if ((z11 || !z5) && i5 < this.f5350c) {
                    z11 = b(i6, i7, i5, false);
                    if (z11) {
                        i5++;
                        z5 = true;
                        z10 = true;
                    } else if (!z5) {
                        i5++;
                    }
                }
            }
            if (i5 < this.f5350c) {
                boolean z12 = true;
                while (true) {
                    if ((z12 || !z6) && i7 < this.f5349b) {
                        z12 = b(i4, i5, i7, true);
                        if (z12) {
                            i7++;
                            z6 = true;
                            z10 = true;
                        } else if (!z6) {
                            i7++;
                        }
                    }
                }
                if (i7 < this.f5349b) {
                    boolean z13 = true;
                    while (true) {
                        if ((z13 || !z7) && i4 >= 0) {
                            z13 = b(i6, i7, i4, false);
                            if (z13) {
                                i4--;
                                z7 = true;
                                z10 = true;
                            } else if (!z7) {
                                i4--;
                            }
                        }
                    }
                    if (i4 >= 0) {
                        z9 = z10;
                        boolean z14 = true;
                        while (true) {
                            if ((z14 || !z8) && i6 >= 0) {
                                z14 = b(i4, i5, i6, true);
                                if (z14) {
                                    i6--;
                                    z9 = true;
                                    z8 = true;
                                } else if (!z8) {
                                    i6--;
                                }
                            }
                        }
                        if (i6 < 0) {
                        }
                    }
                }
            }
            z4 = true;
            break;
        }
        if (z4) {
            throw m.a();
        }
        int i8 = i5 - i4;
        s sVar = null;
        s sVar2 = null;
        for (int i9 = 1; sVar2 == null && i9 < i8; i9++) {
            sVar2 = d(i4, i7 - i9, i4 + i9, i7);
        }
        if (sVar2 == null) {
            throw m.a();
        }
        s sVar3 = null;
        for (int i10 = 1; sVar3 == null && i10 < i8; i10++) {
            sVar3 = d(i4, i6 + i10, i4 + i10, i6);
        }
        if (sVar3 == null) {
            throw m.a();
        }
        s sVar4 = null;
        for (int i11 = 1; sVar4 == null && i11 < i8; i11++) {
            sVar4 = d(i5, i6 + i11, i5 - i11, i6);
        }
        if (sVar4 == null) {
            throw m.a();
        }
        for (int i12 = 1; sVar == null && i12 < i8; i12++) {
            sVar = d(i5, i7 - i12, i5 - i12, i7);
        }
        if (sVar != null) {
            return a(sVar, sVar2, sVar4, sVar3);
        }
        throw m.a();
    }
}
