package g0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class v {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3888a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u a(ViewGroup viewGroup) {
        return new t(viewGroup);
    }

    @SuppressLint({"NewApi"})
    private static void b(ViewGroup viewGroup, boolean z4) {
        if (f3888a) {
            try {
                viewGroup.suppressLayout(z4);
            } catch (NoSuchMethodError unused) {
                f3888a = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ViewGroup viewGroup, boolean z4) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z4);
        } else {
            b(viewGroup, z4);
        }
    }
}
