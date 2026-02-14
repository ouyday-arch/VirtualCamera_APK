package w3;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import l3.z;

/* loaded from: classes.dex */
public class f extends h {

    /* renamed from: d, reason: collision with root package name */
    public static final a f6450d = new a(0 == true ? 1 : 0);

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f6451e;

    /* renamed from: f, reason: collision with root package name */
    private static final Integer f6452f;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final f a() {
            if (b()) {
                return new f();
            }
            return null;
        }

        public final boolean b() {
            return f.f6451e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
    
        if (r1.intValue() >= 9) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    static {
        /*
            w3.f$a r0 = new w3.f$a
            r1 = 0
            r0.<init>(r1)
            w3.f.f6450d = r0
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L14
            java.lang.Integer r1 = j3.l.f(r0)
        L14:
            w3.f.f6452f = r1
            r0 = 1
            r2 = 0
            if (r1 == 0) goto L25
            int r1 = r1.intValue()
            r3 = 9
            if (r1 < r3) goto L23
            goto L2e
        L23:
            r0 = r2
            goto L2e
        L25:
            java.lang.Class<javax.net.ssl.SSLSocket> r1 = javax.net.ssl.SSLSocket.class
            java.lang.String r3 = "getApplicationProtocol"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L23
            r1.getMethod(r3, r4)     // Catch: java.lang.NoSuchMethodException -> L23
        L2e:
            w3.f.f6451e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.f.<clinit>():void");
    }

    @Override // w3.h
    public void e(SSLSocket sSLSocket, String str, List<z> list) {
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        sSLParameters.setApplicationProtocols((String[]) h.f6456a.b(list).toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // w3.h
    public String g(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : e3.f.a(applicationProtocol, "")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override // w3.h
    public SSLContext m() {
        SSLContext sSLContext;
        Integer num = f6452f;
        if (num != null && num.intValue() >= 9) {
            SSLContext sSLContext2 = SSLContext.getInstance("TLS");
            e3.f.d(sSLContext2, "getInstance(...)");
            return sSLContext2;
        }
        try {
            sSLContext = SSLContext.getInstance("TLSv1.3");
        } catch (NoSuchAlgorithmException unused) {
            sSLContext = SSLContext.getInstance("TLS");
        }
        e3.f.b(sSLContext);
        return sSLContext;
    }
}
