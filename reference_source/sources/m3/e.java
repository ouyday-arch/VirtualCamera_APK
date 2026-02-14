package m3;

import b4.g0;
import b4.h0;
import b4.t;
import l3.d0;
import l3.x;

/* loaded from: classes.dex */
public final class e extends d0 implements g0 {

    /* renamed from: c, reason: collision with root package name */
    private final x f5189c;

    /* renamed from: d, reason: collision with root package name */
    private final long f5190d;

    public e(x xVar, long j4) {
        this.f5189c = xVar;
        this.f5190d = j4;
    }

    @Override // l3.d0
    public long J() {
        return this.f5190d;
    }

    @Override // l3.d0
    public x K() {
        return this.f5189c;
    }

    @Override // l3.d0
    public b4.f L() {
        return t.b(this);
    }

    @Override // b4.g0
    public h0 b() {
        return h0.f2350e;
    }

    @Override // l3.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // b4.g0
    public long u(b4.d dVar, long j4) {
        e3.f.e(dVar, "sink");
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }
}
