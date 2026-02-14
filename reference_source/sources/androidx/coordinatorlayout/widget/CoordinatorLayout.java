package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y.k;
import y.l;
import y.m;
import y.n;
import y.p;
import y.x;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements k, l {

    /* renamed from: v, reason: collision with root package name */
    static final String f1276v;

    /* renamed from: w, reason: collision with root package name */
    static final Class<?>[] f1277w;

    /* renamed from: x, reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<c>>> f1278x;

    /* renamed from: y, reason: collision with root package name */
    static final Comparator<View> f1279y;

    /* renamed from: z, reason: collision with root package name */
    private static final x.e<Rect> f1280z;

    /* renamed from: b, reason: collision with root package name */
    private final List<View> f1281b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.coordinatorlayout.widget.a<View> f1282c;

    /* renamed from: d, reason: collision with root package name */
    private final List<View> f1283d;

    /* renamed from: e, reason: collision with root package name */
    private final List<View> f1284e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f1285f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f1286g;

    /* renamed from: h, reason: collision with root package name */
    private final int[] f1287h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1288i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1289j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f1290k;

    /* renamed from: l, reason: collision with root package name */
    private View f1291l;

    /* renamed from: m, reason: collision with root package name */
    private View f1292m;

    /* renamed from: n, reason: collision with root package name */
    private g f1293n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1294o;

    /* renamed from: p, reason: collision with root package name */
    private x f1295p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1296q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f1297r;

    /* renamed from: s, reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f1298s;

    /* renamed from: t, reason: collision with root package name */
    private n f1299t;

    /* renamed from: u, reason: collision with root package name */
    private final m f1300u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements n {
        a() {
        }

        @Override // y.n
        public x a(View view, x xVar) {
            return CoordinatorLayout.this.X(xVar);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        c getBehavior();
    }

    /* loaded from: classes.dex */
    public static abstract class c<V extends View> {
        public c() {
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, V v4, View view, View view2, int i4, int i5) {
            if (i5 == 0) {
                return z(coordinatorLayout, v4, view, view2, i4);
            }
            return false;
        }

        @Deprecated
        public void B(CoordinatorLayout coordinatorLayout, V v4, View view) {
        }

        public void C(CoordinatorLayout coordinatorLayout, V v4, View view, int i4) {
            if (i4 == 0) {
                B(coordinatorLayout, v4, view);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, V v4, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v4) {
            return d(coordinatorLayout, v4) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v4, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v4) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, V v4) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v4, View view) {
            return false;
        }

        public x f(CoordinatorLayout coordinatorLayout, V v4, x xVar) {
            return xVar;
        }

        public void g(f fVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, V v4, View view) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, V v4, View view) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v4, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v4, int i4) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, V v4, int i4, int i5, int i6, int i7) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v4, View view, float f4, float f5, boolean z4) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, V v4, View view, float f4, float f5) {
            return false;
        }

        @Deprecated
        public void p(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int[] iArr, int i6) {
            if (i6 == 0) {
                p(coordinatorLayout, v4, view, i4, i5, iArr);
            }
        }

        @Deprecated
        public void r(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int i6, int i7) {
        }

        @Deprecated
        public void s(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int i6, int i7, int i8) {
            if (i8 == 0) {
                r(coordinatorLayout, v4, view, i4, i5, i6, i7);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, V v4, View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
            iArr[0] = iArr[0] + i6;
            iArr[1] = iArr[1] + i7;
            s(coordinatorLayout, v4, view, i4, i5, i6, i7, i8);
        }

        @Deprecated
        public void u(CoordinatorLayout coordinatorLayout, V v4, View view, View view2, int i4) {
        }

        public void v(CoordinatorLayout coordinatorLayout, V v4, View view, View view2, int i4, int i5) {
            if (i5 == 0) {
                u(coordinatorLayout, v4, view, view2, i4);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, V v4, Rect rect, boolean z4) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, V v4, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, V v4) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean z(CoordinatorLayout coordinatorLayout, V v4, View view, View view2, int i4) {
            return false;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface d {
        Class<? extends c> value();
    }

    /* loaded from: classes.dex */
    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1298s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.I(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1298s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        c f1303a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1304b;

        /* renamed from: c, reason: collision with root package name */
        public int f1305c;

        /* renamed from: d, reason: collision with root package name */
        public int f1306d;

        /* renamed from: e, reason: collision with root package name */
        public int f1307e;

        /* renamed from: f, reason: collision with root package name */
        int f1308f;

        /* renamed from: g, reason: collision with root package name */
        public int f1309g;

        /* renamed from: h, reason: collision with root package name */
        public int f1310h;

        /* renamed from: i, reason: collision with root package name */
        int f1311i;

        /* renamed from: j, reason: collision with root package name */
        int f1312j;

        /* renamed from: k, reason: collision with root package name */
        View f1313k;

        /* renamed from: l, reason: collision with root package name */
        View f1314l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f1315m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f1316n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f1317o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f1318p;

        /* renamed from: q, reason: collision with root package name */
        final Rect f1319q;

        /* renamed from: r, reason: collision with root package name */
        Object f1320r;

        public f(int i4, int i5) {
            super(i4, i5);
            this.f1304b = false;
            this.f1305c = 0;
            this.f1306d = 0;
            this.f1307e = -1;
            this.f1308f = -1;
            this.f1309g = 0;
            this.f1310h = 0;
            this.f1319q = new Rect();
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1304b = false;
            this.f1305c = 0;
            this.f1306d = 0;
            this.f1307e = -1;
            this.f1308f = -1;
            this.f1309g = 0;
            this.f1310h = 0;
            this.f1319q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.c.f4471e);
            this.f1305c = obtainStyledAttributes.getInteger(l.c.f4472f, 0);
            this.f1308f = obtainStyledAttributes.getResourceId(l.c.f4473g, -1);
            this.f1306d = obtainStyledAttributes.getInteger(l.c.f4474h, 0);
            this.f1307e = obtainStyledAttributes.getInteger(l.c.f4478l, -1);
            this.f1309g = obtainStyledAttributes.getInt(l.c.f4477k, 0);
            this.f1310h = obtainStyledAttributes.getInt(l.c.f4476j, 0);
            int i4 = l.c.f4475i;
            boolean hasValue = obtainStyledAttributes.hasValue(i4);
            this.f1304b = hasValue;
            if (hasValue) {
                this.f1303a = CoordinatorLayout.L(context, attributeSet, obtainStyledAttributes.getString(i4));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.f1303a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1304b = false;
            this.f1305c = 0;
            this.f1306d = 0;
            this.f1307e = -1;
            this.f1308f = -1;
            this.f1309g = 0;
            this.f1310h = 0;
            this.f1319q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1304b = false;
            this.f1305c = 0;
            this.f1306d = 0;
            this.f1307e = -1;
            this.f1308f = -1;
            this.f1309g = 0;
            this.f1310h = 0;
            this.f1319q = new Rect();
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f1304b = false;
            this.f1305c = 0;
            this.f1306d = 0;
            this.f1307e = -1;
            this.f1308f = -1;
            this.f1309g = 0;
            this.f1310h = 0;
            this.f1319q = new Rect();
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f1308f);
            this.f1313k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = parent;
                            }
                        } else if (!coordinatorLayout.isInEditMode()) {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f1314l = findViewById;
                    return;
                }
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (!coordinatorLayout.isInEditMode()) {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f1308f) + " to anchor view " + view);
            }
            this.f1314l = null;
            this.f1313k = null;
        }

        private boolean s(View view, int i4) {
            int b5 = y.c.b(((f) view.getLayoutParams()).f1309g, i4);
            return b5 != 0 && (y.c.b(this.f1310h, i4) & b5) == b5;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f1313k.getId() != this.f1308f) {
                return false;
            }
            View view2 = this.f1313k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f1314l = null;
                    this.f1313k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f1314l = view2;
            return true;
        }

        boolean a() {
            return this.f1313k == null && this.f1308f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.f1314l || s(view2, p.t(coordinatorLayout)) || ((cVar = this.f1303a) != null && cVar.e(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.f1303a == null) {
                this.f1315m = false;
            }
            return this.f1315m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f1308f == -1) {
                this.f1314l = null;
                this.f1313k = null;
                return null;
            }
            if (this.f1313k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f1313k;
        }

        public int e() {
            return this.f1308f;
        }

        public c f() {
            return this.f1303a;
        }

        boolean g() {
            return this.f1318p;
        }

        Rect h() {
            return this.f1319q;
        }

        boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z4 = this.f1315m;
            if (z4) {
                return true;
            }
            c cVar = this.f1303a;
            boolean a5 = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z4;
            this.f1315m = a5;
            return a5;
        }

        boolean j(int i4) {
            if (i4 == 0) {
                return this.f1316n;
            }
            if (i4 != 1) {
                return false;
            }
            return this.f1317o;
        }

        void k() {
            this.f1318p = false;
        }

        void l(int i4) {
            r(i4, false);
        }

        void m() {
            this.f1315m = false;
        }

        public void o(c cVar) {
            c cVar2 = this.f1303a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.j();
                }
                this.f1303a = cVar;
                this.f1320r = null;
                this.f1304b = true;
                if (cVar != null) {
                    cVar.g(this);
                }
            }
        }

        void p(boolean z4) {
            this.f1318p = z4;
        }

        void q(Rect rect) {
            this.f1319q.set(rect);
        }

        void r(int i4, boolean z4) {
            if (i4 == 0) {
                this.f1316n = z4;
            } else {
                if (i4 != 1) {
                    return;
                }
                this.f1317o = z4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.I(0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class h extends b0.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        SparseArray<Parcelable> f1322d;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i4) {
                return new h[i4];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1322d = new SparseArray<>(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                this.f1322d.append(iArr[i4], readParcelableArray[i4]);
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            SparseArray<Parcelable> sparseArray = this.f1322d;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr[i5] = this.f1322d.keyAt(i5);
                parcelableArr[i5] = this.f1322d.valueAt(i5);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i4);
        }
    }

    /* loaded from: classes.dex */
    static class i implements Comparator<View> {
        i() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float B = p.B(view);
            float B2 = p.B(view2);
            if (B > B2) {
                return -1;
            }
            return B < B2 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f1276v = r02 != null ? r02.getName() : null;
        f1279y = new i();
        f1277w = new Class[]{Context.class, AttributeSet.class};
        f1278x = new ThreadLocal<>();
        f1280z = new x.g(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, l.a.f4465a);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1281b = new ArrayList();
        this.f1282c = new androidx.coordinatorlayout.widget.a<>();
        this.f1283d = new ArrayList();
        this.f1284e = new ArrayList();
        this.f1286g = new int[2];
        this.f1287h = new int[2];
        this.f1300u = new m(this);
        int[] iArr = l.c.f4468b;
        TypedArray obtainStyledAttributes = i4 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, l.b.f4466a) : context.obtainStyledAttributes(attributeSet, iArr, i4, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            int[] iArr2 = l.c.f4468b;
            if (i4 == 0) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, 0, l.b.f4466a);
            } else {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, i4, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(l.c.f4469c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f1290k = resources.getIntArray(resourceId);
            float f4 = resources.getDisplayMetrics().density;
            int length = this.f1290k.length;
            for (int i5 = 0; i5 < length; i5++) {
                this.f1290k[i5] = (int) (r12[i5] * f4);
            }
        }
        this.f1297r = obtainStyledAttributes.getDrawable(l.c.f4470d);
        obtainStyledAttributes.recycle();
        Y();
        super.setOnHierarchyChangeListener(new e());
        if (p.r(this) == 0) {
            p.j0(this, 1);
        }
    }

    private void A(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i4) : i4));
        }
        Comparator<View> comparator = f1279y;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean B(View view) {
        return this.f1282c.j(view);
    }

    private void D(View view, int i4) {
        f fVar = (f) view.getLayoutParams();
        Rect a5 = a();
        a5.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f1295p != null && p.q(this) && !p.q(view)) {
            a5.left += this.f1295p.b();
            a5.top += this.f1295p.d();
            a5.right -= this.f1295p.c();
            a5.bottom -= this.f1295p.a();
        }
        Rect a6 = a();
        y.c.a(T(fVar.f1305c), view.getMeasuredWidth(), view.getMeasuredHeight(), a5, a6, i4);
        view.layout(a6.left, a6.top, a6.right, a6.bottom);
        P(a5);
        P(a6);
    }

    private void E(View view, View view2, int i4) {
        Rect a5 = a();
        Rect a6 = a();
        try {
            u(view2, a5);
            v(view, i4, a5, a6);
            view.layout(a6.left, a6.top, a6.right, a6.bottom);
        } finally {
            P(a5);
            P(a6);
        }
    }

    private void F(View view, int i4, int i5) {
        f fVar = (f) view.getLayoutParams();
        int b5 = y.c.b(U(fVar.f1305c), i5);
        int i6 = b5 & 7;
        int i7 = b5 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i5 == 1) {
            i4 = width - i4;
        }
        int x4 = x(i4) - measuredWidth;
        int i8 = 0;
        if (i6 == 1) {
            x4 += measuredWidth / 2;
        } else if (i6 == 5) {
            x4 += measuredWidth;
        }
        if (i7 == 16) {
            i8 = 0 + (measuredHeight / 2);
        } else if (i7 == 80) {
            i8 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(x4, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i8, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void G(View view, Rect rect, int i4) {
        boolean z4;
        boolean z5;
        int width;
        int i5;
        int i6;
        int i7;
        int height;
        int i8;
        int i9;
        int i10;
        if (p.H(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c f4 = fVar.f();
            Rect a5 = a();
            Rect a6 = a();
            a6.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f4 == null || !f4.b(this, view, a5)) {
                a5.set(a6);
            } else if (!a6.contains(a5)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a5.toShortString() + " | Bounds:" + a6.toShortString());
            }
            P(a6);
            if (a5.isEmpty()) {
                P(a5);
                return;
            }
            int b5 = y.c.b(fVar.f1310h, i4);
            boolean z6 = true;
            if ((b5 & 48) != 48 || (i9 = (a5.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f1312j) >= (i10 = rect.top)) {
                z4 = false;
            } else {
                W(view, i10 - i9);
                z4 = true;
            }
            if ((b5 & 80) == 80 && (height = ((getHeight() - a5.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f1312j) < (i8 = rect.bottom)) {
                W(view, height - i8);
                z4 = true;
            }
            if (!z4) {
                W(view, 0);
            }
            if ((b5 & 3) != 3 || (i6 = (a5.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f1311i) >= (i7 = rect.left)) {
                z5 = false;
            } else {
                V(view, i7 - i6);
                z5 = true;
            }
            if ((b5 & 5) != 5 || (width = ((getWidth() - a5.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f1311i) >= (i5 = rect.right)) {
                z6 = z5;
            } else {
                V(view, width - i5);
            }
            if (!z6) {
                V(view, 0);
            }
            P(a5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static c L(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f1276v;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = f1278x;
            Map<String, Constructor<c>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f1277w);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e4) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e4);
        }
    }

    private boolean M(MotionEvent motionEvent, int i4) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f1283d;
        A(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z4 = false;
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view = list.get(i5);
            f fVar = (f) view.getLayoutParams();
            c f4 = fVar.f();
            if (!(z4 || z5) || actionMasked == 0) {
                if (!z4 && f4 != null) {
                    if (i4 == 0) {
                        z4 = f4.k(this, view, motionEvent);
                    } else if (i4 == 1) {
                        z4 = f4.D(this, view, motionEvent);
                    }
                    if (z4) {
                        this.f1291l = view;
                    }
                }
                boolean c5 = fVar.c();
                boolean i6 = fVar.i(this, view);
                z5 = i6 && !c5;
                if (i6 && !z5) {
                    break;
                }
            } else if (f4 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i4 == 0) {
                    f4.k(this, view, motionEvent2);
                } else if (i4 == 1) {
                    f4.D(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z4;
    }

    private void N() {
        this.f1281b.clear();
        this.f1282c.c();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f z4 = z(childAt);
            z4.d(this, childAt);
            this.f1282c.b(childAt);
            for (int i5 = 0; i5 < childCount; i5++) {
                if (i5 != i4) {
                    View childAt2 = getChildAt(i5);
                    if (z4.b(this, childAt, childAt2)) {
                        if (!this.f1282c.d(childAt2)) {
                            this.f1282c.b(childAt2);
                        }
                        this.f1282c.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f1281b.addAll(this.f1282c.i());
        Collections.reverse(this.f1281b);
    }

    private static void P(Rect rect) {
        rect.setEmpty();
        f1280z.a(rect);
    }

    private void R(boolean z4) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            c f4 = ((f) childAt.getLayoutParams()).f();
            if (f4 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z4) {
                    f4.k(this, childAt, obtain);
                } else {
                    f4.D(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            ((f) getChildAt(i5).getLayoutParams()).m();
        }
        this.f1291l = null;
        this.f1288i = false;
    }

    private static int S(int i4) {
        if (i4 == 0) {
            return 17;
        }
        return i4;
    }

    private static int T(int i4) {
        if ((i4 & 7) == 0) {
            i4 |= 8388611;
        }
        return (i4 & 112) == 0 ? i4 | 48 : i4;
    }

    private static int U(int i4) {
        if (i4 == 0) {
            return 8388661;
        }
        return i4;
    }

    private void V(View view, int i4) {
        f fVar = (f) view.getLayoutParams();
        int i5 = fVar.f1311i;
        if (i5 != i4) {
            p.M(view, i4 - i5);
            fVar.f1311i = i4;
        }
    }

    private void W(View view, int i4) {
        f fVar = (f) view.getLayoutParams();
        int i5 = fVar.f1312j;
        if (i5 != i4) {
            p.N(view, i4 - i5);
            fVar.f1312j = i4;
        }
    }

    private void Y() {
        if (!p.q(this)) {
            p.l0(this, null);
            return;
        }
        if (this.f1299t == null) {
            this.f1299t = new a();
        }
        p.l0(this, this.f1299t);
        setSystemUiVisibility(1280);
    }

    private static Rect a() {
        Rect b5 = f1280z.b();
        return b5 == null ? new Rect() : b5;
    }

    private static int c(int i4, int i5, int i6) {
        return i4 < i5 ? i5 : i4 > i6 ? i6 : i4;
    }

    private void d(f fVar, Rect rect, int i4, int i5) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i4) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i5) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i4 + max, i5 + max2);
    }

    private x e(x xVar) {
        c f4;
        if (xVar.e()) {
            return xVar;
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (p.q(childAt) && (f4 = ((f) childAt.getLayoutParams()).f()) != null) {
                xVar = f4.f(this, childAt, xVar);
                if (xVar.e()) {
                    break;
                }
            }
        }
        return xVar;
    }

    private void w(View view, int i4, Rect rect, Rect rect2, f fVar, int i5, int i6) {
        int b5 = y.c.b(S(fVar.f1305c), i4);
        int b6 = y.c.b(T(fVar.f1306d), i4);
        int i7 = b5 & 7;
        int i8 = b5 & 112;
        int i9 = b6 & 7;
        int i10 = b6 & 112;
        int width = i9 != 1 ? i9 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i10 != 16 ? i10 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i7 == 1) {
            width -= i5 / 2;
        } else if (i7 != 5) {
            width -= i5;
        }
        if (i8 == 16) {
            height -= i6 / 2;
        } else if (i8 != 80) {
            height -= i6;
        }
        rect2.set(width, height, i5 + width, i6 + height);
    }

    private int x(int i4) {
        StringBuilder sb;
        int[] iArr = this.f1290k;
        if (iArr == null) {
            sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i4);
        } else {
            if (i4 >= 0 && i4 < iArr.length) {
                return iArr[i4];
            }
            sb = new StringBuilder();
            sb.append("Keyline index ");
            sb.append(i4);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e("CoordinatorLayout", sb.toString());
        return 0;
    }

    public boolean C(View view, int i4, int i5) {
        Rect a5 = a();
        u(view, a5);
        try {
            return a5.contains(i4, i5);
        } finally {
            P(a5);
        }
    }

    void H(View view, int i4) {
        c f4;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f1313k != null) {
            Rect a5 = a();
            Rect a6 = a();
            Rect a7 = a();
            u(fVar.f1313k, a5);
            r(view, false, a6);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            w(view, i4, a5, a7, fVar, measuredWidth, measuredHeight);
            boolean z4 = (a7.left == a6.left && a7.top == a6.top) ? false : true;
            d(fVar, a7, measuredWidth, measuredHeight);
            int i5 = a7.left - a6.left;
            int i6 = a7.top - a6.top;
            if (i5 != 0) {
                p.M(view, i5);
            }
            if (i6 != 0) {
                p.N(view, i6);
            }
            if (z4 && (f4 = fVar.f()) != null) {
                f4.h(this, view, fVar.f1313k);
            }
            P(a5);
            P(a6);
            P(a7);
        }
    }

    final void I(int i4) {
        boolean z4;
        int t4 = p.t(this);
        int size = this.f1281b.size();
        Rect a5 = a();
        Rect a6 = a();
        Rect a7 = a();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f1281b.get(i5);
            f fVar = (f) view.getLayoutParams();
            if (i4 != 0 || view.getVisibility() != 8) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (fVar.f1314l == this.f1281b.get(i6)) {
                        H(view, t4);
                    }
                }
                r(view, true, a6);
                if (fVar.f1309g != 0 && !a6.isEmpty()) {
                    int b5 = y.c.b(fVar.f1309g, t4);
                    int i7 = b5 & 112;
                    if (i7 == 48) {
                        a5.top = Math.max(a5.top, a6.bottom);
                    } else if (i7 == 80) {
                        a5.bottom = Math.max(a5.bottom, getHeight() - a6.top);
                    }
                    int i8 = b5 & 7;
                    if (i8 == 3) {
                        a5.left = Math.max(a5.left, a6.right);
                    } else if (i8 == 5) {
                        a5.right = Math.max(a5.right, getWidth() - a6.left);
                    }
                }
                if (fVar.f1310h != 0 && view.getVisibility() == 0) {
                    G(view, a5, t4);
                }
                if (i4 != 2) {
                    y(view, a7);
                    if (!a7.equals(a6)) {
                        O(view, a6);
                    }
                }
                for (int i9 = i5 + 1; i9 < size; i9++) {
                    View view2 = this.f1281b.get(i9);
                    f fVar2 = (f) view2.getLayoutParams();
                    c f4 = fVar2.f();
                    if (f4 != null && f4.e(this, view2, view)) {
                        if (i4 == 0 && fVar2.g()) {
                            fVar2.k();
                        } else {
                            if (i4 != 2) {
                                z4 = f4.h(this, view2, view);
                            } else {
                                f4.i(this, view2, view);
                                z4 = true;
                            }
                            if (i4 == 1) {
                                fVar2.p(z4);
                            }
                        }
                    }
                }
            }
        }
        P(a5);
        P(a6);
        P(a7);
    }

    public void J(View view, int i4) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f1313k;
        if (view2 != null) {
            E(view, view2, i4);
            return;
        }
        int i5 = fVar.f1307e;
        if (i5 >= 0) {
            F(view, i5, i4);
        } else {
            D(view, i4);
        }
    }

    public void K(View view, int i4, int i5, int i6, int i7) {
        measureChildWithMargins(view, i4, i5, i6, i7);
    }

    void O(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    void Q() {
        if (this.f1289j && this.f1293n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1293n);
        }
        this.f1294o = false;
    }

    final x X(x xVar) {
        if (x.c.a(this.f1295p, xVar)) {
            return xVar;
        }
        this.f1295p = xVar;
        boolean z4 = xVar != null && xVar.d() > 0;
        this.f1296q = z4;
        setWillNotDraw(!z4 && getBackground() == null);
        x e4 = e(xVar);
        requestLayout();
        return e4;
    }

    void b() {
        if (this.f1289j) {
            if (this.f1293n == null) {
                this.f1293n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1293n);
        }
        this.f1294o = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j4) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f1303a;
        if (cVar != null) {
            float d5 = cVar.d(this, view);
            if (d5 > 0.0f) {
                if (this.f1285f == null) {
                    this.f1285f = new Paint();
                }
                this.f1285f.setColor(fVar.f1303a.c(this, view));
                this.f1285f.setAlpha(c(Math.round(d5 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f1285f);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1297r;
        boolean z4 = false;
        if (drawable != null && drawable.isStateful()) {
            z4 = false | drawable.setState(drawableState);
        }
        if (z4) {
            invalidate();
        }
    }

    public void f(View view) {
        List g4 = this.f1282c.g(view);
        if (g4 == null || g4.isEmpty()) {
            return;
        }
        for (int i4 = 0; i4 < g4.size(); i4++) {
            View view2 = (View) g4.get(i4);
            c f4 = ((f) view2.getLayoutParams()).f();
            if (f4 != null) {
                f4.h(this, view2, view);
            }
        }
    }

    public boolean g(View view, View view2) {
        boolean z4 = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect a5 = a();
        r(view, view.getParent() != this, a5);
        Rect a6 = a();
        r(view2, view2.getParent() != this, a6);
        try {
            if (a5.left <= a6.right && a5.top <= a6.bottom && a5.right >= a6.left) {
                if (a5.bottom >= a6.top) {
                    z4 = true;
                }
            }
            return z4;
        } finally {
            P(a5);
            P(a6);
        }
    }

    final List<View> getDependencySortedChildren() {
        N();
        return Collections.unmodifiableList(this.f1281b);
    }

    public final x getLastWindowInsets() {
        return this.f1295p;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1300u.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f1297r;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // y.k
    public void h(View view, View view2, int i4, int i5) {
        c f4;
        this.f1300u.c(view, view2, i4, i5);
        this.f1292m = view2;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i5) && (f4 = fVar.f()) != null) {
                f4.v(this, childAt, view, view2, i4, i5);
            }
        }
    }

    @Override // y.k
    public void i(View view, int i4) {
        this.f1300u.d(view, i4);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i4)) {
                c f4 = fVar.f();
                if (f4 != null) {
                    f4.C(this, childAt, view, i4);
                }
                fVar.l(i4);
                fVar.k();
            }
        }
        this.f1292m = null;
    }

    @Override // y.k
    public void j(View view, int i4, int i5, int[] iArr, int i6) {
        c f4;
        int childCount = getChildCount();
        boolean z4 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i6) && (f4 = fVar.f()) != null) {
                    int[] iArr2 = this.f1286g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f4.q(this, childAt, view, i4, i5, iArr2, i6);
                    int[] iArr3 = this.f1286g;
                    i7 = i4 > 0 ? Math.max(i7, iArr3[0]) : Math.min(i7, iArr3[0]);
                    int[] iArr4 = this.f1286g;
                    i8 = i5 > 0 ? Math.max(i8, iArr4[1]) : Math.min(i8, iArr4[1]);
                    z4 = true;
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
        if (z4) {
            I(1);
        }
    }

    void k() {
        int childCount = getChildCount();
        boolean z4 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= childCount) {
                break;
            }
            if (B(getChildAt(i4))) {
                z4 = true;
                break;
            }
            i4++;
        }
        if (z4 != this.f1294o) {
            if (z4) {
                b();
            } else {
                Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // y.l
    public void m(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        c f4;
        boolean z4;
        int min;
        int childCount = getChildCount();
        boolean z5 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i8) && (f4 = fVar.f()) != null) {
                    int[] iArr2 = this.f1286g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f4.t(this, childAt, view, i4, i5, i6, i7, i8, iArr2);
                    int[] iArr3 = this.f1286g;
                    i9 = i6 > 0 ? Math.max(i9, iArr3[0]) : Math.min(i9, iArr3[0]);
                    if (i7 > 0) {
                        z4 = true;
                        min = Math.max(i10, this.f1286g[1]);
                    } else {
                        z4 = true;
                        min = Math.min(i10, this.f1286g[1]);
                    }
                    i10 = min;
                    z5 = z4;
                }
            }
        }
        iArr[0] = iArr[0] + i9;
        iArr[1] = iArr[1] + i10;
        if (z5) {
            I(1);
        }
    }

    @Override // y.k
    public void n(View view, int i4, int i5, int i6, int i7, int i8) {
        m(view, i4, i5, i6, i7, 0, this.f1287h);
    }

    @Override // y.k
    public boolean o(View view, View view2, int i4, int i5) {
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c f4 = fVar.f();
                if (f4 != null) {
                    boolean A = f4.A(this, childAt, view, view2, i4, i5);
                    z4 |= A;
                    fVar.r(i5, A);
                } else {
                    fVar.r(i5, false);
                }
            }
        }
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        R(false);
        if (this.f1294o) {
            if (this.f1293n == null) {
                this.f1293n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1293n);
        }
        if (this.f1295p == null && p.q(this)) {
            p.Y(this);
        }
        this.f1289j = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        R(false);
        if (this.f1294o && this.f1293n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1293n);
        }
        View view = this.f1292m;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f1289j = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f1296q || this.f1297r == null) {
            return;
        }
        x xVar = this.f1295p;
        int d5 = xVar != null ? xVar.d() : 0;
        if (d5 > 0) {
            this.f1297r.setBounds(0, 0, getWidth(), d5);
            this.f1297r.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            R(true);
        }
        boolean M = M(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            R(true);
        }
        return M;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        c f4;
        int t4 = p.t(this);
        int size = this.f1281b.size();
        for (int i8 = 0; i8 < size; i8++) {
            View view = this.f1281b.get(i8);
            if (view.getVisibility() != 8 && ((f4 = ((f) view.getLayoutParams()).f()) == null || !f4.l(this, view, t4))) {
                J(view, t4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x011a, code lost:
    
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        c f6;
        int childCount = getChildCount();
        boolean z5 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f6 = fVar.f()) != null) {
                    z5 |= f6.n(this, childAt, view, f4, f5, z4);
                }
            }
        }
        if (z5) {
            I(1);
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f5) {
        c f6;
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f6 = fVar.f()) != null) {
                    z4 |= f6.o(this, childAt, view, f4, f5);
                }
            }
        }
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        j(view, i4, i5, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        n(view, i4, i5, i6, i7, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i4) {
        h(view, view2, i4, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f());
        SparseArray<Parcelable> sparseArray = hVar.f1322d;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            c f4 = z(childAt).f();
            if (id != -1 && f4 != null && (parcelable2 = sparseArray.get(id)) != null) {
                f4.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable y4;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            c f4 = ((f) childAt.getLayoutParams()).f();
            if (id != -1 && f4 != null && (y4 = f4.y(this, childAt)) != null) {
                sparseArray.append(id, y4);
            }
        }
        hVar.f1322d = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i4) {
        return o(view, view2, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f1291l
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.M(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = r5
        L16:
            android.view.View r6 = r0.f1291l
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.f1291l
            boolean r6 = r6.D(r0, r7, r1)
            goto L2c
        L2b:
            r6 = r5
        L2c:
            android.view.View r7 = r0.f1291l
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.R(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    void r(View view, boolean z4, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z4) {
            u(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        c f4 = ((f) view.getLayoutParams()).f();
        if (f4 == null || !f4.w(this, view, rect, z4)) {
            return super.requestChildRectangleOnScreen(view, rect, z4);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z4) {
        super.requestDisallowInterceptTouchEvent(z4);
        if (!z4 || this.f1288i) {
            return;
        }
        R(false);
        this.f1288i = true;
    }

    public List<View> s(View view) {
        List<View> h4 = this.f1282c.h(view);
        this.f1284e.clear();
        if (h4 != null) {
            this.f1284e.addAll(h4);
        }
        return this.f1284e;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z4) {
        super.setFitsSystemWindows(z4);
        Y();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1298s = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f1297r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f1297r = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f1297r.setState(getDrawableState());
                }
                r.a.h(this.f1297r, p.t(this));
                this.f1297r.setVisible(getVisibility() == 0, false);
                this.f1297r.setCallback(this);
            }
            p.S(this);
        }
    }

    public void setStatusBarBackgroundColor(int i4) {
        setStatusBarBackground(new ColorDrawable(i4));
    }

    public void setStatusBarBackgroundResource(int i4) {
        setStatusBarBackground(i4 != 0 ? o.a.c(getContext(), i4) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f1297r;
        if (drawable == null || drawable.isVisible() == z4) {
            return;
        }
        this.f1297r.setVisible(z4, false);
    }

    public List<View> t(View view) {
        List g4 = this.f1282c.g(view);
        this.f1284e.clear();
        if (g4 != null) {
            this.f1284e.addAll(g4);
        }
        return this.f1284e;
    }

    void u(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    void v(View view, int i4, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        w(view, i4, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1297r;
    }

    void y(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    f z(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f1304b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.o(dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e4) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e4);
                    }
                }
            }
            fVar.f1304b = true;
        }
        return fVar;
    }
}
