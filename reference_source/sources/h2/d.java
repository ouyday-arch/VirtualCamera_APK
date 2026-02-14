package h2;

import g1.s;

/* loaded from: classes.dex */
public final class d extends s {

    /* renamed from: c, reason: collision with root package name */
    private final float f4089c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4090d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(float f4, float f5, float f6) {
        this(f4, f5, f6, 1);
    }

    private d(float f4, float f5, float f6, int i4) {
        super(f4, f5);
        this.f4089c = f6;
        this.f4090d = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(float f4, float f5, float f6) {
        if (Math.abs(f5 - d()) > f4 || Math.abs(f6 - c()) > f4) {
            return false;
        }
        float abs = Math.abs(f4 - this.f4089c);
        return abs <= 1.0f || abs <= this.f4089c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d g(float f4, float f5, float f6) {
        int i4 = this.f4090d;
        int i5 = i4 + 1;
        float c5 = (i4 * c()) + f5;
        float f7 = i5;
        return new d(c5 / f7, ((this.f4090d * d()) + f4) / f7, ((this.f4090d * this.f4089c) + f6) / f7, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f4090d;
    }

    public float i() {
        return this.f4089c;
    }
}
