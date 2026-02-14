package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import b1.n;
import java.util.ArrayList;
import java.util.Iterator;
import y.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    static final TimeInterpolator E = n0.a.f5240c;
    static final int[] F = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] G = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] H = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] I = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] J = {R.attr.state_enabled};
    static final int[] K = new int[0];
    private ViewTreeObserver.OnPreDrawListener D;

    /* renamed from: a, reason: collision with root package name */
    b1.k f3058a;

    /* renamed from: b, reason: collision with root package name */
    b1.g f3059b;

    /* renamed from: c, reason: collision with root package name */
    Drawable f3060c;

    /* renamed from: d, reason: collision with root package name */
    Drawable f3061d;

    /* renamed from: e, reason: collision with root package name */
    boolean f3062e;

    /* renamed from: g, reason: collision with root package name */
    float f3064g;

    /* renamed from: h, reason: collision with root package name */
    float f3065h;

    /* renamed from: i, reason: collision with root package name */
    float f3066i;

    /* renamed from: j, reason: collision with root package name */
    int f3067j;

    /* renamed from: k, reason: collision with root package name */
    private final com.google.android.material.internal.f f3068k;

    /* renamed from: l, reason: collision with root package name */
    private n0.h f3069l;

    /* renamed from: m, reason: collision with root package name */
    private n0.h f3070m;

    /* renamed from: n, reason: collision with root package name */
    private Animator f3071n;

    /* renamed from: o, reason: collision with root package name */
    private n0.h f3072o;

    /* renamed from: p, reason: collision with root package name */
    private n0.h f3073p;

    /* renamed from: q, reason: collision with root package name */
    private float f3074q;

    /* renamed from: s, reason: collision with root package name */
    private int f3076s;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f3078u;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f3079v;

    /* renamed from: w, reason: collision with root package name */
    private ArrayList<i> f3080w;

    /* renamed from: x, reason: collision with root package name */
    final FloatingActionButton f3081x;

    /* renamed from: y, reason: collision with root package name */
    final a1.b f3082y;

    /* renamed from: f, reason: collision with root package name */
    boolean f3063f = true;

    /* renamed from: r, reason: collision with root package name */
    private float f3075r = 1.0f;

    /* renamed from: t, reason: collision with root package name */
    private int f3077t = 0;

    /* renamed from: z, reason: collision with root package name */
    private final Rect f3083z = new Rect();
    private final RectF A = new RectF();
    private final RectF B = new RectF();
    private final Matrix C = new Matrix();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0030a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3084a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f3085b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f3086c;

        C0030a(boolean z4, j jVar) {
            this.f3085b = z4;
            this.f3086c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3084a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f3077t = 0;
            a.this.f3071n = null;
            if (this.f3084a) {
                return;
            }
            FloatingActionButton floatingActionButton = a.this.f3081x;
            boolean z4 = this.f3085b;
            floatingActionButton.b(z4 ? 8 : 4, z4);
            j jVar = this.f3086c;
            if (jVar != null) {
                jVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f3081x.b(0, this.f3085b);
            a.this.f3077t = 1;
            a.this.f3071n = animator;
            this.f3084a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3088a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f3089b;

        b(boolean z4, j jVar) {
            this.f3088a = z4;
            this.f3089b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f3077t = 0;
            a.this.f3071n = null;
            j jVar = this.f3089b;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f3081x.b(0, this.f3088a);
            a.this.f3077t = 2;
            a.this.f3071n = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends n0.g {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f4, Matrix matrix, Matrix matrix2) {
            a.this.f3075r = f4;
            return super.evaluate(f4, matrix, matrix2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements TypeEvaluator<Float> {

        /* renamed from: a, reason: collision with root package name */
        FloatEvaluator f3092a = new FloatEvaluator();

        d() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f4, Float f5, Float f6) {
            float floatValue = this.f3092a.evaluate(f4, (Number) f5, (Number) f6).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.F();
            return true;
        }
    }

    /* loaded from: classes.dex */
    private class f extends l {
        f() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.l
        protected float a() {
            return 0.0f;
        }
    }

    /* loaded from: classes.dex */
    private class g extends l {
        g() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.l
        protected float a() {
            a aVar = a.this;
            return aVar.f3064g + aVar.f3065h;
        }
    }

    /* loaded from: classes.dex */
    private class h extends l {
        h() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.l
        protected float a() {
            a aVar = a.this;
            return aVar.f3064g + aVar.f3066i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface i {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface j {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    private class k extends l {
        k() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.l
        protected float a() {
            return a.this.f3064g;
        }
    }

    /* loaded from: classes.dex */
    private abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3099a;

        /* renamed from: b, reason: collision with root package name */
        private float f3100b;

        /* renamed from: c, reason: collision with root package name */
        private float f3101c;

        private l() {
        }

        /* synthetic */ l(a aVar, C0030a c0030a) {
            this();
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.c0((int) this.f3101c);
            this.f3099a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f3099a) {
                b1.g gVar = a.this.f3059b;
                this.f3100b = gVar == null ? 0.0f : gVar.w();
                this.f3101c = a();
                this.f3099a = true;
            }
            a aVar = a.this;
            float f4 = this.f3100b;
            aVar.c0((int) (f4 + ((this.f3101c - f4) * valueAnimator.getAnimatedFraction())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FloatingActionButton floatingActionButton, a1.b bVar) {
        this.f3081x = floatingActionButton;
        this.f3082y = bVar;
        com.google.android.material.internal.f fVar = new com.google.android.material.internal.f();
        this.f3068k = fVar;
        fVar.a(F, i(new h()));
        fVar.a(G, i(new g()));
        fVar.a(H, i(new g()));
        fVar.a(I, i(new g()));
        fVar.a(J, i(new k()));
        fVar.a(K, i(new f()));
        this.f3074q = floatingActionButton.getRotation();
    }

    private boolean W() {
        return p.H(this.f3081x) && !this.f3081x.isInEditMode();
    }

    private void d0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new d());
    }

    private void g(float f4, Matrix matrix) {
        matrix.reset();
        if (this.f3081x.getDrawable() == null || this.f3076s == 0) {
            return;
        }
        RectF rectF = this.A;
        RectF rectF2 = this.B;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i4 = this.f3076s;
        rectF2.set(0.0f, 0.0f, i4, i4);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i5 = this.f3076s;
        matrix.postScale(f4, f4, i5 / 2.0f, i5 / 2.0f);
    }

    private AnimatorSet h(n0.h hVar, float f4, float f5, float f6) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3081x, (Property<FloatingActionButton, Float>) View.ALPHA, f4);
        hVar.e("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f3081x, (Property<FloatingActionButton, Float>) View.SCALE_X, f5);
        hVar.e("scale").a(ofFloat2);
        d0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f3081x, (Property<FloatingActionButton, Float>) View.SCALE_Y, f5);
        hVar.e("scale").a(ofFloat3);
        d0(ofFloat3);
        arrayList.add(ofFloat3);
        g(f6, this.C);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f3081x, new n0.f(), new c(), new Matrix(this.C));
        hVar.e("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        n0.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private ValueAnimator i(l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(E);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private n0.h k() {
        if (this.f3070m == null) {
            this.f3070m = n0.h.c(this.f3081x.getContext(), m0.a.f4929a);
        }
        return (n0.h) x.h.c(this.f3070m);
    }

    private n0.h l() {
        if (this.f3069l == null) {
            this.f3069l = n0.h.c(this.f3081x.getContext(), m0.a.f4930b);
        }
        return (n0.h) x.h.c(this.f3069l);
    }

    private ViewTreeObserver.OnPreDrawListener q() {
        if (this.D == null) {
            this.D = new e();
        }
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        ViewTreeObserver viewTreeObserver = this.f3081x.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.D;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.D = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int[] iArr) {
        throw null;
    }

    void D(float f4, float f5, float f6) {
        throw null;
    }

    void E(Rect rect) {
        a1.b bVar;
        Drawable drawable;
        x.h.d(this.f3061d, "Didn't initialize content background");
        if (V()) {
            drawable = new InsetDrawable(this.f3061d, rect.left, rect.top, rect.right, rect.bottom);
            bVar = this.f3082y;
        } else {
            bVar = this.f3082y;
            drawable = this.f3061d;
        }
        bVar.c(drawable);
    }

    void F() {
        float rotation = this.f3081x.getRotation();
        if (this.f3074q != rotation) {
            this.f3074q = rotation;
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        ArrayList<i> arrayList = this.f3080w;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        ArrayList<i> arrayList = this.f3080w;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    boolean I() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(ColorStateList colorStateList) {
        b1.g gVar = this.f3059b;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(PorterDuff.Mode mode) {
        b1.g gVar = this.f3059b;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void L(float f4) {
        if (this.f3064g != f4) {
            this.f3064g = f4;
            D(f4, this.f3065h, this.f3066i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(boolean z4) {
        this.f3062e = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(n0.h hVar) {
        this.f3073p = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(float f4) {
        if (this.f3065h != f4) {
            this.f3065h = f4;
            D(this.f3064g, f4, this.f3066i);
        }
    }

    final void P(float f4) {
        this.f3075r = f4;
        Matrix matrix = this.C;
        g(f4, matrix);
        this.f3081x.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(float f4) {
        if (this.f3066i != f4) {
            this.f3066i = f4;
            D(this.f3064g, this.f3065h, f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(ColorStateList colorStateList) {
        Drawable drawable = this.f3060c;
        if (drawable != null) {
            r.a.j(drawable, z0.b.a(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(boolean z4) {
        this.f3063f = z4;
        b0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void T(b1.k kVar) {
        this.f3058a = kVar;
        b1.g gVar = this.f3059b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        Object obj = this.f3060c;
        if (obj instanceof n) {
            ((n) obj).setShapeAppearanceModel(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void U(n0.h hVar) {
        this.f3072o = hVar;
    }

    boolean V() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean X() {
        return !this.f3062e || this.f3081x.getSizeDimension() >= this.f3067j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(j jVar, boolean z4) {
        if (x()) {
            return;
        }
        Animator animator = this.f3071n;
        if (animator != null) {
            animator.cancel();
        }
        if (!W()) {
            this.f3081x.b(0, z4);
            this.f3081x.setAlpha(1.0f);
            this.f3081x.setScaleY(1.0f);
            this.f3081x.setScaleX(1.0f);
            P(1.0f);
            if (jVar != null) {
                jVar.a();
                return;
            }
            return;
        }
        if (this.f3081x.getVisibility() != 0) {
            this.f3081x.setAlpha(0.0f);
            this.f3081x.setScaleY(0.0f);
            this.f3081x.setScaleX(0.0f);
            P(0.0f);
        }
        n0.h hVar = this.f3072o;
        if (hVar == null) {
            hVar = l();
        }
        AnimatorSet h4 = h(hVar, 1.0f, 1.0f, 1.0f);
        h4.addListener(new b(z4, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f3078u;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                h4.addListener(it.next());
            }
        }
        h4.start();
    }

    void Z() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a0() {
        P(this.f3075r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b0() {
        Rect rect = this.f3083z;
        r(rect);
        E(rect);
        this.f3082y.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(float f4) {
        b1.g gVar = this.f3059b;
        if (gVar != null) {
            gVar.U(f4);
        }
    }

    public void d(Animator.AnimatorListener animatorListener) {
        if (this.f3079v == null) {
            this.f3079v = new ArrayList<>();
        }
        this.f3079v.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Animator.AnimatorListener animatorListener) {
        if (this.f3078u == null) {
            this.f3078u = new ArrayList<>();
        }
        this.f3078u.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (this.f3080w == null) {
            this.f3080w = new ArrayList<>();
        }
        this.f3080w.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable j() {
        return this.f3061d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float m() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f3062e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n0.h o() {
        return this.f3073p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p() {
        return this.f3065h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Rect rect) {
        int sizeDimension = this.f3062e ? (this.f3067j - this.f3081x.getSizeDimension()) / 2 : 0;
        int max = Math.max(sizeDimension, (int) Math.ceil(this.f3063f ? m() + this.f3066i : 0.0f));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float s() {
        return this.f3066i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b1.k t() {
        return this.f3058a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n0.h u() {
        return this.f3072o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(j jVar, boolean z4) {
        if (w()) {
            return;
        }
        Animator animator = this.f3071n;
        if (animator != null) {
            animator.cancel();
        }
        if (!W()) {
            this.f3081x.b(z4 ? 8 : 4, z4);
            if (jVar != null) {
                jVar.b();
                return;
            }
            return;
        }
        n0.h hVar = this.f3073p;
        if (hVar == null) {
            hVar = k();
        }
        AnimatorSet h4 = h(hVar, 0.0f, 0.0f, 0.0f);
        h4.addListener(new C0030a(z4, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f3079v;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                h4.addListener(it.next());
            }
        }
        h4.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.f3081x.getVisibility() == 0 ? this.f3077t == 1 : this.f3077t != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return this.f3081x.getVisibility() != 0 ? this.f3077t == 2 : this.f3077t != 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        b1.g gVar = this.f3059b;
        if (gVar != null) {
            b1.h.f(this.f3081x, gVar);
        }
        if (I()) {
            this.f3081x.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }
}
