package g0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class l implements Cloneable {
    private static final int[] H = {2, 1, 3, 4};
    private static final g I = new a();
    private static ThreadLocal<k.a<Animator, d>> J = new ThreadLocal<>();
    private e E;
    private k.a<String, String> F;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<r> f3853u;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<r> f3854v;

    /* renamed from: b, reason: collision with root package name */
    private String f3834b = getClass().getName();

    /* renamed from: c, reason: collision with root package name */
    private long f3835c = -1;

    /* renamed from: d, reason: collision with root package name */
    long f3836d = -1;

    /* renamed from: e, reason: collision with root package name */
    private TimeInterpolator f3837e = null;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<Integer> f3838f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    ArrayList<View> f3839g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<String> f3840h = null;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<Class<?>> f3841i = null;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<Integer> f3842j = null;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<View> f3843k = null;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<Class<?>> f3844l = null;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<String> f3845m = null;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList<Integer> f3846n = null;

    /* renamed from: o, reason: collision with root package name */
    private ArrayList<View> f3847o = null;

    /* renamed from: p, reason: collision with root package name */
    private ArrayList<Class<?>> f3848p = null;

    /* renamed from: q, reason: collision with root package name */
    private s f3849q = new s();

    /* renamed from: r, reason: collision with root package name */
    private s f3850r = new s();

    /* renamed from: s, reason: collision with root package name */
    p f3851s = null;

    /* renamed from: t, reason: collision with root package name */
    private int[] f3852t = H;

    /* renamed from: w, reason: collision with root package name */
    private ViewGroup f3855w = null;

    /* renamed from: x, reason: collision with root package name */
    boolean f3856x = false;

    /* renamed from: y, reason: collision with root package name */
    ArrayList<Animator> f3857y = new ArrayList<>();

    /* renamed from: z, reason: collision with root package name */
    private int f3858z = 0;
    private boolean A = false;
    private boolean B = false;
    private ArrayList<f> C = null;
    private ArrayList<Animator> D = new ArrayList<>();
    private g G = I;

    /* loaded from: classes.dex */
    static class a extends g {
        a() {
        }

        @Override // g0.g
        public Path a(float f4, float f5, float f6, float f7) {
            Path path = new Path();
            path.moveTo(f4, f5);
            path.lineTo(f6, f7);
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k.a f3859a;

        b(k.a aVar) {
            this.f3859a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3859a.remove(animator);
            l.this.f3857y.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            l.this.f3857y.add(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.q();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        View f3862a;

        /* renamed from: b, reason: collision with root package name */
        String f3863b;

        /* renamed from: c, reason: collision with root package name */
        r f3864c;

        /* renamed from: d, reason: collision with root package name */
        h0 f3865d;

        /* renamed from: e, reason: collision with root package name */
        l f3866e;

        d(View view, String str, l lVar, h0 h0Var, r rVar) {
            this.f3862a = view;
            this.f3863b = str;
            this.f3864c = rVar;
            this.f3865d = h0Var;
            this.f3866e = lVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(l lVar);

        void b(l lVar);

        void c(l lVar);

        void d(l lVar);

        void e(l lVar);
    }

    private static boolean I(r rVar, r rVar2, String str) {
        Object obj = rVar.f3880a.get(str);
        Object obj2 = rVar2.f3880a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void J(k.a<View, r> aVar, k.a<View, r> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            View valueAt = sparseArray.valueAt(i4);
            if (valueAt != null && H(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i4))) != null && H(view)) {
                r rVar = aVar.get(valueAt);
                r rVar2 = aVar2.get(view);
                if (rVar != null && rVar2 != null) {
                    this.f3853u.add(rVar);
                    this.f3854v.add(rVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void K(k.a<View, r> aVar, k.a<View, r> aVar2) {
        r remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View i4 = aVar.i(size);
            if (i4 != null && H(i4) && (remove = aVar2.remove(i4)) != null && H(remove.f3881b)) {
                this.f3853u.add(aVar.k(size));
                this.f3854v.add(remove);
            }
        }
    }

    private void L(k.a<View, r> aVar, k.a<View, r> aVar2, k.d<View> dVar, k.d<View> dVar2) {
        View e4;
        int m4 = dVar.m();
        for (int i4 = 0; i4 < m4; i4++) {
            View n4 = dVar.n(i4);
            if (n4 != null && H(n4) && (e4 = dVar2.e(dVar.h(i4))) != null && H(e4)) {
                r rVar = aVar.get(n4);
                r rVar2 = aVar2.get(e4);
                if (rVar != null && rVar2 != null) {
                    this.f3853u.add(rVar);
                    this.f3854v.add(rVar2);
                    aVar.remove(n4);
                    aVar2.remove(e4);
                }
            }
        }
    }

    private void M(k.a<View, r> aVar, k.a<View, r> aVar2, k.a<String, View> aVar3, k.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i4 = 0; i4 < size; i4++) {
            View m4 = aVar3.m(i4);
            if (m4 != null && H(m4) && (view = aVar4.get(aVar3.i(i4))) != null && H(view)) {
                r rVar = aVar.get(m4);
                r rVar2 = aVar2.get(view);
                if (rVar != null && rVar2 != null) {
                    this.f3853u.add(rVar);
                    this.f3854v.add(rVar2);
                    aVar.remove(m4);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void N(s sVar, s sVar2) {
        k.a<View, r> aVar = new k.a<>(sVar.f3883a);
        k.a<View, r> aVar2 = new k.a<>(sVar2.f3883a);
        int i4 = 0;
        while (true) {
            int[] iArr = this.f3852t;
            if (i4 >= iArr.length) {
                c(aVar, aVar2);
                return;
            }
            int i5 = iArr[i4];
            if (i5 == 1) {
                K(aVar, aVar2);
            } else if (i5 == 2) {
                M(aVar, aVar2, sVar.f3886d, sVar2.f3886d);
            } else if (i5 == 3) {
                J(aVar, aVar2, sVar.f3884b, sVar2.f3884b);
            } else if (i5 == 4) {
                L(aVar, aVar2, sVar.f3885c, sVar2.f3885c);
            }
            i4++;
        }
    }

    private void T(Animator animator, k.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    private void c(k.a<View, r> aVar, k.a<View, r> aVar2) {
        for (int i4 = 0; i4 < aVar.size(); i4++) {
            r m4 = aVar.m(i4);
            if (H(m4.f3881b)) {
                this.f3853u.add(m4);
                this.f3854v.add(null);
            }
        }
        for (int i5 = 0; i5 < aVar2.size(); i5++) {
            r m5 = aVar2.m(i5);
            if (H(m5.f3881b)) {
                this.f3854v.add(m5);
                this.f3853u.add(null);
            }
        }
    }

    private static void d(s sVar, View view, r rVar) {
        sVar.f3883a.put(view, rVar);
        int id = view.getId();
        if (id >= 0) {
            if (sVar.f3884b.indexOfKey(id) >= 0) {
                sVar.f3884b.put(id, null);
            } else {
                sVar.f3884b.put(id, view);
            }
        }
        String z4 = y.p.z(view);
        if (z4 != null) {
            if (sVar.f3886d.containsKey(z4)) {
                sVar.f3886d.put(z4, null);
            } else {
                sVar.f3886d.put(z4, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (sVar.f3885c.g(itemIdAtPosition) < 0) {
                    y.p.i0(view, true);
                    sVar.f3885c.j(itemIdAtPosition, view);
                    return;
                }
                View e4 = sVar.f3885c.e(itemIdAtPosition);
                if (e4 != null) {
                    y.p.i0(e4, false);
                    sVar.f3885c.j(itemIdAtPosition, null);
                }
            }
        }
    }

    private void h(View view, boolean z4) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f3842j;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.f3843k;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.f3844l;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        if (this.f3844l.get(i4).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    r rVar = new r(view);
                    if (z4) {
                        k(rVar);
                    } else {
                        g(rVar);
                    }
                    rVar.f3882c.add(this);
                    j(rVar);
                    d(z4 ? this.f3849q : this.f3850r, view, rVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f3846n;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.f3847o;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.f3848p;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i5 = 0; i5 < size2; i5++) {
                                    if (this.f3848p.get(i5).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                                h(viewGroup.getChildAt(i6), z4);
                            }
                        }
                    }
                }
            }
        }
    }

    private static k.a<Animator, d> y() {
        k.a<Animator, d> aVar = J.get();
        if (aVar != null) {
            return aVar;
        }
        k.a<Animator, d> aVar2 = new k.a<>();
        J.set(aVar2);
        return aVar2;
    }

    public List<Integer> A() {
        return this.f3838f;
    }

    public List<String> B() {
        return this.f3840h;
    }

    public List<Class<?>> C() {
        return this.f3841i;
    }

    public List<View> D() {
        return this.f3839g;
    }

    public String[] E() {
        return null;
    }

    public r F(View view, boolean z4) {
        p pVar = this.f3851s;
        if (pVar != null) {
            return pVar.F(view, z4);
        }
        return (z4 ? this.f3849q : this.f3850r).f3883a.get(view);
    }

    public boolean G(r rVar, r rVar2) {
        if (rVar == null || rVar2 == null) {
            return false;
        }
        String[] E = E();
        if (E == null) {
            Iterator<String> it = rVar.f3880a.keySet().iterator();
            while (it.hasNext()) {
                if (I(rVar, rVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : E) {
            if (!I(rVar, rVar2, str)) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f3842j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f3843k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f3844l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (this.f3844l.get(i4).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f3845m != null && y.p.z(view) != null && this.f3845m.contains(y.p.z(view))) {
            return false;
        }
        if ((this.f3838f.size() == 0 && this.f3839g.size() == 0 && (((arrayList = this.f3841i) == null || arrayList.isEmpty()) && ((arrayList2 = this.f3840h) == null || arrayList2.isEmpty()))) || this.f3838f.contains(Integer.valueOf(id)) || this.f3839g.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f3840h;
        if (arrayList6 != null && arrayList6.contains(y.p.z(view))) {
            return true;
        }
        if (this.f3841i != null) {
            for (int i5 = 0; i5 < this.f3841i.size(); i5++) {
                if (this.f3841i.get(i5).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void O(View view) {
        if (this.B) {
            return;
        }
        k.a<Animator, d> y4 = y();
        int size = y4.size();
        h0 d5 = y.d(view);
        for (int i4 = size - 1; i4 >= 0; i4--) {
            d m4 = y4.m(i4);
            if (m4.f3862a != null && d5.equals(m4.f3865d)) {
                g0.a.b(y4.i(i4));
            }
        }
        ArrayList<f> arrayList = this.C;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.C.clone();
            int size2 = arrayList2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ((f) arrayList2.get(i5)).d(this);
            }
        }
        this.A = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(ViewGroup viewGroup) {
        d dVar;
        this.f3853u = new ArrayList<>();
        this.f3854v = new ArrayList<>();
        N(this.f3849q, this.f3850r);
        k.a<Animator, d> y4 = y();
        int size = y4.size();
        h0 d5 = y.d(viewGroup);
        for (int i4 = size - 1; i4 >= 0; i4--) {
            Animator i5 = y4.i(i4);
            if (i5 != null && (dVar = y4.get(i5)) != null && dVar.f3862a != null && d5.equals(dVar.f3865d)) {
                r rVar = dVar.f3864c;
                View view = dVar.f3862a;
                r F = F(view, true);
                r u4 = u(view, true);
                if (F == null && u4 == null) {
                    u4 = this.f3850r.f3883a.get(view);
                }
                if (!(F == null && u4 == null) && dVar.f3866e.G(rVar, u4)) {
                    if (i5.isRunning() || i5.isStarted()) {
                        i5.cancel();
                    } else {
                        y4.remove(i5);
                    }
                }
            }
        }
        p(viewGroup, this.f3849q, this.f3850r, this.f3853u, this.f3854v);
        U();
    }

    public l Q(f fVar) {
        ArrayList<f> arrayList = this.C;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.C.size() == 0) {
            this.C = null;
        }
        return this;
    }

    public l R(View view) {
        this.f3839g.remove(view);
        return this;
    }

    public void S(View view) {
        if (this.A) {
            if (!this.B) {
                k.a<Animator, d> y4 = y();
                int size = y4.size();
                h0 d5 = y.d(view);
                for (int i4 = size - 1; i4 >= 0; i4--) {
                    d m4 = y4.m(i4);
                    if (m4.f3862a != null && d5.equals(m4.f3865d)) {
                        g0.a.c(y4.i(i4));
                    }
                }
                ArrayList<f> arrayList = this.C;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.C.clone();
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        ((f) arrayList2.get(i5)).e(this);
                    }
                }
            }
            this.A = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        b0();
        k.a<Animator, d> y4 = y();
        Iterator<Animator> it = this.D.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (y4.containsKey(next)) {
                b0();
                T(next, y4);
            }
        }
        this.D.clear();
        q();
    }

    public l V(long j4) {
        this.f3836d = j4;
        return this;
    }

    public void W(e eVar) {
        this.E = eVar;
    }

    public l X(TimeInterpolator timeInterpolator) {
        this.f3837e = timeInterpolator;
        return this;
    }

    public void Y(g gVar) {
        if (gVar == null) {
            gVar = I;
        }
        this.G = gVar;
    }

    public void Z(o oVar) {
    }

    public l a(f fVar) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(fVar);
        return this;
    }

    public l a0(long j4) {
        this.f3835c = j4;
        return this;
    }

    public l b(View view) {
        this.f3839g.add(view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b0() {
        if (this.f3858z == 0) {
            ArrayList<f> arrayList = this.C;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.C.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((f) arrayList2.get(i4)).a(this);
                }
            }
            this.B = false;
        }
        this.f3858z++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f3836d != -1) {
            str2 = str2 + "dur(" + this.f3836d + ") ";
        }
        if (this.f3835c != -1) {
            str2 = str2 + "dly(" + this.f3835c + ") ";
        }
        if (this.f3837e != null) {
            str2 = str2 + "interp(" + this.f3837e + ") ";
        }
        if (this.f3838f.size() <= 0 && this.f3839g.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f3838f.size() > 0) {
            for (int i4 = 0; i4 < this.f3838f.size(); i4++) {
                if (i4 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f3838f.get(i4);
            }
        }
        if (this.f3839g.size() > 0) {
            for (int i5 = 0; i5 < this.f3839g.size(); i5++) {
                if (i5 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f3839g.get(i5);
            }
        }
        return str3 + ")";
    }

    protected void e(Animator animator) {
        if (animator == null) {
            q();
            return;
        }
        if (r() >= 0) {
            animator.setDuration(r());
        }
        if (z() >= 0) {
            animator.setStartDelay(z() + animator.getStartDelay());
        }
        if (t() != null) {
            animator.setInterpolator(t());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        for (int size = this.f3857y.size() - 1; size >= 0; size--) {
            this.f3857y.get(size).cancel();
        }
        ArrayList<f> arrayList = this.C;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.C.clone();
        int size2 = arrayList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((f) arrayList2.get(i4)).b(this);
        }
    }

    public abstract void g(r rVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(r rVar) {
    }

    public abstract void k(r rVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(ViewGroup viewGroup, boolean z4) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        k.a<String, String> aVar;
        m(z4);
        if ((this.f3838f.size() > 0 || this.f3839g.size() > 0) && (((arrayList = this.f3840h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f3841i) == null || arrayList2.isEmpty()))) {
            for (int i4 = 0; i4 < this.f3838f.size(); i4++) {
                View findViewById = viewGroup.findViewById(this.f3838f.get(i4).intValue());
                if (findViewById != null) {
                    r rVar = new r(findViewById);
                    if (z4) {
                        k(rVar);
                    } else {
                        g(rVar);
                    }
                    rVar.f3882c.add(this);
                    j(rVar);
                    d(z4 ? this.f3849q : this.f3850r, findViewById, rVar);
                }
            }
            for (int i5 = 0; i5 < this.f3839g.size(); i5++) {
                View view = this.f3839g.get(i5);
                r rVar2 = new r(view);
                if (z4) {
                    k(rVar2);
                } else {
                    g(rVar2);
                }
                rVar2.f3882c.add(this);
                j(rVar2);
                d(z4 ? this.f3849q : this.f3850r, view, rVar2);
            }
        } else {
            h(viewGroup, z4);
        }
        if (z4 || (aVar = this.F) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i6 = 0; i6 < size; i6++) {
            arrayList3.add(this.f3849q.f3886d.remove(this.F.i(i6)));
        }
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = (View) arrayList3.get(i7);
            if (view2 != null) {
                this.f3849q.f3886d.put(this.F.m(i7), view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z4) {
        s sVar;
        if (z4) {
            this.f3849q.f3883a.clear();
            this.f3849q.f3884b.clear();
            sVar = this.f3849q;
        } else {
            this.f3850r.f3883a.clear();
            this.f3850r.f3884b.clear();
            sVar = this.f3850r;
        }
        sVar.f3885c.a();
    }

    @Override // 
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public l clone() {
        try {
            l lVar = (l) super.clone();
            lVar.D = new ArrayList<>();
            lVar.f3849q = new s();
            lVar.f3850r = new s();
            lVar.f3853u = null;
            lVar.f3854v = null;
            return lVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator o(ViewGroup viewGroup, r rVar, r rVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(ViewGroup viewGroup, s sVar, s sVar2, ArrayList<r> arrayList, ArrayList<r> arrayList2) {
        int i4;
        View view;
        Animator animator;
        r rVar;
        Animator animator2;
        r rVar2;
        k.a<Animator, d> y4 = y();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            r rVar3 = arrayList.get(i5);
            r rVar4 = arrayList2.get(i5);
            if (rVar3 != null && !rVar3.f3882c.contains(this)) {
                rVar3 = null;
            }
            if (rVar4 != null && !rVar4.f3882c.contains(this)) {
                rVar4 = null;
            }
            if (rVar3 != null || rVar4 != null) {
                if (rVar3 == null || rVar4 == null || G(rVar3, rVar4)) {
                    Animator o4 = o(viewGroup, rVar3, rVar4);
                    if (o4 != null) {
                        if (rVar4 != null) {
                            View view2 = rVar4.f3881b;
                            String[] E = E();
                            if (E != null && E.length > 0) {
                                rVar2 = new r(view2);
                                r rVar5 = sVar2.f3883a.get(view2);
                                if (rVar5 != null) {
                                    int i6 = 0;
                                    while (i6 < E.length) {
                                        rVar2.f3880a.put(E[i6], rVar5.f3880a.get(E[i6]));
                                        i6++;
                                        o4 = o4;
                                        size = size;
                                        rVar5 = rVar5;
                                    }
                                }
                                Animator animator3 = o4;
                                i4 = size;
                                int size2 = y4.size();
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= size2) {
                                        animator2 = animator3;
                                        break;
                                    }
                                    d dVar = y4.get(y4.i(i7));
                                    if (dVar.f3864c != null && dVar.f3862a == view2 && dVar.f3863b.equals(v()) && dVar.f3864c.equals(rVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i7++;
                                }
                            } else {
                                i4 = size;
                                animator2 = o4;
                                rVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            rVar = rVar2;
                        } else {
                            i4 = size;
                            view = rVar3.f3881b;
                            animator = o4;
                            rVar = null;
                        }
                        if (animator != null) {
                            y4.put(animator, new d(view, v(), this, y.d(viewGroup), rVar));
                            this.D.add(animator);
                        }
                        i5++;
                        size = i4;
                    }
                    i4 = size;
                    i5++;
                    size = i4;
                }
            }
            i4 = size;
            i5++;
            size = i4;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                Animator animator4 = this.D.get(sparseIntArray.keyAt(i8));
                animator4.setStartDelay((sparseIntArray.valueAt(i8) - Long.MAX_VALUE) + animator4.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        int i4 = this.f3858z - 1;
        this.f3858z = i4;
        if (i4 == 0) {
            ArrayList<f> arrayList = this.C;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.C.clone();
                int size = arrayList2.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((f) arrayList2.get(i5)).c(this);
                }
            }
            for (int i6 = 0; i6 < this.f3849q.f3885c.m(); i6++) {
                View n4 = this.f3849q.f3885c.n(i6);
                if (n4 != null) {
                    y.p.i0(n4, false);
                }
            }
            for (int i7 = 0; i7 < this.f3850r.f3885c.m(); i7++) {
                View n5 = this.f3850r.f3885c.n(i7);
                if (n5 != null) {
                    y.p.i0(n5, false);
                }
            }
            this.B = true;
        }
    }

    public long r() {
        return this.f3836d;
    }

    public e s() {
        return this.E;
    }

    public TimeInterpolator t() {
        return this.f3837e;
    }

    public String toString() {
        return c0("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r u(View view, boolean z4) {
        p pVar = this.f3851s;
        if (pVar != null) {
            return pVar.u(view, z4);
        }
        ArrayList<r> arrayList = z4 ? this.f3853u : this.f3854v;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i4 = -1;
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                break;
            }
            r rVar = arrayList.get(i5);
            if (rVar == null) {
                return null;
            }
            if (rVar.f3881b == view) {
                i4 = i5;
                break;
            }
            i5++;
        }
        if (i4 >= 0) {
            return (z4 ? this.f3854v : this.f3853u).get(i4);
        }
        return null;
    }

    public String v() {
        return this.f3834b;
    }

    public g w() {
        return this.G;
    }

    public o x() {
        return null;
    }

    public long z() {
        return this.f3835c;
    }
}
