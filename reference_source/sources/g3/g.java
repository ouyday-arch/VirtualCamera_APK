package g3;

import v2.c0;

/* loaded from: classes.dex */
public class g implements Iterable<Long>, f3.a {

    /* renamed from: e, reason: collision with root package name */
    public static final a f4054e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final long f4055b;

    /* renamed from: c, reason: collision with root package name */
    private final long f4056c;

    /* renamed from: d, reason: collision with root package name */
    private final long f4057d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    public g(long j4, long j5, long j6) {
        if (j6 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j6 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f4055b = j4;
        this.f4056c = z2.c.d(j4, j5, j6);
        this.f4057d = j6;
    }

    public final long a() {
        return this.f4055b;
    }

    public final long b() {
        return this.f4056c;
    }

    @Override // java.lang.Iterable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c0 iterator() {
        return new h(this.f4055b, this.f4056c, this.f4057d);
    }
}
