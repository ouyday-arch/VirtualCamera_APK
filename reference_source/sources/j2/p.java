package j2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends o {
    private static Intent f(Context context) {
        Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        if (c.c()) {
            intent.setData(a0.l(context));
        }
        return !a0.a(context, intent) ? a0.k(context) : intent;
    }

    private static boolean g(Context context) {
        return a0.c(context, "android:get_usage_stats");
    }

    @Override // j2.o, j2.n, j2.m, j2.l
    public Intent a(Context context, String str) {
        return a0.g(str, "android.permission.PACKAGE_USAGE_STATS") ? f(context) : super.a(context, str);
    }

    @Override // j2.o, j2.n, j2.m, j2.l
    public boolean b(Activity activity, String str) {
        if (a0.g(str, "android.permission.PACKAGE_USAGE_STATS")) {
            return false;
        }
        return super.b(activity, str);
    }

    @Override // j2.o, j2.n, j2.m, j2.l
    public boolean c(Context context, String str) {
        return a0.g(str, "android.permission.PACKAGE_USAGE_STATS") ? g(context) : super.c(context, str);
    }
}
