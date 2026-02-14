package v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class o extends n {
    public static final <T> Collection<T> f(T[] tArr) {
        e3.f.e(tArr, "<this>");
        return new d(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int g(List<? extends T> list, T t4, int i4, int i5) {
        int a5;
        e3.f.e(list, "<this>");
        p(list.size(), i4, i5);
        int i6 = i5 - 1;
        while (i4 <= i6) {
            int i7 = (i4 + i6) >>> 1;
            a5 = x2.b.a(list.get(i7), t4);
            if (a5 < 0) {
                i4 = i7 + 1;
            } else {
                if (a5 <= 0) {
                    return i7;
                }
                i6 = i7 - 1;
            }
        }
        return -(i4 + 1);
    }

    public static /* synthetic */ int h(List list, Comparable comparable, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = list.size();
        }
        return g(list, comparable, i4, i5);
    }

    public static <T> List<T> i() {
        return y.f6297b;
    }

    public static g3.f j(Collection<?> collection) {
        e3.f.e(collection, "<this>");
        return new g3.f(0, collection.size() - 1);
    }

    public static <T> int k(List<? extends T> list) {
        e3.f.e(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> l(T... tArr) {
        List<T> i4;
        List<T> c5;
        e3.f.e(tArr, "elements");
        if (tArr.length > 0) {
            c5 = i.c(tArr);
            return c5;
        }
        i4 = i();
        return i4;
    }

    public static <T> List<T> m(T... tArr) {
        e3.f.e(tArr, "elements");
        return j.o(tArr);
    }

    public static <T> List<T> n(T... tArr) {
        e3.f.e(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new d(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> o(List<? extends T> list) {
        List<T> i4;
        List<T> d5;
        e3.f.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            i4 = i();
            return i4;
        }
        if (size != 1) {
            return list;
        }
        d5 = n.d(list.get(0));
        return d5;
    }

    private static final void p(int i4, int i5, int i6) {
        if (i5 > i6) {
            throw new IllegalArgumentException("fromIndex (" + i5 + ") is greater than toIndex (" + i6 + ").");
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i5 + ") is less than zero.");
        }
        if (i6 <= i4) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is greater than size (" + i4 + ").");
    }

    public static void q() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
