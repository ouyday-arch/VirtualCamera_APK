package p2;

import android.graphics.Rect;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5459a;

    /* renamed from: b, reason: collision with root package name */
    private int f5460b;

    /* renamed from: c, reason: collision with root package name */
    private int f5461c;

    public n(byte[] bArr, int i4, int i5) {
        this.f5459a = bArr;
        this.f5460b = i4;
        this.f5461c = i5;
    }

    public static byte[] e(byte[] bArr, int i4, int i5) {
        int i6 = i4 * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = i6 - 1;
        for (int i8 = 0; i8 < i6; i8++) {
            bArr2[i7] = bArr[i8];
            i7--;
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, int i4, int i5) {
        int i6 = i4 * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = i6 - 1;
        for (int i8 = 0; i8 < i4; i8++) {
            for (int i9 = i5 - 1; i9 >= 0; i9--) {
                bArr2[i7] = bArr[(i9 * i4) + i8];
                i7--;
            }
        }
        return bArr2;
    }

    public static byte[] g(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = new byte[i4 * i5];
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = i5 - 1; i8 >= 0; i8--) {
                bArr2[i6] = bArr[(i8 * i4) + i7];
                i6++;
            }
        }
        return bArr2;
    }

    public n a(Rect rect, int i4) {
        int width = rect.width() / i4;
        int height = rect.height() / i4;
        int i5 = rect.top;
        byte[] bArr = new byte[width * height];
        if (i4 == 1) {
            int i6 = (i5 * this.f5460b) + rect.left;
            for (int i7 = 0; i7 < height; i7++) {
                System.arraycopy(this.f5459a, i6, bArr, i7 * width, width);
                i6 += this.f5460b;
            }
        } else {
            int i8 = (i5 * this.f5460b) + rect.left;
            for (int i9 = 0; i9 < height; i9++) {
                int i10 = i9 * width;
                int i11 = i8;
                for (int i12 = 0; i12 < width; i12++) {
                    bArr[i10] = this.f5459a[i11];
                    i11 += i4;
                    i10++;
                }
                i8 += this.f5460b * i4;
            }
        }
        return new n(bArr, width, height);
    }

    public byte[] b() {
        return this.f5459a;
    }

    public int c() {
        return this.f5461c;
    }

    public int d() {
        return this.f5460b;
    }

    public n h(int i4) {
        return i4 != 90 ? i4 != 180 ? i4 != 270 ? this : new n(f(this.f5459a, this.f5460b, this.f5461c), this.f5461c, this.f5460b) : new n(e(this.f5459a, this.f5460b, this.f5461c), this.f5460b, this.f5461c) : new n(g(this.f5459a, this.f5460b, this.f5461c), this.f5461c, this.f5460b);
    }
}
