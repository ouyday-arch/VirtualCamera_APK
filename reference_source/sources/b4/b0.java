package b4;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: h, reason: collision with root package name */
    public static final a f2299h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2300a;

    /* renamed from: b, reason: collision with root package name */
    public int f2301b;

    /* renamed from: c, reason: collision with root package name */
    public int f2302c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2303d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2304e;

    /* renamed from: f, reason: collision with root package name */
    public b0 f2305f;

    /* renamed from: g, reason: collision with root package name */
    public b0 f2306g;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    public b0() {
        this.f2300a = new byte[8192];
        this.f2304e = true;
        this.f2303d = false;
    }

    public b0(byte[] bArr, int i4, int i5, boolean z4, boolean z5) {
        e3.f.e(bArr, "data");
        this.f2300a = bArr;
        this.f2301b = i4;
        this.f2302c = i5;
        this.f2303d = z4;
        this.f2304e = z5;
    }

    public final void a() {
        b0 b0Var = this.f2306g;
        int i4 = 0;
        if (!(b0Var != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        e3.f.b(b0Var);
        if (b0Var.f2304e) {
            int i5 = this.f2302c - this.f2301b;
            b0 b0Var2 = this.f2306g;
            e3.f.b(b0Var2);
            int i6 = 8192 - b0Var2.f2302c;
            b0 b0Var3 = this.f2306g;
            e3.f.b(b0Var3);
            if (!b0Var3.f2303d) {
                b0 b0Var4 = this.f2306g;
                e3.f.b(b0Var4);
                i4 = b0Var4.f2301b;
            }
            if (i5 > i6 + i4) {
                return;
            }
            b0 b0Var5 = this.f2306g;
            e3.f.b(b0Var5);
            f(b0Var5, i5);
            b();
            c0.b(this);
        }
    }

    public final b0 b() {
        b0 b0Var = this.f2305f;
        if (b0Var == this) {
            b0Var = null;
        }
        b0 b0Var2 = this.f2306g;
        e3.f.b(b0Var2);
        b0Var2.f2305f = this.f2305f;
        b0 b0Var3 = this.f2305f;
        e3.f.b(b0Var3);
        b0Var3.f2306g = this.f2306g;
        this.f2305f = null;
        this.f2306g = null;
        return b0Var;
    }

    public final b0 c(b0 b0Var) {
        e3.f.e(b0Var, "segment");
        b0Var.f2306g = this;
        b0Var.f2305f = this.f2305f;
        b0 b0Var2 = this.f2305f;
        e3.f.b(b0Var2);
        b0Var2.f2306g = b0Var;
        this.f2305f = b0Var;
        return b0Var;
    }

    public final b0 d() {
        this.f2303d = true;
        return new b0(this.f2300a, this.f2301b, this.f2302c, true, false);
    }

    public final b0 e(int i4) {
        b0 c5;
        if (!(i4 > 0 && i4 <= this.f2302c - this.f2301b)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i4 >= 1024) {
            c5 = d();
        } else {
            c5 = c0.c();
            byte[] bArr = this.f2300a;
            byte[] bArr2 = c5.f2300a;
            int i5 = this.f2301b;
            v2.i.f(bArr, bArr2, 0, i5, i5 + i4, 2, null);
        }
        c5.f2302c = c5.f2301b + i4;
        this.f2301b += i4;
        b0 b0Var = this.f2306g;
        e3.f.b(b0Var);
        b0Var.c(c5);
        return c5;
    }

    public final void f(b0 b0Var, int i4) {
        e3.f.e(b0Var, "sink");
        if (!b0Var.f2304e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i5 = b0Var.f2302c;
        if (i5 + i4 > 8192) {
            if (b0Var.f2303d) {
                throw new IllegalArgumentException();
            }
            int i6 = b0Var.f2301b;
            if ((i5 + i4) - i6 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = b0Var.f2300a;
            v2.i.f(bArr, bArr, 0, i6, i5, 2, null);
            b0Var.f2302c -= b0Var.f2301b;
            b0Var.f2301b = 0;
        }
        byte[] bArr2 = this.f2300a;
        byte[] bArr3 = b0Var.f2300a;
        int i7 = b0Var.f2302c;
        int i8 = this.f2301b;
        v2.i.d(bArr2, bArr3, i7, i8, i8 + i4);
        b0Var.f2302c += i4;
        this.f2301b += i4;
    }
}
