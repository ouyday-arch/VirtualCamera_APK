package m3;

import java.nio.charset.Charset;
import l3.x;

/* loaded from: classes.dex */
public final class c {
    public static final Charset a(x xVar) {
        Charset b5;
        return (xVar == null || (b5 = x.b(xVar, null, 1, null)) == null) ? j3.d.f4249b : b5;
    }

    public static final u2.g<Charset, x> b(x xVar) {
        Charset charset = j3.d.f4249b;
        if (xVar != null) {
            Charset b5 = x.b(xVar, null, 1, null);
            if (b5 == null) {
                xVar = x.f4814e.a(xVar + "; charset=utf-8");
            } else {
                charset = b5;
            }
        }
        return u2.i.a(charset, xVar);
    }

    public static final String[] c(l3.m mVar, String[] strArr) {
        e3.f.e(mVar, "<this>");
        e3.f.e(strArr, "socketEnabledCipherSuites");
        return mVar.d() != null ? p.x(mVar.d(), strArr, l3.i.f4668b.c()) : strArr;
    }
}
