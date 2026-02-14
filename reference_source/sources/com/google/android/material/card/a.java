package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import b1.k;
import b1.n;
import m0.b;
import m0.j;

/* loaded from: classes.dex */
public class a extends j.a implements Checkable, n {

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f2863n = {R.attr.state_checkable};

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f2864o = {R.attr.state_checked};

    /* renamed from: p, reason: collision with root package name */
    private static final int[] f2865p = {b.f4954v};

    /* renamed from: q, reason: collision with root package name */
    private static final int f2866q = j.f5043i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2867j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2868k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2869l;

    /* renamed from: m, reason: collision with root package name */
    private InterfaceC0026a f2870m;

    /* renamed from: com.google.android.material.card.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0026a {
        void a(a aVar, boolean z4);
    }

    private void d() {
        if (Build.VERSION.SDK_INT > 26) {
            throw null;
        }
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return this.f2869l;
    }

    @Override // j.a
    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    public ColorStateList getCardForegroundColor() {
        throw null;
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
        throw null;
    }

    @Override // j.a
    public int getContentPaddingBottom() {
        throw null;
    }

    @Override // j.a
    public int getContentPaddingLeft() {
        throw null;
    }

    @Override // j.a
    public int getContentPaddingRight() {
        throw null;
    }

    @Override // j.a
    public int getContentPaddingTop() {
        throw null;
    }

    public float getProgress() {
        throw null;
    }

    @Override // j.a
    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    public k getShapeAppearanceModel() {
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    public int getStrokeWidth() {
        throw null;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2868k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 3);
        if (e()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f2863n);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f2864o);
        }
        if (f()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f2865p);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // j.a, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f2867j) {
            throw null;
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // j.a
    public void setCardBackgroundColor(int i4) {
        ColorStateList.valueOf(i4);
        throw null;
    }

    @Override // j.a
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        throw null;
    }

    @Override // j.a
    public void setCardElevation(float f4) {
        super.setCardElevation(f4);
        throw null;
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setCheckable(boolean z4) {
        throw null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z4) {
        if (this.f2868k != z4) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        throw null;
    }

    public void setCheckedIconResource(int i4) {
        c.a.b(getContext(), i4);
        throw null;
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean z4) {
        super.setClickable(z4);
        throw null;
    }

    public void setDragged(boolean z4) {
        if (this.f2869l != z4) {
            this.f2869l = z4;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // j.a
    public void setMaxCardElevation(float f4) {
        super.setMaxCardElevation(f4);
        throw null;
    }

    public void setOnCheckedChangeListener(InterfaceC0026a interfaceC0026a) {
        this.f2870m = interfaceC0026a;
    }

    @Override // j.a
    public void setPreventCornerOverlap(boolean z4) {
        super.setPreventCornerOverlap(z4);
        throw null;
    }

    public void setProgress(float f4) {
        throw null;
    }

    @Override // j.a
    public void setRadius(float f4) {
        super.setRadius(f4);
        throw null;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setRippleColorResource(int i4) {
        c.a.a(getContext(), i4);
        throw null;
    }

    @Override // b1.n
    public void setShapeAppearanceModel(k kVar) {
        throw null;
    }

    public void setStrokeColor(int i4) {
        ColorStateList.valueOf(i4);
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setStrokeWidth(int i4) {
        throw null;
    }

    @Override // j.a
    public void setUseCompatPadding(boolean z4) {
        super.setUseCompatPadding(z4);
        throw null;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (e() && isEnabled()) {
            this.f2868k = !this.f2868k;
            refreshDrawableState();
            d();
            InterfaceC0026a interfaceC0026a = this.f2870m;
            if (interfaceC0026a != null) {
                interfaceC0026a.a(this, this.f2868k);
            }
        }
    }
}
