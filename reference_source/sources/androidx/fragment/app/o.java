package androidx.fragment.app;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f1610a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b, reason: collision with root package name */
    private static final q f1611b = new p();

    /* renamed from: c, reason: collision with root package name */
    private static final q f1612c = w();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1613b;

        a(ArrayList arrayList) {
            this.f1613b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.A(this.f1613b, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f1614b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ q f1615c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f1616d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Fragment f1617e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1618f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f1619g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList f1620h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Object f1621i;

        b(Object obj, q qVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f1614b = obj;
            this.f1615c = qVar;
            this.f1616d = view;
            this.f1617e = fragment;
            this.f1618f = arrayList;
            this.f1619g = arrayList2;
            this.f1620h = arrayList3;
            this.f1621i = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f1614b;
            if (obj != null) {
                this.f1615c.p(obj, this.f1616d);
                this.f1619g.addAll(o.k(this.f1615c, this.f1614b, this.f1617e, this.f1618f, this.f1616d));
            }
            if (this.f1620h != null) {
                if (this.f1621i != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f1616d);
                    this.f1615c.q(this.f1621i, this.f1620h, arrayList);
                }
                this.f1620h.clear();
                this.f1620h.add(this.f1616d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f1622b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f1623c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f1624d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k.a f1625e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f1626f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ q f1627g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Rect f1628h;

        c(Fragment fragment, Fragment fragment2, boolean z4, k.a aVar, View view, q qVar, Rect rect) {
            this.f1622b = fragment;
            this.f1623c = fragment2;
            this.f1624d = z4;
            this.f1625e = aVar;
            this.f1626f = view;
            this.f1627g = qVar;
            this.f1628h = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.f(this.f1622b, this.f1623c, this.f1624d, this.f1625e, false);
            View view = this.f1626f;
            if (view != null) {
                this.f1627g.k(view, this.f1628h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f1629b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k.a f1630c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f1631d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f1632e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1633f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f1634g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Fragment f1635h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Fragment f1636i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f1637j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ ArrayList f1638k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Object f1639l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Rect f1640m;

        d(q qVar, k.a aVar, Object obj, e eVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z4, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f1629b = qVar;
            this.f1630c = aVar;
            this.f1631d = obj;
            this.f1632e = eVar;
            this.f1633f = arrayList;
            this.f1634g = view;
            this.f1635h = fragment;
            this.f1636i = fragment2;
            this.f1637j = z4;
            this.f1638k = arrayList2;
            this.f1639l = obj2;
            this.f1640m = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.a<String, View> h4 = o.h(this.f1629b, this.f1630c, this.f1631d, this.f1632e);
            if (h4 != null) {
                this.f1633f.addAll(h4.values());
                this.f1633f.add(this.f1634g);
            }
            o.f(this.f1635h, this.f1636i, this.f1637j, h4, false);
            Object obj = this.f1631d;
            if (obj != null) {
                this.f1629b.z(obj, this.f1638k, this.f1633f);
                View s4 = o.s(h4, this.f1632e, this.f1639l, this.f1637j);
                if (s4 != null) {
                    this.f1629b.k(s4, this.f1640m);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public Fragment f1641a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1642b;

        /* renamed from: c, reason: collision with root package name */
        public androidx.fragment.app.a f1643c;

        /* renamed from: d, reason: collision with root package name */
        public Fragment f1644d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1645e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.fragment.app.a f1646f;

        e() {
        }
    }

    static void A(ArrayList<View> arrayList, int i4) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void B(j jVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i4, int i5, boolean z4) {
        if (jVar.f1517q < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i6 = i4; i6 < i5; i6++) {
            androidx.fragment.app.a aVar = arrayList.get(i6);
            if (arrayList2.get(i6).booleanValue()) {
                e(aVar, sparseArray, z4);
            } else {
                c(aVar, sparseArray, z4);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(jVar.f1518r.i());
            int size = sparseArray.size();
            for (int i7 = 0; i7 < size; i7++) {
                int keyAt = sparseArray.keyAt(i7);
                k.a<String, String> d5 = d(keyAt, arrayList, arrayList2, i4, i5);
                e eVar = (e) sparseArray.valueAt(i7);
                if (z4) {
                    o(jVar, keyAt, eVar, view, d5);
                } else {
                    n(jVar, keyAt, eVar, view, d5);
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, k.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View m4 = aVar.m(size);
            if (collection.contains(y.p.z(m4))) {
                arrayList.add(m4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0041, code lost:
    
        if (r10.f1419l != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0092, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0076, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0090, code lost:
    
        if (r10.f1433z == false) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b(androidx.fragment.app.a r16, androidx.fragment.app.n.a r17, android.util.SparseArray<androidx.fragment.app.o.e> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.b(androidx.fragment.app.a, androidx.fragment.app.n$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<e> sparseArray, boolean z4) {
        int size = aVar.f1584a.size();
        for (int i4 = 0; i4 < size; i4++) {
            b(aVar, aVar.f1584a.get(i4), sparseArray, false, z4);
        }
    }

    private static k.a<String, String> d(int i4, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i5, int i6) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        k.a<String, String> aVar = new k.a<>();
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i7);
            if (aVar2.q(i4)) {
                boolean booleanValue = arrayList2.get(i7).booleanValue();
                ArrayList<String> arrayList5 = aVar2.f1598o;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f1598o;
                        arrayList4 = aVar2.f1599p;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.f1598o;
                        arrayList3 = aVar2.f1599p;
                        arrayList4 = arrayList6;
                    }
                    for (int i8 = 0; i8 < size; i8++) {
                        String str = arrayList4.get(i8);
                        String str2 = arrayList3.get(i8);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<e> sparseArray, boolean z4) {
        if (aVar.f1455s.f1519s.f()) {
            for (int size = aVar.f1584a.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f1584a.get(size), sparseArray, true, z4);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z4, k.a<String, View> aVar, boolean z5) {
        if (z4) {
            fragment2.r();
        } else {
            fragment.r();
        }
    }

    private static boolean g(q qVar, List<Object> list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!qVar.e(list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    static k.a<String, View> h(q qVar, k.a<String, String> aVar, Object obj, e eVar) {
        ArrayList<String> arrayList;
        Fragment fragment = eVar.f1641a;
        View K = fragment.K();
        if (aVar.isEmpty() || obj == null || K == null) {
            aVar.clear();
            return null;
        }
        k.a<String, View> aVar2 = new k.a<>();
        qVar.j(aVar2, K);
        androidx.fragment.app.a aVar3 = eVar.f1643c;
        if (eVar.f1642b) {
            fragment.t();
            arrayList = aVar3.f1598o;
        } else {
            fragment.r();
            arrayList = aVar3.f1599p;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
            aVar2.o(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    private static k.a<String, View> i(q qVar, k.a<String, String> aVar, Object obj, e eVar) {
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = eVar.f1644d;
        k.a<String, View> aVar2 = new k.a<>();
        qVar.j(aVar2, fragment.b1());
        androidx.fragment.app.a aVar3 = eVar.f1646f;
        if (eVar.f1645e) {
            fragment.r();
            arrayList = aVar3.f1599p;
        } else {
            fragment.t();
            arrayList = aVar3.f1598o;
        }
        aVar2.o(arrayList);
        aVar.o(aVar2.keySet());
        return aVar2;
    }

    private static q j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object s4 = fragment.s();
            if (s4 != null) {
                arrayList.add(s4);
            }
            Object E = fragment.E();
            if (E != null) {
                arrayList.add(E);
            }
            Object G = fragment.G();
            if (G != null) {
                arrayList.add(G);
            }
        }
        if (fragment2 != null) {
            Object q4 = fragment2.q();
            if (q4 != null) {
                arrayList.add(q4);
            }
            Object B = fragment2.B();
            if (B != null) {
                arrayList.add(B);
            }
            Object F = fragment2.F();
            if (F != null) {
                arrayList.add(F);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        q qVar = f1611b;
        if (qVar != null && g(qVar, arrayList)) {
            return qVar;
        }
        q qVar2 = f1612c;
        if (qVar2 != null && g(qVar2, arrayList)) {
            return qVar2;
        }
        if (qVar == null && qVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(q qVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View K = fragment.K();
        if (K != null) {
            qVar.f(arrayList2, K);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        qVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(q qVar, ViewGroup viewGroup, View view, k.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object t4;
        k.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = eVar.f1641a;
        Fragment fragment2 = eVar.f1644d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z4 = eVar.f1642b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            t4 = null;
        } else {
            t4 = t(qVar, fragment, fragment2, z4);
            aVar2 = aVar;
        }
        k.a<String, View> i4 = i(qVar, aVar2, t4, eVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(i4.values());
            obj3 = t4;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z4, i4, true);
        if (obj3 != null) {
            rect = new Rect();
            qVar.y(obj3, view, arrayList);
            z(qVar, obj3, obj2, i4, eVar.f1645e, eVar.f1646f);
            if (obj != null) {
                qVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        y.o.a(viewGroup, new d(qVar, aVar, obj3, eVar, arrayList2, view, fragment, fragment2, z4, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(q qVar, ViewGroup viewGroup, View view, k.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = eVar.f1641a;
        Fragment fragment2 = eVar.f1644d;
        if (fragment != null) {
            fragment.b1().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z4 = eVar.f1642b;
        Object t4 = aVar.isEmpty() ? null : t(qVar, fragment, fragment2, z4);
        k.a<String, View> i4 = i(qVar, aVar, t4, eVar);
        k.a<String, View> h4 = h(qVar, aVar, t4, eVar);
        if (aVar.isEmpty()) {
            if (i4 != null) {
                i4.clear();
            }
            if (h4 != null) {
                h4.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, i4, aVar.keySet());
            a(arrayList2, h4, aVar.values());
            obj3 = t4;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z4, i4, true);
        if (obj3 != null) {
            arrayList2.add(view);
            qVar.y(obj3, view, arrayList);
            z(qVar, obj3, obj2, i4, eVar.f1645e, eVar.f1646f);
            Rect rect2 = new Rect();
            View s4 = s(h4, eVar, obj, z4);
            if (s4 != null) {
                qVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = s4;
        } else {
            view2 = null;
            rect = null;
        }
        y.o.a(viewGroup, new c(fragment, fragment2, z4, h4, view2, qVar, rect));
        return obj3;
    }

    private static void n(j jVar, int i4, e eVar, View view, k.a<String, String> aVar) {
        Fragment fragment;
        Fragment fragment2;
        q j4;
        Object obj;
        ViewGroup viewGroup = jVar.f1519s.f() ? (ViewGroup) jVar.f1519s.e(i4) : null;
        if (viewGroup == null || (j4 = j((fragment2 = eVar.f1644d), (fragment = eVar.f1641a))) == null) {
            return;
        }
        boolean z4 = eVar.f1642b;
        boolean z5 = eVar.f1645e;
        Object q4 = q(j4, fragment, z4);
        Object r4 = r(j4, fragment2, z5);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object l4 = l(j4, viewGroup, view, aVar, eVar, arrayList, arrayList2, q4, r4);
        if (q4 == null && l4 == null) {
            obj = r4;
            if (obj == null) {
                return;
            }
        } else {
            obj = r4;
        }
        ArrayList<View> k4 = k(j4, obj, fragment2, arrayList, view);
        Object obj2 = (k4 == null || k4.isEmpty()) ? null : obj;
        j4.a(q4, view);
        Object u4 = u(j4, q4, obj2, l4, fragment, eVar.f1642b);
        if (u4 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            j4.t(u4, q4, arrayList3, obj2, k4, l4, arrayList2);
            y(j4, viewGroup, fragment, view, arrayList2, q4, arrayList3, obj2, k4);
            j4.w(viewGroup, arrayList2, aVar);
            j4.c(viewGroup, u4);
            j4.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(j jVar, int i4, e eVar, View view, k.a<String, String> aVar) {
        Fragment fragment;
        Fragment fragment2;
        q j4;
        Object obj;
        ViewGroup viewGroup = jVar.f1519s.f() ? (ViewGroup) jVar.f1519s.e(i4) : null;
        if (viewGroup == null || (j4 = j((fragment2 = eVar.f1644d), (fragment = eVar.f1641a))) == null) {
            return;
        }
        boolean z4 = eVar.f1642b;
        boolean z5 = eVar.f1645e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object q4 = q(j4, fragment, z4);
        Object r4 = r(j4, fragment2, z5);
        Object m4 = m(j4, viewGroup, view, aVar, eVar, arrayList2, arrayList, q4, r4);
        if (q4 == null && m4 == null) {
            obj = r4;
            if (obj == null) {
                return;
            }
        } else {
            obj = r4;
        }
        ArrayList<View> k4 = k(j4, obj, fragment2, arrayList2, view);
        ArrayList<View> k5 = k(j4, q4, fragment, arrayList, view);
        A(k5, 4);
        Object u4 = u(j4, q4, obj, m4, fragment, z4);
        if (u4 != null) {
            v(j4, obj, fragment2, k4);
            ArrayList<String> o4 = j4.o(arrayList);
            j4.t(u4, q4, k5, obj, k4, m4, arrayList);
            j4.c(viewGroup, u4);
            j4.x(viewGroup, arrayList2, arrayList, o4, aVar);
            A(k5, 0);
            j4.z(m4, arrayList2, arrayList);
        }
    }

    private static e p(e eVar, SparseArray<e> sparseArray, int i4) {
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        sparseArray.put(i4, eVar2);
        return eVar2;
    }

    private static Object q(q qVar, Fragment fragment, boolean z4) {
        if (fragment == null) {
            return null;
        }
        return qVar.g(z4 ? fragment.B() : fragment.q());
    }

    private static Object r(q qVar, Fragment fragment, boolean z4) {
        if (fragment == null) {
            return null;
        }
        return qVar.g(z4 ? fragment.E() : fragment.s());
    }

    static View s(k.a<String, View> aVar, e eVar, Object obj, boolean z4) {
        ArrayList<String> arrayList;
        androidx.fragment.app.a aVar2 = eVar.f1643c;
        if (obj == null || aVar == null || (arrayList = aVar2.f1598o) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z4 ? aVar2.f1598o : aVar2.f1599p).get(0));
    }

    private static Object t(q qVar, Fragment fragment, Fragment fragment2, boolean z4) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return qVar.A(qVar.g(z4 ? fragment2.G() : fragment.F()));
    }

    private static Object u(q qVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z4) {
        return (obj == null || obj2 == null || fragment == null) ? true : z4 ? fragment.k() : fragment.j() ? qVar.n(obj2, obj, obj3) : qVar.m(obj2, obj, obj3);
    }

    private static void v(q qVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.f1419l && fragment.f1433z && fragment.O) {
            fragment.h1(true);
            qVar.r(obj, fragment.K(), arrayList);
            y.o.a(fragment.G, new a(arrayList));
        }
    }

    private static q w() {
        try {
            return (q) g0.e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void x(k.a<String, String> aVar, k.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    private static void y(q qVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        y.o.a(viewGroup, new b(obj, qVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(q qVar, Object obj, Object obj2, k.a<String, View> aVar, boolean z4, androidx.fragment.app.a aVar2) {
        ArrayList<String> arrayList = aVar2.f1598o;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get((z4 ? aVar2.f1599p : aVar2.f1598o).get(0));
        qVar.v(obj, view);
        if (obj2 != null) {
            qVar.v(obj2, view);
        }
    }
}
