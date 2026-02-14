package com.ashokvarma.bottomnavigation.behaviour;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar$SnackbarLayout;
import d0.b;
import java.util.List;
import y.p;
import y.t;

/* loaded from: classes.dex */
public class BottomNavBarFabBehaviour extends CoordinatorLayout.c<FloatingActionButton> {

    /* renamed from: b, reason: collision with root package name */
    static final Interpolator f2524b = new b();

    /* renamed from: a, reason: collision with root package name */
    t f2525a;

    private void E(FloatingActionButton floatingActionButton) {
        t tVar = this.f2525a;
        if (tVar != null) {
            tVar.b();
            return;
        }
        t c5 = p.c(floatingActionButton);
        this.f2525a = c5;
        c5.d(400L);
        this.f2525a.e(f2524b);
    }

    private float[] F(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
        List<View> s4 = coordinatorLayout.s(floatingActionButton);
        int size = s4.size();
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < size; i4++) {
            View view = s4.get(i4);
            if (view instanceof BottomNavigationBar) {
                f5 = view.getHeight();
                f4 = Math.min(f4, view.getTranslationY() - f5);
            }
        }
        return new float[]{f4, f5};
    }

    private float G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
        List<View> s4 = coordinatorLayout.s(floatingActionButton);
        int size = s4.size();
        float f4 = 0.0f;
        for (int i4 = 0; i4 < size; i4++) {
            View view = s4.get(i4);
            if ((view instanceof Snackbar$SnackbarLayout) && coordinatorLayout.g(floatingActionButton, view)) {
                f4 = Math.min(f4, view.getTranslationY() - view.getHeight());
            }
        }
        return f4;
    }

    private boolean H(View view) {
        return (view instanceof BottomNavigationBar) || (view instanceof Snackbar$SnackbarLayout);
    }

    private void M(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        float G = G(coordinatorLayout, floatingActionButton);
        float[] F = F(coordinatorLayout, floatingActionButton);
        float f4 = F[0];
        float f5 = F[1];
        if (G >= f4) {
            G = f4;
        }
        float translationY = floatingActionButton.getTranslationY();
        E(floatingActionButton);
        if (!floatingActionButton.isShown() || Math.abs(translationY - G) <= floatingActionButton.getHeight() * 0.667f) {
            floatingActionButton.setTranslationY(G);
        } else {
            this.f2525a.k(G).j();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public boolean e(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        return H(view) || super.e(coordinatorLayout, floatingActionButton, view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        if (!H(view)) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }
        M(coordinatorLayout, floatingActionButton, view);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void i(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        if (H(view)) {
            M(coordinatorLayout, floatingActionButton, view);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i4) {
        coordinatorLayout.J(floatingActionButton, i4);
        M(coordinatorLayout, floatingActionButton, null);
        return super.l(coordinatorLayout, floatingActionButton, i4);
    }
}
