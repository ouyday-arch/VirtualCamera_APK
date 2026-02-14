package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import l1.k;
import l1.l;

/* loaded from: classes.dex */
public class CaptureActivity extends Activity {

    /* renamed from: b, reason: collision with root package name */
    private e f3377b;

    /* renamed from: c, reason: collision with root package name */
    private DecoratedBarcodeView f3378c;

    protected DecoratedBarcodeView a() {
        setContentView(l.f4533b);
        return (DecoratedBarcodeView) findViewById(k.f4520a);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3378c = a();
        e eVar = new e(this, this.f3378c);
        this.f3377b = eVar;
        eVar.p(getIntent(), bundle);
        this.f3377b.l();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f3377b.u();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        return this.f3378c.onKeyDown(i4, keyEvent) || super.onKeyDown(i4, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f3377b.v();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        this.f3377b.w(i4, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f3377b.x();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f3377b.y(bundle);
    }
}
