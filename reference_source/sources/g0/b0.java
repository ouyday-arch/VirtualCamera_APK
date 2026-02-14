package g0;

import android.annotation.SuppressLint;
import android.view.View;

/* loaded from: classes.dex */
class b0 extends a0 {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f3764f = true;

    @Override // g0.e0
    @SuppressLint({"NewApi"})
    public void d(View view, int i4, int i5, int i6, int i7) {
        if (f3764f) {
            try {
                view.setLeftTopRightBottom(i4, i5, i6, i7);
            } catch (NoSuchMethodError unused) {
                f3764f = false;
            }
        }
    }
}
