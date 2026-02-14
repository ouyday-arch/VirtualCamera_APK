package x2;

import java.util.Comparator;

/* loaded from: classes.dex */
final class f implements Comparator<Comparable<? super Object>> {

    /* renamed from: b, reason: collision with root package name */
    public static final f f6493b = new f();

    private f() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<Object> comparable, Comparable<Object> comparable2) {
        e3.f.e(comparable, "a");
        e3.f.e(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return e.f6492b;
    }
}
