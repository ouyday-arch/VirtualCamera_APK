package j;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class a extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f4153h = {R.attr.colorBackground};

    /* renamed from: i, reason: collision with root package name */
    private static final d f4154i;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4155b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4156c;

    /* renamed from: d, reason: collision with root package name */
    int f4157d;

    /* renamed from: e, reason: collision with root package name */
    int f4158e;

    /* renamed from: f, reason: collision with root package name */
    final Rect f4159f;

    /* renamed from: g, reason: collision with root package name */
    private final c f4160g;

    static {
        b bVar = new b();
        f4154i = bVar;
        bVar.m();
    }

    public ColorStateList getCardBackgroundColor() {
        return f4154i.f(this.f4160g);
    }

    public float getCardElevation() {
        return f4154i.a(this.f4160g);
    }

    public int getContentPaddingBottom() {
        return this.f4159f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f4159f.left;
    }

    public int getContentPaddingRight() {
        return this.f4159f.right;
    }

    public int getContentPaddingTop() {
        return this.f4159f.top;
    }

    public float getMaxCardElevation() {
        return f4154i.i(this.f4160g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f4156c;
    }

    public float getRadius() {
        return f4154i.h(this.f4160g);
    }

    public boolean getUseCompatPadding() {
        return this.f4155b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        if (!(f4154i instanceof b)) {
            int mode = View.MeasureSpec.getMode(i4);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i4 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.d(this.f4160g)), View.MeasureSpec.getSize(i4)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i5);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i5 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.j(this.f4160g)), View.MeasureSpec.getSize(i5)), mode2);
            }
        }
        super.onMeasure(i4, i5);
    }

    public void setCardBackgroundColor(int i4) {
        f4154i.l(this.f4160g, ColorStateList.valueOf(i4));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f4154i.l(this.f4160g, colorStateList);
    }

    public void setCardElevation(float f4) {
        f4154i.b(this.f4160g, f4);
    }

    public void setMaxCardElevation(float f4) {
        f4154i.k(this.f4160g, f4);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i4) {
        this.f4158e = i4;
        super.setMinimumHeight(i4);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i4) {
        this.f4157d = i4;
        super.setMinimumWidth(i4);
    }

    @Override // android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i4, int i5, int i6, int i7) {
    }

    public void setPreventCornerOverlap(boolean z4) {
        if (z4 != this.f4156c) {
            this.f4156c = z4;
            f4154i.c(this.f4160g);
        }
    }

    public void setRadius(float f4) {
        f4154i.g(this.f4160g, f4);
    }

    public void setUseCompatPadding(boolean z4) {
        if (this.f4155b != z4) {
            this.f4155b = z4;
            f4154i.e(this.f4160g);
        }
    }
}
