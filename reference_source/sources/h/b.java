package h;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a, reason: collision with root package name */
    private final Object f4069a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f4070b = Executors.newFixedThreadPool(2, new a());

    /* renamed from: c, reason: collision with root package name */
    private volatile Handler f4071c;

    /* loaded from: classes.dex */
    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4072a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f4072a.getAndIncrement())));
            return thread;
        }
    }

    @Override // h.c
    public void a(Runnable runnable) {
        this.f4070b.execute(runnable);
    }

    @Override // h.c
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // h.c
    public void c(Runnable runnable) {
        if (this.f4071c == null) {
            synchronized (this.f4069a) {
                if (this.f4071c == null) {
                    this.f4071c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f4071c.post(runnable);
    }
}
