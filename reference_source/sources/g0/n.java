package g0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static l f3867a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadLocal<WeakReference<k.a<ViewGroup, ArrayList<l>>>> f3868b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    static ArrayList<ViewGroup> f3869c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: b, reason: collision with root package name */
        l f3870b;

        /* renamed from: c, reason: collision with root package name */
        ViewGroup f3871c;

        /* renamed from: g0.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0042a extends m {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ k.a f3872a;

            C0042a(k.a aVar) {
                this.f3872a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // g0.l.f
            public void c(l lVar) {
                ((ArrayList) this.f3872a.get(a.this.f3871c)).remove(lVar);
                lVar.Q(this);
            }
        }

        a(l lVar, ViewGroup viewGroup) {
            this.f3870b = lVar;
            this.f3871c = viewGroup;
        }

        private void a() {
            this.f3871c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f3871c.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!n.f3869c.remove(this.f3871c)) {
                return true;
            }
            k.a<ViewGroup, ArrayList<l>> b5 = n.b();
            ArrayList<l> arrayList = b5.get(this.f3871c);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                b5.put(this.f3871c, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f3870b);
            this.f3870b.a(new C0042a(b5));
            this.f3870b.l(this.f3871c, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).S(this.f3871c);
                }
            }
            this.f3870b.P(this.f3871c);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            n.f3869c.remove(this.f3871c);
            ArrayList<l> arrayList = n.b().get(this.f3871c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().S(this.f3871c);
                }
            }
            this.f3870b.m(true);
        }
    }

    public static void a(ViewGroup viewGroup, l lVar) {
        if (f3869c.contains(viewGroup) || !y.p.H(viewGroup)) {
            return;
        }
        f3869c.add(viewGroup);
        if (lVar == null) {
            lVar = f3867a;
        }
        l clone = lVar.clone();
        d(viewGroup, clone);
        k.c(viewGroup, null);
        c(viewGroup, clone);
    }

    static k.a<ViewGroup, ArrayList<l>> b() {
        k.a<ViewGroup, ArrayList<l>> aVar;
        WeakReference<k.a<ViewGroup, ArrayList<l>>> weakReference = f3868b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        k.a<ViewGroup, ArrayList<l>> aVar2 = new k.a<>();
        f3868b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, l lVar) {
        if (lVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(lVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, l lVar) {
        ArrayList<l> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<l> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().O(viewGroup);
            }
        }
        if (lVar != null) {
            lVar.l(viewGroup, true);
        }
        k b5 = k.b(viewGroup);
        if (b5 != null) {
            b5.a();
        }
    }
}
