package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
class q extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f1135b = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f1136a;

    public q(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        a(context, attributeSet, i4, i5);
    }

    private void a(Context context, AttributeSet attributeSet, int i4, int i5) {
        w0 u4 = w0.u(context, attributeSet, a.j.f141b2, i4, i5);
        int i6 = a.j.f151d2;
        if (u4.r(i6)) {
            b(u4.a(i6, false));
        }
        setBackgroundDrawable(u4.g(a.j.f146c2));
        u4.v();
    }

    private void b(boolean z4) {
        if (f1135b) {
            this.f1136a = z4;
        } else {
            androidx.core.widget.h.a(this, z4);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i4, int i5) {
        if (f1135b && this.f1136a) {
            i5 -= view.getHeight();
        }
        super.showAsDropDown(view, i4, i5);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i4, int i5, int i6) {
        if (f1135b && this.f1136a) {
            i5 -= view.getHeight();
        }
        super.showAsDropDown(view, i4, i5, i6);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i4, int i5, int i6, int i7) {
        if (f1135b && this.f1136a) {
            i5 -= view.getHeight();
        }
        super.update(view, i4, i5, i6, i7);
    }
}
