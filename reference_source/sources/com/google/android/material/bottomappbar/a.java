package com.google.android.material.bottomappbar;

import b1.f;
import b1.m;

/* loaded from: classes.dex */
public class a extends f implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    private float f2782b;

    /* renamed from: c, reason: collision with root package name */
    private float f2783c;

    /* renamed from: d, reason: collision with root package name */
    private float f2784d;

    /* renamed from: e, reason: collision with root package name */
    private float f2785e;

    /* renamed from: f, reason: collision with root package name */
    private float f2786f;

    @Override // b1.f
    public void b(float f4, float f5, float f6, m mVar) {
        float f7 = this.f2784d;
        if (f7 == 0.0f) {
            mVar.m(f4, 0.0f);
            return;
        }
        float f8 = ((this.f2783c * 2.0f) + f7) / 2.0f;
        float f9 = f6 * this.f2782b;
        float f10 = f5 + this.f2786f;
        float f11 = (this.f2785e * f6) + ((1.0f - f6) * f8);
        if (f11 / f8 >= 1.0f) {
            mVar.m(f4, 0.0f);
            return;
        }
        float f12 = f8 + f9;
        float f13 = f11 + f9;
        float sqrt = (float) Math.sqrt((f12 * f12) - (f13 * f13));
        float f14 = f10 - sqrt;
        float f15 = f10 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f13));
        float f16 = 90.0f - degrees;
        mVar.m(f14, 0.0f);
        float f17 = f9 * 2.0f;
        mVar.a(f14 - f9, 0.0f, f14 + f9, f17, 270.0f, degrees);
        mVar.a(f10 - f8, (-f8) - f11, f10 + f8, f8 - f11, 180.0f - f16, (f16 * 2.0f) - 180.0f);
        mVar.a(f15 - f9, 0.0f, f15 + f9, f17, 270.0f - degrees, degrees);
        mVar.m(f4, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f2785e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f2783c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f2782b;
    }

    public float f() {
        return this.f2784d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f4) {
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f2785e = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f4) {
        this.f2783c = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(float f4) {
        this.f2782b = f4;
    }

    public void k(float f4) {
        this.f2784d = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f4) {
        this.f2786f = f4;
    }
}
