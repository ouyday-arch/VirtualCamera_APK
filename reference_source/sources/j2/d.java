package j2;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.provider.Settings;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context) {
        if (b0.l()) {
            return c0.a(b0.m() ? z.d(context) : null, a0.k(context));
        }
        return a0.k(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context) {
        if (!c.i()) {
            return true;
        }
        if (c.l() && e(context)) {
            return a0.e(context, "com.android.permission.GET_INSTALLED_APPS");
        }
        if (b0.l() && c() && b0.m()) {
            return a0.d(context, "OP_GET_INSTALLED_APPS", 10022);
        }
        return true;
    }

    private static boolean c() {
        if (!c.i()) {
            return true;
        }
        try {
            Class.forName(AppOpsManager.class.getName()).getDeclaredField("OP_GET_INSTALLED_APPS");
            return true;
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return true;
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Activity activity) {
        if (!c.i()) {
            return false;
        }
        if (c.l() && e(activity)) {
            return (a0.e(activity, "com.android.permission.GET_INSTALLED_APPS") || a0.v(activity, "com.android.permission.GET_INSTALLED_APPS")) ? false : true;
        }
        if (b0.l() && c() && b0.m()) {
            return !b(activity);
        }
        return false;
    }

    private static boolean e(Context context) {
        try {
            PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo("com.android.permission.GET_INSTALLED_APPS", 0);
            if (permissionInfo != null) {
                return c.o() ? permissionInfo.getProtection() == 1 : (permissionInfo.protectionLevel & 15) == 1;
            }
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "oem_installed_apps_runtime_permission_enable") == 1;
        } catch (Settings.SettingNotFoundException e5) {
            e5.printStackTrace();
            return false;
        }
    }
}
