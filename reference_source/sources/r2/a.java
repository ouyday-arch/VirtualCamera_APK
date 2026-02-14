package r2;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.nvshen.chmp4.AutoFitTextureView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import r2.a;

/* loaded from: classes.dex */
public class a extends Fragment implements View.OnClickListener {

    /* renamed from: r0, reason: collision with root package name */
    private static final SparseIntArray f5787r0;

    /* renamed from: a0, reason: collision with root package name */
    private String f5788a0;

    /* renamed from: b0, reason: collision with root package name */
    private AutoFitTextureView f5789b0;

    /* renamed from: c0, reason: collision with root package name */
    private CameraCaptureSession f5790c0;

    /* renamed from: d0, reason: collision with root package name */
    private CameraDevice f5791d0;

    /* renamed from: e0, reason: collision with root package name */
    private Size f5792e0;

    /* renamed from: g0, reason: collision with root package name */
    private HandlerThread f5794g0;

    /* renamed from: h0, reason: collision with root package name */
    private Handler f5795h0;

    /* renamed from: i0, reason: collision with root package name */
    private ImageReader f5796i0;

    /* renamed from: k0, reason: collision with root package name */
    private CaptureRequest.Builder f5798k0;

    /* renamed from: l0, reason: collision with root package name */
    private CaptureRequest f5799l0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f5802o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f5803p0;
    private final TextureView.SurfaceTextureListener Z = new TextureViewSurfaceTextureListenerC0073a();

    /* renamed from: f0, reason: collision with root package name */
    private final CameraDevice.StateCallback f5793f0 = new b();

    /* renamed from: j0, reason: collision with root package name */
    private final ImageReader.OnImageAvailableListener f5797j0 = new c();

    /* renamed from: m0, reason: collision with root package name */
    private int f5800m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    private Semaphore f5801n0 = new Semaphore(1);

    /* renamed from: q0, reason: collision with root package name */
    private CameraCaptureSession.CaptureCallback f5804q0 = new d();

    /* renamed from: r2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class TextureViewSurfaceTextureListenerC0073a implements TextureView.SurfaceTextureListener {
        TextureViewSurfaceTextureListenerC0073a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
            a.this.P1(i4, i5);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
            a.this.L1(i4, i5);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* loaded from: classes.dex */
    class b extends CameraDevice.StateCallback {
        b() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            a.this.f5801n0.release();
            cameraDevice.close();
            a.this.f5791d0 = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i4) {
            a.this.f5801n0.release();
            cameraDevice.close();
            a.this.f5791d0 = null;
            androidx.fragment.app.d i5 = a.this.i();
            if (i5 != null) {
                i5.finish();
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            a.this.f5801n0.release();
            a.this.f5791d0 = cameraDevice;
            a.this.M1();
        }
    }

