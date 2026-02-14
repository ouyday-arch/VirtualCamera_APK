package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.k;
import c0.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import m0.j;
import y.p;
import z.c;
import z.f;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    private static final int M = j.f5037c;
    private boolean A;
    int B;
    int C;
    WeakReference<V> D;
    WeakReference<View> E;
    private final ArrayList<e> F;
    private VelocityTracker G;
    int H;
    private int I;
    boolean J;
    private Map<View, Integer> K;
    private final c.AbstractC0023c L;

    /* renamed from: a, reason: collision with root package name */
    private int f2787a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2788b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2789c;

    /* renamed from: d, reason: collision with root package name */
    private float f2790d;

    /* renamed from: e, reason: collision with root package name */
    private int f2791e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2792f;

    /* renamed from: g, reason: collision with root package name */
    private int f2793g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2794h;

    /* renamed from: i, reason: collision with root package name */
    private b1.g f2795i;

    /* renamed from: j, reason: collision with root package name */
    private k f2796j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2797k;

    /* renamed from: l, reason: collision with root package name */
    private BottomSheetBehavior<V>.g f2798l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f2799m;

    /* renamed from: n, reason: collision with root package name */
    int f2800n;

    /* renamed from: o, reason: collision with root package name */
    int f2801o;

    /* renamed from: p, reason: collision with root package name */
    int f2802p;

    /* renamed from: q, reason: collision with root package name */
    float f2803q;

    /* renamed from: r, reason: collision with root package name */
    int f2804r;

    /* renamed from: s, reason: collision with root package name */
    float f2805s;

    /* renamed from: t, reason: collision with root package name */
    boolean f2806t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f2807u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f2808v;

    /* renamed from: w, reason: collision with root package name */
    int f2809w;

    /* renamed from: x, reason: collision with root package name */
    c0.c f2810x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f2811y;

    /* renamed from: z, reason: collision with root package name */
    private int f2812z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2813b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2814c;

        a(View view, int i4) {
            this.f2813b = view;
            this.f2814c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.h0(this.f2813b, this.f2814c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f2795i != null) {
                BottomSheetBehavior.this.f2795i.W(floatValue);
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends c.AbstractC0023c {
        c() {
        }

        private boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.C + bottomSheetBehavior.S()) / 2;
        }

        @Override // c0.c.AbstractC0023c
        public int a(View view, int i4, int i5) {
            return view.getLeft();
        }

        @Override // c0.c.AbstractC0023c
        public int b(View view, int i4, int i5) {
            int S = BottomSheetBehavior.this.S();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return t.a.b(i4, S, bottomSheetBehavior.f2806t ? bottomSheetBehavior.C : bottomSheetBehavior.f2804r);
        }

        @Override // c0.c.AbstractC0023c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.f2806t ? bottomSheetBehavior.C : bottomSheetBehavior.f2804r;
        }

        @Override // c0.c.AbstractC0023c
        public void j(int i4) {
            if (i4 == 1 && BottomSheetBehavior.this.f2808v) {
                BottomSheetBehavior.this.g0(1);
            }
        }

        @Override // c0.c.AbstractC0023c
        public void k(View view, int i4, int i5, int i6, int i7) {
            BottomSheetBehavior.this.Q(i5);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
        
            if (java.lang.Math.abs(r7.getTop() - r6.f2817a.f2800n) < java.lang.Math.abs(r7.getTop() - r6.f2817a.f2802p)) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
        
            r8 = r6.f2817a.f2800n;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
        
            if (java.lang.Math.abs(r8 - r6.f2817a.f2802p) < java.lang.Math.abs(r8 - r6.f2817a.f2804r)) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d8, code lost:
        
            if (java.lang.Math.abs(r8 - r6.f2817a.f2801o) < java.lang.Math.abs(r8 - r6.f2817a.f2804r)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ea, code lost:
        
            if (r8 < java.lang.Math.abs(r8 - r9.f2804r)) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00fc, code lost:
        
            if (java.lang.Math.abs(r8 - r0) < java.lang.Math.abs(r8 - r6.f2817a.f2804r)) goto L39;
         */
        @Override // c0.c.AbstractC0023c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r7, float r8, float r9) {
            /*
                Method dump skipped, instructions count: 262
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.l(android.view.View, float, float):void");
        }

        @Override // c0.c.AbstractC0023c
        public boolean m(View view, int i4) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i5 = bottomSheetBehavior.f2809w;
            if (i5 == 1 || bottomSheetBehavior.J) {
                return false;
            }
            if (i5 == 3 && bottomSheetBehavior.H == i4) {
                WeakReference<View> weakReference = bottomSheetBehavior.E;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.D;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements z.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f2818a;

        d(int i4) {
            this.f2818a = i4;
        }

        @Override // z.f
        public boolean a(View view, f.a aVar) {
            BottomSheetBehavior.this.f0(this.f2818a);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
        public abstract void a(View view, float f4);

        public abstract void b(View view, int i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class f extends b0.a {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        final int f2820d;

        /* renamed from: e, reason: collision with root package name */
        int f2821e;

        /* renamed from: f, reason: collision with root package name */
        boolean f2822f;

        /* renamed from: g, reason: collision with root package name */
        boolean f2823g;

        /* renamed from: h, reason: collision with root package name */
        boolean f2824h;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i4) {
                return new f[i4];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2820d = parcel.readInt();
            this.f2821e = parcel.readInt();
            this.f2822f = parcel.readInt() == 1;
            this.f2823g = parcel.readInt() == 1;
            this.f2824h = parcel.readInt() == 1;
        }

        public f(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f2820d = bottomSheetBehavior.f2809w;
            this.f2821e = ((BottomSheetBehavior) bottomSheetBehavior).f2791e;
            this.f2822f = ((BottomSheetBehavior) bottomSheetBehavior).f2788b;
            this.f2823g = bottomSheetBehavior.f2806t;
            this.f2824h = ((BottomSheetBehavior) bottomSheetBehavior).f2807u;
        }

        @Override // b0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f2820d);
            parcel.writeInt(this.f2821e);
            parcel.writeInt(this.f2822f ? 1 : 0);
            parcel.writeInt(this.f2823g ? 1 : 0);
            parcel.writeInt(this.f2824h ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final View f2825b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f2826c;

        /* renamed from: d, reason: collision with root package name */
        int f2827d;

        g(View view, int i4) {
            this.f2825b = view;
            this.f2827d = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.c cVar = BottomSheetBehavior.this.f2810x;
            if (cVar == null || !cVar.k(true)) {
                BottomSheetBehavior.this.g0(this.f2827d);
            } else {
                p.T(this.f2825b, this);
            }
            this.f2826c = false;
        }
    }

    public BottomSheetBehavior() {
        this.f2787a = 0;
        this.f2788b = true;
        this.f2789c = false;
        this.f2798l = null;
        this.f2803q = 0.5f;
        this.f2805s = -1.0f;
        this.f2808v = true;
        this.f2809w = 4;
        this.F = new ArrayList<>();
        this.L = new c();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i4;
        this.f2787a = 0;
        this.f2788b = true;
        this.f2789c = false;
        this.f2798l = null;
        this.f2803q = 0.5f;
        this.f2805s = -1.0f;
        this.f2808v = true;
        this.f2809w = 4;
        this.F = new ArrayList<>();
        this.L = new c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.k.f5169x);
        this.f2794h = obtainStyledAttributes.hasValue(m0.k.I);
        int i5 = m0.k.f5179z;
        boolean hasValue = obtainStyledAttributes.hasValue(i5);
        if (hasValue) {
            O(context, attributeSet, hasValue, y0.c.a(context, obtainStyledAttributes, i5));
        } else {
            N(context, attributeSet, hasValue);
        }
        P();
        this.f2805s = obtainStyledAttributes.getDimension(m0.k.f5174y, -1.0f);
        int i6 = m0.k.F;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i6);
        if (peekValue == null || (i4 = peekValue.data) != -1) {
            b0(obtainStyledAttributes.getDimensionPixelSize(i6, -1));
        } else {
            b0(i4);
        }
        a0(obtainStyledAttributes.getBoolean(m0.k.E, false));
        Y(obtainStyledAttributes.getBoolean(m0.k.C, true));
        e0(obtainStyledAttributes.getBoolean(m0.k.H, false));
        W(obtainStyledAttributes.getBoolean(m0.k.A, true));
        d0(obtainStyledAttributes.getInt(m0.k.G, 0));
        Z(obtainStyledAttributes.getFloat(m0.k.D, 0.5f));
        int i7 = m0.k.B;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i7);
        X((peekValue2 == null || peekValue2.type != 16) ? obtainStyledAttributes.getDimensionPixelOffset(i7, 0) : peekValue2.data);
        obtainStyledAttributes.recycle();
        this.f2790d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void J(V v4, c.a aVar, int i4) {
        p.X(v4, aVar, null, new d(i4));
    }

    private void K() {
        int M2 = M();
        if (this.f2788b) {
            this.f2804r = Math.max(this.C - M2, this.f2801o);
        } else {
            this.f2804r = this.C - M2;
        }
    }

    private void L() {
        this.f2802p = (int) (this.C * (1.0f - this.f2803q));
    }

    private int M() {
        return this.f2792f ? Math.max(this.f2793g, this.C - ((this.B * 9) / 16)) : this.f2791e;
    }

    private void N(Context context, AttributeSet attributeSet, boolean z4) {
        O(context, attributeSet, z4, null);
    }

    private void O(Context context, AttributeSet attributeSet, boolean z4, ColorStateList colorStateList) {
        if (this.f2794h) {
            this.f2796j = k.e(context, attributeSet, m0.b.f4934b, M).m();
            b1.g gVar = new b1.g(this.f2796j);
            this.f2795i = gVar;
            gVar.M(context);
            if (z4 && colorStateList != null) {
                this.f2795i.V(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.f2795i.setTint(typedValue.data);
        }
    }

    private void P() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2799m = ofFloat;
        ofFloat.setDuration(500L);
        this.f2799m.addUpdateListener(new b());
    }

    private float T() {
        VelocityTracker velocityTracker = this.G;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f2790d);
        return this.G.getYVelocity(this.H);
    }

    private void U() {
        this.H = -1;
        VelocityTracker velocityTracker = this.G;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.G = null;
        }
    }

    private void V(f fVar) {
        int i4 = this.f2787a;
        if (i4 == 0) {
            return;
        }
        if (i4 == -1 || (i4 & 1) == 1) {
            this.f2791e = fVar.f2821e;
        }
        if (i4 == -1 || (i4 & 2) == 2) {
            this.f2788b = fVar.f2822f;
        }
        if (i4 == -1 || (i4 & 4) == 4) {
            this.f2806t = fVar.f2823g;
        }
        if (i4 == -1 || (i4 & 8) == 8) {
            this.f2807u = fVar.f2824h;
        }
    }

    private void i0(int i4) {
        V v4 = this.D.get();
        if (v4 == null) {
            return;
        }
        ViewParent parent = v4.getParent();
        if (parent != null && parent.isLayoutRequested() && p.G(v4)) {
            v4.post(new a(v4, i4));
        } else {
            h0(v4, i4);
        }
    }

    private void l0() {
        V v4;
        int i4;
        c.a aVar;
        WeakReference<V> weakReference = this.D;
        if (weakReference == null || (v4 = weakReference.get()) == null) {
            return;
        }
        p.V(v4, 524288);
        p.V(v4, 262144);
        p.V(v4, 1048576);
        if (this.f2806t && this.f2809w != 5) {
            J(v4, c.a.f6636y, 5);
        }
        int i5 = this.f2809w;
        if (i5 == 3) {
            i4 = this.f2788b ? 4 : 6;
            aVar = c.a.f6635x;
        } else {
            if (i5 != 4) {
                if (i5 != 6) {
                    return;
                }
                J(v4, c.a.f6635x, 4);
                J(v4, c.a.f6634w, 3);
                return;
            }
            i4 = this.f2788b ? 3 : 6;
            aVar = c.a.f6634w;
        }
        J(v4, aVar, i4);
    }

    private void m0(int i4) {
        ValueAnimator valueAnimator;
        if (i4 == 2) {
            return;
        }
        boolean z4 = i4 == 3;
        if (this.f2797k != z4) {
            this.f2797k = z4;
            if (this.f2795i == null || (valueAnimator = this.f2799m) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.f2799m.reverse();
                return;
            }
            float f4 = z4 ? 0.0f : 1.0f;
            this.f2799m.setFloatValues(1.0f - f4, f4);
            this.f2799m.start();
        }
    }

    private void n0(boolean z4) {
        Map<View, Integer> map;
        int intValue;
        WeakReference<V> weakReference = this.D;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z4) {
                if (this.K != null) {
                    return;
                } else {
                    this.K = new HashMap(childCount);
                }
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = coordinatorLayout.getChildAt(i4);
                if (childAt != this.D.get()) {
                    if (z4) {
                        this.K.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f2789c) {
                            intValue = 4;
                            p.j0(childAt, intValue);
                        }
                    } else if (this.f2789c && (map = this.K) != null && map.containsKey(childAt)) {
                        intValue = this.K.get(childAt).intValue();
                        p.j0(childAt, intValue);
                    }
                }
            }
            if (z4) {
                return;
            }
            this.K = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v4, View view, View view2, int i4, int i5) {
        this.f2812z = 0;
        this.A = false;
        return (i4 & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        if (java.lang.Math.abs(r3 - r2.f2801o) < java.lang.Math.abs(r3 - r2.f2804r)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        if (r3 < java.lang.Math.abs(r3 - r2.f2804r)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
    
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.f2804r)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a6, code lost:
    
        if (java.lang.Math.abs(r3 - r2.f2802p) < java.lang.Math.abs(r3 - r2.f2804r)) goto L47;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.S()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.g0(r0)
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r3 = r2.E
            if (r3 == 0) goto Lb1
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb1
            boolean r3 = r2.A
            if (r3 != 0) goto L1f
            goto Lb1
        L1f:
            int r3 = r2.f2812z
            r5 = 4
            r6 = 6
            if (r3 <= 0) goto L3c
            boolean r3 = r2.f2788b
            if (r3 == 0) goto L2d
        L29:
            int r3 = r2.f2801o
            goto Lab
        L2d:
            int r3 = r4.getTop()
            int r5 = r2.f2802p
            if (r3 <= r5) goto L38
            r3 = r5
            goto Laa
        L38:
            int r3 = r2.f2800n
            goto Lab
        L3c:
            boolean r3 = r2.f2806t
            if (r3 == 0) goto L4e
            float r3 = r2.T()
            boolean r3 = r2.j0(r4, r3)
            if (r3 == 0) goto L4e
            int r3 = r2.C
            r0 = 5
            goto Lab
        L4e:
            int r3 = r2.f2812z
            if (r3 != 0) goto L8b
            int r3 = r4.getTop()
            boolean r1 = r2.f2788b
            if (r1 == 0) goto L6c
            int r6 = r2.f2801o
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            int r1 = r2.f2804r
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r6 >= r3) goto L8f
            goto L29
        L6c:
            int r1 = r2.f2802p
            if (r3 >= r1) goto L7b
            int r5 = r2.f2804r
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            if (r3 >= r5) goto La8
            goto L38
        L7b:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f2804r
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L8f
            goto La8
        L8b:
            boolean r3 = r2.f2788b
            if (r3 == 0) goto L93
        L8f:
            int r3 = r2.f2804r
            r0 = r5
            goto Lab
        L93:
            int r3 = r4.getTop()
            int r0 = r2.f2802p
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f2804r
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L8f
        La8:
            int r3 = r2.f2802p
        Laa:
            r0 = r6
        Lab:
            r5 = 0
            r2.k0(r4, r0, r3, r5)
            r2.A = r5
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v4, MotionEvent motionEvent) {
        if (!v4.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f2809w == 1 && actionMasked == 0) {
            return true;
        }
        c0.c cVar = this.f2810x;
        if (cVar != null) {
            cVar.z(motionEvent);
        }
        if (actionMasked == 0) {
            U();
        }
        if (this.G == null) {
            this.G = VelocityTracker.obtain();
        }
        this.G.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f2811y && Math.abs(this.I - motionEvent.getY()) > this.f2810x.u()) {
            this.f2810x.b(v4, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f2811y;
    }

    void Q(int i4) {
        float f4;
        float f5;
        V v4 = this.D.get();
        if (v4 == null || this.F.isEmpty()) {
            return;
        }
        int i5 = this.f2804r;
        if (i4 > i5 || i5 == S()) {
            int i6 = this.f2804r;
            f4 = i6 - i4;
            f5 = this.C - i6;
        } else {
            int i7 = this.f2804r;
            f4 = i7 - i4;
            f5 = i7 - S();
        }
        float f6 = f4 / f5;
        for (int i8 = 0; i8 < this.F.size(); i8++) {
            this.F.get(i8).a(v4, f6);
        }
    }

    View R(View view) {
        if (p.I(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View R = R(viewGroup.getChildAt(i4));
            if (R != null) {
                return R;
            }
        }
        return null;
    }

    public int S() {
        return this.f2788b ? this.f2801o : this.f2800n;
    }

    public void W(boolean z4) {
        this.f2808v = z4;
    }

    public void X(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f2800n = i4;
    }

    public void Y(boolean z4) {
        if (this.f2788b == z4) {
            return;
        }
        this.f2788b = z4;
        if (this.D != null) {
            K();
        }
        g0((this.f2788b && this.f2809w == 6) ? 3 : this.f2809w);
        l0();
    }

    public void Z(float f4) {
        if (f4 <= 0.0f || f4 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.f2803q = f4;
        if (this.D != null) {
            L();
        }
    }

    public void a0(boolean z4) {
        if (this.f2806t != z4) {
            this.f2806t = z4;
            if (!z4 && this.f2809w == 5) {
                f0(4);
            }
            l0();
        }
    }

    public void b0(int i4) {
        c0(i4, false);
    }

    public final void c0(int i4, boolean z4) {
        V v4;
        boolean z5 = true;
        if (i4 == -1) {
            if (!this.f2792f) {
                this.f2792f = true;
            }
            z5 = false;
        } else {
            if (this.f2792f || this.f2791e != i4) {
                this.f2792f = false;
                this.f2791e = Math.max(0, i4);
            }
            z5 = false;
        }
        if (!z5 || this.D == null) {
            return;
        }
        K();
        if (this.f2809w != 4 || (v4 = this.D.get()) == null) {
            return;
        }
        if (z4) {
            i0(this.f2809w);
        } else {
            v4.requestLayout();
        }
    }

    public void d0(int i4) {
        this.f2787a = i4;
    }

    public void e0(boolean z4) {
        this.f2807u = z4;
    }

    public void f0(int i4) {
        if (i4 == this.f2809w) {
            return;
        }
        if (this.D != null) {
            i0(i4);
            return;
        }
        if (i4 == 4 || i4 == 3 || i4 == 6 || (this.f2806t && i4 == 5)) {
            this.f2809w = i4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.D = null;
        this.f2810x = null;
    }

    void g0(int i4) {
        V v4;
        if (this.f2809w == i4) {
            return;
        }
        this.f2809w = i4;
        WeakReference<V> weakReference = this.D;
        if (weakReference == null || (v4 = weakReference.get()) == null) {
            return;
        }
        if (i4 == 3) {
            n0(true);
        } else if (i4 == 6 || i4 == 5 || i4 == 4) {
            n0(false);
        }
        m0(i4);
        for (int i5 = 0; i5 < this.F.size(); i5++) {
            this.F.get(i5).b(v4, i4);
        }
        l0();
    }

    void h0(View view, int i4) {
        int i5;
        int i6;
        if (i4 == 4) {
            i5 = this.f2804r;
        } else if (i4 == 6) {
            int i7 = this.f2802p;
            if (!this.f2788b || i7 > (i6 = this.f2801o)) {
                i5 = i7;
            } else {
                i4 = 3;
                i5 = i6;
            }
        } else if (i4 == 3) {
            i5 = S();
        } else {
            if (!this.f2806t || i4 != 5) {
                throw new IllegalArgumentException("Illegal state argument: " + i4);
            }
            i5 = this.C;
        }
        k0(view, i4, i5, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.D = null;
        this.f2810x = null;
    }

    boolean j0(View view, float f4) {
        if (this.f2807u) {
            return true;
        }
        if (view.getTop() < this.f2804r) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f4 * 0.1f)) - ((float) this.f2804r)) / ((float) M()) > 0.5f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v4, MotionEvent motionEvent) {
        c0.c cVar;
        if (!v4.isShown() || !this.f2808v) {
            this.f2811y = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            U();
        }
        if (this.G == null) {
            this.G = VelocityTracker.obtain();
        }
        this.G.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x4 = (int) motionEvent.getX();
            this.I = (int) motionEvent.getY();
            if (this.f2809w != 2) {
                WeakReference<View> weakReference = this.E;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.C(view, x4, this.I)) {
                    this.H = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.J = true;
                }
            }
            this.f2811y = this.H == -1 && !coordinatorLayout.C(v4, x4, this.I);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.J = false;
            this.H = -1;
            if (this.f2811y) {
                this.f2811y = false;
                return false;
            }
        }
        if (!this.f2811y && (cVar = this.f2810x) != null && cVar.G(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.E;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.f2811y || this.f2809w == 1 || coordinatorLayout.C(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f2810x == null || Math.abs(((float) this.I) - motionEvent.getY()) <= ((float) this.f2810x.u())) ? false : true;
    }

    void k0(View view, int i4, int i5, boolean z4) {
        if (!(z4 ? this.f2810x.F(view.getLeft(), i5) : this.f2810x.H(view, view.getLeft(), i5))) {
            g0(i4);
            return;
        }
        g0(2);
        m0(i4);
        if (this.f2798l == null) {
            this.f2798l = new g(view, i4);
        }
        if (((g) this.f2798l).f2826c) {
            this.f2798l.f2827d = i4;
            return;
        }
        BottomSheetBehavior<V>.g gVar = this.f2798l;
        gVar.f2827d = i4;
        p.T(view, gVar);
        ((g) this.f2798l).f2826c = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v4, int i4) {
        int i5;
        b1.g gVar;
        if (p.q(coordinatorLayout) && !p.q(v4)) {
            v4.setFitsSystemWindows(true);
        }
        if (this.D == null) {
            this.f2793g = coordinatorLayout.getResources().getDimensionPixelSize(m0.d.f4965b);
            this.D = new WeakReference<>(v4);
            if (this.f2794h && (gVar = this.f2795i) != null) {
                p.d0(v4, gVar);
            }
            b1.g gVar2 = this.f2795i;
            if (gVar2 != null) {
                float f4 = this.f2805s;
                if (f4 == -1.0f) {
                    f4 = p.p(v4);
                }
                gVar2.U(f4);
                boolean z4 = this.f2809w == 3;
                this.f2797k = z4;
                this.f2795i.W(z4 ? 0.0f : 1.0f);
            }
            l0();
            if (p.r(v4) == 0) {
                p.j0(v4, 1);
            }
        }
        if (this.f2810x == null) {
            this.f2810x = c0.c.m(coordinatorLayout, this.L);
        }
        int top = v4.getTop();
        coordinatorLayout.J(v4, i4);
        this.B = coordinatorLayout.getWidth();
        int height = coordinatorLayout.getHeight();
        this.C = height;
        this.f2801o = Math.max(0, height - v4.getHeight());
        L();
        K();
        int i6 = this.f2809w;
        if (i6 == 3) {
            i5 = S();
        } else if (i6 == 6) {
            i5 = this.f2802p;
        } else if (this.f2806t && i6 == 5) {
            i5 = this.C;
        } else {
            if (i6 != 4) {
                if (i6 == 1 || i6 == 2) {
                    p.N(v4, top - v4.getTop());
                }
                this.E = new WeakReference<>(R(v4));
                return true;
            }
            i5 = this.f2804r;
        }
        p.N(v4, i5);
        this.E = new WeakReference<>(R(v4));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V v4, View view, float f4, float f5) {
        WeakReference<View> weakReference = this.E;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.f2809w != 3 || super.o(coordinatorLayout, v4, view, f4, f5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int[] iArr, int i6) {
        int i7;
        if (i6 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.E;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v4.getTop();
        int i8 = top - i5;
        if (i5 > 0) {
            if (i8 < S()) {
                iArr[1] = top - S();
                p.N(v4, -iArr[1]);
                i7 = 3;
                g0(i7);
            } else {
                if (!this.f2808v) {
                    return;
                }
                iArr[1] = i5;
                p.N(v4, -i5);
                g0(1);
            }
        } else if (i5 < 0 && !view.canScrollVertically(-1)) {
            int i9 = this.f2804r;
            if (i8 > i9 && !this.f2806t) {
                iArr[1] = top - i9;
                p.N(v4, -iArr[1]);
                i7 = 4;
                g0(i7);
            } else {
                if (!this.f2808v) {
                    return;
                }
                iArr[1] = i5;
                p.N(v4, -i5);
                g0(1);
            }
        }
        Q(v4.getTop());
        this.f2812z = i5;
        this.A = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, V v4, Parcelable parcelable) {
        f fVar = (f) parcelable;
        super.x(coordinatorLayout, v4, fVar.f());
        V(fVar);
        int i4 = fVar.f2820d;
        if (i4 == 1 || i4 == 2) {
            i4 = 4;
        }
        this.f2809w = i4;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout coordinatorLayout, V v4) {
        return new f(super.y(coordinatorLayout, v4), (BottomSheetBehavior<?>) this);
    }
}
