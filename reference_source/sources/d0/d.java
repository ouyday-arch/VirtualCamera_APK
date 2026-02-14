package d0;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f3578a;

    /* renamed from: b, reason: collision with root package name */
    private final float f3579b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(float[] fArr) {
        this.f3578a = fArr;
        this.f3579b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f3578a;
        int min = Math.min((int) ((fArr.length - 1) * f4), fArr.length - 2);
        float f5 = this.f3579b;
        float f6 = (f4 - (min * f5)) / f5;
        float[] fArr2 = this.f3578a;
        return fArr2[min] + (f6 * (fArr2[min + 1] - fArr2[min]));
    }
}
