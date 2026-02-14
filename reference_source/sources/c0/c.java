package c0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import y.p;

/* loaded from: classes.dex */
public class c {

    /* renamed from: w, reason: collision with root package name */
    private static final Interpolator f2420w = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f2421a;

    /* renamed from: b, reason: collision with root package name */
    private int f2422b;

    /* renamed from: d, reason: collision with root package name */
    private float[] f2424d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f2425e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f2426f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f2427g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f2428h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f2429i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f2430j;

    /* renamed from: k, reason: collision with root package name */
    private int f2431k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f2432l;

    /* renamed from: m, reason: collision with root package name */
    private float f2433m;

    /* renamed from: n, reason: collision with root package name */
    private float f2434n;

    /* renamed from: o, reason: collision with root package name */
    private int f2435o;

    /* renamed from: p, reason: collision with root package name */
    private int f2436p;

    /* renamed from: q, reason: collision with root package name */
    private OverScroller f2437q;

    /* renamed from: r, reason: collision with root package name */
    private final AbstractC0023c f2438r;

    /* renamed from: s, reason: collision with root package name */
    private View f2439s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f2440t;

    /* renamed from: u, reason: collision with root package name */
    private final ViewGroup f2441u;

    /* renamed from: c, reason: collision with root package name */
    private int f2423c = -1;

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f2442v = new b();

