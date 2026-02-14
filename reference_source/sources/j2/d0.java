package j2;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context) {
        Intent g4;
        if (c.l()) {
            if (!c.d() || !b0.l() || !b0.m()) {
                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                intent.setData(a0.l(context));
                return a0.a(context, intent) ? intent : a0.k(context);
            }
            g4 = z.d(context);
        } else if (b0.j()) {
            g4 = z.b(context);
        } else if (b0.l()) {
            g4 = null;
            if (b0.m()) {
                g4 = z.e(context);
            }
        } else if (b0.i()) {
            g4 = z.a(context);
        } else if (b0.o()) {
            g4 = z.i(context);
        } else {
            if (!b0.n()) {
                return a0.k(context);
            }
            g4 = z.g(context);
        }
        return c0.a(g4, a0.k(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context) {
        if (c.l()) {
            return Settings.canDrawOverlays(context);
        }
        if (c.i()) {
            return a0.d(context, "OP_SYSTEM_ALERT_WINDOW", 24);
        }
        return true;
    }
}
