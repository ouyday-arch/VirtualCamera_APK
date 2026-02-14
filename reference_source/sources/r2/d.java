package r2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class d extends SurfaceView implements SurfaceHolder.Callback, Camera.PreviewCallback {

    /* renamed from: b, reason: collision with root package name */
    private SurfaceHolder f5824b;

    /* renamed from: c, reason: collision with root package name */
    private Camera f5825c;

    /* renamed from: d, reason: collision with root package name */
    private int f5826d;

    /* renamed from: e, reason: collision with root package name */
    private i f5827e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f5828f;

    /* renamed from: g, reason: collision with root package name */
    private j f5829g;

    /* renamed from: h, reason: collision with root package name */
    private LinkedBlockingQueue<byte[]> f5830h;

    /* renamed from: i, reason: collision with root package name */
    private k f5831i;

    /* renamed from: j, reason: collision with root package name */
    int f5832j;

    /* renamed from: k, reason: collision with root package name */
    int f5833k;

    /* renamed from: l, reason: collision with root package name */
    int f5834l;

    /* renamed from: m, reason: collision with root package name */
    long f5835m;

    /* loaded from: classes.dex */
    class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return Integer.parseInt(str.split("x")[0]) - Integer.parseInt(str2.split("x")[0]);
        }
    }

    /* loaded from: classes.dex */
    class b implements Comparator<Camera.Size> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Camera.Size size, Camera.Size size2) {
            return size.width - size2.width;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends HandlerThread {

        /* renamed from: b, reason: collision with root package name */
        Handler f5837b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.c();
                c.this.a();
            }
        }

        public c(String str) {
            super(str);
            start();
            this.f5837b = new Handler(getLooper());
        }

        synchronized void a() {
            notify();
        }

        void b() {
            this.f5837b.post(new a());
            try {
                wait();
            } catch (InterruptedException unused) {
                Log.w("CameraPreview", "wait was interrupted");
            }
        }
    }

    public d(Context context) {
        super(context);
        this.f5826d = 4;
        this.f5832j = 0;
        this.f5833k = 0;
        this.f5834l = 0;
        this.f5835m = 0L;
        SurfaceHolder holder = getHolder();
        this.f5824b = holder;
        holder.addCallback(this);
        int i4 = this.f5826d;
        if (i4 == 1) {
            this.f5827e = new i("process frame");
            this.f5828f = new Handler(this.f5827e.getLooper(), this.f5827e);
        } else if (i4 == 2) {
            this.f5830h = new LinkedBlockingQueue<>();
            this.f5829g = new j(this.f5830h);
        } else {
            if (i4 != 4) {
                return;
            }
            this.f5831i = new k();
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static List<String> b(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        HashMap hashMap = new HashMap();
        try {
            for (String str : cameraManager.getCameraIdList()) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap != null) {
                    for (Size size : streamConfigurationMap.getOutputSizes(SurfaceTexture.class)) {
                        if (size.getWidth() >= 480 && size.getHeight() >= 480) {
                            hashMap.put(String.format("%dx%d", Integer.valueOf(size.getWidth()), Integer.valueOf(size.getHeight())), num);
                            hashMap.put(String.format("%dx%d", Integer.valueOf(size.getHeight()), Integer.valueOf(size.getWidth())), num);
                        }
                        Log.e("CameraPreview", size.getWidth() + "x" + size.getHeight() + ",ingore");
                    }
                }
            }
        } catch (CameraAccessException e4) {
            e4.printStackTrace();
        }
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        arrayList.sort(new a());
        Log.d("CameraPreview", r2.c.a("\n", arrayList));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            for (int i4 = 0; i4 < numberOfCameras; i4++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i4, cameraInfo);
                int i5 = cameraInfo.facing;
                if (i5 == 0) {
                    this.f5832j = i4;
                } else if (i5 == 1) {
                    this.f5833k = i4;
                }
            }
            this.f5825c = Camera.open(this.f5833k);
            Log.i("CameraPreview", "getNumberOfCameras: " + numberOfCameras);
        } catch (Exception e4) {
            e4.printStackTrace();
            Log.e("CameraPreview", "openCameraOriginal camera is not available");
        }
    }

    public Camera getCameraInstance() {
        if (this.f5825c == null) {
            c cVar = new c("camera thread");
            synchronized (cVar) {
                cVar.b();
            }
        }
        return this.f5825c;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.f5834l++;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f5835m > 1000) {
            this.f5835m = currentTimeMillis;
            Log.e("CameraPreview", "onPreviewFrame fps:" + this.f5834l);
            this.f5834l = 0;
        }
        int i4 = this.f5826d;
        if (i4 == 1) {
            this.f5828f.obtainMessage(1, bArr).sendToTarget();
            return;
        }
        if (i4 == 2) {
            try {
                this.f5830h.put(bArr);
                return;
            } catch (InterruptedException e4) {
                e4.printStackTrace();
                return;
            }
        }
        if (i4 == 3) {
            new h().execute(bArr);
        } else {
            if (i4 != 4) {
                return;
            }
            this.f5831i.b(bArr);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        getCameraInstance();
        this.f5825c.setDisplayOrientation(90);
        this.f5825c.setPreviewCallback(this);
        try {
            this.f5825c.setPreviewDisplay(surfaceHolder);
            Camera.Parameters parameters = this.f5825c.getParameters();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            supportedPreviewSizes.sort(new b());
            Camera.Size size = null;
            int i4 = 1;
            while (true) {
                if (i4 >= supportedPreviewSizes.size()) {
                    break;
                }
                if (supportedPreviewSizes.get(i4).width > getWidth()) {
                    size = supportedPreviewSizes.get(i4 - 1);
                    break;
                }
                i4++;
            }
            if (size == null) {
                size = supportedPreviewSizes.get(supportedPreviewSizes.size() - 1);
            }
            Log.e("CameraPreview", String.format("---------preview size =%dx%d ", Integer.valueOf(size.width), Integer.valueOf(size.height)));
            parameters.setPreviewSize(640, 480);
            this.f5825c.setParameters(parameters);
            this.f5825c.startPreview();
        } catch (IOException e4) {
            Log.d("CameraPreview", "Error setting camera preview: " + e4.getMessage());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f5824b.removeCallback(this);
        this.f5825c.setPreviewCallback(null);
        this.f5825c.stopPreview();
        this.f5825c.release();
        this.f5825c = null;
    }
}
