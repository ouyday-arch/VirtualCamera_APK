package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import y.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends androidx.appcompat.view.menu.a implements b.a {
    a A;
    RunnableC0008c B;
    private b C;
    final f D;
    int E;

    /* renamed from: l, reason: collision with root package name */
    d f941l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f942m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f943n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f944o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f945p;

    /* renamed from: q, reason: collision with root package name */
    private int f946q;

    /* renamed from: r, reason: collision with root package name */
    private int f947r;

    /* renamed from: s, reason: collision with root package name */
    private int f948s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f949t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f950u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f951v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f952w;

    /* renamed from: x, reason: collision with root package name */
    private int f953x;

    /* renamed from: y, reason: collision with root package name */
    private final SparseBooleanArray f954y;

    /* renamed from: z, reason: collision with root package name */
    e f955z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.i {
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false, a.a.f11l);
            if (!((androidx.appcompat.view.menu.g) mVar.getItem()).l()) {
                View view2 = c.this.f941l;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.a) c.this).f585j : view2);
            }
            j(c.this.D);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            c cVar = c.this;
            cVar.A = null;
            cVar.E = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public g.e a() {
            a aVar = c.this.A;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0008c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private e f958b;

        public RunnableC0008c(e eVar) {
            this.f958b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.a) c.this).f579d != null) {
                ((androidx.appcompat.view.menu.a) c.this).f579d.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.a) c.this).f585j;
            if (view != null && view.getWindowToken() != null && this.f958b.m()) {
                c.this.f955z = this.f958b;
            }
            c.this.B = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends o implements ActionMenuView.a {

        /* renamed from: d, reason: collision with root package name */
        private final float[] f960d;

        /* loaded from: classes.dex */
        class a extends h0 {

            /* renamed from: k, reason: collision with root package name */
            final /* synthetic */ c f962k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, c cVar) {
                super(view);
                this.f962k = cVar;
            }

            @Override // androidx.appcompat.widget.h0
            public g.e b() {
                e eVar = c.this.f955z;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.h0
            public boolean c() {
                c.this.J();
                return true;
            }

            @Override // androidx.appcompat.widget.h0
            public boolean d() {
                c cVar = c.this;
                if (cVar.B != null) {
                    return false;
                }
                cVar.A();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, a.a.f10k);
            this.f960d = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            y0.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.J();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i4, int i5, int i6, int i7) {
            boolean frame = super.setFrame(i4, i5, i6, i7);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                r.a.g(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z4) {
            super(context, eVar, view, z4, a.a.f11l);
            h(8388613);
            j(c.this.D);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            if (((androidx.appcompat.view.menu.a) c.this).f579d != null) {
                ((androidx.appcompat.view.menu.a) c.this).f579d.close();
            }
            c.this.f955z = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
            if (eVar instanceof androidx.appcompat.view.menu.m) {
                eVar.D().e(false);
            }
            j.a m4 = c.this.m();
            if (m4 != null) {
                m4.a(eVar, z4);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            if (eVar == null) {
                return false;
            }
            c.this.E = ((androidx.appcompat.view.menu.m) eVar).getItem().getItemId();
            j.a m4 = c.this.m();
            if (m4 != null) {
                return m4.b(eVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, a.g.f100c, a.g.f99b);
        this.f954y = new SparseBooleanArray();
        this.D = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View y(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f585j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        Object obj;
        RunnableC0008c runnableC0008c = this.B;
        if (runnableC0008c != null && (obj = this.f585j) != null) {
            ((View) obj).removeCallbacks(runnableC0008c);
            this.B = null;
            return true;
        }
        e eVar = this.f955z;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean B() {
        a aVar = this.A;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean C() {
        return this.B != null || D();
    }

    public boolean D() {
        e eVar = this.f955z;
        return eVar != null && eVar.d();
    }

    public void E(Configuration configuration) {
        if (!this.f949t) {
            this.f948s = f.a.b(this.f578c).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f579d;
        if (eVar != null) {
            eVar.K(true);
        }
    }

    public void F(boolean z4) {
        this.f952w = z4;
    }

    public void G(ActionMenuView actionMenuView) {
        this.f585j = actionMenuView;
        actionMenuView.b(this.f579d);
    }

    public void H(Drawable drawable) {
        d dVar = this.f941l;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f943n = true;
            this.f942m = drawable;
        }
    }

    public void I(boolean z4) {
        this.f944o = z4;
        this.f945p = true;
    }

    public boolean J() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f944o || D() || (eVar = this.f579d) == null || this.f585j == null || this.B != null || eVar.z().isEmpty()) {
            return false;
        }
        RunnableC0008c runnableC0008c = new RunnableC0008c(new e(this.f578c, this.f579d, this.f941l, true));
        this.B = runnableC0008c;
        ((View) this.f585j).post(runnableC0008c);
        super.h(null);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
        x();
        super.a(eVar, z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        ArrayList<androidx.appcompat.view.menu.g> arrayList;
        int i4;
        int i5;
        int i6;
        boolean z4;
        int i7;
        c cVar = this;
        androidx.appcompat.view.menu.e eVar = cVar.f579d;
        View view = null;
        ?? r32 = 0;
        if (eVar != null) {
            arrayList = eVar.E();
            i4 = arrayList.size();
        } else {
            arrayList = null;
            i4 = 0;
        }
        int i8 = cVar.f948s;
        int i9 = cVar.f947r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f585j;
        boolean z5 = false;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i4; i12++) {
            androidx.appcompat.view.menu.g gVar = arrayList.get(i12);
            if (gVar.o()) {
                i10++;
            } else if (gVar.n()) {
                i11++;
            } else {
                z5 = true;
            }
            if (cVar.f952w && gVar.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (cVar.f944o && (z5 || i11 + i10 > i8)) {
            i8--;
        }
        int i13 = i8 - i10;
        SparseBooleanArray sparseBooleanArray = cVar.f954y;
        sparseBooleanArray.clear();
        if (cVar.f950u) {
            int i14 = cVar.f953x;
            i6 = i9 / i14;
            i5 = i14 + ((i9 % i14) / i6);
        } else {
            i5 = 0;
            i6 = 0;
        }
        int i15 = 0;
        int i16 = 0;
        while (i15 < i4) {
            androidx.appcompat.view.menu.g gVar2 = arrayList.get(i15);
            if (gVar2.o()) {
                View n4 = cVar.n(gVar2, view, viewGroup);
                if (cVar.f950u) {
                    i6 -= ActionMenuView.L(n4, i5, i6, makeMeasureSpec, r32);
                } else {
                    n4.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n4.getMeasuredWidth();
                i9 -= measuredWidth;
                if (i16 == 0) {
                    i16 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                z4 = r32;
                i7 = i4;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z6 = sparseBooleanArray.get(groupId2);
                boolean z7 = (i13 > 0 || z6) && i9 > 0 && (!cVar.f950u || i6 > 0);
                boolean z8 = z7;
                i7 = i4;
                if (z7) {
                    View n5 = cVar.n(gVar2, null, viewGroup);
                    if (cVar.f950u) {
                        int L = ActionMenuView.L(n5, i5, i6, makeMeasureSpec, 0);
                        i6 -= L;
                        if (L == 0) {
                            z8 = false;
                        }
                    } else {
                        n5.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z9 = z8;
                    int measuredWidth2 = n5.getMeasuredWidth();
                    i9 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z7 = z9 & (!cVar.f950u ? i9 + i16 <= 0 : i9 < 0);
                }
                if (z7 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z6) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i17 = 0; i17 < i15; i17++) {
                        androidx.appcompat.view.menu.g gVar3 = arrayList.get(i17);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i13++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z7) {
                    i13--;
                }
                gVar2.u(z7);
                z4 = false;
            } else {
                z4 = r32;
                i7 = i4;
                gVar2.u(z4);
            }
            i15++;
            r32 = z4;
            i4 = i7;
            view = null;
            cVar = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void d(Context context, androidx.appcompat.view.menu.e eVar) {
        super.d(context, eVar);
        Resources resources = context.getResources();
        f.a b5 = f.a.b(context);
        if (!this.f945p) {
            this.f944o = b5.h();
        }
        if (!this.f951v) {
            this.f946q = b5.c();
        }
        if (!this.f949t) {
            this.f948s = b5.d();
        }
        int i4 = this.f946q;
        if (this.f944o) {
            if (this.f941l == null) {
                d dVar = new d(this.f577b);
                this.f941l = dVar;
                if (this.f943n) {
                    dVar.setImageDrawable(this.f942m);
                    this.f942m = null;
                    this.f943n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f941l.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i4 -= this.f941l.getMeasuredWidth();
        } else {
            this.f941l = null;
        }
        this.f947r = i4;
        this.f953x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean h(androidx.appcompat.view.menu.m mVar) {
        boolean z4 = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.m mVar2 = mVar;
        while (mVar2.e0() != this.f579d) {
            mVar2 = (androidx.appcompat.view.menu.m) mVar2.e0();
        }
        View y4 = y(mVar2.getItem());
        if (y4 == null) {
            return false;
        }
        this.E = mVar.getItem().getItemId();
        int size = mVar.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                break;
            }
            MenuItem item = mVar.getItem(i4);
            if (item.isVisible() && item.getIcon() != null) {
                z4 = true;
                break;
            }
            i4++;
        }
        a aVar = new a(this.f578c, mVar, y4);
        this.A = aVar;
        aVar.g(z4);
        this.A.k();
        super.h(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void i(boolean z4) {
        super.i(z4);
        ((View) this.f585j).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f579d;
        boolean z5 = false;
        if (eVar != null) {
            ArrayList<androidx.appcompat.view.menu.g> s4 = eVar.s();
            int size = s4.size();
            for (int i4 = 0; i4 < size; i4++) {
                y.b a5 = s4.get(i4).a();
                if (a5 != null) {
                    a5.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f579d;
        ArrayList<androidx.appcompat.view.menu.g> z6 = eVar2 != null ? eVar2.z() : null;
        if (this.f944o && z6 != null) {
            int size2 = z6.size();
            if (size2 == 1) {
                z5 = !z6.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z5 = true;
            }
        }
        d dVar = this.f941l;
        if (z5) {
            if (dVar == null) {
                this.f941l = new d(this.f577b);
            }
            ViewGroup viewGroup = (ViewGroup) this.f941l.getParent();
            if (viewGroup != this.f585j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f941l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f585j;
                actionMenuView.addView(this.f941l, actionMenuView.F());
            }
        } else if (dVar != null) {
            Object parent = dVar.getParent();
            Object obj = this.f585j;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.f941l);
            }
        }
        ((ActionMenuView) this.f585j).setOverflowReserved(this.f944o);
    }

    @Override // androidx.appcompat.view.menu.a
    public void j(androidx.appcompat.view.menu.g gVar, k.a aVar) {
        aVar.e(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f585j);
        if (this.C == null) {
            this.C = new b();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean l(ViewGroup viewGroup, int i4) {
        if (viewGroup.getChildAt(i4) == this.f941l) {
            return false;
        }
        return super.l(viewGroup, i4);
    }

    @Override // androidx.appcompat.view.menu.a
    public View n(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.n(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.k o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.k kVar = this.f585j;
        androidx.appcompat.view.menu.k o4 = super.o(viewGroup);
        if (kVar != o4) {
            ((ActionMenuView) o4).setPresenter(this);
        }
        return o4;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean q(int i4, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }

    public boolean x() {
        return A() | B();
    }

    public Drawable z() {
        d dVar = this.f941l;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f943n) {
            return this.f942m;
        }
        return null;
    }
}
