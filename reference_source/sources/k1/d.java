package k1;

import a.j;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    static final String[] f4379b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: c, reason: collision with root package name */
    static final int[][] f4380c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f4381d;

    /* renamed from: e, reason: collision with root package name */
    static final int[][] f4382e;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f4383a;

    /* loaded from: classes.dex */
    class a implements Comparator<f> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.e() - fVar2.e();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, 5, 256);
        f4381d = iArr;
        iArr[0][32] = 1;
        for (int i4 = 65; i4 <= 90; i4++) {
            f4381d[0][i4] = (i4 - 65) + 2;
        }
        f4381d[1][32] = 1;
        for (int i5 = 97; i5 <= 122; i5++) {
            f4381d[1][i5] = (i5 - 97) + 2;
        }
        f4381d[2][32] = 1;
        for (int i6 = 48; i6 <= 57; i6++) {
            f4381d[2][i6] = (i6 - 48) + 2;
        }
        int[][] iArr2 = f4381d;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, j.N0, 126, 127};
        for (int i7 = 0; i7 < 28; i7++) {
            f4381d[3][iArr3[i7]] = i7;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, j.M0, 125};
        for (int i8 = 0; i8 < 31; i8++) {
            if (iArr4[i8] > 0) {
                f4381d[4][iArr4[i8]] = i8;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) int.class, 6, 6);
        f4382e = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f4382e;
        iArr7[0][4] = 0;
        iArr7[1][4] = 0;
        iArr7[1][0] = 28;
        iArr7[3][4] = 0;
        iArr7[2][4] = 0;
        iArr7[2][0] = 15;
    }

    public d(byte[] bArr) {
        this.f4383a = bArr;
    }

    private static Collection<f> b(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            boolean z4 = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.g(fVar)) {
                    z4 = false;
                    break;
                }
                if (fVar.g(fVar2)) {
                    it.remove();
                }
            }
            if (z4) {
                linkedList.add(fVar);
            }
        }
        return linkedList;
    }

    private void c(f fVar, int i4, Collection<f> collection) {
        char c5 = (char) (this.f4383a[i4] & 255);
        boolean z4 = f4381d[fVar.f()][c5] > 0;
        f fVar2 = null;
        for (int i5 = 0; i5 <= 4; i5++) {
            int i6 = f4381d[i5][c5];
            if (i6 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.c(i4);
                }
                if (!z4 || i5 == fVar.f() || i5 == 2) {
                    collection.add(fVar2.h(i5, i6));
                }
                if (!z4 && f4382e[fVar.f()][i5] >= 0) {
                    collection.add(fVar2.i(i5, i6));
                }
            }
        }
        if (fVar.d() > 0 || f4381d[fVar.f()][c5] == 0) {
            collection.add(fVar.a(i4));
        }
    }

    private static void d(f fVar, int i4, int i5, Collection<f> collection) {
        f c5 = fVar.c(i4);
        collection.add(c5.h(4, i5));
        if (fVar.f() != 4) {
            collection.add(c5.i(4, i5));
        }
        if (i5 == 3 || i5 == 4) {
            collection.add(c5.h(2, 16 - i5).h(2, 1));
        }
        if (fVar.d() > 0) {
            collection.add(fVar.a(i4).a(i4 + 1));
        }
    }

    private Collection<f> e(Iterable<f> iterable, int i4) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            c(it.next(), i4, linkedList);
        }
        return b(linkedList);
    }

    private static Collection<f> f(Iterable<f> iterable, int i4, int i5) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            d(it.next(), i4, i5, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n1.a a() {
        /*
            r8 = this;
            k1.f r0 = k1.f.f4387e
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = r1
        L8:
            byte[] r3 = r8.f4383a
            int r4 = r3.length
            if (r2 >= r4) goto L4c
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L15
            r5 = r3[r4]
            goto L16
        L15:
            r5 = r1
        L16:
            r3 = r3[r2]
            r6 = 13
            if (r3 == r6) goto L38
            r6 = 44
            r7 = 32
            if (r3 == r6) goto L34
            r6 = 46
            if (r3 == r6) goto L30
            r6 = 58
            if (r3 == r6) goto L2c
        L2a:
            r3 = r1
            goto L3d
        L2c:
            if (r5 != r7) goto L2a
            r3 = 5
            goto L3d
        L30:
            if (r5 != r7) goto L2a
            r3 = 3
            goto L3d
        L34:
            if (r5 != r7) goto L2a
            r3 = 4
            goto L3d
        L38:
            r3 = 10
            if (r5 != r3) goto L2a
            r3 = 2
        L3d:
            if (r3 <= 0) goto L45
            java.util.Collection r0 = f(r0, r2, r3)
            r2 = r4
            goto L49
        L45:
            java.util.Collection r0 = r8.e(r0, r2)
        L49:
            int r2 = r2 + 1
            goto L8
        L4c:
            k1.d$a r1 = new k1.d$a
            r1.<init>()
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            k1.f r0 = (k1.f) r0
            byte[] r1 = r8.f4383a
            n1.a r0 = r0.j(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.d.a():n1.a");
    }
}
