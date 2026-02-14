package z1;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private final n1.a f6664a;

    /* renamed from: b, reason: collision with root package name */
    private final s f6665b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(n1.a aVar) {
        this.f6664a = aVar;
        this.f6665b = new s(aVar);
    }

    public static j a(n1.a aVar) {
        if (aVar.g(1)) {
            return new g(aVar);
        }
        if (!aVar.g(2)) {
            return new k(aVar);
        }
        int g4 = s.g(aVar, 1, 4);
        if (g4 == 4) {
            return new a(aVar);
        }
        if (g4 == 5) {
            return new b(aVar);
        }
        int g5 = s.g(aVar, 1, 5);
        if (g5 == 12) {
            return new c(aVar);
        }
        if (g5 == 13) {
            return new d(aVar);
        }
        switch (s.g(aVar, 1, 7)) {
            case m0.k.y4 /* 56 */:
                return new e(aVar, "310", "11");
            case m0.k.z4 /* 57 */:
                return new e(aVar, "320", "11");
            case m0.k.A4 /* 58 */:
                return new e(aVar, "310", "13");
            case m0.k.B4 /* 59 */:
                return new e(aVar, "320", "13");
            case m0.k.C4 /* 60 */:
                return new e(aVar, "310", "15");
            case m0.k.D4 /* 61 */:
                return new e(aVar, "320", "15");
            case 62:
                return new e(aVar, "310", "17");
            case 63:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s b() {
        return this.f6665b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final n1.a c() {
        return this.f6664a;
    }

    public abstract String d();
}
