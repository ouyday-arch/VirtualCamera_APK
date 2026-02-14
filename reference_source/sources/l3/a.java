package l3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import l3.v;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final r f4556a;

    /* renamed from: b, reason: collision with root package name */
    private final SocketFactory f4557b;

    /* renamed from: c, reason: collision with root package name */
    private final SSLSocketFactory f4558c;

    /* renamed from: d, reason: collision with root package name */
    private final HostnameVerifier f4559d;

    /* renamed from: e, reason: collision with root package name */
    private final g f4560e;

    /* renamed from: f, reason: collision with root package name */
    private final b f4561f;

    /* renamed from: g, reason: collision with root package name */
    private final Proxy f4562g;

    /* renamed from: h, reason: collision with root package name */
    private final ProxySelector f4563h;

    /* renamed from: i, reason: collision with root package name */
    private final v f4564i;

    /* renamed from: j, reason: collision with root package name */
    private final List<z> f4565j;

    /* renamed from: k, reason: collision with root package name */
    private final List<m> f4566k;

    public a(String str, int i4, r rVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<? extends z> list, List<m> list2, ProxySelector proxySelector) {
        e3.f.e(str, "uriHost");
        e3.f.e(rVar, "dns");
        e3.f.e(socketFactory, "socketFactory");
        e3.f.e(bVar, "proxyAuthenticator");
        e3.f.e(list, "protocols");
        e3.f.e(list2, "connectionSpecs");
        e3.f.e(proxySelector, "proxySelector");
        this.f4556a = rVar;
        this.f4557b = socketFactory;
        this.f4558c = sSLSocketFactory;
        this.f4559d = hostnameVerifier;
        this.f4560e = gVar;
        this.f4561f = bVar;
        this.f4562g = proxy;
        this.f4563h = proxySelector;
        this.f4564i = new v.a().p(sSLSocketFactory != null ? "https" : "http").k(str).n(i4).a();
        this.f4565j = m3.s.t(list);
        this.f4566k = m3.s.t(list2);
    }

    public final g a() {
        return this.f4560e;
    }

    public final List<m> b() {
        return this.f4566k;
    }

    public final r c() {
        return this.f4556a;
    }

    public final boolean d(a aVar) {
        e3.f.e(aVar, "that");
        return e3.f.a(this.f4556a, aVar.f4556a) && e3.f.a(this.f4561f, aVar.f4561f) && e3.f.a(this.f4565j, aVar.f4565j) && e3.f.a(this.f4566k, aVar.f4566k) && e3.f.a(this.f4563h, aVar.f4563h) && e3.f.a(this.f4562g, aVar.f4562g) && e3.f.a(this.f4558c, aVar.f4558c) && e3.f.a(this.f4559d, aVar.f4559d) && e3.f.a(this.f4560e, aVar.f4560e) && this.f4564i.o() == aVar.f4564i.o();
    }

    public final HostnameVerifier e() {
        return this.f4559d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (e3.f.a(this.f4564i, aVar.f4564i) && d(aVar)) {
                return true;
            }
        }
        return false;
    }

    public final List<z> f() {
        return this.f4565j;
    }

    public final Proxy g() {
        return this.f4562g;
    }

    public final b h() {
        return this.f4561f;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f4564i.hashCode()) * 31) + this.f4556a.hashCode()) * 31) + this.f4561f.hashCode()) * 31) + this.f4565j.hashCode()) * 31) + this.f4566k.hashCode()) * 31) + this.f4563h.hashCode()) * 31) + Objects.hashCode(this.f4562g)) * 31) + Objects.hashCode(this.f4558c)) * 31) + Objects.hashCode(this.f4559d)) * 31) + Objects.hashCode(this.f4560e);
    }

    public final ProxySelector i() {
        return this.f4563h;
    }

    public final SocketFactory j() {
        return this.f4557b;
    }

    public final SSLSocketFactory k() {
        return this.f4558c;
    }

    public final v l() {
        return this.f4564i;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f4564i.j());
        sb2.append(':');
        sb2.append(this.f4564i.o());
        sb2.append(", ");
        if (this.f4562g != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.f4562g;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.f4563h;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append('}');
        return sb2.toString();
    }
}
