package j2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
class r extends q {
    private static Intent n(Context context) {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        intent.setData(a0.l(context));
        return !a0.a(context, intent) ? a0.k(context) : intent;
    }

    private static Intent o(Context context) {
        Intent intent = new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS");
        intent.setData(a0.l(context));
        return !a0.a(context, intent) ? a0.k(context) : intent;
    }

    private static boolean p(Context context) {
        return context.getPackageManager().canRequestPackageInstalls();
    }

    private static boolean q(Context context) {
        return a0.c(context, "android:picture_in_picture");
    }

    @Override // j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public Intent a(Context context, String str) {
        return a0.g(str, "android.permission.REQUEST_INSTALL_PACKAGES") ? n(context) : a0.g(str, "android.permission.PICTURE_IN_PICTURE") ? o(context) : super.a(context, str);
    }

    @Override // j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean b(Activity activity, String str) {
        if (a0.g(str, "android.permission.REQUEST_INSTALL_PACKAGES") || a0.g(str, "android.permission.PICTURE_IN_PICTURE")) {
            return false;
        }
        return (a0.g(str, "android.permission.READ_PHONE_NUMBERS") || a0.g(str, "android.permission.ANSWER_PHONE_CALLS")) ? (a0.e(activity, str) || a0.v(activity, str)) ? false : true : super.b(activity, str);
    }

    @Override // j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean c(Context context, String str) {
        return a0.g(str, "android.permission.REQUEST_INSTALL_PACKAGES") ? p(context) : a0.g(str, "android.permission.PICTURE_IN_PICTURE") ? q(context) : (a0.g(str, "android.permission.READ_PHONE_NUMBERS") || a0.g(str, "android.permission.ANSWER_PHONE_CALLS")) ? a0.e(context, str) : super.c(context, str);
    }
}
