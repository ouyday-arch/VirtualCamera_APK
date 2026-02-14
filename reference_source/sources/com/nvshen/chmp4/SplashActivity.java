package com.nvshen.chmp4;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.nmmedit.protect.NativeUtil;
import com.telegram.a1064.R;
import k2.o;
import s2.b;

/* loaded from: classes.dex */
public class SplashActivity extends androidx.appcompat.app.c {

    /* renamed from: v, reason: collision with root package name */
    public static int f3475v;

    /* renamed from: u, reason: collision with root package name */
    private int f3476u = 0;

    /* loaded from: classes.dex */
    class a implements DialogInterface.OnClickListener {
        static {
            NativeUtil.classesInit0(54);
        }

        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public native void onClick(DialogInterface dialogInterface, int i4);
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f3478b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f3479c;

        static {
            NativeUtil.classesInit0(53);
        }

        b(EditText editText, Activity activity) {
            this.f3478b = editText;
            this.f3479c = activity;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    static {
        NativeUtil.classesInit0(39);
        s2.b.f5887c = false;
        s2.b.N(b.a.a().b(8).c(10L));
        f3475v = 1;
    }

    private native void I();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(s2.b bVar) {
        if (!bVar.M()) {
            M();
            return;
        }
        if (s2.b.I("getenforce").i().c().contains("Enforcing")) {
            s2.b.I("setenforce 0").i();
            if (s2.b.I("getenforce").i().c().contains("Permissive")) {
                s2.b.I("setenforce 1").i();
            } else {
                Log.e("HOOK", "setenforce 0 fail!");
                o.j(getString(R.string.check_selinux));
            }
        }
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    public static native void K(Context context);

    private native void L();

    native void M();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, n.d, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.d, android.app.Activity
    public native void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr);
}
