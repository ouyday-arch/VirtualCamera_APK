package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class e {

    /* renamed from: e, reason: collision with root package name */
    private static e f3196e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f3197a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Handler f3198b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c, reason: collision with root package name */
    private c f3199c;

    /* renamed from: d, reason: collision with root package name */
    private c f3200d;

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            e.this.c((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<b> f3202a;

        /* renamed from: b, reason: collision with root package name */
        int f3203b;

        /* renamed from: c, reason: collision with root package name */
        boolean f3204c;

        boolean a(b bVar) {
            return bVar != null && this.f3202a.get() == bVar;
        }
    }

    private e() {
    }

    private boolean a(c cVar, int i4) {
        b bVar = cVar.f3202a.get();
        if (bVar == null) {
            return false;
        }
        this.f3198b.removeCallbacksAndMessages(cVar);
        bVar.a(i4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e b() {
        if (f3196e == null) {
            f3196e = new e();
        }
        return f3196e;
    }

    private boolean d(b bVar) {
        c cVar = this.f3199c;
        return cVar != null && cVar.a(bVar);
    }

    private void g(c cVar) {
        int i4 = cVar.f3203b;
        if (i4 == -2) {
            return;
        }
        if (i4 <= 0) {
            i4 = i4 == -1 ? 1500 : 2750;
        }
        this.f3198b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f3198b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i4);
    }

    void c(c cVar) {
        synchronized (this.f3197a) {
            if (this.f3199c == cVar || this.f3200d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public void e(b bVar) {
        synchronized (this.f3197a) {
            if (d(bVar)) {
                c cVar = this.f3199c;
                if (!cVar.f3204c) {
                    cVar.f3204c = true;
                    this.f3198b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f3197a) {
            if (d(bVar)) {
                c cVar = this.f3199c;
                if (cVar.f3204c) {
                    cVar.f3204c = false;
                    g(cVar);
                }
            }
        }
    }
}
