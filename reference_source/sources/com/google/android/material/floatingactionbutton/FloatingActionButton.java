package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.n;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.k;
import java.util.List;
import m0.j;
import n0.h;
import y.p;

/* loaded from: classes.dex */
public class FloatingActionButton extends k implements v0.a, n, CoordinatorLayout.b {

    /* renamed from: q, reason: collision with root package name */
    private static final int f3035q = j.f5038d;

    /* renamed from: c, reason: collision with root package name */
    private ColorStateList f3036c;

    /* renamed from: d, reason: collision with root package name */
    private PorterDuff.Mode f3037d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f3038e;

    /* renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f3039f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f3040g;

    /* renamed from: h, reason: collision with root package name */
    private int f3041h;

    /* renamed from: i, reason: collision with root package name */
    private int f3042i;

    /* renamed from: j, reason: collision with root package name */
    private int f3043j;

    /* renamed from: k, reason: collision with root package name */
    private int f3044k;

    /* renamed from: l, reason: collision with root package name */
    boolean f3045l;

    /* renamed from: m, reason: collision with root package name */
    final Rect f3046m;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f3047n;

    /* renamed from: o, reason: collision with root package name */
    private final androidx.appcompat.widget.n f3048o;

    /* renamed from: p, reason: collision with root package name */
    private com.google.android.material.floatingactionbutton.a f3049p;

    /* loaded from: classes.dex */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f3050a;

        /* renamed from: b, reason: collision with root package name */
        private b f3051b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3052c;

