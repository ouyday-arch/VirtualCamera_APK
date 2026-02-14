package androidx.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.savedstate.SavedStateRegistry;
import n.d;

/* loaded from: classes.dex */
public class ComponentActivity extends d implements s, androidx.savedstate.b, c {

    /* renamed from: f, reason: collision with root package name */
    private r f313f;

    /* renamed from: h, reason: collision with root package name */
    private int f315h;

    /* renamed from: d, reason: collision with root package name */
    private final h f311d = new h(this);

    /* renamed from: e, reason: collision with root package name */
    private final androidx.savedstate.a f312e = androidx.savedstate.a.a(this);

    /* renamed from: g, reason: collision with root package name */
    private final OnBackPressedDispatcher f314g = new OnBackPressedDispatcher(new a());

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        Object f319a;

        /* renamed from: b, reason: collision with root package name */
        r f320b;

        b() {
        }
    }

    public ComponentActivity() {
        if (a() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        a().a(new e() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.e
            public void d(g gVar, d.a aVar) {
                if (aVar == d.a.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        a().a(new e() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.e
            public void d(g gVar, d.a aVar) {
                if (aVar != d.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.h().a();
            }
        });
    }

    @Override // n.d, androidx.lifecycle.g
    public androidx.lifecycle.d a() {
        return this.f311d;
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher c() {
        return this.f314g;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry d() {
        return this.f312e.b();
    }

    @Override // androidx.lifecycle.s
    public r h() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f313f == null) {
            b bVar = (b) getLastNonConfigurationInstance();
            if (bVar != null) {
                this.f313f = bVar.f320b;
            }
            if (this.f313f == null) {
                this.f313f = new r();
            }
        }
        return this.f313f;
    }

    @Deprecated
    public Object l() {
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f314g.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f312e.c(bundle);
        o.e(this);
        int i4 = this.f315h;
        if (i4 != 0) {
            setContentView(i4);
        }
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object l4 = l();
        r rVar = this.f313f;
        if (rVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            rVar = bVar.f320b;
        }
        if (rVar == null && l4 == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.f319a = l4;
        bVar2.f320b = rVar;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.d a5 = a();
        if (a5 instanceof h) {
            ((h) a5).p(d.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f312e.d(bundle);
    }
}
