package q2;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: e, reason: collision with root package name */
    private static k f5606e;

    /* renamed from: a, reason: collision with root package name */
    private Handler f5607a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f5608b;

    /* renamed from: c, reason: collision with root package name */
    private int f5609c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final Object f5610d = new Object();

    private k() {
    }

    private void a() {
        synchronized (this.f5610d) {
            if (this.f5607a == null) {
                if (this.f5609c <= 0) {
                    throw new IllegalStateException("CameraThread is not open");
                }
                HandlerThread handlerThread = new HandlerThread("CameraThread");
                this.f5608b = handlerThread;
                handlerThread.start();
                this.f5607a = new Handler(this.f5608b.getLooper());
            }
        }
    }

    public static k d() {
        if (f5606e == null) {
            f5606e = new k();
        }
        return f5606e;
    }

    private void f() {
        synchronized (this.f5610d) {
            this.f5608b.quit();
            this.f5608b = null;
            this.f5607a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        synchronized (this.f5610d) {
            int i4 = this.f5609c - 1;
            this.f5609c = i4;
            if (i4 == 0) {
                f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Runnable runnable) {
        synchronized (this.f5610d) {
            a();
            this.f5607a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Runnable runnable) {
        synchronized (this.f5610d) {
            this.f5609c++;
            c(runnable);
        }
    }
}
