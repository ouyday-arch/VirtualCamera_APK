package a4;

import e3.f;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import w3.h;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f309a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final c a(X509TrustManager x509TrustManager) {
            f.e(x509TrustManager, "trustManager");
            return h.f6456a.g().c(x509TrustManager);
        }
    }

    public abstract List<Certificate> a(List<? extends Certificate> list, String str);
}
