package w1;

/* loaded from: classes.dex */
public final class a0 extends y {

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f6355j = {1, 1, 1, 1, 1, 1};

    /* renamed from: k, reason: collision with root package name */
    static final int[][] f6356k = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: i, reason: collision with root package name */
    private final int[] f6357i = new int[4];

    public static String t(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c5 = cArr[5];
        switch (c5) {
            case m0.k.s4 /* 48 */:
            case m0.k.t4 /* 49 */:
            case m0.k.u4 /* 50 */:
                sb.append(cArr, 0, 2);
                sb.append(c5);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case m0.k.v4 /* 51 */:
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c5);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    private static void u(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 <= 1; i5++) {
            for (int i6 = 0; i6 < 10; i6++) {
                if (i4 == f6356k[i5][i6]) {
                    sb.insert(0, (char) (i5 + 48));
                    sb.append((char) (i6 + 48));
                    return;
                }
            }
        }
        throw g1.m.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.y
    public boolean i(String str) {
        return super.i(t(str));
    }

    @Override // w1.y
    protected int[] l(n1.a aVar, int i4) {
        return y.o(aVar, i4, true, f6355j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.y
    public int m(n1.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f6357i;
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
        u(sb, i5);
        return i4;
    }

    @Override // w1.y
    g1.a r() {
        return g1.a.UPC_E;
    }
}
