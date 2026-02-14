package t1;

import java.util.Arrays;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f5917a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5918b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5919c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f5920d;

    public e(CharSequence charSequence, int i4, int i5) {
        this.f5917a = charSequence;
        this.f5919c = i4;
        this.f5918b = i5;
        byte[] bArr = new byte[i4 * i5];
        this.f5920d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void a(int i4) {
        f(this.f5918b - 1, 0, i4, 1);
        f(this.f5918b - 1, 1, i4, 2);
        f(this.f5918b - 1, 2, i4, 3);
        f(0, this.f5919c - 2, i4, 4);
        f(0, this.f5919c - 1, i4, 5);
        f(1, this.f5919c - 1, i4, 6);
        f(2, this.f5919c - 1, i4, 7);
        f(3, this.f5919c - 1, i4, 8);
    }

    private void b(int i4) {
        f(this.f5918b - 3, 0, i4, 1);
        f(this.f5918b - 2, 0, i4, 2);
        f(this.f5918b - 1, 0, i4, 3);
        f(0, this.f5919c - 4, i4, 4);
        f(0, this.f5919c - 3, i4, 5);
        f(0, this.f5919c - 2, i4, 6);
        f(0, this.f5919c - 1, i4, 7);
        f(1, this.f5919c - 1, i4, 8);
    }

    private void c(int i4) {
        f(this.f5918b - 3, 0, i4, 1);
        f(this.f5918b - 2, 0, i4, 2);
        f(this.f5918b - 1, 0, i4, 3);
        f(0, this.f5919c - 2, i4, 4);
        f(0, this.f5919c - 1, i4, 5);
        f(1, this.f5919c - 1, i4, 6);
        f(2, this.f5919c - 1, i4, 7);
        f(3, this.f5919c - 1, i4, 8);
    }

    private void d(int i4) {
        f(this.f5918b - 1, 0, i4, 1);
        f(this.f5918b - 1, this.f5919c - 1, i4, 2);
        f(0, this.f5919c - 3, i4, 3);
        f(0, this.f5919c - 2, i4, 4);
        f(0, this.f5919c - 1, i4, 5);
        f(1, this.f5919c - 3, i4, 6);
        f(1, this.f5919c - 2, i4, 7);
        f(1, this.f5919c - 1, i4, 8);
    }

    private void f(int i4, int i5, int i6, int i7) {
        if (i4 < 0) {
            int i8 = this.f5918b;
            i4 += i8;
            i5 += 4 - ((i8 + 4) % 8);
        }
        if (i5 < 0) {
            int i9 = this.f5919c;
            i5 += i9;
            i4 += 4 - ((i9 + 4) % 8);
        }
        i(i5, i4, (this.f5917a.charAt(i6) & (1 << (8 - i7))) != 0);
    }

    private boolean g(int i4, int i5) {
        return this.f5920d[(i5 * this.f5919c) + i4] < 0;
    }

    private void i(int i4, int i5, boolean z4) {
        this.f5920d[(i5 * this.f5919c) + i4] = z4 ? (byte) 1 : (byte) 0;
    }

    private void j(int i4, int i5, int i6) {
        int i7 = i4 - 2;
        int i8 = i5 - 2;
        f(i7, i8, i6, 1);
        int i9 = i5 - 1;
        f(i7, i9, i6, 2);
        int i10 = i4 - 1;
        f(i10, i8, i6, 3);
        f(i10, i9, i6, 4);
        f(i10, i5, i6, 5);
        f(i4, i8, i6, 6);
        f(i4, i9, i6, 7);
        f(i4, i5, i6, 8);
    }

    public final boolean e(int i4, int i5) {
        return this.f5920d[(i5 * this.f5919c) + i4] == 1;
    }

    public final void h() {
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 0;
        int i8 = 4;
        while (true) {
            if (i8 == this.f5918b && i6 == 0) {
                a(i7);
                i7++;
            }
            if (i8 == this.f5918b - 2 && i6 == 0 && this.f5919c % 4 != 0) {
                b(i7);
                i7++;
            }
            if (i8 == this.f5918b - 2 && i6 == 0 && this.f5919c % 8 == 4) {
                c(i7);
                i7++;
            }
            if (i8 == this.f5918b + 4 && i6 == 2 && this.f5919c % 8 == 0) {
                d(i7);
                i7++;
            }
            do {
                if (i8 < this.f5918b && i6 >= 0 && g(i6, i8)) {
                    j(i8, i6, i7);
                    i7++;
                }
                i8 -= 2;
                i6 += 2;
                if (i8 < 0) {
                    break;
                }
            } while (i6 < this.f5919c);
            int i9 = i8 + 1;
            int i10 = i6 + 3;
            do {
                if (i9 >= 0 && i10 < this.f5919c && g(i10, i9)) {
                    j(i9, i10, i7);
                    i7++;
                }
                i9 += 2;
                i10 -= 2;
                i4 = this.f5918b;
                if (i9 >= i4) {
                    break;
                }
            } while (i10 >= 0);
            i8 = i9 + 3;
            i6 = i10 + 1;
            if (i8 >= i4 && i6 >= (i5 = this.f5919c)) {
                break;
            }
        }
        if (g(i5 - 1, i4 - 1)) {
            i(this.f5919c - 1, this.f5918b - 1, true);
            i(this.f5919c - 2, this.f5918b - 2, true);
        }
    }
}
