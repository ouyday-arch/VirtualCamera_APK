package v2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends r {
    public static <T extends Comparable<? super T>> void s(List<T> list) {
        e3.f.e(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void t(List<T> list, Comparator<? super T> comparator) {
        e3.f.e(list, "<this>");
        e3.f.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
