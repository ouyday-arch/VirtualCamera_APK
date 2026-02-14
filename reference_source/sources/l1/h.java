package l1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import l1.h;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4507a;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f4511e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4512f;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4509c = false;

    /* renamed from: b, reason: collision with root package name */
    private final BroadcastReceiver f4508b = new b();

    /* renamed from: d, reason: collision with root package name */
    private Handler f4510d = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b extends BroadcastReceiver {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z4) {
            h.this.f(z4);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z4 = intent.getIntExtra("plugged", -1) <= 0;
                h.this.f4510d.post(new Runnable() { // from class: l1.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.b.this.b(z4);
                    }
                });
            }
        }
    }

    public h(Context context, Runnable runnable) {
        this.f4507a = context;
        this.f4511e = runnable;
    }

    private void e() {
        this.f4510d.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z4) {
        this.f4512f = z4;
        if (this.f4509c) {
            c();
        }
    }

    private void g() {
        if (this.f4509c) {
            return;
        }
        this.f4507a.registerReceiver(this.f4508b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f4509c = true;
    }

    private void i() {
        if (this.f4509c) {
            this.f4507a.unregisterReceiver(this.f4508b);
            this.f4509c = false;
        }
    }

    public void c() {
        e();
        if (this.f4512f) {
            this.f4510d.postDelayed(this.f4511e, 300000L);
        }
    }

    public void d() {
        e();
        i();
    }

    public void h() {
        g();
        c();
    }
}
