package com.nvshen.chmp4;

import android.os.Binder;
import android.os.Parcel;
import com.nmmedit.protect.NativeUtil;

/* loaded from: classes.dex */
class i extends Binder {
    static {
        NativeUtil.classesInit0(2);
    }

    @Override // android.os.Binder
    protected native boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5);
}
