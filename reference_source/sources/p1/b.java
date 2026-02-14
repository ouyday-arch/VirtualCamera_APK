package p1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final a f5427a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f5428b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f5427a = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f5428b = iArr;
            return;
        }
        int i4 = 1;
        while (i4 < length && iArr[i4] == 0) {
            i4++;
        }
        if (i4 == length) {
            this.f5428b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i4];
        this.f5428b = iArr2;
        System.arraycopy(iArr, i4, iArr2, 0, iArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(b bVar) {
        if (!this.f5427a.equals(bVar.f5427a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return bVar;
        }
        if (bVar.g()) {
            return this;
        }
        int[] iArr = this.f5428b;
        int[] iArr2 = bVar.f5428b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i4 = length; i4 < iArr.length; i4++) {
            iArr3[i4] = a.a(iArr2[i4 - length], iArr[i4]);
        }
        return new b(this.f5427a, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b[] b(b bVar) {
        if (!this.f5427a.equals(bVar.f5427a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b g4 = this.f5427a.g();
        int h4 = this.f5427a.h(bVar.d(bVar.f()));
        b bVar2 = this;
        while (bVar2.f() >= bVar.f() && !bVar2.g()) {
            int f4 = bVar2.f() - bVar.f();
            int j4 = this.f5427a.j(bVar2.d(bVar2.f()), h4);
            b j5 = bVar.j(f4, j4);
            g4 = g4.a(this.f5427a.b(f4, j4));
            bVar2 = bVar2.a(j5);
        }
        return new b[]{g4, bVar2};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i4) {
        if (i4 == 0) {
            return d(0);
        }
        if (i4 == 1) {
            int i5 = 0;
            for (int i6 : this.f5428b) {
                i5 = a.a(i5, i6);
            }
            return i5;
        }
        int[] iArr = this.f5428b;
        int i7 = iArr[0];
        int length = iArr.length;
        for (int i8 = 1; i8 < length; i8++) {
            i7 = a.a(this.f5427a.j(i4, i7), this.f5428b[i8]);
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i4) {
        return this.f5428b[(r0.length - 1) - i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] e() {
        return this.f5428b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f5428b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f5428b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(int i4) {
        if (i4 == 0) {
            return this.f5427a.g();
        }
        if (i4 == 1) {
            return this;
        }
        int length = this.f5428b.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = this.f5427a.j(this.f5428b[i5], i4);
        }
        return new b(this.f5427a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i(b bVar) {
        if (!this.f5427a.equals(bVar.f5427a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || bVar.g()) {
            return this.f5427a.g();
        }
        int[] iArr = this.f5428b;
        int length = iArr.length;
        int[] iArr2 = bVar.f5428b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            for (int i6 = 0; i6 < length2; i6++) {
                int i7 = i4 + i6;
                iArr3[i7] = a.a(iArr3[i7], this.f5427a.j(i5, iArr2[i6]));
            }
        }
        return new b(this.f5427a, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b j(int i4, int i5) {
        if (i4 < 0) {
            throw new IllegalArgumentException();
        }
        if (i5 == 0) {
            return this.f5427a.g();
        }
        int length = this.f5428b.length;
        int[] iArr = new int[i4 + length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = this.f5427a.j(this.f5428b[i6], i5);
        }
        return new b(this.f5427a, iArr);
    }

    public String toString() {
        char c5;
        if (g()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(f() * 8);
        int f4 = f();
        while (f4 >= 0) {
            int d5 = d(f4);
            if (d5 != 0) {
                if (d5 < 0) {
                    sb.append(f4 == f() ? "-" : " - ");
                    d5 = -d5;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (f4 == 0 || d5 != 1) {
                    int i4 = this.f5427a.i(d5);
                    if (i4 == 0) {
                        c5 = '1';
                    } else if (i4 == 1) {
                        c5 = 'a';
                    } else {
                        sb.append("a^");
                        sb.append(i4);
                    }
                    sb.append(c5);
                }
                if (f4 != 0) {
                    if (f4 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(f4);
                    }
                }
            }
            f4--;
        }
        return sb.toString();
    }
}
