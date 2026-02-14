package x1;

import g1.m;
import g1.q;
import g1.s;
import g1.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import w1.r;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f6483i = {1, 10, 34, 70, 126};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f6484j = {4, 20, 48, 81};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f6485k = {0, 161, 961, 2015, 2715};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f6486l = {0, 336, 1036, 1516};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f6487m = {8, 6, 4, 3, 1};

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f6488n = {2, 4, 6, 8};

    /* renamed from: o, reason: collision with root package name */
    private static final int[][] f6489o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: g, reason: collision with root package name */
    private final List<d> f6490g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<d> f6491h = new ArrayList();

    private static void s(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z4 = false;
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.b() == dVar.b()) {
                next.e();
                z4 = true;
                break;
            }
        }
        if (z4) {
            return;
        }
        collection.add(dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0041, code lost:
    
        r5 = false;
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x003f, code lost:
    
        if (r1 < 4) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:
    
        if (r1 < 4) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0044, code lost:
    
        r2 = false;
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void t(boolean r10, int r11) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.e.t(boolean, int):void");
    }

    private static boolean u(d dVar, d dVar2) {
        int a5 = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c5 = (dVar.d().c() * 9) + dVar2.d().c();
        if (c5 > 72) {
            c5--;
        }
        if (c5 > 8) {
            c5--;
        }
        return a5 == c5;
    }

    private static q v(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i4 = 0;
        for (int i5 = 0; i5 < 13; i5++) {
            int charAt = sb.charAt(i5) - '0';
            if ((i5 & 1) == 0) {
                charAt *= 3;
            }
            i4 += charAt;
        }
        int i6 = 10 - (i4 % 10);
        if (i6 == 10) {
            i6 = 0;
        }
        sb.append(i6);
        s[] a5 = dVar.d().a();
        s[] a6 = dVar2.d().a();
        return new q(sb.toString(), null, new s[]{a5[0], a5[1], a6[0], a6[1]}, g1.a.RSS_14);
    }

    private b w(n1.a aVar, c cVar, boolean z4) {
        int[] j4 = j();
        Arrays.fill(j4, 0);
        int[] b5 = cVar.b();
        if (z4) {
            r.h(aVar, b5[0], j4);
        } else {
            r.g(aVar, b5[1], j4);
            int i4 = 0;
            for (int length = j4.length - 1; i4 < length; length--) {
                int i5 = j4[i4];
                j4[i4] = j4[length];
                j4[length] = i5;
                i4++;
            }
        }
        int i6 = z4 ? 16 : 15;
        float d5 = o1.a.d(j4) / i6;
        int[] n4 = n();
        int[] l4 = l();
        float[] o4 = o();
        float[] m4 = m();
        for (int i7 = 0; i7 < j4.length; i7++) {
            float f4 = j4[i7] / d5;
            int i8 = (int) (0.5f + f4);
            if (i8 <= 0) {
                i8 = 1;
            } else if (i8 > 8) {
                i8 = 8;
            }
            int i9 = i7 / 2;
            if ((i7 & 1) == 0) {
                n4[i9] = i8;
                o4[i9] = f4 - i8;
            } else {
                l4[i9] = i8;
                m4[i9] = f4 - i8;
            }
        }
        t(z4, i6);
        int i10 = 0;
        int i11 = 0;
        for (int length2 = n4.length - 1; length2 >= 0; length2--) {
            i10 = (i10 * 9) + n4[length2];
            i11 += n4[length2];
        }
        int i12 = 0;
        int i13 = 0;
        for (int length3 = l4.length - 1; length3 >= 0; length3--) {
            i12 = (i12 * 9) + l4[length3];
            i13 += l4[length3];
        }
        int i14 = i10 + (i12 * 3);
        if (!z4) {
            if ((i13 & 1) != 0 || i13 > 10 || i13 < 4) {
                throw m.a();
            }
            int i15 = (10 - i13) / 2;
            int i16 = f6488n[i15];
            return new b((f.b(l4, 9 - i16, false) * f6484j[i15]) + f.b(n4, i16, true) + f6486l[i15], i14);
        }
        if ((i11 & 1) != 0 || i11 > 12 || i11 < 4) {
            throw m.a();
        }
        int i17 = (12 - i11) / 2;
        int i18 = f6487m[i17];
        return new b((f.b(n4, i18, false) * f6483i[i17]) + f.b(l4, 9 - i18, true) + f6485k[i17], i14);
    }

    private d x(n1.a aVar, boolean z4, int i4, Map<g1.e, ?> map) {
        try {
            c z5 = z(aVar, i4, z4, y(aVar, z4));
            t tVar = map == null ? null : (t) map.get(g1.e.NEED_RESULT_POINT_CALLBACK);
            if (tVar != null) {
                int[] b5 = z5.b();
                float f4 = ((b5[0] + b5[1]) - 1) / 2.0f;
                if (z4) {
                    f4 = (aVar.l() - 1) - f4;
                }
                tVar.a(new s(f4, i4));
            }
            b w4 = w(aVar, z5, true);
            b w5 = w(aVar, z5, false);
            return new d((w4.b() * 1597) + w5.b(), w4.a() + (w5.a() * 4), z5);
        } catch (m unused) {
            return null;
        }
    }

    private int[] y(n1.a aVar, boolean z4) {
        int[] k4 = k();
        k4[0] = 0;
        k4[1] = 0;
        k4[2] = 0;
        k4[3] = 0;
        int l4 = aVar.l();
        int i4 = 0;
        boolean z5 = false;
        while (i4 < l4) {
            z5 = !aVar.g(i4);
            if (z4 == z5) {
                break;
            }
            i4++;
        }
        int i5 = 0;
        int i6 = i4;
        while (i4 < l4) {
            if (aVar.g(i4) != z5) {
                k4[i5] = k4[i5] + 1;
            } else {
                if (i5 != 3) {
                    i5++;
                } else {
                    if (a.q(k4)) {
                        return new int[]{i6, i4};
                    }
                    i6 += k4[0] + k4[1];
                    k4[0] = k4[2];
                    k4[1] = k4[3];
                    k4[2] = 0;
                    k4[3] = 0;
                    i5--;
                }
                k4[i5] = 1;
                z5 = !z5;
            }
            i4++;
        }
        throw m.a();
    }

    private c z(n1.a aVar, int i4, boolean z4, int[] iArr) {
        int i5;
        int i6;
        boolean g4 = aVar.g(iArr[0]);
        int i7 = iArr[0] - 1;
        while (i7 >= 0 && g4 != aVar.g(i7)) {
            i7--;
        }
        int i8 = i7 + 1;
        int i9 = iArr[0] - i8;
        int[] k4 = k();
        System.arraycopy(k4, 0, k4, 1, k4.length - 1);
        k4[0] = i9;
        int r4 = a.r(k4, f6489o);
        int i10 = iArr[1];
        if (z4) {
            int l4 = (aVar.l() - 1) - i8;
            i5 = (aVar.l() - 1) - i10;
            i6 = l4;
        } else {
            i5 = i10;
            i6 = i8;
        }
        return new c(r4, new int[]{i8, iArr[1]}, i6, i5, i4);
    }

    @Override // w1.r, g1.o
    public void c() {
        this.f6490g.clear();
        this.f6491h.clear();
    }

    @Override // w1.r
    public q d(int i4, n1.a aVar, Map<g1.e, ?> map) {
        s(this.f6490g, x(aVar, false, i4, map));
        aVar.p();
        s(this.f6491h, x(aVar, true, i4, map));
        aVar.p();
        for (d dVar : this.f6490g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f6491h) {
                    if (dVar2.c() > 1 && u(dVar, dVar2)) {
                        return v(dVar, dVar2);
                    }
                }
            }
        }
        throw m.a();
    }
}
