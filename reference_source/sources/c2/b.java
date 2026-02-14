package c2;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final b f2446f = new b(929, 3);

    /* renamed from: a, reason: collision with root package name */
    private final int[] f2447a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f2448b;

    /* renamed from: c, reason: collision with root package name */
    private final c f2449c;

    /* renamed from: d, reason: collision with root package name */
    private final c f2450d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2451e;

    private b(int i4, int i5) {
        this.f2451e = i4;
        this.f2447a = new int[i4];
        this.f2448b = new int[i4];
        int i6 = 1;
        for (int i7 = 0; i7 < i4; i7++) {
            this.f2447a[i7] = i6;
            i6 = (i6 * i5) % i4;
        }
        for (int i8 = 0; i8 < i4 - 1; i8++) {
            this.f2448b[this.f2447a[i8]] = i8;
        }
        this.f2449c = new c(this, new int[]{0});
        this.f2450d = new c(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i4, int i5) {
        return (i4 + i5) % this.f2451e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b(int i4, int i5) {
        if (i4 < 0) {
            throw new IllegalArgumentException();
        }
        if (i5 == 0) {
            return this.f2449c;
        }
        int[] iArr = new int[i4 + 1];
        iArr[0] = i5;
        return new c(this, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i4) {
        return this.f2447a[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        return this.f2450d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f2451e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c f() {
        return this.f2449c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(int i4) {
        if (i4 != 0) {
            return this.f2447a[(this.f2451e - this.f2448b[i4]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i4) {
        if (i4 != 0) {
            return this.f2448b[i4];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i4, int i5) {
        if (i4 == 0 || i5 == 0) {
            return 0;
        }
        int[] iArr = this.f2447a;
        int[] iArr2 = this.f2448b;
        return iArr[(iArr2[i4] + iArr2[i5]) % (this.f2451e - 1)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(int i4, int i5) {
        int i6 = this.f2451e;
        return ((i4 + i6) - i5) % i6;
    }
}
