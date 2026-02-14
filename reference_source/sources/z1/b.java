package z1;

/* loaded from: classes.dex */
final class b extends f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(n1.a aVar) {
        super(aVar);
    }

    @Override // z1.i
    protected void h(StringBuilder sb, int i4) {
        sb.append(i4 < 10000 ? "(3202)" : "(3203)");
    }

    @Override // z1.i
    protected int i(int i4) {
        return i4 < 10000 ? i4 : i4 - 10000;
    }
}
