package g0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
class c0 extends b0 {

    /* renamed from: g, reason: collision with root package name */
    private static boolean f3791g = true;

    @Override // g0.e0
    @SuppressLint({"NewApi"})
    public void f(View view, int i4) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i4);
        } else if (f3791g) {
            try {
                view.setTransitionVisibility(i4);
            } catch (NoSuchMethodError unused) {
                f3791g = false;
            }
        }
    }
}
