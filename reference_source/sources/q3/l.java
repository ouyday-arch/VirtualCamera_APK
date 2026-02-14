package q3;

import q3.n;

/* loaded from: classes.dex */
public final class l implements n.b {

    /* renamed from: a, reason: collision with root package name */
    private final i f5736a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5737b;

    public l(i iVar) {
        e3.f.e(iVar, "connection");
        this.f5736a = iVar;
        this.f5737b = true;
    }

    @Override // q3.n.b
    public /* bridge */ /* synthetic */ n.b a() {
        return (n.b) j();
    }

    @Override // q3.n.b
    public boolean b() {
        return this.f5737b;
    }

    @Override // q3.n.b, r3.d.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void cancel() {
        throw new IllegalStateException("unexpected cancel".toString());
    }

    @Override // q3.n.b
    public /* bridge */ /* synthetic */ n.a d() {
        return (n.a) g();
    }

    @Override // q3.n.b
    public /* bridge */ /* synthetic */ n.a e() {
        return (n.a) h();
    }

    @Override // q3.n.b
    public i f() {
        return this.f5736a;
    }

    public Void g() {
        throw new IllegalStateException("already connected".toString());
    }

    public Void h() {
        throw new IllegalStateException("already connected".toString());
    }

    public final i i() {
        return this.f5736a;
    }

    public Void j() {
        throw new IllegalStateException("unexpected retry".toString());
    }
}
