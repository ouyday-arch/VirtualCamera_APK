package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    protected final RecyclerView.o f2075a;

    /* renamed from: b, reason: collision with root package name */
    private int f2076b;

    /* renamed from: c, reason: collision with root package name */
    final Rect f2077c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends j {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.j
        public int d(View view) {
            return this.f2075a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2075a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2075a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int g(View view) {
            return this.f2075a.Q(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int h() {
            return this.f2075a.o0();
        }

        @Override // androidx.recyclerview.widget.j
        public int i() {
            return this.f2075a.o0() - this.f2075a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int j() {
            return this.f2075a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int k() {
            return this.f2075a.p0();
        }

        @Override // androidx.recyclerview.widget.j
        public int l() {
            return this.f2075a.X();
        }

        @Override // androidx.recyclerview.widget.j
        public int m() {
            return this.f2075a.e0();
        }

        @Override // androidx.recyclerview.widget.j
        public int n() {
            return (this.f2075a.o0() - this.f2075a.e0()) - this.f2075a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int p(View view) {
            this.f2075a.n0(view, true, this.f2077c);
            return this.f2077c.right;
        }

        @Override // androidx.recyclerview.widget.j
        public int q(View view) {
            this.f2075a.n0(view, true, this.f2077c);
            return this.f2077c.left;
        }

        @Override // androidx.recyclerview.widget.j
        public void r(int i4) {
            this.f2075a.C0(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends j {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.j
        public int d(View view) {
            return this.f2075a.O(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2075a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2075a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int g(View view) {
            return this.f2075a.U(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int h() {
            return this.f2075a.W();
        }

        @Override // androidx.recyclerview.widget.j
        public int i() {
            return this.f2075a.W() - this.f2075a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int j() {
            return this.f2075a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int k() {
            return this.f2075a.X();
        }

        @Override // androidx.recyclerview.widget.j
        public int l() {
            return this.f2075a.p0();
        }

        @Override // androidx.recyclerview.widget.j
        public int m() {
            return this.f2075a.g0();
        }

        @Override // androidx.recyclerview.widget.j
        public int n() {
            return (this.f2075a.W() - this.f2075a.g0()) - this.f2075a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int p(View view) {
            this.f2075a.n0(view, true, this.f2077c);
            return this.f2077c.bottom;
        }

        @Override // androidx.recyclerview.widget.j
        public int q(View view) {
            this.f2075a.n0(view, true, this.f2077c);
            return this.f2077c.top;
        }

        @Override // androidx.recyclerview.widget.j
        public void r(int i4) {
            this.f2075a.D0(i4);
        }
    }

    private j(RecyclerView.o oVar) {
        this.f2076b = RecyclerView.UNDEFINED_DURATION;
        this.f2077c = new Rect();
        this.f2075a = oVar;
    }

    /* synthetic */ j(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static j a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static j b(RecyclerView.o oVar, int i4) {
        if (i4 == 0) {
            return a(oVar);
        }
        if (i4 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static j c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f2076b) {
            return 0;
        }
        return n() - this.f2076b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i4);

    public void s() {
        this.f2076b = n();
    }
}
