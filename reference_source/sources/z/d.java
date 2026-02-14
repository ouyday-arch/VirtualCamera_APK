package z;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f6644a;

    /* loaded from: classes.dex */
    static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        final d f6645a;

        a(d dVar) {
            this.f6645a = dVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i4) {
            c a5 = this.f6645a.a(i4);
            if (a5 == null) {
                return null;
            }
            return a5.s0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i4) {
            List<c> b5 = this.f6645a.b(str, i4);
            if (b5 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = b5.size();
            for (int i5 = 0; i5 < size; i5++) {
                arrayList.add(b5.get(i5).s0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i4, int i5, Bundle bundle) {
            return this.f6645a.e(i4, i5, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class b extends a {
        b(d dVar) {
            super(dVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i4) {
            c c5 = this.f6645a.c(i4);
            if (c5 == null) {
                return null;
            }
            return c5.s0();
        }
    }

    public d() {
        this.f6644a = new b(this);
    }

    public d(Object obj) {
        this.f6644a = obj;
    }

    public c a(int i4) {
        return null;
    }

    public List<c> b(String str, int i4) {
        return null;
    }

    public c c(int i4) {
        return null;
    }

    public Object d() {
        return this.f6644a;
    }

    public boolean e(int i4, int i5, Bundle bundle) {
        return false;
    }
}
