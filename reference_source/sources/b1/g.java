package b1;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import b1.k;
import b1.l;
import b1.m;
import java.util.BitSet;

/* loaded from: classes.dex */
public class g extends Drawable implements n {

    /* renamed from: x, reason: collision with root package name */
    private static final String f2133x = g.class.getSimpleName();

    /* renamed from: y, reason: collision with root package name */
    private static final Paint f2134y = new Paint(1);

    /* renamed from: b, reason: collision with root package name */
    private c f2135b;

    /* renamed from: c, reason: collision with root package name */
    private final m.g[] f2136c;

    /* renamed from: d, reason: collision with root package name */
    private final m.g[] f2137d;

    /* renamed from: e, reason: collision with root package name */
    private final BitSet f2138e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2139f;

    /* renamed from: g, reason: collision with root package name */
    private final Matrix f2140g;

    /* renamed from: h, reason: collision with root package name */
    private final Path f2141h;

    /* renamed from: i, reason: collision with root package name */
    private final Path f2142i;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f2143j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f2144k;

    /* renamed from: l, reason: collision with root package name */
    private final Region f2145l;

    /* renamed from: m, reason: collision with root package name */
    private final Region f2146m;

    /* renamed from: n, reason: collision with root package name */
    private k f2147n;

    /* renamed from: o, reason: collision with root package name */
    private final Paint f2148o;

    /* renamed from: p, reason: collision with root package name */
    private final Paint f2149p;

    /* renamed from: q, reason: collision with root package name */
    private final a1.a f2150q;

    /* renamed from: r, reason: collision with root package name */
    private final l.a f2151r;

    /* renamed from: s, reason: collision with root package name */
    private final l f2152s;

    /* renamed from: t, reason: collision with root package name */
    private PorterDuffColorFilter f2153t;

    /* renamed from: u, reason: collision with root package name */
    private PorterDuffColorFilter f2154u;

    /* renamed from: v, reason: collision with root package name */
    private final RectF f2155v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f2156w;

    /* loaded from: classes.dex */
    class a implements l.a {
        a() {
        }

        @Override // b1.l.a
        public void a(m mVar, Matrix matrix, int i4) {
            g.this.f2138e.set(i4, mVar.e());
            g.this.f2136c[i4] = mVar.f(matrix);
        }

