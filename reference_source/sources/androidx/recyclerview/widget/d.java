package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends RecyclerView.n implements RecyclerView.s {
    private static final int[] D = {R.attr.state_pressed};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.t C;

    /* renamed from: a, reason: collision with root package name */
    private final int f2009a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2010b;

    /* renamed from: c, reason: collision with root package name */
    final StateListDrawable f2011c;

    /* renamed from: d, reason: collision with root package name */
    final Drawable f2012d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2013e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2014f;

    /* renamed from: g, reason: collision with root package name */
    private final StateListDrawable f2015g;

    /* renamed from: h, reason: collision with root package name */
    private final Drawable f2016h;

    /* renamed from: i, reason: collision with root package name */
    private final int f2017i;

    /* renamed from: j, reason: collision with root package name */
    private final int f2018j;

    /* renamed from: k, reason: collision with root package name */
    int f2019k;

    /* renamed from: l, reason: collision with root package name */
    int f2020l;

    /* renamed from: m, reason: collision with root package name */
    float f2021m;

    /* renamed from: n, reason: collision with root package name */
    int f2022n;

    /* renamed from: o, reason: collision with root package name */
    int f2023o;

    /* renamed from: p, reason: collision with root package name */
    float f2024p;

    /* renamed from: s, reason: collision with root package name */
    private RecyclerView f2027s;

    /* renamed from: z, reason: collision with root package name */
    final ValueAnimator f2034z;

    /* renamed from: q, reason: collision with root package name */
    private int f2025q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f2026r = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f2028t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f2029u = false;

    /* renamed from: v, reason: collision with root package name */
    private int f2030v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f2031w = 0;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f2032x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    private final int[] f2033y = new int[2];

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(500);
        }
    }

    /* loaded from: classes.dex */
    class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i4, int i5) {
            d.this.B(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* loaded from: classes.dex */
    private class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f2037a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2037a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2037a) {
                this.f2037a = false;
                return;
            }
            if (((Float) d.this.f2034z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.y(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.v();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0018d implements ValueAnimator.AnimatorUpdateListener {
        C0018d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f2011c.setAlpha(floatValue);
            d.this.f2012d.setAlpha(floatValue);
            d.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i4, int i5, int i6) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2034z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f2011c = stateListDrawable;
        this.f2012d = drawable;
        this.f2015g = stateListDrawable2;
        this.f2016h = drawable2;
        this.f2013e = Math.max(i4, stateListDrawable.getIntrinsicWidth());
        this.f2014f = Math.max(i4, drawable.getIntrinsicWidth());
        this.f2017i = Math.max(i4, stateListDrawable2.getIntrinsicWidth());
        this.f2018j = Math.max(i4, drawable2.getIntrinsicWidth());
        this.f2009a = i5;
        this.f2010b = i6;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new C0018d());
        j(recyclerView);
    }

    private void C(float f4) {
        int[] p4 = p();
        float max = Math.max(p4[0], Math.min(p4[1], f4));
        if (Math.abs(this.f2020l - max) < 2.0f) {
            return;
        }
        int x4 = x(this.f2021m, max, p4, this.f2027s.computeVerticalScrollRange(), this.f2027s.computeVerticalScrollOffset(), this.f2026r);
        if (x4 != 0) {
            this.f2027s.scrollBy(0, x4);
        }
        this.f2021m = max;
    }

    private void k() {
        this.f2027s.removeCallbacks(this.B);
    }

    private void l() {
        this.f2027s.removeItemDecoration(this);
        this.f2027s.removeOnItemTouchListener(this);
        this.f2027s.removeOnScrollListener(this.C);
        k();
    }

    private void m(Canvas canvas) {
        int i4 = this.f2026r;
        int i5 = this.f2017i;
        int i6 = this.f2023o;
        int i7 = this.f2022n;
        this.f2015g.setBounds(0, 0, i7, i5);
        this.f2016h.setBounds(0, 0, this.f2025q, this.f2018j);
        canvas.translate(0.0f, i4 - i5);
        this.f2016h.draw(canvas);
        canvas.translate(i6 - (i7 / 2), 0.0f);
        this.f2015g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void n(Canvas canvas) {
        int i4 = this.f2025q;
        int i5 = this.f2013e;
        int i6 = i4 - i5;
        int i7 = this.f2020l;
        int i8 = this.f2019k;
        int i9 = i7 - (i8 / 2);
        this.f2011c.setBounds(0, 0, i5, i8);
        this.f2012d.setBounds(0, 0, this.f2014f, this.f2026r);
        if (s()) {
            this.f2012d.draw(canvas);
            canvas.translate(this.f2013e, i9);
            canvas.scale(-1.0f, 1.0f);
            this.f2011c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            i6 = this.f2013e;
        } else {
            canvas.translate(i6, 0.0f);
            this.f2012d.draw(canvas);
            canvas.translate(0.0f, i9);
            this.f2011c.draw(canvas);
        }
        canvas.translate(-i6, -i9);
    }

    private int[] o() {
        int[] iArr = this.f2033y;
        int i4 = this.f2010b;
        iArr[0] = i4;
        iArr[1] = this.f2025q - i4;
        return iArr;
    }

    private int[] p() {
        int[] iArr = this.f2032x;
        int i4 = this.f2010b;
        iArr[0] = i4;
        iArr[1] = this.f2026r - i4;
        return iArr;
    }

    private void r(float f4) {
        int[] o4 = o();
        float max = Math.max(o4[0], Math.min(o4[1], f4));
        if (Math.abs(this.f2023o - max) < 2.0f) {
            return;
        }
        int x4 = x(this.f2024p, max, o4, this.f2027s.computeHorizontalScrollRange(), this.f2027s.computeHorizontalScrollOffset(), this.f2025q);
        if (x4 != 0) {
            this.f2027s.scrollBy(x4, 0);
        }
        this.f2024p = max;
    }

    private boolean s() {
        return y.p.t(this.f2027s) == 1;
    }

    private void w(int i4) {
        k();
        this.f2027s.postDelayed(this.B, i4);
    }

    private int x(float f4, float f5, int[] iArr, int i4, int i5, int i6) {
        int i7 = iArr[1] - iArr[0];
        if (i7 == 0) {
            return 0;
        }
        int i8 = i4 - i6;
        int i9 = (int) (((f5 - f4) / i7) * i8);
        int i10 = i5 + i9;
        if (i10 >= i8 || i10 < 0) {
            return 0;
        }
        return i9;
    }

    private void z() {
        this.f2027s.addItemDecoration(this);
        this.f2027s.addOnItemTouchListener(this);
        this.f2027s.addOnScrollListener(this.C);
    }

    public void A() {
        int i4 = this.A;
        if (i4 != 0) {
            if (i4 != 3) {
                return;
            } else {
                this.f2034z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f2034z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f2034z.setDuration(500L);
        this.f2034z.setStartDelay(0L);
        this.f2034z.start();
    }

    void B(int i4, int i5) {
        int computeVerticalScrollRange = this.f2027s.computeVerticalScrollRange();
        int i6 = this.f2026r;
        this.f2028t = computeVerticalScrollRange - i6 > 0 && i6 >= this.f2009a;
        int computeHorizontalScrollRange = this.f2027s.computeHorizontalScrollRange();
        int i7 = this.f2025q;
        boolean z4 = computeHorizontalScrollRange - i7 > 0 && i7 >= this.f2009a;
        this.f2029u = z4;
        boolean z5 = this.f2028t;
        if (!z5 && !z4) {
            if (this.f2030v != 0) {
                y(0);
                return;
            }
            return;
        }
        if (z5) {
            float f4 = i6;
            this.f2020l = (int) ((f4 * (i5 + (f4 / 2.0f))) / computeVerticalScrollRange);
            this.f2019k = Math.min(i6, (i6 * i6) / computeVerticalScrollRange);
        }
        if (this.f2029u) {
            float f5 = i7;
            this.f2023o = (int) ((f5 * (i4 + (f5 / 2.0f))) / computeHorizontalScrollRange);
            this.f2022n = Math.min(i7, (i7 * i7) / computeHorizontalScrollRange);
        }
        int i8 = this.f2030v;
        if (i8 == 0 || i8 == 1) {
            y(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i4 = this.f2030v;
        if (i4 == 1) {
            boolean u4 = u(motionEvent.getX(), motionEvent.getY());
            boolean t4 = t(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!u4 && !t4) {
                return false;
            }
            if (t4) {
                this.f2031w = 1;
                this.f2024p = (int) motionEvent.getX();
            } else if (u4) {
                this.f2031w = 2;
                this.f2021m = (int) motionEvent.getY();
            }
            y(2);
        } else if (i4 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f2030v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean u4 = u(motionEvent.getX(), motionEvent.getY());
            boolean t4 = t(motionEvent.getX(), motionEvent.getY());
            if (u4 || t4) {
                if (t4) {
                    this.f2031w = 1;
                    this.f2024p = (int) motionEvent.getX();
                } else if (u4) {
                    this.f2031w = 2;
                    this.f2021m = (int) motionEvent.getY();
                }
                y(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f2030v == 2) {
            this.f2021m = 0.0f;
            this.f2024p = 0.0f;
            y(1);
            this.f2031w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f2030v == 2) {
            A();
            if (this.f2031w == 1) {
                r(motionEvent.getX());
            }
            if (this.f2031w == 2) {
                C(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void c(boolean z4) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.f2025q != this.f2027s.getWidth() || this.f2026r != this.f2027s.getHeight()) {
            this.f2025q = this.f2027s.getWidth();
            this.f2026r = this.f2027s.getHeight();
            y(0);
        } else if (this.A != 0) {
            if (this.f2028t) {
                n(canvas);
            }
            if (this.f2029u) {
                m(canvas);
            }
        }
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2027s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            l();
        }
        this.f2027s = recyclerView;
        if (recyclerView != null) {
            z();
        }
    }

    void q(int i4) {
        int i5 = this.A;
        if (i5 == 1) {
            this.f2034z.cancel();
        } else if (i5 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f2034z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f2034z.setDuration(i4);
        this.f2034z.start();
    }

    boolean t(float f4, float f5) {
        if (f5 >= this.f2026r - this.f2017i) {
            int i4 = this.f2023o;
            int i5 = this.f2022n;
            if (f4 >= i4 - (i5 / 2) && f4 <= i4 + (i5 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean u(float f4, float f5) {
        if (!s() ? f4 >= this.f2025q - this.f2013e : f4 <= this.f2013e / 2) {
            int i4 = this.f2020l;
            int i5 = this.f2019k;
            if (f5 >= i4 - (i5 / 2) && f5 <= i4 + (i5 / 2)) {
                return true;
            }
        }
        return false;
    }

    void v() {
        this.f2027s.invalidate();
    }

    void y(int i4) {
        int i5;
        if (i4 == 2 && this.f2030v != 2) {
            this.f2011c.setState(D);
            k();
        }
        if (i4 == 0) {
            v();
        } else {
            A();
        }
        if (this.f2030v != 2 || i4 == 2) {
            i5 = i4 == 1 ? 1500 : 1200;
            this.f2030v = i4;
        }
        this.f2011c.setState(E);
        w(i5);
        this.f2030v = i4;
    }
}
