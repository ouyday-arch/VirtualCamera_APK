package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.i;
import androidx.lifecycle.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends androidx.fragment.app.i implements LayoutInflater.Factory2 {
    static boolean I;
    static final Interpolator J = new DecelerateInterpolator(2.5f);
    static final Interpolator K = new DecelerateInterpolator(1.5f);
    ArrayList<androidx.fragment.app.a> A;
    ArrayList<Boolean> B;
    ArrayList<Fragment> C;
    ArrayList<m> F;
    private androidx.fragment.app.l G;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<k> f1504d;

    /* renamed from: e, reason: collision with root package name */
    boolean f1505e;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f1509i;

    /* renamed from: j, reason: collision with root package name */
    ArrayList<Fragment> f1510j;

    /* renamed from: k, reason: collision with root package name */
    private OnBackPressedDispatcher f1511k;

    /* renamed from: m, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f1513m;

    /* renamed from: n, reason: collision with root package name */
    ArrayList<Integer> f1514n;

    /* renamed from: o, reason: collision with root package name */
    ArrayList<i.a> f1515o;

    /* renamed from: r, reason: collision with root package name */
    androidx.fragment.app.h f1518r;

    /* renamed from: s, reason: collision with root package name */
    androidx.fragment.app.e f1519s;

    /* renamed from: t, reason: collision with root package name */
    Fragment f1520t;

    /* renamed from: u, reason: collision with root package name */
    Fragment f1521u;

    /* renamed from: v, reason: collision with root package name */
    boolean f1522v;

    /* renamed from: w, reason: collision with root package name */
    boolean f1523w;

    /* renamed from: x, reason: collision with root package name */
    boolean f1524x;

    /* renamed from: y, reason: collision with root package name */
    boolean f1525y;

    /* renamed from: z, reason: collision with root package name */
    boolean f1526z;

    /* renamed from: f, reason: collision with root package name */
    int f1506f = 0;

    /* renamed from: g, reason: collision with root package name */
    final ArrayList<Fragment> f1507g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    final HashMap<String, Fragment> f1508h = new HashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private final androidx.activity.b f1512l = new a(false);

    /* renamed from: p, reason: collision with root package name */
    private final CopyOnWriteArrayList<i> f1516p = new CopyOnWriteArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    int f1517q = 0;
    Bundle D = null;
    SparseArray<Parcelable> E = null;
    Runnable H = new b();

    /* loaded from: classes.dex */
    class a extends androidx.activity.b {
        a(boolean z4) {
            super(z4);
        }

        @Override // androidx.activity.b
        public void b() {
            j.this.A0();
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1529a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f1530b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f1530b.l() != null) {
                    c.this.f1530b.e1(null);
                    c cVar = c.this;
                    j jVar = j.this;
                    Fragment fragment = cVar.f1530b;
                    jVar.Q0(fragment, fragment.H(), 0, 0, false);
                }
            }
        }

        c(ViewGroup viewGroup, Fragment fragment) {
            this.f1529a = viewGroup;
            this.f1530b = fragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f1529a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1533a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1534b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f1535c;

        d(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f1533a = viewGroup;
            this.f1534b = view;
            this.f1535c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1533a.endViewTransition(this.f1534b);
            Animator m4 = this.f1535c.m();
            this.f1535c.f1(null);
            if (m4 == null || this.f1533a.indexOfChild(this.f1534b) >= 0) {
                return;
            }
            j jVar = j.this;
            Fragment fragment = this.f1535c;
            jVar.Q0(fragment, fragment.H(), 0, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1537a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1538b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f1539c;

        e(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f1537a = viewGroup;
            this.f1538b = view;
            this.f1539c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1537a.endViewTransition(this.f1538b);
            animator.removeListener(this);
            Fragment fragment = this.f1539c;
            View view = fragment.H;
            if (view == null || !fragment.f1433z) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends androidx.fragment.app.g {
        f() {
        }

        @Override // androidx.fragment.app.g
        public Fragment a(ClassLoader classLoader, String str) {
            androidx.fragment.app.h hVar = j.this.f1518r;
            return hVar.b(hVar.i(), str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f1542a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f1543b;

        g(Animator animator) {
            this.f1542a = null;
            this.f1543b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        g(Animation animation) {
            this.f1542a = animation;
            this.f1543b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends AnimationSet implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final ViewGroup f1544b;

        /* renamed from: c, reason: collision with root package name */
        private final View f1545c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1546d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f1547e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f1548f;

        h(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1548f = true;
            this.f1544b = viewGroup;
            this.f1545c = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j4, Transformation transformation) {
            this.f1548f = true;
            if (this.f1546d) {
                return !this.f1547e;
            }
            if (!super.getTransformation(j4, transformation)) {
                this.f1546d = true;
                y.o.a(this.f1544b, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j4, Transformation transformation, float f4) {
            this.f1548f = true;
            if (this.f1546d) {
                return !this.f1547e;
            }
            if (!super.getTransformation(j4, transformation, f4)) {
                this.f1546d = true;
                y.o.a(this.f1544b, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1546d || !this.f1548f) {
                this.f1544b.endViewTransition(this.f1545c);
                this.f1547e = true;
            } else {
                this.f1548f = false;
                this.f1544b.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class i {

        /* renamed from: a, reason: collision with root package name */
        final boolean f1549a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.fragment.app.j$j, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0011j {

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f1550a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface k {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    private class l implements k {

        /* renamed from: a, reason: collision with root package name */
        final String f1551a;

        /* renamed from: b, reason: collision with root package name */
        final int f1552b;

        /* renamed from: c, reason: collision with root package name */
        final int f1553c;

        l(String str, int i4, int i5) {
            this.f1551a = str;
            this.f1552b = i4;
            this.f1553c = i5;
        }

        @Override // androidx.fragment.app.j.k
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = j.this.f1521u;
            if (fragment == null || this.f1552b >= 0 || this.f1551a != null || !fragment.o().f()) {
                return j.this.U0(arrayList, arrayList2, this.f1551a, this.f1552b, this.f1553c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class m implements Fragment.f {

        /* renamed from: a, reason: collision with root package name */
        final boolean f1555a;

        /* renamed from: b, reason: collision with root package name */
        final androidx.fragment.app.a f1556b;

        /* renamed from: c, reason: collision with root package name */
        private int f1557c;

        m(androidx.fragment.app.a aVar, boolean z4) {
            this.f1555a = z4;
            this.f1556b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.f
        public void a() {
            int i4 = this.f1557c - 1;
            this.f1557c = i4;
            if (i4 != 0) {
                return;
            }
            this.f1556b.f1455s.g1();
        }

        @Override // androidx.fragment.app.Fragment.f
        public void b() {
            this.f1557c++;
        }

        public void c() {
            androidx.fragment.app.a aVar = this.f1556b;
            aVar.f1455s.t(aVar, this.f1555a, false, false);
        }

        public void d() {
            boolean z4 = this.f1557c > 0;
            j jVar = this.f1556b.f1455s;
            int size = jVar.f1507g.size();
            for (int i4 = 0; i4 < size; i4++) {
                Fragment fragment = jVar.f1507g.get(i4);
                fragment.k1(null);
                if (z4 && fragment.Q()) {
                    fragment.n1();
                }
            }
            androidx.fragment.app.a aVar = this.f1556b;
            aVar.f1455s.t(aVar, this.f1555a, !z4, true);
        }

        public boolean e() {
            return this.f1557c == 0;
        }
    }

    private boolean D0(Fragment fragment) {
        return (fragment.D && fragment.E) || fragment.f1428u.q();
    }

    static g J0(float f4, float f5) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(K);
        alphaAnimation.setDuration(220L);
        return new g(alphaAnimation);
    }

    static g L0(float f4, float f5, float f6, float f7) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f4, f5, f4, f5, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(J);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f6, f7);
        alphaAnimation.setInterpolator(K);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new g(animationSet);
    }

    private void M0(k.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            Fragment h4 = bVar.h(i4);
            if (!h4.f1419l) {
                View b12 = h4.b1();
                h4.P = b12.getAlpha();
                b12.setAlpha(0.0f);
            }
        }
    }

    private boolean T0(String str, int i4, int i5) {
        j0();
        h0(true);
        Fragment fragment = this.f1521u;
        if (fragment != null && i4 < 0 && str == null && fragment.o().f()) {
            return true;
        }
        boolean U0 = U0(this.A, this.B, str, i4, i5);
        if (U0) {
            this.f1505e = true;
            try {
                Y0(this.A, this.B);
            } finally {
                s();
            }
        }
        o1();
        e0();
        p();
        return U0;
    }

    private void V(Fragment fragment) {
        if (fragment == null || this.f1508h.get(fragment.f1413f) != fragment) {
            return;
        }
        fragment.S0();
    }

    private int V0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i4, int i5, k.b<Fragment> bVar) {
        int i6 = i5;
        for (int i7 = i5 - 1; i7 >= i4; i7--) {
            androidx.fragment.app.a aVar = arrayList.get(i7);
            boolean booleanValue = arrayList2.get(i7).booleanValue();
            if (aVar.t() && !aVar.r(arrayList, i7 + 1, i5)) {
                if (this.F == null) {
                    this.F = new ArrayList<>();
                }
                m mVar = new m(aVar, booleanValue);
                this.F.add(mVar);
                aVar.v(mVar);
                if (booleanValue) {
                    aVar.m();
                } else {
                    aVar.n(false);
                }
                i6--;
                if (i7 != i6) {
                    arrayList.remove(i7);
                    arrayList.add(i6, aVar);
                }
                h(bVar);
            }
        }
        return i6;
    }

    private void Y0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        m0(arrayList, arrayList2);
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            if (!arrayList.get(i4).f1600q) {
                if (i5 != i4) {
                    l0(arrayList, arrayList2, i5, i4);
                }
                i5 = i4 + 1;
                if (arrayList2.get(i4).booleanValue()) {
                    while (i5 < size && arrayList2.get(i5).booleanValue() && !arrayList.get(i5).f1600q) {
                        i5++;
                    }
                }
                l0(arrayList, arrayList2, i4, i5);
                i4 = i5 - 1;
            }
            i4++;
        }
        if (i5 != size) {
            l0(arrayList, arrayList2, i5, size);
        }
    }

    private void c0(int i4) {
        try {
            this.f1505e = true;
            O0(i4, false);
            this.f1505e = false;
            j0();
        } catch (Throwable th) {
            this.f1505e = false;
            throw th;
        }
    }

    public static int c1(int i4) {
        if (i4 == 4097) {
            return 8194;
        }
        if (i4 != 4099) {
            return i4 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void f0() {
        for (Fragment fragment : this.f1508h.values()) {
            if (fragment != null) {
                if (fragment.l() != null) {
                    int H = fragment.H();
                    View l4 = fragment.l();
                    Animation animation = l4.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        l4.clearAnimation();
                    }
                    fragment.e1(null);
                    Q0(fragment, H, 0, 0, false);
                } else if (fragment.m() != null) {
                    fragment.m().end();
                }
            }
        }
    }

    private void h(k.b<Fragment> bVar) {
        int i4 = this.f1517q;
        if (i4 < 1) {
            return;
        }
        int min = Math.min(i4, 3);
        int size = this.f1507g.size();
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.f1507g.get(i5);
            if (fragment.f1409b < min) {
                Q0(fragment, min, fragment.x(), fragment.y(), false);
                if (fragment.H != null && !fragment.f1433z && fragment.N) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private void h0(boolean z4) {
        if (this.f1505e) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1518r == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.f1518r.j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z4) {
            r();
        }
        if (this.A == null) {
            this.A = new ArrayList<>();
            this.B = new ArrayList<>();
        }
        this.f1505e = true;
        try {
            m0(null, null);
        } finally {
            this.f1505e = false;
        }
    }

    private static void k0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i4, int i5) {
        while (i4 < i5) {
            androidx.fragment.app.a aVar = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                aVar.i(-1);
                aVar.n(i4 == i5 + (-1));
            } else {
                aVar.i(1);
                aVar.m();
            }
            i4++;
        }
    }

    private void l0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4;
        boolean z4 = arrayList.get(i8).f1600q;
        ArrayList<Fragment> arrayList3 = this.C;
        if (arrayList3 == null) {
            this.C = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.C.addAll(this.f1507g);
        Fragment y02 = y0();
        boolean z5 = false;
        for (int i9 = i8; i9 < i5; i9++) {
            androidx.fragment.app.a aVar = arrayList.get(i9);
            y02 = !arrayList2.get(i9).booleanValue() ? aVar.o(this.C, y02) : aVar.w(this.C, y02);
            z5 = z5 || aVar.f1591h;
        }
        this.C.clear();
        if (!z4) {
            o.B(this, arrayList, arrayList2, i4, i5, false);
        }
        k0(arrayList, arrayList2, i4, i5);
        if (z4) {
            k.b<Fragment> bVar = new k.b<>();
            h(bVar);
            int V0 = V0(arrayList, arrayList2, i4, i5, bVar);
            M0(bVar);
            i6 = V0;
        } else {
            i6 = i5;
        }
        if (i6 != i8 && z4) {
            o.B(this, arrayList, arrayList2, i4, i6, true);
            O0(this.f1517q, true);
        }
        while (i8 < i5) {
            androidx.fragment.app.a aVar2 = arrayList.get(i8);
            if (arrayList2.get(i8).booleanValue() && (i7 = aVar2.f1457u) >= 0) {
                s0(i7);
                aVar2.f1457u = -1;
            }
            aVar2.u();
            i8++;
        }
        if (z5) {
            a1();
        }
    }

    private void m(Fragment fragment, g gVar, int i4) {
        View view = fragment.H;
        ViewGroup viewGroup = fragment.G;
        viewGroup.startViewTransition(view);
        fragment.l1(i4);
        if (gVar.f1542a != null) {
            h hVar = new h(gVar.f1542a, viewGroup, view);
            fragment.e1(fragment.H);
            hVar.setAnimationListener(new c(viewGroup, fragment));
            fragment.H.startAnimation(hVar);
            return;
        }
        Animator animator = gVar.f1543b;
        fragment.f1(animator);
        animator.addListener(new d(viewGroup, view, fragment));
        animator.setTarget(fragment.H);
        animator.start();
    }

    private void m0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<m> arrayList3 = this.F;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i4 = 0;
        while (i4 < size) {
            m mVar = this.F.get(i4);
            if (arrayList == null || mVar.f1555a || (indexOf2 = arrayList.indexOf(mVar.f1556b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (mVar.e() || (arrayList != null && mVar.f1556b.r(arrayList, 0, arrayList.size()))) {
                    this.F.remove(i4);
                    i4--;
                    size--;
                    if (arrayList == null || mVar.f1555a || (indexOf = arrayList.indexOf(mVar.f1556b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        mVar.d();
                    }
                }
                i4++;
            } else {
                this.F.remove(i4);
                i4--;
                size--;
            }
            mVar.c();
            i4++;
        }
    }

    private void m1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new x.b("FragmentManager"));
        androidx.fragment.app.h hVar = this.f1518r;
        try {
            if (hVar != null) {
                hVar.l("  ", null, printWriter, new String[0]);
            } else {
                b("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e4) {
            Log.e("FragmentManager", "Failed dumping state", e4);
            throw runtimeException;
        }
    }

    public static int n1(int i4, boolean z4) {
        if (i4 == 4097) {
            return z4 ? 1 : 2;
        }
        if (i4 == 4099) {
            return z4 ? 5 : 6;
        }
        if (i4 != 8194) {
            return -1;
        }
        return z4 ? 3 : 4;
    }

    private void o1() {
        ArrayList<k> arrayList = this.f1504d;
        if (arrayList == null || arrayList.isEmpty()) {
            this.f1512l.f(u0() > 0 && E0(this.f1520t));
        } else {
            this.f1512l.f(true);
        }
    }

    private void p() {
        this.f1508h.values().removeAll(Collections.singleton(null));
    }

    private Fragment q0(Fragment fragment) {
        ViewGroup viewGroup = fragment.G;
        View view = fragment.H;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.f1507g.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.f1507g.get(indexOf);
                if (fragment2.G == viewGroup && fragment2.H != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private void r() {
        if (G0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void r0() {
        if (this.F != null) {
            while (!this.F.isEmpty()) {
                this.F.remove(0).d();
            }
        }
    }

    private void s() {
        this.f1505e = false;
        this.B.clear();
        this.A.clear();
    }

    private boolean t0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            ArrayList<k> arrayList3 = this.f1504d;
            if (arrayList3 != null && arrayList3.size() != 0) {
                int size = this.f1504d.size();
                boolean z4 = false;
                for (int i4 = 0; i4 < size; i4++) {
                    z4 |= this.f1504d.get(i4).a(arrayList, arrayList2);
                }
                this.f1504d.clear();
                this.f1518r.j().removeCallbacks(this.H);
                return z4;
            }
            return false;
        }
    }

    public boolean A(Menu menu, MenuInflater menuInflater) {
        if (this.f1517q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z4 = false;
        for (int i4 = 0; i4 < this.f1507g.size(); i4++) {
            Fragment fragment = this.f1507g.get(i4);
            if (fragment != null && fragment.F0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z4 = true;
            }
        }
        if (this.f1510j != null) {
            for (int i5 = 0; i5 < this.f1510j.size(); i5++) {
                Fragment fragment2 = this.f1510j.get(i5);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.f0();
                }
            }
        }
        this.f1510j = arrayList;
        return z4;
    }

    void A0() {
        j0();
        if (this.f1512l.c()) {
            f();
        } else {
            this.f1511k.c();
        }
    }

    public void B() {
        this.f1525y = true;
        j0();
        c0(0);
        this.f1518r = null;
        this.f1519s = null;
        this.f1520t = null;
        if (this.f1511k != null) {
            this.f1512l.d();
            this.f1511k = null;
        }
    }

    public void B0(Fragment fragment) {
        if (I) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.f1433z) {
            return;
        }
        fragment.f1433z = true;
        fragment.O = true ^ fragment.O;
    }

    public void C() {
        c0(1);
    }

    public boolean C0() {
        return this.f1525y;
    }

    public void D() {
        for (int i4 = 0; i4 < this.f1507g.size(); i4++) {
            Fragment fragment = this.f1507g.get(i4);
            if (fragment != null) {
                fragment.L0();
            }
        }
    }

    public void E(boolean z4) {
        for (int size = this.f1507g.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1507g.get(size);
            if (fragment != null) {
                fragment.M0(z4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        j jVar = fragment.f1426s;
        return fragment == jVar.y0() && E0(jVar.f1520t);
    }

    void F(Fragment fragment, Bundle bundle, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).F(fragment, bundle, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F0(int i4) {
        return this.f1517q >= i4;
    }

    void G(Fragment fragment, Context context, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).G(fragment, context, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    public boolean G0() {
        return this.f1523w || this.f1524x;
    }

    void H(Fragment fragment, Bundle bundle, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).H(fragment, bundle, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    g H0(Fragment fragment, int i4, boolean z4, int i5) {
        int n12;
        int x4 = fragment.x();
        boolean z5 = false;
        fragment.i1(0);
        ViewGroup viewGroup = fragment.G;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation a02 = fragment.a0(i4, z4, x4);
        if (a02 != null) {
            return new g(a02);
        }
        Animator b02 = fragment.b0(i4, z4, x4);
        if (b02 != null) {
            return new g(b02);
        }
        if (x4 != 0) {
            boolean equals = "anim".equals(this.f1518r.i().getResources().getResourceTypeName(x4));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f1518r.i(), x4);
                    if (loadAnimation != null) {
                        return new g(loadAnimation);
                    }
                    z5 = true;
                } catch (Resources.NotFoundException e4) {
                    throw e4;
                } catch (RuntimeException unused) {
                }
            }
            if (!z5) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.f1518r.i(), x4);
                    if (loadAnimator != null) {
                        return new g(loadAnimator);
                    }
                } catch (RuntimeException e5) {
                    if (equals) {
                        throw e5;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f1518r.i(), x4);
                    if (loadAnimation2 != null) {
                        return new g(loadAnimation2);
                    }
                }
            }
        }
        if (i4 == 0 || (n12 = n1(i4, z4)) < 0) {
            return null;
        }
        switch (n12) {
            case 1:
                return L0(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return L0(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return L0(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return L0(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return J0(0.0f, 1.0f);
            case 6:
                return J0(1.0f, 0.0f);
            default:
                if (i5 == 0 && this.f1518r.p()) {
                    this.f1518r.o();
                }
                return null;
        }
    }

    void I(Fragment fragment, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).I(fragment, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I0(Fragment fragment) {
        if (this.f1508h.get(fragment.f1413f) != null) {
            return;
        }
        this.f1508h.put(fragment.f1413f, fragment);
        if (fragment.C) {
            if (fragment.B) {
                k(fragment);
            } else {
                Z0(fragment);
            }
            fragment.C = false;
        }
        if (I) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    void J(Fragment fragment, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).J(fragment, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    void K(Fragment fragment, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).K(fragment, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    void K0(Fragment fragment) {
        if (this.f1508h.get(fragment.f1413f) == null) {
            return;
        }
        if (I) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
        for (Fragment fragment2 : this.f1508h.values()) {
            if (fragment2 != null && fragment.f1413f.equals(fragment2.f1416i)) {
                fragment2.f1415h = fragment;
                fragment2.f1416i = null;
            }
        }
        this.f1508h.put(fragment.f1413f, null);
        Z0(fragment);
        String str = fragment.f1416i;
        if (str != null) {
            fragment.f1415h = this.f1508h.get(str);
        }
        fragment.M();
    }

    void L(Fragment fragment, Context context, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).L(fragment, context, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    void M(Fragment fragment, Bundle bundle, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).M(fragment, bundle, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    void N(Fragment fragment, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).N(fragment, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N0(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (!this.f1508h.containsKey(fragment.f1413f)) {
            if (I) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f1517q + "since it is not added to " + this);
                return;
            }
            return;
        }
        int i4 = this.f1517q;
        if (fragment.f1420m) {
            i4 = fragment.P() ? Math.min(i4, 1) : Math.min(i4, 0);
        }
        Q0(fragment, i4, fragment.y(), fragment.z(), false);
        if (fragment.H != null) {
            Fragment q02 = q0(fragment);
            if (q02 != null) {
                View view = q02.H;
                ViewGroup viewGroup = fragment.G;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.H);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.H, indexOfChild);
                }
            }
            if (fragment.N && fragment.G != null) {
                float f4 = fragment.P;
                if (f4 > 0.0f) {
                    fragment.H.setAlpha(f4);
                }
                fragment.P = 0.0f;
                fragment.N = false;
                g H0 = H0(fragment, fragment.y(), true, fragment.z());
                if (H0 != null) {
                    Animation animation = H0.f1542a;
                    if (animation != null) {
                        fragment.H.startAnimation(animation);
                    } else {
                        H0.f1543b.setTarget(fragment.H);
                        H0.f1543b.start();
                    }
                }
            }
        }
        if (fragment.O) {
            u(fragment);
        }
    }

    void O(Fragment fragment, Bundle bundle, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).O(fragment, bundle, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(int i4, boolean z4) {
        androidx.fragment.app.h hVar;
        if (this.f1518r == null && i4 != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z4 || i4 != this.f1517q) {
            this.f1517q = i4;
            int size = this.f1507g.size();
            for (int i5 = 0; i5 < size; i5++) {
                N0(this.f1507g.get(i5));
            }
            for (Fragment fragment : this.f1508h.values()) {
                if (fragment != null && (fragment.f1420m || fragment.A)) {
                    if (!fragment.N) {
                        N0(fragment);
                    }
                }
            }
            l1();
            if (this.f1522v && (hVar = this.f1518r) != null && this.f1517q == 4) {
                hVar.t();
                this.f1522v = false;
            }
        }
    }

    void P(Fragment fragment, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).P(fragment, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    void P0(Fragment fragment) {
        Q0(fragment, this.f1517q, 0, 0, false);
    }

    void Q(Fragment fragment, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).Q(fragment, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Q0(androidx.fragment.app.Fragment r19, int r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.Q0(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    void R(Fragment fragment, View view, Bundle bundle, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).R(fragment, view, bundle, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    public void R0() {
        this.f1523w = false;
        this.f1524x = false;
        int size = this.f1507g.size();
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f1507g.get(i4);
            if (fragment != null) {
                fragment.S();
            }
        }
    }

    void S(Fragment fragment, boolean z4) {
        Fragment fragment2 = this.f1520t;
        if (fragment2 != null) {
            androidx.fragment.app.i u4 = fragment2.u();
            if (u4 instanceof j) {
                ((j) u4).S(fragment, true);
            }
        }
        Iterator<i> it = this.f1516p.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!z4 || next.f1549a) {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    public void S0(Fragment fragment) {
        if (fragment.J) {
            if (this.f1505e) {
                this.f1526z = true;
            } else {
                fragment.J = false;
                Q0(fragment, this.f1517q, 0, 0, false);
            }
        }
    }

    public boolean T(MenuItem menuItem) {
        if (this.f1517q < 1) {
            return false;
        }
        for (int i4 = 0; i4 < this.f1507g.size(); i4++) {
            Fragment fragment = this.f1507g.get(i4);
            if (fragment != null && fragment.N0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void U(Menu menu) {
        if (this.f1517q < 1) {
            return;
        }
        for (int i4 = 0; i4 < this.f1507g.size(); i4++) {
            Fragment fragment = this.f1507g.get(i4);
            if (fragment != null) {
                fragment.O0(menu);
            }
        }
    }

    boolean U0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i4, int i5) {
        int i6;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f1509i;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i4 < 0 && (i5 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1509i.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i4 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f1509i.get(size2);
                    if ((str != null && str.equals(aVar.p())) || (i4 >= 0 && i4 == aVar.f1457u)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i5 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.f1509i.get(size2);
                        if (str == null || !str.equals(aVar2.p())) {
                            if (i4 < 0 || i4 != aVar2.f1457u) {
                                break;
                            }
                        }
                    }
                }
                i6 = size2;
            } else {
                i6 = -1;
            }
            if (i6 == this.f1509i.size() - 1) {
                return false;
            }
            for (int size3 = this.f1509i.size() - 1; size3 > i6; size3--) {
                arrayList.add(this.f1509i.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void W() {
        c0(3);
    }

    public void W0(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f1426s != this) {
            m1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.f1413f);
    }

    public void X(boolean z4) {
        for (int size = this.f1507g.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1507g.get(size);
            if (fragment != null) {
                fragment.Q0(z4);
            }
        }
    }

    public void X0(Fragment fragment) {
        if (I) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f1425r);
        }
        boolean z4 = !fragment.P();
        if (!fragment.A || z4) {
            synchronized (this.f1507g) {
                this.f1507g.remove(fragment);
            }
            if (D0(fragment)) {
                this.f1522v = true;
            }
            fragment.f1419l = false;
            fragment.f1420m = true;
        }
    }

    public boolean Y(Menu menu) {
        if (this.f1517q < 1) {
            return false;
        }
        boolean z4 = false;
        for (int i4 = 0; i4 < this.f1507g.size(); i4++) {
            Fragment fragment = this.f1507g.get(i4);
            if (fragment != null && fragment.R0(menu)) {
                z4 = true;
            }
        }
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        o1();
        V(this.f1521u);
    }

    void Z0(Fragment fragment) {
        if (G0()) {
            if (I) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.G.k(fragment) && I) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    @Override // androidx.fragment.app.i
    public n a() {
        return new androidx.fragment.app.a(this);
    }

    public void a0() {
        this.f1523w = false;
        this.f1524x = false;
        c0(4);
    }

    void a1() {
        if (this.f1515o != null) {
            for (int i4 = 0; i4 < this.f1515o.size(); i4++) {
                this.f1515o.get(i4).a();
            }
        }
    }

    @Override // androidx.fragment.app.i
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.f1508h.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.f1508h.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.e(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f1507g.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i4 = 0; i4 < size5; i4++) {
                Fragment fragment2 = this.f1507g.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f1510j;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i5 = 0; i5 < size4; i5++) {
                Fragment fragment3 = this.f1510j.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f1509i;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i6 = 0; i6 < size3; i6++) {
                androidx.fragment.app.a aVar = this.f1509i.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.k(str2, printWriter);
            }
        }
        synchronized (this) {
            ArrayList<androidx.fragment.app.a> arrayList3 = this.f1513m;
            if (arrayList3 != null && (size2 = arrayList3.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i7 = 0; i7 < size2; i7++) {
                    Object obj = (androidx.fragment.app.a) this.f1513m.get(i7);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i7);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            ArrayList<Integer> arrayList4 = this.f1514n;
            if (arrayList4 != null && arrayList4.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f1514n.toArray()));
            }
        }
        ArrayList<k> arrayList5 = this.f1504d;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i8 = 0; i8 < size; i8++) {
                Object obj2 = (k) this.f1504d.get(i8);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i8);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1518r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1519s);
        if (this.f1520t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1520t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1517q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1523w);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1524x);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1525y);
        if (this.f1522v) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1522v);
        }
    }

    public void b0() {
        this.f1523w = false;
        this.f1524x = false;
        c0(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b1(Parcelable parcelable) {
        androidx.fragment.app.m mVar;
        if (parcelable == null) {
            return;
        }
        androidx.fragment.app.k kVar = (androidx.fragment.app.k) parcelable;
        if (kVar.f1558b == null) {
            return;
        }
        for (Fragment fragment : this.G.h()) {
            if (I) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
            }
            Iterator<androidx.fragment.app.m> it = kVar.f1558b.iterator();
            while (true) {
                if (it.hasNext()) {
                    mVar = it.next();
                    if (mVar.f1571c.equals(fragment.f1413f)) {
                        break;
                    }
                } else {
                    mVar = null;
                    break;
                }
            }
            if (mVar == null) {
                if (I) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + kVar.f1558b);
                }
                Q0(fragment, 1, 0, 0, false);
                fragment.f1420m = true;
                Q0(fragment, 0, 0, 0, false);
            } else {
                mVar.f1583o = fragment;
                fragment.f1411d = null;
                fragment.f1425r = 0;
                fragment.f1422o = false;
                fragment.f1419l = false;
                Fragment fragment2 = fragment.f1415h;
                fragment.f1416i = fragment2 != null ? fragment2.f1413f : null;
                fragment.f1415h = null;
                Bundle bundle = mVar.f1582n;
                if (bundle != null) {
                    bundle.setClassLoader(this.f1518r.i().getClassLoader());
                    fragment.f1411d = mVar.f1582n.getSparseParcelableArray("android:view_state");
                    fragment.f1410c = mVar.f1582n;
                }
            }
        }
        this.f1508h.clear();
        Iterator<androidx.fragment.app.m> it2 = kVar.f1558b.iterator();
        while (it2.hasNext()) {
            androidx.fragment.app.m next = it2.next();
            if (next != null) {
                Fragment f4 = next.f(this.f1518r.i().getClassLoader(), c());
                f4.f1426s = this;
                if (I) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + f4.f1413f + "): " + f4);
                }
                this.f1508h.put(f4.f1413f, f4);
                next.f1583o = null;
            }
        }
        this.f1507g.clear();
        ArrayList<String> arrayList = kVar.f1559c;
        if (arrayList != null) {
            Iterator<String> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String next2 = it3.next();
                Fragment fragment3 = this.f1508h.get(next2);
                if (fragment3 == null) {
                    m1(new IllegalStateException("No instantiated fragment for (" + next2 + ")"));
                }
                fragment3.f1419l = true;
                if (I) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + next2 + "): " + fragment3);
                }
                if (this.f1507g.contains(fragment3)) {
                    throw new IllegalStateException("Already added " + fragment3);
                }
                synchronized (this.f1507g) {
                    this.f1507g.add(fragment3);
                }
            }
        }
        if (kVar.f1560d != null) {
            this.f1509i = new ArrayList<>(kVar.f1560d.length);
            int i4 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = kVar.f1560d;
                if (i4 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a f5 = bVarArr[i4].f(this);
                if (I) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i4 + " (index " + f5.f1457u + "): " + f5);
                    PrintWriter printWriter = new PrintWriter(new x.b("FragmentManager"));
                    f5.l("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1509i.add(f5);
                int i5 = f5.f1457u;
                if (i5 >= 0) {
                    h1(i5, f5);
                }
                i4++;
            }
        } else {
            this.f1509i = null;
        }
        String str = kVar.f1561e;
        if (str != null) {
            Fragment fragment4 = this.f1508h.get(str);
            this.f1521u = fragment4;
            V(fragment4);
        }
        this.f1506f = kVar.f1562f;
    }

    @Override // androidx.fragment.app.i
    public androidx.fragment.app.g c() {
        if (super.c() == androidx.fragment.app.i.f1502c) {
            Fragment fragment = this.f1520t;
            if (fragment != null) {
                return fragment.f1426s.c();
            }
            g(new f());
        }
        return super.c();
    }

    @Override // androidx.fragment.app.i
    public List<Fragment> d() {
        List<Fragment> list;
        if (this.f1507g.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1507g) {
            list = (List) this.f1507g.clone();
        }
        return list;
    }

    public void d0() {
        this.f1524x = true;
        c0(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable d1() {
        ArrayList<String> arrayList;
        int size;
        r0();
        f0();
        j0();
        this.f1523w = true;
        androidx.fragment.app.b[] bVarArr = null;
        if (this.f1508h.isEmpty()) {
            return null;
        }
        ArrayList<androidx.fragment.app.m> arrayList2 = new ArrayList<>(this.f1508h.size());
        boolean z4 = false;
        for (Fragment fragment : this.f1508h.values()) {
            if (fragment != null) {
                if (fragment.f1426s != this) {
                    m1(new IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                }
                androidx.fragment.app.m mVar = new androidx.fragment.app.m(fragment);
                arrayList2.add(mVar);
                if (fragment.f1409b <= 0 || mVar.f1582n != null) {
                    mVar.f1582n = fragment.f1410c;
                } else {
                    mVar.f1582n = e1(fragment);
                    String str = fragment.f1416i;
                    if (str != null) {
                        Fragment fragment2 = this.f1508h.get(str);
                        if (fragment2 == null) {
                            m1(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f1416i));
                        }
                        if (mVar.f1582n == null) {
                            mVar.f1582n = new Bundle();
                        }
                        W0(mVar.f1582n, "android:target_state", fragment2);
                        int i4 = fragment.f1417j;
                        if (i4 != 0) {
                            mVar.f1582n.putInt("android:target_req_state", i4);
                        }
                    }
                }
                if (I) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + mVar.f1582n);
                }
                z4 = true;
            }
        }
        if (!z4) {
            if (I) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.f1507g.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<Fragment> it = this.f1507g.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.f1413f);
                if (next.f1426s != this) {
                    m1(new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                }
                if (I) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.f1413f + "): " + next);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f1509i;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i5 = 0; i5 < size; i5++) {
                bVarArr[i5] = new androidx.fragment.app.b(this.f1509i.get(i5));
                if (I) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.f1509i.get(i5));
                }
            }
        }
        androidx.fragment.app.k kVar = new androidx.fragment.app.k();
        kVar.f1558b = arrayList2;
        kVar.f1559c = arrayList;
        kVar.f1560d = bVarArr;
        Fragment fragment3 = this.f1521u;
        if (fragment3 != null) {
            kVar.f1561e = fragment3.f1413f;
        }
        kVar.f1562f = this.f1506f;
        return kVar;
    }

    @Override // androidx.fragment.app.i
    public void e(int i4, int i5) {
        if (i4 >= 0) {
            g0(new l(null, i4, i5), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i4);
    }

    void e0() {
        if (this.f1526z) {
            this.f1526z = false;
            l1();
        }
    }

    Bundle e1(Fragment fragment) {
        if (this.D == null) {
            this.D = new Bundle();
        }
        fragment.U0(this.D);
        O(fragment, this.D, false);
        Bundle bundle = null;
        if (!this.D.isEmpty()) {
            Bundle bundle2 = this.D;
            this.D = null;
            bundle = bundle2;
        }
        if (fragment.H != null) {
            f1(fragment);
        }
        if (fragment.f1411d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f1411d);
        }
        if (!fragment.K) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.K);
        }
        return bundle;
    }

    @Override // androidx.fragment.app.i
    public boolean f() {
        r();
        return T0(null, -1, 0);
    }

    void f1(Fragment fragment) {
        if (fragment.I == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.E;
        if (sparseArray == null) {
            this.E = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.I.saveHierarchyState(this.E);
        if (this.E.size() > 0) {
            fragment.f1411d = this.E;
            this.E = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g0(androidx.fragment.app.j.k r2, boolean r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L5
            r1.r()
        L5:
            monitor-enter(r1)
            boolean r0 = r1.f1525y     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto L24
            androidx.fragment.app.h r0 = r1.f1518r     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lf
            goto L24
        Lf:
            java.util.ArrayList<androidx.fragment.app.j$k> r3 = r1.f1504d     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            r1.f1504d = r3     // Catch: java.lang.Throwable -> L30
        L1a:
            java.util.ArrayList<androidx.fragment.app.j$k> r3 = r1.f1504d     // Catch: java.lang.Throwable -> L30
            r3.add(r2)     // Catch: java.lang.Throwable -> L30
            r1.g1()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L24:
            if (r3 == 0) goto L28
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L28:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Activity has been destroyed"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30
            throw r2     // Catch: java.lang.Throwable -> L30
        L30:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.g0(androidx.fragment.app.j$k, boolean):void");
    }

    void g1() {
        synchronized (this) {
            ArrayList<m> arrayList = this.F;
            boolean z4 = false;
            boolean z5 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            ArrayList<k> arrayList2 = this.f1504d;
            if (arrayList2 != null && arrayList2.size() == 1) {
                z4 = true;
            }
            if (z5 || z4) {
                this.f1518r.j().removeCallbacks(this.H);
                this.f1518r.j().post(this.H);
                o1();
            }
        }
    }

    public void h1(int i4, androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.f1513m == null) {
                this.f1513m = new ArrayList<>();
            }
            int size = this.f1513m.size();
            if (i4 < size) {
                if (I) {
                    Log.v("FragmentManager", "Setting back stack index " + i4 + " to " + aVar);
                }
                this.f1513m.set(i4, aVar);
            } else {
                while (size < i4) {
                    this.f1513m.add(null);
                    if (this.f1514n == null) {
                        this.f1514n = new ArrayList<>();
                    }
                    if (I) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f1514n.add(Integer.valueOf(size));
                    size++;
                }
                if (I) {
                    Log.v("FragmentManager", "Adding back stack index " + i4 + " with " + aVar);
                }
                this.f1513m.add(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(androidx.fragment.app.a aVar) {
        if (this.f1509i == null) {
            this.f1509i = new ArrayList<>();
        }
        this.f1509i.add(aVar);
    }

    void i0(Fragment fragment) {
        if (!fragment.f1421n || fragment.f1424q) {
            return;
        }
        fragment.G0(fragment.K0(fragment.f1410c), null, fragment.f1410c);
        View view = fragment.H;
        if (view == null) {
            fragment.I = null;
            return;
        }
        fragment.I = view;
        view.setSaveFromParentEnabled(false);
        if (fragment.f1433z) {
            fragment.H.setVisibility(8);
        }
        fragment.y0(fragment.H, fragment.f1410c);
        R(fragment, fragment.H, fragment.f1410c, false);
    }

    public void i1(Fragment fragment, d.b bVar) {
        if (this.f1508h.get(fragment.f1413f) == fragment && (fragment.f1427t == null || fragment.u() == this)) {
            fragment.S = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void j(Fragment fragment, boolean z4) {
        if (I) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        I0(fragment);
        if (fragment.A) {
            return;
        }
        if (this.f1507g.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f1507g) {
            this.f1507g.add(fragment);
        }
        fragment.f1419l = true;
        fragment.f1420m = false;
        if (fragment.H == null) {
            fragment.O = false;
        }
        if (D0(fragment)) {
            this.f1522v = true;
        }
        if (z4) {
            P0(fragment);
        }
    }

    public boolean j0() {
        h0(true);
        boolean z4 = false;
        while (t0(this.A, this.B)) {
            this.f1505e = true;
            try {
                Y0(this.A, this.B);
                s();
                z4 = true;
            } catch (Throwable th) {
                s();
                throw th;
            }
        }
        o1();
        e0();
        p();
        return z4;
    }

    public void j1(Fragment fragment) {
        if (fragment == null || (this.f1508h.get(fragment.f1413f) == fragment && (fragment.f1427t == null || fragment.u() == this))) {
            Fragment fragment2 = this.f1521u;
            this.f1521u = fragment;
            V(fragment2);
            V(this.f1521u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void k(Fragment fragment) {
        if (G0()) {
            if (I) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.G.d(fragment) && I) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public void k1(Fragment fragment) {
        if (I) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f1433z) {
            fragment.f1433z = false;
            fragment.O = !fragment.O;
        }
    }

    public int l(androidx.fragment.app.a aVar) {
        synchronized (this) {
            ArrayList<Integer> arrayList = this.f1514n;
            if (arrayList != null && arrayList.size() > 0) {
                int intValue = this.f1514n.remove(r0.size() - 1).intValue();
                if (I) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + aVar);
                }
                this.f1513m.set(intValue, aVar);
                return intValue;
            }
            if (this.f1513m == null) {
                this.f1513m = new ArrayList<>();
            }
            int size = this.f1513m.size();
            if (I) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.f1513m.add(aVar);
            return size;
        }
    }

    void l1() {
        for (Fragment fragment : this.f1508h.values()) {
            if (fragment != null) {
                S0(fragment);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(androidx.fragment.app.h hVar, androidx.fragment.app.e eVar, Fragment fragment) {
        if (this.f1518r != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1518r = hVar;
        this.f1519s = eVar;
        this.f1520t = fragment;
        if (fragment != null) {
            o1();
        }
        if (hVar instanceof androidx.activity.c) {
            androidx.activity.c cVar = (androidx.activity.c) hVar;
            OnBackPressedDispatcher c5 = cVar.c();
            this.f1511k = c5;
            androidx.lifecycle.g gVar = cVar;
            if (fragment != null) {
                gVar = fragment;
            }
            c5.a(gVar, this.f1512l);
        }
        this.G = fragment != null ? fragment.f1426s.v0(fragment) : hVar instanceof androidx.lifecycle.s ? androidx.fragment.app.l.g(((androidx.lifecycle.s) hVar).h()) : new androidx.fragment.app.l(false);
    }

    public Fragment n0(int i4) {
        for (int size = this.f1507g.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1507g.get(size);
            if (fragment != null && fragment.f1430w == i4) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.f1508h.values()) {
            if (fragment2 != null && fragment2.f1430w == i4) {
                return fragment2;
            }
        }
        return null;
    }

    public void o(Fragment fragment) {
        if (I) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.A) {
            fragment.A = false;
            if (fragment.f1419l) {
                return;
            }
            if (this.f1507g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (I) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.f1507g) {
                this.f1507g.add(fragment);
            }
            fragment.f1419l = true;
            if (D0(fragment)) {
                this.f1522v = true;
            }
        }
    }

    public Fragment o0(String str) {
        if (str != null) {
            for (int size = this.f1507g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f1507g.get(size);
                if (fragment != null && str.equals(fragment.f1432y)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment fragment2 : this.f1508h.values()) {
            if (fragment2 != null && str.equals(fragment2.f1432y)) {
                return fragment2;
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0011j.f1550a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str2 == null || !androidx.fragment.app.g.b(context.getClassLoader(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment n02 = resourceId != -1 ? n0(resourceId) : null;
        if (n02 == null && string != null) {
            n02 = o0(string);
        }
        if (n02 == null && id != -1) {
            n02 = n0(id);
        }
        if (I) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + n02);
        }
        if (n02 == null) {
            n02 = c().a(context.getClassLoader(), str2);
            n02.f1421n = true;
            n02.f1430w = resourceId != 0 ? resourceId : id;
            n02.f1431x = id;
            n02.f1432y = string;
            n02.f1422o = true;
            n02.f1426s = this;
            androidx.fragment.app.h hVar = this.f1518r;
            n02.f1427t = hVar;
            n02.l0(hVar.i(), attributeSet, n02.f1410c);
            j(n02, true);
        } else {
            if (n02.f1422o) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            n02.f1422o = true;
            androidx.fragment.app.h hVar2 = this.f1518r;
            n02.f1427t = hVar2;
            n02.l0(hVar2.i(), attributeSet, n02.f1410c);
        }
        Fragment fragment = n02;
        if (this.f1517q >= 1 || !fragment.f1421n) {
            P0(fragment);
        } else {
            Q0(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.H;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.H.getTag() == null) {
                fragment.H.setTag(string);
            }
            return fragment.H;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public Fragment p0(String str) {
        Fragment g4;
        for (Fragment fragment : this.f1508h.values()) {
            if (fragment != null && (g4 = fragment.g(str)) != null) {
                return g4;
            }
        }
        return null;
    }

    boolean q() {
        boolean z4 = false;
        for (Fragment fragment : this.f1508h.values()) {
            if (fragment != null) {
                z4 = D0(fragment);
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    public void s0(int i4) {
        synchronized (this) {
            this.f1513m.set(i4, null);
            if (this.f1514n == null) {
                this.f1514n = new ArrayList<>();
            }
            if (I) {
                Log.v("FragmentManager", "Freeing back stack index " + i4);
            }
            this.f1514n.add(Integer.valueOf(i4));
        }
    }

    void t(androidx.fragment.app.a aVar, boolean z4, boolean z5, boolean z6) {
        if (z4) {
            aVar.n(z6);
        } else {
            aVar.m();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z4));
        if (z5) {
            o.B(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z6) {
            O0(this.f1517q, true);
        }
        for (Fragment fragment : this.f1508h.values()) {
            if (fragment != null && fragment.H != null && fragment.N && aVar.q(fragment.f1431x)) {
                float f4 = fragment.P;
                if (f4 > 0.0f) {
                    fragment.H.setAlpha(f4);
                }
                if (z6) {
                    fragment.P = 0.0f;
                } else {
                    fragment.P = -1.0f;
                    fragment.N = false;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.f1520t;
        if (obj == null) {
            obj = this.f1518r;
        }
        x.a.a(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    void u(Fragment fragment) {
        Animator animator;
        if (fragment.H != null) {
            g H0 = H0(fragment, fragment.y(), !fragment.f1433z, fragment.z());
            if (H0 == null || (animator = H0.f1543b) == null) {
                if (H0 != null) {
                    fragment.H.startAnimation(H0.f1542a);
                    H0.f1542a.start();
                }
                fragment.H.setVisibility((!fragment.f1433z || fragment.O()) ? 0 : 8);
                if (fragment.O()) {
                    fragment.h1(false);
                }
            } else {
                animator.setTarget(fragment.H);
                if (!fragment.f1433z) {
                    fragment.H.setVisibility(0);
                } else if (fragment.O()) {
                    fragment.h1(false);
                } else {
                    ViewGroup viewGroup = fragment.G;
                    View view = fragment.H;
                    viewGroup.startViewTransition(view);
                    H0.f1543b.addListener(new e(viewGroup, view, fragment));
                }
                H0.f1543b.start();
            }
        }
        if (fragment.f1419l && D0(fragment)) {
            this.f1522v = true;
        }
        fragment.O = false;
        fragment.j0(fragment.f1433z);
    }

    public int u0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f1509i;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void v(Fragment fragment) {
        if (I) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.A) {
            return;
        }
        fragment.A = true;
        if (fragment.f1419l) {
            if (I) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.f1507g) {
                this.f1507g.remove(fragment);
            }
            if (D0(fragment)) {
                this.f1522v = true;
            }
            fragment.f1419l = false;
        }
    }

    androidx.fragment.app.l v0(Fragment fragment) {
        return this.G.f(fragment);
    }

    public void w() {
        this.f1523w = false;
        this.f1524x = false;
        c0(2);
    }

    public Fragment w0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.f1508h.get(string);
        if (fragment == null) {
            m1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragment;
    }

    public void x(Configuration configuration) {
        for (int i4 = 0; i4 < this.f1507g.size(); i4++) {
            Fragment fragment = this.f1507g.get(i4);
            if (fragment != null) {
                fragment.C0(configuration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 x0() {
        return this;
    }

    public boolean y(MenuItem menuItem) {
        if (this.f1517q < 1) {
            return false;
        }
        for (int i4 = 0; i4 < this.f1507g.size(); i4++) {
            Fragment fragment = this.f1507g.get(i4);
            if (fragment != null && fragment.D0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Fragment y0() {
        return this.f1521u;
    }

    public void z() {
        this.f1523w = false;
        this.f1524x = false;
        c0(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.r z0(Fragment fragment) {
        return this.G.i(fragment);
    }
}
