package v2;

import java.util.Set;

/* loaded from: classes.dex */
class k0 extends j0 {
    public static final <T> Set<T> b() {
        return a0.f6280b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> set) {
        e3.f.e(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : j0.a(set.iterator().next()) : b();
    }
}
