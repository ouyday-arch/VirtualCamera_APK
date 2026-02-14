package t3;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6202c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private int f6203a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f6204b = new int[10];

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    public final int a(int i4) {
        return this.f6204b[i4];
    }

    public final int b() {
        if ((this.f6203a & 2) != 0) {
            return this.f6204b[1];
        }
        return -1;
    }

    public final int c() {
        if ((this.f6203a & 128) != 0) {
            return this.f6204b[7];
        }
        return 65535;
    }

    public final int d() {
        if ((this.f6203a & 16) != 0) {
            return this.f6204b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int e(int i4) {
        return (this.f6203a & 32) != 0 ? this.f6204b[5] : i4;
    }

    public final boolean f(int i4) {
        return ((1 << i4) & this.f6203a) != 0;
    }

    public final void g(n nVar) {
        e3.f.e(nVar, "other");
        for (int i4 = 0; i4 < 10; i4++) {
            if (nVar.f(i4)) {
                h(i4, nVar.a(i4));
            }
        }
    }

    public final n h(int i4, int i5) {
        if (i4 >= 0) {
            int[] iArr = this.f6204b;
            if (i4 < iArr.length) {
                this.f6203a = (1 << i4) | this.f6203a;
                iArr[i4] = i5;
            }
        }
        return this;
    }

    public final int i() {
        return Integer.bitCount(this.f6203a);
    }
}
