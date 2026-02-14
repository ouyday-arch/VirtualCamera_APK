package l3;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    private final a f4641a;

    /* renamed from: b, reason: collision with root package name */
    private final Proxy f4642b;

    /* renamed from: c, reason: collision with root package name */
    private final InetSocketAddress f4643c;

    public e0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        e3.f.e(aVar, "address");
        e3.f.e(proxy, "proxy");
        e3.f.e(inetSocketAddress, "socketAddress");
        this.f4641a = aVar;
        this.f4642b = proxy;
        this.f4643c = inetSocketAddress;
    }

    public final a a() {
        return this.f4641a;
    }

    public final Proxy b() {
        return this.f4642b;
    }

    public final boolean c() {
        if (this.f4642b.type() != Proxy.Type.HTTP) {
            return false;
        }
        return this.f4641a.k() != null || this.f4641a.f().contains(z.f4876h);
    }

    public final InetSocketAddress d() {
        return this.f4643c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e0) {
            e0 e0Var = (e0) obj;
            if (e3.f.a(e0Var.f4641a, this.f4641a) && e3.f.a(e0Var.f4642b, this.f4642b) && e3.f.a(e0Var.f4643c, this.f4643c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f4641a.hashCode()) * 31) + this.f4642b.hashCode()) * 31) + this.f4643c.hashCode();
    }

    public String toString() {
        String str;
        boolean B;
        boolean B2;
        String hostAddress;
        StringBuilder sb = new StringBuilder();
        String j4 = this.f4641a.l().j();
        InetAddress address = this.f4643c.getAddress();
        if (address == null || (hostAddress = address.getHostAddress()) == null) {
            str = null;
        } else {
            e3.f.b(hostAddress);
            str = m3.i.k(hostAddress);
        }
        B = j3.v.B(j4, ':', false, 2, null);
        if (B) {
            sb.append("[");
            sb.append(j4);
            sb.append("]");
        } else {
            sb.append(j4);
        }
        if (this.f4641a.l().o() != this.f4643c.getPort() || e3.f.a(j4, str)) {
            sb.append(":");
            sb.append(this.f4641a.l().o());
        }
        if (!e3.f.a(j4, str)) {
            sb.append(e3.f.a(this.f4642b, Proxy.NO_PROXY) ? " at " : " via proxy ");
            if (str == null) {
                sb.append("<unresolved>");
            } else {
                B2 = j3.v.B(str, ':', false, 2, null);
                if (B2) {
                    sb.append("[");
                    sb.append(str);
                    sb.append("]");
                } else {
                    sb.append(str);
                }
            }
            sb.append(":");
            sb.append(this.f4643c.getPort());
        }
        String sb2 = sb.toString();
        e3.f.d(sb2, "toString(...)");
        return sb2;
    }
}
