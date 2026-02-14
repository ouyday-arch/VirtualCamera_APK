package w2;

import e3.f;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class b {
    public static final <E> E[] d(int i4) {
        if (i4 >= 0) {
            return (E[]) new Object[i4];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] e(T[] tArr, int i4) {
        f.e(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i4);
        f.d(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static final <E> void f(E[] eArr, int i4) {
        f.e(eArr, "<this>");
        eArr[i4] = null;
    }

    public static final <E> void g(E[] eArr, int i4, int i5) {
        f.e(eArr, "<this>");
        while (i4 < i5) {
            f(eArr, i4);
            i4++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i4, int i5, List<?> list) {
        if (i5 != list.size()) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!f.a(tArr[i4 + i6], list.get(i6))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i4, int i5) {
        int i6 = 1;
        for (int i7 = 0; i7 < i5; i7++) {
            T t4 = tArr[i4 + i7];
            i6 = (i6 * 31) + (t4 != null ? t4.hashCode() : 0);
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i4, int i5, Collection<? extends T> collection) {
        StringBuilder sb = new StringBuilder((i5 * 3) + 2);
        sb.append("[");
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            T t4 = tArr[i4 + i6];
            if (t4 == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(t4);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        f.d(sb2, "toString(...)");
        return sb2;
    }
}
