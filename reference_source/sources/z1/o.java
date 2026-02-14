package z1;

/* loaded from: classes.dex */
final class o extends q {

    /* renamed from: b, reason: collision with root package name */
    private final String f6675b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6676c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f6677d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i4, String str) {
        super(i4);
        this.f6675b = str;
        this.f6677d = false;
        this.f6676c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i4, String str, int i5) {
        super(i4);
        this.f6677d = true;
        this.f6676c = i5;
        this.f6675b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f6675b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f6676c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f6677d;
    }
}
