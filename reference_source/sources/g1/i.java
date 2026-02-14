package g1;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: c, reason: collision with root package name */
    private final j f3946c;

    public i(j jVar) {
        super(jVar.d(), jVar.a());
        this.f3946c = jVar;
    }

    @Override // g1.j
    public byte[] b() {
        byte[] b5 = this.f3946c.b();
        int d5 = d() * a();
        byte[] bArr = new byte[d5];
        for (int i4 = 0; i4 < d5; i4++) {
            bArr[i4] = (byte) (255 - (b5[i4] & 255));
        }
        return bArr;
    }

    @Override // g1.j
    public byte[] c(int i4, byte[] bArr) {
        byte[] c5 = this.f3946c.c(i4, bArr);
        int d5 = d();
        for (int i5 = 0; i5 < d5; i5++) {
            c5[i5] = (byte) (255 - (c5[i5] & 255));
        }
        return c5;
    }

    @Override // g1.j
    public j e() {
        return this.f3946c;
    }

    @Override // g1.j
    public boolean f() {
        return this.f3946c.f();
    }

    @Override // g1.j
    public j g() {
        return new i(this.f3946c.g());
    }
}
