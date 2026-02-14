package com.google.android.material.snackbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.internal.j;
import m0.k;
import y.p;

/* loaded from: classes.dex */
public class d extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private static final View.OnTouchListener f3188i = new a();

    /* renamed from: b, reason: collision with root package name */
    private c f3189b;

    /* renamed from: c, reason: collision with root package name */
    private b f3190c;

    /* renamed from: d, reason: collision with root package name */
    private int f3191d;

    /* renamed from: e, reason: collision with root package name */
    private final float f3192e;

    /* renamed from: f, reason: collision with root package name */
    private final float f3193f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f3194g;

    /* renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f3195h;

    /* loaded from: classes.dex */
    static class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, AttributeSet attributeSet) {
        super(e1.a.c(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, k.P2);
        if (obtainStyledAttributes.hasValue(k.W2)) {
            p.h0(this, obtainStyledAttributes.getDimensionPixelSize(r1, 0));
        }
        this.f3191d = obtainStyledAttributes.getInt(k.S2, 0);
        this.f3192e = obtainStyledAttributes.getFloat(k.T2, 1.0f);
        setBackgroundTintList(y0.c.a(context2, obtainStyledAttributes, k.U2));
        setBackgroundTintMode(j.d(obtainStyledAttributes.getInt(k.V2, -1), PorterDuff.Mode.SRC_IN));
        this.f3193f = obtainStyledAttributes.getFloat(k.R2, 1.0f);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f3188i);
        setFocusable(true);
        if (getBackground() == null) {
            p.d0(this, a());
        }
    }

    private Drawable a() {
        float dimension = getResources().getDimension(m0.d.f4978o);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(s0.a.g(this, m0.b.f4943k, m0.b.f4940h, getBackgroundOverlayColorAlpha()));
        if (this.f3194g == null) {
            return r.a.m(gradientDrawable);
        }
        Drawable m4 = r.a.m(gradientDrawable);
        r.a.j(m4, this.f3194g);
        return m4;
    }

    float getActionTextColorAlpha() {
        return this.f3193f;
    }

    int getAnimationMode() {
        return this.f3191d;
    }

    float getBackgroundOverlayColorAlpha() {
        return this.f3192e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f3190c;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        p.Y(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f3190c;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        c cVar = this.f3189b;
        if (cVar != null) {
            cVar.a(this, i4, i5, i6, i7);
        }
    }

    void setAnimationMode(int i4) {
        this.f3191d = i4;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f3194g != null) {
            drawable = r.a.m(drawable.mutate());
            r.a.j(drawable, this.f3194g);
            r.a.k(drawable, this.f3195h);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f3194g = colorStateList;
        if (getBackground() != null) {
            Drawable m4 = r.a.m(getBackground().mutate());
            r.a.j(m4, colorStateList);
            r.a.k(m4, this.f3195h);
            if (m4 != getBackground()) {
                super.setBackgroundDrawable(m4);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f3195h = mode;
        if (getBackground() != null) {
            Drawable m4 = r.a.m(getBackground().mutate());
            r.a.k(m4, mode);
            if (m4 != getBackground()) {
                super.setBackgroundDrawable(m4);
            }
        }
    }

    void setOnAttachStateChangeListener(b bVar) {
        this.f3190c = bVar;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f3188i);
        super.setOnClickListener(onClickListener);
    }

    void setOnLayoutChangeListener(c cVar) {
        this.f3189b = cVar;
    }
}
