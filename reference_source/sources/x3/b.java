package x3;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class b extends a4.c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f6495d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final X509TrustManager f6496b;

    /* renamed from: c, reason: collision with root package name */
    private final X509TrustManagerExtensions f6497c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final b a(X509TrustManager x509TrustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            e3.f.e(x509TrustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new b(x509TrustManager, x509TrustManagerExtensions);
            }
            return null;
        }
    }

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        e3.f.e(x509TrustManager, "trustManager");
        e3.f.e(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f6496b = x509TrustManager;
        this.f6497c = x509TrustManagerExtensions;
    }

    @Override // a4.c
    public List<Certificate> a(List<? extends Certificate> list, String str) {
        e3.f.e(list, "chain");
        e3.f.e(str, "hostname");
        try {
            List<X509Certificate> checkServerTrusted = this.f6497c.checkServerTrusted((X509Certificate[]) list.toArray(new X509Certificate[0]), "RSA", str);
            e3.f.d(checkServerTrusted, "checkServerTrusted(...)");
            return checkServerTrusted;
        } catch (CertificateException e4) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e4.getMessage());
            sSLPeerUnverifiedException.initCause(e4);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f6496b == this.f6496b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f6496b);
    }
}
