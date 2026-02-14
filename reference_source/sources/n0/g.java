package n0;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f5248a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f5249b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f5250c = new Matrix();

    public Matrix a(float f4, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f5248a);
        matrix2.getValues(this.f5249b);
        for (int i4 = 0; i4 < 9; i4++) {
            float[] fArr = this.f5249b;
            float f5 = fArr[i4];
            float[] fArr2 = this.f5248a;
            fArr[i4] = fArr2[i4] + ((f5 - fArr2[i4]) * f4);
        }
        this.f5250c.setValues(this.f5249b);
        return this.f5250c;
    }
}
