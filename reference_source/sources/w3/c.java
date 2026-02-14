package w3;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import l3.z;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* loaded from: classes.dex */
public final class c extends h {

    /* renamed from: e, reason: collision with root package name */
    public static final a f6434e;

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f6435f;

    /* renamed from: d, reason: collision with root package name */
    private final Provider f6436d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final c a() {
            e3.d dVar = null;
            if (b()) {
                return new c(dVar);
            }
            return null;
        }

        public final boolean b() {
            return c.f6435f;
        }
    }

    static {
        a aVar = new a(null);
        f6434e = aVar;
        boolean z4 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, aVar.getClass().getClassLoader());
            z4 = true;
        } catch (ClassNotFoundException unused) {
        }
        f6435f = z4;
    }

    private c() {
        this.f6436d = new BouncyCastleJsseProvider();
    }

    public /* synthetic */ c(e3.d dVar) {
        this();
    }

    @Override // w3.h
    public void e(SSLSocket sSLSocket, String str, List<z> list) {
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        if (!(sSLSocket instanceof BCSSLSocket)) {
            super.e(sSLSocket, str, list);
            return;
        }
        BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
        BCSSLParameters parameters = bCSSLSocket.getParameters();
        parameters.setApplicationProtocols((String[]) h.f6456a.b(list).toArray(new String[0]));
        bCSSLSocket.setParameters(parameters);
    }

    @Override // w3.h
    public String g(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        if (!(sSLSocket instanceof BCSSLSocket)) {
            return super.g(sSLSocket);
        }
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : e3.f.a(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // w3.h
    public SSLContext m() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f6436d);
        e3.f.d(sSLContext, "getInstance(...)");
        return sSLContext;
    }

    @Override // w3.h
    public X509TrustManager o() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        e3.f.b(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            e3.f.c(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return (X509TrustManager) trustManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        e3.f.d(arrays, "toString(...)");
        sb.append(arrays);
        throw new IllegalStateException(sb.toString().toString());
    }
}
