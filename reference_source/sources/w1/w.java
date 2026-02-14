package w1;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f6400c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a, reason: collision with root package name */
    private final int[] f6401a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f6402b = new StringBuilder();

    private int a(n1.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f6401a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l4 = aVar.l();
        int i4 = iArr[1];
        int i5 = 0;
        for (int i6 = 0; i6 < 5 && i4 < l4; i6++) {
            int k4 = y.k(aVar, iArr2, i4, y.f6410h);
            sb.append((char) ((k4 % 10) + 48));
            for (int i7 : iArr2) {
                i4 += i7;
            }
            if (k4 >= 10) {
                i5 |= 1 << (4 - i6);
            }
            if (i6 != 4) {
                i4 = aVar.k(aVar.j(i4));
            }
        }
        if (sb.length() != 5) {
            throw g1.m.a();
        }
        if (d(sb.toString()) == c(i5)) {
            return i4;
        }
        throw g1.m.a();
    }

    private static int c(int i4) {
        for (int i5 = 0; i5 < 10; i5++) {
            if (i4 == f6400c[i5]) {
                return i5;
            }
        }
        throw g1.m.a();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        for (int i5 = length - 2; i5 >= 0; i5 -= 2) {
            i4 += charSequence.charAt(i5) - '0';
        }
        int i6 = i4 * 3;
        for (int i7 = length - 1; i7 >= 0; i7 -= 2) {
            i6 += charSequence.charAt(i7) - '0';
        }
        return (i6 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if (r5.equals("90000") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String e(java.lang.String r5) {
        /*
            r0 = 0
            char r1 = r5.charAt(r0)
            r2 = 48
            java.lang.String r3 = ""
            r4 = 1
            if (r1 == r2) goto L4d
            r2 = 53
            if (r1 == r2) goto L4a
            r2 = 57
            if (r1 == r2) goto L15
            goto L4f
        L15:
            r1 = -1
            int r2 = r5.hashCode()
            switch(r2) {
                case 54118329: goto L35;
                case 54395376: goto L2a;
                case 54395377: goto L1f;
                default: goto L1d;
            }
        L1d:
            r0 = r1
            goto L3e
        L1f:
            java.lang.String r0 = "99991"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L28
            goto L1d
        L28:
            r0 = 2
            goto L3e
        L2a:
            java.lang.String r0 = "99990"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L33
            goto L1d
        L33:
            r0 = r4
            goto L3e
        L35:
            java.lang.String r2 = "90000"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L3e
            goto L1d
        L3e:
            switch(r0) {
                case 0: goto L48;
                case 1: goto L45;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L4f
        L42:
            java.lang.String r5 = "0.00"
            return r5
        L45:
            java.lang.String r5 = "Used"
            return r5
        L48:
            r5 = 0
            return r5
        L4a:
            java.lang.String r3 = "$"
            goto L4f
        L4d:
            java.lang.String r3 = "£"
        L4f:
            java.lang.String r5 = r5.substring(r4)
            int r5 = java.lang.Integer.parseInt(r5)
            int r0 = r5 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r5 % 100
            r1 = 10
            if (r5 >= r1) goto L6e
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r1 = "0"
            java.lang.String r5 = r1.concat(r5)
            goto L72
        L6e:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L72:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.w.e(java.lang.String):java.lang.String");
    }

    private static Map<g1.r, Object> f(String str) {
        String e4;
        if (str.length() != 5 || (e4 = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(g1.r.class);
        enumMap.put((EnumMap) g1.r.SUGGESTED_PRICE, (g1.r) e4);
        return enumMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1.q b(int i4, n1.a aVar, int[] iArr) {
        StringBuilder sb = this.f6402b;
        sb.setLength(0);
        int a5 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<g1.r, Object> f4 = f(sb2);
        float f5 = i4;
        g1.q qVar = new g1.q(sb2, null, new g1.s[]{new g1.s((iArr[0] + iArr[1]) / 2.0f, f5), new g1.s(a5, f5)}, g1.a.UPC_EAN_EXTENSION);
        if (f4 != null) {
            qVar.g(f4);
        }
        return qVar;
    }
}
