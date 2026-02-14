package r2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class k {

    /* renamed from: c, reason: collision with root package name */
    private static final TimeUnit f5849c = TimeUnit.SECONDS;

    /* renamed from: a, reason: collision with root package name */
    private BlockingQueue<Runnable> f5850a;

    /* renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f5851b;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ byte[] f5852b;

        a(byte[] bArr) {
            this.f5852b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.c(this.f5852b);
        }
    }

    public k() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f5850a = new LinkedBlockingQueue();
        this.f5851b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 10L, f5849c, this.f5850a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(byte[] bArr) {
    }

    public synchronized void b(byte[] bArr) {
        this.f5851b.execute(new a(bArr));
    }
}
