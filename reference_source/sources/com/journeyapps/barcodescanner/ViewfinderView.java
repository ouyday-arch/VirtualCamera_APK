package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.journeyapps.barcodescanner.a;
import g1.s;
import java.util.ArrayList;
import java.util.List;
import l1.j;
import l1.o;
import p2.q;

/* loaded from: classes.dex */
public class ViewfinderView extends View {

    /* renamed from: o, reason: collision with root package name */
    protected static final String f3385o = ViewfinderView.class.getSimpleName();

    /* renamed from: p, reason: collision with root package name */
    protected static final int[] f3386p = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: b, reason: collision with root package name */
    protected final Paint f3387b;

    /* renamed from: c, reason: collision with root package name */
    protected Bitmap f3388c;

    /* renamed from: d, reason: collision with root package name */
    protected int f3389d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f3390e;

    /* renamed from: f, reason: collision with root package name */
    protected final int f3391f;

    /* renamed from: g, reason: collision with root package name */
    protected final int f3392g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f3393h;

    /* renamed from: i, reason: collision with root package name */
    protected int f3394i;

    /* renamed from: j, reason: collision with root package name */
    protected List<s> f3395j;

    /* renamed from: k, reason: collision with root package name */
    protected List<s> f3396k;

    /* renamed from: l, reason: collision with root package name */
    protected com.journeyapps.barcodescanner.a f3397l;

    /* renamed from: m, reason: collision with root package name */
    protected Rect f3398m;

    /* renamed from: n, reason: collision with root package name */
    protected q f3399n;

    /* loaded from: classes.dex */
    class a implements a.f {
        a() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void a() {
            ViewfinderView.this.b();
            ViewfinderView.this.invalidate();
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void b(Exception exc) {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void c() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void e() {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3387b = new Paint(1);
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f4548k);
        this.f3389d = obtainStyledAttributes.getColor(o.f4553p, resources.getColor(j.f4519d));
        this.f3390e = obtainStyledAttributes.getColor(o.f4550m, resources.getColor(j.f4517b));
        this.f3391f = obtainStyledAttributes.getColor(o.f4551n, resources.getColor(j.f4518c));
        this.f3392g = obtainStyledAttributes.getColor(o.f4549l, resources.getColor(j.f4516a));
        this.f3393h = obtainStyledAttributes.getBoolean(o.f4552o, true);
        obtainStyledAttributes.recycle();
        this.f3394i = 0;
        this.f3395j = new ArrayList(20);
        this.f3396k = new ArrayList(20);
    }

    public void a(s sVar) {
        if (this.f3395j.size() < 20) {
            this.f3395j.add(sVar);
        }
    }

    protected void b() {
        com.journeyapps.barcodescanner.a aVar = this.f3397l;
        if (aVar == null) {
            return;
        }
        Rect framingRect = aVar.getFramingRect();
        q previewSize = this.f3397l.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.f3398m = framingRect;
        this.f3399n = previewSize;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        q qVar;
        b();
        Rect rect = this.f3398m;
        if (rect == null || (qVar = this.f3399n) == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f3387b.setColor(this.f3388c != null ? this.f3390e : this.f3389d);
        float f4 = width;
        canvas.drawRect(0.0f, 0.0f, f4, rect.top, this.f3387b);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f3387b);
        canvas.drawRect(rect.right + 1, rect.top, f4, rect.bottom + 1, this.f3387b);
        canvas.drawRect(0.0f, rect.bottom + 1, f4, height, this.f3387b);
        if (this.f3388c != null) {
            this.f3387b.setAlpha(160);
            canvas.drawBitmap(this.f3388c, (Rect) null, rect, this.f3387b);
            return;
        }
        if (this.f3393h) {
            this.f3387b.setColor(this.f3391f);
            Paint paint = this.f3387b;
            int[] iArr = f3386p;
            paint.setAlpha(iArr[this.f3394i]);
            this.f3394i = (this.f3394i + 1) % iArr.length;
            int height2 = (rect.height() / 2) + rect.top;
            canvas.drawRect(rect.left + 2, height2 - 1, rect.right - 1, height2 + 2, this.f3387b);
        }
        float width2 = getWidth() / qVar.f5467b;
        float height3 = getHeight() / qVar.f5468c;
        if (!this.f3396k.isEmpty()) {
            this.f3387b.setAlpha(80);
            this.f3387b.setColor(this.f3392g);
            for (s sVar : this.f3396k) {
                canvas.drawCircle((int) (sVar.c() * width2), (int) (sVar.d() * height3), 3.0f, this.f3387b);
            }
            this.f3396k.clear();
        }
        if (!this.f3395j.isEmpty()) {
            this.f3387b.setAlpha(160);
            this.f3387b.setColor(this.f3392g);
            for (s sVar2 : this.f3395j) {
                canvas.drawCircle((int) (sVar2.c() * width2), (int) (sVar2.d() * height3), 6.0f, this.f3387b);
            }
            List<s> list = this.f3395j;
            List<s> list2 = this.f3396k;
            this.f3395j = list2;
            this.f3396k = list;
            list2.clear();
        }
        postInvalidateDelayed(80L, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
    }

    public void setCameraPreview(com.journeyapps.barcodescanner.a aVar) {
        this.f3397l = aVar;
        aVar.i(new a());
    }

    public void setLaserVisibility(boolean z4) {
        this.f3393h = z4;
    }

    public void setMaskColor(int i4) {
        this.f3389d = i4;
    }
}
