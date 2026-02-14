package c2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final b f2452a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f2453b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f2452a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f2453b = iArr;
            return;
        }
        int i4 = 1;
        while (i4 < length && iArr[i4] == 0) {
            i4++;
        }
        if (i4 == length) {
            this.f2453b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i4];
        this.f2453b = iArr2;
        System.arraycopy(iArr, i4, iArr2, 0, iArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(c cVar) {
        if (!this.f2452a.equals(cVar.f2452a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e()) {
            return cVar;
        }
        if (cVar.e()) {
            return this;
        }
        int[] iArr = this.f2453b;
        int[] iArr2 = cVar.f2453b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i4 = length; i4 < iArr.length; i4++) {
            iArr3[i4] = this.f2452a.a(iArr2[i4 - length], iArr[i4]);
        }
        return new c(this.f2452a, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i4) {
        if (i4 == 0) {
            return c(0);
        }
        if (i4 == 1) {
            int i5 = 0;
            for (int i6 : this.f2453b) {
                i5 = this.f2452a.a(i5, i6);
            }
            return i5;
        }
        int[] iArr = this.f2453b;
        int i7 = iArr[0];
        int length = iArr.length;
        for (int i8 = 1; i8 < length; i8++) {
            b bVar = this.f2452a;
            i7 = bVar.a(bVar.i(i4, i7), this.f2453b[i8]);
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i4) {
        return this.f2453b[(r0.length - 1) - i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f2453b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f2453b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c f(int i4) {
        if (i4 == 0) {
            return this.f2452a.f();
        }
        if (i4 == 1) {
            return this;
        }
        int length = this.f2453b.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = this.f2452a.i(this.f2453b[i5], i4);
        }
        return new c(this.f2452a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c g(c cVar) {
        if (!this.f2452a.equals(cVar.f2452a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e() || cVar.e()) {
            return this.f2452a.f();
        }
        int[] iArr = this.f2453b;
        int length = iArr.length;
        int[] iArr2 = cVar.f2453b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            for (int i6 = 0; i6 < length2; i6++) {
                int i7 = i4 + i6;
                b bVar = this.f2452a;
                iArr3[i7] = bVar.a(iArr3[i7], bVar.i(i5, iArr2[i6]));
            }
        }
        return new c(this.f2452a, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c h(int i4, int i5) {
        if (i4 < 0) {
            throw new IllegalArgumentException();
        }
        if (i5 == 0) {
            return this.f2452a.f();
        }
        int length = this.f2453b.length;
        int[] iArr = new int[i4 + length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = this.f2452a.i(this.f2453b[i6], i5);
        }
        return new c(this.f2452a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c i() {
        int length = this.f2453b.length;
        int[] iArr = new int[length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.f2452a.j(0, this.f2453b[i4]);
        }
        return new c(this.f2452a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c j(c cVar) {
        if (this.f2452a.equals(cVar.f2452a)) {
            return cVar.e() ? this : a(cVar.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int d5 = d(); d5 >= 0; d5--) {
            int c5 = c(d5);
            if (c5 != 0) {
                if (c5 < 0) {
                    sb.append(" - ");
                    c5 = -c5;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (d5 == 0 || c5 != 1) {
                    sb.append(c5);
                }
                if (d5 != 0) {
                    if (d5 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(d5);
                    }
                }
            }
        }
        return sb.toString();
    }
}
