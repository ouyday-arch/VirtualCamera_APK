package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.d;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.g, androidx.lifecycle.s, androidx.savedstate.b {
    static final Object Y = new Object();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    private boolean F;
    ViewGroup G;
    View H;
    View I;
    boolean J;
    d L;
    boolean N;
    boolean O;
    float P;
    LayoutInflater Q;
    boolean R;
    androidx.lifecycle.h T;
    r U;
    androidx.savedstate.a W;
    private int X;

    /* renamed from: c, reason: collision with root package name */
    Bundle f1410c;

    /* renamed from: d, reason: collision with root package name */
    SparseArray<Parcelable> f1411d;

    /* renamed from: e, reason: collision with root package name */
    Boolean f1412e;

    /* renamed from: g, reason: collision with root package name */
    Bundle f1414g;

    /* renamed from: h, reason: collision with root package name */
    Fragment f1415h;

    /* renamed from: j, reason: collision with root package name */
    int f1417j;

    /* renamed from: l, reason: collision with root package name */
    boolean f1419l;

    /* renamed from: m, reason: collision with root package name */
    boolean f1420m;

    /* renamed from: n, reason: collision with root package name */
    boolean f1421n;

    /* renamed from: o, reason: collision with root package name */
    boolean f1422o;

    /* renamed from: p, reason: collision with root package name */
    boolean f1423p;

    /* renamed from: q, reason: collision with root package name */
    boolean f1424q;

    /* renamed from: r, reason: collision with root package name */
    int f1425r;

    /* renamed from: s, reason: collision with root package name */
    j f1426s;

    /* renamed from: t, reason: collision with root package name */
    h f1427t;

    /* renamed from: v, reason: collision with root package name */
    Fragment f1429v;

    /* renamed from: w, reason: collision with root package name */
    int f1430w;

    /* renamed from: x, reason: collision with root package name */
    int f1431x;

    /* renamed from: y, reason: collision with root package name */
    String f1432y;

    /* renamed from: z, reason: collision with root package name */
    boolean f1433z;

    /* renamed from: b, reason: collision with root package name */
    int f1409b = 0;

    /* renamed from: f, reason: collision with root package name */
    String f1413f = UUID.randomUUID().toString();

    /* renamed from: i, reason: collision with root package name */
    String f1416i = null;

    /* renamed from: k, reason: collision with root package name */
    private Boolean f1418k = null;

    /* renamed from: u, reason: collision with root package name */
    j f1428u = new j();
    boolean E = true;
    boolean K = true;
    Runnable M = new a();
    d.b S = d.b.RESUMED;
    androidx.lifecycle.l<androidx.lifecycle.g> V = new androidx.lifecycle.l<>();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.b();
        }
    }

    /* loaded from: classes.dex */
    class c extends androidx.fragment.app.e {
        c() {
        }

        @Override // androidx.fragment.app.e
        public View e(int i4) {
            View view = Fragment.this.H;
            if (view != null) {
                return view.findViewById(i4);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        @Override // androidx.fragment.app.e
        public boolean f() {
            return Fragment.this.H != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        View f1438a;

        /* renamed from: b, reason: collision with root package name */
        Animator f1439b;

        /* renamed from: c, reason: collision with root package name */
        int f1440c;

        /* renamed from: d, reason: collision with root package name */
        int f1441d;

        /* renamed from: e, reason: collision with root package name */
        int f1442e;

        /* renamed from: f, reason: collision with root package name */
        int f1443f;

        /* renamed from: g, reason: collision with root package name */
        Object f1444g = null;

        /* renamed from: h, reason: collision with root package name */
        Object f1445h;

        /* renamed from: i, reason: collision with root package name */
        Object f1446i;

        /* renamed from: j, reason: collision with root package name */
        Object f1447j;

        /* renamed from: k, reason: collision with root package name */
        Object f1448k;

        /* renamed from: l, reason: collision with root package name */
        Object f1449l;

        /* renamed from: m, reason: collision with root package name */
        Boolean f1450m;

        /* renamed from: n, reason: collision with root package name */
        Boolean f1451n;

        /* renamed from: o, reason: collision with root package name */
        boolean f1452o;

        /* renamed from: p, reason: collision with root package name */
        f f1453p;

        /* renamed from: q, reason: collision with root package name */
        boolean f1454q;

        d() {
            Object obj = Fragment.Y;
            this.f1445h = obj;
            this.f1446i = null;
            this.f1447j = obj;
            this.f1448k = null;
            this.f1449l = obj;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends RuntimeException {
        public e(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b();
    }

    public Fragment() {
        L();
    }

    private void L() {
        this.T = new androidx.lifecycle.h(this);
        this.W = androidx.savedstate.a.a(this);
        this.T.a(new androidx.lifecycle.e() { // from class: androidx.fragment.app.Fragment.2
            @Override // androidx.lifecycle.e
            public void d(androidx.lifecycle.g gVar, d.a aVar) {
                View view;
                if (aVar != d.a.ON_STOP || (view = Fragment.this.H) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
    }

    @Deprecated
    public static Fragment N(Context context, String str, Bundle bundle) {
        try {
            Fragment newInstance = g.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.g1(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e4) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
        } catch (InstantiationException e5) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e5);
        } catch (NoSuchMethodException e6) {
            throw new e("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e6);
        } catch (InvocationTargetException e7) {
            throw new e("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e7);
        }
    }

    private d f() {
        if (this.L == null) {
            this.L = new d();
        }
        return this.L;
    }

    public final Fragment A() {
        return this.f1429v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A0(Bundle bundle) {
        this.f1428u.R0();
        this.f1409b = 2;
        this.F = false;
        T(bundle);
        if (this.F) {
            this.f1428u.w();
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public Object B() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1447j;
        return obj == Y ? s() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B0() {
        this.f1428u.n(this.f1427t, new c(), this);
        this.F = false;
        W(this.f1427t.i());
        if (this.F) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onAttach()");
    }

    public final Resources C() {
        return Z0().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.f1428u.x(configuration);
    }

    public final boolean D() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D0(MenuItem menuItem) {
        if (this.f1433z) {
            return false;
        }
        return Y(menuItem) || this.f1428u.y(menuItem);
    }

    public Object E() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1445h;
        return obj == Y ? q() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E0(Bundle bundle) {
        this.f1428u.R0();
        this.f1409b = 1;
        this.F = false;
        this.W.c(bundle);
        Z(bundle);
        this.R = true;
        if (this.F) {
            this.T.i(d.a.ON_CREATE);
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onCreate()");
    }

    public Object F() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        return dVar.f1448k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F0(Menu menu, MenuInflater menuInflater) {
        boolean z4 = false;
        if (this.f1433z) {
            return false;
        }
        if (this.D && this.E) {
            z4 = true;
            c0(menu, menuInflater);
        }
        return z4 | this.f1428u.A(menu, menuInflater);
    }

    public Object G() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1449l;
        return obj == Y ? F() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1428u.R0();
        this.f1424q = true;
        this.U = new r();
        View d02 = d0(layoutInflater, viewGroup, bundle);
        this.H = d02;
        if (d02 != null) {
            this.U.e();
            this.V.g(this.U);
        } else {
            if (this.U.f()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.U = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int H() {
        d dVar = this.L;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1440c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H0() {
        this.f1428u.B();
        this.T.i(d.a.ON_DESTROY);
        this.f1409b = 0;
        this.F = false;
        this.R = false;
        e0();
        if (this.F) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public final String I(int i4) {
        return C().getString(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I0() {
        this.f1428u.C();
        if (this.H != null) {
            this.U.b(d.a.ON_DESTROY);
        }
        this.f1409b = 1;
        this.F = false;
        g0();
        if (this.F) {
            androidx.loader.app.a.b(this).c();
            this.f1424q = false;
        } else {
            throw new s("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public final Fragment J() {
        String str;
        Fragment fragment = this.f1415h;
        if (fragment != null) {
            return fragment;
        }
        j jVar = this.f1426s;
        if (jVar == null || (str = this.f1416i) == null) {
            return null;
        }
        return jVar.f1508h.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J0() {
        this.F = false;
        h0();
        this.Q = null;
        if (this.F) {
            if (this.f1428u.C0()) {
                return;
            }
            this.f1428u.B();
            this.f1428u = new j();
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onDetach()");
    }

    public View K() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater K0(Bundle bundle) {
        LayoutInflater i02 = i0(bundle);
        this.Q = i02;
        return i02;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L0() {
        onLowMemory();
        this.f1428u.D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M() {
        L();
        this.f1413f = UUID.randomUUID().toString();
        this.f1419l = false;
        this.f1420m = false;
        this.f1421n = false;
        this.f1422o = false;
        this.f1423p = false;
        this.f1425r = 0;
        this.f1426s = null;
        this.f1428u = new j();
        this.f1427t = null;
        this.f1430w = 0;
        this.f1431x = 0;
        this.f1432y = null;
        this.f1433z = false;
        this.A = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M0(boolean z4) {
        m0(z4);
        this.f1428u.E(z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean N0(MenuItem menuItem) {
        if (this.f1433z) {
            return false;
        }
        return (this.D && this.E && n0(menuItem)) || this.f1428u.T(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O() {
        d dVar = this.L;
        if (dVar == null) {
            return false;
        }
        return dVar.f1454q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(Menu menu) {
        if (this.f1433z) {
            return;
        }
        if (this.D && this.E) {
            o0(menu);
        }
        this.f1428u.U(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean P() {
        return this.f1425r > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0() {
        this.f1428u.W();
        if (this.H != null) {
            this.U.b(d.a.ON_PAUSE);
        }
        this.T.i(d.a.ON_PAUSE);
        this.f1409b = 3;
        this.F = false;
        p0();
        if (this.F) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Q() {
        d dVar = this.L;
        if (dVar == null) {
            return false;
        }
        return dVar.f1452o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q0(boolean z4) {
        q0(z4);
        this.f1428u.X(z4);
    }

    public final boolean R() {
        j jVar = this.f1426s;
        if (jVar == null) {
            return false;
        }
        return jVar.G0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R0(Menu menu) {
        boolean z4 = false;
        if (this.f1433z) {
            return false;
        }
        if (this.D && this.E) {
            z4 = true;
            r0(menu);
        }
        return z4 | this.f1428u.Y(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        this.f1428u.R0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S0() {
        boolean E0 = this.f1426s.E0(this);
        Boolean bool = this.f1418k;
        if (bool == null || bool.booleanValue() != E0) {
            this.f1418k = Boolean.valueOf(E0);
            s0(E0);
            this.f1428u.Z();
        }
    }

    public void T(Bundle bundle) {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T0() {
        this.f1428u.R0();
        this.f1428u.j0();
        this.f1409b = 4;
        this.F = false;
        u0();
        if (!this.F) {
            throw new s("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.h hVar = this.T;
        d.a aVar = d.a.ON_RESUME;
        hVar.i(aVar);
        if (this.H != null) {
            this.U.b(aVar);
        }
        this.f1428u.a0();
        this.f1428u.j0();
    }

    public void U(int i4, int i5, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U0(Bundle bundle) {
        v0(bundle);
        this.W.d(bundle);
        Parcelable d12 = this.f1428u.d1();
        if (d12 != null) {
            bundle.putParcelable("android:support:fragments", d12);
        }
    }

    @Deprecated
    public void V(Activity activity) {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V0() {
        this.f1428u.R0();
        this.f1428u.j0();
        this.f1409b = 3;
        this.F = false;
        w0();
        if (!this.F) {
            throw new s("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.h hVar = this.T;
        d.a aVar = d.a.ON_START;
        hVar.i(aVar);
        if (this.H != null) {
            this.U.b(aVar);
        }
        this.f1428u.b0();
    }

    public void W(Context context) {
        this.F = true;
        h hVar = this.f1427t;
        Activity g4 = hVar == null ? null : hVar.g();
        if (g4 != null) {
            this.F = false;
            V(g4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W0() {
        this.f1428u.d0();
        if (this.H != null) {
            this.U.b(d.a.ON_STOP);
        }
        this.T.i(d.a.ON_STOP);
        this.f1409b = 2;
        this.F = false;
        x0();
        if (this.F) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onStop()");
    }

    public void X(Fragment fragment) {
    }

    public final void X0(String[] strArr, int i4) {
        h hVar = this.f1427t;
        if (hVar != null) {
            hVar.q(this, strArr, i4);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public boolean Y(MenuItem menuItem) {
        return false;
    }

    public final androidx.fragment.app.d Y0() {
        androidx.fragment.app.d i4 = i();
        if (i4 != null) {
            return i4;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public void Z(Bundle bundle) {
        this.F = true;
        c1(bundle);
        if (this.f1428u.F0(1)) {
            return;
        }
        this.f1428u.z();
    }

    public final Context Z0() {
        Context p4 = p();
        if (p4 != null) {
            return p4;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.d a() {
        return this.T;
    }

    public Animation a0(int i4, boolean z4, int i5) {
        return null;
    }

    public final i a1() {
        i u4 = u();
        if (u4 != null) {
            return u4;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    void b() {
        d dVar = this.L;
        f fVar = null;
        if (dVar != null) {
            dVar.f1452o = false;
            f fVar2 = dVar.f1453p;
            dVar.f1453p = null;
            fVar = fVar2;
        }
        if (fVar != null) {
            fVar.a();
        }
    }

    public Animator b0(int i4, boolean z4, int i5) {
        return null;
    }

    public final View b1() {
        View K = K();
        if (K != null) {
            return K;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void c0(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f1428u.b1(parcelable);
        this.f1428u.z();
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry d() {
        return this.W.b();
    }

    public View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i4 = this.X;
        if (i4 != 0) {
            return layoutInflater.inflate(i4, viewGroup, false);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f1411d;
        if (sparseArray != null) {
            this.I.restoreHierarchyState(sparseArray);
            this.f1411d = null;
        }
        this.F = false;
        z0(bundle);
        if (this.F) {
            if (this.H != null) {
                this.U.b(d.a.ON_CREATE);
            }
        } else {
            throw new s("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f1430w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f1431x));
        printWriter.print(" mTag=");
        printWriter.println(this.f1432y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f1409b);
        printWriter.print(" mWho=");
        printWriter.print(this.f1413f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f1425r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f1419l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f1420m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f1421n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f1422o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f1433z);
        printWriter.print(" mDetached=");
        printWriter.print(this.A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.B);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.K);
        if (this.f1426s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f1426s);
        }
        if (this.f1427t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f1427t);
        }
        if (this.f1429v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f1429v);
        }
        if (this.f1414g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f1414g);
        }
        if (this.f1410c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f1410c);
        }
        if (this.f1411d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f1411d);
        }
        Fragment J = J();
        if (J != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(J);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f1417j);
        }
        if (x() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(x());
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.H);
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.H);
        }
        if (l() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(l());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(H());
        }
        if (p() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f1428u + ":");
        this.f1428u.b(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public void e0() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e1(View view) {
        f().f1438a = view;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f1(Animator animator) {
        f().f1439b = animator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment g(String str) {
        return str.equals(this.f1413f) ? this : this.f1428u.p0(str);
    }

    public void g0() {
        this.F = true;
    }

    public void g1(Bundle bundle) {
        if (this.f1426s != null && R()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f1414g = bundle;
    }

    @Override // androidx.lifecycle.s
    public androidx.lifecycle.r h() {
        j jVar = this.f1426s;
        if (jVar != null) {
            return jVar.z0(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void h0() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h1(boolean z4) {
        f().f1454q = z4;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final androidx.fragment.app.d i() {
        h hVar = this.f1427t;
        if (hVar == null) {
            return null;
        }
        return (androidx.fragment.app.d) hVar.g();
    }

    public LayoutInflater i0(Bundle bundle) {
        return w(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i1(int i4) {
        if (this.L == null && i4 == 0) {
            return;
        }
        f().f1441d = i4;
    }

    public boolean j() {
        Boolean bool;
        d dVar = this.L;
        if (dVar == null || (bool = dVar.f1451n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void j0(boolean z4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j1(int i4, int i5) {
        if (this.L == null && i4 == 0 && i5 == 0) {
            return;
        }
        f();
        d dVar = this.L;
        dVar.f1442e = i4;
        dVar.f1443f = i5;
    }

    public boolean k() {
        Boolean bool;
        d dVar = this.L;
        if (dVar == null || (bool = dVar.f1450m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public void k0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k1(f fVar) {
        f();
        d dVar = this.L;
        f fVar2 = dVar.f1453p;
        if (fVar == fVar2) {
            return;
        }
        if (fVar != null && fVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (dVar.f1452o) {
            dVar.f1453p = fVar;
        }
        if (fVar != null) {
            fVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View l() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        return dVar.f1438a;
    }

    public void l0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
        h hVar = this.f1427t;
        Activity g4 = hVar == null ? null : hVar.g();
        if (g4 != null) {
            this.F = false;
            k0(g4, attributeSet, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l1(int i4) {
        f().f1440c = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator m() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        return dVar.f1439b;
    }

    public void m0(boolean z4) {
    }

    public boolean m1(String str) {
        h hVar = this.f1427t;
        if (hVar != null) {
            return hVar.s(str);
        }
        return false;
    }

    public final Bundle n() {
        return this.f1414g;
    }

    public boolean n0(MenuItem menuItem) {
        return false;
    }

    public void n1() {
        j jVar = this.f1426s;
        if (jVar == null || jVar.f1518r == null) {
            f().f1452o = false;
        } else if (Looper.myLooper() != this.f1426s.f1518r.j().getLooper()) {
            this.f1426s.f1518r.j().postAtFrontOfQueue(new b());
        } else {
            b();
        }
    }

    public final i o() {
        if (this.f1427t != null) {
            return this.f1428u;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void o0(Menu menu) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.F = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Y0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.F = true;
    }

    public Context p() {
        h hVar = this.f1427t;
        if (hVar == null) {
            return null;
        }
        return hVar.i();
    }

    public void p0() {
        this.F = true;
    }

    public Object q() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        return dVar.f1444g;
    }

    public void q0(boolean z4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n.f r() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public void r0(Menu menu) {
    }

    public Object s() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        return dVar.f1446i;
    }

    public void s0(boolean z4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n.f t() {
        d dVar = this.L;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public void t0(int i4, String[] strArr, int[] iArr) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        x.a.a(this, sb);
        sb.append(" (");
        sb.append(this.f1413f);
        sb.append(")");
        if (this.f1430w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1430w));
        }
        if (this.f1432y != null) {
            sb.append(" ");
            sb.append(this.f1432y);
        }
        sb.append('}');
        return sb.toString();
    }

    public final i u() {
        return this.f1426s;
    }

    public void u0() {
        this.F = true;
    }

    public final Object v() {
        h hVar = this.f1427t;
        if (hVar == null) {
            return null;
        }
        return hVar.m();
    }

    public void v0(Bundle bundle) {
    }

    @Deprecated
    public LayoutInflater w(Bundle bundle) {
        h hVar = this.f1427t;
        if (hVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater n4 = hVar.n();
        y.e.a(n4, this.f1428u.x0());
        return n4;
    }

    public void w0() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x() {
        d dVar = this.L;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1441d;
    }

    public void x0() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y() {
        d dVar = this.L;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1442e;
    }

    public void y0(View view, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z() {
        d dVar = this.L;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1443f;
    }

    public void z0(Bundle bundle) {
        this.F = true;
    }
}
