package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
import y.p;

/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a, reason: collision with root package name */
    private int f3340a;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3341b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3342c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ v0.a f3343d;

        a(View view, int i4, v0.a aVar) {
            this.f3341b = view;
            this.f3342c = i4;
            this.f3343d = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f3341b.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f3340a == this.f3342c) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                v0.a aVar = this.f3343d;
                expandableBehavior.H((View) aVar, this.f3341b, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f3340a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3340a = 0;
    }

    private boolean F(boolean z4) {
        if (!z4) {
            return this.f3340a == 1;
        }
        int i4 = this.f3340a;
        return i4 == 0 || i4 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected v0.a G(CoordinatorLayout coordinatorLayout, View view) {
        List<View> s4 = coordinatorLayout.s(view);
        int size = s4.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = s4.get(i4);
            if (e(coordinatorLayout, view, view2)) {
                return (v0.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean H(View view, View view2, boolean z4, boolean z5);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        v0.a aVar = (v0.a) view2;
        if (!F(aVar.a())) {
            return false;
        }
        this.f3340a = aVar.a() ? 1 : 2;
        return H((View) aVar, view, aVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
        v0.a G;
        if (p.H(view) || (G = G(coordinatorLayout, view)) == null || !F(G.a())) {
            return false;
        }
        int i5 = G.a() ? 1 : 2;
        this.f3340a = i5;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i5, G));
        return false;
    }
}
