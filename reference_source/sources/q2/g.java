package q2;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import p2.s;

/* loaded from: classes.dex */
public class g {

    /* renamed from: n, reason: collision with root package name */
    private static final String f5555n = "g";

    /* renamed from: a, reason: collision with root package name */
    private k f5556a;

    /* renamed from: b, reason: collision with root package name */
    private j f5557b;

    /* renamed from: c, reason: collision with root package name */
    private h f5558c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f5559d;

    /* renamed from: e, reason: collision with root package name */
    private m f5560e;

    /* renamed from: h, reason: collision with root package name */
    private Handler f5563h;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5561f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5562g = true;

    /* renamed from: i, reason: collision with root package name */
    private i f5564i = new i();

    /* renamed from: j, reason: collision with root package name */
    private Runnable f5565j = new a();

    /* renamed from: k, reason: collision with root package name */
    private Runnable f5566k = new b();

    /* renamed from: l, reason: collision with root package name */
    private Runnable f5567l = new c();

    /* renamed from: m, reason: collision with root package name */
    private Runnable f5568m = new d();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(g.f5555n, "Opening camera");
                g.this.f5558c.l();
            } catch (Exception e4) {
                g.this.t(e4);
                Log.e(g.f5555n, "Failed to open camera", e4);
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(g.f5555n, "Configuring camera");
                g.this.f5558c.e();
                if (g.this.f5559d != null) {
                    g.this.f5559d.obtainMessage(l1.k.f4529j, g.this.o()).sendToTarget();
                }
            } catch (Exception e4) {
                g.this.t(e4);
                Log.e(g.f5555n, "Failed to configure camera", e4);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(g.f5555n, "Starting preview");
                g.this.f5558c.s(g.this.f5557b);
                g.this.f5558c.u();
            } catch (Exception e4) {
                g.this.t(e4);
                Log.e(g.f5555n, "Failed to start preview", e4);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(g.f5555n, "Closing camera");
                g.this.f5558c.v();
                g.this.f5558c.d();
            } catch (Exception e4) {
                Log.e(g.f5555n, "Failed to close camera", e4);
            }
            g.this.f5562g = true;
            g.this.f5559d.sendEmptyMessage(l1.k.f4522c);
            g.this.f5556a.b();
        }
    }

    public g(Context context) {
        s.a();
        this.f5556a = k.d();
        h hVar = new h(context);
        this.f5558c = hVar;
        hVar.o(this.f5564i);
        this.f5563h = new Handler();
    }

    private void C() {
        if (!this.f5561f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p2.q o() {
        return this.f5558c.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(p pVar) {
        this.f5558c.m(pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(final p pVar) {
        if (this.f5561f) {
            this.f5556a.c(new Runnable() { // from class: q2.d
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.q(pVar);
                }
            });
        } else {
            Log.d(f5555n, "Camera is closed, not requesting preview");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(boolean z4) {
        this.f5558c.t(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        Handler handler = this.f5559d;
        if (handler != null) {
            handler.obtainMessage(l1.k.f4523d, exc).sendToTarget();
        }
    }

    public void A(final boolean z4) {
        s.a();
        if (this.f5561f) {
            this.f5556a.c(new Runnable() { // from class: q2.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.s(z4);
                }
            });
        }
    }

    public void B() {
        s.a();
        C();
        this.f5556a.c(this.f5567l);
    }

    public void l() {
        s.a();
        if (this.f5561f) {
            this.f5556a.c(this.f5568m);
        } else {
            this.f5562g = true;
        }
        this.f5561f = false;
    }

    public void m() {
        s.a();
        C();
        this.f5556a.c(this.f5566k);
    }

    public m n() {
        return this.f5560e;
    }

    public boolean p() {
        return this.f5562g;
    }

    public void u() {
        s.a();
        this.f5561f = true;
        this.f5562g = false;
        this.f5556a.e(this.f5565j);
    }

    public void v(final p pVar) {
        this.f5563h.post(new Runnable() { // from class: q2.e
            @Override // java.lang.Runnable
            public final void run() {
                g.this.r(pVar);
            }
        });
    }

    public void w(i iVar) {
        if (this.f5561f) {
            return;
        }
        this.f5564i = iVar;
        this.f5558c.o(iVar);
    }

    public void x(m mVar) {
        this.f5560e = mVar;
        this.f5558c.q(mVar);
    }

    public void y(Handler handler) {
        this.f5559d = handler;
    }

    public void z(j jVar) {
        this.f5557b = jVar;
    }
}
