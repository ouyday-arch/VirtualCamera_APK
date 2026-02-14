package r3;

import java.net.Proxy;
import l3.a0;
import l3.v;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f5877a = new i();

    private i() {
    }

    private final boolean b(a0 a0Var, Proxy.Type type) {
        return !a0Var.f() && type == Proxy.Type.HTTP;
    }

    public final String a(a0 a0Var, Proxy.Type type) {
        e3.f.e(a0Var, "request");
        e3.f.e(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(a0Var.g());
        sb.append(' ');
        i iVar = f5877a;
        boolean b5 = iVar.b(a0Var, type);
        v i4 = a0Var.i();
        if (b5) {
            sb.append(i4);
        } else {
            sb.append(iVar.c(i4));
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        e3.f.d(sb2, "toString(...)");
        return sb2;
    }

    public final String c(v vVar) {
        e3.f.e(vVar, "url");
        String c5 = vVar.c();
        String e4 = vVar.e();
        if (e4 == null) {
            return c5;
        }
        return c5 + '?' + e4;
    }
}
