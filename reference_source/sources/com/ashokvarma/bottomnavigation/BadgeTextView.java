package com.ashokvarma.bottomnavigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.z;

@SuppressLint({"Instantiatable"})
/* loaded from: classes.dex */
class BadgeTextView extends z {

    /* renamed from: f, reason: collision with root package name */
    private boolean f2494f;

    /* renamed from: g, reason: collision with root package name */
    private int f2495g;

    /* renamed from: h, reason: collision with root package name */
    private int f2496h;

    public BadgeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BadgeTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f2495g = 100;
        this.f2496h = 100;
        f();
    }

    private void f() {
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.z, android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        if (!this.f2494f) {
            super.onMeasure(i4, i5);
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(this.f2495g, size);
        } else if (mode != 1073741824) {
            size = this.f2495g;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(this.f2496h, size2);
        } else if (mode2 != 1073741824) {
            size2 = this.f2496h;
        }
        setMeasuredDimension(size, size2);
    }
}
