package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.m0;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f1037b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private static j f1038c;

    /* renamed from: a, reason: collision with root package name */
    private m0 f1039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements m0.c {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f1040a = {a.e.S, a.e.Q, a.e.f46a};

        /* renamed from: b, reason: collision with root package name */
        private final int[] f1041b = {a.e.f60o, a.e.B, a.e.f65t, a.e.f61p, a.e.f62q, a.e.f64s, a.e.f63r};

        /* renamed from: c, reason: collision with root package name */
        private final int[] f1042c = {a.e.P, a.e.R, a.e.f56k, a.e.I, a.e.J, a.e.L, a.e.N, a.e.K, a.e.M, a.e.O};

        /* renamed from: d, reason: collision with root package name */
        private final int[] f1043d = {a.e.f68w, a.e.f54i, a.e.f67v};

        /* renamed from: e, reason: collision with root package name */
        private final int[] f1044e = {a.e.H, a.e.T};

        /* renamed from: f, reason: collision with root package name */
        private final int[] f1045f = {a.e.f48c, a.e.f52g, a.e.f49d, a.e.f53h};

        a() {
        }

        private boolean f(int[] iArr, int i4) {
            for (int i5 : iArr) {
                if (i5 == i4) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i4) {
            int b5 = r0.b(context, a.a.f21v);
            return new ColorStateList(new int[][]{r0.f1160b, r0.f1163e, r0.f1161c, r0.f1167i}, new int[]{r0.a(context, a.a.f19t), q.a.b(b5, i4), q.a.b(b5, i4), i4});
        }

        private ColorStateList i(Context context) {
            return h(context, r0.b(context, a.a.f18s));
        }

        private ColorStateList j(Context context) {
            return h(context, r0.b(context, a.a.f19t));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            int i4 = a.a.f23x;
            ColorStateList d5 = r0.d(context, i4);
            if (d5 == null || !d5.isStateful()) {
                iArr[0] = r0.f1160b;
                iArr2[0] = r0.a(context, i4);
                iArr[1] = r0.f1164f;
                iArr2[1] = r0.b(context, a.a.f20u);
                iArr[2] = r0.f1167i;
                iArr2[2] = r0.b(context, i4);
            } else {
                iArr[0] = r0.f1160b;
                iArr2[0] = d5.getColorForState(iArr[0], 0);
                iArr[1] = r0.f1164f;
                iArr2[1] = r0.b(context, a.a.f20u);
                iArr[2] = r0.f1167i;
                iArr2[2] = d5.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private void l(Drawable drawable, int i4, PorterDuff.Mode mode) {
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = j.f1037b;
            }
            drawable.setColorFilter(j.e(i4, mode));
        }

        @Override // androidx.appcompat.widget.m0.c
        public Drawable a(m0 m0Var, Context context, int i4) {
            if (i4 == a.e.f55j) {
                return new LayerDrawable(new Drawable[]{m0Var.i(context, a.e.f54i), m0Var.i(context, a.e.f56k)});
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0061 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
        @Override // androidx.appcompat.widget.m0.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.j.a()
                int[] r1 = r6.f1040a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L17
                int r2 = a.a.f22w
            L14:
                r8 = r3
            L15:
                r1 = r5
                goto L44
            L17:
                int[] r1 = r6.f1042c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L22
                int r2 = a.a.f20u
                goto L14
            L22:
                int[] r1 = r6.f1043d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L2d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L14
            L2d:
                int r1 = a.e.f66u
                if (r8 != r1) goto L3c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L15
            L3c:
                int r1 = a.e.f57l
                if (r8 != r1) goto L41
                goto L14
            L41:
                r8 = r3
                r1 = r4
                r2 = r1
            L44:
                if (r1 == 0) goto L61
                boolean r1 = androidx.appcompat.widget.e0.a(r9)
                if (r1 == 0) goto L50
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L50:
                int r7 = androidx.appcompat.widget.r0.b(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.j.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L60
                r9.setAlpha(r8)
            L60:
                return r5
            L61:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.m0.c
        public ColorStateList c(Context context, int i4) {
            if (i4 == a.e.f58m) {
                return c.a.a(context, a.c.f30d);
            }
            if (i4 == a.e.G) {
                return c.a.a(context, a.c.f33g);
            }
            if (i4 == a.e.F) {
                return k(context);
            }
            if (i4 == a.e.f51f) {
                return j(context);
            }
            if (i4 == a.e.f47b) {
                return g(context);
            }
            if (i4 == a.e.f50e) {
                return i(context);
            }
            if (i4 == a.e.D || i4 == a.e.E) {
                return c.a.a(context, a.c.f32f);
            }
            if (f(this.f1041b, i4)) {
                return r0.d(context, a.a.f22w);
            }
            if (f(this.f1044e, i4)) {
                return c.a.a(context, a.c.f29c);
            }
            if (f(this.f1045f, i4)) {
                return c.a.a(context, a.c.f28b);
            }
            if (i4 == a.e.A) {
                return c.a.a(context, a.c.f31e);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.m0.c
        public boolean d(Context context, int i4, Drawable drawable) {
            Drawable findDrawableByLayerId;
            int b5;
            if (i4 == a.e.C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(R.id.background);
                int i5 = a.a.f22w;
                l(findDrawableByLayerId2, r0.b(context, i5), j.f1037b);
                l(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), r0.b(context, i5), j.f1037b);
                findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.progress);
                b5 = r0.b(context, a.a.f20u);
            } else {
                if (i4 != a.e.f70y && i4 != a.e.f69x && i4 != a.e.f71z) {
                    return false;
                }
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                l(layerDrawable2.findDrawableByLayerId(R.id.background), r0.a(context, a.a.f22w), j.f1037b);
                Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
                int i6 = a.a.f20u;
                l(findDrawableByLayerId3, r0.b(context, i6), j.f1037b);
                findDrawableByLayerId = layerDrawable2.findDrawableByLayerId(R.id.progress);
                b5 = r0.b(context, i6);
            }
            l(findDrawableByLayerId, b5, j.f1037b);
            return true;
        }

        @Override // androidx.appcompat.widget.m0.c
        public PorterDuff.Mode e(int i4) {
            if (i4 == a.e.F) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized j b() {
        j jVar;
        synchronized (j.class) {
            if (f1038c == null) {
                h();
            }
            jVar = f1038c;
        }
        return jVar;
    }

    public static synchronized PorterDuffColorFilter e(int i4, PorterDuff.Mode mode) {
        PorterDuffColorFilter k4;
        synchronized (j.class) {
            k4 = m0.k(i4, mode);
        }
        return k4;
    }

    public static synchronized void h() {
        synchronized (j.class) {
            if (f1038c == null) {
                j jVar = new j();
                f1038c = jVar;
                jVar.f1039a = m0.g();
                f1038c.f1039a.t(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Drawable drawable, u0 u0Var, int[] iArr) {
        m0.v(drawable, u0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i4) {
        return this.f1039a.i(context, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i4, boolean z4) {
        return this.f1039a.j(context, i4, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i4) {
        return this.f1039a.l(context, i4);
    }

    public synchronized void g(Context context) {
        this.f1039a.r(context);
    }
}
