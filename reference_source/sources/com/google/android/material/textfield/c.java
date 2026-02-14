package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import b1.k;

/* loaded from: classes.dex */
class c extends b1.g {
    private final RectF A;
    private int B;

    /* renamed from: z, reason: collision with root package name */
    private final Paint f3277z;

    c() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(k kVar) {
        super(kVar == null ? new k() : kVar);
        this.f3277z = new Paint(1);
        n0();
        this.A = new RectF();
    }

    private void h0(Canvas canvas) {
        if (o0(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.B);
    }

    private void i0(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (!o0(callback)) {
            k0(canvas);
            return;
        }
        View view = (View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    private void k0(Canvas canvas) {
        this.B = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
    }

    private void n0() {
        this.f3277z.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f3277z.setColor(-1);
        this.f3277z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean o0(Drawable.Callback callback) {
        return callback instanceof View;
    }

    @Override // b1.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        i0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.A, this.f3277z);
        h0(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g0() {
        return !this.A.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0() {
        l0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void l0(float f4, float f5, float f6, float f7) {
        RectF rectF = this.A;
        if (f4 == rectF.left && f5 == rectF.top && f6 == rectF.right && f7 == rectF.bottom) {
            return;
        }
        rectF.set(f4, f5, f6, f7);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m0(RectF rectF) {
        l0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
