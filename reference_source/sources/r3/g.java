package r3;

import java.util.List;
import l3.a0;
import l3.c0;
import l3.w;

/* loaded from: classes.dex */
public final class g implements w.a {

    /* renamed from: a, reason: collision with root package name */
    private final q3.h f5865a;

    /* renamed from: b, reason: collision with root package name */
    private final List<w> f5866b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5867c;

    /* renamed from: d, reason: collision with root package name */
    private final q3.c f5868d;

    /* renamed from: e, reason: collision with root package name */
    private final a0 f5869e;

    /* renamed from: f, reason: collision with root package name */
    private final int f5870f;

    /* renamed from: g, reason: collision with root package name */
    private final int f5871g;

    /* renamed from: h, reason: collision with root package name */
    private final int f5872h;

    /* renamed from: i, reason: collision with root package name */
    private int f5873i;

    /* JADX WARN: Multi-variable type inference failed */
    public g(q3.h hVar, List<? extends w> list, int i4, q3.c cVar, a0 a0Var, int i5, int i6, int i7) {
        e3.f.e(hVar, "call");
        e3.f.e(list, "interceptors");
        e3.f.e(a0Var, "request");
        this.f5865a = hVar;
        this.f5866b = list;
        this.f5867c = i4;
        this.f5868d = cVar;
        this.f5869e = a0Var;
        this.f5870f = i5;
        this.f5871g = i6;
        this.f5872h = i7;
    }

    public static /* synthetic */ g f(g gVar, int i4, q3.c cVar, a0 a0Var, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = gVar.f5867c;
        }
        if ((i8 & 2) != 0) {
            cVar = gVar.f5868d;
        }
        q3.c cVar2 = cVar;
        if ((i8 & 4) != 0) {
            a0Var = gVar.f5869e;
        }
        a0 a0Var2 = a0Var;
        if ((i8 & 8) != 0) {
            i5 = gVar.f5870f;
        }
        int i9 = i5;
        if ((i8 & 16) != 0) {
            i6 = gVar.f5871g;
        }
        int i10 = i6;
        if ((i8 & 32) != 0) {
            i7 = gVar.f5872h;
        }
        return gVar.e(i4, cVar2, a0Var2, i9, i10, i7);
    }

    @Override // l3.w.a
    public c0 a(a0 a0Var) {
        e3.f.e(a0Var, "request");
        if (!(this.f5867c < this.f5866b.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f5873i++;
        q3.c cVar = this.f5868d;
        if (cVar != null) {
            if (!cVar.j().b().c(a0Var.i())) {
                throw new IllegalStateException(("network interceptor " + this.f5866b.get(this.f5867c - 1) + " must retain the same host and port").toString());
            }
            if (!(this.f5873i == 1)) {
                throw new IllegalStateException(("network interceptor " + this.f5866b.get(this.f5867c - 1) + " must call proceed() exactly once").toString());
            }
        }
        g f4 = f(this, this.f5867c + 1, null, a0Var, 0, 0, 0, 58, null);
        w wVar = this.f5866b.get(this.f5867c);
        c0 a5 = wVar.a(f4);
        if (a5 == null) {
            throw new NullPointerException("interceptor " + wVar + " returned null");
        }
        if (this.f5868d != null) {
            if (!(this.f5867c + 1 >= this.f5866b.size() || f4.f5873i == 1)) {
                throw new IllegalStateException(("network interceptor " + wVar + " must call proceed() exactly once").toString());
            }
        }
        return a5;
    }

    @Override // l3.w.a
    public a0 b() {
        return this.f5869e;
    }

    @Override // l3.w.a
    public int c() {
        return this.f5870f;
    }

    @Override // l3.w.a
    public l3.e call() {
        return this.f5865a;
    }

    @Override // l3.w.a
    public int d() {
        return this.f5871g;
    }

    public final g e(int i4, q3.c cVar, a0 a0Var, int i5, int i6, int i7) {
        e3.f.e(a0Var, "request");
        return new g(this.f5865a, this.f5866b, i4, cVar, a0Var, i5, i6, i7);
    }

    public final q3.h g() {
        return this.f5865a;
    }

    public final q3.c h() {
        return this.f5868d;
    }

    public final int i() {
        return this.f5871g;
    }

    public final a0 j() {
        return this.f5869e;
    }

    public final int k() {
        return this.f5872h;
    }
}
