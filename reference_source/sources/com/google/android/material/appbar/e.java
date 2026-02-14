package com.google.android.material.appbar;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.view.View;
import m0.g;

/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2731a = {R.attr.stateListAnimator};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, float f4) {
        int integer = view.getResources().getInteger(g.f5012a);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j4 = integer;
        stateListAnimator.addState(new int[]{R.attr.enabled, m0.b.f4955w, -m0.b.f4956x}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j4));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(view, "elevation", f4).setDuration(j4));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
