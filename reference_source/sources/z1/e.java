package z1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends i {

    /* renamed from: c, reason: collision with root package name */
    private final String f6662c;

    /* renamed from: d, reason: collision with root package name */
    private final String f6663d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(n1.a aVar, String str, String str2) {
        super(aVar);
        this.f6662c = str2;
        this.f6663d = str;
    }

    private void k(StringBuilder sb, int i4) {
        int f4 = b().f(i4, 16);
        if (f4 == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f6662c);
        sb.append(')');
        int i5 = f4 % 32;
        int i6 = f4 / 32;
        int i7 = (i6 % 12) + 1;
        int i8 = i6 / 12;
        if (i8 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i8);
        if (i7 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i7);
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
    }

    @Override // z1.j
    public String d() {
        if (c().l() != 84) {
            throw g1.m.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        j(sb, 48, 20);
        k(sb, 68);
        return sb.toString();
    }

    @Override // z1.i
    protected void h(StringBuilder sb, int i4) {
        sb.append('(');
        sb.append(this.f6663d);
        sb.append(i4 / 100000);
        sb.append(')');
    }

    @Override // z1.i
    protected int i(int i4) {
        return i4 % 100000;
    }
}
