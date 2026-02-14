package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b, reason: collision with root package name */
    private AnimatorSet f3345b;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f3345b = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean H(View view, View view2, boolean z4, boolean z5) {
        AnimatorSet animatorSet = this.f3345b;
        boolean z6 = animatorSet != null;
        if (z6) {
            animatorSet.cancel();
        }
        AnimatorSet J = J(view, view2, z4, z6);
        this.f3345b = J;
        J.addListener(new a());
        this.f3345b.start();
        if (!z5) {
            this.f3345b.end();
        }
        return true;
    }

    protected abstract AnimatorSet J(View view, View view2, boolean z4, boolean z5);
}
