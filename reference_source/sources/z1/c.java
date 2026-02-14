package z1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(n1.a aVar) {
        super(aVar);
    }

    @Override // z1.j
    public String d() {
        if (c().l() < 48) {
            throw g1.m.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        int f4 = b().f(48, 2);
        sb.append("(392");
        sb.append(f4);
        sb.append(')');
        sb.append(b().c(50, null).b());
        return sb.toString();
    }
}
