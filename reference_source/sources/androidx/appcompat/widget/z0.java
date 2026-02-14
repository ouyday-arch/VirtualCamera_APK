package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
class z0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k, reason: collision with root package name */
    private static z0 f1263k;

    /* renamed from: l, reason: collision with root package name */
    private static z0 f1264l;

    /* renamed from: b, reason: collision with root package name */
    private final View f1265b;

    /* renamed from: c, reason: collision with root package name */
    private final CharSequence f1266c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1267d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f1268e = new a();

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f1269f = new b();

    /* renamed from: g, reason: collision with root package name */
    private int f1270g;

    /* renamed from: h, reason: collision with root package name */
    private int f1271h;

    /* renamed from: i, reason: collision with root package name */
    private a1 f1272i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1273j;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.g(false);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.c();
        }
    }

    private z0(View view, CharSequence charSequence) {
        this.f1265b = view;
        this.f1266c = charSequence;
        this.f1267d = y.q.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.f1265b.removeCallbacks(this.f1268e);
    }

    private void b() {
        this.f1270g = Integer.MAX_VALUE;
        this.f1271h = Integer.MAX_VALUE;
    }

    private void d() {
        this.f1265b.postDelayed(this.f1268e, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(z0 z0Var) {
        z0 z0Var2 = f1263k;
        if (z0Var2 != null) {
            z0Var2.a();
        }
        f1263k = z0Var;
        if (z0Var != null) {
            z0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        z0 z0Var = f1263k;
        if (z0Var != null && z0Var.f1265b == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new z0(view, charSequence);
            return;
        }
        z0 z0Var2 = f1264l;
        if (z0Var2 != null && z0Var2.f1265b == view) {
            z0Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean h(MotionEvent motionEvent) {
        int x4 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        if (Math.abs(x4 - this.f1270g) <= this.f1267d && Math.abs(y4 - this.f1271h) <= this.f1267d) {
            return false;
        }
        this.f1270g = x4;
        this.f1271h = y4;
        return true;
    }

    void c() {
        if (f1264l == this) {
            f1264l = null;
            a1 a1Var = this.f1272i;
            if (a1Var != null) {
                a1Var.c();
                this.f1272i = null;
                b();
                this.f1265b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1263k == this) {
            e(null);
        }
        this.f1265b.removeCallbacks(this.f1269f);
    }

    void g(boolean z4) {
        long longPressTimeout;
        if (y.p.G(this.f1265b)) {
            e(null);
            z0 z0Var = f1264l;
            if (z0Var != null) {
                z0Var.c();
            }
            f1264l = this;
            this.f1273j = z4;
            a1 a1Var = new a1(this.f1265b.getContext());
            this.f1272i = a1Var;
            a1Var.e(this.f1265b, this.f1270g, this.f1271h, this.f1273j, this.f1266c);
            this.f1265b.addOnAttachStateChangeListener(this);
            if (this.f1273j) {
                longPressTimeout = 2500;
            } else {
                longPressTimeout = ((y.p.A(this.f1265b) & 1) == 1 ? 3000L : 15000L) - ViewConfiguration.getLongPressTimeout();
            }
            this.f1265b.removeCallbacks(this.f1269f);
            this.f1265b.postDelayed(this.f1269f, longPressTimeout);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1272i != null && this.f1273j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1265b.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f1265b.isEnabled() && this.f1272i == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1270g = view.getWidth() / 2;
        this.f1271h = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
