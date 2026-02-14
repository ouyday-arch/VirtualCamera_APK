package t2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f6003a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f6004b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static List<String> f6005c = new ArrayList(Arrays.asList("su"));

    /* renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    static Context f6006d;

    public static void a(String str) {
        if (f6005c.indexOf(str) == -1) {
            f6005c.add(str);
        }
    }

    public static void b(String str, Throwable th) {
        Log.d(str, "", th);
    }

    public static void c(Throwable th) {
        b("LIBSU", th);
    }

    @SuppressLint({"PrivateApi"})
    public static Context d() {
        if (f6006d == null) {
            try {
                f6006d = e((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]));
            } catch (Exception e4) {
                c(e4);
            }
        }
        return f6006d;
    }

    public static Context e(Context context) {
        while (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    public static String f() {
        for (String str : System.getenv("PATH").split(":")) {
            for (String str2 : f6005c) {
                if (new File(str, str2).canExecute()) {
                    Log.i("SU", "su " + str2);
                    return str2;
                }
                Log.e("SU", "su check fail " + str + "/" + str2);
            }
        }
        return "su";
    }

    public static boolean g(Collection<?> collection) {
        if (f6003a == null) {
            f6003a = Collections.synchronizedCollection(h.c()).getClass();
        }
        return f6003a.isInstance(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void h(boolean z4) {
        synchronized (w.class) {
            f6004b = z4 ? 2 : 0;
        }
    }
}
