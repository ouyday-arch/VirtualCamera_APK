package com.nvshen.chmp4;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.nmmedit.protect.NativeUtil;
import com.telegram.a1064.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import n2.e;

/* loaded from: classes.dex */
public class m extends Fragment {

    /* renamed from: b0, reason: collision with root package name */
    public static String f3534b0 = "SettingsFragment";

    /* renamed from: c0, reason: collision with root package name */
    public static n2.e<?> f3535c0;
    Handler Z = new Handler();

    /* renamed from: a0, reason: collision with root package name */
    Runnable f3536a0 = new k();

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        static {
            NativeUtil.classesInit0(34);
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* loaded from: classes.dex */
    class b implements j2.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f3538a;

        static {
            NativeUtil.classesInit0(33);
        }

        b(Activity activity) {
            this.f3538a = activity;
        }

        @Override // j2.h
        public native void a(List<String> list, boolean z4);

        @Override // j2.h
        public native void b(List<String> list, boolean z4);
    }

    /* loaded from: classes.dex */
    class c implements e.a<Button> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e.a f3540a;

        static {
            NativeUtil.classesInit0(36);
        }

        c(e.a aVar) {
            this.f3540a = aVar;
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    /* loaded from: classes.dex */
    class d implements e.a<Button> {
        static {
            NativeUtil.classesInit0(35);
        }

        d() {
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    /* loaded from: classes.dex */
    class e implements e.a<Button> {
        static {
            NativeUtil.classesInit0(3);
        }

        e() {
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    /* loaded from: classes.dex */
    class f implements e.a<Button> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f3541a;

        static {
            NativeUtil.classesInit0(1);
        }

        f(Activity activity) {
            this.f3541a = activity;
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    /* loaded from: classes.dex */
    class g implements e.a<Button> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f3542a;

        static {
            NativeUtil.classesInit0(8);
        }

        g(Activity activity) {
            this.f3542a = activity;
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    /* loaded from: classes.dex */
    class h implements e.a<Button> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Application f3543a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f3544b;

        /* loaded from: classes.dex */
        class a implements e.a<Button> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f3545a;

            static {
                NativeUtil.classesInit0(31);
            }

            a(Context context) {
                this.f3545a = context;
            }

            @Override // n2.e.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public native void a(n2.e<?> eVar, Button button);
        }

        /* loaded from: classes.dex */
        class b implements e.a<Button> {
            static {
                NativeUtil.classesInit0(30);
            }

            b() {
            }

            @Override // n2.e.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public native void a(n2.e<?> eVar, Button button);
        }

        static {
            NativeUtil.classesInit0(6);
        }

        h(Application application, Activity activity) {
            this.f3543a = application;
            this.f3544b = activity;
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    /* loaded from: classes.dex */
    class i implements e.a<Button> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f3548a;

        static {
            NativeUtil.classesInit0(11);
        }

        i(Activity activity) {
            this.f3548a = activity;
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    /* loaded from: classes.dex */
    class j implements e.a<Button> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f3549a;

        static {
            NativeUtil.classesInit0(10);
        }

        j(Activity activity) {
            this.f3549a = activity;
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    /* loaded from: classes.dex */
    class k implements Runnable {
        static {
            NativeUtil.classesInit0(16);
        }

        k() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* loaded from: classes.dex */
    class l implements e.a<Button> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f3551a;

        static {
            NativeUtil.classesInit0(14);
        }

        l(Activity activity) {
            this.f3551a = activity;
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    /* renamed from: com.nvshen.chmp4.m$m, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0038m implements e.a<Button> {
        static {
            NativeUtil.classesInit0(19);
        }

        C0038m() {
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, Button button);
    }

    /* loaded from: classes.dex */
    class n implements e.a<ImageView> {
        static {
            NativeUtil.classesInit0(17);
        }

        n() {
        }

        @Override // n2.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public native void a(n2.e<?> eVar, ImageView imageView);
    }

    /* loaded from: classes.dex */
    class o implements View.OnClickListener {
        static {
            NativeUtil.classesInit0(21);
        }

        o() {
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* loaded from: classes.dex */
    class p implements View.OnClickListener {
        static {
            NativeUtil.classesInit0(20);
        }

        p() {
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* loaded from: classes.dex */
    class q implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f3554b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextView f3555c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f3557b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ TextView f3558c;

            static {
                NativeUtil.classesInit0(46);
            }

            a(int i4, TextView textView) {
                this.f3557b = i4;
                this.f3558c = textView;
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeUtil.classesInit0(25);
        }

        q(EditText editText, TextView textView) {
            this.f3554b = editText;
            this.f3555c = textView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(TextView textView, int i4) {
            m.this.i().runOnUiThread(new a(i4, textView));
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* loaded from: classes.dex */
    class r implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f3560b;

        static {
            NativeUtil.classesInit0(23);
        }

        r(Context context) {
            this.f3560b = context;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* loaded from: classes.dex */
    class s implements View.OnClickListener {
        static {
            NativeUtil.classesInit0(29);
        }

        s() {
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* loaded from: classes.dex */
    class t implements CompoundButton.OnCheckedChangeListener {
        static {
            NativeUtil.classesInit0(27);
        }

        t() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public native void onCheckedChanged(CompoundButton compoundButton, boolean z4);
    }

    /* loaded from: classes.dex */
    class u implements CompoundButton.OnCheckedChangeListener {
        static {
            NativeUtil.classesInit0(38);
        }

        u() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public native void onCheckedChanged(CompoundButton compoundButton, boolean z4);
    }

    /* loaded from: classes.dex */
    class v implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Spinner f3565b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f3566c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Spinner f3567d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Spinner f3568e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Spinner f3569f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Spinner f3570g;

        static {
            NativeUtil.classesInit0(37);
        }

        v(Spinner spinner, Context context, Spinner spinner2, Spinner spinner3, Spinner spinner4, Spinner spinner5) {
            this.f3565b = spinner;
            this.f3566c = context;
            this.f3567d = spinner2;
            this.f3568e = spinner3;
            this.f3569f = spinner4;
            this.f3570g = spinner5;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    static {
        NativeUtil.classesInit0(12);
    }

    public static native boolean q1(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1(TextView textView) {
        long v4 = com.nvshen.chmp4.d.B().v();
        if (v4 <= 0) {
            textView.setText(R.string.setting_inactivated);
        } else {
            textView.setText(String.format(I(R.string.setting_expired_time), new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(v4))));
            Log.e(f3534b0, "expiredTime:" + v4);
            Log.e(f3534b0, "current:" + System.currentTimeMillis());
            if (v4 > System.currentTimeMillis()) {
                textView.setTextColor(-16711936);
                return;
            }
        }
        textView.setTextColor(-65536);
    }

    public static native void y1(Activity activity);

    static native void z1(Application application, String str, String str2, e.a<Button> aVar);

    public native void A1();

    public native void B1();

    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public native void v1(View view);

    @Override // androidx.fragment.app.Fragment
    public native View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void r1();

    public native void s1();

    public native String t1(Context context);

    public native void u1(View view);

    @Override // androidx.fragment.app.Fragment
    public native void x0();

    public native Bitmap x1(String str);
}
