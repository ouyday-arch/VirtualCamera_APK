package n1;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final float f5312a;

    /* renamed from: b, reason: collision with root package name */
    private final float f5313b;

    /* renamed from: c, reason: collision with root package name */
    private final float f5314c;

    /* renamed from: d, reason: collision with root package name */
    private final float f5315d;

    /* renamed from: e, reason: collision with root package name */
    private final float f5316e;

    /* renamed from: f, reason: collision with root package name */
    private final float f5317f;

    /* renamed from: g, reason: collision with root package name */
    private final float f5318g;

    /* renamed from: h, reason: collision with root package name */
    private final float f5319h;

    /* renamed from: i, reason: collision with root package name */
    private final float f5320i;

    private k(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        this.f5312a = f4;
        this.f5313b = f7;
        this.f5314c = f10;
        this.f5315d = f5;
        this.f5316e = f8;
        this.f5317f = f11;
        this.f5318g = f6;
        this.f5319h = f9;
        this.f5320i = f12;
    }

    public static k b(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        return d(f12, f13, f14, f15, f16, f17, f18, f19).e(c(f4, f5, f6, f7, f8, f9, f10, f11));
    }

    public static k c(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        return d(f4, f5, f6, f7, f8, f9, f10, f11).a();
    }

    public static k d(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        float f12 = ((f4 - f6) + f8) - f10;
        float f13 = ((f5 - f7) + f9) - f11;
        if (f12 == 0.0f && f13 == 0.0f) {
            return new k(f6 - f4, f8 - f6, f4, f7 - f5, f9 - f7, f5, 0.0f, 0.0f, 1.0f);
        }
        float f14 = f6 - f8;
        float f15 = f10 - f8;
        float f16 = f7 - f9;
        float f17 = f11 - f9;
        float f18 = (f14 * f17) - (f15 * f16);
        float f19 = ((f17 * f12) - (f15 * f13)) / f18;
        float f20 = ((f14 * f13) - (f12 * f16)) / f18;
        return new k((f19 * f6) + (f6 - f4), (f20 * f10) + (f10 - f4), f4, (f7 - f5) + (f19 * f7), (f11 - f5) + (f20 * f11), f5, f19, f20, 1.0f);
    }

    k a() {
        float f4 = this.f5316e;
        float f5 = this.f5320i;
        float f6 = this.f5317f;
        float f7 = this.f5319h;
        float f8 = (f4 * f5) - (f6 * f7);
        float f9 = this.f5318g;
        float f10 = this.f5315d;
        float f11 = (f6 * f9) - (f10 * f5);
        float f12 = (f10 * f7) - (f4 * f9);
        float f13 = this.f5314c;
        float f14 = this.f5313b;
        float f15 = (f13 * f7) - (f14 * f5);
        float f16 = this.f5312a;
        return new k(f8, f11, f12, f15, (f5 * f16) - (f13 * f9), (f9 * f14) - (f7 * f16), (f14 * f6) - (f13 * f4), (f13 * f10) - (f6 * f16), (f16 * f4) - (f14 * f10));
    }

    k e(k kVar) {
        float f4 = this.f5312a;
        float f5 = kVar.f5312a;
        float f6 = this.f5315d;
        float f7 = kVar.f5313b;
        float f8 = this.f5318g;
        float f9 = kVar.f5314c;
        float f10 = (f4 * f5) + (f6 * f7) + (f8 * f9);
        float f11 = kVar.f5315d;
        float f12 = kVar.f5316e;
        float f13 = kVar.f5317f;
        float f14 = (f4 * f11) + (f6 * f12) + (f8 * f13);
        float f15 = kVar.f5318g;
        float f16 = kVar.f5319h;
        float f17 = kVar.f5320i;
        float f18 = (f4 * f15) + (f6 * f16) + (f8 * f17);
        float f19 = this.f5313b;
        float f20 = this.f5316e;
        float f21 = this.f5319h;
        float f22 = (f19 * f5) + (f20 * f7) + (f21 * f9);
        float f23 = (f19 * f11) + (f20 * f12) + (f21 * f13);
        float f24 = (f21 * f17) + (f19 * f15) + (f20 * f16);
        float f25 = this.f5314c;
        float f26 = this.f5317f;
        float f27 = (f5 * f25) + (f7 * f26);
        float f28 = this.f5320i;
        return new k(f10, f14, f18, f22, f23, f24, (f9 * f28) + f27, (f11 * f25) + (f12 * f26) + (f13 * f28), (f25 * f15) + (f26 * f16) + (f28 * f17));
    }

    public void f(float[] fArr) {
        float f4 = this.f5312a;
        float f5 = this.f5313b;
        float f6 = this.f5314c;
        float f7 = this.f5315d;
        float f8 = this.f5316e;
        float f9 = this.f5317f;
        float f10 = this.f5318g;
        float f11 = this.f5319h;
        float f12 = this.f5320i;
        int length = fArr.length - 1;
        for (int i4 = 0; i4 < length; i4 += 2) {
            float f13 = fArr[i4];
            int i5 = i4 + 1;
            float f14 = fArr[i5];
            float f15 = (f6 * f13) + (f9 * f14) + f12;
            fArr[i4] = (((f4 * f13) + (f7 * f14)) + f10) / f15;
            fArr[i5] = (((f13 * f5) + (f14 * f8)) + f11) / f15;
        }
    }
}
