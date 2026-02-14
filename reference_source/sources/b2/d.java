package b2;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f2266a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2267b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2268c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2269d;

    /* renamed from: e, reason: collision with root package name */
    private int f2270e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i4, int i5, int i6, int i7) {
        this.f2266a = i4;
        this.f2267b = i5;
        this.f2268c = i6;
        this.f2269d = i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2268c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f2267b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f2270e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f2266a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f2269d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f2267b - this.f2266a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return h(this.f2270e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(int i4) {
        return i4 != -1 && this.f2268c == (i4 % 3) * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i4) {
        this.f2270e = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.f2270e = ((this.f2269d / 30) * 3) + (this.f2268c / 3);
    }

    public String toString() {
        return this.f2270e + "|" + this.f2269d;
    }
}
