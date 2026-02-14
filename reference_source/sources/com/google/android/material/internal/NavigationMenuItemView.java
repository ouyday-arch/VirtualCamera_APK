package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.y0;
import y.p;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements k.a {
    private static final int[] G = {R.attr.state_checked};
    private FrameLayout A;
    private androidx.appcompat.view.menu.g B;
    private ColorStateList C;
    private boolean D;
    private Drawable E;
    private final y.a F;

    /* renamed from: w, reason: collision with root package name */
    private int f3110w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f3111x;

    /* renamed from: y, reason: collision with root package name */
    boolean f3112y;

    /* renamed from: z, reason: collision with root package name */
    private final CheckedTextView f3113z;

    /* loaded from: classes.dex */
    class a extends y.a {
        a() {
        }

        @Override // y.a
        public void g(View view, z.c cVar) {
            super.g(view, cVar);
            cVar.U(NavigationMenuItemView.this.f3112y);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a aVar = new a();
        this.F = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(m0.h.f5014a, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(m0.d.f4968e));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(m0.f.f4991d);
        this.f3113z = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        p.a0(checkedTextView, aVar);
    }

    private void B() {
        i0.a aVar;
        int i4;
        if (D()) {
            this.f3113z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout == null) {
                return;
            }
            aVar = (i0.a) frameLayout.getLayoutParams();
            i4 = -1;
        } else {
            this.f3113z.setVisibility(0);
            FrameLayout frameLayout2 = this.A;
            if (frameLayout2 == null) {
                return;
            }
            aVar = (i0.a) frameLayout2.getLayoutParams();
            i4 = -2;
        }
        ((ViewGroup.MarginLayoutParams) aVar).width = i4;
        this.A.setLayoutParams(aVar);
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(a.a.f21v, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean D() {
        return this.B.getTitle() == null && this.B.getIcon() == null && this.B.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(m0.f.f4990c)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(androidx.appcompat.view.menu.g gVar, int i4) {
        this.B = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            p.d0(this, C());
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.getTitle());
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.getContentDescription());
        y0.a(this, gVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public androidx.appcompat.view.menu.g getItemData() {
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        androidx.appcompat.view.menu.g gVar = this.B;
        if (gVar != null && gVar.isCheckable() && this.B.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z4) {
        refreshDrawableState();
        if (this.f3112y != z4) {
            this.f3112y = z4;
            this.F.l(this.f3113z, 2048);
        }
    }

    public void setChecked(boolean z4) {
        refreshDrawableState();
        this.f3113z.setChecked(z4);
    }

    public void setHorizontalPadding(int i4) {
        setPadding(i4, 0, i4, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = r.a.m(drawable).mutate();
                r.a.j(drawable, this.C);
            }
            int i4 = this.f3110w;
            drawable.setBounds(0, 0, i4, i4);
        } else if (this.f3111x) {
            if (this.E == null) {
                Drawable a5 = p.b.a(getResources(), m0.e.f4987e, getContext().getTheme());
                this.E = a5;
                if (a5 != null) {
                    int i5 = this.f3110w;
                    a5.setBounds(0, 0, i5, i5);
                }
            }
            drawable = this.E;
        }
        androidx.core.widget.i.i(this.f3113z, drawable, null, null, null);
    }

    public void setIconPadding(int i4) {
        this.f3113z.setCompoundDrawablePadding(i4);
    }

    public void setIconSize(int i4) {
        this.f3110w = i4;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = colorStateList != null;
        androidx.appcompat.view.menu.g gVar = this.B;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setMaxLines(int i4) {
        this.f3113z.setMaxLines(i4);
    }

    public void setNeedsEmptyIcon(boolean z4) {
        this.f3111x = z4;
    }

    public void setTextAppearance(int i4) {
        androidx.core.widget.i.n(this.f3113z, i4);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f3113z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f3113z.setText(charSequence);
    }
}
