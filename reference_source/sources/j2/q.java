package j2;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.provider.Settings;

/* loaded from: classes.dex */
class q extends p {
    private static Intent h(Context context) {
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(a0.l(context));
        if (!a0.a(context, intent)) {
            intent = new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        }
        return !a0.a(context, intent) ? a0.k(context) : intent;
    }

    private static Intent i(Context context) {
        Intent intent;
        if (!c.c() || b0.k()) {
            intent = null;
        } else {
            intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_DETAIL_SETTINGS");
            intent.setData(a0.l(context));
        }
        if (!a0.a(context, intent)) {
            intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
        }
        return !a0.a(context, intent) ? a0.k(context) : intent;
    }

    private static Intent j(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(a0.l(context));
        return !a0.a(context, intent) ? a0.k(context) : intent;
    }

    private static boolean k(Context context) {
        return ((PowerManager) context.getSystemService(PowerManager.class)).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    private static boolean l(Context context) {
        return ((NotificationManager) context.getSystemService(NotificationManager.class)).isNotificationPolicyAccessGranted();
    }

    private static boolean m(Context context) {
        if (c.l()) {
            return Settings.System.canWrite(context);
        }
        return true;
    }

    @Override // j2.p, j2.o, j2.n, j2.m, j2.l
    public Intent a(Context context, String str) {
        return a0.g(str, "android.permission.WRITE_SETTINGS") ? j(context) : a0.g(str, "android.permission.ACCESS_NOTIFICATION_POLICY") ? i(context) : a0.g(str, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") ? h(context) : super.a(context, str);
    }

    @Override // j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean b(Activity activity, String str) {
        if (!c.f()) {
            if (a0.g(str, "android.permission.POST_NOTIFICATIONS")) {
                return super.b(activity, str);
            }
            if (a0.g(str, "android.permission.NEARBY_WIFI_DEVICES")) {
                return (a0.e(activity, "android.permission.ACCESS_FINE_LOCATION") || a0.v(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
            }
            if (a0.g(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
                return (a0.e(activity, "android.permission.BODY_SENSORS") || a0.v(activity, "android.permission.BODY_SENSORS")) ? false : true;
            }
            if (a0.g(str, "android.permission.READ_MEDIA_IMAGES") || a0.g(str, "android.permission.READ_MEDIA_VIDEO") || a0.g(str, "android.permission.READ_MEDIA_AUDIO")) {
                return (a0.e(activity, "android.permission.READ_EXTERNAL_STORAGE") || a0.v(activity, "android.permission.READ_EXTERNAL_STORAGE")) ? false : true;
            }
        }
        if (!c.e()) {
            if (a0.g(str, "android.permission.BLUETOOTH_SCAN")) {
                return (a0.e(activity, "android.permission.ACCESS_FINE_LOCATION") || a0.v(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
            }
            if (a0.g(str, "android.permission.BLUETOOTH_CONNECT") || a0.g(str, "android.permission.BLUETOOTH_ADVERTISE")) {
                return false;
            }
        }
        if (!c.c()) {
            if (a0.g(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                return (a0.e(activity, "android.permission.ACCESS_FINE_LOCATION") || a0.v(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
            }
            if (a0.g(str, "android.permission.ACTIVITY_RECOGNITION")) {
                return false;
            }
            if (a0.g(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
                return (a0.e(activity, "android.permission.READ_EXTERNAL_STORAGE") || a0.v(activity, "android.permission.READ_EXTERNAL_STORAGE")) ? false : true;
            }
        }
        if (!c.o() && a0.g(str, "android.permission.ACCEPT_HANDOVER")) {
            return false;
        }
        if (!c.n()) {
            if (a0.g(str, "android.permission.ANSWER_PHONE_CALLS")) {
                return false;
            }
            if (a0.g(str, "android.permission.READ_PHONE_NUMBERS")) {
                return (a0.e(activity, "android.permission.READ_PHONE_STATE") || a0.v(activity, "android.permission.READ_PHONE_STATE")) ? false : true;
            }
        }
        if (a0.g(str, "com.android.permission.GET_INSTALLED_APPS") || a0.g(str, "android.permission.POST_NOTIFICATIONS")) {
            return super.b(activity, str);
        }
        if (a0.q(str)) {
            return false;
        }
        return (a0.e(activity, str) || a0.v(activity, str)) ? false : true;
    }

    @Override // j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean c(Context context, String str) {
        String str2;
        if (!c.f()) {
            if (a0.g(str, "android.permission.POST_NOTIFICATIONS")) {
                return super.c(context, str);
            }
            if (a0.g(str, "android.permission.NEARBY_WIFI_DEVICES")) {
                return a0.e(context, "android.permission.ACCESS_FINE_LOCATION");
            }
            if (a0.g(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
                str2 = "android.permission.BODY_SENSORS";
                return a0.e(context, str2);
            }
            if (a0.g(str, "android.permission.READ_MEDIA_IMAGES") || a0.g(str, "android.permission.READ_MEDIA_VIDEO") || a0.g(str, "android.permission.READ_MEDIA_AUDIO")) {
                return a0.e(context, "android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        if (!c.e()) {
            if (a0.g(str, "android.permission.BLUETOOTH_SCAN")) {
                return a0.e(context, "android.permission.ACCESS_FINE_LOCATION");
            }
            if (a0.g(str, "android.permission.BLUETOOTH_CONNECT") || a0.g(str, "android.permission.BLUETOOTH_ADVERTISE")) {
                return true;
            }
        }
        if (!c.d() && a0.g(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
            return a0.e(context, "android.permission.READ_EXTERNAL_STORAGE") && a0.e(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!c.c()) {
            if (a0.g(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                return a0.e(context, "android.permission.ACCESS_FINE_LOCATION");
            }
            if (a0.g(str, "android.permission.ACTIVITY_RECOGNITION")) {
                return true;
            }
            if (a0.g(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
                return a0.e(context, "android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        if (!c.o() && a0.g(str, "android.permission.ACCEPT_HANDOVER")) {
            return true;
        }
        if (!c.n()) {
            if (a0.g(str, "android.permission.ANSWER_PHONE_CALLS")) {
                return true;
            }
            if (a0.g(str, "android.permission.READ_PHONE_NUMBERS")) {
                str2 = "android.permission.READ_PHONE_STATE";
                return a0.e(context, str2);
            }
        }
        return (a0.g(str, "com.android.permission.GET_INSTALLED_APPS") || a0.g(str, "android.permission.POST_NOTIFICATIONS")) ? super.c(context, str) : a0.q(str) ? a0.g(str, "android.permission.WRITE_SETTINGS") ? m(context) : a0.g(str, "android.permission.ACCESS_NOTIFICATION_POLICY") ? l(context) : a0.g(str, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") ? k(context) : super.c(context, str) : a0.e(context, str);
    }
}
