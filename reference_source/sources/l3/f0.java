package l3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f4644c;

    /* renamed from: d, reason: collision with root package name */
    public static final f0 f4645d = new f0("TLS_1_3", 0, "TLSv1.3");

    /* renamed from: e, reason: collision with root package name */
    public static final f0 f4646e = new f0("TLS_1_2", 1, "TLSv1.2");

    /* renamed from: f, reason: collision with root package name */
    public static final f0 f4647f = new f0("TLS_1_1", 2, "TLSv1.1");

    /* renamed from: g, reason: collision with root package name */
    public static final f0 f4648g = new f0("TLS_1_0", 3, "TLSv1");

    /* renamed from: h, reason: collision with root package name */
    public static final f0 f4649h = new f0("SSL_3_0", 4, "SSLv3");

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ f0[] f4650i;

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ y2.a f4651j;

    /* renamed from: b, reason: collision with root package name */
    private final String f4652b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final f0 a(String str) {
            e3.f.e(str, "javaName");
            int hashCode = str.hashCode();
            if (hashCode != 79201641) {
                if (hashCode != 79923350) {
                    switch (hashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return f0.f4647f;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return f0.f4646e;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return f0.f4645d;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return f0.f4648g;
                }
            } else if (str.equals("SSLv3")) {
                return f0.f4649h;
            }
            throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    static {
        f0[] a5 = a();
        f4650i = a5;
        f4651j = y2.b.a(a5);
        f4644c = new a(null);
    }

    private f0(String str, int i4, String str2) {
        this.f4652b = str2;
    }

    private static final /* synthetic */ f0[] a() {
        return new f0[]{f4645d, f4646e, f4647f, f4648g, f4649h};
    }

    public static f0 valueOf(String str) {
        return (f0) Enum.valueOf(f0.class, str);
    }

    public static f0[] values() {
        return (f0[]) f4650i.clone();
    }

    public final String b() {
        return this.f4652b;
    }
}
