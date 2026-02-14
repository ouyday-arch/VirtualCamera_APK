package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import y.p;
import y.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b extends c<View> {

    /* renamed from: d, reason: collision with root package name */
    final Rect f2717d;

    /* renamed from: e, reason: collision with root package name */
    final Rect f2718e;

    /* renamed from: f, reason: collision with root package name */
    private int f2719f;

    /* renamed from: g, reason: collision with root package name */
    private int f2720g;

    public b() {
        this.f2717d = new Rect();
        this.f2718e = new Rect();
        this.f2719f = 0;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2717d = new Rect();
        this.f2718e = new Rect();
        this.f2719f = 0;
    }

    private static int N(int i4) {
        if (i4 == 0) {
            return 8388659;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.c
    public void F(CoordinatorLayout coordinatorLayout, View view, int i4) {
        int i5;
        View H = H(coordinatorLayout.s(view));
        if (H != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f2717d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, H.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + H.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            x lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && p.q(coordinatorLayout) && !p.q(view)) {
                rect.left += lastWindowInsets.b();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.f2718e;
            y.c.a(N(fVar.f1305c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i4);
            int I = I(H);
            view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
            i5 = rect2.top - H.getBottom();
        } else {
            super.F(coordinatorLayout, view, i4);
            i5 = 0;
        }
        this.f2719f = i5;
    }

    abstract View H(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int I(View view) {
        if (this.f2720g == 0) {
            return 0;
        }
        float J = J(view);
        int i4 = this.f2720g;
        return t.a.b((int) (J * i4), 0, i4);
    }

    float J(View view) {
        return 1.0f;
    }

    public final int K() {
        return this.f2720g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int L(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int M() {
        return this.f2719f;
    }

    public final void O(int i4) {
        this.f2720g = i4;
    }

    protected boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int i7) {
        View H;
        x lastWindowInsets;
        int i8 = view.getLayoutParams().height;
        if ((i8 != -1 && i8 != -2) || (H = H(coordinatorLayout.s(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i6);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (p.q(H) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.d() + lastWindowInsets.a();
        }
        int L = size + L(H);
        int measuredHeight = H.getMeasuredHeight();
        if (P()) {
            view.setTranslationY(-measuredHeight);
        } else {
            L -= measuredHeight;
        }
        coordinatorLayout.K(view, i4, i5, View.MeasureSpec.makeMeasureSpec(L, i8 == -1 ? 1073741824 : RecyclerView.UNDEFINED_DURATION), i7);
        return true;
    }
}
