package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import n.a;

/* loaded from: classes.dex */
public class d extends ComponentActivity implements a.b {

    /* renamed from: k, reason: collision with root package name */
    boolean f1486k;

    /* renamed from: l, reason: collision with root package name */
    boolean f1487l;

    /* renamed from: n, reason: collision with root package name */
    boolean f1489n;

    /* renamed from: o, reason: collision with root package name */
    boolean f1490o;

    /* renamed from: p, reason: collision with root package name */
    boolean f1491p;

    /* renamed from: q, reason: collision with root package name */
    int f1492q;

    /* renamed from: r, reason: collision with root package name */
    k.h<String> f1493r;

    /* renamed from: i, reason: collision with root package name */
    final f f1484i = f.b(new a());

    /* renamed from: j, reason: collision with root package name */
    final androidx.lifecycle.h f1485j = new androidx.lifecycle.h(this);

    /* renamed from: m, reason: collision with root package name */
    boolean f1488m = true;

    /* loaded from: classes.dex */
    class a extends h<d> implements androidx.lifecycle.s, androidx.activity.c {
        public a() {
            super(d.this);
        }

        @Override // androidx.lifecycle.g
        public androidx.lifecycle.d a() {
            return d.this.f1485j;
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher c() {
            return d.this.c();
        }

        @Override // androidx.fragment.app.h, androidx.fragment.app.e
        public View e(int i4) {
            return d.this.findViewById(i4);
        }

        @Override // androidx.fragment.app.h, androidx.fragment.app.e
        public boolean f() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.lifecycle.s
        public androidx.lifecycle.r h() {
            return d.this.h();
        }

        @Override // androidx.fragment.app.h
        public void k(Fragment fragment) {
            d.this.s(fragment);
        }

        @Override // androidx.fragment.app.h
        public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            d.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.h
        public LayoutInflater n() {
            return d.this.getLayoutInflater().cloneInContext(d.this);
        }

        @Override // androidx.fragment.app.h
        public int o() {
            Window window = d.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.h
        public boolean p() {
            return d.this.getWindow() != null;
        }

        @Override // androidx.fragment.app.h
        public void q(Fragment fragment, String[] strArr, int i4) {
            d.this.v(fragment, strArr, i4);
        }

        @Override // androidx.fragment.app.h
        public boolean r(Fragment fragment) {
            return !d.this.isFinishing();
        }

        @Override // androidx.fragment.app.h
        public boolean s(String str) {
            return n.a.i(d.this, str);
        }

        @Override // androidx.fragment.app.h
        public void t() {
            d.this.w();
        }

        @Override // androidx.fragment.app.h
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public d m() {
            return d.this;
        }
    }

    private int m(Fragment fragment) {
        if (this.f1493r.m() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.f1493r.g(this.f1492q) >= 0) {
            this.f1492q = (this.f1492q + 1) % 65534;
        }
        int i4 = this.f1492q;
        this.f1493r.k(i4, fragment.f1413f);
        this.f1492q = (this.f1492q + 1) % 65534;
        return i4;
    }

    static void n(int i4) {
        if ((i4 & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void q() {
        do {
        } while (r(p(), d.b.CREATED));
    }

    private static boolean r(i iVar, d.b bVar) {
        boolean z4 = false;
        for (Fragment fragment : iVar.d()) {
            if (fragment != null) {
                if (fragment.a().b().a(d.b.STARTED)) {
                    fragment.T.p(bVar);
                    z4 = true;
                }
                if (fragment.v() != null) {
                    z4 |= r(fragment.o(), bVar);
                }
            }
        }
        return z4;
    }

    @Override // n.a.b
    public final void b(int i4) {
        if (this.f1489n || i4 == -1) {
            return;
        }
        n(i4);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f1486k);
        printWriter.print(" mResumed=");
        printWriter.print(this.f1487l);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1488m);
        if (getApplication() != null) {
            androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f1484i.u().b(str, fileDescriptor, printWriter, strArr);
    }

    final View o(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1484i.w(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i4, int i5, Intent intent) {
        this.f1484i.v();
        int i6 = i4 >> 16;
        if (i6 == 0) {
            a.InterfaceC0060a f4 = n.a.f();
            if (f4 == null || !f4.b(this, i4, i5, intent)) {
                super.onActivityResult(i4, i5, intent);
                return;
            }
            return;
        }
        int i7 = i6 - 1;
        String e4 = this.f1493r.e(i7);
        this.f1493r.l(i7);
        if (e4 == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        Fragment t4 = this.f1484i.t(e4);
        if (t4 != null) {
            t4.U(i4 & 65535, i5, intent);
            return;
        }
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + e4);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1484i.v();
        this.f1484i.d(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, n.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f1484i.a(null);
        if (bundle != null) {
            this.f1484i.x(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f1492q = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f1493r = new k.h<>(intArray.length);
                    for (int i4 = 0; i4 < intArray.length; i4++) {
                        this.f1493r.k(intArray[i4], stringArray[i4]);
                    }
                }
            }
        }
        if (this.f1493r == null) {
            this.f1493r = new k.h<>();
            this.f1492q = 0;
        }
        super.onCreate(bundle);
        this.f1485j.i(d.a.ON_CREATE);
        this.f1484i.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i4, Menu menu) {
        return i4 == 0 ? super.onCreatePanelMenu(i4, menu) | this.f1484i.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i4, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View o4 = o(view, str, context, attributeSet);
        return o4 == null ? super.onCreateView(view, str, context, attributeSet) : o4;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View o4 = o(null, str, context, attributeSet);
        return o4 == null ? super.onCreateView(str, context, attributeSet) : o4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1484i.h();
        this.f1485j.i(d.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f1484i.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        if (i4 == 0) {
            return this.f1484i.k(menuItem);
        }
        if (i4 != 6) {
            return false;
        }
        return this.f1484i.e(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4) {
        this.f1484i.j(z4);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.f1484i.v();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i4, Menu menu) {
        if (i4 == 0) {
            this.f1484i.l(menu);
        }
        super.onPanelClosed(i4, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f1487l = false;
        this.f1484i.m();
        this.f1485j.i(d.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z4) {
        this.f1484i.n(z4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        u();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i4, View view, Menu menu) {
        return i4 == 0 ? t(view, menu) | this.f1484i.o(menu) : super.onPreparePanel(i4, view, menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        this.f1484i.v();
        int i5 = (i4 >> 16) & 65535;
        if (i5 != 0) {
            int i6 = i5 - 1;
            String e4 = this.f1493r.e(i6);
            this.f1493r.l(i6);
            if (e4 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment t4 = this.f1484i.t(e4);
            if (t4 != null) {
                t4.t0(i4 & 65535, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + e4);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f1487l = true;
        this.f1484i.v();
        this.f1484i.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, n.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        q();
        this.f1485j.i(d.a.ON_STOP);
        Parcelable y4 = this.f1484i.y();
        if (y4 != null) {
            bundle.putParcelable("android:support:fragments", y4);
        }
        if (this.f1493r.m() > 0) {
            bundle.putInt("android:support:next_request_index", this.f1492q);
            int[] iArr = new int[this.f1493r.m()];
            String[] strArr = new String[this.f1493r.m()];
            for (int i4 = 0; i4 < this.f1493r.m(); i4++) {
                iArr[i4] = this.f1493r.j(i4);
                strArr[i4] = this.f1493r.n(i4);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f1488m = false;
        if (!this.f1486k) {
            this.f1486k = true;
            this.f1484i.c();
        }
        this.f1484i.v();
        this.f1484i.s();
        this.f1485j.i(d.a.ON_START);
        this.f1484i.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f1484i.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f1488m = true;
        q();
        this.f1484i.r();
        this.f1485j.i(d.a.ON_STOP);
    }

    public i p() {
        return this.f1484i.u();
    }

    public void s(Fragment fragment) {
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i4) {
        if (!this.f1491p && i4 != -1) {
            n(i4);
        }
        super.startActivityForResult(intent, i4);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i4, Bundle bundle) {
        if (!this.f1491p && i4 != -1) {
            n(i4);
        }
        super.startActivityForResult(intent, i4, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7) {
        if (!this.f1490o && i4 != -1) {
            n(i4);
        }
        super.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7, Bundle bundle) {
        if (!this.f1490o && i4 != -1) {
            n(i4);
        }
        super.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
    }

    @Deprecated
    protected boolean t(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    protected void u() {
        this.f1485j.i(d.a.ON_RESUME);
        this.f1484i.p();
    }

    void v(Fragment fragment, String[] strArr, int i4) {
        if (i4 == -1) {
            n.a.h(this, strArr, i4);
            return;
        }
        n(i4);
        try {
            this.f1489n = true;
            n.a.h(this, strArr, ((m(fragment) + 1) << 16) + (i4 & 65535));
        } finally {
            this.f1489n = false;
        }
    }

    @Deprecated
    public void w() {
        invalidateOptionsMenu();
    }
}
