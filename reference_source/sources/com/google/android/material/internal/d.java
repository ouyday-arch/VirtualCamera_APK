package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.i0;

/* loaded from: classes.dex */
public class d extends i0 {

    /* renamed from: q, reason: collision with root package name */
    private Drawable f3149q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f3150r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f3151s;

    /* renamed from: t, reason: collision with root package name */
    private int f3152t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f3153u;

    /* renamed from: v, reason: collision with root package name */
    boolean f3154v;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3150r = new Rect();
        this.f3151s = new Rect();
        this.f3152t = a.j.I0;
        this.f3153u = true;
        this.f3154v = false;
        TypedArray h4 = i.h(context, attributeSet, m0.k.Z0, i4, 0, new int[0]);
        this.f3152t = h4.getInt(m0.k.f5058b1, this.f3152t);
        Drawable drawable = h4.getDrawable(m0.k.f5052a1);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f3153u = h4.getBoolean(m0.k.f5064c1, true);
        h4.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f3149q;
        if (drawable != null) {
            if (this.f3154v) {
                this.f3154v = false;
                Rect rect = this.f3150r;
                Rect rect2 = this.f3151s;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f3153u) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f3152t, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f4, float f5) {
        super.drawableHotspotChanged(f4, f5);
        Drawable drawable = this.f3149q;
        if (drawable != null) {
            drawable.setHotspot(f4, f5);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3149q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f3149q.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f3149q;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f3152t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3149q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        this.f3154v = z4 | this.f3154v;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f3154v = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f3149q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f3149q);
            }
            this.f3149q = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f3152t == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i4) {
        if (this.f3152t != i4) {
            if ((8388615 & i4) == 0) {
                i4 |= 8388611;
            }
            if ((i4 & 112) == 0) {
                i4 |= 48;
            }
            this.f3152t = i4;
            if (i4 == 119 && this.f3149q != null) {
                this.f3149q.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3149q;
    }
}
