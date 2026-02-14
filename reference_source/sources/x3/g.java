package x3;

import java.util.List;
import javax.net.ssl.SSLSocket;
import l3.z;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import x3.i;

/* loaded from: classes.dex */
public final class g implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6510a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final i.a f6511b = new a();

    /* loaded from: classes.dex */
    public static final class a implements i.a {
        a() {
        }

        @Override // x3.i.a
        public boolean a(SSLSocket sSLSocket) {
            e3.f.e(sSLSocket, "sslSocket");
            return w3.c.f6434e.b() && (sSLSocket instanceof BCSSLSocket);
        }

        @Override // x3.i.a
        public j b(SSLSocket sSLSocket) {
            e3.f.e(sSLSocket, "sslSocket");
            return new g();
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }

        public final i.a a() {
            return g.f6511b;
        }
    }

    @Override // x3.j
    public boolean a(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }

    @Override // x3.j
    public boolean b() {
        return w3.c.f6434e.b();
    }

    @Override // x3.j
    public String c(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : e3.f.a(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // x3.j
    public void d(SSLSocket sSLSocket, String str, List<? extends z> list) {
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            parameters.setApplicationProtocols((String[]) w3.h.f6456a.b(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
