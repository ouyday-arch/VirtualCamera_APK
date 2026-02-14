package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    private d f2721a;

    /* renamed from: b, reason: collision with root package name */
    private int f2722b;

    /* renamed from: c, reason: collision with root package name */
    private int f2723c;

    public c() {
        this.f2722b = 0;
        this.f2723c = 0;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2722b = 0;
        this.f2723c = 0;
    }

    public int E() {
        d dVar = this.f2721a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(CoordinatorLayout coordinatorLayout, V v4, int i4) {
        coordinatorLayout.J(v4, i4);
    }

    public boolean G(int i4) {
        d dVar = this.f2721a;
        if (dVar != null) {
            return dVar.e(i4);
        }
        this.f2722b = i4;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v4, int i4) {
        F(coordinatorLayout, v4, i4);
        if (this.f2721a == null) {
            this.f2721a = new d(v4);
        }
        this.f2721a.c();
        this.f2721a.a();
        int i5 = this.f2722b;
        if (i5 != 0) {
            this.f2721a.e(i5);
            this.f2722b = 0;
        }
        int i6 = this.f2723c;
        if (i6 == 0) {
            return true;
        }
        this.f2721a.d(i6);
        this.f2723c = 0;
        return true;
    }
}
