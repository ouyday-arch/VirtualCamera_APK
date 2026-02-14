package com.nvshen.chmp4;

import android.app.ProgressDialog;
import com.nmmedit.protect.NativeUtil;
import com.nvshen.chmp4.d;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements d.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f3519a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f3520b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f3521c;

    static {
        NativeUtil.classesInit0(7);
    }

    public /* synthetic */ g(MainActivity mainActivity, ProgressDialog progressDialog, d dVar) {
        this.f3519a = mainActivity;
        this.f3520b = progressDialog;
        this.f3521c = dVar;
    }

    @Override // com.nvshen.chmp4.d.h
    public final native void a(int i4, int i5, String str);
}
