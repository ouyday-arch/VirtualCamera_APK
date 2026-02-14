package r1;

import a.j;
import g1.h;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: h, reason: collision with root package name */
    private static final e[] f5775h = a();

    /* renamed from: a, reason: collision with root package name */
    private final int f5776a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5777b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5778c;

    /* renamed from: d, reason: collision with root package name */
    private final int f5779d;

    /* renamed from: e, reason: collision with root package name */
    private final int f5780e;

    /* renamed from: f, reason: collision with root package name */
    private final c f5781f;

    /* renamed from: g, reason: collision with root package name */
    private final int f5782g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f5783a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5784b;

        private b(int i4, int i5) {
            this.f5783a = i4;
            this.f5784b = i5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            return this.f5783a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f5784b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final int f5785a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f5786b;

        private c(int i4, b bVar) {
            this.f5785a = i4;
            this.f5786b = new b[]{bVar};
        }

        private c(int i4, b bVar, b bVar2) {
            this.f5785a = i4;
            this.f5786b = new b[]{bVar, bVar2};
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b[] a() {
            return this.f5786b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f5785a;
        }
    }

    private e(int i4, int i5, int i6, int i7, int i8, c cVar) {
        this.f5776a = i4;
        this.f5777b = i5;
        this.f5778c = i6;
        this.f5779d = i7;
        this.f5780e = i8;
        this.f5781f = cVar;
        int b5 = cVar.b();
        int i9 = 0;
        for (b bVar : cVar.a()) {
            i9 += bVar.a() * (bVar.b() + b5);
        }
        this.f5782g = i9;
    }

    private static e[] a() {
        int i4 = 1;
        int i5 = 5;
        int i6 = 8;
        e eVar = new e(3, 14, 14, 12, 12, new c(10, new b(i4, i6)));
        int i7 = 2;
        int i8 = 12;
        int i9 = 18;
        e eVar2 = new e(7, 22, 22, 20, 20, new c(20, new b(i4, 30)));
        int i10 = 6;
        int i11 = 36;
        int i12 = 62;
        int i13 = 56;
        int i14 = 68;
        b bVar = new b(i4, 5);
        b bVar2 = new b(i4, 10);
        b bVar3 = new b(i4, 16);
        return new e[]{new e(1, 10, 10, 8, 8, new c(i5, new b(i4, 3))), new e(2, 12, 12, 10, 10, new c(7, new b(i4, i5))), eVar, new e(4, 16, 16, 14, 14, new c(i8, new b(i4, i8))), new e(5, 18, 18, 16, 16, new c(14, new b(i4, i9))), new e(6, 20, 20, 18, 18, new c(i9, new b(i4, 22))), eVar2, new e(8, 24, 24, 22, 22, new c(24, new b(i4, i11))), new e(9, 26, 26, 24, 24, new c(28, new b(i4, 44))), new e(10, 32, 32, 14, 14, new c(i11, new b(i4, i12))), new e(11, 36, 36, 16, 16, new c(42, new b(i4, 86))), new e(12, 40, 40, 18, 18, new c(48, new b(i4, j.D0))), new e(13, 44, 44, 20, 20, new c(i13, new b(i4, 144))), new e(14, 48, 48, 22, 22, new c(i14, new b(i4, 174))), new e(15, 52, 52, 24, 24, new c(42, new b(i7, 102))), new e(16, 64, 64, 14, 14, new c(i13, new b(i7, 140))), new e(17, 72, 72, 16, 16, new c(i11, new b(4, 92))), new e(18, 80, 80, 18, 18, new c(48, new b(4, j.D0))), new e(19, 88, 88, 20, 20, new c(i13, new b(4, 144))), new e(20, 96, 96, 22, 22, new c(i14, new b(4, 174))), new e(21, 104, 104, 24, 24, new c(i13, new b(i10, 136))), new e(22, j.J0, j.J0, 18, 18, new c(i14, new b(i10, 175))), new e(23, 132, 132, 20, 20, new c(i12, new b(i6, 163))), new e(24, 144, 144, 22, 22, new c(i12, new b(i6, 156), new b(i7, 155))), new e(25, 8, 18, 6, 16, new c(7, bVar)), new e(26, 8, 32, 6, 14, new c(11, bVar2)), new e(27, 12, 26, 10, 24, new c(14, bVar3)), new e(28, 12, 36, 10, 16, new c(i9, new b(i4, 22))), new e(29, 16, 36, 14, 16, new c(24, new b(i4, 32))), new e(30, 16, 48, 14, 22, new c(28, new b(i4, 49)))};
    }

    public static e h(int i4, int i5) {
        if ((i4 & 1) != 0 || (i5 & 1) != 0) {
            throw h.a();
        }
        for (e eVar : f5775h) {
            if (eVar.f5777b == i4 && eVar.f5778c == i5) {
                return eVar;
            }
        }
        throw h.a();
    }

    public int b() {
        return this.f5780e;
    }

    public int c() {
        return this.f5779d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        return this.f5781f;
    }

    public int e() {
        return this.f5778c;
    }

    public int f() {
        return this.f5777b;
    }

    public int g() {
        return this.f5782g;
    }

    public int i() {
        return this.f5776a;
    }

    public String toString() {
        return String.valueOf(this.f5776a);
    }
}
