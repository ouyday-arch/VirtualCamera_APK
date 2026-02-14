package com.google.android.material.chip;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.g;
import androidx.recyclerview.widget.RecyclerView;
import b1.n;
import com.google.android.material.chip.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import m0.i;
import m0.j;
import m0.k;
import n0.h;
import y.p;
import y0.d;
import y0.f;
import z.c;

/* loaded from: classes.dex */
public class Chip extends g implements a.InterfaceC0027a, n {

    /* renamed from: u, reason: collision with root package name */
    private static final int f2871u = j.f5045k;

    /* renamed from: v, reason: collision with root package name */
    private static final Rect f2872v = new Rect();

    /* renamed from: w, reason: collision with root package name */
    private static final int[] f2873w = {R.attr.state_selected};

    /* renamed from: x, reason: collision with root package name */
    private static final int[] f2874x = {R.attr.state_checkable};

    /* renamed from: e, reason: collision with root package name */
    private com.google.android.material.chip.a f2875e;

    /* renamed from: f, reason: collision with root package name */
    private InsetDrawable f2876f;

    /* renamed from: g, reason: collision with root package name */
    private RippleDrawable f2877g;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f2878h;

    /* renamed from: i, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f2879i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2880j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2881k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2882l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2883m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f2884n;

    /* renamed from: o, reason: collision with root package name */
    private int f2885o;

    /* renamed from: p, reason: collision with root package name */
    private int f2886p;

    /* renamed from: q, reason: collision with root package name */
    private final c f2887q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f2888r;

    /* renamed from: s, reason: collision with root package name */
    private final RectF f2889s;

    /* renamed from: t, reason: collision with root package name */
    private final f f2890t;

    /* loaded from: classes.dex */
    class a extends f {
        a() {
        }

        @Override // y0.f
        public void a(int i4) {
        }

        @Override // y0.f
        public void b(Typeface typeface, boolean z4) {
            Chip chip = Chip.this;
            chip.setText(chip.f2875e.C2() ? Chip.this.f2875e.a1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f2875e != null) {
                Chip.this.f2875e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends c0.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // c0.a
        protected int B(float f4, float f5) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f4, f5)) ? 1 : 0;
        }

