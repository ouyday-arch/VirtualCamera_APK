package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private ColorStateList A;
    private ColorStateList B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    f H;
    private final ActionMenuView.e I;
    private x0 J;
    private androidx.appcompat.widget.c K;
    private d L;
    private j.a M;
    private e.a N;
    private boolean O;
    private final Runnable P;

    /* renamed from: b, reason: collision with root package name */
    private ActionMenuView f867b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f868c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f869d;

    /* renamed from: e, reason: collision with root package name */
    private ImageButton f870e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f871f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f872g;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence f873h;

    /* renamed from: i, reason: collision with root package name */
    ImageButton f874i;

    /* renamed from: j, reason: collision with root package name */
    View f875j;

    /* renamed from: k, reason: collision with root package name */
    private Context f876k;

    /* renamed from: l, reason: collision with root package name */
    private int f877l;

    /* renamed from: m, reason: collision with root package name */
    private int f878m;

    /* renamed from: n, reason: collision with root package name */
    private int f879n;

    /* renamed from: o, reason: collision with root package name */
    int f880o;

    /* renamed from: p, reason: collision with root package name */
    private int f881p;

    /* renamed from: q, reason: collision with root package name */
    private int f882q;

    /* renamed from: r, reason: collision with root package name */
    private int f883r;

    /* renamed from: s, reason: collision with root package name */
    private int f884s;

    /* renamed from: t, reason: collision with root package name */
    private int f885t;

    /* renamed from: u, reason: collision with root package name */
    private o0 f886u;

    /* renamed from: v, reason: collision with root package name */
    private int f887v;

    /* renamed from: w, reason: collision with root package name */
    private int f888w;

    /* renamed from: x, reason: collision with root package name */
    private int f889x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f890y;

    /* renamed from: z, reason: collision with root package name */
    private CharSequence f891z;

    /* loaded from: classes.dex */
    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.H;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements androidx.appcompat.view.menu.j {

        /* renamed from: b, reason: collision with root package name */
        androidx.appcompat.view.menu.e f895b;

        /* renamed from: c, reason: collision with root package name */
        androidx.appcompat.view.menu.g f896c;

        d() {
        }

        @Override // androidx.appcompat.view.menu.j
        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public void d(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f895b;
            if (eVar2 != null && (gVar = this.f896c) != null) {
                eVar2.f(gVar);
            }
            this.f895b = eVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean e(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            KeyEvent.Callback callback = Toolbar.this.f875j;
            if (callback instanceof f.c) {
                ((f.c) callback).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f875j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f874i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f875j = null;
            toolbar3.a();
            this.f896c = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean f(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f874i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f874i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f874i);
            }
            Toolbar.this.f875j = gVar.getActionView();
            this.f896c = gVar;
            ViewParent parent2 = Toolbar.this.f875j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f875j);
                }
                e generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f413a = 8388611 | (toolbar4.f880o & 112);
                generateDefaultLayoutParams.f898b = 2;
                toolbar4.f875j.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f875j);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            gVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f875j;
            if (callback instanceof f.c) {
                ((f.c) callback).c();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean h(androidx.appcompat.view.menu.m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public void i(boolean z4) {
            if (this.f896c != null) {
                androidx.appcompat.view.menu.e eVar = this.f895b;
                boolean z5 = false;
                if (eVar != null) {
                    int size = eVar.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            break;
                        }
                        if (this.f895b.getItem(i4) == this.f896c) {
                            z5 = true;
                            break;
                        }
                        i4++;
                    }
                }
                if (z5) {
                    return;
                }
                e(this.f895b, this.f896c);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends a.C0004a {

        /* renamed from: b, reason: collision with root package name */
        int f898b;

        public e(int i4, int i5) {
            super(i4, i5);
            this.f898b = 0;
            this.f413a = 8388627;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f898b = 0;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f898b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f898b = 0;
            a(marginLayoutParams);
        }

        public e(a.C0004a c0004a) {
            super(c0004a);
            this.f898b = 0;
        }

        public e(e eVar) {
            super((a.C0004a) eVar);
            this.f898b = 0;
            this.f898b = eVar.f898b;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public static class g extends b0.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        int f899d;

        /* renamed from: e, reason: collision with root package name */
        boolean f900e;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i4) {
                return new g[i4];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f899d = parcel.readInt();
            this.f900e = parcel.readInt() != 0;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f899d);
            parcel.writeInt(this.f900e ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.M);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f889x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.I = new a();
        this.P = new b();
        w0 u4 = w0.u(getContext(), attributeSet, a.j.T2, i4, 0);
        this.f878m = u4.n(a.j.f242v3, 0);
        this.f879n = u4.n(a.j.f197m3, 0);
        this.f889x = u4.l(a.j.U2, this.f889x);
        this.f880o = u4.l(a.j.V2, 48);
        int e4 = u4.e(a.j.f212p3, 0);
        int i5 = a.j.f237u3;
        e4 = u4.r(i5) ? u4.e(i5, e4) : e4;
        this.f885t = e4;
        this.f884s = e4;
        this.f883r = e4;
        this.f882q = e4;
        int e5 = u4.e(a.j.f227s3, -1);
        if (e5 >= 0) {
            this.f882q = e5;
        }
        int e6 = u4.e(a.j.f222r3, -1);
        if (e6 >= 0) {
            this.f883r = e6;
        }
        int e7 = u4.e(a.j.f232t3, -1);
        if (e7 >= 0) {
            this.f884s = e7;
        }
        int e8 = u4.e(a.j.f217q3, -1);
        if (e8 >= 0) {
            this.f885t = e8;
        }
        this.f881p = u4.f(a.j.f167g3, -1);
        int e9 = u4.e(a.j.f147c3, RecyclerView.UNDEFINED_DURATION);
        int e10 = u4.e(a.j.Y2, RecyclerView.UNDEFINED_DURATION);
        int f4 = u4.f(a.j.f137a3, 0);
        int f5 = u4.f(a.j.f142b3, 0);
        h();
        this.f886u.e(f4, f5);
        if (e9 != Integer.MIN_VALUE || e10 != Integer.MIN_VALUE) {
            this.f886u.g(e9, e10);
        }
        this.f887v = u4.e(a.j.f152d3, RecyclerView.UNDEFINED_DURATION);
        this.f888w = u4.e(a.j.Z2, RecyclerView.UNDEFINED_DURATION);
        this.f872g = u4.g(a.j.X2);
        this.f873h = u4.p(a.j.W2);
        CharSequence p4 = u4.p(a.j.f207o3);
        if (!TextUtils.isEmpty(p4)) {
            setTitle(p4);
        }
        CharSequence p5 = u4.p(a.j.f192l3);
        if (!TextUtils.isEmpty(p5)) {
            setSubtitle(p5);
        }
        this.f876k = getContext();
        setPopupTheme(u4.n(a.j.f187k3, 0));
        Drawable g4 = u4.g(a.j.f182j3);
        if (g4 != null) {
            setNavigationIcon(g4);
        }
        CharSequence p6 = u4.p(a.j.f177i3);
        if (!TextUtils.isEmpty(p6)) {
            setNavigationContentDescription(p6);
        }
        Drawable g5 = u4.g(a.j.f157e3);
        if (g5 != null) {
            setLogo(g5);
        }
        CharSequence p7 = u4.p(a.j.f162f3);
        if (!TextUtils.isEmpty(p7)) {
            setLogoDescription(p7);
        }
        int i6 = a.j.f247w3;
        if (u4.r(i6)) {
            setTitleTextColor(u4.c(i6));
        }
        int i7 = a.j.f202n3;
        if (u4.r(i7)) {
            setSubtitleTextColor(u4.c(i7));
        }
        int i8 = a.j.f172h3;
        if (u4.r(i8)) {
            x(u4.n(i8, 0));
        }
        u4.v();
    }

    private int B(View view, int i4, int[] iArr, int i5) {
        e eVar = (e) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = i4 + Math.max(0, i6);
        iArr[0] = Math.max(0, -i6);
        int q4 = q(view, i5);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q4, max + measuredWidth, view.getMeasuredHeight() + q4);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    private int C(View view, int i4, int[] iArr, int i5) {
        e eVar = (e) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i4 - Math.max(0, i6);
        iArr[1] = Math.max(0, -i6);
        int q4 = q(view, i5);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q4, max, view.getMeasuredHeight() + q4);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    private int D(View view, int i4, int i5, int i6, int i7, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i8 = marginLayoutParams.leftMargin - iArr[0];
        int i9 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i8) + Math.max(0, i9);
        iArr[0] = Math.max(0, -i8);
        iArr[1] = Math.max(0, -i9);
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight() + max + i5, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void E(View view, int i4, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i8 >= 0) {
            if (mode != 0) {
                i8 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i8);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void F() {
        removeCallbacks(this.P);
        post(this.P);
    }

    private boolean L() {
        if (!this.O) {
            return false;
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (M(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean M(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i4) {
        boolean z4 = y.p.t(this) == 1;
        int childCount = getChildCount();
        int b5 = y.c.b(i4, y.p.t(this));
        list.clear();
        if (!z4) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f898b == 0 && M(childAt) && p(eVar.f413a) == b5) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f898b == 0 && M(childAt2) && p(eVar2.f413a) == b5) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        generateDefaultLayoutParams.f898b = 1;
        if (!z4 || this.f875j == null) {
            addView(view, generateDefaultLayoutParams);
        } else {
            view.setLayoutParams(generateDefaultLayoutParams);
            this.F.add(view);
        }
    }

    private MenuInflater getMenuInflater() {
        return new f.g(getContext());
    }

    private void h() {
        if (this.f886u == null) {
            this.f886u = new o0();
        }
    }

    private void i() {
        if (this.f871f == null) {
            this.f871f = new o(getContext());
        }
    }

    private void j() {
        k();
        if (this.f867b.N() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f867b.getMenu();
            if (this.L == null) {
                this.L = new d();
            }
            this.f867b.setExpandedActionViewsExclusive(true);
            eVar.c(this.L, this.f876k);
        }
    }

    private void k() {
        if (this.f867b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f867b = actionMenuView;
            actionMenuView.setPopupTheme(this.f877l);
            this.f867b.setOnMenuItemClickListener(this.I);
            this.f867b.O(this.M, this.N);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f413a = 8388613 | (this.f880o & 112);
            this.f867b.setLayoutParams(generateDefaultLayoutParams);
            c(this.f867b, false);
        }
    }

    private void l() {
        if (this.f870e == null) {
            this.f870e = new m(getContext(), null, a.a.L);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f413a = 8388611 | (this.f880o & 112);
            this.f870e.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int p(int i4) {
        int t4 = y.p.t(this);
        int b5 = y.c.b(i4, t4) & 7;
        return (b5 == 1 || b5 == 3 || b5 == 5) ? b5 : t4 == 1 ? 5 : 3;
    }

    private int q(View view, int i4) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i4 > 0 ? (measuredHeight - i4) / 2 : 0;
        int r4 = r(eVar.f413a);
        if (r4 == 48) {
            return getPaddingTop() - i5;
        }
        if (r4 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i5;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i6 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i7 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (i6 < i7) {
            i6 = i7;
        } else {
            int i8 = (((height - paddingBottom) - measuredHeight) - i6) - paddingTop;
            int i9 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i8 < i9) {
                i6 = Math.max(0, i6 - (i9 - i8));
            }
        }
        return paddingTop + i6;
    }

    private int r(int i4) {
        int i5 = i4 & 112;
        return (i5 == 16 || i5 == 48 || i5 == 80) ? i5 : this.f889x & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return y.f.b(marginLayoutParams) + y.f.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i4 = iArr[0];
        int i5 = iArr[1];
        int size = list.size();
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            View view = list.get(i6);
            e eVar = (e) view.getLayoutParams();
            int i8 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i4;
            int i9 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i5;
            int max = Math.max(0, i8);
            int max2 = Math.max(0, i9);
            int max3 = Math.max(0, -i8);
            int max4 = Math.max(0, -i9);
            i7 += max + view.getMeasuredWidth() + max2;
            i6++;
            i5 = max4;
            i4 = max3;
        }
        return i7;
    }

    private boolean y(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f867b;
        return actionMenuView != null && actionMenuView.J();
    }

    void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f898b != 2 && childAt != this.f867b) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    public void H(int i4, int i5) {
        h();
        this.f886u.g(i4, i5);
    }

    public void I(androidx.appcompat.view.menu.e eVar, androidx.appcompat.widget.c cVar) {
        if (eVar == null && this.f867b == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e N = this.f867b.N();
        if (N == eVar) {
            return;
        }
        if (N != null) {
            N.O(this.K);
            N.O(this.L);
        }
        if (this.L == null) {
            this.L = new d();
        }
        cVar.F(true);
        if (eVar != null) {
            eVar.c(cVar, this.f876k);
            eVar.c(this.L, this.f876k);
        } else {
            cVar.d(this.f876k, null);
            this.L.d(this.f876k, null);
            cVar.i(true);
            this.L.i(true);
        }
        this.f867b.setPopupTheme(this.f877l);
        this.f867b.setPresenter(cVar);
        this.K = cVar;
    }

    public void J(Context context, int i4) {
        this.f879n = i4;
        TextView textView = this.f869d;
        if (textView != null) {
            textView.setTextAppearance(context, i4);
        }
    }

    public void K(Context context, int i4) {
        this.f878m = i4;
        TextView textView = this.f868c;
        if (textView != null) {
            textView.setTextAppearance(context, i4);
        }
    }

    public boolean N() {
        ActionMenuView actionMenuView = this.f867b;
        return actionMenuView != null && actionMenuView.P();
    }

    void a() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f867b) != null && actionMenuView.K();
    }

    public void e() {
        d dVar = this.L;
        androidx.appcompat.view.menu.g gVar = dVar == null ? null : dVar.f896c;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f867b;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.f874i == null) {
            m mVar = new m(getContext(), null, a.a.L);
            this.f874i = mVar;
            mVar.setImageDrawable(this.f872g);
            this.f874i.setContentDescription(this.f873h);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f413a = 8388611 | (this.f880o & 112);
            generateDefaultLayoutParams.f898b = 2;
            this.f874i.setLayoutParams(generateDefaultLayoutParams);
            this.f874i.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f874i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f874i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        o0 o0Var = this.f886u;
        if (o0Var != null) {
            return o0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i4 = this.f888w;
        return i4 != Integer.MIN_VALUE ? i4 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        o0 o0Var = this.f886u;
        if (o0Var != null) {
            return o0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        o0 o0Var = this.f886u;
        if (o0Var != null) {
            return o0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        o0 o0Var = this.f886u;
        if (o0Var != null) {
            return o0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i4 = this.f887v;
        return i4 != Integer.MIN_VALUE ? i4 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e N;
        ActionMenuView actionMenuView = this.f867b;
        return actionMenuView != null && (N = actionMenuView.N()) != null && N.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.f888w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return y.p.t(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return y.p.t(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f887v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f871f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f871f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f867b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f870e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f870e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f867b.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f876k;
    }

    public int getPopupTheme() {
        return this.f877l;
    }

    public CharSequence getSubtitle() {
        return this.f891z;
    }

    final TextView getSubtitleTextView() {
        return this.f869d;
    }

    public CharSequence getTitle() {
        return this.f890y;
    }

    public int getTitleMarginBottom() {
        return this.f885t;
    }

    public int getTitleMarginEnd() {
        return this.f883r;
    }

    public int getTitleMarginStart() {
        return this.f882q;
    }

    public int getTitleMarginTop() {
        return this.f884s;
    }

    final TextView getTitleTextView() {
        return this.f868c;
    }

    public d0 getWrapper() {
        if (this.J == null) {
            this.J = new x0(this, true);
        }
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.C0004a ? new e((a.C0004a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.P);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:112:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0295 A[LOOP:0: B:46:0x0293->B:47:0x0295, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02b7 A[LOOP:1: B:50:0x02b5->B:51:0x02b7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02f0 A[LOOP:2: B:59:0x02ee->B:60:0x02f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x021d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 773
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int[] iArr = this.G;
        boolean b5 = c1.b(this);
        int i13 = !b5 ? 1 : 0;
        if (M(this.f870e)) {
            E(this.f870e, i4, 0, i5, 0, this.f881p);
            i6 = this.f870e.getMeasuredWidth() + s(this.f870e);
            i7 = Math.max(0, this.f870e.getMeasuredHeight() + t(this.f870e));
            i8 = View.combineMeasuredStates(0, this.f870e.getMeasuredState());
        } else {
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (M(this.f874i)) {
            E(this.f874i, i4, 0, i5, 0, this.f881p);
            i6 = this.f874i.getMeasuredWidth() + s(this.f874i);
            i7 = Math.max(i7, this.f874i.getMeasuredHeight() + t(this.f874i));
            i8 = View.combineMeasuredStates(i8, this.f874i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i6);
        iArr[b5 ? 1 : 0] = Math.max(0, currentContentInsetStart - i6);
        if (M(this.f867b)) {
            E(this.f867b, i4, max, i5, 0, this.f881p);
            i9 = this.f867b.getMeasuredWidth() + s(this.f867b);
            i7 = Math.max(i7, this.f867b.getMeasuredHeight() + t(this.f867b));
            i8 = View.combineMeasuredStates(i8, this.f867b.getMeasuredState());
        } else {
            i9 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i9);
        iArr[i13] = Math.max(0, currentContentInsetEnd - i9);
        if (M(this.f875j)) {
            max2 += D(this.f875j, i4, max2, i5, 0, iArr);
            i7 = Math.max(i7, this.f875j.getMeasuredHeight() + t(this.f875j));
            i8 = View.combineMeasuredStates(i8, this.f875j.getMeasuredState());
        }
        if (M(this.f871f)) {
            max2 += D(this.f871f, i4, max2, i5, 0, iArr);
            i7 = Math.max(i7, this.f871f.getMeasuredHeight() + t(this.f871f));
            i8 = View.combineMeasuredStates(i8, this.f871f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (((e) childAt.getLayoutParams()).f898b == 0 && M(childAt)) {
                max2 += D(childAt, i4, max2, i5, 0, iArr);
                i7 = Math.max(i7, childAt.getMeasuredHeight() + t(childAt));
                i8 = View.combineMeasuredStates(i8, childAt.getMeasuredState());
            }
        }
        int i15 = this.f884s + this.f885t;
        int i16 = this.f882q + this.f883r;
        if (M(this.f868c)) {
            D(this.f868c, i4, max2 + i16, i5, i15, iArr);
            int measuredWidth = this.f868c.getMeasuredWidth() + s(this.f868c);
            i10 = this.f868c.getMeasuredHeight() + t(this.f868c);
            i11 = View.combineMeasuredStates(i8, this.f868c.getMeasuredState());
            i12 = measuredWidth;
        } else {
            i10 = 0;
            i11 = i8;
            i12 = 0;
        }
        if (M(this.f869d)) {
            i12 = Math.max(i12, D(this.f869d, i4, max2 + i16, i5, i10 + i15, iArr));
            i10 += this.f869d.getMeasuredHeight() + t(this.f869d);
            i11 = View.combineMeasuredStates(i11, this.f869d.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max2 + i12 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i4, (-16777216) & i11), L() ? 0 : View.resolveSizeAndState(Math.max(Math.max(i7, i10) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i5, i11 << 16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.f());
        ActionMenuView actionMenuView = this.f867b;
        androidx.appcompat.view.menu.e N = actionMenuView != null ? actionMenuView.N() : null;
        int i4 = gVar.f899d;
        if (i4 != 0 && this.L != null && N != null && (findItem = N.findItem(i4)) != null) {
            findItem.expandActionView();
        }
        if (gVar.f900e) {
            F();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        h();
        this.f886u.f(i4 == 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        g gVar2 = new g(super.onSaveInstanceState());
        d dVar = this.L;
        if (dVar != null && (gVar = dVar.f896c) != null) {
            gVar2.f899d = gVar.getItemId();
        }
        gVar2.f900e = A();
        return gVar2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i4) {
        setCollapseContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f874i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i4) {
        setCollapseIcon(c.a.b(getContext(), i4));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f874i.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f874i;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f872g);
            }
        }
    }

    public void setCollapsible(boolean z4) {
        this.O = z4;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i4) {
        if (i4 < 0) {
            i4 = RecyclerView.UNDEFINED_DURATION;
        }
        if (i4 != this.f888w) {
            this.f888w = i4;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i4) {
        if (i4 < 0) {
            i4 = RecyclerView.UNDEFINED_DURATION;
        }
        if (i4 != this.f887v) {
            this.f887v = i4;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i4) {
        setLogo(c.a.b(getContext(), i4));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f871f)) {
                c(this.f871f, true);
            }
        } else {
            ImageView imageView = this.f871f;
            if (imageView != null && y(imageView)) {
                removeView(this.f871f);
                this.F.remove(this.f871f);
            }
        }
        ImageView imageView2 = this.f871f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i4) {
        setLogoDescription(getContext().getText(i4));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f871f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i4) {
        setNavigationContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f870e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i4) {
        setNavigationIcon(c.a.b(getContext(), i4));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f870e)) {
                c(this.f870e, true);
            }
        } else {
            ImageButton imageButton = this.f870e;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f870e);
                this.F.remove(this.f870e);
            }
        }
        ImageButton imageButton2 = this.f870e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f870e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.H = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f867b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i4) {
        if (this.f877l != i4) {
            this.f877l = i4;
            if (i4 == 0) {
                this.f876k = getContext();
            } else {
                this.f876k = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    public void setSubtitle(int i4) {
        setSubtitle(getContext().getText(i4));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f869d;
            if (textView != null && y(textView)) {
                removeView(this.f869d);
                this.F.remove(this.f869d);
            }
        } else {
            if (this.f869d == null) {
                Context context = getContext();
                z zVar = new z(context);
                this.f869d = zVar;
                zVar.setSingleLine();
                this.f869d.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f879n;
                if (i4 != 0) {
                    this.f869d.setTextAppearance(context, i4);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f869d.setTextColor(colorStateList);
                }
            }
            if (!y(this.f869d)) {
                c(this.f869d, true);
            }
        }
        TextView textView2 = this.f869d;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f891z = charSequence;
    }

    public void setSubtitleTextColor(int i4) {
        setSubtitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.f869d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i4) {
        setTitle(getContext().getText(i4));
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f868c;
            if (textView != null && y(textView)) {
                removeView(this.f868c);
                this.F.remove(this.f868c);
            }
        } else {
            if (this.f868c == null) {
                Context context = getContext();
                z zVar = new z(context);
                this.f868c = zVar;
                zVar.setSingleLine();
                this.f868c.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f878m;
                if (i4 != 0) {
                    this.f868c.setTextAppearance(context, i4);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f868c.setTextColor(colorStateList);
                }
            }
            if (!y(this.f868c)) {
                c(this.f868c, true);
            }
        }
        TextView textView2 = this.f868c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f890y = charSequence;
    }

    public void setTitleMarginBottom(int i4) {
        this.f885t = i4;
        requestLayout();
    }

    public void setTitleMarginEnd(int i4) {
        this.f883r = i4;
        requestLayout();
    }

    public void setTitleMarginStart(int i4) {
        this.f882q = i4;
        requestLayout();
    }

    public void setTitleMarginTop(int i4) {
        this.f884s = i4;
        requestLayout();
    }

    public void setTitleTextColor(int i4) {
        setTitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f868c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public boolean v() {
        d dVar = this.L;
        return (dVar == null || dVar.f896c == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f867b;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i4) {
        getMenuInflater().inflate(i4, getMenu());
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.f867b;
        return actionMenuView != null && actionMenuView.I();
    }
}
