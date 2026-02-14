package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import b1.g;
import b1.h;
import m0.j;
import y.p;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    private static final int Q = j.f5049o;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m0.b.B);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet, int i4) {
        super(e1.a.c(context, attributeSet, i4, Q), attributeSet, i4);
        O(getContext());
    }

    private void O(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.V(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            gVar.M(context);
            gVar.U(p.p(this));
            p.d0(this, gVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        h.d(this, f4);
    }
}
