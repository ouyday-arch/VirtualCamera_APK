package com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.journeyapps.barcodescanner.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l1.k;
import p2.o;
import p2.p;
import p2.q;
import p2.s;
import q2.g;
import q2.i;
import q2.j;
import q2.l;
import q2.m;
import q2.n;

/* loaded from: classes.dex */
public class a extends ViewGroup {
    private static final String B = a.class.getSimpleName();
    private final f A;

    /* renamed from: b, reason: collision with root package name */
    private g f3401b;

    /* renamed from: c, reason: collision with root package name */
    private WindowManager f3402c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f3403d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3404e;

    /* renamed from: f, reason: collision with root package name */
    private SurfaceView f3405f;

    /* renamed from: g, reason: collision with root package name */
    private TextureView f3406g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3407h;

    /* renamed from: i, reason: collision with root package name */
    private p f3408i;

    /* renamed from: j, reason: collision with root package name */
    private int f3409j;

    /* renamed from: k, reason: collision with root package name */
    private List<f> f3410k;

    /* renamed from: l, reason: collision with root package name */
    private m f3411l;

    /* renamed from: m, reason: collision with root package name */
    private i f3412m;

    /* renamed from: n, reason: collision with root package name */
    private q f3413n;

    /* renamed from: o, reason: collision with root package name */
    private q f3414o;

    /* renamed from: p, reason: collision with root package name */
    private Rect f3415p;

    /* renamed from: q, reason: collision with root package name */
    private q f3416q;

    /* renamed from: r, reason: collision with root package name */
    private Rect f3417r;

    /* renamed from: s, reason: collision with root package name */
    private Rect f3418s;

    /* renamed from: t, reason: collision with root package name */
    private q f3419t;

    /* renamed from: u, reason: collision with root package name */
    private double f3420u;

    /* renamed from: v, reason: collision with root package name */
    private q2.q f3421v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f3422w;

    /* renamed from: x, reason: collision with root package name */
    private final SurfaceHolder.Callback f3423x;

    /* renamed from: y, reason: collision with root package name */
    private final Handler.Callback f3424y;

