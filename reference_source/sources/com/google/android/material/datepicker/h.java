package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;

/* loaded from: classes.dex */
public final class h<S> extends androidx.fragment.app.c {

    /* renamed from: k0, reason: collision with root package name */
    static final Object f2993k0 = "CONFIRM_BUTTON_TAG";

    /* renamed from: l0, reason: collision with root package name */
    static final Object f2994l0 = "CANCEL_BUTTON_TAG";

    /* renamed from: m0, reason: collision with root package name */
    static final Object f2995m0 = "TOGGLE_BUTTON_TAG";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s1(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(y0.b.c(context, m0.b.f4949q, g.class.getCanonicalName()), new int[]{R.attr.windowFullscreen});
        boolean z4 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z4;
    }
}
