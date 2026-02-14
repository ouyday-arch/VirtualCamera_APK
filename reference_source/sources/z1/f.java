package z1;

/* loaded from: classes.dex */
abstract class f extends i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(n1.a aVar) {
        super(aVar);
    }

    @Override // z1.j
    public String d() {
        if (c().l() != 60) {
            throw g1.m.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 5);
        j(sb, 45, 15);
        return sb.toString();
    }
}
