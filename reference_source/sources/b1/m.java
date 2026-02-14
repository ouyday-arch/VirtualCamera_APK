package b1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f2224a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f2225b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f2226c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f2227d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f2228e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f2229f;

    /* renamed from: g, reason: collision with root package name */
    private final List<f> f2230g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<g> f2231h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private boolean f2232i;

    /* loaded from: classes.dex */
    class a extends g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f2233b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Matrix f2234c;

        a(List list, Matrix matrix) {
            this.f2233b = list;
            this.f2234c = matrix;
        }

        @Override // b1.m.g
        public void b(Matrix matrix, a1.a aVar, int i4, Canvas canvas) {
            Iterator it = this.f2233b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(this.f2234c, aVar, i4, canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: b, reason: collision with root package name */
        private final d f2236b;

        public b(d dVar) {
            this.f2236b = dVar;
        }

        @Override // b1.m.g
        public void b(Matrix matrix, a1.a aVar, int i4, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f2236b.k(), this.f2236b.o(), this.f2236b.l(), this.f2236b.j()), i4, this.f2236b.m(), this.f2236b.n());
        }
    }

    /* loaded from: classes.dex */
    static class c extends g {

        /* renamed from: b, reason: collision with root package name */
        private final e f2237b;

        /* renamed from: c, reason: collision with root package name */
        private final float f2238c;

        /* renamed from: d, reason: collision with root package name */
        private final float f2239d;

        public c(e eVar, float f4, float f5) {
            this.f2237b = eVar;
            this.f2238c = f4;
            this.f2239d = f5;
        }

        @Override // b1.m.g
        public void b(Matrix matrix, a1.a aVar, int i4, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f2237b.f2248c - this.f2239d, this.f2237b.f2247b - this.f2238c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f2238c, this.f2239d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i4);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f2237b.f2248c - this.f2239d) / (this.f2237b.f2247b - this.f2238c)));
        }
    }

    /* loaded from: classes.dex */
    public static class d extends f {

        /* renamed from: h, reason: collision with root package name */
        private static final RectF f2240h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f2241b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f2242c;

        /* renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f2243d;

        /* renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f2244e;

        /* renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f2245f;

        /* renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f2246g;

        public d(float f4, float f5, float f6, float f7) {
            q(f4);
            u(f5);
            r(f6);
            p(f7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f2244e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f2241b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f2243d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f2245f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f2246g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f2242c;
        }

        private void p(float f4) {
            this.f2244e = f4;
        }

        private void q(float f4) {
            this.f2241b = f4;
        }

        private void r(float f4) {
            this.f2243d = f4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f4) {
            this.f2245f = f4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f4) {
            this.f2246g = f4;
        }

        private void u(float f4) {
            this.f2242c = f4;
        }

        @Override // b1.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f2249a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f2240h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        private float f2247b;

        /* renamed from: c, reason: collision with root package name */
        private float f2248c;

        @Override // b1.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f2249a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f2247b, this.f2248c);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected final Matrix f2249a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class g {

        /* renamed from: a, reason: collision with root package name */
        static final Matrix f2250a = new Matrix();

        g() {
        }

        public final void a(a1.a aVar, int i4, Canvas canvas) {
            b(f2250a, aVar, i4, canvas);
        }

        public abstract void b(Matrix matrix, a1.a aVar, int i4, Canvas canvas);
    }

    public m() {
        n(0.0f, 0.0f);
    }

    private void b(float f4) {
        if (g() == f4) {
            return;
        }
        float g4 = ((f4 - g()) + 360.0f) % 360.0f;
        if (g4 > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(g4);
        this.f2231h.add(new b(dVar));
        p(f4);
    }

    private void c(g gVar, float f4, float f5) {
        b(f4);
        this.f2231h.add(gVar);
        p(f5);
    }

    private float g() {
        return this.f2228e;
    }

    private float h() {
        return this.f2229f;
    }

    private void p(float f4) {
        this.f2228e = f4;
    }

    private void q(float f4) {
        this.f2229f = f4;
    }

    private void r(float f4) {
        this.f2226c = f4;
    }

    private void s(float f4) {
        this.f2227d = f4;
    }

    private void t(float f4) {
        this.f2224a = f4;
    }

    private void u(float f4) {
        this.f2225b = f4;
    }

    public void a(float f4, float f5, float f6, float f7, float f8, float f9) {
        d dVar = new d(f4, f5, f6, f7);
        dVar.s(f8);
        dVar.t(f9);
        this.f2230g.add(dVar);
        b bVar = new b(dVar);
        float f10 = f8 + f9;
        boolean z4 = f9 < 0.0f;
        if (z4) {
            f8 = (f8 + 180.0f) % 360.0f;
        }
        c(bVar, f8, z4 ? (180.0f + f10) % 360.0f : f10);
        double d5 = f10;
        r(((f4 + f6) * 0.5f) + (((f6 - f4) / 2.0f) * ((float) Math.cos(Math.toRadians(d5)))));
        s(((f5 + f7) * 0.5f) + (((f7 - f5) / 2.0f) * ((float) Math.sin(Math.toRadians(d5)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f2230g.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f2230g.get(i4).a(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f2232i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f2231h), matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f2226c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f2227d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.f2224a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f2225b;
    }

    public void m(float f4, float f5) {
        e eVar = new e();
        eVar.f2247b = f4;
        eVar.f2248c = f5;
        this.f2230g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f4);
        s(f5);
    }

    public void n(float f4, float f5) {
        o(f4, f5, 270.0f, 0.0f);
    }

    public void o(float f4, float f5, float f6, float f7) {
        t(f4);
        u(f5);
        r(f4);
        s(f5);
        p(f6);
        q((f6 + f7) % 360.0f);
        this.f2230g.clear();
        this.f2231h.clear();
        this.f2232i = false;
    }
}
