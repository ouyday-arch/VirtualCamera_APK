package j2;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/* loaded from: classes.dex */
final class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f4206a = {"huawei"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f4207b = {"vivo"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f4208c = {"xiaomi"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f4209d = {"oppo"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f4210e = {"leeco", "letv"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f4211f = {"360", "qiku"};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f4212g = {"zte"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f4213h = {"oneplus"};

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f4214i = {"nubia"};

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f4215j = {"samsung"};

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f4216k = {"ro.build.version.opporom", "ro.build.version.oplusrom.display"};

    private static String a() {
        return Build.BRAND.toLowerCase();
    }

    private static String b() {
        return Build.MANUFACTURER.toLowerCase();
    }

    private static String c(String str) {
        return !TextUtils.isEmpty(str) ? e(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        String a5 = a();
        String b5 = b();
        if (p(a5, b5, f4206a)) {
            String c5 = c("ro.build.version.emui");
            String[] split = c5.split("_");
            return split.length > 1 ? split[1] : c5.contains("EmotionUI") ? c5.replaceFirst("EmotionUI\\s*", "") : c5;
        }
        if (p(a5, b5, f4207b)) {
            return c("ro.vivo.os.build.display.id");
        }
        if (p(a5, b5, f4208c)) {
            return c("ro.build.version.incremental");
        }
        if (!p(a5, b5, f4209d)) {
            return p(a5, b5, f4210e) ? c("ro.letv.release.version") : p(a5, b5, f4211f) ? c("ro.build.uiversion") : p(a5, b5, f4212g) ? c("ro.build.MiFavor_version") : p(a5, b5, f4213h) ? c("ro.rom.version") : p(a5, b5, f4214i) ? c("ro.build.rom.id") : c("");
        }
        for (String str : f4216k) {
            String c6 = c(str);
            if (!TextUtils.isEmpty(str)) {
                return c6;
            }
        }
        return "";
    }

    private static String e(String str) {
        String g4 = g(str);
        if (!TextUtils.isEmpty(g4)) {
            return g4;
        }
        String h4 = h(str);
        return (TextUtils.isEmpty(h4) && Build.VERSION.SDK_INT < 28) ? f(str) : h4;
    }

    @SuppressLint({"PrivateApi"})
    private static String f(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return "";
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
            return "";
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
            return "";
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
            return "";
        }
    }

    private static String g(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e4) {
                e = e4;
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (IOException e5) {
                e = e5;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                if (bufferedReader2 == null) {
                    return "";
                }
                bufferedReader2.close();
                return "";
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
            if (readLine == null) {
                bufferedReader.close();
                return "";
            }
            try {
                bufferedReader.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
            return readLine;
        } catch (IOException e8) {
            e8.printStackTrace();
            return "";
        }
    }

    private static String h(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
            return "";
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        for (String str : f4216k) {
            if (!TextUtils.isEmpty(c(str))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j() {
        return !TextUtils.isEmpty(c("ro.build.version.emui"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(String.valueOf(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l() {
        return !TextUtils.isEmpty(c("ro.miui.ui.version.name"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"PrivateApi"})
    public static boolean m() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String valueOf = String.valueOf(cls.getMethod("get", String.class, String.class).invoke(cls, "ro.miui.cts", ""));
            Method method = cls.getMethod("getBoolean", String.class, Boolean.TYPE);
            Object[] objArr = new Object[2];
            objArr[0] = "persist.sys.miui_optimization";
            objArr[1] = Boolean.valueOf("1".equals(valueOf) ? false : true);
            return Boolean.parseBoolean(String.valueOf(method.invoke(cls, objArr)));
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return true;
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
            return true;
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
            return true;
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"PrivateApi"})
    public static boolean n() {
        return p(a(), b(), f4215j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o() {
        return !TextUtils.isEmpty(c("ro.vivo.os.build.display.id"));
    }

    private static boolean p(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }
}
