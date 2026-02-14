package k2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import k2.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: h, reason: collision with root package name */
    private static final Handler f4415h = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private final d f4416a;

    /* renamed from: b, reason: collision with root package name */
    private p f4417b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4418c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4419d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4420e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f4421f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f4422g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            k.this.g();
        }

        @Override // java.lang.Runnable
        @SuppressLint({"WrongConstant"})
        public void run() {
            WindowManager a5 = k.this.f4417b.a();
            if (a5 == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.flags = 152;
            layoutParams.packageName = k.this.f4418c;
            layoutParams.gravity = k.this.f4416a.d();
            layoutParams.x = k.this.f4416a.j();
            layoutParams.y = k.this.f4416a.k();
            layoutParams.verticalMargin = k.this.f4416a.h();
            layoutParams.horizontalMargin = k.this.f4416a.e();
            layoutParams.windowAnimations = k.this.f4416a.b();
            if (k.this.f4420e) {
                layoutParams.type = Build.VERSION.SDK_INT >= 26 ? 2038 : 2003;
            }
            try {
                a5.addView(k.this.f4416a.i(), layoutParams);
                k.f4415h.postDelayed(new Runnable() { // from class: k2.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.a.this.b();
                    }
                }, k.this.f4416a.c() == 1 ? k.this.f4416a.f() : k.this.f4416a.g());
                k.this.f4417b.b(k.this);
                k.this.j(true);
                k kVar = k.this;
                kVar.l(kVar.f4416a.i());
            } catch (WindowManager.BadTokenException | IllegalStateException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WindowManager a5;
            try {
                try {
                    a5 = k.this.f4417b.a();
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                }
                if (a5 == null) {
                    return;
                }
                a5.removeViewImmediate(k.this.f4416a.i());
            } finally {
                k.this.f4417b.c();
                k.this.j(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Activity activity, d dVar) {
        this((Context) activity, dVar);
        this.f4420e = false;
        this.f4417b = new p(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Application application, d dVar) {
        this((Context) application, dVar);
        this.f4420e = true;
        this.f4417b = new p(application);
    }

    private k(Context context, d dVar) {
        this.f4421f = new a();
        this.f4422g = new b();
        this.f4416a = dVar;
        this.f4418c = context.getPackageName();
    }

    private boolean h() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(View view) {
        Context context = view.getContext();
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(64);
            obtain.setClassName(Toast.class.getName());
            obtain.setPackageName(context.getPackageName());
            view.dispatchPopulateAccessibilityEvent(obtain);
            accessibilityManager.sendAccessibilityEvent(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (i()) {
            Handler handler = f4415h;
            handler.removeCallbacks(this.f4421f);
            if (h()) {
                this.f4422g.run();
            } else {
                handler.removeCallbacks(this.f4422g);
                handler.post(this.f4422g);
            }
        }
    }

    boolean i() {
        return this.f4419d;
    }

    void j(boolean z4) {
        this.f4419d = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (i()) {
            return;
        }
        if (h()) {
            this.f4421f.run();
            return;
        }
        Handler handler = f4415h;
        handler.removeCallbacks(this.f4421f);
        handler.post(this.f4421f);
    }
}
