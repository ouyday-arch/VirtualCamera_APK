package l3;

import java.io.IOException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: c, reason: collision with root package name */
    public static final a f4871c;

    /* renamed from: d, reason: collision with root package name */
    public static final z f4872d = new z("HTTP_1_0", 0, "http/1.0");

    /* renamed from: e, reason: collision with root package name */
    public static final z f4873e = new z("HTTP_1_1", 1, "http/1.1");

    /* renamed from: f, reason: collision with root package name */
    public static final z f4874f = new z("SPDY_3", 2, "spdy/3.1");

    /* renamed from: g, reason: collision with root package name */
    public static final z f4875g = new z("HTTP_2", 3, "h2");

    /* renamed from: h, reason: collision with root package name */
    public static final z f4876h = new z("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");

    /* renamed from: i, reason: collision with root package name */
    public static final z f4877i = new z("QUIC", 5, "quic");

    /* renamed from: j, reason: collision with root package name */
    public static final z f4878j = new z("HTTP_3", 6, "h3");

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ z[] f4879k;

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ y2.a f4880l;

    /* renamed from: b, reason: collision with root package name */
    private final String f4881b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final z a(String str) {
            boolean x4;
            e3.f.e(str, "protocol");
            z zVar = z.f4872d;
            if (!e3.f.a(str, zVar.f4881b)) {
                zVar = z.f4873e;
                if (!e3.f.a(str, zVar.f4881b)) {
                    zVar = z.f4876h;
                    if (!e3.f.a(str, zVar.f4881b)) {
                        zVar = z.f4875g;
                        if (!e3.f.a(str, zVar.f4881b)) {
                            zVar = z.f4874f;
                            if (!e3.f.a(str, zVar.f4881b)) {
                                zVar = z.f4877i;
                                if (!e3.f.a(str, zVar.f4881b)) {
                                    zVar = z.f4878j;
                                    x4 = j3.u.x(str, zVar.f4881b, false, 2, null);
                                    if (!x4) {
                                        throw new IOException("Unexpected protocol: " + str);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return zVar;
        }
    }

    static {
        z[] a5 = a();
        f4879k = a5;
        f4880l = y2.b.a(a5);
        f4871c = new a(null);
    }

    private z(String str, int i4, String str2) {
        this.f4881b = str2;
    }

    private static final /* synthetic */ z[] a() {
        return new z[]{f4872d, f4873e, f4874f, f4875g, f4876h, f4877i, f4878j};
    }

    public static z valueOf(String str) {
        return (z) Enum.valueOf(z.class, str);
    }

    public static z[] values() {
        return (z[]) f4879k.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f4881b;
    }
}
