package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Property;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FloatingActionButton floatingActionButton, a1.b bVar) {
        super(floatingActionButton, bVar);
    }

    private Animator e0(float f4, float f5) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f3081x, "elevation", f4).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f3081x, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f5).setDuration(100L));
        animatorSet.setInterpolator(a.E);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void A() {
        b0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void C(int[] iArr) {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void D(float f4, float f5, float f6) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(a.F, e0(f4, f6));
        stateListAnimator.addState(a.G, e0(f4, f5));
        stateListAnimator.addState(a.H, e0(f4, f5));
        stateListAnimator.addState(a.I, e0(f4, f5));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f3081x, "elevation", f4).setDuration(0L));
        arrayList.add(ObjectAnimator.ofFloat(this.f3081x, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(a.E);
        stateListAnimator.addState(a.J, animatorSet);
        stateListAnimator.addState(a.K, e0(0.0f, 0.0f));
        this.f3081x.setStateListAnimator(stateListAnimator);
        if (V()) {
            b0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    boolean I() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void R(ColorStateList colorStateList) {
        Drawable drawable = this.f3060c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(z0.b.a(colorStateList));
        } else {
            super.R(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    boolean V() {
        return this.f3082y.d() || !X();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void Z() {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float m() {
        return this.f3081x.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void r(Rect rect) {
        if (this.f3082y.d()) {
            super.r(rect);
        } else {
            int sizeDimension = !X() ? (this.f3067j - this.f3081x.getSizeDimension()) / 2 : 0;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void y() {
    }
}
