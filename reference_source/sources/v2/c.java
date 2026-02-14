package v2;

import java.util.AbstractList;

/* loaded from: classes.dex */
public abstract class c<E> extends AbstractList<E> implements f3.b {
    public abstract int a();

    public abstract E b(int i4);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i4) {
        return b(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
