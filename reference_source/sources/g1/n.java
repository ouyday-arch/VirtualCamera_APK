package g1;

/* loaded from: classes.dex */
public final class n extends j {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f3954c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3955d;

    /* renamed from: e, reason: collision with root package name */
    private final int f3956e;

    /* renamed from: f, reason: collision with root package name */
    private final int f3957f;

    /* renamed from: g, reason: collision with root package name */
    private final int f3958g;

    public n(byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, boolean z4) {
        super(i8, i9);
        if (i6 + i8 > i4 || i7 + i9 > i5) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f3954c = bArr;
        this.f3955d = i4;
        this.f3956e = i5;
        this.f3957f = i6;
        this.f3958g = i7;
        if (z4) {
            h(i8, i9);
        }
    }

    private void h(int i4, int i5) {
        byte[] bArr = this.f3954c;
        int i6 = (this.f3958g * this.f3955d) + this.f3957f;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = (i4 / 2) + i6;
            int i9 = (i6 + i4) - 1;
            int i10 = i6;
            while (i10 < i8) {
                byte b5 = bArr[i10];
                bArr[i10] = bArr[i9];
                bArr[i9] = b5;
                i10++;
                i9--;
            }
            i7++;
            i6 += this.f3955d;
        }
    }

    @Override // g1.j
    public byte[] b() {
        int d5 = d();
        int a5 = a();
        int i4 = this.f3955d;
        if (d5 == i4 && a5 == this.f3956e) {
            return this.f3954c;
        }
        int i5 = d5 * a5;
        byte[] bArr = new byte[i5];
        int i6 = (this.f3958g * i4) + this.f3957f;
        if (d5 == i4) {
            System.arraycopy(this.f3954c, i6, bArr, 0, i5);
            return bArr;
        }
        for (int i7 = 0; i7 < a5; i7++) {
            System.arraycopy(this.f3954c, i6, bArr, i7 * d5, d5);
            i6 += this.f3955d;
        }
        return bArr;
    }

    @Override // g1.j
    public byte[] c(int i4, byte[] bArr) {
        if (i4 < 0 || i4 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i4)));
        }
        int d5 = d();
        if (bArr == null || bArr.length < d5) {
            bArr = new byte[d5];
        }
        System.arraycopy(this.f3954c, ((i4 + this.f3958g) * this.f3955d) + this.f3957f, bArr, 0, d5);
        return bArr;
    }
}
