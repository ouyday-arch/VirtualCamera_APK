package l3;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final q3.j f4739a;

    public l() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(int i4, long j4, TimeUnit timeUnit) {
        this(i4, j4, timeUnit, p3.d.f5490m, k.f4737a.a());
        e3.f.e(timeUnit, "timeUnit");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(int i4, long j4, TimeUnit timeUnit, p3.d dVar, k kVar) {
        this(new q3.j(dVar, i4, j4, timeUnit, kVar));
        e3.f.e(timeUnit, "timeUnit");
        e3.f.e(dVar, "taskRunner");
        e3.f.e(kVar, "connectionListener");
    }

    public l(q3.j jVar) {
        e3.f.e(jVar, "delegate");
        this.f4739a = jVar;
    }

    public final k a() {
        return this.f4739a.d();
    }

    public final q3.j b() {
        return this.f4739a;
    }
}
