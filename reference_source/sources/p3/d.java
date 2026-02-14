package p3;

import e3.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import m3.p;
import m3.s;
import u2.l;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: k, reason: collision with root package name */
    public static final b f5488k = new b(null);

    /* renamed from: l, reason: collision with root package name */
    private static final Logger f5489l;

    /* renamed from: m, reason: collision with root package name */
    public static final d f5490m;

    /* renamed from: a, reason: collision with root package name */
    private final a f5491a;

    /* renamed from: b, reason: collision with root package name */
    private final Logger f5492b;

    /* renamed from: c, reason: collision with root package name */
    private final ReentrantLock f5493c;

    /* renamed from: d, reason: collision with root package name */
    private final Condition f5494d;

    /* renamed from: e, reason: collision with root package name */
    private int f5495e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5496f;

    /* renamed from: g, reason: collision with root package name */
    private long f5497g;

    /* renamed from: h, reason: collision with root package name */
    private final List<p3.c> f5498h;

    /* renamed from: i, reason: collision with root package name */
    private final List<p3.c> f5499i;

    /* renamed from: j, reason: collision with root package name */
    private final Runnable f5500j;

    /* loaded from: classes.dex */
    public interface a {
        void a(d dVar, long j4);

        void b(d dVar, Runnable runnable);

        void c(d dVar);

        <T> BlockingQueue<T> d(BlockingQueue<T> blockingQueue);

        long e();
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f5501a;

        public c(ThreadFactory threadFactory) {
            f.e(threadFactory, "threadFactory");
            this.f5501a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // p3.d.a
        public void a(d dVar, long j4) {
            f.e(dVar, "taskRunner");
            ReentrantLock h4 = dVar.h();
            if (!s.f5213e || h4.isHeldByCurrentThread()) {
                if (j4 > 0) {
                    dVar.g().awaitNanos(j4);
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + h4);
            }
        }

        @Override // p3.d.a
        public void b(d dVar, Runnable runnable) {
            f.e(dVar, "taskRunner");
            f.e(runnable, "runnable");
            this.f5501a.execute(runnable);
        }

        @Override // p3.d.a
        public void c(d dVar) {
            f.e(dVar, "taskRunner");
            dVar.g().signal();
        }

        @Override // p3.d.a
        public <T> BlockingQueue<T> d(BlockingQueue<T> blockingQueue) {
            f.e(blockingQueue, "queue");
            return blockingQueue;
        }

        @Override // p3.d.a
        public long e() {
            return System.nanoTime();
        }
    }

    /* renamed from: p3.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0068d implements Runnable {
        RunnableC0068d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                ReentrantLock h4 = d.this.h();
                d dVar = d.this;
                h4.lock();
                try {
                    p3.a c5 = dVar.c();
                    if (c5 == null) {
                        return;
                    }
                    Logger i4 = d.this.i();
                    p3.c d5 = c5.d();
                    f.b(d5);
                    d dVar2 = d.this;
                    long j4 = -1;
                    boolean isLoggable = i4.isLoggable(Level.FINE);
                    if (isLoggable) {
                        j4 = d5.j().f().e();
                        p3.b.c(i4, c5, d5, "starting");
                    }
                    try {
                        try {
                            dVar2.l(c5);
                            l lVar = l.f6223a;
                            if (isLoggable) {
                                p3.b.c(i4, c5, d5, "finished run in " + p3.b.b(d5.j().f().e() - j4));
                            }
                        } catch (Throwable th) {
                            dVar2.h().lock();
                            try {
                                dVar2.f().b(dVar2, this);
                                l lVar2 = l.f6223a;
                                throw th;
                            } finally {
                            }
                        }
                    } catch (Throwable th2) {
                        if (isLoggable) {
                            p3.b.c(i4, c5, d5, "failed a run in " + p3.b.b(d5.j().f().e() - j4));
                        }
                        throw th2;
                    }
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Logger logger = Logger.getLogger(d.class.getName());
        f.d(logger, "getLogger(...)");
        f5489l = logger;
        f5490m = new d(new c(s.n(s.f5214f + " TaskRunner", true)), 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    }

    public d(a aVar, Logger logger) {
        f.e(aVar, "backend");
        f.e(logger, "logger");
        this.f5491a = aVar;
        this.f5492b = logger;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f5493c = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        f.d(newCondition, "newCondition(...)");
        this.f5494d = newCondition;
        this.f5495e = 10000;
        this.f5498h = new ArrayList();
        this.f5499i = new ArrayList();
        this.f5500j = new RunnableC0068d();
    }

    public /* synthetic */ d(a aVar, Logger logger, int i4, e3.d dVar) {
        this(aVar, (i4 & 2) != 0 ? f5489l : logger);
    }

    private final void b(p3.a aVar, long j4) {
        ReentrantLock reentrantLock = this.f5493c;
        if (s.f5213e && !reentrantLock.isHeldByCurrentThread()) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + reentrantLock);
        }
        p3.c d5 = aVar.d();
        f.b(d5);
        if (!(d5.e() == aVar)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean f4 = d5.f();
        d5.p(false);
        d5.o(null);
        this.f5498h.remove(d5);
        if (j4 != -1 && !f4 && !d5.i()) {
            d5.n(aVar, j4, true);
        }
        if (!d5.g().isEmpty()) {
            this.f5499i.add(d5);
        }
    }

    private final void d(p3.a aVar) {
        ReentrantLock reentrantLock = this.f5493c;
        if (s.f5213e && !reentrantLock.isHeldByCurrentThread()) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + reentrantLock);
        }
        aVar.g(-1L);
        p3.c d5 = aVar.d();
        f.b(d5);
        d5.g().remove(aVar);
        this.f5499i.remove(d5);
        d5.o(aVar);
        this.f5498h.add(d5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(p3.a aVar) {
        ReentrantLock reentrantLock;
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(aVar.b());
        try {
            long f4 = aVar.f();
            reentrantLock = this.f5493c;
            reentrantLock.lock();
            try {
                b(aVar, f4);
                l lVar = l.f6223a;
                reentrantLock.unlock();
                currentThread.setName(name);
            } finally {
            }
        } catch (Throwable th) {
            reentrantLock = this.f5493c;
            reentrantLock.lock();
            try {
                b(aVar, -1L);
                l lVar2 = l.f6223a;
                reentrantLock.unlock();
                currentThread.setName(name);
                throw th;
            } finally {
            }
        }
    }

    public final p3.a c() {
        boolean z4;
        ReentrantLock reentrantLock = this.f5493c;
        if (s.f5213e && !reentrantLock.isHeldByCurrentThread()) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + reentrantLock);
        }
        while (!this.f5499i.isEmpty()) {
            long e4 = this.f5491a.e();
            long j4 = Long.MAX_VALUE;
            Iterator<p3.c> it = this.f5499i.iterator();
            p3.a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z4 = false;
                    break;
                }
                p3.a aVar2 = it.next().g().get(0);
                long max = Math.max(0L, aVar2.c() - e4);
                if (max > 0) {
                    j4 = Math.min(max, j4);
                } else {
                    if (aVar != null) {
                        z4 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                d(aVar);
                if (z4 || (!this.f5496f && (!this.f5499i.isEmpty()))) {
                    this.f5491a.b(this, this.f5500j);
                }
                return aVar;
            }
            if (this.f5496f) {
                if (j4 < this.f5497g - e4) {
                    this.f5491a.c(this);
                }
                return null;
            }
            this.f5496f = true;
            this.f5497g = e4 + j4;
            try {
                try {
                    this.f5491a.a(this, j4);
                } catch (InterruptedException unused) {
                    e();
                }
            } finally {
                this.f5496f = false;
            }
        }
        return null;
    }

    public final void e() {
        ReentrantLock reentrantLock = this.f5493c;
        if (s.f5213e && !reentrantLock.isHeldByCurrentThread()) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + reentrantLock);
        }
        int size = this.f5498h.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            } else {
                this.f5498h.get(size).b();
            }
        }
        for (int size2 = this.f5499i.size() - 1; -1 < size2; size2--) {
            p3.c cVar = this.f5499i.get(size2);
            cVar.b();
            if (cVar.g().isEmpty()) {
                this.f5499i.remove(size2);
            }
        }
    }

    public final a f() {
        return this.f5491a;
    }

    public final Condition g() {
        return this.f5494d;
    }

    public final ReentrantLock h() {
        return this.f5493c;
    }

    public final Logger i() {
        return this.f5492b;
    }

    public final void j(p3.c cVar) {
        f.e(cVar, "taskQueue");
        ReentrantLock reentrantLock = this.f5493c;
        if (s.f5213e && !reentrantLock.isHeldByCurrentThread()) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + reentrantLock);
        }
        if (cVar.e() == null) {
            if (!cVar.g().isEmpty()) {
                p.a(this.f5499i, cVar);
            } else {
                this.f5499i.remove(cVar);
            }
        }
        if (this.f5496f) {
            this.f5491a.c(this);
        } else {
            this.f5491a.b(this, this.f5500j);
        }
    }

    public final p3.c k() {
        ReentrantLock reentrantLock = this.f5493c;
        reentrantLock.lock();
        try {
            int i4 = this.f5495e;
            this.f5495e = i4 + 1;
            reentrantLock.unlock();
            StringBuilder sb = new StringBuilder();
            sb.append('Q');
            sb.append(i4);
            return new p3.c(this, sb.toString());
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
