package d2;

import g1.c;
import g1.e;
import g1.s;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f3583a = {0, 4, 1, 5};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f3584b = {6, 2, 7, 3};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f3585c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f3586d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private static void a(s[] sVarArr, s[] sVarArr2, int[] iArr) {
        for (int i4 = 0; i4 < iArr.length; i4++) {
            sVarArr[iArr[i4]] = sVarArr2[i4];
        }
    }

    public static b b(c cVar, Map<e, ?> map, boolean z4) {
        n1.b a5 = cVar.a();
        List<s[]> c5 = c(z4, a5);
        if (c5.isEmpty()) {
            a5 = a5.clone();
            a5.m();
            c5 = c(z4, a5);
        }
        return new b(a5, c5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r4.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r5 = (g1.s[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r5[1] == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r5[3] == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<g1.s[]> c(boolean r8, n1.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = r2
            r4 = r3
        L9:
            r5 = r4
        La:
            int r6 = r9.h()
            if (r3 >= r6) goto L79
            g1.s[] r4 = f(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L53
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L53
            if (r5 == 0) goto L79
            java.util.Iterator r4 = r0.iterator()
        L23:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4f
            java.lang.Object r5 = r4.next()
            g1.s[] r5 = (g1.s[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L3f
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.d()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L3f:
            r7 = r5[r6]
            if (r7 == 0) goto L23
            r5 = r5[r6]
            float r5 = r5.d()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L23
        L4f:
            int r3 = r3 + 5
            r4 = r2
            goto L9
        L53:
            r0.add(r4)
            if (r8 == 0) goto L79
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L67
            r5 = r4[r3]
            float r5 = r5.c()
            int r5 = (int) r5
            r3 = r4[r3]
            goto L71
        L67:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.c()
            int r5 = (int) r5
            r3 = r4[r3]
        L71:
            float r3 = r3.d()
            int r3 = (int) r3
            r4 = r5
            r5 = r1
            goto La
        L79:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.a.c(boolean, n1.b):java.util.List");
    }

    private static int[] d(n1.b bVar, int i4, int i5, int i6, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i7 = 0;
        while (bVar.e(i4, i5) && i4 > 0) {
            int i8 = i7 + 1;
            if (i7 >= 3) {
                break;
            }
            i4--;
            i7 = i8;
        }
        int length = iArr.length;
        int i9 = i4;
        int i10 = 0;
        boolean z4 = false;
        while (i4 < i6) {
            if (bVar.e(i4, i5) != z4) {
                iArr2[i10] = iArr2[i10] + 1;
            } else {
                if (i10 != length - 1) {
                    i10++;
                } else {
                    if (g(iArr2, iArr) < 0.42f) {
                        return new int[]{i9, i4};
                    }
                    i9 += iArr2[0] + iArr2[1];
                    int i11 = i10 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i11);
                    iArr2[i11] = 0;
                    iArr2[i10] = 0;
                    i10--;
                }
                iArr2[i10] = 1;
                z4 = !z4;
            }
            i4++;
        }
        if (i10 != length - 1 || g(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i9, i4 - 1};
    }

    private static s[] e(n1.b bVar, int i4, int i5, int i6, int i7, int[] iArr) {
        boolean z4;
        int i8;
        int i9;
        s[] sVarArr = new s[4];
        int[] iArr2 = new int[iArr.length];
        int i10 = i6;
        while (true) {
            if (i10 >= i4) {
                z4 = false;
                break;
            }
            int[] d5 = d(bVar, i7, i10, i5, iArr, iArr2);
            if (d5 != null) {
                int i11 = i10;
                int[] iArr3 = d5;
                int i12 = i11;
                while (true) {
                    if (i12 <= 0) {
                        i9 = i12;
                        break;
                    }
                    int i13 = i12 - 1;
                    int[] d6 = d(bVar, i7, i13, i5, iArr, iArr2);
                    if (d6 == null) {
                        i9 = i13 + 1;
                        break;
                    }
                    iArr3 = d6;
                    i12 = i13;
                }
                float f4 = i9;
                sVarArr[0] = new s(iArr3[0], f4);
                sVarArr[1] = new s(iArr3[1], f4);
                z4 = true;
                i10 = i9;
            } else {
                i10 += 5;
            }
        }
        int i14 = i10 + 1;
        if (z4) {
            int[] iArr4 = {(int) sVarArr[0].c(), (int) sVarArr[1].c()};
            int i15 = i14;
            int i16 = 0;
            while (true) {
                if (i15 >= i4) {
                    i8 = i16;
                    break;
                }
                i8 = i16;
                int[] d7 = d(bVar, iArr4[0], i15, i5, iArr, iArr2);
                if (d7 != null && Math.abs(iArr4[0] - d7[0]) < 5 && Math.abs(iArr4[1] - d7[1]) < 5) {
                    iArr4 = d7;
                    i16 = 0;
                } else {
                    if (i8 > 25) {
                        break;
                    }
                    i16 = i8 + 1;
                }
                i15++;
            }
            i14 = i15 - (i8 + 1);
            float f5 = i14;
            sVarArr[2] = new s(iArr4[0], f5);
            sVarArr[3] = new s(iArr4[1], f5);
        }
        if (i14 - i10 < 10) {
            Arrays.fill(sVarArr, (Object) null);
        }
        return sVarArr;
    }

    private static s[] f(n1.b bVar, int i4, int i5) {
        int h4 = bVar.h();
        int l4 = bVar.l();
        s[] sVarArr = new s[8];
        a(sVarArr, e(bVar, h4, l4, i4, i5, f3585c), f3583a);
        if (sVarArr[4] != null) {
            i5 = (int) sVarArr[4].c();
            i4 = (int) sVarArr[4].d();
        }
        a(sVarArr, e(bVar, h4, l4, i4, i5, f3586d), f3584b);
        return sVarArr;
    }

    private static float g(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            i4 += iArr[i6];
            i5 += iArr2[i6];
        }
        if (i4 < i5) {
            return Float.POSITIVE_INFINITY;
        }
        float f4 = i4;
        float f5 = f4 / i5;
        float f6 = 0.8f * f5;
        float f7 = 0.0f;
        for (int i7 = 0; i7 < length; i7++) {
            float f8 = iArr2[i7] * f5;
            float f9 = iArr[i7];
            float f10 = f9 > f8 ? f9 - f8 : f8 - f9;
            if (f10 > f6) {
                return Float.POSITIVE_INFINITY;
            }
            f7 += f10;
        }
        return f7 / f4;
    }
}
