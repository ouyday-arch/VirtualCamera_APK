package com.ashokvarma.bottomnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.ashokvarma.bottomnavigation.behaviour.BottomNavBarFabBehaviour;
import com.ashokvarma.bottomnavigation.behaviour.BottomVerticalScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;
import y.p;
import y.t;

@CoordinatorLayout.d(BottomVerticalScrollBehavior.class)
/* loaded from: classes.dex */
public class BottomNavigationBar extends FrameLayout {

    /* renamed from: v, reason: collision with root package name */
    private static final Interpolator f2497v = new d0.c();

    /* renamed from: b, reason: collision with root package name */
    private int f2498b;

    /* renamed from: c, reason: collision with root package name */
    private int f2499c;

    /* renamed from: d, reason: collision with root package name */
    private t f2500d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2501e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<com.ashokvarma.bottomnavigation.c> f2502f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<d> f2503g;

    /* renamed from: h, reason: collision with root package name */
    private int f2504h;

    /* renamed from: i, reason: collision with root package name */
    private int f2505i;

    /* renamed from: j, reason: collision with root package name */
    private c f2506j;

    /* renamed from: k, reason: collision with root package name */
    private int f2507k;

    /* renamed from: l, reason: collision with root package name */
    private int f2508l;

    /* renamed from: m, reason: collision with root package name */
    private int f2509m;

    /* renamed from: n, reason: collision with root package name */
    private FrameLayout f2510n;

    /* renamed from: o, reason: collision with root package name */
    private FrameLayout f2511o;

    /* renamed from: p, reason: collision with root package name */
    private LinearLayout f2512p;

    /* renamed from: q, reason: collision with root package name */
    private int f2513q;

    /* renamed from: r, reason: collision with root package name */
    private int f2514r;

    /* renamed from: s, reason: collision with root package name */
    private float f2515s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f2516t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f2517u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomNavigationBar.this.p(((d) view).b(), false, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f2519b;

        b(d dVar) {
            this.f2519b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ashokvarma.bottomnavigation.b.d(this.f2519b, BottomNavigationBar.this.f2511o, BottomNavigationBar.this.f2510n, this.f2519b.a(), BottomNavigationBar.this.f2514r);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(int i4);

        void b(int i4);

        void c(int i4);
    }

    public BottomNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationBar(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f2498b = 0;
        this.f2499c = 0;
        this.f2501e = false;
        this.f2502f = new ArrayList<>();
        this.f2503g = new ArrayList<>();
        this.f2504h = -1;
        this.f2505i = 0;
        this.f2513q = 200;
        this.f2514r = 500;
        this.f2517u = false;
        m(context, attributeSet);
        i();
    }

    private void f(int i4) {
        t tVar = this.f2500d;
        if (tVar == null) {
            t c5 = p.c(this);
            this.f2500d = c5;
            c5.d(this.f2514r);
            this.f2500d.e(f2497v);
        } else {
            tVar.b();
        }
        this.f2500d.k(i4).j();
    }

    private void i() {
        setLayoutParams(new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(-1, -2)));
        View inflate = LayoutInflater.from(getContext()).inflate(i.f2605a, (ViewGroup) this, true);
        this.f2510n = (FrameLayout) inflate.findViewById(h.f2594c);
        this.f2511o = (FrameLayout) inflate.findViewById(h.f2592a);
        this.f2512p = (LinearLayout) inflate.findViewById(h.f2593b);
        setOutlineProvider(ViewOutlineProvider.BOUNDS);
        p.h0(this, this.f2515s);
        setClipToPadding(false);
    }

    private void m(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.f2507k = l0.a.a(context, f.f2572a);
            this.f2508l = -3355444;
            this.f2509m = -1;
            this.f2515s = getResources().getDimension(g.f2573a);
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, j.f2648u, 0, 0);
        this.f2507k = obtainStyledAttributes.getColor(j.f2650v, l0.a.a(context, f.f2572a));
        this.f2508l = obtainStyledAttributes.getColor(j.B, -3355444);
        this.f2509m = obtainStyledAttributes.getColor(j.f2656y, -1);
        this.f2516t = obtainStyledAttributes.getBoolean(j.f2654x, true);
        this.f2515s = obtainStyledAttributes.getDimension(j.A, getResources().getDimension(g.f2573a));
        r(obtainStyledAttributes.getInt(j.f2652w, 200));
        int i4 = obtainStyledAttributes.getInt(j.C, 0);
        if (i4 == 1) {
            this.f2498b = 1;
        } else if (i4 != 2) {
            int i5 = 3;
            if (i4 != 3) {
                i5 = 4;
                if (i4 != 4) {
                    this.f2498b = 0;
                }
            }
            this.f2498b = i5;
        } else {
            this.f2498b = 2;
        }
        int i6 = obtainStyledAttributes.getInt(j.f2658z, 0);
        if (i6 == 1) {
            this.f2499c = 1;
        } else if (i6 != 2) {
            this.f2499c = 0;
        } else {
            this.f2499c = 2;
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i4, boolean z4, boolean z5, boolean z6) {
        int i5 = this.f2504h;
        if (i5 != i4) {
            int i6 = this.f2499c;
            if (i6 == 1) {
                if (i5 != -1) {
                    this.f2503g.get(i5).r(true, this.f2513q);
                }
                this.f2503g.get(i4).e(true, this.f2513q);
            } else if (i6 == 2) {
                if (i5 != -1) {
                    this.f2503g.get(i5).r(false, this.f2513q);
                }
                this.f2503g.get(i4).e(false, this.f2513q);
                d dVar = this.f2503g.get(i4);
                if (z4) {
                    this.f2511o.setBackgroundColor(dVar.a());
                    this.f2510n.setVisibility(8);
                } else {
                    this.f2510n.post(new b(dVar));
                }
            }
            this.f2504h = i4;
        }
        if (z5) {
            q(i5, i4, z6);
        }
    }