        @Override // c0.a
        protected void C(List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f2878h != null) {
                list.add(1);
            }
        }

        @Override // c0.a
        protected boolean J(int i4, int i5, Bundle bundle) {
            if (i5 != 16) {
                return false;
            }
            if (i4 == 0) {
                return Chip.this.performClick();
            }
            if (i4 == 1) {
                return Chip.this.t();
            }
            return false;
        }

        @Override // c0.a
        protected void M(z.c cVar) {
            cVar.U(Chip.this.r());
            cVar.X(Chip.this.isClickable());
            cVar.W((Chip.this.r() || Chip.this.isClickable()) ? Chip.this.r() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
            cVar.q0(Chip.this.getText());
        }

        @Override // c0.a
        protected void N(int i4, z.c cVar) {
            if (i4 != 1) {
                cVar.a0("");
                cVar.S(Chip.f2872v);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription == null) {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i5 = i.f5029g;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                closeIconContentDescription = context.getString(i5, objArr).trim();
            }
            cVar.a0(closeIconContentDescription);
            cVar.S(Chip.this.getCloseIconTouchBoundsInt());
            cVar.b(c.a.f6620i);
            cVar.b0(Chip.this.isEnabled());
        }

        @Override // c0.a
        protected void O(int i4, boolean z4) {
            if (i4 == 1) {
                Chip.this.f2883m = z4;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m0.b.f4937e);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Chip(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.chip.Chip.f2871u
            android.content.Context r8 = e1.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r7.f2888r = r8
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            r7.f2889s = r8
            com.google.android.material.chip.Chip$a r8 = new com.google.android.material.chip.Chip$a
            r8.<init>()
            r7.f2890t = r8
            android.content.Context r0 = r7.getContext()
            r7.C(r9)
            com.google.android.material.chip.a r8 = com.google.android.material.chip.a.r0(r0, r9, r10, r4)
            r7.o(r0, r9, r10)
            r7.setChipDrawable(r8)
            float r1 = y.p.p(r7)
            r8.U(r1)
            int[] r2 = m0.k.L
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.i.h(r0, r1, r2, r3, r4, r5)
            int r10 = m0.k.f5155u0
            boolean r10 = r9.hasValue(r10)
            r9.recycle()
            com.google.android.material.chip.Chip$c r9 = new com.google.android.material.chip.Chip$c
            r9.<init>(r7)
            r7.f2887q = r9
            r7.x()
            if (r10 != 0) goto L59
            r7.p()
        L59:
            boolean r9 = r7.f2880j
            r7.setChecked(r9)
            java.lang.CharSequence r9 = r8.a1()
            r7.setText(r9)
            android.text.TextUtils$TruncateAt r8 = r8.U0()
            r7.setEllipsize(r8)
            r7.setIncludeFontPadding(r6)
            r7.B()
            com.google.android.material.chip.a r8 = r7.f2875e
            boolean r8 = r8.C2()
            if (r8 != 0) goto L81
            r8 = 1
            r7.setLines(r8)
            r7.setHorizontallyScrolling(r8)
        L81:
            r8 = 8388627(0x800013, float:1.175497E-38)
            r7.setGravity(r8)
            r7.A()
            boolean r8 = r7.v()
            if (r8 == 0) goto L95
            int r8 = r7.f2886p
            r7.setMinHeight(r8)
        L95:
            int r8 = y.p.t(r7)
            r7.f2885o = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void A() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f2875e) == null) {
            return;
        }
        int E0 = (int) (aVar.E0() + this.f2875e.c1() + this.f2875e.m0());
        int J0 = (int) (this.f2875e.J0() + this.f2875e.d1() + this.f2875e.i0());
        if (this.f2876f != null) {
            Rect rect = new Rect();
            this.f2876f.getPadding(rect);
            J0 += rect.left;
            E0 += rect.right;
        }
        p.m0(this, J0, getPaddingTop(), E0, getPaddingBottom());
    }

    private void B() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.i(getContext(), paint, this.f2890t);
        }
    }

    private void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f2889s.setEmpty();
        if (n()) {
            this.f2875e.T0(this.f2889s);
        }
        return this.f2889s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f2888r.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f2888r;
    }

    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    private void i(com.google.android.material.chip.a aVar) {
        aVar.g2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    private int[] j() {
        ?? isEnabled = isEnabled();
        int i4 = isEnabled;
        if (this.f2883m) {
            i4 = isEnabled + 1;
        }
        int i5 = i4;
        if (this.f2882l) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (this.f2881k) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (isChecked()) {
            i7 = i6 + 1;
        }
        int[] iArr = new int[i7];
        int i8 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i8 = 1;
        }
        if (this.f2883m) {
            iArr[i8] = 16842908;
            i8++;
        }
        if (this.f2882l) {
            iArr[i8] = 16843623;
            i8++;
        }
        if (this.f2881k) {
            iArr[i8] = 16842919;
            i8++;
        }
        if (isChecked()) {
            iArr[i8] = 16842913;
        }
        return iArr;
    }

    private void l() {
        if (getBackgroundDrawable() == this.f2876f && this.f2875e.getCallback() == null) {
            this.f2875e.setCallback(this.f2876f);
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean m(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = c0.a.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.f2887q)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = c0.a.class.getDeclaredMethod("V", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f2887q, Integer.valueOf(RecyclerView.UNDEFINED_DURATION));
                    return true;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        com.google.android.material.chip.a aVar = this.f2875e;
        return (aVar == null || aVar.M0() == null) ? false : true;
    }

    private void o(Context context, AttributeSet attributeSet, int i4) {
        TypedArray h4 = com.google.android.material.internal.i.h(context, attributeSet, k.L, i4, f2871u, new int[0]);
        this.f2884n = h4.getBoolean(k.f5130p0, false);
        this.f2886p = (int) Math.ceil(h4.getDimension(k.f5069d0, (float) Math.ceil(com.google.android.material.internal.j.a(getContext(), 48))));
        h4.recycle();
    }

    private void p() {
        setOutlineProvider(new b());
    }

    private void q(int i4, int i5, int i6, int i7) {
        this.f2876f = new InsetDrawable((Drawable) this.f2875e, i4, i5, i6, i7);
    }

    private void setCloseIconHovered(boolean z4) {
        if (this.f2882l != z4) {
            this.f2882l = z4;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z4) {
        if (this.f2881k != z4) {
            this.f2881k = z4;
            refreshDrawableState();
        }
    }

    private void u() {
        if (this.f2876f != null) {
            this.f2876f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            y();
        }
    }

    private void w(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.g2(null);
        }
    }

    private void x() {
        p.a0(this, (n() && s() && this.f2878h != null) ? this.f2887q : null);
    }

    private void y() {
        if (z0.b.f6650a) {
            z();
            return;
        }
        this.f2875e.B2(true);
        p.d0(this, getBackgroundDrawable());
        A();
        l();
    }

    private void z() {
        this.f2877g = new RippleDrawable(z0.b.a(this.f2875e.Y0()), getBackgroundDrawable(), null);
        this.f2875e.B2(false);
        p.d0(this, this.f2877g);
        A();
    }

    @Override // com.google.android.material.chip.a.InterfaceC0027a
    public void a() {
        k(this.f2886p);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return m(motionEvent) || this.f2887q.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f2887q.w(keyEvent) || this.f2887q.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.g, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f2875e;
        if ((aVar == null || !aVar.i1()) ? false : this.f2875e.c2(j())) {
            invalidate();
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f2876f;
        return insetDrawable == null ? this.f2875e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.B0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.C0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.D0();
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f2875e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.E0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.F0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.G0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.H0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.I0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.J0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.K0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.L0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.M0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.N0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.O0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.P0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.Q0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.S0();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.U0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f2887q.A() == 1 || this.f2887q.x() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.V0();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.W0();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.X0();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.Y0();
        }
        return null;
    }

    public b1.k getShapeAppearanceModel() {
        return this.f2875e.C();
    }

    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.Z0();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.c1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            return aVar.d1();
        }
        return 0.0f;
    }

    public boolean k(int i4) {
        this.f2886p = i4;
        if (!v()) {
            if (this.f2876f != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int max = Math.max(0, i4 - this.f2875e.getIntrinsicHeight());
        int max2 = Math.max(0, i4 - this.f2875e.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f2876f != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int i5 = max2 > 0 ? max2 / 2 : 0;
        int i6 = max > 0 ? max / 2 : 0;
        if (this.f2876f != null) {
            Rect rect = new Rect();
            this.f2876f.getPadding(rect);
            if (rect.top == i6 && rect.bottom == i6 && rect.left == i5 && rect.right == i5) {
                y();
                return true;
            }
        }
        if (getMinHeight() != i4) {
            setMinHeight(i4);
        }
        if (getMinWidth() != i4) {
            setMinWidth(i4);
        }
        q(i5, i6, i5, i6);
        y();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b1.h.f(this, this.f2875e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, f2873w);
        }
        if (r()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, f2874x);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z4, int i4, Rect rect) {
        super.onFocusChanged(z4, i4, rect);
        this.f2887q.I(z4, i4, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean contains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                contains = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(contains);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((r() || isClickable()) ? r() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            z.c.t0(accessibilityNodeInfo).Z(c.C0097c.a(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.n(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i4) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        if (this.f2885o != i4) {
            this.f2885o = i4;
            A();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.f2881k
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.f2881k
            if (r0 == 0) goto L34
            r5.t()
            r0 = r3
            goto L35
        L34:
            r0 = r2
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = r3
            goto L41
        L40:
            r0 = r2
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = r3
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean r() {
        com.google.android.material.chip.a aVar = this.f2875e;
        return aVar != null && aVar.h1();
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.f2875e;
        return aVar != null && aVar.j1();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2877g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2877g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundResource(int i4) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.q1(z4);
        }
    }

    public void setCheckableResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.r1(i4);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar == null) {
            this.f2880j = z4;
            return;
        }
        if (aVar.h1()) {
            boolean isChecked = isChecked();
            super.setChecked(z4);
            if (isChecked == z4 || (onCheckedChangeListener = this.f2879i) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z4);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.s1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z4) {
        setCheckedIconVisible(z4);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i4) {
        setCheckedIconVisible(i4);
    }

    public void setCheckedIconResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.t1(i4);
        }
    }

    public void setCheckedIconVisible(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.u1(i4);
        }
    }

    public void setCheckedIconVisible(boolean z4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.v1(z4);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.w1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.x1(i4);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.y1(f4);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.z1(i4);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f2875e;
        if (aVar2 != aVar) {
            w(aVar2);
            this.f2875e = aVar;
            aVar.r2(false);
            i(this.f2875e);
            k(this.f2886p);
        }
    }

    public void setChipEndPadding(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.A1(f4);
        }
    }

    public void setChipEndPaddingResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.B1(i4);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.C1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z4) {
        setChipIconVisible(z4);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i4) {
        setChipIconVisible(i4);
    }

    public void setChipIconResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.D1(i4);
        }
    }

    public void setChipIconSize(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.E1(f4);
        }
    }

    public void setChipIconSizeResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.F1(i4);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.G1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.H1(i4);
        }
    }

    public void setChipIconVisible(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.I1(i4);
        }
    }

    public void setChipIconVisible(boolean z4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.J1(z4);
        }
    }

    public void setChipMinHeight(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.K1(f4);
        }
    }

    public void setChipMinHeightResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.L1(i4);
        }
    }

    public void setChipStartPadding(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.M1(f4);
        }
    }

    public void setChipStartPaddingResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.N1(i4);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.O1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.P1(i4);
        }
    }

    public void setChipStrokeWidth(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.Q1(f4);
        }
    }

    public void setChipStrokeWidthResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.R1(i4);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i4) {
        setText(getResources().getString(i4));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.T1(drawable);
        }
        x();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.U1(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z4) {
        setCloseIconVisible(z4);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i4) {
        setCloseIconVisible(i4);
    }

    public void setCloseIconEndPadding(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.V1(f4);
        }
    }

    public void setCloseIconEndPaddingResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.W1(i4);
        }
    }

    public void setCloseIconResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.X1(i4);
        }
        x();
    }

    public void setCloseIconSize(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.Y1(f4);
        }
    }

    public void setCloseIconSizeResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.Z1(i4);
        }
    }

    public void setCloseIconStartPadding(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.a2(f4);
        }
    }

    public void setCloseIconStartPaddingResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.b2(i4);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.d2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.e2(i4);
        }
    }

    public void setCloseIconVisible(int i4) {
        setCloseIconVisible(getResources().getBoolean(i4));
    }

    public void setCloseIconVisible(boolean z4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.f2(z4);
        }
        x();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i6 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i4, i5, i6, i7);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i6 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i4, i5, i6, i7);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.U(f4);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f2875e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.h2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z4) {
        this.f2884n = z4;
        k(this.f2886p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i4) {
        if (i4 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i4);
        }
    }

    public void setHideMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.i2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.j2(i4);
        }
    }

    public void setIconEndPadding(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.k2(f4);
        }
    }

    public void setIconEndPaddingResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.l2(i4);
        }
    }

    public void setIconStartPadding(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.m2(f4);
        }
    }

    public void setIconStartPaddingResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.n2(i4);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i4) {
        if (this.f2875e == null) {
            return;
        }
        super.setLayoutDirection(i4);
    }

    @Override // android.widget.TextView
    public void setLines(int i4) {
        if (i4 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i4);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i4) {
        if (i4 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i4);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i4) {
        super.setMaxWidth(i4);
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.o2(i4);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i4) {
        if (i4 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2879i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f2878h = onClickListener;
        x();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.p2(colorStateList);
        }
        if (this.f2875e.f1()) {
            return;
        }
        z();
    }

    public void setRippleColorResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.q2(i4);
            if (this.f2875e.f1()) {
                return;
            }
            z();
        }
    }

    @Override // b1.n
    public void setShapeAppearanceModel(b1.k kVar) {
        this.f2875e.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.s2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.t2(i4);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z4) {
        if (!z4) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z4);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.C2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f2875e;
        if (aVar2 != null) {
            aVar2.u2(charSequence);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i4) {
        super.setTextAppearance(i4);
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.w2(i4);
        }
        B();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.w2(i4);
        }
        B();
    }

    public void setTextAppearance(d dVar) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.v2(dVar);
        }
        B();
    }

    public void setTextAppearanceResource(int i4) {
        setTextAppearance(getContext(), i4);
    }

    public void setTextEndPadding(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.x2(f4);
        }
    }

    public void setTextEndPaddingResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.y2(i4);
        }
    }

    public void setTextStartPadding(float f4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.z2(f4);
        }
    }

    public void setTextStartPaddingResource(int i4) {
        com.google.android.material.chip.a aVar = this.f2875e;
        if (aVar != null) {
            aVar.A2(i4);
        }
    }

    public boolean t() {
        boolean z4 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f2878h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z4 = true;
        }
        this.f2887q.U(1, 1);
        return z4;
    }

    public boolean v() {
        return this.f2884n;
    }
}
