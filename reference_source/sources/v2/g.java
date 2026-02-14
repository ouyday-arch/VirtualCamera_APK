package v2;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
class g {
    public static final <T> T[] a(T[] tArr, int i4) {
        e3.f.e(tArr, "reference");
        Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i4);
        e3.f.c(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) newInstance);
    }

    public static final void b(int i4, int i5) {
        if (i4 <= i5) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i5 + ").");
    }
}