        @Override // b1.l.a
        public void b(m mVar, Matrix matrix, int i4) {
            g.this.f2138e.set(i4 + 4, mVar.e());
            g.this.f2137d[i4] = mVar.f(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements k.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f2158a;

        b(float f4) {
            this.f2158a = f4;
        }

        @Override // b1.k.c
        public b1.c a(b1.c cVar) {
            return cVar instanceof i ? cVar : new b1.b(this.f2158a, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public k f2160a;

        /* renamed from: b, reason: collision with root package name */
        public u0.a f2161b;

        /* renamed from: c, reason: collision with root package name */
        public ColorFilter f2162c;

        /* renamed from: d, reason: collision with root package name */
        public ColorStateList f2163d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList f2164e;

        /* renamed from: f, reason: collision with root package name */
        public ColorStateList f2165f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f2166g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f2167h;

        /* renamed from: i, reason: collision with root package name */
        public Rect f2168i;

        /* renamed from: j, reason: collision with root package name */
        public float f2169j;

        /* renamed from: k, reason: collision with root package name */
        public float f2170k;

        /* renamed from: l, reason: collision with root package name */
        public float f2171l;

        /* renamed from: m, reason: collision with root package name */
        public int f2172m;

        /* renamed from: n, reason: collision with root package name */
        public float f2173n;

        /* renamed from: o, reason: collision with root package name */
        public float f2174o;

        /* renamed from: p, reason: collision with root package name */
        public float f2175p;

        /* renamed from: q, reason: collision with root package name */
        public int f2176q;

        /* renamed from: r, reason: collision with root package name */
        public int f2177r;

        /* renamed from: s, reason: collision with root package name */
        public int f2178s;

        /* renamed from: t, reason: collision with root package name */
        public int f2179t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f2180u;

        /* renamed from: v, reason: collision with root package name */
        public Paint.Style f2181v;

        public c(c cVar) {
            this.f2163d = null;
            this.f2164e = null;
            this.f2165f = null;
            this.f2166g = null;
            this.f2167h = PorterDuff.Mode.SRC_IN;
            this.f2168i = null;
            this.f2169j = 1.0f;
            this.f2170k = 1.0f;
            this.f2172m = 255;
            this.f2173n = 0.0f;
            this.f2174o = 0.0f;
            this.f2175p = 0.0f;
            this.f2176q = 0;
            this.f2177r = 0;
            this.f2178s = 0;
            this.f2179t = 0;
            this.f2180u = false;
            this.f2181v = Paint.Style.FILL_AND_STROKE;
            this.f2160a = cVar.f2160a;
            this.f2161b = cVar.f2161b;
            this.f2171l = cVar.f2171l;
            this.f2162c = cVar.f2162c;
            this.f2163d = cVar.f2163d;
            this.f2164e = cVar.f2164e;
            this.f2167h = cVar.f2167h;
            this.f2166g = cVar.f2166g;
            this.f2172m = cVar.f2172m;
            this.f2169j = cVar.f2169j;
            this.f2178s = cVar.f2178s;
            this.f2176q = cVar.f2176q;
            this.f2180u = cVar.f2180u;
            this.f2170k = cVar.f2170k;
            this.f2173n = cVar.f2173n;
            this.f2174o = cVar.f2174o;
            this.f2175p = cVar.f2175p;
            this.f2177r = cVar.f2177r;
            this.f2179t = cVar.f2179t;
            this.f2165f = cVar.f2165f;
            this.f2181v = cVar.f2181v;
            if (cVar.f2168i != null) {
                this.f2168i = new Rect(cVar.f2168i);
            }
        }

        public c(k kVar, u0.a aVar) {
            this.f2163d = null;
            this.f2164e = null;
            this.f2165f = null;
            this.f2166g = null;
            this.f2167h = PorterDuff.Mode.SRC_IN;
            this.f2168i = null;
            this.f2169j = 1.0f;
            this.f2170k = 1.0f;
            this.f2172m = 255;
            this.f2173n = 0.0f;
            this.f2174o = 0.0f;
            this.f2175p = 0.0f;
            this.f2176q = 0;
            this.f2177r = 0;
            this.f2178s = 0;
            this.f2179t = 0;
            this.f2180u = false;
            this.f2181v = Paint.Style.FILL_AND_STROKE;
            this.f2160a = kVar;
            this.f2161b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.f2139f = true;
            return gVar;
        }
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i4, int i5) {
        this(k.e(context, attributeSet, i4, i5).m());
    }

    private g(c cVar) {
        this.f2136c = new m.g[4];
        this.f2137d = new m.g[4];
        this.f2138e = new BitSet(8);
        this.f2140g = new Matrix();
        this.f2141h = new Path();
        this.f2142i = new Path();
        this.f2143j = new RectF();
        this.f2144k = new RectF();
        this.f2145l = new Region();
        this.f2146m = new Region();
        Paint paint = new Paint(1);
        this.f2148o = paint;
        Paint paint2 = new Paint(1);
        this.f2149p = paint2;
        this.f2150q = new a1.a();
        this.f2152s = new l();
        this.f2155v = new RectF();
        this.f2156w = true;
        this.f2135b = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = f2134y;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        e0();
        d0(getState());
        this.f2151r = new a();
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    private float D() {
        if (L()) {
            return this.f2149p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean J() {
        c cVar = this.f2135b;
        int i4 = cVar.f2176q;
        return i4 != 1 && cVar.f2177r > 0 && (i4 == 2 || T());
    }

    private boolean K() {
        Paint.Style style = this.f2135b.f2181v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean L() {
        Paint.Style style = this.f2135b.f2181v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f2149p.getStrokeWidth() > 0.0f;
    }

    private void N() {
        super.invalidateSelf();
    }

    private void Q(Canvas canvas) {
        if (J()) {
            canvas.save();
            S(canvas);
            if (this.f2156w) {
                int width = (int) (this.f2155v.width() - getBounds().width());
                int height = (int) (this.f2155v.height() - getBounds().height());
                if (width < 0 || height < 0) {
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                Bitmap createBitmap = Bitmap.createBitmap(((int) this.f2155v.width()) + (this.f2135b.f2177r * 2) + width, ((int) this.f2155v.height()) + (this.f2135b.f2177r * 2) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f4 = (getBounds().left - this.f2135b.f2177r) - width;
                float f5 = (getBounds().top - this.f2135b.f2177r) - height;
                canvas2.translate(-f4, -f5);
                n(canvas2);
                canvas.drawBitmap(createBitmap, f4, f5, (Paint) null);
                createBitmap.recycle();
            } else {
                n(canvas);
            }
            canvas.restore();
        }
    }

    private static int R(int i4, int i5) {
        return (i4 * (i5 + (i5 >>> 7))) >>> 8;
    }

    private void S(Canvas canvas) {
        canvas.translate(z(), A());
    }

    private boolean T() {
        return (P() || this.f2141h.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    private boolean d0(int[] iArr) {
        boolean z4;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f2135b.f2163d == null || color2 == (colorForState2 = this.f2135b.f2163d.getColorForState(iArr, (color2 = this.f2148o.getColor())))) {
            z4 = false;
        } else {
            this.f2148o.setColor(colorForState2);
            z4 = true;
        }
        if (this.f2135b.f2164e == null || color == (colorForState = this.f2135b.f2164e.getColorForState(iArr, (color = this.f2149p.getColor())))) {
            return z4;
        }
        this.f2149p.setColor(colorForState);
        return true;
    }

    private boolean e0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f2153t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f2154u;
        c cVar = this.f2135b;
        this.f2153t = k(cVar.f2166g, cVar.f2167h, this.f2148o, true);
        c cVar2 = this.f2135b;
        this.f2154u = k(cVar2.f2165f, cVar2.f2167h, this.f2149p, false);
        c cVar3 = this.f2135b;
        if (cVar3.f2180u) {
            this.f2150q.d(cVar3.f2166g.getColorForState(getState(), 0));
        }
        return (x.c.a(porterDuffColorFilter, this.f2153t) && x.c.a(porterDuffColorFilter2, this.f2154u)) ? false : true;
    }

    private PorterDuffColorFilter f(Paint paint, boolean z4) {
        int color;
        int l4;
        if (!z4 || (l4 = l((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(l4, PorterDuff.Mode.SRC_IN);
    }

    private void f0() {
        float I = I();
        this.f2135b.f2177r = (int) Math.ceil(0.75f * I);
        this.f2135b.f2178s = (int) Math.ceil(I * 0.25f);
        e0();
        N();
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f2135b.f2169j != 1.0f) {
            this.f2140g.reset();
            Matrix matrix = this.f2140g;
            float f4 = this.f2135b.f2169j;
            matrix.setScale(f4, f4, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f2140g);
        }
        path.computeBounds(this.f2155v, true);
    }

    private void i() {
        k x4 = C().x(new b(-D()));
        this.f2147n = x4;
        this.f2152s.d(x4, this.f2135b.f2170k, v(), this.f2142i);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z4) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z4) {
            colorForState = l(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z4) {
        return (colorStateList == null || mode == null) ? f(paint, z4) : j(colorStateList, mode, z4);
    }

    private int l(int i4) {
        float I = I() + y();
        u0.a aVar = this.f2135b.f2161b;
        return aVar != null ? aVar.c(i4, I) : i4;
    }

    public static g m(Context context, float f4) {
        int b5 = s0.a.b(context, m0.b.f4943k, g.class.getSimpleName());
        g gVar = new g();
        gVar.M(context);
        gVar.V(ColorStateList.valueOf(b5));
        gVar.U(f4);
        return gVar;
    }

    private void n(Canvas canvas) {
        if (this.f2138e.cardinality() > 0) {
            Log.w(f2133x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f2135b.f2178s != 0) {
            canvas.drawPath(this.f2141h, this.f2150q.c());
        }
        for (int i4 = 0; i4 < 4; i4++) {
            this.f2136c[i4].a(this.f2150q, this.f2135b.f2177r, canvas);
            this.f2137d[i4].a(this.f2150q, this.f2135b.f2177r, canvas);
        }
        if (this.f2156w) {
            int z4 = z();
            int A = A();
            canvas.translate(-z4, -A);
            canvas.drawPath(this.f2141h, f2134y);
            canvas.translate(z4, A);
        }
    }

    private void o(Canvas canvas) {
        q(canvas, this.f2148o, this.f2141h, this.f2135b.f2160a, u());
    }

    private void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float a5 = kVar.t().a(rectF) * this.f2135b.f2170k;
            canvas.drawRoundRect(rectF, a5, a5, paint);
        }
    }

    private void r(Canvas canvas) {
        q(canvas, this.f2149p, this.f2142i, this.f2147n, v());
    }

    private RectF v() {
        this.f2144k.set(u());
        float D = D();
        this.f2144k.inset(D, D);
        return this.f2144k;
    }

    public int A() {
        c cVar = this.f2135b;
        return (int) (cVar.f2178s * Math.cos(Math.toRadians(cVar.f2179t)));
    }

    public int B() {
        return this.f2135b.f2177r;
    }

    public k C() {
        return this.f2135b.f2160a;
    }

    public ColorStateList E() {
        return this.f2135b.f2166g;
    }

    public float F() {
        return this.f2135b.f2160a.r().a(u());
    }

    public float G() {
        return this.f2135b.f2160a.t().a(u());
    }

    public float H() {
        return this.f2135b.f2175p;
    }

    public float I() {
        return w() + H();
    }

    public void M(Context context) {
        this.f2135b.f2161b = new u0.a(context);
        f0();
    }

    public boolean O() {
        u0.a aVar = this.f2135b.f2161b;
        return aVar != null && aVar.d();
    }

    public boolean P() {
        return this.f2135b.f2160a.u(u());
    }

    public void U(float f4) {
        c cVar = this.f2135b;
        if (cVar.f2174o != f4) {
            cVar.f2174o = f4;
            f0();
        }
    }

    public void V(ColorStateList colorStateList) {
        c cVar = this.f2135b;
        if (cVar.f2163d != colorStateList) {
            cVar.f2163d = colorStateList;
            onStateChange(getState());
        }
    }

    public void W(float f4) {
        c cVar = this.f2135b;
        if (cVar.f2170k != f4) {
            cVar.f2170k = f4;
            this.f2139f = true;
            invalidateSelf();
        }
    }

    public void X(int i4, int i5, int i6, int i7) {
        c cVar = this.f2135b;
        if (cVar.f2168i == null) {
            cVar.f2168i = new Rect();
        }
        this.f2135b.f2168i.set(i4, i5, i6, i7);
        invalidateSelf();
    }

    public void Y(float f4) {
        c cVar = this.f2135b;
        if (cVar.f2173n != f4) {
            cVar.f2173n = f4;
            f0();
        }
    }

    public void Z(float f4, int i4) {
        c0(f4);
        b0(ColorStateList.valueOf(i4));
    }

    public void a0(float f4, ColorStateList colorStateList) {
        c0(f4);
        b0(colorStateList);
    }

    public void b0(ColorStateList colorStateList) {
        c cVar = this.f2135b;
        if (cVar.f2164e != colorStateList) {
            cVar.f2164e = colorStateList;
            onStateChange(getState());
        }
    }

    public void c0(float f4) {
        this.f2135b.f2171l = f4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2148o.setColorFilter(this.f2153t);
        int alpha = this.f2148o.getAlpha();
        this.f2148o.setAlpha(R(alpha, this.f2135b.f2172m));
        this.f2149p.setColorFilter(this.f2154u);
        this.f2149p.setStrokeWidth(this.f2135b.f2171l);
        int alpha2 = this.f2149p.getAlpha();
        this.f2149p.setAlpha(R(alpha2, this.f2135b.f2172m));
        if (this.f2139f) {
            i();
            g(u(), this.f2141h);
            this.f2139f = false;
        }
        Q(canvas);
        if (K()) {
            o(canvas);
        }
        if (L()) {
            r(canvas);
        }
        this.f2148o.setAlpha(alpha);
        this.f2149p.setAlpha(alpha2);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f2135b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f2135b.f2176q == 2) {
            return;
        }
        if (P()) {
            outline.setRoundRect(getBounds(), F() * this.f2135b.f2170k);
            return;
        }
        g(u(), this.f2141h);
        if (this.f2141h.isConvex() || Build.VERSION.SDK_INT >= 29) {
            outline.setConvexPath(this.f2141h);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f2135b.f2168i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f2145l.set(getBounds());
        g(u(), this.f2141h);
        this.f2146m.setPath(this.f2141h, this.f2145l);
        this.f2145l.op(this.f2146m, Region.Op.DIFFERENCE);
        return this.f2145l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(RectF rectF, Path path) {
        l lVar = this.f2152s;
        c cVar = this.f2135b;
        lVar.e(cVar.f2160a, cVar.f2170k, rectF, this.f2151r, path);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f2139f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f2135b.f2166g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f2135b.f2165f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f2135b.f2164e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f2135b.f2163d) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f2135b = new c(this.f2135b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f2139f = true;
        super.onBoundsChange(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z4 = d0(iArr) || e0();
        if (z4) {
            invalidateSelf();
        }
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f2135b.f2160a, rectF);
    }

    public float s() {
        return this.f2135b.f2160a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        c cVar = this.f2135b;
        if (cVar.f2172m != i4) {
            cVar.f2172m = i4;
            N();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2135b.f2162c = colorFilter;
        N();
    }

    @Override // b1.n
    public void setShapeAppearanceModel(k kVar) {
        this.f2135b.f2160a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i4) {
        setTintList(ColorStateList.valueOf(i4));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2135b.f2166g = colorStateList;
        e0();
        N();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f2135b;
        if (cVar.f2167h != mode) {
            cVar.f2167h = mode;
            e0();
            N();
        }
    }

    public float t() {
        return this.f2135b.f2160a.l().a(u());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF u() {
        this.f2143j.set(getBounds());
        return this.f2143j;
    }

    public float w() {
        return this.f2135b.f2174o;
    }

    public ColorStateList x() {
        return this.f2135b.f2163d;
    }

    public float y() {
        return this.f2135b.f2173n;
    }

    public int z() {
        c cVar = this.f2135b;
        return (int) (cVar.f2178s * Math.sin(Math.toRadians(cVar.f2179t)));
    }
}
