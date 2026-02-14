package r3;

import b4.g;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import l3.c0;
import l3.n;
import l3.o;
import l3.u;
import l3.v;
import m3.s;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final b4.g f5862a;

    /* renamed from: b, reason: collision with root package name */
    private static final b4.g f5863b;

    static {
        g.a aVar = b4.g.f2337e;
        f5862a = aVar.c("\"\\");
        f5863b = aVar.c("\t ,=");
    }

    public static final List<l3.h> a(u uVar, String str) {
        boolean l4;
        e3.f.e(uVar, "<this>");
        e3.f.e(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = uVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            l4 = j3.u.l(str, uVar.c(i4), true);
            if (l4) {
                try {
                    c(new b4.d().x(uVar.e(i4)), arrayList);
                } catch (EOFException e4) {
                    w3.h.f6456a.g().j("Unable to parse challenge", 5, e4);
                }
            }
        }
        return arrayList;
    }

    public static final boolean b(c0 c0Var) {
        boolean l4;
        e3.f.e(c0Var, "<this>");
        if (e3.f.a(c0Var.Z().g(), "HEAD")) {
            return false;
        }
        int M = c0Var.M();
        if (((M >= 100 && M < 200) || M == 204 || M == 304) && s.i(c0Var) == -1) {
            l4 = j3.u.l("chunked", c0.R(c0Var, "Transfer-Encoding", null, 2, null), true);
            if (!l4) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ba, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ba, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void c(b4.d r7, java.util.List<l3.h> r8) {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            g(r7)
            java.lang.String r1 = e(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = g(r7)
            java.lang.String r3 = e(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.z()
            if (r7 != 0) goto L1f
            return
        L1f:
            l3.h r7 = new l3.h
            java.util.Map r0 = v2.d0.c()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            int r5 = m3.p.C(r7, r4)
            boolean r6 = g(r7)
            if (r2 != 0) goto L67
            if (r6 != 0) goto L40
            boolean r2 = r7.z()
            if (r2 == 0) goto L67
        L40:
            l3.h r2 = new l3.h
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "="
            java.lang.String r3 = j3.l.p(r3, r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "singletonMap(...)"
            e3.f.d(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L67:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = m3.p.C(r7, r4)
            int r5 = r5 + r6
        L71:
            if (r3 != 0) goto L81
            java.lang.String r3 = e(r7)
            boolean r5 = g(r7)
            if (r5 != 0) goto Lba
            int r5 = m3.p.C(r7, r4)
        L81:
            if (r5 == 0) goto Lba
            r6 = 1
            if (r5 <= r6) goto L87
            return
        L87:
            boolean r6 = g(r7)
            if (r6 == 0) goto L8e
            return
        L8e:
            r6 = 34
            boolean r6 = h(r7, r6)
            if (r6 == 0) goto L9b
            java.lang.String r6 = d(r7)
            goto L9f
        L9b:
            java.lang.String r6 = e(r7)
        L9f:
            if (r6 != 0) goto La2
            return
        La2:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lab
            return
        Lab:
            boolean r3 = g(r7)
            if (r3 != 0) goto Lb8
            boolean r3 = r7.z()
            if (r3 != 0) goto Lb8
            return
        Lb8:
            r3 = r0
            goto L71
        Lba:
            l3.h r4 = new l3.h
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.e.c(b4.d, java.util.List):void");
    }

    private static final String d(b4.d dVar) {
        if (!(dVar.H() == 34)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        b4.d dVar2 = new b4.d();
        while (true) {
            long P = dVar.P(f5862a);
            if (P == -1) {
                return null;
            }
            if (dVar.N(P) == 34) {
                dVar2.F(dVar, P);
                dVar.H();
                return dVar2.Z();
            }
            if (dVar.c0() == P + 1) {
                return null;
            }
            dVar2.F(dVar, P);
            dVar.H();
            dVar2.F(dVar, 1L);
        }
    }

    private static final String e(b4.d dVar) {
        long P = dVar.P(f5863b);
        if (P == -1) {
            P = dVar.c0();
        }
        if (P != 0) {
            return dVar.e(P);
        }
        return null;
    }

    public static final void f(o oVar, v vVar, u uVar) {
        e3.f.e(oVar, "<this>");
        e3.f.e(vVar, "url");
        e3.f.e(uVar, "headers");
        if (oVar == o.f4771b) {
            return;
        }
        List<n> e4 = n.f4755k.e(vVar, uVar);
        if (e4.isEmpty()) {
            return;
        }
        oVar.b(vVar, e4);
    }

    private static final boolean g(b4.d dVar) {
        boolean z4 = false;
        while (!dVar.z()) {
            byte N = dVar.N(0L);
            if (N != 44) {
                if (!(N == 32 || N == 9)) {
                    break;
                }
                dVar.H();
            } else {
                dVar.H();
                z4 = true;
            }
        }
        return z4;
    }

    private static final boolean h(b4.d dVar, byte b5) {
        return !dVar.z() && dVar.N(0L) == b5;
    }
}
