package m3;

import l3.a0;
import l3.c0;
import l3.d0;
import l3.u;
import l3.z;

/* loaded from: classes.dex */
public final class o {
    private static final void a(String str, c0 c0Var) {
        if (c0Var != null) {
            if (!(c0Var.U() == null)) {
                throw new IllegalArgumentException((str + ".networkResponse != null").toString());
            }
            if (!(c0Var.K() == null)) {
                throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
            }
            if (c0Var.W() == null) {
                return;
            }
            throw new IllegalArgumentException((str + ".priorResponse != null").toString());
        }
    }

    public static final c0.a b(c0.a aVar, String str, String str2) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "name");
        e3.f.e(str2, "value");
        aVar.g().a(str, str2);
        return aVar;
    }

    public static final c0.a c(c0.a aVar, d0 d0Var) {
        e3.f.e(aVar, "<this>");
        e3.f.e(d0Var, "body");
        aVar.s(d0Var);
        return aVar;
    }

    public static final c0.a d(c0.a aVar, c0 c0Var) {
        e3.f.e(aVar, "<this>");
        a("cacheResponse", c0Var);
        aVar.t(c0Var);
        return aVar;
    }

    public static final void e(c0 c0Var) {
        e3.f.e(c0Var, "<this>");
        c0Var.I().close();
    }

    public static final c0.a f(c0.a aVar, int i4) {
        e3.f.e(aVar, "<this>");
        aVar.u(i4);
        return aVar;
    }

    public static final String g(c0 c0Var, String str, String str2) {
        e3.f.e(c0Var, "<this>");
        e3.f.e(str, "name");
        String a5 = c0Var.S().a(str);
        return a5 == null ? str2 : a5;
    }

    public static final c0.a h(c0.a aVar, String str, String str2) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "name");
        e3.f.e(str2, "value");
        aVar.g().g(str, str2);
        return aVar;
    }

    public static final c0.a i(c0.a aVar, u uVar) {
        e3.f.e(aVar, "<this>");
        e3.f.e(uVar, "headers");
        aVar.v(uVar.d());
        return aVar;
    }

    public static final c0.a j(c0.a aVar, String str) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "message");
        aVar.w(str);
        return aVar;
    }

    public static final c0.a k(c0.a aVar, c0 c0Var) {
        e3.f.e(aVar, "<this>");
        a("networkResponse", c0Var);
        aVar.x(c0Var);
        return aVar;
    }

    public static final c0.a l(c0 c0Var) {
        e3.f.e(c0Var, "<this>");
        return new c0.a(c0Var);
    }

    public static final c0.a m(c0.a aVar, c0 c0Var) {
        e3.f.e(aVar, "<this>");
        aVar.y(c0Var);
        return aVar;
    }

    public static final c0.a n(c0.a aVar, z zVar) {
        e3.f.e(aVar, "<this>");
        e3.f.e(zVar, "protocol");
        aVar.z(zVar);
        return aVar;
    }

    public static final c0.a o(c0.a aVar, a0 a0Var) {
        e3.f.e(aVar, "<this>");
        e3.f.e(a0Var, "request");
        aVar.A(a0Var);
        return aVar;
    }

    public static final String p(c0 c0Var) {
        e3.f.e(c0Var, "<this>");
        return "Response{protocol=" + c0Var.X() + ", code=" + c0Var.M() + ", message=" + c0Var.T() + ", url=" + c0Var.Z().i() + '}';
    }

    public static final c0.a q(c0.a aVar, d3.a<u> aVar2) {
        e3.f.e(aVar, "<this>");
        e3.f.e(aVar2, "trailersFn");
        aVar.B(aVar2);
        return aVar;
    }

    public static final l3.d r(c0 c0Var) {
        e3.f.e(c0Var, "<this>");
        l3.d O = c0Var.O();
        if (O != null) {
            return O;
        }
        l3.d a5 = l3.d.f4616n.a(c0Var.S());
        c0Var.b0(a5);
        return a5;
    }

    public static final boolean s(c0 c0Var) {
        e3.f.e(c0Var, "<this>");
        int M = c0Var.M();
        if (M != 307 && M != 308) {
            switch (M) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static final boolean t(c0 c0Var) {
        e3.f.e(c0Var, "<this>");
        int M = c0Var.M();
        return 200 <= M && M < 300;
    }

    public static final c0 u(c0 c0Var) {
        e3.f.e(c0Var, "<this>");
        return c0Var.V().b(new e(c0Var.I().K(), c0Var.I().J())).c();
    }
}
