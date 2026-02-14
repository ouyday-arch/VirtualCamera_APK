package g3;

/* loaded from: classes.dex */
public class a implements Iterable<Character>, f3.a {

    /* renamed from: e, reason: collision with root package name */
    public static final C0044a f4034e = new C0044a(null);

    /* renamed from: b, reason: collision with root package name */
    private final char f4035b;

    /* renamed from: c, reason: collision with root package name */
    private final char f4036c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4037d;

    /* renamed from: g3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0044a {
        private C0044a() {
        }

        public /* synthetic */ C0044a(e3.d dVar) {
            this();
        }
    }

    public a(char c5, char c6, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f4035b = c5;
        this.f4036c = (char) z2.c.c(c5, c6, i4);
        this.f4037d = i4;
    }

    public final char a() {
        return this.f4035b;
    }

    public final char b() {
        return this.f4036c;
    }

    @Override // java.lang.Iterable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v2.l iterator() {
        return new b(this.f4035b, this.f4036c, this.f4037d);
    }
}
