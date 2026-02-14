package x2;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    public static <T extends Comparable<?>> int a(T t4, T t5) {
        if (t4 == t5) {
            return 0;
        }
        if (t4 == null) {
            return -1;
        }
        if (t5 == null) {
            return 1;
        }
        return t4.compareTo(t5);
    }

    public static <T extends Comparable<? super T>> Comparator<T> b() {
        e eVar = e.f6492b;
        e3.f.c(eVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return eVar;
    }
}
