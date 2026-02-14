package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.android.material.internal.g;
import y.p;
import y0.a;

/* loaded from: classes.dex */
public final class a {
    private static final boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    private static final Paint f3115a0 = null;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private int[] F;
    private boolean G;
    private final TextPaint H;
    private final TextPaint I;
    private TimeInterpolator J;
    private TimeInterpolator K;
    private float L;
    private float M;
    private float N;
    private ColorStateList O;
    private float P;
    private float Q;
    private float R;
    private ColorStateList S;
    private StaticLayout T;
    private float U;
    private float V;
    private float W;
    private CharSequence X;

    /* renamed from: a, reason: collision with root package name */
    private final View f3116a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3117b;

    /* renamed from: c, reason: collision with root package name */
    private float f3118c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f3119d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f3120e;

    /* renamed from: f, reason: collision with root package name */
    private final RectF f3121f;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f3126k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f3127l;

    /* renamed from: m, reason: collision with root package name */
    private float f3128m;

    /* renamed from: n, reason: collision with root package name */
    private float f3129n;

    /* renamed from: o, reason: collision with root package name */
    private float f3130o;

    /* renamed from: p, reason: collision with root package name */
    private float f3131p;

    /* renamed from: q, reason: collision with root package name */
    private float f3132q;

    /* renamed from: r, reason: collision with root package name */
    private float f3133r;

    /* renamed from: s, reason: collision with root package name */
    private Typeface f3134s;

    /* renamed from: t, reason: collision with root package name */
    private Typeface f3135t;

    /* renamed from: u, reason: collision with root package name */
    private Typeface f3136u;

    /* renamed from: v, reason: collision with root package name */
    private y0.a f3137v;

    /* renamed from: w, reason: collision with root package name */
    private y0.a f3138w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f3139x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f3140y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f3141z;

    /* renamed from: g, reason: collision with root package name */
    private int f3122g = 16;

    /* renamed from: h, reason: collision with root package name */
    private int f3123h = 16;

    /* renamed from: i, reason: collision with root package name */
    private float f3124i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f3125j = 15.0f;
    private int Y = 1;

    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0031a implements a.InterfaceC0096a {
        C0031a() {
        }

        @Override // y0.a.InterfaceC0096a
        public void a(Typeface typeface) {
            a.this.M(typeface);
        }
    }

    public a(View view) {
        this.f3116a = view;
        TextPaint textPaint = new TextPaint(129);
        this.H = textPaint;
        this.I = new TextPaint(textPaint);
        this.f3120e = new Rect();
        this.f3119d = new Rect();
        this.f3121f = new RectF();
    }

    private boolean A() {
        return p.t(this.f3116a) == 1;
    }

