package n2;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import n2.e;
import n2.f;

/* loaded from: classes.dex */
public class e<X extends e<?>> implements Runnable, f.a {

    /* renamed from: m, reason: collision with root package name */
    private static final Handler f5328m = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private Context f5329b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f5330c;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager f5331d;

    /* renamed from: e, reason: collision with root package name */
    private WindowManager.LayoutParams f5332e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5333f;

    /* renamed from: g, reason: collision with root package name */
    private int f5334g;

    /* renamed from: h, reason: collision with root package name */
    private n2.a f5335h;

    /* renamed from: i, reason: collision with root package name */
    private o2.d f5336i;

    /* renamed from: j, reason: collision with root package name */
    private b f5337j;

    /* renamed from: k, reason: collision with root package name */
    private f f5338k;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f5339l;

    /* loaded from: classes.dex */
    public interface a<V extends View> {
        void a(e<?> eVar, V v4);
    }

    /* loaded from: classes.dex */
    public interface b {
        default void a(e<?> eVar) {
        }

        default void b(e<?> eVar) {
        }

        default void c(e<?> eVar) {
        }
    }

    public e(Activity activity) {
        this((Context) activity);
        View decorView = activity.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        if ((attributes.flags & 1024) != 0 || (decorView.getSystemUiVisibility() & 4) != 0) {
            d(1024);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            B(attributes.layoutInDisplayCutoutMode);
        }
        int i4 = attributes.systemUiVisibility;
        if (i4 != 0) {
            G(i4);
        }
        if (decorView.getSystemUiVisibility() != 0) {
            this.f5330c.setSystemUiVisibility(decorView.getSystemUiVisibility());
        }
        this.f5335h = new n2.a(this, activity);
    }

    public e(Application application) {
        this((Context) application);
        I(Build.VERSION.SDK_INT >= 26 ? 2038 : 2003);
    }

