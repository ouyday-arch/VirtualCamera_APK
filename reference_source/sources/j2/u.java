package j2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends t {
    private static Intent t(Context context) {
        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(a0.l(context));
        if (!a0.a(context, intent)) {
            intent = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
        }
        return !a0.a(context, intent) ? a0.k(context) : intent;
    }

    private static boolean u() {
        return Environment.isExternalStorageManager();
    }

    @Override // j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public Intent a(Context context, String str) {
        return a0.g(str, "android.permission.MANAGE_EXTERNAL_STORAGE") ? t(context) : super.a(context, str);
    }

    @Override // j2.t, j2.s, j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean b(Activity activity, String str) {
        if (a0.g(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
            return false;
        }
        return super.b(activity, str);
    }

    @Override // j2.t, j2.s, j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean c(Context context, String str) {
        return a0.g(str, "android.permission.MANAGE_EXTERNAL_STORAGE") ? u() : super.c(context, str);
    }
}
