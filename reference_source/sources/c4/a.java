package c4;

import b4.b0;
import b4.k0;
import b4.w;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private static final byte[] f2454a = k0.a("0123456789abcdef");

    public static final byte[] a() {
        return f2454a;
    }

    public static final String b(b4.d dVar, long j4) {
        e3.f.e(dVar, "<this>");
        if (j4 > 0) {
            long j5 = j4 - 1;
            if (dVar.N(j5) == 13) {
                String e4 = dVar.e(j5);
                dVar.o(2L);
                return e4;
            }
        }
        String e5 = dVar.e(j4);
        dVar.o(1L);
        return e5;
    }

    public static final int c(b4.d dVar, w wVar, boolean z4) {
        int i4;
        int i5;
        int i6;
        int i7;
        b0 b0Var;
        e3.f.e(dVar, "<this>");
        e3.f.e(wVar, "options");
        b0 b0Var2 = dVar.f2325b;
        if (b0Var2 == null) {
            return z4 ? -2 : -1;
        }
        byte[] bArr = b0Var2.f2300a;
        int i8 = b0Var2.f2301b;
        int i9 = b0Var2.f2302c;
        int[] e4 = wVar.e();
        b0 b0Var3 = b0Var2;
        int i10 = -1;
        int i11 = 0;
        loop0: while (true) {
            int i12 = i11 + 1;
            int i13 = e4[i11];
            int i14 = i12 + 1;
            int i15 = e4[i12];
            if (i15 != -1) {
                i10 = i15;
            }
            if (b0Var3 == null) {
                break;
            }
            if (i13 >= 0) {
                i4 = i8 + 1;
                int i16 = bArr[i8] & 255;
                int i17 = i14 + i13;
                while (i14 != i17) {
                    if (i16 == e4[i14]) {
                        i5 = e4[i14 + i13];
                        if (i4 == i9) {
                            b0Var3 = b0Var3.f2305f;
                            e3.f.b(b0Var3);
                            i4 = b0Var3.f2301b;
                            bArr = b0Var3.f2300a;
                            i9 = b0Var3.f2302c;
                            if (b0Var3 == b0Var2) {
                                b0Var3 = null;
                            }
                        }
                    } else {
                        i14++;
                    }
                }
                return i10;
            }
            int i18 = i14 + (i13 * (-1));
            while (true) {
                int i19 = i8 + 1;
                int i20 = i14 + 1;
                if ((bArr[i8] & 255) != e4[i14]) {
                    return i10;
                }
                boolean z5 = i20 == i18;
                if (i19 == i9) {
                    e3.f.b(b0Var3);
                    b0 b0Var4 = b0Var3.f2305f;
                    e3.f.b(b0Var4);
                    i7 = b0Var4.f2301b;
                    byte[] bArr2 = b0Var4.f2300a;
                    i6 = b0Var4.f2302c;
                    if (b0Var4 != b0Var2) {
                        b0Var = b0Var4;
                        bArr = bArr2;
                    } else {
                        if (!z5) {
                            break loop0;
                        }
                        bArr = bArr2;
                        b0Var = null;
                    }
                } else {
                    b0 b0Var5 = b0Var3;
                    i6 = i9;
                    i7 = i19;
                    b0Var = b0Var5;
                }
                if (z5) {
                    i5 = e4[i20];
                    i4 = i7;
                    i9 = i6;
                    b0Var3 = b0Var;
                    break;
                }
                i8 = i7;
                i9 = i6;
                i14 = i20;
                b0Var3 = b0Var;
            }
            if (i5 >= 0) {
                return i5;
            }
            i11 = -i5;
            i8 = i4;
        }
        if (z4) {
            return -2;
        }
        return i10;
    }

    public static /* synthetic */ int d(b4.d dVar, w wVar, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return c(dVar, wVar, z4);
    }
}
