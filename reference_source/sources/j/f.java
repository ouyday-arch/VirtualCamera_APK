package j;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class f extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private static final double f4172a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f4, float f5, boolean z4) {
        return z4 ? (float) (f4 + ((1.0d - f4172a) * f5)) : f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f4, float f5, boolean z4) {
        float f6 = f4 * 1.5f;
        return z4 ? (float) (f6 + ((1.0d - f4172a) * f5)) : f6;
    }
}
