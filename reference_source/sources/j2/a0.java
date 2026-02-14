package j2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f4205a = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return c.f() ? !packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(65536L)).isEmpty() : !packageManager.queryIntentActivities(intent, 65536).isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ArrayList<T> b(T... tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr != null ? tArr.length : 0);
        if (tArr != null && tArr.length != 0) {
            for (T t4 : tArr) {
                arrayList.add(t4);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context, String str) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        return (c.c() ? appOpsManager.unsafeCheckOpNoThrow(str, context.getApplicationInfo().uid, context.getPackageName()) : appOpsManager.checkOpNoThrow(str, context.getApplicationInfo().uid, context.getPackageName())) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Context context, String str, int i4) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i5 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            try {
                i4 = ((Integer) cls.getDeclaredField(str).get(Integer.class)).intValue();
            } catch (NoSuchFieldException e4) {
                e4.printStackTrace();
            }
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(i4), Integer.valueOf(i5), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(Collection<String> collection, String str) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (g(it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(String str, String str2) {
        int length = str.length();
        if (length != str2.length()) {
            return false;
        }
        for (int i4 = length - 1; i4 >= 0; i4--) {
            if (str.charAt(i4) != str2.charAt(i4)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Activity h(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper) || (context = ((ContextWrapper) context).getBaseContext()) == null) {
                return null;
            }
        }
        return (Activity) context;
    }

    @SuppressLint({"PrivateApi"})
    static int i(Context context, String str) {
        AssetManager assets = context.getAssets();
        try {
            if (c.b(context) >= 28 && c.a() >= 28 && c.a() < 30) {
                Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                declaredMethod.setAccessible(true);
                Method method = (Method) declaredMethod.invoke(AssetManager.class, "findCookieForPath", new Class[]{String.class});
                if (method != null) {
                    method.setAccessible(true);
                    Integer num = (Integer) method.invoke(context.getAssets(), str);
                    if (num != null) {
                        return num.intValue();
                    }
                }
            }
            Integer num2 = (Integer) assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, str);
            if (num2 != null) {
                return num2.intValue();
            }
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a j(Context context) {
        a b5;
        int i4 = i(context, context.getApplicationInfo().sourceDir);
        a aVar = null;
        if (i4 == 0) {
            return null;
        }
        try {
            b5 = b.b(context, i4);
        } catch (IOException e4) {
            e = e4;
        } catch (XmlPullParserException e5) {
            e = e5;
        }
        try {
            if (TextUtils.equals(context.getPackageName(), b5.f4189a)) {
                return b5;
            }
            return null;
        } catch (IOException e6) {
            e = e6;
            aVar = b5;
            e.printStackTrace();
            return aVar;
        } catch (XmlPullParserException e7) {
            e = e7;
            aVar = b5;
            e.printStackTrace();
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent k(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(l(context));
        if (a(context, intent)) {
            return intent;
        }
        Intent intent2 = new Intent("android.settings.APPLICATION_SETTINGS");
        return a(context, intent2) ? intent2 : new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri l(Context context) {
        return Uri.parse("package:" + context.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent m(Context context, List<String> list) {
        if (list == null || list.isEmpty()) {
            return k(context);
        }
        if (j.a(list)) {
            int size = list.size();
            if (size != 1) {
                if (size != 2) {
                    if (size == 3 && c.d() && f(list, "android.permission.MANAGE_EXTERNAL_STORAGE") && f(list, "android.permission.READ_EXTERNAL_STORAGE") && f(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        return j.d(context, "android.permission.MANAGE_EXTERNAL_STORAGE");
                    }
                } else if (!c.f() && f(list, "android.permission.NOTIFICATION_SERVICE") && f(list, "android.permission.POST_NOTIFICATIONS")) {
                    return j.d(context, "android.permission.NOTIFICATION_SERVICE");
                }
                return k(context);
            }
        } else if (list.size() != 1) {
            return k(context);
        }
        return j.d(context, list.get(0));
    }

    static boolean n(Activity activity) {
        int rotation = (c.d() ? activity.getDisplay() : activity.getWindowManager().getDefaultDisplay()).getRotation();
        return rotation == 2 || rotation == 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null || !bundle.containsKey("ScopedStorage")) {
                return false;
            }
            return Boolean.parseBoolean(String.valueOf(bundle.get("ScopedStorage")));
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q(String str) {
        return g(str, "android.permission.MANAGE_EXTERNAL_STORAGE") || g(str, "android.permission.REQUEST_INSTALL_PACKAGES") || g(str, "android.permission.SYSTEM_ALERT_WINDOW") || g(str, "android.permission.WRITE_SETTINGS") || g(str, "android.permission.NOTIFICATION_SERVICE") || g(str, "android.permission.PACKAGE_USAGE_STATS") || g(str, "android.permission.SCHEDULE_EXACT_ALARM") || g(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") || g(str, "android.permission.ACCESS_NOTIFICATION_POLICY") || g(str, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") || g(str, "android.permission.BIND_VPN_SERVICE") || g(str, "android.permission.PICTURE_IN_PICTURE");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"SwitchIntDef"})
    public static void r(Activity activity) {
        try {
            int i4 = activity.getResources().getConfiguration().orientation;
            if (i4 == 1) {
                activity.setRequestedOrientation(n(activity) ? 9 : 1);
            } else if (i4 == 2) {
                activity.setRequestedOrientation(n(activity) ? 8 : 0);
            }
        } catch (IllegalStateException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void s(Activity activity, String[] strArr, int[] iArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            String str = strArr[i4];
            boolean i5 = j.i(str);
            if (c.f() && c.b(activity) >= 33 && g(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                i5 = true;
            }
            if (!c.f() && (g(str, "android.permission.POST_NOTIFICATIONS") || g(str, "android.permission.NEARBY_WIFI_DEVICES") || g(str, "android.permission.BODY_SENSORS_BACKGROUND") || g(str, "android.permission.READ_MEDIA_IMAGES") || g(str, "android.permission.READ_MEDIA_VIDEO") || g(str, "android.permission.READ_MEDIA_AUDIO"))) {
                i5 = true;
            }
            if (!c.e() && (g(str, "android.permission.BLUETOOTH_SCAN") || g(str, "android.permission.BLUETOOTH_CONNECT") || g(str, "android.permission.BLUETOOTH_ADVERTISE"))) {
                i5 = true;
            }
            if (!c.c() && (g(str, "android.permission.ACCESS_BACKGROUND_LOCATION") || g(str, "android.permission.ACTIVITY_RECOGNITION") || g(str, "android.permission.ACCESS_MEDIA_LOCATION"))) {
                i5 = true;
            }
            if (!c.o() && g(str, "android.permission.ACCEPT_HANDOVER")) {
                i5 = true;
            }
            if (!c.n() && (g(str, "android.permission.ANSWER_PHONE_CALLS") || g(str, "android.permission.READ_PHONE_NUMBERS"))) {
                i5 = true;
            }
            if (g(str, "com.android.permission.GET_INSTALLED_APPS") ? true : i5) {
                iArr[i4] = j.e(activity, str) ? 0 : -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void t(List<String> list, Runnable runnable) {
        long j4 = 300;
        long j5 = c.d() ? 200L : 300L;
        if (!b0.j() && !b0.k()) {
            j4 = (b0.l() && c.d() && f(list, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) ? 1000L : j5;
        } else if (!c.n()) {
            j4 = 500;
        }
        u(runnable, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void u(Runnable runnable, long j4) {
        f4205a.postDelayed(runnable, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v(Activity activity, String str) {
        if (c.a() == 31) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
