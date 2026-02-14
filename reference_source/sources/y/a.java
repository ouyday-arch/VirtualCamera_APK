package y;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import z.c;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final View.AccessibilityDelegate f6519c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    private final View.AccessibilityDelegate f6520a;

    /* renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f6521b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0094a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final a f6522a;

        C0094a(a aVar) {
            this.f6522a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f6522a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            z.d b5 = this.f6522a.b(view);
            if (b5 != null) {
                return (AccessibilityNodeProvider) b5.d();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f6522a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            z.c t02 = z.c.t0(accessibilityNodeInfo);
            t02.m0(p.K(view));
            t02.f0(p.F(view));
            t02.j0(p.j(view));
            this.f6522a.g(view, t02);
            t02.e(accessibilityNodeInfo.getText(), view);
            List<c.a> c5 = a.c(view);
            for (int i4 = 0; i4 < c5.size(); i4++) {
                t02.b(c5.get(i4));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f6522a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f6522a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i4, Bundle bundle) {
            return this.f6522a.j(view, i4, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i4) {
            this.f6522a.l(view, i4);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f6522a.m(view, accessibilityEvent);
        }
    }

    public a() {
        this(f6519c);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f6520a = accessibilityDelegate;
        this.f6521b = new C0094a(this);
    }

    static List<c.a> c(View view) {
        List<c.a> list = (List) view.getTag(m.a.H);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] p4 = z.c.p(view.createAccessibilityNodeInfo().getText());
            for (int i4 = 0; p4 != null && i4 < p4.length; i4++) {
                if (clickableSpan.equals(p4[i4])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i4, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(m.a.I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i4)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f6520a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public z.d b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f6520a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new z.d(accessibilityNodeProvider);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.f6521b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f6520a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, z.c cVar) {
        this.f6520a.onInitializeAccessibilityNodeInfo(view, cVar.s0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f6520a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f6520a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i4, Bundle bundle) {
        List<c.a> c5 = c(view);
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= c5.size()) {
                break;
            }
            c.a aVar = c5.get(i5);
            if (aVar.b() == i4) {
                z4 = aVar.d(view, bundle);
                break;
            }
            i5++;
        }
        if (!z4) {
            z4 = this.f6520a.performAccessibilityAction(view, i4, bundle);
        }
        return (z4 || i4 != m.a.f4882a) ? z4 : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i4) {
        this.f6520a.sendAccessibilityEvent(view, i4);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f6520a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
