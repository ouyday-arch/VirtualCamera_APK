package j2;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public interface e {
    default void a(Activity activity, List<String> list, boolean z4, h hVar) {
    }

    default void b(Activity activity, List<String> list, List<String> list2, boolean z4, h hVar) {
        if (hVar == null) {
            return;
        }
        hVar.b(list2, z4);
    }

    default void c(Activity activity, List<String> list, List<String> list2, boolean z4, h hVar) {
        if (hVar == null) {
            return;
        }
        hVar.a(list2, z4);
    }

    default void d(Activity activity, List<String> list, h hVar) {
        x.c(activity, new ArrayList(list), this, hVar);
    }
}
