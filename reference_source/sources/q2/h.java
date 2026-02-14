package q2;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import p2.r;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: n, reason: collision with root package name */
    private static final String f5573n = "h";

    /* renamed from: a, reason: collision with root package name */
    private Camera f5574a;

    /* renamed from: b, reason: collision with root package name */
    private Camera.CameraInfo f5575b;

    /* renamed from: c, reason: collision with root package name */
    private q2.a f5576c;

    /* renamed from: d, reason: collision with root package name */
    private l1.b f5577d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5578e;

    /* renamed from: f, reason: collision with root package name */
    private String f5579f;

    /* renamed from: h, reason: collision with root package name */
    private m f5581h;

    /* renamed from: i, reason: collision with root package name */
    private p2.q f5582i;

    /* renamed from: j, reason: collision with root package name */
    private p2.q f5583j;

    /* renamed from: l, reason: collision with root package name */
    private Context f5585l;

    /* renamed from: g, reason: collision with root package name */
    private i f5580g = new i();

    /* renamed from: k, reason: collision with root package name */
    private int f5584k = -1;

    /* renamed from: m, reason: collision with root package name */
    private final a f5586m = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements Camera.PreviewCallback {

        /* renamed from: b, reason: collision with root package name */
        private p f5587b;

        /* renamed from: c, reason: collision with root package name */
        private p2.q f5588c;

        public a() {
        }

        public void a(p pVar) {
            this.f5587b = pVar;
        }

        public void b(p2.q qVar) {
            this.f5588c = qVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Exception e4;
            p2.q qVar = this.f5588c;
            p pVar = this.f5587b;
            if (qVar == null || pVar == null) {
                Log.d(h.f5573n, "Got preview callback, but no handler or resolution available");
                if (pVar == null) {
                    return;
                } else {
                    e4 = new Exception("No resolution available");
                }
            } else {
                try {
                    if (bArr == null) {
                        throw new NullPointerException("No preview data received");
                    }
                    r rVar = new r(bArr, qVar.f5467b, qVar.f5468c, camera.getParameters().getPreviewFormat(), h.this.f());
                    if (h.this.f5575b.facing == 1) {
                        rVar.e(true);
                    }
                    pVar.b(rVar);
                    return;
                } catch (RuntimeException e5) {
                    e4 = e5;
                    Log.e(h.f5573n, "Camera preview failed", e4);
                }
            }
            pVar.a(e4);
        }
    }

    public h(Context context) {
        this.f5585l = context;
    }

    private int c() {
        int c5 = this.f5581h.c();
        int i4 = 0;
        if (c5 != 0) {
            if (c5 == 1) {
                i4 = 90;
            } else if (c5 == 2) {
                i4 = 180;
            } else if (c5 == 3) {
                i4 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f5575b;
        int i5 = cameraInfo.facing;
        int i6 = cameraInfo.orientation;
        int i7 = (i5 == 1 ? 360 - ((i6 + i4) % 360) : (i6 - i4) + 360) % 360;
        Log.i(f5573n, "Camera Display Orientation: " + i7);
        return i7;
    }

    private Camera.Parameters g() {
        Camera.Parameters parameters = this.f5574a.getParameters();
        String str = this.f5579f;
        if (str == null) {
            this.f5579f = parameters.flatten();
        } else {
            parameters.unflatten(str);
        }
        return parameters;
    }

    private static List<p2.q> i(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                new p2.q(previewSize.width, previewSize.height);
                arrayList.add(new p2.q(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Camera.Size size : supportedPreviewSizes) {
            arrayList.add(new p2.q(size.width, size.height));
        }
        return arrayList;
    }

    private void n(int i4) {
        this.f5574a.setDisplayOrientation(i4);
    }

    private void p(boolean z4) {
        Camera.Parameters g4 = g();
        if (g4 == null) {
            Log.w(f5573n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = f5573n;
        Log.i(str, "Initial camera parameters: " + g4.flatten());
        if (z4) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        c.g(g4, this.f5580g.a(), z4);
        if (!z4) {
            c.k(g4, false);
            if (this.f5580g.h()) {
                c.i(g4);
            }
            if (this.f5580g.e()) {
                c.c(g4);
            }
            if (this.f5580g.g()) {
                c.l(g4);
                c.h(g4);
                c.j(g4);
            }
        }
        List<p2.q> i4 = i(g4);
        if (i4.size() == 0) {
            this.f5582i = null;
        } else {
            p2.q a5 = this.f5581h.a(i4, j());
            this.f5582i = a5;
            g4.setPreviewSize(a5.f5467b, a5.f5468c);
        }
        if (Build.DEVICE.equals("glass-1")) {
            c.e(g4);
        }
        Log.i(str, "Final camera parameters: " + g4.flatten());
        this.f5574a.setParameters(g4);
    }

    private void r() {
        try {
            int c5 = c();
            this.f5584k = c5;
            n(c5);
        } catch (Exception unused) {
            Log.w(f5573n, "Failed to set rotation.");
        }
        try {
            p(false);
        } catch (Exception unused2) {
            try {
                p(true);
            } catch (Exception unused3) {
                Log.w(f5573n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f5574a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f5583j = this.f5582i;
        } else {
            this.f5583j = new p2.q(previewSize.width, previewSize.height);
        }
        this.f5586m.b(this.f5583j);
    }

    public void d() {
        Camera camera = this.f5574a;
        if (camera != null) {
            camera.release();
            this.f5574a = null;
        }
    }

    public void e() {
        if (this.f5574a == null) {
            throw new RuntimeException("Camera not open");
        }
        r();
    }

    public int f() {
        return this.f5584k;
    }

    public p2.q h() {
        if (this.f5583j == null) {
            return null;
        }
        return j() ? this.f5583j.b() : this.f5583j;
    }

    public boolean j() {
        int i4 = this.f5584k;
        if (i4 != -1) {
            return i4 % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean k() {
        String flashMode;
        Camera.Parameters parameters = this.f5574a.getParameters();
        if (parameters == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    public void l() {
        Camera b5 = m1.a.b(this.f5580g.b());
        this.f5574a = b5;
        if (b5 == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int a5 = m1.a.a(this.f5580g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f5575b = cameraInfo;
        Camera.getCameraInfo(a5, cameraInfo);
    }

    public void m(p pVar) {
        Camera camera = this.f5574a;
        if (camera == null || !this.f5578e) {
            return;
        }
        this.f5586m.a(pVar);
        camera.setOneShotPreviewCallback(this.f5586m);
    }

    public void o(i iVar) {
        this.f5580g = iVar;
    }

    public void q(m mVar) {
        this.f5581h = mVar;
    }

    public void s(j jVar) {
        jVar.a(this.f5574a);
    }

    public void t(boolean z4) {
        if (this.f5574a != null) {
            try {
                if (z4 != k()) {
                    q2.a aVar = this.f5576c;
                    if (aVar != null) {
                        aVar.j();
                    }
                    Camera.Parameters parameters = this.f5574a.getParameters();
                    c.k(parameters, z4);
                    if (this.f5580g.f()) {
                        c.d(parameters, z4);
                    }
                    this.f5574a.setParameters(parameters);
                    q2.a aVar2 = this.f5576c;
                    if (aVar2 != null) {
                        aVar2.i();
                    }
                }
            } catch (RuntimeException e4) {
                Log.e(f5573n, "Failed to set torch", e4);
            }
        }
    }

    public void u() {
        Camera camera = this.f5574a;
        if (camera == null || this.f5578e) {
            return;
        }
        camera.startPreview();
        this.f5578e = true;
        this.f5576c = new q2.a(this.f5574a, this.f5580g);
        l1.b bVar = new l1.b(this.f5585l, this, this.f5580g);
        this.f5577d = bVar;
        bVar.d();
    }

    public void v() {
        q2.a aVar = this.f5576c;
        if (aVar != null) {
            aVar.j();
            this.f5576c = null;
        }
        l1.b bVar = this.f5577d;
        if (bVar != null) {
            bVar.e();
            this.f5577d = null;
        }
        Camera camera = this.f5574a;
        if (camera == null || !this.f5578e) {
            return;
        }
        camera.stopPreview();
        this.f5586m.a(null);
        this.f5578e = false;
    }
}
