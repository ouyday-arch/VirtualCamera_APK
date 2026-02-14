package o;

import android.content.Context;
import android.os.Process;
import n.c;

/* loaded from: classes.dex */
public final class b {
    public static int a(Context context, String str, int i4, int i5, String str2) {
        if (context.checkPermission(str, i4, i5) == -1) {
            return -1;
        }
        String b5 = c.b(str);
        if (b5 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i5);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return c.a(context, b5, str2) != 0 ? -2 : 0;
    }

    public static int b(Context context, String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
