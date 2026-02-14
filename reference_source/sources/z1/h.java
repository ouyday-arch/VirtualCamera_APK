package z1;

/* loaded from: classes.dex */
abstract class h extends j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(n1.a aVar) {
        super(aVar);
    }

    private static void e(StringBuilder sb, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < 13; i6++) {
            int charAt = sb.charAt(i6 + i4) - '0';
            if ((i6 & 1) == 0) {
                charAt *= 3;
            }
            i5 += charAt;
        }
        int i7 = 10 - (i5 % 10);
        sb.append(i7 != 10 ? i7 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(StringBuilder sb, int i4) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        g(sb, i4, length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(StringBuilder sb, int i4, int i5) {
        for (int i6 = 0; i6 < 4; i6++) {
            int f4 = b().f((i6 * 10) + i4, 10);
            if (f4 / 100 == 0) {
                sb.append('0');
            }
            if (f4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(f4);
        }
        e(sb, i5);
    }
}
