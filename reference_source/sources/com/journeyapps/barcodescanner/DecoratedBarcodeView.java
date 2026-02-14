package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import g1.s;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l1.f;
import l1.g;
import l1.k;
import l1.l;
import l1.o;
import p2.h;
import q2.i;

/* loaded from: classes.dex */
public class DecoratedBarcodeView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    private BarcodeView f3379b;

    /* renamed from: c, reason: collision with root package name */
    private ViewfinderView f3380c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f3381d;

    /* renamed from: e, reason: collision with root package name */
    private a f3382e;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    private class b implements p2.a {

        /* renamed from: a, reason: collision with root package name */
        private p2.a f3383a;

        public b(p2.a aVar) {
            this.f3383a = aVar;
        }

        @Override // p2.a
        public void a(List<s> list) {
            Iterator<s> it = list.iterator();
            while (it.hasNext()) {
                DecoratedBarcodeView.this.f3380c.a(it.next());
            }
            this.f3383a.a(list);
        }

        @Override // p2.a
        public void b(p2.c cVar) {
            this.f3383a.b(cVar);
        }
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f4554q);
        int resourceId = obtainStyledAttributes.getResourceId(o.f4555r, l.f4532a);
        obtainStyledAttributes.recycle();
        FrameLayout.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(k.f4521b);
        this.f3379b = barcodeView;
        if (barcodeView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        barcodeView.q(attributeSet);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(k.f4531l);
        this.f3380c = viewfinderView;
        if (viewfinderView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        viewfinderView.setCameraPreview(this.f3379b);
        this.f3381d = (TextView) findViewById(k.f4530k);
    }

    public void b(p2.a aVar) {
        this.f3379b.I(new b(aVar));
    }

    public void d(Intent intent) {
        int intExtra;
        Set<g1.a> a5 = f.a(intent);
        Map<g1.e, ?> a6 = g.a(intent);
        i iVar = new i();
        if (intent.hasExtra("SCAN_CAMERA_ID") && (intExtra = intent.getIntExtra("SCAN_CAMERA_ID", -1)) >= 0) {
            iVar.i(intExtra);
        }
        if (intent.hasExtra("TORCH_ENABLED") && intent.getBooleanExtra("TORCH_ENABLED", false)) {
            i();
        }
        String stringExtra = intent.getStringExtra("PROMPT_MESSAGE");
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        int intExtra2 = intent.getIntExtra("SCAN_TYPE", 0);
        String stringExtra2 = intent.getStringExtra("CHARACTER_SET");
        new g1.k().f(a6);
        this.f3379b.setCameraSettings(iVar);
        this.f3379b.setDecoderFactory(new p2.k(a5, a6, stringExtra2, intExtra2));
    }

    public void e() {
        this.f3379b.u();
    }

    public void f() {
        this.f3379b.v();
    }

    public void g() {
        this.f3379b.y();
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(k.f4521b);
    }

    public i getCameraSettings() {
        return this.f3379b.getCameraSettings();
    }

    public h getDecoderFactory() {
        return this.f3379b.getDecoderFactory();
    }

    public TextView getStatusView() {
        return this.f3381d;
    }

    public ViewfinderView getViewFinder() {
        return this.f3380c;
    }

    public void h() {
        this.f3379b.setTorch(false);
        a aVar = this.f3382e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void i() {
        this.f3379b.setTorch(true);
        a aVar = this.f3382e;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (i4 == 24) {
            i();
            return true;
        }
        if (i4 == 25) {
            h();
            return true;
        }
        if (i4 == 27 || i4 == 80) {
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }

    public void setCameraSettings(i iVar) {
        this.f3379b.setCameraSettings(iVar);
    }

    public void setDecoderFactory(h hVar) {
        this.f3379b.setDecoderFactory(hVar);
    }

    public void setStatusText(String str) {
        TextView textView = this.f3381d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
        this.f3382e = aVar;
    }
}
