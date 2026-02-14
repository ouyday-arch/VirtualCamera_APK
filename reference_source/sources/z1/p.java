package z1;

/* loaded from: classes.dex */
final class p extends q {

    /* renamed from: b, reason: collision with root package name */
    private final int f6678b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6679c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i4, int i5, int i6) {
        super(i4);
        if (i5 < 0 || i5 > 10 || i6 < 0 || i6 > 10) {
            throw g1.h.a();
        }
        this.f6678b = i5;
        this.f6679c = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f6678b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f6679c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f6678b == 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f6679c == 10;
    }
}
