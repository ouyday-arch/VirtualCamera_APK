package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.g;
import b1.h;
import java.lang.ref.WeakReference;
import java.util.List;
import m0.j;
import m0.k;
import y.i;
import y.p;
import y.x;
import z.c;
import z.f;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: s, reason: collision with root package name */
    private static final int f2664s = j.f5036b;

    /* renamed from: b, reason: collision with root package name */
    private int f2665b;

    /* renamed from: c, reason: collision with root package name */
    private int f2666c;

    /* renamed from: d, reason: collision with root package name */
    private int f2667d;

    /* renamed from: e, reason: collision with root package name */
    private int f2668e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2669f;

    /* renamed from: g, reason: collision with root package name */
    private int f2670g;

    /* renamed from: h, reason: collision with root package name */
    private x f2671h;

    /* renamed from: i, reason: collision with root package name */
    private List<b> f2672i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2673j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2674k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2675l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2676m;

    /* renamed from: n, reason: collision with root package name */
    private int f2677n;

    /* renamed from: o, reason: collision with root package name */
    private WeakReference<View> f2678o;

    /* renamed from: p, reason: collision with root package name */
    private ValueAnimator f2679p;

    /* renamed from: q, reason: collision with root package name */
    private int[] f2680q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f2681r;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a<T> {

        /* renamed from: k, reason: collision with root package name */
        private int f2682k;

        /* renamed from: l, reason: collision with root package name */
        private int f2683l;

        /* renamed from: m, reason: collision with root package name */
        private ValueAnimator f2684m;

        /* renamed from: n, reason: collision with root package name */
        private int f2685n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f2686o;

        /* renamed from: p, reason: collision with root package name */
        private float f2687p;

        /* renamed from: q, reason: collision with root package name */
        private WeakReference<View> f2688q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f2689a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f2690b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f2689a = coordinatorLayout;
                this.f2690b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.f2689a, this.f2690b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f2692a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f2693b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f2694c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f2695d;

            b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i4) {
                this.f2692a = coordinatorLayout;
                this.f2693b = appBarLayout;
                this.f2694c = view;
                this.f2695d = i4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // z.f
            public boolean a(View view, f.a aVar) {
                BaseBehavior.this.q(this.f2692a, this.f2693b, this.f2694c, 0, this.f2695d, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f2697a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f2698b;

            c(AppBarLayout appBarLayout, boolean z4) {
                this.f2697a = appBarLayout;
                this.f2698b = z4;
            }

            @Override // z.f
            public boolean a(View view, f.a aVar) {
                this.f2697a.setExpanded(this.f2698b);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes.dex */
        public static class d extends b0.a {
            public static final Parcelable.Creator<d> CREATOR = new a();

            /* renamed from: d, reason: collision with root package name */
            int f2700d;

            /* renamed from: e, reason: collision with root package name */
            float f2701e;

            /* renamed from: f, reason: collision with root package name */
            boolean f2702f;

            /* loaded from: classes.dex */
            static class a implements Parcelable.ClassLoaderCreator<d> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public d createFromParcel(Parcel parcel) {
                    return new d(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new d(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public d[] newArray(int i4) {
                    return new d[i4];
                }
            }

            public d(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f2700d = parcel.readInt();
                this.f2701e = parcel.readFloat();
                this.f2702f = parcel.readByte() != 0;
            }

            public d(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // b0.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i4) {
                super.writeToParcel(parcel, i4);
                parcel.writeInt(this.f2700d);
                parcel.writeFloat(this.f2701e);
                parcel.writeByte(this.f2702f ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
            this.f2685n = -1;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2685n = -1;
        }

        private void S(CoordinatorLayout coordinatorLayout, T t4, View view) {
            if (M() != (-t4.getTotalScrollRange()) && view.canScrollVertically(1)) {
                T(coordinatorLayout, t4, c.a.f6628q, false);
            }
            if (M() != 0) {
                if (!view.canScrollVertically(-1)) {
                    T(coordinatorLayout, t4, c.a.f6629r, true);
                    return;
                }
                int i4 = -t4.getDownNestedPreScrollRange();
                if (i4 != 0) {
                    p.X(coordinatorLayout, c.a.f6629r, null, new b(coordinatorLayout, t4, view, i4));
                }
            }
        }

        private void T(CoordinatorLayout coordinatorLayout, T t4, c.a aVar, boolean z4) {
            p.X(coordinatorLayout, aVar, null, new c(t4, z4));
        }

        private void U(CoordinatorLayout coordinatorLayout, T t4, int i4, float f4) {
            int abs = Math.abs(M() - i4);
            float abs2 = Math.abs(f4);
            V(coordinatorLayout, t4, i4, abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / t4.getHeight()) + 1.0f) * 150.0f));
        }

        private void V(CoordinatorLayout coordinatorLayout, T t4, int i4, int i5) {
            int M = M();
            if (M == i4) {
                ValueAnimator valueAnimator = this.f2684m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f2684m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f2684m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f2684m = valueAnimator3;
                valueAnimator3.setInterpolator(n0.a.f5242e);
                this.f2684m.addUpdateListener(new a(coordinatorLayout, t4));
            } else {
                valueAnimator2.cancel();
            }
            this.f2684m.setDuration(Math.min(i5, 600));
            this.f2684m.setIntValues(M, i4);
            this.f2684m.start();
        }

        private boolean X(CoordinatorLayout coordinatorLayout, T t4, View view) {
            return t4.h() && coordinatorLayout.getHeight() - view.getHeight() <= t4.getHeight();
        }

        private static boolean Y(int i4, int i5) {
            return (i4 & i5) == i5;
        }

        private View Z(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = coordinatorLayout.getChildAt(i4);
                if ((childAt instanceof i) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View a0(AppBarLayout appBarLayout, int i4) {
            int abs = Math.abs(i4);
            int childCount = appBarLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = appBarLayout.getChildAt(i5);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int b0(T t4, int i4) {
            int childCount = t4.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = t4.getChildAt(i5);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                c cVar = (c) childAt.getLayoutParams();
                if (Y(cVar.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) cVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) cVar).bottomMargin;
                }
                int i6 = -i4;
                if (top <= i6 && bottom >= i6) {
                    return i5;
                }
            }
            return -1;
        }

        private int e0(T t4, int i4) {
            int abs = Math.abs(i4);
            int childCount = t4.getChildCount();
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    break;
                }
                View childAt = t4.getChildAt(i6);
                c cVar = (c) childAt.getLayoutParams();
                Interpolator b5 = cVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i6++;
                } else if (b5 != null) {
                    int a5 = cVar.a();
                    if ((a5 & 1) != 0) {
                        i5 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
                        if ((a5 & 2) != 0) {
                            i5 -= p.u(childAt);
                        }
                    }
                    if (p.q(childAt)) {
                        i5 -= t4.getTopInset();
                    }
                    if (i5 > 0) {
                        float f4 = i5;
                        return Integer.signum(i4) * (childAt.getTop() + Math.round(f4 * b5.getInterpolation((abs - childAt.getTop()) / f4)));
                    }
                }
            }
            return i4;
        }

        private boolean p0(CoordinatorLayout coordinatorLayout, T t4) {
            List<View> t5 = coordinatorLayout.t(t4);
            int size = t5.size();
            for (int i4 = 0; i4 < size; i4++) {
                CoordinatorLayout.c f4 = ((CoordinatorLayout.f) t5.get(i4).getLayoutParams()).f();
                if (f4 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) f4).K() != 0;
                }
            }
            return false;
        }

        private void q0(CoordinatorLayout coordinatorLayout, T t4) {
            int M = M();
            int b02 = b0(t4, M);
            if (b02 >= 0) {
                View childAt = t4.getChildAt(b02);
                c cVar = (c) childAt.getLayoutParams();
                int a5 = cVar.a();
                if ((a5 & 17) == 17) {
                    int i4 = -childAt.getTop();
                    int i5 = -childAt.getBottom();
                    if (b02 == t4.getChildCount() - 1) {
                        i5 += t4.getTopInset();
                    }
                    if (Y(a5, 2)) {
                        i5 += p.u(childAt);
                    } else if (Y(a5, 5)) {
                        int u4 = p.u(childAt) + i5;
                        if (M < u4) {
                            i4 = u4;
                        } else {
                            i5 = u4;
                        }
                    }
                    if (Y(a5, 32)) {
                        i4 += ((LinearLayout.LayoutParams) cVar).topMargin;
                        i5 -= ((LinearLayout.LayoutParams) cVar).bottomMargin;
                    }
                    if (M < (i5 + i4) / 2) {
                        i4 = i5;
                    }
                    U(coordinatorLayout, t4, t.a.b(i4, -t4.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void r0(CoordinatorLayout coordinatorLayout, T t4) {
            p.V(coordinatorLayout, c.a.f6628q.b());
            p.V(coordinatorLayout, c.a.f6629r.b());
            View Z = Z(coordinatorLayout);
            if (Z == null || t4.getTotalScrollRange() == 0 || !(((CoordinatorLayout.f) Z.getLayoutParams()).f() instanceof ScrollingViewBehavior)) {
                return;
            }
            S(coordinatorLayout, t4, Z);
        }

        private void s0(CoordinatorLayout coordinatorLayout, T t4, int i4, int i5, boolean z4) {
            View a02 = a0(t4, i4);
            if (a02 != null) {
                int a5 = ((c) a02.getLayoutParams()).a();
                boolean z5 = false;
                if ((a5 & 1) != 0) {
                    int u4 = p.u(a02);
                    if (i5 <= 0 || (a5 & 12) == 0 ? !((a5 & 2) == 0 || (-i4) < (a02.getBottom() - u4) - t4.getTopInset()) : (-i4) >= (a02.getBottom() - u4) - t4.getTopInset()) {
                        z5 = true;
                    }
                }
                if (t4.j()) {
                    z5 = t4.r(Z(coordinatorLayout));
                }
                boolean p4 = t4.p(z5);
                if (z4 || (p4 && p0(coordinatorLayout, t4))) {
                    t4.jumpDrawablesToCurrentState();
                }
            }
        }

        @Override // com.google.android.material.appbar.a
        int M() {
            return E() + this.f2682k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: W, reason: merged with bridge method [inline-methods] */
        public boolean H(T t4) {
            WeakReference<View> weakReference = this.f2688q;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: c0, reason: merged with bridge method [inline-methods] */
        public int K(T t4) {
            return -t4.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: d0, reason: merged with bridge method [inline-methods] */
        public int L(T t4) {
            return t4.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: f0, reason: merged with bridge method [inline-methods] */
        public void N(CoordinatorLayout coordinatorLayout, T t4) {
            q0(coordinatorLayout, t4);
            if (t4.j()) {
                t4.p(t4.r(Z(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: g0, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, T t4, int i4) {
            boolean l4 = super.l(coordinatorLayout, t4, i4);
            int pendingAction = t4.getPendingAction();
            int i5 = this.f2685n;
            if (i5 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t4.getChildAt(i5);
                P(coordinatorLayout, t4, (-childAt.getBottom()) + (this.f2686o ? p.u(childAt) + t4.getTopInset() : Math.round(childAt.getHeight() * this.f2687p)));
            } else if (pendingAction != 0) {
                boolean z4 = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i6 = -t4.getUpNestedPreScrollRange();
                    if (z4) {
                        U(coordinatorLayout, t4, i6, 0.0f);
                    } else {
                        P(coordinatorLayout, t4, i6);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z4) {
                        U(coordinatorLayout, t4, 0, 0.0f);
                    } else {
                        P(coordinatorLayout, t4, 0);
                    }
                }
            }
            t4.l();
            this.f2685n = -1;
            G(t.a.b(E(), -t4.getTotalScrollRange(), 0));
            s0(coordinatorLayout, t4, E(), 0, true);
            t4.k(E());
            r0(coordinatorLayout, t4);
            return l4;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: h0, reason: merged with bridge method [inline-methods] */
        public boolean m(CoordinatorLayout coordinatorLayout, T t4, int i4, int i5, int i6, int i7) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t4.getLayoutParams())).height != -2) {
                return super.m(coordinatorLayout, t4, i4, i5, i6, i7);
            }
            coordinatorLayout.K(t4, i4, i5, View.MeasureSpec.makeMeasureSpec(0, 0), i7);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void q(CoordinatorLayout coordinatorLayout, T t4, View view, int i4, int i5, int[] iArr, int i6) {
            int i7;
            int i8;
            if (i5 != 0) {
                if (i5 < 0) {
                    i7 = -t4.getTotalScrollRange();
                    i8 = t4.getDownNestedPreScrollRange() + i7;
                } else {
                    i7 = -t4.getUpNestedPreScrollRange();
                    i8 = 0;
                }
                int i9 = i7;
                int i10 = i8;
                if (i9 != i10) {
                    iArr[1] = O(coordinatorLayout, t4, i5, i9, i10);
                }
            }
            if (t4.j()) {
                t4.p(t4.r(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void t(CoordinatorLayout coordinatorLayout, T t4, View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
            if (i7 < 0) {
                iArr[1] = O(coordinatorLayout, t4, i7, -t4.getDownNestedScrollRange(), 0);
            }
            if (i7 == 0) {
                r0(coordinatorLayout, t4);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void x(CoordinatorLayout coordinatorLayout, T t4, Parcelable parcelable) {
            if (!(parcelable instanceof d)) {
                super.x(coordinatorLayout, t4, parcelable);
                this.f2685n = -1;
                return;
            }
            d dVar = (d) parcelable;
            super.x(coordinatorLayout, t4, dVar.f());
            this.f2685n = dVar.f2700d;
            this.f2687p = dVar.f2701e;
            this.f2686o = dVar.f2702f;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public Parcelable y(CoordinatorLayout coordinatorLayout, T t4) {
            Parcelable y4 = super.y(coordinatorLayout, t4);
            int E = E();
            int childCount = t4.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = t4.getChildAt(i4);
                int bottom = childAt.getBottom() + E;
                if (childAt.getTop() + E <= 0 && bottom >= 0) {
                    d dVar = new d(y4);
                    dVar.f2700d = i4;
                    dVar.f2702f = bottom == p.u(childAt) + t4.getTopInset();
                    dVar.f2701e = bottom / childAt.getHeight();
                    return dVar;
                }
            }
            return y4;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, T t4, View view, View view2, int i4, int i5) {
            ValueAnimator valueAnimator;
            boolean z4 = (i4 & 2) != 0 && (t4.j() || X(coordinatorLayout, t4, view));
            if (z4 && (valueAnimator = this.f2684m) != null) {
                valueAnimator.cancel();
            }
            this.f2688q = null;
            this.f2683l = i5;
            return z4;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void C(CoordinatorLayout coordinatorLayout, T t4, View view, int i4) {
            if (this.f2683l == 0 || i4 == 1) {
                q0(coordinatorLayout, t4);
                if (t4.j()) {
                    t4.p(t4.r(view));
                }
            }
            this.f2688q = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public int Q(CoordinatorLayout coordinatorLayout, T t4, int i4, int i5, int i6) {
            int M = M();
            int i7 = 0;
            if (i5 == 0 || M < i5 || M > i6) {
                this.f2682k = 0;
            } else {
                int b5 = t.a.b(i4, i5, i6);
                if (M != b5) {
                    int e02 = t4.f() ? e0(t4, b5) : b5;
                    boolean G = G(e02);
                    i7 = M - b5;
                    this.f2682k = b5 - e02;
                    if (!G && t4.f()) {
                        coordinatorLayout.f(t4);
                    }
                    t4.k(E());
                    s0(coordinatorLayout, t4, b5, b5 < M ? -1 : 1, false);
                }
            }
            r0(coordinatorLayout, t4);
            return i7;
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int E() {
            return super.E();
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ boolean G(int i4) {
            return super.G(i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: g0 */
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i4) {
            return super.l(coordinatorLayout, appBarLayout, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: h0 */
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i4, int i5, int i6, int i7) {
            return super.m(coordinatorLayout, appBarLayout, i4, i5, i6, i7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: i0 */
        public /* bridge */ /* synthetic */ void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i4, int i5, int[] iArr, int i6) {
            super.q(coordinatorLayout, appBarLayout, view, i4, i5, iArr, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: j0 */
        public /* bridge */ /* synthetic */ void t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
            super.t(coordinatorLayout, appBarLayout, view, i4, i5, i6, i7, i8, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: k0 */
        public /* bridge */ /* synthetic */ void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.x(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: l0 */
        public /* bridge */ /* synthetic */ Parcelable y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.y(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: m0 */
        public /* bridge */ /* synthetic */ boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i4, int i5) {
            return super.A(coordinatorLayout, appBarLayout, view, view2, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: n0 */
        public /* bridge */ /* synthetic */ void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i4) {
            super.C(coordinatorLayout, appBarLayout, view, i4);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f5177y2);
            O(obtainStyledAttributes.getDimensionPixelSize(k.f5182z2, 0));
            obtainStyledAttributes.recycle();
        }

        private static int R(AppBarLayout appBarLayout) {
            CoordinatorLayout.c f4 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (f4 instanceof BaseBehavior) {
                return ((BaseBehavior) f4).M();
            }
            return 0;
        }

        private void S(View view, View view2) {
            CoordinatorLayout.c f4 = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (f4 instanceof BaseBehavior) {
                p.N(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f4).f2682k) + M()) - I(view2));
            }
        }

        private void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.j()) {
                    appBarLayout.p(appBarLayout.r(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.b
        float J(View view) {
            int i4;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int R = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + R > downNestedPreScrollRange) && (i4 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (R / i4) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.b
        int L(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.L(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public AppBarLayout H(List<View> list) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = list.get(i4);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                p.V(coordinatorLayout, c.a.f6628q.b());
                p.V(coordinatorLayout, c.a.f6629r.b());
            }
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
            return super.l(coordinatorLayout, view, i4);
        }

        @Override // com.google.android.material.appbar.b, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int i7) {
            return super.m(coordinatorLayout, view, i4, i5, i6, i7);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z4) {
            AppBarLayout H = H(coordinatorLayout.s(view));
            if (H != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f2717d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    H.m(false, !z4);
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f2703a;

        a(g gVar) {
            this.f2703a = gVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f2703a.U(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public interface b<T extends AppBarLayout> {
        void a(T t4, int i4);
    }

    /* loaded from: classes.dex */
    public static class c extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f2705a;

        /* renamed from: b, reason: collision with root package name */
        Interpolator f2706b;

        public c(int i4, int i5) {
            super(i4, i5);
            this.f2705a = 1;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2705a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f5114m);
            this.f2705a = obtainStyledAttributes.getInt(k.f5119n, 0);
            int i4 = k.f5124o;
            if (obtainStyledAttributes.hasValue(i4)) {
                this.f2706b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i4, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2705a = 1;
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2705a = 1;
        }

        public c(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2705a = 1;
        }

        public int a() {
            return this.f2705a;
        }

        public Interpolator b() {
            return this.f2706b;
        }

        boolean c() {
            int i4 = this.f2705a;
            return (i4 & 1) == 1 && (i4 & 10) != 0;
        }
    }

    private void a() {
        WeakReference<View> weakReference = this.f2678o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2678o = null;
    }

    private View b(View view) {
        int i4;
        if (this.f2678o == null && (i4 = this.f2677n) != -1) {
            View findViewById = view != null ? view.findViewById(i4) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.f2677n);
            }
            if (findViewById != null) {
                this.f2678o = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.f2678o;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean g() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (((c) getChildAt(i4).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void i() {
        this.f2666c = -1;
        this.f2667d = -1;
        this.f2668e = -1;
    }

    private void n(boolean z4, boolean z5, boolean z6) {
        this.f2670g = (z4 ? 1 : 2) | (z5 ? 4 : 0) | (z6 ? 8 : 0);
        requestLayout();
    }

    private boolean o(boolean z4) {
        if (this.f2674k == z4) {
            return false;
        }
        this.f2674k = z4;
        refreshDrawableState();
        return true;
    }

    private boolean q() {
        return this.f2681r != null && getTopInset() > 0;
    }

    private boolean s() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || p.q(childAt)) ? false : true;
    }

    private void t(g gVar, boolean z4) {
        float dimension = getResources().getDimension(m0.d.f4964a);
        float f4 = z4 ? 0.0f : dimension;
        if (!z4) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f2679p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, dimension);
        this.f2679p = ofFloat;
        ofFloat.setDuration(getResources().getInteger(m0.g.f5012a));
        this.f2679p.setInterpolator(n0.a.f5238a);
        this.f2679p.addUpdateListener(new a(gVar));
        this.f2679p.start();
    }

    private void u() {
        setWillNotDraw(!q());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (q()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f2665b);
            this.f2681r.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2681r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new c((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    boolean f() {
        return this.f2669f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    int getDownNestedPreScrollRange() {
        int i4;
        int u4;
        int i5 = this.f2667d;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i7 = cVar.f2705a;
            if ((i7 & 5) != 5) {
                if (i6 > 0) {
                    break;
                }
            } else {
                int i8 = ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
                if ((i7 & 8) != 0) {
                    u4 = p.u(childAt);
                } else if ((i7 & 2) != 0) {
                    u4 = measuredHeight - p.u(childAt);
                } else {
                    i4 = i8 + measuredHeight;
                    if (childCount == 0 && p.q(childAt)) {
                        i4 = Math.min(i4, measuredHeight - getTopInset());
                    }
                    i6 += i4;
                }
                i4 = i8 + u4;
                if (childCount == 0) {
                    i4 = Math.min(i4, measuredHeight - getTopInset());
                }
                i6 += i4;
            }
        }
        int max = Math.max(0, i6);
        this.f2667d = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i4 = this.f2668e;
        if (i4 != -1) {
            return i4;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
            int i7 = cVar.f2705a;
            if ((i7 & 1) == 0) {
                break;
            }
            i6 += measuredHeight;
            if ((i7 & 2) != 0) {
                i6 -= p.u(childAt);
                break;
            }
            i5++;
        }
        int max = Math.max(0, i6);
        this.f2668e = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f2677n;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int u4 = p.u(this);
        if (u4 == 0) {
            int childCount = getChildCount();
            u4 = childCount >= 1 ? p.u(getChildAt(childCount - 1)) : 0;
            if (u4 == 0) {
                return getHeight() / 3;
            }
        }
        return (u4 * 2) + topInset;
    }

    int getPendingAction() {
        return this.f2670g;
    }

    public Drawable getStatusBarForeground() {
        return this.f2681r;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        x xVar = this.f2671h;
        if (xVar != null) {
            return xVar.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i4 = this.f2666c;
        if (i4 != -1) {
            return i4;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i7 = cVar.f2705a;
            if ((i7 & 1) == 0) {
                break;
            }
            i6 += measuredHeight + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
            if (i5 == 0 && p.q(childAt)) {
                i6 -= getTopInset();
            }
            if ((i7 & 2) != 0) {
                i6 -= p.u(childAt);
                break;
            }
            i5++;
        }
        int max = Math.max(0, i6);
        this.f2666c = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean h() {
        return getTotalScrollRange() != 0;
    }

    public boolean j() {
        return this.f2676m;
    }

    void k(int i4) {
        this.f2665b = i4;
        if (!willNotDraw()) {
            p.S(this);
        }
        List<b> list = this.f2672i;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                b bVar = this.f2672i.get(i5);
                if (bVar != null) {
                    bVar.a(this, i4);
                }
            }
        }
    }

    void l() {
        this.f2670g = 0;
    }

    public void m(boolean z4, boolean z5) {
        n(z4, z5, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i4) {
        if (this.f2680q == null) {
            this.f2680q = new int[4];
        }
        int[] iArr = this.f2680q;
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + iArr.length);
        boolean z4 = this.f2674k;
        int i5 = m0.b.f4955w;
        if (!z4) {
            i5 = -i5;
        }
        iArr[0] = i5;
        iArr[1] = (z4 && this.f2675l) ? m0.b.f4956x : -m0.b.f4956x;
        int i6 = m0.b.f4953u;
        if (!z4) {
            i6 = -i6;
        }
        iArr[2] = i6;
        iArr[3] = (z4 && this.f2675l) ? m0.b.f4952t : -m0.b.f4952t;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        boolean z5 = true;
        if (p.q(this) && s()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                p.N(getChildAt(childCount), topInset);
            }
        }
        i();
        this.f2669f = false;
        int childCount2 = getChildCount();
        int i8 = 0;
        while (true) {
            if (i8 >= childCount2) {
                break;
            }
            if (((c) getChildAt(i8).getLayoutParams()).b() != null) {
                this.f2669f = true;
                break;
            }
            i8++;
        }
        Drawable drawable = this.f2681r;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f2673j) {
            return;
        }
        if (!this.f2676m && !g()) {
            z5 = false;
        }
        o(z5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i5);
        if (mode != 1073741824 && p.q(this) && s()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = t.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i5));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        i();
    }

    boolean p(boolean z4) {
        if (this.f2675l == z4) {
            return false;
        }
        this.f2675l = z4;
        refreshDrawableState();
        if (!this.f2676m || !(getBackground() instanceof g)) {
            return true;
        }
        t((g) getBackground(), z4);
        return true;
    }

    boolean r(View view) {
        View b5 = b(view);
        if (b5 != null) {
            view = b5;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        h.d(this, f4);
    }

    public void setExpanded(boolean z4) {
        m(z4, p.H(this));
    }

    public void setLiftOnScroll(boolean z4) {
        this.f2676m = z4;
    }

    public void setLiftOnScrollTargetViewId(int i4) {
        this.f2677n = i4;
        a();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i4) {
        if (i4 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i4);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f2681r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f2681r = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f2681r.setState(getDrawableState());
                }
                r.a.h(this.f2681r, p.t(this));
                this.f2681r.setVisible(getVisibility() == 0, false);
                this.f2681r.setCallback(this);
            }
            u();
            p.S(this);
        }
    }

    public void setStatusBarForegroundColor(int i4) {
        setStatusBarForeground(new ColorDrawable(i4));
    }

    public void setStatusBarForegroundResource(int i4) {
        setStatusBarForeground(c.a.b(getContext(), i4));
    }

    @Deprecated
    public void setTargetElevation(float f4) {
        e.a(this, f4);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f2681r;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2681r;
    }
}
