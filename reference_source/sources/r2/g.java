package r2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import com.telegram.a1064.R;
import j0.a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class g extends Fragment {

    /* loaded from: classes.dex */
    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes.dex */
    class c extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f5844a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f5845b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f5846c;

        c(Map map, String str, String str2) {
            this.f5844a = map;
            this.f5845b = str;
            this.f5846c = str2;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            Log.e("HOOK", "onReceivedHttpAuthRequest" + this.f5845b);
            if (this.f5845b.isEmpty() || this.f5846c.isEmpty()) {
                return;
            }
            httpAuthHandler.proceed(this.f5845b, this.f5846c);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str, this.f5844a);
            return false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetJavaScriptEnabled"})
    public View d0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.fragment_index, viewGroup, false);
        WebView webView = (WebView) inflate.findViewById(R.id.webview);
        String s4 = com.nvshen.chmp4.d.B().s();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUserAgentString(com.nvshen.chmp4.d.B().E());
        String C = com.nvshen.chmp4.d.B().C();
        String str2 = "";
        if (C.indexOf("@") > 0) {
            String[] split = C.split("@");
            String[] split2 = split[0].split("://");
            String[] split3 = split2[1].split(":");
            if (split3.length == 2) {
                str2 = split3[0];
                str = split3[1];
            } else {
                str = "";
            }
            C = split2[0] + "://" + split[1];
        } else {
            str = "";
        }
        if (j0.c.a("PROXY_OVERRIDE") && !C.isEmpty()) {
            j0.a b5 = new a.C0049a().a(C).b();
            Log.e("HOOK", "webview proxy " + C + ", " + str2 + ":" + str);
            j0.b.a().b(b5, new a(), new b());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("deviceId", s4);
        hashMap.put("pkgname", p().getPackageName());
        webView.loadUrl(com.nvshen.chmp4.d.B().o() + "/chmp4.html?t=4&lan=" + Locale.getDefault().getLanguage(), hashMap);
        webView.setWebViewClient(new c(hashMap, str2, str));
        return inflate;
    }
}
