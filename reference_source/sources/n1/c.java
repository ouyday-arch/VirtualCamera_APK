package n1;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f5267a;

    /* renamed from: b, reason: collision with root package name */
    private int f5268b;

    /* renamed from: c, reason: collision with root package name */
    private int f5269c;

    public c(byte[] bArr) {
        this.f5267a = bArr;
    }

    public int a() {
        return ((this.f5267a.length - this.f5268b) * 8) - this.f5269c;
    }

    public int b() {
        return this.f5269c;
    }

    public int c() {
        return this.f5268b;
    }

    public int d(int i4) {
        if (i4 <= 0 || i4 > 32 || i4 > a()) {
            throw new IllegalArgumentException(String.valueOf(i4));
        }
        int i5 = this.f5269c;
        int i6 = 0;
        if (i5 > 0) {
            int i7 = 8 - i5;
            int min = Math.min(i4, i7);
            int i8 = i7 - min;
            byte[] bArr = this.f5267a;
            int i9 = this.f5268b;
            int i10 = (((255 >> (8 - min)) << i8) & bArr[i9]) >> i8;
            i4 -= min;
            int i11 = this.f5269c + min;
            this.f5269c = i11;
            if (i11 == 8) {
                this.f5269c = 0;
                this.f5268b = i9 + 1;
            }
            i6 = i10;
        }
        if (i4 <= 0) {
            return i6;
        }
        while (i4 >= 8) {
            int i12 = i6 << 8;
            byte[] bArr2 = this.f5267a;
            int i13 = this.f5268b;
            i6 = (bArr2[i13] & 255) | i12;
            this.f5268b = i13 + 1;
            i4 -= 8;
        }
        if (i4 <= 0) {
            return i6;
        }
        int i14 = 8 - i4;
        int i15 = (i6 << i4) | ((((255 >> i14) << i14) & this.f5267a[this.f5268b]) >> i14);
        this.f5269c += i4;
        return i15;
    }
}
