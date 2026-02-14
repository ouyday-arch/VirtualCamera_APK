package n1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    private final int f5263b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5264c;

    /* renamed from: d, reason: collision with root package name */
    private final int f5265d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f5266e;

    public b(int i4) {
        this(i4, i4);
    }

    public b(int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f5263b = i4;
        this.f5264c = i5;
        int i6 = (i4 + 31) / 32;
        this.f5265d = i6;
        this.f5266e = new int[i6 * i5];
    }

    private b(int i4, int i5, int i6, int[] iArr) {
        this.f5263b = i4;
        this.f5264c = i5;
        this.f5265d = i6;
        this.f5266e = iArr;
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f5264c * (this.f5263b + 1));
        for (int i4 = 0; i4 < this.f5264c; i4++) {
            for (int i5 = 0; i5 < this.f5263b; i5++) {
                sb.append(e(i5, i4) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void b() {
        int length = this.f5266e.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f5266e[i4] = 0;
        }
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f5263b, this.f5264c, this.f5265d, (int[]) this.f5266e.clone());
    }

    public void d(int i4, int i5) {
        int i6 = (i5 * this.f5265d) + (i4 / 32);
        int[] iArr = this.f5266e;
        iArr[i6] = (1 << (i4 & 31)) ^ iArr[i6];
    }

    public boolean e(int i4, int i5) {
        return ((this.f5266e[(i5 * this.f5265d) + (i4 / 32)] >>> (i4 & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5263b == bVar.f5263b && this.f5264c == bVar.f5264c && this.f5265d == bVar.f5265d && Arrays.equals(this.f5266e, bVar.f5266e);
    }

    public int[] f() {
        int length = this.f5266e.length - 1;
        while (length >= 0 && this.f5266e[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i4 = this.f5265d;
        int i5 = length / i4;
        int i6 = (length % i4) << 5;
        int i7 = 31;
        while ((this.f5266e[length] >>> i7) == 0) {
            i7--;
        }
        return new int[]{i6 + i7, i5};
    }

    public int[] g() {
        int i4 = this.f5263b;
        int i5 = this.f5264c;
        int i6 = -1;
        int i7 = -1;
        for (int i8 = 0; i8 < this.f5264c; i8++) {
            int i9 = 0;
            while (true) {
                int i10 = this.f5265d;
                if (i9 < i10) {
                    int i11 = this.f5266e[(i10 * i8) + i9];
                    if (i11 != 0) {
                        if (i8 < i5) {
                            i5 = i8;
                        }
                        if (i8 > i7) {
                            i7 = i8;
                        }
                        int i12 = i9 << 5;
                        if (i12 < i4) {
                            int i13 = 0;
                            while ((i11 << (31 - i13)) == 0) {
                                i13++;
                            }
                            int i14 = i13 + i12;
                            if (i14 < i4) {
                                i4 = i14;
                            }
                        }
                        if (i12 + 31 > i6) {
                            int i15 = 31;
                            while ((i11 >>> i15) == 0) {
                                i15--;
                            }
                            int i16 = i12 + i15;
                            if (i16 > i6) {
                                i6 = i16;
                            }
                        }
                    }
                    i9++;
                }
            }
        }
        if (i6 < i4 || i7 < i5) {
            return null;
        }
        return new int[]{i4, i5, (i6 - i4) + 1, (i7 - i5) + 1};
    }

    public int h() {
        return this.f5264c;
    }

    public int hashCode() {
        int i4 = this.f5263b;
        return (((((((i4 * 31) + i4) * 31) + this.f5264c) * 31) + this.f5265d) * 31) + Arrays.hashCode(this.f5266e);
    }

    public a j(int i4, a aVar) {
        if (aVar == null || aVar.l() < this.f5263b) {
            aVar = new a(this.f5263b);
        } else {
            aVar.d();
        }
        int i5 = i4 * this.f5265d;
        for (int i6 = 0; i6 < this.f5265d; i6++) {
            aVar.r(i6 << 5, this.f5266e[i5 + i6]);
        }
        return aVar;
    }

    public int[] k() {
        int[] iArr;
        int i4 = 0;
        while (true) {
            iArr = this.f5266e;
            if (i4 >= iArr.length || iArr[i4] != 0) {
                break;
            }
            i4++;
        }
        if (i4 == iArr.length) {
            return null;
        }
        int i5 = this.f5265d;
        int i6 = i4 / i5;
        int i7 = (i4 % i5) << 5;
        int i8 = iArr[i4];
        int i9 = 0;
        while ((i8 << (31 - i9)) == 0) {
            i9++;
        }
        return new int[]{i7 + i9, i6};
    }

    public int l() {
        return this.f5263b;
    }

    public void m() {
        a aVar = new a(this.f5263b);
        a aVar2 = new a(this.f5263b);
        int i4 = (this.f5264c + 1) / 2;
        for (int i5 = 0; i5 < i4; i5++) {
            aVar = j(i5, aVar);
            int i6 = (this.f5264c - 1) - i5;
            aVar2 = j(i6, aVar2);
            aVar.p();
            aVar2.p();
            p(i5, aVar2);
            p(i6, aVar);
        }
    }

    public void n(int i4, int i5) {
        int i6 = (i5 * this.f5265d) + (i4 / 32);
        int[] iArr = this.f5266e;
        iArr[i6] = (1 << (i4 & 31)) | iArr[i6];
    }

    public void o(int i4, int i5, int i6, int i7) {
        if (i5 < 0 || i4 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i7 <= 0 || i6 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i8 = i6 + i4;
        int i9 = i7 + i5;
        if (i9 > this.f5264c || i8 > this.f5263b) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i5 < i9) {
            int i10 = this.f5265d * i5;
            for (int i11 = i4; i11 < i8; i11++) {
                int[] iArr = this.f5266e;
                int i12 = (i11 / 32) + i10;
                iArr[i12] = iArr[i12] | (1 << (i11 & 31));
            }
            i5++;
        }
    }

    public void p(int i4, a aVar) {
        int[] h4 = aVar.h();
        int[] iArr = this.f5266e;
        int i5 = this.f5265d;
        System.arraycopy(h4, 0, iArr, i4 * i5, i5);
    }

    public String q(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return q("X ", "  ");
    }
}
