package l3;

import b4.g;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final b f4653c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final g f4654d = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final Set<c> f4655a;

    /* renamed from: b, reason: collision with root package name */
    private final a4.c f4656b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<c> f4657a = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        public final g a() {
            Set Q;
            Q = v2.w.Q(this.f4657a);
            return new g(Q, null, 2, 0 == true ? 1 : 0);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }

        public final String a(Certificate certificate) {
            e3.f.e(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            return "sha256/" + c((X509Certificate) certificate).a();
        }

        public final b4.g b(X509Certificate x509Certificate) {
            e3.f.e(x509Certificate, "<this>");
            g.a aVar = b4.g.f2337e;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            e3.f.d(encoded, "getEncoded(...)");
            return g.a.e(aVar, encoded, 0, 0, 3, null).w();
        }

        public final b4.g c(X509Certificate x509Certificate) {
            e3.f.e(x509Certificate, "<this>");
            g.a aVar = b4.g.f2337e;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            e3.f.d(encoded, "getEncoded(...)");
            return g.a.e(aVar, encoded, 0, 0, 3, null).x();
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f4658a;

        /* renamed from: b, reason: collision with root package name */
        private final String f4659b;

        /* renamed from: c, reason: collision with root package name */
        private final b4.g f4660c;

        public final b4.g a() {
            return this.f4660c;
        }

        public final String b() {
            return this.f4659b;
        }

        public final boolean c(String str) {
            boolean x4;
            boolean x5;
            boolean o4;
            int R;
            boolean o5;
            e3.f.e(str, "hostname");
            x4 = j3.u.x(this.f4658a, "**.", false, 2, null);
            if (x4) {
                int length = this.f4658a.length() - 3;
                int length2 = str.length() - length;
                o5 = j3.u.o(str, str.length() - length, this.f4658a, 3, length, false, 16, null);
                if (!o5) {
                    return false;
                }
                if (length2 != 0 && str.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                x5 = j3.u.x(this.f4658a, "*.", false, 2, null);
                if (!x5) {
                    return e3.f.a(str, this.f4658a);
                }
                int length3 = this.f4658a.length() - 1;
                int length4 = str.length() - length3;
                o4 = j3.u.o(str, str.length() - length3, this.f4658a, 1, length3, false, 16, null);
                if (!o4) {
                    return false;
                }
                R = j3.v.R(str, '.', length4 - 1, false, 4, null);
                if (R != -1) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return e3.f.a(this.f4658a, cVar.f4658a) && e3.f.a(this.f4659b, cVar.f4659b) && e3.f.a(this.f4660c, cVar.f4660c);
        }

        public int hashCode() {
            return (((this.f4658a.hashCode() * 31) + this.f4659b.hashCode()) * 31) + this.f4660c.hashCode();
        }

        public String toString() {
            return this.f4659b + '/' + this.f4660c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d extends e3.g implements d3.a<List<? extends X509Certificate>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<Certificate> f4662d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f4663e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(List<? extends Certificate> list, String str) {
            super(0);
            this.f4662d = list;
            this.f4663e = str;
        }

        @Override // d3.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List<X509Certificate> d() {
            List<Certificate> list;
            int r4;
            a4.c d5 = g.this.d();
            if (d5 == null || (list = d5.a(this.f4662d, this.f4663e)) == null) {
                list = this.f4662d;
            }
            r4 = v2.p.r(list, 10);
            ArrayList arrayList = new ArrayList(r4);
            for (Certificate certificate : list) {
                e3.f.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public g(Set<c> set, a4.c cVar) {
        e3.f.e(set, "pins");
        this.f4655a = set;
        this.f4656b = cVar;
    }

    public /* synthetic */ g(Set set, a4.c cVar, int i4, e3.d dVar) {
        this(set, (i4 & 2) != 0 ? null : cVar);
    }

    public final void a(String str, List<? extends Certificate> list) {
        e3.f.e(str, "hostname");
        e3.f.e(list, "peerCertificates");
        b(str, new d(list, str));
    }

    public final void b(String str, d3.a<? extends List<? extends X509Certificate>> aVar) {
        e3.f.e(str, "hostname");
        e3.f.e(aVar, "cleanedPeerCertificatesFn");
        List<c> c5 = c(str);
        if (c5.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> d5 = aVar.d();
        for (X509Certificate x509Certificate : d5) {
            b4.g gVar = null;
            b4.g gVar2 = null;
            for (c cVar : c5) {
                String b5 = cVar.b();
                if (e3.f.a(b5, "sha256")) {
                    if (gVar == null) {
                        gVar = f4653c.c(x509Certificate);
                    }
                    if (e3.f.a(cVar.a(), gVar)) {
                        return;
                    }
                } else {
                    if (!e3.f.a(b5, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + cVar.b());
                    }
                    if (gVar2 == null) {
                        gVar2 = f4653c.b(x509Certificate);
                    }
                    if (e3.f.a(cVar.a(), gVar2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : d5) {
            sb.append("\n    ");
            sb.append(f4653c.a(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        for (c cVar2 : c5) {
            sb.append("\n    ");
            sb.append(cVar2);
        }
        String sb2 = sb.toString();
        e3.f.d(sb2, "toString(...)");
        throw new SSLPeerUnverifiedException(sb2);
    }

    public final List<c> c(String str) {
        List<c> i4;
        e3.f.e(str, "hostname");
        Set<c> set = this.f4655a;
        i4 = v2.o.i();
        for (Object obj : set) {
            if (((c) obj).c(str)) {
                if (i4.isEmpty()) {
                    i4 = new ArrayList<>();
                }
                e3.f.c(i4, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal._UtilCommonKt.filterList>");
                e3.o.a(i4).add(obj);
            }
        }
        return i4;
    }

    public final a4.c d() {
        return this.f4656b;
    }

    public final g e(a4.c cVar) {
        e3.f.e(cVar, "certificateChainCleaner");
        return e3.f.a(this.f4656b, cVar) ? this : new g(this.f4655a, cVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (e3.f.a(gVar.f4655a, this.f4655a) && e3.f.a(gVar.f4656b, this.f4656b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (1517 + this.f4655a.hashCode()) * 41;
        a4.c cVar = this.f4656b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }
}
