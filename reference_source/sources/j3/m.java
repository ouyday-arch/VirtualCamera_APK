package j3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    public static <T> void a(Appendable appendable, T t4, d3.b<? super T, ? extends CharSequence> bVar) {
        CharSequence valueOf;
        e3.f.e(appendable, "<this>");
        if (bVar != null) {
            t4 = (T) bVar.b(t4);
        } else {
            if (!(t4 == 0 ? true : t4 instanceof CharSequence)) {
                if (t4 instanceof Character) {
                    appendable.append(((Character) t4).charValue());
                    return;
                } else {
                    valueOf = String.valueOf((Object) t4);
                    appendable.append(valueOf);
                }
            }
        }
        valueOf = (CharSequence) t4;
        appendable.append(valueOf);
    }
}
