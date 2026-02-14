package q3;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import m3.s;
import q3.n;

/* loaded from: classes.dex */
public final class f implements d {

    /* renamed from: a, reason: collision with root package name */
    private final n f5666a;

    /* renamed from: b, reason: collision with root package name */
    private final p3.d f5667b;

    /* renamed from: c, reason: collision with root package name */
    private final long f5668c;

    /* renamed from: d, reason: collision with root package name */
    private long f5669d;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<n.b> f5670e;

    /* renamed from: f, reason: collision with root package name */
    private final BlockingQueue<n.a> f5671f;

    /* loaded from: classes.dex */
    public static final class a extends p3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n.b f5672e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f5673f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, n.b bVar, f fVar) {
            super(str, false, 2, null);
            this.f5672e = bVar;
            this.f5673f = fVar;
        }

        @Override // p3.a
        public long f() {
            n.a aVar;
            try {
                aVar = this.f5672e.d();
            } catch (Throwable th) {
                aVar = new n.a(this.f5672e, null, th, 2, null);
            }
            if (!this.f5673f.f5670e.contains(this.f5672e)) {
                return -1L;
            }
            this.f5673f.f5671f.put(aVar);
            return -1L;
        }
    }

    public f(n nVar, p3.d dVar) {
        e3.f.e(nVar, "routePlanner");
        e3.f.e(dVar, "taskRunner");
        this.f5666a = nVar;
        this.f5667b = dVar;
        this.f5668c = TimeUnit.MILLISECONDS.toNanos(250L);
        this.f5669d = Long.MIN_VALUE;
        this.f5670e = new CopyOnWriteArrayList<>();
        this.f5671f = dVar.f().d(new LinkedBlockingDeque());
    }

    private final n.a e(long j4, TimeUnit timeUnit) {
        n.a poll;
        if (this.f5670e.isEmpty() || (poll = this.f5671f.poll(j4, timeUnit)) == null) {
            return null;
        }
        this.f5670e.remove(poll.d());
        return poll;
    }

    private final void f() {
        Iterator<n.b> it = this.f5670e.iterator();
        while (it.hasNext()) {
            n.b next = it.next();
            next.cancel();
            n.b a5 = next.a();
            if (a5 != null) {
                b().a().d(a5);
            }
        }
        this.f5670e.clear();
    }

    private final n.a g() {
        n.b eVar;
        if (n.d(b(), null, 1, null)) {
            try {
                eVar = b().b();
            } catch (Throwable th) {
                eVar = new e(th);
            }
            if (eVar.b()) {
                return new n.a(eVar, null, null, 6, null);
            }
            if (eVar instanceof e) {
                return ((e) eVar).g();
            }
            this.f5670e.add(eVar);
            p3.c.m(this.f5667b.k(), new a(s.f5214f + " connect " + b().e().l().q(), eVar, this), 0L, 2, null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0061 A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:3:0x0002, B:5:0x000c, B:11:0x001e, B:13:0x0028, B:20:0x0052, B:23:0x005b, B:25:0x0061, B:27:0x006e, B:28:0x0077, B:31:0x007d, B:34:0x0089, B:36:0x008f, B:39:0x0095, B:40:0x0099, B:42:0x009d, B:43:0x009e, B:46:0x00a4, B:54:0x0047, B:56:0x00b1, B:57:0x00b8), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008f A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:3:0x0002, B:5:0x000c, B:11:0x001e, B:13:0x0028, B:20:0x0052, B:23:0x005b, B:25:0x0061, B:27:0x006e, B:28:0x0077, B:31:0x007d, B:34:0x0089, B:36:0x008f, B:39:0x0095, B:40:0x0099, B:42:0x009d, B:43:0x009e, B:46:0x00a4, B:54:0x0047, B:56:0x00b1, B:57:0x00b8), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0002 A[SYNTHETIC] */
    @Override // q3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q3.i a() {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
        L2:
            java.util.concurrent.CopyOnWriteArrayList<q3.n$b> r2 = r8.f5670e     // Catch: java.lang.Throwable -> Lb9
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> Lb9
            r3 = 1
            r2 = r2 ^ r3
            if (r2 != 0) goto L1e
            q3.n r2 = r8.b()     // Catch: java.lang.Throwable -> Lb9
            boolean r2 = q3.n.d(r2, r0, r3, r0)     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto L17
            goto L1e
        L17:
            r8.f()
            e3.f.b(r1)
            throw r1
        L1e:
            q3.n r2 = r8.b()     // Catch: java.lang.Throwable -> Lb9
            boolean r2 = r2.g()     // Catch: java.lang.Throwable -> Lb9
            if (r2 != 0) goto Lb1
            p3.d r2 = r8.f5667b     // Catch: java.lang.Throwable -> Lb9
            p3.d$a r2 = r2.f()     // Catch: java.lang.Throwable -> Lb9
            long r2 = r2.e()     // Catch: java.lang.Throwable -> Lb9
            long r4 = r8.f5669d     // Catch: java.lang.Throwable -> Lb9
            long r4 = r4 - r2
            java.util.concurrent.CopyOnWriteArrayList<q3.n$b> r6 = r8.f5670e     // Catch: java.lang.Throwable -> Lb9
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Lb9
            if (r6 != 0) goto L47
            r6 = 0
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 > 0) goto L44
            goto L47
        L44:
            r5 = r4
            r4 = r0
            goto L50
        L47:
            q3.n$a r4 = r8.g()     // Catch: java.lang.Throwable -> Lb9
            long r5 = r8.f5668c     // Catch: java.lang.Throwable -> Lb9
            long r2 = r2 + r5
            r8.f5669d = r2     // Catch: java.lang.Throwable -> Lb9
        L50:
            if (r4 != 0) goto L5b
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> Lb9
            q3.n$a r4 = r8.e(r5, r2)     // Catch: java.lang.Throwable -> Lb9
            if (r4 != 0) goto L5b
            goto L2
        L5b:
            boolean r2 = r4.f()     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto L89
            r8.f()     // Catch: java.lang.Throwable -> Lb9
            q3.n$b r2 = r4.d()     // Catch: java.lang.Throwable -> Lb9
            boolean r2 = r2.b()     // Catch: java.lang.Throwable -> Lb9
            if (r2 != 0) goto L77
            q3.n$b r2 = r4.d()     // Catch: java.lang.Throwable -> Lb9
            q3.n$a r2 = r2.e()     // Catch: java.lang.Throwable -> Lb9
            r4 = r2
        L77:
            boolean r2 = r4.f()     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto L89
            q3.n$b r0 = r4.d()     // Catch: java.lang.Throwable -> Lb9
            q3.i r0 = r0.f()     // Catch: java.lang.Throwable -> Lb9
            r8.f()
            return r0
        L89:
            java.lang.Throwable r2 = r4.e()     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto L9e
            boolean r3 = r2 instanceof java.io.IOException     // Catch: java.lang.Throwable -> Lb9
            if (r3 == 0) goto L9d
            if (r1 != 0) goto L99
            java.io.IOException r2 = (java.io.IOException) r2     // Catch: java.lang.Throwable -> Lb9
            r1 = r2
            goto L9e
        L99:
            u2.a.a(r1, r2)     // Catch: java.lang.Throwable -> Lb9
            goto L9e
        L9d:
            throw r2     // Catch: java.lang.Throwable -> Lb9
        L9e:
            q3.n$b r2 = r4.c()     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto L2
            q3.n r3 = r8.b()     // Catch: java.lang.Throwable -> Lb9
            v2.e r3 = r3.a()     // Catch: java.lang.Throwable -> Lb9
            r3.c(r2)     // Catch: java.lang.Throwable -> Lb9
            goto L2
        Lb1:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lb9
            throw r0     // Catch: java.lang.Throwable -> Lb9
        Lb9:
            r0 = move-exception
            r8.f()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.f.a():q3.i");
    }

    @Override // q3.d
    public n b() {
        return this.f5666a;
    }
}
