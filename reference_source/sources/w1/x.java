package w1;

/* loaded from: classes.dex */
final class x {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f6403c = {1, 1, 2};

    /* renamed from: a, reason: collision with root package name */
    private final v f6404a = new v();

    /* renamed from: b, reason: collision with root package name */
    private final w f6405b = new w();

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1.q a(int i4, n1.a aVar, int i5) {
        int[] o4 = y.o(aVar, i5, false, f6403c);
        try {
            return this.f6405b.b(i4, aVar, o4);
        } catch (g1.p unused) {
            return this.f6404a.b(i4, aVar, o4);
        }
    }
}
