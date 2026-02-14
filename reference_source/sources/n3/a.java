package n3;

import e3.d;
import e3.f;
import j3.u;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import l3.a0;
import l3.b;
import l3.c0;
import l3.e0;
import l3.h;
import l3.p;
import l3.r;
import l3.v;
import v2.w;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: d, reason: collision with root package name */
    private final r f5345d;

    /* renamed from: n3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class C0062a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5346a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f5346a = iArr;
        }
    }

    public a(r rVar) {
        f.e(rVar, "defaultDns");
        this.f5345d = rVar;
    }

    public /* synthetic */ a(r rVar, int i4, d dVar) {
        this((i4 & 1) != 0 ? r.f4782b : rVar);
    }

    private final InetAddress b(Proxy proxy, v vVar, r rVar) {
        Object A;
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : C0062a.f5346a[type.ordinal()]) == 1) {
            A = w.A(rVar.a(vVar.j()));
            return (InetAddress) A;
        }
        SocketAddress address = proxy.address();
        f.c(address, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address2 = ((InetSocketAddress) address).getAddress();
        f.d(address2, "getAddress(...)");
        return address2;
    }

    @Override // l3.b
    public a0 a(e0 e0Var, c0 c0Var) {
        Proxy proxy;
        boolean l4;
        r rVar;
        PasswordAuthentication requestPasswordAuthentication;
        l3.a a5;
        f.e(c0Var, "response");
        List<h> L = c0Var.L();
        a0 Z = c0Var.Z();
        v i4 = Z.i();
        boolean z4 = c0Var.M() == 407;
        if (e0Var == null || (proxy = e0Var.b()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (h hVar : L) {
            l4 = u.l("Basic", hVar.d(), true);
            if (l4) {
                if (e0Var == null || (a5 = e0Var.a()) == null || (rVar = a5.c()) == null) {
                    rVar = this.f5345d;
                }
                if (z4) {
                    SocketAddress address = proxy.address();
                    f.c(address, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                    String hostName = inetSocketAddress.getHostName();
                    f.b(proxy);
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, i4, rVar), inetSocketAddress.getPort(), i4.s(), hVar.c(), hVar.d(), i4.u(), Authenticator.RequestorType.PROXY);
                } else {
                    String j4 = i4.j();
                    f.b(proxy);
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(j4, b(proxy, i4, rVar), i4.o(), i4.s(), hVar.c(), hVar.d(), i4.u(), Authenticator.RequestorType.SERVER);
                }
                if (requestPasswordAuthentication != null) {
                    String str = z4 ? "Proxy-Authorization" : "Authorization";
                    String userName = requestPasswordAuthentication.getUserName();
                    f.d(userName, "getUserName(...)");
                    char[] password = requestPasswordAuthentication.getPassword();
                    f.d(password, "getPassword(...)");
                    return Z.h().h(str, p.b(userName, new String(password), hVar.b())).b();
                }
            }
        }
        return null;
    }
}
