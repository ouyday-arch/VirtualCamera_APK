package g2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
abstract class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f3988b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f3989c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f3990d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f3991e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f3992f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f3993g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f3994h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f3995i;

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ c[] f3996j;

    /* loaded from: classes.dex */
    enum a extends c {
        a(String str, int i4) {
            super(str, i4, null);
        }

        @Override // g2.c
        boolean a(int i4, int i5) {
            return ((i4 + i5) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        f3988b = aVar;
        c cVar = new c("DATA_MASK_001", 1) { // from class: g2.c.b
            {
                a aVar2 = null;
            }

            @Override // g2.c
            boolean a(int i4, int i5) {
                return (i4 & 1) == 0;
            }
        };
        f3989c = cVar;
        c cVar2 = new c("DATA_MASK_010", 2) { // from class: g2.c.c
            {
                a aVar2 = null;
            }

            @Override // g2.c
            boolean a(int i4, int i5) {
                return i5 % 3 == 0;
            }
        };
        f3990d = cVar2;
        c cVar3 = new c("DATA_MASK_011", 3) { // from class: g2.c.d
            {
                a aVar2 = null;
            }

            @Override // g2.c
            boolean a(int i4, int i5) {
                return (i4 + i5) % 3 == 0;
            }
        };
        f3991e = cVar3;
        c cVar4 = new c("DATA_MASK_100", 4) { // from class: g2.c.e
            {
                a aVar2 = null;
            }

            @Override // g2.c
            boolean a(int i4, int i5) {
                return (((i4 / 2) + (i5 / 3)) & 1) == 0;
            }
        };
        f3992f = cVar4;
        c cVar5 = new c("DATA_MASK_101", 5) { // from class: g2.c.f
            {
                a aVar2 = null;
            }

            @Override // g2.c
            boolean a(int i4, int i5) {
                return (i4 * i5) % 6 == 0;
            }
        };
        f3993g = cVar5;
        c cVar6 = new c("DATA_MASK_110", 6) { // from class: g2.c.g
            {
                a aVar2 = null;
            }

            @Override // g2.c
            boolean a(int i4, int i5) {
                return (i4 * i5) % 6 < 3;
            }
        };
        f3994h = cVar6;
        c cVar7 = new c("DATA_MASK_111", 7) { // from class: g2.c.h
            {
                a aVar2 = null;
            }

            @Override // g2.c
            boolean a(int i4, int i5) {
                return (((i4 + i5) + ((i4 * i5) % 3)) & 1) == 0;
            }
        };
        f3995i = cVar7;
        f3996j = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7};
    }

    private c(String str, int i4) {
    }

    /* synthetic */ c(String str, int i4, a aVar) {
        this(str, i4);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f3996j.clone();
    }

    abstract boolean a(int i4, int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(n1.b bVar, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            for (int i6 = 0; i6 < i4; i6++) {
                if (a(i5, i6)) {
                    bVar.d(i6, i5);
                }
            }
        }
    }
}
