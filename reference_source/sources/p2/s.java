package p2;

import android.os.Looper;

/* loaded from: classes.dex */
public class s {
    public static void a() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }
}
