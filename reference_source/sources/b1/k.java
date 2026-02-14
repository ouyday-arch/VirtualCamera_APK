package b1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* loaded from: classes.dex */
public class k {

    /* renamed from: m, reason: collision with root package name */
    public static final b1.c f2184m = new i(0.5f);

    /* renamed from: a, reason: collision with root package name */
    d f2185a;

    /* renamed from: b, reason: collision with root package name */
    d f2186b;

    /* renamed from: c, reason: collision with root package name */
    d f2187c;

    /* renamed from: d, reason: collision with root package name */
    d f2188d;

    /* renamed from: e, reason: collision with root package name */
    b1.c f2189e;

    /* renamed from: f, reason: collision with root package name */
    b1.c f2190f;

    /* renamed from: g, reason: collision with root package name */
    b1.c f2191g;

    /* renamed from: h, reason: collision with root package name */
    b1.c f2192h;

    /* renamed from: i, reason: collision with root package name */
    f f2193i;

    /* renamed from: j, reason: collision with root package name */
    f f2194j;

    /* renamed from: k, reason: collision with root package name */
    f f2195k;

    /* renamed from: l, reason: collision with root package name */
    f f2196l;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private d f2197a;

        /* renamed from: b, reason: collision with root package name */
        private d f2198b;

        /* renamed from: c, reason: collision with root package name */
        private d f2199c;

        /* renamed from: d, reason: collision with root package name */
        private d f2200d;

        /* renamed from: e, reason: collision with root package name */
        private b1.c f2201e;

        /* renamed from: f, reason: collision with root package name */
        private b1.c f2202f;

        /* renamed from: g, reason: collision with root package name */
        private b1.c f2203g;

        /* renamed from: h, reason: collision with root package name */
        private b1.c f2204h;

        /* renamed from: i, reason: collision with root package name */
        private f f2205i;

        /* renamed from: j, reason: collision with root package name */
        private f f2206j;

        /* renamed from: k, reason: collision with root package name */
        private f f2207k;

        /* renamed from: l, reason: collision with root package name */
        private f f2208l;

        public b() {
            this.f2197a = h.b();
            this.f2198b = h.b();
            this.f2199c = h.b();
            this.f2200d = h.b();
            this.f2201e = new b1.a(0.0f);
            this.f2202f = new b1.a(0.0f);
            this.f2203g = new b1.a(0.0f);
            this.f2204h = new b1.a(0.0f);
            this.f2205i = h.c();
            this.f2206j = h.c();
            this.f2207k = h.c();
            this.f2208l = h.c();
        }

