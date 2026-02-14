package j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f4161a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f4162b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f4163c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f4164d;

    /* renamed from: e, reason: collision with root package name */
    private float f4165e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4166f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4167g;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f4168h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f4169i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f4170j;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f4171k;

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f4168h = colorStateList;
        this.f4162b.setColor(colorStateList.getColorForState(getState(), this.f4168h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f4163c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f4164d.set(rect);
        if (this.f4166f) {
            this.f4164d.inset((int) Math.ceil(f.a(this.f4165e, this.f4161a, this.f4167g)), (int) Math.ceil(f.b(this.f4165e, this.f4161a, this.f4167g)));
            this.f4163c.set(this.f4164d);
        }
    }

    public ColorStateList b() {
        return this.f4168h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f4165e;
    }

    public float d() {
        return this.f4161a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z4;
        Paint paint = this.f4162b;
        if (this.f4169i == null || paint.getColorFilter() != null) {
            z4 = false;
        } else {
            paint.setColorFilter(this.f4169i);
            z4 = true;
        }
        RectF rectF = this.f4163c;
        float f4 = this.f4161a;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        if (z4) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f4, boolean z4, boolean z5) {
        if (f4 == this.f4165e && this.f4166f == z4 && this.f4167g == z5) {
            return;
        }
        this.f4165e = f4;
        this.f4166f = z4;
        this.f4167g = z5;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f4164d, this.f4161a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f4) {
        if (f4 == this.f4161a) {
            return;
        }
        this.f4161a = f4;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f4170j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f4168h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f4168h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z4 = colorForState != this.f4162b.getColor();
        if (z4) {
            this.f4162b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f4170j;
        if (colorStateList2 == null || (mode = this.f4171k) == null) {
            return z4;
        }
        this.f4169i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f4162b.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4162b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f4170j = colorStateList;
        this.f4169i = a(colorStateList, this.f4171k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f4171k = mode;
        this.f4169i = a(this.f4170j, mode);
        invalidateSelf();
    }
}
