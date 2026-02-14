package w1;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class y extends r {

    /* renamed from: d, reason: collision with root package name */
    static final int[] f6406d = {1, 1, 1};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f6407e = {1, 1, 1, 1, 1};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f6408f = {1, 1, 1, 1, 1, 1};

    /* renamed from: g, reason: collision with root package name */
    static final int[][] f6409g;

    /* renamed from: h, reason: collision with root package name */
    static final int[][] f6410h;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f6411a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private final x f6412b = new x();

    /* renamed from: c, reason: collision with root package name */
    private final m f6413c = new m();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f6409g = iArr;
        int[][] iArr2 = new int[20];
        f6410h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i4 = 10; i4 < 20; i4++) {
            int[] iArr3 = f6409g[i4 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i5 = 0; i5 < iArr3.length; i5++) {
                iArr4[i5] = iArr3[(iArr3.length - i5) - 1];
            }
            f6410h[i4] = iArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i4 = length - 1;
        return s(charSequence.subSequence(0, i4)) == Character.digit(charSequence.charAt(i4), 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(n1.a aVar, int[] iArr, int i4, int[][] iArr2) {
        r.g(aVar, i4, iArr);
        int length = iArr2.length;
        float f4 = 0.48f;
        int i5 = -1;
        for (int i6 = 0; i6 < length; i6++) {
            float f5 = r.f(iArr, iArr2[i6], 0.7f);
            if (f5 < f4) {
                i5 = i6;
                f4 = f5;
            }
        }
        if (i5 >= 0) {
            return i5;
        }
        throw g1.m.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] o(n1.a aVar, int i4, boolean z4, int[] iArr) {
        return p(aVar, i4, z4, iArr, new int[iArr.length]);
    }

    private static int[] p(n1.a aVar, int i4, boolean z4, int[] iArr, int[] iArr2) {
        int l4 = aVar.l();
        int k4 = z4 ? aVar.k(i4) : aVar.j(i4);
        int length = iArr.length;
        boolean z5 = z4;
        int i5 = 0;
        int i6 = k4;
        while (k4 < l4) {
            if (aVar.g(k4) != z5) {
                iArr2[i5] = iArr2[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else {
                    if (r.f(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i6, k4};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i7 = i5 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i7);
                    iArr2[i7] = 0;
                    iArr2[i5] = 0;
                    i5--;
                }
                iArr2[i5] = 1;
                z5 = !z5;
            }
            k4++;
        }
        throw g1.m.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] q(n1.a aVar) {
        int[] iArr = new int[f6406d.length];
        int[] iArr2 = null;
        boolean z4 = false;
        int i4 = 0;
        while (!z4) {
            int[] iArr3 = f6406d;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = p(aVar, i4, false, iArr3, iArr);
            int i5 = iArr2[0];
            int i6 = iArr2[1];
            int i7 = i5 - (i6 - i5);
            if (i7 >= 0) {
                z4 = aVar.n(i7, i5, false);
            }
            i4 = i6;
        }
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            int charAt = charSequence.charAt(i5) - '0';
            if (charAt < 0 || charAt > 9) {
                throw g1.h.a();
            }
            i4 += charAt;
        }
        int i6 = i4 * 3;
        for (int i7 = length - 2; i7 >= 0; i7 -= 2) {
            int charAt2 = charSequence.charAt(i7) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw g1.h.a();
            }
            i6 += charAt2;
        }
        return (1000 - i6) % 10;
    }

    @Override // w1.r
    public g1.q d(int i4, n1.a aVar, Map<g1.e, ?> map) {
        return n(i4, aVar, q(aVar), map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(String str) {
        return j(str);
    }

    int[] l(n1.a aVar, int i4) {
        return o(aVar, i4, false, f6406d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int m(n1.a aVar, int[] iArr, StringBuilder sb);

    public g1.q n(int i4, n1.a aVar, int[] iArr, Map<g1.e, ?> map) {
        int i5;
        String c5;
        g1.t tVar = map == null ? null : (g1.t) map.get(g1.e.NEED_RESULT_POINT_CALLBACK);
        boolean z4 = true;
        if (tVar != null) {
            tVar.a(new g1.s((iArr[0] + iArr[1]) / 2.0f, i4));
        }
        StringBuilder sb = this.f6411a;
        sb.setLength(0);
        int m4 = m(aVar, iArr, sb);
        if (tVar != null) {
            tVar.a(new g1.s(m4, i4));
        }
        int[] l4 = l(aVar, m4);
        if (tVar != null) {
            tVar.a(new g1.s((l4[0] + l4[1]) / 2.0f, i4));
        }
        int i6 = l4[1];
        int i7 = (i6 - l4[0]) + i6;
        if (i7 >= aVar.l() || !aVar.n(i6, i7, false)) {
            throw g1.m.a();
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw g1.h.a();
        }
        if (!i(sb2)) {
            throw g1.d.a();
        }
        g1.a r4 = r();
        float f4 = i4;
        g1.q qVar = new g1.q(sb2, null, new g1.s[]{new g1.s((iArr[1] + iArr[0]) / 2.0f, f4), new g1.s((l4[1] + l4[0]) / 2.0f, f4)}, r4);
        try {
            g1.q a5 = this.f6412b.a(i4, aVar, l4[1]);
            qVar.h(g1.r.UPC_EAN_EXTENSION, a5.f());
            qVar.g(a5.d());
            qVar.a(a5.e());
            i5 = a5.f().length();
        } catch (g1.p unused) {
            i5 = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(g1.e.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length = iArr2.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    z4 = false;
                    break;
                }
                if (i5 == iArr2[i8]) {
                    break;
                }
                i8++;
            }
            if (!z4) {
                throw g1.m.a();
            }
        }
        if ((r4 == g1.a.EAN_13 || r4 == g1.a.UPC_A) && (c5 = this.f6413c.c(sb2)) != null) {
            qVar.h(g1.r.POSSIBLE_COUNTRY, c5);
        }
        return qVar;
    }

    abstract g1.a r();
}
