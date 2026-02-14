package r3;

import b4.t;
import j3.u;
import java.util.List;
import l3.a0;
import l3.b0;
import l3.c0;
import l3.d0;
import l3.n;
import l3.o;
import l3.w;
import l3.x;
import m3.s;

/* loaded from: classes.dex */
public final class a implements w {

    /* renamed from: a, reason: collision with root package name */
    private final o f5857a;

    public a(o oVar) {
        e3.f.e(oVar, "cookieJar");
        this.f5857a = oVar;
    }

    private final String b(List<n> list) {
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        for (Object obj : list) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                v2.o.q();
            }
            n nVar = (n) obj;
            if (i4 > 0) {
                sb.append("; ");
            }
            sb.append(nVar.e());
            sb.append('=');
            sb.append(nVar.g());
            i4 = i5;
        }
        String sb2 = sb.toString();
        e3.f.d(sb2, "toString(...)");
        return sb2;
    }

    @Override // l3.w
    public c0 a(w.a aVar) {
        boolean l4;
        d0 I;
        e3.f.e(aVar, "chain");
        a0 b5 = aVar.b();
        a0.a h4 = b5.h();
        b0 a5 = b5.a();
        if (a5 != null) {
            x b6 = a5.b();
            if (b6 != null) {
                h4.h("Content-Type", b6.toString());
            }
            long a6 = a5.a();
            if (a6 != -1) {
                h4.h("Content-Length", String.valueOf(a6));
                h4.l("Transfer-Encoding");
            } else {
                h4.h("Transfer-Encoding", "chunked");
                h4.l("Content-Length");
            }
        }
        boolean z4 = false;
        if (b5.d("Host") == null) {
            h4.h("Host", s.s(b5.i(), false, 1, null));
        }
        if (b5.d("Connection") == null) {
            h4.h("Connection", "Keep-Alive");
        }
        if (b5.d("Accept-Encoding") == null && b5.d("Range") == null) {
            h4.h("Accept-Encoding", "gzip");
            z4 = true;
        }
        List<n> a7 = this.f5857a.a(b5.i());
        if (!a7.isEmpty()) {
            h4.h("Cookie", b(a7));
        }
        if (b5.d("User-Agent") == null) {
            h4.h("User-Agent", "okhttp/5.0.0-alpha.12");
        }
        a0 b7 = h4.b();
        c0 a8 = aVar.a(b7);
        e.f(this.f5857a, b7.i(), a8.S());
        c0.a q4 = a8.V().q(b7);
        if (z4) {
            l4 = u.l("gzip", c0.R(a8, "Content-Encoding", null, 2, null), true);
            if (l4 && e.b(a8) && (I = a8.I()) != null) {
                b4.n nVar = new b4.n(I.L());
                q4.j(a8.S().d().f("Content-Encoding").f("Content-Length").d());
                q4.b(new h(c0.R(a8, "Content-Type", null, 2, null), -1L, t.b(nVar)));
            }
        }
        return q4.c();
    }
}
