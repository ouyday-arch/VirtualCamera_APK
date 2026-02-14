package u3;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f6224a;

    /* renamed from: b, reason: collision with root package name */
    private long f6225b;

    /* renamed from: c, reason: collision with root package name */
    private long f6226c;

    public a(int i4) {
        this.f6224a = i4;
    }

    public static /* synthetic */ void c(a aVar, long j4, long j5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = 0;
        }
        if ((i4 & 2) != 0) {
            j5 = 0;
        }
        aVar.b(j4, j5);
    }

    public final synchronized long a() {
        return this.f6225b - this.f6226c;
    }

    public final synchronized void b(long j4, long j5) {
        if (!(j4 >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(j5 >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        long j6 = this.f6225b + j4;
        this.f6225b = j6;
        long j7 = this.f6226c + j5;
        this.f6226c = j7;
        if (!(j7 <= j6)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public String toString() {
        return "WindowCounter(streamId=" + this.f6224a + ", total=" + this.f6225b + ", acknowledged=" + this.f6226c + ", unacknowledged=" + a() + ')';
    }
}
