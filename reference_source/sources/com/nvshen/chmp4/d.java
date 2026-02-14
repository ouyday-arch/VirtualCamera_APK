package com.nvshen.chmp4;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import com.nmmedit.protect.NativeUtil;
import com.telegram.a1064.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import l3.a0;
import l3.c0;
import l3.e0;
import l3.y;
import org.json.JSONException;
import org.json.JSONObject;
import s2.b;

/* loaded from: classes.dex */
public class d {

    /* renamed from: q, reason: collision with root package name */
    private static d f3486q;

    /* renamed from: a, reason: collision with root package name */
    private String f3487a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f3488b = "";

    /* renamed from: c, reason: collision with root package name */
    private Context f3489c = null;

    /* renamed from: d, reason: collision with root package name */
    private int f3490d = -1;

    /* renamed from: e, reason: collision with root package name */
    private long f3491e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f3492f = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f3493g = "";

    /* renamed from: h, reason: collision with root package name */
    private ProgressDialog f3494h = null;

    /* renamed from: i, reason: collision with root package name */
    private int f3495i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f3496j = 32;

    /* renamed from: k, reason: collision with root package name */
    private String f3497k = "";

    /* renamed from: l, reason: collision with root package name */
    private HashMap<String, String> f3498l = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, String> f3499m = new HashMap<>();

    /* renamed from: n, reason: collision with root package name */
    private String[] f3500n = {"https://xnxi.xyz", "https://xnxi.xyz"};

    /* renamed from: o, reason: collision with root package name */
    private int f3501o = 0;

    /* renamed from: p, reason: collision with root package name */
    private HashMap<String, g> f3502p = new HashMap<>();

    /* loaded from: classes.dex */
    class a implements l3.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3503d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3504e;

        static {
            NativeUtil.classesInit0(41);
        }

        a(String str, String str2) {
            this.f3503d = str;
            this.f3504e = str2;
        }

        @Override // l3.b
        public native a0 a(e0 e0Var, c0 c0Var);
    }

    /* loaded from: classes.dex */
    class b implements l3.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f3506a;

        static {
            NativeUtil.classesInit0(43);
        }

        b(e eVar) {
            this.f3506a = eVar;
        }

        @Override // l3.f
        public native void a(l3.e eVar, c0 c0Var);

        @Override // l3.f
        public native void b(l3.e eVar, IOException iOException);
    }

    /* loaded from: classes.dex */
    class c implements l3.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f3508a;

        static {
            NativeUtil.classesInit0(42);
        }

        c(e eVar) {
            this.f3508a = eVar;
        }

        @Override // l3.f
        public native void a(l3.e eVar, c0 c0Var);

        @Override // l3.f
        public native void b(l3.e eVar, IOException iOException);
    }

    /* renamed from: com.nvshen.chmp4.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0037d implements l3.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f3510a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3511b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3512c;

        static {
            NativeUtil.classesInit0(44);
        }

        C0037d(h hVar, String str, String str2) {
            this.f3510a = hVar;
            this.f3511b = str;
            this.f3512c = str2;
        }

        @Override // l3.f
        public native void a(l3.e eVar, c0 c0Var);

        @Override // l3.f
        public native void b(l3.e eVar, IOException iOException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void a(int i4, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void a(int i4);
    }

    /* loaded from: classes.dex */
    interface g {
        void a();
    }

    /* loaded from: classes.dex */
    interface h {
        void a(int i4, int i5, String str);
    }

    static {
        NativeUtil.classesInit0(22);
    }

    public static native d B();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(f fVar, int i4, String str) {
        int i5;
        if (i4 == 200) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                i5 = jSONObject.getInt("code");
                if (i5 == 200) {
                    this.f3490d = jSONObject.optInt("remain");
                    this.f3492f = jSONObject.optInt("now");
                    this.f3493g = jSONObject.optString("token");
                    this.f3495i = jSONObject.optInt("ns", 0);
                    this.f3491e = jSONObject.optLong("expiredTime", 0L);
                    N();
                }
            } catch (JSONException e4) {
                i5 = 500;
                e4.printStackTrace();
            }
            i4 = i5;
        }
        fVar.a(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(StringBuffer stringBuffer, String str, String str2) {
        stringBuffer.append(str + "=" + str2 + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(b.e eVar) {
        a0();
        int a5 = eVar.a();
        Iterator<String> it = eVar.c().iterator();
        while (it.hasNext()) {
            Log.e("HOOK", it.next());
        }
        Iterator<String> it2 = eVar.b().iterator();
        while (it2.hasNext()) {
            Log.e("HOOK", it2.next());
        }
        if (eVar.a() == 0) {
            Y(this.f3489c.getString(R.string.replace_camera_success));
            k.c().b();
        } else {
            Y(this.f3489c.getString(R.string.replace_camera_fail) + a5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(e eVar, int i4, String str) {
        JSONObject jSONObject;
        Log.e("TAG", str);
        if (i4 == 200) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e4) {
                e4.printStackTrace();
                str = e4.getMessage();
            }
            if (jSONObject.getInt("code") == 200) {
                this.f3492f = jSONObject.optInt("now");
                this.f3493g = jSONObject.optString("token");
                this.f3495i = jSONObject.optInt("ns", 0);
                this.f3491e = jSONObject.optLong("expiredTime", 0L);
                if (this.f3493g.length() > 5) {
                    this.f3490d = jSONObject.optInt("remain");
                }
                N();
            } else {
                str = jSONObject.optString("error", "unknow");
                i4 = 500;
            }
        }
        eVar.a(i4, str);
    }

    private native void N();

    public native y A();

    public native String C();

    public native int D();

    public native String E();

    public native String F();

    public native String G();

    public native void M();

    public native void O(String str, String str2, e eVar);

    public native void P(String str);

    public native void Q();

    public native void R(int i4);

    public native void S(Context context);

    public native void T(String str);

    public native void U(String str);

    public native void V(String str);

    public native void W(String str);

    public native void X(String str);

    public native void Y(String str);

    @SuppressLint({"DefaultLocale"})
    public native void Z();

    public native void a0();

    public native void b0(e eVar);

    public native void f(String str, f fVar);

    public native void g(String str, g gVar);

    public native void h(String str, String str2);

    public native ProgressDialog i(String str);

    public native int j(String str);

    public native void k(String str, String str2, h hVar);

    public native int l(String str);

    public native List<String> m();

    public native void n(String str, String str2, e eVar);

    public native String o();

    public native String p();

    public native int q();

    public native Context r();

    public native String s();

    public native String t();

    public native String u(String str);

    public native long v();

    public native String w();

    public native String x();

    public native int y();

    public native int z();
}
