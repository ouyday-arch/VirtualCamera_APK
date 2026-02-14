package w1;

import java.util.Map;

/* loaded from: classes.dex */
public final class t extends y {

    /* renamed from: i, reason: collision with root package name */
    private final y f6396i = new i();

    private static g1.q t(g1.q qVar) {
        String f4 = qVar.f();
        if (f4.charAt(0) != '0') {
            throw g1.h.a();
        }
        g1.q qVar2 = new g1.q(f4.substring(1), null, qVar.e(), g1.a.UPC_A);
        if (qVar.d() != null) {
            qVar2.g(qVar.d());
        }
        return qVar2;
    }

    @Override // w1.r, g1.o
    public g1.q a(g1.c cVar, Map<g1.e, ?> map) {
        return t(this.f6396i.a(cVar, map));
    }

    @Override // w1.r, g1.o
    public g1.q b(g1.c cVar) {
        return t(this.f6396i.b(cVar));
    }

    @Override // w1.y, w1.r
    public g1.q d(int i4, n1.a aVar, Map<g1.e, ?> map) {
        return t(this.f6396i.d(i4, aVar, map));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.y
    public int m(n1.a aVar, int[] iArr, StringBuilder sb) {
        return this.f6396i.m(aVar, iArr, sb);
    }

    @Override // w1.y
    public g1.q n(int i4, n1.a aVar, int[] iArr, Map<g1.e, ?> map) {
        return t(this.f6396i.n(i4, aVar, iArr, map));
    }

    @Override // w1.y
    g1.a r() {
        return g1.a.UPC_A;
    }
}
