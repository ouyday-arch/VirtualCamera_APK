package p3;

import e3.f;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f5475a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5476b;

    /* renamed from: c, reason: collision with root package name */
    private c f5477c;

    /* renamed from: d, reason: collision with root package name */
    private long f5478d;

    public a(String str, boolean z4) {
        f.e(str, "name");
        this.f5475a = str;
        this.f5476b = z4;
        this.f5478d = -1L;
    }

    public /* synthetic */ a(String str, boolean z4, int i4, e3.d dVar) {
        this(str, (i4 & 2) != 0 ? true : z4);
    }

    public final boolean a() {
        return this.f5476b;
    }

    public final String b() {
        return this.f5475a;
    }

    public final long c() {
        return this.f5478d;
    }

    public final c d() {
        return this.f5477c;
    }

    public final void e(c cVar) {
        f.e(cVar, "queue");
        c cVar2 = this.f5477c;
        if (cVar2 == cVar) {
            return;
        }
        if (!(cVar2 == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.f5477c = cVar;
    }

    public abstract long f();

    public final void g(long j4) {
        this.f5478d = j4;
    }

    public String toString() {
        return this.f5475a;
    }
}
