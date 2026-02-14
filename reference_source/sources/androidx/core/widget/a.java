package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import y.p;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: s, reason: collision with root package name */
    private static final int f1371s = ViewConfiguration.getTapTimeout();

    /* renamed from: d, reason: collision with root package name */
    final View f1374d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f1375e;

    /* renamed from: h, reason: collision with root package name */
    private int f1378h;

    /* renamed from: i, reason: collision with root package name */
    private int f1379i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1383m;

    /* renamed from: n, reason: collision with root package name */
    boolean f1384n;

    /* renamed from: o, reason: collision with root package name */
    boolean f1385o;

    /* renamed from: p, reason: collision with root package name */
    boolean f1386p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1387q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1388r;

    /* renamed from: b, reason: collision with root package name */
    final C0010a f1372b = new C0010a();

    /* renamed from: c, reason: collision with root package name */
    private final Interpolator f1373c = new AccelerateInterpolator();

    /* renamed from: f, reason: collision with root package name */
    private float[] f1376f = {0.0f, 0.0f};

    /* renamed from: g, reason: collision with root package name */
    private float[] f1377g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: j, reason: collision with root package name */
    private float[] f1380j = {0.0f, 0.0f};

    /* renamed from: k, reason: collision with root package name */
    private float[] f1381k = {0.0f, 0.0f};

    /* renamed from: l, reason: collision with root package name */
    private float[] f1382l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010a {

        /* renamed from: a, reason: collision with root package name */
        private int f1389a;

        /* renamed from: b, reason: collision with root package name */
        private int f1390b;

        /* renamed from: c, reason: collision with root package name */
        private float f1391c;

        /* renamed from: d, reason: collision with root package name */
        private float f1392d;

        /* renamed from: j, reason: collision with root package name */
        private float f1398j;

        /* renamed from: k, reason: collision with root package name */
        private int f1399k;

        /* renamed from: e, reason: collision with root package name */
        private long f1393e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f1397i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f1394f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f1395g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f1396h = 0;

        C0010a() {
        }

        private float e(long j4) {
            long j5 = this.f1393e;
            if (j4 < j5) {
                return 0.0f;
            }
            long j6 = this.f1397i;
            if (j6 < 0 || j4 < j6) {
                return a.e(((float) (j4 - j5)) / this.f1389a, 0.0f, 1.0f) * 0.5f;
            }
            float f4 = this.f1398j;
            return (1.0f - f4) + (f4 * a.e(((float) (j4 - j6)) / this.f1399k, 0.0f, 1.0f));
        }

        private float g(float f4) {
            return ((-4.0f) * f4 * f4) + (f4 * 4.0f);
        }

        public void a() {
            if (this.f1394f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float g4 = g(e(currentAnimationTimeMillis));
            long j4 = currentAnimationTimeMillis - this.f1394f;
            this.f1394f = currentAnimationTimeMillis;
            float f4 = ((float) j4) * g4;
            this.f1395g = (int) (this.f1391c * f4);
            this.f1396h = (int) (f4 * this.f1392d);
        }

        public int b() {
            return this.f1395g;
        }

        public int c() {
            return this.f1396h;
        }

        public int d() {
            float f4 = this.f1391c;
            return (int) (f4 / Math.abs(f4));
        }

        public int f() {
            float f4 = this.f1392d;
            return (int) (f4 / Math.abs(f4));
        }

        public boolean h() {
            return this.f1397i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1397i + ((long) this.f1399k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1399k = a.f((int) (currentAnimationTimeMillis - this.f1393e), 0, this.f1390b);
            this.f1398j = e(currentAnimationTimeMillis);
            this.f1397i = currentAnimationTimeMillis;
        }

        public void j(int i4) {
            this.f1390b = i4;
        }

        public void k(int i4) {
            this.f1389a = i4;
        }

        public void l(float f4, float f5) {
            this.f1391c = f4;
            this.f1392d = f5;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1393e = currentAnimationTimeMillis;
            this.f1397i = -1L;
            this.f1394f = currentAnimationTimeMillis;
            this.f1398j = 0.5f;
            this.f1395g = 0;
            this.f1396h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f1386p) {
                if (aVar.f1384n) {
                    aVar.f1384n = false;
                    aVar.f1372b.m();
                }
                C0010a c0010a = a.this.f1372b;
                if (c0010a.h() || !a.this.u()) {
                    a.this.f1386p = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f1385o) {
                    aVar2.f1385o = false;
                    aVar2.c();
                }
                c0010a.a();
                a.this.j(c0010a.b(), c0010a.c());
                p.T(a.this.f1374d, this);
            }
        }
    }

    public a(View view) {
        this.f1374d = view;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        float f5 = (int) ((1575.0f * f4) + 0.5f);
        o(f5, f5);
        float f6 = (int) ((f4 * 315.0f) + 0.5f);
        p(f6, f6);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f1371s);
        r(500);
        q(500);
    }

    private float d(int i4, float f4, float f5, float f6) {
        float h4 = h(this.f1376f[i4], f5, this.f1377g[i4], f4);
        if (h4 == 0.0f) {
            return 0.0f;
        }
        float f7 = this.f1380j[i4];
        float f8 = this.f1381k[i4];
        float f9 = this.f1382l[i4];
        float f10 = f7 * f6;
        return h4 > 0.0f ? e(h4 * f10, f8, f9) : -e((-h4) * f10, f8, f9);
    }

    static float e(float f4, float f5, float f6) {
        return f4 > f6 ? f6 : f4 < f5 ? f5 : f4;
    }

    static int f(int i4, int i5, int i6) {
        return i4 > i6 ? i6 : i4 < i5 ? i5 : i4;
    }

    private float g(float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        int i4 = this.f1378h;
        if (i4 == 0 || i4 == 1) {
            if (f4 < f5) {
                if (f4 >= 0.0f) {
                    return 1.0f - (f4 / f5);
                }
                if (this.f1386p && i4 == 1) {
                    return 1.0f;
                }
            }
        } else if (i4 == 2 && f4 < 0.0f) {
            return f4 / (-f5);
        }
        return 0.0f;
    }

    private float h(float f4, float f5, float f6, float f7) {
        float interpolation;
        float e4 = e(f4 * f5, 0.0f, f6);
        float g4 = g(f5 - f7, e4) - g(f7, e4);
        if (g4 < 0.0f) {
            interpolation = -this.f1373c.getInterpolation(-g4);
        } else {
            if (g4 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f1373c.getInterpolation(g4);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f1384n) {
            this.f1386p = false;
        } else {
            this.f1372b.i();
        }
    }

    private void v() {
        int i4;
        if (this.f1375e == null) {
            this.f1375e = new b();
        }
        this.f1386p = true;
        this.f1384n = true;
        if (this.f1383m || (i4 = this.f1379i) <= 0) {
            this.f1375e.run();
        } else {
            p.U(this.f1374d, this.f1375e, i4);
        }
        this.f1383m = true;
    }

    public abstract boolean a(int i4);

    public abstract boolean b(int i4);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1374d.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i4, int i5);

    public a k(int i4) {
        this.f1379i = i4;
        return this;
    }

    public a l(int i4) {
        this.f1378h = i4;
        return this;
    }

    public a m(boolean z4) {
        if (this.f1387q && !z4) {
            i();
        }
        this.f1387q = z4;
        return this;
    }

    public a n(float f4, float f5) {
        float[] fArr = this.f1377g;
        fArr[0] = f4;
        fArr[1] = f5;
        return this;
    }

    public a o(float f4, float f5) {
        float[] fArr = this.f1382l;
        fArr[0] = f4 / 1000.0f;
        fArr[1] = f5 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f1387q
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f1385o = r2
            r5.f1383m = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1374d
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1374d
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f1372b
            r7.l(r0, r6)
            boolean r6 = r5.f1386p
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f1388r
            if (r6 == 0) goto L61
            boolean r6 = r5.f1386p
            if (r6 == 0) goto L61
            r1 = r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f4, float f5) {
        float[] fArr = this.f1381k;
        fArr[0] = f4 / 1000.0f;
        fArr[1] = f5 / 1000.0f;
        return this;
    }

    public a q(int i4) {
        this.f1372b.j(i4);
        return this;
    }

    public a r(int i4) {
        this.f1372b.k(i4);
        return this;
    }

    public a s(float f4, float f5) {
        float[] fArr = this.f1376f;
        fArr[0] = f4;
        fArr[1] = f5;
        return this;
    }

    public a t(float f4, float f5) {
        float[] fArr = this.f1380j;
        fArr[0] = f4 / 1000.0f;
        fArr[1] = f5 / 1000.0f;
        return this;
    }

    boolean u() {
        C0010a c0010a = this.f1372b;
        int f4 = c0010a.f();
        int d5 = c0010a.d();
        return (f4 != 0 && b(f4)) || (d5 != 0 && a(d5));
    }
}
