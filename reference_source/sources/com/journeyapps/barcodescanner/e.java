package com.journeyapps.barcodescanner;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.journeyapps.barcodescanner.a;
import com.journeyapps.barcodescanner.e;
import g1.r;
import g1.s;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l1.h;
import l1.n;

/* loaded from: classes.dex */
public class e {

    /* renamed from: o, reason: collision with root package name */
    private static final String f3435o = "e";

    /* renamed from: p, reason: collision with root package name */
    private static int f3436p = 250;

    /* renamed from: a, reason: collision with root package name */
    private Activity f3437a;

    /* renamed from: b, reason: collision with root package name */
    private DecoratedBarcodeView f3438b;

    /* renamed from: h, reason: collision with root package name */
    private h f3444h;

    /* renamed from: i, reason: collision with root package name */
    private l1.e f3445i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f3446j;

    /* renamed from: m, reason: collision with root package name */
    private final a.f f3449m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3450n;

    /* renamed from: c, reason: collision with root package name */
    private int f3439c = -1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3440d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3441e = true;

    /* renamed from: f, reason: collision with root package name */
    private String f3442f = "";

    /* renamed from: g, reason: collision with root package name */
    private boolean f3443g = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3447k = false;

    /* renamed from: l, reason: collision with root package name */
    private p2.a f3448l = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements p2.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(p2.c cVar) {
            e.this.B(cVar);
        }

        @Override // p2.a
        public void a(List<s> list) {
        }

