package v2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends s {
    public static <T> boolean u(Collection<? super T> collection, Iterable<? extends T> iterable) {
        e3.f.e(collection, "<this>");
        e3.f.e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z4 = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z4 = true;
            }
        }
        return z4;
    }

    public static <T> boolean v(Collection<? super T> collection, T[] tArr) {
        e3.f.e(collection, "<this>");
        e3.f.e(tArr, "elements");
        return collection.addAll(f.c(tArr));
    }

    public static <T> T w(List<T> list) {
        e3.f.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(m.k(list));
    }
}
