package r1;

import g1.h;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final n1.b f5755a;

    /* renamed from: b, reason: collision with root package name */
    private final n1.b f5756b;

    /* renamed from: c, reason: collision with root package name */
    private final e f5757c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(n1.b bVar) {
        int h4 = bVar.h();
        if (h4 < 8 || h4 > 144 || (h4 & 1) != 0) {
            throw h.a();
        }
        this.f5757c = j(bVar);
        n1.b a5 = a(bVar);
        this.f5755a = a5;
        this.f5756b = new n1.b(a5.l(), a5.h());
    }

    private n1.b a(n1.b bVar) {
        int f4 = this.f5757c.f();
        int e4 = this.f5757c.e();
        if (bVar.h() != f4) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int c5 = this.f5757c.c();
        int b5 = this.f5757c.b();
        int i4 = f4 / c5;
        int i5 = e4 / b5;
        n1.b bVar2 = new n1.b(i5 * b5, i4 * c5);
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = i6 * c5;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = i8 * b5;
                for (int i10 = 0; i10 < c5; i10++) {
                    int i11 = ((c5 + 2) * i6) + 1 + i10;
                    int i12 = i7 + i10;
                    for (int i13 = 0; i13 < b5; i13++) {
                        if (bVar.e(((b5 + 2) * i8) + 1 + i13, i11)) {
                            bVar2.n(i9 + i13, i12);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    private int d(int i4, int i5) {
        int i6 = i4 - 1;
        int i7 = (h(i6, 0, i4, i5) ? 1 : 0) << 1;
        if (h(i6, 1, i4, i5)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (h(i6, 2, i4, i5)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (h(0, i5 - 2, i4, i5)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        int i11 = i5 - 1;
        if (h(0, i11, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (h(1, i11, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(2, i11, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return h(3, i11, i4, i5) ? i14 | 1 : i14;
    }

    private int e(int i4, int i5) {
        int i6 = (h(i4 + (-3), 0, i4, i5) ? 1 : 0) << 1;
        if (h(i4 - 2, 0, i4, i5)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(i4 - 1, 0, i4, i5)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (h(0, i5 - 4, i4, i5)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (h(0, i5 - 3, i4, i5)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(0, i5 - 2, i4, i5)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        int i12 = i5 - 1;
        if (h(0, i12, i4, i5)) {
            i11 |= 1;
        }
        int i13 = i11 << 1;
        return h(1, i12, i4, i5) ? i13 | 1 : i13;
    }

    private int f(int i4, int i5) {
        int i6 = i4 - 1;
        int i7 = (h(i6, 0, i4, i5) ? 1 : 0) << 1;
        int i8 = i5 - 1;
        if (h(i6, i8, i4, i5)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i5 - 3;
        if (h(0, i10, i4, i5)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        int i12 = i5 - 2;
        if (h(0, i12, i4, i5)) {
            i11 |= 1;
        }
        int i13 = i11 << 1;
        if (h(0, i8, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(1, i10, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(1, i12, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return h(1, i8, i4, i5) ? i16 | 1 : i16;
    }

    private int g(int i4, int i5) {
        int i6 = (h(i4 + (-3), 0, i4, i5) ? 1 : 0) << 1;
        if (h(i4 - 2, 0, i4, i5)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(i4 - 1, 0, i4, i5)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (h(0, i5 - 2, i4, i5)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        int i10 = i5 - 1;
        if (h(0, i10, i4, i5)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (h(1, i10, i4, i5)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(2, i10, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return h(3, i10, i4, i5) ? i13 | 1 : i13;
    }

    private boolean h(int i4, int i5, int i6, int i7) {
        if (i4 < 0) {
            i4 += i6;
            i5 += 4 - ((i6 + 4) & 7);
        }
        if (i5 < 0) {
            i5 += i7;
            i4 += 4 - ((i7 + 4) & 7);
        }
        this.f5756b.n(i5, i4);
        return this.f5755a.e(i5, i4);
    }

    private int i(int i4, int i5, int i6, int i7) {
        int i8 = i4 - 2;
        int i9 = i5 - 2;
        int i10 = (h(i8, i9, i6, i7) ? 1 : 0) << 1;
        int i11 = i5 - 1;
        if (h(i8, i11, i6, i7)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        int i13 = i4 - 1;
        if (h(i13, i9, i6, i7)) {
            i12 |= 1;
        }
        int i14 = i12 << 1;
        if (h(i13, i11, i6, i7)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(i13, i5, i6, i7)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (h(i4, i9, i6, i7)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        if (h(i4, i11, i6, i7)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        return h(i4, i5, i6, i7) ? i18 | 1 : i18;
    }

    private static e j(n1.b bVar) {
        return e.h(bVar.h(), bVar.l());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e b() {
        return this.f5757c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c() {
        byte[] bArr = new byte[this.f5757c.g()];
        int h4 = this.f5755a.h();
        int l4 = this.f5755a.l();
        int i4 = 0;
        int i5 = 4;
        boolean z4 = false;
        int i6 = 0;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            if (i5 == h4 && i4 == 0 && !z4) {
                bArr[i6] = (byte) d(h4, l4);
                i5 -= 2;
                i4 += 2;
                i6++;
                z4 = true;
            } else {
                int i7 = h4 - 2;
                if (i5 == i7 && i4 == 0 && (l4 & 3) != 0 && !z5) {
                    bArr[i6] = (byte) e(h4, l4);
                    i5 -= 2;
                    i4 += 2;
                    i6++;
                    z5 = true;
                } else if (i5 == h4 + 4 && i4 == 2 && (l4 & 7) == 0 && !z6) {
                    bArr[i6] = (byte) f(h4, l4);
                    i5 -= 2;
                    i4 += 2;
                    i6++;
                    z6 = true;
                } else if (i5 == i7 && i4 == 0 && (l4 & 7) == 4 && !z7) {
                    bArr[i6] = (byte) g(h4, l4);
                    i5 -= 2;
                    i4 += 2;
                    i6++;
                    z7 = true;
                } else {
                    do {
                        if (i5 < h4 && i4 >= 0 && !this.f5756b.e(i4, i5)) {
                            bArr[i6] = (byte) i(i5, i4, h4, l4);
                            i6++;
                        }
                        i5 -= 2;
                        i4 += 2;
                        if (i5 < 0) {
                            break;
                        }
                    } while (i4 < l4);
                    int i8 = i5 + 1;
                    int i9 = i4 + 3;
                    do {
                        if (i8 >= 0 && i9 < l4 && !this.f5756b.e(i9, i8)) {
                            bArr[i6] = (byte) i(i8, i9, h4, l4);
                            i6++;
                        }
                        i8 += 2;
                        i9 -= 2;
                        if (i8 >= h4) {
                            break;
                        }
                    } while (i9 >= 0);
                    i5 = i8 + 3;
                    i4 = i9 + 1;
                }
            }
            if (i5 >= h4 && i4 >= l4) {
                break;
            }
        }
        if (i6 == this.f5757c.g()) {
            return bArr;
        }
        throw h.a();
    }
}
