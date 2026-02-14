package g0;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
class a0 extends z {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f3762d = true;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f3763e = true;

    @Override // g0.e0
    @SuppressLint({"NewApi"})
    public void g(View view, Matrix matrix) {
        if (f3762d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f3762d = false;
            }
        }
    }

    @Override // g0.e0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (f3763e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f3763e = false;
            }
        }
    }
}
