package e3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class a<T> implements Iterator<T>, f3.a {

    /* renamed from: b, reason: collision with root package name */
    private final T[] f3623b;

    /* renamed from: c, reason: collision with root package name */
    private int f3624c;

    public a(T[] tArr) {
        f.e(tArr, "array");
        this.f3623b = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3624c < this.f3623b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f3623b;
            int i4 = this.f3624c;
            this.f3624c = i4 + 1;
            return tArr[i4];
        } catch (ArrayIndexOutOfBoundsException e4) {
            this.f3624c--;
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
