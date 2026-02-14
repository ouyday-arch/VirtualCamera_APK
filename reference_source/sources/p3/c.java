package p3;

import e3.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import m3.s;
import u2.l;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final d f5479a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5480b;

    /* renamed from: c, reason: collision with root package name */
    private final ReentrantLock f5481c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5482d;

    /* renamed from: e, reason: collision with root package name */
    private p3.a f5483e;

    /* renamed from: f, reason: collision with root package name */
    private final List<p3.a> f5484f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5485g;

    /* loaded from: classes.dex */
    public static final class a extends p3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d3.a<l> f5486e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z4, d3.a<l> aVar) {
            super(str, z4);
            this.f5486e = aVar;
        }

        @Override // p3.a
        public long f() {
            this.f5486e.d();
            return -1L;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends p3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d3.a<Long> f5487e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, d3.a<Long> aVar) {
            super(str, false, 2, null);
            this.f5487e = aVar;
        }

        @Override // p3.a
        public long f() {
            return this.f5487e.d().longValue();
        }
    }

    public c(d dVar, String str) {
        f.e(dVar, "taskRunner");
        f.e(str, "name");
        this.f5479a = dVar;
        this.f5480b = str;
        this.f5481c = new ReentrantLock();
        this.f5484f = new ArrayList();
    }

    public static /* synthetic */ void d(c cVar, String str, long j4, boolean z4, d3.a aVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        long j5 = j4;
        if ((i4 & 4) != 0) {
            z4 = true;
        }
        cVar.c(str, j5, z4, aVar);
    }

    public static /* synthetic */ void m(c cVar, p3.a aVar, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        cVar.l(aVar, j4);
    }

    public final void a() {
        ReentrantLock reentrantLock = this.f5481c;
        if (s.f5213e && reentrantLock.isHeldByCurrentThread()) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + reentrantLock);
        }
        ReentrantLock h4 = this.f5479a.h();
        h4.lock();
        try {
            if (b()) {
                this.f5479a.j(this);
            }
            l lVar = l.f6223a;
        } finally {
            h4.unlock();
        }
    }

    public final boolean b() {
        p3.a aVar = this.f5483e;
        if (aVar != null) {
            f.b(aVar);
            if (aVar.a()) {
                this.f5485g = true;
            }
        }
        boolean z4 = false;
        for (int size = this.f5484f.size() - 1; -1 < size; size--) {
            if (this.f5484f.get(size).a()) {
                Logger i4 = this.f5479a.i();
                p3.a aVar2 = this.f5484f.get(size);
                if (i4.isLoggable(Level.FINE)) {
                    p3.b.c(i4, aVar2, this, "canceled");
                }
                this.f5484f.remove(size);
                z4 = true;
            }
        }
        return z4;
    }

    public final void c(String str, long j4, boolean z4, d3.a<l> aVar) {
        f.e(str, "name");
        f.e(aVar, "block");
        l(new a(str, z4, aVar), j4);
    }

    public final p3.a e() {
        return this.f5483e;
    }

    public final boolean f() {
        return this.f5485g;
    }

    public final List<p3.a> g() {
        return this.f5484f;
    }

    public final String h() {
        return this.f5480b;
    }

    public final boolean i() {
        return this.f5482d;
    }

    public final d j() {
        return this.f5479a;
    }

    public final void k(String str, long j4, d3.a<Long> aVar) {
        f.e(str, "name");
        f.e(aVar, "block");
        l(new b(str, aVar), j4);
    }

    public final void l(p3.a aVar, long j4) {
        f.e(aVar, "task");
        ReentrantLock h4 = this.f5479a.h();
        h4.lock();
        try {
            if (!this.f5482d) {
                if (n(aVar, j4, false)) {
                    this.f5479a.j(this);
                }
                l lVar = l.f6223a;
            } else if (aVar.a()) {
                Logger i4 = this.f5479a.i();
                if (i4.isLoggable(Level.FINE)) {
                    p3.b.c(i4, aVar, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Logger i5 = this.f5479a.i();
                if (i5.isLoggable(Level.FINE)) {
                    p3.b.c(i5, aVar, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        } finally {
            h4.unlock();
        }
    }

    public final boolean n(p3.a aVar, long j4, boolean z4) {
        StringBuilder sb;
        String str;
        f.e(aVar, "task");
        aVar.e(this);
        long e4 = this.f5479a.f().e();
        long j5 = e4 + j4;
        int indexOf = this.f5484f.indexOf(aVar);
        if (indexOf != -1) {
            if (aVar.c() <= j5) {
                Logger i4 = this.f5479a.i();
                if (i4.isLoggable(Level.FINE)) {
                    p3.b.c(i4, aVar, this, "already scheduled");
                }
                return false;
            }
            this.f5484f.remove(indexOf);
        }
        aVar.g(j5);
        Logger i5 = this.f5479a.i();
        if (i5.isLoggable(Level.FINE)) {
            if (z4) {
                sb = new StringBuilder();
                str = "run again after ";
            } else {
                sb = new StringBuilder();
                str = "scheduled after ";
            }
            sb.append(str);
            sb.append(p3.b.b(j5 - e4));
            p3.b.c(i5, aVar, this, sb.toString());
        }
        Iterator<p3.a> it = this.f5484f.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = -1;
                break;
            }
            if (it.next().c() - e4 > j4) {
                break;
            }
            i6++;
        }
        if (i6 == -1) {
            i6 = this.f5484f.size();
        }
        this.f5484f.add(i6, aVar);
        return i6 == 0;
    }

    public final void o(p3.a aVar) {
        this.f5483e = aVar;
    }

    public final void p(boolean z4) {
        this.f5485g = z4;
    }

    public final void q() {
        ReentrantLock reentrantLock = this.f5481c;
        if (s.f5213e && reentrantLock.isHeldByCurrentThread()) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + reentrantLock);
        }
        ReentrantLock h4 = this.f5479a.h();
        h4.lock();
        try {
            this.f5482d = true;
            if (b()) {
                this.f5479a.j(this);
            }
            l lVar = l.f6223a;
        } finally {
            h4.unlock();
        }
    }

    public String toString() {
        return this.f5480b;
    }
}
