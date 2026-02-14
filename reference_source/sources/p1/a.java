package p1;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f5412h = new a(4201, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final a f5413i = new a(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final a f5414j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f5415k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f5416l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f5417m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f5418n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f5419o;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f5420a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f5421b;

    /* renamed from: c, reason: collision with root package name */
    private final b f5422c;

    /* renamed from: d, reason: collision with root package name */
    private final b f5423d;

    /* renamed from: e, reason: collision with root package name */
    private final int f5424e;

    /* renamed from: f, reason: collision with root package name */
    private final int f5425f;

    /* renamed from: g, reason: collision with root package name */
    private final int f5426g;

    static {
        a aVar = new a(67, 64, 1);
        f5414j = aVar;
        f5415k = new a(19, 16, 1);
        f5416l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f5417m = aVar2;
        f5418n = aVar2;
        f5419o = aVar;
    }

    public a(int i4, int i5, int i6) {
        this.f5425f = i4;
        this.f5424e = i5;
        this.f5426g = i6;
        this.f5420a = new int[i5];
        this.f5421b = new int[i5];
        int i7 = 1;
        for (int i8 = 0; i8 < i5; i8++) {
            this.f5420a[i8] = i7;
            i7 <<= 1;
            if (i7 >= i5) {
                i7 = (i7 ^ i4) & (i5 - 1);
            }
        }
        for (int i9 = 0; i9 < i5 - 1; i9++) {
            this.f5421b[this.f5420a[i9]] = i9;
        }
        this.f5422c = new b(this, new int[]{0});
        this.f5423d = new b(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i4, int i5) {
        return i4 ^ i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(int i4, int i5) {
        if (i4 < 0) {
            throw new IllegalArgumentException();
        }
        if (i5 == 0) {
            return this.f5422c;
        }
        int[] iArr = new int[i4 + 1];
        iArr[0] = i5;
        return new b(this, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i4) {
        return this.f5420a[i4];
    }

    public int d() {
        return this.f5426g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e() {
        return this.f5423d;
    }

    public int f() {
        return this.f5424e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g() {
        return this.f5422c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i4) {
        if (i4 != 0) {
            return this.f5420a[(this.f5424e - this.f5421b[i4]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i4) {
        if (i4 != 0) {
            return this.f5421b[i4];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(int i4, int i5) {
        if (i4 == 0 || i5 == 0) {
            return 0;
        }
        int[] iArr = this.f5420a;
        int[] iArr2 = this.f5421b;
        return iArr[(iArr2[i4] + iArr2[i5]) % (this.f5424e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f5425f) + ',' + this.f5424e + ')';
    }
}
