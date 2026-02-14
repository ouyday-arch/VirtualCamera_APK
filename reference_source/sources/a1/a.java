package a1;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* loaded from: classes.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f277i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f278j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f279k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f280l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private final Paint f281a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f282b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f283c;

    /* renamed from: d, reason: collision with root package name */
    private int f284d;

    /* renamed from: e, reason: collision with root package name */
    private int f285e;

    /* renamed from: f, reason: collision with root package name */
    private int f286f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f287g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f288h;

    public a() {
        this(-16777216);
    }

    public a(int i4) {
        this.f287g = new Path();
        this.f288h = new Paint();
        this.f281a = new Paint();
        d(i4);
        this.f288h.setColor(0);
        Paint paint = new Paint(4);
        this.f282b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f283c = new Paint(paint);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i4, float f4, float f5) {
        boolean z4 = f5 < 0.0f;
        Path path = this.f287g;
        if (z4) {
            int[] iArr = f279k;
            iArr[0] = 0;
            iArr[1] = this.f286f;
            iArr[2] = this.f285e;
            iArr[3] = this.f284d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f4, f5);
            path.close();
            float f6 = -i4;
            rectF.inset(f6, f6);
            int[] iArr2 = f279k;
            iArr2[0] = 0;
            iArr2[1] = this.f284d;
            iArr2[2] = this.f285e;
            iArr2[3] = this.f286f;
        }
        float width = 1.0f - (i4 / (rectF.width() / 2.0f));
        float[] fArr = f280l;
        fArr[1] = width;
        fArr[2] = ((1.0f - width) / 2.0f) + width;
        this.f282b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, f279k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z4) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f288h);
        }
        canvas.drawArc(rectF, f4, f5, true, this.f282b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i4) {
        rectF.bottom += i4;
        rectF.offset(0.0f, -i4);
        int[] iArr = f277i;
        iArr[0] = this.f286f;
        iArr[1] = this.f285e;
        iArr[2] = this.f284d;
        Paint paint = this.f283c;
        float f4 = rectF.left;
        paint.setShader(new LinearGradient(f4, rectF.top, f4, rectF.bottom, iArr, f278j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f283c);
        canvas.restore();
    }

    public Paint c() {
        return this.f281a;
    }

    public void d(int i4) {
        this.f284d = q.a.d(i4, 68);
        this.f285e = q.a.d(i4, 20);
        this.f286f = q.a.d(i4, 0);
        this.f281a.setColor(this.f284d);
    }
}
