package m3;

import j3.u;
import l3.a0;
import l3.b0;

/* loaded from: classes.dex */
public final class m {
    public static final String a(String str) {
        boolean v4;
        boolean v5;
        StringBuilder sb;
        int i4;
        e3.f.e(str, "url");
        v4 = u.v(str, "ws:", true);
        if (v4) {
            sb = new StringBuilder();
            sb.append("http:");
            i4 = 3;
        } else {
            v5 = u.v(str, "wss:", true);
            if (!v5) {
                return str;
            }
            sb = new StringBuilder();
            sb.append("https:");
            i4 = 4;
        }
        String substring = str.substring(i4);
        e3.f.d(substring, "substring(...)");
        sb.append(substring);
        return sb.toString();
    }

    public static final a0.a b(a0.a aVar, String str, String str2) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "name");
        e3.f.e(str2, "value");
        aVar.d().a(str, str2);
        return aVar;
    }

    public static final String c(a0 a0Var, String str) {
        e3.f.e(a0Var, "<this>");
        e3.f.e(str, "name");
        return a0Var.e().a(str);
    }

    public static final a0.a d(a0.a aVar, String str, String str2) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "name");
        e3.f.e(str2, "value");
        aVar.d().g(str, str2);
        return aVar;
    }

    public static final a0.a e(a0.a aVar, l3.u uVar) {
        e3.f.e(aVar, "<this>");
        e3.f.e(uVar, "headers");
        aVar.n(uVar.d());
        return aVar;
    }

    public static final a0.a f(a0.a aVar, String str, b0 b0Var) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "method");
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }
        if (b0Var == null) {
            if (!(true ^ r3.f.d(str))) {
                throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
            }
        } else if (!r3.f.a(str)) {
            throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
        }
        aVar.o(str);
        aVar.m(b0Var);
        return aVar;
    }

    public static final a0.a g(a0.a aVar, b0 b0Var) {
        e3.f.e(aVar, "<this>");
        e3.f.e(b0Var, "body");
        return aVar.j("POST", b0Var);
    }

    public static final a0.a h(a0.a aVar, String str) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "name");
        aVar.d().f(str);
        return aVar;
    }

    public static final String i(a0 a0Var) {
        e3.f.e(a0Var, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(a0Var.g());
        sb.append(", url=");
        sb.append(a0Var.i());
        if (a0Var.e().size() != 0) {
            sb.append(", headers=[");
            int i4 = 0;
            for (u2.g<? extends String, ? extends String> gVar : a0Var.e()) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    v2.o.q();
                }
                u2.g<? extends String, ? extends String> gVar2 = gVar;
                String a5 = gVar2.a();
                String b5 = gVar2.b();
                if (i4 > 0) {
                    sb.append(", ");
                }
                sb.append(a5);
                sb.append(':');
                if (p.y(a5)) {
                    b5 = "██";
                }
                sb.append(b5);
                i4 = i5;
            }
            sb.append(']');
        }
        if (!a0Var.c().isEmpty()) {
            sb.append(", tags=");
            sb.append(a0Var.c());
        }
        sb.append('}');
        String sb2 = sb.toString();
        e3.f.d(sb2, "toString(...)");
        return sb2;
    }
}
