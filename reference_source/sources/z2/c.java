package z2;

/* loaded from: classes.dex */
public final class c {
    private static final int a(int i4, int i5, int i6) {
        return e(e(i4, i6) - e(i5, i6), i6);
    }

    private static final long b(long j4, long j5, long j6) {
        return f(f(j4, j6) - f(j5, j6), j6);
    }

    public static final int c(int i4, int i5, int i6) {
        if (i6 > 0) {
            return i4 >= i5 ? i5 : i5 - a(i5, i4, i6);
        }
        if (i6 < 0) {
            return i4 <= i5 ? i5 : i5 + a(i4, i5, -i6);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long d(long j4, long j5, long j6) {
        if (j6 > 0) {
            return j4 >= j5 ? j5 : j5 - b(j5, j4, j6);
        }
        if (j6 < 0) {
            return j4 <= j5 ? j5 : j5 + b(j4, j5, -j6);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int e(int i4, int i5) {
        int i6 = i4 % i5;
        return i6 >= 0 ? i6 : i6 + i5;
    }

    private static final long f(long j4, long j5) {
        long j6 = j4 % j5;
        return j6 >= 0 ? j6 : j6 + j5;
    }
}
