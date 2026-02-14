package g1;

/* loaded from: classes.dex */
public final class h extends p {

    /* renamed from: d, reason: collision with root package name */
    private static final h f3945d;

    static {
        h hVar = new h();
        f3945d = hVar;
        hVar.setStackTrace(p.f3960c);
    }

    private h() {
    }

    private h(Throwable th) {
        super(th);
    }

    public static h a() {
        return p.f3959b ? new h() : f3945d;
    }

    public static h b(Throwable th) {
        return p.f3959b ? new h(th) : f3945d;
    }
}
