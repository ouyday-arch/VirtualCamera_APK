package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    private int f2732a;

    /* renamed from: b, reason: collision with root package name */
    private int f2733b;

    /* renamed from: c, reason: collision with root package name */
    private int f2734c;

    /* renamed from: d, reason: collision with root package name */
    private ViewPropertyAnimator f2735d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f2735d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f2732a = 0;
        this.f2733b = 2;
        this.f2734c = 0;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2732a = 0;
        this.f2733b = 2;
        this.f2734c = 0;
    }

    private void F(V v4, int i4, long j4, TimeInterpolator timeInterpolator) {
        this.f2735d = v4.animate().translationY(i4).setInterpolator(timeInterpolator).setDuration(j4).setListener(new a());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v4, View view, View view2, int i4, int i5) {
        return i4 == 2;
    }

    public void G(V v4, int i4) {
        this.f2734c = i4;
        if (this.f2733b == 1) {
            v4.setTranslationY(this.f2732a + i4);
        }
    }

    public void H(V v4) {
        if (this.f2733b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2735d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v4.clearAnimation();
        }
        this.f2733b = 1;
        F(v4, this.f2732a + this.f2734c, 175L, n0.a.f5240c);
    }

    public void I(V v4) {
        if (this.f2733b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2735d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v4.clearAnimation();
        }
        this.f2733b = 2;
        F(v4, 0, 225L, n0.a.f5241d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v4, int i4) {
        this.f2732a = v4.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v4.getLayoutParams()).bottomMargin;
        return super.l(coordinatorLayout, v4, i4);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        if (i5 > 0) {
            H(v4);
        } else if (i5 < 0) {
            I(v4);
        }
    }
}
