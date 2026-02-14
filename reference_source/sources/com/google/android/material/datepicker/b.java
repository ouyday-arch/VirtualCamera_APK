package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f2942a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f2943b;

    /* renamed from: c, reason: collision with root package name */
    private final ColorStateList f2944c;

    /* renamed from: d, reason: collision with root package name */
    private final ColorStateList f2945d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2946e;

    /* renamed from: f, reason: collision with root package name */
    private final b1.k f2947f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i4, b1.k kVar, Rect rect) {
        x.h.b(rect.left);
        x.h.b(rect.top);
        x.h.b(rect.right);
        x.h.b(rect.bottom);
        this.f2942a = rect;
        this.f2943b = colorStateList2;
        this.f2944c = colorStateList;
        this.f2945d = colorStateList3;
        this.f2946e = i4;
        this.f2947f = kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(Context context, int i4) {
        x.h.a(i4 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i4, m0.k.O1);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(m0.k.P1, 0), obtainStyledAttributes.getDimensionPixelOffset(m0.k.R1, 0), obtainStyledAttributes.getDimensionPixelOffset(m0.k.Q1, 0), obtainStyledAttributes.getDimensionPixelOffset(m0.k.S1, 0));
        ColorStateList a5 = y0.c.a(context, obtainStyledAttributes, m0.k.T1);
        ColorStateList a6 = y0.c.a(context, obtainStyledAttributes, m0.k.Y1);
        ColorStateList a7 = y0.c.a(context, obtainStyledAttributes, m0.k.W1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(m0.k.X1, 0);
        b1.k m4 = b1.k.b(context, obtainStyledAttributes.getResourceId(m0.k.U1, 0), obtainStyledAttributes.getResourceId(m0.k.V1, 0)).m();
        obtainStyledAttributes.recycle();
        return new b(a5, a6, a7, dimensionPixelSize, m4, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f2942a.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f2942a.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView) {
        b1.g gVar = new b1.g();
        b1.g gVar2 = new b1.g();
        gVar.setShapeAppearanceModel(this.f2947f);
        gVar2.setShapeAppearanceModel(this.f2947f);
        gVar.V(this.f2944c);
        gVar.a0(this.f2946e, this.f2945d);
        textView.setTextColor(this.f2943b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f2943b.withAlpha(30), gVar, gVar2);
        Rect rect = this.f2942a;
        y.p.d0(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
