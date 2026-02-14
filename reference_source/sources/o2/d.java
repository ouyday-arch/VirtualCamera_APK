package o2;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/* loaded from: classes.dex */
public abstract class d implements View.OnTouchListener {

    /* renamed from: b, reason: collision with root package name */
    private n2.e<?> f5361b;

    /* renamed from: c, reason: collision with root package name */
    private View f5362c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f5363d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private int f5364e;

    /* renamed from: f, reason: collision with root package name */
    private int f5365f;

    /* renamed from: g, reason: collision with root package name */
    private int f5366g;

    /* renamed from: h, reason: collision with root package name */
    private int f5367h;

    /* renamed from: i, reason: collision with root package name */
    private int f5368i;

    /* renamed from: j, reason: collision with root package name */
    private int f5369j;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(float f4, int i4, float f5) {
        c().getWindowVisibleDisplayFrame(this.f5363d);
        Rect rect = this.f5363d;
        int i5 = rect.right - rect.left;
        int i6 = rect.bottom - rect.top;
        float f6 = i5 * f4;
        float f7 = i4 / 2.0f;
        q((int) (f6 - f7), (int) ((i6 * f5) - f7));
        e().m(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean l(View view, MotionEvent motionEvent) {
        n();
        return onTouch(view, motionEvent);
    }

    protected View c() {
        return this.f5362c;
    }

    protected float d() {
        return TypedValue.applyDimension(1, 1.0f, Resources.getSystem().getDisplayMetrics());
    }

    protected n2.e<?> e() {
        return this.f5361b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        return this.f5365f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int g() {
        return this.f5369j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int h() {
        return this.f5368i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int i() {
        return this.f5364e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(float f4, float f5, float f6, float f7) {
        float d5 = d();
        return Math.abs(f4 - f5) >= d5 || Math.abs(f6 - f7) >= d5;
    }

    public void m() {
        final int width = c().getWidth();
        int height = c().getHeight();
        int i4 = this.f5366g - this.f5368i;
        int i5 = this.f5367h - this.f5369j;
        float f4 = i4;
        final float f5 = 1.0f;
        final float f6 = f4 < 1.0f ? 0.0f : ((float) Math.abs(this.f5364e - (i4 + width))) < 1.0f ? 1.0f : (f4 + (width / 2.0f)) / this.f5364e;
        float f7 = i5;
        if (f7 < 1.0f) {
            f5 = 0.0f;
        } else if (Math.abs(this.f5365f - (i5 + height)) >= 1.0f) {
            f5 = (f7 + (height / 2.0f)) / this.f5365f;
        }
        e().o(new Runnable() { // from class: o2.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.k(f6, width, f5);
            }
        }, 100L);
    }

    public void n() {
        c().getWindowVisibleDisplayFrame(this.f5363d);
        Rect rect = this.f5363d;
        this.f5364e = rect.right - rect.left;
        this.f5365f = rect.bottom - rect.top;
        int[] iArr = new int[2];
        c().getLocationOnScreen(iArr);
        this.f5366g = iArr[0];
        this.f5367h = iArr[1];
        Rect rect2 = this.f5363d;
        this.f5368i = rect2.left;
        this.f5369j = rect2.top;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void o(n2.e<?> eVar) {
        this.f5361b = eVar;
        View h4 = eVar.h();
        this.f5362c = h4;
        h4.setOnTouchListener(new View.OnTouchListener() { // from class: o2.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean l4;
                l4 = d.this.l(view, motionEvent);
                return l4;
            }
        });
        this.f5362c.post(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(float f4, float f5) {
        q((int) f4, (int) f5);
    }

    protected void q(int i4, int i5) {
        WindowManager.LayoutParams i6 = this.f5361b.i();
        if (i6 == null) {
            return;
        }
        if (i6.gravity == 8388659 && i6.x == i4 && i6.y == i5) {
            return;
        }
        i6.x = i4;
        i6.y = i5;
        i6.gravity = 8388659;
        this.f5361b.L();
    }
}
