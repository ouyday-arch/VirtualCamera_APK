package g0;

import android.annotation.SuppressLint;
import android.view.View;

/* loaded from: classes.dex */
class z extends e0 {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f3893c = true;

    @Override // g0.e0
    public void a(View view) {
    }

    @Override // g0.e0
    @SuppressLint({"NewApi"})
    public float b(View view) {
        if (f3893c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f3893c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // g0.e0
    public void c(View view) {
    }

    @Override // g0.e0
    @SuppressLint({"NewApi"})
    public void e(View view, float f4) {
        if (f3893c) {
            try {
                view.setTransitionAlpha(f4);
                return;
            } catch (NoSuchMethodError unused) {
                f3893c = false;
            }
        }
        view.setAlpha(f4);
    }
}
