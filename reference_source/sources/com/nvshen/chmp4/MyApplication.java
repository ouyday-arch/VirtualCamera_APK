package com.nvshen.chmp4;

import android.app.Application;
import com.nmmedit.protect.NativeUtil;

/* loaded from: classes.dex */
public class MyApplication extends Application {

    /* renamed from: b, reason: collision with root package name */
    private String f3474b;

    static {
        NativeUtil.classesInit0(40);
    }

    public native void a(String str);

    @Override // android.app.Application
    public native void onCreate();
}