    /* loaded from: classes.dex */
    class c implements ImageReader.OnImageAvailableListener {
        c() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            a.this.f5795h0.post(new k(imageReader.acquireNextImage(), a.this.i()));
        }
    }

    /* loaded from: classes.dex */
    class d extends CameraCaptureSession.CaptureCallback {
        d() {
        }

        private void a(CaptureResult captureResult) {
            int i4 = a.this.f5800m0;
            if (i4 == 1) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num != null) {
                    if (4 != num.intValue() && 5 != num.intValue()) {
                        return;
                    }
                    Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num2 != null && num2.intValue() != 2) {
                        a.this.R1();
                        return;
                    }
                }
                a.this.I1();
            }
            if (i4 == 2) {
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num3 == null || num3.intValue() == 5 || num3.intValue() == 4) {
                    a.this.f5800m0 = 3;
                    return;
                }
                return;
            }
            if (i4 != 3) {
                return;
            }
            Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
            if (num4 != null && num4.intValue() == 5) {
                return;
            }
            a.this.f5800m0 = 4;
            a.this.I1();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a(totalCaptureResult);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            a(captureResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f5809b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f5810c;

        e(Activity activity, String str) {
            this.f5809b = activity;
            this.f5810c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(this.f5809b, this.f5810c, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends CameraCaptureSession.StateCallback {
        f() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            a.this.U1("Failed");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            if (a.this.f5791d0 == null) {
                return;
            }
            a.this.f5790c0 = cameraCaptureSession;
            try {
                a.this.f5798k0.set(CaptureRequest.CONTROL_AF_MODE, 4);
                a aVar = a.this;
                aVar.S1(aVar.f5798k0);
                a aVar2 = a.this;
                aVar2.f5799l0 = aVar2.f5798k0.build();
                a.this.f5790c0.setRepeatingRequest(a.this.f5799l0, a.this.f5804q0, a.this.f5795h0);
            } catch (CameraAccessException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f5813a;

        g(Activity activity) {
            this.f5813a = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Activity activity) {
            com.nvshen.chmp4.d.B().a0();
            String u4 = com.nvshen.chmp4.d.B().u("pic");
            Log.d("Camera2BasicFragment", "CaptureCallback url = " + u4);
            if (u4 == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addFlags(268435459);
            intent.setDataAndType(Uri.parse(u4), "image/jpeg");
            activity.startActivity(intent);
            Log.d("Camera2BasicFragment", "url = " + u4);
            com.nvshen.chmp4.d.B().a0();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a.this.Y1();
            Handler handler = new Handler();
            final Activity activity = this.f5813a;
            handler.postDelayed(new Runnable() { // from class: r2.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.g.b(activity);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h implements Comparator<Size> {
        h() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Size size, Size size2) {
            return Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        }
    }

    /* loaded from: classes.dex */
    public static class i extends androidx.fragment.app.c {

        /* renamed from: r2.a$i$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class DialogInterfaceOnClickListenerC0074a implements DialogInterface.OnClickListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Fragment f5815b;

            DialogInterfaceOnClickListenerC0074a(Fragment fragment) {
                this.f5815b = fragment;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                androidx.fragment.app.d i5 = this.f5815b.i();
                if (i5 != null) {
                    i5.finish();
                }
            }
        }

        /* loaded from: classes.dex */
        class b implements DialogInterface.OnClickListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Fragment f5817b;

            b(Fragment fragment) {
                this.f5817b = fragment;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                this.f5817b.X0(new String[]{"android.permission.CAMERA"}, 1);
            }
        }

        @Override // androidx.fragment.app.c
        public Dialog p1(Bundle bundle) {
            Fragment A = A();
            return new AlertDialog.Builder(i()).setMessage("R.string.request_permission").setPositiveButton(R.string.ok, new b(A)).setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC0074a(A)).create();
        }
    }

    /* loaded from: classes.dex */
    public static class j extends androidx.fragment.app.c {

        /* renamed from: r2.a$j$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class DialogInterfaceOnClickListenerC0075a implements DialogInterface.OnClickListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Activity f5819b;

            DialogInterfaceOnClickListenerC0075a(Activity activity) {
                this.f5819b = activity;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                this.f5819b.finish();
            }
        }

        public static j s1(String str) {
            j jVar = new j();
            Bundle bundle = new Bundle();
            bundle.putString("message", str);
            jVar.g1(bundle);
            return jVar;
        }

        @Override // androidx.fragment.app.c
        public Dialog p1(Bundle bundle) {
            androidx.fragment.app.d i4 = i();
            return new AlertDialog.Builder(i4).setMessage(n().getString("message")).setPositiveButton(R.string.ok, new DialogInterfaceOnClickListenerC0075a(i4)).create();
        }
    }

    /* loaded from: classes.dex */
    private static class k implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final Image f5821b;

        /* renamed from: c, reason: collision with root package name */
        private Activity f5822c;

        k(Image image, Activity activity) {
            this.f5821b = image;
            this.f5822c = activity;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:54:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r1v18 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String a(android.content.Context r5, java.lang.String r6, java.nio.ByteBuffer r7) {
            /*
                Method dump skipped, instructions count: 221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: r2.a.k.a(android.content.Context, java.lang.String, java.nio.ByteBuffer):java.lang.String");
        }

        @Override // java.lang.Runnable
        public void run() {
            String a5 = a(this.f5822c, String.format("pic_%d.jpg", Long.valueOf(System.currentTimeMillis())), this.f5821b.getPlanes()[0].getBuffer());
            com.nvshen.chmp4.d.B().h("pic", a5);
            Log.d("Camera2BasicFragment", "save pic : " + a5);
            this.f5821b.close();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5787r0 = sparseIntArray;
        sparseIntArray.append(0, 90);
        sparseIntArray.append(1, 0);
        sparseIntArray.append(2, 270);
        sparseIntArray.append(3, 180);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1() {
        CameraDevice cameraDevice;
        try {
            androidx.fragment.app.d i4 = i();
            if (i4 != null && (cameraDevice = this.f5791d0) != null) {
                CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(2);
                createCaptureRequest.addTarget(this.f5796i0.getSurface());
                createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 4);
                S1(createCaptureRequest);
                createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(N1(i4.getWindowManager().getDefaultDisplay().getRotation())));
                g gVar = new g(i4);
                this.f5790c0.stopRepeating();
                this.f5790c0.abortCaptures();
                this.f5790c0.capture(createCaptureRequest.build(), gVar, null);
            }
        } catch (CameraAccessException e4) {
            e4.printStackTrace();
        }
    }

    private static Size J1(Size[] sizeArr, int i4, int i5, int i6, int i7, Size size) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int width = size.getWidth();
        int height = size.getHeight();
        for (Size size2 : sizeArr) {
            if (size2.getWidth() <= i6 && size2.getHeight() <= i7 && size2.getHeight() == (size2.getWidth() * height) / width) {
                if (size2.getWidth() < i4 || size2.getHeight() < i5) {
                    arrayList2.add(size2);
                } else {
                    arrayList.add(size2);
                }
            }
        }
        if (arrayList.size() > 0) {
            return (Size) Collections.min(arrayList, new h());
        }
        if (arrayList2.size() > 0) {
            return (Size) Collections.max(arrayList2, new h());
        }
        Log.e("Camera2BasicFragment", "Couldn't find any suitable preview size");
        return sizeArr[0];
    }

    private void K1() {
        try {
            try {
                this.f5801n0.acquire();
                CameraCaptureSession cameraCaptureSession = this.f5790c0;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                    this.f5790c0 = null;
                }
                CameraDevice cameraDevice = this.f5791d0;
                if (cameraDevice != null) {
                    cameraDevice.close();
                    this.f5791d0 = null;
                }
                ImageReader imageReader = this.f5796i0;
                if (imageReader != null) {
                    imageReader.close();
                    this.f5796i0 = null;
                }
            } catch (InterruptedException e4) {
                throw new RuntimeException("Interrupted while trying to lock camera closing.", e4);
            }
        } finally {
            this.f5801n0.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1(int i4, int i5) {
        float f4;
        androidx.fragment.app.d i6 = i();
        if (this.f5789b0 == null || this.f5792e0 == null || i6 == null) {
            return;
        }
        int rotation = i6.getWindowManager().getDefaultDisplay().getRotation();
        Matrix matrix = new Matrix();
        float f5 = i4;
        float f6 = i5;
        RectF rectF = new RectF(0.0f, 0.0f, f5, f6);
        RectF rectF2 = new RectF(0.0f, 0.0f, this.f5792e0.getHeight(), this.f5792e0.getWidth());
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        if (1 != rotation && 3 != rotation) {
            if (2 == rotation) {
                f4 = 180.0f;
            }
            this.f5789b0.setTransform(matrix);
        } else {
            rectF2.offset(centerX - rectF2.centerX(), centerY - rectF2.centerY());
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            float max = Math.max(f6 / this.f5792e0.getHeight(), f5 / this.f5792e0.getWidth());
            matrix.postScale(max, max, centerX, centerY);
            f4 = (rotation - 2) * 90;
        }
        matrix.postRotate(f4, centerX, centerY);
        this.f5789b0.setTransform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M1() {
        try {
            SurfaceTexture surfaceTexture = this.f5789b0.getSurfaceTexture();
            surfaceTexture.setDefaultBufferSize(this.f5792e0.getWidth(), this.f5792e0.getHeight());
            Surface surface = new Surface(surfaceTexture);
            CaptureRequest.Builder createCaptureRequest = this.f5791d0.createCaptureRequest(1);
            this.f5798k0 = createCaptureRequest;
            createCaptureRequest.addTarget(surface);
            this.f5791d0.createCaptureSession(Arrays.asList(surface, this.f5796i0.getSurface()), new f(), null);
        } catch (CameraAccessException e4) {
            e4.printStackTrace();
        }
    }

    private int N1(int i4) {
        return ((f5787r0.get(i4) + this.f5803p0) + 270) % 360;
    }

    private void O1() {
        try {
            this.f5798k0.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            this.f5800m0 = 1;
            this.f5790c0.capture(this.f5798k0.build(), this.f5804q0, this.f5795h0);
        } catch (CameraAccessException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1(int i4, int i5) {
        if (o.a.a(i(), "android.permission.CAMERA") != 0) {
            Q1();
            return;
        }
        T1(i4, i5);
        L1(i4, i5);
        CameraManager cameraManager = (CameraManager) i().getSystemService("camera");
        try {
            if (!this.f5801n0.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                throw new RuntimeException("Time out waiting to lock camera opening.");
            }
            cameraManager.openCamera(this.f5788a0, this.f5793f0, this.f5795h0);
        } catch (CameraAccessException e4) {
            e4.printStackTrace();
        } catch (InterruptedException e5) {
            throw new RuntimeException("Interrupted while trying to lock camera opening.", e5);
        }
    }

    private void Q1() {
        if (m1("android.permission.CAMERA")) {
            new i().r1(o(), "dialog");
        } else {
            X0(new String[]{"android.permission.CAMERA"}, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1() {
        try {
            this.f5798k0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            this.f5800m0 = 2;
            this.f5790c0.capture(this.f5798k0.build(), this.f5804q0, this.f5795h0);
        } catch (CameraAccessException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1(CaptureRequest.Builder builder) {
        if (this.f5802o0) {
            builder.set(CaptureRequest.CONTROL_AE_MODE, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0105 A[Catch: NullPointerException -> 0x013a, CameraAccessException -> 0x014a, TryCatch #2 {CameraAccessException -> 0x014a, NullPointerException -> 0x013a, blocks: (B:3:0x000e, B:5:0x0017, B:7:0x002f, B:11:0x0040, B:12:0x0036, B:15:0x0043, B:21:0x0093, B:23:0x00bb, B:32:0x00ed, B:34:0x0105, B:35:0x0113, B:36:0x0126, B:39:0x0135, B:43:0x0131, B:44:0x0117), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0131 A[Catch: NullPointerException -> 0x013a, CameraAccessException -> 0x014a, TryCatch #2 {CameraAccessException -> 0x014a, NullPointerException -> 0x013a, blocks: (B:3:0x000e, B:5:0x0017, B:7:0x002f, B:11:0x0040, B:12:0x0036, B:15:0x0043, B:21:0x0093, B:23:0x00bb, B:32:0x00ed, B:34:0x0105, B:35:0x0113, B:36:0x0126, B:39:0x0135, B:43:0x0131, B:44:0x0117), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0117 A[Catch: NullPointerException -> 0x013a, CameraAccessException -> 0x014a, TryCatch #2 {CameraAccessException -> 0x014a, NullPointerException -> 0x013a, blocks: (B:3:0x000e, B:5:0x0017, B:7:0x002f, B:11:0x0040, B:12:0x0036, B:15:0x0043, B:21:0x0093, B:23:0x00bb, B:32:0x00ed, B:34:0x0105, B:35:0x0113, B:36:0x0126, B:39:0x0135, B:43:0x0131, B:44:0x0117), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void T1(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.a.T1(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1(String str) {
        androidx.fragment.app.d i4 = i();
        if (i4 != null) {
            i4.runOnUiThread(new e(i4, str));
        }
    }

    private void V1() {
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.f5794g0 = handlerThread;
        handlerThread.start();
        this.f5795h0 = new Handler(this.f5794g0.getLooper());
    }

    private void W1() {
        this.f5794g0.quitSafely();
        try {
            this.f5794g0.join();
            this.f5794g0 = null;
            this.f5795h0 = null;
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
    }

    private void X1() {
        com.nvshen.chmp4.d.B().i(I(com.telegram.a1064.R.string.net_test_loading));
        O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1() {
        try {
            this.f5798k0.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            S1(this.f5798k0);
            this.f5790c0.capture(this.f5798k0.build(), this.f5804q0, this.f5795h0);
            this.f5800m0 = 0;
            this.f5790c0.setRepeatingRequest(this.f5799l0, this.f5804q0, this.f5795h0);
        } catch (CameraAccessException e4) {
            e4.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void T(Bundle bundle) {
        super.T(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.telegram.a1064.R.layout.fragment_camera2_basic, viewGroup, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != com.telegram.a1064.R.id.info) {
            if (id != com.telegram.a1064.R.id.picture) {
                return;
            }
            X1();
        } else {
            androidx.fragment.app.d i4 = i();
            if (i4 != null) {
                new AlertDialog.Builder(i4).setMessage("thank you").setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void p0() {
        K1();
        W1();
        super.p0();
    }

    @Override // androidx.fragment.app.Fragment
    public void t0(int i4, String[] strArr, int[] iArr) {
        if (i4 != 1) {
            super.t0(i4, strArr, iArr);
        } else {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            j.s1("getString(R.string.request_permission)").r1(o(), "dialog");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void u0() {
        super.u0();
        V1();
        if (this.f5789b0.isAvailable()) {
            P1(this.f5789b0.getWidth(), this.f5789b0.getHeight());
        } else {
            this.f5789b0.setSurfaceTextureListener(this.Z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y0(View view, Bundle bundle) {
        view.findViewById(com.telegram.a1064.R.id.picture).setOnClickListener(this);
        view.findViewById(com.telegram.a1064.R.id.info).setOnClickListener(this);
        this.f5789b0 = (AutoFitTextureView) view.findViewById(com.telegram.a1064.R.id.texture);
    }
}
