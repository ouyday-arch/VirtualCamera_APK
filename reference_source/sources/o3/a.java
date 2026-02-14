package o3;

import e3.d;
import e3.f;
import l3.a0;
import l3.c;
import l3.c0;
import l3.e;
import l3.s;
import l3.u;
import l3.w;
import l3.z;
import m3.o;
import m3.p;
import o3.b;
import q3.h;

/* loaded from: classes.dex */
public final class a implements w {

    /* renamed from: a, reason: collision with root package name */
    public static final C0063a f5378a = new C0063a(null);

    /* renamed from: o3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0063a {
        private C0063a() {
        }

        public /* synthetic */ C0063a(d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final u b(u uVar, u uVar2) {
            int i4;
            boolean l4;
            boolean x4;
            u.a aVar = new u.a();
            int size = uVar.size();
            for (0; i4 < size; i4 + 1) {
                String c5 = uVar.c(i4);
                String e4 = uVar.e(i4);
                l4 = j3.u.l("Warning", c5, true);
                if (l4) {
                    x4 = j3.u.x(e4, "1", false, 2, null);
                    i4 = x4 ? i4 + 1 : 0;
                }
                if (c(c5) || !d(c5) || uVar2.a(c5) == null) {
                    aVar.c(c5, e4);
                }
            }
            int size2 = uVar2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                String c6 = uVar2.c(i5);
                if (!c(c6) && d(c6)) {
                    aVar.c(c6, uVar2.e(i5));
                }
            }
            return aVar.d();
        }

        private final boolean c(String str) {
            boolean l4;
            boolean l5;
            boolean l6;
            l4 = j3.u.l("Content-Length", str, true);
            if (l4) {
                return true;
            }
            l5 = j3.u.l("Content-Encoding", str, true);
            if (l5) {
                return true;
            }
            l6 = j3.u.l("Content-Type", str, true);
            return l6;
        }

        private final boolean d(String str) {
            boolean l4;
            boolean l5;
            boolean l6;
            boolean l7;
            boolean l8;
            boolean l9;
            boolean l10;
            boolean l11;
            l4 = j3.u.l("Connection", str, true);
            if (!l4) {
                l5 = j3.u.l("Keep-Alive", str, true);
                if (!l5) {
                    l6 = j3.u.l("Proxy-Authenticate", str, true);
                    if (!l6) {
                        l7 = j3.u.l("Proxy-Authorization", str, true);
                        if (!l7) {
                            l8 = j3.u.l("TE", str, true);
                            if (!l8) {
                                l9 = j3.u.l("Trailers", str, true);
                                if (!l9) {
                                    l10 = j3.u.l("Transfer-Encoding", str, true);
                                    if (!l10) {
                                        l11 = j3.u.l("Upgrade", str, true);
                                        if (!l11) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public a(c cVar) {
    }

    @Override // l3.w
    public c0 a(w.a aVar) {
        s sVar;
        f.e(aVar, "chain");
        e call = aVar.call();
        b b5 = new b.C0064b(System.currentTimeMillis(), aVar.b(), null).b();
        a0 b6 = b5.b();
        c0 a5 = b5.a();
        h hVar = call instanceof h ? (h) call : null;
        if (hVar == null || (sVar = hVar.n()) == null) {
            sVar = s.f4785b;
        }
        if (b6 == null && a5 == null) {
            c0 c5 = new c0.a().q(aVar.b()).o(z.f4873e).e(504).l("Unsatisfiable Request (only-if-cached)").r(-1L).p(System.currentTimeMillis()).c();
            sVar.z(call, c5);
            return c5;
        }
        if (b6 == null) {
            f.b(a5);
            c0 c6 = a5.V().d(o.u(a5)).c();
            sVar.b(call, c6);
            return c6;
        }
        if (a5 != null) {
            sVar.a(call, a5);
        }
        c0 a6 = aVar.a(b6);
        if (a5 != null) {
            boolean z4 = false;
            if (a6 != null && a6.M() == 304) {
                z4 = true;
            }
            if (z4) {
                a5.V().j(f5378a.b(a5.S(), a6.S())).r(a6.a0()).p(a6.Y()).d(o.u(a5)).m(o.u(a6)).c();
                a6.I().close();
                f.b(null);
                throw null;
            }
            p.f(a5.I());
        }
        f.b(a6);
        return a6.V().d(a5 != null ? o.u(a5) : null).m(o.u(a6)).c();
    }
}
