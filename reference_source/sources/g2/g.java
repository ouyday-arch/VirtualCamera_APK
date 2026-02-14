package g2;

/* loaded from: classes.dex */
final class g {

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f4007c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a, reason: collision with root package name */
    private final f f4008a;

    /* renamed from: b, reason: collision with root package name */
    private final byte f4009b;

    private g(int i4) {
        this.f4008a = f.a((i4 >> 3) & 3);
        this.f4009b = (byte) (i4 & 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g a(int i4, int i5) {
        g b5 = b(i4, i5);
        return b5 != null ? b5 : b(i4 ^ 21522, i5 ^ 21522);
    }

    private static g b(int i4, int i5) {
        int e4;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int[] iArr : f4007c) {
            int i8 = iArr[0];
            if (i8 == i4 || i8 == i5) {
                return new g(iArr[1]);
            }
            int e5 = e(i4, i8);
            if (e5 < i6) {
                i7 = iArr[1];
                i6 = e5;
            }
            if (i4 != i5 && (e4 = e(i5, i8)) < i6) {
                i7 = iArr[1];
                i6 = e4;
            }
        }
        if (i6 <= 3) {
            return new g(i7);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i4, int i5) {
        return Integer.bitCount(i4 ^ i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte c() {
        return this.f4009b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f d() {
        return this.f4008a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f4008a == gVar.f4008a && this.f4009b == gVar.f4009b;
    }

    public int hashCode() {
        return (this.f4008a.ordinal() << 3) | this.f4009b;
    }
}
