package q3;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import l3.e0;
import l3.s;
import l3.v;
import v2.t;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: j, reason: collision with root package name */
    public static final a f5742j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final l3.a f5743a;

    /* renamed from: b, reason: collision with root package name */
    private final m f5744b;

    /* renamed from: c, reason: collision with root package name */
    private final l3.e f5745c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f5746d;

    /* renamed from: e, reason: collision with root package name */
    private final s f5747e;

    /* renamed from: f, reason: collision with root package name */
    private List<? extends Proxy> f5748f;

    /* renamed from: g, reason: collision with root package name */
    private int f5749g;

    /* renamed from: h, reason: collision with root package name */
    private List<? extends InetSocketAddress> f5750h;

    /* renamed from: i, reason: collision with root package name */
    private final List<e0> f5751i;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final String a(InetSocketAddress inetSocketAddress) {
            String hostAddress;
            String str;
            e3.f.e(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                hostAddress = inetSocketAddress.getHostName();
                str = "getHostName(...)";
            } else {
                hostAddress = address.getHostAddress();
                str = "getHostAddress(...)";
            }
            e3.f.d(hostAddress, str);
            return hostAddress;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List<e0> f5752a;

        /* renamed from: b, reason: collision with root package name */
        private int f5753b;

        public b(List<e0> list) {
            e3.f.e(list, "routes");
            this.f5752a = list;
        }

        public final List<e0> a() {
            return this.f5752a;
        }

        public final boolean b() {
            return this.f5753b < this.f5752a.size();
        }

        public final e0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<e0> list = this.f5752a;
            int i4 = this.f5753b;
            this.f5753b = i4 + 1;
            return list.get(i4);
        }
    }

    public o(l3.a aVar, m mVar, l3.e eVar, boolean z4, s sVar) {
        List<? extends Proxy> i4;
        List<? extends InetSocketAddress> i5;
        e3.f.e(aVar, "address");
        e3.f.e(mVar, "routeDatabase");
        e3.f.e(eVar, "call");
        e3.f.e(sVar, "eventListener");
        this.f5743a = aVar;
        this.f5744b = mVar;
        this.f5745c = eVar;
        this.f5746d = z4;
        this.f5747e = sVar;
        i4 = v2.o.i();
        this.f5748f = i4;
        i5 = v2.o.i();
        this.f5750h = i5;
        this.f5751i = new ArrayList();
        f(aVar.l(), aVar.g());
    }

    private final boolean b() {
        return this.f5749g < this.f5748f.size();
    }

    private final Proxy d() {
        if (b()) {
            List<? extends Proxy> list = this.f5748f;
            int i4 = this.f5749g;
            this.f5749g = i4 + 1;
            Proxy proxy = list.get(i4);
            e(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f5743a.l().j() + "; exhausted proxy configurations: " + this.f5748f);
    }

    private final void e(Proxy proxy) {
        String j4;
        int o4;
        List<InetAddress> a5;
        ArrayList arrayList = new ArrayList();
        this.f5750h = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            j4 = this.f5743a.l().j();
            o4 = this.f5743a.l().o();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + address.getClass()).toString());
            }
            a aVar = f5742j;
            e3.f.b(address);
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            j4 = aVar.a(inetSocketAddress);
            o4 = inetSocketAddress.getPort();
        }
        boolean z4 = false;
        if (1 <= o4 && o4 < 65536) {
            z4 = true;
        }
        if (!z4) {
            throw new SocketException("No route to " + j4 + ':' + o4 + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(j4, o4));
            return;
        }
        if (m3.i.a(j4)) {
            a5 = v2.n.d(InetAddress.getByName(j4));
        } else {
            this.f5747e.m(this.f5745c, j4);
            a5 = this.f5743a.c().a(j4);
            if (a5.isEmpty()) {
                throw new UnknownHostException(this.f5743a.c() + " returned no addresses for " + j4);
            }
            this.f5747e.l(this.f5745c, j4, a5);
        }
        if (this.f5746d) {
            a5 = g.a(a5);
        }
        Iterator<InetAddress> it = a5.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress(it.next(), o4));
        }
    }

    private final void f(v vVar, Proxy proxy) {
        this.f5747e.o(this.f5745c, vVar);
        List<Proxy> g4 = g(proxy, vVar, this);
        this.f5748f = g4;
        this.f5749g = 0;
        this.f5747e.n(this.f5745c, vVar, g4);
    }

    private static final List<Proxy> g(Proxy proxy, v vVar, o oVar) {
        List<Proxy> d5;
        if (proxy != null) {
            d5 = v2.n.d(proxy);
            return d5;
        }
        URI t4 = vVar.t();
        if (t4.getHost() == null) {
            return m3.s.j(Proxy.NO_PROXY);
        }
        List<Proxy> select = oVar.f5743a.i().select(t4);
        if (select == null || select.isEmpty()) {
            return m3.s.j(Proxy.NO_PROXY);
        }
        e3.f.b(select);
        return m3.s.t(select);
    }

    public final boolean a() {
        return b() || (this.f5751i.isEmpty() ^ true);
    }

    public final b c() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy d5 = d();
            Iterator<? extends InetSocketAddress> it = this.f5750h.iterator();
            while (it.hasNext()) {
                e0 e0Var = new e0(this.f5743a, d5, it.next());
                if (this.f5744b.c(e0Var)) {
                    this.f5751i.add(e0Var);
                } else {
                    arrayList.add(e0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            t.u(arrayList, this.f5751i);
            this.f5751i.clear();
        }
        return new b(arrayList);
    }
}
