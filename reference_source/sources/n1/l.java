package n1;

import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5321a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f5322b;

    static {
        String name = Charset.defaultCharset().name();
        f5321a = name;
        f5322b = "SJIS".equalsIgnoreCase(name) || "EUC_JP".equalsIgnoreCase(name);
    }

    public static String a(byte[] bArr, Map<g1.e, ?> map) {
        byte[] bArr2 = bArr;
        if (map != null) {
            g1.e eVar = g1.e.CHARACTER_SET;
            if (map.containsKey(eVar)) {
                return map.get(eVar).toString();
            }
        }
        int length = bArr2.length;
        boolean z4 = true;
        int i4 = 0;
        boolean z5 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        boolean z6 = true;
        boolean z7 = true;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i6 < length && (z4 || z6 || z7)) {
            int i16 = bArr2[i6] & 255;
            if (z7) {
                int i17 = i16 & 128;
                if (i7 > 0) {
                    if (i17 != 0) {
                        i7--;
                    }
                    z7 = false;
                } else if (i17 != 0) {
                    if ((i16 & 64) != 0) {
                        i7++;
                        if ((i16 & 32) == 0) {
                            i9++;
                        } else {
                            i7++;
                            if ((i16 & 16) == 0) {
                                i10++;
                            } else {
                                i7++;
                                if ((i16 & 8) == 0) {
                                    i11++;
                                }
                            }
                        }
                    }
                    z7 = false;
                }
            }
            if (z4) {
                if (i16 > 127 && i16 < 160) {
                    z4 = false;
                } else if (i16 > 159 && (i16 < 192 || i16 == 215 || i16 == 247)) {
                    i13++;
                }
            }
            if (z6) {
                if (i8 > 0) {
                    if (i16 >= 64 && i16 != 127 && i16 <= 252) {
                        i8--;
                    }
                    z6 = false;
                } else {
                    if (i16 != 128 && i16 != 160 && i16 <= 239) {
                        if (i16 <= 160 || i16 >= 224) {
                            if (i16 > 127) {
                                i8++;
                                int i18 = i14 + 1;
                                if (i18 > i4) {
                                    i4 = i18;
                                    i14 = i4;
                                } else {
                                    i14 = i18;
                                }
                            } else {
                                i14 = 0;
                            }
                            i15 = 0;
                        } else {
                            i5++;
                            int i19 = i15 + 1;
                            if (i19 > i12) {
                                i12 = i19;
                                i15 = i12;
                            } else {
                                i15 = i19;
                            }
                            i14 = 0;
                        }
                    }
                    z6 = false;
                }
            }
            i6++;
            bArr2 = bArr;
        }
        if (z7 && i7 > 0) {
            z7 = false;
        }
        if (z6 && i8 > 0) {
            z6 = false;
        }
        return (!z7 || (!z5 && (i9 + i10) + i11 <= 0)) ? (!z6 || (!f5322b && i12 < 3 && i4 < 3)) ? (z4 && z6) ? (!(i12 == 2 && i5 == 2) && i13 * 10 < length) ? "ISO8859_1" : "SJIS" : z4 ? "ISO8859_1" : z6 ? "SJIS" : z7 ? "UTF8" : f5321a : "SJIS" : "UTF8";
    }
}
