package t2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class n extends AbstractExecutorService implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5983a = false;

    /* renamed from: b, reason: collision with root package name */
    private ArrayDeque<Runnable> f5984b = new ArrayDeque<>();

    /* renamed from: c, reason: collision with root package name */
    private FutureTask<Void> f5985c = null;

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        Runnable poll;
        while (true) {
            synchronized (this) {
                poll = this.f5984b.poll();
                if (poll == null) {
                    this.f5985c = null;
                    return null;
                }
            }
            poll.run();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean awaitTermination(long j4, TimeUnit timeUnit) {
        FutureTask<Void> futureTask = this.f5985c;
        if (futureTask == null) {
            return true;
        }
        try {
            futureTask.get(j4, timeUnit);
        } catch (ExecutionException unused) {
        } catch (TimeoutException unused2) {
            return false;
        }
        return true;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (this.f5983a) {
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + toString());
        }
        this.f5984b.offer(runnable);
        if (this.f5985c == null) {
            FutureTask<Void> futureTask = new FutureTask<>(this);
            this.f5985c = futureTask;
            s2.b.f5886b.execute(futureTask);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean isShutdown() {
        return this.f5983a;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean isTerminated() {
        boolean z4;
        if (this.f5983a) {
            z4 = this.f5985c == null;
        }
        return z4;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized void shutdown() {
        this.f5983a = true;
        this.f5984b.clear();
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized List<Runnable> shutdownNow() {
        this.f5983a = true;
        FutureTask<Void> futureTask = this.f5985c;
        if (futureTask != null) {
            futureTask.cancel(true);
        }
        try {
        } finally {
            this.f5984b.clear();
        }
        return new ArrayList(this.f5984b);
    }
}
