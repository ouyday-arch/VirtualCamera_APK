package y;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class h {
    public static boolean a(MotionEvent motionEvent, int i4) {
        return (motionEvent.getSource() & i4) == i4;
    }
}
