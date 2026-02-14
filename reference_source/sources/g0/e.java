package g0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import g0.l;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class e extends androidx.fragment.app.q {

    /* loaded from: classes.dex */
    class a extends l.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f3796a;

        a(Rect rect) {
            this.f3796a = rect;
        }
    }

    /* loaded from: classes.dex */
    class b implements l.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3798a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f3799b;

        b(View view, ArrayList arrayList) {
            this.f3798a = view;
            this.f3799b = arrayList;
        }

        @Override // g0.l.f
        public void a(l lVar) {
        }

        @Override // g0.l.f
        public void b(l lVar) {
        }

        @Override // g0.l.f
        public void c(l lVar) {
            lVar.Q(this);
            this.f3798a.setVisibility(8);
            int size = this.f3799b.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((View) this.f3799b.get(i4)).setVisibility(0);
            }
        }

        @Override // g0.l.f
        public void d(l lVar) {
        }

        @Override // g0.l.f
        public void e(l lVar) {
        }
    }

    /* loaded from: classes.dex */
    class c extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f3801a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f3802b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f3803c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f3804d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f3805e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f3806f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f3801a = obj;
            this.f3802b = arrayList;
            this.f3803c = obj2;
            this.f3804d = arrayList2;
            this.f3805e = obj3;
            this.f3806f = arrayList3;
        }

        @Override // g0.m, g0.l.f
        public void a(l lVar) {
            Object obj = this.f3801a;
            if (obj != null) {
                e.this.q(obj, this.f3802b, null);
            }
            Object obj2 = this.f3803c;
            if (obj2 != null) {
                e.this.q(obj2, this.f3804d, null);
            }
            Object obj3 = this.f3805e;
            if (obj3 != null) {
                e.this.q(obj3, this.f3806f, null);
            }
        }

        @Override // g0.l.f
        public void c(l lVar) {
            lVar.Q(this);
        }
    }

    /* loaded from: classes.dex */
    class d extends l.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f3808a;

        d(Rect rect) {
            this.f3808a = rect;
        }
    }

    private static boolean B(l lVar) {
        return (androidx.fragment.app.q.l(lVar.A()) && androidx.fragment.app.q.l(lVar.B()) && androidx.fragment.app.q.l(lVar.C())) ? false : true;
    }

    @Override // androidx.fragment.app.q
    public Object A(Object obj) {
        if (obj == null) {
            return null;
        }
        p pVar = new p();
        pVar.f0((l) obj);
        return pVar;
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, View view) {
        if (obj != null) {
            ((l) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.q
    public void b(Object obj, ArrayList<View> arrayList) {
        l lVar = (l) obj;
        if (lVar == null) {
            return;
        }
        int i4 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int i02 = pVar.i0();
            while (i4 < i02) {
                b(pVar.h0(i4), arrayList);
                i4++;
            }
            return;
        }
        if (B(lVar) || !androidx.fragment.app.q.l(lVar.D())) {
            return;
        }
        int size = arrayList.size();
        while (i4 < size) {
            lVar.b(arrayList.get(i4));
            i4++;
        }
    }

    @Override // androidx.fragment.app.q
    public void c(ViewGroup viewGroup, Object obj) {
        n.a(viewGroup, (l) obj);
    }

    @Override // androidx.fragment.app.q
    public boolean e(Object obj) {
        return obj instanceof l;
    }

    @Override // androidx.fragment.app.q
    public Object g(Object obj) {
        if (obj != null) {
            return ((l) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.q
    public Object m(Object obj, Object obj2, Object obj3) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        l lVar3 = (l) obj3;
        if (lVar != null && lVar2 != null) {
            lVar = new p().f0(lVar).f0(lVar2).n0(1);
        } else if (lVar == null) {
            lVar = lVar2 != null ? lVar2 : null;
        }
        if (lVar3 == null) {
            return lVar;
        }
        p pVar = new p();
        if (lVar != null) {
            pVar.f0(lVar);
        }
        pVar.f0(lVar3);
        return pVar;
    }

    @Override // androidx.fragment.app.q
    public Object n(Object obj, Object obj2, Object obj3) {
        p pVar = new p();
        if (obj != null) {
            pVar.f0((l) obj);
        }
        if (obj2 != null) {
            pVar.f0((l) obj2);
        }
        if (obj3 != null) {
            pVar.f0((l) obj3);
        }
        return pVar;
    }

    @Override // androidx.fragment.app.q
    public void p(Object obj, View view) {
        if (obj != null) {
            ((l) obj).R(view);
        }
    }

    @Override // androidx.fragment.app.q
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        l lVar = (l) obj;
        int i4 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int i02 = pVar.i0();
            while (i4 < i02) {
                q(pVar.h0(i4), arrayList, arrayList2);
                i4++;
            }
            return;
        }
        if (B(lVar)) {
            return;
        }
        List<View> D = lVar.D();
        if (D.size() == arrayList.size() && D.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i4 < size) {
                lVar.b(arrayList2.get(i4));
                i4++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                lVar.R(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.q
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((l) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.q
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((l) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.q
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((l) obj).W(new d(rect));
        }
    }

    @Override // androidx.fragment.app.q
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((l) obj).W(new a(rect));
        }
    }

    @Override // androidx.fragment.app.q
    public void y(Object obj, View view, ArrayList<View> arrayList) {
        p pVar = (p) obj;
        List<View> D = pVar.D();
        D.clear();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            androidx.fragment.app.q.d(D, arrayList.get(i4));
        }
        D.add(view);
        arrayList.add(view);
        b(pVar, arrayList);
    }

    @Override // androidx.fragment.app.q
    public void z(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        p pVar = (p) obj;
        if (pVar != null) {
            pVar.D().clear();
            pVar.D().addAll(arrayList2);
            q(pVar, arrayList, arrayList2);
        }
    }
}
