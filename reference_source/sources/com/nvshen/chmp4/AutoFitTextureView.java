package com.nvshen.chmp4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import com.nmmedit.protect.NativeUtil;

/* loaded from: classes.dex */
public class AutoFitTextureView extends TextureView {

    /* renamed from: b, reason: collision with root package name */
    private int f3453b;

    /* renamed from: c, reason: collision with root package name */
    private int f3454c;

    static {
        NativeUtil.classesInit0(4);
    }

    public AutoFitTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoFitTextureView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3453b = 0;
        this.f3454c = 0;
    }

    public native void a(int i4, int i5);

    @Override // android.view.View
    protected native void onMeasure(int i4, int i5);
}
