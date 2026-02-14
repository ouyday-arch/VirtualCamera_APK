package w1;

/* loaded from: classes.dex */
public final class k extends y {

    /* renamed from: i, reason: collision with root package name */
    private final int[] f6380i = new int[4];

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.y
    public int m(n1.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f6380i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l4 = aVar.l();
        int i4 = iArr[1];
        for (int i5 = 0; i5 < 4 && i4 < l4; i5++) {
            sb.append((char) (y.k(aVar, iArr2, i4, y.f6409g) + 48));
            for (int i6 : iArr2) {
                i4 += i6;
            }
        }
        int i7 = y.o(aVar, i4, true, y.f6407e)[1];
        for (int i8 = 0; i8 < 4 && i7 < l4; i8++) {
            sb.append((char) (y.k(aVar, iArr2, i7, y.f6409g) + 48));
            for (int i9 : iArr2) {
                i7 += i9;
            }
        }
        return i7;
    }

    @Override // w1.y
    g1.a r() {
        return g1.a.EAN_8;
    }
}
