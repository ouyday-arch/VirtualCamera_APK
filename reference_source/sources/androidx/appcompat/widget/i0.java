package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public class i0 extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    private boolean f1020b;

    /* renamed from: c, reason: collision with root package name */
    private int f1021c;

    /* renamed from: d, reason: collision with root package name */
    private int f1022d;

    /* renamed from: e, reason: collision with root package name */
    private int f1023e;

    /* renamed from: f, reason: collision with root package name */
    private int f1024f;

    /* renamed from: g, reason: collision with root package name */
    private int f1025g;

    /* renamed from: h, reason: collision with root package name */
    private float f1026h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1027i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f1028j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f1029k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f1030l;

    /* renamed from: m, reason: collision with root package name */
    private int f1031m;

    /* renamed from: n, reason: collision with root package name */
    private int f1032n;

    /* renamed from: o, reason: collision with root package name */
    private int f1033o;

    /* renamed from: p, reason: collision with root package name */
    private int f1034p;

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public float f1035a;

        /* renamed from: b, reason: collision with root package name */
        public int f1036b;

        public a(int i4, int i5) {
            super(i4, i5);
            this.f1036b = -1;
            this.f1035a = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1036b = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.f190l1);
            this.f1035a = obtainStyledAttributes.getFloat(a.j.f200n1, 0.0f);
            this.f1036b = obtainStyledAttributes.getInt(a.j.f195m1, -1);
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1036b = -1;
        }
    }

    public i0(Context context) {
        this(context, null);
    }

    public i0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i0(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1020b = true;
        this.f1021c = -1;
        this.f1022d = 0;
        this.f1024f = 8388659;
        w0 u4 = w0.u(context, attributeSet, a.j.f140b1, i4, 0);
        int k4 = u4.k(a.j.f150d1, -1);
        if (k4 >= 0) {
            setOrientation(k4);
        }
        int k5 = u4.k(a.j.f145c1, -1);
        if (k5 >= 0) {
            setGravity(k5);
        }
        boolean a5 = u4.a(a.j.f155e1, true);
        if (!a5) {
            setBaselineAligned(a5);
        }
        this.f1026h = u4.i(a.j.f165g1, -1.0f);
        this.f1021c = u4.k(a.j.f160f1, -1);
        this.f1027i = u4.a(a.j.f180j1, false);
        setDividerDrawable(u4.g(a.j.f170h1));
        this.f1033o = u4.k(a.j.f185k1, 0);
        this.f1034p = u4.f(a.j.f175i1, 0);
        u4.v();
    }

    private void A(View view, int i4, int i5, int i6, int i7) {
        view.layout(i4, i5, i6 + i4, i7 + i5);
    }

    private void k(int i4, int i5) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i6 = 0; i6 < i4; i6++) {
            View s4 = s(i6);
            if (s4.getVisibility() != 8) {
                a aVar = (a) s4.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                    int i7 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    ((ViewGroup.MarginLayoutParams) aVar).width = s4.getMeasuredWidth();
                    measureChildWithMargins(s4, i5, 0, makeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).width = i7;
                }
            }
        }
    }

    private void l(int i4, int i5) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i6 = 0; i6 < i4; i6++) {
            View s4 = s(i6);
            if (s4.getVisibility() != 8) {
                a aVar = (a) s4.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i7 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = s4.getMeasuredHeight();
                    measureChildWithMargins(s4, makeMeasureSpec, 0, i5, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i7;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void g(Canvas canvas) {
        int right;
        int left;
        int i4;
        int virtualChildCount = getVirtualChildCount();
        boolean b5 = c1.b(this);
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View s4 = s(i5);
            if (s4 != null && s4.getVisibility() != 8 && t(i5)) {
                a aVar = (a) s4.getLayoutParams();
                j(canvas, b5 ? s4.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin : (s4.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.f1031m);
            }
        }
        if (t(virtualChildCount)) {
            View s5 = s(virtualChildCount - 1);
            if (s5 != null) {
                a aVar2 = (a) s5.getLayoutParams();
                if (b5) {
                    left = s5.getLeft();
                    i4 = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                    right = (left - i4) - this.f1031m;
                } else {
                    right = s5.getRight() + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                }
            } else if (b5) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                i4 = getPaddingRight();
                right = (left - i4) - this.f1031m;
            }
            j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i4;
        if (this.f1021c < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i5 = this.f1021c;
        if (childCount <= i5) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i5);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1021c == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i6 = this.f1022d;
        if (this.f1023e == 1 && (i4 = this.f1024f & 112) != 48) {
            if (i4 == 16) {
                i6 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1025g) / 2;
            } else if (i4 == 80) {
                i6 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1025g;
            }
        }
        return i6 + ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1021c;
    }

    public Drawable getDividerDrawable() {
        return this.f1030l;
    }

    public int getDividerPadding() {
        return this.f1034p;
    }

    public int getDividerWidth() {
        return this.f1031m;
    }

    public int getGravity() {
        return this.f1024f;
    }

    public int getOrientation() {
        return this.f1023e;
    }

    public int getShowDividers() {
        return this.f1033o;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1026h;
    }

    void h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i4 = 0; i4 < virtualChildCount; i4++) {
            View s4 = s(i4);
            if (s4 != null && s4.getVisibility() != 8 && t(i4)) {
                i(canvas, (s4.getTop() - ((ViewGroup.MarginLayoutParams) ((a) s4.getLayoutParams())).topMargin) - this.f1032n);
            }
        }
        if (t(virtualChildCount)) {
            View s5 = s(virtualChildCount - 1);
            i(canvas, s5 == null ? (getHeight() - getPaddingBottom()) - this.f1032n : s5.getBottom() + ((ViewGroup.MarginLayoutParams) ((a) s5.getLayoutParams())).bottomMargin);
        }
    }

    void i(Canvas canvas, int i4) {
        this.f1030l.setBounds(getPaddingLeft() + this.f1034p, i4, (getWidth() - getPaddingRight()) - this.f1034p, this.f1032n + i4);
        this.f1030l.draw(canvas);
    }

    void j(Canvas canvas, int i4) {
        this.f1030l.setBounds(i4, getPaddingTop() + this.f1034p, this.f1031m + i4, (getHeight() - getPaddingBottom()) - this.f1034p);
        this.f1030l.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i4 = this.f1023e;
        if (i4 == 0) {
            return new a(-2, -2);
        }
        if (i4 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f1030l == null) {
            return;
        }
        if (this.f1023e == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        if (this.f1023e == 1) {
            v(i4, i5, i6, i7);
        } else {
            u(i4, i5, i6, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        if (this.f1023e == 1) {
            z(i4, i5);
        } else {
            x(i4, i5);
        }
    }

    int p(View view, int i4) {
        return 0;
    }

    int q(View view) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    View s(int i4) {
        return getChildAt(i4);
    }

    public void setBaselineAligned(boolean z4) {
        this.f1020b = z4;
    }

    public void setBaselineAlignedChildIndex(int i4) {
        if (i4 >= 0 && i4 < getChildCount()) {
            this.f1021c = i4;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1030l) {
            return;
        }
        this.f1030l = drawable;
        if (drawable != null) {
            this.f1031m = drawable.getIntrinsicWidth();
            this.f1032n = drawable.getIntrinsicHeight();
        } else {
            this.f1031m = 0;
            this.f1032n = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i4) {
        this.f1034p = i4;
    }

    public void setGravity(int i4) {
        if (this.f1024f != i4) {
            if ((8388615 & i4) == 0) {
                i4 |= 8388611;
            }
            if ((i4 & 112) == 0) {
                i4 |= 48;
            }
            this.f1024f = i4;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i4) {
        int i5 = i4 & 8388615;
        int i6 = this.f1024f;
        if ((8388615 & i6) != i5) {
            this.f1024f = i5 | ((-8388616) & i6);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z4) {
        this.f1027i = z4;
    }

    public void setOrientation(int i4) {
        if (this.f1023e != i4) {
            this.f1023e = i4;
            requestLayout();
        }
    }

    public void setShowDividers(int i4) {
        if (i4 != this.f1033o) {
            requestLayout();
        }
        this.f1033o = i4;
    }

    public void setVerticalGravity(int i4) {
        int i5 = i4 & 112;
        int i6 = this.f1024f;
        if ((i6 & 112) != i5) {
            this.f1024f = i5 | (i6 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f4) {
        this.f1026h = Math.max(0.0f, f4);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(int i4) {
        if (i4 == 0) {
            return (this.f1033o & 1) != 0;
        }
        if (i4 == getChildCount()) {
            return (this.f1033o & 4) != 0;
        }
        if ((this.f1033o & 2) == 0) {
            return false;
        }
        for (int i5 = i4 - 1; i5 >= 0; i5--) {
            if (getChildAt(i5).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void u(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.u(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void v(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f1024f
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f1025g
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f1025g
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = r1
        L49:
            if (r12 >= r10) goto Lc8
            android.view.View r13 = r6.s(r12)
            r14 = 1
            if (r13 != 0) goto L59
            int r1 = r6.y(r12)
            int r0 = r0 + r1
            goto Lc5
        L59:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto Lc5
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.i0$a r5 = (androidx.appcompat.widget.i0.a) r5
            int r1 = r5.f1036b
            if (r1 >= 0) goto L75
            r1 = r11
        L75:
            int r2 = y.p.t(r17)
            int r1 = y.c.b(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L8b
            r2 = 5
            if (r1 == r2) goto L88
            int r1 = r5.leftMargin
            int r1 = r1 + r7
            goto L96
        L88:
            int r1 = r8 - r4
            goto L93
        L8b:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
        L93:
            int r2 = r5.rightMargin
            int r1 = r1 - r2
        L96:
            r2 = r1
            boolean r1 = r6.t(r12)
            if (r1 == 0) goto La0
            int r1 = r6.f1032n
            int r0 = r0 + r1
        La0:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.q(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.A(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.r(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.p(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            r1 = 1
            goto Lc6
        Lc5:
            r1 = r14
        Lc6:
            int r12 = r12 + r1
            goto L49
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.v(int, int, int, int):void");
    }

    void w(View view, int i4, int i5, int i6, int i7, int i8) {
        measureChildWithMargins(view, i5, i6, i7, i8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:174:0x03a5, code lost:
    
        if (r8 > 0) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03b2, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03b3, code lost:
    
        r14.measure(android.view.View.MeasureSpec.makeMeasureSpec(r8, r3), r0);
        r9 = android.view.View.combineMeasuredStates(r9, r14.getMeasuredState() & (-16777216));
        r0 = r0;
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03b0, code lost:
    
        if (r8 < 0) goto L169;
     */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void x(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.x(int, int):void");
    }

    int y(int i4) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x02cf, code lost:
    
        if (r15 > 0) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02dc, code lost:
    
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02dd, code lost:
    
        r13.measure(r0, android.view.View.MeasureSpec.makeMeasureSpec(r15, r10));
        r1 = android.view.View.combineMeasuredStates(r1, r13.getMeasuredState() & (-256));
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02da, code lost:
    
        if (r15 < 0) goto L136;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x031b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void z(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.z(int, int):void");
    }
}
