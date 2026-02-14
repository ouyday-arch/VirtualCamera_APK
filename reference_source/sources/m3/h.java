package m3;

import j3.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import l3.u;
import v2.t;
import v2.w;

/* loaded from: classes.dex */
public final class h {
    private static final String a(char c5) {
        int a5;
        a5 = j3.b.a(16);
        String num = Integer.toString(c5, a5);
        e3.f.d(num, "toString(...)");
        if (num.length() >= 2) {
            return num;
        }
        return '0' + num;
    }

    public static final u.a b(u.a aVar, String str, String str2) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "name");
        e3.f.e(str2, "value");
        q(str);
        r(str2, str);
        c(aVar, str, str2);
        return aVar;
    }

    public static final u.a c(u.a aVar, String str, String str2) {
        CharSequence o02;
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "name");
        e3.f.e(str2, "value");
        aVar.e().add(str);
        List<String> e4 = aVar.e();
        o02 = v.o0(str2);
        e4.add(o02.toString());
        return aVar;
    }

    public static final u d(u.a aVar) {
        e3.f.e(aVar, "<this>");
        return new u((String[]) aVar.e().toArray(new String[0]));
    }

    public static final boolean e(u uVar, Object obj) {
        e3.f.e(uVar, "<this>");
        return (obj instanceof u) && Arrays.equals(uVar.b(), ((u) obj).b());
    }

    public static final int f(u uVar) {
        e3.f.e(uVar, "<this>");
        return Arrays.hashCode(uVar.b());
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x001c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String g(java.lang.String[] r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "namesAndValues"
            e3.f.e(r4, r0)
            java.lang.String r0 = "name"
            e3.f.e(r5, r0)
            int r0 = r4.length
            int r0 = r0 + (-2)
            r1 = 0
            r2 = -2
            int r1 = z2.c.c(r0, r1, r2)
            if (r1 > r0) goto L27
        L15:
            r2 = r4[r0]
            r3 = 1
            boolean r2 = j3.l.l(r5, r2, r3)
            if (r2 == 0) goto L22
            int r0 = r0 + r3
            r4 = r4[r0]
            return r4
        L22:
            if (r0 == r1) goto L27
            int r0 = r0 + (-2)
            goto L15
        L27:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.h.g(java.lang.String[], java.lang.String):java.lang.String");
    }

    public static final u h(String... strArr) {
        CharSequence o02;
        e3.f.e(strArr, "inputNamesAndValues");
        int i4 = 0;
        if (!(strArr.length % 2 == 0)) {
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        int length = strArr2.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (!(strArr2[i5] != null)) {
                throw new IllegalArgumentException("Headers cannot be null".toString());
            }
            o02 = v.o0(strArr[i5]);
            strArr2[i5] = o02.toString();
        }
        int c5 = z2.c.c(0, strArr2.length - 1, 2);
        if (c5 >= 0) {
            while (true) {
                String str = strArr2[i4];
                String str2 = strArr2[i4 + 1];
                q(str);
                r(str2, str);
                if (i4 == c5) {
                    break;
                }
                i4 += 2;
            }
        }
        return new u(strArr2);
    }

    public static final Iterator<u2.g<String, String>> i(u uVar) {
        e3.f.e(uVar, "<this>");
        int size = uVar.size();
        u2.g[] gVarArr = new u2.g[size];
        for (int i4 = 0; i4 < size; i4++) {
            gVarArr[i4] = u2.i.a(uVar.c(i4), uVar.e(i4));
        }
        return e3.b.a(gVarArr);
    }

    public static final String j(u uVar, int i4) {
        Object r4;
        e3.f.e(uVar, "<this>");
        r4 = v2.j.r(uVar.b(), i4 * 2);
        String str = (String) r4;
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i4 + ']');
    }

    public static final u.a k(u uVar) {
        e3.f.e(uVar, "<this>");
        u.a aVar = new u.a();
        t.v(aVar.e(), uVar.b());
        return aVar;
    }

    public static final u.a l(u.a aVar, String str) {
        boolean l4;
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "name");
        int i4 = 0;
        while (i4 < aVar.e().size()) {
            l4 = j3.u.l(str, aVar.e().get(i4), true);
            if (l4) {
                aVar.e().remove(i4);
                aVar.e().remove(i4);
                i4 -= 2;
            }
            i4 += 2;
        }
        return aVar;
    }

    public static final u.a m(u.a aVar, String str, String str2) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "name");
        e3.f.e(str2, "value");
        q(str);
        r(str2, str);
        aVar.f(str);
        c(aVar, str, str2);
        return aVar;
    }

    public static final String n(u uVar) {
        e3.f.e(uVar, "<this>");
        StringBuilder sb = new StringBuilder();
        int size = uVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            String c5 = uVar.c(i4);
            String e4 = uVar.e(i4);
            sb.append(c5);
            sb.append(": ");
            if (p.y(c5)) {
                e4 = "██";
            }
            sb.append(e4);
            sb.append("\n");
        }
        String sb2 = sb.toString();
        e3.f.d(sb2, "toString(...)");
        return sb2;
    }

    public static final String o(u uVar, int i4) {
        Object r4;
        e3.f.e(uVar, "<this>");
        r4 = v2.j.r(uVar.b(), (i4 * 2) + 1);
        String str = (String) r4;
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i4 + ']');
    }

    public static final List<String> p(u uVar, String str) {
        List<String> i4;
        boolean l4;
        e3.f.e(uVar, "<this>");
        e3.f.e(str, "name");
        int size = uVar.size();
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < size; i5++) {
            l4 = j3.u.l(str, uVar.c(i5), true);
            if (l4) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(uVar.e(i5));
            }
        }
        List<String> N = arrayList != null ? w.N(arrayList) : null;
        if (N != null) {
            return N;
        }
        i4 = v2.o.i();
        return i4;
    }

    public static final void q(String str) {
        e3.f.e(str, "name");
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("name is empty".toString());
        }
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (!('!' <= charAt && charAt < 127)) {
                throw new IllegalArgumentException(("Unexpected char 0x" + a(charAt) + " at " + i4 + " in header name: " + str).toString());
            }
        }
    }

    public static final void r(String str, String str2) {
        e3.f.e(str, "value");
        e3.f.e(str2, "name");
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            boolean z4 = true;
            if (charAt != '\t') {
                if (!(' ' <= charAt && charAt < 127)) {
                    z4 = false;
                }
            }
            if (!z4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected char 0x");
                sb.append(a(charAt));
                sb.append(" at ");
                sb.append(i4);
                sb.append(" in ");
                sb.append(str2);
                sb.append(" value");
                sb.append(p.y(str2) ? "" : ": " + str);
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }
}
