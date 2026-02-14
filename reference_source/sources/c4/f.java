package c4;

import b4.g0;
import b4.l;
import java.io.IOException;

/* loaded from: classes.dex */
public final class f extends l {

    /* renamed from: c, reason: collision with root package name */
    private final long f2464c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f2465d;

    /* renamed from: e, reason: collision with root package name */
    private long f2466e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g0 g0Var, long j4, boolean z4) {
        super(g0Var);
        e3.f.e(g0Var, "delegate");
        this.f2464c = j4;
        this.f2465d = z4;
    }

    private final void I(b4.d dVar, long j4) {
        b4.d dVar2 = new b4.d();
        dVar2.j0(dVar);
        dVar.F(dVar2, j4);
        dVar2.I();
    }

    @Override // b4.l, b4.g0
    public long u(b4.d dVar, long j4) {
        e3.f.e(dVar, "sink");
        long j5 = this.f2466e;
        long j6 = this.f2464c;
        if (j5 > j6) {
            j4 = 0;
        } else if (this.f2465d) {
            long j7 = j6 - j5;
            if (j7 == 0) {
                return -1L;
            }
            j4 = Math.min(j4, j7);
        }
        long u4 = super.u(dVar, j4);
        if (u4 != -1) {
            this.f2466e += u4;
        }
        long j8 = this.f2466e;
        long j9 = this.f2464c;
        if ((j8 >= j9 || u4 != -1) && j8 <= j9) {
            return u4;
        }
        if (u4 > 0 && j8 > j9) {
            I(dVar, dVar.c0() - (this.f2466e - this.f2464c));
        }
        throw new IOException("expected " + this.f2464c + " bytes but got " + this.f2466e);
    }
}
