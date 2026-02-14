package e2;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f3596a;

    /* renamed from: b, reason: collision with root package name */
    private int f3597b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i4) {
        this.f3596a = new byte[i4];
    }

    private void c(int i4, boolean z4) {
        this.f3596a[i4] = z4 ? (byte) 1 : (byte) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z4, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.f3597b;
            this.f3597b = i6 + 1;
            c(i6, z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b(int i4) {
        int length = this.f3596a.length * i4;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr[i5] = this.f3596a[i5 / i4];
        }
        return bArr;
    }
}
