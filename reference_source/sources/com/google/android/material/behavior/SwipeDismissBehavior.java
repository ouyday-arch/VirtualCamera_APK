package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c0.c;
import y.p;
import z.c;
import z.f;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    c0.c f2737a;

    /* renamed from: b, reason: collision with root package name */
    c f2738b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2739c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2741e;

    /* renamed from: d, reason: collision with root package name */
    private float f2740d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    int f2742f = 2;

    /* renamed from: g, reason: collision with root package name */
    float f2743g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    float f2744h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    float f2745i = 0.5f;

    /* renamed from: j, reason: collision with root package name */
    private final c.AbstractC0023c f2746j = new a();

    /* loaded from: classes.dex */
    class a extends c.AbstractC0023c {

        /* renamed from: a, reason: collision with root package name */
        private int f2747a;

        /* renamed from: b, reason: collision with root package name */
        private int f2748b = -1;

        a() {
        }

        private boolean n(View view, float f4) {
            if (f4 == 0.0f) {
                return Math.abs(view.getLeft() - this.f2747a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f2743g);
            }
            boolean z4 = p.t(view) == 1;
            int i4 = SwipeDismissBehavior.this.f2742f;
            if (i4 == 2) {
                return true;
            }
            if (i4 == 0) {
                if (z4) {
                    if (f4 >= 0.0f) {
                        return false;
                    }
                } else if (f4 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i4 != 1) {
                return false;
            }
            if (z4) {
                if (f4 <= 0.0f) {
                    return false;
                }
            } else if (f4 >= 0.0f) {
                return false;
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        
            r5 = r2.f2747a;
            r3 = r3.getWidth() + r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        
            if (r5 != false) goto L10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
        
            if (r5 != false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        
            r5 = r2.f2747a - r3.getWidth();
            r3 = r2.f2747a;
         */
        @Override // c0.c.AbstractC0023c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int a(android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = y.p.t(r3)
                r0 = 1
                if (r5 != r0) goto L9
                r5 = r0
                goto La
            L9:
                r5 = 0
            La:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.f2742f
                if (r1 != 0) goto L24
                if (r5 == 0) goto L1c
            L12:
                int r5 = r2.f2747a
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.f2747a
                goto L37
            L1c:
                int r5 = r2.f2747a
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L37
            L24:
                if (r1 != r0) goto L29
                if (r5 == 0) goto L12
                goto L1c
            L29:
                int r5 = r2.f2747a
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.f2747a
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L37:
                int r3 = com.google.android.material.behavior.SwipeDismissBehavior.G(r5, r4, r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.a(android.view.View, int, int):int");
        }

        @Override // c0.c.AbstractC0023c
        public int b(View view, int i4, int i5) {
            return view.getTop();
        }

        @Override // c0.c.AbstractC0023c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // c0.c.AbstractC0023c
        public void i(View view, int i4) {
            this.f2748b = i4;
            this.f2747a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // c0.c.AbstractC0023c
        public void j(int i4) {
            c cVar = SwipeDismissBehavior.this.f2738b;
            if (cVar != null) {
                cVar.b(i4);
            }
        }

        @Override // c0.c.AbstractC0023c
        public void k(View view, int i4, int i5, int i6, int i7) {
            float width = this.f2747a + (view.getWidth() * SwipeDismissBehavior.this.f2744h);
            float width2 = this.f2747a + (view.getWidth() * SwipeDismissBehavior.this.f2745i);
            float f4 = i4;
            if (f4 <= width) {
                view.setAlpha(1.0f);
            } else if (f4 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.F(0.0f, 1.0f - SwipeDismissBehavior.I(width, width2, f4), 1.0f));
            }
        }

        @Override // c0.c.AbstractC0023c
        public void l(View view, float f4, float f5) {
            int i4;
            boolean z4;
            c cVar;
            this.f2748b = -1;
            int width = view.getWidth();
            if (n(view, f4)) {
                int left = view.getLeft();
                int i5 = this.f2747a;
                i4 = left < i5 ? i5 - width : i5 + width;
                z4 = true;
            } else {
                i4 = this.f2747a;
                z4 = false;
            }
            if (SwipeDismissBehavior.this.f2737a.F(i4, view.getTop())) {
                p.T(view, new d(view, z4));
            } else {
                if (!z4 || (cVar = SwipeDismissBehavior.this.f2738b) == null) {
                    return;
                }
                cVar.a(view);
            }
        }

        @Override // c0.c.AbstractC0023c
        public boolean m(View view, int i4) {
            int i5 = this.f2748b;
            return (i5 == -1 || i5 == i4) && SwipeDismissBehavior.this.E(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements f {
        b() {
        }

        @Override // z.f
        public boolean a(View view, f.a aVar) {
            boolean z4 = false;
            if (!SwipeDismissBehavior.this.E(view)) {
                return false;
            }
            boolean z5 = p.t(view) == 1;
            int i4 = SwipeDismissBehavior.this.f2742f;
            if ((i4 == 0 && z5) || (i4 == 1 && !z5)) {
                z4 = true;
            }
            int width = view.getWidth();
            if (z4) {
                width = -width;
            }
            p.M(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f2738b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(View view);

        void b(int i4);
    }

    /* loaded from: classes.dex */
    private class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final View f2751b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f2752c;

        d(View view, boolean z4) {
            this.f2751b = view;
            this.f2752c = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            c0.c cVar2 = SwipeDismissBehavior.this.f2737a;
            if (cVar2 != null && cVar2.k(true)) {
                p.T(this.f2751b, this);
            } else {
                if (!this.f2752c || (cVar = SwipeDismissBehavior.this.f2738b) == null) {
                    return;
                }
                cVar.a(this.f2751b);
            }
        }
    }

    static float F(float f4, float f5, float f6) {
        return Math.min(Math.max(f4, f5), f6);
    }

    static int G(int i4, int i5, int i6) {
        return Math.min(Math.max(i4, i5), i6);
    }

    private void H(ViewGroup viewGroup) {
        if (this.f2737a == null) {
            this.f2737a = this.f2741e ? c0.c.l(viewGroup, this.f2740d, this.f2746j) : c0.c.m(viewGroup, this.f2746j);
        }
    }

    static float I(float f4, float f5, float f6) {
        return (f6 - f4) / (f5 - f4);
    }

    private void M(View view) {
        p.V(view, 1048576);
        if (E(view)) {
            p.X(view, c.a.f6636y, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v4, MotionEvent motionEvent) {
        c0.c cVar = this.f2737a;
        if (cVar == null) {
            return false;
        }
        cVar.z(motionEvent);
        return true;
    }

    public boolean E(View view) {
        return true;
    }

    public void J(float f4) {
        this.f2745i = F(0.0f, f4, 1.0f);
    }

    public void K(float f4) {
        this.f2744h = F(0.0f, f4, 1.0f);
    }

    public void L(int i4) {
        this.f2742f = i4;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v4, MotionEvent motionEvent) {
        boolean z4 = this.f2739c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z4 = coordinatorLayout.C(v4, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f2739c = z4;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2739c = false;
        }
        if (!z4) {
            return false;
        }
        H(coordinatorLayout);
        return this.f2737a.G(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v4, int i4) {
        boolean l4 = super.l(coordinatorLayout, v4, i4);
        if (p.r(v4) == 0) {
            p.j0(v4, 1);
            M(v4);
        }
        return l4;
    }
}
