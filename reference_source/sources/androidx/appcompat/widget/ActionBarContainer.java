package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    private boolean f732b;

    /* renamed from: c, reason: collision with root package name */
    private View f733c;

    /* renamed from: d, reason: collision with root package name */
    private View f734d;

    /* renamed from: e, reason: collision with root package name */
    private View f735e;

    /* renamed from: f, reason: collision with root package name */
    Drawable f736f;

    /* renamed from: g, reason: collision with root package name */
    Drawable f737g;

    /* renamed from: h, reason: collision with root package name */
    Drawable f738h;

    /* renamed from: i, reason: collision with root package name */
    boolean f739i;

    /* renamed from: j, reason: collision with root package name */
    boolean f740j;

    /* renamed from: k, reason: collision with root package name */
    private int f741k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y.p.d0(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.f133a);
        this.f736f = obtainStyledAttributes.getDrawable(a.j.f138b);
        this.f737g = obtainStyledAttributes.getDrawable(a.j.f148d);
        this.f741k = obtainStyledAttributes.getDimensionPixelSize(a.j.f178j, -1);
        boolean z4 = true;
        if (getId() == a.f.H) {
            this.f739i = true;
            this.f738h = obtainStyledAttributes.getDrawable(a.j.f143c);
        }
        obtainStyledAttributes.recycle();
        if (!this.f739i ? this.f736f != null || this.f737g != null : this.f738h != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f736f;
        if (drawable != null && drawable.isStateful()) {
            this.f736f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f737g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f737g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f738h;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f738h.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f733c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f736f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f737g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f738h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f734d = findViewById(a.f.f72a);
        this.f735e = findViewById(a.f.f77f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f732b || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z4, i4, i5, i6, i7);
        View view2 = this.f733c;
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (view2 != null && view2.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            int measuredHeight2 = measuredHeight - view2.getMeasuredHeight();
            int i8 = layoutParams.bottomMargin;
            view2.layout(i4, measuredHeight2 - i8, i6, measuredHeight - i8);
        }
        if (this.f739i) {
            Drawable drawable3 = this.f738h;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            z5 = z6;
        } else {
            if (this.f736f != null) {
                if (this.f734d.getVisibility() == 0) {
                    drawable2 = this.f736f;
                    left = this.f734d.getLeft();
                    top = this.f734d.getTop();
                    right = this.f734d.getRight();
                    view = this.f734d;
                } else {
                    View view3 = this.f735e;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f736f.setBounds(0, 0, 0, 0);
                        z6 = true;
                    } else {
                        drawable2 = this.f736f;
                        left = this.f735e.getLeft();
                        top = this.f735e.getTop();
                        right = this.f735e.getRight();
                        view = this.f735e;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z6 = true;
            }
            this.f740j = z7;
            if (z7 && (drawable = this.f737g) != null) {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
            z5 = z6;
        }
        if (z5) {
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.f734d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L1c
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L1c
            int r0 = r3.f741k
            if (r0 < 0) goto L1c
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L1c:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.f734d
            if (r4 != 0) goto L24
            return
        L24:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.f733c
            if (r0 == 0) goto L6f
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L6f
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L6f
            android.view.View r0 = r3.f734d
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L47
            android.view.View r0 = r3.f734d
        L42:
            int r0 = r3.a(r0)
            goto L53
        L47:
            android.view.View r0 = r3.f735e
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L52
            android.view.View r0 = r3.f735e
            goto L42
        L52:
            r0 = 0
        L53:
            if (r4 != r1) goto L5a
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L5d
        L5a:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L5d:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.f733c
            int r1 = r3.a(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f736f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f736f);
        }
        this.f736f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f734d;
            if (view != null) {
                this.f736f.setBounds(view.getLeft(), this.f734d.getTop(), this.f734d.getRight(), this.f734d.getBottom());
            }
        }
        boolean z4 = true;
        if (!this.f739i ? this.f736f != null || this.f737g != null : this.f738h != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f738h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f738h);
        }
        this.f738h = drawable;
        boolean z4 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f739i && (drawable2 = this.f738h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f739i ? !(this.f736f != null || this.f737g != null) : this.f738h == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f737g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f737g);
        }
        this.f737g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f740j && (drawable2 = this.f737g) != null) {
                drawable2.setBounds(this.f733c.getLeft(), this.f733c.getTop(), this.f733c.getRight(), this.f733c.getBottom());
            }
        }
        boolean z4 = true;
        if (!this.f739i ? this.f736f != null || this.f737g != null : this.f738h != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(p0 p0Var) {
        View view = this.f733c;
        if (view != null) {
            removeView(view);
        }
        this.f733c = p0Var;
        if (p0Var != null) {
            addView(p0Var);
            ViewGroup.LayoutParams layoutParams = p0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            p0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z4) {
        this.f732b = z4;
        setDescendantFocusability(z4 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f736f;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
        Drawable drawable2 = this.f737g;
        if (drawable2 != null) {
            drawable2.setVisible(z4, false);
        }
        Drawable drawable3 = this.f738h;
        if (drawable3 != null) {
            drawable3.setVisible(z4, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i4) {
        if (i4 != 0) {
            return super.startActionModeForChild(view, callback, i4);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f736f && !this.f739i) || (drawable == this.f737g && this.f740j) || ((drawable == this.f738h && this.f739i) || super.verifyDrawable(drawable));
    }
}
