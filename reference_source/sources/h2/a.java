package h2;

import g1.s;

/* loaded from: classes.dex */
public final class a extends s {

    /* renamed from: c, reason: collision with root package name */
    private final float f4077c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(float f4, float f5, float f6) {
        super(f4, f5);
        this.f4077c = f6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(float f4, float f5, float f6) {
        if (Math.abs(f5 - d()) > f4 || Math.abs(f6 - c()) > f4) {
            return false;
        }
        float abs = Math.abs(f4 - this.f4077c);
        return abs <= 1.0f || abs <= this.f4077c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a g(float f4, float f5, float f6) {
        return new a((c() + f5) / 2.0f, (d() + f4) / 2.0f, (this.f4077c + f6) / 2.0f);
    }
}
