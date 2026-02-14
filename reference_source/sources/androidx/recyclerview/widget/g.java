package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class g extends RecyclerView.z {

    /* renamed from: k, reason: collision with root package name */
    protected PointF f2066k;

    /* renamed from: l, reason: collision with root package name */
    private final DisplayMetrics f2067l;

    /* renamed from: n, reason: collision with root package name */
    private float f2069n;

    /* renamed from: i, reason: collision with root package name */
    protected final LinearInterpolator f2064i = new LinearInterpolator();

    /* renamed from: j, reason: collision with root package name */
    protected final DecelerateInterpolator f2065j = new DecelerateInterpolator();

    /* renamed from: m, reason: collision with root package name */
    private boolean f2068m = false;

    /* renamed from: o, reason: collision with root package name */
    protected int f2070o = 0;

    /* renamed from: p, reason: collision with root package name */
    protected int f2071p = 0;

    public g(Context context) {
        this.f2067l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.f2068m) {
            this.f2069n = v(this.f2067l);
            this.f2068m = true;
        }
        return this.f2069n;
    }

    private int y(int i4, int i5) {
        int i6 = i4 - i5;
        if (i4 * i6 <= 0) {
            return 0;
        }
        return i6;
    }

    protected int B() {
        PointF pointF = this.f2066k;
        if (pointF != null) {
            float f4 = pointF.y;
            if (f4 != 0.0f) {
                return f4 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected void C(RecyclerView.z.a aVar) {
        PointF a5 = a(f());
        if (a5 == null || (a5.x == 0.0f && a5.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(a5);
        this.f2066k = a5;
        this.f2070o = (int) (a5.x * 10000.0f);
        this.f2071p = (int) (a5.y * 10000.0f);
        aVar.d((int) (this.f2070o * 1.2f), (int) (this.f2071p * 1.2f), (int) (x(10000) * 1.2f), this.f2064i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void l(int i4, int i5, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f2070o = y(this.f2070o, i4);
        int y4 = y(this.f2071p, i5);
        this.f2071p = y4;
        if (this.f2070o == 0 && y4 == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void n() {
        this.f2071p = 0;
        this.f2070o = 0;
        this.f2066k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        int t4 = t(view, z());
        int u4 = u(view, B());
        int w4 = w((int) Math.sqrt((t4 * t4) + (u4 * u4)));
        if (w4 > 0) {
            aVar.d(-t4, -u4, w4, this.f2065j);
        }
    }

    public int s(int i4, int i5, int i6, int i7, int i8) {
        if (i8 == -1) {
            return i6 - i4;
        }
        if (i8 != 0) {
            if (i8 == 1) {
                return i7 - i5;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i9 = i6 - i4;
        if (i9 > 0) {
            return i9;
        }
        int i10 = i7 - i5;
        if (i10 < 0) {
            return i10;
        }
        return 0;
    }

    public int t(View view, int i4) {
        RecyclerView.o e4 = e();
        if (e4 == null || !e4.k()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(e4.Q(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, e4.T(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, e4.e0(), e4.o0() - e4.f0(), i4);
    }

    public int u(View view, int i4) {
        RecyclerView.o e4 = e();
        if (e4 == null || !e4.l()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(e4.U(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, e4.O(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, e4.g0(), e4.W() - e4.d0(), i4);
    }

    protected float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w(int i4) {
        return (int) Math.ceil(x(i4) / 0.3356d);
    }

    protected int x(int i4) {
        return (int) Math.ceil(Math.abs(i4) * A());
    }

    protected int z() {
        PointF pointF = this.f2066k;
        if (pointF != null) {
            float f4 = pointF.x;
            if (f4 != 0.0f) {
                return f4 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
