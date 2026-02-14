package q2;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private SurfaceHolder f5604a;

    /* renamed from: b, reason: collision with root package name */
    private SurfaceTexture f5605b;

    public j(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            throw new IllegalArgumentException("surfaceTexture may not be null");
        }
        this.f5605b = surfaceTexture;
    }

    public j(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalArgumentException("surfaceHolder may not be null");
        }
        this.f5604a = surfaceHolder;
    }

    public void a(Camera camera) {
        SurfaceHolder surfaceHolder = this.f5604a;
        if (surfaceHolder != null) {
            camera.setPreviewDisplay(surfaceHolder);
        } else {
            camera.setPreviewTexture(this.f5605b);
        }
    }
}
