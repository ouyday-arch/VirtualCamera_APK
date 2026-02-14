package w3;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import l3.z;
import v2.o;
import x3.i;
import x3.j;
import x3.k;

/* loaded from: classes.dex */
public final class b extends h {

    /* renamed from: e, reason: collision with root package name */
    public static final a f6429e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f6430f;

    /* renamed from: d, reason: collision with root package name */
    private final List<j> f6431d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final h a() {
            if (b()) {
                return new b();
            }
            return null;
        }

        public final boolean b() {
            return b.f6430f;
        }
    }

    /* renamed from: w3.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0091b implements a4.e {

        /* renamed from: a, reason: collision with root package name */
        private final X509TrustManager f6432a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f6433b;

        public C0091b(X509TrustManager x509TrustManager, Method method) {
            e3.f.e(x509TrustManager, "trustManager");
            e3.f.e(method, "findByIssuerAndSignatureMethod");
            this.f6432a = x509TrustManager;
            this.f6433b = method;
        }

        @Override // a4.e
        public X509Certificate a(X509Certificate x509Certificate) {
            e3.f.e(x509Certificate, "cert");
            try {
                Object invoke = this.f6433b.invoke(this.f6432a, x509Certificate);
                e3.f.c(invoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) invoke).getTrustedCert();
            } catch (IllegalAccessException e4) {
                throw new AssertionError("unable to get issues and signature", e4);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0091b)) {
                return false;
            }
            C0091b c0091b = (C0091b) obj;
            return e3.f.a(this.f6432a, c0091b.f6432a) && e3.f.a(this.f6433b, c0091b.f6433b);
        }

        public int hashCode() {
            return (this.f6432a.hashCode() * 31) + this.f6433b.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f6432a + ", findByIssuerAndSignatureMethod=" + this.f6433b + ')';
        }
    }

    static {
        boolean z4 = false;
        if (h.f6456a.h() && Build.VERSION.SDK_INT < 30) {
            z4 = true;
        }
        f6430f = z4;
    }

    public b() {
        List m4;
        m4 = o.m(k.a.b(k.f6516j, null, 1, null), new i(x3.f.f6502f.d()), new i(x3.h.f6512a.a()), new i(x3.g.f6510a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : m4) {
            if (((j) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.f6431d = arrayList;
    }

    @Override // w3.h
    public a4.c c(X509TrustManager x509TrustManager) {
        e3.f.e(x509TrustManager, "trustManager");
        x3.b a5 = x3.b.f6495d.a(x509TrustManager);
        return a5 != null ? a5 : super.c(x509TrustManager);
    }

    @Override // w3.h
    public a4.e d(X509TrustManager x509TrustManager) {
        e3.f.e(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            e3.f.b(declaredMethod);
            return new C0091b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    @Override // w3.h
    public void e(SSLSocket sSLSocket, String str, List<z> list) {
        Object obj;
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        Iterator<T> it = this.f6431d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((j) obj).a(sSLSocket)) {
                    break;
                }
            }
        }
        j jVar = (j) obj;
        if (jVar != null) {
            jVar.d(sSLSocket, str, list);
        }
    }

    @Override // w3.h
    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i4) {
        e3.f.e(socket, "socket");
        e3.f.e(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i4);
        } catch (ClassCastException e4) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e4;
            }
            throw new IOException("Exception in connect", e4);
        }
    }

    @Override // w3.h
    public String g(SSLSocket sSLSocket) {
        Object obj;
        e3.f.e(sSLSocket, "sslSocket");
        Iterator<T> it = this.f6431d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((j) obj).a(sSLSocket)) {
                break;
            }
        }
        j jVar = (j) obj;
        if (jVar != null) {
            return jVar.c(sSLSocket);
        }
        return null;
    }

    @Override // w3.h
    public boolean i(String str) {
        e3.f.e(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
