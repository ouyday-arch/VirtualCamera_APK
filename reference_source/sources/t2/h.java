package t2;

import java.util.AbstractList;

/* loaded from: classes.dex */
public class h extends AbstractList<String> {

    /* renamed from: b, reason: collision with root package name */
    private static h f5967b;

    private h() {
    }

    public static h c() {
        if (f5967b == null) {
            f5967b = new h();
        }
        return f5967b;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i4, String str) {
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get(int i4) {
        return null;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String remove(int i4) {
        return null;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public String set(int i4, String str) {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 0;
    }
}
