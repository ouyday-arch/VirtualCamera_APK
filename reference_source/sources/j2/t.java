package j2;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends s {
    private boolean r(Context context) {
        return (!c.f() || c.b(context) < 33) ? (!c.d() || c.b(context) < 30) ? a0.e(context, "android.permission.READ_EXTERNAL_STORAGE") : a0.e(context, "android.permission.READ_EXTERNAL_STORAGE") || c(context, "android.permission.MANAGE_EXTERNAL_STORAGE") : a0.e(context, "android.permission.READ_MEDIA_IMAGES") || c(context, "android.permission.MANAGE_EXTERNAL_STORAGE");
    }

    private static boolean s() {
        return Environment.isExternalStorageLegacy();
    }

    @Override // j2.s, j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean b(Activity activity, String str) {
        if (a0.g(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return !a0.e(activity, "android.permission.ACCESS_FINE_LOCATION") ? !a0.v(activity, "android.permission.ACCESS_FINE_LOCATION") : (a0.e(activity, str) || a0.v(activity, str)) ? false : true;
        }
        if (a0.g(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
            return (!r(activity) || a0.e(activity, str) || a0.v(activity, str)) ? false : true;
        }
        if (a0.g(str, "android.permission.ACTIVITY_RECOGNITION")) {
            return (a0.e(activity, str) || a0.v(activity, str)) ? false : true;
        }
        if (c.d() || !a0.g(str, "android.permission.MANAGE_EXTERNAL_STORAGE") || s()) {
            return super.b(activity, str);
        }
        return true;
    }

    @Override // j2.s, j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean c(Context context, String str) {
        if (a0.g(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
            return r(context) && a0.e(context, "android.permission.ACCESS_MEDIA_LOCATION");
        }
        if (a0.g(str, "android.permission.ACCESS_BACKGROUND_LOCATION") || a0.g(str, "android.permission.ACTIVITY_RECOGNITION")) {
            return a0.e(context, str);
        }
        if (c.d() || !a0.g(str, "android.permission.MANAGE_EXTERNAL_STORAGE") || s()) {
            return super.c(context, str);
        }
        return false;
    }
}
