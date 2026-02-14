package e3;

import java.util.List;

/* loaded from: classes.dex */
public class o {
    public static List a(Object obj) {
        if ((obj instanceof f3.a) && !(obj instanceof f3.b)) {
            e(obj, "kotlin.collections.MutableList");
        }
        return b(obj);
    }

    public static List b(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e4) {
            throw d(e4);
        }
    }

    private static <T extends Throwable> T c(T t4) {
        return (T) f.j(t4, o.class.getName());
    }

    public static ClassCastException d(ClassCastException classCastException) {
        throw ((ClassCastException) c(classCastException));
    }

    public static void e(Object obj, String str) {
        f((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void f(String str) {
        throw d(new ClassCastException(str));
    }
}
