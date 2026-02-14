package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class k extends ImageButton {

    /* renamed from: b, reason: collision with root package name */
    private int f3181b;

    public final void b(int i4, boolean z4) {
        super.setVisibility(i4);
        if (z4) {
            this.f3181b = i4;
        }
    }

    public final int getUserSetVisibility() {
        return this.f3181b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i4) {
        b(i4, true);
    }
}
