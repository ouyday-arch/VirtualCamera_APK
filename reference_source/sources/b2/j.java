package b2;

import g1.m;
import g1.s;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final c2.a f2290a = new c2.a();

    private static c a(h hVar) {
        int[] j4;
        if (hVar == null || (j4 = hVar.j()) == null) {
            return null;
        }
        int p4 = p(j4);
        int i4 = 0;
        int i5 = 0;
        for (int i6 : j4) {
            i5 += p4 - i6;
            if (i6 > 0) {
                break;
            }
        }
        d[] d5 = hVar.d();
        for (int i7 = 0; i5 > 0 && d5[i7] == null; i7++) {
            i5--;
        }
        for (int length = j4.length - 1; length >= 0; length--) {
            i4 += p4 - j4[length];
            if (j4[length] > 0) {
                break;
            }
        }
        for (int length2 = d5.length - 1; i4 > 0 && d5[length2] == null; length2--) {
            i4--;
        }
        return hVar.a().a(i5, i4, hVar.k());
    }

    private static void b(f fVar, b[][] bVarArr) {
        b bVar = bVarArr[0][1];
        int[] a5 = bVar.a();
        int j4 = (fVar.j() * fVar.l()) - r(fVar.k());
        if (a5.length == 0) {
            if (j4 <= 0 || j4 > 928) {
                throw m.a();
            }
            bVar.b(j4);
            return;
        }
        if (a5[0] == j4 || j4 <= 0 || j4 > 928) {
            return;
        }
        bVar.b(j4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int c(n1.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.e(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.j.c(n1.b, int, int, boolean, int, int):int");
    }

    private static boolean d(int i4, int i5, int i6) {
        return i5 + (-2) <= i4 && i4 <= i6 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i4) {
        if ((iArr2 == null || iArr2.length <= (i4 / 2) + 3) && i4 >= 0 && i4 <= 512) {
            return f2290a.a(iArr, i4, iArr2);
        }
        throw g1.d.a();
    }

    private static b[][] f(f fVar) {
        int c5;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, fVar.l(), fVar.j() + 2);
        for (int i4 = 0; i4 < bVarArr.length; i4++) {
            for (int i5 = 0; i5 < bVarArr[i4].length; i5++) {
                bVarArr[i4][i5] = new b();
            }
        }
        int i6 = 0;
        for (g gVar : fVar.o()) {
            if (gVar != null) {
                for (d dVar : gVar.d()) {
                    if (dVar != null && (c5 = dVar.c()) >= 0 && c5 < bVarArr.length) {
                        bVarArr[c5][i6].b(dVar.e());
                    }
                }
            }
            i6++;
        }
        return bVarArr;
    }

    private static n1.e g(f fVar) {
        b[][] f4 = f(fVar);
        b(fVar, f4);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.l() * fVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < fVar.l(); i4++) {
            int i5 = 0;
            while (i5 < fVar.j()) {
                int i6 = i5 + 1;
                int[] a5 = f4[i4][i6].a();
                int j4 = (fVar.j() * i4) + i5;
                if (a5.length == 0) {
                    arrayList.add(Integer.valueOf(j4));
                } else if (a5.length == 1) {
                    iArr[j4] = a5[0];
                } else {
                    arrayList3.add(Integer.valueOf(j4));
                    arrayList2.add(a5);
                }
                i5 = i6;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            iArr2[i7] = (int[]) arrayList2.get(i7);
        }
        return h(fVar.k(), iArr, a2.a.b(arrayList), a2.a.b(arrayList3), iArr2);
    }

    private static n1.e h(int i4, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i5 = 100;
        while (true) {
            int i6 = i5 - 1;
            if (i5 <= 0) {
                throw g1.d.a();
            }
            for (int i7 = 0; i7 < length; i7++) {
                iArr[iArr3[i7]] = iArr4[i7][iArr5[i7]];
            }
            try {
                return j(iArr, i4, iArr2);
            } catch (g1.d unused) {
                if (length == 0) {
                    throw g1.d.a();
                }
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        break;
                    }
                    if (iArr5[i8] < iArr4[i8].length - 1) {
                        iArr5[i8] = iArr5[i8] + 1;
                        break;
                    }
                    iArr5[i8] = 0;
                    if (i8 == length - 1) {
                        throw g1.d.a();
                    }
                    i8++;
                }
                i5 = i6;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        r3 = r27;
        r6 = r28;
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        if (r7 > r5) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (r0 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        if (r4.n(r8) != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
    
        if (r8 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        if (r8 != r5) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
    
        r9 = new b2.g(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0095, code lost:
    
        r4.q(r8, r9);
        r15 = -1;
        r14 = r10.g();
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
    
        if (r14 > r10.e()) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a5, code lost:
    
        r11 = t(r4, r8, r14, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
    
        if (r11 < 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00af, code lost:
    
        if (r11 <= r10.d()) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
    
        r19 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
    
        r20 = r13;
        r23 = r14;
        r21 = r15;
        r11 = k(r22, r10.f(), r10.d(), r0, r19, r23, r3, r6);
        r12 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00da, code lost:
    
        if (r11 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
    
        r9.f(r12, r11);
        r3 = java.lang.Math.min(r3, r11.f());
        r6 = java.lang.Math.max(r6, r11.f());
        r13 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f9, code lost:
    
        r14 = r12 + 1;
        r15 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f7, code lost:
    
        r13 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b5, code lost:
    
        if (r13 == r15) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b7, code lost:
    
        r19 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f2, code lost:
    
        r20 = r13;
        r12 = r14;
        r21 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fe, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008d, code lost:
    
        if (r8 != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008f, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0092, code lost:
    
        r9 = new b2.h(r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0091, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0078, code lost:
    
        r8 = r5 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
    
        return g(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x006c, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static n1.e i(n1.b r22, g1.s r23, g1.s r24, g1.s r25, g1.s r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.j.i(n1.b, g1.s, g1.s, g1.s, g1.s, int, int):n1.e");
    }

    private static n1.e j(int[] iArr, int i4, int[] iArr2) {
        if (iArr.length == 0) {
            throw g1.h.a();
        }
        int i5 = 1 << (i4 + 1);
        int e4 = e(iArr, iArr2, i5);
        w(iArr, i5);
        n1.e b5 = e.b(iArr, String.valueOf(i4));
        b5.k(Integer.valueOf(e4));
        b5.j(Integer.valueOf(iArr2.length));
        return b5;
    }

    private static d k(n1.b bVar, int i4, int i5, boolean z4, int i6, int i7, int i8, int i9) {
        int i10;
        int d5;
        int a5;
        int c5 = c(bVar, i4, i5, z4, i6, i7);
        int[] q4 = q(bVar, i4, i5, z4, c5, i7);
        if (q4 == null) {
            return null;
        }
        int d6 = o1.a.d(q4);
        if (z4) {
            i10 = c5 + d6;
        } else {
            for (int i11 = 0; i11 < q4.length / 2; i11++) {
                int i12 = q4[i11];
                q4[i11] = q4[(q4.length - 1) - i11];
                q4[(q4.length - 1) - i11] = i12;
            }
            c5 -= d6;
            i10 = c5;
        }
        if (d(d6, i8, i9) && (a5 = a2.a.a((d5 = i.d(q4)))) != -1) {
            return new d(c5, i10, n(d5), a5);
        }
        return null;
    }

    private static a l(h hVar, h hVar2) {
        a i4;
        a i5;
        if (hVar == null || (i4 = hVar.i()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.i();
        }
        if (hVar2 == null || (i5 = hVar2.i()) == null || i4.a() == i5.a() || i4.b() == i5.b() || i4.c() == i5.c()) {
            return i4;
        }
        return null;
    }

    private static int[] m(int i4) {
        int[] iArr = new int[8];
        int i5 = 0;
        int i6 = 7;
        while (true) {
            int i7 = i4 & 1;
            if (i7 != i5) {
                i6--;
                if (i6 < 0) {
                    return iArr;
                }
                i5 = i7;
            }
            iArr[i6] = iArr[i6] + 1;
            i4 >>= 1;
        }
    }

    private static int n(int i4) {
        return o(m(i4));
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int i4 = -1;
        for (int i5 : iArr) {
            i4 = Math.max(i4, i5);
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[EDGE_INSN: B:17:0x0027->B:18:0x0027 BREAK  A[LOOP:0: B:5:0x000c->B:13:0x000c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int[] q(n1.b r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = r2
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.e(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.j.q(n1.b, int, int, boolean, int, int):int[]");
    }

    private static int r(int i4) {
        return 2 << i4;
    }

    private static h s(n1.b bVar, c cVar, s sVar, boolean z4, int i4, int i5) {
        h hVar = new h(cVar, z4);
        int i6 = 0;
        while (i6 < 2) {
            int i7 = i6 == 0 ? 1 : -1;
            int c5 = (int) sVar.c();
            for (int d5 = (int) sVar.d(); d5 <= cVar.e() && d5 >= cVar.g(); d5 += i7) {
                d k4 = k(bVar, 0, bVar.l(), z4, c5, d5, i4, i5);
                if (k4 != null) {
                    hVar.f(d5, k4);
                    c5 = z4 ? k4.d() : k4.b();
                }
            }
            i6++;
        }
        return hVar;
    }

    private static int t(f fVar, int i4, int i5, boolean z4) {
        int i6 = z4 ? 1 : -1;
        int i7 = i4 - i6;
        d b5 = u(fVar, i7) ? fVar.n(i7).b(i5) : null;
        if (b5 != null) {
            return z4 ? b5.b() : b5.d();
        }
        d c5 = fVar.n(i4).c(i5);
        if (c5 != null) {
            return z4 ? c5.d() : c5.b();
        }
        if (u(fVar, i7)) {
            c5 = fVar.n(i7).c(i5);
        }
        if (c5 != null) {
            return z4 ? c5.b() : c5.d();
        }
        int i8 = 0;
        while (true) {
            i4 -= i6;
            if (!u(fVar, i4)) {
                c m4 = fVar.m();
                return z4 ? m4.f() : m4.d();
            }
            for (d dVar : fVar.n(i4).d()) {
                if (dVar != null) {
                    return (z4 ? dVar.b() : dVar.d()) + (i6 * i8 * (dVar.b() - dVar.d()));
                }
            }
            i8++;
        }
    }

    private static boolean u(f fVar, int i4) {
        return i4 >= 0 && i4 <= fVar.j() + 1;
    }

    private static f v(h hVar, h hVar2) {
        a l4;
        if ((hVar == null && hVar2 == null) || (l4 = l(hVar, hVar2)) == null) {
            return null;
        }
        return new f(l4, c.j(a(hVar), a(hVar2)));
    }

    private static void w(int[] iArr, int i4) {
        if (iArr.length < 4) {
            throw g1.h.a();
        }
        int i5 = iArr[0];
        if (i5 > iArr.length) {
            throw g1.h.a();
        }
        if (i5 == 0) {
            if (i4 >= iArr.length) {
                throw g1.h.a();
            }
            iArr[0] = iArr.length - i4;
        }
    }
}
