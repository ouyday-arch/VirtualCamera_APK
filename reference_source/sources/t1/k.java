package t1;

/* loaded from: classes.dex */
public class k {

    /* renamed from: i, reason: collision with root package name */
    static final k[] f5934i;

    /* renamed from: j, reason: collision with root package name */
    private static k[] f5935j;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5936a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5937b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5938c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5939d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5940e;

    /* renamed from: f, reason: collision with root package name */
    private final int f5941f;

    /* renamed from: g, reason: collision with root package name */
    private final int f5942g;

    /* renamed from: h, reason: collision with root package name */
    private final int f5943h;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, a.j.D0, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, a.j.D0, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, 408, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f5934i = kVarArr;
        f5935j = kVarArr;
    }

    public k(boolean z4, int i4, int i5, int i6, int i7, int i8) {
        this(z4, i4, i5, i6, i7, i8, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(boolean z4, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f5936a = z4;
        this.f5937b = i4;
        this.f5938c = i5;
        this.f5939d = i6;
        this.f5940e = i7;
        this.f5941f = i8;
        this.f5942g = i9;
        this.f5943h = i10;
    }

    private int e() {
        int i4 = this.f5941f;
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
            if (i4 != 2 && i4 != 4) {
                if (i4 == 16) {
                    return 4;
                }
                if (i4 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i5;
    }

    private int k() {
        int i4 = this.f5941f;
        if (i4 == 1 || i4 == 2) {
            return 1;
        }
        if (i4 == 4) {
            return 2;
        }
        if (i4 == 16) {
            return 4;
        }
        if (i4 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public static k l(int i4, l lVar, g1.f fVar, g1.f fVar2, boolean z4) {
        for (k kVar : f5935j) {
            if (!(lVar == l.FORCE_SQUARE && kVar.f5936a) && ((lVar != l.FORCE_RECTANGLE || kVar.f5936a) && ((fVar == null || (kVar.j() >= fVar.b() && kVar.i() >= fVar.a())) && ((fVar2 == null || (kVar.j() <= fVar2.b() && kVar.i() <= fVar2.a())) && i4 <= kVar.f5937b)))) {
                return kVar;
            }
        }
        if (z4) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i4)));
        }
        return null;
    }

    public final int a() {
        return this.f5937b;
    }

    public int b(int i4) {
        return this.f5942g;
    }

    public final int c() {
        return this.f5938c;
    }

    public final int d(int i4) {
        return this.f5943h;
    }

    public int f() {
        return this.f5937b / this.f5942g;
    }

    public final int g() {
        return k() * this.f5940e;
    }

    public final int h() {
        return e() * this.f5939d;
    }

    public final int i() {
        return g() + (k() << 1);
    }

    public final int j() {
        return h() + (e() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5936a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f5939d);
        sb.append('x');
        sb.append(this.f5940e);
        sb.append(", symbol size ");
        sb.append(j());
        sb.append('x');
        sb.append(i());
        sb.append(", symbol data size ");
        sb.append(h());
        sb.append('x');
        sb.append(g());
        sb.append(", codewords ");
        sb.append(this.f5937b);
        sb.append('+');
        sb.append(this.f5938c);
        return sb.toString();
    }
}
