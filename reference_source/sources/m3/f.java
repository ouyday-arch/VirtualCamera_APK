package m3;

import j3.v;
import l3.d;

/* loaded from: classes.dex */
public final class f {
    public static final l3.d a(d.a aVar) {
        e3.f.e(aVar, "<this>");
        return new l3.d(aVar.f(), aVar.g(), aVar.c(), -1, false, false, false, aVar.d(), aVar.e(), aVar.i(), aVar.h(), aVar.b(), null);
    }

    public static final int b(long j4) {
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j4;
    }

    public static final l3.d c(d.b bVar) {
        e3.f.e(bVar, "<this>");
        return new d.a().l().j(Integer.MAX_VALUE, k3.d.f4458f).a();
    }

    public static final l3.d d(d.b bVar) {
        e3.f.e(bVar, "<this>");
        return new d.a().k().a();
    }

    public static final d.a e(d.a aVar, int i4, k3.d dVar) {
        e3.f.e(aVar, "<this>");
        e3.f.e(dVar, "timeUnit");
        if (i4 >= 0) {
            aVar.m(b(k3.a.k(k3.c.h(i4, dVar))));
            return aVar;
        }
        throw new IllegalArgumentException(("maxStale < 0: " + i4).toString());
    }

    public static final d.a f(d.a aVar) {
        e3.f.e(aVar, "<this>");
        aVar.n(true);
        return aVar;
    }

    public static final d.a g(d.a aVar) {
        e3.f.e(aVar, "<this>");
        aVar.o(true);
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final l3.d h(l3.d.b r28, l3.u r29) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.f.h(l3.d$b, l3.u):l3.d");
    }

    public static final String i(l3.d dVar) {
        e3.f.e(dVar, "<this>");
        String a5 = dVar.a();
        if (a5 != null) {
            return a5;
        }
        StringBuilder sb = new StringBuilder();
        if (dVar.i()) {
            sb.append("no-cache, ");
        }
        if (dVar.j()) {
            sb.append("no-store, ");
        }
        if (dVar.e() != -1) {
            sb.append("max-age=");
            sb.append(dVar.e());
            sb.append(", ");
        }
        if (dVar.m() != -1) {
            sb.append("s-maxage=");
            sb.append(dVar.m());
            sb.append(", ");
        }
        if (dVar.c()) {
            sb.append("private, ");
        }
        if (dVar.d()) {
            sb.append("public, ");
        }
        if (dVar.h()) {
            sb.append("must-revalidate, ");
        }
        if (dVar.f() != -1) {
            sb.append("max-stale=");
            sb.append(dVar.f());
            sb.append(", ");
        }
        if (dVar.g() != -1) {
            sb.append("min-fresh=");
            sb.append(dVar.g());
            sb.append(", ");
        }
        if (dVar.l()) {
            sb.append("only-if-cached, ");
        }
        if (dVar.k()) {
            sb.append("no-transform, ");
        }
        if (dVar.b()) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        e3.f.d(sb.delete(sb.length() - 2, sb.length()), "delete(...)");
        String sb2 = sb.toString();
        e3.f.d(sb2, "toString(...)");
        dVar.n(sb2);
        return sb2;
    }

    private static final int j(String str, String str2, int i4) {
        boolean B;
        int length = str.length();
        while (i4 < length) {
            B = v.B(str2, str.charAt(i4), false, 2, null);
            if (B) {
                return i4;
            }
            i4++;
        }
        return str.length();
    }
}
