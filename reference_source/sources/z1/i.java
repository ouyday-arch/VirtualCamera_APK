package z1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class i extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(n1.a aVar) {
        super(aVar);
    }

    protected abstract void h(StringBuilder sb, int i4);

    protected abstract int i(int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(StringBuilder sb, int i4, int i5) {
        int f4 = b().f(i4, i5);
        h(sb, f4);
        int i6 = i(f4);
        int i7 = 100000;
        for (int i8 = 0; i8 < 5; i8++) {
            if (i6 / i7 == 0) {
                sb.append('0');
            }
            i7 /= 10;
        }
        sb.append(i6);
    }
}
