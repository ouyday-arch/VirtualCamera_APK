package g3;

/* loaded from: classes.dex */
public final class c extends g3.a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f4042f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final c f4043g = new c(1, 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    public c(char c5, char c6) {
        super(c5, c6, 1);
    }

    public boolean d(char c5) {
        return e3.f.f(a(), c5) <= 0 && e3.f.f(c5, b()) <= 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
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
        return (a() * 31) + b();
    }

    public boolean isEmpty() {
        return e3.f.f(a(), b()) > 0;
    }

    public String toString() {
        return a() + ".." + b();
    }
}
