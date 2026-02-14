package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final View f970a;

    /* renamed from: d, reason: collision with root package name */
    private u0 f973d;

    /* renamed from: e, reason: collision with root package name */
    private u0 f974e;

    /* renamed from: f, reason: collision with root package name */
    private u0 f975f;

    /* renamed from: c, reason: collision with root package name */
    private int f972c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final j f971b = j.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(View view) {
        this.f970a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f975f == null) {
            this.f975f = new u0();
        }
        u0 u0Var = this.f975f;
        u0Var.a();
        ColorStateList l4 = y.p.l(this.f970a);
        if (l4 != null) {
            u0Var.f1181d = true;
            u0Var.f1178a = l4;
        }
        PorterDuff.Mode m4 = y.p.m(this.f970a);
        if (m4 != null) {
            u0Var.f1180c = true;
            u0Var.f1179b = m4;
        }
        if (!u0Var.f1181d && !u0Var.f1180c) {
            return false;
        }
        j.i(drawable, u0Var, this.f970a.getDrawableState());
        return true;
    }

    private boolean k() {
        return this.f973d != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f970a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            u0 u0Var = this.f974e;
            if (u0Var != null) {
                j.i(background, u0Var, this.f970a.getDrawableState());
                return;
            }
            u0 u0Var2 = this.f973d;
            if (u0Var2 != null) {
                j.i(background, u0Var2, this.f970a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        u0 u0Var = this.f974e;
        if (u0Var != null) {
            return u0Var.f1178a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        u0 u0Var = this.f974e;
        if (u0Var != null) {
            return u0Var.f1179b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i4) {
        w0 u4 = w0.u(this.f970a.getContext(), attributeSet, a.j.A3, i4, 0);
        try {
            int i5 = a.j.B3;
            if (u4.r(i5)) {
                this.f972c = u4.n(i5, -1);
                ColorStateList f4 = this.f971b.f(this.f970a.getContext(), this.f972c);
                if (f4 != null) {
                    h(f4);
                }
            }
            int i6 = a.j.C3;
            if (u4.r(i6)) {
                y.p.e0(this.f970a, u4.c(i6));
            }
            int i7 = a.j.D3;
            if (u4.r(i7)) {
                y.p.f0(this.f970a, e0.c(u4.k(i7, -1), null));
            }
        } finally {
            u4.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f972c = -1;
        h(null);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i4) {
        this.f972c = i4;
        j jVar = this.f971b;
        h(jVar != null ? jVar.f(this.f970a.getContext(), i4) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f973d == null) {
                this.f973d = new u0();
            }
            u0 u0Var = this.f973d;
            u0Var.f1178a = colorStateList;
            u0Var.f1181d = true;
        } else {
            this.f973d = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f974e == null) {
            this.f974e = new u0();
        }
        u0 u0Var = this.f974e;
        u0Var.f1178a = colorStateList;
        u0Var.f1181d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f974e == null) {
            this.f974e = new u0();
        }
        u0 u0Var = this.f974e;
        u0Var.f1179b = mode;
        u0Var.f1180c = true;
        b();
    }
}
