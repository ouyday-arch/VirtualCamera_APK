package u0;

import android.content.Context;
import android.graphics.Color;
import y0.b;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6211a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6212b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6213c;

    /* renamed from: d, reason: collision with root package name */
    private final float f6214d;

    public a(Context context) {
        this.f6211a = b.b(context, m0.b.f4946n, false);
        this.f6212b = s0.a.a(context, m0.b.f4945m, 0);
        this.f6213c = s0.a.a(context, m0.b.f4943k, 0);
        this.f6214d = context.getResources().getDisplayMetrics().density;
    }

    private boolean e(int i4) {
        return q.a.d(i4, 255) == this.f6213c;
    }

    public float a(float f4) {
        if (this.f6214d <= 0.0f || f4 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f4 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i4, float f4) {
        float a5 = a(f4);
        return q.a.d(s0.a.f(q.a.d(i4, 255), this.f6212b, a5), Color.alpha(i4));
    }

    public int c(int i4, float f4) {
        return (this.f6211a && e(i4)) ? b(i4, f4) : i4;
    }

    public boolean d() {
        return this.f6211a;
    }
}
