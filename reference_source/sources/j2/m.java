package j2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;

/* loaded from: classes.dex */
class m implements l {
    private static Intent d(Context context) {
        Intent prepare = VpnService.prepare(context);
        return !a0.a(context, prepare) ? a0.k(context) : prepare;
    }

    private static boolean e(Context context) {
        return VpnService.prepare(context) == null;
    }

    @Override // j2.l
    public Intent a(Context context, String str) {
        return a0.g(str, "android.permission.BIND_VPN_SERVICE") ? d(context) : a0.k(context);
    }

    @Override // j2.l
    public boolean b(Activity activity, String str) {
        return false;
    }

    @Override // j2.l
    public boolean c(Context context, String str) {
        if (a0.g(str, "android.permission.BIND_VPN_SERVICE")) {
            return e(context);
        }
        return true;
    }
}
