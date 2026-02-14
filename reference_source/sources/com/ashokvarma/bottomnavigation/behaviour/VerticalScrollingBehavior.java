package com.ashokvarma.bottomnavigation.behaviour;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public abstract class VerticalScrollingBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    private int f2531a;

    /* renamed from: b, reason: collision with root package name */
    private int f2532b;

    /* renamed from: c, reason: collision with root package name */
    private int f2533c;

    /* renamed from: d, reason: collision with root package name */
    private int f2534d;

    /* renamed from: e, reason: collision with root package name */
    private int f2535e;

    /* renamed from: f, reason: collision with root package name */
    private int f2536f;

    public VerticalScrollingBehavior() {
        this.f2531a = -1;
        this.f2532b = -1;
        this.f2533c = -1;
        this.f2534d = 0;
        this.f2535e = 0;
        this.f2536f = 0;
    }

    public VerticalScrollingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2531a = -1;
        this.f2532b = -1;
        this.f2533c = -1;
        this.f2534d = 0;
        this.f2535e = 0;
        this.f2536f = 0;
    }

    protected abstract boolean E(CoordinatorLayout coordinatorLayout, V v4, View view, float f4, float f5, boolean z4, int i4);

    public abstract void F(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int[] iArr, int i6);

    public abstract void G(CoordinatorLayout coordinatorLayout, V v4, int i4, int i5, int i6);

    public abstract void H(CoordinatorLayout coordinatorLayout, V v4, int i4, int i5, int i6);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, V v4, View view, float f4, float f5, boolean z4) {
        super.n(coordinatorLayout, v4, view, f4, f5, z4);
        return E(coordinatorLayout, v4, view, f4, f5, z4, f5 > 0.0f ? 1 : -1);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int[] iArr) {
        super.p(coordinatorLayout, v4, view, i4, i5, iArr);
        if (i5 > 0 && this.f2533c < 0) {
            this.f2533c = 0;
            this.f2535e = 1;
            F(coordinatorLayout, v4, view, i4, i5, iArr, 1);
        } else if (i5 < 0 && this.f2533c > 0) {
            this.f2533c = 0;
            this.f2535e = -1;
            F(coordinatorLayout, v4, view, i4, i5, iArr, -1);
        }
        this.f2533c += i5;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        super.r(coordinatorLayout, v4, view, i4, i5, i6, i7);
        if (i7 <= 0 || this.f2531a >= 0) {
            if (i7 < 0 && this.f2531a > 0) {
                i8 = 0;
                this.f2531a = 0;
                i9 = -1;
            }
            this.f2531a += i7;
            if (i5 > 0 || this.f2532b >= 0) {
                if (i5 < 0 && this.f2532b > 0) {
                    i10 = 0;
                    this.f2532b = 0;
                    i11 = -1;
                }
                this.f2532b += i5;
            }
            i10 = 0;
            this.f2532b = 0;
            i11 = 1;
            this.f2536f = i11;
            G(coordinatorLayout, v4, i11, i5, i10);
            this.f2532b += i5;
        }
        i8 = 0;
        this.f2531a = 0;
        i9 = 1;
        this.f2534d = i9;
        H(coordinatorLayout, v4, i9, i5, i8);
        this.f2531a += i7;
        if (i5 > 0) {
        }
        if (i5 < 0) {
            i10 = 0;
            this.f2532b = 0;
            i11 = -1;
            this.f2536f = i11;
            G(coordinatorLayout, v4, i11, i5, i10);
        }
        this.f2532b += i5;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean z(CoordinatorLayout coordinatorLayout, V v4, View view, View view2, int i4) {
        return (i4 & 2) != 0;
    }
}
