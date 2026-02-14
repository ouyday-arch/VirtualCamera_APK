package g3;

import java.util.NoSuchElementException;
import v2.c0;

/* loaded from: classes.dex */
public final class h extends c0 {

    /* renamed from: b, reason: collision with root package name */
    private final long f4058b;

    /* renamed from: c, reason: collision with root package name */
    private final long f4059c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4060d;

    /* renamed from: e, reason: collision with root package name */
    private long f4061e;

    public h(long j4, long j5, long j6) {
        this.f4058b = j6;
        this.f4059c = j5;
        boolean z4 = true;
        if (j6 <= 0 ? j4 < j5 : j4 > j5) {
            z4 = false;
        }
        this.f4060d = z4;
        this.f4061e = z4 ? j4 : j5;
    }

    @Override // v2.c0
    public long a() {
        long j4 = this.f4061e;
        if (j4 != this.f4059c) {
            this.f4061e = this.f4058b + j4;
        } else {
            if (!this.f4060d) {
                throw new NoSuchElementException();
            }
            this.f4060d = false;
        }
        return j4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f4060d;
    }
}
