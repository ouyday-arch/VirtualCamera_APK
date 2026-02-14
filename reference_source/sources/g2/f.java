package g2;

/* loaded from: classes.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: g, reason: collision with root package name */
    private static final f[] f4004g;

    /* renamed from: b, reason: collision with root package name */
    private final int f4006b;

    static {
        f fVar = L;
        f fVar2 = M;
        f fVar3 = Q;
        f4004g = new f[]{fVar2, fVar, H, fVar3};
    }

    f(int i4) {
        this.f4006b = i4;
    }

    public static f a(int i4) {
        if (i4 >= 0) {
            f[] fVarArr = f4004g;
            if (i4 < fVarArr.length) {
                return fVarArr[i4];
            }
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.f4006b;
    }
}
