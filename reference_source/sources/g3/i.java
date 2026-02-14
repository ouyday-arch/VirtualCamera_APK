package g3;

/* loaded from: classes.dex */
public final class i extends g {

    /* renamed from: f, reason: collision with root package name */
    public static final a f4062f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final i f4063g = new i(1, 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    public i(long j4, long j5) {
        super(j4, j5, 1L);
    }

    public boolean d(long j4) {
        return a() <= j4 && j4 <= b();
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (a() != iVar.a() || b() != iVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (a() ^ (a() >>> 32))) + (b() ^ (b() >>> 32)));
    }

    public boolean isEmpty() {
        return a() > b();
    }

    public String toString() {
        return a() + ".." + b();
    }
}
