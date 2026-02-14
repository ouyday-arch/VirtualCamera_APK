package t3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6007c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f6008d = new b("NO_ERROR", 0, 0);

    /* renamed from: e, reason: collision with root package name */
    public static final b f6009e = new b("PROTOCOL_ERROR", 1, 1);

    /* renamed from: f, reason: collision with root package name */
    public static final b f6010f = new b("INTERNAL_ERROR", 2, 2);

    /* renamed from: g, reason: collision with root package name */
    public static final b f6011g = new b("FLOW_CONTROL_ERROR", 3, 3);

    /* renamed from: h, reason: collision with root package name */
    public static final b f6012h = new b("SETTINGS_TIMEOUT", 4, 4);

    /* renamed from: i, reason: collision with root package name */
    public static final b f6013i = new b("STREAM_CLOSED", 5, 5);

    /* renamed from: j, reason: collision with root package name */
    public static final b f6014j = new b("FRAME_SIZE_ERROR", 6, 6);

    /* renamed from: k, reason: collision with root package name */
    public static final b f6015k = new b("REFUSED_STREAM", 7, 7);

    /* renamed from: l, reason: collision with root package name */
    public static final b f6016l = new b("CANCEL", 8, 8);

    /* renamed from: m, reason: collision with root package name */
    public static final b f6017m = new b("COMPRESSION_ERROR", 9, 9);

    /* renamed from: n, reason: collision with root package name */
    public static final b f6018n = new b("CONNECT_ERROR", 10, 10);

    /* renamed from: o, reason: collision with root package name */
    public static final b f6019o = new b("ENHANCE_YOUR_CALM", 11, 11);

    /* renamed from: p, reason: collision with root package name */
    public static final b f6020p = new b("INADEQUATE_SECURITY", 12, 12);

    /* renamed from: q, reason: collision with root package name */
    public static final b f6021q = new b("HTTP_1_1_REQUIRED", 13, 13);

    /* renamed from: r, reason: collision with root package name */
    private static final /* synthetic */ b[] f6022r;

    /* renamed from: s, reason: collision with root package name */
    private static final /* synthetic */ y2.a f6023s;

    /* renamed from: b, reason: collision with root package name */
    private final int f6024b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final b a(int i4) {
            for (b bVar : b.values()) {
                if (bVar.b() == i4) {
                    return bVar;
                }
            }
            return null;
        }
    }

    static {
        b[] a5 = a();
        f6022r = a5;
        f6023s = y2.b.a(a5);
        f6007c = new a(null);
    }

    private b(String str, int i4, int i5) {
        this.f6024b = i5;
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{f6008d, f6009e, f6010f, f6011g, f6012h, f6013i, f6014j, f6015k, f6016l, f6017m, f6018n, f6019o, f6020p, f6021q};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f6022r.clone();
    }

    public final int b() {
        return this.f6024b;
    }
}
