package k1;

/* loaded from: classes.dex */
final class b extends g {

    /* renamed from: c, reason: collision with root package name */
    private final short f4376c;

    /* renamed from: d, reason: collision with root package name */
    private final short f4377d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, int i4, int i5) {
        super(gVar);
        this.f4376c = (short) i4;
        this.f4377d = (short) i5;
    }

    @Override // k1.g
    public void c(n1.a aVar, byte[] bArr) {
        int i4;
        int i5 = 0;
        while (true) {
            short s4 = this.f4377d;
            if (i5 >= s4) {
                return;
            }
            if (i5 == 0 || (i5 == 31 && s4 <= 62)) {
                int i6 = 5;
                aVar.c(31, 5);
                short s5 = this.f4377d;
                if (s5 > 62) {
                    i4 = s5 - 31;
                    i6 = 16;
                } else if (i5 == 0) {
                    aVar.c(Math.min((int) s5, 31), 5);
                } else {
                    i4 = s5 - 31;
                }
                aVar.c(i4, i6);
            }
            aVar.c(bArr[this.f4376c + i5], 8);
            i5++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f4376c);
        sb.append("::");
        sb.append((this.f4376c + this.f4377d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
