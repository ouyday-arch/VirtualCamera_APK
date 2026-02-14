package p2;

/* loaded from: classes.dex */
public class m extends g {

    /* renamed from: c, reason: collision with root package name */
    private boolean f5458c;

    public m(g1.o oVar) {
        super(oVar);
        this.f5458c = true;
    }

    @Override // p2.g
    protected g1.c e(g1.j jVar) {
        if (this.f5458c) {
            this.f5458c = false;
            return new g1.c(new n1.j(jVar.e()));
        }
        this.f5458c = true;
        return new g1.c(new n1.j(jVar));
    }
}
