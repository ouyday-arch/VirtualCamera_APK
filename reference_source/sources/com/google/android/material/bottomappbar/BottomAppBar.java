package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.h;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m0.j;
import n0.k;
import y.p;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* renamed from: j0, reason: collision with root package name */
    private static final int f2754j0 = j.f5041g;
    private final int Q;
    private final b1.g R;
    private Animator S;
    private Animator T;
    private int U;
    private int V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private int f2755a0;

    /* renamed from: b0, reason: collision with root package name */
    private ArrayList<f> f2756b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f2757c0;

    /* renamed from: d0, reason: collision with root package name */
    private Behavior f2758d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f2759e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f2760f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f2761g0;

    /* renamed from: h0, reason: collision with root package name */
    AnimatorListenerAdapter f2762h0;

    /* renamed from: i0, reason: collision with root package name */
    k<FloatingActionButton> f2763i0;

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: e, reason: collision with root package name */
        private final Rect f2764e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<BottomAppBar> f2765f;

        /* renamed from: g, reason: collision with root package name */
        private int f2766g;

        /* renamed from: h, reason: collision with root package name */
        private final View.OnLayoutChangeListener f2767h;

        /* loaded from: classes.dex */
        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f2765f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.j(Behavior.this.f2764e);
                int height = Behavior.this.f2764e.height();
                bottomAppBar.s0(height);
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f2766g == 0) {
                    ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(m0.d.f4972i) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (com.google.android.material.internal.j.c(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.Q;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.Q;
                    }
                }
            }
        }

        public Behavior() {
            this.f2767h = new a();
            this.f2764e = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2767h = new a();
            this.f2764e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i4) {
            this.f2765f = new WeakReference<>(bottomAppBar);
            View k02 = bottomAppBar.k0();
            if (k02 != null && !p.H(k02)) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) k02.getLayoutParams();
                fVar.f1306d = 49;
                this.f2766g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                if (k02 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) k02;
                    floatingActionButton.addOnLayoutChangeListener(this.f2767h);
                    bottomAppBar.c0(floatingActionButton);
                }
                bottomAppBar.r0();
            }
            coordinatorLayout.J(bottomAppBar, i4);
            return super.l(coordinatorLayout, bottomAppBar, i4);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i4, int i5) {
            return bottomAppBar.getHideOnScroll() && super.A(coordinatorLayout, bottomAppBar, view, view2, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.h0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends FloatingActionButton.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f2770a;

        /* loaded from: classes.dex */
        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.h0();
            }
        }

        b(int i4) {
            this.f2770a = i4;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.m0(this.f2770a));
            floatingActionButton.s(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.h0();
            BottomAppBar.this.T = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f2774a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f2775b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2776c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f2777d;

        d(ActionMenuView actionMenuView, int i4, boolean z4) {
            this.f2775b = actionMenuView;
            this.f2776c = i4;
            this.f2777d = z4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2774a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2774a) {
                return;
            }
            BottomAppBar.this.t0(this.f2775b, this.f2776c, this.f2777d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f2762h0.onAnimationStart(animator);
            FloatingActionButton j02 = BottomAppBar.this.j0();
            if (j02 != null) {
                j02.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g extends b0.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        int f2780d;

        /* renamed from: e, reason: collision with root package name */
        boolean f2781e;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i4) {
                return new g[i4];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2780d = parcel.readInt();
            this.f2781e = parcel.readInt() != 0;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f2780d);
            parcel.writeInt(this.f2781e ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.f2762h0);
        floatingActionButton.f(new e());
        floatingActionButton.g(this.f2763i0);
    }

    private void d0() {
        Animator animator = this.T;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.S;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void f0(int i4, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(j0(), "translationX", m0(i4));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void g0(int i4, boolean z4, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - l0(actionMenuView, i4, z4)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        } else {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.addListener(new d(actionMenuView, i4, z4));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f2759e0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return m0(this.U);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f2761g0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f2760f0;
    }

    private com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) this.R.C().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        ArrayList<f> arrayList;
        int i4 = this.f2755a0 - 1;
        this.f2755a0 = i4;
        if (i4 != 0 || (arrayList = this.f2756b0) == null) {
            return;
        }
        Iterator<f> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        ArrayList<f> arrayList;
        int i4 = this.f2755a0;
        this.f2755a0 = i4 + 1;
        if (i4 != 0 || (arrayList = this.f2756b0) == null) {
            return;
        }
        Iterator<f> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton j0() {
        View k02 = k0();
        if (k02 instanceof FloatingActionButton) {
            return (FloatingActionButton) k02;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View k0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).t(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float m0(int i4) {
        boolean c5 = com.google.android.material.internal.j.c(this);
        if (i4 == 1) {
            return ((getMeasuredWidth() / 2) - (this.Q + (c5 ? this.f2761g0 : this.f2760f0))) * (c5 ? -1 : 1);
        }
        return 0.0f;
    }

    private boolean n0() {
        FloatingActionButton j02 = j0();
        return j02 != null && j02.o();
    }

    private void o0(int i4, boolean z4) {
        if (p.H(this)) {
            Animator animator = this.T;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!n0()) {
                i4 = 0;
                z4 = false;
            }
            g0(i4, z4, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.T = animatorSet;
            animatorSet.addListener(new c());
            this.T.start();
        }
    }

    private void p0(int i4) {
        if (this.U == i4 || !p.H(this)) {
            return;
        }
        Animator animator = this.S;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.V == 1) {
            f0(i4, arrayList);
        } else {
            e0(i4, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.S = animatorSet;
        animatorSet.addListener(new a());
        this.S.start();
    }

    private void q0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (n0()) {
                t0(actionMenuView, this.U, this.f2757c0);
            } else {
                t0(actionMenuView, 0, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        getTopEdgeTreatment().l(getFabTranslationX());
        View k02 = k0();
        this.R.W((this.f2757c0 && n0()) ? 1.0f : 0.0f);
        if (k02 != null) {
            k02.setTranslationY(getFabTranslationY());
            k02.setTranslationX(getFabTranslationX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(ActionMenuView actionMenuView, int i4, boolean z4) {
        actionMenuView.setTranslationX(l0(actionMenuView, i4, z4));
    }

    protected void e0(int i4, List<Animator> list) {
        FloatingActionButton j02 = j0();
        if (j02 == null || j02.n()) {
            return;
        }
        i0();
        j02.l(new b(i4));
    }

    public ColorStateList getBackgroundTint() {
        return this.R.E();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f2758d0 == null) {
            this.f2758d0 = new Behavior();
        }
        return this.f2758d0;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.U;
    }

    public int getFabAnimationMode() {
        return this.V;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().d();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().e();
    }

    public boolean getHideOnScroll() {
        return this.W;
    }

    protected int l0(ActionMenuView actionMenuView, int i4, boolean z4) {
        if (i4 != 1 || !z4) {
            return 0;
        }
        boolean c5 = com.google.android.material.internal.j.c(this);
        int measuredWidth = c5 ? getMeasuredWidth() : 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f413a & 8388615) == 8388611) {
                measuredWidth = c5 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((c5 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (c5 ? this.f2760f0 : -this.f2761g0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.R);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (z4) {
            d0();
            r0();
        }
        q0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.f());
        this.U = gVar.f2780d;
        this.f2757c0 = gVar.f2781e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        gVar.f2780d = this.U;
        gVar.f2781e = this.f2757c0;
        return gVar;
    }

    boolean s0(int i4) {
        float f4 = i4;
        if (f4 == getTopEdgeTreatment().f()) {
            return false;
        }
        getTopEdgeTreatment().k(f4);
        this.R.invalidateSelf();
        return true;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        r.a.j(this.R, colorStateList);
    }

    public void setCradleVerticalOffset(float f4) {
        if (f4 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().g(f4);
            this.R.invalidateSelf();
            r0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        this.R.U(f4);
        getBehavior().G(this, this.R.B() - this.R.A());
    }

    public void setFabAlignmentMode(int i4) {
        p0(i4);
        o0(i4, this.f2757c0);
        this.U = i4;
    }

    public void setFabAnimationMode(int i4) {
        this.V = i4;
    }

    public void setFabCradleMargin(float f4) {
        if (f4 != getFabCradleMargin()) {
            getTopEdgeTreatment().h(f4);
            this.R.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f4) {
        if (f4 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().j(f4);
            this.R.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z4) {
        this.W = z4;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
