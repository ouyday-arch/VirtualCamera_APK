package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class n extends RecyclerView.r {

    /* renamed from: a, reason: collision with root package name */
    RecyclerView f2083a;

    /* renamed from: b, reason: collision with root package name */
    private Scroller f2084b;

    /* renamed from: c, reason: collision with root package name */
    private final RecyclerView.t f2085c = new a();

    /* loaded from: classes.dex */
    class a extends RecyclerView.t {

        /* renamed from: a, reason: collision with root package name */
        boolean f2086a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i4) {
            super.a(recyclerView, i4);
            if (i4 == 0 && this.f2086a) {
                this.f2086a = false;
                n.this.l();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i4, int i5) {
            if (i4 == 0 && i5 == 0) {
                return;
            }
            this.f2086a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g {
        b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.g, androidx.recyclerview.widget.RecyclerView.z
        protected void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            n nVar = n.this;
            RecyclerView recyclerView = nVar.f2083a;
            if (recyclerView == null) {
                return;
            }
            int[] c5 = nVar.c(recyclerView.getLayoutManager(), view);
            int i4 = c5[0];
            int i5 = c5[1];
            int w4 = w(Math.max(Math.abs(i4), Math.abs(i5)));
            if (w4 > 0) {
                aVar.d(i4, i5, w4, this.f2065j);
            }
        }

        @Override // androidx.recyclerview.widget.g
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    private void g() {
        this.f2083a.removeOnScrollListener(this.f2085c);
        this.f2083a.setOnFlingListener(null);
    }

    private void j() {
        if (this.f2083a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f2083a.addOnScrollListener(this.f2085c);
        this.f2083a.setOnFlingListener(this);
    }

    private boolean k(RecyclerView.o oVar, int i4, int i5) {
        RecyclerView.z e4;
        int i6;
        if (!(oVar instanceof RecyclerView.z.b) || (e4 = e(oVar)) == null || (i6 = i(oVar, i4, i5)) == -1) {
            return false;
        }
        e4.p(i6);
        oVar.J1(e4);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i4, int i5) {
        RecyclerView.o layoutManager = this.f2083a.getLayoutManager();
        if (layoutManager == null || this.f2083a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f2083a.getMinFlingVelocity();
        return (Math.abs(i5) > minFlingVelocity || Math.abs(i4) > minFlingVelocity) && k(layoutManager, i4, i5);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2083a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            g();
        }
        this.f2083a = recyclerView;
        if (recyclerView != null) {
            j();
            this.f2084b = new Scroller(this.f2083a.getContext(), new DecelerateInterpolator());
            l();
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    public int[] d(int i4, int i5) {
        this.f2084b.fling(0, 0, i4, i5, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
        return new int[]{this.f2084b.getFinalX(), this.f2084b.getFinalY()};
    }

    protected RecyclerView.z e(RecyclerView.o oVar) {
        return f(oVar);
    }

    @Deprecated
    protected g f(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.z.b) {
            return new b(this.f2083a.getContext());
        }
        return null;
    }

    public abstract View h(RecyclerView.o oVar);

    public abstract int i(RecyclerView.o oVar, int i4, int i5);

    void l() {
        RecyclerView.o layoutManager;
        View h4;
        RecyclerView recyclerView = this.f2083a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (h4 = h(layoutManager)) == null) {
            return;
        }
        int[] c5 = c(layoutManager, h4);
        if (c5[0] == 0 && c5[1] == 0) {
            return;
        }
        this.f2083a.smoothScrollBy(c5[0], c5[1]);
    }
}
