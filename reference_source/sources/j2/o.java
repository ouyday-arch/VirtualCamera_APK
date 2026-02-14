package j2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends n {
    @Override // j2.n, j2.m, j2.l
    public Intent a(Context context, String str) {
        return a0.g(str, "android.permission.SYSTEM_ALERT_WINDOW") ? d0.a(context) : a0.g(str, "com.android.permission.GET_INSTALLED_APPS") ? d.a(context) : a0.g(str, "android.permission.NOTIFICATION_SERVICE") ? g.a(context) : (c.f() || !a0.g(str, "android.permission.POST_NOTIFICATIONS")) ? super.a(context, str) : g.a(context);
    }

    @Override // j2.n, j2.m, j2.l
    public boolean b(Activity activity, String str) {
        if (a0.g(str, "android.permission.SYSTEM_ALERT_WINDOW")) {
            return false;
        }
        if (a0.g(str, "com.android.permission.GET_INSTALLED_APPS")) {
            return d.d(activity);
        }
        if (a0.g(str, "android.permission.NOTIFICATION_SERVICE")) {
            return false;
        }
        if (c.f() || !a0.g(str, "android.permission.POST_NOTIFICATIONS")) {
            return super.b(activity, str);
        }
        return false;
    }

    @Override // j2.n, j2.m, j2.l
    public boolean c(Context context, String str) {
        return a0.g(str, "android.permission.SYSTEM_ALERT_WINDOW") ? d0.b(context) : a0.g(str, "com.android.permission.GET_INSTALLED_APPS") ? d.b(context) : a0.g(str, "android.permission.NOTIFICATION_SERVICE") ? g.b(context) : (c.f() || !a0.g(str, "android.permission.POST_NOTIFICATIONS")) ? super.c(context, str) : g.b(context);
    }
}
