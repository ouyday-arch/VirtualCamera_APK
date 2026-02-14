package p2;

import g1.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g implements t {

    /* renamed from: a, reason: collision with root package name */
    private g1.o f5438a;

    /* renamed from: b, reason: collision with root package name */
    private List<g1.s> f5439b = new ArrayList();

    public g(g1.o oVar) {
        this.f5438a = oVar;
    }

    @Override // g1.t
    public void a(g1.s sVar) {
        this.f5439b.add(sVar);
    }

    protected g1.q b(g1.c cVar) {
        g1.q qVar;
        this.f5439b.clear();
        try {
            g1.o oVar = this.f5438a;
            qVar = oVar instanceof g1.k ? ((g1.k) oVar).e(cVar) : oVar.b(cVar);
        } catch (Exception unused) {
            qVar = null;
        } catch (Throwable th) {
            this.f5438a.c();
            throw th;
        }
        this.f5438a.c();
        return qVar;
    }

    public g1.q c(g1.j jVar) {
        return b(e(jVar));
    }

    public List<g1.s> d() {
        return new ArrayList(this.f5439b);
    }

    protected g1.c e(g1.j jVar) {
        return new g1.c(new n1.j(jVar));
    }
}