    /* loaded from: classes.dex */
    static class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            return (f5 * f5 * f5 * f5 * f5) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E(0);
        }
    }

    /* renamed from: c0.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0023c {
        public abstract int a(View view, int i4, int i5);

        public abstract int b(View view, int i4, int i5);

        public int c(int i4) {
            return i4;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i4, int i5) {
        }

        public boolean g(int i4) {
            return false;
        }

        public void h(int i4, int i5) {
        }

        public void i(View view, int i4) {
        }

        public abstract void j(int i4);

        public abstract void k(View view, int i4, int i5, int i6, int i7);

        public abstract void l(View view, float f4, float f5);

        public abstract boolean m(View view, int i4);
    }

    private c(Context context, ViewGroup viewGroup, AbstractC0023c abstractC0023c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0023c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f2441u = viewGroup;
        this.f2438r = abstractC0023c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2435o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f2422b = viewConfiguration.getScaledTouchSlop();
        this.f2433m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f2434n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2437q = new OverScroller(context, f2420w);
    }

    private void A() {
        this.f2432l.computeCurrentVelocity(1000, this.f2433m);
        n(e(this.f2432l.getXVelocity(this.f2423c), this.f2434n, this.f2433m), e(this.f2432l.getYVelocity(this.f2423c), this.f2434n, this.f2433m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [c0.c$c] */
    private void B(float f4, float f5, int i4) {
        boolean c5 = c(f4, f5, i4, 1);
        boolean z4 = c5;
        if (c(f5, f4, i4, 4)) {
            z4 = (c5 ? 1 : 0) | 4;
        }
        boolean z5 = z4;
        if (c(f4, f5, i4, 2)) {
            z5 = (z4 ? 1 : 0) | 2;
        }
        ?? r02 = z5;
        if (c(f5, f4, i4, 8)) {
            r02 = (z5 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f2429i;
            iArr[i4] = iArr[i4] | r02;
            this.f2438r.f(r02, i4);
        }
    }

    private void C(float f4, float f5, int i4) {
        q(i4);
        float[] fArr = this.f2424d;
        this.f2426f[i4] = f4;
        fArr[i4] = f4;
        float[] fArr2 = this.f2425e;
        this.f2427g[i4] = f5;
        fArr2[i4] = f5;
        this.f2428h[i4] = t((int) f4, (int) f5);
        this.f2431k |= 1 << i4;
    }

    private void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i4 = 0; i4 < pointerCount; i4++) {
            int pointerId = motionEvent.getPointerId(i4);
            if (x(pointerId)) {
                float x4 = motionEvent.getX(i4);
                float y4 = motionEvent.getY(i4);
                this.f2426f[pointerId] = x4;
                this.f2427g[pointerId] = y4;
            }
        }
    }

    private boolean c(float f4, float f5, int i4, int i5) {
        float abs = Math.abs(f4);
        float abs2 = Math.abs(f5);
        if ((this.f2428h[i4] & i5) != i5 || (this.f2436p & i5) == 0 || (this.f2430j[i4] & i5) == i5 || (this.f2429i[i4] & i5) == i5) {
            return false;
        }
        int i6 = this.f2422b;
        if (abs <= i6 && abs2 <= i6) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f2438r.g(i5)) {
            return (this.f2429i[i4] & i5) == 0 && abs > ((float) this.f2422b);
        }
        int[] iArr = this.f2430j;
        iArr[i4] = iArr[i4] | i5;
        return false;
    }

    private boolean d(View view, float f4, float f5) {
        if (view == null) {
            return false;
        }
        boolean z4 = this.f2438r.d(view) > 0;
        boolean z5 = this.f2438r.e(view) > 0;
        if (!z4 || !z5) {
            return z4 ? Math.abs(f4) > ((float) this.f2422b) : z5 && Math.abs(f5) > ((float) this.f2422b);
        }
        float f6 = (f4 * f4) + (f5 * f5);
        int i4 = this.f2422b;
        return f6 > ((float) (i4 * i4));
    }

    private float e(float f4, float f5, float f6) {
        float abs = Math.abs(f4);
        if (abs < f5) {
            return 0.0f;
        }
        return abs > f6 ? f4 > 0.0f ? f6 : -f6 : f4;
    }

    private int f(int i4, int i5, int i6) {
        int abs = Math.abs(i4);
        if (abs < i5) {
            return 0;
        }
        return abs > i6 ? i4 > 0 ? i6 : -i6 : i4;
    }

    private void g() {
        float[] fArr = this.f2424d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f2425e, 0.0f);
        Arrays.fill(this.f2426f, 0.0f);
        Arrays.fill(this.f2427g, 0.0f);
        Arrays.fill(this.f2428h, 0);
        Arrays.fill(this.f2429i, 0);
        Arrays.fill(this.f2430j, 0);
        this.f2431k = 0;
    }

    private void h(int i4) {
        if (this.f2424d == null || !w(i4)) {
            return;
        }
        this.f2424d[i4] = 0.0f;
        this.f2425e[i4] = 0.0f;
        this.f2426f[i4] = 0.0f;
        this.f2427g[i4] = 0.0f;
        this.f2428h[i4] = 0;
        this.f2429i[i4] = 0;
        this.f2430j[i4] = 0;
        this.f2431k = (~(1 << i4)) & this.f2431k;
    }

    private int i(int i4, int i5, int i6) {
        if (i4 == 0) {
            return 0;
        }
        int width = this.f2441u.getWidth();
        float f4 = width / 2;
        float o4 = f4 + (o(Math.min(1.0f, Math.abs(i4) / width)) * f4);
        int abs = Math.abs(i5);
        return Math.min(abs > 0 ? Math.round(Math.abs(o4 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i4) / i6) + 1.0f) * 256.0f), 600);
    }

    private int j(View view, int i4, int i5, int i6, int i7) {
        float f4;
        float f5;
        float f6;
        float f7;
        int f8 = f(i6, (int) this.f2434n, (int) this.f2433m);
        int f9 = f(i7, (int) this.f2434n, (int) this.f2433m);
        int abs = Math.abs(i4);
        int abs2 = Math.abs(i5);
        int abs3 = Math.abs(f8);
        int abs4 = Math.abs(f9);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (f8 != 0) {
            f4 = abs3;
            f5 = i8;
        } else {
            f4 = abs;
            f5 = i9;
        }
        float f10 = f4 / f5;
        if (f9 != 0) {
            f6 = abs4;
            f7 = i8;
        } else {
            f6 = abs2;
            f7 = i9;
        }
        return (int) ((i(i4, f8, this.f2438r.d(view)) * f10) + (i(i5, f9, this.f2438r.e(view)) * (f6 / f7)));
    }

    public static c l(ViewGroup viewGroup, float f4, AbstractC0023c abstractC0023c) {
        c m4 = m(viewGroup, abstractC0023c);
        m4.f2422b = (int) (m4.f2422b * (1.0f / f4));
        return m4;
    }

    public static c m(ViewGroup viewGroup, AbstractC0023c abstractC0023c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0023c);
    }

    private void n(float f4, float f5) {
        this.f2440t = true;
        this.f2438r.l(this.f2439s, f4, f5);
        this.f2440t = false;
        if (this.f2421a == 1) {
            E(0);
        }
    }

    private float o(float f4) {
        return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
    }

    private void p(int i4, int i5, int i6, int i7) {
        int left = this.f2439s.getLeft();
        int top = this.f2439s.getTop();
        if (i6 != 0) {
            i4 = this.f2438r.a(this.f2439s, i4, i6);
            p.M(this.f2439s, i4 - left);
        }
        int i8 = i4;
        if (i7 != 0) {
            i5 = this.f2438r.b(this.f2439s, i5, i7);
            p.N(this.f2439s, i5 - top);
        }
        int i9 = i5;
        if (i6 == 0 && i7 == 0) {
            return;
        }
        this.f2438r.k(this.f2439s, i8, i9, i8 - left, i9 - top);
    }

    private void q(int i4) {
        float[] fArr = this.f2424d;
        if (fArr == null || fArr.length <= i4) {
            int i5 = i4 + 1;
            float[] fArr2 = new float[i5];
            float[] fArr3 = new float[i5];
            float[] fArr4 = new float[i5];
            float[] fArr5 = new float[i5];
            int[] iArr = new int[i5];
            int[] iArr2 = new int[i5];
            int[] iArr3 = new int[i5];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f2425e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f2426f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f2427g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f2428h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f2429i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f2430j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2424d = fArr2;
            this.f2425e = fArr3;
            this.f2426f = fArr4;
            this.f2427g = fArr5;
            this.f2428h = iArr;
            this.f2429i = iArr2;
            this.f2430j = iArr3;
        }
    }

    private boolean s(int i4, int i5, int i6, int i7) {
        int left = this.f2439s.getLeft();
        int top = this.f2439s.getTop();
        int i8 = i4 - left;
        int i9 = i5 - top;
        if (i8 == 0 && i9 == 0) {
            this.f2437q.abortAnimation();
            E(0);
            return false;
        }
        this.f2437q.startScroll(left, top, i8, i9, j(this.f2439s, i8, i9, i6, i7));
        E(2);
        return true;
    }

    private int t(int i4, int i5) {
        int i6 = i4 < this.f2441u.getLeft() + this.f2435o ? 1 : 0;
        if (i5 < this.f2441u.getTop() + this.f2435o) {
            i6 |= 4;
        }
        if (i4 > this.f2441u.getRight() - this.f2435o) {
            i6 |= 2;
        }
        return i5 > this.f2441u.getBottom() - this.f2435o ? i6 | 8 : i6;
    }

    private boolean x(int i4) {
        if (w(i4)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i4 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    void E(int i4) {
        this.f2441u.removeCallbacks(this.f2442v);
        if (this.f2421a != i4) {
            this.f2421a = i4;
            this.f2438r.j(i4);
            if (this.f2421a == 0) {
                this.f2439s = null;
            }
        }
    }

    public boolean F(int i4, int i5) {
        if (this.f2440t) {
            return s(i4, i5, (int) this.f2432l.getXVelocity(this.f2423c), (int) this.f2432l.getYVelocity(this.f2423c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean G(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.c.G(android.view.MotionEvent):boolean");
    }

    public boolean H(View view, int i4, int i5) {
        this.f2439s = view;
        this.f2423c = -1;
        boolean s4 = s(i4, i5, 0, 0);
        if (!s4 && this.f2421a == 0 && this.f2439s != null) {
            this.f2439s = null;
        }
        return s4;
    }

    boolean I(View view, int i4) {
        if (view == this.f2439s && this.f2423c == i4) {
            return true;
        }
        if (view == null || !this.f2438r.m(view, i4)) {
            return false;
        }
        this.f2423c = i4;
        b(view, i4);
        return true;
    }

    public void a() {
        this.f2423c = -1;
        g();
        VelocityTracker velocityTracker = this.f2432l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2432l = null;
        }
    }

    public void b(View view, int i4) {
        if (view.getParent() == this.f2441u) {
            this.f2439s = view;
            this.f2423c = i4;
            this.f2438r.i(view, i4);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f2441u + ")");
    }

    public boolean k(boolean z4) {
        if (this.f2421a == 2) {
            boolean computeScrollOffset = this.f2437q.computeScrollOffset();
            int currX = this.f2437q.getCurrX();
            int currY = this.f2437q.getCurrY();
            int left = currX - this.f2439s.getLeft();
            int top = currY - this.f2439s.getTop();
            if (left != 0) {
                p.M(this.f2439s, left);
            }
            if (top != 0) {
                p.N(this.f2439s, top);
            }
            if (left != 0 || top != 0) {
                this.f2438r.k(this.f2439s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f2437q.getFinalX() && currY == this.f2437q.getFinalY()) {
                this.f2437q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z4) {
                    this.f2441u.post(this.f2442v);
                } else {
                    E(0);
                }
            }
        }
        return this.f2421a == 2;
    }

    public View r(int i4, int i5) {
        for (int childCount = this.f2441u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f2441u.getChildAt(this.f2438r.c(childCount));
            if (i4 >= childAt.getLeft() && i4 < childAt.getRight() && i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public int u() {
        return this.f2422b;
    }

    public boolean v(int i4, int i5) {
        return y(this.f2439s, i4, i5);
    }

    public boolean w(int i4) {
        return ((1 << i4) & this.f2431k) != 0;
    }

    public boolean y(View view, int i4, int i5) {
        return view != null && i4 >= view.getLeft() && i4 < view.getRight() && i5 >= view.getTop() && i5 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i4;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f2432l == null) {
            this.f2432l = VelocityTracker.obtain();
        }
        this.f2432l.addMovement(motionEvent);
        int i5 = 0;
        if (actionMasked == 0) {
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View r4 = r((int) x4, (int) y4);
            C(x4, y4, pointerId);
            I(r4, pointerId);
            int i6 = this.f2428h[pointerId];
            int i7 = this.f2436p;
            if ((i6 & i7) != 0) {
                this.f2438r.h(i6 & i7, pointerId);
                return;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f2421a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i5 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i5);
                        if (x(pointerId2)) {
                            float x5 = motionEvent.getX(i5);
                            float y5 = motionEvent.getY(i5);
                            float f4 = x5 - this.f2424d[pointerId2];
                            float f5 = y5 - this.f2425e[pointerId2];
                            B(f4, f5, pointerId2);
                            if (this.f2421a != 1) {
                                View r5 = r((int) x5, (int) y5);
                                if (d(r5, f4, f5) && I(r5, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i5++;
                    }
                } else {
                    if (!x(this.f2423c)) {
                        return;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(this.f2423c);
                    float x6 = motionEvent.getX(findPointerIndex);
                    float y6 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f2426f;
                    int i8 = this.f2423c;
                    int i9 = (int) (x6 - fArr[i8]);
                    int i10 = (int) (y6 - this.f2427g[i8]);
                    p(this.f2439s.getLeft() + i9, this.f2439s.getTop() + i10, i9, i10);
                }
                D(motionEvent);
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked == 5) {
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    float x7 = motionEvent.getX(actionIndex);
                    float y7 = motionEvent.getY(actionIndex);
                    C(x7, y7, pointerId3);
                    if (this.f2421a != 0) {
                        if (v((int) x7, (int) y7)) {
                            I(this.f2439s, pointerId3);
                            return;
                        }
                        return;
                    } else {
                        I(r((int) x7, (int) y7), pointerId3);
                        int i11 = this.f2428h[pointerId3];
                        int i12 = this.f2436p;
                        if ((i11 & i12) != 0) {
                            this.f2438r.h(i11 & i12, pointerId3);
                            return;
                        }
                        return;
                    }
                }
                if (actionMasked != 6) {
                    return;
                }
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.f2421a == 1 && pointerId4 == this.f2423c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i5 >= pointerCount2) {
                            i4 = -1;
                            break;
                        }
                        int pointerId5 = motionEvent.getPointerId(i5);
                        if (pointerId5 != this.f2423c) {
                            View r6 = r((int) motionEvent.getX(i5), (int) motionEvent.getY(i5));
                            View view = this.f2439s;
                            if (r6 == view && I(view, pointerId5)) {
                                i4 = this.f2423c;
                                break;
                            }
                        }
                        i5++;
                    }
                    if (i4 == -1) {
                        A();
                    }
                }
                h(pointerId4);
                return;
            }
            if (this.f2421a == 1) {
                n(0.0f, 0.0f);
            }
        } else if (this.f2421a == 1) {
            A();
        }
        a();
    }
}
