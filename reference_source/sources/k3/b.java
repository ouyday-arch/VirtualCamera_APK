package k3;

import java.text.DecimalFormat;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f4453a = false;

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f4454b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i4 = 0; i4 < 4; i4++) {
            threadLocalArr[i4] = new ThreadLocal<>();
        }
        f4454b = threadLocalArr;
    }

    public static final boolean a() {
        return f4453a;
    }
}
