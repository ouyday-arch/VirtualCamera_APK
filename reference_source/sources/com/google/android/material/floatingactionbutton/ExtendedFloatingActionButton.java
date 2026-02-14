package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;
import m0.j;
import m0.k;
import n0.h;
import y.p;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    /* renamed from: s, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.c f3023s;

    /* renamed from: t, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.c f3024t;

    /* renamed from: u, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.c f3025u;

    /* renamed from: v, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.c f3026v;

    /* renamed from: w, reason: collision with root package name */
    private final CoordinatorLayout.c<ExtendedFloatingActionButton> f3027w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f3028x;

    /* renamed from: y, reason: collision with root package name */
    private static final int f3021y = j.f5048n;

    /* renamed from: z, reason: collision with root package name */
    static final Property<View, Float> f3022z = new b(Float.class, "width");
    static final Property<View, Float> A = new c(Float.class, "height");

    /* loaded from: classes.dex */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f3029a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f3030b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3031c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f3030b = false;
            this.f3031c = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.O0);
            this.f3030b = obtainStyledAttributes.getBoolean(k.P0, false);
            this.f3031c = obtainStyledAttributes.getBoolean(k.Q0, true);
            obtainStyledAttributes.recycle();
        }

        private static boolean G(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f3030b || this.f3031c) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f3029a == null) {
                this.f3029a = new Rect();
            }
            Rect rect = this.f3029a;
            com.google.android.material.internal.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        private boolean M(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        protected void E(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.l(this.f3031c ? extendedFloatingActionButton.f3024t : extendedFloatingActionButton.f3025u, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!G(view)) {
                return false;
            }
            M(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i4) {
            List<View> s4 = coordinatorLayout.s(extendedFloatingActionButton);
            int size = s4.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = s4.get(i5);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.J(extendedFloatingActionButton, i4);
            return true;
        }

        protected void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.l(this.f3031c ? extendedFloatingActionButton.f3023s : extendedFloatingActionButton.f3026v, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f1310h == 0) {
                fVar.f1310h = 80;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3032a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.floatingactionbutton.c f3033b;

        a(com.google.android.material.floatingactionbutton.c cVar, d dVar) {
            this.f3033b = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3032a = true;
            this.f3033b.d();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3033b.c();
            if (this.f3032a) {
                return;
            }
            this.f3033b.f(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f3033b.onAnimationStart(animator);
            this.f3032a = false;
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property<View, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f4) {
            view.getLayoutParams().width = f4.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    static class c extends Property<View, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f4) {
            view.getLayoutParams().height = f4.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.google.android.material.floatingactionbutton.c cVar, d dVar) {
        if (cVar.g()) {
            return;
        }
        if (!m()) {
            cVar.i();
            cVar.f(dVar);
            return;
        }
        measure(0, 0);
        AnimatorSet b5 = cVar.b();
        b5.addListener(new a(cVar, dVar));
        Iterator<Animator.AnimatorListener> it = cVar.e().iterator();
        while (it.hasNext()) {
            b5.addListener(it.next());
        }
        b5.start();
    }

    private boolean m() {
        return p.H(this) && !isInEditMode();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return this.f3027w;
    }

    int getCollapsedSize() {
        return (Math.min(p.y(this), p.x(this)) * 2) + getIconSize();
    }

    public h getExtendMotionSpec() {
        return this.f3024t.a();
    }

    public h getHideMotionSpec() {
        return this.f3026v.a();
    }

    public h getShowMotionSpec() {
        return this.f3025u.a();
    }

    public h getShrinkMotionSpec() {
        return this.f3023s.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3028x && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.f3028x = false;
            this.f3023s.i();
        }
    }

    public void setExtendMotionSpec(h hVar) {
        this.f3024t.h(hVar);
    }

    public void setExtendMotionSpecResource(int i4) {
        setExtendMotionSpec(h.c(getContext(), i4));
    }

    public void setExtended(boolean z4) {
        if (this.f3028x == z4) {
            return;
        }
        com.google.android.material.floatingactionbutton.c cVar = z4 ? this.f3024t : this.f3023s;
        if (cVar.g()) {
            return;
        }
        cVar.i();
    }

    public void setHideMotionSpec(h hVar) {
        this.f3026v.h(hVar);
    }

    public void setHideMotionSpecResource(int i4) {
        setHideMotionSpec(h.c(getContext(), i4));
    }

    public void setShowMotionSpec(h hVar) {
        this.f3025u.h(hVar);
    }

    public void setShowMotionSpecResource(int i4) {
        setShowMotionSpec(h.c(getContext(), i4));
    }

    public void setShrinkMotionSpec(h hVar) {
        this.f3023s.h(hVar);
    }

    public void setShrinkMotionSpecResource(int i4) {
        setShrinkMotionSpec(h.c(getContext(), i4));
    }
}
