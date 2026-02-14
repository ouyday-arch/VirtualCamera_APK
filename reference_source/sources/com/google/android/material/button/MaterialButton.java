package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.f;
import androidx.core.widget.i;
import b1.h;
import b1.k;
import b1.n;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m0.j;
import y.p;

/* loaded from: classes.dex */
public class MaterialButton extends f implements Checkable, n {

    /* renamed from: p, reason: collision with root package name */
    private static final int[] f2829p = {R.attr.state_checkable};

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f2830q = {R.attr.state_checked};

    /* renamed from: r, reason: collision with root package name */
    private static final int f2831r = j.f5042h;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.material.button.a f2832d;

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashSet<a> f2833e;

    /* renamed from: f, reason: collision with root package name */
    private b f2834f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f2835g;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f2836h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f2837i;

    /* renamed from: j, reason: collision with root package name */
    private int f2838j;

    /* renamed from: k, reason: collision with root package name */
    private int f2839k;

    /* renamed from: l, reason: collision with root package name */
    private int f2840l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2841m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f2842n;

    /* renamed from: o, reason: collision with root package name */
    private int f2843o;

    /* loaded from: classes.dex */
    public interface a {
        void a(MaterialButton materialButton, boolean z4);
    }

    /* loaded from: classes.dex */
    interface b {
        void a(MaterialButton materialButton, boolean z4);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m0.b.f4948p);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButton(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = com.google.android.material.button.MaterialButton.f2831r
            android.content.Context r9 = e1.a.c(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f2833e = r9
            r9 = 0
            r8.f2841m = r9
            r8.f2842n = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = m0.k.f5111l1
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.i.h(r0, r1, r2, r3, r4, r5)
            int r1 = m0.k.f5171x1
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f2840l = r1
            int r1 = m0.k.A1
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.j.d(r1, r2)
            r8.f2835g = r1
            android.content.Context r1 = r8.getContext()
            int r2 = m0.k.f5181z1
            android.content.res.ColorStateList r1 = y0.c.a(r1, r0, r2)
            r8.f2836h = r1
            android.content.Context r1 = r8.getContext()
            int r2 = m0.k.f5161v1
            android.graphics.drawable.Drawable r1 = y0.c.d(r1, r0, r2)
            r8.f2837i = r1
            int r1 = m0.k.f5166w1
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.f2843o = r1
            int r1 = m0.k.f5176y1
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f2838j = r1
            b1.k$b r10 = b1.k.e(r7, r10, r11, r6)
            b1.k r10 = r10.m()
            com.google.android.material.button.a r11 = new com.google.android.material.button.a
            r11.<init>(r8, r10)
            r8.f2832d = r11
            r11.o(r0)
            r0.recycle()
            int r10 = r8.f2840l
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f2837i
            if (r10 == 0) goto L84
            r9 = r2
        L84:
            r8.e(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private boolean b() {
        return p.t(this) == 1;
    }

    private boolean c() {
        com.google.android.material.button.a aVar = this.f2832d;
        return (aVar == null || aVar.m()) ? false : true;
    }

    private void d(boolean z4) {
        if (z4) {
            i.i(this, this.f2837i, null, null, null);
        } else {
            i.i(this, null, null, this.f2837i, null);
        }
    }

    private void e(boolean z4) {
        Drawable drawable = this.f2837i;
        boolean z5 = false;
        if (drawable != null) {
            Drawable mutate = r.a.m(drawable).mutate();
            this.f2837i = mutate;
            r.a.j(mutate, this.f2836h);
            PorterDuff.Mode mode = this.f2835g;
            if (mode != null) {
                r.a.k(this.f2837i, mode);
            }
            int i4 = this.f2838j;
            if (i4 == 0) {
                i4 = this.f2837i.getIntrinsicWidth();
            }
            int i5 = this.f2838j;
            if (i5 == 0) {
                i5 = this.f2837i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f2837i;
            int i6 = this.f2839k;
            drawable2.setBounds(i6, 0, i4 + i6, i5);
        }
        int i7 = this.f2843o;
        boolean z6 = i7 == 1 || i7 == 2;
        if (z4) {
            d(z6);
            return;
        }
        Drawable[] a5 = i.a(this);
        Drawable drawable3 = a5[0];
        Drawable drawable4 = a5[2];
        if ((z6 && drawable3 != this.f2837i) || (!z6 && drawable4 != this.f2837i)) {
            z5 = true;
        }
        if (z5) {
            d(z6);
        }
    }

    private void f() {
        if (this.f2837i == null || getLayout() == null) {
            return;
        }
        int i4 = this.f2843o;
        if (i4 == 1 || i4 == 3) {
            this.f2839k = 0;
            e(false);
            return;
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        int min = Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
        int i5 = this.f2838j;
        if (i5 == 0) {
            i5 = this.f2837i.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - min) - p.x(this)) - i5) - this.f2840l) - p.y(this)) / 2;
        if (b() != (this.f2843o == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.f2839k != measuredWidth) {
            this.f2839k = measuredWidth;
            e(false);
        }
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    public boolean a() {
        com.google.android.material.button.a aVar = this.f2832d;
        return aVar != null && aVar.n();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (c()) {
            return this.f2832d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f2837i;
    }

    public int getIconGravity() {
        return this.f2843o;
    }

    public int getIconPadding() {
        return this.f2840l;
    }

    public int getIconSize() {
        return this.f2838j;
    }

    public ColorStateList getIconTint() {
        return this.f2836h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f2835g;
    }

    public ColorStateList getRippleColor() {
        if (c()) {
            return this.f2832d.f();
        }
        return null;
    }

    public k getShapeAppearanceModel() {
        if (c()) {
            return this.f2832d.g();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (c()) {
            return this.f2832d.h();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (c()) {
            return this.f2832d.i();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.f
    public ColorStateList getSupportBackgroundTintList() {
        return c() ? this.f2832d.j() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return c() ? this.f2832d.k() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2841m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.f2832d.d());
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 2);
        if (a()) {
            Button.mergeDrawableStates(onCreateDrawableState, f2829p);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, f2830q);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        f();
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        f();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        if (c()) {
            this.f2832d.p(i4);
        } else {
            super.setBackgroundColor(i4);
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (c()) {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            } else {
                Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
                this.f2832d.q();
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i4) {
        setBackgroundDrawable(i4 != 0 ? c.a.b(getContext(), i4) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z4) {
        if (c()) {
            this.f2832d.r(z4);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z4) {
        if (a() && isEnabled() && this.f2841m != z4) {
            this.f2841m = z4;
            refreshDrawableState();
            if (this.f2842n) {
                return;
            }
            this.f2842n = true;
            Iterator<a> it = this.f2833e.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f2841m);
            }
            this.f2842n = false;
        }
    }

    public void setCornerRadius(int i4) {
        if (c()) {
            this.f2832d.s(i4);
        }
    }

    public void setCornerRadiusResource(int i4) {
        if (c()) {
            setCornerRadius(getResources().getDimensionPixelSize(i4));
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        if (c()) {
            this.f2832d.d().U(f4);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f2837i != drawable) {
            this.f2837i = drawable;
            e(true);
        }
    }

    public void setIconGravity(int i4) {
        if (this.f2843o != i4) {
            this.f2843o = i4;
            f();
        }
    }

    public void setIconPadding(int i4) {
        if (this.f2840l != i4) {
            this.f2840l = i4;
            setCompoundDrawablePadding(i4);
        }
    }

    public void setIconResource(int i4) {
        setIcon(i4 != 0 ? c.a.b(getContext(), i4) : null);
    }

    public void setIconSize(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f2838j != i4) {
            this.f2838j = i4;
            e(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f2836h != colorStateList) {
            this.f2836h = colorStateList;
            e(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f2835g != mode) {
            this.f2835g = mode;
            e(false);
        }
    }

    public void setIconTintResource(int i4) {
        setIconTint(c.a.a(getContext(), i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(b bVar) {
        this.f2834f = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z4) {
        b bVar = this.f2834f;
        if (bVar != null) {
            bVar.a(this, z4);
        }
        super.setPressed(z4);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (c()) {
            this.f2832d.t(colorStateList);
        }
    }

    public void setRippleColorResource(int i4) {
        if (c()) {
            setRippleColor(c.a.a(getContext(), i4));
        }
    }

    @Override // b1.n
    public void setShapeAppearanceModel(k kVar) {
        if (!c()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f2832d.u(kVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z4) {
        if (c()) {
            this.f2832d.v(z4);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (c()) {
            this.f2832d.w(colorStateList);
        }
    }

    public void setStrokeColorResource(int i4) {
        if (c()) {
            setStrokeColor(c.a.a(getContext(), i4));
        }
    }

    public void setStrokeWidth(int i4) {
        if (c()) {
            this.f2832d.x(i4);
        }
    }

    public void setStrokeWidthResource(int i4) {
        if (c()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i4));
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (c()) {
            this.f2832d.y(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.f2832d.z(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f2841m);
    }
}
