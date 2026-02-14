package k3;

import e3.f;
import g3.i;
import g3.l;

/* loaded from: classes.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long d(long j4, int i4) {
        return a.d((j4 << 1) + i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long e(long j4) {
        return a.d((j4 << 1) + 1);
    }

    private static final long f(long j4) {
        return a.d(j4 << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(long j4) {
        return j4 * 1000000;
    }

    public static final long h(int i4, d dVar) {
        f.e(dVar, "unit");
        return dVar.compareTo(d.f4458f) <= 0 ? f(e.b(i4, dVar, d.f4455c)) : i(i4, dVar);
    }

    public static final long i(long j4, d dVar) {
        long e4;
        f.e(dVar, "unit");
        d dVar2 = d.f4455c;
        long b5 = e.b(4611686018426999999L, dVar2, dVar);
        if (new i(-b5, b5).d(j4)) {
            return f(e.b(j4, dVar, dVar2));
        }
        e4 = l.e(e.a(j4, dVar, d.f4457e), -4611686018427387903L, 4611686018427387903L);
        return e(e4);
    }
}
