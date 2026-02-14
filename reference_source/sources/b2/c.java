package b2;

import g1.m;
import g1.s;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final n1.b f2257a;

    /* renamed from: b, reason: collision with root package name */
    private final s f2258b;

    /* renamed from: c, reason: collision with root package name */
    private final s f2259c;

    /* renamed from: d, reason: collision with root package name */
    private final s f2260d;

    /* renamed from: e, reason: collision with root package name */
    private final s f2261e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2262f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2263g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2264h;

    /* renamed from: i, reason: collision with root package name */
    private final int f2265i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(c cVar) {
        this.f2257a = cVar.f2257a;
        this.f2258b = cVar.f2258b;
        this.f2259c = cVar.f2259c;
        this.f2260d = cVar.f2260d;
        this.f2261e = cVar.f2261e;
        this.f2262f = cVar.f2262f;
        this.f2263g = cVar.f2263g;
        this.f2264h = cVar.f2264h;
        this.f2265i = cVar.f2265i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(n1.b bVar, s sVar, s sVar2, s sVar3, s sVar4) {
        boolean z4 = sVar == null || sVar2 == null;
        boolean z5 = sVar3 == null || sVar4 == null;
        if (z4 && z5) {
            throw m.a();
        }
        if (z4) {
            sVar = new s(0.0f, sVar3.d());
            sVar2 = new s(0.0f, sVar4.d());
        } else if (z5) {
            sVar3 = new s(bVar.l() - 1, sVar.d());
            sVar4 = new s(bVar.l() - 1, sVar2.d());
        }
        this.f2257a = bVar;
        this.f2258b = sVar;
        this.f2259c = sVar2;
        this.f2260d = sVar3;
        this.f2261e = sVar4;
        this.f2262f = (int) Math.min(sVar.c(), sVar2.c());
        this.f2263g = (int) Math.max(sVar3.c(), sVar4.c());
        this.f2264h = (int) Math.min(sVar.d(), sVar3.d());
        this.f2265i = (int) Math.max(sVar2.d(), sVar4.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c j(c cVar, c cVar2) {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f2257a, cVar.f2258b, cVar.f2259c, cVar2.f2260d, cVar2.f2261e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b2.c a(int r13, int r14, boolean r15) {
        /*
            r12 = this;
            g1.s r0 = r12.f2258b
            g1.s r1 = r12.f2259c
            g1.s r2 = r12.f2260d
            g1.s r3 = r12.f2261e
            if (r13 <= 0) goto L29
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            g1.s r13 = new g1.s
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L26
            r8 = r13
            goto L2a
        L26:
            r10 = r13
            r8 = r0
            goto L2b
        L29:
            r8 = r0
        L2a:
            r10 = r2
        L2b:
            if (r14 <= 0) goto L5b
            if (r15 == 0) goto L32
            g1.s r13 = r12.f2259c
            goto L34
        L32:
            g1.s r13 = r12.f2261e
        L34:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            n1.b r14 = r12.f2257a
            int r14 = r14.h()
            if (r0 < r14) goto L4a
            n1.b r14 = r12.f2257a
            int r14 = r14.h()
            int r0 = r14 + (-1)
        L4a:
            g1.s r14 = new g1.s
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L58
            r9 = r14
            goto L5c
        L58:
            r11 = r14
            r9 = r1
            goto L5d
        L5b:
            r9 = r1
        L5c:
            r11 = r3
        L5d:
            b2.c r13 = new b2.c
            n1.b r7 = r12.f2257a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.c.a(int, int, boolean):b2.c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s b() {
        return this.f2259c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s c() {
        return this.f2261e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f2263g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f2265i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f2262f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f2264h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s h() {
        return this.f2258b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s i() {
        return this.f2260d;
    }
}
