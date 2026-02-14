package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import b1.g;
import b1.k;
import b1.n;
import com.google.android.material.internal.j;
import m0.b;
import y.p;
import y0.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {

    /* renamed from: s, reason: collision with root package name */
    private static final boolean f2844s = true;

    /* renamed from: a, reason: collision with root package name */
    private final MaterialButton f2845a;

    /* renamed from: b, reason: collision with root package name */
    private k f2846b;

    /* renamed from: c, reason: collision with root package name */
    private int f2847c;

    /* renamed from: d, reason: collision with root package name */
    private int f2848d;

    /* renamed from: e, reason: collision with root package name */
    private int f2849e;

    /* renamed from: f, reason: collision with root package name */
    private int f2850f;

    /* renamed from: g, reason: collision with root package name */
    private int f2851g;

    /* renamed from: h, reason: collision with root package name */
    private int f2852h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuff.Mode f2853i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f2854j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f2855k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f2856l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f2857m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f2858n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2859o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f2860p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2861q;

    /* renamed from: r, reason: collision with root package name */
    private LayerDrawable f2862r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MaterialButton materialButton, k kVar) {
        this.f2845a = materialButton;
        this.f2846b = kVar;
    }

    private void A(k kVar) {
        if (d() != null) {
            d().setShapeAppearanceModel(kVar);
        }
        if (l() != null) {
            l().setShapeAppearanceModel(kVar);
        }
        if (c() != null) {
            c().setShapeAppearanceModel(kVar);
        }
    }

    private void B() {
        g d5 = d();
        g l4 = l();
        if (d5 != null) {
            d5.a0(this.f2852h, this.f2855k);
            if (l4 != null) {
                l4.Z(this.f2852h, this.f2858n ? s0.a.c(this.f2845a, b.f4943k) : 0);
            }
        }
    }

    private InsetDrawable C(Drawable drawable) {
        return new InsetDrawable(drawable, this.f2847c, this.f2849e, this.f2848d, this.f2850f);
    }

    private Drawable a() {
        g gVar = new g(this.f2846b);
        gVar.M(this.f2845a.getContext());
        r.a.j(gVar, this.f2854j);
        PorterDuff.Mode mode = this.f2853i;
        if (mode != null) {
            r.a.k(gVar, mode);
        }
        gVar.a0(this.f2852h, this.f2855k);
        g gVar2 = new g(this.f2846b);
        gVar2.setTint(0);
        gVar2.Z(this.f2852h, this.f2858n ? s0.a.c(this.f2845a, b.f4943k) : 0);
        if (f2844s) {
            g gVar3 = new g(this.f2846b);
            this.f2857m = gVar3;
            r.a.i(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(z0.b.a(this.f2856l), C(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.f2857m);
            this.f2862r = rippleDrawable;
            return rippleDrawable;
        }
        z0.a aVar = new z0.a(this.f2846b);
        this.f2857m = aVar;
        r.a.j(aVar, z0.b.a(this.f2856l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.f2857m});
        this.f2862r = layerDrawable;
        return C(layerDrawable);
    }

    private g e(boolean z4) {
        LayerDrawable layerDrawable = this.f2862r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) (f2844s ? (LayerDrawable) ((InsetDrawable) this.f2862r.getDrawable(0)).getDrawable() : this.f2862r).getDrawable(!z4 ? 1 : 0);
    }

    private g l() {
        return e(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f2851g;
    }

    public n c() {
        LayerDrawable layerDrawable = this.f2862r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (n) (this.f2862r.getNumberOfLayers() > 2 ? this.f2862r.getDrawable(2) : this.f2862r.getDrawable(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g d() {
        return e(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f2856l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k g() {
        return this.f2846b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.f2855k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f2852h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.f2854j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        return this.f2853i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.f2859o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f2861q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(TypedArray typedArray) {
        this.f2847c = typedArray.getDimensionPixelOffset(m0.k.f5116m1, 0);
        this.f2848d = typedArray.getDimensionPixelOffset(m0.k.f5121n1, 0);
        this.f2849e = typedArray.getDimensionPixelOffset(m0.k.f5126o1, 0);
        this.f2850f = typedArray.getDimensionPixelOffset(m0.k.f5131p1, 0);
        int i4 = m0.k.f5151t1;
        if (typedArray.hasValue(i4)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i4, -1);
            this.f2851g = dimensionPixelSize;
            u(this.f2846b.w(dimensionPixelSize));
            this.f2860p = true;
        }
        this.f2852h = typedArray.getDimensionPixelSize(m0.k.D1, 0);
        this.f2853i = j.d(typedArray.getInt(m0.k.f5146s1, -1), PorterDuff.Mode.SRC_IN);
        this.f2854j = c.a(this.f2845a.getContext(), typedArray, m0.k.f5141r1);
        this.f2855k = c.a(this.f2845a.getContext(), typedArray, m0.k.C1);
        this.f2856l = c.a(this.f2845a.getContext(), typedArray, m0.k.B1);
        this.f2861q = typedArray.getBoolean(m0.k.f5136q1, false);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(m0.k.f5156u1, 0);
        int y4 = p.y(this.f2845a);
        int paddingTop = this.f2845a.getPaddingTop();
        int x4 = p.x(this.f2845a);
        int paddingBottom = this.f2845a.getPaddingBottom();
        this.f2845a.setInternalBackground(a());
        g d5 = d();
        if (d5 != null) {
            d5.U(dimensionPixelSize2);
        }
        p.m0(this.f2845a, y4 + this.f2847c, paddingTop + this.f2849e, x4 + this.f2848d, paddingBottom + this.f2850f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i4) {
        if (d() != null) {
            d().setTint(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f2859o = true;
        this.f2845a.setSupportBackgroundTintList(this.f2854j);
        this.f2845a.setSupportBackgroundTintMode(this.f2853i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z4) {
        this.f2861q = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i4) {
        if (this.f2860p && this.f2851g == i4) {
            return;
        }
        this.f2851g = i4;
        this.f2860p = true;
        u(this.f2846b.w(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(ColorStateList colorStateList) {
        if (this.f2856l != colorStateList) {
            this.f2856l = colorStateList;
            boolean z4 = f2844s;
            if (z4 && (this.f2845a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f2845a.getBackground()).setColor(z0.b.a(colorStateList));
            } else {
                if (z4 || !(this.f2845a.getBackground() instanceof z0.a)) {
                    return;
                }
                ((z0.a) this.f2845a.getBackground()).setTintList(z0.b.a(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(k kVar) {
        this.f2846b = kVar;
        A(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(boolean z4) {
        this.f2858n = z4;
        B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        if (this.f2855k != colorStateList) {
            this.f2855k = colorStateList;
            B();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(int i4) {
        if (this.f2852h != i4) {
            this.f2852h = i4;
            B();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(ColorStateList colorStateList) {
        if (this.f2854j != colorStateList) {
            this.f2854j = colorStateList;
            if (d() != null) {
                r.a.j(d(), this.f2854j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(PorterDuff.Mode mode) {
        if (this.f2853i != mode) {
            this.f2853i = mode;
            if (d() == null || this.f2853i == null) {
                return;
            }
            r.a.k(d(), this.f2853i);
        }
    }
}
