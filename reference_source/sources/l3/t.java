package l3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: e, reason: collision with root package name */
    public static final a f4786e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final f0 f4787a;

    /* renamed from: b, reason: collision with root package name */
    private final i f4788b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Certificate> f4789c;

    /* renamed from: d, reason: collision with root package name */
    private final u2.c f4790d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: l3.t$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0059a extends e3.g implements d3.a<List<? extends Certificate>> {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ List<Certificate> f4791c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0059a(List<? extends Certificate> list) {
                super(0);
                this.f4791c = list;
            }

            @Override // d3.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public final List<Certificate> d() {
                return this.f4791c;
            }
        }

        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        private final List<Certificate> b(Certificate[] certificateArr) {
            List<Certificate> i4;
            if (certificateArr != null) {
                return m3.s.j(Arrays.copyOf(certificateArr, certificateArr.length));
            }
            i4 = v2.o.i();
            return i4;
        }

        public final t a(SSLSession sSLSession) {
            List<Certificate> i4;
            e3.f.e(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            if (e3.f.a(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : e3.f.a(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            i b5 = i.f4668b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (e3.f.a("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            f0 a5 = f0.f4644c.a(protocol);
            try {
                i4 = b(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                i4 = v2.o.i();
            }
            return new t(a5, b5, b(sSLSession.getLocalCertificates()), new C0059a(i4));
        }
    }

    /* loaded from: classes.dex */
    static final class b extends e3.g implements d3.a<List<? extends Certificate>> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d3.a<List<Certificate>> f4792c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(d3.a<? extends List<? extends Certificate>> aVar) {
            super(0);
            this.f4792c = aVar;
        }

        @Override // d3.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List<Certificate> d() {
            List<Certificate> i4;
            try {
                return this.f4792c.d();
            } catch (SSLPeerUnverifiedException unused) {
                i4 = v2.o.i();
                return i4;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(f0 f0Var, i iVar, List<? extends Certificate> list, d3.a<? extends List<? extends Certificate>> aVar) {
        u2.c a5;
        e3.f.e(f0Var, "tlsVersion");
        e3.f.e(iVar, "cipherSuite");
        e3.f.e(list, "localCertificates");
        e3.f.e(aVar, "peerCertificatesFn");
        this.f4787a = f0Var;
        this.f4788b = iVar;
        this.f4789c = list;
        a5 = u2.e.a(new b(aVar));
        this.f4790d = a5;
    }

    private final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        e3.f.d(type, "getType(...)");
        return type;
    }

    public final i a() {
        return this.f4788b;
    }

    public final List<Certificate> c() {
        return this.f4789c;
    }

    public final List<Certificate> d() {
        return (List) this.f4790d.getValue();
    }

    public final f0 e() {
        return this.f4787a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (tVar.f4787a == this.f4787a && e3.f.a(tVar.f4788b, this.f4788b) && e3.f.a(tVar.d(), d()) && e3.f.a(tVar.f4789c, this.f4789c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f4787a.hashCode()) * 31) + this.f4788b.hashCode()) * 31) + d().hashCode()) * 31) + this.f4789c.hashCode();
    }

    public String toString() {
        int r4;
        int r5;
        List<Certificate> d5 = d();
        r4 = v2.p.r(d5, 10);
        ArrayList arrayList = new ArrayList(r4);
        Iterator<T> it = d5.iterator();
        while (it.hasNext()) {
            arrayList.add(b((Certificate) it.next()));
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{tlsVersion=");
        sb.append(this.f4787a);
        sb.append(" cipherSuite=");
        sb.append(this.f4788b);
        sb.append(" peerCertificates=");
        sb.append(obj);
        sb.append(" localCertificates=");
        List<Certificate> list = this.f4789c;
        r5 = v2.p.r(list, 10);
        ArrayList arrayList2 = new ArrayList(r5);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(b((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
