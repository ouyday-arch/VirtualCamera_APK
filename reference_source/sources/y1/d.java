package y1;

import a.j;
import g1.e;
import g1.m;
import g1.q;
import g1.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import w1.r;
import x1.f;

/* loaded from: classes.dex */
public final class d extends x1.a {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f6597k = {7, 5, 4, 3, 1};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f6598l = {4, 20, 52, 104, 204};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f6599m = {0, 348, 1388, 2948, 3988};

    /* renamed from: n, reason: collision with root package name */
    private static final int[][] f6600n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: o, reason: collision with root package name */
    private static final int[][] f6601o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, j.H0, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, j.G0, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, j.M0, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, j.L0, 155}, new int[]{43, 129, 176, 106, 107, 110, j.I0, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, j.F0, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, j.E0}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{j.J0, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, j.D0, 131, 182, j.N0}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* renamed from: p, reason: collision with root package name */
    private static final int[][] f6602p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* renamed from: g, reason: collision with root package name */
    private final List<b> f6603g = new ArrayList(11);

    /* renamed from: h, reason: collision with root package name */
    private final List<c> f6604h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final int[] f6605i = new int[2];

    /* renamed from: j, reason: collision with root package name */
    private boolean f6606j;

    private static int A(n1.a aVar, int i4) {
        return aVar.g(i4) ? aVar.j(aVar.k(i4)) : aVar.k(aVar.j(i4));
    }

    private static boolean B(x1.c cVar, boolean z4, boolean z5) {
        return (cVar.c() == 0 && z4 && z5) ? false : true;
    }

    private static boolean C(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z4;
        boolean z5;
        Iterator<c> it = iterable2.iterator();
        do {
            z4 = false;
            if (!it.hasNext()) {
                return false;
            }
            c next = it.next();
            Iterator<b> it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z4 = true;
                    break;
                }
                b next2 = it2.next();
                Iterator<b> it3 = next.a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z5 = false;
                        break;
                    }
                    if (next2.equals(it3.next())) {
                        z5 = true;
                        break;
                    }
                }
                if (!z5) {
                    break;
                }
            }
        } while (!z4);
        return true;
    }

    private static boolean D(List<b> list) {
        boolean z4;
        for (int[] iArr : f6602p) {
            if (list.size() <= iArr.length) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.size()) {
                        z4 = true;
                        break;
                    }
                    if (list.get(i4).a().c() != iArr[i4]) {
                        z4 = false;
                        break;
                    }
                    i4++;
                }
                if (z4) {
                    return true;
                }
            }
        }
        return false;
    }

    private x1.c E(n1.a aVar, int i4, boolean z4) {
        int i5;
        int i6;
        int i7;
        if (z4) {
            int i8 = this.f6605i[0] - 1;
            while (i8 >= 0 && !aVar.g(i8)) {
                i8--;
            }
            int i9 = i8 + 1;
            int[] iArr = this.f6605i;
            i7 = iArr[0] - i9;
            i5 = iArr[1];
            i6 = i9;
        } else {
            int[] iArr2 = this.f6605i;
            int i10 = iArr2[0];
            int k4 = aVar.k(iArr2[1] + 1);
            i5 = k4;
            i6 = i10;
            i7 = k4 - this.f6605i[1];
        }
        int[] k5 = k();
        System.arraycopy(k5, 0, k5, 1, k5.length - 1);
        k5[0] = i7;
        try {
            return new x1.c(x1.a.r(k5, f6600n), new int[]{i6, i5}, i6, i5, i4);
        } catch (m unused) {
            return null;
        }
    }

    private static void F(Collection<b> collection, Collection<c> collection2) {
        Iterator<c> it = collection2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != collection.size()) {
                boolean z4 = true;
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!collection.contains(it2.next())) {
                        z4 = false;
                        break;
                    }
                }
                if (z4) {
                    it.remove();
                }
            }
        }
    }

    private static void H(int[] iArr) {
        int length = iArr.length;
        for (int i4 = 0; i4 < length / 2; i4++) {
            int i5 = iArr[i4];
            int i6 = (length - i4) - 1;
            iArr[i4] = iArr[i6];
            iArr[i6] = i5;
        }
    }

    private void I(int i4) {
        boolean z4;
        int i5 = 0;
        boolean z5 = false;
        while (true) {
            if (i5 >= this.f6604h.size()) {
                z4 = false;
                break;
            }
            c cVar = this.f6604h.get(i5);
            if (cVar.b() > i4) {
                z4 = cVar.c(this.f6603g);
                break;
            } else {
                z5 = cVar.c(this.f6603g);
                i5++;
            }
        }
        if (z4 || z5 || C(this.f6603g, this.f6604h)) {
            return;
        }
        this.f6604h.add(i5, new c(this.f6603g, i4, false));
        F(this.f6603g, this.f6604h);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void s(int r11) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.d.s(int):void");
    }

    private boolean t() {
        b bVar = this.f6603g.get(0);
        x1.b b5 = bVar.b();
        x1.b c5 = bVar.c();
        if (c5 == null) {
            return false;
        }
        int a5 = c5.a();
        int i4 = 2;
        for (int i5 = 1; i5 < this.f6603g.size(); i5++) {
            b bVar2 = this.f6603g.get(i5);
            a5 += bVar2.b().a();
            i4++;
            x1.b c6 = bVar2.c();
            if (c6 != null) {
                a5 += c6.a();
                i4++;
            }
        }
        return ((i4 + (-4)) * 211) + (a5 % 211) == b5.b();
    }

    private List<b> u(List<c> list, int i4) {
        while (i4 < this.f6604h.size()) {
            c cVar = this.f6604h.get(i4);
            this.f6603g.clear();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                this.f6603g.addAll(it.next().a());
            }
            this.f6603g.addAll(cVar.a());
            if (D(this.f6603g)) {
                if (t()) {
                    return this.f6603g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return u(arrayList, i4 + 1);
                } catch (m unused) {
                    continue;
                }
            }
            i4++;
        }
        throw m.a();
    }

    private List<b> v(boolean z4) {
        List<b> list = null;
        if (this.f6604h.size() > 25) {
            this.f6604h.clear();
            return null;
        }
        this.f6603g.clear();
        if (z4) {
            Collections.reverse(this.f6604h);
        }
        try {
            list = u(new ArrayList(), 0);
        } catch (m unused) {
        }
        if (z4) {
            Collections.reverse(this.f6604h);
        }
        return list;
    }

    static q w(List<b> list) {
        String d5 = z1.j.a(a.a(list)).d();
        s[] a5 = list.get(0).a().a();
        s[] a6 = list.get(list.size() - 1).a().a();
        return new q(d5, null, new s[]{a5[0], a5[1], a6[0], a6[1]}, g1.a.RSS_EXPANDED);
    }

    private void z(n1.a aVar, List<b> list, int i4) {
        int[] k4 = k();
        k4[0] = 0;
        k4[1] = 0;
        k4[2] = 0;
        k4[3] = 0;
        int l4 = aVar.l();
        if (i4 < 0) {
            i4 = list.isEmpty() ? 0 : list.get(list.size() - 1).a().b()[1];
        }
        boolean z4 = list.size() % 2 != 0;
        if (this.f6606j) {
            z4 = !z4;
        }
        boolean z5 = false;
        while (i4 < l4) {
            z5 = !aVar.g(i4);
            if (!z5) {
                break;
            } else {
                i4++;
            }
        }
        int i5 = 0;
        boolean z6 = z5;
        int i6 = i4;
        while (i4 < l4) {
            if (aVar.g(i4) != z6) {
                k4[i5] = k4[i5] + 1;
            } else {
                if (i5 == 3) {
                    if (z4) {
                        H(k4);
                    }
                    if (x1.a.q(k4)) {
                        int[] iArr = this.f6605i;
                        iArr[0] = i6;
                        iArr[1] = i4;
                        return;
                    }
                    if (z4) {
                        H(k4);
                    }
                    i6 += k4[0] + k4[1];
                    k4[0] = k4[2];
                    k4[1] = k4[3];
                    k4[2] = 0;
                    k4[3] = 0;
                    i5--;
                } else {
                    i5++;
                }
                k4[i5] = 1;
                z6 = !z6;
            }
            i4++;
        }
        throw m.a();
    }

    b G(n1.a aVar, List<b> list, int i4) {
        x1.c E;
        x1.b bVar;
        boolean z4 = list.size() % 2 == 0;
        if (this.f6606j) {
            z4 = !z4;
        }
        int i5 = -1;
        boolean z5 = true;
        do {
            z(aVar, list, i5);
            E = E(aVar, i4, z4);
            if (E == null) {
                i5 = A(aVar, this.f6605i[0]);
            } else {
                z5 = false;
            }
        } while (z5);
        x1.b x4 = x(aVar, E, z4, true);
        if (!list.isEmpty() && list.get(list.size() - 1).d()) {
            throw m.a();
        }
        try {
            bVar = x(aVar, E, z4, false);
        } catch (m unused) {
            bVar = null;
        }
        return new b(x4, bVar, E);
    }

    @Override // w1.r, g1.o
    public void c() {
        this.f6603g.clear();
        this.f6604h.clear();
    }

    @Override // w1.r
    public q d(int i4, n1.a aVar, Map<e, ?> map) {
        this.f6603g.clear();
        this.f6606j = false;
        try {
            return w(y(i4, aVar));
        } catch (m unused) {
            this.f6603g.clear();
            this.f6606j = true;
            return w(y(i4, aVar));
        }
    }

    x1.b x(n1.a aVar, x1.c cVar, boolean z4, boolean z5) {
        int[] j4 = j();
        Arrays.fill(j4, 0);
        int[] b5 = cVar.b();
        if (z5) {
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
        float d5 = o1.a.d(j4) / 17.0f;
        float f4 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(d5 - f4) / f4 > 0.3f) {
            throw m.a();
        }
        int[] n4 = n();
        int[] l4 = l();
        float[] o4 = o();
        float[] m4 = m();
        for (int i6 = 0; i6 < j4.length; i6++) {
            float f5 = (j4[i6] * 1.0f) / d5;
            int i7 = (int) (0.5f + f5);
            if (i7 <= 0) {
                if (f5 < 0.3f) {
                    throw m.a();
                }
                i7 = 1;
            } else if (i7 > 8) {
                if (f5 > 8.7f) {
                    throw m.a();
                }
                i7 = 8;
            }
            int i8 = i6 / 2;
            if ((i6 & 1) == 0) {
                n4[i8] = i7;
                o4[i8] = f5 - i7;
            } else {
                l4[i8] = i7;
                m4[i8] = f5 - i7;
            }
        }
        s(17);
        int c5 = (((cVar.c() * 4) + (z4 ? 0 : 2)) + (!z5 ? 1 : 0)) - 1;
        int i9 = 0;
        int i10 = 0;
        for (int length2 = n4.length - 1; length2 >= 0; length2--) {
            if (B(cVar, z4, z5)) {
                i9 += n4[length2] * f6601o[c5][length2 * 2];
            }
            i10 += n4[length2];
        }
        int i11 = 0;
        for (int length3 = l4.length - 1; length3 >= 0; length3--) {
            if (B(cVar, z4, z5)) {
                i11 += l4[length3] * f6601o[c5][(length3 * 2) + 1];
            }
        }
        int i12 = i9 + i11;
        if ((i10 & 1) != 0 || i10 > 13 || i10 < 4) {
            throw m.a();
        }
        int i13 = (13 - i10) / 2;
        int i14 = f6597k[i13];
        return new x1.b((f.b(n4, i14, true) * f6598l[i13]) + f.b(l4, 9 - i14, false) + f6599m[i13], i12);
    }

    List<b> y(int i4, n1.a aVar) {
        boolean z4 = false;
        while (!z4) {
            try {
                List<b> list = this.f6603g;
                list.add(G(aVar, list, i4));
            } catch (m e4) {
                if (this.f6603g.isEmpty()) {
                    throw e4;
                }
                z4 = true;
            }
        }
        if (t()) {
            return this.f6603g;
        }
        boolean z5 = !this.f6604h.isEmpty();
        I(i4);
        if (z5) {
            List<b> v4 = v(false);
            if (v4 != null) {
                return v4;
            }
            List<b> v5 = v(true);
            if (v5 != null) {
                return v5;
            }
        }
        throw m.a();
    }
}
