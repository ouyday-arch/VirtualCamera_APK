package z1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(n1.a aVar) {
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
        sb.append("(393");
        sb.append(f4);
        sb.append(')');
        int f5 = b().f(50, 10);
        if (f5 / 100 == 0) {
            sb.append('0');
        }
        if (f5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(f5);
        sb.append(b().c(60, null).b());
        return sb.toString();
    }
}
