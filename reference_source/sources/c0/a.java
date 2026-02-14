package c0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.recyclerview.widget.RecyclerView;
import c0.b;
import java.util.ArrayList;
import java.util.List;
import k.h;
import y.p;
import y.s;
import z.d;
import z.e;

/* loaded from: classes.dex */
public abstract class a extends y.a {

    /* renamed from: n, reason: collision with root package name */
    private static final Rect f2402n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);

    /* renamed from: o, reason: collision with root package name */
    private static final b.a<z.c> f2403o = new C0021a();

    /* renamed from: p, reason: collision with root package name */
    private static final b.InterfaceC0022b<h<z.c>, z.c> f2404p = new b();

    /* renamed from: h, reason: collision with root package name */
    private final AccessibilityManager f2409h;

    /* renamed from: i, reason: collision with root package name */
    private final View f2410i;

    /* renamed from: j, reason: collision with root package name */
    private c f2411j;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f2405d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private final Rect f2406e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    private final Rect f2407f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    private final int[] f2408g = new int[2];

    /* renamed from: k, reason: collision with root package name */
    int f2412k = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: l, reason: collision with root package name */
    int f2413l = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: m, reason: collision with root package name */
    private int f2414m = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: c0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0021a implements b.a<z.c> {
        C0021a() {
        }

        @Override // c0.b.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(z.c cVar, Rect rect) {
            cVar.l(rect);
        }
    }

    /* loaded from: classes.dex */
    static class b implements b.InterfaceC0022b<h<z.c>, z.c> {
        b() {
        }

        @Override // c0.b.InterfaceC0022b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public z.c b(h<z.c> hVar, int i4) {
            return hVar.n(i4);
        }

        @Override // c0.b.InterfaceC0022b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int a(h<z.c> hVar) {
            return hVar.m();
        }
    }

    /* loaded from: classes.dex */
    private class c extends d {
        c() {
        }

        @Override // z.d
        public z.c a(int i4) {
            return z.c.M(a.this.H(i4));
        }

        @Override // z.d
        public z.c c(int i4) {
            int i5 = i4 == 2 ? a.this.f2412k : a.this.f2413l;
            if (i5 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i5);
        }

        @Override // z.d
        public boolean e(int i4, int i5, Bundle bundle) {
            return a.this.P(i4, i5, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f2410i = view;
        this.f2409h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (p.r(view) == 0) {
            p.j0(view, 1);
        }
    }

    private static Rect D(View view, int i4, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i4 == 17) {
            rect.set(width, 0, width, height);
        } else if (i4 == 33) {
            rect.set(0, height, width, height);
        } else if (i4 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i4 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f2410i.getWindowVisibility() != 0) {
            return false;
        }
        View view = this.f2410i;
        do {
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return parent != null;
            }
            view = (View) parent;
            if (view.getAlpha() <= 0.0f) {
                break;
            }
        } while (view.getVisibility() == 0);
        return false;
    }

    private static int F(int i4) {
        if (i4 == 19) {
            return 33;
        }
        if (i4 != 21) {
            return i4 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean G(int i4, Rect rect) {
        Object d5;
        h<z.c> y4 = y();
        int i5 = this.f2413l;
        int i6 = RecyclerView.UNDEFINED_DURATION;
        z.c e4 = i5 == Integer.MIN_VALUE ? null : y4.e(i5);
        if (i4 == 1 || i4 == 2) {
            d5 = c0.b.d(y4, f2404p, f2403o, e4, i4, p.t(this.f2410i) == 1, false);
        } else {
            if (i4 != 17 && i4 != 33 && i4 != 66 && i4 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i7 = this.f2413l;
            if (i7 != Integer.MIN_VALUE) {
                z(i7, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f2410i, i4, rect2);
            }
            d5 = c0.b.c(y4, f2404p, f2403o, e4, rect2, i4);
        }
        z.c cVar = (z.c) d5;
        if (cVar != null) {
            i6 = y4.j(y4.h(cVar));
        }
        return T(i6);
    }

    private boolean Q(int i4, int i5, Bundle bundle) {
        return i5 != 1 ? i5 != 2 ? i5 != 64 ? i5 != 128 ? J(i4, i5, bundle) : n(i4) : S(i4) : o(i4) : T(i4);
    }

    private boolean R(int i4, Bundle bundle) {
        return p.R(this.f2410i, i4, bundle);
    }

    private boolean S(int i4) {
        int i5;
        if (!this.f2409h.isEnabled() || !this.f2409h.isTouchExplorationEnabled() || (i5 = this.f2412k) == i4) {
            return false;
        }
        if (i5 != Integer.MIN_VALUE) {
            n(i5);
        }
        this.f2412k = i4;
        this.f2410i.invalidate();
        U(i4, 32768);
        return true;
    }

    private void V(int i4) {
        int i5 = this.f2414m;
        if (i5 == i4) {
            return;
        }
        this.f2414m = i4;
        U(i4, 128);
        U(i5, 256);
    }

    private boolean n(int i4) {
        if (this.f2412k != i4) {
            return false;
        }
        this.f2412k = RecyclerView.UNDEFINED_DURATION;
        this.f2410i.invalidate();
        U(i4, 65536);
        return true;
    }

    private boolean p() {
        int i4 = this.f2413l;
        return i4 != Integer.MIN_VALUE && J(i4, 16, null);
    }

    private AccessibilityEvent q(int i4, int i5) {
        return i4 != -1 ? r(i4, i5) : s(i5);
    }

    private AccessibilityEvent r(int i4, int i5) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i5);
        z.c H = H(i4);
        obtain.getText().add(H.v());
        obtain.setContentDescription(H.q());
        obtain.setScrollable(H.H());
        obtain.setPassword(H.G());
        obtain.setEnabled(H.C());
        obtain.setChecked(H.A());
        L(i4, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(H.o());
        e.c(obtain, this.f2410i, i4);
        obtain.setPackageName(this.f2410i.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent s(int i4) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i4);
        this.f2410i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private z.c t(int i4) {
        z.c K = z.c.K();
        K.b0(true);
        K.d0(true);
        K.W("android.view.View");
        Rect rect = f2402n;
        K.S(rect);
        K.T(rect);
        K.k0(this.f2410i);
        N(i4, K);
        if (K.v() == null && K.q() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        K.l(this.f2406e);
        if (this.f2406e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int j4 = K.j();
        if ((j4 & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((j4 & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        K.i0(this.f2410i.getContext().getPackageName());
        K.p0(this.f2410i, i4);
        if (this.f2412k == i4) {
            K.Q(true);
            K.a(128);
        } else {
            K.Q(false);
            K.a(64);
        }
        boolean z4 = this.f2413l == i4;
        if (z4) {
            K.a(2);
        } else if (K.D()) {
            K.a(1);
        }
        K.e0(z4);
        this.f2410i.getLocationOnScreen(this.f2408g);
        K.m(this.f2405d);
        if (this.f2405d.equals(rect)) {
            K.l(this.f2405d);
            if (K.f6614b != -1) {
                z.c K2 = z.c.K();
                for (int i5 = K.f6614b; i5 != -1; i5 = K2.f6614b) {
                    K2.l0(this.f2410i, -1);
                    K2.S(f2402n);
                    N(i5, K2);
                    K2.l(this.f2406e);
                    Rect rect2 = this.f2405d;
                    Rect rect3 = this.f2406e;
                    rect2.offset(rect3.left, rect3.top);
                }
                K2.O();
            }
            this.f2405d.offset(this.f2408g[0] - this.f2410i.getScrollX(), this.f2408g[1] - this.f2410i.getScrollY());
        }
        if (this.f2410i.getLocalVisibleRect(this.f2407f)) {
            this.f2407f.offset(this.f2408g[0] - this.f2410i.getScrollX(), this.f2408g[1] - this.f2410i.getScrollY());
            if (this.f2405d.intersect(this.f2407f)) {
                K.T(this.f2405d);
                if (E(this.f2405d)) {
                    K.r0(true);
                }
            }
        }
        return K;
    }

    private z.c u() {
        z.c L = z.c.L(this.f2410i);
        p.P(this.f2410i, L);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (L.n() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            L.c(this.f2410i, ((Integer) arrayList.get(i4)).intValue());
        }
        return L;
    }

    private h<z.c> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h<z.c> hVar = new h<>();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            hVar.k(i4, t(i4));
        }
        return hVar;
    }

    private void z(int i4, Rect rect) {
        H(i4).l(rect);
    }

    public final int A() {
        return this.f2413l;
    }

    protected abstract int B(float f4, float f5);

    protected abstract void C(List<Integer> list);

    z.c H(int i4) {
        return i4 == -1 ? u() : t(i4);
    }

    public final void I(boolean z4, int i4, Rect rect) {
        int i5 = this.f2413l;
        if (i5 != Integer.MIN_VALUE) {
            o(i5);
        }
        if (z4) {
            G(i4, rect);
        }
    }

    protected abstract boolean J(int i4, int i5, Bundle bundle);

    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int i4, AccessibilityEvent accessibilityEvent) {
    }

    protected void M(z.c cVar) {
    }

    protected abstract void N(int i4, z.c cVar);

    protected void O(int i4, boolean z4) {
    }

    boolean P(int i4, int i5, Bundle bundle) {
        return i4 != -1 ? Q(i4, i5, bundle) : R(i5, bundle);
    }

    public final boolean T(int i4) {
        int i5;
        if ((!this.f2410i.isFocused() && !this.f2410i.requestFocus()) || (i5 = this.f2413l) == i4) {
            return false;
        }
        if (i5 != Integer.MIN_VALUE) {
            o(i5);
        }
        this.f2413l = i4;
        O(i4, true);
        U(i4, 8);
        return true;
    }

    public final boolean U(int i4, int i5) {
        ViewParent parent;
        if (i4 == Integer.MIN_VALUE || !this.f2409h.isEnabled() || (parent = this.f2410i.getParent()) == null) {
            return false;
        }
        return s.h(parent, this.f2410i, q(i4, i5));
    }

    @Override // y.a
    public d b(View view) {
        if (this.f2411j == null) {
            this.f2411j = new c();
        }
        return this.f2411j;
    }

    @Override // y.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // y.a
    public void g(View view, z.c cVar) {
        super.g(view, cVar);
        M(cVar);
    }

    public final boolean o(int i4) {
        if (this.f2413l != i4) {
            return false;
        }
        this.f2413l = RecyclerView.UNDEFINED_DURATION;
        O(i4, false);
        U(i4, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.f2409h.isEnabled() || !this.f2409h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int B = B(motionEvent.getX(), motionEvent.getY());
            V(B);
            return B != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f2414m == Integer.MIN_VALUE) {
            return false;
        }
        V(RecyclerView.UNDEFINED_DURATION);
        return true;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i4 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return G(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return G(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int F = F(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z4 = false;
                    while (i4 < repeatCount && G(F, null)) {
                        i4++;
                        z4 = true;
                    }
                    return z4;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p();
        return true;
    }

    public final int x() {
        return this.f2412k;
    }
}
