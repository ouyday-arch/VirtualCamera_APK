package m3;

import l3.b0;
import l3.x;

/* loaded from: classes.dex */
public final class l {

    /* loaded from: classes.dex */
    public static final class a extends b0 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f5194b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f5195c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ byte[] f5196d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f5197e;

        a(x xVar, int i4, byte[] bArr, int i5) {
            this.f5194b = xVar;
            this.f5195c = i4;
            this.f5196d = bArr;
            this.f5197e = i5;
        }

        @Override // l3.b0
        public long a() {
            return this.f5195c;
        }

        @Override // l3.b0
        public x b() {
            return this.f5194b;
        }

        @Override // l3.b0
        public void f(b4.e eVar) {
            e3.f.e(eVar, "sink");
            eVar.d(this.f5196d, this.f5197e, this.f5195c);
        }
    }

    public static final boolean a(b0 b0Var) {
        e3.f.e(b0Var, "<this>");
        return false;
    }

    public static final boolean b(b0 b0Var) {
        e3.f.e(b0Var, "<this>");
        return false;
    }

    public static final b0 c(byte[] bArr, x xVar, int i4, int i5) {
        e3.f.e(bArr, "<this>");
        p.e(bArr.length, i4, i5);
        return new a(xVar, i5, bArr, i4);
    }
}
