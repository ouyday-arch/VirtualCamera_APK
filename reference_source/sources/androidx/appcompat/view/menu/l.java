package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.l0;
import y.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends h implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: w, reason: collision with root package name */
    private static final int f709w = a.g.f110m;

    /* renamed from: c, reason: collision with root package name */
    private final Context f710c;

    /* renamed from: d, reason: collision with root package name */
    private final e f711d;

    /* renamed from: e, reason: collision with root package name */
    private final d f712e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f713f;

    /* renamed from: g, reason: collision with root package name */
    private final int f714g;

    /* renamed from: h, reason: collision with root package name */
    private final int f715h;

    /* renamed from: i, reason: collision with root package name */
    private final int f716i;

    /* renamed from: j, reason: collision with root package name */
    final l0 f717j;

    /* renamed from: m, reason: collision with root package name */
    private PopupWindow.OnDismissListener f720m;

    /* renamed from: n, reason: collision with root package name */
    private View f721n;

    /* renamed from: o, reason: collision with root package name */
    View f722o;

    /* renamed from: p, reason: collision with root package name */
    private j.a f723p;

    /* renamed from: q, reason: collision with root package name */
    ViewTreeObserver f724q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f725r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f726s;

    /* renamed from: t, reason: collision with root package name */
    private int f727t;

    /* renamed from: v, reason: collision with root package name */
    private boolean f729v;

    /* renamed from: k, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f718k = new a();

    /* renamed from: l, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f719l = new b();

    /* renamed from: u, reason: collision with root package name */
    private int f728u = 0;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!l.this.b() || l.this.f717j.A()) {
                return;
            }
            View view = l.this.f722o;
            if (view == null || !view.isShown()) {
                l.this.dismiss();
            } else {
                l.this.f717j.show();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f724q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f724q = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f724q.removeGlobalOnLayoutListener(lVar.f718k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i4, int i5, boolean z4) {
        this.f710c = context;
        this.f711d = eVar;
        this.f713f = z4;
        this.f712e = new d(eVar, LayoutInflater.from(context), z4, f709w);
        this.f715h = i4;
        this.f716i = i5;
        Resources resources = context.getResources();
        this.f714g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.f37d));
        this.f721n = view;
        this.f717j = new l0(context, null, i4, i5);
        eVar.c(this, context);
    }

    private boolean y() {
        View view;
        if (b()) {
            return true;
        }
        if (this.f725r || (view = this.f721n) == null) {
            return false;
        }
        this.f722o = view;
        this.f717j.J(this);
        this.f717j.K(this);
        this.f717j.I(true);
        View view2 = this.f722o;
        boolean z4 = this.f724q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f724q = viewTreeObserver;
        if (z4) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f718k);
        }
        view2.addOnAttachStateChangeListener(this.f719l);
        this.f717j.C(view2);
        this.f717j.F(this.f728u);
        if (!this.f726s) {
            this.f727t = h.n(this.f712e, null, this.f710c, this.f714g);
            this.f726s = true;
        }
        this.f717j.E(this.f727t);
        this.f717j.H(2);
        this.f717j.G(m());
        this.f717j.show();
        ListView k4 = this.f717j.k();
        k4.setOnKeyListener(this);
        if (this.f729v && this.f711d.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f710c).inflate(a.g.f109l, (ViewGroup) k4, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f711d.x());
            }
            frameLayout.setEnabled(false);
            k4.addHeaderView(frameLayout, null, false);
        }
        this.f717j.n(this.f712e);
        this.f717j.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z4) {
        if (eVar != this.f711d) {
            return;
        }
        dismiss();
        j.a aVar = this.f723p;
        if (aVar != null) {
            aVar.a(eVar, z4);
        }
    }

    @Override // g.e
    public boolean b() {
        return !this.f725r && this.f717j.b();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    @Override // g.e
    public void dismiss() {
        if (b()) {
            this.f717j.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void g(j.a aVar) {
        this.f723p = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean h(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f710c, mVar, this.f722o, this.f713f, this.f715h, this.f716i);
            iVar.j(this.f723p);
            iVar.g(h.w(mVar));
            iVar.i(this.f720m);
            this.f720m = null;
            this.f711d.e(false);
            int e4 = this.f717j.e();
            int g4 = this.f717j.g();
            if ((Gravity.getAbsoluteGravity(this.f728u, p.t(this.f721n)) & 7) == 5) {
                e4 += this.f721n.getWidth();
            }
            if (iVar.n(e4, g4)) {
                j.a aVar = this.f723p;
                if (aVar == null) {
                    return true;
                }
                aVar.b(mVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(boolean z4) {
        this.f726s = false;
        d dVar = this.f712e;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void j(e eVar) {
    }

    @Override // g.e
    public ListView k() {
        return this.f717j.k();
    }

    @Override // androidx.appcompat.view.menu.h
    public void o(View view) {
        this.f721n = view;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f725r = true;
        this.f711d.close();
        ViewTreeObserver viewTreeObserver = this.f724q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f724q = this.f722o.getViewTreeObserver();
            }
            this.f724q.removeGlobalOnLayoutListener(this.f718k);
            this.f724q = null;
        }
        this.f722o.removeOnAttachStateChangeListener(this.f719l);
        PopupWindow.OnDismissListener onDismissListener = this.f720m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i4, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i4 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.h
    public void q(boolean z4) {
        this.f712e.d(z4);
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(int i4) {
        this.f728u = i4;
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i4) {
        this.f717j.d(i4);
    }

    @Override // g.e
    public void show() {
        if (!y()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f720m = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(boolean z4) {
        this.f729v = z4;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(int i4) {
        this.f717j.m(i4);
    }
}
