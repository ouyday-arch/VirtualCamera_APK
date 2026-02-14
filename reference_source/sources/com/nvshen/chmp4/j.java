package com.nvshen.chmp4;

import android.widget.Button;
import com.nmmedit.protect.NativeUtil;
import n2.e;

/* loaded from: classes.dex */
class j implements e.a<Button> {

    /* renamed from: a, reason: collision with root package name */
    private e.a<Button> f3523a;

    /* renamed from: b, reason: collision with root package name */
    private String f3524b;

    /* renamed from: c, reason: collision with root package name */
    private String f3525c;

    /* loaded from: classes.dex */
    class a implements e.a<Button> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Button f3526a;

        static {
            NativeUtil.classesInit0(45);
        }

        a(Button button) {
            this.f3526a = button;
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    static {
        NativeUtil.classesInit0(13);
    }

    public j(e.a<Button> aVar, String str, String str2) {
        this.f3523a = aVar;
        this.f3524b = str2;
        this.f3525c = str;
    }

    @Override // n2.e.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public native void a(n2.e<?> eVar, Button button);
}
