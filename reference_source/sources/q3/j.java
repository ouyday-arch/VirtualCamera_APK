package q3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import l3.e0;
import m3.s;
import q3.h;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: g, reason: collision with root package name */
    public static final a f5718g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f5719a;

    /* renamed from: b, reason: collision with root package name */
    private final l3.k f5720b;

    /* renamed from: c, reason: collision with root package name */
    private final long f5721c;

    /* renamed from: d, reason: collision with root package name */
    private final p3.c f5722d;

    /* renamed from: e, reason: collision with root package name */
    private final b f5723e;

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentLinkedQueue<i> f5724f;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends p3.a {
        b(String str) {
            super(str, false, 2, null);
        }

        @Override // p3.a
        public long f() {
            return j.this.b(System.nanoTime());
        }
    }

    public j(p3.d dVar, int i4, long j4, TimeUnit timeUnit, l3.k kVar) {
        e3.f.e(dVar, "taskRunner");
        e3.f.e(timeUnit, "timeUnit");
        e3.f.e(kVar, "connectionListener");
        this.f5719a = i4;
        this.f5720b = kVar;
        this.f5721c = timeUnit.toNanos(j4);
        this.f5722d = dVar.k();
        this.f5723e = new b(s.f5214f + " ConnectionPool");
        this.f5724f = new ConcurrentLinkedQueue<>();
        if (j4 > 0) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j4).toString());
    }

    private final int e(i iVar, long j4) {
        if (s.f5213e && !Thread.holdsLock(iVar)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + iVar);
        }
        List<Reference<h>> f4 = iVar.f();
        int i4 = 0;
        while (i4 < f4.size()) {
            Reference<h> reference = f4.get(i4);
            if (reference.get() != null) {
                i4++;
            } else {
                e3.f.c(reference, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
                w3.h.f6456a.g().l("A connection to " + iVar.t().a().l() + " was leaked. Did you forget to close a response body?", ((h.b) reference).a());
                f4.remove(i4);
                if (f4.isEmpty()) {
                    iVar.v(j4 - this.f5721c);
                    return 0;
                }
            }
        }
        return f4.size();
    }

    public final i a(boolean z4, l3.a aVar, h hVar, List<e0> list, boolean z5) {
        boolean z6;
        boolean z7;
        Socket y4;
        e3.f.e(aVar, "address");
        e3.f.e(hVar, "call");
        Iterator<i> it = this.f5724f.iterator();
        while (it.hasNext()) {
            i next = it.next();
            e3.f.b(next);
            synchronized (next) {
                if (z5) {
                    if (!next.q()) {
                        z6 = false;
                    }
                }
                if (next.o(aVar, list)) {
                    hVar.c(next);
                    z6 = true;
                }
                z6 = false;
            }
            if (z6) {
                if (next.p(z4)) {
                    return next;
                }
                synchronized (next) {
                    z7 = next.k() ? false : true;
                    next.w(true);
                    y4 = hVar.y();
                }
                if (y4 != null) {
                    s.f(y4);
                    this.f5720b.f(next);
                } else if (z7) {
                    this.f5720b.h(next);
                }
            }
        }
        return null;
    }

    public final long b(long j4) {
        Iterator<i> it = this.f5724f.iterator();
        int i4 = 0;
        long j5 = Long.MIN_VALUE;
        i iVar = null;
        int i5 = 0;
        while (it.hasNext()) {
            i next = it.next();
            e3.f.b(next);
            synchronized (next) {
                if (e(next, j4) > 0) {
                    i5++;
                } else {
                    i4++;
                    long j6 = j4 - next.j();
                    if (j6 > j5) {
                        iVar = next;
                        j5 = j6;
                    }
                    u2.l lVar = u2.l.f6223a;
                }
            }
        }
        long j7 = this.f5721c;
        if (j5 < j7 && i4 <= this.f5719a) {
            if (i4 > 0) {
                return j7 - j5;
            }
            if (i5 > 0) {
                return j7;
            }
            return -1L;
        }
        e3.f.b(iVar);
        synchronized (iVar) {
            if (!iVar.f().isEmpty()) {
                return 0L;
            }
            if (iVar.j() + j5 != j4) {
                return 0L;
            }
            iVar.w(true);
            this.f5724f.remove(iVar);
            s.f(iVar.x());
            this.f5720b.f(iVar);
            if (this.f5724f.isEmpty()) {
                this.f5722d.a();
            }
            return 0L;
        }
    }

    public final boolean c(i iVar) {
        e3.f.e(iVar, "connection");
        if (s.f5213e && !Thread.holdsLock(iVar)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + iVar);
        }
        if (!iVar.k() && this.f5719a != 0) {
            p3.c.m(this.f5722d, this.f5723e, 0L, 2, null);
            return false;
        }
        iVar.w(true);
        this.f5724f.remove(iVar);
        if (!this.f5724f.isEmpty()) {
            return true;
        }
        this.f5722d.a();
        return true;
    }

    public final l3.k d() {
        return this.f5720b;
    }

    public final void f(i iVar) {
        e3.f.e(iVar, "connection");
        if (!s.f5213e || Thread.holdsLock(iVar)) {
            this.f5724f.add(iVar);
            p3.c.m(this.f5722d, this.f5723e, 0L, 2, null);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + iVar);
    }
}
