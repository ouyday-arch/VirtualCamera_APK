package w0;

/* loaded from: classes.dex */
public final class a {
    public static float a(float f4, float f5, float f6, float f7) {
        return (float) Math.hypot(f6 - f4, f7 - f5);
    }

    public static float b(float f4, float f5, float f6, float f7, float f8, float f9) {
        return d(a(f4, f5, f6, f7), a(f4, f5, f8, f7), a(f4, f5, f8, f9), a(f4, f5, f6, f9));
    }

    public static float c(float f4, float f5, float f6) {
        return ((1.0f - f6) * f4) + (f6 * f5);
    }

    private static float d(float f4, float f5, float f6, float f7) {
        return (f4 <= f5 || f4 <= f6 || f4 <= f7) ? (f5 <= f6 || f5 <= f7) ? f6 > f7 ? f6 : f7 : f5 : f4;
    }
}
