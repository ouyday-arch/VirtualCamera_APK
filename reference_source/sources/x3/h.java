package x3;

import java.util.List;
import javax.net.ssl.SSLSocket;
import l3.z;
import org.conscrypt.Conscrypt;
import x3.i;

/* loaded from: classes.dex */
public final class h implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6512a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final i.a f6513b = new a();

    /* loaded from: classes.dex */
    public static final class a implements i.a {
        a() {
        }

        @Override // x3.i.a
        public boolean a(SSLSocket sSLSocket) {
            e3.f.e(sSLSocket, "sslSocket");
            return w3.d.f6437e.c() && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override // x3.i.a
        public j b(SSLSocket sSLSocket) {
            e3.f.e(sSLSocket, "sslSocket");
            return new h();
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }

        public final i.a a() {
            return h.f6513b;
        }
    }

    @Override // x3.j
    public boolean a(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // x3.j
    public boolean b() {
        return w3.d.f6437e.c();
    }

    @Override // x3.j
    public String c(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // x3.j
    public void d(SSLSocket sSLSocket, String str, List<? extends z> list) {
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) w3.h.f6456a.b(list).toArray(new String[0]));
        }
    }
}