        public BaseBehavior() {
            this.f3052c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.k.S0);
            this.f3052c = obtainStyledAttributes.getBoolean(m0.k.T0, true);
            obtainStyledAttributes.recycle();
        }

        private static boolean F(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f3046m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i4 = 0;
            int i5 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i4 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i4 = -rect.top;
            }
            if (i4 != 0) {
                p.N(floatingActionButton, i4);
            }
            if (i5 != 0) {
                p.M(floatingActionButton, i5);
            }
        }

        private boolean J(View view, FloatingActionButton floatingActionButton) {
            return this.f3052c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f3050a == null) {
                this.f3050a = new Rect();
            }
            Rect rect = this.f3050a;
            com.google.android.material.internal.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m(this.f3051b, false);
                return true;
            }
            floatingActionButton.t(this.f3051b, false);
            return true;
        }

        private boolean L(View view, FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.m(this.f3051b, false);
                return true;
            }
            floatingActionButton.t(this.f3051b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f3046m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!F(view)) {
                return false;
            }
            L(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i4) {
            List<View> s4 = coordinatorLayout.s(floatingActionButton);
            int size = s4.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = s4.get(i5);
                if (!(view instanceof AppBarLayout)) {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.J(floatingActionButton, i4);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f1310h == 0) {
                fVar.f1310h = 80;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: E */
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: H */
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: I */
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i4) {
            return super.l(coordinatorLayout, floatingActionButton, i4);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void g(CoordinatorLayout.f fVar) {
            super.g(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f3053a;

        a(b bVar) {
            this.f3053a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void a() {
            this.f3053a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void b() {
            this.f3053a.a(FloatingActionButton.this);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements a1.b {
        c() {
        }

        @Override // a1.b
        public void a(int i4, int i5, int i6, int i7) {
            FloatingActionButton.this.f3046m.set(i4, i5, i6, i7);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i4 + floatingActionButton.f3043j, i5 + FloatingActionButton.this.f3043j, i6 + FloatingActionButton.this.f3043j, i7 + FloatingActionButton.this.f3043j);
        }

        @Override // a1.b
        public void c(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // a1.b
        public boolean d() {
            return FloatingActionButton.this.f3045l;
        }
    }

    /* loaded from: classes.dex */
    class d<T extends FloatingActionButton> implements a.i {

        /* renamed from: a, reason: collision with root package name */
        private final n0.k<T> f3056a;

        d(n0.k<T> kVar) {
            this.f3056a = kVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.i
        public void a() {
            this.f3056a.a(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.i
        public void b() {
            this.f3056a.b(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && ((d) obj).f3056a.equals(this.f3056a);
        }

        public int hashCode() {
            return this.f3056a.hashCode();
        }
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.f3049p == null) {
            this.f3049p = h();
        }
        return this.f3049p;
    }

    private com.google.android.material.floatingactionbutton.a h() {
        return new com.google.android.material.floatingactionbutton.b(this, new c());
    }

    private int k(int i4) {
        int i5 = this.f3042i;
        if (i5 != 0) {
            return i5;
        }
        Resources resources = getResources();
        if (i4 != -1) {
            return resources.getDimensionPixelSize(i4 != 1 ? m0.d.f4967d : m0.d.f4966c);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? k(1) : k(0);
    }

    private void p(Rect rect) {
        int i4 = rect.left;
        Rect rect2 = this.f3046m;
        rect.left = i4 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void q() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f3038e;
        if (colorStateList == null) {
            r.a.a(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f3039f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(androidx.appcompat.widget.j.e(colorForState, mode));
    }

    private static int r(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i4, size);
        }
        if (mode == 0) {
            return i4;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    private a.j u(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // v0.a
    public boolean a() {
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().C(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void g(n0.k<? extends FloatingActionButton> kVar) {
        getImpl().f(new d(kVar));
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f3036c;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f3037d;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().m();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().s();
    }

    public Drawable getContentBackground() {
        return getImpl().j();
    }

    public int getCustomSize() {
        return this.f3042i;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public h getHideMotionSpec() {
        return getImpl().o();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f3040g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f3040g;
    }

    public b1.k getShapeAppearanceModel() {
        return (b1.k) x.h.c(getImpl().t());
    }

    public h getShowMotionSpec() {
        return getImpl().u();
    }

    public int getSize() {
        return this.f3041h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSizeDimension() {
        return k(this.f3041h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f3038e;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f3039f;
    }

    public boolean getUseCompatPadding() {
        return this.f3045l;
    }

    @Deprecated
    public boolean i(Rect rect) {
        if (!p.H(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        p(rect);
        return true;
    }

    public void j(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        p(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().y();
    }

    public void l(b bVar) {
        m(bVar, true);
    }

    void m(b bVar, boolean z4) {
        getImpl().v(u(bVar), z4);
    }

    public boolean n() {
        return getImpl().w();
    }

    public boolean o() {
        return getImpl().x();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().z();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        int sizeDimension = getSizeDimension();
        this.f3043j = (sizeDimension - this.f3044k) / 2;
        getImpl().b0();
        int min = Math.min(r(sizeDimension, i4), r(sizeDimension, i5));
        Rect rect = this.f3046m;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c1.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c1.a aVar = (c1.a) parcelable;
        super.onRestoreInstanceState(aVar.f());
        throw null;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        new c1.a(onSaveInstanceState);
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && i(this.f3047n) && !this.f3047n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void s(b bVar) {
        t(bVar, true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3036c != colorStateList) {
            this.f3036c = colorStateList;
            getImpl().J(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3037d != mode) {
            this.f3037d = mode;
            getImpl().K(mode);
        }
    }

    public void setCompatElevation(float f4) {
        getImpl().L(f4);
    }

    public void setCompatElevationResource(int i4) {
        setCompatElevation(getResources().getDimension(i4));
    }

    public void setCompatHoveredFocusedTranslationZ(float f4) {
        getImpl().O(f4);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i4) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i4));
    }

    public void setCompatPressedTranslationZ(float f4) {
        getImpl().Q(f4);
    }

    public void setCompatPressedTranslationZResource(int i4) {
        setCompatPressedTranslationZ(getResources().getDimension(i4));
    }

    public void setCustomSize(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i4 != this.f3042i) {
            this.f3042i = i4;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        getImpl().c0(f4);
    }

    public void setEnsureMinTouchTargetSize(boolean z4) {
        if (z4 != getImpl().n()) {
            getImpl().M(z4);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i4) {
        throw null;
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().N(hVar);
    }

    public void setHideMotionSpecResource(int i4) {
        setHideMotionSpec(h.c(getContext(), i4));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().a0();
            if (this.f3038e != null) {
                q();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i4) {
        this.f3048o.g(i4);
        q();
    }

    public void setRippleColor(int i4) {
        setRippleColor(ColorStateList.valueOf(i4));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f3040g != colorStateList) {
            this.f3040g = colorStateList;
            getImpl().R(this.f3040g);
        }
    }

    @Override // android.view.View
    public void setScaleX(float f4) {
        super.setScaleX(f4);
        getImpl().G();
    }

    @Override // android.view.View
    public void setScaleY(float f4) {
        super.setScaleY(f4);
        getImpl().G();
    }

    public void setShadowPaddingEnabled(boolean z4) {
        getImpl().S(z4);
    }

    @Override // b1.n
    public void setShapeAppearanceModel(b1.k kVar) {
        getImpl().T(kVar);
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().U(hVar);
    }

    public void setShowMotionSpecResource(int i4) {
        setShowMotionSpec(h.c(getContext(), i4));
    }

    public void setSize(int i4) {
        this.f3042i = 0;
        if (i4 != this.f3041h) {
            this.f3041h = i4;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f3038e != colorStateList) {
            this.f3038e = colorStateList;
            q();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f3039f != mode) {
            this.f3039f = mode;
            q();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f4) {
        super.setTranslationX(f4);
        getImpl().H();
    }

    @Override // android.view.View
    public void setTranslationY(float f4) {
        super.setTranslationY(f4);
        getImpl().H();
    }

    @Override // android.view.View
    public void setTranslationZ(float f4) {
        super.setTranslationZ(f4);
        getImpl().H();
    }

    public void setUseCompatPadding(boolean z4) {
        if (this.f3045l != z4) {
            this.f3045l = z4;
            getImpl().A();
        }
    }

    @Override // com.google.android.material.internal.k, android.widget.ImageView, android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
    }

    void t(b bVar, boolean z4) {
        getImpl().Y(u(bVar), z4);
    }
}
