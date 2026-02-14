package l3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import q3.h;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: c, reason: collision with root package name */
    private Runnable f4776c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f4777d;

    /* renamed from: a, reason: collision with root package name */
    private int f4774a = 64;

    /* renamed from: b, reason: collision with root package name */
    private int f4775b = 5;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayDeque<h.a> f4778e = new ArrayDeque<>();

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque<h.a> f4779f = new ArrayDeque<>();

    /* renamed from: g, reason: collision with root package name */
    private final ArrayDeque<q3.h> f4780g = new ArrayDeque<>();

    private final h.a c(String str) {
        Iterator<h.a> it = this.f4779f.iterator();
        while (it.hasNext()) {
            h.a next = it.next();
            if (e3.f.a(next.f(), str)) {
                return next;
            }
        }
        Iterator<h.a> it2 = this.f4778e.iterator();
        while (it2.hasNext()) {
            h.a next2 = it2.next();
            if (e3.f.a(next2.f(), str)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void d(Deque<T> deque, T t4) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t4)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f4776c;
            u2.l lVar = u2.l.f6223a;
        }
        if (f() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private final boolean f() {
        int i4;
        boolean z4;
        if (m3.s.f5213e && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<h.a> it = this.f4778e.iterator();
            e3.f.d(it, "iterator(...)");
            while (it.hasNext()) {
                h.a next = it.next();
                if (this.f4779f.size() >= this.f4774a) {
                    break;
                }
                if (next.e().get() < this.f4775b) {
                    it.remove();
                    next.e().incrementAndGet();
                    e3.f.b(next);
                    arrayList.add(next);
                    this.f4779f.add(next);
                }
            }
            i4 = 0;
            z4 = g() > 0;
            u2.l lVar = u2.l.f6223a;
        }
        if (b().isShutdown()) {
            int size = arrayList.size();
            while (i4 < size) {
                h.a aVar = (h.a) arrayList.get(i4);
                aVar.e().decrementAndGet();
                synchronized (this) {
                    this.f4779f.remove(aVar);
                }
                h.a.c(aVar, null, 1, null);
                i4++;
            }
            Runnable runnable = this.f4776c;
            if (runnable != null) {
                runnable.run();
            }
        } else {
            int size2 = arrayList.size();
            while (i4 < size2) {
                ((h.a) arrayList.get(i4)).a(b());
                i4++;
            }
        }
        return z4;
    }

    public final void a(h.a aVar) {
        h.a c5;
        e3.f.e(aVar, "call");
        synchronized (this) {
            this.f4778e.add(aVar);
            if (!aVar.d().o() && (c5 = c(aVar.f())) != null) {
                aVar.g(c5);
            }
            u2.l lVar = u2.l.f6223a;
        }
        f();
    }

    public final synchronized ExecutorService b() {
        ExecutorService executorService;
        if (this.f4777d == null) {
            this.f4777d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), m3.s.n(m3.s.f5214f + " Dispatcher", false));
        }
        executorService = this.f4777d;
        e3.f.b(executorService);
        return executorService;
    }

    public final void e(h.a aVar) {
        e3.f.e(aVar, "call");
        aVar.e().decrementAndGet();
        d(this.f4779f, aVar);
    }

    public final synchronized int g() {
        return this.f4779f.size() + this.f4780g.size();
    }
}
