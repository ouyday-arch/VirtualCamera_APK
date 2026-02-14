package x;

import java.util.Objects;

/* loaded from: classes.dex */
public final class h {
    public static void a(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int b(int i4) {
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T c(T t4) {
        Objects.requireNonNull(t4);
        return t4;
    }

    public static <T> T d(T t4, Object obj) {
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
