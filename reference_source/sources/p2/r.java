package p2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private n f5469a;

    /* renamed from: b, reason: collision with root package name */
    private int f5470b;

    /* renamed from: c, reason: collision with root package name */
    private int f5471c;

    /* renamed from: d, reason: collision with root package name */
    private Rect f5472d;

    /* renamed from: e, reason: collision with root package name */
    private int f5473e = 1;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5474f;

    public r(byte[] bArr, int i4, int i5, int i6, int i7) {
        this.f5469a = new n(bArr, i4, i5);
        this.f5471c = i7;
        this.f5470b = i6;
        if (i4 * i5 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i4 + "x" + i5 + " > " + bArr.length);
    }

    public g1.n a() {
        n a5 = this.f5469a.h(this.f5471c).a(this.f5472d, this.f5473e);
        return new g1.n(a5.b(), a5.d(), a5.c(), 0, 0, a5.d(), a5.c(), false);
    }

    public Bitmap b(Rect rect, int i4) {
        if (rect == null) {
            rect = new Rect(0, 0, this.f5469a.d(), this.f5469a.c());
        } else if (c()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.f5469a.b(), this.f5470b, this.f5469a.d(), this.f5469a.c(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i4;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.f5471c == 0) {
            return decodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f5471c);
        return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
    }

    public boolean c() {
        return this.f5471c % 180 != 0;
    }

    public void d(Rect rect) {
        this.f5472d = rect;
    }

    public void e(boolean z4) {
        this.f5474f = z4;
    }

    public g1.s f(g1.s sVar) {
        float c5 = (sVar.c() * this.f5473e) + this.f5472d.left;
        float d5 = (sVar.d() * this.f5473e) + this.f5472d.top;
        if (this.f5474f) {
            c5 = this.f5469a.d() - c5;
        }
        return new g1.s(c5, d5);
    }
}
