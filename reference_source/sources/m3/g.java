package m3;

/* loaded from: classes.dex */
public final class g {
    public static final boolean a(l3.h hVar, Object obj) {
        e3.f.e(hVar, "<this>");
        if (obj instanceof l3.h) {
            l3.h hVar2 = (l3.h) obj;
            if (e3.f.a(hVar2.d(), hVar.d()) && e3.f.a(hVar2.a(), hVar.a())) {
                return true;
            }
        }
        return false;
    }

    public static final int b(l3.h hVar) {
        e3.f.e(hVar, "<this>");
        return ((899 + hVar.d().hashCode()) * 31) + hVar.a().hashCode();
    }

    public static final String c(l3.h hVar) {
        e3.f.e(hVar, "<this>");
        return hVar.d() + " authParams=" + hVar.a();
    }
}
