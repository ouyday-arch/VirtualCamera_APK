package z;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import z.f;

/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static int f6612d;

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f6613a;

    /* renamed from: b, reason: collision with root package name */
    public int f6614b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f6615c = -1;

    /* loaded from: classes.dex */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;

        /* renamed from: e, reason: collision with root package name */
        public static final a f6616e = new a(1, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f6617f = new a(2, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f6618g = new a(4, null);

        /* renamed from: h, reason: collision with root package name */
        public static final a f6619h = new a(8, null);

        /* renamed from: i, reason: collision with root package name */
        public static final a f6620i = new a(16, null);

        /* renamed from: j, reason: collision with root package name */
        public static final a f6621j = new a(32, null);

        /* renamed from: k, reason: collision with root package name */
        public static final a f6622k = new a(64, null);

        /* renamed from: l, reason: collision with root package name */
        public static final a f6623l = new a(128, null);

        /* renamed from: m, reason: collision with root package name */
        public static final a f6624m = new a(256, null, f.b.class);

        /* renamed from: n, reason: collision with root package name */
        public static final a f6625n = new a(512, null, f.b.class);

        /* renamed from: o, reason: collision with root package name */
        public static final a f6626o = new a(1024, null, f.c.class);

        /* renamed from: p, reason: collision with root package name */
        public static final a f6627p = new a(2048, null, f.c.class);

        /* renamed from: q, reason: collision with root package name */
        public static final a f6628q = new a(4096, null);

        /* renamed from: r, reason: collision with root package name */
        public static final a f6629r = new a(8192, null);

        /* renamed from: s, reason: collision with root package name */
        public static final a f6630s = new a(16384, null);

        /* renamed from: t, reason: collision with root package name */
        public static final a f6631t = new a(32768, null);

        /* renamed from: u, reason: collision with root package name */
        public static final a f6632u = new a(65536, null);

        /* renamed from: v, reason: collision with root package name */
        public static final a f6633v = new a(131072, null, f.g.class);

        /* renamed from: w, reason: collision with root package name */
        public static final a f6634w = new a(262144, null);

        /* renamed from: x, reason: collision with root package name */
        public static final a f6635x = new a(524288, null);

        /* renamed from: y, reason: collision with root package name */
        public static final a f6636y = new a(1048576, null);

        /* renamed from: z, reason: collision with root package name */
        public static final a f6637z = new a(2097152, null, f.h.class);

        /* renamed from: a, reason: collision with root package name */
        final Object f6638a;

        /* renamed from: b, reason: collision with root package name */
        private final int f6639b;

        /* renamed from: c, reason: collision with root package name */
        private final Class<? extends f.a> f6640c;

        /* renamed from: d, reason: collision with root package name */
        protected final f f6641d;

        static {
            int i4 = Build.VERSION.SDK_INT;
            A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, f.e.class);
            C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            G = new a(i4 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            H = new a(i4 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            I = new a(i4 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            J = new a(i4 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, f.C0098f.class);
            M = new a(i4 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, f.d.class);
            N = new a(i4 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            O = new a(i4 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        }

        public a(int i4, CharSequence charSequence) {
            this(null, i4, charSequence, null, null);
        }

        private a(int i4, CharSequence charSequence, Class<? extends f.a> cls) {
            this(null, i4, charSequence, null, cls);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        a(Object obj, int i4, CharSequence charSequence, f fVar, Class<? extends f.a> cls) {
            this.f6639b = i4;
            this.f6641d = fVar;
            this.f6638a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i4, charSequence) : obj;
            this.f6640c = cls;
        }

        public a a(CharSequence charSequence, f fVar) {
            return new a(null, this.f6639b, charSequence, fVar, this.f6640c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f6638a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f6638a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            f.a newInstance;
            if (this.f6641d == null) {
                return false;
            }
            f.a aVar = null;
            Class<? extends f.a> cls = this.f6640c;
            if (cls != null) {
                try {
                    newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e4) {
                    e = e4;
                }
                try {
                    newInstance.a(bundle);
                    aVar = newInstance;
                } catch (Exception e5) {
                    e = e5;
                    aVar = newInstance;
                    Class<? extends f.a> cls2 = this.f6640c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                    return this.f6641d.a(view, aVar);
                }
            }
            return this.f6641d.a(view, aVar);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.f6638a;
            Object obj3 = ((a) obj).f6638a;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f6638a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final Object f6642a;

        b(Object obj) {
            this.f6642a = obj;
        }

        public static b a(int i4, int i5, boolean z4, int i6) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i4, i5, z4, i6));
        }
    }

    /* renamed from: z.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0097c {

        /* renamed from: a, reason: collision with root package name */
        final Object f6643a;

        C0097c(Object obj) {
            this.f6643a = obj;
        }

        public static C0097c a(int i4, int i5, int i6, int i7, boolean z4, boolean z5) {
            return new C0097c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i4, i5, i6, i7, z4, z5));
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f6613a = accessibilityNodeInfo;
    }

    public static c K() {
        return t0(AccessibilityNodeInfo.obtain());
    }

    public static c L(View view) {
        return t0(AccessibilityNodeInfo.obtain(view));
    }

    public static c M(c cVar) {
        return t0(AccessibilityNodeInfo.obtain(cVar.f6613a));
    }

    private void P(View view) {
        SparseArray<WeakReference<ClickableSpan>> u4 = u(view);
        if (u4 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < u4.size(); i4++) {
                if (u4.valueAt(i4).get() == null) {
                    arrayList.add(Integer.valueOf(i4));
                }
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                u4.remove(((Integer) arrayList.get(i5)).intValue());
            }
        }
    }

    private void R(int i4, boolean z4) {
        Bundle r4 = r();
        if (r4 != null) {
            int i5 = r4.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i4);
            if (!z4) {
                i4 = 0;
            }
            r4.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i4 | i5);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned, int i4) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i4));
    }

    private void f() {
        this.f6613a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f6613a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f6613a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f6613a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List<Integer> g(String str) {
        ArrayList<Integer> integerArrayList = this.f6613a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f6613a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String i(int i4) {
        if (i4 == 1) {
            return "ACTION_FOCUS";
        }
        if (i4 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i4) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i4) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i4) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    private boolean k(int i4) {
        Bundle r4 = r();
        return r4 != null && (r4.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i4) == i4;
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> s(View view) {
        SparseArray<WeakReference<ClickableSpan>> u4 = u(view);
        if (u4 != null) {
            return u4;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(m.a.I, sparseArray);
        return sparseArray;
    }

    public static c t0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    private SparseArray<WeakReference<ClickableSpan>> u(View view) {
        return (SparseArray) view.getTag(m.a.I);
    }

    private boolean x() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int y(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                if (clickableSpan.equals(sparseArray.valueAt(i4).get())) {
                    return sparseArray.keyAt(i4);
                }
            }
        }
        int i5 = f6612d;
        f6612d = i5 + 1;
        return i5;
    }

    public boolean A() {
        return this.f6613a.isChecked();
    }

    public boolean B() {
        return this.f6613a.isClickable();
    }

    public boolean C() {
        return this.f6613a.isEnabled();
    }

    public boolean D() {
        return this.f6613a.isFocusable();
    }

    public boolean E() {
        return this.f6613a.isFocused();
    }

    public boolean F() {
        return this.f6613a.isLongClickable();
    }

    public boolean G() {
        return this.f6613a.isPassword();
    }

    public boolean H() {
        return this.f6613a.isScrollable();
    }

    public boolean I() {
        return this.f6613a.isSelected();
    }

    public boolean J() {
        return Build.VERSION.SDK_INT >= 26 ? this.f6613a.isShowingHintText() : k(4);
    }

    public boolean N(int i4, Bundle bundle) {
        return this.f6613a.performAction(i4, bundle);
    }

    public void O() {
        this.f6613a.recycle();
    }

    public void Q(boolean z4) {
        this.f6613a.setAccessibilityFocused(z4);
    }

    @Deprecated
    public void S(Rect rect) {
        this.f6613a.setBoundsInParent(rect);
    }

    public void T(Rect rect) {
        this.f6613a.setBoundsInScreen(rect);
    }

    public void U(boolean z4) {
        this.f6613a.setCheckable(z4);
    }

    public void V(boolean z4) {
        this.f6613a.setChecked(z4);
    }

    public void W(CharSequence charSequence) {
        this.f6613a.setClassName(charSequence);
    }

    public void X(boolean z4) {
        this.f6613a.setClickable(z4);
    }

    public void Y(Object obj) {
        this.f6613a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f6642a);
    }

    public void Z(Object obj) {
        this.f6613a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0097c) obj).f6643a);
    }

    public void a(int i4) {
        this.f6613a.addAction(i4);
    }

    public void a0(CharSequence charSequence) {
        this.f6613a.setContentDescription(charSequence);
    }

    public void b(a aVar) {
        this.f6613a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f6638a);
    }

    public void b0(boolean z4) {
        this.f6613a.setEnabled(z4);
    }

    public void c(View view, int i4) {
        this.f6613a.addChild(view, i4);
    }

    public void c0(CharSequence charSequence) {
        this.f6613a.setError(charSequence);
    }

    public void d0(boolean z4) {
        this.f6613a.setFocusable(z4);
    }

    public void e(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            f();
            P(view);
            ClickableSpan[] p4 = p(charSequence);
            if (p4 == null || p4.length <= 0) {
                return;
            }
            r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", m.a.f4882a);
            SparseArray<WeakReference<ClickableSpan>> s4 = s(view);
            for (int i4 = 0; i4 < p4.length; i4++) {
                int y4 = y(p4[i4], s4);
                s4.put(y4, new WeakReference<>(p4[i4]));
                d(p4[i4], (Spanned) charSequence, y4);
            }
        }
    }

    public void e0(boolean z4) {
        this.f6613a.setFocused(z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f6613a;
        if (accessibilityNodeInfo == null) {
            if (cVar.f6613a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f6613a)) {
            return false;
        }
        return this.f6615c == cVar.f6615c && this.f6614b == cVar.f6614b;
    }

    public void f0(boolean z4) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6613a.setHeading(z4);
        } else {
            R(2, z4);
        }
    }

    public void g0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6613a.setHintText(charSequence);
        } else {
            this.f6613a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public List<a> h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f6613a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(new a(actionList.get(i4)));
        }
        return arrayList;
    }

    public void h0(int i4) {
        this.f6613a.setMaxTextLength(i4);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f6613a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(CharSequence charSequence) {
        this.f6613a.setPackageName(charSequence);
    }

    public int j() {
        return this.f6613a.getActions();
    }

    public void j0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6613a.setPaneTitle(charSequence);
        } else {
            this.f6613a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void k0(View view) {
        this.f6614b = -1;
        this.f6613a.setParent(view);
    }

    @Deprecated
    public void l(Rect rect) {
        this.f6613a.getBoundsInParent(rect);
    }

    public void l0(View view, int i4) {
        this.f6614b = i4;
        this.f6613a.setParent(view, i4);
    }

    public void m(Rect rect) {
        this.f6613a.getBoundsInScreen(rect);
    }

    public void m0(boolean z4) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6613a.setScreenReaderFocusable(z4);
        } else {
            R(1, z4);
        }
    }

    public int n() {
        return this.f6613a.getChildCount();
    }

    public void n0(boolean z4) {
        this.f6613a.setScrollable(z4);
    }

    public CharSequence o() {
        return this.f6613a.getClassName();
    }

    public void o0(boolean z4) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6613a.setShowingHintText(z4);
        } else {
            R(4, z4);
        }
    }

    public void p0(View view, int i4) {
        this.f6615c = i4;
        this.f6613a.setSource(view, i4);
    }

    public CharSequence q() {
        return this.f6613a.getContentDescription();
    }

    public void q0(CharSequence charSequence) {
        this.f6613a.setText(charSequence);
    }

    public Bundle r() {
        return this.f6613a.getExtras();
    }

    public void r0(boolean z4) {
        this.f6613a.setVisibleToUser(z4);
    }

    public AccessibilityNodeInfo s0() {
        return this.f6613a;
    }

    public CharSequence t() {
        return this.f6613a.getPackageName();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(t());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(v());
        sb.append("; contentDescription: ");
        sb.append(q());
        sb.append("; viewId: ");
        sb.append(w());
        sb.append("; checkable: ");
        sb.append(z());
        sb.append("; checked: ");
        sb.append(A());
        sb.append("; focusable: ");
        sb.append(D());
        sb.append("; focused: ");
        sb.append(E());
        sb.append("; selected: ");
        sb.append(I());
        sb.append("; clickable: ");
        sb.append(B());
        sb.append("; longClickable: ");
        sb.append(F());
        sb.append("; enabled: ");
        sb.append(C());
        sb.append("; password: ");
        sb.append(G());
        sb.append("; scrollable: " + H());
        sb.append("; [");
        List<a> h4 = h();
        for (int i4 = 0; i4 < h4.size(); i4++) {
            a aVar = h4.get(i4);
            String i5 = i(aVar.b());
            if (i5.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                i5 = aVar.c().toString();
            }
            sb.append(i5);
            if (i4 != h4.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence v() {
        if (!x()) {
            return this.f6613a.getText();
        }
        List<Integer> g4 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> g5 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> g6 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> g7 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f6613a.getText(), 0, this.f6613a.getText().length()));
        for (int i4 = 0; i4 < g4.size(); i4++) {
            spannableString.setSpan(new z.a(g7.get(i4).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), g4.get(i4).intValue(), g5.get(i4).intValue(), g6.get(i4).intValue());
        }
        return spannableString;
    }

    public String w() {
        return this.f6613a.getViewIdResourceName();
    }

    public boolean z() {
        return this.f6613a.isCheckable();
    }
}
