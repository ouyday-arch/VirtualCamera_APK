package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c extends m {

    /* renamed from: s, reason: collision with root package name */
    private static TimeInterpolator f1958s;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f1959h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f1960i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<j> f1961j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<i> f1962k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.d0>> f1963l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    ArrayList<ArrayList<j>> f1964m = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    ArrayList<ArrayList<i>> f1965n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f1966o = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f1967p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f1968q = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f1969r = new ArrayList<>();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1970b;

        a(ArrayList arrayList) {
            this.f1970b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1970b.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.S(jVar.f2004a, jVar.f2005b, jVar.f2006c, jVar.f2007d, jVar.f2008e);
            }
            this.f1970b.clear();
            c.this.f1964m.remove(this.f1970b);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1972b;

        b(ArrayList arrayList) {
            this.f1972b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1972b.iterator();
            while (it.hasNext()) {
                c.this.R((i) it.next());
            }
            this.f1972b.clear();
            c.this.f1965n.remove(this.f1972b);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0017c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1974b;

        RunnableC0017c(ArrayList arrayList) {
            this.f1974b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1974b.iterator();
            while (it.hasNext()) {
                c.this.Q((RecyclerView.d0) it.next());
            }
            this.f1974b.clear();
            c.this.f1963l.remove(this.f1974b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1976a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1977b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1978c;

        d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1976a = d0Var;
            this.f1977b = viewPropertyAnimator;
            this.f1978c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1977b.setListener(null);
            this.f1978c.setAlpha(1.0f);
            c.this.G(this.f1976a);
            c.this.f1968q.remove(this.f1976a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.H(this.f1976a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1980a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1981b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1982c;

        e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1980a = d0Var;
            this.f1981b = view;
            this.f1982c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1981b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1982c.setListener(null);
            c.this.A(this.f1980a);
            c.this.f1966o.remove(this.f1980a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.B(this.f1980a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1984a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1985b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1986c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1987d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1988e;

        f(RecyclerView.d0 d0Var, int i4, View view, int i5, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1984a = d0Var;
            this.f1985b = i4;
            this.f1986c = view;
            this.f1987d = i5;
            this.f1988e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1985b != 0) {
                this.f1986c.setTranslationX(0.0f);
            }
            if (this.f1987d != 0) {
                this.f1986c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1988e.setListener(null);
            c.this.E(this.f1984a);
            c.this.f1967p.remove(this.f1984a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.F(this.f1984a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f1990a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1991b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1992c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1990a = iVar;
            this.f1991b = viewPropertyAnimator;
            this.f1992c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1991b.setListener(null);
            this.f1992c.setAlpha(1.0f);
            this.f1992c.setTranslationX(0.0f);
            this.f1992c.setTranslationY(0.0f);
            c.this.C(this.f1990a.f1998a, true);
            c.this.f1969r.remove(this.f1990a.f1998a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f1990a.f1998a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f1994a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1995b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1996c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1994a = iVar;
            this.f1995b = viewPropertyAnimator;
            this.f1996c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1995b.setListener(null);
            this.f1996c.setAlpha(1.0f);
            this.f1996c.setTranslationX(0.0f);
            this.f1996c.setTranslationY(0.0f);
            c.this.C(this.f1994a.f1999b, false);
            c.this.f1969r.remove(this.f1994a.f1999b);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f1994a.f1999b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f1998a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.d0 f1999b;

        /* renamed from: c, reason: collision with root package name */
        public int f2000c;

        /* renamed from: d, reason: collision with root package name */
        public int f2001d;

        /* renamed from: e, reason: collision with root package name */
        public int f2002e;

        /* renamed from: f, reason: collision with root package name */
        public int f2003f;

        private i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f1998a = d0Var;
            this.f1999b = d0Var2;
        }

        i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i4, int i5, int i6, int i7) {
            this(d0Var, d0Var2);
            this.f2000c = i4;
            this.f2001d = i5;
            this.f2002e = i6;
            this.f2003f = i7;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1998a + ", newHolder=" + this.f1999b + ", fromX=" + this.f2000c + ", fromY=" + this.f2001d + ", toX=" + this.f2002e + ", toY=" + this.f2003f + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f2004a;

        /* renamed from: b, reason: collision with root package name */
        public int f2005b;

        /* renamed from: c, reason: collision with root package name */
        public int f2006c;

        /* renamed from: d, reason: collision with root package name */
        public int f2007d;

        /* renamed from: e, reason: collision with root package name */
        public int f2008e;

        j(RecyclerView.d0 d0Var, int i4, int i5, int i6, int i7) {
            this.f2004a = d0Var;
            this.f2005b = i4;
            this.f2006c = i5;
            this.f2007d = i6;
            this.f2008e = i7;
        }
    }

    private void T(RecyclerView.d0 d0Var) {
        View view = d0Var.f1809a;
        ViewPropertyAnimator animate = view.animate();
        this.f1968q.add(d0Var);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(d0Var, animate, view)).start();
    }

    private void W(List<i> list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (Y(iVar, d0Var) && iVar.f1998a == null && iVar.f1999b == null) {
                list.remove(iVar);
            }
        }
    }

    private void X(i iVar) {
        RecyclerView.d0 d0Var = iVar.f1998a;
        if (d0Var != null) {
            Y(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f1999b;
        if (d0Var2 != null) {
            Y(iVar, d0Var2);
        }
    }

    private boolean Y(i iVar, RecyclerView.d0 d0Var) {
        boolean z4 = false;
        if (iVar.f1999b == d0Var) {
            iVar.f1999b = null;
        } else {
            if (iVar.f1998a != d0Var) {
                return false;
            }
            iVar.f1998a = null;
            z4 = true;
        }
        d0Var.f1809a.setAlpha(1.0f);
        d0Var.f1809a.setTranslationX(0.0f);
        d0Var.f1809a.setTranslationY(0.0f);
        C(d0Var, z4);
        return true;
    }

    private void Z(RecyclerView.d0 d0Var) {
        if (f1958s == null) {
            f1958s = new ValueAnimator().getInterpolator();
        }
        d0Var.f1809a.animate().setInterpolator(f1958s);
        j(d0Var);
    }

    void Q(RecyclerView.d0 d0Var) {
        View view = d0Var.f1809a;
        ViewPropertyAnimator animate = view.animate();
        this.f1966o.add(d0Var);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(d0Var, view, animate)).start();
    }

    void R(i iVar) {
        RecyclerView.d0 d0Var = iVar.f1998a;
        View view = d0Var == null ? null : d0Var.f1809a;
        RecyclerView.d0 d0Var2 = iVar.f1999b;
        View view2 = d0Var2 != null ? d0Var2.f1809a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f1969r.add(iVar.f1998a);
            duration.translationX(iVar.f2002e - iVar.f2000c);
            duration.translationY(iVar.f2003f - iVar.f2001d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f1969r.add(iVar.f1999b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    void S(RecyclerView.d0 d0Var, int i4, int i5, int i6, int i7) {
        View view = d0Var.f1809a;
        int i8 = i6 - i4;
        int i9 = i7 - i5;
        if (i8 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i9 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f1967p.add(d0Var);
        animate.setDuration(n()).setListener(new f(d0Var, i8, view, i9, animate)).start();
    }

    void U(List<RecyclerView.d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f1809a.animate().cancel();
        }
    }

    void V() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.d0 d0Var, List<Object> list) {
        return !list.isEmpty() || super.g(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.d0 d0Var) {
        View view = d0Var.f1809a;
        view.animate().cancel();
        int size = this.f1961j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f1961j.get(size).f2004a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(d0Var);
                this.f1961j.remove(size);
            }
        }
        W(this.f1962k, d0Var);
        if (this.f1959h.remove(d0Var)) {
            view.setAlpha(1.0f);
            G(d0Var);
        }
        if (this.f1960i.remove(d0Var)) {
            view.setAlpha(1.0f);
            A(d0Var);
        }
        for (int size2 = this.f1965n.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.f1965n.get(size2);
            W(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.f1965n.remove(size2);
            }
        }
        for (int size3 = this.f1964m.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.f1964m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f2004a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f1964m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f1963l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.d0> arrayList3 = this.f1963l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                A(d0Var);
                if (arrayList3.isEmpty()) {
                    this.f1963l.remove(size5);
                }
            }
        }
        this.f1968q.remove(d0Var);
        this.f1966o.remove(d0Var);
        this.f1969r.remove(d0Var);
        this.f1967p.remove(d0Var);
        V();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f1961j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f1961j.get(size);
            View view = jVar.f2004a.f1809a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.f2004a);
            this.f1961j.remove(size);
        }
        for (int size2 = this.f1959h.size() - 1; size2 >= 0; size2--) {
            G(this.f1959h.get(size2));
            this.f1959h.remove(size2);
        }
        int size3 = this.f1960i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.f1960i.get(size3);
            d0Var.f1809a.setAlpha(1.0f);
            A(d0Var);
            this.f1960i.remove(size3);
        }
        for (int size4 = this.f1962k.size() - 1; size4 >= 0; size4--) {
            X(this.f1962k.get(size4));
        }
        this.f1962k.clear();
        if (p()) {
            for (int size5 = this.f1964m.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.f1964m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f2004a.f1809a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.f2004a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1964m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1963l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.d0> arrayList2 = this.f1963l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = arrayList2.get(size8);
                    d0Var2.f1809a.setAlpha(1.0f);
                    A(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1963l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f1965n.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.f1965n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f1965n.remove(arrayList3);
                    }
                }
            }
            U(this.f1968q);
            U(this.f1967p);
            U(this.f1966o);
            U(this.f1969r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f1960i.isEmpty() && this.f1962k.isEmpty() && this.f1961j.isEmpty() && this.f1959h.isEmpty() && this.f1967p.isEmpty() && this.f1968q.isEmpty() && this.f1966o.isEmpty() && this.f1969r.isEmpty() && this.f1964m.isEmpty() && this.f1963l.isEmpty() && this.f1965n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void u() {
        boolean z4 = !this.f1959h.isEmpty();
        boolean z5 = !this.f1961j.isEmpty();
        boolean z6 = !this.f1962k.isEmpty();
        boolean z7 = !this.f1960i.isEmpty();
        if (z4 || z5 || z7 || z6) {
            Iterator<RecyclerView.d0> it = this.f1959h.iterator();
            while (it.hasNext()) {
                T(it.next());
            }
            this.f1959h.clear();
            if (z5) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f1961j);
                this.f1964m.add(arrayList);
                this.f1961j.clear();
                a aVar = new a(arrayList);
                if (z4) {
                    y.p.U(arrayList.get(0).f2004a.f1809a, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z6) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f1962k);
                this.f1965n.add(arrayList2);
                this.f1962k.clear();
                b bVar = new b(arrayList2);
                if (z4) {
                    y.p.U(arrayList2.get(0).f1998a.f1809a, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z7) {
                ArrayList<RecyclerView.d0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f1960i);
                this.f1963l.add(arrayList3);
                this.f1960i.clear();
                RunnableC0017c runnableC0017c = new RunnableC0017c(arrayList3);
                if (z4 || z5 || z6) {
                    y.p.U(arrayList3.get(0).f1809a, runnableC0017c, (z4 ? o() : 0L) + Math.max(z5 ? n() : 0L, z6 ? m() : 0L));
                } else {
                    runnableC0017c.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.m
    public boolean w(RecyclerView.d0 d0Var) {
        Z(d0Var);
        d0Var.f1809a.setAlpha(0.0f);
        this.f1960i.add(d0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean x(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i4, int i5, int i6, int i7) {
        if (d0Var == d0Var2) {
            return y(d0Var, i4, i5, i6, i7);
        }
        float translationX = d0Var.f1809a.getTranslationX();
        float translationY = d0Var.f1809a.getTranslationY();
        float alpha = d0Var.f1809a.getAlpha();
        Z(d0Var);
        int i8 = (int) ((i6 - i4) - translationX);
        int i9 = (int) ((i7 - i5) - translationY);
        d0Var.f1809a.setTranslationX(translationX);
        d0Var.f1809a.setTranslationY(translationY);
        d0Var.f1809a.setAlpha(alpha);
        if (d0Var2 != null) {
            Z(d0Var2);
            d0Var2.f1809a.setTranslationX(-i8);
            d0Var2.f1809a.setTranslationY(-i9);
            d0Var2.f1809a.setAlpha(0.0f);
        }
        this.f1962k.add(new i(d0Var, d0Var2, i4, i5, i6, i7));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean y(RecyclerView.d0 d0Var, int i4, int i5, int i6, int i7) {
        View view = d0Var.f1809a;
        int translationX = i4 + ((int) view.getTranslationX());
        int translationY = i5 + ((int) d0Var.f1809a.getTranslationY());
        Z(d0Var);
        int i8 = i6 - translationX;
        int i9 = i7 - translationY;
        if (i8 == 0 && i9 == 0) {
            E(d0Var);
            return false;
        }
        if (i8 != 0) {
            view.setTranslationX(-i8);
        }
        if (i9 != 0) {
            view.setTranslationY(-i9);
        }
        this.f1961j.add(new j(d0Var, translationX, translationY, i6, i7));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean z(RecyclerView.d0 d0Var) {
        Z(d0Var);
        this.f1959h.add(d0Var);
        return true;
    }
}
