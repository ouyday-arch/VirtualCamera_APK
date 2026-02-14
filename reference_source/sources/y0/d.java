package y0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import m0.k;
import p.b;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final float f6570a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f6571b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f6572c;

    /* renamed from: d, reason: collision with root package name */
    public final ColorStateList f6573d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6574e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6575f;

    /* renamed from: g, reason: collision with root package name */
    public final String f6576g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f6577h;

    /* renamed from: i, reason: collision with root package name */
    public final ColorStateList f6578i;

    /* renamed from: j, reason: collision with root package name */
    public final float f6579j;

    /* renamed from: k, reason: collision with root package name */
    public final float f6580k;

    /* renamed from: l, reason: collision with root package name */
    public final float f6581l;

    /* renamed from: m, reason: collision with root package name */
    private final int f6582m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6583n = false;

    /* renamed from: o, reason: collision with root package name */
    private Typeface f6584o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f6585a;

        a(f fVar) {
            this.f6585a = fVar;
        }

        @Override // p.b.a
        public void c(int i4) {
            d.this.f6583n = true;
            this.f6585a.a(i4);
        }

        @Override // p.b.a
        public void d(Typeface typeface) {
            d dVar = d.this;
            dVar.f6584o = Typeface.create(typeface, dVar.f6574e);
            d.this.f6583n = true;
            this.f6585a.b(d.this.f6584o, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextPaint f6587a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f6588b;

        b(TextPaint textPaint, f fVar) {
            this.f6587a = textPaint;
            this.f6588b = fVar;
        }

        @Override // y0.f
        public void a(int i4) {
            this.f6588b.a(i4);
        }

        @Override // y0.f
        public void b(Typeface typeface, boolean z4) {
            d.this.k(this.f6587a, typeface);
            this.f6588b.b(typeface, z4);
        }
    }

    public d(Context context, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i4, k.f5083f3);
        this.f6570a = obtainStyledAttributes.getDimension(k.f5088g3, 0.0f);
        this.f6571b = c.a(context, obtainStyledAttributes, k.f5103j3);
        this.f6572c = c.a(context, obtainStyledAttributes, k.f5108k3);
        this.f6573d = c.a(context, obtainStyledAttributes, k.f5113l3);
        this.f6574e = obtainStyledAttributes.getInt(k.f5098i3, 0);
        this.f6575f = obtainStyledAttributes.getInt(k.f5093h3, 1);
        int e4 = c.e(obtainStyledAttributes, k.f5143r3, k.f5138q3);
        this.f6582m = obtainStyledAttributes.getResourceId(e4, 0);
        this.f6576g = obtainStyledAttributes.getString(e4);
        this.f6577h = obtainStyledAttributes.getBoolean(k.f5148s3, false);
        this.f6578i = c.a(context, obtainStyledAttributes, k.f5118m3);
        this.f6579j = obtainStyledAttributes.getFloat(k.f5123n3, 0.0f);
        this.f6580k = obtainStyledAttributes.getFloat(k.f5128o3, 0.0f);
        this.f6581l = obtainStyledAttributes.getFloat(k.f5133p3, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private void d() {
        String str;
        if (this.f6584o == null && (str = this.f6576g) != null) {
            this.f6584o = Typeface.create(str, this.f6574e);
        }
        if (this.f6584o == null) {
            int i4 = this.f6575f;
            this.f6584o = i4 != 1 ? i4 != 2 ? i4 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.f6584o = Typeface.create(this.f6584o, this.f6574e);
        }
    }

    public Typeface e() {
        d();
        return this.f6584o;
    }

    public Typeface f(Context context) {
        if (this.f6583n) {
            return this.f6584o;
        }
        if (!context.isRestricted()) {
            try {
                Typeface b5 = p.b.b(context, this.f6582m);
                this.f6584o = b5;
                if (b5 != null) {
                    this.f6584o = Typeface.create(b5, this.f6574e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e4) {
                Log.d("TextAppearance", "Error loading font " + this.f6576g, e4);
            }
        }
        d();
        this.f6583n = true;
        return this.f6584o;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        k(textPaint, e());
        h(context, new b(textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (e.a()) {
            f(context);
        } else {
            d();
        }
        int i4 = this.f6582m;
        if (i4 == 0) {
            this.f6583n = true;
        }
        if (this.f6583n) {
            fVar.b(this.f6584o, true);
            return;
        }
        try {
            p.b.d(context, i4, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f6583n = true;
            fVar.a(1);
        } catch (Exception e4) {
            Log.d("TextAppearance", "Error loading font " + this.f6576g, e4);
            this.f6583n = true;
            fVar.a(-3);
        }
    }

    public void i(Context context, TextPaint textPaint, f fVar) {
        j(context, textPaint, fVar);
        ColorStateList colorStateList = this.f6571b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f4 = this.f6581l;
        float f5 = this.f6579j;
        float f6 = this.f6580k;
        ColorStateList colorStateList2 = this.f6578i;
        textPaint.setShadowLayer(f4, f5, f6, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void j(Context context, TextPaint textPaint, f fVar) {
        if (e.a()) {
            k(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void k(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i4 = (~typeface.getStyle()) & this.f6574e;
        textPaint.setFakeBoldText((i4 & 1) != 0);
        textPaint.setTextSkewX((i4 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f6570a);
    }
}
