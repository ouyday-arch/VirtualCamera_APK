package com.ashokvarma.bottomnavigation.behaviour;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.google.android.material.snackbar.Snackbar$SnackbarLayout;
import d0.b;
import java.lang.ref.WeakReference;
import java.util.List;
import y.p;

/* loaded from: classes.dex */
public class BottomVerticalScrollBehavior<V extends View> extends VerticalScrollingBehavior<V> {

    /* renamed from: i, reason: collision with root package name */
    private static final Interpolator f2526i = new b();

    /* renamed from: g, reason: collision with root package name */
    private int f2527g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<BottomNavigationBar> f2528h;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2529b;

        a(View view) {
            this.f2529b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomVerticalScrollBehavior.this.f2527g = this.f2529b.getHeight();
        }
    }

    private Snackbar$SnackbarLayout J(CoordinatorLayout coordinatorLayout, V v4) {
        List<View> s4 = coordinatorLayout.s(v4);
        int size = s4.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view = s4.get(i4);
            if (view instanceof Snackbar$SnackbarLayout) {
                return (Snackbar$SnackbarLayout) view;
            }
        }
        return null;
    }

    private void K(CoordinatorLayout coordinatorLayout, V v4, int i4) {
        BottomNavigationBar bottomNavigationBar = this.f2528h.get();
        if (bottomNavigationBar == null || !bottomNavigationBar.k()) {
            return;
        }
        if (i4 == -1 && bottomNavigationBar.l()) {
            N(coordinatorLayout, v4, J(coordinatorLayout, v4), -this.f2527g);
            bottomNavigationBar.v();
        } else {
            if (i4 != 1 || bottomNavigationBar.l()) {
                return;
            }
            N(coordinatorLayout, v4, J(coordinatorLayout, v4), 0.0f);
            bottomNavigationBar.g();
        }
    }

    private boolean L(View view) {
        return view instanceof Snackbar$SnackbarLayout;
    }

    private void M(CoordinatorLayout coordinatorLayout, V v4, View view) {
        N(coordinatorLayout, v4, view, v4.getTranslationY() - v4.getHeight());
    }

    private void N(CoordinatorLayout coordinatorLayout, V v4, View view, float f4) {
        if (view == null || !(view instanceof Snackbar$SnackbarLayout)) {
            return;
        }
        p.c(view).e(f2526i).d(80L).h(0L).k(f4).j();
    }

    @Override // com.ashokvarma.bottomnavigation.behaviour.VerticalScrollingBehavior
    protected boolean E(CoordinatorLayout coordinatorLayout, V v4, View view, float f4, float f5, boolean z4, int i4) {
        return z4;
    }

    @Override // com.ashokvarma.bottomnavigation.behaviour.VerticalScrollingBehavior
    public void F(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int[] iArr, int i6) {
    }

    @Override // com.ashokvarma.bottomnavigation.behaviour.VerticalScrollingBehavior
    public void G(CoordinatorLayout coordinatorLayout, V v4, int i4, int i5, int i6) {
        K(coordinatorLayout, v4, i4);
    }

    @Override // com.ashokvarma.bottomnavigation.behaviour.VerticalScrollingBehavior
    public void H(CoordinatorLayout coordinatorLayout, V v4, int i4, int i5, int i6) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, V v4, View view) {
        return L(view) || super.e(coordinatorLayout, v4, view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, V v4, View view) {
        if (!L(view)) {
            return super.h(coordinatorLayout, v4, view);
        }
        M(coordinatorLayout, v4, view);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v4, int i4) {
        coordinatorLayout.J(v4, i4);
        if (v4 instanceof BottomNavigationBar) {
            this.f2528h = new WeakReference<>((BottomNavigationBar) v4);
        }
        v4.post(new a(v4));
        M(coordinatorLayout, v4, J(coordinatorLayout, v4));
        return super.l(coordinatorLayout, v4, i4);
    }
}
