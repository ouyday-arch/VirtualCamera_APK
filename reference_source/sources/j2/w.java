package j2;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes.dex */
class w extends v {
    @Override // j2.v, j2.u, j2.t, j2.s, j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean b(Activity activity, String str) {
        if (a0.g(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
            return !a0.e(activity, "android.permission.BODY_SENSORS") ? !a0.v(activity, "android.permission.BODY_SENSORS") : (a0.e(activity, str) || a0.v(activity, str)) ? false : true;
        }
        if (a0.g(str, "android.permission.POST_NOTIFICATIONS") || a0.g(str, "android.permission.NEARBY_WIFI_DEVICES") || a0.g(str, "android.permission.READ_MEDIA_IMAGES") || a0.g(str, "android.permission.READ_MEDIA_VIDEO") || a0.g(str, "android.permission.READ_MEDIA_AUDIO")) {
            return (a0.e(activity, str) || a0.v(activity, str)) ? false : true;
        }
        if (c.b(activity) >= 33) {
            if (a0.g(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return false;
            }
            if (a0.g(str, "android.permission.READ_EXTERNAL_STORAGE")) {
                return (a0.e(activity, "android.permission.READ_MEDIA_IMAGES") || a0.v(activity, "android.permission.READ_MEDIA_IMAGES") || a0.e(activity, "android.permission.READ_MEDIA_VIDEO") || a0.v(activity, "android.permission.READ_MEDIA_VIDEO") || a0.e(activity, "android.permission.READ_MEDIA_AUDIO") || a0.v(activity, "android.permission.READ_MEDIA_AUDIO")) ? false : true;
            }
        }
        return super.b(activity, str);
    }

    @Override // j2.v, j2.u, j2.t, j2.s, j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean c(Context context, String str) {
        if (a0.g(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
            return a0.e(context, "android.permission.BODY_SENSORS") && a0.e(context, "android.permission.BODY_SENSORS_BACKGROUND");
        }
        if (a0.g(str, "android.permission.POST_NOTIFICATIONS") || a0.g(str, "android.permission.NEARBY_WIFI_DEVICES") || a0.g(str, "android.permission.READ_MEDIA_IMAGES") || a0.g(str, "android.permission.READ_MEDIA_VIDEO") || a0.g(str, "android.permission.READ_MEDIA_AUDIO")) {
            return a0.e(context, str);
        }
        if (c.b(context) >= 33) {
            if (a0.g(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return true;
            }
            if (a0.g(str, "android.permission.READ_EXTERNAL_STORAGE")) {
                return a0.e(context, "android.permission.READ_MEDIA_IMAGES") && a0.e(context, "android.permission.READ_MEDIA_VIDEO") && a0.e(context, "android.permission.READ_MEDIA_AUDIO");
            }
        }
        return super.c(context, str);
    }
}
