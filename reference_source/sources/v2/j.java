package v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends i {
    public static final <T> boolean n(T[] tArr, T t4) {
        e3.f.e(tArr, "<this>");
        return s(tArr, t4) >= 0;
    }

    public static final <T> List<T> o(T[] tArr) {
        e3.f.e(tArr, "<this>");
        return (List) p(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C p(T[] tArr, C c5) {
        e3.f.e(tArr, "<this>");
        e3.f.e(c5, "destination");
        for (T t4 : tArr) {
            if (t4 != null) {
                c5.add(t4);
            }
        }
        return c5;
    }

    public static <T> int q(T[] tArr) {
        e3.f.e(tArr, "<this>");
        return tArr.length - 1;
    }

    public static <T> T r(T[] tArr, int i4) {
        int q4;
        e3.f.e(tArr, "<this>");
        if (i4 >= 0) {
            q4 = q(tArr);
            if (i4 <= q4) {
                return tArr[i4];
            }
        }
        return null;
    }

    public static final <T> int s(T[] tArr, T t4) {
        e3.f.e(tArr, "<this>");
        int i4 = 0;
        if (t4 == null) {
            int length = tArr.length;
            while (i4 < length) {
                if (tArr[i4] == null) {
                    return i4;
                }
                i4++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i4 < length2) {
            if (e3.f.a(t4, tArr[i4])) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static char t(char[] cArr) {
        e3.f.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T u(T[] tArr) {
        e3.f.e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static byte[] v(byte[] bArr, g3.f fVar) {
        byte[] h4;
        e3.f.e(bArr, "<this>");
        e3.f.e(fVar, "indices");
        if (fVar.isEmpty()) {
            return new byte[0];
        }
        h4 = i.h(bArr, fVar.h().intValue(), fVar.g().intValue() + 1);
        return h4;
    }

    public static <T> List<T> w(T[] tArr) {
        List<T> i4;
        List<T> d5;
        List<T> x4;
        e3.f.e(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            i4 = o.i();
            return i4;
        }
        if (length != 1) {
            x4 = x(tArr);
            return x4;
        }
        d5 = n.d(tArr[0]);
        return d5;
    }

    public static <T> List<T> x(T[] tArr) {
        e3.f.e(tArr, "<this>");
        return new ArrayList(o.f(tArr));
    }
}
