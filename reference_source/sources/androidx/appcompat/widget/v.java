package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: classes.dex */
class v extends r {

    /* renamed from: d, reason: collision with root package name */
    private final SeekBar f1182d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f1183e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f1184f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f1185g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1186h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1187i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SeekBar seekBar) {
        super(seekBar);
        this.f1184f = null;
        this.f1185g = null;
        this.f1186h = false;
        this.f1187i = false;
        this.f1182d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1183e;
        if (drawable != null) {
            if (this.f1186h || this.f1187i) {
                Drawable m4 = r.a.m(drawable.mutate());
                this.f1183e = m4;
                if (this.f1186h) {
                    r.a.j(m4, this.f1184f);
                }
                if (this.f1187i) {
                    r.a.k(this.f1183e, this.f1185g);
                }
                if (this.f1183e.isStateful()) {
                    this.f1183e.setState(this.f1182d.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.r
    public void c(AttributeSet attributeSet, int i4) {
        super.c(attributeSet, i4);
        w0 u4 = w0.u(this.f1182d.getContext(), attributeSet, a.j.V, i4, 0);
        Drawable h4 = u4.h(a.j.W);
        if (h4 != null) {
            this.f1182d.setThumb(h4);
        }
        j(u4.g(a.j.X));
        int i5 = a.j.Z;
        if (u4.r(i5)) {
            this.f1185g = e0.c(u4.k(i5, -1), this.f1185g);
            this.f1187i = true;
        }
        int i6 = a.j.Y;
        if (u4.r(i6)) {
            this.f1184f = u4.c(i6);
            this.f1186h = true;
        }
        u4.v();
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f1183e != null) {
            int max = this.f1182d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1183e.getIntrinsicWidth();
                int intrinsicHeight = this.f1183e.getIntrinsicHeight();
                int i4 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i5 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1183e.setBounds(-i4, -i5, i4, i5);
                float width = ((this.f1182d.getWidth() - this.f1182d.getPaddingLeft()) - this.f1182d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f1182d.getPaddingLeft(), this.f1182d.getHeight() / 2);
                for (int i6 = 0; i6 <= max; i6++) {
                    this.f1183e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f1183e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1182d.getDrawableState())) {
            this.f1182d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f1183e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f1183e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1183e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1182d);
            r.a.h(drawable, y.p.t(this.f1182d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1182d.getDrawableState());
            }
            f();
        }
        this.f1182d.invalidate();
    }
}
