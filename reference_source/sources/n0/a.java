package n0;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f5238a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f5239b = new d0.b();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f5240c = new d0.a();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f5241d = new d0.c();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f5242e = new DecelerateInterpolator();

    public static float a(float f4, float f5, float f6) {
        return f4 + (f6 * (f5 - f4));
    }
}
