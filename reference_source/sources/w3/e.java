package w3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import l3.z;

/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: i, reason: collision with root package name */
    public static final b f6441i = new b(null);

    /* renamed from: d, reason: collision with root package name */
    private final Method f6442d;

    /* renamed from: e, reason: collision with root package name */
    private final Method f6443e;

    /* renamed from: f, reason: collision with root package name */
    private final Method f6444f;

    /* renamed from: g, reason: collision with root package name */
    private final Class<?> f6445g;

    /* renamed from: h, reason: collision with root package name */
    private final Class<?> f6446h;

    /* loaded from: classes.dex */
    private static final class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f6447a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f6448b;

        /* renamed from: c, reason: collision with root package name */
        private String f6449c;

        public a(List<String> list) {
            e3.f.e(list, "protocols");
            this.f6447a = list;
        }

        public final String a() {
            return this.f6449c;
        }

        public final boolean b() {
            return this.f6448b;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            e3.f.e(obj, "proxy");
            e3.f.e(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (e3.f.a(name, "supports") && e3.f.a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (e3.f.a(name, "unsupported") && e3.f.a(Void.TYPE, returnType)) {
                this.f6448b = true;
                return null;
            }
            if (e3.f.a(name, "protocols")) {
                if (objArr.length == 0) {
                    return this.f6447a;
                }
            }
            if ((!e3.f.a(name, "selectProtocol") && !e3.f.a(name, "select")) || !e3.f.a(String.class, returnType) || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!e3.f.a(name, "protocolSelected") && !e3.f.a(name, "selected")) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                }
                Object obj2 = objArr[0];
                e3.f.c(obj2, "null cannot be cast to non-null type kotlin.String");
                this.f6449c = (String) obj2;
                return null;
            }
            Object obj3 = objArr[0];
            e3.f.c(obj3, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) obj3;
            int size = list.size();
            if (size >= 0) {
                int i4 = 0;
                while (true) {
                    Object obj4 = list.get(i4);
                    e3.f.c(obj4, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) obj4;
                    if (!this.f6447a.contains(str)) {
                        if (i4 == size) {
                            break;
                        }
                        i4++;
                    } else {
                        this.f6449c = str;
                        return str;
                    }
                }
            }
            String str2 = this.f6447a.get(0);
            this.f6449c = str2;
            return str2;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }

        public final h a() {
            String property = System.getProperty("java.specification.version", "unknown");
            try {
                e3.f.b(property);
                if (Integer.parseInt(property) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method method = cls.getMethod("put", SSLSocket.class, cls2);
                Method method2 = cls.getMethod("get", SSLSocket.class);
                Method method3 = cls.getMethod("remove", SSLSocket.class);
                e3.f.b(method);
                e3.f.b(method2);
                e3.f.b(method3);
                e3.f.b(cls3);
                e3.f.b(cls4);
                return new e(method, method2, method3, cls3, cls4);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }
    }

    public e(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        e3.f.e(method, "putMethod");
        e3.f.e(method2, "getMethod");
        e3.f.e(method3, "removeMethod");
        e3.f.e(cls, "clientProviderClass");
        e3.f.e(cls2, "serverProviderClass");
        this.f6442d = method;
        this.f6443e = method2;
        this.f6444f = method3;
        this.f6445g = cls;
        this.f6446h = cls2;
    }

    @Override // w3.h
    public void b(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        try {
            this.f6444f.invoke(null, sSLSocket);
        } catch (IllegalAccessException e4) {
            throw new AssertionError("failed to remove ALPN", e4);
        } catch (InvocationTargetException e5) {
            throw new AssertionError("failed to remove ALPN", e5);
        }
    }

    @Override // w3.h
    public void e(SSLSocket sSLSocket, String str, List<? extends z> list) {
        e3.f.e(sSLSocket, "sslSocket");
        e3.f.e(list, "protocols");
        try {
            this.f6442d.invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f6445g, this.f6446h}, new a(h.f6456a.b(list))));
        } catch (IllegalAccessException e4) {
            throw new AssertionError("failed to set ALPN", e4);
        } catch (InvocationTargetException e5) {
            throw new AssertionError("failed to set ALPN", e5);
        }
    }

    @Override // w3.h
    public String g(SSLSocket sSLSocket) {
        e3.f.e(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f6443e.invoke(null, sSLSocket));
            e3.f.c(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            a aVar = (a) invocationHandler;
            if (!aVar.b() && aVar.a() == null) {
                h.k(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (aVar.b()) {
                return null;
            }
            return aVar.a();
        } catch (IllegalAccessException e4) {
            throw new AssertionError("failed to get ALPN selected protocol", e4);
        } catch (InvocationTargetException e5) {
            throw new AssertionError("failed to get ALPN selected protocol", e5);
        }
    }
}
