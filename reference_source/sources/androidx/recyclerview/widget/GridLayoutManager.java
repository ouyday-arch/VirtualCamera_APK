package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import z.c;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean I;
    int J;
    int[] K;
    View[] L;
    final SparseIntArray M;
    final SparseIntArray N;
    c O;
    final Rect P;
    private boolean Q;

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i4, int i5) {
            return i4 % i5;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i4) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.p {

        /* renamed from: e, reason: collision with root package name */
        int f1742e;

        /* renamed from: f, reason: collision with root package name */
        int f1743f;

        public b(int i4, int i5) {
            super(i4, i5);
            this.f1742e = -1;
            this.f1743f = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1742e = -1;
            this.f1743f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1742e = -1;
            this.f1743f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1742e = -1;
            this.f1743f = 0;
        }

        public int e() {
            return this.f1742e;
        }

        public int f() {
            return this.f1743f;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final SparseIntArray f1744a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        final SparseIntArray f1745b = new SparseIntArray();

        /* renamed from: c, reason: collision with root package name */
        private boolean f1746c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1747d = false;

        static int a(SparseIntArray sparseIntArray, int i4) {
            int size = sparseIntArray.size() - 1;
            int i5 = 0;
            while (i5 <= size) {
                int i6 = (i5 + size) >>> 1;
                if (sparseIntArray.keyAt(i6) < i4) {
                    i5 = i6 + 1;
                } else {
                    size = i6 - 1;
                }
            }
            int i7 = i5 - 1;
            if (i7 < 0 || i7 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i7);
        }

        int b(int i4, int i5) {
            if (!this.f1747d) {
                return d(i4, i5);
            }
            int i6 = this.f1745b.get(i4, -1);
            if (i6 != -1) {
                return i6;
            }
            int d5 = d(i4, i5);
            this.f1745b.put(i4, d5);
            return d5;
        }

        int c(int i4, int i5) {
            if (!this.f1746c) {
                return e(i4, i5);
            }
            int i6 = this.f1744a.get(i4, -1);
            if (i6 != -1) {
                return i6;
            }
            int e4 = e(i4, i5);
            this.f1744a.put(i4, e4);
            return e4;
        }

        public int d(int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int a5;
            if (!this.f1747d || (a5 = a(this.f1745b, i4)) == -1) {
                i6 = 0;
                i7 = 0;
                i8 = 0;
            } else {
                i6 = this.f1745b.get(a5);
                i7 = a5 + 1;
                i8 = c(a5, i5) + f(a5);
                if (i8 == i5) {
                    i6++;
                    i8 = 0;
                }
            }
            int f4 = f(i4);
            while (i7 < i4) {
                int f5 = f(i7);
                i8 += f5;
                if (i8 == i5) {
                    i6++;
                    i8 = 0;
                } else if (i8 > i5) {
                    i6++;
                    i8 = f5;
                }
                i7++;
            }
            return i8 + f4 > i5 ? i6 + 1 : i6;
        }

        public abstract int e(int i4, int i5);

        public abstract int f(int i4);

        public void g() {
            this.f1745b.clear();
        }

        public void h() {
            this.f1744a.clear();
        }
    }

    public GridLayoutManager(Context context, int i4, int i5, boolean z4) {
        super(context, i5, z4);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        e3(i4);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        e3(RecyclerView.o.i0(context, attributeSet, i4, i5).f1863b);
    }

    private void N2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i4, boolean z4) {
        int i5;
        int i6;
        int i7 = 0;
        int i8 = -1;
        if (z4) {
            i6 = 1;
            i8 = i4;
            i5 = 0;
        } else {
            i5 = i4 - 1;
            i6 = -1;
        }
        while (i5 != i8) {
            View view = this.L[i5];
            b bVar = (b) view.getLayoutParams();
            int a32 = a3(vVar, a0Var, h0(view));
            bVar.f1743f = a32;
            bVar.f1742e = i7;
            i7 += a32;
            i5 += i6;
        }
    }

    private void O2() {
        int J = J();
        for (int i4 = 0; i4 < J; i4++) {
            b bVar = (b) I(i4).getLayoutParams();
            int a5 = bVar.a();
            this.M.put(a5, bVar.f());
            this.N.put(a5, bVar.e());
        }
    }

    private void P2(int i4) {
        this.K = Q2(this.K, this.J, i4);
    }

    static int[] Q2(int[] iArr, int i4, int i5) {
        int i6;
        if (iArr == null || iArr.length != i4 + 1 || iArr[iArr.length - 1] != i5) {
            iArr = new int[i4 + 1];
        }
        int i7 = 0;
        iArr[0] = 0;
        int i8 = i5 / i4;
        int i9 = i5 % i4;
        int i10 = 0;
        for (int i11 = 1; i11 <= i4; i11++) {
            i7 += i9;
            if (i7 <= 0 || i4 - i7 >= i9) {
                i6 = i8;
            } else {
                i6 = i8 + 1;
                i7 -= i4;
            }
            i10 += i6;
            iArr[i11] = i10;
        }
        return iArr;
    }

    private void R2() {
        this.M.clear();
        this.N.clear();
    }

    private int S2(RecyclerView.a0 a0Var) {
        if (J() != 0 && a0Var.b() != 0) {
            T1();
            boolean r22 = r2();
            View Y1 = Y1(!r22, true);
            View X1 = X1(!r22, true);
            if (Y1 != null && X1 != null) {
                int b5 = this.O.b(h0(Y1), this.J);
                int b6 = this.O.b(h0(X1), this.J);
                int max = this.f1753x ? Math.max(0, ((this.O.b(a0Var.b() - 1, this.J) + 1) - Math.max(b5, b6)) - 1) : Math.max(0, Math.min(b5, b6));
                if (r22) {
                    return Math.round((max * (Math.abs(this.f1750u.d(X1) - this.f1750u.g(Y1)) / ((this.O.b(h0(X1), this.J) - this.O.b(h0(Y1), this.J)) + 1))) + (this.f1750u.m() - this.f1750u.g(Y1)));
                }
                return max;
            }
        }
        return 0;
    }

    private int T2(RecyclerView.a0 a0Var) {
        if (J() != 0 && a0Var.b() != 0) {
            T1();
            View Y1 = Y1(!r2(), true);
            View X1 = X1(!r2(), true);
            if (Y1 != null && X1 != null) {
                if (!r2()) {
                    return this.O.b(a0Var.b() - 1, this.J) + 1;
                }
                int d5 = this.f1750u.d(X1) - this.f1750u.g(Y1);
                int b5 = this.O.b(h0(Y1), this.J);
                return (int) ((d5 / ((this.O.b(h0(X1), this.J) - b5) + 1)) * (this.O.b(a0Var.b() - 1, this.J) + 1));
            }
        }
        return 0;
    }

    private void U2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i4) {
        boolean z4 = i4 == 1;
        int Z2 = Z2(vVar, a0Var, aVar.f1757b);
        if (z4) {
            while (Z2 > 0) {
                int i5 = aVar.f1757b;
                if (i5 <= 0) {
                    return;
                }
                int i6 = i5 - 1;
                aVar.f1757b = i6;
                Z2 = Z2(vVar, a0Var, i6);
            }
            return;
        }
        int b5 = a0Var.b() - 1;
        int i7 = aVar.f1757b;
        while (i7 < b5) {
            int i8 = i7 + 1;
            int Z22 = Z2(vVar, a0Var, i8);
            if (Z22 <= Z2) {
                break;
            }
            i7 = i8;
            Z2 = Z22;
        }
        aVar.f1757b = i7;
    }

    private void V2() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    private int Y2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i4) {
        if (!a0Var.e()) {
            return this.O.b(i4, this.J);
        }
        int f4 = vVar.f(i4);
        if (f4 != -1) {
            return this.O.b(f4, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i4);
        return 0;
    }

    private int Z2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i4) {
        if (!a0Var.e()) {
            return this.O.c(i4, this.J);
        }
        int i5 = this.N.get(i4, -1);
        if (i5 != -1) {
            return i5;
        }
        int f4 = vVar.f(i4);
        if (f4 != -1) {
            return this.O.c(f4, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i4);
        return 0;
    }

    private int a3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i4) {
        if (!a0Var.e()) {
            return this.O.f(i4);
        }
        int i5 = this.M.get(i4, -1);
        if (i5 != -1) {
            return i5;
        }
        int f4 = vVar.f(i4);
        if (f4 != -1) {
            return this.O.f(f4);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i4);
        return 1;
    }

    private void b3(float f4, int i4) {
        P2(Math.max(Math.round(f4 * this.J), i4));
    }

    private void c3(View view, int i4, boolean z4) {
        int i5;
        int i6;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f1867b;
        int i7 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i8 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int W2 = W2(bVar.f1742e, bVar.f1743f);
        if (this.f1748s == 1) {
            i6 = RecyclerView.o.K(W2, i4, i8, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i5 = RecyclerView.o.K(this.f1750u.n(), X(), i7, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int K = RecyclerView.o.K(W2, i4, i7, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int K2 = RecyclerView.o.K(this.f1750u.n(), p0(), i8, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i5 = K;
            i6 = K2;
        }
        d3(view, i6, i5, z4);
    }

    private void d3(View view, int i4, int i5, boolean z4) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z4 ? H1(view, i4, i5, pVar) : F1(view, i4, i5, pVar)) {
            view.measure(i4, i5);
        }
    }

    private void f3() {
        int W;
        int g02;
        if (p2() == 1) {
            W = o0() - f0();
            g02 = e0();
        } else {
            W = W() - d0();
            g02 = g0();
        }
        P2(W - g02);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect rect, int i4, int i5) {
        int n4;
        int n5;
        if (this.K == null) {
            super.C1(rect, i4, i5);
        }
        int e02 = e0() + f0();
        int g02 = g0() + d0();
        if (this.f1748s == 1) {
            n5 = RecyclerView.o.n(i5, rect.height() + g02, b0());
            int[] iArr = this.K;
            n4 = RecyclerView.o.n(i4, iArr[iArr.length - 1] + e02, c0());
        } else {
            n4 = RecyclerView.o.n(i4, rect.width() + e02, c0());
            int[] iArr2 = this.K;
            n5 = RecyclerView.o.n(i5, iArr2[iArr2.length - 1] + g02, b0());
        }
        B1(n4, n5);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.f1748s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void E2(boolean z4) {
        if (z4) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.E2(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f6, code lost:
    
        if (r13 == (r2 > r7)) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View J0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.a0 r27) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.J0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.D == null && !this.I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f1748s == 1) {
            return this.J;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return Y2(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void N1(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i4 = this.J;
        for (int i5 = 0; i5 < this.J && cVar.c(a0Var) && i4 > 0; i5++) {
            int i6 = cVar.f1768d;
            cVar2.a(i6, Math.max(0, cVar.f1771g));
            i4 -= this.O.f(i6);
            cVar.f1768d += cVar.f1769e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, z.c cVar) {
        int i4;
        int e4;
        int f4;
        boolean z4;
        boolean z5;
        int i5;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.O0(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        int Y2 = Y2(vVar, a0Var, bVar.a());
        if (this.f1748s == 0) {
            i5 = bVar.e();
            i4 = bVar.f();
            f4 = 1;
            z4 = false;
            z5 = false;
            e4 = Y2;
        } else {
            i4 = 1;
            e4 = bVar.e();
            f4 = bVar.f();
            z4 = false;
            z5 = false;
            i5 = Y2;
        }
        cVar.Z(c.C0097c.a(i5, i4, e4, f4, z4, z5));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int i4, int i5) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i4, int i5, int i6) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i4, int i5) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int i4, int i5, Object obj) {
        this.O.h();
        this.O.g();
    }

    int W2(int i4, int i5) {
        if (this.f1748s != 1 || !q2()) {
            int[] iArr = this.K;
            return iArr[i5 + i4] - iArr[i4];
        }
        int[] iArr2 = this.K;
        int i6 = this.J;
        return iArr2[i6 - i4] - iArr2[(i6 - i4) - i5];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.e()) {
            O2();
        }
        super.X0(vVar, a0Var);
        R2();
    }

    public int X2() {
        return this.J;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.I = false;
    }

    public void e3(int i4) {
        if (i4 == this.J) {
            return;
        }
        this.I = true;
        if (i4 >= 1) {
            this.J = i4;
            this.O.h();
            t1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i4);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View h2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i4, int i5, int i6) {
        T1();
        int m4 = this.f1750u.m();
        int i7 = this.f1750u.i();
        int i8 = i5 > i4 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i4 != i5) {
            View I = I(i4);
            int h02 = h0(I);
            if (h02 >= 0 && h02 < i6 && Z2(vVar, a0Var, h02) == 0) {
                if (((RecyclerView.p) I.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = I;
                    }
                } else {
                    if (this.f1750u.g(I) < i7 && this.f1750u.d(I) >= m4) {
                        return I;
                    }
                    if (view == null) {
                        view = I;
                    }
                }
            }
            i4 += i8;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f1748s == 0) {
            return this.J;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return Y2(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return this.Q ? S2(a0Var) : super.r(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return this.Q ? T2(a0Var) : super.s(a0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        r21.f1762b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void s2(androidx.recyclerview.widget.RecyclerView.v r18, androidx.recyclerview.widget.RecyclerView.a0 r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.s2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return this.Q ? S2(a0Var) : super.u(a0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void u2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i4) {
        super.u2(vVar, a0Var, aVar, i4);
        f3();
        if (a0Var.b() > 0 && !a0Var.e()) {
            U2(vVar, a0Var, aVar, i4);
        }
        V2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return this.Q ? T2(a0Var) : super.v(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        f3();
        V2();
        return super.w1(i4, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        f3();
        V2();
        return super.y1(i4, vVar, a0Var);
    }
}
