package q2;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import q2.a;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    private static final String f5535i = "a";

    /* renamed from: j, reason: collision with root package name */
    private static final Collection<String> f5536j;

    /* renamed from: a, reason: collision with root package name */
    private boolean f5537a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5538b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f5539c;

    /* renamed from: d, reason: collision with root package name */
    private final Camera f5540d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f5541e;

    /* renamed from: f, reason: collision with root package name */
    private int f5542f = 1;

    /* renamed from: g, reason: collision with root package name */
    private final Handler.Callback f5543g;

    /* renamed from: h, reason: collision with root package name */
    private final Camera.AutoFocusCallback f5544h;

    /* renamed from: q2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0071a implements Handler.Callback {
        C0071a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != a.this.f5542f) {
                return false;
            }
            a.this.h();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Camera.AutoFocusCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            a.this.f5538b = false;
            a.this.f();
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z4, Camera camera) {
            a.this.f5541e.post(new Runnable() { // from class: q2.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.this.b();
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f5536j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public a(Camera camera, i iVar) {
        C0071a c0071a = new C0071a();
        this.f5543g = c0071a;
        this.f5544h = new b();
        this.f5541e = new Handler(c0071a);
        this.f5540d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z4 = iVar.c() && f5536j.contains(focusMode);
        this.f5539c = z4;
        Log.i(f5535i, "Current focus mode '" + focusMode + "'; use auto focus? " + z4);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (!this.f5537a && !this.f5541e.hasMessages(this.f5542f)) {
            Handler handler = this.f5541e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f5542f), 2000L);
        }
    }

    private void g() {
        this.f5541e.removeMessages(this.f5542f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f5539c || this.f5537a || this.f5538b) {
            return;
        }
        try {
            this.f5540d.autoFocus(this.f5544h);
            this.f5538b = true;
        } catch (RuntimeException e4) {
            Log.w(f5535i, "Unexpected exception while focusing", e4);
            f();
        }
    }

    public void i() {
        this.f5537a = false;
        h();
    }

    public void j() {
        this.f5537a = true;
        this.f5538b = false;
        g();
        if (this.f5539c) {
            try {
                this.f5540d.cancelAutoFocus();
            } catch (RuntimeException e4) {
                Log.w(f5535i, "Unexpected exception while cancelling focusing", e4);
            }
        }
    }
}
