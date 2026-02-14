package t3;

import j3.u;
import m3.s;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f6057a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final b4.g f6058b = b4.g.f2337e.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f6059c = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f6060d = new String[64];

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f6061e;

    static {
        String s4;
        String[] strArr = new String[256];
        for (int i4 = 0; i4 < 256; i4++) {
            String binaryString = Integer.toBinaryString(i4);
            e3.f.d(binaryString, "toBinaryString(...)");
            s4 = u.s(s.h("%8s", binaryString), ' ', '0', false, 4, null);
            strArr[i4] = s4;
        }
        f6061e = strArr;
        String[] strArr2 = f6060d;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i5 = 0; i5 < 1; i5++) {
            int i6 = iArr[i5];
            String[] strArr3 = f6060d;
            strArr3[i6 | 8] = strArr3[i6] + "|PADDED";
        }
        String[] strArr4 = f6060d;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i7 = 0; i7 < 3; i7++) {
            int i8 = iArr2[i7];
            for (int i9 = 0; i9 < 1; i9++) {
                int i10 = iArr[i9];
                String[] strArr5 = f6060d;
                int i11 = i10 | i8;
                strArr5[i11] = strArr5[i10] + '|' + strArr5[i8];
                strArr5[i11 | 8] = strArr5[i10] + '|' + strArr5[i8] + "|PADDED";
            }
        }
        int length = f6060d.length;
        for (int i12 = 0; i12 < length; i12++) {
            String[] strArr6 = f6060d;
            if (strArr6[i12] == null) {
                strArr6[i12] = f6061e[i12];
            }
        }
    }

    private f() {
    }

    public final String a(int i4, int i5) {
        String str;
        boolean z4;
        int i6;
        Object obj;
        String str2;
        String str3;
        String t4;
        if (i5 == 0) {
            return "";
        }
        if (i4 != 2 && i4 != 3) {
            if (i4 == 4 || i4 == 6) {
                return i5 == 1 ? "ACK" : f6061e[i5];
            }
            if (i4 != 7 && i4 != 8) {
                String[] strArr = f6060d;
                if (i5 < strArr.length) {
                    str = strArr[i5];
                    e3.f.b(str);
                } else {
                    str = f6061e[i5];
                }
                String str4 = str;
                if (i4 == 5 && (i5 & 4) != 0) {
                    z4 = false;
                    i6 = 4;
                    obj = null;
                    str2 = "HEADERS";
                    str3 = "PUSH_PROMISE";
                } else {
                    if (i4 != 0 || (i5 & 32) == 0) {
                        return str4;
                    }
                    z4 = false;
                    i6 = 4;
                    obj = null;
                    str2 = "PRIORITY";
                    str3 = "COMPRESSED";
                }
                t4 = u.t(str4, str2, str3, z4, i6, obj);
                return t4;
            }
        }
        return f6061e[i5];
    }

    public final String b(int i4) {
        String[] strArr = f6059c;
        return i4 < strArr.length ? strArr[i4] : s.h("0x%02x", Integer.valueOf(i4));
    }

    public final String c(boolean z4, int i4, int i5, int i6, int i7) {
        return s.h("%s 0x%08x %5d %-13s %s", z4 ? "<<" : ">>", Integer.valueOf(i4), Integer.valueOf(i5), b(i6), a(i6, i7));
    }

    public final String d(boolean z4, int i4, int i5, long j4) {
        return s.h("%s 0x%08x %5d %-13s %d", z4 ? "<<" : ">>", Integer.valueOf(i4), Integer.valueOf(i5), b(8), Long.valueOf(j4));
    }
}
