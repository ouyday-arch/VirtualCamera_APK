package x3;

import java.util.List;
import javax.net.ssl.SSLSocket;
import l3.z;

/* loaded from: classes.dex */
public final class i implements j {

    /* renamed from: a, reason: collision with root package name */
    private final a f6514a;

    /* renamed from: b, reason: collision with root package name */
    private j f6515b;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(SSLSocket sSLSocket);

        j b(SSLSocket sSLSocket);
    }

    public i(a aVar) {
        e3.f.e(aVar, "socketAdapterFactory");
        this.f6514a = aVar;
    }

    private final synchronized j e(SSLSocket sSLSocket) {
        if (this.f6515b == null && this.f6514a.a(sSLSocket)) {
            this.f6515b = this.f6514a.b(sSLSocket);
        }
        return this.f6515b;
    }

    @Override // x3.j
    public boolean a(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        return this.f6514a.a(sSLSocket);
    }

    @Override // x3.j
    public boolean b() {
        return true;
    }

    @Override // x3.j
    public String c(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        j e4 = e(sSLSocket);
        if (e4 != null) {
            return e4.c(sSLSocket);
        }
        return null;
    }

    @Override // x3.j
    public void d(SSLSocket sSLSocket, String str, List<? extends z> list) {
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        j e4 = e(sSLSocket);
        if (e4 != null) {
            e4.d(sSLSocket, str, list);
        }
    }
}
