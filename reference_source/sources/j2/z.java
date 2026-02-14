package j2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
final class z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context) {
        Intent intent = new Intent("com.oppo.safe.permission.PermissionTopActivity");
        Intent h4 = h(context);
        if (!a0.a(context, intent)) {
            intent = null;
        }
        return a0.a(context, h4) ? c0.a(intent, h4) : intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        Intent intent2 = new Intent();
        intent2.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        Intent c5 = c(context);
        String d5 = b0.d();
        if (d5 == null) {
            d5 = "";
        }
        if (d5.startsWith("3.0")) {
            if (!a0.a(context, intent2)) {
                intent2 = null;
            }
            if (a0.a(context, intent)) {
                intent2 = c0.a(intent2, intent);
            }
        } else {
            if (!a0.a(context, intent)) {
                intent = null;
            }
            intent2 = a0.a(context, intent2) ? c0.a(intent, intent2) : intent;
        }
        return a0.a(context, c5) ? c0.a(intent2, c5) : intent2;
    }

    static Intent c(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.huawei.systemmanager");
        if (a0.a(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent d(Context context) {
        Intent putExtra = new Intent().setAction("miui.intent.action.APP_PERM_EDITOR").putExtra("extra_pkgname", context.getPackageName());
        Intent k4 = k(context);
        if (!a0.a(context, putExtra)) {
            putExtra = null;
        }
        return a0.a(context, k4) ? c0.a(putExtra, k4) : putExtra;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent e(Context context) {
        return d(context);
    }

    static Intent f(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$AppOpsDetailsActivity");
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        intent.putExtra(":settings:show_fragment_args", bundle);
        intent.setData(a0.l(context));
        if (a0.a(context, intent)) {
            return intent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent g(Context context) {
        return f(context);
    }

    static Intent h(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.oppo.safe");
        if (a0.a(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        Intent launchIntentForPackage2 = context.getPackageManager().getLaunchIntentForPackage("com.color.safecenter");
        if (a0.a(context, launchIntentForPackage2)) {
            return launchIntentForPackage2;
        }
        Intent launchIntentForPackage3 = context.getPackageManager().getLaunchIntentForPackage("com.oplus.safecenter");
        if (a0.a(context, launchIntentForPackage3)) {
            return launchIntentForPackage3;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent i(Context context) {
        Intent j4 = j(context);
        if (a0.a(context, j4)) {
            return j4;
        }
        return null;
    }

    static Intent j(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.iqoo.secure");
        if (a0.a(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    static Intent k(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.miui.securitycenter");
        if (a0.a(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }
}
