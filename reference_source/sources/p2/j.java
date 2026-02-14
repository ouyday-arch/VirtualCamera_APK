package p2;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
public class j {

    /* renamed from: k, reason: collision with root package name */
    private static final String f5441k = "j";

    /* renamed from: a, reason: collision with root package name */
    private q2.g f5442a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f5443b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f5444c;

    /* renamed from: d, reason: collision with root package name */
    private g f5445d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f5446e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f5447f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5448g = false;

    /* renamed from: h, reason: collision with root package name */
    private final Object f5449h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private final Handler.Callback f5450i = new a();

    /* renamed from: j, reason: collision with root package name */
    private final q2.p f5451j = new b();

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == l1.k.f4524e) {
                j.this.g((r) message.obj);
                return true;
            }
            if (i4 != l1.k.f4528i) {
                return true;
            }
            j.this.h();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b implements q2.p {
        b() {
        }

        @Override // q2.p
        public void a(Exception exc) {
            synchronized (j.this.f5449h) {
                if (j.this.f5448g) {
                    j.this.f5444c.obtainMessage(l1.k.f4528i).sendToTarget();
                }
            }
        }

        @Override // q2.p
        public void b(r rVar) {
            synchronized (j.this.f5449h) {
                if (j.this.f5448g) {
                    j.this.f5444c.obtainMessage(l1.k.f4524e, rVar).sendToTarget();
                }
            }
        }
    }

    public j(q2.g gVar, g gVar2, Handler handler) {
        s.a();
        this.f5442a = gVar;
        this.f5445d = gVar2;
        this.f5446e = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(r rVar) {
        Message obtain;
        long currentTimeMillis = System.currentTimeMillis();
        rVar.d(this.f5447f);
        g1.j f4 = f(rVar);
        g1.q c5 = f4 != null ? this.f5445d.c(f4) : null;
        if (c5 != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d(f5441k, "Found barcode in " + (currentTimeMillis2 - currentTimeMillis) + " ms");
            if (this.f5446e != null) {
                obtain = Message.obtain(this.f5446e, l1.k.f4526g, new c(c5, rVar));
                obtain.setData(new Bundle());
                obtain.sendToTarget();
            }
        } else {
            Handler handler = this.f5446e;
            if (handler != null) {
                obtain = Message.obtain(handler, l1.k.f4525f);
                obtain.sendToTarget();
            }
        }
        if (this.f5446e != null) {
            Message.obtain(this.f5446e, l1.k.f4527h, c.e(this.f5445d.d(), rVar)).sendToTarget();
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f5442a.v(this.f5451j);
    }

    protected g1.j f(r rVar) {
        if (this.f5447f == null) {
            return null;
        }
        return rVar.a();
    }

    public void i(Rect rect) {
        this.f5447f = rect;
    }

    public void j(g gVar) {
        this.f5445d = gVar;
    }

    public void k() {
        s.a();
        HandlerThread handlerThread = new HandlerThread(f5441k);
        this.f5443b = handlerThread;
        handlerThread.start();
        this.f5444c = new Handler(this.f5443b.getLooper(), this.f5450i);
        this.f5448g = true;
        h();
    }

    public void l() {
        s.a();
        synchronized (this.f5449h) {
            this.f5448g = false;
            this.f5444c.removeCallbacksAndMessages(null);
            this.f5443b.quit();
        }
    }
}
