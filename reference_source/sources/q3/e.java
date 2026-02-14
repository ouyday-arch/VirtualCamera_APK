package q3;

import q3.n;

/* loaded from: classes.dex */
public final class e implements n.b {

    /* renamed from: a, reason: collision with root package name */
    private final n.a f5664a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5665b;

    public e(Throwable th) {
        e3.f.e(th, "e");
        this.f5664a = new n.a(this, null, th, 2, null);
    }

    @Override // q3.n.b
    public /* bridge */ /* synthetic */ n.b a() {
        return (n.b) i();
    }

    @Override // q3.n.b
    public boolean b() {
        return this.f5665b;
    }

    @Override // q3.n.b, r3.d.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void cancel() {
        throw new IllegalStateException("unexpected cancel".toString());
    }

    @Override // q3.n.b
    public n.a d() {
        return this.f5664a;
    }

    @Override // q3.n.b
    public n.a e() {
        return this.f5664a;
    }

    @Override // q3.n.b
    public /* bridge */ /* synthetic */ i f() {
        return (i) h();
    }

    public final n.a g() {
        return this.f5664a;
    }

    public Void h() {
        throw new IllegalStateException("unexpected call".toString());
    }

    public Void i() {
        throw new IllegalStateException("unexpected retry".toString());
    }
}
