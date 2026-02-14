package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import p.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f1240a;

    /* renamed from: b, reason: collision with root package name */
    private u0 f1241b;

    /* renamed from: c, reason: collision with root package name */
    private u0 f1242c;

    /* renamed from: d, reason: collision with root package name */
    private u0 f1243d;

    /* renamed from: e, reason: collision with root package name */
    private u0 f1244e;

    /* renamed from: f, reason: collision with root package name */
    private u0 f1245f;

    /* renamed from: g, reason: collision with root package name */
    private u0 f1246g;

    /* renamed from: h, reason: collision with root package name */
    private u0 f1247h;

    /* renamed from: i, reason: collision with root package name */
    private final a0 f1248i;

    /* renamed from: j, reason: collision with root package name */
    private int f1249j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f1250k = -1;

    /* renamed from: l, reason: collision with root package name */
    private Typeface f1251l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1252m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends b.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<y> f1253a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1254b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1255c;

        /* renamed from: androidx.appcompat.widget.y$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class RunnableC0009a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            private final WeakReference<y> f1256b;

            /* renamed from: c, reason: collision with root package name */
            private final Typeface f1257c;

            RunnableC0009a(WeakReference<y> weakReference, Typeface typeface) {
                this.f1256b = weakReference;
                this.f1257c = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                y yVar = this.f1256b.get();
                if (yVar == null) {
                    return;
                }
                yVar.B(this.f1257c);
            }
        }

        a(y yVar, int i4, int i5) {
            this.f1253a = new WeakReference<>(yVar);
            this.f1254b = i4;
            this.f1255c = i5;
        }

        @Override // p.b.a
        public void c(int i4) {
        }

        @Override // p.b.a
        public void d(Typeface typeface) {
            int i4;
            y yVar = this.f1253a.get();
            if (yVar == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (i4 = this.f1254b) != -1) {
                typeface = Typeface.create(typeface, i4, (this.f1255c & 2) != 0);
            }
            yVar.q(new RunnableC0009a(this.f1253a, typeface));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TextView textView) {
        this.f1240a = textView;
        this.f1248i = new a0(textView);
    }

    private void A(int i4, float f4) {
        this.f1248i.u(i4, f4);
    }

    private void C(Context context, w0 w0Var) {
        String o4;
        Typeface create;
        Typeface typeface;
        this.f1249j = w0Var.k(a.j.M2, this.f1249j);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            int k4 = w0Var.k(a.j.O2, -1);
            this.f1250k = k4;
            if (k4 != -1) {
                this.f1249j = (this.f1249j & 2) | 0;
            }
        }
        int i5 = a.j.N2;
        if (!w0Var.r(i5) && !w0Var.r(a.j.P2)) {
            int i6 = a.j.L2;
            if (w0Var.r(i6)) {
                this.f1252m = false;
                int k5 = w0Var.k(i6, 1);
                if (k5 == 1) {
                    typeface = Typeface.SANS_SERIF;
                } else if (k5 == 2) {
                    typeface = Typeface.SERIF;
                } else if (k5 != 3) {
                    return;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
                this.f1251l = typeface;
                return;
            }
            return;
        }
        this.f1251l = null;
        int i7 = a.j.P2;
        if (w0Var.r(i7)) {
            i5 = i7;
        }
        int i8 = this.f1250k;
        int i9 = this.f1249j;
        if (!context.isRestricted()) {
            try {
                Typeface j4 = w0Var.j(i5, this.f1249j, new a(this, i8, i9));
                if (j4 != null) {
                    if (i4 >= 28 && this.f1250k != -1) {
                        j4 = Typeface.create(Typeface.create(j4, 0), this.f1250k, (this.f1249j & 2) != 0);
                    }
                    this.f1251l = j4;
                }
                this.f1252m = this.f1251l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1251l != null || (o4 = w0Var.o(i5)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1250k == -1) {
            create = Typeface.create(o4, this.f1249j);
        } else {
            create = Typeface.create(Typeface.create(o4, 0), this.f1250k, (this.f1249j & 2) != 0);
        }
        this.f1251l = create;
    }

    private void a(Drawable drawable, u0 u0Var) {
        if (drawable == null || u0Var == null) {
            return;
        }
        j.i(drawable, u0Var, this.f1240a.getDrawableState());
    }

    private static u0 d(Context context, j jVar, int i4) {
        ColorStateList f4 = jVar.f(context, i4);
        if (f4 == null) {
            return null;
        }
        u0 u0Var = new u0();
        u0Var.f1181d = true;
        u0Var.f1178a = f4;
        return u0Var;
    }

    private void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f1240a.getCompoundDrawablesRelative();
            TextView textView = this.f1240a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f1240a.getCompoundDrawablesRelative();
        if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
            TextView textView2 = this.f1240a;
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            Drawable drawable8 = compoundDrawablesRelative2[2];
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f1240a.getCompoundDrawables();
        TextView textView3 = this.f1240a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void y() {
        u0 u0Var = this.f1247h;
        this.f1241b = u0Var;
        this.f1242c = u0Var;
        this.f1243d = u0Var;
        this.f1244e = u0Var;
        this.f1245f = u0Var;
        this.f1246g = u0Var;
    }

    public void B(Typeface typeface) {
        if (this.f1252m) {
            this.f1240a.setTypeface(typeface);
            this.f1251l = typeface;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f1241b != null || this.f1242c != null || this.f1243d != null || this.f1244e != null) {
            Drawable[] compoundDrawables = this.f1240a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1241b);
            a(compoundDrawables[1], this.f1242c);
            a(compoundDrawables[2], this.f1243d);
            a(compoundDrawables[3], this.f1244e);
        }
        if (this.f1245f == null && this.f1246g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f1240a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f1245f);
        a(compoundDrawablesRelative[2], this.f1246g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1248i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1248i.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f1248i.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1248i.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.f1248i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f1248i.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        u0 u0Var = this.f1247h;
        if (u0Var != null) {
            return u0Var.f1178a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        u0 u0Var = this.f1247h;
        if (u0Var != null) {
            return u0Var.f1179b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f1248i.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.util.AttributeSet r20, int r21) {
        /*
            Method dump skipped, instructions count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.m(android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(boolean z4, int i4, int i5, int i6, int i7) {
        if (androidx.core.widget.b.f1401a) {
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Context context, int i4) {
        String o4;
        w0 s4 = w0.s(context, i4, a.j.J2);
        int i5 = a.j.R2;
        if (s4.r(i5)) {
            r(s4.a(i5, false));
        }
        int i6 = Build.VERSION.SDK_INT;
        int i7 = a.j.K2;
        if (s4.r(i7) && s4.f(i7, -1) == 0) {
            this.f1240a.setTextSize(0, 0.0f);
        }
        C(context, s4);
        if (i6 >= 26) {
            int i8 = a.j.Q2;
            if (s4.r(i8) && (o4 = s4.o(i8)) != null) {
                this.f1240a.setFontVariationSettings(o4);
            }
        }
        s4.v();
        Typeface typeface = this.f1251l;
        if (typeface != null) {
            this.f1240a.setTypeface(typeface, this.f1249j);
        }
    }

    public void q(Runnable runnable) {
        this.f1240a.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z4) {
        this.f1240a.setAllCaps(z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i4, int i5, int i6, int i7) {
        this.f1248i.q(i4, i5, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int[] iArr, int i4) {
        this.f1248i.r(iArr, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i4) {
        this.f1248i.s(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ColorStateList colorStateList) {
        if (this.f1247h == null) {
            this.f1247h = new u0();
        }
        u0 u0Var = this.f1247h;
        u0Var.f1178a = colorStateList;
        u0Var.f1181d = colorStateList != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(PorterDuff.Mode mode) {
        if (this.f1247h == null) {
            this.f1247h = new u0();
        }
        u0 u0Var = this.f1247h;
        u0Var.f1179b = mode;
        u0Var.f1180c = mode != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int i4, float f4) {
        if (androidx.core.widget.b.f1401a || l()) {
            return;
        }
        A(i4, f4);
    }
}
