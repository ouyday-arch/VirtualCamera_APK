package m3;

import l3.d0;
import l3.x;

/* loaded from: classes.dex */
public final class n {

    /* loaded from: classes.dex */
    public static final class a extends d0 {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ x f5198c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f5199d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b4.f f5200e;

        a(x xVar, long j4, b4.f fVar) {
            this.f5198c = xVar;
            this.f5199d = j4;
            this.f5200e = fVar;
        }

        @Override // l3.d0
        public long J() {
            return this.f5199d;
        }

        @Override // l3.d0
        public x K() {
            return this.f5198c;
        }

        @Override // l3.d0
        public b4.f L() {
            return this.f5200e;
        }
    }

    public static final d0 a(b4.f fVar, x xVar, long j4) {
        e3.f.e(fVar, "<this>");
        return new a(xVar, j4, fVar);
    }

    public static final void b(d0 d0Var) {
        e3.f.e(d0Var, "<this>");
        p.f(d0Var.L());
    }

    public static final d0 c(byte[] bArr, x xVar) {
        e3.f.e(bArr, "<this>");
        return d0.f4640b.a(new b4.d().c(bArr), xVar, bArr.length);
    }
}
