package w3;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import l3.y;
import l3.z;
import v2.m;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6456a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile h f6457b;

    /* renamed from: c, reason: collision with root package name */
    private static final Logger f6458c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        private final h d() {
            x3.c.f6498a.b();
            h a5 = w3.a.f6426e.a();
            if (a5 != null) {
                return a5;
            }
            h a6 = b.f6429e.a();
            e3.f.b(a6);
            return a6;
        }

        private final h e() {
            g a5;
            c a6;
            d b5;
            if (j() && (b5 = d.f6437e.b()) != null) {
                return b5;
            }
            if (i() && (a6 = c.f6434e.a()) != null) {
                return a6;
            }
            if (k() && (a5 = g.f6453e.a()) != null) {
                return a5;
            }
            f a7 = f.f6450d.a();
            if (a7 != null) {
                return a7;
            }
            h a8 = e.f6441i.a();
            return a8 != null ? a8 : new h();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final h f() {
            return h() ? d() : e();
        }

        private final boolean i() {
            return e3.f.a("BC", Security.getProviders()[0].getName());
        }

        private final boolean j() {
            return e3.f.a("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean k() {
            return e3.f.a("OpenJSSE", Security.getProviders()[0].getName());
        }

        public final List<String> b(List<? extends z> list) {
            e3.f.e(list, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((z) obj) != z.f4872d) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(m.r(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((z) it.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] c(List<? extends z> list) {
            e3.f.e(list, "protocols");
            b4.d dVar = new b4.d();
            for (String str : b(list)) {
                dVar.B(str.length());
                dVar.x(str);
            }
            return dVar.U();
        }

        public final h g() {
            return h.f6457b;
        }

        public final boolean h() {
            return e3.f.a("Dalvik", System.getProperty("java.vm.name"));
        }
    }

    static {
        a aVar = new a(null);
        f6456a = aVar;
        f6457b = aVar.f();
        f6458c = Logger.getLogger(y.class.getName());
    }

    public static /* synthetic */ void k(h hVar, String str, int i4, Throwable th, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i5 & 2) != 0) {
            i4 = 4;
        }
        if ((i5 & 4) != 0) {
            th = null;
        }
        hVar.j(str, i4, th);
    }

    public void b(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
    }

    public a4.c c(X509TrustManager x509TrustManager) {
        e3.f.e(x509TrustManager, "trustManager");
        return new a4.a(d(x509TrustManager));
    }

    public a4.e d(X509TrustManager x509TrustManager) {
        e3.f.e(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        e3.f.d(acceptedIssuers, "getAcceptedIssuers(...)");
        return new a4.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void e(SSLSocket sSLSocket, String str, List<z> list) {
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
    }

    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i4) {
        e3.f.e(socket, "socket");
        e3.f.e(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i4);
    }

    public String g(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        return null;
    }

    public Object h(String str) {
        e3.f.e(str, "closer");
        if (f6458c.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean i(String str) {
        e3.f.e(str, "hostname");
        return true;
    }

    public void j(String str, int i4, Throwable th) {
        e3.f.e(str, "message");
        f6458c.log(i4 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void l(String str, Object obj) {
        e3.f.e(str, "message");
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        j(str, 5, (Throwable) obj);
    }

    public SSLContext m() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        e3.f.d(sSLContext, "getInstance(...)");
        return sSLContext;
    }

    public SSLSocketFactory n(X509TrustManager x509TrustManager) {
        e3.f.e(x509TrustManager, "trustManager");
        try {
            SSLContext m4 = m();
            m4.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = m4.getSocketFactory();
            e3.f.d(socketFactory, "getSocketFactory(...)");
            return socketFactory;
        } catch (GeneralSecurityException e4) {
            throw new AssertionError("No System TLS: " + e4, e4);
        }
    }

    public X509TrustManager o() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    public String toString() {
        String simpleName = getClass().getSimpleName();
        e3.f.d(simpleName, "getSimpleName(...)");
        return simpleName;
    }
}