        public b(k kVar) {
            this.f2197a = h.b();
            this.f2198b = h.b();
            this.f2199c = h.b();
            this.f2200d = h.b();
            this.f2201e = new b1.a(0.0f);
            this.f2202f = new b1.a(0.0f);
            this.f2203g = new b1.a(0.0f);
            this.f2204h = new b1.a(0.0f);
            this.f2205i = h.c();
            this.f2206j = h.c();
            this.f2207k = h.c();
            this.f2208l = h.c();
            this.f2197a = kVar.f2185a;
            this.f2198b = kVar.f2186b;
            this.f2199c = kVar.f2187c;
            this.f2200d = kVar.f2188d;
            this.f2201e = kVar.f2189e;
            this.f2202f = kVar.f2190f;
            this.f2203g = kVar.f2191g;
            this.f2204h = kVar.f2192h;
            this.f2205i = kVar.f2193i;
            this.f2206j = kVar.f2194j;
            this.f2207k = kVar.f2195k;
            this.f2208l = kVar.f2196l;
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f2183a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f2132a;
            }
            return -1.0f;
        }

        public b A(b1.c cVar) {
            this.f2201e = cVar;
            return this;
        }

        public b B(int i4, b1.c cVar) {
            return C(h.a(i4)).E(cVar);
        }

        public b C(d dVar) {
            this.f2198b = dVar;
            float n4 = n(dVar);
            if (n4 != -1.0f) {
                D(n4);
            }
            return this;
        }

        public b D(float f4) {
            this.f2202f = new b1.a(f4);
            return this;
        }

        public b E(b1.c cVar) {
            this.f2202f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f4) {
            return z(f4).D(f4).v(f4).r(f4);
        }

        public b p(int i4, b1.c cVar) {
            return q(h.a(i4)).s(cVar);
        }

        public b q(d dVar) {
            this.f2200d = dVar;
            float n4 = n(dVar);
            if (n4 != -1.0f) {
                r(n4);
            }
            return this;
        }

        public b r(float f4) {
            this.f2204h = new b1.a(f4);
            return this;
        }

        public b s(b1.c cVar) {
            this.f2204h = cVar;
            return this;
        }

        public b t(int i4, b1.c cVar) {
            return u(h.a(i4)).w(cVar);
        }

        public b u(d dVar) {
            this.f2199c = dVar;
            float n4 = n(dVar);
            if (n4 != -1.0f) {
                v(n4);
            }
            return this;
        }

        public b v(float f4) {
            this.f2203g = new b1.a(f4);
            return this;
        }

        public b w(b1.c cVar) {
            this.f2203g = cVar;
            return this;
        }

        public b x(int i4, b1.c cVar) {
            return y(h.a(i4)).A(cVar);
        }

        public b y(d dVar) {
            this.f2197a = dVar;
            float n4 = n(dVar);
            if (n4 != -1.0f) {
                z(n4);
            }
            return this;
        }

        public b z(float f4) {
            this.f2201e = new b1.a(f4);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        b1.c a(b1.c cVar);
    }

    public k() {
        this.f2185a = h.b();
        this.f2186b = h.b();
        this.f2187c = h.b();
        this.f2188d = h.b();
        this.f2189e = new b1.a(0.0f);
        this.f2190f = new b1.a(0.0f);
        this.f2191g = new b1.a(0.0f);
        this.f2192h = new b1.a(0.0f);
        this.f2193i = h.c();
        this.f2194j = h.c();
        this.f2195k = h.c();
        this.f2196l = h.c();
    }

    private k(b bVar) {
        this.f2185a = bVar.f2197a;
        this.f2186b = bVar.f2198b;
        this.f2187c = bVar.f2199c;
        this.f2188d = bVar.f2200d;
        this.f2189e = bVar.f2201e;
        this.f2190f = bVar.f2202f;
        this.f2191g = bVar.f2203g;
        this.f2192h = bVar.f2204h;
        this.f2193i = bVar.f2205i;
        this.f2194j = bVar.f2206j;
        this.f2195k = bVar.f2207k;
        this.f2196l = bVar.f2208l;
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i4, int i5) {
        return c(context, i4, i5, 0);
    }

    private static b c(Context context, int i4, int i5, int i6) {
        return d(context, i4, i5, new b1.a(i6));
    }

    private static b d(Context context, int i4, int i5, b1.c cVar) {
        if (i5 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i4);
            i4 = i5;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i4, m0.k.B2);
        try {
            int i6 = obtainStyledAttributes.getInt(m0.k.C2, 0);
            int i7 = obtainStyledAttributes.getInt(m0.k.F2, i6);
            int i8 = obtainStyledAttributes.getInt(m0.k.G2, i6);
            int i9 = obtainStyledAttributes.getInt(m0.k.E2, i6);
            int i10 = obtainStyledAttributes.getInt(m0.k.D2, i6);
            b1.c m4 = m(obtainStyledAttributes, m0.k.H2, cVar);
            b1.c m5 = m(obtainStyledAttributes, m0.k.K2, m4);
            b1.c m6 = m(obtainStyledAttributes, m0.k.L2, m4);
            b1.c m7 = m(obtainStyledAttributes, m0.k.J2, m4);
            return new b().x(i7, m5).B(i8, m6).t(i9, m7).p(i10, m(obtainStyledAttributes, m0.k.I2, m4));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i4, int i5) {
        return f(context, attributeSet, i4, i5, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i4, int i5, int i6) {
        return g(context, attributeSet, i4, i5, new b1.a(i6));
    }

    public static b g(Context context, AttributeSet attributeSet, int i4, int i5, b1.c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.k.f5082f2, i4, i5);
        int resourceId = obtainStyledAttributes.getResourceId(m0.k.f5087g2, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(m0.k.f5092h2, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static b1.c m(TypedArray typedArray, int i4, b1.c cVar) {
        TypedValue peekValue = typedArray.peekValue(i4);
        if (peekValue == null) {
            return cVar;
        }
        int i5 = peekValue.type;
        return i5 == 5 ? new b1.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i5 == 6 ? new i(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.f2195k;
    }

    public d i() {
        return this.f2188d;
    }

    public b1.c j() {
        return this.f2192h;
    }

    public d k() {
        return this.f2187c;
    }

    public b1.c l() {
        return this.f2191g;
    }

    public f n() {
        return this.f2196l;
    }

    public f o() {
        return this.f2194j;
    }

    public f p() {
        return this.f2193i;
    }

    public d q() {
        return this.f2185a;
    }

    public b1.c r() {
        return this.f2189e;
    }

    public d s() {
        return this.f2186b;
    }

    public b1.c t() {
        return this.f2190f;
    }

    public boolean u(RectF rectF) {
        boolean z4 = this.f2196l.getClass().equals(f.class) && this.f2194j.getClass().equals(f.class) && this.f2193i.getClass().equals(f.class) && this.f2195k.getClass().equals(f.class);
        float a5 = this.f2189e.a(rectF);
        return z4 && ((this.f2190f.a(rectF) > a5 ? 1 : (this.f2190f.a(rectF) == a5 ? 0 : -1)) == 0 && (this.f2192h.a(rectF) > a5 ? 1 : (this.f2192h.a(rectF) == a5 ? 0 : -1)) == 0 && (this.f2191g.a(rectF) > a5 ? 1 : (this.f2191g.a(rectF) == a5 ? 0 : -1)) == 0) && ((this.f2186b instanceof j) && (this.f2185a instanceof j) && (this.f2187c instanceof j) && (this.f2188d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f4) {
        return v().o(f4).m();
    }

    public k x(c cVar) {
        return v().A(cVar.a(r())).E(cVar.a(t())).s(cVar.a(j())).w(cVar.a(l())).m();
    }
}
