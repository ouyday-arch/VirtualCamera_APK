package b2;

import java.util.Formatter;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private final a f2282a;

    /* renamed from: b, reason: collision with root package name */
    private final g[] f2283b;

    /* renamed from: c, reason: collision with root package name */
    private c f2284c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2285d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, c cVar) {
        this.f2282a = aVar;
        int a5 = aVar.a();
        this.f2285d = a5;
        this.f2284c = cVar;
        this.f2283b = new g[a5 + 2];
    }

    private void a(g gVar) {
        if (gVar != null) {
            ((h) gVar).g(this.f2282a);
        }
    }

    private static boolean b(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.i(dVar2.c());
        return true;
    }

    private static int c(int i4, int i5, d dVar) {
        if (dVar == null || dVar.g()) {
            return i5;
        }
        if (!dVar.h(i4)) {
            return i5 + 1;
        }
        dVar.i(i4);
        return 0;
    }

    private int d() {
        int f4 = f();
        if (f4 == 0) {
            return 0;
        }
        for (int i4 = 1; i4 < this.f2285d + 1; i4++) {
            d[] d5 = this.f2283b[i4].d();
            for (int i5 = 0; i5 < d5.length; i5++) {
                if (d5[i5] != null && !d5[i5].g()) {
                    e(i4, i5, d5);
                }
            }
        }
        return f4;
    }

    private void e(int i4, int i5, d[] dVarArr) {
        d dVar = dVarArr[i5];
        d[] d5 = this.f2283b[i4 - 1].d();
        g[] gVarArr = this.f2283b;
        int i6 = i4 + 1;
        d[] d6 = gVarArr[i6] != null ? gVarArr[i6].d() : d5;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = d5[i5];
        dVarArr2[3] = d6[i5];
        if (i5 > 0) {
            int i7 = i5 - 1;
            dVarArr2[0] = dVarArr[i7];
            dVarArr2[4] = d5[i7];
            dVarArr2[5] = d6[i7];
        }
        if (i5 > 1) {
            int i8 = i5 - 2;
            dVarArr2[8] = dVarArr[i8];
            dVarArr2[10] = d5[i8];
            dVarArr2[11] = d6[i8];
        }
        if (i5 < dVarArr.length - 1) {
            int i9 = i5 + 1;
            dVarArr2[1] = dVarArr[i9];
            dVarArr2[6] = d5[i9];
            dVarArr2[7] = d6[i9];
        }
        if (i5 < dVarArr.length - 2) {
            int i10 = i5 + 2;
            dVarArr2[9] = dVarArr[i10];
            dVarArr2[12] = d5[i10];
            dVarArr2[13] = d6[i10];
        }
        for (int i11 = 0; i11 < 14 && !b(dVar, dVarArr2[i11]); i11++) {
        }
    }

    private int f() {
        g();
        return h() + i();
    }

    private void g() {
        g[] gVarArr = this.f2283b;
        if (gVarArr[0] == null || gVarArr[this.f2285d + 1] == null) {
            return;
        }
        d[] d5 = gVarArr[0].d();
        d[] d6 = this.f2283b[this.f2285d + 1].d();
        for (int i4 = 0; i4 < d5.length; i4++) {
            if (d5[i4] != null && d6[i4] != null && d5[i4].c() == d6[i4].c()) {
                for (int i5 = 1; i5 <= this.f2285d; i5++) {
                    d dVar = this.f2283b[i5].d()[i4];
                    if (dVar != null) {
                        dVar.i(d5[i4].c());
                        if (!dVar.g()) {
                            this.f2283b[i5].d()[i4] = null;
                        }
                    }
                }
            }
        }
    }

    private int h() {
        g[] gVarArr = this.f2283b;
        if (gVarArr[0] == null) {
            return 0;
        }
        d[] d5 = gVarArr[0].d();
        int i4 = 0;
        for (int i5 = 0; i5 < d5.length; i5++) {
            if (d5[i5] != null) {
                int c5 = d5[i5].c();
                int i6 = 0;
                for (int i7 = 1; i7 < this.f2285d + 1 && i6 < 2; i7++) {
                    d dVar = this.f2283b[i7].d()[i5];
                    if (dVar != null) {
                        i6 = c(c5, i6, dVar);
                        if (!dVar.g()) {
                            i4++;
                        }
                    }
                }
            }
        }
        return i4;
    }

    private int i() {
        g[] gVarArr = this.f2283b;
        int i4 = this.f2285d;
        if (gVarArr[i4 + 1] == null) {
            return 0;
        }
        d[] d5 = gVarArr[i4 + 1].d();
        int i5 = 0;
        for (int i6 = 0; i6 < d5.length; i6++) {
            if (d5[i6] != null) {
                int c5 = d5[i6].c();
                int i7 = 0;
                for (int i8 = this.f2285d + 1; i8 > 0 && i7 < 2; i8--) {
                    d dVar = this.f2283b[i8].d()[i6];
                    if (dVar != null) {
                        i7 = c(c5, i7, dVar);
                        if (!dVar.g()) {
                            i5++;
                        }
                    }
                }
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f2285d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f2282a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f2282a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c m() {
        return this.f2284c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g n(int i4) {
        return this.f2283b[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g[] o() {
        a(this.f2283b[0]);
        a(this.f2283b[this.f2285d + 1]);
        int i4 = 928;
        while (true) {
            int d5 = d();
            if (d5 <= 0 || d5 >= i4) {
                break;
            }
            i4 = d5;
        }
        return this.f2283b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(c cVar) {
        this.f2284c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i4, g gVar) {
        this.f2283b[i4] = gVar;
    }

    public String toString() {
        g[] gVarArr = this.f2283b;
        g gVar = gVarArr[0];
        if (gVar == null) {
            gVar = gVarArr[this.f2285d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i4 = 0; i4 < gVar.d().length; i4++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i4));
                for (int i5 = 0; i5 < this.f2285d + 2; i5++) {
                    g[] gVarArr2 = this.f2283b;
                    if (gVarArr2[i5] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = gVarArr2[i5].d()[i4];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
