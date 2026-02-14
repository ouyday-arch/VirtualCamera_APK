package j2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

@SuppressLint({"AnnotateVersionCheck"})
/* loaded from: classes.dex */
final class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return Build.VERSION.SDK_INT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Context context) {
        return context.getApplicationInfo().targetSdkVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return Build.VERSION.SDK_INT >= 29;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        return Build.VERSION.SDK_INT >= 30;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e() {
        return Build.VERSION.SDK_INT >= 31;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f() {
        return Build.VERSION.SDK_INT >= 33;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean n() {
        return Build.VERSION.SDK_INT >= 26;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
