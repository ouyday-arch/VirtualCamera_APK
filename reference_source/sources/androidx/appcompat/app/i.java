package androidx.appcompat.app;

import a.j;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.p0;
import f.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import y.p;
import y.t;
import y.u;
import y.v;
import y.w;

/* loaded from: classes.dex */
public class i extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator F = new AccelerateInterpolator();
    private static final Interpolator G = new DecelerateInterpolator();
    private boolean A;
    boolean B;

    /* renamed from: a, reason: collision with root package name */
    Context f510a;

    /* renamed from: b, reason: collision with root package name */
    private Context f511b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f512c;

    /* renamed from: d, reason: collision with root package name */
    private Dialog f513d;

    /* renamed from: e, reason: collision with root package name */
    ActionBarOverlayLayout f514e;

    /* renamed from: f, reason: collision with root package name */
    ActionBarContainer f515f;

    /* renamed from: g, reason: collision with root package name */
    d0 f516g;

    /* renamed from: h, reason: collision with root package name */
    ActionBarContextView f517h;

    /* renamed from: i, reason: collision with root package name */
    View f518i;

    /* renamed from: j, reason: collision with root package name */
    p0 f519j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f522m;

    /* renamed from: n, reason: collision with root package name */
    d f523n;

    /* renamed from: o, reason: collision with root package name */
    f.b f524o;

    /* renamed from: p, reason: collision with root package name */
    b.a f525p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f526q;

    /* renamed from: s, reason: collision with root package name */
    private boolean f528s;

    /* renamed from: v, reason: collision with root package name */
    boolean f531v;

    /* renamed from: w, reason: collision with root package name */
    boolean f532w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f533x;

    /* renamed from: z, reason: collision with root package name */
    f.h f535z;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<Object> f520k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    private int f521l = -1;

    /* renamed from: r, reason: collision with root package name */
    private ArrayList<a.b> f527r = new ArrayList<>();

    /* renamed from: t, reason: collision with root package name */
    private int f529t = 0;

    /* renamed from: u, reason: collision with root package name */
    boolean f530u = true;

    /* renamed from: y, reason: collision with root package name */
    private boolean f534y = true;
    final u C = new a();
    final u D = new b();
    final w E = new c();

    /* loaded from: classes.dex */
    class a extends v {
        a() {
        }

        @Override // y.u
        public void a(View view) {
            View view2;
            i iVar = i.this;
            if (iVar.f530u && (view2 = iVar.f518i) != null) {
                view2.setTranslationY(0.0f);
                i.this.f515f.setTranslationY(0.0f);
            }
            i.this.f515f.setVisibility(8);
            i.this.f515f.setTransitioning(false);
            i iVar2 = i.this;
            iVar2.f535z = null;
            iVar2.y();
            ActionBarOverlayLayout actionBarOverlayLayout = i.this.f514e;
            if (actionBarOverlayLayout != null) {
                p.Y(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends v {
        b() {
        }

        @Override // y.u
        public void a(View view) {
            i iVar = i.this;
            iVar.f535z = null;
            iVar.f515f.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class c implements w {
        c() {
        }

        @Override // y.w
        public void a(View view) {
            ((View) i.this.f515f.getParent()).invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class d extends f.b implements e.a {

        /* renamed from: d, reason: collision with root package name */
        private final Context f539d;

        /* renamed from: e, reason: collision with root package name */
        private final androidx.appcompat.view.menu.e f540e;

        /* renamed from: f, reason: collision with root package name */
        private b.a f541f;

        /* renamed from: g, reason: collision with root package name */
        private WeakReference<View> f542g;

        public d(Context context, b.a aVar) {
            this.f539d = context;
            this.f541f = aVar;
            androidx.appcompat.view.menu.e S = new androidx.appcompat.view.menu.e(context).S(1);
            this.f540e = S;
            S.R(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            b.a aVar = this.f541f;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (this.f541f == null) {
                return;
            }
            k();
            i.this.f517h.l();
        }

        @Override // f.b
        public void c() {
            i iVar = i.this;
            if (iVar.f523n != this) {
                return;
            }
            if (i.x(iVar.f531v, iVar.f532w, false)) {
                this.f541f.c(this);
            } else {
                i iVar2 = i.this;
                iVar2.f524o = this;
                iVar2.f525p = this.f541f;
            }
            this.f541f = null;
            i.this.w(false);
            i.this.f517h.g();
            i.this.f516g.m().sendAccessibilityEvent(32);
            i iVar3 = i.this;
            iVar3.f514e.setHideOnContentScrollEnabled(iVar3.B);
            i.this.f523n = null;
        }

        @Override // f.b
        public View d() {
            WeakReference<View> weakReference = this.f542g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // f.b
        public Menu e() {
            return this.f540e;
        }

        @Override // f.b
        public MenuInflater f() {
            return new f.g(this.f539d);
        }

        @Override // f.b
        public CharSequence g() {
            return i.this.f517h.getSubtitle();
        }

        @Override // f.b
        public CharSequence i() {
            return i.this.f517h.getTitle();
        }

        @Override // f.b
        public void k() {
            if (i.this.f523n != this) {
                return;
            }
            this.f540e.d0();
            try {
                this.f541f.d(this, this.f540e);
            } finally {
                this.f540e.c0();
            }
        }

        @Override // f.b
        public boolean l() {
            return i.this.f517h.j();
        }

        @Override // f.b
        public void m(View view) {
            i.this.f517h.setCustomView(view);
            this.f542g = new WeakReference<>(view);
        }

        @Override // f.b
        public void n(int i4) {
            o(i.this.f510a.getResources().getString(i4));
        }

        @Override // f.b
        public void o(CharSequence charSequence) {
            i.this.f517h.setSubtitle(charSequence);
        }

        @Override // f.b
        public void q(int i4) {
            r(i.this.f510a.getResources().getString(i4));
        }

        @Override // f.b
        public void r(CharSequence charSequence) {
            i.this.f517h.setTitle(charSequence);
        }

        @Override // f.b
        public void s(boolean z4) {
            super.s(z4);
            i.this.f517h.setTitleOptional(z4);
        }

        public boolean t() {
            this.f540e.d0();
            try {
                return this.f541f.b(this, this.f540e);
            } finally {
                this.f540e.c0();
            }
        }
    }

    public i(Activity activity, boolean z4) {
        this.f512c = activity;
        View decorView = activity.getWindow().getDecorView();
        E(decorView);
        if (z4) {
            return;
        }
        this.f518i = decorView.findViewById(R.id.content);
    }

    public i(Dialog dialog) {
        this.f513d = dialog;
        E(dialog.getWindow().getDecorView());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d0 B(View view) {
        if (view instanceof d0) {
            return (d0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void D() {
        if (this.f533x) {
            this.f533x = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f514e;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            N(false);
        }
    }

    private void E(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(a.f.f87p);
        this.f514e = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f516g = B(view.findViewById(a.f.f72a));
        this.f517h = (ActionBarContextView) view.findViewById(a.f.f77f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(a.f.f74c);
        this.f515f = actionBarContainer;
        d0 d0Var = this.f516g;
        if (d0Var == null || this.f517h == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f510a = d0Var.o();
        boolean z4 = (this.f516g.i() & 4) != 0;
        if (z4) {
            this.f522m = true;
        }
        f.a b5 = f.a.b(this.f510a);
        K(b5.a() || z4);
        I(b5.g());
        TypedArray obtainStyledAttributes = this.f510a.obtainStyledAttributes(null, j.f133a, a.a.f2c, 0);
        if (obtainStyledAttributes.getBoolean(j.f183k, false)) {
            J(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.f173i, 0);
        if (dimensionPixelSize != 0) {
            H(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void I(boolean z4) {
        this.f528s = z4;
        if (z4) {
            this.f515f.setTabContainer(null);
            this.f516g.l(this.f519j);
        } else {
            this.f516g.l(null);
            this.f515f.setTabContainer(this.f519j);
        }
        boolean z5 = C() == 2;
        p0 p0Var = this.f519j;
        if (p0Var != null) {
            if (z5) {
                p0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f514e;
                if (actionBarOverlayLayout != null) {
                    p.Y(actionBarOverlayLayout);
                }
            } else {
                p0Var.setVisibility(8);
            }
        }
        this.f516g.u(!this.f528s && z5);
        this.f514e.setHasNonEmbeddedTabs(!this.f528s && z5);
    }

    private boolean L() {
        return p.H(this.f515f);
    }

    private void M() {
        if (this.f533x) {
            return;
        }
        this.f533x = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f514e;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        N(false);
    }

    private void N(boolean z4) {
        if (x(this.f531v, this.f532w, this.f533x)) {
            if (this.f534y) {
                return;
            }
            this.f534y = true;
            A(z4);
            return;
        }
        if (this.f534y) {
            this.f534y = false;
            z(z4);
        }
    }

    static boolean x(boolean z4, boolean z5, boolean z6) {
        if (z6) {
            return true;
        }
        return (z4 || z5) ? false : true;
    }

    public void A(boolean z4) {
        View view;
        View view2;
        f.h hVar = this.f535z;
        if (hVar != null) {
            hVar.a();
        }
        this.f515f.setVisibility(0);
        if (this.f529t == 0 && (this.A || z4)) {
            this.f515f.setTranslationY(0.0f);
            float f4 = -this.f515f.getHeight();
            if (z4) {
                this.f515f.getLocationInWindow(new int[]{0, 0});
                f4 -= r5[1];
            }
            this.f515f.setTranslationY(f4);
            f.h hVar2 = new f.h();
            t k4 = p.c(this.f515f).k(0.0f);
            k4.i(this.E);
            hVar2.c(k4);
            if (this.f530u && (view2 = this.f518i) != null) {
                view2.setTranslationY(f4);
                hVar2.c(p.c(this.f518i).k(0.0f));
            }
            hVar2.f(G);
            hVar2.e(250L);
            hVar2.g(this.D);
            this.f535z = hVar2;
            hVar2.h();
        } else {
            this.f515f.setAlpha(1.0f);
            this.f515f.setTranslationY(0.0f);
            if (this.f530u && (view = this.f518i) != null) {
                view.setTranslationY(0.0f);
            }
            this.D.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f514e;
        if (actionBarOverlayLayout != null) {
            p.Y(actionBarOverlayLayout);
        }
    }

    public int C() {
        return this.f516g.p();
    }

    public void F(boolean z4) {
        G(z4 ? 4 : 0, 4);
    }

    public void G(int i4, int i5) {
        int i6 = this.f516g.i();
        if ((i5 & 4) != 0) {
            this.f522m = true;
        }
        this.f516g.v((i4 & i5) | ((~i5) & i6));
    }

    public void H(float f4) {
        p.h0(this.f515f, f4);
    }

    public void J(boolean z4) {
        if (z4 && !this.f514e.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.B = z4;
        this.f514e.setHideOnContentScrollEnabled(z4);
    }

    public void K(boolean z4) {
        this.f516g.n(z4);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(boolean z4) {
        this.f530u = z4;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        if (this.f532w) {
            this.f532w = false;
            N(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
        f.h hVar = this.f535z;
        if (hVar != null) {
            hVar.a();
            this.f535z = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d(int i4) {
        this.f529t = i4;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (this.f532w) {
            return;
        }
        this.f532w = true;
        N(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        d0 d0Var = this.f516g;
        if (d0Var == null || !d0Var.s()) {
            return false;
        }
        this.f516g.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z4) {
        if (z4 == this.f526q) {
            return;
        }
        this.f526q = z4;
        int size = this.f527r.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f527r.get(i4).a(z4);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f516g.i();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f511b == null) {
            TypedValue typedValue = new TypedValue();
            this.f510a.getTheme().resolveAttribute(a.a.f6g, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                this.f511b = new ContextThemeWrapper(this.f510a, i4);
            } else {
                this.f511b = this.f510a;
            }
        }
        return this.f511b;
    }

    @Override // androidx.appcompat.app.a
    public void l() {
        if (this.f531v) {
            return;
        }
        this.f531v = true;
        N(false);
    }

    @Override // androidx.appcompat.app.a
    public void n(Configuration configuration) {
        I(f.a.b(this.f510a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean p(int i4, KeyEvent keyEvent) {
        Menu e4;
        d dVar = this.f523n;
        if (dVar == null || (e4 = dVar.e()) == null) {
            return false;
        }
        e4.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return e4.performShortcut(i4, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z4) {
        if (this.f522m) {
            return;
        }
        F(z4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z4) {
        f.h hVar;
        this.A = z4;
        if (z4 || (hVar = this.f535z) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void u(CharSequence charSequence) {
        this.f516g.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public f.b v(b.a aVar) {
        d dVar = this.f523n;
        if (dVar != null) {
            dVar.c();
        }
        this.f514e.setHideOnContentScrollEnabled(false);
        this.f517h.k();
        d dVar2 = new d(this.f517h.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f523n = dVar2;
        dVar2.k();
        this.f517h.h(dVar2);
        w(true);
        this.f517h.sendAccessibilityEvent(32);
        return dVar2;
    }

    public void w(boolean z4) {
        t q4;
        t f4;
        if (z4) {
            M();
        } else {
            D();
        }
        if (!L()) {
            if (z4) {
                this.f516g.j(4);
                this.f517h.setVisibility(0);
                return;
            } else {
                this.f516g.j(0);
                this.f517h.setVisibility(8);
                return;
            }
        }
        if (z4) {
            f4 = this.f516g.q(4, 100L);
            q4 = this.f517h.f(0, 200L);
        } else {
            q4 = this.f516g.q(0, 200L);
            f4 = this.f517h.f(8, 100L);
        }
        f.h hVar = new f.h();
        hVar.d(f4, q4);
        hVar.h();
    }

    void y() {
        b.a aVar = this.f525p;
        if (aVar != null) {
            aVar.c(this.f524o);
            this.f524o = null;
            this.f525p = null;
        }
    }

    public void z(boolean z4) {
        View view;
        f.h hVar = this.f535z;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f529t != 0 || (!this.A && !z4)) {
            this.C.a(null);
            return;
        }
        this.f515f.setAlpha(1.0f);
        this.f515f.setTransitioning(true);
        f.h hVar2 = new f.h();
        float f4 = -this.f515f.getHeight();
        if (z4) {
            this.f515f.getLocationInWindow(new int[]{0, 0});
            f4 -= r5[1];
        }
        t k4 = p.c(this.f515f).k(f4);
        k4.i(this.E);
        hVar2.c(k4);
        if (this.f530u && (view = this.f518i) != null) {
            hVar2.c(p.c(view).k(f4));
        }
        hVar2.f(F);
        hVar2.e(250L);
        hVar2.g(this.C);
        this.f535z = hVar2;
        hVar2.h();
    }
}
