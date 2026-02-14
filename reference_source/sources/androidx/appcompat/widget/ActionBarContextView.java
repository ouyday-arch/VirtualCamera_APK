package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f742j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f743k;

    /* renamed from: l, reason: collision with root package name */
    private View f744l;

    /* renamed from: m, reason: collision with root package name */
    private View f745m;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f746n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f747o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f748p;

    /* renamed from: q, reason: collision with root package name */
    private int f749q;

    /* renamed from: r, reason: collision with root package name */
    private int f750r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f751s;

    /* renamed from: t, reason: collision with root package name */
    private int f752t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f.b f753b;

        a(f.b bVar) {
            this.f753b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f753b.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.f9j);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        w0 u4 = w0.u(context, attributeSet, a.j.f253y, i4, 0);
        y.p.d0(this, u4.g(a.j.f258z));
        this.f749q = u4.n(a.j.D, 0);
        this.f750r = u4.n(a.j.C, 0);
        this.f910f = u4.m(a.j.B, 0);
        this.f752t = u4.n(a.j.A, a.g.f101d);
        u4.v();
    }

    private void i() {
        if (this.f746n == null) {
            LayoutInflater.from(getContext()).inflate(a.g.f98a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f746n = linearLayout;
            this.f747o = (TextView) linearLayout.findViewById(a.f.f76e);
            this.f748p = (TextView) this.f746n.findViewById(a.f.f75d);
            if (this.f749q != 0) {
                this.f747o.setTextAppearance(getContext(), this.f749q);
            }
            if (this.f750r != 0) {
                this.f748p.setTextAppearance(getContext(), this.f750r);
            }
        }
        this.f747o.setText(this.f742j);
        this.f748p.setText(this.f743k);
        boolean z4 = !TextUtils.isEmpty(this.f742j);
        boolean z5 = !TextUtils.isEmpty(this.f743k);
        int i4 = 0;
        this.f748p.setVisibility(z5 ? 0 : 8);
        LinearLayout linearLayout2 = this.f746n;
        if (!z4 && !z5) {
            i4 = 8;
        }
        linearLayout2.setVisibility(i4);
        if (this.f746n.getParent() == null) {
            addView(this.f746n);
        }
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ y.t f(int i4, long j4) {
        return super.f(i4, j4);
    }

    public void g() {
        if (this.f744l == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f743k;
    }

    public CharSequence getTitle() {
        return this.f742j;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(f.b r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.f744l
            if (r0 != 0) goto L19
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.f752t
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.f744l = r0
        L15:
            r3.addView(r0)
            goto L22
        L19:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L22
            android.view.View r0 = r3.f744l
            goto L15
        L22:
            android.view.View r0 = r3.f744l
            int r1 = a.f.f80i
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.ActionBarContextView$a r1 = new androidx.appcompat.widget.ActionBarContextView$a
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.e()
            androidx.appcompat.view.menu.e r4 = (androidx.appcompat.view.menu.e) r4
            androidx.appcompat.widget.c r0 = r3.f909e
            if (r0 == 0) goto L3f
            r0.x()
        L3f:
            androidx.appcompat.widget.c r0 = new androidx.appcompat.widget.c
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.f909e = r0
            r1 = 1
            r0.I(r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            androidx.appcompat.widget.c r1 = r3.f909e
            android.content.Context r2 = r3.f907c
            r4.c(r1, r2)
            androidx.appcompat.widget.c r4 = r3.f909e
            androidx.appcompat.view.menu.k r4 = r4.o(r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.f908d = r4
            r1 = 0
            y.p.d0(r4, r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.f908d
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.h(f.b):void");
    }

    public boolean j() {
        return this.f751s;
    }

    public void k() {
        removeAllViews();
        this.f745m = null;
        this.f908d = null;
    }

    public boolean l() {
        c cVar = this.f909e;
        if (cVar != null) {
            return cVar.J();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f909e;
        if (cVar != null) {
            cVar.A();
            this.f909e.B();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f742j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        boolean b5 = c1.b(this);
        int paddingRight = b5 ? (i6 - i4) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
        View view = this.f744l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f744l.getLayoutParams();
            int i8 = b5 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i9 = b5 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d5 = androidx.appcompat.widget.a.d(paddingRight, i8, b5);
            paddingRight = androidx.appcompat.widget.a.d(d5 + e(this.f744l, d5, paddingTop, paddingTop2, b5), i9, b5);
        }
        int i10 = paddingRight;
        LinearLayout linearLayout = this.f746n;
        if (linearLayout != null && this.f745m == null && linearLayout.getVisibility() != 8) {
            i10 += e(this.f746n, i10, paddingTop, paddingTop2, b5);
        }
        int i11 = i10;
        View view2 = this.f745m;
        if (view2 != null) {
            e(view2, i11, paddingTop, paddingTop2, b5);
        }
        int paddingLeft = b5 ? getPaddingLeft() : (i6 - i4) - getPaddingRight();
        ActionMenuView actionMenuView = this.f908d;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b5);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        if (View.MeasureSpec.getMode(i4) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i5) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i4);
        int i6 = this.f910f;
        if (i6 <= 0) {
            i6 = View.MeasureSpec.getSize(i5);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i7 = i6 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, RecyclerView.UNDEFINED_DURATION);
        View view = this.f744l;
        if (view != null) {
            int c5 = c(view, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f744l.getLayoutParams();
            paddingLeft = c5 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f908d;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f908d, paddingLeft, makeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f746n;
        if (linearLayout != null && this.f745m == null) {
            if (this.f751s) {
                this.f746n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f746n.getMeasuredWidth();
                boolean z4 = measuredWidth <= paddingLeft;
                if (z4) {
                    paddingLeft -= measuredWidth;
                }
                this.f746n.setVisibility(z4 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
            }
        }
        View view2 = this.f745m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i8 = layoutParams.width;
            int i9 = i8 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i8 >= 0) {
                paddingLeft = Math.min(i8, paddingLeft);
            }
            int i10 = layoutParams.height;
            int i11 = i10 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i10 >= 0) {
                i7 = Math.min(i10, i7);
            }
            this.f745m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i9), View.MeasureSpec.makeMeasureSpec(i7, i11));
        }
        if (this.f910f > 0) {
            setMeasuredDimension(size, i6);
            return;
        }
        int childCount = getChildCount();
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            int measuredHeight = getChildAt(i13).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i12) {
                i12 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i12);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i4) {
        this.f910f = i4;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f745m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f745m = view;
        if (view != null && (linearLayout = this.f746n) != null) {
            removeView(linearLayout);
            this.f746n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f743k = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f742j = charSequence;
        i();
    }

    public void setTitleOptional(boolean z4) {
        if (z4 != this.f751s) {
            requestLayout();
        }
        this.f751s = z4;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i4) {
        super.setVisibility(i4);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
