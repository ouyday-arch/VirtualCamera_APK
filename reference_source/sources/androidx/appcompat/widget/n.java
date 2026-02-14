package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f1097a;

    /* renamed from: b, reason: collision with root package name */
    private u0 f1098b;

    /* renamed from: c, reason: collision with root package name */
    private u0 f1099c;

    /* renamed from: d, reason: collision with root package name */
    private u0 f1100d;

    public n(ImageView imageView) {
        this.f1097a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1100d == null) {
            this.f1100d = new u0();
        }
        u0 u0Var = this.f1100d;
        u0Var.a();
        ColorStateList a5 = androidx.core.widget.e.a(this.f1097a);
        if (a5 != null) {
            u0Var.f1181d = true;
            u0Var.f1178a = a5;
        }
        PorterDuff.Mode b5 = androidx.core.widget.e.b(this.f1097a);
        if (b5 != null) {
            u0Var.f1180c = true;
            u0Var.f1179b = b5;
        }
        if (!u0Var.f1181d && !u0Var.f1180c) {
            return false;
        }
        j.i(drawable, u0Var, this.f1097a.getDrawableState());
        return true;
    }

    private boolean j() {
        return this.f1098b != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f1097a.getDrawable();
        if (drawable != null) {
            e0.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            u0 u0Var = this.f1099c;
            if (u0Var != null) {
                j.i(drawable, u0Var, this.f1097a.getDrawableState());
                return;
            }
            u0 u0Var2 = this.f1098b;
            if (u0Var2 != null) {
                j.i(drawable, u0Var2, this.f1097a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        u0 u0Var = this.f1099c;
        if (u0Var != null) {
            return u0Var.f1178a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        u0 u0Var = this.f1099c;
        if (u0Var != null) {
            return u0Var.f1179b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return !(this.f1097a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i4) {
        int n4;
        w0 u4 = w0.u(this.f1097a.getContext(), attributeSet, a.j.R, i4, 0);
        try {
            Drawable drawable = this.f1097a.getDrawable();
            if (drawable == null && (n4 = u4.n(a.j.S, -1)) != -1 && (drawable = c.a.b(this.f1097a.getContext(), n4)) != null) {
                this.f1097a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                e0.b(drawable);
            }
            int i5 = a.j.T;
            if (u4.r(i5)) {
                androidx.core.widget.e.c(this.f1097a, u4.c(i5));
            }
            int i6 = a.j.U;
            if (u4.r(i6)) {
                androidx.core.widget.e.d(this.f1097a, e0.c(u4.k(i6, -1), null));
            }
        } finally {
            u4.v();
        }
    }

    public void g(int i4) {
        if (i4 != 0) {
            Drawable b5 = c.a.b(this.f1097a.getContext(), i4);
            if (b5 != null) {
                e0.b(b5);
            }
            this.f1097a.setImageDrawable(b5);
        } else {
            this.f1097a.setImageDrawable(null);
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (this.f1099c == null) {
            this.f1099c = new u0();
        }
        u0 u0Var = this.f1099c;
        u0Var.f1178a = colorStateList;
        u0Var.f1181d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(PorterDuff.Mode mode) {
        if (this.f1099c == null) {
            this.f1099c = new u0();
        }
        u0 u0Var = this.f1099c;
        u0Var.f1179b = mode;
        u0Var.f1180c = true;
        b();
    }
}
