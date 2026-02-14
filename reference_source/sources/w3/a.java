package w3;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.util.CloseGuard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import l3.z;
import v2.o;
import x3.i;
import x3.j;

/* loaded from: classes.dex */
public final class a extends h {

    /* renamed from: e, reason: collision with root package name */
    public static final C0090a f6426e = new C0090a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f6427f;

    /* renamed from: d, reason: collision with root package name */
    private final List<j> f6428d;

    /* renamed from: w3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0090a {
        private C0090a() {
        }

        public /* synthetic */ C0090a(e3.d dVar) {
            this();
        }

        public final h a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return a.f6427f;
        }
    }

    static {
        f6427f = h.f6456a.h() && Build.VERSION.SDK_INT >= 29;
    }

    public a() {
        List m4;
        m4 = o.m(x3.a.f6494a.a(), new i(x3.f.f6502f.d()), new i(x3.h.f6512a.a()), new i(x3.g.f6510a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : m4) {
            if (((j) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.f6428d = arrayList;
    }

    @Override // w3.h
    public a4.c c(X509TrustManager x509TrustManager) {
        e3.f.e(x509TrustManager, "trustManager");
        x3.b a5 = x3.b.f6495d.a(x509TrustManager);
        return a5 != null ? a5 : super.c(x509TrustManager);
    }

    @Override // w3.h
    public void e(SSLSocket sSLSocket, String str, List<? extends z> list) {
        Object obj;
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        Iterator<T> it = this.f6428d.iterator();
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
    public String g(SSLSocket sSLSocket) {
        Object obj;
        e3.f.e(sSLSocket, "sslSocket");
        Iterator<T> it = this.f6428d.iterator();
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
    public Object h(String str) {
        e3.f.e(str, "closer");
        if (Build.VERSION.SDK_INT < 30) {
            return super.h(str);
        }
        CloseGuard closeGuard = new CloseGuard();
        closeGuard.open(str);
        return closeGuard;
    }

    @Override // w3.h
    @SuppressLint({"NewApi"})
    public boolean i(String str) {
        e3.f.e(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // w3.h
    public void l(String str, Object obj) {
        e3.f.e(str, "message");
        if (Build.VERSION.SDK_INT < 30) {
            super.l(str, obj);
        } else {
            e3.f.c(obj, "null cannot be cast to non-null type android.util.CloseGuard");
            ((CloseGuard) obj).warnIfOpen();
        }
    }
}
