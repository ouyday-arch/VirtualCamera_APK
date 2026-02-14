package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.z;
import e1.a;
import m0.k;
import y0.b;
import y0.c;

/* loaded from: classes.dex */
public class MaterialTextView extends z {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(a.c(context, attributeSet, i4, i5), attributeSet, i4);
        int h4;
        Context context2 = getContext();
        if (g(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (j(context2, theme, attributeSet, i4, i5) || (h4 = h(theme, attributeSet, i4, i5)) == -1) {
                return;
            }
            f(theme, h4);
        }
    }

    private void f(Resources.Theme theme, int i4) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i4, k.f5097i2);
        int i5 = i(getContext(), obtainStyledAttributes, k.f5102j2, k.f5107k2);
        obtainStyledAttributes.recycle();
        if (i5 >= 0) {
            setLineHeight(i5);
        }
    }

    private static boolean g(Context context) {
        return b.b(context, m0.b.f4957y, true);
    }

    private static int h(Resources.Theme theme, AttributeSet attributeSet, int i4, int i5) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.f5112l2, i4, i5);
        int resourceId = obtainStyledAttributes.getResourceId(k.f5117m2, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int i(Context context, TypedArray typedArray, int... iArr) {
        int i4 = -1;
        for (int i5 = 0; i5 < iArr.length && i4 < 0; i5++) {
            i4 = c.c(context, typedArray, iArr[i5], -1);
        }
        return i4;
    }

    private static boolean j(Context context, Resources.Theme theme, AttributeSet attributeSet, int i4, int i5) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.f5112l2, i4, i5);
        int i6 = i(context, obtainStyledAttributes, k.f5122n2, k.f5127o2);
        obtainStyledAttributes.recycle();
        return i6 != -1;
    }

    @Override // androidx.appcompat.widget.z, android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        if (g(context)) {
            f(context.getTheme(), i4);
        }
    }
}
