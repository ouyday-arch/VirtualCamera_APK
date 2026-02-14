package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.w0;
import androidx.lifecycle.d;
import f.b;
import f.f;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import y.d;
import y.p;
import y.t;
import y.v;
import y.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends androidx.appcompat.app.d implements e.a, LayoutInflater.Factory2 {

    /* renamed from: b0, reason: collision with root package name */
    private static final Map<Class<?>, Integer> f422b0 = new k.a();

    /* renamed from: c0, reason: collision with root package name */
    private static final boolean f423c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final int[] f424d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final boolean f425e0;
    private boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    private boolean G;
    private m[] H;
    private m I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    boolean N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private j S;
    private j T;
    boolean U;
    int V;
    private final Runnable W;
    private boolean X;
    private Rect Y;
    private Rect Z;

    /* renamed from: a0, reason: collision with root package name */
    private AppCompatViewInflater f426a0;

    /* renamed from: e, reason: collision with root package name */
    final Object f427e;

    /* renamed from: f, reason: collision with root package name */
    final Context f428f;

    /* renamed from: g, reason: collision with root package name */
    Window f429g;

    /* renamed from: h, reason: collision with root package name */
    private h f430h;

    /* renamed from: i, reason: collision with root package name */
    final b.a f431i;

    /* renamed from: j, reason: collision with root package name */
    androidx.appcompat.app.a f432j;

    /* renamed from: k, reason: collision with root package name */
    MenuInflater f433k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f434l;

    /* renamed from: m, reason: collision with root package name */
    private c0 f435m;

    /* renamed from: n, reason: collision with root package name */
    private f f436n;

    /* renamed from: o, reason: collision with root package name */
    private n f437o;

    /* renamed from: p, reason: collision with root package name */
    f.b f438p;

    /* renamed from: q, reason: collision with root package name */
    ActionBarContextView f439q;

    /* renamed from: r, reason: collision with root package name */
    PopupWindow f440r;

    /* renamed from: s, reason: collision with root package name */
    Runnable f441s;

    /* renamed from: t, reason: collision with root package name */
    t f442t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f443u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f444v;

    /* renamed from: w, reason: collision with root package name */
    private ViewGroup f445w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f446x;

    /* renamed from: y, reason: collision with root package name */
    private View f447y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f448z;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            if ((eVar.V & 1) != 0) {
                eVar.S(0);
            }
            e eVar2 = e.this;
            if ((eVar2.V & 4096) != 0) {
                eVar2.S(108);
            }
            e eVar3 = e.this;
            eVar3.U = false;
            eVar3.V = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements y.n {
        b() {
        }

        @Override // y.n
        public x a(View view, x xVar) {
            int d5 = xVar.d();
            int I0 = e.this.I0(d5);
            if (d5 != I0) {
                xVar = xVar.f(xVar.b(), I0, xVar.c(), xVar.a());
            }
            return p.O(view, xVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ContentFrameLayout.a {
        c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            e.this.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* loaded from: classes.dex */
        class a extends v {
            a() {
            }

            @Override // y.u
            public void a(View view) {
                e.this.f439q.setAlpha(1.0f);
                e.this.f442t.f(null);
                e.this.f442t = null;
            }

            @Override // y.v, y.u
            public void b(View view) {
                e.this.f439q.setVisibility(0);
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f440r.showAtLocation(eVar.f439q, 55, 0, 0);
            e.this.T();
            if (!e.this.A0()) {
                e.this.f439q.setAlpha(1.0f);
                e.this.f439q.setVisibility(0);
            } else {
                e.this.f439q.setAlpha(0.0f);
                e eVar2 = e.this;
                eVar2.f442t = p.c(eVar2.f439q).a(1.0f);
                e.this.f442t.f(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.appcompat.app.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0005e extends v {
        C0005e() {
        }

        @Override // y.u
        public void a(View view) {
            e.this.f439q.setAlpha(1.0f);
            e.this.f442t.f(null);
            e.this.f442t = null;
        }

        @Override // y.v, y.u
        public void b(View view) {
            e.this.f439q.setVisibility(0);
            e.this.f439q.sendAccessibilityEvent(32);
            if (e.this.f439q.getParent() instanceof View) {
                p.Y((View) e.this.f439q.getParent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
            e.this.K(eVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback c02 = e.this.c0();
            if (c02 == null) {
                return true;
            }
            c02.onMenuOpened(108, eVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private b.a f456a;

        /* loaded from: classes.dex */
        class a extends v {
            a() {
            }

            @Override // y.u
            public void a(View view) {
                e.this.f439q.setVisibility(8);
                e eVar = e.this;
                PopupWindow popupWindow = eVar.f440r;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (eVar.f439q.getParent() instanceof View) {
                    p.Y((View) e.this.f439q.getParent());
                }
                e.this.f439q.removeAllViews();
                e.this.f442t.f(null);
                e.this.f442t = null;
            }
        }

        public g(b.a aVar) {
            this.f456a = aVar;
        }

        @Override // f.b.a
        public boolean a(f.b bVar, MenuItem menuItem) {
            return this.f456a.a(bVar, menuItem);
        }

        @Override // f.b.a
        public boolean b(f.b bVar, Menu menu) {
            return this.f456a.b(bVar, menu);
        }

        @Override // f.b.a
        public void c(f.b bVar) {
            this.f456a.c(bVar);
            e eVar = e.this;
            if (eVar.f440r != null) {
                eVar.f429g.getDecorView().removeCallbacks(e.this.f441s);
            }
            e eVar2 = e.this;
            if (eVar2.f439q != null) {
                eVar2.T();
                e eVar3 = e.this;
                eVar3.f442t = p.c(eVar3.f439q).a(0.0f);
                e.this.f442t.f(new a());
            }
            e eVar4 = e.this;
            b.a aVar = eVar4.f431i;
            if (aVar != null) {
                aVar.e(eVar4.f438p);
            }
            e.this.f438p = null;
        }

        @Override // f.b.a
        public boolean d(f.b bVar, Menu menu) {
            return this.f456a.d(bVar, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends f.i {
        h(Window.Callback callback) {
            super(callback);
        }

        final ActionMode b(ActionMode.Callback callback) {
            f.a aVar = new f.a(e.this.f428f, callback);
            f.b C0 = e.this.C0(aVar);
            if (C0 != null) {
                return aVar.e(C0);
            }
            return null;
        }

        @Override // f.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return e.this.R(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // f.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || e.this.o0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // f.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i4, Menu menu) {
            if (i4 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i4, menu);
            }
            return false;
        }

        @Override // f.i, android.view.Window.Callback
        public boolean onMenuOpened(int i4, Menu menu) {
            super.onMenuOpened(i4, menu);
            e.this.r0(i4);
            return true;
        }

        @Override // f.i, android.view.Window.Callback
        public void onPanelClosed(int i4, Menu menu) {
            super.onPanelClosed(i4, menu);
            e.this.s0(i4);
        }

        @Override // f.i, android.view.Window.Callback
        public boolean onPreparePanel(int i4, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i4 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.a0(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i4, view, menu);
            if (eVar != null) {
                eVar.a0(false);
            }
            return onPreparePanel;
        }

        @Override // f.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i4) {
            androidx.appcompat.view.menu.e eVar;
            m a02 = e.this.a0(0, true);
            if (a02 == null || (eVar = a02.f477j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i4);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i4);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // f.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i4) {
            return (e.this.j0() && i4 == 0) ? b(callback) : super.onWindowStartingActionMode(callback, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends j {

        /* renamed from: c, reason: collision with root package name */
        private final PowerManager f460c;

        i(Context context) {
            super();
            this.f460c = (PowerManager) context.getSystemService("power");
        }

        @Override // androidx.appcompat.app.e.j
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.e.j
        public int c() {
            return this.f460c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.e.j
        public void d() {
            e.this.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class j {

        /* renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f462a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                j.this.d();
            }
        }

        j() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f462a;
            if (broadcastReceiver != null) {
                try {
                    e.this.f428f.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f462a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b5 = b();
            if (b5 == null || b5.countActions() == 0) {
                return;
            }
            if (this.f462a == null) {
                this.f462a = new a();
            }
            e.this.f428f.registerReceiver(this.f462a, b5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends j {

        /* renamed from: c, reason: collision with root package name */
        private final androidx.appcompat.app.h f465c;

        k(androidx.appcompat.app.h hVar) {
            super();
            this.f465c = hVar;
        }

        @Override // androidx.appcompat.app.e.j
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.e.j
        public int c() {
            return this.f465c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.e.j
        public void d() {
            e.this.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class l extends ContentFrameLayout {
        public l(Context context) {
            super(context);
        }

        private boolean c(int i4, int i5) {
            return i4 < -5 || i5 < -5 || i4 > getWidth() + 5 || i5 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return e.this.R(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            e.this.M(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i4) {
            setBackgroundDrawable(c.a.b(getContext(), i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class m {

        /* renamed from: a, reason: collision with root package name */
        int f468a;

        /* renamed from: b, reason: collision with root package name */
        int f469b;

        /* renamed from: c, reason: collision with root package name */
        int f470c;

        /* renamed from: d, reason: collision with root package name */
        int f471d;

        /* renamed from: e, reason: collision with root package name */
        int f472e;

        /* renamed from: f, reason: collision with root package name */
        int f473f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f474g;

        /* renamed from: h, reason: collision with root package name */
        View f475h;

        /* renamed from: i, reason: collision with root package name */
        View f476i;

        /* renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.e f477j;

        /* renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.c f478k;

        /* renamed from: l, reason: collision with root package name */
        Context f479l;

        /* renamed from: m, reason: collision with root package name */
        boolean f480m;

        /* renamed from: n, reason: collision with root package name */
        boolean f481n;

        /* renamed from: o, reason: collision with root package name */
        boolean f482o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f483p;

        /* renamed from: q, reason: collision with root package name */
        boolean f484q = false;

        /* renamed from: r, reason: collision with root package name */
        boolean f485r;

        /* renamed from: s, reason: collision with root package name */
        Bundle f486s;

        m(int i4) {
            this.f468a = i4;
        }

        androidx.appcompat.view.menu.k a(j.a aVar) {
            if (this.f477j == null) {
                return null;
            }
            if (this.f478k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f479l, a.g.f107j);
                this.f478k = cVar;
                cVar.g(aVar);
                this.f477j.b(this.f478k);
            }
            return this.f478k.j(this.f474g);
        }

        public boolean b() {
            if (this.f475h == null) {
                return false;
            }
            return this.f476i != null || this.f478k.b().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f477j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.O(this.f478k);
            }
            this.f477j = eVar;
            if (eVar == null || (cVar = this.f478k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(a.a.f0a, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                newTheme.applyStyle(i4, true);
            }
            newTheme.resolveAttribute(a.a.E, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 == 0) {
                i5 = a.i.f131b;
            }
            newTheme.applyStyle(i5, true);
            f.d dVar = new f.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f479l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(a.j.f259z0);
            this.f469b = obtainStyledAttributes.getResourceId(a.j.C0, 0);
            this.f473f = obtainStyledAttributes.getResourceId(a.j.B0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class n implements j.a {
        n() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z4) {
            androidx.appcompat.view.menu.e D = eVar.D();
            boolean z5 = D != eVar;
            e eVar2 = e.this;
            if (z5) {
                eVar = D;
            }
            m W = eVar2.W(eVar);
            if (W != null) {
                if (!z5) {
                    e.this.N(W, z4);
                } else {
                    e.this.J(W.f468a, W, D);
                    e.this.N(W, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback c02;
            if (eVar != null) {
                return true;
            }
            e eVar2 = e.this;
            if (!eVar2.B || (c02 = eVar2.c0()) == null || e.this.N) {
                return true;
            }
            c02.onMenuOpened(108, eVar);
            return true;
        }
    }

    static {
        int i4 = Build.VERSION.SDK_INT;
        f423c0 = false;
        f424d0 = new int[]{R.attr.windowBackground};
        f425e0 = i4 <= 25;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Activity activity, b.a aVar) {
        this(activity, null, aVar, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Dialog dialog, b.a aVar) {
        this(dialog.getContext(), dialog.getWindow(), aVar, dialog);
    }

    private e(Context context, Window window, b.a aVar, Object obj) {
        Map<Class<?>, Integer> map;
        Integer num;
        androidx.appcompat.app.c F0;
        this.f442t = null;
        this.f443u = true;
        this.O = -100;
        this.W = new a();
        this.f428f = context;
        this.f431i = aVar;
        this.f427e = obj;
        if (this.O == -100 && (obj instanceof Dialog) && (F0 = F0()) != null) {
            this.O = F0.x().i();
        }
        if (this.O == -100 && (num = (map = f422b0).get(obj.getClass())) != null) {
            this.O = num.intValue();
            map.remove(obj.getClass());
        }
        if (window != null) {
            H(window);
        }
        androidx.appcompat.widget.j.h();
    }

    private boolean B0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f429g.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || p.G((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void E0() {
        if (this.f444v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private boolean F(boolean z4) {
        if (this.N) {
            return false;
        }
        int I = I();
        boolean G0 = G0(k0(I), z4);
        if (I == 0) {
            Z().e();
        } else {
            j jVar = this.S;
            if (jVar != null) {
                jVar.a();
            }
        }
        if (I == 3) {
            Y().e();
        } else {
            j jVar2 = this.T;
            if (jVar2 != null) {
                jVar2.a();
            }
        }
        return G0;
    }

    private androidx.appcompat.app.c F0() {
        for (Context context = this.f428f; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof androidx.appcompat.app.c) {
                return (androidx.appcompat.app.c) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void G() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f445w.findViewById(R.id.content);
        View decorView = this.f429g.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f428f.obtainStyledAttributes(a.j.f259z0);
        obtainStyledAttributes.getValue(a.j.L0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(a.j.M0, contentFrameLayout.getMinWidthMinor());
        int i4 = a.j.J0;
        if (obtainStyledAttributes.hasValue(i4)) {
            obtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedWidthMajor());
        }
        int i5 = a.j.K0;
        if (obtainStyledAttributes.hasValue(i5)) {
            obtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedWidthMinor());
        }
        int i6 = a.j.H0;
        if (obtainStyledAttributes.hasValue(i6)) {
            obtainStyledAttributes.getValue(i6, contentFrameLayout.getFixedHeightMajor());
        }
        int i7 = a.j.I0;
        if (obtainStyledAttributes.hasValue(i7)) {
            obtainStyledAttributes.getValue(i7, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private boolean G0(int i4, boolean z4) {
        int i5 = this.f428f.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z5 = true;
        int i6 = i4 != 1 ? i4 != 2 ? i5 : 32 : 16;
        boolean i02 = i0();
        boolean z6 = false;
        if ((f425e0 || i6 != i5) && !i02 && !this.K && (this.f427e instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | i6;
            try {
                ((ContextThemeWrapper) this.f427e).applyOverrideConfiguration(configuration);
                z6 = true;
            } catch (IllegalStateException e4) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e4);
            }
        }
        int i7 = this.f428f.getResources().getConfiguration().uiMode & 48;
        if (!z6 && i7 != i6 && z4 && !i02 && this.K) {
            Object obj = this.f427e;
            if (obj instanceof Activity) {
                n.a.g((Activity) obj);
                z6 = true;
            }
        }
        if (z6 || i7 == i6) {
            z5 = z6;
        } else {
            H0(i6, i02);
        }
        if (z5) {
            Object obj2 = this.f427e;
            if (obj2 instanceof androidx.appcompat.app.c) {
                ((androidx.appcompat.app.c) obj2).A(i4);
            }
        }
        return z5;
    }

    private void H(Window window) {
        if (this.f429g != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof h) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        h hVar = new h(callback);
        this.f430h = hVar;
        window.setCallback(hVar);
        w0 t4 = w0.t(this.f428f, null, f424d0);
        Drawable h4 = t4.h(0);
        if (h4 != null) {
            window.setBackgroundDrawable(h4);
        }
        t4.v();
        this.f429g = window;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void H0(int i4, boolean z4) {
        Resources resources = this.f428f.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i4 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration, null);
        if (Build.VERSION.SDK_INT < 26) {
            androidx.appcompat.app.f.a(resources);
        }
        int i5 = this.P;
        if (i5 != 0) {
            this.f428f.setTheme(i5);
            this.f428f.getTheme().applyStyle(this.P, true);
        }
        if (z4) {
            Object obj = this.f427e;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.g) {
                    if (!((androidx.lifecycle.g) activity).a().b().a(d.b.STARTED)) {
                        return;
                    }
                } else if (!this.M) {
                    return;
                }
                activity.onConfigurationChanged(configuration);
            }
        }
    }

    private int I() {
        int i4 = this.O;
        return i4 != -100 ? i4 : androidx.appcompat.app.d.h();
    }

    private void L() {
        j jVar = this.S;
        if (jVar != null) {
            jVar.a();
        }
        j jVar2 = this.T;
        if (jVar2 != null) {
            jVar2.a();
        }
    }

    private ViewGroup O() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f428f.obtainStyledAttributes(a.j.f259z0);
        int i4 = a.j.E0;
        if (!obtainStyledAttributes.hasValue(i4)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(a.j.N0, false)) {
            y(1);
        } else if (obtainStyledAttributes.getBoolean(i4, false)) {
            y(108);
        }
        if (obtainStyledAttributes.getBoolean(a.j.F0, false)) {
            y(109);
        }
        if (obtainStyledAttributes.getBoolean(a.j.G0, false)) {
            y(10);
        }
        this.E = obtainStyledAttributes.getBoolean(a.j.A0, false);
        obtainStyledAttributes.recycle();
        V();
        this.f429g.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.f428f);
        if (this.F) {
            viewGroup = (ViewGroup) from.inflate(this.D ? a.g.f112o : a.g.f111n, (ViewGroup) null);
            p.l0(viewGroup, new b());
        } else if (this.E) {
            viewGroup = (ViewGroup) from.inflate(a.g.f103f, (ViewGroup) null);
            this.C = false;
            this.B = false;
        } else if (this.B) {
            TypedValue typedValue = new TypedValue();
            this.f428f.getTheme().resolveAttribute(a.a.f5f, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new f.d(this.f428f, typedValue.resourceId) : this.f428f).inflate(a.g.f113p, (ViewGroup) null);
            c0 c0Var = (c0) viewGroup.findViewById(a.f.f87p);
            this.f435m = c0Var;
            c0Var.setWindowCallback(c0());
            if (this.C) {
                this.f435m.k(109);
            }
            if (this.f448z) {
                this.f435m.k(2);
            }
            if (this.A) {
                this.f435m.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.B + ", windowActionBarOverlay: " + this.C + ", android:windowIsFloating: " + this.E + ", windowActionModeOverlay: " + this.D + ", windowNoTitle: " + this.F + " }");
        }
        if (this.f435m == null) {
            this.f446x = (TextView) viewGroup.findViewById(a.f.M);
        }
        c1.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.f.f73b);
        ViewGroup viewGroup2 = (ViewGroup) this.f429g.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f429g.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c());
        return viewGroup;
    }

    private void U() {
        if (this.f444v) {
            return;
        }
        this.f445w = O();
        CharSequence b02 = b0();
        if (!TextUtils.isEmpty(b02)) {
            c0 c0Var = this.f435m;
            if (c0Var != null) {
                c0Var.setWindowTitle(b02);
            } else if (v0() != null) {
                v0().u(b02);
            } else {
                TextView textView = this.f446x;
                if (textView != null) {
                    textView.setText(b02);
                }
            }
        }
        G();
        t0(this.f445w);
        this.f444v = true;
        m a02 = a0(0, false);
        if (this.N) {
            return;
        }
        if (a02 == null || a02.f477j == null) {
            h0(108);
        }
    }

    private void V() {
        if (this.f429g == null) {
            Object obj = this.f427e;
            if (obj instanceof Activity) {
                H(((Activity) obj).getWindow());
            }
        }
        if (this.f429g == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private j Y() {
        if (this.T == null) {
            this.T = new i(this.f428f);
        }
        return this.T;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d0() {
        /*
            r3 = this;
            r3.U()
            boolean r0 = r3.B
            if (r0 == 0) goto L37
            androidx.appcompat.app.a r0 = r3.f432j
            if (r0 == 0) goto Lc
            goto L37
        Lc:
            java.lang.Object r0 = r3.f427e
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L20
            androidx.appcompat.app.i r0 = new androidx.appcompat.app.i
            java.lang.Object r1 = r3.f427e
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.C
            r0.<init>(r1, r2)
        L1d:
            r3.f432j = r0
            goto L2e
        L20:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L2e
            androidx.appcompat.app.i r0 = new androidx.appcompat.app.i
            java.lang.Object r1 = r3.f427e
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L1d
        L2e:
            androidx.appcompat.app.a r0 = r3.f432j
            if (r0 == 0) goto L37
            boolean r1 = r3.X
            r0.s(r1)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.e.d0():void");
    }

    private boolean e0(m mVar) {
        View view = mVar.f476i;
        if (view != null) {
            mVar.f475h = view;
            return true;
        }
        if (mVar.f477j == null) {
            return false;
        }
        if (this.f437o == null) {
            this.f437o = new n();
        }
        View view2 = (View) mVar.a(this.f437o);
        mVar.f475h = view2;
        return view2 != null;
    }

    private boolean f0(m mVar) {
        mVar.d(X());
        mVar.f474g = new l(mVar.f479l);
        mVar.f470c = 81;
        return true;
    }

    private boolean g0(m mVar) {
        Context context = this.f428f;
        int i4 = mVar.f468a;
        if ((i4 == 0 || i4 == 108) && this.f435m != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.a.f5f, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(a.a.f6g, typedValue, true);
            } else {
                theme.resolveAttribute(a.a.f6g, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                f.d dVar = new f.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.R(this);
        mVar.c(eVar);
        return true;
    }

    private void h0(int i4) {
        this.V = (1 << i4) | this.V;
        if (this.U) {
            return;
        }
        p.T(this.f429g.getDecorView(), this.W);
        this.U = true;
    }

    private boolean i0() {
        if (!this.R && (this.f427e instanceof Activity)) {
            PackageManager packageManager = this.f428f.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f428f, this.f427e.getClass()), 0);
                this.Q = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e4) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e4);
                this.Q = false;
            }
        }
        this.R = true;
        return this.Q;
    }

    private boolean n0(int i4, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        m a02 = a0(i4, true);
        if (a02.f482o) {
            return false;
        }
        return x0(a02, keyEvent);
    }

    private boolean q0(int i4, KeyEvent keyEvent) {
        boolean z4;
        c0 c0Var;
        if (this.f438p != null) {
            return false;
        }
        boolean z5 = true;
        m a02 = a0(i4, true);
        if (i4 != 0 || (c0Var = this.f435m) == null || !c0Var.g() || ViewConfiguration.get(this.f428f).hasPermanentMenuKey()) {
            boolean z6 = a02.f482o;
            if (z6 || a02.f481n) {
                N(a02, true);
                z5 = z6;
            } else {
                if (a02.f480m) {
                    if (a02.f485r) {
                        a02.f480m = false;
                        z4 = x0(a02, keyEvent);
                    } else {
                        z4 = true;
                    }
                    if (z4) {
                        u0(a02, keyEvent);
                    }
                }
                z5 = false;
            }
        } else if (this.f435m.c()) {
            z5 = this.f435m.d();
        } else {
            if (!this.N && x0(a02, keyEvent)) {
                z5 = this.f435m.e();
            }
            z5 = false;
        }
        if (z5) {
            AudioManager audioManager = (AudioManager) this.f428f.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z5;
    }

    private void u0(m mVar, KeyEvent keyEvent) {
        int i4;
        ViewGroup.LayoutParams layoutParams;
        if (mVar.f482o || this.N) {
            return;
        }
        if (mVar.f468a == 0) {
            if ((this.f428f.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback c02 = c0();
        if (c02 != null && !c02.onMenuOpened(mVar.f468a, mVar.f477j)) {
            N(mVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f428f.getSystemService("window");
        if (windowManager != null && x0(mVar, keyEvent)) {
            ViewGroup viewGroup = mVar.f474g;
            if (viewGroup == null || mVar.f484q) {
                if (viewGroup == null) {
                    if (!f0(mVar) || mVar.f474g == null) {
                        return;
                    }
                } else if (mVar.f484q && viewGroup.getChildCount() > 0) {
                    mVar.f474g.removeAllViews();
                }
                if (!e0(mVar) || !mVar.b()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = mVar.f475h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                mVar.f474g.setBackgroundResource(mVar.f469b);
                ViewParent parent = mVar.f475h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(mVar.f475h);
                }
                mVar.f474g.addView(mVar.f475h, layoutParams2);
                if (!mVar.f475h.hasFocus()) {
                    mVar.f475h.requestFocus();
                }
            } else {
                View view = mVar.f476i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i4 = -1;
                    mVar.f481n = false;
                    WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i4, -2, mVar.f471d, mVar.f472e, 1002, 8519680, -3);
                    layoutParams3.gravity = mVar.f470c;
                    layoutParams3.windowAnimations = mVar.f473f;
                    windowManager.addView(mVar.f474g, layoutParams3);
                    mVar.f482o = true;
                }
            }
            i4 = -2;
            mVar.f481n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i4, -2, mVar.f471d, mVar.f472e, 1002, 8519680, -3);
            layoutParams32.gravity = mVar.f470c;
            layoutParams32.windowAnimations = mVar.f473f;
            windowManager.addView(mVar.f474g, layoutParams32);
            mVar.f482o = true;
        }
    }

    private boolean w0(m mVar, int i4, KeyEvent keyEvent, int i5) {
        androidx.appcompat.view.menu.e eVar;
        boolean z4 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((mVar.f480m || x0(mVar, keyEvent)) && (eVar = mVar.f477j) != null) {
            z4 = eVar.performShortcut(i4, keyEvent, i5);
        }
        if (z4 && (i5 & 1) == 0 && this.f435m == null) {
            N(mVar, true);
        }
        return z4;
    }

    private boolean x0(m mVar, KeyEvent keyEvent) {
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        if (this.N) {
            return false;
        }
        if (mVar.f480m) {
            return true;
        }
        m mVar2 = this.I;
        if (mVar2 != null && mVar2 != mVar) {
            N(mVar2, false);
        }
        Window.Callback c02 = c0();
        if (c02 != null) {
            mVar.f476i = c02.onCreatePanelView(mVar.f468a);
        }
        int i4 = mVar.f468a;
        boolean z4 = i4 == 0 || i4 == 108;
        if (z4 && (c0Var3 = this.f435m) != null) {
            c0Var3.f();
        }
        if (mVar.f476i == null) {
            if (z4) {
                v0();
            }
            androidx.appcompat.view.menu.e eVar = mVar.f477j;
            if (eVar == null || mVar.f485r) {
                if (eVar == null && (!g0(mVar) || mVar.f477j == null)) {
                    return false;
                }
                if (z4 && this.f435m != null) {
                    if (this.f436n == null) {
                        this.f436n = new f();
                    }
                    this.f435m.a(mVar.f477j, this.f436n);
                }
                mVar.f477j.d0();
                if (!c02.onCreatePanelMenu(mVar.f468a, mVar.f477j)) {
                    mVar.c(null);
                    if (z4 && (c0Var = this.f435m) != null) {
                        c0Var.a(null, this.f436n);
                    }
                    return false;
                }
                mVar.f485r = false;
            }
            mVar.f477j.d0();
            Bundle bundle = mVar.f486s;
            if (bundle != null) {
                mVar.f477j.P(bundle);
                mVar.f486s = null;
            }
            if (!c02.onPreparePanel(0, mVar.f476i, mVar.f477j)) {
                if (z4 && (c0Var2 = this.f435m) != null) {
                    c0Var2.a(null, this.f436n);
                }
                mVar.f477j.c0();
                return false;
            }
            boolean z5 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            mVar.f483p = z5;
            mVar.f477j.setQwertyMode(z5);
            mVar.f477j.c0();
        }
        mVar.f480m = true;
        mVar.f481n = false;
        this.I = mVar;
        return true;
    }

    private void y0(androidx.appcompat.view.menu.e eVar, boolean z4) {
        c0 c0Var = this.f435m;
        if (c0Var == null || !c0Var.g() || (ViewConfiguration.get(this.f428f).hasPermanentMenuKey() && !this.f435m.b())) {
            m a02 = a0(0, true);
            a02.f484q = true;
            N(a02, false);
            u0(a02, null);
            return;
        }
        Window.Callback c02 = c0();
        if (this.f435m.c() && z4) {
            this.f435m.d();
            if (this.N) {
                return;
            }
            c02.onPanelClosed(108, a0(0, true).f477j);
            return;
        }
        if (c02 == null || this.N) {
            return;
        }
        if (this.U && (this.V & 1) != 0) {
            this.f429g.getDecorView().removeCallbacks(this.W);
            this.W.run();
        }
        m a03 = a0(0, true);
        androidx.appcompat.view.menu.e eVar2 = a03.f477j;
        if (eVar2 == null || a03.f485r || !c02.onPreparePanel(0, a03.f476i, eVar2)) {
            return;
        }
        c02.onMenuOpened(108, a03.f477j);
        this.f435m.e();
    }

    private int z0(int i4) {
        if (i4 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i4 != 9) {
            return i4;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    @Override // androidx.appcompat.app.d
    public void A(View view) {
        U();
        ViewGroup viewGroup = (ViewGroup) this.f445w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f430h.a().onContentChanged();
    }

    final boolean A0() {
        ViewGroup viewGroup;
        return this.f444v && (viewGroup = this.f445w) != null && p.H(viewGroup);
    }

    @Override // androidx.appcompat.app.d
    public void B(View view, ViewGroup.LayoutParams layoutParams) {
        U();
        ViewGroup viewGroup = (ViewGroup) this.f445w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f430h.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.d
    public void C(int i4) {
        this.P = i4;
    }

    public f.b C0(b.a aVar) {
        b.a aVar2;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        f.b bVar = this.f438p;
        if (bVar != null) {
            bVar.c();
        }
        g gVar = new g(aVar);
        androidx.appcompat.app.a k4 = k();
        if (k4 != null) {
            f.b v4 = k4.v(gVar);
            this.f438p = v4;
            if (v4 != null && (aVar2 = this.f431i) != null) {
                aVar2.j(v4);
            }
        }
        if (this.f438p == null) {
            this.f438p = D0(gVar);
        }
        return this.f438p;
    }

    @Override // androidx.appcompat.app.d
    public final void D(CharSequence charSequence) {
        this.f434l = charSequence;
        c0 c0Var = this.f435m;
        if (c0Var != null) {
            c0Var.setWindowTitle(charSequence);
            return;
        }
        if (v0() != null) {
            v0().u(charSequence);
            return;
        }
        TextView textView = this.f446x;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    f.b D0(f.b.a r8) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.e.D0(f.b$a):f.b");
    }

    public boolean E() {
        return F(true);
    }

    int I0(int i4) {
        boolean z4;
        boolean z5;
        ActionBarContextView actionBarContextView = this.f439q;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z4 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f439q.getLayoutParams();
            if (this.f439q.isShown()) {
                if (this.Y == null) {
                    this.Y = new Rect();
                    this.Z = new Rect();
                }
                Rect rect = this.Y;
                Rect rect2 = this.Z;
                rect.set(0, i4, 0, 0);
                c1.a(this.f445w, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i4 : 0)) {
                    marginLayoutParams.topMargin = i4;
                    View view = this.f447y;
                    if (view == null) {
                        View view2 = new View(this.f428f);
                        this.f447y = view2;
                        view2.setBackgroundColor(this.f428f.getResources().getColor(a.c.f27a));
                        this.f445w.addView(this.f447y, -1, new ViewGroup.LayoutParams(-1, i4));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i4) {
                            layoutParams.height = i4;
                            this.f447y.setLayoutParams(layoutParams);
                        }
                    }
                    z5 = true;
                } else {
                    z5 = false;
                }
                r3 = this.f447y != null;
                if (!this.D && r3) {
                    i4 = 0;
                }
                boolean z6 = r3;
                r3 = z5;
                z4 = z6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z4 = false;
            } else {
                z4 = false;
                r3 = false;
            }
            if (r3) {
                this.f439q.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.f447y;
        if (view3 != null) {
            view3.setVisibility(z4 ? 0 : 8);
        }
        return i4;
    }

    void J(int i4, m mVar, Menu menu) {
        if (menu == null) {
            if (mVar == null && i4 >= 0) {
                m[] mVarArr = this.H;
                if (i4 < mVarArr.length) {
                    mVar = mVarArr[i4];
                }
            }
            if (mVar != null) {
                menu = mVar.f477j;
            }
        }
        if ((mVar == null || mVar.f482o) && !this.N) {
            this.f430h.a().onPanelClosed(i4, menu);
        }
    }

    void K(androidx.appcompat.view.menu.e eVar) {
        if (this.G) {
            return;
        }
        this.G = true;
        this.f435m.l();
        Window.Callback c02 = c0();
        if (c02 != null && !this.N) {
            c02.onPanelClosed(108, eVar);
        }
        this.G = false;
    }

    void M(int i4) {
        N(a0(i4, true), true);
    }

    void N(m mVar, boolean z4) {
        ViewGroup viewGroup;
        c0 c0Var;
        if (z4 && mVar.f468a == 0 && (c0Var = this.f435m) != null && c0Var.c()) {
            K(mVar.f477j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f428f.getSystemService("window");
        if (windowManager != null && mVar.f482o && (viewGroup = mVar.f474g) != null) {
            windowManager.removeView(viewGroup);
            if (z4) {
                J(mVar.f468a, mVar, null);
            }
        }
        mVar.f480m = false;
        mVar.f481n = false;
        mVar.f482o = false;
        mVar.f475h = null;
        mVar.f484q = true;
        if (this.I == mVar) {
            this.I = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View P(View view, String str, Context context, AttributeSet attributeSet) {
        AppCompatViewInflater appCompatViewInflater;
        boolean z4 = false;
        if (this.f426a0 == null) {
            String string = this.f428f.obtainStyledAttributes(a.j.f259z0).getString(a.j.D0);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.f426a0 = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                }
            }
            this.f426a0 = appCompatViewInflater;
        }
        boolean z5 = f423c0;
        if (z5) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z4 = B0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z4 = true;
            }
        }
        return this.f426a0.q(view, str, context, attributeSet, z4, z5, true, b1.b());
    }

    void Q() {
        androidx.appcompat.view.menu.e eVar;
        c0 c0Var = this.f435m;
        if (c0Var != null) {
            c0Var.l();
        }
        if (this.f440r != null) {
            this.f429g.getDecorView().removeCallbacks(this.f441s);
            if (this.f440r.isShowing()) {
                try {
                    this.f440r.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f440r = null;
        }
        T();
        m a02 = a0(0, false);
        if (a02 == null || (eVar = a02.f477j) == null) {
            return;
        }
        eVar.close();
    }

    boolean R(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f427e;
        if (((obj instanceof d.a) || (obj instanceof b.b)) && (decorView = this.f429g.getDecorView()) != null && y.d.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f430h.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? m0(keyCode, keyEvent) : p0(keyCode, keyEvent);
    }

    void S(int i4) {
        m a02;
        m a03 = a0(i4, true);
        if (a03.f477j != null) {
            Bundle bundle = new Bundle();
            a03.f477j.Q(bundle);
            if (bundle.size() > 0) {
                a03.f486s = bundle;
            }
            a03.f477j.d0();
            a03.f477j.clear();
        }
        a03.f485r = true;
        a03.f484q = true;
        if ((i4 != 108 && i4 != 0) || this.f435m == null || (a02 = a0(0, false)) == null) {
            return;
        }
        a02.f480m = false;
        x0(a02, null);
    }

    void T() {
        t tVar = this.f442t;
        if (tVar != null) {
            tVar.b();
        }
    }

    m W(Menu menu) {
        m[] mVarArr = this.H;
        int length = mVarArr != null ? mVarArr.length : 0;
        for (int i4 = 0; i4 < length; i4++) {
            m mVar = mVarArr[i4];
            if (mVar != null && mVar.f477j == menu) {
                return mVar;
            }
        }
        return null;
    }

    final Context X() {
        androidx.appcompat.app.a k4 = k();
        Context k5 = k4 != null ? k4.k() : null;
        return k5 == null ? this.f428f : k5;
    }

    final j Z() {
        if (this.S == null) {
            this.S = new k(androidx.appcompat.app.h.a(this.f428f));
        }
        return this.S;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        m W;
        Window.Callback c02 = c0();
        if (c02 == null || this.N || (W = W(eVar.D())) == null) {
            return false;
        }
        return c02.onMenuItemSelected(W.f468a, menuItem);
    }

    protected m a0(int i4, boolean z4) {
        m[] mVarArr = this.H;
        if (mVarArr == null || mVarArr.length <= i4) {
            m[] mVarArr2 = new m[i4 + 1];
            if (mVarArr != null) {
                System.arraycopy(mVarArr, 0, mVarArr2, 0, mVarArr.length);
            }
            this.H = mVarArr2;
            mVarArr = mVarArr2;
        }
        m mVar = mVarArr[i4];
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(i4);
        mVarArr[i4] = mVar2;
        return mVar2;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        y0(eVar, true);
    }

    final CharSequence b0() {
        Object obj = this.f427e;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f434l;
    }

    @Override // androidx.appcompat.app.d
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        U();
        ((ViewGroup) this.f445w.findViewById(R.id.content)).addView(view, layoutParams);
        this.f430h.a().onContentChanged();
    }

    final Window.Callback c0() {
        return this.f429g.getCallback();
    }

    @Override // androidx.appcompat.app.d
    public void d(Context context) {
        F(false);
        this.K = true;
    }

    @Override // androidx.appcompat.app.d
    public <T extends View> T g(int i4) {
        U();
        return (T) this.f429g.findViewById(i4);
    }

    @Override // androidx.appcompat.app.d
    public int i() {
        return this.O;
    }

    @Override // androidx.appcompat.app.d
    public MenuInflater j() {
        if (this.f433k == null) {
            d0();
            androidx.appcompat.app.a aVar = this.f432j;
            this.f433k = new f.g(aVar != null ? aVar.k() : this.f428f);
        }
        return this.f433k;
    }

    public boolean j0() {
        return this.f443u;
    }

    @Override // androidx.appcompat.app.d
    public androidx.appcompat.app.a k() {
        d0();
        return this.f432j;
    }

    int k0(int i4) {
        j Z;
        if (i4 == -100) {
            return -1;
        }
        if (i4 != -1) {
            if (i4 != 0) {
                if (i4 != 1 && i4 != 2) {
                    if (i4 != 3) {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                    Z = Y();
                }
            } else {
                if (((UiModeManager) this.f428f.getSystemService(UiModeManager.class)).getNightMode() == 0) {
                    return -1;
                }
                Z = Z();
            }
            return Z.c();
        }
        return i4;
    }

    @Override // androidx.appcompat.app.d
    public void l() {
        LayoutInflater from = LayoutInflater.from(this.f428f);
        if (from.getFactory() == null) {
            y.e.a(from, this);
        } else {
            if (from.getFactory2() instanceof e) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    boolean l0() {
        f.b bVar = this.f438p;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a k4 = k();
        return k4 != null && k4.h();
    }

    @Override // androidx.appcompat.app.d
    public void m() {
        androidx.appcompat.app.a k4 = k();
        if (k4 == null || !k4.m()) {
            h0(0);
        }
    }

    boolean m0(int i4, KeyEvent keyEvent) {
        if (i4 == 4) {
            this.J = (keyEvent.getFlags() & 128) != 0;
        } else if (i4 == 82) {
            n0(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean o0(int i4, KeyEvent keyEvent) {
        androidx.appcompat.app.a k4 = k();
        if (k4 != null && k4.p(i4, keyEvent)) {
            return true;
        }
        m mVar = this.I;
        if (mVar != null && w0(mVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            m mVar2 = this.I;
            if (mVar2 != null) {
                mVar2.f481n = true;
            }
            return true;
        }
        if (this.I == null) {
            m a02 = a0(0, true);
            x0(a02, keyEvent);
            boolean w02 = w0(a02, keyEvent.getKeyCode(), keyEvent, 1);
            a02.f480m = false;
            if (w02) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return P(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.d
    public void p(Configuration configuration) {
        androidx.appcompat.app.a k4;
        if (this.B && this.f444v && (k4 = k()) != null) {
            k4.n(configuration);
        }
        androidx.appcompat.widget.j.b().g(this.f428f);
        F(false);
    }

    boolean p0(int i4, KeyEvent keyEvent) {
        if (i4 == 4) {
            boolean z4 = this.J;
            this.J = false;
            m a02 = a0(0, false);
            if (a02 != null && a02.f482o) {
                if (!z4) {
                    N(a02, true);
                }
                return true;
            }
            if (l0()) {
                return true;
            }
        } else if (i4 == 82) {
            q0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.d
    public void q(Bundle bundle) {
        this.K = true;
        F(false);
        V();
        Object obj = this.f427e;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = n.e.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                androidx.appcompat.app.a v02 = v0();
                if (v02 == null) {
                    this.X = true;
                } else {
                    v02.s(true);
                }
            }
        }
        this.L = true;
    }

    @Override // androidx.appcompat.app.d
    public void r() {
        androidx.appcompat.app.d.o(this);
        if (this.U) {
            this.f429g.getDecorView().removeCallbacks(this.W);
        }
        this.M = false;
        this.N = true;
        androidx.appcompat.app.a aVar = this.f432j;
        if (aVar != null) {
            aVar.o();
        }
        L();
    }

    void r0(int i4) {
        androidx.appcompat.app.a k4;
        if (i4 != 108 || (k4 = k()) == null) {
            return;
        }
        k4.i(true);
    }

    @Override // androidx.appcompat.app.d
    public void s(Bundle bundle) {
        U();
    }

    void s0(int i4) {
        if (i4 == 108) {
            androidx.appcompat.app.a k4 = k();
            if (k4 != null) {
                k4.i(false);
                return;
            }
            return;
        }
        if (i4 == 0) {
            m a02 = a0(i4, true);
            if (a02.f482o) {
                N(a02, false);
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public void t() {
        androidx.appcompat.app.a k4 = k();
        if (k4 != null) {
            k4.t(true);
        }
    }

    void t0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.d
    public void u(Bundle bundle) {
        if (this.O != -100) {
            f422b0.put(this.f427e.getClass(), Integer.valueOf(this.O));
        }
    }

    @Override // androidx.appcompat.app.d
    public void v() {
        this.M = true;
        E();
        androidx.appcompat.app.d.n(this);
    }

    final androidx.appcompat.app.a v0() {
        return this.f432j;
    }

    @Override // androidx.appcompat.app.d
    public void w() {
        this.M = false;
        androidx.appcompat.app.d.o(this);
        androidx.appcompat.app.a k4 = k();
        if (k4 != null) {
            k4.t(false);
        }
        if (this.f427e instanceof Dialog) {
            L();
        }
    }

    @Override // androidx.appcompat.app.d
    public boolean y(int i4) {
        int z02 = z0(i4);
        if (this.F && z02 == 108) {
            return false;
        }
        if (this.B && z02 == 1) {
            this.B = false;
        }
        if (z02 == 1) {
            E0();
            this.F = true;
            return true;
        }
        if (z02 == 2) {
            E0();
            this.f448z = true;
            return true;
        }
        if (z02 == 5) {
            E0();
            this.A = true;
            return true;
        }
        if (z02 == 10) {
            E0();
            this.D = true;
            return true;
        }
        if (z02 == 108) {
            E0();
            this.B = true;
            return true;
        }
        if (z02 != 109) {
            return this.f429g.requestFeature(z02);
        }
        E0();
        this.C = true;
        return true;
    }

    @Override // androidx.appcompat.app.d
    public void z(int i4) {
        U();
        ViewGroup viewGroup = (ViewGroup) this.f445w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f428f).inflate(i4, viewGroup);
        this.f430h.a().onContentChanged();
    }
}
