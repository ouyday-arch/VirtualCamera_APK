package x3;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import l3.z;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public final class a implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final C0092a f6494a = new C0092a(null);

    /* renamed from: x3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0092a {
        private C0092a() {
        }

        public /* synthetic */ C0092a(e3.d dVar) {
            this();
        }

        public final j a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return w3.h.f6456a.h() && Build.VERSION.SDK_INT >= 29;
        }
    }

    @Override // x3.j
    public boolean a(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // x3.j
    public boolean b() {
        return f6494a.b();
    }

    @Override // x3.j
    @SuppressLint({"NewApi"})
    public String c(SSLSocket sSLSocket) {
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

    @Override // x3.j
    @SuppressLint({"NewApi"})
    public void d(SSLSocket sSLSocket, String str, List<? extends z> list) {
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) w3.h.f6456a.b(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e4) {
            throw new IOException("Android internal error", e4);
        }
    }
}
