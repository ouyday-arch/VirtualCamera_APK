package n1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    private int[] f5261b;

    /* renamed from: c, reason: collision with root package name */
    private int f5262c;

    public a() {
        this.f5262c = 0;
        this.f5261b = new int[1];
    }

    public a(int i4) {
        this.f5262c = i4;
        this.f5261b = o(i4);
    }

    a(int[] iArr, int i4) {
        this.f5261b = iArr;
        this.f5262c = i4;
    }

    private void f(int i4) {
        if (i4 > (this.f5261b.length << 5)) {
            int[] o4 = o(i4);
            int[] iArr = this.f5261b;
            System.arraycopy(iArr, 0, o4, 0, iArr.length);
            this.f5261b = o4;
        }
    }

    private static int[] o(int i4) {
        return new int[(i4 + 31) / 32];
    }

    public void a(boolean z4) {
        f(this.f5262c + 1);
        if (z4) {
            int[] iArr = this.f5261b;
            int i4 = this.f5262c;
            int i5 = i4 / 32;
            iArr[i5] = (1 << (i4 & 31)) | iArr[i5];
        }
        this.f5262c++;
    }

    public void b(a aVar) {
        int i4 = aVar.f5262c;
        f(this.f5262c + i4);
        for (int i5 = 0; i5 < i4; i5++) {
            a(aVar.g(i5));
        }
    }

    public void c(int i4, int i5) {
        if (i5 < 0 || i5 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        f(this.f5262c + i5);
        while (i5 > 0) {
            boolean z4 = true;
            if (((i4 >> (i5 - 1)) & 1) != 1) {
                z4 = false;
            }
            a(z4);
            i5--;
        }
    }

    public void d() {
        int length = this.f5261b.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f5261b[i4] = 0;
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f5261b.clone(), this.f5262c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5262c == aVar.f5262c && Arrays.equals(this.f5261b, aVar.f5261b);
    }

    public boolean g(int i4) {
        return ((1 << (i4 & 31)) & this.f5261b[i4 / 32]) != 0;
    }

    public int[] h() {
        return this.f5261b;
    }

    public int hashCode() {
        return (this.f5262c * 31) + Arrays.hashCode(this.f5261b);
    }

    public int j(int i4) {
        int i5 = this.f5262c;
        if (i4 >= i5) {
            return i5;
        }
        int i6 = i4 / 32;
        int i7 = (-(1 << (i4 & 31))) & this.f5261b[i6];
        while (i7 == 0) {
            i6++;
            int[] iArr = this.f5261b;
            if (i6 == iArr.length) {
                return this.f5262c;
            }
            i7 = iArr[i6];
        }
        return Math.min((i6 << 5) + Integer.numberOfTrailingZeros(i7), this.f5262c);
    }

    public int k(int i4) {
        int i5 = this.f5262c;
        if (i4 >= i5) {
            return i5;
        }
        int i6 = i4 / 32;
        int i7 = (-(1 << (i4 & 31))) & (~this.f5261b[i6]);
        while (i7 == 0) {
            i6++;
            int[] iArr = this.f5261b;
            if (i6 == iArr.length) {
                return this.f5262c;
            }
            i7 = ~iArr[i6];
        }
        return Math.min((i6 << 5) + Integer.numberOfTrailingZeros(i7), this.f5262c);
    }

    public int l() {
        return this.f5262c;
    }

    public int m() {
        return (this.f5262c + 7) / 8;
    }

    public boolean n(int i4, int i5, boolean z4) {
        if (i5 < i4 || i4 < 0 || i5 > this.f5262c) {
            throw new IllegalArgumentException();
        }
        if (i5 == i4) {
            return true;
        }
        int i6 = i5 - 1;
        int i7 = i4 / 32;
        int i8 = i6 / 32;
        int i9 = i7;
        while (i9 <= i8) {
            int i10 = (2 << (i9 >= i8 ? 31 & i6 : 31)) - (1 << (i9 > i7 ? 0 : i4 & 31));
            int i11 = this.f5261b[i9] & i10;
            if (!z4) {
                i10 = 0;
            }
            if (i11 != i10) {
                return false;
            }
            i9++;
        }
        return true;
    }

    public void p() {
        int[] iArr = new int[this.f5261b.length];
        int i4 = (this.f5262c - 1) / 32;
        int i5 = i4 + 1;
        for (int i6 = 0; i6 < i5; i6++) {
            long j4 = this.f5261b[i6];
            long j5 = ((j4 & 1431655765) << 1) | ((j4 >> 1) & 1431655765);
            long j6 = ((j5 & 858993459) << 2) | ((j5 >> 2) & 858993459);
            long j7 = ((j6 & 252645135) << 4) | ((j6 >> 4) & 252645135);
            long j8 = ((j7 & 16711935) << 8) | ((j7 >> 8) & 16711935);
            iArr[i4 - i6] = (int) (((j8 & 65535) << 16) | ((j8 >> 16) & 65535));
        }
        int i7 = this.f5262c;
        int i8 = i5 << 5;
        if (i7 != i8) {
            int i9 = i8 - i7;
            int i10 = iArr[0] >>> i9;
            for (int i11 = 1; i11 < i5; i11++) {
                int i12 = iArr[i11];
                iArr[i11 - 1] = i10 | (i12 << (32 - i9));
                i10 = i12 >>> i9;
            }
            iArr[i5 - 1] = i10;
        }
        this.f5261b = iArr;
    }

    public void q(int i4) {
        int[] iArr = this.f5261b;
        int i5 = i4 / 32;
        iArr[i5] = (1 << (i4 & 31)) | iArr[i5];
    }

    public void r(int i4, int i5) {
        this.f5261b[i4 / 32] = i5;
    }

    public void s(int i4, byte[] bArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < 8; i9++) {
                if (g(i4)) {
                    i8 |= 1 << (7 - i9);
                }
                i4++;
            }
            bArr[i5 + i7] = (byte) i8;
        }
    }

    public void t(a aVar) {
        if (this.f5262c != aVar.f5262c) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i4 = 0;
        while (true) {
            int[] iArr = this.f5261b;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = iArr[i4] ^ aVar.f5261b[i4];
            i4++;
        }
    }

    public String toString() {
        int i4 = this.f5262c;
        StringBuilder sb = new StringBuilder(i4 + (i4 / 8) + 1);
        for (int i5 = 0; i5 < this.f5262c; i5++) {
            if ((i5 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(g(i5) ? 'X' : '.');
        }
        return sb.toString();
    }
}
