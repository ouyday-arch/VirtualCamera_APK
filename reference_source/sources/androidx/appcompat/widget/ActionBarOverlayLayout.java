package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.j;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements c0, y.k, y.l {
    static final int[] C = {a.a.f1b, R.attr.windowContentOverlay};
    private final Runnable A;
    private final y.m B;

    /* renamed from: b, reason: collision with root package name */
    private int f755b;

    /* renamed from: c, reason: collision with root package name */
    private int f756c;

    /* renamed from: d, reason: collision with root package name */
    private ContentFrameLayout f757d;

    /* renamed from: e, reason: collision with root package name */
    ActionBarContainer f758e;

    /* renamed from: f, reason: collision with root package name */
    private d0 f759f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f760g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f761h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f762i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f763j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f764k;

    /* renamed from: l, reason: collision with root package name */
    boolean f765l;

    /* renamed from: m, reason: collision with root package name */
    private int f766m;

    /* renamed from: n, reason: collision with root package name */
    private int f767n;

    /* renamed from: o, reason: collision with root package name */
    private final Rect f768o;

    /* renamed from: p, reason: collision with root package name */
    private final Rect f769p;

    /* renamed from: q, reason: collision with root package name */
    private final Rect f770q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f771r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f772s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f773t;

    /* renamed from: u, reason: collision with root package name */
    private final Rect f774u;

    /* renamed from: v, reason: collision with root package name */
    private d f775v;

    /* renamed from: w, reason: collision with root package name */
    private OverScroller f776w;

    /* renamed from: x, reason: collision with root package name */
    ViewPropertyAnimator f777x;

    /* renamed from: y, reason: collision with root package name */
    final AnimatorListenerAdapter f778y;

    /* renamed from: z, reason: collision with root package name */
    private final Runnable f779z;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f777x = null;
            actionBarOverlayLayout.f765l = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f777x = null;
            actionBarOverlayLayout.f765l = false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f777x = actionBarOverlayLayout.f758e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f778y);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f777x = actionBarOverlayLayout.f758e.animate().translationY(-ActionBarOverlayLayout.this.f758e.getHeight()).setListener(ActionBarOverlayLayout.this.f778y);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(boolean z4);

        void b();

        void c();

        void d(int i4);

        void e();

        void f();
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i4, int i5) {
            super(i4, i5);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f756c = 0;
        this.f768o = new Rect();
        this.f769p = new Rect();
        this.f770q = new Rect();
        this.f771r = new Rect();
        this.f772s = new Rect();
        this.f773t = new Rect();
        this.f774u = new Rect();
        this.f778y = new a();
        this.f779z = new b();
        this.A = new c();
        v(context);
        this.B = new y.m(this);
    }

    private void A() {
        u();
        this.f779z.run();
    }

    private boolean B(float f4, float f5) {
        this.f776w.fling(0, 0, 0, (int) f5, 0, 0, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
        return this.f776w.getFinalY() > this.f758e.getHeight();
    }

    private void p() {
        u();
        this.A.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean q(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = r0
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = r0
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = r0
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d0 t(View view) {
        if (view instanceof d0) {
            return (d0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(C);
        this.f755b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f760g = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f761h = context.getApplicationInfo().targetSdkVersion < 19;
        this.f776w = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.A, 600L);
    }

    private void y() {
        u();
        postDelayed(this.f779z, 600L);
    }

    @Override // androidx.appcompat.widget.c0
    public void a(Menu menu, j.a aVar) {
        z();
        this.f759f.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.c0
    public boolean b() {
        z();
        return this.f759f.b();
    }

    @Override // androidx.appcompat.widget.c0
    public boolean c() {
        z();
        return this.f759f.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.c0
    public boolean d() {
        z();
        return this.f759f.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f760g == null || this.f761h) {
            return;
        }
        int bottom = this.f758e.getVisibility() == 0 ? (int) (this.f758e.getBottom() + this.f758e.getTranslationY() + 0.5f) : 0;
        this.f760g.setBounds(0, bottom, getWidth(), this.f760g.getIntrinsicHeight() + bottom);
        this.f760g.draw(canvas);
    }

    @Override // androidx.appcompat.widget.c0
    public boolean e() {
        z();
        return this.f759f.e();
    }

    @Override // androidx.appcompat.widget.c0
    public void f() {
        z();
        this.f759f.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        z();
        y.p.A(this);
        boolean q4 = q(this.f758e, rect, true, true, false, true);
        this.f771r.set(rect);
        c1.a(this, this.f771r, this.f768o);
        if (!this.f772s.equals(this.f771r)) {
            this.f772s.set(this.f771r);
            q4 = true;
        }
        if (!this.f769p.equals(this.f768o)) {
            this.f769p.set(this.f768o);
            q4 = true;
        }
        if (q4) {
            requestLayout();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.c0
    public boolean g() {
        z();
        return this.f759f.g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f758e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f759f.getTitle();
    }

    @Override // y.k
    public void h(View view, View view2, int i4, int i5) {
        if (i5 == 0) {
            onNestedScrollAccepted(view, view2, i4);
        }
    }

    @Override // y.k
    public void i(View view, int i4) {
        if (i4 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // y.k
    public void j(View view, int i4, int i5, int[] iArr, int i6) {
        if (i6 == 0) {
            onNestedPreScroll(view, i4, i5, iArr);
        }
    }

    @Override // androidx.appcompat.widget.c0
    public void k(int i4) {
        z();
        if (i4 == 2) {
            this.f759f.r();
        } else if (i4 == 5) {
            this.f759f.t();
        } else {
            if (i4 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.c0
    public void l() {
        z();
        this.f759f.h();
    }

    @Override // y.l
    public void m(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        n(view, i4, i5, i6, i7, i8);
    }

    @Override // y.k
    public void n(View view, int i4, int i5, int i6, int i7, int i8) {
        if (i8 == 0) {
            onNestedScroll(view, i4, i5, i6, i7);
        }
    }

    @Override // y.k
    public boolean o(View view, View view2, int i4, int i5) {
        return i5 == 0 && onStartNestedScroll(view, view2, i4);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        y.p.Y(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i10 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i9, i10, measuredWidth + i9, measuredHeight + i10);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int measuredHeight;
        z();
        measureChildWithMargins(this.f758e, i4, 0, i5, 0);
        e eVar = (e) this.f758e.getLayoutParams();
        int max = Math.max(0, this.f758e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f758e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f758e.getMeasuredState());
        boolean z4 = (y.p.A(this) & 256) != 0;
        if (z4) {
            measuredHeight = this.f755b;
            if (this.f763j && this.f758e.getTabContainer() != null) {
                measuredHeight += this.f755b;
            }
        } else {
            measuredHeight = this.f758e.getVisibility() != 8 ? this.f758e.getMeasuredHeight() : 0;
        }
        this.f770q.set(this.f768o);
        this.f773t.set(this.f771r);
        Rect rect = (this.f762i || z4) ? this.f773t : this.f770q;
        rect.top += measuredHeight;
        rect.bottom += 0;
        q(this.f757d, this.f770q, true, true, true, true);
        if (!this.f774u.equals(this.f773t)) {
            this.f774u.set(this.f773t);
            this.f757d.a(this.f773t);
        }
        measureChildWithMargins(this.f757d, i4, 0, i5, 0);
        e eVar2 = (e) this.f757d.getLayoutParams();
        int max3 = Math.max(max, this.f757d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f757d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f757d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i4, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i5, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (!this.f764k || !z4) {
            return false;
        }
        if (B(f4, f5)) {
            p();
        } else {
            A();
        }
        this.f765l = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        int i8 = this.f766m + i5;
        this.f766m = i8;
        setActionBarHideOffset(i8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i4) {
        this.B.b(view, view2, i4);
        this.f766m = getActionBarHideOffset();
        u();
        d dVar = this.f775v;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i4) {
        if ((i4 & 2) == 0 || this.f758e.getVisibility() != 0) {
            return false;
        }
        return this.f764k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f764k && !this.f765l) {
            if (this.f766m <= this.f758e.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.f775v;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i4) {
        super.onWindowSystemUiVisibilityChanged(i4);
        z();
        int i5 = this.f767n ^ i4;
        this.f767n = i4;
        boolean z4 = (i4 & 4) == 0;
        boolean z5 = (i4 & 256) != 0;
        d dVar = this.f775v;
        if (dVar != null) {
            dVar.a(!z5);
            if (z4 || !z5) {
                this.f775v.b();
            } else {
                this.f775v.e();
            }
        }
        if ((i5 & 256) == 0 || this.f775v == null) {
            return;
        }
        y.p.Y(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        this.f756c = i4;
        d dVar = this.f775v;
        if (dVar != null) {
            dVar.d(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i4) {
        u();
        this.f758e.setTranslationY(-Math.max(0, Math.min(i4, this.f758e.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f775v = dVar;
        if (getWindowToken() != null) {
            this.f775v.d(this.f756c);
            int i4 = this.f767n;
            if (i4 != 0) {
                onWindowSystemUiVisibilityChanged(i4);
                y.p.Y(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z4) {
        this.f763j = z4;
    }

    public void setHideOnContentScrollEnabled(boolean z4) {
        if (z4 != this.f764k) {
            this.f764k = z4;
            if (z4) {
                return;
            }
            u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i4) {
        z();
        this.f759f.setIcon(i4);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f759f.setIcon(drawable);
    }

    public void setLogo(int i4) {
        z();
        this.f759f.k(i4);
    }

    public void setOverlayMode(boolean z4) {
        this.f762i = z4;
        this.f761h = z4 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z4) {
    }

    public void setUiOptions(int i4) {
    }

    @Override // androidx.appcompat.widget.c0
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f759f.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.c0
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f759f.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        removeCallbacks(this.f779z);
        removeCallbacks(this.A);
        ViewPropertyAnimator viewPropertyAnimator = this.f777x;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f762i;
    }

    void z() {
        if (this.f757d == null) {
            this.f757d = (ContentFrameLayout) findViewById(a.f.f73b);
            this.f758e = (ActionBarContainer) findViewById(a.f.f74c);
            this.f759f = t(findViewById(a.f.f72a));
        }
    }
}
