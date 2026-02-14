package b4;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class m extends h0 {

    /* renamed from: f, reason: collision with root package name */
    private h0 f2374f;

    public m(h0 h0Var) {
        e3.f.e(h0Var, "delegate");
        this.f2374f = h0Var;
    }

    @Override // b4.h0
    public h0 a() {
        return this.f2374f.a();
    }

    @Override // b4.h0
    public h0 b() {
        return this.f2374f.b();
    }

    @Override // b4.h0
    public long c() {
        return this.f2374f.c();
    }

    @Override // b4.h0
    public h0 d(long j4) {
        return this.f2374f.d(j4);
    }

    @Override // b4.h0
    public boolean e() {
        return this.f2374f.e();
    }

    @Override // b4.h0
    public void f() {
        this.f2374f.f();
    }

    @Override // b4.h0
    public h0 g(long j4, TimeUnit timeUnit) {
        e3.f.e(timeUnit, "unit");
        return this.f2374f.g(j4, timeUnit);
    }

    public final h0 i() {
        return this.f2374f;
    }

    public final m j(h0 h0Var) {
        e3.f.e(h0Var, "delegate");
        this.f2374f = h0Var;
        return this;
    }
}
