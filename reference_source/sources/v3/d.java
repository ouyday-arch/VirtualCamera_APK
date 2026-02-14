package v3;

import b4.g;
import g3.f;
import g3.l;
import j3.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f6303a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final String f6304b = "xn--";

    /* renamed from: c, reason: collision with root package name */
    private static final g f6305c = g.f2337e.c("xn--");

    private d() {
    }

    private final int a(int i4, int i5, boolean z4) {
        int i6 = z4 ? i4 / 700 : i4 / 2;
        int i7 = i6 + (i6 / i5);
        int i8 = 0;
        while (i7 > 455) {
            i7 /= 35;
            i8 += 36;
        }
        return i8 + ((i7 * 36) / (i7 + 38));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [char] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    private final List<Integer> b(String str, int i4, int i5) {
        boolean e4;
        ArrayList arrayList = new ArrayList();
        while (i4 < i5) {
            int charAt = str.charAt(i4);
            e4 = j3.c.e(charAt);
            if (e4) {
                int i6 = i4 + 1;
                char charAt2 = i6 < i5 ? str.charAt(i6) : (char) 0;
                if (Character.isLowSurrogate(charAt) || !Character.isLowSurrogate(charAt2)) {
                    charAt = 63;
                } else {
                    charAt = (((charAt & 1023) << 10) | (charAt2 & 1023)) + 65536;
                    i4 = i6;
                }
            }
            arrayList.add(Integer.valueOf(charAt));
            i4++;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean d(java.lang.String r24, int r25, int r26, b4.d r27) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.d.d(java.lang.String, int, int, b4.d):boolean");
    }

    private final boolean f(String str, int i4, int i5, b4.d dVar) {
        int i6;
        f h4;
        g3.d g4;
        int i7;
        if (!h(str, i4, i5)) {
            dVar.h(str, i4, i5);
            return true;
        }
        dVar.A(f6305c);
        List<Integer> b5 = b(str, i4, i5);
        Iterator<Integer> it = b5.iterator();
        boolean z4 = false;
        int i8 = 0;
        while (true) {
            i6 = 128;
            if (!it.hasNext()) {
                break;
            }
            int intValue = it.next().intValue();
            if (intValue < 128) {
                dVar.B(intValue);
                i8++;
            }
        }
        if (i8 > 0) {
            dVar.B(45);
        }
        int i9 = 72;
        int i10 = 0;
        int i11 = i8;
        while (i11 < b5.size()) {
            Iterator<T> it2 = b5.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it2.next();
            if (it2.hasNext()) {
                int intValue2 = ((Number) next).intValue();
                if (intValue2 < i6) {
                    intValue2 = Integer.MAX_VALUE;
                }
                do {
                    Object next2 = it2.next();
                    int intValue3 = ((Number) next2).intValue();
                    if (intValue3 < i6) {
                        intValue3 = Integer.MAX_VALUE;
                    }
                    if (intValue2 > intValue3) {
                        next = next2;
                        intValue2 = intValue3;
                    }
                } while (it2.hasNext());
            }
            int intValue4 = ((Number) next).intValue();
            int i12 = (intValue4 - i6) * (i11 + 1);
            if (i10 > Integer.MAX_VALUE - i12) {
                return z4;
            }
            int i13 = i10 + i12;
            Iterator<Integer> it3 = b5.iterator();
            while (it3.hasNext()) {
                int intValue5 = it3.next().intValue();
                if (intValue5 < intValue4) {
                    if (i13 == Integer.MAX_VALUE) {
                        return z4;
                    }
                    i13++;
                } else if (intValue5 == intValue4) {
                    h4 = l.h(36, Integer.MAX_VALUE);
                    g4 = l.g(h4, 36);
                    int a5 = g4.a();
                    int b6 = g4.b();
                    int c5 = g4.c();
                    if ((c5 > 0 && a5 <= b6) || (c5 < 0 && b6 <= a5)) {
                        i7 = i13;
                        while (true) {
                            int i14 = a5 <= i9 ? 1 : a5 >= i9 + 26 ? 26 : a5 - i9;
                            if (i7 < i14) {
                                break;
                            }
                            int i15 = i7 - i14;
                            int i16 = 36 - i14;
                            dVar.B(g(i14 + (i15 % i16)));
                            i7 = i15 / i16;
                            if (a5 == b6) {
                                break;
                            }
                            a5 += c5;
                        }
                    } else {
                        i7 = i13;
                    }
                    dVar.B(g(i7));
                    int i17 = i11 + 1;
                    boolean z5 = i11 == i8;
                    i11 = i17;
                    i9 = a(i13, i17, z5);
                    z4 = false;
                    i13 = 0;
                }
            }
            i10 = i13 + 1;
            i6 = intValue4 + 1;
            z4 = false;
        }
        return true;
    }

    private final int g(int i4) {
        if (i4 < 26) {
            return i4 + 97;
        }
        if (i4 < 36) {
            return (i4 - 26) + 48;
        }
        throw new IllegalStateException(("unexpected digit: " + i4).toString());
    }

    private final boolean h(String str, int i4, int i5) {
        while (i4 < i5) {
            if (str.charAt(i4) >= 128) {
                return true;
            }
            i4++;
        }
        return false;
    }

    public final String c(String str) {
        int M;
        e3.f.e(str, "string");
        int length = str.length();
        b4.d dVar = new b4.d();
        for (int i4 = 0; i4 < length; i4 = M + 1) {
            M = v.M(str, '.', i4, false, 4, null);
            if (M == -1) {
                M = length;
            }
            if (!d(str, i4, M, dVar)) {
                return null;
            }
            if (M >= length) {
                break;
            }
            dVar.B(46);
        }
        return dVar.Z();
    }

    public final String e(String str) {
        int M;
        e3.f.e(str, "string");
        int length = str.length();
        b4.d dVar = new b4.d();
        for (int i4 = 0; i4 < length; i4 = M + 1) {
            M = v.M(str, '.', i4, false, 4, null);
            if (M == -1) {
                M = length;
            }
            if (!f(str, i4, M, dVar)) {
                return null;
            }
            if (M >= length) {
                break;
            }
            dVar.B(46);
        }
        return dVar.Z();
    }
}
