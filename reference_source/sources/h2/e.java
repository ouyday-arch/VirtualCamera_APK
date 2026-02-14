package h2;

import g1.s;
import g1.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    private static final b f4091f = new b();

    /* renamed from: a, reason: collision with root package name */
    private final n1.b f4092a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4094c;

    /* renamed from: e, reason: collision with root package name */
    private final t f4096e;

    /* renamed from: b, reason: collision with root package name */
    private final List<d> f4093b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final int[] f4095d = new int[5];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements Serializable, Comparator<d> {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return Float.compare(dVar.i(), dVar2.i());
        }
    }

    public e(n1.b bVar, t tVar) {
        this.f4092a = bVar;
        this.f4096e = tVar;
    }

    private static float a(int[] iArr, int i4) {
        return ((i4 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean b(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int[] k4 = k();
        int i9 = 0;
        while (i4 >= i9 && i5 >= i9 && this.f4092a.e(i5 - i9, i4 - i9)) {
            k4[2] = k4[2] + 1;
            i9++;
        }
        if (k4[2] == 0) {
            return false;
        }
        while (i4 >= i9 && i5 >= i9 && !this.f4092a.e(i5 - i9, i4 - i9)) {
            k4[1] = k4[1] + 1;
            i9++;
        }
        if (k4[1] == 0) {
            return false;
        }
        while (i4 >= i9 && i5 >= i9 && this.f4092a.e(i5 - i9, i4 - i9)) {
            k4[0] = k4[0] + 1;
            i9++;
        }
        if (k4[0] == 0) {
            return false;
        }
        int h4 = this.f4092a.h();
        int l4 = this.f4092a.l();
        int i10 = 1;
        while (true) {
            int i11 = i4 + i10;
            if (i11 >= h4 || (i8 = i5 + i10) >= l4 || !this.f4092a.e(i8, i11)) {
                break;
            }
            k4[2] = k4[2] + 1;
            i10++;
        }
        while (true) {
            int i12 = i4 + i10;
            if (i12 >= h4 || (i7 = i5 + i10) >= l4 || this.f4092a.e(i7, i12)) {
                break;
            }
            k4[3] = k4[3] + 1;
            i10++;
        }
        if (k4[3] == 0) {
            return false;
        }
        while (true) {
            int i13 = i4 + i10;
            if (i13 >= h4 || (i6 = i5 + i10) >= l4 || !this.f4092a.e(i6, i13)) {
                break;
            }
            k4[4] = k4[4] + 1;
            i10++;
        }
        if (k4[4] == 0) {
            return false;
        }
        return j(k4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r2[1] <= r13) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r3 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r0.e(r3, r12) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if (r2[0] > r13) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        if (r2[0] <= r13) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (r11 >= r1) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005f, code lost:
    
        if (r0.e(r11, r12) == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r11 != r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006d, code lost:
    
        if (r11 >= r1) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        if (r0.e(r11, r12) != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0077, code lost:
    
        if (r2[3] >= r13) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0079, code lost:
    
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
    
        if (r11 == r1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0085, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0089, code lost:
    
        if (r11 >= r1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008f, code lost:
    
        if (r0.e(r11, r12) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0093, code lost:
    
        if (r2[4] >= r13) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0095, code lost:
    
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        if (r2[4] < r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a1, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b7, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < r14) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b9, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00be, code lost:
    
        if (i(r2) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c4, code lost:
    
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float c(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.e.c(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r2[1] <= r13) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r3 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r0.e(r12, r3) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if (r2[0] > r13) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        if (r2[0] <= r13) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (r11 >= r1) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005f, code lost:
    
        if (r0.e(r12, r11) == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r11 != r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006d, code lost:
    
        if (r11 >= r1) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        if (r0.e(r12, r11) != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0077, code lost:
    
        if (r2[3] >= r13) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0079, code lost:
    
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
    
        if (r11 == r1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0085, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0089, code lost:
    
        if (r11 >= r1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008f, code lost:
    
        if (r0.e(r12, r11) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0093, code lost:
    
        if (r2[4] >= r13) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0095, code lost:
    
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        if (r2[4] < r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a1, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b8, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < (r14 * 2)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ba, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bf, code lost:
    
        if (i(r2) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c5, code lost:
    
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float d(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.e.d(int, int, int, int):float");
    }

    protected static void e(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    protected static void f(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private int h() {
        if (this.f4093b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f4093b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.f4094c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    protected static boolean i(int[] iArr) {
        int i4 = 0;
        for (int i5 = 0; i5 < 5; i5++) {
            int i6 = iArr[i5];
            if (i6 == 0) {
                return false;
            }
            i4 += i6;
        }
        if (i4 < 7) {
            return false;
        }
        float f4 = i4 / 7.0f;
        float f5 = f4 / 2.0f;
        return Math.abs(f4 - ((float) iArr[0])) < f5 && Math.abs(f4 - ((float) iArr[1])) < f5 && Math.abs((f4 * 3.0f) - ((float) iArr[2])) < 3.0f * f5 && Math.abs(f4 - ((float) iArr[3])) < f5 && Math.abs(f4 - ((float) iArr[4])) < f5;
    }

    protected static boolean j(int[] iArr) {
        int i4 = 0;
        for (int i5 = 0; i5 < 5; i5++) {
            int i6 = iArr[i5];
            if (i6 == 0) {
                return false;
            }
            i4 += i6;
        }
        if (i4 < 7) {
            return false;
        }
        float f4 = i4 / 7.0f;
        float f5 = f4 / 1.333f;
        return Math.abs(f4 - ((float) iArr[0])) < f5 && Math.abs(f4 - ((float) iArr[1])) < f5 && Math.abs((f4 * 3.0f) - ((float) iArr[2])) < 3.0f * f5 && Math.abs(f4 - ((float) iArr[3])) < f5 && Math.abs(f4 - ((float) iArr[4])) < f5;
    }

    private int[] k() {
        e(this.f4095d);
        return this.f4095d;
    }

    private boolean m() {
        int size = this.f4093b.size();
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i4 = 0;
        for (d dVar : this.f4093b) {
            if (dVar.h() >= 2) {
                i4++;
                f5 += dVar.i();
            }
        }
        if (i4 < 3) {
            return false;
        }
        float f6 = f5 / size;
        Iterator<d> it = this.f4093b.iterator();
        while (it.hasNext()) {
            f4 += Math.abs(it.next().i() - f6);
        }
        return f4 <= f5 * 0.05f;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private h2.d[] n() {
        /*
            r26 = this;
            r0 = r26
            java.util.List<h2.d> r1 = r0.f4093b
            int r1 = r1.size()
            r2 = 3
            if (r1 < r2) goto Ld7
            java.util.List<h2.d> r1 = r0.f4093b
            h2.e$b r3 = h2.e.f4091f
            r1.sort(r3)
            h2.d[] r1 = new h2.d[r2]
            r2 = 0
            r5 = r2
            r6 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L1b:
            java.util.List<h2.d> r8 = r0.f4093b
            int r8 = r8.size()
            r9 = 2
            int r8 = r8 - r9
            if (r5 >= r8) goto Lc8
            java.util.List<h2.d> r8 = r0.f4093b
            java.lang.Object r8 = r8.get(r5)
            h2.d r8 = (h2.d) r8
            float r10 = r8.i()
            int r5 = r5 + 1
            r11 = r5
        L34:
            java.util.List<h2.d> r12 = r0.f4093b
            int r12 = r12.size()
            r13 = 1
            int r12 = r12 - r13
            if (r11 >= r12) goto L1b
            java.util.List<h2.d> r12 = r0.f4093b
            java.lang.Object r12 = r12.get(r11)
            h2.d r12 = (h2.d) r12
            double r14 = o(r8, r12)
            int r11 = r11 + 1
            r3 = r11
        L4d:
            java.util.List<h2.d> r4 = r0.f4093b
            int r4 = r4.size()
            if (r3 >= r4) goto L34
            java.util.List<h2.d> r4 = r0.f4093b
            java.lang.Object r4 = r4.get(r3)
            h2.d r4 = (h2.d) r4
            float r16 = r4.i()
            r17 = 1068708659(0x3fb33333, float:1.4)
            float r17 = r17 * r10
            int r16 = (r16 > r17 ? 1 : (r16 == r17 ? 0 : -1))
            if (r16 > 0) goto Lc5
            double r16 = o(r12, r4)
            double r18 = o(r8, r4)
            int r20 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r20 >= 0) goto L8d
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 <= 0) goto L84
            int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r20 >= 0) goto L81
            r20 = r14
            goto La5
        L81:
            r20 = r18
            goto L99
        L84:
            r20 = r14
            r24 = r16
            r16 = r18
            r18 = r24
            goto La5
        L8d:
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L9f
            int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r20 >= 0) goto L9c
            r20 = r16
            r16 = r18
        L99:
            r18 = r14
            goto La5
        L9c:
            r20 = r16
            goto La3
        L9f:
            r20 = r18
            r18 = r16
        La3:
            r16 = r14
        La5:
            r22 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r18 = r18 * r22
            double r18 = r16 - r18
            double r18 = java.lang.Math.abs(r18)
            double r20 = r20 * r22
            double r16 = r16 - r20
            double r16 = java.lang.Math.abs(r16)
            double r18 = r18 + r16
            int r16 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r16 >= 0) goto Lc5
            r1[r2] = r8
            r1[r13] = r12
            r1[r9] = r4
            r6 = r18
        Lc5:
            int r3 = r3 + 1
            goto L4d
        Lc8:
            r3 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto Ld2
            return r1
        Ld2:
            g1.m r1 = g1.m.a()
            throw r1
        Ld7:
            g1.m r1 = g1.m.a()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.e.n():h2.d[]");
    }

    private static double o(d dVar, d dVar2) {
        double c5 = dVar.c() - dVar2.c();
        double d5 = dVar.d() - dVar2.d();
        return (c5 * c5) + (d5 * d5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f g(Map<g1.e, ?> map) {
        boolean z4 = map != null && map.containsKey(g1.e.TRY_HARDER);
        int h4 = this.f4092a.h();
        int l4 = this.f4092a.l();
        int i4 = (h4 * 3) / 388;
        if (i4 < 3 || z4) {
            i4 = 3;
        }
        int[] iArr = new int[5];
        int i5 = i4 - 1;
        boolean z5 = false;
        while (i5 < h4 && !z5) {
            e(iArr);
            int i6 = 0;
            int i7 = 0;
            while (i6 < l4) {
                if (this.f4092a.e(i6, i5)) {
                    if ((i7 & 1) == 1) {
                        i7++;
                    }
                    iArr[i7] = iArr[i7] + 1;
                } else if ((i7 & 1) != 0) {
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 != 4) {
                    i7++;
                    iArr[i7] = iArr[i7] + 1;
                } else if (i(iArr) && l(iArr, i5, i6)) {
                    if (this.f4094c) {
                        z5 = m();
                    } else {
                        int h5 = h();
                        if (h5 > iArr[2]) {
                            i5 += (h5 - iArr[2]) - 2;
                            i6 = l4 - 1;
                        }
                    }
                    e(iArr);
                    i7 = 0;
                    i4 = 2;
                } else {
                    f(iArr);
                    i7 = 3;
                }
                i6++;
            }
            if (i(iArr) && l(iArr, i5, l4)) {
                i4 = iArr[0];
                if (this.f4094c) {
                    z5 = m();
                }
            }
            i5 += i4;
        }
        d[] n4 = n();
        s.e(n4);
        return new f(n4);
    }

    protected final boolean l(int[] iArr, int i4, int i5) {
        boolean z4 = false;
        int i6 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a5 = (int) a(iArr, i5);
        float d5 = d(i4, a5, iArr[2], i6);
        if (!Float.isNaN(d5)) {
            int i7 = (int) d5;
            float c5 = c(a5, i7, iArr[2], i6);
            if (!Float.isNaN(c5) && b(i7, (int) c5)) {
                float f4 = i6 / 7.0f;
                int i8 = 0;
                while (true) {
                    if (i8 >= this.f4093b.size()) {
                        break;
                    }
                    d dVar = this.f4093b.get(i8);
                    if (dVar.f(f4, d5, c5)) {
                        this.f4093b.set(i8, dVar.g(d5, c5, f4));
                        z4 = true;
                        break;
                    }
                    i8++;
                }
                if (!z4) {
                    d dVar2 = new d(c5, d5, f4);
                    this.f4093b.add(dVar2);
                    t tVar = this.f4096e;
                    if (tVar != null) {
                        tVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
