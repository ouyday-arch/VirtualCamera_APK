package y;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import y.a;
import z.c;

/* loaded from: classes.dex */
public class p {

    /* renamed from: c, reason: collision with root package name */
    private static Field f6542c;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f6540a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private static WeakHashMap<View, t> f6541b = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f6543d = false;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f6544e = {m.a.f4883b, m.a.f4884c, m.a.f4895n, m.a.f4906y, m.a.B, m.a.C, m.a.D, m.a.E, m.a.F, m.a.G, m.a.f4885d, m.a.f4886e, m.a.f4887f, m.a.f4888g, m.a.f4889h, m.a.f4890i, m.a.f4891j, m.a.f4892k, m.a.f4893l, m.a.f4894m, m.a.f4896o, m.a.f4897p, m.a.f4898q, m.a.f4899r, m.a.f4900s, m.a.f4901t, m.a.f4902u, m.a.f4903v, m.a.f4904w, m.a.f4905x, m.a.f4907z, m.a.A};

    /* renamed from: f, reason: collision with root package name */
    private static e f6545f = new e();

    /* loaded from: classes.dex */
    static class a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f6546a;

        a(n nVar) {
            this.f6546a = nVar;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return this.f6546a.a(view, x.h(windowInsets)).g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends f<Boolean> {
        b(int i4, Class cls, int i5) {
            super(i4, cls, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // y.p.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // y.p.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            view.setScreenReaderFocusable(bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // y.p.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends f<CharSequence> {
        c(int i4, Class cls, int i5, int i6) {
            super(i4, cls, i5, i6);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // y.p.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return view.getAccessibilityPaneTitle();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // y.p.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // y.p.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d extends f<Boolean> {
        d(int i4, Class cls, int i5) {
            super(i4, cls, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // y.p.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // y.p.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            view.setAccessibilityHeading(bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // y.p.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* loaded from: classes.dex */
    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: b, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f6547b = new WeakHashMap<>();

        e() {
        }

        private void a(View view, boolean z4) {
            boolean z5 = view.getVisibility() == 0;
            if (z4 != z5) {
                if (z5) {
                    p.L(view, 16);
                }
                this.f6547b.put(view, Boolean.valueOf(z5));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            for (Map.Entry<View, Boolean> entry : this.f6547b.entrySet()) {
                a(entry.getKey(), entry.getValue().booleanValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class f<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f6548a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<T> f6549b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6550c;

        f(int i4, Class<T> cls, int i5) {
            this(i4, cls, 0, i5);
        }

        f(int i4, Class<T> cls, int i5, int i6) {
            this.f6548a = i4;
            this.f6549b = cls;
            this.f6550c = i6;
        }

        private boolean b() {
            return true;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f6550c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        abstract T d(View view);

        abstract void e(View view, T t4);

        T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T t4 = (T) view.getTag(this.f6548a);
            if (this.f6549b.isInstance(t4)) {
                return t4;
            }
            return null;
        }

        void g(View view, T t4) {
            if (c()) {
                e(view, t4);
            } else if (b() && h(f(view), t4)) {
                p.w(view);
                view.setTag(this.f6548a, t4);
                p.L(view, 0);
            }
        }

        abstract boolean h(T t4, T t5);
    }

    /* loaded from: classes.dex */
    public interface g {
        boolean a(View view, KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    static class h {

        /* renamed from: d, reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f6551d = new ArrayList<>();

        /* renamed from: a, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f6552a = null;

        /* renamed from: b, reason: collision with root package name */
        private SparseArray<WeakReference<View>> f6553b = null;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<KeyEvent> f6554c = null;

        h() {
        }

        static h a(View view) {
            int i4 = m.a.M;
            h hVar = (h) view.getTag(i4);
            if (hVar != null) {
                return hVar;
            }
            h hVar2 = new h();
            view.setTag(i4, hVar2);
            return hVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f6552a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c5 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c5 != null) {
                            return c5;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f6553b == null) {
                this.f6553b = new SparseArray<>();
            }
            return this.f6553b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(m.a.N);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((g) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f6552a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f6551d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f6552a == null) {
                    this.f6552a = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f6551d;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f6552a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f6552a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c5 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c5 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(c5));
                }
            }
            return c5 != null;
        }

        boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f6554c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f6554c = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference2 = null;
            SparseArray<WeakReference<View>> d5 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d5.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d5.valueAt(indexOfKey);
                d5.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d5.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = weakReference2.get();
            if (view != null && p.G(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static int A(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float B(View view) {
        return view.getZ();
    }

    public static boolean C(View view) {
        return view.hasOnClickListeners();
    }

    public static boolean D(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean E(View view) {
        return view.hasTransientState();
    }

    public static boolean F(View view) {
        Boolean f4 = a().f(view);
        if (f4 == null) {
            return false;
        }
        return f4.booleanValue();
    }

    public static boolean G(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean H(View view) {
        return view.isLaidOut();
    }

    public static boolean I(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static boolean J(View view) {
        return view.isPaddingRelative();
    }

    public static boolean K(View view) {
        Boolean f4 = Z().f(view);
        if (f4 == null) {
            return false;
        }
        return f4.booleanValue();
    }

    static void L(View view, int i4) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z4 = j(view) != null;
            if (i(view) != 0 || (z4 && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z4 ? 32 : 2048);
                obtain.setContentChangeTypes(i4);
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i4);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e4);
                }
            }
        }
    }

    public static void M(View view, int i4) {
        view.offsetLeftAndRight(i4);
    }

    public static void N(View view, int i4) {
        view.offsetTopAndBottom(i4);
    }

    public static x O(View view, x xVar) {
        WindowInsets g4 = xVar.g();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(g4);
        if (!onApplyWindowInsets.equals(g4)) {
            g4 = new WindowInsets(onApplyWindowInsets);
        }
        return x.h(g4);
    }

    public static void P(View view, z.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.s0());
    }

    private static f<CharSequence> Q() {
        return new c(m.a.K, CharSequence.class, 8, 28);
    }

    public static boolean R(View view, int i4, Bundle bundle) {
        return view.performAccessibilityAction(i4, bundle);
    }

    public static void S(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void T(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void U(View view, Runnable runnable, long j4) {
        view.postOnAnimationDelayed(runnable, j4);
    }

    public static void V(View view, int i4) {
        W(i4, view);
        L(view, 0);
    }

    private static void W(int i4, View view) {
        List<c.a> k4 = k(view);
        for (int i5 = 0; i5 < k4.size(); i5++) {
            if (k4.get(i5).b() == i4) {
                k4.remove(i5);
                return;
            }
        }
    }

    public static void X(View view, c.a aVar, CharSequence charSequence, z.f fVar) {
        if (fVar == null && charSequence == null) {
            V(view, aVar.b());
        } else {
            b(view, aVar.a(charSequence, fVar));
        }
    }

    public static void Y(View view) {
        view.requestApplyInsets();
    }

    private static f<Boolean> Z() {
        return new b(m.a.L, Boolean.class, 28);
    }

    private static f<Boolean> a() {
        return new d(m.a.J, Boolean.class, 28);
    }

    public static void a0(View view, y.a aVar) {
        if (aVar == null && (g(view) instanceof a.C0094a)) {
            aVar = new y.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    private static void b(View view, c.a aVar) {
        w(view);
        W(aVar.b(), view);
        k(view).add(aVar);
        L(view, 0);
    }

    public static void b0(View view, boolean z4) {
        a().g(view, Boolean.valueOf(z4));
    }

    public static t c(View view) {
        if (f6541b == null) {
            f6541b = new WeakHashMap<>();
        }
        t tVar = f6541b.get(view);
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(view);
        f6541b.put(view, tVar2);
        return tVar2;
    }

    public static void c0(View view, int i4) {
        view.setAccessibilityLiveRegion(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return h.a(view).b(view, keyEvent);
    }

    public static void d0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return h.a(view).f(keyEvent);
    }

    public static void e0(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static y.a f(View view) {
        View.AccessibilityDelegate g4 = g(view);
        if (g4 == null) {
            return null;
        }
        return g4 instanceof a.C0094a ? ((a.C0094a) g4).f6522a : new y.a(g4);
    }

    public static void f0(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    private static View.AccessibilityDelegate g(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : h(view);
    }

    public static void g0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    private static View.AccessibilityDelegate h(View view) {
        if (f6543d) {
            return null;
        }
        if (f6542c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f6542c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f6543d = true;
                return null;
            }
        }
        try {
            Object obj = f6542c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f6543d = true;
            return null;
        }
    }

    public static void h0(View view, float f4) {
        view.setElevation(f4);
    }

    public static int i(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static void i0(View view, boolean z4) {
        view.setHasTransientState(z4);
    }

    public static CharSequence j(View view) {
        return Q().f(view);
    }

    public static void j0(View view, int i4) {
        view.setImportantForAccessibility(i4);
    }

    private static List<c.a> k(View view) {
        int i4 = m.a.H;
        ArrayList arrayList = (ArrayList) view.getTag(i4);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i4, arrayList2);
        return arrayList2;
    }

    public static void k0(View view, int i4) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i4);
        }
    }

    public static ColorStateList l(View view) {
        return view.getBackgroundTintList();
    }

    public static void l0(View view, n nVar) {
        if (nVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new a(nVar));
        }
    }

    public static PorterDuff.Mode m(View view) {
        return view.getBackgroundTintMode();
    }

    public static void m0(View view, int i4, int i5, int i6, int i7) {
        view.setPaddingRelative(i4, i5, i6, i7);
    }

    public static Rect n(View view) {
        return view.getClipBounds();
    }

    public static void n0(View view, int i4, int i5) {
        view.setScrollIndicators(i4, i5);
    }

    public static Display o(View view) {
        return view.getDisplay();
    }

    public static void o0(View view, String str) {
        view.setTransitionName(str);
    }

    public static float p(View view) {
        return view.getElevation();
    }

    public static void p0(View view) {
        view.stopNestedScroll();
    }

    public static boolean q(View view) {
        return view.getFitsSystemWindows();
    }

    public static int r(View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int s(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int t(View view) {
        return view.getLayoutDirection();
    }

    public static int u(View view) {
        return view.getMinimumHeight();
    }

    public static int v(View view) {
        return view.getMinimumWidth();
    }

    static y.a w(View view) {
        y.a f4 = f(view);
        if (f4 == null) {
            f4 = new y.a();
        }
        a0(view, f4);
        return f4;
    }

    public static int x(View view) {
        return view.getPaddingEnd();
    }

    public static int y(View view) {
        return view.getPaddingStart();
    }

    public static String z(View view) {
        return view.getTransitionName();
    }
}