    private void q(int i4, int i5, boolean z4) {
        c cVar = this.f2506j;
        if (cVar != null) {
            if (z4) {
                cVar.a(i5);
                return;
            }
            if (i4 == i5) {
                cVar.c(i5);
                return;
            }
            cVar.a(i5);
            if (i4 != -1) {
                this.f2506j.b(i4);
            }
        }
    }

    private void t(int i4, boolean z4) {
        if (z4) {
            f(i4);
            return;
        }
        t tVar = this.f2500d;
        if (tVar != null) {
            tVar.b();
        }
        setTranslationY(i4);
    }

    private void u(boolean z4, d dVar, com.ashokvarma.bottomnavigation.c cVar, int i4, int i5) {
        dVar.l(z4);
        dVar.k(i4);
        dVar.g(i5);
        dVar.q(this.f2502f.indexOf(cVar));
        dVar.setOnClickListener(new a());
        this.f2503g.add(dVar);
        com.ashokvarma.bottomnavigation.b.a(cVar, dVar, this);
        dVar.d(this.f2499c == 1);
        this.f2512p.addView(dVar);
    }

    public BottomNavigationBar e(com.ashokvarma.bottomnavigation.c cVar) {
        this.f2502f.add(cVar);
        return this;
    }

    public void g() {
        h(true);
    }

    public int getActiveColor() {
        return this.f2507k;
    }

    public int getAnimationDuration() {
        return this.f2513q;
    }

    public int getBackgroundColor() {
        return this.f2509m;
    }

    public int getCurrentSelectedPosition() {
        return this.f2504h;
    }

    public int getInActiveColor() {
        return this.f2508l;
    }

    public void h(boolean z4) {
        this.f2517u = true;
        t(getHeight(), z4);
    }

    public void j() {
        this.f2504h = -1;
        this.f2503g.clear();
        if (this.f2502f.isEmpty()) {
            return;
        }
        this.f2512p.removeAllViews();
        if (this.f2498b == 0) {
            if (this.f2502f.size() <= 3) {
                this.f2498b = 1;
            } else {
                this.f2498b = 2;
            }
        }
        if (this.f2499c == 0) {
            if (this.f2498b == 1) {
                this.f2499c = 1;
            } else {
                this.f2499c = 2;
            }
        }
        if (this.f2499c == 1) {
            this.f2510n.setVisibility(8);
            this.f2511o.setBackgroundColor(this.f2509m);
        }
        int b5 = l0.a.b(getContext());
        int i4 = this.f2498b;
        if (i4 == 1 || i4 == 3) {
            int i5 = com.ashokvarma.bottomnavigation.b.b(getContext(), b5, this.f2502f.size(), this.f2501e)[0];
            Iterator<com.ashokvarma.bottomnavigation.c> it = this.f2502f.iterator();
            while (it.hasNext()) {
                com.ashokvarma.bottomnavigation.c next = it.next();
                u(this.f2498b == 3, new e(getContext()), next, i5, i5);
            }
        } else if (i4 == 2 || i4 == 4) {
            int[] c5 = com.ashokvarma.bottomnavigation.b.c(getContext(), b5, this.f2502f.size(), this.f2501e);
            int i6 = c5[0];
            int i7 = c5[1];
            Iterator<com.ashokvarma.bottomnavigation.c> it2 = this.f2502f.iterator();
            while (it2.hasNext()) {
                com.ashokvarma.bottomnavigation.c next2 = it2.next();
                u(this.f2498b == 4, new k(getContext()), next2, i6, i7);
            }
        }
        int size = this.f2503g.size();
        int i8 = this.f2505i;
        if (size > i8) {
            p(i8, true, false, false);
        } else {
            if (this.f2503g.isEmpty()) {
                return;
            }
            p(0, true, false, false);
        }
    }

    public boolean k() {
        return this.f2516t;
    }

    public boolean l() {
        return this.f2517u;
    }

    public void n(int i4) {
        o(i4, true);
    }

    public void o(int i4, boolean z4) {
        p(i4, false, z4, z4);
    }

    public BottomNavigationBar r(int i4) {
        this.f2513q = i4;
        this.f2514r = (int) (i4 * 2.5d);
        return this;
    }

    public BottomNavigationBar s(c cVar) {
        this.f2506j = cVar;
        return this;
    }

    public void setAutoHideEnabled(boolean z4) {
        this.f2516t = z4;
    }

    public void setFab(FloatingActionButton floatingActionButton) {
        ViewGroup.LayoutParams layoutParams = floatingActionButton.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof CoordinatorLayout.f)) {
            return;
        }
        ((CoordinatorLayout.f) layoutParams).o(new BottomNavBarFabBehaviour());
    }

    public void v() {
        w(true);
    }

    public void w(boolean z4) {
        this.f2517u = false;
        t(0, z4);
    }
}
