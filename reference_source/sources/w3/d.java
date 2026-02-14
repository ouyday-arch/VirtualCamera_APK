package w3;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import l3.z;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* loaded from: classes.dex */
public final class d extends h {

    /* renamed from: e, reason: collision with root package name */
    public static final a f6437e;

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f6438f;

    /* renamed from: d, reason: collision with root package name */
    private final Provider f6439d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final boolean a(int i4, int i5, int i6) {
            Conscrypt.Version version = Conscrypt.version();
            if (version == null) {
                return false;
            }
            return version.major() != i4 ? version.major() > i4 : version.minor() != i5 ? version.minor() > i5 : version.patch() >= i6;
        }

        public final d b() {
            e3.d dVar = null;
            if (c()) {
                return new d(dVar);
            }
            return null;
        }

        public final boolean c() {
            return d.f6438f;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements ConscryptHostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        public static final b f6440a = new b();

        private b() {
        }
    }

    static {
        a aVar = new a(null);
        f6437e = aVar;
        boolean z4 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (aVar.a(2, 1, 0)) {
                    z4 = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f6438f = z4;
    }

    private d() {
        Provider newProvider = Conscrypt.newProvider();
        e3.f.d(newProvider, "newProvider(...)");
        this.f6439d = newProvider;
    }

    public /* synthetic */ d(e3.d dVar) {
        this();
    }

    @Override // w3.h
    public void e(SSLSocket sSLSocket, String str, List<z> list) {
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.e(sSLSocket, str, list);
        } else {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) h.f6456a.b(list).toArray(new String[0]));
        }
    }

    @Override // w3.h
    public String g(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.g(sSLSocket);
    }

    @Override // w3.h
    public SSLContext m() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f6439d);
        e3.f.d(sSLContext, "getInstance(...)");
        return sSLContext;
    }

    @Override // w3.h
    public SSLSocketFactory n(X509TrustManager x509TrustManager) {
        e3.f.e(x509TrustManager, "trustManager");
        SSLContext m4 = m();
        m4.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = m4.getSocketFactory();
        e3.f.d(socketFactory, "getSocketFactory(...)");
        return socketFactory;
    }

    @Override // w3.h
    public X509TrustManager o() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        e3.f.b(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            e3.f.c(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
            Conscrypt.setHostnameVerifier(x509TrustManager, b.f6440a);
            return x509TrustManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        e3.f.d(arrays, "toString(...)");
        sb.append(arrays);
        throw new IllegalStateException(sb.toString().toString());
    }
}
