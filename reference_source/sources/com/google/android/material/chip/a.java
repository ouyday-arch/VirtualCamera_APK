package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import b1.g;
import com.google.android.material.internal.h;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import y0.d;
import z0.b;

/* loaded from: classes.dex */
public class a extends g implements Drawable.Callback, h.b {
    private static final int[] I0 = {R.attr.state_enabled};
    private static final ShapeDrawable J0 = new ShapeDrawable(new OvalShape());
    private ColorStateList A;
    private int[] A0;
    private float B;
    private boolean B0;
    private float C;
    private ColorStateList C0;
    private ColorStateList D;
    private WeakReference<InterfaceC0027a> D0;
    private float E;
    private TextUtils.TruncateAt E0;
    private ColorStateList F;
    private boolean F0;
    private CharSequence G;
    private int G0;
    private boolean H;
    private boolean H0;
    private Drawable I;
    private ColorStateList J;
    private float K;
    private boolean L;
    private boolean M;
    private Drawable N;
    private Drawable O;
    private ColorStateList P;
    private float Q;
    private CharSequence R;
    private boolean S;
    private boolean T;
    private Drawable U;
    private n0.h V;
    private n0.h W;
    private float X;
    private float Y;
    private float Z;

    /* renamed from: a0, reason: collision with root package name */
    private float f2907a0;

    /* renamed from: b0, reason: collision with root package name */
    private float f2908b0;

    /* renamed from: c0, reason: collision with root package name */
    private float f2909c0;

    /* renamed from: d0, reason: collision with root package name */
    private float f2910d0;

    /* renamed from: e0, reason: collision with root package name */
    private float f2911e0;

    /* renamed from: f0, reason: collision with root package name */
    private final Context f2912f0;

    /* renamed from: g0, reason: collision with root package name */
    private final Paint f2913g0;

    /* renamed from: h0, reason: collision with root package name */
    private final Paint f2914h0;

    /* renamed from: i0, reason: collision with root package name */
    private final Paint.FontMetrics f2915i0;

    /* renamed from: j0, reason: collision with root package name */
    private final RectF f2916j0;

    /* renamed from: k0, reason: collision with root package name */
    private final PointF f2917k0;

    /* renamed from: l0, reason: collision with root package name */
    private final Path f2918l0;

    /* renamed from: m0, reason: collision with root package name */
    private final h f2919m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f2920n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f2921o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f2922p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f2923q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f2924r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f2925s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f2926t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f2927u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f2928v0;

    /* renamed from: w0, reason: collision with root package name */
    private ColorFilter f2929w0;

    /* renamed from: x0, reason: collision with root package name */
    private PorterDuffColorFilter f2930x0;

    /* renamed from: y0, reason: collision with root package name */
    private ColorStateList f2931y0;

    /* renamed from: z, reason: collision with root package name */
    private ColorStateList f2932z;

