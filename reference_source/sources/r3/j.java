package r3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import l3.a0;
import l3.b0;
import l3.c0;
import l3.e0;
import l3.v;
import l3.w;
import l3.y;
import m3.p;
import m3.s;
import v2.o;

/* loaded from: classes.dex */
public final class j implements w {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5878b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final y f5879a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    public j(y yVar) {
        e3.f.e(yVar, "client");
        this.f5879a = yVar;
    }

    private final a0 b(c0 c0Var, String str) {
        String R;
        v r4;
        b0 b0Var = null;
        if (!this.f5879a.o() || (R = c0.R(c0Var, "Location", null, 2, null)) == null || (r4 = c0Var.Z().i().r(R)) == null) {
            return null;
        }
        if (!e3.f.a(r4.s(), c0Var.Z().i().s()) && !this.f5879a.p()) {
            return null;
        }
        a0.a h4 = c0Var.Z().h();
        if (f.a(str)) {
            int M = c0Var.M();
            f fVar = f.f5864a;
            boolean z4 = fVar.c(str) || M == 308 || M == 307;
            if (fVar.b(str) && M != 308 && M != 307) {
                str = "GET";
            } else if (z4) {
                b0Var = c0Var.Z().a();
            }
            h4.j(str, b0Var);
            if (!z4) {
                h4.l("Transfer-Encoding");
                h4.l("Content-Length");
                h4.l("Content-Type");
            }
        }
        if (!s.e(c0Var.Z().i(), r4)) {
            h4.l("Authorization");
        }
        return h4.q(r4).b();
    }

    private final a0 c(c0 c0Var, q3.c cVar) {
        q3.i h4;
        e0 t4 = (cVar == null || (h4 = cVar.h()) == null) ? null : h4.t();
        int M = c0Var.M();
        String g4 = c0Var.Z().g();
        if (M != 307 && M != 308) {
            if (M == 401) {
                return this.f5879a.c().a(t4, c0Var);
            }
            if (M == 421) {
                b0 a5 = c0Var.Z().a();
                if ((a5 != null && a5.e()) || cVar == null || !cVar.l()) {
                    return null;
                }
                cVar.h().s();
                return c0Var.Z();
            }
            if (M == 503) {
                c0 W = c0Var.W();
                if ((W == null || W.M() != 503) && g(c0Var, Integer.MAX_VALUE) == 0) {
                    return c0Var.Z();
                }
                return null;
            }
            if (M == 407) {
                e3.f.b(t4);
                if (t4.b().type() == Proxy.Type.HTTP) {
                    return this.f5879a.z().a(t4, c0Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (M == 408) {
                if (!this.f5879a.C()) {
                    return null;
                }
                b0 a6 = c0Var.Z().a();
                if (a6 != null && a6.e()) {
                    return null;
                }
                c0 W2 = c0Var.W();
                if ((W2 == null || W2.M() != 408) && g(c0Var, 0) <= 0) {
                    return c0Var.Z();
                }
                return null;
            }
            switch (M) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return b(c0Var, g4);
    }

    private final boolean d(IOException iOException, boolean z4) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z4 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean e(IOException iOException, q3.h hVar, a0 a0Var, boolean z4) {
        if (this.f5879a.C()) {
            return !(z4 && f(iOException, a0Var)) && d(iOException, z4) && hVar.z();
        }
        return false;
    }

    private final boolean f(IOException iOException, a0 a0Var) {
        b0 a5 = a0Var.a();
        return (a5 != null && a5.e()) || (iOException instanceof FileNotFoundException);
    }

    private final int g(c0 c0Var, int i4) {
        String R = c0.R(c0Var, "Retry-After", null, 2, null);
        if (R == null) {
            return i4;
        }
        if (!new j3.j("\\d+").b(R)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(R);
        e3.f.d(valueOf, "valueOf(...)");
        return valueOf.intValue();
    }

    @Override // l3.w
    public c0 a(w.a aVar) {
        List i4;
        q3.c p4;
        a0 c5;
        e3.f.e(aVar, "chain");
        g gVar = (g) aVar;
        a0 j4 = gVar.j();
        q3.h g4 = gVar.g();
        i4 = o.i();
        c0 c0Var = null;
        boolean z4 = true;
        int i5 = 0;
        while (true) {
            g4.j(j4, z4, gVar);
            try {
                if (g4.u()) {
                    throw new IOException("Canceled");
                }
                try {
                    c0Var = gVar.a(j4).V().q(j4).n(c0Var != null ? m3.o.u(c0Var) : null).c();
                    p4 = g4.p();
                    c5 = c(c0Var, p4);
                } catch (IOException e4) {
                    if (!e(e4, g4, j4, !(e4 instanceof t3.a))) {
                        throw p.H(e4, i4);
                    }
                    i4 = v2.w.H(i4, e4);
                    g4.k(true);
                    z4 = false;
                }
                if (c5 == null) {
                    if (p4 != null && p4.m()) {
                        g4.A();
                    }
                    g4.k(false);
                    return c0Var;
                }
                b0 a5 = c5.a();
                if (a5 != null && a5.e()) {
                    g4.k(false);
                    return c0Var;
                }
                p.f(c0Var.I());
                i5++;
                if (i5 > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i5);
                }
                g4.k(true);
                j4 = c5;
                z4 = true;
            } catch (Throwable th) {
                g4.k(true);
                throw th;
            }
        }
    }
}
