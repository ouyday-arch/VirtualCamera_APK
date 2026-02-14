package x;

/* loaded from: classes.dex */
public class g<T> extends f<T> {

    /* renamed from: c, reason: collision with root package name */
    private final Object f6465c;

    public g(int i4) {
        super(i4);
        this.f6465c = new Object();
    }

    @Override // x.f, x.e
    public boolean a(T t4) {
        boolean a5;
        synchronized (this.f6465c) {
            a5 = super.a(t4);
        }
        return a5;
    }

    @Override // x.f, x.e
    public T b() {
        T t4;
        synchronized (this.f6465c) {
            t4 = (T) super.b();
        }
        return t4;
    }
}
