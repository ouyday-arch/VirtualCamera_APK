package k1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: b, reason: collision with root package name */
    static final g f4392b = new e(null, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final g f4393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(g gVar) {
        this.f4393a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g a(int i4, int i5) {
        return new e(this, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g b(int i4, int i5) {
        return new b(this, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(n1.a aVar, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g d() {
        return this.f4393a;
    }
}
