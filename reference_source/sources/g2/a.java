package g2;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final n1.b f3982a;

    /* renamed from: b, reason: collision with root package name */
    private j f3983b;

    /* renamed from: c, reason: collision with root package name */
    private g f3984c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3985d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(n1.b bVar) {
        int h4 = bVar.h();
        if (h4 < 21 || (h4 & 3) != 1) {
            throw g1.h.a();
        }
        this.f3982a = bVar;
    }

    private int a(int i4, int i5, int i6) {
        return this.f3985d ? this.f3982a.e(i5, i4) : this.f3982a.e(i4, i5) ? (i6 << 1) | 1 : i6 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i4 = 0;
        while (i4 < this.f3982a.l()) {
            int i5 = i4 + 1;
            for (int i6 = i5; i6 < this.f3982a.h(); i6++) {
                if (this.f3982a.e(i4, i6) != this.f3982a.e(i6, i4)) {
                    this.f3982a.d(i6, i4);
                    this.f3982a.d(i4, i6);
                }
            }
            i4 = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c() {
        g d5 = d();
        j e4 = e();
        c cVar = c.values()[d5.c()];
        int h4 = this.f3982a.h();
        cVar.b(this.f3982a, h4);
        n1.b a5 = e4.a();
        byte[] bArr = new byte[e4.h()];
        int i4 = h4 - 1;
        boolean z4 = true;
        int i5 = i4;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 > 0) {
            if (i5 == 6) {
                i5--;
            }
            for (int i9 = 0; i9 < h4; i9++) {
                int i10 = z4 ? i4 - i9 : i9;
                for (int i11 = 0; i11 < 2; i11++) {
                    int i12 = i5 - i11;
                    if (!a5.e(i12, i10)) {
                        i7++;
                        i8 <<= 1;
                        if (this.f3982a.e(i12, i10)) {
                            i8 |= 1;
                        }
                        if (i7 == 8) {
                            bArr[i6] = (byte) i8;
                            i6++;
                            i7 = 0;
                            i8 = 0;
                        }
                    }
                }
            }
            z4 = !z4;
            i5 -= 2;
        }
        if (i6 == e4.h()) {
            return bArr;
        }
        throw g1.h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g d() {
        g gVar = this.f3984c;
        if (gVar != null) {
            return gVar;
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < 6; i6++) {
            i5 = a(i6, 8, i5);
        }
        int a5 = a(8, 7, a(8, 8, a(7, 8, i5)));
        for (int i7 = 5; i7 >= 0; i7--) {
            a5 = a(8, i7, a5);
        }
        int h4 = this.f3982a.h();
        int i8 = h4 - 7;
        for (int i9 = h4 - 1; i9 >= i8; i9--) {
            i4 = a(8, i9, i4);
        }
        for (int i10 = h4 - 8; i10 < h4; i10++) {
            i4 = a(i10, 8, i4);
        }
        g a6 = g.a(a5, i4);
        this.f3984c = a6;
        if (a6 != null) {
            return a6;
        }
        throw g1.h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j e() {
        j jVar = this.f3983b;
        if (jVar != null) {
            return jVar;
        }
        int h4 = this.f3982a.h();
        int i4 = (h4 - 17) / 4;
        if (i4 <= 6) {
            return j.i(i4);
        }
        int i5 = h4 - 11;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 5; i8 >= 0; i8--) {
            for (int i9 = h4 - 9; i9 >= i5; i9--) {
                i7 = a(i9, i8, i7);
            }
        }
        j c5 = j.c(i7);
        if (c5 != null && c5.e() == h4) {
            this.f3983b = c5;
            return c5;
        }
        for (int i10 = 5; i10 >= 0; i10--) {
            for (int i11 = h4 - 9; i11 >= i5; i11--) {
                i6 = a(i10, i11, i6);
            }
        }
        j c6 = j.c(i6);
        if (c6 == null || c6.e() != h4) {
            throw g1.h.a();
        }
        this.f3983b = c6;
        return c6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.f3984c == null) {
            return;
        }
        c.values()[this.f3984c.c()].b(this.f3982a, this.f3982a.h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(boolean z4) {
        this.f3983b = null;
        this.f3984c = null;
        this.f3985d = z4;
    }
}
