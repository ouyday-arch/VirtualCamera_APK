package u1;

import g1.e;
import g1.m;
import g1.o;
import g1.q;
import g1.r;
import g1.s;
import java.util.Map;
import n1.b;
import v1.c;

/* loaded from: classes.dex */
public final class a implements o {

    /* renamed from: b, reason: collision with root package name */
    private static final s[] f6215b = new s[0];

    /* renamed from: a, reason: collision with root package name */
    private final c f6216a = new c();

    private static b d(b bVar) {
        int[] g4 = bVar.g();
        if (g4 == null) {
            throw m.a();
        }
        int i4 = g4[0];
        int i5 = g4[1];
        int i6 = g4[2];
        int i7 = g4[3];
        b bVar2 = new b(30, 33);
        for (int i8 = 0; i8 < 33; i8++) {
            int i9 = (((i8 * i7) + (i7 / 2)) / 33) + i5;
            for (int i10 = 0; i10 < 30; i10++) {
                if (bVar.e(((((i10 * i6) + (i6 / 2)) + (((i8 & 1) * i6) / 2)) / 30) + i4, i9)) {
                    bVar2.n(i10, i8);
                }
            }
        }
        return bVar2;
    }

    @Override // g1.o
    public q a(g1.c cVar, Map<e, ?> map) {
        n1.e b5 = this.f6216a.b(d(cVar.a()), map);
        q qVar = new q(b5.h(), b5.e(), f6215b, g1.a.MAXICODE);
        String b6 = b5.b();
        if (b6 != null) {
            qVar.h(r.ERROR_CORRECTION_LEVEL, b6);
        }
        return qVar;
    }

    @Override // g1.o
    public q b(g1.c cVar) {
        return a(cVar, null);
    }

    @Override // g1.o
    public void c() {
    }
}
