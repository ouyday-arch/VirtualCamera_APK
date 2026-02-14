package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.i0;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class ActionMenuView extends i0 implements e.b, androidx.appcompat.view.menu.k {
    private int A;
    e B;

    /* renamed from: q, reason: collision with root package name */
    private androidx.appcompat.view.menu.e f783q;

    /* renamed from: r, reason: collision with root package name */
    private Context f784r;

    /* renamed from: s, reason: collision with root package name */
    private int f785s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f786t;

    /* renamed from: u, reason: collision with root package name */
    private androidx.appcompat.widget.c f787u;

    /* renamed from: v, reason: collision with root package name */
    private j.a f788v;

    /* renamed from: w, reason: collision with root package name */
    e.a f789w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f790x;

    /* renamed from: y, reason: collision with root package name */
    private int f791y;

    /* renamed from: z, reason: collision with root package name */
    private int f792z;

    /* loaded from: classes.dex */
    public interface a {
        boolean a();

        boolean b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements j.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends i0.a {

        /* renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f793c;

        /* renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f794d;

        /* renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f795e;

        /* renamed from: f, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f796f;

        /* renamed from: g, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f797g;

        /* renamed from: h, reason: collision with root package name */
        boolean f798h;

        public c(int i4, int i5) {
            super(i4, i5);
            this.f793c = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f793c = cVar.f793c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements e.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.B;
            return eVar2 != null && eVar2.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            e.a aVar = ActionMenuView.this.f789w;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f792z = (int) (56.0f * f4);
        this.A = (int) (f4 * 4.0f);
        this.f784r = context;
        this.f785s = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(View view, int i4, int i5, int i6, int i7) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6) - i7, View.MeasureSpec.getMode(i6));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z4 = actionMenuItemView != null && actionMenuItemView.f();
        int i8 = 2;
        if (i5 <= 0 || (z4 && i5 < 2)) {
            i8 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i4, RecyclerView.UNDEFINED_DURATION), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i9 = measuredWidth / i4;
            if (measuredWidth % i4 != 0) {
                i9++;
            }
            if (!z4 || i9 >= 2) {
                i8 = i9;
            }
        }
        cVar.f796f = !cVar.f793c && z4;
        cVar.f794d = i8;
        view.measure(View.MeasureSpec.makeMeasureSpec(i4 * i8, 1073741824), makeMeasureSpec);
        return i8;
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v14 */
    private void M(int i4, int i5) {
        int i6;
        int i7;
        boolean z4;
        int i8;
        int i9;
        boolean z5;
        boolean z6;
        int i10;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, paddingTop, -2);
        int i11 = size - paddingLeft;
        int i12 = this.f792z;
        int i13 = i11 / i12;
        int i14 = i11 % i12;
        if (i13 == 0) {
            setMeasuredDimension(i11, 0);
            return;
        }
        int i15 = i12 + (i14 / i13);
        int childCount = getChildCount();
        int i16 = 0;
        int i17 = 0;
        boolean z7 = false;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        long j4 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            int i21 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z8 = childAt instanceof ActionMenuItemView;
                int i22 = i18 + 1;
                if (z8) {
                    int i23 = this.A;
                    i10 = i22;
                    r14 = 0;
                    childAt.setPadding(i23, 0, i23, 0);
                } else {
                    i10 = i22;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f798h = r14;
                cVar.f795e = r14;
                cVar.f794d = r14;
                cVar.f796f = r14;
                ((ViewGroup.MarginLayoutParams) cVar).leftMargin = r14;
                ((ViewGroup.MarginLayoutParams) cVar).rightMargin = r14;
                cVar.f797g = z8 && ((ActionMenuItemView) childAt).f();
                int L = L(childAt, i15, cVar.f793c ? 1 : i13, childMeasureSpec, paddingTop);
                i19 = Math.max(i19, L);
                if (cVar.f796f) {
                    i20++;
                }
                if (cVar.f793c) {
                    z7 = true;
                }
                i13 -= L;
                i16 = Math.max(i16, childAt.getMeasuredHeight());
                if (L == 1) {
                    j4 |= 1 << i17;
                    i16 = i16;
                }
                i18 = i10;
            }
            i17++;
            size2 = i21;
        }
        int i24 = size2;
        boolean z9 = z7 && i18 == 2;
        boolean z10 = false;
        while (i20 > 0 && i13 > 0) {
            int i25 = Integer.MAX_VALUE;
            int i26 = 0;
            int i27 = 0;
            long j5 = 0;
            while (i27 < childCount) {
                boolean z11 = z10;
                c cVar2 = (c) getChildAt(i27).getLayoutParams();
                int i28 = i16;
                if (cVar2.f796f) {
                    int i29 = cVar2.f794d;
                    if (i29 < i25) {
                        j5 = 1 << i27;
                        i25 = i29;
                        i26 = 1;
                    } else if (i29 == i25) {
                        i26++;
                        j5 |= 1 << i27;
                    }
                }
                i27++;
                i16 = i28;
                z10 = z11;
            }
            z4 = z10;
            i8 = i16;
            j4 |= j5;
            if (i26 > i13) {
                i6 = mode;
                i7 = i11;
                break;
            }
            int i30 = i25 + 1;
            int i31 = 0;
            while (i31 < childCount) {
                View childAt2 = getChildAt(i31);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i32 = i11;
                int i33 = mode;
                long j6 = 1 << i31;
                if ((j5 & j6) == 0) {
                    if (cVar3.f794d == i30) {
                        j4 |= j6;
                    }
                    z6 = z9;
                } else {
                    if (z9 && cVar3.f797g && i13 == 1) {
                        int i34 = this.A;
                        z6 = z9;
                        childAt2.setPadding(i34 + i15, 0, i34, 0);
                    } else {
                        z6 = z9;
                    }
                    cVar3.f794d++;
                    cVar3.f798h = true;
                    i13--;
                }
                i31++;
                mode = i33;
                i11 = i32;
                z9 = z6;
            }
            i16 = i8;
            z10 = true;
        }
        i6 = mode;
        i7 = i11;
        z4 = z10;
        i8 = i16;
        boolean z12 = !z7 && i18 == 1;
        if (i13 <= 0 || j4 == 0 || (i13 >= i18 - 1 && !z12 && i19 <= 1)) {
            i9 = 0;
            z5 = z4;
        } else {
            float bitCount = Long.bitCount(j4);
            if (z12) {
                i9 = 0;
            } else {
                i9 = 0;
                if ((j4 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f797g) {
                    bitCount -= 0.5f;
                }
                int i35 = childCount - 1;
                if ((j4 & (1 << i35)) != 0 && !((c) getChildAt(i35).getLayoutParams()).f797g) {
                    bitCount -= 0.5f;
                }
            }
            int i36 = bitCount > 0.0f ? (int) ((i13 * i15) / bitCount) : i9;
            z5 = z4;
            for (int i37 = i9; i37 < childCount; i37++) {
                if ((j4 & (1 << i37)) != 0) {
                    View childAt3 = getChildAt(i37);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f795e = i36;
                        cVar4.f798h = true;
                        if (i37 == 0 && !cVar4.f797g) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = (-i36) / 2;
                        }
                        z5 = true;
                    } else if (cVar4.f793c) {
                        cVar4.f795e = i36;
                        cVar4.f798h = true;
                        ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = (-i36) / 2;
                        z5 = true;
                    } else {
                        if (i37 != 0) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = i36 / 2;
                        }
                        if (i37 != childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = i36 / 2;
                        }
                    }
                }
            }
        }
        if (z5) {
            for (int i38 = i9; i38 < childCount; i38++) {
                View childAt4 = getChildAt(i38);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f798h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f794d * i15) + cVar5.f795e, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i7, i6 != 1073741824 ? i8 : i24);
    }

    public void B() {
        androidx.appcompat.widget.c cVar = this.f787u;
        if (cVar != null) {
            cVar.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.f1036b = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.i0
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.f1036b <= 0) {
            cVar.f1036b = 16;
        }
        return cVar;
    }

    public c F() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f793c = true;
        return generateDefaultLayoutParams;
    }

    protected boolean G(int i4) {
        boolean z4 = false;
        if (i4 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i4 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i4);
        if (i4 < getChildCount() && (childAt instanceof a)) {
            z4 = false | ((a) childAt).a();
        }
        return (i4 <= 0 || !(childAt2 instanceof a)) ? z4 : z4 | ((a) childAt2).b();
    }

    public boolean H() {
        androidx.appcompat.widget.c cVar = this.f787u;
        return cVar != null && cVar.A();
    }

    public boolean I() {
        androidx.appcompat.widget.c cVar = this.f787u;
        return cVar != null && cVar.C();
    }

    public boolean J() {
        androidx.appcompat.widget.c cVar = this.f787u;
        return cVar != null && cVar.D();
    }

    public boolean K() {
        return this.f786t;
    }

    public androidx.appcompat.view.menu.e N() {
        return this.f783q;
    }

    public void O(j.a aVar, e.a aVar2) {
        this.f788v = aVar;
        this.f789w = aVar2;
    }

    public boolean P() {
        androidx.appcompat.widget.c cVar = this.f787u;
        return cVar != null && cVar.J();
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(androidx.appcompat.view.menu.g gVar) {
        return this.f783q.L(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(androidx.appcompat.view.menu.e eVar) {
        this.f783q = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f783q == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.f783q = eVar;
            eVar.R(new d());
            androidx.appcompat.widget.c cVar = new androidx.appcompat.widget.c(context);
            this.f787u = cVar;
            cVar.I(true);
            androidx.appcompat.widget.c cVar2 = this.f787u;
            j.a aVar = this.f788v;
            if (aVar == null) {
                aVar = new b();
            }
            cVar2.g(aVar);
            this.f783q.c(this.f787u, this.f784r);
            this.f787u.G(this);
        }
        return this.f783q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f787u.z();
    }

    public int getPopupTheme() {
        return this.f785s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.c cVar = this.f787u;
        if (cVar != null) {
            cVar.i(false);
            if (this.f787u.D()) {
                this.f787u.A();
                this.f787u.J();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int width;
        int i8;
        if (!this.f790x) {
            super.onLayout(z4, i4, i5, i6, i7);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i7 - i5) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i6 - i4;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean b5 = c1.b(this);
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f793c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b5) {
                        i8 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                        width = i8 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        i8 = width - measuredWidth;
                    }
                    int i14 = i9 - (measuredHeight / 2);
                    childAt.layout(i8, i14, width, measuredHeight + i14);
                    paddingRight -= measuredWidth;
                    i11 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin) + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                    G(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i10 / 2) - (measuredWidth2 / 2);
            int i16 = i9 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        int max = Math.max(0, i17 > 0 ? paddingRight / i17 : 0);
        if (b5) {
            int width2 = getWidth() - getPaddingRight();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt3 = getChildAt(i18);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f793c) {
                    int i19 = width2 - ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width2 = i19 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt4 = getChildAt(i21);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f793c) {
                int i22 = paddingLeft + ((ViewGroup.MarginLayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i23 = i9 - (measuredHeight4 / 2);
                childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                paddingLeft = i22 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) cVar3).rightMargin + max;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0, android.view.View
    public void onMeasure(int i4, int i5) {
        androidx.appcompat.view.menu.e eVar;
        boolean z4 = this.f790x;
        boolean z5 = View.MeasureSpec.getMode(i4) == 1073741824;
        this.f790x = z5;
        if (z4 != z5) {
            this.f791y = 0;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (this.f790x && (eVar = this.f783q) != null && size != this.f791y) {
            this.f791y = size;
            eVar.K(true);
        }
        int childCount = getChildCount();
        if (this.f790x && childCount > 0) {
            M(i4, i5);
            return;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            c cVar = (c) getChildAt(i6).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) cVar).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i4, i5);
    }

    public void setExpandedActionViewsExclusive(boolean z4) {
        this.f787u.F(z4);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.B = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f787u.H(drawable);
    }

    public void setOverflowReserved(boolean z4) {
        this.f786t = z4;
    }

    public void setPopupTheme(int i4) {
        if (this.f785s != i4) {
            this.f785s = i4;
            if (i4 == 0) {
                this.f784r = getContext();
            } else {
                this.f784r = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.c cVar) {
        this.f787u = cVar;
        cVar.G(this);
    }
}
