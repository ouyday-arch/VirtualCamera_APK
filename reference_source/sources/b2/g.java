package b2;

import java.util.Formatter;

/* loaded from: classes.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private final c f2286a;

    /* renamed from: b, reason: collision with root package name */
    private final d[] f2287b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.f2286a = new c(cVar);
        this.f2287b = new d[(cVar.e() - cVar.g()) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c a() {
        return this.f2286a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d b(int i4) {
        return this.f2287b[e(i4)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d c(int i4) {
        d dVar;
        d dVar2;
        d b5 = b(i4);
        if (b5 != null) {
            return b5;
        }
        for (int i5 = 1; i5 < 5; i5++) {
            int e4 = e(i4) - i5;
            if (e4 >= 0 && (dVar2 = this.f2287b[e4]) != null) {
                return dVar2;
            }
            int e5 = e(i4) + i5;
            d[] dVarArr = this.f2287b;
            if (e5 < dVarArr.length && (dVar = dVarArr[e5]) != null) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d[] d() {
        return this.f2287b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e(int i4) {
        return i4 - this.f2286a.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i4, d dVar) {
        this.f2287b[e(i4)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i4 = 0;
            for (d dVar : this.f2287b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i4));
                    i4++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i4), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i4++;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
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
}
