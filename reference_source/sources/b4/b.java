package b4;

import b4.d;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final d.a f2297a = new d.a();

    /* renamed from: b, reason: collision with root package name */
    private static final int f2298b = -1234567890;

    public static final boolean a(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) {
        e3.f.e(bArr, "a");
        e3.f.e(bArr2, "b");
        for (int i7 = 0; i7 < i6; i7++) {
            if (bArr[i7 + i4] != bArr2[i7 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException("size=" + j4 + " offset=" + j5 + " byteCount=" + j6);
        }
    }

    public static final int c() {
        return f2298b;
    }

    public static final int d(g gVar, int i4) {
        e3.f.e(gVar, "<this>");
        return i4 == f2298b ? gVar.y() : i4;
    }

    public static final int e(byte[] bArr, int i4) {
        e3.f.e(bArr, "<this>");
        return i4 == f2298b ? bArr.length : i4;
    }

    public static final int f(int i4) {
        return ((i4 & 255) << 24) | (((-16777216) & i4) >>> 24) | ((16711680 & i4) >>> 8) | ((65280 & i4) << 8);
    }

    public static final long g(long j4) {
        return ((j4 & 255) << 56) | (((-72057594037927936L) & j4) >>> 56) | ((71776119061217280L & j4) >>> 40) | ((280375465082880L & j4) >>> 24) | ((1095216660480L & j4) >>> 8) | ((4278190080L & j4) << 8) | ((16711680 & j4) << 24) | ((65280 & j4) << 40);
    }

    public static final short h(short s4) {
        int i4 = s4 & 65535;
        return (short) (((i4 & 255) << 8) | ((65280 & i4) >>> 8));
    }

    public static final String i(byte b5) {
        String h4;
        h4 = j3.u.h(new char[]{c4.b.f()[(b5 >> 4) & 15], c4.b.f()[b5 & 15]});
        return h4;
    }

    public static final String j(int i4) {
        String i5;
        if (i4 == 0) {
            return "0";
        }
        int i6 = 0;
        char[] cArr = {c4.b.f()[(i4 >> 28) & 15], c4.b.f()[(i4 >> 24) & 15], c4.b.f()[(i4 >> 20) & 15], c4.b.f()[(i4 >> 16) & 15], c4.b.f()[(i4 >> 12) & 15], c4.b.f()[(i4 >> 8) & 15], c4.b.f()[(i4 >> 4) & 15], c4.b.f()[i4 & 15]};
        while (i6 < 8 && cArr[i6] == '0') {
            i6++;
        }
        i5 = j3.u.i(cArr, i6, 8);
        return i5;
    }
}
