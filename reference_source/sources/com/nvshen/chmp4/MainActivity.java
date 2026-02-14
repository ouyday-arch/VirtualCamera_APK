package com.nvshen.chmp4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.nmmedit.protect.NativeUtil;

/* loaded from: classes.dex */
public class MainActivity extends androidx.appcompat.app.c {

    /* renamed from: u, reason: collision with root package name */
    private String f3455u = "";

    /* renamed from: v, reason: collision with root package name */
    private int f3456v = 11;

    /* loaded from: classes.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3457b;

        static {
            NativeUtil.classesInit0(47);
        }

        a(int i4) {
            this.f3457b = i4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public native void onClick(DialogInterface dialogInterface, int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.nvshen.chmp4.d f3459b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3460c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3461d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f3462e;

        static {
            NativeUtil.classesInit0(51);
        }

        b(com.nvshen.chmp4.d dVar, int i4, String str, int i5) {
            this.f3459b = dVar;
            this.f3460c = i4;
            this.f3461d = str;
            this.f3462e = i5;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* loaded from: classes.dex */
    class c implements BottomNavigationBar.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.fragment.app.i f3464a;

        static {
            NativeUtil.classesInit0(50);
        }

        c(androidx.fragment.app.i iVar) {
            this.f3464a = iVar;
        }

        @Override // com.ashokvarma.bottomnavigation.BottomNavigationBar.c
        public native void a(int i4);

        @Override // com.ashokvarma.bottomnavigation.BottomNavigationBar.c
        public native void b(int i4);

        @Override // com.ashokvarma.bottomnavigation.BottomNavigationBar.c
        public native void c(int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f3466b;

        static {
            NativeUtil.classesInit0(49);
        }

        d(String[] strArr) {
            this.f3466b = strArr;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3468b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ProgressDialog f3469c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.nvshen.chmp4.d f3470d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f3471e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3472f;

        static {
            NativeUtil.classesInit0(48);
        }

        e(int i4, ProgressDialog progressDialog, com.nvshen.chmp4.d dVar, int i5, String str) {
            this.f3468b = i4;
            this.f3469c = progressDialog;
            this.f3470d = dVar;
            this.f3471e = i5;
            this.f3472f = str;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeUtil.classesInit0(52);
    }

    private native boolean N();

    /* JADX INFO: Access modifiers changed from: private */
    public native void O(int i4);

    private native void Q(String str, int i4, int i5);

    private native void R();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(String str, int i4, String str2) {
        Log.d("mp4Camera", "checkAndUpdateAPK body:" + str2);
        if (i4 != 200) {
            Log.e("mp4Camera", "checkAndUpdateAPK fail :" + str2);
            return;
        }
        String[] split = str2.split("\n");
        if (split.length != 2) {
            Log.e("mp4Camera", "ignore update");
            return;
        }
        if (str.equals(split[0])) {
            Log.e("mp4Camera", str + " is latest version");
            return;
        }
        if (split[1].indexOf("http") != 0) {
            Log.e("mp4Camera", "invalid update url");
        } else {
            runOnUiThread(new d(split));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(com.nvshen.chmp4.d dVar, int i4, int i5, String str) {
        runOnUiThread(new b(dVar, i5, str, i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(ProgressDialog progressDialog, com.nvshen.chmp4.d dVar, int i4, int i5, String str) {
        Log.e("mp4Camera", "downloadAPK " + i4 + ", progress:" + i5 + "," + str);
        runOnUiThread(new e(i4, progressDialog, dVar, i5, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void X(String str, int i4);

    public native void M();

    protected native void P(String str, String str2);

    public native void S(String str, String str2);

    public native String T();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, n.d, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    public native void onDestroy();

    @Override // androidx.fragment.app.d, android.app.Activity
    public native void onPause();

    @Override // androidx.fragment.app.d, android.app.Activity
    protected native void onResume();
}
