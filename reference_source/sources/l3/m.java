package l3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: e, reason: collision with root package name */
    public static final b f4740e = new b(null);

    /* renamed from: f, reason: collision with root package name */
    private static final List<i> f4741f;

    /* renamed from: g, reason: collision with root package name */
    private static final List<i> f4742g;

    /* renamed from: h, reason: collision with root package name */
    public static final m f4743h;

    /* renamed from: i, reason: collision with root package name */
    public static final m f4744i;

    /* renamed from: j, reason: collision with root package name */
    public static final m f4745j;

    /* renamed from: k, reason: collision with root package name */
    public static final m f4746k;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4747a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4748b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f4749c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f4750d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4751a;

        /* renamed from: b, reason: collision with root package name */
        private String[] f4752b;

        /* renamed from: c, reason: collision with root package name */
        private String[] f4753c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f4754d;

        public a(m mVar) {
            e3.f.e(mVar, "connectionSpec");
            this.f4751a = mVar.f();
            this.f4752b = mVar.d();
            this.f4753c = mVar.f4750d;
            this.f4754d = mVar.h();
        }

        public a(boolean z4) {
            this.f4751a = z4;
        }

        public final m a() {
            return new m(this.f4751a, this.f4754d, this.f4752b, this.f4753c);
        }

        public final a b(String... strArr) {
            e3.f.e(strArr, "cipherSuites");
            if (!this.f4751a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
            e3.f.d(copyOf, "copyOf(...)");
            this.f4752b = (String[]) copyOf;
            return this;
        }

        public final a c(i... iVarArr) {
            e3.f.e(iVarArr, "cipherSuites");
            if (!this.f4751a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(iVarArr.length);
            for (i iVar : iVarArr) {
                arrayList.add(iVar.c());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return b((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final a d(boolean z4) {
            if (!this.f4751a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.f4754d = z4;
            return this;
        }

        public final a e(String... strArr) {
            e3.f.e(strArr, "tlsVersions");
            if (!this.f4751a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
            e3.f.d(copyOf, "copyOf(...)");
            this.f4753c = (String[]) copyOf;
            return this;
        }

        public final a f(f0... f0VarArr) {
            e3.f.e(f0VarArr, "tlsVersions");
            if (!this.f4751a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(f0VarArr.length);
            for (f0 f0Var : f0VarArr) {
                arrayList.add(f0Var.b());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return e((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }
    }

    static {
        List<i> l4;
        List<i> l5;
        i iVar = i.f4709o1;
        i iVar2 = i.f4712p1;
        i iVar3 = i.f4715q1;
        i iVar4 = i.f4667a1;
        i iVar5 = i.f4679e1;
        i iVar6 = i.f4670b1;
        i iVar7 = i.f4682f1;
        i iVar8 = i.f4700l1;
        i iVar9 = i.f4697k1;
        l4 = v2.o.l(iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9);
        f4741f = l4;
        l5 = v2.o.l(iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9, i.L0, i.M0, i.f4693j0, i.f4696k0, i.H, i.L, i.f4698l);
        f4742g = l5;
        a aVar = new a(true);
        i[] iVarArr = (i[]) l4.toArray(new i[0]);
        a c5 = aVar.c((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        f0 f0Var = f0.f4645d;
        f0 f0Var2 = f0.f4646e;
        f4743h = c5.f(f0Var, f0Var2).d(true).a();
        a aVar2 = new a(true);
        i[] iVarArr2 = (i[]) l5.toArray(new i[0]);
        f4744i = aVar2.c((i[]) Arrays.copyOf(iVarArr2, iVarArr2.length)).f(f0Var, f0Var2).d(true).a();
        a aVar3 = new a(true);
        i[] iVarArr3 = (i[]) l5.toArray(new i[0]);
        f4745j = aVar3.c((i[]) Arrays.copyOf(iVarArr3, iVarArr3.length)).f(f0Var, f0Var2, f0.f4647f, f0.f4648g).d(true).a();
        f4746k = new a(false).a();
    }

    public m(boolean z4, boolean z5, String[] strArr, String[] strArr2) {
        this.f4747a = z4;
        this.f4748b = z5;
        this.f4749c = strArr;
        this.f4750d = strArr2;
    }

    private final m g(SSLSocket sSLSocket, boolean z4) {
        String[] enabledProtocols;
        Comparator b5;
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        e3.f.b(enabledCipherSuites);
        String[] c5 = m3.c.c(this, enabledCipherSuites);
        if (this.f4750d != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            e3.f.d(enabledProtocols2, "getEnabledProtocols(...)");
            String[] strArr = this.f4750d;
            b5 = x2.b.b();
            enabledProtocols = m3.p.x(enabledProtocols2, strArr, b5);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        e3.f.b(supportedCipherSuites);
        int p4 = m3.p.p(supportedCipherSuites, "TLS_FALLBACK_SCSV", i.f4668b.c());
        if (z4 && p4 != -1) {
            String str = supportedCipherSuites[p4];
            e3.f.d(str, "get(...)");
            c5 = m3.p.g(c5, str);
        }
        a b6 = new a(this).b((String[]) Arrays.copyOf(c5, c5.length));
        e3.f.b(enabledProtocols);
        return b6.e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length)).a();
    }

    public final void b(SSLSocket sSLSocket, boolean z4) {
        e3.f.e(sSLSocket, "sslSocket");
        m g4 = g(sSLSocket, z4);
        if (g4.i() != null) {
            sSLSocket.setEnabledProtocols(g4.f4750d);
        }
        if (g4.c() != null) {
            sSLSocket.setEnabledCipherSuites(g4.f4749c);
        }
    }

    public final List<i> c() {
        String[] strArr = this.f4749c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(i.f4668b.b(str));
        }
        return arrayList;
    }

    public final String[] d() {
        return this.f4749c;
    }

    public final boolean e(SSLSocket sSLSocket) {
        Comparator b5;
        e3.f.e(sSLSocket, "socket");
        if (!this.f4747a) {
            return false;
        }
        String[] strArr = this.f4750d;
        if (strArr != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            b5 = x2.b.b();
            if (!m3.p.o(strArr, enabledProtocols, b5)) {
                return false;
            }
        }
        String[] strArr2 = this.f4749c;
        return strArr2 == null || m3.p.o(strArr2, sSLSocket.getEnabledCipherSuites(), i.f4668b.c());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z4 = this.f4747a;
        m mVar = (m) obj;
        if (z4 != mVar.f4747a) {
            return false;
        }
        return !z4 || (Arrays.equals(this.f4749c, mVar.f4749c) && Arrays.equals(this.f4750d, mVar.f4750d) && this.f4748b == mVar.f4748b);
    }

    public final boolean f() {
        return this.f4747a;
    }

    public final boolean h() {
        return this.f4748b;
    }

    public int hashCode() {
        if (!this.f4747a) {
            return 17;
        }
        String[] strArr = this.f4749c;
        int hashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f4750d;
        return ((hashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f4748b ? 1 : 0);
    }

    public final List<f0> i() {
        String[] strArr = this.f4750d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(f0.f4644c.a(str));
        }
        return arrayList;
    }

    public String toString() {
        if (!this.f4747a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(c(), "[all enabled]") + ", tlsVersions=" + Objects.toString(i(), "[all enabled]") + ", supportsTlsExtensions=" + this.f4748b + ')';
    }
}
