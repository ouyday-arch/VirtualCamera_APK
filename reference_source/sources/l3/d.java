package l3;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: n, reason: collision with root package name */
    public static final b f4616n;

    /* renamed from: o, reason: collision with root package name */
    public static final d f4617o;

    /* renamed from: p, reason: collision with root package name */
    public static final d f4618p;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4619a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4620b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4621c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4622d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f4623e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f4624f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f4625g;

    /* renamed from: h, reason: collision with root package name */
    private final int f4626h;

    /* renamed from: i, reason: collision with root package name */
    private final int f4627i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f4628j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f4629k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f4630l;

    /* renamed from: m, reason: collision with root package name */
    private String f4631m;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4632a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f4633b;

        /* renamed from: c, reason: collision with root package name */
        private int f4634c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f4635d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f4636e = -1;

        /* renamed from: f, reason: collision with root package name */
        private boolean f4637f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f4638g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f4639h;

        public final d a() {
            return m3.f.a(this);
        }

        public final boolean b() {
            return this.f4639h;
        }

        public final int c() {
            return this.f4634c;
        }

        public final int d() {
            return this.f4635d;
        }

        public final int e() {
            return this.f4636e;
        }

        public final boolean f() {
            return this.f4632a;
        }

        public final boolean g() {
            return this.f4633b;
        }

        public final boolean h() {
            return this.f4638g;
        }

        public final boolean i() {
            return this.f4637f;
        }

        public final a j(int i4, k3.d dVar) {
            e3.f.e(dVar, "timeUnit");
            return m3.f.e(this, i4, dVar);
        }

        public final a k() {
            return m3.f.f(this);
        }

        public final a l() {
            return m3.f.g(this);
        }

        public final void m(int i4) {
            this.f4635d = i4;
        }

        public final void n(boolean z4) {
            this.f4632a = z4;
        }

        public final void o(boolean z4) {
            this.f4637f = z4;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }

        public final d a(u uVar) {
            e3.f.e(uVar, "headers");
            return m3.f.h(this, uVar);
        }
    }

    static {
        b bVar = new b(null);
        f4616n = bVar;
        f4617o = m3.f.d(bVar);
        f4618p = m3.f.c(bVar);
    }

    public d(boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, int i6, int i7, boolean z9, boolean z10, boolean z11, String str) {
        this.f4619a = z4;
        this.f4620b = z5;
        this.f4621c = i4;
        this.f4622d = i5;
        this.f4623e = z6;
        this.f4624f = z7;
        this.f4625g = z8;
        this.f4626h = i6;
        this.f4627i = i7;
        this.f4628j = z9;
        this.f4629k = z10;
        this.f4630l = z11;
        this.f4631m = str;
    }

    public final String a() {
        return this.f4631m;
    }

    public final boolean b() {
        return this.f4630l;
    }

    public final boolean c() {
        return this.f4623e;
    }

    public final boolean d() {
        return this.f4624f;
    }

    public final int e() {
        return this.f4621c;
    }

    public final int f() {
        return this.f4626h;
    }

    public final int g() {
        return this.f4627i;
    }

    public final boolean h() {
        return this.f4625g;
    }

    public final boolean i() {
        return this.f4619a;
    }

    public final boolean j() {
        return this.f4620b;
    }

    public final boolean k() {
        return this.f4629k;
    }

    public final boolean l() {
        return this.f4628j;
    }

    public final int m() {
        return this.f4622d;
    }

    public final void n(String str) {
        this.f4631m = str;
    }

    public String toString() {
        return m3.f.i(this);
    }
}
