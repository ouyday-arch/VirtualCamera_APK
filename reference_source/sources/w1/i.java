package w1;

/* loaded from: classes.dex */
public final class i extends y {

    /* renamed from: j, reason: collision with root package name */
    static final int[] f6378j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: i, reason: collision with root package name */
    private final int[] f6379i = new int[4];

    private static void t(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < 10; i5++) {
            if (i4 == f6378j[i5]) {
                sb.insert(0, (char) (i5 + 48));
                return;
            }
        }
        throw g1.m.a();
    }

    @Override // w1.y
    protected int m(n1.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f6379i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l4 = aVar.l();
        int i4 = iArr[1];
        int i5 = 0;
        for (int i6 = 0; i6 < 6 && i4 < l4; i6++) {
            int k4 = y.k(aVar, iArr2, i4, y.f6410h);
            sb.append((char) ((k4 % 10) + 48));
            for (int i7 : iArr2) {
                i4 += i7;
            }
            if (k4 >= 10) {
                i5 |= 1 << (5 - i6);
            }
        }
        t(sb, i5);
        int i8 = y.o(aVar, i4, true, y.f6407e)[1];
        for (int i9 = 0; i9 < 6 && i8 < l4; i9++) {
            sb.append((char) (y.k(aVar, iArr2, i8, y.f6409g) + 48));
            for (int i10 : iArr2) {
                i8 += i10;
            }
        }
        return i8;
    }

    @Override // w1.y
    g1.a r() {
        return g1.a.EAN_13;
    }
}
