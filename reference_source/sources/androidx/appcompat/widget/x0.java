package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public class x0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f1218a;

    /* renamed from: b, reason: collision with root package name */
    private int f1219b;

    /* renamed from: c, reason: collision with root package name */
    private View f1220c;

    /* renamed from: d, reason: collision with root package name */
    private View f1221d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f1222e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f1223f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f1224g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1225h;

    /* renamed from: i, reason: collision with root package name */
    CharSequence f1226i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f1227j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f1228k;

    /* renamed from: l, reason: collision with root package name */
    Window.Callback f1229l;

    /* renamed from: m, reason: collision with root package name */
    boolean f1230m;

    /* renamed from: n, reason: collision with root package name */
    private c f1231n;

    /* renamed from: o, reason: collision with root package name */
    private int f1232o;

    /* renamed from: p, reason: collision with root package name */
    private int f1233p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f1234q;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final g.a f1235b;

        a() {
            this.f1235b = new g.a(x0.this.f1218a.getContext(), 0, R.id.home, 0, 0, x0.this.f1226i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x0 x0Var = x0.this;
            Window.Callback callback = x0Var.f1229l;
            if (callback == null || !x0Var.f1230m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1235b);
        }
    }

    /* loaded from: classes.dex */
    class b extends y.v {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1237a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1238b;

        b(int i4) {
            this.f1238b = i4;
        }

        @Override // y.u
        public void a(View view) {
            if (this.f1237a) {
                return;
            }
            x0.this.f1218a.setVisibility(this.f1238b);
        }

        @Override // y.v, y.u
        public void b(View view) {
            x0.this.f1218a.setVisibility(0);
        }

        @Override // y.v, y.u
        public void c(View view) {
            this.f1237a = true;
        }
    }

    public x0(Toolbar toolbar, boolean z4) {
        this(toolbar, z4, a.h.f118a, a.e.f59n);
    }

    public x0(Toolbar toolbar, boolean z4, int i4, int i5) {
        Drawable drawable;
        this.f1232o = 0;
        this.f1233p = 0;
        this.f1218a = toolbar;
        this.f1226i = toolbar.getTitle();
        this.f1227j = toolbar.getSubtitle();
        this.f1225h = this.f1226i != null;
        this.f1224g = toolbar.getNavigationIcon();
        w0 u4 = w0.u(toolbar.getContext(), null, a.j.f133a, a.a.f2c, 0);
        this.f1234q = u4.g(a.j.f188l);
        if (z4) {
            CharSequence p4 = u4.p(a.j.f218r);
            if (!TextUtils.isEmpty(p4)) {
                E(p4);
            }
            CharSequence p5 = u4.p(a.j.f208p);
            if (!TextUtils.isEmpty(p5)) {
                D(p5);
            }
            Drawable g4 = u4.g(a.j.f198n);
            if (g4 != null) {
                z(g4);
            }
            Drawable g5 = u4.g(a.j.f193m);
            if (g5 != null) {
                setIcon(g5);
            }
            if (this.f1224g == null && (drawable = this.f1234q) != null) {
                C(drawable);
            }
            v(u4.k(a.j.f168h, 0));
            int n4 = u4.n(a.j.f163g, 0);
            if (n4 != 0) {
                x(LayoutInflater.from(this.f1218a.getContext()).inflate(n4, (ViewGroup) this.f1218a, false));
                v(this.f1219b | 16);
            }
            int m4 = u4.m(a.j.f178j, 0);
            if (m4 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1218a.getLayoutParams();
                layoutParams.height = m4;
                this.f1218a.setLayoutParams(layoutParams);
            }
            int e4 = u4.e(a.j.f158f, -1);
            int e5 = u4.e(a.j.f153e, -1);
            if (e4 >= 0 || e5 >= 0) {
                this.f1218a.H(Math.max(e4, 0), Math.max(e5, 0));
            }
            int n5 = u4.n(a.j.f223s, 0);
            if (n5 != 0) {
                Toolbar toolbar2 = this.f1218a;
                toolbar2.K(toolbar2.getContext(), n5);
            }
            int n6 = u4.n(a.j.f213q, 0);
            if (n6 != 0) {
                Toolbar toolbar3 = this.f1218a;
                toolbar3.J(toolbar3.getContext(), n6);
            }
            int n7 = u4.n(a.j.f203o, 0);
            if (n7 != 0) {
                this.f1218a.setPopupTheme(n7);
            }
        } else {
            this.f1219b = w();
        }
        u4.v();
        y(i4);
        this.f1228k = this.f1218a.getNavigationContentDescription();
        this.f1218a.setNavigationOnClickListener(new a());
    }

    private void F(CharSequence charSequence) {
        this.f1226i = charSequence;
        if ((this.f1219b & 8) != 0) {
            this.f1218a.setTitle(charSequence);
        }
    }

    private void G() {
        if ((this.f1219b & 4) != 0) {
            if (TextUtils.isEmpty(this.f1228k)) {
                this.f1218a.setNavigationContentDescription(this.f1233p);
            } else {
                this.f1218a.setNavigationContentDescription(this.f1228k);
            }
        }
    }

    private void H() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f1219b & 4) != 0) {
            toolbar = this.f1218a;
            drawable = this.f1224g;
            if (drawable == null) {
                drawable = this.f1234q;
            }
        } else {
            toolbar = this.f1218a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void I() {
        Drawable drawable;
        int i4 = this.f1219b;
        if ((i4 & 2) == 0) {
            drawable = null;
        } else if ((i4 & 1) == 0 || (drawable = this.f1223f) == null) {
            drawable = this.f1222e;
        }
        this.f1218a.setLogo(drawable);
    }

    private int w() {
        if (this.f1218a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1234q = this.f1218a.getNavigationIcon();
        return 15;
    }

    public void A(int i4) {
        B(i4 == 0 ? null : o().getString(i4));
    }

    public void B(CharSequence charSequence) {
        this.f1228k = charSequence;
        G();
    }

    public void C(Drawable drawable) {
        this.f1224g = drawable;
        H();
    }

    public void D(CharSequence charSequence) {
        this.f1227j = charSequence;
        if ((this.f1219b & 8) != 0) {
            this.f1218a.setSubtitle(charSequence);
        }
    }

    public void E(CharSequence charSequence) {
        this.f1225h = true;
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.d0
    public void a(Menu menu, j.a aVar) {
        if (this.f1231n == null) {
            c cVar = new c(this.f1218a.getContext());
            this.f1231n = cVar;
            cVar.p(a.f.f78g);
        }
        this.f1231n.g(aVar);
        this.f1218a.I((androidx.appcompat.view.menu.e) menu, this.f1231n);
    }

    @Override // androidx.appcompat.widget.d0
    public boolean b() {
        return this.f1218a.z();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean c() {
        return this.f1218a.A();
    }

    @Override // androidx.appcompat.widget.d0
    public void collapseActionView() {
        this.f1218a.e();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean d() {
        return this.f1218a.w();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean e() {
        return this.f1218a.N();
    }

    @Override // androidx.appcompat.widget.d0
    public void f() {
        this.f1230m = true;
    }

    @Override // androidx.appcompat.widget.d0
    public boolean g() {
        return this.f1218a.d();
    }

    @Override // androidx.appcompat.widget.d0
    public CharSequence getTitle() {
        return this.f1218a.getTitle();
    }

    @Override // androidx.appcompat.widget.d0
    public void h() {
        this.f1218a.f();
    }

    @Override // androidx.appcompat.widget.d0
    public int i() {
        return this.f1219b;
    }

    @Override // androidx.appcompat.widget.d0
    public void j(int i4) {
        this.f1218a.setVisibility(i4);
    }

    @Override // androidx.appcompat.widget.d0
    public void k(int i4) {
        z(i4 != 0 ? c.a.b(o(), i4) : null);
    }

    @Override // androidx.appcompat.widget.d0
    public void l(p0 p0Var) {
        View view = this.f1220c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1218a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1220c);
            }
        }
        this.f1220c = p0Var;
        if (p0Var == null || this.f1232o != 2) {
            return;
        }
        this.f1218a.addView(p0Var, 0);
        Toolbar.e eVar = (Toolbar.e) this.f1220c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.f413a = 8388691;
        p0Var.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.d0
    public ViewGroup m() {
        return this.f1218a;
    }

    @Override // androidx.appcompat.widget.d0
    public void n(boolean z4) {
    }

    @Override // androidx.appcompat.widget.d0
    public Context o() {
        return this.f1218a.getContext();
    }

    @Override // androidx.appcompat.widget.d0
    public int p() {
        return this.f1232o;
    }

    @Override // androidx.appcompat.widget.d0
    public y.t q(int i4, long j4) {
        return y.p.c(this.f1218a).a(i4 == 0 ? 1.0f : 0.0f).d(j4).f(new b(i4));
    }

    @Override // androidx.appcompat.widget.d0
    public void r() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.d0
    public boolean s() {
        return this.f1218a.v();
    }

    @Override // androidx.appcompat.widget.d0
    public void setIcon(int i4) {
        setIcon(i4 != 0 ? c.a.b(o(), i4) : null);
    }

    @Override // androidx.appcompat.widget.d0
    public void setIcon(Drawable drawable) {
        this.f1222e = drawable;
        I();
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowCallback(Window.Callback callback) {
        this.f1229l = callback;
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f1225h) {
            return;
        }
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.d0
    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.d0
    public void u(boolean z4) {
        this.f1218a.setCollapsible(z4);
    }

    @Override // androidx.appcompat.widget.d0
    public void v(int i4) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i5 = this.f1219b ^ i4;
        this.f1219b = i4;
        if (i5 != 0) {
            if ((i5 & 4) != 0) {
                if ((i4 & 4) != 0) {
                    G();
                }
                H();
            }
            if ((i5 & 3) != 0) {
                I();
            }
            if ((i5 & 8) != 0) {
                if ((i4 & 8) != 0) {
                    this.f1218a.setTitle(this.f1226i);
                    toolbar = this.f1218a;
                    charSequence = this.f1227j;
                } else {
                    charSequence = null;
                    this.f1218a.setTitle((CharSequence) null);
                    toolbar = this.f1218a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i5 & 16) == 0 || (view = this.f1221d) == null) {
                return;
            }
            if ((i4 & 16) != 0) {
                this.f1218a.addView(view);
            } else {
                this.f1218a.removeView(view);
            }
        }
    }

    public void x(View view) {
        View view2 = this.f1221d;
        if (view2 != null && (this.f1219b & 16) != 0) {
            this.f1218a.removeView(view2);
        }
        this.f1221d = view;
        if (view == null || (this.f1219b & 16) == 0) {
            return;
        }
        this.f1218a.addView(view);
    }

    public void y(int i4) {
        if (i4 == this.f1233p) {
            return;
        }
        this.f1233p = i4;
        if (TextUtils.isEmpty(this.f1218a.getNavigationContentDescription())) {
            A(this.f1233p);
        }
    }

    public void z(Drawable drawable) {
        this.f1223f = drawable;
        I();
    }
}