    private static float C(float f4, float f5, float f6, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f6 = timeInterpolator.getInterpolation(f6);
        }
        return n0.a.a(f4, f5, f6);
    }

    private static boolean F(Rect rect, int i4, int i5, int i6, int i7) {
        return rect.left == i4 && rect.top == i5 && rect.right == i6 && rect.bottom == i7;
    }

    private void J(float f4) {
        this.U = f4;
        p.S(this.f3116a);
    }

    private boolean N(Typeface typeface) {
        y0.a aVar = this.f3138w;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f3134s == typeface) {
            return false;
        }
        this.f3134s = typeface;
        return true;
    }

    private void Q(float f4) {
        this.V = f4;
        p.S(this.f3116a);
    }

    private boolean U(Typeface typeface) {
        y0.a aVar = this.f3137v;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f3135t == typeface) {
            return false;
        }
        this.f3135t = typeface;
        return true;
    }

    private void W(float f4) {
        g(f4);
        boolean z4 = Z && this.D != 1.0f;
        this.A = z4;
        if (z4) {
            l();
        }
        p.S(this.f3116a);
    }

    private static int a(int i4, int i5, float f4) {
        float f5 = 1.0f - f4;
        return Color.argb((int) ((Color.alpha(i4) * f5) + (Color.alpha(i5) * f4)), (int) ((Color.red(i4) * f5) + (Color.red(i5) * f4)), (int) ((Color.green(i4) * f5) + (Color.green(i5) * f4)), (int) ((Color.blue(i4) * f5) + (Color.blue(i5) * f4)));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.a.b():void");
    }

    private boolean c0() {
        return (this.Y <= 1 || this.f3141z || this.A) ? false : true;
    }

    private void d() {
        f(this.f3118c);
    }

    private boolean e(CharSequence charSequence) {
        return (A() ? w.d.f6339d : w.d.f6338c).a(charSequence, 0, charSequence.length());
    }

    private void f(float f4) {
        TextPaint textPaint;
        int r4;
        y(f4);
        this.f3132q = C(this.f3130o, this.f3131p, f4, this.J);
        this.f3133r = C(this.f3128m, this.f3129n, f4, this.J);
        W(C(this.f3124i, this.f3125j, f4, this.K));
        TimeInterpolator timeInterpolator = n0.a.f5239b;
        J(1.0f - C(0.0f, 1.0f, 1.0f - f4, timeInterpolator));
        Q(C(1.0f, 0.0f, f4, timeInterpolator));
        if (this.f3127l != this.f3126k) {
            textPaint = this.H;
            r4 = a(t(), r(), f4);
        } else {
            textPaint = this.H;
            r4 = r();
        }
        textPaint.setColor(r4);
        this.H.setShadowLayer(C(this.P, this.L, f4, null), C(this.Q, this.M, f4, null), C(this.R, this.N, f4, null), a(s(this.S), s(this.O), f4));
        p.S(this.f3116a);
    }

    private void g(float f4) {
        boolean z4;
        float f5;
        boolean z5;
        if (this.f3139x == null) {
            return;
        }
        float width = this.f3120e.width();
        float width2 = this.f3119d.width();
        if (z(f4, this.f3125j)) {
            f5 = this.f3125j;
            this.D = 1.0f;
            Typeface typeface = this.f3136u;
            Typeface typeface2 = this.f3134s;
            if (typeface != typeface2) {
                this.f3136u = typeface2;
                z5 = true;
            } else {
                z5 = false;
            }
        } else {
            float f6 = this.f3124i;
            Typeface typeface3 = this.f3136u;
            Typeface typeface4 = this.f3135t;
            if (typeface3 != typeface4) {
                this.f3136u = typeface4;
                z4 = true;
            } else {
                z4 = false;
            }
            if (z(f4, f6)) {
                this.D = 1.0f;
            } else {
                this.D = f4 / this.f3124i;
            }
            float f7 = this.f3125j / this.f3124i;
            width = width2 * f7 > width ? Math.min(width / f7, width2) : width2;
            f5 = f6;
            z5 = z4;
        }
        if (width > 0.0f) {
            z5 = this.E != f5 || this.G || z5;
            this.E = f5;
            this.G = false;
        }
        if (this.f3140y == null || z5) {
            this.H.setTextSize(this.E);
            this.H.setTypeface(this.f3136u);
            this.H.setLinearText(this.D != 1.0f);
            this.f3141z = e(this.f3139x);
            StaticLayout i4 = i(c0() ? this.Y : 1, width, this.f3141z);
            this.T = i4;
            this.f3140y = i4.getText();
        }
    }

    private void h() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private StaticLayout i(int i4, float f4, boolean z4) {
        StaticLayout staticLayout;
        try {
            staticLayout = g.b(this.f3139x, this.H, (int) f4).d(TextUtils.TruncateAt.END).f(z4).c(Layout.Alignment.ALIGN_NORMAL).e(false).g(i4).a();
        } catch (g.a e4) {
            Log.e("CollapsingTextHelper", e4.getCause().getMessage(), e4);
            staticLayout = null;
        }
        return (StaticLayout) x.h.c(staticLayout);
    }

    private void k(Canvas canvas, float f4, float f5, float f6, float f7) {
        int alpha = this.H.getAlpha();
        canvas.translate(f4, f6);
        float f8 = alpha;
        this.H.setAlpha((int) (this.V * f8));
        this.T.draw(canvas);
        canvas.translate(f5 - f4, 0.0f);
        this.H.setAlpha((int) (this.U * f8));
        CharSequence charSequence = this.X;
        float f9 = -f7;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f9 / this.D, this.H);
        String trim = this.X.toString().trim();
        if (trim.endsWith("…")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.H.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.T.getLineEnd(0), str.length()), 0.0f, f9 / this.D, (Paint) this.H);
    }

    private void l() {
        if (this.B != null || this.f3119d.isEmpty() || TextUtils.isEmpty(this.f3140y)) {
            return;
        }
        f(0.0f);
        int width = this.T.getWidth();
        int height = this.T.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.B = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.T.draw(new Canvas(this.B));
        if (this.C == null) {
            this.C = new Paint(3);
        }
    }

    private float p(int i4, int i5) {
        return (i5 == 17 || (i5 & 7) == 1) ? (i4 / 2.0f) - (c() / 2.0f) : ((i5 & 8388613) == 8388613 || (i5 & 5) == 5) ? this.f3141z ? this.f3120e.left : this.f3120e.right - c() : this.f3141z ? this.f3120e.right - c() : this.f3120e.left;
    }

    private float q(RectF rectF, int i4, int i5) {
        return (i5 == 17 || (i5 & 7) == 1) ? (i4 / 2.0f) + (c() / 2.0f) : ((i5 & 8388613) == 8388613 || (i5 & 5) == 5) ? this.f3141z ? rectF.left + c() : this.f3120e.right : this.f3141z ? this.f3120e.right : rectF.left + c();
    }

    private int s(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.F;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int t() {
        return s(this.f3126k);
    }

    private void w(TextPaint textPaint) {
        textPaint.setTextSize(this.f3125j);
        textPaint.setTypeface(this.f3134s);
    }

    private void x(TextPaint textPaint) {
        textPaint.setTextSize(this.f3124i);
        textPaint.setTypeface(this.f3135t);
    }

    private void y(float f4) {
        this.f3121f.left = C(this.f3119d.left, this.f3120e.left, f4, this.J);
        this.f3121f.top = C(this.f3128m, this.f3129n, f4, this.J);
        this.f3121f.right = C(this.f3119d.right, this.f3120e.right, f4, this.J);
        this.f3121f.bottom = C(this.f3119d.bottom, this.f3120e.bottom, f4, this.J);
    }

    private static boolean z(float f4, float f5) {
        return Math.abs(f4 - f5) < 0.001f;
    }

    public final boolean B() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f3127l;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f3126k) != null && colorStateList.isStateful());
    }

    void D() {
        this.f3117b = this.f3120e.width() > 0 && this.f3120e.height() > 0 && this.f3119d.width() > 0 && this.f3119d.height() > 0;
    }

    public void E() {
        if (this.f3116a.getHeight() <= 0 || this.f3116a.getWidth() <= 0) {
            return;
        }
        b();
        d();
    }

    public void G(int i4, int i5, int i6, int i7) {
        if (F(this.f3120e, i4, i5, i6, i7)) {
            return;
        }
        this.f3120e.set(i4, i5, i6, i7);
        this.G = true;
        D();
    }

    public void H(Rect rect) {
        G(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void I(int i4) {
        y0.d dVar = new y0.d(this.f3116a.getContext(), i4);
        ColorStateList colorStateList = dVar.f6571b;
        if (colorStateList != null) {
            this.f3127l = colorStateList;
        }
        float f4 = dVar.f6570a;
        if (f4 != 0.0f) {
            this.f3125j = f4;
        }
        ColorStateList colorStateList2 = dVar.f6578i;
        if (colorStateList2 != null) {
            this.O = colorStateList2;
        }
        this.M = dVar.f6579j;
        this.N = dVar.f6580k;
        this.L = dVar.f6581l;
        y0.a aVar = this.f3138w;
        if (aVar != null) {
            aVar.c();
        }
        this.f3138w = new y0.a(new C0031a(), dVar.e());
        dVar.h(this.f3116a.getContext(), this.f3138w);
        E();
    }

    public void K(ColorStateList colorStateList) {
        if (this.f3127l != colorStateList) {
            this.f3127l = colorStateList;
            E();
        }
    }

    public void L(int i4) {
        if (this.f3123h != i4) {
            this.f3123h = i4;
            E();
        }
    }

    public void M(Typeface typeface) {
        if (N(typeface)) {
            E();
        }
    }

    public void O(int i4, int i5, int i6, int i7) {
        if (F(this.f3119d, i4, i5, i6, i7)) {
            return;
        }
        this.f3119d.set(i4, i5, i6, i7);
        this.G = true;
        D();
    }

    public void P(Rect rect) {
        O(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void R(ColorStateList colorStateList) {
        if (this.f3126k != colorStateList) {
            this.f3126k = colorStateList;
            E();
        }
    }

    public void S(int i4) {
        if (this.f3122g != i4) {
            this.f3122g = i4;
            E();
        }
    }

    public void T(float f4) {
        if (this.f3124i != f4) {
            this.f3124i = f4;
            E();
        }
    }

    public void V(float f4) {
        float a5 = t.a.a(f4, 0.0f, 1.0f);
        if (a5 != this.f3118c) {
            this.f3118c = a5;
            d();
        }
    }

    public void X(TimeInterpolator timeInterpolator) {
        this.J = timeInterpolator;
        E();
    }

    public final boolean Y(int[] iArr) {
        this.F = iArr;
        if (!B()) {
            return false;
        }
        E();
        return true;
    }

    public void Z(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f3139x, charSequence)) {
            this.f3139x = charSequence;
            this.f3140y = null;
            h();
            E();
        }
    }

    public void a0(TimeInterpolator timeInterpolator) {
        this.K = timeInterpolator;
        E();
    }

    public void b0(Typeface typeface) {
        boolean N = N(typeface);
        boolean U = U(typeface);
        if (N || U) {
            E();
        }
    }

    public float c() {
        if (this.f3139x == null) {
            return 0.0f;
        }
        w(this.I);
        TextPaint textPaint = this.I;
        CharSequence charSequence = this.f3139x;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void j(Canvas canvas) {
        int save = canvas.save();
        if (this.f3140y == null || !this.f3117b) {
            return;
        }
        float lineLeft = (this.f3132q + this.T.getLineLeft(0)) - (this.W * 2.0f);
        this.H.setTextSize(this.E);
        float f4 = this.f3132q;
        float f5 = this.f3133r;
        boolean z4 = this.A && this.B != null;
        float lineAscent = this.T.getLineAscent(0);
        float f6 = this.D;
        if (f6 != 1.0f) {
            canvas.scale(f6, f6, f4, f5);
        }
        if (z4) {
            canvas.drawBitmap(this.B, f4, f5 + lineAscent, this.C);
            canvas.restoreToCount(save);
            return;
        }
        if (c0()) {
            k(canvas, lineLeft, f4, f5, lineAscent);
        } else {
            canvas.translate(f4, f5 + lineAscent);
            this.T.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public void m(RectF rectF, int i4, int i5) {
        this.f3141z = e(this.f3139x);
        rectF.left = p(i4, i5);
        rectF.top = this.f3120e.top;
        rectF.right = q(rectF, i4, i5);
        rectF.bottom = this.f3120e.top + o();
    }

    public ColorStateList n() {
        return this.f3127l;
    }

    public float o() {
        w(this.I);
        return -this.I.ascent();
    }

    public int r() {
        return s(this.f3127l);
    }

    public float u() {
        x(this.I);
        return -this.I.ascent();
    }

    public float v() {
        return this.f3118c;
    }
}
