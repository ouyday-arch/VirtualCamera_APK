package o1;

/* loaded from: classes.dex */
public final class a {
    public static float a(float f4, float f5, float f6, float f7) {
        double d5 = f4 - f6;
        double d6 = f5 - f7;
        return (float) Math.sqrt((d5 * d5) + (d6 * d6));
    }

    public static float b(int i4, int i5, int i6, int i7) {
        double d5 = i4 - i6;
        double d6 = i5 - i7;
        return (float) Math.sqrt((d5 * d5) + (d6 * d6));
    }

    public static int c(float f4) {
        return (int) (f4 + (f4 < 0.0f ? -0.5f : 0.5f));
    }

    public static int d(int[] iArr) {
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        return i4;
    }
}
