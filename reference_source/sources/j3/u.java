package j3;

import java.util.Collection;
import java.util.Iterator;
import v2.b0;

/* loaded from: classes.dex */
public class u extends t {
    public static String h(char[] cArr) {
        e3.f.e(cArr, "<this>");
        return new String(cArr);
    }

    public static String i(char[] cArr, int i4, int i5) {
        e3.f.e(cArr, "<this>");
        v2.b.f6281b.a(i4, i5, cArr.length);
        return new String(cArr, i4, i5 - i4);
    }

    public static boolean j(String str, String str2, boolean z4) {
        boolean n4;
        e3.f.e(str, "<this>");
        e3.f.e(str2, "suffix");
        if (!z4) {
            return str.endsWith(str2);
        }
        n4 = n(str, str.length() - str2.length(), str2, 0, str2.length(), true);
        return n4;
    }

    public static /* synthetic */ boolean k(String str, String str2, boolean z4, int i4, Object obj) {
        boolean j4;
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        j4 = j(str, str2, z4);
        return j4;
    }

    public static boolean l(String str, String str2, boolean z4) {
        return str == null ? str2 == null : !z4 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static final boolean m(CharSequence charSequence) {
        boolean z4;
        e3.f.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable G = v.G(charSequence);
            if (!(G instanceof Collection) || !((Collection) G).isEmpty()) {
                Iterator it = G.iterator();
                while (it.hasNext()) {
                    if (!b.c(charSequence.charAt(((b0) it).a()))) {
                        z4 = false;
                        break;
                    }
                }
            }
            z4 = true;
            if (!z4) {
                return false;
            }
        }
        return true;
    }

    public static boolean n(String str, int i4, String str2, int i5, int i6, boolean z4) {
        e3.f.e(str, "<this>");
        e3.f.e(str2, "other");
        return !z4 ? str.regionMatches(i4, str2, i5, i6) : str.regionMatches(z4, i4, str2, i5, i6);
    }

    public static /* synthetic */ boolean o(String str, int i4, String str2, int i5, int i6, boolean z4, int i7, Object obj) {
        boolean n4;
        if ((i7 & 16) != 0) {
            z4 = false;
        }
        n4 = n(str, i4, str2, i5, i6, z4);
        return n4;
    }

    public static String p(CharSequence charSequence, int i4) {
        e3.f.e(charSequence, "<this>");
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i4 + '.').toString());
        }
        if (i4 == 0) {
            return "";
        }
        if (i4 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                cArr[i5] = charAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i4);
        b0 it = new g3.f(1, i4).iterator();
        while (it.hasNext()) {
            it.a();
            sb.append(charSequence);
        }
        String sb2 = sb.toString();
        e3.f.b(sb2);
        return sb2;
    }

    public static final String q(String str, char c5, char c6, boolean z4) {
        String sb;
        String str2;
        e3.f.e(str, "<this>");
        if (z4) {
            StringBuilder sb2 = new StringBuilder(str.length());
            for (int i4 = 0; i4 < str.length(); i4++) {
                char charAt = str.charAt(i4);
                if (c.d(charAt, c5, z4)) {
                    charAt = c6;
                }
                sb2.append(charAt);
            }
            sb = sb2.toString();
            str2 = "toString(...)";
        } else {
            sb = str.replace(c5, c6);
            str2 = "replace(...)";
        }
        e3.f.d(sb, str2);
        return sb;
    }

    public static final String r(String str, String str2, String str3, boolean z4) {
        int b5;
        e3.f.e(str, "<this>");
        e3.f.e(str2, "oldValue");
        e3.f.e(str3, "newValue");
        int i4 = 0;
        int J = v.J(str, str2, 0, z4);
        if (J < 0) {
            return str;
        }
        int length = str2.length();
        b5 = g3.l.b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i4, J);
            sb.append(str3);
            i4 = J + length;
            if (J >= str.length()) {
                break;
            }
            J = v.J(str, str2, J + b5, z4);
        } while (J > 0);
        sb.append((CharSequence) str, i4, str.length());
        String sb2 = sb.toString();
        e3.f.d(sb2, "toString(...)");
        return sb2;
    }

    public static /* synthetic */ String s(String str, char c5, char c6, boolean z4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        return q(str, c5, c6, z4);
    }

    public static /* synthetic */ String t(String str, String str2, String str3, boolean z4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        return r(str, str2, str3, z4);
    }

    public static boolean u(String str, String str2, int i4, boolean z4) {
        boolean n4;
        e3.f.e(str, "<this>");
        e3.f.e(str2, "prefix");
        if (!z4) {
            return str.startsWith(str2, i4);
        }
        n4 = n(str, i4, str2, 0, str2.length(), z4);
        return n4;
    }

    public static boolean v(String str, String str2, boolean z4) {
        boolean n4;
        e3.f.e(str, "<this>");
        e3.f.e(str2, "prefix");
        if (!z4) {
            return str.startsWith(str2);
        }
        n4 = n(str, 0, str2, 0, str2.length(), z4);
        return n4;
    }

    public static /* synthetic */ boolean w(String str, String str2, int i4, boolean z4, int i5, Object obj) {
        boolean u4;
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        u4 = u(str, str2, i4, z4);
        return u4;
    }

    public static /* synthetic */ boolean x(String str, String str2, boolean z4, int i4, Object obj) {
        boolean v4;
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        v4 = v(str, str2, z4);
        return v4;
    }
}
