package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import y.p;

/* loaded from: classes.dex */
public class c extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    private int f3145b;

    /* renamed from: c, reason: collision with root package name */
    private int f3146c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3147d;

    /* renamed from: e, reason: collision with root package name */
    private int f3148e;

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3147d = false;
        d(context, attributeSet);
    }

    private static int a(int i4, int i5, int i6) {
        return i5 != Integer.MIN_VALUE ? i5 != 1073741824 ? i6 : i4 : Math.min(i6, i4);
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, m0.k.U0, 0, 0);
        this.f3145b = obtainStyledAttributes.getDimensionPixelSize(m0.k.W0, 0);
        this.f3146c = obtainStyledAttributes.getDimensionPixelSize(m0.k.V0, 0);
        obtainStyledAttributes.recycle();
    }

    public int b(View view) {
        Object tag = view.getTag(m0.f.f5003p);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f3147d;
    }

    protected int getItemSpacing() {
        return this.f3146c;
    }

    protected int getLineSpacing() {
        return this.f3145b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRowCount() {
        return this.f3148e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        if (getChildCount() == 0) {
            this.f3148e = 0;
            return;
        }
        this.f3148e = 1;
        boolean z5 = p.t(this) == 1;
        int paddingRight = z5 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z5 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i10 = (i6 - i4) - paddingLeft;
        int i11 = paddingRight;
        int i12 = paddingTop;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(m0.f.f5003p, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i9 = y.f.b(marginLayoutParams);
                    i8 = y.f.a(marginLayoutParams);
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                int measuredWidth = i11 + i9 + childAt.getMeasuredWidth();
                if (!this.f3147d && measuredWidth > i10) {
                    i12 = this.f3145b + paddingTop;
                    this.f3148e++;
                    i11 = paddingRight;
                }
                childAt.setTag(m0.f.f5003p, Integer.valueOf(this.f3148e - 1));
                int i14 = i11 + i9;
                int measuredWidth2 = childAt.getMeasuredWidth() + i14;
                int measuredHeight = childAt.getMeasuredHeight() + i12;
                if (z5) {
                    i14 = i10 - measuredWidth2;
                    measuredWidth2 = (i10 - i11) - i9;
                }
                childAt.layout(i14, i12, measuredWidth2, measuredHeight);
                i11 += i9 + i8 + childAt.getMeasuredWidth() + this.f3146c;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int size = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        int i9 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i9 - getPaddingRight();
        int i10 = paddingTop;
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i4, i5);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i6 = marginLayoutParams.leftMargin + 0;
                    i7 = marginLayoutParams.rightMargin + 0;
                } else {
                    i6 = 0;
                    i7 = 0;
                }
                int i13 = paddingLeft;
                if (paddingLeft + i6 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    i8 = i13;
                } else {
                    i8 = getPaddingLeft();
                    i10 = this.f3145b + paddingTop;
                }
                int measuredWidth = i8 + i6 + childAt.getMeasuredWidth();
                int measuredHeight = i10 + childAt.getMeasuredHeight();
                if (measuredWidth > i11) {
                    i11 = measuredWidth;
                }
                paddingLeft = i8 + i6 + i7 + childAt.getMeasuredWidth() + this.f3146c;
                if (i12 == getChildCount() - 1) {
                    i11 += i7;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i11 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemSpacing(int i4) {
        this.f3146c = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLineSpacing(int i4) {
        this.f3145b = i4;
    }

    public void setSingleLine(boolean z4) {
        this.f3147d = z4;
    }
}
