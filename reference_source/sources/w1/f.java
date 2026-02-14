package w1;

import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public final class f extends s {
    private static void h(int i4, int[] iArr) {
        for (int i5 = 0; i5 < 9; i5++) {
            int i6 = 1;
            if (((1 << (8 - i5)) & i4) != 0) {
                i6 = 2;
            }
            iArr[i5] = i6;
        }
    }

    private static String i(String str) {
        String str2;
        int i4;
        int i5;
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt != 0) {
                if (charAt != ' ') {
                    if (charAt == '@') {
                        str2 = "%V";
                    } else if (charAt == '`') {
                        str2 = "%W";
                    } else if (charAt != '-' && charAt != '.') {
                        if (charAt <= 26) {
                            sb.append('$');
                            i4 = charAt - 1;
                        } else if (charAt < ' ') {
                            sb.append('%');
                            i4 = charAt - 27;
                        } else if (charAt <= ',' || charAt == '/' || charAt == ':') {
                            sb.append('/');
                            i4 = charAt - '!';
                        } else {
                            if (charAt <= '9') {
                                i5 = (charAt - '0') + 48;
                            } else if (charAt <= '?') {
                                sb.append('%');
                                i5 = (charAt - ';') + 70;
                            } else if (charAt <= 'Z') {
                                i4 = charAt - 'A';
                            } else if (charAt <= '_') {
                                sb.append('%');
                                i5 = (charAt - '[') + 75;
                            } else if (charAt <= 'z') {
                                sb.append('+');
                                i4 = charAt - 'a';
                            } else {
                                if (charAt > 127) {
                                    throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i6) + "'");
                                }
                                sb.append('%');
                                i5 = (charAt - '{') + 80;
                            }
                            charAt = (char) i5;
                        }
                        i5 = i4 + 65;
                        charAt = (char) i5;
                    }
                }
                sb.append(charAt);
            } else {
                str2 = "%U";
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    @Override // w1.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i4)) < 0) {
                str = i(str);
                length = str.length();
                if (length > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                }
            } else {
                i4++;
            }
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[(length * 13) + 25];
        h(148, iArr);
        int b5 = s.b(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int b6 = b5 + s.b(zArr, b5, iArr2, false);
        for (int i5 = 0; i5 < length; i5++) {
            h(e.f6368e["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i5))], iArr);
            int b7 = b6 + s.b(zArr, b6, iArr, true);
            b6 = b7 + s.b(zArr, b7, iArr2, false);
        }
        h(148, iArr);
        s.b(zArr, b6, iArr, true);
        return zArr;
    }

    @Override // w1.s
    protected Collection<g1.a> f() {
        return Collections.singleton(g1.a.CODE_39);
    }
}
