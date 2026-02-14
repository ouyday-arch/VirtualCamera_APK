package j2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final l f4224a;

    static {
        f4224a = c.f() ? new w() : c.e() ? new v() : c.d() ? new u() : c.c() ? new t() : c.o() ? new s() : c.n() ? new r() : c.l() ? new q() : c.j() ? new p() : c.i() ? new o() : c.h() ? new n() : new m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (i(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> b(List<String> list, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (iArr[i4] == -1) {
                arrayList.add(list.get(i4));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> c(List<String> list, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (iArr[i4] == 0) {
                arrayList.add(list.get(i4));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent d(Context context, String str) {
        return f4224a.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Context context, String str) {
        return f4224a.c(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(Context context, List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!e(context, it.next())) {
                return false;
            }
        }
        return true;
    }

    static boolean g(Activity activity, String str) {
        return f4224a.b(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(Activity activity, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (g(activity, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(String str) {
        return a0.q(str);
    }
}
