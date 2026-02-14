package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class k extends y.a {

    /* renamed from: d, reason: collision with root package name */
    final RecyclerView f2078d;

    /* renamed from: e, reason: collision with root package name */
    private final a f2079e;

    /* loaded from: classes.dex */
    public static class a extends y.a {

        /* renamed from: d, reason: collision with root package name */
        final k f2080d;

        /* renamed from: e, reason: collision with root package name */
        private Map<View, y.a> f2081e = new WeakHashMap();

        public a(k kVar) {
            this.f2080d = kVar;
        }

        @Override // y.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            y.a aVar = this.f2081e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // y.a
        public z.d b(View view) {
            y.a aVar = this.f2081e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // y.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            y.a aVar = this.f2081e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // y.a
        public void g(View view, z.c cVar) {
            if (!this.f2080d.o() && this.f2080d.f2078d.getLayoutManager() != null) {
                this.f2080d.f2078d.getLayoutManager().O0(view, cVar);
                y.a aVar = this.f2081e.get(view);
                if (aVar != null) {
                    aVar.g(view, cVar);
                    return;
                }
            }
            super.g(view, cVar);
        }

        @Override // y.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            y.a aVar = this.f2081e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // y.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            y.a aVar = this.f2081e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // y.a
        public boolean j(View view, int i4, Bundle bundle) {
            if (this.f2080d.o() || this.f2080d.f2078d.getLayoutManager() == null) {
                return super.j(view, i4, bundle);
            }
            y.a aVar = this.f2081e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i4, bundle)) {
                    return true;
                }
            } else if (super.j(view, i4, bundle)) {
                return true;
            }
            return this.f2080d.f2078d.getLayoutManager().i1(view, i4, bundle);
        }

        @Override // y.a
        public void l(View view, int i4) {
            y.a aVar = this.f2081e.get(view);
            if (aVar != null) {
                aVar.l(view, i4);
            } else {
                super.l(view, i4);
            }
        }

        @Override // y.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            y.a aVar = this.f2081e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public y.a n(View view) {
            return this.f2081e.remove(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void o(View view) {
            y.a f4 = y.p.f(view);
            if (f4 == null || f4 == this) {
                return;
            }
            this.f2081e.put(view, f4);
        }
    }

    public k(RecyclerView recyclerView) {
        this.f2078d = recyclerView;
        y.a n4 = n();
        this.f2079e = (n4 == null || !(n4 instanceof a)) ? new a(this) : (a) n4;
    }

    @Override // y.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().K0(accessibilityEvent);
        }
    }

    @Override // y.a
    public void g(View view, z.c cVar) {
        super.g(view, cVar);
        if (o() || this.f2078d.getLayoutManager() == null) {
            return;
        }
        this.f2078d.getLayoutManager().N0(cVar);
    }

    @Override // y.a
    public boolean j(View view, int i4, Bundle bundle) {
        if (super.j(view, i4, bundle)) {
            return true;
        }
        if (o() || this.f2078d.getLayoutManager() == null) {
            return false;
        }
        return this.f2078d.getLayoutManager().g1(i4, bundle);
    }

    public y.a n() {
        return this.f2079e;
    }

    boolean o() {
        return this.f2078d.hasPendingAdapterUpdates();
    }
}
