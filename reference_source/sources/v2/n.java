package v2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {
    public static <E> List<E> a(List<E> list) {
        e3.f.e(list, "builder");
        return ((w2.a) list).i();
    }

    public static final <T> Object[] b(T[] tArr, boolean z4) {
        e3.f.e(tArr, "<this>");
        if (z4 && e3.f.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        e3.f.d(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static <E> List<E> c() {
        return new w2.a();
    }

    public static <T> List<T> d(T t4) {
        List<T> singletonList = Collections.singletonList(t4);
        e3.f.d(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static <T> T[] e(int i4, T[] tArr) {
        e3.f.e(tArr, "array");
        if (i4 < tArr.length) {
            tArr[i4] = null;
        }
        return tArr;
    }
}
