package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g<S> extends m<S> {

    /* renamed from: k0, reason: collision with root package name */
    static final Object f2960k0 = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: l0, reason: collision with root package name */
    static final Object f2961l0 = "NAVIGATION_PREV_TAG";

    /* renamed from: m0, reason: collision with root package name */
    static final Object f2962m0 = "NAVIGATION_NEXT_TAG";

    /* renamed from: n0, reason: collision with root package name */
    static final Object f2963n0 = "SELECTOR_TOGGLE_TAG";

    /* renamed from: a0, reason: collision with root package name */
    private int f2964a0;

    /* renamed from: b0, reason: collision with root package name */
    private com.google.android.material.datepicker.d<S> f2965b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.google.android.material.datepicker.a f2966c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.google.android.material.datepicker.i f2967d0;

    /* renamed from: e0, reason: collision with root package name */
    private k f2968e0;

    /* renamed from: f0, reason: collision with root package name */
    private com.google.android.material.datepicker.c f2969f0;

    /* renamed from: g0, reason: collision with root package name */
    private RecyclerView f2970g0;

    /* renamed from: h0, reason: collision with root package name */
    private RecyclerView f2971h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f2972i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f2973j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f2974b;

        a(int i4) {
            this.f2974b = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f2971h0.smoothScrollToPosition(this.f2974b);
        }
    }

    /* loaded from: classes.dex */
    class b extends y.a {
        b() {
        }

        @Override // y.a
        public void g(View view, z.c cVar) {
            super.g(view, cVar);
            cVar.Y(null);
        }
    }

    /* loaded from: classes.dex */
    class c extends n {
        final /* synthetic */ int I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i4, boolean z4, int i5) {
            super(context, i4, z4);
            this.I = i5;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void M1(RecyclerView.a0 a0Var, int[] iArr) {
            if (this.I == 0) {
                iArr[0] = g.this.f2971h0.getWidth();
                iArr[1] = g.this.f2971h0.getWidth();
            } else {
                iArr[0] = g.this.f2971h0.getHeight();
                iArr[1] = g.this.f2971h0.getHeight();
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements l {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.g.l
        public void a(long j4) {
            if (g.this.f2966c0.g().c(j4)) {
                g.this.f2965b0.d(j4);
                Iterator<com.google.android.material.datepicker.l<S>> it = g.this.Z.iterator();
                while (it.hasNext()) {
                    it.next().a(g.this.f2965b0.a());
                }
                g.this.f2971h0.getAdapter().h();
                if (g.this.f2970g0 != null) {
                    g.this.f2970g0.getAdapter().h();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends RecyclerView.n {

        /* renamed from: a, reason: collision with root package name */
        private final Calendar f2978a = o.i();

        /* renamed from: b, reason: collision with root package name */
        private final Calendar f2979b = o.i();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if ((recyclerView.getAdapter() instanceof p) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                p pVar = (p) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (x.d<Long, Long> dVar : g.this.f2965b0.b()) {
                    Long l4 = dVar.f6461a;
                    if (l4 != null && dVar.f6462b != null) {
                        this.f2978a.setTimeInMillis(l4.longValue());
                        this.f2979b.setTimeInMillis(dVar.f6462b.longValue());
                        int w4 = pVar.w(this.f2978a.get(1));
                        int w5 = pVar.w(this.f2979b.get(1));
                        View C = gridLayoutManager.C(w4);
                        View C2 = gridLayoutManager.C(w5);
                        int X2 = w4 / gridLayoutManager.X2();
                        int X22 = w5 / gridLayoutManager.X2();
                        int i4 = X2;
                        while (i4 <= X22) {
                            if (gridLayoutManager.C(gridLayoutManager.X2() * i4) != null) {
                                canvas.drawRect(i4 == X2 ? C.getLeft() + (C.getWidth() / 2) : 0, r9.getTop() + g.this.f2969f0.f2951d.c(), i4 == X22 ? C2.getLeft() + (C2.getWidth() / 2) : recyclerView.getWidth(), r9.getBottom() - g.this.f2969f0.f2951d.b(), g.this.f2969f0.f2955h);
                            }
                            i4++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends y.a {
        f() {
        }

        @Override // y.a
        public void g(View view, z.c cVar) {
            g gVar;
            int i4;
            super.g(view, cVar);
            if (g.this.f2973j0.getVisibility() == 0) {
                gVar = g.this;
                i4 = m0.i.f5033k;
            } else {
                gVar = g.this;
                i4 = m0.i.f5032j;
            }
            cVar.g0(gVar.I(i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.datepicker.g$g, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0029g extends RecyclerView.t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f2982a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialButton f2983b;

        C0029g(com.google.android.material.datepicker.k kVar, MaterialButton materialButton) {
            this.f2982a = kVar;
            this.f2983b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i4) {
            if (i4 == 0) {
                recyclerView.announceForAccessibility(this.f2983b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i4, int i5) {
            LinearLayoutManager C1 = g.this.C1();
            int Z1 = i4 < 0 ? C1.Z1() : C1.c2();
            g.this.f2967d0 = this.f2982a.v(Z1);
            this.f2983b.setText(this.f2982a.w(Z1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.G1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f2986b;

        i(com.google.android.material.datepicker.k kVar) {
            this.f2986b = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int Z1 = g.this.C1().Z1() + 1;
            if (Z1 < g.this.f2971h0.getAdapter().c()) {
                g.this.E1(this.f2986b.v(Z1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f2988b;

        j(com.google.android.material.datepicker.k kVar) {
            this.f2988b = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int c22 = g.this.C1().c2() - 1;
            if (c22 >= 0) {
                g.this.E1(this.f2988b.v(c22));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum k {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface l {
        void a(long j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B1(Context context) {
        return context.getResources().getDimensionPixelSize(m0.d.f4973j);
    }

    private void D1(int i4) {
        this.f2971h0.post(new a(i4));
    }

    private void v1(View view, com.google.android.material.datepicker.k kVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(m0.f.f4993f);
        materialButton.setTag(f2963n0);
        y.p.a0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(m0.f.f4995h);
        materialButton2.setTag(f2961l0);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(m0.f.f4994g);
        materialButton3.setTag(f2962m0);
        this.f2972i0 = view.findViewById(m0.f.f5000m);
        this.f2973j0 = view.findViewById(m0.f.f4997j);
        F1(k.DAY);
        materialButton.setText(this.f2967d0.j());
        this.f2971h0.addOnScrollListener(new C0029g(kVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(kVar));
        materialButton2.setOnClickListener(new j(kVar));
    }

    private RecyclerView.n w1() {
        return new e();
    }

    public com.google.android.material.datepicker.d<S> A1() {
        return this.f2965b0;
    }

    LinearLayoutManager C1() {
        return (LinearLayoutManager) this.f2971h0.getLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E1(com.google.android.material.datepicker.i iVar) {
        RecyclerView recyclerView;
        int i4;
        com.google.android.material.datepicker.k kVar = (com.google.android.material.datepicker.k) this.f2971h0.getAdapter();
        int x4 = kVar.x(iVar);
        int x5 = x4 - kVar.x(this.f2967d0);
        boolean z4 = Math.abs(x5) > 3;
        boolean z5 = x5 > 0;
        this.f2967d0 = iVar;
        if (!z4 || !z5) {
            if (z4) {
                recyclerView = this.f2971h0;
                i4 = x4 + 3;
            }
            D1(x4);
        }
        recyclerView = this.f2971h0;
        i4 = x4 - 3;
        recyclerView.scrollToPosition(i4);
        D1(x4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F1(k kVar) {
        this.f2968e0 = kVar;
        if (kVar == k.YEAR) {
            this.f2970g0.getLayoutManager().x1(((p) this.f2970g0.getAdapter()).w(this.f2967d0.f2999e));
            this.f2972i0.setVisibility(0);
            this.f2973j0.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.f2972i0.setVisibility(8);
            this.f2973j0.setVisibility(0);
            E1(this.f2967d0);
        }
    }

    void G1() {
        k kVar = this.f2968e0;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            F1(k.DAY);
        } else if (kVar == k.DAY) {
            F1(kVar2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Z(Bundle bundle) {
        super.Z(bundle);
        if (bundle == null) {
            bundle = n();
        }
        this.f2964a0 = bundle.getInt("THEME_RES_ID_KEY");
        this.f2965b0 = (com.google.android.material.datepicker.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f2966c0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f2967d0 = (com.google.android.material.datepicker.i) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i4;
        int i5;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(p(), this.f2964a0);
        this.f2969f0 = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        com.google.android.material.datepicker.i k4 = this.f2966c0.k();
        if (com.google.android.material.datepicker.h.s1(contextThemeWrapper)) {
            i4 = m0.h.f5021h;
            i5 = 1;
        } else {
            i4 = m0.h.f5019f;
            i5 = 0;
        }
        View inflate = cloneInContext.inflate(i4, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(m0.f.f4998k);
        y.p.a0(gridView, new b());
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.f());
        gridView.setNumColumns(k4.f3000f);
        gridView.setEnabled(false);
        this.f2971h0 = (RecyclerView) inflate.findViewById(m0.f.f4999l);
        this.f2971h0.setLayoutManager(new c(p(), i5, false, i5));
        this.f2971h0.setTag(f2960k0);
        com.google.android.material.datepicker.k kVar = new com.google.android.material.datepicker.k(contextThemeWrapper, this.f2965b0, this.f2966c0, new d());
        this.f2971h0.setAdapter(kVar);
        int integer = contextThemeWrapper.getResources().getInteger(m0.g.f5013b);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(m0.f.f5000m);
        this.f2970g0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f2970g0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f2970g0.setAdapter(new p(this));
            this.f2970g0.addItemDecoration(w1());
        }
        if (inflate.findViewById(m0.f.f4993f) != null) {
            v1(inflate, kVar);
        }
        if (!com.google.android.material.datepicker.h.s1(contextThemeWrapper)) {
            new androidx.recyclerview.widget.h().b(this.f2971h0);
        }
        this.f2971h0.scrollToPosition(kVar.x(this.f2967d0));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f2964a0);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f2965b0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f2966c0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f2967d0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.a x1() {
        return this.f2966c0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.c y1() {
        return this.f2969f0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.i z1() {
        return this.f2967d0;
    }
}
