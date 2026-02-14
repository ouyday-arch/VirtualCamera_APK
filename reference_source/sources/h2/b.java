package h2;

import g1.m;
import g1.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final n1.b f4078a;

    /* renamed from: c, reason: collision with root package name */
    private final int f4080c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4081d;

    /* renamed from: e, reason: collision with root package name */
    private final int f4082e;

    /* renamed from: f, reason: collision with root package name */
    private final int f4083f;

    /* renamed from: g, reason: collision with root package name */
    private final float f4084g;

    /* renamed from: i, reason: collision with root package name */
    private final t f4086i;

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f4079b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    private final int[] f4085h = new int[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(n1.b bVar, int i4, int i5, int i6, int i7, float f4, t tVar) {
        this.f4078a = bVar;
        this.f4080c = i4;
        this.f4081d = i5;
        this.f4082e = i6;
        this.f4083f = i7;
        this.f4084g = f4;
        this.f4086i = tVar;
    }

    private static float a(int[] iArr, int i4) {
        return (i4 - iArr[2]) - (iArr[1] / 2.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        if (r2[1] <= r12) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r10 >= r1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
    
        if (r0.e(r11, r10) != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
    
        if (r2[2] > r12) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
    
        r2[2] = r2[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (r2[2] <= r12) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008e, code lost:
    
        if ((java.lang.Math.abs(((r2[0] + r2[1]) + r2[2]) - r13) * 5) < (r13 * 2)) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0090, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
    
        if (d(r2) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009b, code lost:
    
        return a(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float b(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            n1.b r0 = r9.f4078a
            int r1 = r0.h()
            int[] r2 = r9.f4085h
            r3 = 0
            r2[r3] = r3
            r4 = 1
            r2[r4] = r3
            r5 = 2
            r2[r5] = r3
            r6 = r10
        L12:
            if (r6 < 0) goto L26
            boolean r7 = r0.e(r11, r6)
            if (r7 == 0) goto L26
            r7 = r2[r4]
            if (r7 > r12) goto L26
            r7 = r2[r4]
            int r7 = r7 + r4
            r2[r4] = r7
            int r6 = r6 + (-1)
            goto L12
        L26:
            r7 = 2143289344(0x7fc00000, float:NaN)
            if (r6 < 0) goto L9c
            r8 = r2[r4]
            if (r8 <= r12) goto L30
            goto L9c
        L30:
            if (r6 < 0) goto L44
            boolean r8 = r0.e(r11, r6)
            if (r8 != 0) goto L44
            r8 = r2[r3]
            if (r8 > r12) goto L44
            r8 = r2[r3]
            int r8 = r8 + r4
            r2[r3] = r8
            int r6 = r6 + (-1)
            goto L30
        L44:
            r6 = r2[r3]
            if (r6 <= r12) goto L49
            return r7
        L49:
            int r10 = r10 + r4
        L4a:
            if (r10 >= r1) goto L5e
            boolean r6 = r0.e(r11, r10)
            if (r6 == 0) goto L5e
            r6 = r2[r4]
            if (r6 > r12) goto L5e
            r6 = r2[r4]
            int r6 = r6 + r4
            r2[r4] = r6
            int r10 = r10 + 1
            goto L4a
        L5e:
            if (r10 == r1) goto L9c
            r6 = r2[r4]
            if (r6 <= r12) goto L65
            goto L9c
        L65:
            if (r10 >= r1) goto L79
            boolean r6 = r0.e(r11, r10)
            if (r6 != 0) goto L79
            r6 = r2[r5]
            if (r6 > r12) goto L79
            r6 = r2[r5]
            int r6 = r6 + r4
            r2[r5] = r6
            int r10 = r10 + 1
            goto L65
        L79:
            r11 = r2[r5]
            if (r11 <= r12) goto L7e
            return r7
        L7e:
            r11 = r2[r3]
            r12 = r2[r4]
            int r11 = r11 + r12
            r12 = r2[r5]
            int r11 = r11 + r12
            int r11 = r11 - r13
            int r11 = java.lang.Math.abs(r11)
            int r11 = r11 * 5
            int r13 = r13 * r5
            if (r11 < r13) goto L91
            return r7
        L91:
            boolean r11 = r9.d(r2)
            if (r11 == 0) goto L9c
            float r10 = a(r2, r10)
            return r10
        L9c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.b.b(int, int, int, int):float");
    }

    private boolean d(int[] iArr) {
        float f4 = this.f4084g;
        float f5 = f4 / 2.0f;
        for (int i4 = 0; i4 < 3; i4++) {
            if (Math.abs(f4 - iArr[i4]) >= f5) {
                return false;
            }
        }
        return true;
    }

    private a e(int[] iArr, int i4, int i5) {
        int i6 = iArr[0] + iArr[1] + iArr[2];
        float a5 = a(iArr, i5);
        float b5 = b(i4, (int) a5, iArr[1] * 2, i6);
        if (Float.isNaN(b5)) {
            return null;
        }
        float f4 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f4079b) {
            if (aVar.f(f4, b5, a5)) {
                return aVar.g(b5, a5, f4);
            }
        }
        a aVar2 = new a(a5, b5, f4);
        this.f4079b.add(aVar2);
        t tVar = this.f4086i;
        if (tVar == null) {
            return null;
        }
        tVar.a(aVar2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c() {
        a e4;
        a e5;
        int i4 = this.f4080c;
        int i5 = this.f4083f;
        int i6 = this.f4082e + i4;
        int i7 = this.f4081d + (i5 / 2);
        int[] iArr = new int[3];
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = ((i8 & 1) == 0 ? (i8 + 1) / 2 : -((i8 + 1) / 2)) + i7;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i10 = i4;
            while (i10 < i6 && !this.f4078a.e(i10, i9)) {
                i10++;
            }
            int i11 = 0;
            while (i10 < i6) {
                if (!this.f4078a.e(i10, i9)) {
                    if (i11 == 1) {
                        i11++;
                    }
                    iArr[i11] = iArr[i11] + 1;
                } else if (i11 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i11 != 2) {
                    i11++;
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    if (d(iArr) && (e5 = e(iArr, i9, i10)) != null) {
                        return e5;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i11 = 1;
                }
                i10++;
            }
            if (d(iArr) && (e4 = e(iArr, i9, i6)) != null) {
                return e4;
            }
        }
        if (this.f4079b.isEmpty()) {
            throw m.a();
        }
        return this.f4079b.get(0);
    }
}
