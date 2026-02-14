package b4;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class h implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    private final boolean f2342b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2343c;

    /* renamed from: d, reason: collision with root package name */
    private int f2344d;

    /* renamed from: e, reason: collision with root package name */
    private final ReentrantLock f2345e = k0.b();

    /* loaded from: classes.dex */
    private static final class a implements g0 {

        /* renamed from: b, reason: collision with root package name */
        private final h f2346b;

        /* renamed from: c, reason: collision with root package name */
        private long f2347c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2348d;

        public a(h hVar, long j4) {
            e3.f.e(hVar, "fileHandle");
            this.f2346b = hVar;
            this.f2347c = j4;
        }

        @Override // b4.g0
        public h0 b() {
            return h0.f2350e;
        }

        @Override // b4.g0, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
            if (this.f2348d) {
                return;
            }
            this.f2348d = true;
            ReentrantLock L = this.f2346b.L();
            L.lock();
            try {
                h hVar = this.f2346b;
                hVar.f2344d--;
                if (this.f2346b.f2344d == 0 && this.f2346b.f2343c) {
                    u2.l lVar = u2.l.f6223a;
                    L.unlock();
                    this.f2346b.M();
                }
            } finally {
                L.unlock();
            }
        }

        @Override // b4.g0
        public long u(d dVar, long j4) {
            e3.f.e(dVar, "sink");
            if (!(!this.f2348d)) {
                throw new IllegalStateException("closed".toString());
            }
            long P = this.f2346b.P(this.f2347c, dVar, j4);
            if (P != -1) {
                this.f2347c += P;
            }
            return P;
        }
    }

    public h(boolean z4) {
        this.f2342b = z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long P(long j4, d dVar, long j5) {
        if (!(j5 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
        long j6 = j4 + j5;
        long j7 = j4;
        while (true) {
            if (j7 >= j6) {
                break;
            }
            b0 f02 = dVar.f0(1);
            int N = N(j7, f02.f2300a, f02.f2302c, (int) Math.min(j6 - j7, 8192 - r9));
            if (N == -1) {
                if (f02.f2301b == f02.f2302c) {
                    dVar.f2325b = f02.b();
                    c0.b(f02);
                }
                if (j4 == j7) {
                    return -1L;
                }
            } else {
                f02.f2302c += N;
                long j8 = N;
                j7 += j8;
                dVar.b0(dVar.c0() + j8);
            }
        }
        return j7 - j4;
    }

    public final ReentrantLock L() {
        return this.f2345e;
    }

    protected abstract void M();

    protected abstract int N(long j4, byte[] bArr, int i4, int i5);

    protected abstract long O();

    public final long Q() {
        ReentrantLock reentrantLock = this.f2345e;
        reentrantLock.lock();
        try {
            if (!(!this.f2343c)) {
                throw new IllegalStateException("closed".toString());
            }
            u2.l lVar = u2.l.f6223a;
            reentrantLock.unlock();
            return O();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final g0 R(long j4) {
        ReentrantLock reentrantLock = this.f2345e;
        reentrantLock.lock();
        try {
            if (!(!this.f2343c)) {
                throw new IllegalStateException("closed".toString());
            }
            this.f2344d++;
            reentrantLock.unlock();
            return new a(this, j4);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f2345e;
        reentrantLock.lock();
        try {
            if (this.f2343c) {
                return;
            }
            this.f2343c = true;
            if (this.f2344d != 0) {
                return;
            }
            u2.l lVar = u2.l.f6223a;
            reentrantLock.unlock();
            M();
        } finally {
            reentrantLock.unlock();
        }
    }
}
