package b1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final m[] f2209a = new m[4];

    /* renamed from: b, reason: collision with root package name */
    private final Matrix[] f2210b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix[] f2211c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    private final PointF f2212d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    private final Path f2213e = new Path();

    /* renamed from: f, reason: collision with root package name */
    private final Path f2214f = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final m f2215g = new m();

    /* renamed from: h, reason: collision with root package name */
    private final float[] f2216h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    private final float[] f2217i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    private boolean f2218j = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(m mVar, Matrix matrix, int i4);

        void b(m mVar, Matrix matrix, int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final k f2219a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f2220b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f2221c;

        /* renamed from: d, reason: collision with root package name */
        public final a f2222d;

        /* renamed from: e, reason: collision with root package name */
        public final float f2223e;

        b(k kVar, float f4, RectF rectF, a aVar, Path path) {
            this.f2222d = aVar;
            this.f2219a = kVar;
            this.f2223e = f4;
            this.f2221c = rectF;
            this.f2220b = path;
        }
    }

    public l() {
        for (int i4 = 0; i4 < 4; i4++) {
            this.f2209a[i4] = new m();
            this.f2210b[i4] = new Matrix();
            this.f2211c[i4] = new Matrix();
        }
    }

    private float a(int i4) {
        return (i4 + 1) * 90;
    }

    private void b(b bVar, int i4) {
        this.f2216h[0] = this.f2209a[i4].k();
        this.f2216h[1] = this.f2209a[i4].l();
        this.f2210b[i4].mapPoints(this.f2216h);
        Path path = bVar.f2220b;
        float[] fArr = this.f2216h;
        if (i4 == 0) {
            path.moveTo(fArr[0], fArr[1]);
        } else {
            path.lineTo(fArr[0], fArr[1]);
        }
        this.f2209a[i4].d(this.f2210b[i4], bVar.f2220b);
        a aVar = bVar.f2222d;
        if (aVar != null) {
            aVar.a(this.f2209a[i4], this.f2210b[i4], i4);
        }
    }

    private void c(b bVar, int i4) {
        m mVar;
        Matrix matrix;
        Path path;
        int i5 = (i4 + 1) % 4;
        this.f2216h[0] = this.f2209a[i4].i();
        this.f2216h[1] = this.f2209a[i4].j();
        this.f2210b[i4].mapPoints(this.f2216h);
        this.f2217i[0] = this.f2209a[i5].k();
        this.f2217i[1] = this.f2209a[i5].l();
        this.f2210b[i5].mapPoints(this.f2217i);
        float f4 = this.f2216h[0];
        float[] fArr = this.f2217i;
        float max = Math.max(((float) Math.hypot(f4 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float i6 = i(bVar.f2221c, i4);
        this.f2215g.n(0.0f, 0.0f);
        f j4 = j(i4, bVar.f2219a);
        j4.b(max, i6, bVar.f2223e, this.f2215g);
        Path path2 = new Path();
        this.f2215g.d(this.f2211c[i4], path2);
        if (this.f2218j && (j4.a() || k(path2, i4) || k(path2, i5))) {
            path2.op(path2, this.f2214f, Path.Op.DIFFERENCE);
            this.f2216h[0] = this.f2215g.k();
            this.f2216h[1] = this.f2215g.l();
            this.f2211c[i4].mapPoints(this.f2216h);
            Path path3 = this.f2213e;
            float[] fArr2 = this.f2216h;
            path3.moveTo(fArr2[0], fArr2[1]);
            mVar = this.f2215g;
            matrix = this.f2211c[i4];
            path = this.f2213e;
        } else {
            mVar = this.f2215g;
            matrix = this.f2211c[i4];
            path = bVar.f2220b;
        }
        mVar.d(matrix, path);
        a aVar = bVar.f2222d;
        if (aVar != null) {
            aVar.b(this.f2215g, this.f2211c[i4], i4);
        }
    }

    private void f(int i4, RectF rectF, PointF pointF) {
        float f4;
        float f5;
        if (i4 == 1) {
            f4 = rectF.right;
        } else {
            if (i4 != 2) {
                f4 = i4 != 3 ? rectF.right : rectF.left;
                f5 = rectF.top;
                pointF.set(f4, f5);
            }
            f4 = rectF.left;
        }
        f5 = rectF.bottom;
        pointF.set(f4, f5);
    }

    private c g(int i4, k kVar) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? kVar.t() : kVar.r() : kVar.j() : kVar.l();
    }

    private d h(int i4, k kVar) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? kVar.s() : kVar.q() : kVar.i() : kVar.k();
    }

    private float i(RectF rectF, int i4) {
        float centerX;
        float f4;
        float[] fArr = this.f2216h;
        m[] mVarArr = this.f2209a;
        fArr[0] = mVarArr[i4].f2226c;
        fArr[1] = mVarArr[i4].f2227d;
        this.f2210b[i4].mapPoints(fArr);
        if (i4 == 1 || i4 == 3) {
            centerX = rectF.centerX();
            f4 = this.f2216h[0];
        } else {
            centerX = rectF.centerY();
            f4 = this.f2216h[1];
        }
        return Math.abs(centerX - f4);
    }

    private f j(int i4, k kVar) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? kVar.o() : kVar.p() : kVar.n() : kVar.h();
    }

    private boolean k(Path path, int i4) {
        Path path2 = new Path();
        this.f2209a[i4].d(this.f2210b[i4], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void l(b bVar, int i4) {
        h(i4, bVar.f2219a).b(this.f2209a[i4], 90.0f, bVar.f2223e, bVar.f2221c, g(i4, bVar.f2219a));
        float a5 = a(i4);
        this.f2210b[i4].reset();
        f(i4, bVar.f2221c, this.f2212d);
        Matrix matrix = this.f2210b[i4];
        PointF pointF = this.f2212d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f2210b[i4].preRotate(a5);
    }

    private void m(int i4) {
        this.f2216h[0] = this.f2209a[i4].i();
        this.f2216h[1] = this.f2209a[i4].j();
        this.f2210b[i4].mapPoints(this.f2216h);
        float a5 = a(i4);
        this.f2211c[i4].reset();
        Matrix matrix = this.f2211c[i4];
        float[] fArr = this.f2216h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f2211c[i4].preRotate(a5);
    }

    public void d(k kVar, float f4, RectF rectF, Path path) {
        e(kVar, f4, rectF, null, path);
    }

    public void e(k kVar, float f4, RectF rectF, a aVar, Path path) {
        path.rewind();
        this.f2213e.rewind();
        this.f2214f.rewind();
        this.f2214f.addRect(rectF, Path.Direction.CW);
        b bVar = new b(kVar, f4, rectF, aVar, path);
        for (int i4 = 0; i4 < 4; i4++) {
            l(bVar, i4);
            m(i4);
        }
        for (int i5 = 0; i5 < 4; i5++) {
            b(bVar, i5);
            c(bVar, i5);
        }
        path.close();
        this.f2213e.close();
        if (this.f2213e.isEmpty()) {
            return;
        }
        path.op(this.f2213e, Path.Op.UNION);
    }
}