    /* renamed from: z, reason: collision with root package name */
    private o f3425z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.journeyapps.barcodescanner.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class TextureViewSurfaceTextureListenerC0036a implements TextureView.SurfaceTextureListener {
        TextureViewSurfaceTextureListenerC0036a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
            onSurfaceTextureSizeChanged(surfaceTexture, i4, i5);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
            a.this.f3416q = new q(i4, i5);
            a.this.C();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* loaded from: classes.dex */
    class b implements SurfaceHolder.Callback {
        b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
            if (surfaceHolder == null) {
                Log.e(a.B, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            a.this.f3416q = new q(i5, i6);
            a.this.C();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            a.this.f3416q = null;
        }
    }

    /* loaded from: classes.dex */
    class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == k.f4529j) {
                a.this.w((q) message.obj);
                return true;
            }
            if (i4 != k.f4523d) {
                if (i4 != k.f4522c) {
                    return false;
                }
                a.this.A.e();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!a.this.r()) {
                return false;
            }
            a.this.u();
            a.this.A.b(exc);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements o {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            a.this.z();
        }

        @Override // p2.o
        public void a(int i4) {
            a.this.f3403d.postDelayed(new Runnable() { // from class: com.journeyapps.barcodescanner.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.d.this.c();
                }
            }, 250L);
        }
    }

    /* loaded from: classes.dex */
    class e implements f {
        e() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void a() {
            Iterator it = a.this.f3410k.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void b(Exception exc) {
            Iterator it = a.this.f3410k.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(exc);
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void c() {
            Iterator it = a.this.f3410k.iterator();
            while (it.hasNext()) {
                ((f) it.next()).c();
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void d() {
            Iterator it = a.this.f3410k.iterator();
            while (it.hasNext()) {
                ((f) it.next()).d();
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void e() {
            Iterator it = a.this.f3410k.iterator();
            while (it.hasNext()) {
                ((f) it.next()).e();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b(Exception exc);

        void c();

        void d();

        void e();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3404e = false;
        this.f3407h = false;
        this.f3409j = -1;
        this.f3410k = new ArrayList();
        this.f3412m = new i();
        this.f3417r = null;
        this.f3418s = null;
        this.f3419t = null;
        this.f3420u = 0.1d;
        this.f3421v = null;
        this.f3422w = false;
        this.f3423x = new b();
        this.f3424y = new c();
        this.f3425z = new d();
        this.A = new e();
        p(context, attributeSet, 0, 0);
    }

    private void A() {
        View view;
        if (this.f3404e) {
            TextureView textureView = new TextureView(getContext());
            this.f3406g = textureView;
            textureView.setSurfaceTextureListener(D());
            view = this.f3406g;
        } else {
            SurfaceView surfaceView = new SurfaceView(getContext());
            this.f3405f = surfaceView;
            surfaceView.getHolder().addCallback(this.f3423x);
            view = this.f3405f;
        }
        addView(view);
    }

    private void B(j jVar) {
        if (this.f3407h || this.f3401b == null) {
            return;
        }
        Log.i(B, "Starting preview");
        this.f3401b.z(jVar);
        this.f3401b.B();
        this.f3407h = true;
        x();
        this.A.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Rect rect;
        j jVar;
        q qVar = this.f3416q;
        if (qVar == null || this.f3414o == null || (rect = this.f3415p) == null) {
            return;
        }
        if (this.f3405f == null || !qVar.equals(new q(rect.width(), this.f3415p.height()))) {
            TextureView textureView = this.f3406g;
            if (textureView == null || textureView.getSurfaceTexture() == null) {
                return;
            }
            if (this.f3414o != null) {
                this.f3406g.setTransform(l(new q(this.f3406g.getWidth(), this.f3406g.getHeight()), this.f3414o));
            }
            jVar = new j(this.f3406g.getSurfaceTexture());
        } else {
            jVar = new j(this.f3405f.getHolder());
        }
        B(jVar);
    }

    @TargetApi(14)
    private TextureView.SurfaceTextureListener D() {
        return new TextureViewSurfaceTextureListenerC0036a();
    }

    private int getDisplayRotation() {
        return this.f3402c.getDefaultDisplay().getRotation();
    }

    private void j() {
        q qVar;
        m mVar;
        q qVar2 = this.f3413n;
        if (qVar2 == null || (qVar = this.f3414o) == null || (mVar = this.f3411l) == null) {
            this.f3418s = null;
            this.f3417r = null;
            this.f3415p = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i4 = qVar.f5467b;
        int i5 = qVar.f5468c;
        int i6 = qVar2.f5467b;
        int i7 = qVar2.f5468c;
        Rect d5 = mVar.d(qVar);
        if (d5.width() <= 0 || d5.height() <= 0) {
            return;
        }
        this.f3415p = d5;
        this.f3417r = k(new Rect(0, 0, i6, i7), this.f3415p);
        Rect rect = new Rect(this.f3417r);
        Rect rect2 = this.f3415p;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i4) / this.f3415p.width(), (rect.top * i5) / this.f3415p.height(), (rect.right * i4) / this.f3415p.width(), (rect.bottom * i5) / this.f3415p.height());
        this.f3418s = rect3;
        if (rect3.width() > 0 && this.f3418s.height() > 0) {
            this.A.a();
            return;
        }
        this.f3418s = null;
        this.f3417r = null;
        Log.w(B, "Preview frame is too small");
    }

    private void m(q qVar) {
        this.f3413n = qVar;
        g gVar = this.f3401b;
        if (gVar == null || gVar.n() != null) {
            return;
        }
        m mVar = new m(getDisplayRotation(), qVar);
        this.f3411l = mVar;
        mVar.e(getPreviewScalingStrategy());
        this.f3401b.x(this.f3411l);
        this.f3401b.m();
        boolean z4 = this.f3422w;
        if (z4) {
            this.f3401b.A(z4);
        }
    }

    private void o() {
        if (this.f3401b != null) {
            Log.w(B, "initCamera called twice");
            return;
        }
        g n4 = n();
        this.f3401b = n4;
        n4.y(this.f3403d);
        this.f3401b.u();
        this.f3409j = getDisplayRotation();
    }

    private void p(Context context, AttributeSet attributeSet, int i4, int i5) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        q(attributeSet);
        this.f3402c = (WindowManager) context.getSystemService("window");
        this.f3403d = new Handler(this.f3424y);
        this.f3408i = new p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(q qVar) {
        this.f3414o = qVar;
        if (this.f3413n != null) {
            j();
            requestLayout();
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (!r() || getDisplayRotation() == this.f3409j) {
            return;
        }
        u();
        y();
    }

    public g getCameraInstance() {
        return this.f3401b;
    }

    public i getCameraSettings() {
        return this.f3412m;
    }

    public Rect getFramingRect() {
        return this.f3417r;
    }

    public q getFramingRectSize() {
        return this.f3419t;
    }

    public double getMarginFraction() {
        return this.f3420u;
    }

    public Rect getPreviewFramingRect() {
        return this.f3418s;
    }

    public q2.q getPreviewScalingStrategy() {
        q2.q qVar = this.f3421v;
        return qVar != null ? qVar : this.f3406g != null ? new l() : new n();
    }

    public q getPreviewSize() {
        return this.f3414o;
    }

    public void i(f fVar) {
        this.f3410k.add(fVar);
    }

    protected Rect k(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.f3419t != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.f3419t.f5467b) / 2), Math.max(0, (rect3.height() - this.f3419t.f5468c) / 2));
            return rect3;
        }
        int min = (int) Math.min(rect3.width() * this.f3420u, rect3.height() * this.f3420u);
        rect3.inset(min, min);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    protected Matrix l(q qVar, q qVar2) {
        float f4;
        float f5 = qVar.f5467b / qVar.f5468c;
        float f6 = qVar2.f5467b / qVar2.f5468c;
        float f7 = 1.0f;
        if (f5 < f6) {
            float f8 = f6 / f5;
            f4 = 1.0f;
            f7 = f8;
        } else {
            f4 = f5 / f6;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f7, f4);
        int i4 = qVar.f5467b;
        int i5 = qVar.f5468c;
        matrix.postTranslate((i4 - (i4 * f7)) / 2.0f, (i5 - (i5 * f4)) / 2.0f);
        return matrix;
    }

    protected g n() {
        g gVar = new g(getContext());
        gVar.w(this.f3412m);
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        m(new q(i6 - i4, i7 - i5));
        SurfaceView surfaceView = this.f3405f;
        if (surfaceView == null) {
            TextureView textureView = this.f3406g;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
                return;
            }
            return;
        }
        Rect rect = this.f3415p;
        if (rect == null) {
            surfaceView.layout(0, 0, getWidth(), getHeight());
        } else {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.f3422w);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(AttributeSet attributeSet) {
        q2.q oVar;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, l1.o.f4543f);
        int dimension = (int) obtainStyledAttributes.getDimension(l1.o.f4545h, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(l1.o.f4544g, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.f3419t = new q(dimension, dimension2);
        }
        this.f3404e = obtainStyledAttributes.getBoolean(l1.o.f4547j, true);
        int integer = obtainStyledAttributes.getInteger(l1.o.f4546i, -1);
        if (integer == 1) {
            oVar = new l();
        } else {
            if (integer != 2) {
                if (integer == 3) {
                    oVar = new q2.o();
                }
                obtainStyledAttributes.recycle();
            }
            oVar = new n();
        }
        this.f3421v = oVar;
        obtainStyledAttributes.recycle();
    }

    protected boolean r() {
        return this.f3401b != null;
    }

    public boolean s() {
        g gVar = this.f3401b;
        return gVar == null || gVar.p();
    }

    public void setCameraSettings(i iVar) {
        this.f3412m = iVar;
    }

    public void setFramingRectSize(q qVar) {
        this.f3419t = qVar;
    }

    public void setMarginFraction(double d5) {
        if (d5 >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.f3420u = d5;
    }

    public void setPreviewScalingStrategy(q2.q qVar) {
        this.f3421v = qVar;
    }

    public void setTorch(boolean z4) {
        this.f3422w = z4;
        g gVar = this.f3401b;
        if (gVar != null) {
            gVar.A(z4);
        }
    }

    public void setUseTextureView(boolean z4) {
        this.f3404e = z4;
    }

    public boolean t() {
        return this.f3407h;
    }

    public void u() {
        TextureView textureView;
        SurfaceView surfaceView;
        s.a();
        Log.d(B, "pause()");
        this.f3409j = -1;
        g gVar = this.f3401b;
        if (gVar != null) {
            gVar.l();
            this.f3401b = null;
            this.f3407h = false;
        } else {
            this.f3403d.sendEmptyMessage(k.f4522c);
        }
        if (this.f3416q == null && (surfaceView = this.f3405f) != null) {
            surfaceView.getHolder().removeCallback(this.f3423x);
        }
        if (this.f3416q == null && (textureView = this.f3406g) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.f3413n = null;
        this.f3414o = null;
        this.f3418s = null;
        this.f3408i.f();
        this.A.d();
    }

    public void v() {
        g cameraInstance = getCameraInstance();
        u();
        long nanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.p() && System.nanoTime() - nanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
    }

    public void y() {
        s.a();
        Log.d(B, "resume()");
        o();
        if (this.f3416q != null) {
            C();
        } else {
            SurfaceView surfaceView = this.f3405f;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.f3423x);
            } else {
                TextureView textureView = this.f3406g;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        D().onSurfaceTextureAvailable(this.f3406g.getSurfaceTexture(), this.f3406g.getWidth(), this.f3406g.getHeight());
                    } else {
                        this.f3406g.setSurfaceTextureListener(D());
                    }
                }
            }
        }
        requestLayout();
        this.f3408i.e(getContext(), this.f3425z);
    }
}
