package j2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import j2.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Activity activity, boolean z4) {
        if (activity == null) {
            if (z4) {
                throw new IllegalArgumentException("The instance of the context must be an activity object");
            }
            return false;
        }
        if (activity.isFinishing()) {
            if (z4) {
                throw new IllegalStateException("The activity has been finishing, please manually determine the status of the activity");
            }
            return false;
        }
        if (!c.g() || !activity.isDestroyed()) {
            return true;
        }
        if (z4) {
            throw new IllegalStateException("The activity has been destroyed, please manually determine the status of the activity");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(List<String> list) {
        if (a0.f(list, "android.permission.BODY_SENSORS_BACKGROUND")) {
            if (a0.f(list, "android.permission.BODY_SENSORS_BACKGROUND") && !a0.f(list, "android.permission.BODY_SENSORS")) {
                throw new IllegalArgumentException("Applying for background sensor permissions must contain android.permission.BODY_SENSORS");
            }
            for (String str : list) {
                if (a0.g(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    throw new IllegalArgumentException("Applying for permissions android.permission.BODY_SENSORS_BACKGROUND and android.permission.ACCESS_BACKGROUND_LOCATION at the same time is not supported");
                }
                if (a0.g(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
                    throw new IllegalArgumentException("Applying for permissions android.permission.BODY_SENSORS_BACKGROUND and android.permission.ACCESS_MEDIA_LOCATION at the same time is not supported");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(List<String> list) {
        if (a0.f(list, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            if (a0.f(list, "android.permission.ACCESS_COARSE_LOCATION") && !a0.f(list, "android.permission.ACCESS_FINE_LOCATION")) {
                throw new IllegalArgumentException("Applying for background positioning permissions must include android.permission.ACCESS_FINE_LOCATION");
            }
            for (String str : list) {
                if (!a0.g(str, "android.permission.ACCESS_FINE_LOCATION") && !a0.g(str, "android.permission.ACCESS_COARSE_LOCATION") && !a0.g(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    throw new IllegalArgumentException("Because it includes background location permissions, do not apply for permissions unrelated to location");
                }
            }
        }
    }

    static void d(List<a.c> list, String str) {
        e(list, str, Integer.MAX_VALUE);
    }

    static void e(List<a.c> list, String str, int i4) {
        a.c cVar;
        String str2;
        Iterator<a.c> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                cVar = null;
                break;
            } else {
                cVar = it.next();
                if (TextUtils.equals(cVar.f4199a, str)) {
                    break;
                }
            }
        }
        if (cVar == null) {
            throw new IllegalStateException("Please register permissions in the AndroidManifest.xml file <uses-permission android:name=\"" + str + "\" />");
        }
        int i5 = cVar.f4200b;
        if (i5 < i4) {
            StringBuilder sb = new StringBuilder();
            sb.append("The AndroidManifest.xml file <uses-permission android:name=\"");
            sb.append(str);
            sb.append("\" android:maxSdkVersion=\"");
            sb.append(i5);
            sb.append("\" /> does not meet the requirements, ");
            if (i4 != Integer.MAX_VALUE) {
                str2 = "the minimum requirement for maxSdkVersion is " + i4;
            } else {
                str2 = "please delete the android:maxSdkVersion=\"" + i5 + "\" attribute";
            }
            sb.append(str2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Context context, List<String> list, a aVar) {
        int i4;
        String str;
        int i5;
        String str2;
        if (aVar == null) {
            return;
        }
        List<a.c> list2 = aVar.f4191c;
        if (list2.isEmpty()) {
            throw new IllegalStateException("No permissions are registered in the AndroidManifest.xml file");
        }
        if (c.m()) {
            i4 = context.getApplicationInfo().minSdkVersion;
        } else {
            a.e eVar = aVar.f4190b;
            i4 = eVar != null ? eVar.f4204a : 23;
        }
        for (String str3 : list) {
            if (!a0.g(str3, "android.permission.NOTIFICATION_SERVICE") && !a0.g(str3, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") && !a0.g(str3, "android.permission.BIND_VPN_SERVICE") && !a0.g(str3, "android.permission.PICTURE_IN_PICTURE")) {
                d(list2, str3);
                if (a0.g(str3, "android.permission.BODY_SENSORS_BACKGROUND")) {
                    str = "android.permission.BODY_SENSORS";
                } else if (!a0.g(str3, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    if (i4 < 33) {
                        if (a0.g(str3, "android.permission.READ_MEDIA_IMAGES") || a0.g(str3, "android.permission.READ_MEDIA_VIDEO") || a0.g(str3, "android.permission.READ_MEDIA_AUDIO")) {
                            e(list2, "android.permission.READ_EXTERNAL_STORAGE", 32);
                        } else if (a0.g(str3, "android.permission.NEARBY_WIFI_DEVICES")) {
                            e(list2, "android.permission.ACCESS_FINE_LOCATION", 32);
                        }
                    }
                    if (i4 < 31) {
                        if (a0.g(str3, "android.permission.BLUETOOTH_SCAN")) {
                            e(list2, "android.permission.BLUETOOTH_ADMIN", 30);
                            e(list2, "android.permission.ACCESS_FINE_LOCATION", 30);
                        } else if (a0.g(str3, "android.permission.BLUETOOTH_CONNECT")) {
                            e(list2, "android.permission.BLUETOOTH", 30);
                        } else if (a0.g(str3, "android.permission.BLUETOOTH_ADVERTISE")) {
                            e(list2, "android.permission.BLUETOOTH_ADMIN", 30);
                        }
                    }
                    if (i4 < 30 && a0.g(str3, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                        i5 = 29;
                        e(list2, "android.permission.READ_EXTERNAL_STORAGE", 29);
                        str2 = "android.permission.WRITE_EXTERNAL_STORAGE";
                    } else if (i4 < 26 && a0.g(str3, "android.permission.READ_PHONE_NUMBERS")) {
                        i5 = 25;
                        str2 = "android.permission.READ_PHONE_STATE";
                    } else if (a0.g(str3, "com.android.permission.GET_INSTALLED_APPS")) {
                        str = "android.permission.QUERY_ALL_PACKAGES";
                    }
                    e(list2, str2, i5);
                } else if (c.b(context) >= 31) {
                    e(list2, "android.permission.ACCESS_FINE_LOCATION", 30);
                    str = "android.permission.ACCESS_COARSE_LOCATION";
                } else {
                    d(list2, "android.permission.ACCESS_FINE_LOCATION");
                }
                d(list2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Context context, List<String> list) {
        if (a0.f(list, "android.permission.ACCESS_MEDIA_LOCATION")) {
            for (String str : list) {
                if (!a0.g(str, "android.permission.ACCESS_MEDIA_LOCATION") && !a0.g(str, "android.permission.READ_MEDIA_IMAGES") && !a0.g(str, "android.permission.READ_EXTERNAL_STORAGE") && !a0.g(str, "android.permission.WRITE_EXTERNAL_STORAGE") && !a0.g(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    throw new IllegalArgumentException("Because it includes access media location permissions, do not apply for permissions unrelated to access media location");
                }
            }
            if (c.b(context) >= 33) {
                if (!a0.f(list, "android.permission.READ_MEDIA_IMAGES") && !a0.f(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    throw new IllegalArgumentException("You must add android.permission.READ_MEDIA_IMAGES or android.permission.MANAGE_EXTERNAL_STORAGE rights to apply for android.permission.ACCESS_MEDIA_LOCATION rights");
                }
            } else if (!a0.f(list, "android.permission.READ_EXTERNAL_STORAGE") && !a0.f(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                throw new IllegalArgumentException("You must add android.permission.READ_EXTERNAL_STORAGE or android.permission.MANAGE_EXTERNAL_STORAGE rights to apply for android.permission.ACCESS_MEDIA_LOCATION rights");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(List<String> list, a aVar) {
        if ((!a0.f(list, "android.permission.BLUETOOTH_SCAN") && !a0.f(list, "android.permission.NEARBY_WIFI_DEVICES")) || a0.f(list, "android.permission.ACCESS_FINE_LOCATION") || aVar == null) {
            return;
        }
        for (a.c cVar : aVar.f4191c) {
            if (a0.g(cVar.f4199a, "android.permission.BLUETOOTH_SCAN") || a0.g(cVar.f4199a, "android.permission.NEARBY_WIFI_DEVICES")) {
                if (!cVar.a()) {
                    String str = cVar.f4200b != Integer.MAX_VALUE ? "android:maxSdkVersion=\"" + cVar.f4200b + "\" " : "";
                    throw new IllegalArgumentException("If your app doesn't use " + cVar.f4199a + " to get physical location, please change the <uses-permission android:name=\"" + cVar.f4199a + "\" " + str + "/> node in the manifest file to <uses-permission android:name=\"" + cVar.f4199a + "\" android:usesPermissionFlags=\"neverForLocation\" " + str + "/> node, if your app need use " + cVar.f4199a + " to get physical location, also need to add android.permission.ACCESS_FINE_LOCATION permissions");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(List<String> list, a aVar) {
        if (a0.f(list, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") && aVar != null) {
            List<a.d> list2 = aVar.f4194f;
            for (int i4 = 0; i4 < list2.size(); i4++) {
                if (TextUtils.equals(list2.get(i4).f4203b, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE")) {
                    return;
                }
            }
            throw new IllegalArgumentException("No service registered permission attribute, please register <service android:permission=\"android.permission.BIND_NOTIFICATION_LISTENER_SERVICE\" > in AndroidManifest.xml");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(List<String> list, boolean z4) {
        if (list == null || list.isEmpty()) {
            if (z4) {
                throw new IllegalArgumentException("The requested permission cannot be empty");
            }
            return false;
        }
        if (c.a() <= 33 && z4) {
            ArrayList arrayList = new ArrayList();
            Field[] declaredFields = i.class.getDeclaredFields();
            if (declaredFields.length == 0) {
                return true;
            }
            for (Field field : declaredFields) {
                if (String.class.equals(field.getType())) {
                    try {
                        arrayList.add((String) field.get(null));
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                    }
                }
            }
            for (String str : list) {
                if (!a0.f(arrayList, str)) {
                    throw new IllegalArgumentException("The " + str + " is not a dangerous permission or special permission, please do not request dynamically");
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(Activity activity, List<String> list, a aVar) {
        if (a0.f(list, "android.permission.PICTURE_IN_PICTURE") && aVar != null) {
            List<a.C0051a> list2 = aVar.f4193e;
            for (int i4 = 0; i4 < list2.size(); i4++) {
                if (list2.get(i4).f4196b) {
                    return;
                }
            }
            throw new IllegalArgumentException("No activity registered supportsPictureInPicture attribute, please register \n<activity android:name=\"" + activity.getClass().getName().replace(activity.getPackageName(), "") + "\" android:supportsPictureInPicture=\"true\" > in AndroidManifest.xml");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(Context context, List<String> list, a aVar) {
        a.b bVar;
        if (a0.f(list, "android.permission.READ_MEDIA_IMAGES") || a0.f(list, "android.permission.READ_MEDIA_VIDEO") || a0.f(list, "android.permission.READ_MEDIA_AUDIO") || a0.f(list, "android.permission.MANAGE_EXTERNAL_STORAGE") || a0.f(list, "android.permission.READ_EXTERNAL_STORAGE") || a0.f(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (c.b(context) >= 33 && a0.f(list, "android.permission.READ_EXTERNAL_STORAGE")) {
                throw new IllegalArgumentException("When targetSdkVersion >= 33 should use android.permission.READ_MEDIA_IMAGES, android.permission.READ_MEDIA_VIDEO, android.permission.READ_MEDIA_AUDIO instead of android.permission.READ_EXTERNAL_STORAGE");
            }
            if (a0.f(list, "android.permission.READ_MEDIA_IMAGES") || a0.f(list, "android.permission.ACCESS_MEDIA_LOCATION") || aVar == null || (bVar = aVar.f4192d) == null) {
                return;
            }
            boolean p4 = a0.p(context);
            int b5 = c.b(context);
            boolean z4 = bVar.f4198b;
            if (b5 >= 29 && !z4 && (a0.f(list, "android.permission.MANAGE_EXTERNAL_STORAGE") || !p4)) {
                throw new IllegalStateException("Please register the android:requestLegacyExternalStorage=\"true\" attribute in the AndroidManifest.xml file, otherwise it will cause incompatibility with the old version");
            }
            if (b5 >= 30 && !a0.f(list, "android.permission.MANAGE_EXTERNAL_STORAGE") && !p4) {
                throw new IllegalArgumentException("The storage permission application is abnormal. If you have adapted the scope storage, please register the <meta-data android:name=\"ScopedStorage\" android:value=\"true\" /> attribute in the AndroidManifest.xml file. If there is no adaptation scope storage, please use android.permission.MANAGE_EXTERNAL_STORAGE to apply for permission");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(Context context, List<String> list) {
        int i4 = (a0.f(list, "android.permission.POST_NOTIFICATIONS") || a0.f(list, "android.permission.NEARBY_WIFI_DEVICES") || a0.f(list, "android.permission.BODY_SENSORS_BACKGROUND") || a0.f(list, "android.permission.READ_MEDIA_IMAGES") || a0.f(list, "android.permission.READ_MEDIA_VIDEO") || a0.f(list, "android.permission.READ_MEDIA_AUDIO")) ? 33 : (a0.f(list, "android.permission.BLUETOOTH_SCAN") || a0.f(list, "android.permission.BLUETOOTH_CONNECT") || a0.f(list, "android.permission.BLUETOOTH_ADVERTISE") || a0.f(list, "android.permission.SCHEDULE_EXACT_ALARM")) ? 31 : a0.f(list, "android.permission.MANAGE_EXTERNAL_STORAGE") ? 30 : (a0.f(list, "android.permission.ACCESS_BACKGROUND_LOCATION") || a0.f(list, "android.permission.ACTIVITY_RECOGNITION") || a0.f(list, "android.permission.ACCESS_MEDIA_LOCATION")) ? 29 : a0.f(list, "android.permission.ACCEPT_HANDOVER") ? 28 : (a0.f(list, "android.permission.REQUEST_INSTALL_PACKAGES") || a0.f(list, "android.permission.ANSWER_PHONE_CALLS") || a0.f(list, "android.permission.READ_PHONE_NUMBERS") || a0.f(list, "android.permission.PICTURE_IN_PICTURE")) ? 26 : 23;
        if (c.b(context) >= i4) {
            return;
        }
        throw new RuntimeException("The targetSdkVersion SDK must be " + i4 + " or more, if you do not want to upgrade targetSdkVersion, please apply with the old permissions");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void n(List<String> list) {
        if (!c.f()) {
            if (a0.f(list, "android.permission.POST_NOTIFICATIONS") && !a0.f(list, "android.permission.NOTIFICATION_SERVICE")) {
                list.add("android.permission.NOTIFICATION_SERVICE");
            }
            if (a0.f(list, "android.permission.NEARBY_WIFI_DEVICES") && !a0.f(list, "android.permission.ACCESS_FINE_LOCATION")) {
                list.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if ((a0.f(list, "android.permission.READ_MEDIA_IMAGES") || a0.f(list, "android.permission.READ_MEDIA_VIDEO") || a0.f(list, "android.permission.READ_MEDIA_AUDIO")) && !a0.f(list, "android.permission.READ_EXTERNAL_STORAGE")) {
                list.add("android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        if (!c.e() && a0.f(list, "android.permission.BLUETOOTH_SCAN") && !a0.f(list, "android.permission.ACCESS_FINE_LOCATION")) {
            list.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (a0.f(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
            if (a0.f(list, "android.permission.READ_EXTERNAL_STORAGE") || a0.f(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                throw new IllegalArgumentException("If you have applied for MANAGE_EXTERNAL_STORAGE permissions, do not apply for the READ_EXTERNAL_STORAGE and WRITE_EXTERNAL_STORAGE permissions");
            }
            if (!c.d()) {
                list.add("android.permission.READ_EXTERNAL_STORAGE");
                list.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
        }
        if (!c.c() && a0.f(list, "android.permission.ACTIVITY_RECOGNITION") && !a0.f(list, "android.permission.BODY_SENSORS")) {
            list.add("android.permission.BODY_SENSORS");
        }
        if (c.n() || !a0.f(list, "android.permission.READ_PHONE_NUMBERS") || a0.f(list, "android.permission.READ_PHONE_STATE")) {
            return;
        }
        list.add("android.permission.READ_PHONE_STATE");
    }
}
