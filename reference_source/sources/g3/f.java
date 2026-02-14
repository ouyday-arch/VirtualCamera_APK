package g3;

/* loaded from: classes.dex */
public final class f extends d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f4052f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final f f4053g = new f(1, 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final f a() {
            return f.f4053g;
        }
    }

    public f(int i4, int i5) {
        super(i4, i5, 1);
    }

    @Override // g3.d
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            if (!isEmpty() || !((f) obj).isEmpty()) {
                f fVar = (f) obj;
                if (a() != fVar.a() || b() != fVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i4) {
        return a() <= i4 && i4 <= b();
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public Integer h() {
        return Integer.valueOf(a());
    }

    @Override // g3.d
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // g3.d
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // g3.d
    public String toString() {
        return a() + ".." + b();
    }
}
