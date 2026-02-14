package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class j0 implements g.e {
    private static Method I;
    private static Method J;
    private final e A;
    private final c B;
    private Runnable C;
    final Handler D;
    private final Rect E;
    private Rect F;
    private boolean G;
    PopupWindow H;

    /* renamed from: b, reason: collision with root package name */
    private Context f1046b;

    /* renamed from: c, reason: collision with root package name */
    private ListAdapter f1047c;

    /* renamed from: d, reason: collision with root package name */
    f0 f1048d;

    /* renamed from: e, reason: collision with root package name */
    private int f1049e;

    /* renamed from: f, reason: collision with root package name */
    private int f1050f;

    /* renamed from: g, reason: collision with root package name */
    private int f1051g;

    /* renamed from: h, reason: collision with root package name */
    private int f1052h;

    /* renamed from: i, reason: collision with root package name */
    private int f1053i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1054j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1055k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1056l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1057m;

    /* renamed from: n, reason: collision with root package name */
    private int f1058n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1059o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f1060p;

    /* renamed from: q, reason: collision with root package name */
    int f1061q;

    /* renamed from: r, reason: collision with root package name */
    private View f1062r;

    /* renamed from: s, reason: collision with root package name */
    private int f1063s;

    /* renamed from: t, reason: collision with root package name */
    private DataSetObserver f1064t;

    /* renamed from: u, reason: collision with root package name */
    private View f1065u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f1066v;

    /* renamed from: w, reason: collision with root package name */
    private AdapterView.OnItemClickListener f1067w;

    /* renamed from: x, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f1068x;

    /* renamed from: y, reason: collision with root package name */
    final g f1069y;

    /* renamed from: z, reason: collision with root package name */
    private final f f1070z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View s4 = j0.this.s();
            if (s4 == null || s4.getWindowToken() == null) {
                return;
            }
            j0.this.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            f0 f0Var;
            if (i4 == -1 || (f0Var = j0.this.f1048d) == null) {
                return;
            }
            f0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (j0.this.b()) {
                j0.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            j0.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements AbsListView.OnScrollListener {
        e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i4) {
            if (i4 != 1 || j0.this.z() || j0.this.H.getContentView() == null) {
                return;
            }
            j0 j0Var = j0.this;
            j0Var.D.removeCallbacks(j0Var.f1069y);
            j0.this.f1069y.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x4 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = j0.this.H) != null && popupWindow.isShowing() && x4 >= 0 && x4 < j0.this.H.getWidth() && y4 >= 0 && y4 < j0.this.H.getHeight()) {
                j0 j0Var = j0.this;
                j0Var.D.postDelayed(j0Var.f1069y, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            j0 j0Var2 = j0.this;
            j0Var2.D.removeCallbacks(j0Var2.f1069y);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f0 f0Var = j0.this.f1048d;
            if (f0Var == null || !y.p.G(f0Var) || j0.this.f1048d.getCount() <= j0.this.f1048d.getChildCount()) {
                return;
            }
            int childCount = j0.this.f1048d.getChildCount();
            j0 j0Var = j0.this;
            if (childCount <= j0Var.f1061q) {
                j0Var.H.setInputMethodMode(2);
                j0.this.show();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                I = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                J = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public j0(Context context) {
        this(context, null, a.a.D);
    }

    public j0(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public j0(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f1049e = -2;
        this.f1050f = -2;
        this.f1053i = 1002;
        this.f1055k = true;
        this.f1058n = 0;
        this.f1059o = false;
        this.f1060p = false;
        this.f1061q = Integer.MAX_VALUE;
        this.f1063s = 0;
        this.f1069y = new g();
        this.f1070z = new f();
        this.A = new e();
        this.B = new c();
        this.E = new Rect();
        this.f1046b = context;
        this.D = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.f205o1, i4, i5);
        this.f1051g = obtainStyledAttributes.getDimensionPixelOffset(a.j.f210p1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(a.j.f215q1, 0);
        this.f1052h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1054j = true;
        }
        obtainStyledAttributes.recycle();
        q qVar = new q(context, attributeSet, i4, i5);
        this.H = qVar;
        qVar.setInputMethodMode(1);
    }

    private void B() {
        View view = this.f1062r;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1062r);
            }
        }
    }

    private void M(boolean z4) {
        if (Build.VERSION.SDK_INT > 28) {
            this.H.setIsClippedToScreen(z4);
            return;
        }
        Method method = I;
        if (method != null) {
            try {
                method.invoke(this.H, Boolean.valueOf(z4));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int p() {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j0.p():int");
    }

    private int t(View view, int i4, boolean z4) {
        return this.H.getMaxAvailableHeight(view, i4, z4);
    }

    public boolean A() {
        return this.G;
    }

    public void C(View view) {
        this.f1065u = view;
    }

    public void D(int i4) {
        this.H.setAnimationStyle(i4);
    }

    public void E(int i4) {
        Drawable background = this.H.getBackground();
        if (background == null) {
            P(i4);
            return;
        }
        background.getPadding(this.E);
        Rect rect = this.E;
        this.f1050f = rect.left + rect.right + i4;
    }

    public void F(int i4) {
        this.f1058n = i4;
    }

    public void G(Rect rect) {
        this.F = rect != null ? new Rect(rect) : null;
    }

    public void H(int i4) {
        this.H.setInputMethodMode(i4);
    }

    public void I(boolean z4) {
        this.G = z4;
        this.H.setFocusable(z4);
    }

    public void J(PopupWindow.OnDismissListener onDismissListener) {
        this.H.setOnDismissListener(onDismissListener);
    }

    public void K(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1067w = onItemClickListener;
    }

    public void L(boolean z4) {
        this.f1057m = true;
        this.f1056l = z4;
    }

    public void N(int i4) {
        this.f1063s = i4;
    }

    public void O(int i4) {
        f0 f0Var = this.f1048d;
        if (!b() || f0Var == null) {
            return;
        }
        f0Var.setListSelectionHidden(false);
        f0Var.setSelection(i4);
        if (f0Var.getChoiceMode() != 0) {
            f0Var.setItemChecked(i4, true);
        }
    }

    public void P(int i4) {
        this.f1050f = i4;
    }

    @Override // g.e
    public boolean b() {
        return this.H.isShowing();
    }

    public void c(Drawable drawable) {
        this.H.setBackgroundDrawable(drawable);
    }

    public void d(int i4) {
        this.f1051g = i4;
    }

    @Override // g.e
    public void dismiss() {
        this.H.dismiss();
        B();
        this.H.setContentView(null);
        this.f1048d = null;
        this.D.removeCallbacks(this.f1069y);
    }

    public int e() {
        return this.f1051g;
    }

    public int g() {
        if (this.f1054j) {
            return this.f1052h;
        }
        return 0;
    }

    public Drawable i() {
        return this.H.getBackground();
    }

    @Override // g.e
    public ListView k() {
        return this.f1048d;
    }

    public void m(int i4) {
        this.f1052h = i4;
        this.f1054j = true;
    }

    public void n(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1064t;
        if (dataSetObserver == null) {
            this.f1064t = new d();
        } else {
            ListAdapter listAdapter2 = this.f1047c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1047c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1064t);
        }
        f0 f0Var = this.f1048d;
        if (f0Var != null) {
            f0Var.setAdapter(this.f1047c);
        }
    }

    public void q() {
        f0 f0Var = this.f1048d;
        if (f0Var != null) {
            f0Var.setListSelectionHidden(true);
            f0Var.requestLayout();
        }
    }

    f0 r(Context context, boolean z4) {
        return new f0(context, z4);
    }

    public View s() {
        return this.f1065u;
    }

    @Override // g.e
    public void show() {
        int p4 = p();
        boolean z4 = z();
        androidx.core.widget.h.b(this.H, this.f1053i);
        if (this.H.isShowing()) {
            if (y.p.G(s())) {
                int i4 = this.f1050f;
                if (i4 == -1) {
                    i4 = -1;
                } else if (i4 == -2) {
                    i4 = s().getWidth();
                }
                int i5 = this.f1049e;
                if (i5 == -1) {
                    if (!z4) {
                        p4 = -1;
                    }
                    if (z4) {
                        this.H.setWidth(this.f1050f == -1 ? -1 : 0);
                        this.H.setHeight(0);
                    } else {
                        this.H.setWidth(this.f1050f == -1 ? -1 : 0);
                        this.H.setHeight(-1);
                    }
                } else if (i5 != -2) {
                    p4 = i5;
                }
                this.H.setOutsideTouchable((this.f1060p || this.f1059o) ? false : true);
                this.H.update(s(), this.f1051g, this.f1052h, i4 < 0 ? -1 : i4, p4 < 0 ? -1 : p4);
                return;
            }
            return;
        }
        int i6 = this.f1050f;
        if (i6 == -1) {
            i6 = -1;
        } else if (i6 == -2) {
            i6 = s().getWidth();
        }
        int i7 = this.f1049e;
        if (i7 == -1) {
            p4 = -1;
        } else if (i7 != -2) {
            p4 = i7;
        }
        this.H.setWidth(i6);
        this.H.setHeight(p4);
        M(true);
        this.H.setOutsideTouchable((this.f1060p || this.f1059o) ? false : true);
        this.H.setTouchInterceptor(this.f1070z);
        if (this.f1057m) {
            androidx.core.widget.h.a(this.H, this.f1056l);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = J;
            if (method != null) {
                try {
                    method.invoke(this.H, this.F);
                } catch (Exception e4) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e4);
                }
            }
        } else {
            this.H.setEpicenterBounds(this.F);
        }
        androidx.core.widget.h.c(this.H, s(), this.f1051g, this.f1052h, this.f1058n);
        this.f1048d.setSelection(-1);
        if (!this.G || this.f1048d.isInTouchMode()) {
            q();
        }
        if (this.G) {
            return;
        }
        this.D.post(this.B);
    }

    public Object u() {
        if (b()) {
            return this.f1048d.getSelectedItem();
        }
        return null;
    }

    public long v() {
        if (b()) {
            return this.f1048d.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int w() {
        if (b()) {
            return this.f1048d.getSelectedItemPosition();
        }
        return -1;
    }

    public View x() {
        if (b()) {
            return this.f1048d.getSelectedView();
        }
        return null;
    }

    public int y() {
        return this.f1050f;
    }

    public boolean z() {
        return this.H.getInputMethodMode() == 2;
    }
}