        @Override // p2.a
        public void b(final p2.c cVar) {
            e.this.f3438b.e();
            e.this.f3445i.f();
            e.this.f3446j.post(new Runnable() { // from class: com.journeyapps.barcodescanner.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.this.d(cVar);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    class b implements a.f {
        b() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void a() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void b(Exception exc) {
            e eVar = e.this;
            eVar.m(eVar.f3437a.getString(n.f4537c));
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void c() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void e() {
            if (e.this.f3447k) {
                Log.d(e.f3435o, "Camera closed; finishing activity");
                e.this.n();
            }
        }
    }

    public e(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        b bVar = new b();
        this.f3449m = bVar;
        this.f3450n = false;
        this.f3437a = activity;
        this.f3438b = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().i(bVar);
        this.f3446j = new Handler();
        this.f3444h = new h(activity, new Runnable() { // from class: p2.f
            @Override // java.lang.Runnable
            public final void run() {
                com.journeyapps.barcodescanner.e.this.s();
            }
        });
        this.f3445i = new l1.e(activity);
    }

    public static Intent A(p2.c cVar, String str) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addFlags(524288);
        intent.putExtra("SCAN_RESULT", cVar.toString());
        intent.putExtra("SCAN_RESULT_FORMAT", cVar.a().toString());
        byte[] c5 = cVar.c();
        if (c5 != null && c5.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", c5);
        }
        Map<r, Object> d5 = cVar.d();
        if (d5 != null) {
            r rVar = r.UPC_EAN_EXTENSION;
            if (d5.containsKey(rVar)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", d5.get(rVar).toString());
            }
            Number number = (Number) d5.get(r.ORIENTATION);
            if (number != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
            }
            String str2 = (String) d5.get(r.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str2);
            }
            Iterable iterable = (Iterable) d5.get(r.BYTE_SEGMENTS);
            if (iterable != null) {
                int i4 = 0;
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i4, (byte[]) it.next());
                    i4++;
                }
            }
        }
        if (str != null) {
            intent.putExtra("SCAN_RESULT_IMAGE_PATH", str);
        }
        return intent;
    }

    private void D() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("MISSING_CAMERA_PERMISSION", true);
        this.f3437a.setResult(0, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f3437a.finish();
    }

    private String o(p2.c cVar) {
        if (this.f3440d) {
            Bitmap b5 = cVar.b();
            try {
                File createTempFile = File.createTempFile("barcodeimage", ".jpg", this.f3437a.getCacheDir());
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                b5.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                return createTempFile.getAbsolutePath();
            } catch (IOException e4) {
                Log.w(f3435o, "Unable to create temporary file and store bitmap! " + e4);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(DialogInterface dialogInterface, int i4) {
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(DialogInterface dialogInterface) {
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        Log.d(f3435o, "Finishing due to inactivity");
        n();
    }

    @TargetApi(23)
    private void z() {
        if (o.a.a(this.f3437a, "android.permission.CAMERA") == 0) {
            this.f3438b.g();
        } else {
            if (this.f3450n) {
                return;
            }
            n.a.h(this.f3437a, new String[]{"android.permission.CAMERA"}, f3436p);
            this.f3450n = true;
        }
    }

    protected void B(p2.c cVar) {
        this.f3437a.setResult(-1, A(cVar, o(cVar)));
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("TIMEOUT", true);
        this.f3437a.setResult(0, intent);
        k();
    }

    public void E(boolean z4, String str) {
        this.f3441e = z4;
        if (str == null) {
            str = "";
        }
        this.f3442f = str;
    }

    protected void k() {
        if (this.f3438b.getBarcodeView().s()) {
            n();
        } else {
            this.f3447k = true;
        }
        this.f3438b.e();
        this.f3444h.d();
    }

    public void l() {
        this.f3438b.b(this.f3448l);
    }

    protected void m(String str) {
        if (this.f3437a.isFinishing() || this.f3443g || this.f3447k) {
            return;
        }
        if (str.isEmpty()) {
            str = this.f3437a.getString(n.f4537c);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f3437a);
        builder.setTitle(this.f3437a.getString(n.f4535a));
        builder.setMessage(str);
        builder.setPositiveButton(n.f4536b, new DialogInterface.OnClickListener() { // from class: p2.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                com.journeyapps.barcodescanner.e.this.q(dialogInterface, i4);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: p2.d
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                com.journeyapps.barcodescanner.e.this.r(dialogInterface);
            }
        });
        builder.show();
    }

    public void p(Intent intent, Bundle bundle) {
        this.f3437a.getWindow().addFlags(128);
        if (bundle != null) {
            this.f3439c = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra("SCAN_ORIENTATION_LOCKED", true)) {
                t();
            }
            if ("com.google.zxing.client.android.SCAN".equals(intent.getAction())) {
                this.f3438b.d(intent);
            }
            if (!intent.getBooleanExtra("BEEP_ENABLED", true)) {
                this.f3445i.g(false);
            }
            if (intent.hasExtra("SHOW_MISSING_CAMERA_PERMISSION_DIALOG")) {
                E(intent.getBooleanExtra("SHOW_MISSING_CAMERA_PERMISSION_DIALOG", true), intent.getStringExtra("MISSING_CAMERA_PERMISSION_DIALOG_MESSAGE"));
            }
            if (intent.hasExtra("TIMEOUT")) {
                this.f3446j.postDelayed(new Runnable() { // from class: com.journeyapps.barcodescanner.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.C();
                    }
                }, intent.getLongExtra("TIMEOUT", 0L));
            }
            if (intent.getBooleanExtra("BARCODE_IMAGE_ENABLED", false)) {
                this.f3440d = true;
            }
        }
    }

    protected void t() {
        if (this.f3439c == -1) {
            int rotation = this.f3437a.getWindowManager().getDefaultDisplay().getRotation();
            int i4 = this.f3437a.getResources().getConfiguration().orientation;
            int i5 = 0;
            if (i4 == 2) {
                if (rotation != 0 && rotation != 1) {
                    i5 = 8;
                }
            } else if (i4 == 1) {
                i5 = (rotation == 0 || rotation == 3) ? 1 : 9;
            }
            this.f3439c = i5;
        }
        this.f3437a.setRequestedOrientation(this.f3439c);
    }

    public void u() {
        this.f3443g = true;
        this.f3444h.d();
        this.f3446j.removeCallbacksAndMessages(null);
    }

    public void v() {
        this.f3444h.d();
        this.f3438b.f();
    }

    public void w(int i4, String[] strArr, int[] iArr) {
        if (i4 == f3436p) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.f3438b.g();
                return;
            }
            D();
            if (this.f3441e) {
                m(this.f3442f);
            } else {
                k();
            }
        }
    }

    public void x() {
        z();
        this.f3444h.h();
    }

    public void y(Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.f3439c);
    }
}
