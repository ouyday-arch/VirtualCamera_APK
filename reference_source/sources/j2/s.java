package j2;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes.dex */
class s extends r {
    @Override // j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean b(Activity activity, String str) {
        return a0.g(str, "android.permission.ACCEPT_HANDOVER") ? (a0.e(activity, str) || a0.v(activity, str)) ? false : true : super.b(activity, str);
    }

    @Override // j2.r, j2.q, j2.p, j2.o, j2.n, j2.m, j2.l
    public boolean c(Context context, String str) {
        return a0.g(str, "android.permission.ACCEPT_HANDOVER") ? a0.e(context, str) : super.c(context, str);
    }
}
