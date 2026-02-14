package x;

/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f6463a;

    /* renamed from: b, reason: collision with root package name */
    private int f6464b;

    public f(int i4) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f6463a = new Object[i4];
    }

    private boolean c(T t4) {
        for (int i4 = 0; i4 < this.f6464b; i4++) {
            if (this.f6463a[i4] == t4) {
                return true;
            }
        }
        return false;
    }

    @Override // x.e
    public boolean a(T t4) {
        if (c(t4)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i4 = this.f6464b;
        Object[] objArr = this.f6463a;
        if (i4 >= objArr.length) {
            return false;
        }
        objArr[i4] = t4;
        this.f6464b = i4 + 1;
        return true;
    }

    @Override // x.e
    public T b() {
        int i4 = this.f6464b;
        if (i4 <= 0) {
            return null;
        }
        int i5 = i4 - 1;
        Object[] objArr = this.f6463a;
        T t4 = (T) objArr[i5];
        objArr[i5] = null;
        this.f6464b = i4 - 1;
        return t4;
    }
}
