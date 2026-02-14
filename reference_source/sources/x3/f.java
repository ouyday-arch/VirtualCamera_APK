package x3;

import j3.u;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import l3.z;
import x3.i;

/* loaded from: classes.dex */
public class f implements j {

    /* renamed from: f, reason: collision with root package name */
    public static final a f6502f;

    /* renamed from: g, reason: collision with root package name */
    private static final i.a f6503g;

    /* renamed from: a, reason: collision with root package name */
    private final Class<? super SSLSocket> f6504a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f6505b;

    /* renamed from: c, reason: collision with root package name */
    private final Method f6506c;

    /* renamed from: d, reason: collision with root package name */
    private final Method f6507d;

    /* renamed from: e, reason: collision with root package name */
    private final Method f6508e;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: x3.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0093a implements i.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f6509a;

            C0093a(String str) {
                this.f6509a = str;
            }

            @Override // x3.i.a
            public boolean a(SSLSocket sSLSocket) {
                boolean x4;
                e3.f.e(sSLSocket, "sslSocket");
                String name = sSLSocket.getClass().getName();
                e3.f.d(name, "getName(...)");
                x4 = u.x(name, this.f6509a + '.', false, 2, null);
                return x4;
            }

            @Override // x3.i.a
            public j b(SSLSocket sSLSocket) {
                e3.f.e(sSLSocket, "sslSocket");
                return f.f6502f.b(sSLSocket.getClass());
            }
        }

        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final f b(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> cls2 = cls;
            while (cls2 != null && !e3.f.a(cls2.getSimpleName(), "OpenSSLSocketImpl")) {
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            e3.f.b(cls2);
            return new f(cls2);
        }

        public final i.a c(String str) {
            e3.f.e(str, "packageName");
            return new C0093a(str);
        }

        public final i.a d() {
            return f.f6503g;
        }
    }

    static {
        a aVar = new a(null);
        f6502f = aVar;
        f6503g = aVar.c("com.google.android.gms.org.conscrypt");
    }

    public f(Class<? super SSLSocket> cls) {
        e3.f.e(cls, "sslSocketClass");
        this.f6504a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        e3.f.d(declaredMethod, "getDeclaredMethod(...)");
        this.f6505b = declaredMethod;
        this.f6506c = cls.getMethod("setHostname", String.class);
        this.f6507d = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f6508e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // x3.j
    public boolean a(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        return this.f6504a.isInstance(sSLSocket);
    }

    @Override // x3.j
    public boolean b() {
        return w3.b.f6429e.b();
    }

    @Override // x3.j
    public String c(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        if (!a(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f6507d.invoke(sSLSocket, new Object[0]);
            if (bArr != null) {
                return new String(bArr, j3.d.f4249b);
            }
            return null;
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if ((cause instanceof NullPointerException) && e3.f.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e5);
        }
    }

    @Override // x3.j
    public void d(SSLSocket sSLSocket, String str, List<? extends z> list) {
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        if (a(sSLSocket)) {
            try {
                this.f6505b.invoke(sSLSocket, Boolean.TRUE);
                this.f6508e.invoke(sSLSocket, w3.h.f6456a.c(list));
            } catch (IllegalAccessException e4) {
                throw new AssertionError(e4);
            } catch (InvocationTargetException e5) {
                throw new AssertionError(e5);
            }
        }
    }
}
