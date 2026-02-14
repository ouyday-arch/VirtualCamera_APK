package z1;

/* loaded from: classes.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private int f6668a = 0;

    /* renamed from: b, reason: collision with root package name */
    private a f6669b = a.NUMERIC;

    /* loaded from: classes.dex */
    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f6668a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i4) {
        this.f6668a += i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f6669b == a.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f6669b == a.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f6669b = a.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f6669b = a.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f6669b = a.NUMERIC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i4) {
        this.f6668a = i4;
    }
}
