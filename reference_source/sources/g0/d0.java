package g0;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
class d0 extends c0 {
    @Override // g0.z, g0.e0
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // g0.b0, g0.e0
    public void d(View view, int i4, int i5, int i6, int i7) {
        view.setLeftTopRightBottom(i4, i5, i6, i7);
    }

    @Override // g0.z, g0.e0
    public void e(View view, float f4) {
        view.setTransitionAlpha(f4);
    }

    @Override // g0.c0, g0.e0
    public void f(View view, int i4) {
        view.setTransitionVisibility(i4);
    }

    @Override // g0.a0, g0.e0
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // g0.a0, g0.e0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
