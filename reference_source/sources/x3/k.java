package x3;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import l3.y;

/* loaded from: classes.dex */
public final class k extends f {

    /* renamed from: j, reason: collision with root package name */
    public static final a f6516j = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private final Class<? super SSLSocketFactory> f6517h;

    /* renamed from: i, reason: collision with root package name */
    private final Class<?> f6518i;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public static /* synthetic */ j b(a aVar, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return aVar.a(str);
        }

        public final j a(String str) {
            e3.f.e(str, "packageName");
            try {
                Class<?> cls = Class.forName(str + ".OpenSSLSocketImpl");
                e3.f.c(cls, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
                Class<?> cls2 = Class.forName(str + ".OpenSSLSocketFactoryImpl");
                e3.f.c(cls2, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                Class<?> cls3 = Class.forName(str + ".SSLParametersImpl");
                e3.f.b(cls3);
                return new k(cls, cls2, cls3);
            } catch (Exception e4) {
                c cVar = c.f6498a;
                String name = y.class.getName();
                e3.f.d(name, "getName(...)");
                cVar.a(name, 5, "unable to load android socket classes", e4);
                return null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        e3.f.e(cls, "sslSocketClass");
        e3.f.e(cls2, "sslSocketFactoryClass");
        e3.f.e(cls3, "paramClass");
        this.f6517h = cls2;
        this.f6518i = cls3;
    }
}
