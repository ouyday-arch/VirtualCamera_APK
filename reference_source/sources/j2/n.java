package j2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends m {
    @Override // j2.m, j2.l
    public Intent a(Context context, String str) {
        return a0.g(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") ? f.a(context) : super.a(context, str);
    }

    @Override // j2.m, j2.l
    public boolean b(Activity activity, String str) {
        if (a0.g(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE")) {
            return false;
        }
        return super.b(activity, str);
    }

    @Override // j2.m, j2.l
    public boolean c(Context context, String str) {
        return a0.g(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") ? f.b(context) : super.c(context, str);
    }
}
