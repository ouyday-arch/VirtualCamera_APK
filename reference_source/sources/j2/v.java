package j2;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
class v extends u {
    private static Intent v(Context context) {
        Intent intent = new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
        intent.setData(a0.l(context));
        return !a0.a(context, intent) ? a0.k(context) : intent;
    }

    private static boolean w(Context context) {
        return ((AlarmManager) context.getSystemService(AlarmManager.class)).canScheduleExactAlarms();
    }

    @Override // j2.u, j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public Intent a(Context context, String str) {
        return a0.g(str, "android.permission.SCHEDULE_EXACT_ALARM") ? v(context) : super.a(context, str);
    }

    @Override // j2.u, j2.t, j2.s, j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean b(Activity activity, String str) {
        if (a0.g(str, "android.permission.SCHEDULE_EXACT_ALARM")) {
            return false;
        }
        return (a0.g(str, "android.permission.BLUETOOTH_SCAN") || a0.g(str, "android.permission.BLUETOOTH_CONNECT") || a0.g(str, "android.permission.BLUETOOTH_ADVERTISE")) ? (a0.e(activity, str) || a0.v(activity, str)) ? false : true : (activity.getApplicationInfo().targetSdkVersion < 31 || !a0.g(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) ? super.b(activity, str) : (a0.e(activity, "android.permission.ACCESS_FINE_LOCATION") || a0.e(activity, "android.permission.ACCESS_COARSE_LOCATION")) ? (a0.e(activity, str) || a0.v(activity, str)) ? false : true : (a0.v(activity, "android.permission.ACCESS_FINE_LOCATION") || a0.v(activity, "android.permission.ACCESS_COARSE_LOCATION")) ? false : true;
    }

    @Override // j2.u, j2.t, j2.s, j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean c(Context context, String str) {
        return a0.g(str, "android.permission.SCHEDULE_EXACT_ALARM") ? w(context) : (a0.g(str, "android.permission.BLUETOOTH_SCAN") || a0.g(str, "android.permission.BLUETOOTH_CONNECT") || a0.g(str, "android.permission.BLUETOOTH_ADVERTISE")) ? a0.e(context, str) : super.c(context, str);
    }
}
