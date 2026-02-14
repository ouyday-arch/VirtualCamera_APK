package n;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes.dex */
public class a extends o.a {

    /* renamed from: b, reason: collision with root package name */
    private static InterfaceC0060a f5215b;

    /* renamed from: n.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060a {
        boolean a(Activity activity, String[] strArr, int i4);

        boolean b(Activity activity, int i4, int i5, Intent intent);
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(int i4);
    }

    public static void e(Activity activity) {
        activity.finishAffinity();
    }

    public static InterfaceC0060a f() {
        return f5215b;
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT < 28 && n.b.i(activity)) {
            return;
        }
        activity.recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(Activity activity, String[] strArr, int i4) {
        InterfaceC0060a interfaceC0060a = f5215b;
        if (interfaceC0060a == null || !interfaceC0060a.a(activity, strArr, i4)) {
            if (activity instanceof b) {
                ((b) activity).b(i4);
            }
            activity.requestPermissions(strArr, i4);
        }
    }

    public static boolean i(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
