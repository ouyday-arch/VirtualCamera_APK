package v2;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class c0 implements Iterator<Long>, f3.a {
    public abstract long a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