    /* renamed from: z0, reason: collision with root package name */
    private PorterDuff.Mode f2933z0;

    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0027a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f2913g0 = new Paint(1);
        this.f2915i0 = new Paint.FontMetrics();
        this.f2916j0 = new RectF();
        this.f2917k0 = new PointF();
        this.f2918l0 = new Path();
        this.f2928v0 = 255;
        this.f2933z0 = PorterDuff.Mode.SRC_IN;
        this.D0 = new WeakReference<>(null);
        M(context);
        this.f2912f0 = context;
        h hVar = new h(this);
        this.f2919m0 = hVar;
        this.G = "";
        hVar.e().density = context.getResources().getDisplayMetrics().density;
        this.f2914h0 = null;
        int[] iArr = I0;
        setState(iArr);
        c2(iArr);
        this.F0 = true;
        if (b.f6650a) {
            J0.setTint(-1);
        }
    }

    private void A0(Canvas canvas, Rect rect) {
        if (this.G != null) {
            Paint.Align p02 = p0(rect, this.f2917k0);
            n0(rect, this.f2916j0);
            if (this.f2919m0.d() != null) {
                this.f2919m0.e().drawableState = getState();
                this.f2919m0.j(this.f2912f0);
            }
            this.f2919m0.e().setTextAlign(p02);
            int i4 = 0;
            boolean z4 = Math.round(this.f2919m0.f(a1().toString())) > Math.round(this.f2916j0.width());
            if (z4) {
                i4 = canvas.save();
                canvas.clipRect(this.f2916j0);
            }
            CharSequence charSequence = this.G;
            if (z4 && this.E0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f2919m0.e(), this.f2916j0.width(), this.E0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.f2917k0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.f2919m0.e());
            if (z4) {
                canvas.restoreToCount(i4);
            }
        }
    }

    private boolean D2() {
        return this.T && this.U != null && this.f2926t0;
    }

    private boolean E2() {
        return this.H && this.I != null;
    }

    private boolean F2() {
        return this.M && this.N != null;
    }

    private void G2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void H2() {
        this.C0 = this.B0 ? b.a(this.F) : null;
    }

    @TargetApi(21)
    private void I2() {
        this.O = new RippleDrawable(b.a(Y0()), this.N, J0);
    }

    private void S1(ColorStateList colorStateList) {
        if (this.f2932z != colorStateList) {
            this.f2932z = colorStateList;
            onStateChange(getState());
        }
    }

    private ColorFilter e1() {
        ColorFilter colorFilter = this.f2929w0;
        return colorFilter != null ? colorFilter : this.f2930x0;
    }

    private void g0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        r.a.h(drawable, r.a.b(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.N) {
            if (drawable.isStateful()) {
                drawable.setState(R0());
            }
            r.a.j(drawable, this.P);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.I;
        if (drawable == drawable2 && this.L) {
            r.a.j(drawable2, this.J);
        }
    }

    private static boolean g1(int[] iArr, int i4) {
        if (iArr == null) {
            return false;
        }
        for (int i5 : iArr) {
            if (i5 == i4) {
                return true;
            }
        }
        return false;
    }

    private void h0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (E2() || D2()) {
            float f4 = this.X + this.Y;
            if (r.a.b(this) == 0) {
                float f5 = rect.left + f4;
                rectF.left = f5;
                rectF.right = f5 + this.K;
            } else {
                float f6 = rect.right - f4;
                rectF.right = f6;
                rectF.left = f6 - this.K;
            }
            float exactCenterY = rect.exactCenterY();
            float f7 = this.K;
            float f8 = exactCenterY - (f7 / 2.0f);
            rectF.top = f8;
            rectF.bottom = f8 + f7;
        }
    }

    private void j0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (F2()) {
            float f4 = this.f2911e0 + this.f2910d0 + this.Q + this.f2909c0 + this.f2908b0;
            if (r.a.b(this) == 0) {
                rectF.right = rect.right - f4;
            } else {
                rectF.left = rect.left + f4;
            }
        }
    }

    private void k0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (F2()) {
            float f4 = this.f2911e0 + this.f2910d0;
            if (r.a.b(this) == 0) {
                float f5 = rect.right - f4;
                rectF.right = f5;
                rectF.left = f5 - this.Q;
            } else {
                float f6 = rect.left + f4;
                rectF.left = f6;
                rectF.right = f6 + this.Q;
            }
            float exactCenterY = rect.exactCenterY();
            float f7 = this.Q;
            float f8 = exactCenterY - (f7 / 2.0f);
            rectF.top = f8;
            rectF.bottom = f8 + f7;
        }
    }

    private static boolean k1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void l0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (F2()) {
            float f4 = this.f2911e0 + this.f2910d0 + this.Q + this.f2909c0 + this.f2908b0;
            if (r.a.b(this) == 0) {
                float f5 = rect.right;
                rectF.right = f5;
                rectF.left = f5 - f4;
            } else {
                int i4 = rect.left;
                rectF.left = i4;
                rectF.right = i4 + f4;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean l1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean m1(d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.f6571b) == null || !colorStateList.isStateful()) ? false : true;
    }

    private void n0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.G != null) {
            float i02 = this.X + i0() + this.f2907a0;
            float m02 = this.f2911e0 + m0() + this.f2908b0;
            if (r.a.b(this) == 0) {
                rectF.left = rect.left + i02;
                rectF.right = rect.right - m02;
            } else {
                rectF.left = rect.left + m02;
                rectF.right = rect.right - i02;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void n1(android.util.AttributeSet r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.n1(android.util.AttributeSet, int, int):void");
    }

    private float o0() {
        this.f2919m0.e().getFontMetrics(this.f2915i0);
        Paint.FontMetrics fontMetrics = this.f2915i0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean p1(int[] iArr, int[] iArr2) {
        boolean z4;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f2932z;
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, this.f2920n0) : 0;
        boolean z5 = true;
        if (this.f2920n0 != colorForState) {
            this.f2920n0 = colorForState;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.A;
        int colorForState2 = colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f2921o0) : 0;
        if (this.f2921o0 != colorForState2) {
            this.f2921o0 = colorForState2;
            onStateChange = true;
        }
        int e4 = s0.a.e(colorForState, colorForState2);
        if ((this.f2922p0 != e4) | (x() == null)) {
            this.f2922p0 = e4;
            V(ColorStateList.valueOf(e4));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.D;
        int colorForState3 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f2923q0) : 0;
        if (this.f2923q0 != colorForState3) {
            this.f2923q0 = colorForState3;
            onStateChange = true;
        }
        int colorForState4 = (this.C0 == null || !b.b(iArr)) ? 0 : this.C0.getColorForState(iArr, this.f2924r0);
        if (this.f2924r0 != colorForState4) {
            this.f2924r0 = colorForState4;
            if (this.B0) {
                onStateChange = true;
            }
        }
        int colorForState5 = (this.f2919m0.d() == null || this.f2919m0.d().f6571b == null) ? 0 : this.f2919m0.d().f6571b.getColorForState(iArr, this.f2925s0);
        if (this.f2925s0 != colorForState5) {
            this.f2925s0 = colorForState5;
            onStateChange = true;
        }
        boolean z6 = g1(getState(), R.attr.state_checked) && this.S;
        if (this.f2926t0 == z6 || this.U == null) {
            z4 = false;
        } else {
            float i02 = i0();
            this.f2926t0 = z6;
            if (i02 != i0()) {
                onStateChange = true;
                z4 = true;
            } else {
                z4 = false;
                onStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.f2931y0;
        int colorForState6 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f2927u0) : 0;
        if (this.f2927u0 != colorForState6) {
            this.f2927u0 = colorForState6;
            this.f2930x0 = t0.a.a(this, this.f2931y0, this.f2933z0);
        } else {
            z5 = onStateChange;
        }
        if (l1(this.I)) {
            z5 |= this.I.setState(iArr);
        }
        if (l1(this.U)) {
            z5 |= this.U.setState(iArr);
        }
        if (l1(this.N)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z5 |= this.N.setState(iArr3);
        }
        if (b.f6650a && l1(this.O)) {
            z5 |= this.O.setState(iArr2);
        }
        if (z5) {
            invalidateSelf();
        }
        if (z4) {
            o1();
        }
        return z5;
    }

    private boolean q0() {
        return this.T && this.U != null && this.S;
    }

    public static a r0(Context context, AttributeSet attributeSet, int i4, int i5) {
        a aVar = new a(context, attributeSet, i4, i5);
        aVar.n1(attributeSet, i4, i5);
        return aVar;
    }

    private void s0(Canvas canvas, Rect rect) {
        if (D2()) {
            h0(rect, this.f2916j0);
            RectF rectF = this.f2916j0;
            float f4 = rectF.left;
            float f5 = rectF.top;
            canvas.translate(f4, f5);
            this.U.setBounds(0, 0, (int) this.f2916j0.width(), (int) this.f2916j0.height());
            this.U.draw(canvas);
            canvas.translate(-f4, -f5);
        }
    }

    private void t0(Canvas canvas, Rect rect) {
        if (this.H0) {
            return;
        }
        this.f2913g0.setColor(this.f2921o0);
        this.f2913g0.setStyle(Paint.Style.FILL);
        this.f2913g0.setColorFilter(e1());
        this.f2916j0.set(rect);
        canvas.drawRoundRect(this.f2916j0, D0(), D0(), this.f2913g0);
    }

    private void u0(Canvas canvas, Rect rect) {
        if (E2()) {
            h0(rect, this.f2916j0);
            RectF rectF = this.f2916j0;
            float f4 = rectF.left;
            float f5 = rectF.top;
            canvas.translate(f4, f5);
            this.I.setBounds(0, 0, (int) this.f2916j0.width(), (int) this.f2916j0.height());
            this.I.draw(canvas);
            canvas.translate(-f4, -f5);
        }
    }

    private void v0(Canvas canvas, Rect rect) {
        if (this.E <= 0.0f || this.H0) {
            return;
        }
        this.f2913g0.setColor(this.f2923q0);
        this.f2913g0.setStyle(Paint.Style.STROKE);
        if (!this.H0) {
            this.f2913g0.setColorFilter(e1());
        }
        RectF rectF = this.f2916j0;
        float f4 = rect.left;
        float f5 = this.E;
        rectF.set(f4 + (f5 / 2.0f), rect.top + (f5 / 2.0f), rect.right - (f5 / 2.0f), rect.bottom - (f5 / 2.0f));
        float f6 = this.C - (this.E / 2.0f);
        canvas.drawRoundRect(this.f2916j0, f6, f6, this.f2913g0);
    }

    private void w0(Canvas canvas, Rect rect) {
        if (this.H0) {
            return;
        }
        this.f2913g0.setColor(this.f2920n0);
        this.f2913g0.setStyle(Paint.Style.FILL);
        this.f2916j0.set(rect);
        canvas.drawRoundRect(this.f2916j0, D0(), D0(), this.f2913g0);
    }

    private void x0(Canvas canvas, Rect rect) {
        Drawable drawable;
        if (F2()) {
            k0(rect, this.f2916j0);
            RectF rectF = this.f2916j0;
            float f4 = rectF.left;
            float f5 = rectF.top;
            canvas.translate(f4, f5);
            this.N.setBounds(0, 0, (int) this.f2916j0.width(), (int) this.f2916j0.height());
            if (b.f6650a) {
                this.O.setBounds(this.N.getBounds());
                this.O.jumpToCurrentState();
                drawable = this.O;
            } else {
                drawable = this.N;
            }
            drawable.draw(canvas);
            canvas.translate(-f4, -f5);
        }
    }

    private void y0(Canvas canvas, Rect rect) {
        this.f2913g0.setColor(this.f2924r0);
        this.f2913g0.setStyle(Paint.Style.FILL);
        this.f2916j0.set(rect);
        if (!this.H0) {
            canvas.drawRoundRect(this.f2916j0, D0(), D0(), this.f2913g0);
        } else {
            h(new RectF(rect), this.f2918l0);
            super.p(canvas, this.f2913g0, this.f2918l0, u());
        }
    }

    private void z0(Canvas canvas, Rect rect) {
        Paint paint = this.f2914h0;
        if (paint != null) {
            paint.setColor(q.a.d(-16777216, 127));
            canvas.drawRect(rect, this.f2914h0);
            if (E2() || D2()) {
                h0(rect, this.f2916j0);
                canvas.drawRect(this.f2916j0, this.f2914h0);
            }
            if (this.G != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f2914h0);
            }
            if (F2()) {
                k0(rect, this.f2916j0);
                canvas.drawRect(this.f2916j0, this.f2914h0);
            }
            this.f2914h0.setColor(q.a.d(-65536, 127));
            j0(rect, this.f2916j0);
            canvas.drawRect(this.f2916j0, this.f2914h0);
            this.f2914h0.setColor(q.a.d(-16711936, 127));
            l0(rect, this.f2916j0);
            canvas.drawRect(this.f2916j0, this.f2914h0);
        }
    }

    public void A1(float f4) {
        if (this.f2911e0 != f4) {
            this.f2911e0 = f4;
            invalidateSelf();
            o1();
        }
    }

    public void A2(int i4) {
        z2(this.f2912f0.getResources().getDimension(i4));
    }

    public Drawable B0() {
        return this.U;
    }

    public void B1(int i4) {
        A1(this.f2912f0.getResources().getDimension(i4));
    }

    public void B2(boolean z4) {
        if (this.B0 != z4) {
            this.B0 = z4;
            H2();
            onStateChange(getState());
        }
    }

    public ColorStateList C0() {
        return this.A;
    }

    public void C1(Drawable drawable) {
        Drawable F0 = F0();
        if (F0 != drawable) {
            float i02 = i0();
            this.I = drawable != null ? r.a.m(drawable).mutate() : null;
            float i03 = i0();
            G2(F0);
            if (E2()) {
                g0(this.I);
            }
            invalidateSelf();
            if (i02 != i03) {
                o1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C2() {
        return this.F0;
    }

    public float D0() {
        return this.H0 ? F() : this.C;
    }

    public void D1(int i4) {
        C1(c.a.b(this.f2912f0, i4));
    }

    public float E0() {
        return this.f2911e0;
    }

    public void E1(float f4) {
        if (this.K != f4) {
            float i02 = i0();
            this.K = f4;
            float i03 = i0();
            invalidateSelf();
            if (i02 != i03) {
                o1();
            }
        }
    }

    public Drawable F0() {
        Drawable drawable = this.I;
        if (drawable != null) {
            return r.a.l(drawable);
        }
        return null;
    }

    public void F1(int i4) {
        E1(this.f2912f0.getResources().getDimension(i4));
    }

    public float G0() {
        return this.K;
    }

    public void G1(ColorStateList colorStateList) {
        this.L = true;
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (E2()) {
                r.a.j(this.I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public ColorStateList H0() {
        return this.J;
    }

    public void H1(int i4) {
        G1(c.a.a(this.f2912f0, i4));
    }

    public float I0() {
        return this.B;
    }

    public void I1(int i4) {
        J1(this.f2912f0.getResources().getBoolean(i4));
    }

    public float J0() {
        return this.X;
    }

    public void J1(boolean z4) {
        if (this.H != z4) {
            boolean E2 = E2();
            this.H = z4;
            boolean E22 = E2();
            if (E2 != E22) {
                if (E22) {
                    g0(this.I);
                } else {
                    G2(this.I);
                }
                invalidateSelf();
                o1();
            }
        }
    }

    public ColorStateList K0() {
        return this.D;
    }

    public void K1(float f4) {
        if (this.B != f4) {
            this.B = f4;
            invalidateSelf();
            o1();
        }
    }

    public float L0() {
        return this.E;
    }

    public void L1(int i4) {
        K1(this.f2912f0.getResources().getDimension(i4));
    }

    public Drawable M0() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return r.a.l(drawable);
        }
        return null;
    }

    public void M1(float f4) {
        if (this.X != f4) {
            this.X = f4;
            invalidateSelf();
            o1();
        }
    }

    public CharSequence N0() {
        return this.R;
    }

    public void N1(int i4) {
        M1(this.f2912f0.getResources().getDimension(i4));
    }

    public float O0() {
        return this.f2910d0;
    }

    public void O1(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.H0) {
                b0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float P0() {
        return this.Q;
    }

    public void P1(int i4) {
        O1(c.a.a(this.f2912f0, i4));
    }

    public float Q0() {
        return this.f2909c0;
    }

    public void Q1(float f4) {
        if (this.E != f4) {
            this.E = f4;
            this.f2913g0.setStrokeWidth(f4);
            if (this.H0) {
                super.c0(f4);
            }
            invalidateSelf();
        }
    }

    public int[] R0() {
        return this.A0;
    }

    public void R1(int i4) {
        Q1(this.f2912f0.getResources().getDimension(i4));
    }

    public ColorStateList S0() {
        return this.P;
    }

    public void T0(RectF rectF) {
        l0(getBounds(), rectF);
    }

    public void T1(Drawable drawable) {
        Drawable M0 = M0();
        if (M0 != drawable) {
            float m02 = m0();
            this.N = drawable != null ? r.a.m(drawable).mutate() : null;
            if (b.f6650a) {
                I2();
            }
            float m03 = m0();
            G2(M0);
            if (F2()) {
                g0(this.N);
            }
            invalidateSelf();
            if (m02 != m03) {
                o1();
            }
        }
    }

    public TextUtils.TruncateAt U0() {
        return this.E0;
    }

    public void U1(CharSequence charSequence) {
        if (this.R != charSequence) {
            this.R = w.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public n0.h V0() {
        return this.W;
    }

    public void V1(float f4) {
        if (this.f2910d0 != f4) {
            this.f2910d0 = f4;
            invalidateSelf();
            if (F2()) {
                o1();
            }
        }
    }

    public float W0() {
        return this.Z;
    }

    public void W1(int i4) {
        V1(this.f2912f0.getResources().getDimension(i4));
    }

    public float X0() {
        return this.Y;
    }

    public void X1(int i4) {
        T1(c.a.b(this.f2912f0, i4));
    }

    public ColorStateList Y0() {
        return this.F;
    }

    public void Y1(float f4) {
        if (this.Q != f4) {
            this.Q = f4;
            invalidateSelf();
            if (F2()) {
                o1();
            }
        }
    }

    public n0.h Z0() {
        return this.V;
    }

    public void Z1(int i4) {
        Y1(this.f2912f0.getResources().getDimension(i4));
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        o1();
        invalidateSelf();
    }

    public CharSequence a1() {
        return this.G;
    }

    public void a2(float f4) {
        if (this.f2909c0 != f4) {
            this.f2909c0 = f4;
            invalidateSelf();
            if (F2()) {
                o1();
            }
        }
    }

    public d b1() {
        return this.f2919m0.d();
    }

    public void b2(int i4) {
        a2(this.f2912f0.getResources().getDimension(i4));
    }

    public float c1() {
        return this.f2908b0;
    }

    public boolean c2(int[] iArr) {
        if (Arrays.equals(this.A0, iArr)) {
            return false;
        }
        this.A0 = iArr;
        if (F2()) {
            return p1(getState(), iArr);
        }
        return false;
    }

    public float d1() {
        return this.f2907a0;
    }

    public void d2(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (F2()) {
                r.a.j(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // b1.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i4 = this.f2928v0;
        int a5 = i4 < 255 ? o0.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i4) : 0;
        w0(canvas, bounds);
        t0(canvas, bounds);
        if (this.H0) {
            super.draw(canvas);
        }
        v0(canvas, bounds);
        y0(canvas, bounds);
        u0(canvas, bounds);
        s0(canvas, bounds);
        if (this.F0) {
            A0(canvas, bounds);
        }
        x0(canvas, bounds);
        z0(canvas, bounds);
        if (this.f2928v0 < 255) {
            canvas.restoreToCount(a5);
        }
    }

    public void e2(int i4) {
        d2(c.a.a(this.f2912f0, i4));
    }

    public boolean f1() {
        return this.B0;
    }

    public void f2(boolean z4) {
        if (this.M != z4) {
            boolean F2 = F2();
            this.M = z4;
            boolean F22 = F2();
            if (F2 != F22) {
                if (F22) {
                    g0(this.N);
                } else {
                    G2(this.N);
                }
                invalidateSelf();
                o1();
            }
        }
    }

    public void g2(InterfaceC0027a interfaceC0027a) {
        this.D0 = new WeakReference<>(interfaceC0027a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2928v0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f2929w0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.X + i0() + this.f2907a0 + this.f2919m0.f(a1().toString()) + this.f2908b0 + m0() + this.f2911e0), this.G0);
    }

    @Override // b1.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // b1.g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.H0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.C);
        } else {
            outline.setRoundRect(bounds, this.C);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public boolean h1() {
        return this.S;
    }

    public void h2(TextUtils.TruncateAt truncateAt) {
        this.E0 = truncateAt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i0() {
        if (E2() || D2()) {
            return this.Y + this.K + this.Z;
        }
        return 0.0f;
    }

    public boolean i1() {
        return l1(this.N);
    }

    public void i2(n0.h hVar) {
        this.W = hVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // b1.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return k1(this.f2932z) || k1(this.A) || k1(this.D) || (this.B0 && k1(this.C0)) || m1(this.f2919m0.d()) || q0() || l1(this.I) || l1(this.U) || k1(this.f2931y0);
    }

    public boolean j1() {
        return this.M;
    }

    public void j2(int i4) {
        i2(n0.h.c(this.f2912f0, i4));
    }

    public void k2(float f4) {
        if (this.Z != f4) {
            float i02 = i0();
            this.Z = f4;
            float i03 = i0();
            invalidateSelf();
            if (i02 != i03) {
                o1();
            }
        }
    }

    public void l2(int i4) {
        k2(this.f2912f0.getResources().getDimension(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float m0() {
        if (F2()) {
            return this.f2909c0 + this.Q + this.f2910d0;
        }
        return 0.0f;
    }

    public void m2(float f4) {
        if (this.Y != f4) {
            float i02 = i0();
            this.Y = f4;
            float i03 = i0();
            invalidateSelf();
            if (i02 != i03) {
                o1();
            }
        }
    }

    public void n2(int i4) {
        m2(this.f2912f0.getResources().getDimension(i4));
    }

    protected void o1() {
        InterfaceC0027a interfaceC0027a = this.D0.get();
        if (interfaceC0027a != null) {
            interfaceC0027a.a();
        }
    }

    public void o2(int i4) {
        this.G0 = i4;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i4) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i4);
        if (E2()) {
            onLayoutDirectionChanged |= r.a.h(this.I, i4);
        }
        if (D2()) {
            onLayoutDirectionChanged |= r.a.h(this.U, i4);
        }
        if (F2()) {
            onLayoutDirectionChanged |= r.a.h(this.N, i4);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i4) {
        boolean onLevelChange = super.onLevelChange(i4);
        if (E2()) {
            onLevelChange |= this.I.setLevel(i4);
        }
        if (D2()) {
            onLevelChange |= this.U.setLevel(i4);
        }
        if (F2()) {
            onLevelChange |= this.N.setLevel(i4);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // b1.g, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.H0) {
            super.onStateChange(iArr);
        }
        return p1(iArr, R0());
    }

    Paint.Align p0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.G != null) {
            float i02 = this.X + i0() + this.f2907a0;
            if (r.a.b(this) == 0) {
                pointF.x = rect.left + i02;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - i02;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - o0();
        }
        return align;
    }

    public void p2(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            H2();
            onStateChange(getState());
        }
    }

    public void q1(boolean z4) {
        if (this.S != z4) {
            this.S = z4;
            float i02 = i0();
            if (!z4 && this.f2926t0) {
                this.f2926t0 = false;
            }
            float i03 = i0();
            invalidateSelf();
            if (i02 != i03) {
                o1();
            }
        }
    }

    public void q2(int i4) {
        p2(c.a.a(this.f2912f0, i4));
    }

    public void r1(int i4) {
        q1(this.f2912f0.getResources().getBoolean(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r2(boolean z4) {
        this.F0 = z4;
    }

    public void s1(Drawable drawable) {
        if (this.U != drawable) {
            float i02 = i0();
            this.U = drawable;
            float i03 = i0();
            G2(this.U);
            g0(this.U);
            invalidateSelf();
            if (i02 != i03) {
                o1();
            }
        }
    }

    public void s2(n0.h hVar) {
        this.V = hVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j4);
        }
    }

    @Override // b1.g, android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        if (this.f2928v0 != i4) {
            this.f2928v0 = i4;
            invalidateSelf();
        }
    }

    @Override // b1.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2929w0 != colorFilter) {
            this.f2929w0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // b1.g, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f2931y0 != colorStateList) {
            this.f2931y0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // b1.g, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2933z0 != mode) {
            this.f2933z0 = mode;
            this.f2930x0 = t0.a.a(this, this.f2931y0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z4, boolean z5) {
        boolean visible = super.setVisible(z4, z5);
        if (E2()) {
            visible |= this.I.setVisible(z4, z5);
        }
        if (D2()) {
            visible |= this.U.setVisible(z4, z5);
        }
        if (F2()) {
            visible |= this.N.setVisible(z4, z5);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t1(int i4) {
        s1(c.a.b(this.f2912f0, i4));
    }

    public void t2(int i4) {
        s2(n0.h.c(this.f2912f0, i4));
    }

    public void u1(int i4) {
        v1(this.f2912f0.getResources().getBoolean(i4));
    }

    public void u2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.G, charSequence)) {
            return;
        }
        this.G = charSequence;
        this.f2919m0.i(true);
        invalidateSelf();
        o1();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v1(boolean z4) {
        if (this.T != z4) {
            boolean D2 = D2();
            this.T = z4;
            boolean D22 = D2();
            if (D2 != D22) {
                if (D22) {
                    g0(this.U);
                } else {
                    G2(this.U);
                }
                invalidateSelf();
                o1();
            }
        }
    }

    public void v2(d dVar) {
        this.f2919m0.h(dVar, this.f2912f0);
    }

    public void w1(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    public void w2(int i4) {
        v2(new d(this.f2912f0, i4));
    }

    public void x1(int i4) {
        w1(c.a.a(this.f2912f0, i4));
    }

    public void x2(float f4) {
        if (this.f2908b0 != f4) {
            this.f2908b0 = f4;
            invalidateSelf();
            o1();
        }
    }

    @Deprecated
    public void y1(float f4) {
        if (this.C != f4) {
            this.C = f4;
            setShapeAppearanceModel(C().w(f4));
        }
    }

    public void y2(int i4) {
        x2(this.f2912f0.getResources().getDimension(i4));
    }

    @Deprecated
    public void z1(int i4) {
        y1(this.f2912f0.getResources().getDimension(i4));
    }

    public void z2(float f4) {
        if (this.f2907a0 != f4) {
            this.f2907a0 = f4;
            invalidateSelf();
            o1();
        }
    }
}
