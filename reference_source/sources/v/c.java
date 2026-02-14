package v;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f6255b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f6256c;

    /* renamed from: f, reason: collision with root package name */
    private final int f6259f;

    /* renamed from: g, reason: collision with root package name */
    private final int f6260g;

    /* renamed from: h, reason: collision with root package name */
    private final String f6261h;

    /* renamed from: a, reason: collision with root package name */
    private final Object f6254a = new Object();

    /* renamed from: e, reason: collision with root package name */
    private Handler.Callback f6258e = new a();

    /* renamed from: d, reason: collision with root package name */
    private int f6257d = 0;

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 0) {
                c.this.a();
                return true;
            }
            if (i4 != 1) {
                return true;
            }
            c.this.b((Runnable) message.obj);
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Callable f6263b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Handler f6264c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f6265d;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f6267b;

            a(Object obj) {
                this.f6267b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f6265d.a(this.f6267b);
            }
        }

        b(Callable callable, Handler handler, d dVar) {
            this.f6263b = callable;
            this.f6264c = handler;
            this.f6265d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.f6263b.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f6264c.post(new a(obj));
        }
    }

    /* renamed from: v.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0083c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f6269b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Callable f6270c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReentrantLock f6271d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f6272e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Condition f6273f;

        RunnableC0083c(AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f6269b = atomicReference;
            this.f6270c = callable;
            this.f6271d = reentrantLock;
            this.f6272e = atomicBoolean;
            this.f6273f = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6269b.set(this.f6270c.call());
            } catch (Exception unused) {
            }
            this.f6271d.lock();
            try {
                this.f6272e.set(false);
                this.f6273f.signal();
            } finally {
                this.f6271d.unlock();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t4);
    }

    public c(String str, int i4, int i5) {
        this.f6261h = str;
        this.f6260g = i4;
        this.f6259f = i5;
    }

    private void c(Runnable runnable) {
        synchronized (this.f6254a) {
            if (this.f6255b == null) {
                HandlerThread handlerThread = new HandlerThread(this.f6261h, this.f6260g);
                this.f6255b = handlerThread;
                handlerThread.start();
                this.f6256c = new Handler(this.f6255b.getLooper(), this.f6258e);
                this.f6257d++;
            }
            this.f6256c.removeMessages(0);
            Handler handler = this.f6256c;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    void a() {
        synchronized (this.f6254a) {
            if (this.f6256c.hasMessages(1)) {
                return;
            }
            this.f6255b.quit();
            this.f6255b = null;
            this.f6256c = null;
        }
    }

    void b(Runnable runnable) {
        runnable.run();
        synchronized (this.f6254a) {
            this.f6256c.removeMessages(0);
            Handler handler = this.f6256c;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f6259f);
        }
    }

    public <T> void d(Callable<T> callable, d<T> dVar) {
        c(new b(callable, new Handler(), dVar));
    }

    public <T> T e(Callable<T> callable, int i4) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        c(new RunnableC0083c(atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i4);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
