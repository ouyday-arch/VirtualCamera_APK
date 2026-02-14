package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    final b f2948a;

    /* renamed from: b, reason: collision with root package name */
    final b f2949b;

    /* renamed from: c, reason: collision with root package name */
    final b f2950c;

    /* renamed from: d, reason: collision with root package name */
    final b f2951d;

    /* renamed from: e, reason: collision with root package name */
    final b f2952e;

    /* renamed from: f, reason: collision with root package name */
    final b f2953f;

    /* renamed from: g, reason: collision with root package name */
    final b f2954g;

    /* renamed from: h, reason: collision with root package name */
    final Paint f2955h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(y0.b.c(context, m0.b.f4949q, g.class.getCanonicalName()), m0.k.F1);
        this.f2948a = b.a(context, obtainStyledAttributes.getResourceId(m0.k.I1, 0));
        this.f2954g = b.a(context, obtainStyledAttributes.getResourceId(m0.k.G1, 0));
        this.f2949b = b.a(context, obtainStyledAttributes.getResourceId(m0.k.H1, 0));
        this.f2950c = b.a(context, obtainStyledAttributes.getResourceId(m0.k.J1, 0));
        ColorStateList a5 = y0.c.a(context, obtainStyledAttributes, m0.k.K1);
        this.f2951d = b.a(context, obtainStyledAttributes.getResourceId(m0.k.M1, 0));
        this.f2952e = b.a(context, obtainStyledAttributes.getResourceId(m0.k.L1, 0));
        this.f2953f = b.a(context, obtainStyledAttributes.getResourceId(m0.k.N1, 0));
        Paint paint = new Paint();
        this.f2955h = paint;
        paint.setColor(a5.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
