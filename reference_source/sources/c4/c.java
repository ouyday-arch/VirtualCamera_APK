package c4;

import b4.g;
import b4.y;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private static final b4.g f2456a;

    /* renamed from: b */
    private static final b4.g f2457b;

    /* renamed from: c */
    private static final b4.g f2458c;

    /* renamed from: d */
    private static final b4.g f2459d;

    /* renamed from: e */
    private static final b4.g f2460e;

    static {
        g.a aVar = b4.g.f2337e;
        f2456a = aVar.c("/");
        f2457b = aVar.c("\\");
        f2458c = aVar.c("/\\");
        f2459d = aVar.c(".");
        f2460e = aVar.c("..");
    }

    public static final y j(y yVar, y yVar2, boolean z4) {
        e3.f.e(yVar, "<this>");
        e3.f.e(yVar2, "child");
        if (yVar2.e() || yVar2.n() != null) {
            return yVar2;
        }
        b4.g m4 = m(yVar);
        if (m4 == null && (m4 = m(yVar2)) == null) {
            m4 = s(y.f2394d);
        }
        b4.d dVar = new b4.d();
        dVar.A(yVar.b());
        if (dVar.c0() > 0) {
            dVar.A(m4);
        }
        dVar.A(yVar2.b());
        return q(dVar, z4);
    }

    public static final y k(String str, boolean z4) {
        e3.f.e(str, "<this>");
        return q(new b4.d().x(str), z4);
    }

    public static final int l(y yVar) {
        int r4 = b4.g.r(yVar.b(), f2456a, 0, 2, null);
        return r4 != -1 ? r4 : b4.g.r(yVar.b(), f2457b, 0, 2, null);
    }

    public static final b4.g m(y yVar) {
        b4.g b5 = yVar.b();
        b4.g gVar = f2456a;
        if (b4.g.m(b5, gVar, 0, 2, null) != -1) {
            return gVar;
        }
        b4.g b6 = yVar.b();
        b4.g gVar2 = f2457b;
        if (b4.g.m(b6, gVar2, 0, 2, null) != -1) {
            return gVar2;
        }
        return null;
    }

    public static final boolean n(y yVar) {
        return yVar.b().d(f2460e) && (yVar.b().y() == 2 || yVar.b().s(yVar.b().y() + (-3), f2456a, 0, 1) || yVar.b().s(yVar.b().y() + (-3), f2457b, 0, 1));
    }

    public static final int o(y yVar) {
        if (yVar.b().y() == 0) {
            return -1;
        }
        boolean z4 = false;
        if (yVar.b().e(0) == 47) {
            return 1;
        }
        if (yVar.b().e(0) == 92) {
            if (yVar.b().y() <= 2 || yVar.b().e(1) != 92) {
                return 1;
            }
            int k4 = yVar.b().k(f2457b, 2);
            return k4 == -1 ? yVar.b().y() : k4;
        }
        if (yVar.b().y() <= 2 || yVar.b().e(1) != 58 || yVar.b().e(2) != 92) {
            return -1;
        }
        char e4 = (char) yVar.b().e(0);
        if ('a' <= e4 && e4 < '{') {
            return 3;
        }
        if ('A' <= e4 && e4 < '[') {
            z4 = true;
        }
        return !z4 ? -1 : 3;
    }

    private static final boolean p(b4.d dVar, b4.g gVar) {
        if (!e3.f.a(gVar, f2457b) || dVar.c0() < 2 || dVar.N(1L) != 58) {
            return false;
        }
        char N = (char) dVar.N(0L);
        if (!('a' <= N && N < '{')) {
            if (!('A' <= N && N < '[')) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final b4.y q(b4.d r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.c.q(b4.d, boolean):b4.y");
    }

    private static final b4.g r(byte b5) {
        if (b5 == 47) {
            return f2456a;
        }
        if (b5 == 92) {
            return f2457b;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b5));
    }

    public static final b4.g s(String str) {
        if (e3.f.a(str, "/")) {
            return f2456a;
        }
        if (e3.f.a(str, "\\")) {
            return f2457b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
