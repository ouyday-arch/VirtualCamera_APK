package w1;

import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public class h extends s {
    private static int h(boolean[] zArr, int i4, int i5) {
        for (int i6 = 0; i6 < 9; i6++) {
            boolean z4 = true;
            int i7 = i4 + i6;
            if (((1 << (8 - i6)) & i5) == 0) {
                z4 = false;
            }
            zArr[i7] = z4;
        }
        return 9;
    }

    private static int i(String str, int i4) {
        int i5 = 0;
        int i6 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i5 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i6;
            i6++;
            if (i6 > i4) {
                i6 = 1;
            }
        }
        return i5 % 47;
    }

    static String j(String str) {
        int i4;
        String str2;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length << 1);
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt == 0) {
                str2 = "bU";
            } else {
                if (charAt <= 26) {
                    sb.append('a');
                    i4 = (charAt + 'A') - 1;
                } else if (charAt <= 31) {
                    sb.append('b');
                    i4 = (charAt + 'A') - 27;
                } else {
                    if (charAt != ' ' && charAt != '$' && charAt != '%' && charAt != '+') {
                        if (charAt <= ',') {
                            sb.append('c');
                            i4 = (charAt + 'A') - 33;
                        } else if (charAt > '9') {
                            if (charAt == ':') {
                                str2 = "cZ";
                            } else if (charAt <= '?') {
                                sb.append('b');
                                i4 = (charAt + 'F') - 59;
                            } else if (charAt == '@') {
                                str2 = "bV";
                            } else if (charAt > 'Z') {
                                if (charAt <= '_') {
                                    sb.append('b');
                                    i4 = (charAt + 'K') - 91;
                                } else if (charAt == '`') {
                                    str2 = "bW";
                                } else if (charAt <= 'z') {
                                    sb.append('d');
                                    i4 = (charAt + 'A') - 97;
                                } else {
                                    if (charAt > 127) {
                                        throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + charAt + "'");
                                    }
                                    sb.append('b');
                                    i4 = (charAt + 'P') - 123;
                                }
                            }
                        }
                    }
                    sb.append(charAt);
                }
                charAt = (char) i4;
                sb.append(charAt);
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    @Override // w1.s
    public boolean[] d(String str) {
        String j4 = j(str);
        int length = j4.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long after converting to extended encoding, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[((j4.length() + 2 + 2) * 9) + 1];
        int h4 = h(zArr, 0, g.f6375e);
        for (int i4 = 0; i4 < length; i4++) {
            h4 += h(zArr, h4, g.f6374d["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(j4.charAt(i4))]);
        }
        int i5 = i(j4, 20);
        int[] iArr = g.f6374d;
        int h5 = h4 + h(zArr, h4, iArr[i5]);
        int h6 = h5 + h(zArr, h5, iArr[i(j4 + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(i5), 15)]);
        zArr[h6 + h(zArr, h6, g.f6375e)] = true;
        return zArr;
    }

    @Override // w1.s
    protected Collection<g1.a> f() {
        return Collections.singleton(g1.a.CODE_93);
    }
}
