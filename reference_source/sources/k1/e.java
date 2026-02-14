package k1;

/* loaded from: classes.dex */
final class e extends g {

    /* renamed from: c, reason: collision with root package name */
    private final short f4385c;

    /* renamed from: d, reason: collision with root package name */
    private final short f4386d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar, int i4, int i5) {
        super(gVar);
        this.f4385c = (short) i4;
        this.f4386d = (short) i5;
    }

    @Override // k1.g
    void c(n1.a aVar, byte[] bArr) {
        aVar.c(this.f4385c, this.f4386d);
    }

    public String toString() {
        short s4 = this.f4385c;
        short s5 = this.f4386d;
        return "<" + Integer.toBinaryString((s4 & ((1 << s5) - 1)) | (1 << s5) | (1 << this.f4386d)).substring(1) + '>';
    }
}
