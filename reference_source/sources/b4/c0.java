package b4;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final c0 f2320a = new c0();

    /* renamed from: b, reason: collision with root package name */
    private static final int f2321b = 65536;

    /* renamed from: c, reason: collision with root package name */
    private static final b0 f2322c = new b0(new byte[0], 0, 0, false, false);

    /* renamed from: d, reason: collision with root package name */
    private static final int f2323d;

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReference<b0>[] f2324e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f2323d = highestOneBit;
        AtomicReference<b0>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i4 = 0; i4 < highestOneBit; i4++) {
            atomicReferenceArr[i4] = new AtomicReference<>();
        }
        f2324e = atomicReferenceArr;
    }

    private c0() {
    }

    private final AtomicReference<b0> a() {
        return f2324e[(int) (Thread.currentThread().getId() & (f2323d - 1))];
    }

    public static final void b(b0 b0Var) {
        AtomicReference<b0> a5;
        b0 b0Var2;
        b0 andSet;
        e3.f.e(b0Var, "segment");
        if (!(b0Var.f2305f == null && b0Var.f2306g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (b0Var.f2303d || (andSet = (a5 = f2320a.a()).getAndSet((b0Var2 = f2322c))) == b0Var2) {
            return;
        }
        int i4 = andSet != null ? andSet.f2302c : 0;
        if (i4 >= f2321b) {
            a5.set(andSet);
            return;
        }
        b0Var.f2305f = andSet;
        b0Var.f2301b = 0;
        b0Var.f2302c = i4 + 8192;
        a5.set(b0Var);
    }

    public static final b0 c() {
        AtomicReference<b0> a5 = f2320a.a();
        b0 b0Var = f2322c;
        b0 andSet = a5.getAndSet(b0Var);
        if (andSet == b0Var) {
            return new b0();
        }
        if (andSet == null) {
            a5.set(null);
            return new b0();
        }
        a5.set(andSet.f2305f);
        andSet.f2305f = null;
        andSet.f2302c = 0;
        return andSet;
    }
}
