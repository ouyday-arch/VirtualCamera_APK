package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.w0;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f3179a = {m0.b.f4941i};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f3180b = {m0.b.f4942j};

    public static void a(Context context) {
        e(context, f3179a, "Theme.AppCompat");
    }

    private static void b(Context context, AttributeSet attributeSet, int i4, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.k.E4, i4, i5);
        boolean z4 = obtainStyledAttributes.getBoolean(m0.k.G4, false);
        obtainStyledAttributes.recycle();
        if (z4) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(m0.b.f4947o, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(Context context) {
        e(context, f3180b, "Theme.MaterialComponents");
    }

    private static void d(Context context, AttributeSet attributeSet, int[] iArr, int i4, int i5, int... iArr2) {
        boolean z4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.k.E4, i4, i5);
        if (!obtainStyledAttributes.getBoolean(m0.k.H4, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            z4 = obtainStyledAttributes.getResourceId(m0.k.F4, -1) != -1;
        } else {
            z4 = f(context, attributeSet, iArr, i4, i5, iArr2);
        }
        obtainStyledAttributes.recycle();
        if (!z4) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(Context context, int[] iArr, String str) {
        if (g(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    private static boolean f(Context context, AttributeSet attributeSet, int[] iArr, int i4, int i5, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i4, i5);
        for (int i6 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i6, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    private static boolean g(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (!obtainStyledAttributes.hasValue(i4)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static TypedArray h(Context context, AttributeSet attributeSet, int[] iArr, int i4, int i5, int... iArr2) {
        b(context, attributeSet, i4, i5);
        d(context, attributeSet, iArr, i4, i5, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i4, i5);
    }

    public static w0 i(Context context, AttributeSet attributeSet, int[] iArr, int i4, int i5, int... iArr2) {
        b(context, attributeSet, i4, i5);
        d(context, attributeSet, iArr, i4, i5, iArr2);
        return w0.u(context, attributeSet, iArr, i4, i5);
    }
}
