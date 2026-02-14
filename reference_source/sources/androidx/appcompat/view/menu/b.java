package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends h implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int C = a.g.f102e;
    private PopupWindow.OnDismissListener A;
    boolean B;

    /* renamed from: c, reason: collision with root package name */
    private final Context f587c;

    /* renamed from: d, reason: collision with root package name */
    private final int f588d;

    /* renamed from: e, reason: collision with root package name */
    private final int f589e;

    /* renamed from: f, reason: collision with root package name */
    private final int f590f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f591g;

    /* renamed from: h, reason: collision with root package name */
    final Handler f592h;

    /* renamed from: p, reason: collision with root package name */
    private View f600p;

    /* renamed from: q, reason: collision with root package name */
    View f601q;

    /* renamed from: s, reason: collision with root package name */
    private boolean f603s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f604t;

    /* renamed from: u, reason: collision with root package name */
    private int f605u;

    /* renamed from: v, reason: collision with root package name */
    private int f606v;

    /* renamed from: x, reason: collision with root package name */
    private boolean f608x;

    /* renamed from: y, reason: collision with root package name */
    private j.a f609y;

    /* renamed from: z, reason: collision with root package name */
    ViewTreeObserver f610z;

    /* renamed from: i, reason: collision with root package name */
    private final List<e> f593i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    final List<d> f594j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f595k = new a();

    /* renamed from: l, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f596l = new ViewOnAttachStateChangeListenerC0006b();

    /* renamed from: m, reason: collision with root package name */
    private final k0 f597m = new c();

    /* renamed from: n, reason: collision with root package name */
    private int f598n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f599o = 0;

    /* renamed from: w, reason: collision with root package name */
    private boolean f607w = false;

    /* renamed from: r, reason: collision with root package name */
    private int f602r = C();

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.b() || b.this.f594j.size() <= 0 || b.this.f594j.get(0).f618a.A()) {
                return;
            }
            View view = b.this.f601q;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator<d> it = b.this.f594j.iterator();
            while (it.hasNext()) {
                it.next().f618a.show();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnAttachStateChangeListenerC0006b implements View.OnAttachStateChangeListener {
        ViewOnAttachStateChangeListenerC0006b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f610z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f610z = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f610z.removeGlobalOnLayoutListener(bVar.f595k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    class c implements k0 {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f614b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ MenuItem f615c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f616d;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.f614b = dVar;
                this.f615c = menuItem;
                this.f616d = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f614b;
                if (dVar != null) {
                    b.this.B = true;
                    dVar.f619b.e(false);
                    b.this.B = false;
                }
                if (this.f615c.isEnabled() && this.f615c.hasSubMenu()) {
                    this.f616d.L(this.f615c, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.k0
        public void a(e eVar, MenuItem menuItem) {
            b.this.f592h.removeCallbacksAndMessages(null);
            int size = b.this.f594j.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i4 = -1;
                    break;
                } else if (eVar == b.this.f594j.get(i4).f619b) {
                    break;
                } else {
                    i4++;
                }
            }
            if (i4 == -1) {
                return;
            }
            int i5 = i4 + 1;
            b.this.f592h.postAtTime(new a(i5 < b.this.f594j.size() ? b.this.f594j.get(i5) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.k0
        public void h(e eVar, MenuItem menuItem) {
            b.this.f592h.removeCallbacksAndMessages(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final l0 f618a;

        /* renamed from: b, reason: collision with root package name */
        public final e f619b;

        /* renamed from: c, reason: collision with root package name */
        public final int f620c;

        public d(l0 l0Var, e eVar, int i4) {
            this.f618a = l0Var;
            this.f619b = eVar;
            this.f620c = i4;
        }

        public ListView a() {
            return this.f618a.k();
        }
    }

    public b(Context context, View view, int i4, int i5, boolean z4) {
        this.f587c = context;
        this.f600p = view;
        this.f589e = i4;
        this.f590f = i5;
        this.f591g = z4;
        Resources resources = context.getResources();
        this.f588d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.f37d));
        this.f592h = new Handler();
    }

    private MenuItem A(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = eVar.getItem(i4);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View B(d dVar, e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int i4;
        int firstVisiblePosition;
        MenuItem A = A(dVar.f619b, eVar);
        if (A == null) {
            return null;
        }
        ListView a5 = dVar.a();
        ListAdapter adapter = a5.getAdapter();
        int i5 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i4 = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            i4 = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i5 >= count) {
                i5 = -1;
                break;
            }
            if (A == dVar2.getItem(i5)) {
                break;
            }
            i5++;
        }
        if (i5 != -1 && (firstVisiblePosition = (i5 + i4) - a5.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a5.getChildCount()) {
            return a5.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int C() {
        return p.t(this.f600p) == 1 ? 0 : 1;
    }

    private int D(int i4) {
        List<d> list = this.f594j;
        ListView a5 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a5.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f601q.getWindowVisibleDisplayFrame(rect);
        return this.f602r == 1 ? (iArr[0] + a5.getWidth()) + i4 > rect.right ? 0 : 1 : iArr[0] - i4 < 0 ? 1 : 0;
    }

    private void E(e eVar) {
        d dVar;
        View view;
        int i4;
        int i5;
        int i6;
        LayoutInflater from = LayoutInflater.from(this.f587c);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, from, this.f591g, C);
        if (!b() && this.f607w) {
            dVar2.d(true);
        } else if (b()) {
            dVar2.d(h.w(eVar));
        }
        int n4 = h.n(dVar2, null, this.f587c, this.f588d);
        l0 y4 = y();
        y4.n(dVar2);
        y4.E(n4);
        y4.F(this.f599o);
        if (this.f594j.size() > 0) {
            List<d> list = this.f594j;
            dVar = list.get(list.size() - 1);
            view = B(dVar, eVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            y4.T(false);
            y4.Q(null);
            int D = D(n4);
            boolean z4 = D == 1;
            this.f602r = D;
            if (Build.VERSION.SDK_INT >= 26) {
                y4.C(view);
                i5 = 0;
                i4 = 0;
            } else {
                int[] iArr = new int[2];
                this.f600p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f599o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f600p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i4 = iArr2[0] - iArr[0];
                i5 = iArr2[1] - iArr[1];
            }
            if ((this.f599o & 5) == 5) {
                if (!z4) {
                    n4 = view.getWidth();
                    i6 = i4 - n4;
                }
                i6 = i4 + n4;
            } else {
                if (z4) {
                    n4 = view.getWidth();
                    i6 = i4 + n4;
                }
                i6 = i4 - n4;
            }
            y4.d(i6);
            y4.L(true);
            y4.m(i5);
        } else {
            if (this.f603s) {
                y4.d(this.f605u);
            }
            if (this.f604t) {
                y4.m(this.f606v);
            }
            y4.G(m());
        }
        this.f594j.add(new d(y4, eVar, this.f602r));
        y4.show();
        ListView k4 = y4.k();
        k4.setOnKeyListener(this);
        if (dVar == null && this.f608x && eVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(a.g.f109l, (ViewGroup) k4, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(eVar.x());
            k4.addHeaderView(frameLayout, null, false);
            y4.show();
        }
    }

    private l0 y() {
        l0 l0Var = new l0(this.f587c, null, this.f589e, this.f590f);
        l0Var.S(this.f597m);
        l0Var.K(this);
        l0Var.J(this);
        l0Var.C(this.f600p);
        l0Var.F(this.f599o);
        l0Var.I(true);
        l0Var.H(2);
        return l0Var;
    }

    private int z(e eVar) {
        int size = this.f594j.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (eVar == this.f594j.get(i4).f619b) {
                return i4;
            }
        }
        return -1;
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z4) {
        int z5 = z(eVar);
        if (z5 < 0) {
            return;
        }
        int i4 = z5 + 1;
        if (i4 < this.f594j.size()) {
            this.f594j.get(i4).f619b.e(false);
        }
        d remove = this.f594j.remove(z5);
        remove.f619b.O(this);
        if (this.B) {
            remove.f618a.R(null);
            remove.f618a.D(0);
        }
        remove.f618a.dismiss();
        int size = this.f594j.size();
        this.f602r = size > 0 ? this.f594j.get(size - 1).f620c : C();
        if (size != 0) {
            if (z4) {
                this.f594j.get(0).f619b.e(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.f609y;
        if (aVar != null) {
            aVar.a(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f610z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f610z.removeGlobalOnLayoutListener(this.f595k);
            }
            this.f610z = null;
        }
        this.f601q.removeOnAttachStateChangeListener(this.f596l);
        this.A.onDismiss();
    }

    @Override // g.e
    public boolean b() {
        return this.f594j.size() > 0 && this.f594j.get(0).f618a.b();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    @Override // g.e
    public void dismiss() {
        int size = this.f594j.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f594j.toArray(new d[size]);
            for (int i4 = size - 1; i4 >= 0; i4--) {
                d dVar = dVarArr[i4];
                if (dVar.f618a.b()) {
                    dVar.f618a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void g(j.a aVar) {
        this.f609y = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean h(m mVar) {
        for (d dVar : this.f594j) {
            if (mVar == dVar.f619b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        j(mVar);
        j.a aVar = this.f609y;
        if (aVar != null) {
            aVar.b(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(boolean z4) {
        Iterator<d> it = this.f594j.iterator();
        while (it.hasNext()) {
            h.x(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void j(e eVar) {
        eVar.c(this, this.f587c);
        if (b()) {
            E(eVar);
        } else {
            this.f593i.add(eVar);
        }
    }

    @Override // g.e
    public ListView k() {
        if (this.f594j.isEmpty()) {
            return null;
        }
        return this.f594j.get(r0.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.h
    protected boolean l() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.h
    public void o(View view) {
        if (this.f600p != view) {
            this.f600p = view;
            this.f599o = y.c.b(this.f598n, p.t(view));
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f594j.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f594j.get(i4);
            if (!dVar.f618a.b()) {
                break;
            } else {
                i4++;
            }
        }
        if (dVar != null) {
            dVar.f619b.e(false);
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
        this.f607w = z4;
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(int i4) {
        if (this.f598n != i4) {
            this.f598n = i4;
            this.f599o = y.c.b(i4, p.t(this.f600p));
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i4) {
        this.f603s = true;
        this.f605u = i4;
    }

    @Override // g.e
    public void show() {
        if (b()) {
            return;
        }
        Iterator<e> it = this.f593i.iterator();
        while (it.hasNext()) {
            E(it.next());
        }
        this.f593i.clear();
        View view = this.f600p;
        this.f601q = view;
        if (view != null) {
            boolean z4 = this.f610z == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f610z = viewTreeObserver;
            if (z4) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f595k);
            }
            this.f601q.addOnAttachStateChangeListener(this.f596l);
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(boolean z4) {
        this.f608x = z4;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(int i4) {
        this.f604t = true;
        this.f606v = i4;
    }
}
