package r3;

import l3.d0;
import l3.x;

/* loaded from: classes.dex */
public final class h extends d0 {

    /* renamed from: c, reason: collision with root package name */
    private final String f5874c;

    /* renamed from: d, reason: collision with root package name */
    private final long f5875d;

    /* renamed from: e, reason: collision with root package name */
    private final b4.f f5876e;

    public h(String str, long j4, b4.f fVar) {
        e3.f.e(fVar, "source");
        this.f5874c = str;
        this.f5875d = j4;
        this.f5876e = fVar;
    }

    @Override // l3.d0
    public long J() {
        return this.f5875d;
    }

    @Override // l3.d0
    public x K() {
        String str = this.f5874c;
        if (str != null) {
            return x.f4814e.a(str);
        }
        return null;
    }

    @Override // l3.d0
    public b4.f L() {
        return this.f5876e;
    }
}