    private e(Context context) {
        this.f5339l = new Runnable() { // from class: n2.b
            @Override // java.lang.Runnable
            public final void run() {
                e.this.L();
            }
        };
        this.f5329b = context;
        this.f5330c = new h(context);
        this.f5331d = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f5332e = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation.Toast;
        layoutParams.packageName = context.getPackageName();
        this.f5332e.flags = 40;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private X D(View view, a<? extends View> aVar) {
        s(16);
        view.setClickable(true);
        view.setOnClickListener(new g(this, aVar));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        o2.d dVar = this.f5336i;
        if (dVar != null) {
            dVar.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        o2.d dVar = this.f5336i;
        if (dVar != null) {
            dVar.n();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X A(int i4, Drawable drawable) {
        ((ImageView) f(i4)).setImageDrawable(drawable);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X B(int i4) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f5332e.layoutInDisplayCutoutMode = i4;
            p();
        }
        return this;
    }

    public X C(int i4, a<? extends View> aVar) {
        return D(f(i4), aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X E(boolean z4) {
        if (z4) {
            d(40);
        } else {
            s(40);
        }
        p();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X F(int i4) {
        this.f5332e.softInputMode = i4;
        s(8);
        p();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X G(int i4) {
        this.f5332e.systemUiVisibility = i4;
        p();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X H(int i4, CharSequence charSequence) {
        ((TextView) f(i4)).setText(charSequence);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X I(int i4) {
        this.f5332e.type = i4;
        p();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X J(int i4) {
        this.f5332e.y = i4;
        p();
        m(new Runnable() { // from class: n2.c
            @Override // java.lang.Runnable
            public final void run() {
                e.this.l();
            }
        });
        return this;
    }

    public void K() {
        if (this.f5330c.getChildCount() == 0 || this.f5332e == null) {
            throw new IllegalArgumentException("WindowParams and view cannot be empty");
        }
        if (this.f5333f) {
            L();
            return;
        }
        Context context = this.f5329b;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        try {
            if (this.f5330c.getParent() != null) {
                this.f5331d.removeViewImmediate(this.f5330c);
            }
            this.f5331d.addView(this.f5330c, this.f5332e);
            this.f5333f = true;
            if (this.f5334g != 0) {
                r(this);
                o(this, this.f5334g);
            }
            o2.d dVar = this.f5336i;
            if (dVar != null) {
                dVar.o(this);
            }
            n2.a aVar = this.f5335h;
            if (aVar != null) {
                aVar.a();
            }
            b bVar = this.f5337j;
            if (bVar != null) {
                bVar.b(this);
            }
        } catch (WindowManager.BadTokenException | IllegalArgumentException | IllegalStateException | NullPointerException e4) {
            e4.printStackTrace();
        }
    }

    public void L() {
        if (j()) {
            try {
                this.f5331d.updateViewLayout(this.f5330c, this.f5332e);
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // n2.f.a
    public void a(int i4) {
        o2.d dVar;
        if (j() && (dVar = this.f5336i) != null) {
            dVar.m();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X d(int i4) {
        WindowManager.LayoutParams layoutParams = this.f5332e;
        layoutParams.flags = i4 | layoutParams.flags;
        p();
        return this;
    }

    public void e() {
        if (this.f5333f) {
            try {
                try {
                    n2.a aVar = this.f5335h;
                    if (aVar != null) {
                        aVar.b();
                    }
                    this.f5331d.removeViewImmediate(this.f5330c);
                    r(this);
                    b bVar = this.f5337j;
                    if (bVar != null) {
                        bVar.a(this);
                    }
                } finally {
                    this.f5333f = false;
                }
            } catch (IllegalArgumentException | IllegalStateException | NullPointerException e4) {
                e4.printStackTrace();
            }
        }
    }

    public <V extends View> V f(int i4) {
        return (V) this.f5330c.findViewById(i4);
    }

    public Context g() {
        return this.f5329b;
    }

    public View h() {
        return this.f5330c;
    }

    public WindowManager.LayoutParams i() {
        return this.f5332e;
    }

    public boolean j() {
        return this.f5333f;
    }

    public boolean m(Runnable runnable) {
        return o(runnable, 0L);
    }

    public boolean n(Runnable runnable, long j4) {
        return f5328m.postAtTime(runnable, this, j4);
    }

    public boolean o(Runnable runnable, long j4) {
        if (j4 < 0) {
            j4 = 0;
        }
        return n(runnable, SystemClock.uptimeMillis() + j4);
    }

    public void p() {
        if (j()) {
            r(this.f5339l);
            m(this.f5339l);
        }
    }

    public void q() {
        if (j()) {
            e();
        }
        f fVar = this.f5338k;
        if (fVar != null) {
            fVar.b(this.f5329b);
        }
        b bVar = this.f5337j;
        if (bVar != null) {
            bVar.c(this);
        }
        this.f5337j = null;
        this.f5329b = null;
        this.f5330c = null;
        this.f5331d = null;
        this.f5332e = null;
        this.f5335h = null;
        this.f5336i = null;
    }

    public void r(Runnable runnable) {
        f5328m.removeCallbacks(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X s(int i4) {
        WindowManager.LayoutParams layoutParams = this.f5332e;
        layoutParams.flags = (~i4) & layoutParams.flags;
        p();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X t(float f4) {
        if (f4 < 0.0f || f4 > 1.0f) {
            throw new IllegalArgumentException("amount must be a value between 0 and 1");
        }
        this.f5332e.dimAmount = f4;
        if (f4 != 0.0f) {
            d(2);
        } else {
            s(2);
        }
        p();
        return this;
    }

    public X u(int i4) {
        return v(LayoutInflater.from(this.f5329b).inflate(i4, this.f5330c, false));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
    
        r0.gravity = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public X v(android.view.View r5) {
        /*
            r4 = this;
            android.view.ViewGroup r0 = r4.f5330c
            int r0 = r0.getChildCount()
            if (r0 <= 0) goto Ld
            android.view.ViewGroup r0 = r4.f5330c
            r0.removeAllViews()
        Ld:
            android.view.ViewGroup r0 = r4.f5330c
            r0.addView(r5)
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            boolean r0 = r5 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r0 == 0) goto L26
            r0 = r5
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            r1 = 0
            r0.topMargin = r1
            r0.bottomMargin = r1
            r0.leftMargin = r1
            r0.rightMargin = r1
        L26:
            android.view.WindowManager$LayoutParams r0 = r4.f5332e
            int r1 = r0.gravity
            if (r1 != 0) goto L4e
            boolean r1 = r5 instanceof android.widget.FrameLayout.LayoutParams
            r2 = -1
            if (r1 == 0) goto L39
            r1 = r5
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            int r1 = r1.gravity
            if (r1 == r2) goto L46
            goto L44
        L39:
            boolean r1 = r5 instanceof android.widget.LinearLayout.LayoutParams
            if (r1 == 0) goto L46
            r1 = r5
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            int r1 = r1.gravity
            if (r1 == r2) goto L46
        L44:
            r0.gravity = r1
        L46:
            int r1 = r0.gravity
            if (r1 != 0) goto L4e
            r1 = 17
            r0.gravity = r1
        L4e:
            if (r5 == 0) goto L68
            int r1 = r0.width
            r2 = -2
            if (r1 != r2) goto L62
            int r3 = r0.height
            if (r3 != r2) goto L62
            int r1 = r5.width
            r0.width = r1
            int r5 = r5.height
            r0.height = r5
            goto L68
        L62:
            r5.width = r1
            int r0 = r0.height
            r5.height = r0
        L68:
            r4.p()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.e.v(android.view.View):n2.e");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X w(o2.d dVar) {
        this.f5336i = dVar;
        if (dVar != null) {
            s(16);
            s(512);
            if (j()) {
                L();
                dVar.o(this);
            }
        }
        if (this.f5338k == null) {
            this.f5338k = new f(this.f5329b.getResources().getConfiguration());
        }
        this.f5338k.a(this.f5329b, this);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X x(int i4) {
        this.f5334g = i4;
        if (j() && this.f5334g != 0) {
            r(this);
            o(this, this.f5334g);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X y(int i4) {
        this.f5332e.gravity = i4;
        p();
        m(new Runnable() { // from class: n2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.k();
            }
        });
        return this;
    }

    public X z(int i4, int i5) {
        return A(i4, this.f5329b.getDrawable(i5));
    }
}
