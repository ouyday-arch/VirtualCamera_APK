package w1;

import java.util.Map;

/* loaded from: classes.dex */
public final class n extends r {

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f6383b = {6, 8, 10, 12, 14};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f6384c = {1, 1, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f6385d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: e, reason: collision with root package name */
    private static final int[][] f6386e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a, reason: collision with root package name */
    private int f6387a = -1;

    private static int i(int[] iArr) {
        int length = f6386e.length;
        float f4 = 0.38f;
        int i4 = -1;
        for (int i5 = 0; i5 < length; i5++) {
            float f5 = r.f(iArr, f6386e[i5], 0.5f);
            if (f5 < f4) {
                i4 = i5;
                f4 = f5;
            } else if (f5 == f4) {
                i4 = -1;
            }
        }
        if (i4 >= 0) {
            return i4 % 10;
        }
        throw g1.m.a();
    }

    private int[] j(n1.a aVar) {
        int[] m4;
        aVar.p();
        try {
            int n4 = n(aVar);
            try {
                m4 = m(aVar, n4, f6385d[0]);
            } catch (g1.m unused) {
                m4 = m(aVar, n4, f6385d[1]);
            }
            o(aVar, m4[0]);
            int i4 = m4[0];
            m4[0] = aVar.l() - m4[1];
            m4[1] = aVar.l() - i4;
            return m4;
        } finally {
            aVar.p();
        }
    }

    private static void k(n1.a aVar, int i4, int i5, StringBuilder sb) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i4 < i5) {
            r.g(aVar, i4, iArr);
            for (int i6 = 0; i6 < 5; i6++) {
                int i7 = i6 * 2;
                iArr2[i6] = iArr[i7];
                iArr3[i6] = iArr[i7 + 1];
            }
            sb.append((char) (i(iArr2) + 48));
            sb.append((char) (i(iArr3) + 48));
            for (int i8 = 0; i8 < 10; i8++) {
                i4 += iArr[i8];
            }
        }
    }

    private int[] l(n1.a aVar) {
        int[] m4 = m(aVar, n(aVar), f6384c);
        this.f6387a = (m4[1] - m4[0]) / 4;
        o(aVar, m4[0]);
        return m4;
    }

    private static int[] m(n1.a aVar, int i4, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int l4 = aVar.l();
        int i5 = i4;
        boolean z4 = false;
        int i6 = 0;
        while (i4 < l4) {
            if (aVar.g(i4) != z4) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                if (i6 != length - 1) {
                    i6++;
                } else {
                    if (r.f(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i5, i4};
                    }
                    i5 += iArr2[0] + iArr2[1];
                    int i7 = i6 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i7);
                    iArr2[i7] = 0;
                    iArr2[i6] = 0;
                    i6--;
                }
                iArr2[i6] = 1;
                z4 = !z4;
            }
            i4++;
        }
        throw g1.m.a();
    }

    private static int n(n1.a aVar) {
        int l4 = aVar.l();
        int j4 = aVar.j(0);
        if (j4 != l4) {
            return j4;
        }
        throw g1.m.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void o(n1.a r3, int r4) {
        /*
            r2 = this;
            int r0 = r2.f6387a
            int r0 = r0 * 10
            int r0 = java.lang.Math.min(r0, r4)
            int r4 = r4 + (-1)
        La:
            if (r0 <= 0) goto L19
            if (r4 < 0) goto L19
            boolean r1 = r3.g(r4)
            if (r1 != 0) goto L19
            int r0 = r0 + (-1)
            int r4 = r4 + (-1)
            goto La
        L19:
            if (r0 != 0) goto L1c
            return
        L1c:
            g1.m r3 = g1.m.a()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.n.o(n1.a, int):void");
    }

    @Override // w1.r
    public g1.q d(int i4, n1.a aVar, Map<g1.e, ?> map) {
        boolean z4;
        int[] l4 = l(aVar);
        int[] j4 = j(aVar);
        StringBuilder sb = new StringBuilder(20);
        k(aVar, l4[1], j4[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(g1.e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f6383b;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= length2) {
                z4 = false;
                break;
            }
            int i7 = iArr[i5];
            if (length == i7) {
                z4 = true;
                break;
            }
            if (i7 > i6) {
                i6 = i7;
            }
            i5++;
        }
        if (!z4 && length > i6) {
            z4 = true;
        }
        if (!z4) {
            throw g1.h.a();
        }
        float f4 = i4;
        return new g1.q(sb2, null, new g1.s[]{new g1.s(l4[1], f4), new g1.s(j4[0], f4)}, g1.a.ITF);
    }
}
