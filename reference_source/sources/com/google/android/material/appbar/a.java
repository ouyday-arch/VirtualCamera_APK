package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import y.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a<V extends View> extends c<V> {

    /* renamed from: d, reason: collision with root package name */
    private Runnable f2707d;

    /* renamed from: e, reason: collision with root package name */
    OverScroller f2708e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2709f;

    /* renamed from: g, reason: collision with root package name */
    private int f2710g;

    /* renamed from: h, reason: collision with root package name */
    private int f2711h;

    /* renamed from: i, reason: collision with root package name */
    private int f2712i;

    /* renamed from: j, reason: collision with root package name */
    private VelocityTracker f2713j;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.material.appbar.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0025a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final CoordinatorLayout f2714b;

        /* renamed from: c, reason: collision with root package name */
        private final V f2715c;

        RunnableC0025a(CoordinatorLayout coordinatorLayout, V v4) {
            this.f2714b = coordinatorLayout;
            this.f2715c = v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f2715c == null || (overScroller = a.this.f2708e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.N(this.f2714b, this.f2715c);
                return;
            }
            a aVar = a.this;
            aVar.P(this.f2714b, this.f2715c, aVar.f2708e.getCurrY());
            p.T(this.f2715c, this);
        }
    }

    public a() {
        this.f2710g = -1;
        this.f2712i = -1;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2710g = -1;
        this.f2712i = -1;
    }

    private void I() {
        if (this.f2713j == null) {
            this.f2713j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean D(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = r2
            goto L1c
        L1b:
            r12 = r3
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f2710g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f2711h = r12
            goto L4c
        L2d:
            int r0 = r11.f2710g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f2711h
            int r7 = r1 - r0
            r11.f2711h = r0
            int r8 = r11.K(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.O(r5, r6, r7, r8, r9)
        L4c:
            r12 = r3
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f2713j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f2713j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f2713j
            int r4 = r11.f2710g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.L(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.J(r6, r7, r8, r9, r10)
            r12 = r2
            goto L73
        L72:
            r12 = r3
        L73:
            r11.f2709f = r3
            r11.f2710g = r1
            android.view.VelocityTracker r13 = r11.f2713j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f2713j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f2713j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f2709f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = r3
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    boolean H(V v4) {
        return false;
    }

    final boolean J(CoordinatorLayout coordinatorLayout, V v4, int i4, int i5, float f4) {
        Runnable runnable = this.f2707d;
        if (runnable != null) {
            v4.removeCallbacks(runnable);
            this.f2707d = null;
        }
        if (this.f2708e == null) {
            this.f2708e = new OverScroller(v4.getContext());
        }
        this.f2708e.fling(0, E(), 0, Math.round(f4), 0, 0, i4, i5);
        if (!this.f2708e.computeScrollOffset()) {
            N(coordinatorLayout, v4);
            return false;
        }
        RunnableC0025a runnableC0025a = new RunnableC0025a(coordinatorLayout, v4);
        this.f2707d = runnableC0025a;
        p.T(v4, runnableC0025a);
        return true;
    }

    int K(V v4) {
        return -v4.getHeight();
    }

    int L(V v4) {
        return v4.getHeight();
    }

    int M() {
        return E();
    }

    void N(CoordinatorLayout coordinatorLayout, V v4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int O(CoordinatorLayout coordinatorLayout, V v4, int i4, int i5, int i6) {
        return Q(coordinatorLayout, v4, M() - i4, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int P(CoordinatorLayout coordinatorLayout, V v4, int i4) {
        return Q(coordinatorLayout, v4, i4, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
    }

    int Q(CoordinatorLayout coordinatorLayout, V v4, int i4, int i5, int i6) {
        int b5;
        int E = E();
        if (i5 == 0 || E < i5 || E > i6 || E == (b5 = t.a.b(i4, i5, i6))) {
            return 0;
        }
        G(b5);
        return E - b5;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v4, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f2712i < 0) {
            this.f2712i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f2709f) {
            int i4 = this.f2710g;
            if (i4 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i4)) == -1) {
                return false;
            }
            int y4 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y4 - this.f2711h) > this.f2712i) {
                this.f2711h = y4;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f2710g = -1;
            int x4 = (int) motionEvent.getX();
            int y5 = (int) motionEvent.getY();
            boolean z4 = H(v4) && coordinatorLayout.C(v4, x4, y5);
            this.f2709f = z4;
            if (z4) {
                this.f2711h = y5;
                this.f2710g = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f2708e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f2708e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f2713j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }
}
