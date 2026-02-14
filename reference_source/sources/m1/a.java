package m1;

import android.hardware.Camera;
import android.util.Log;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5184a = "m1.a";

    public static int a(int i4) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f5184a, "No cameras!");
            return -1;
        }
        boolean z4 = i4 >= 0;
        if (!z4) {
            i4 = 0;
            while (i4 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i4, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i4++;
            }
        }
        return i4 < numberOfCameras ? i4 : z4 ? -1 : 0;
    }

    public static Camera b(int i4) {
        int a5 = a(i4);
        if (a5 == -1) {
            return null;
        }
        return Camera.open(a5);
    }
}
