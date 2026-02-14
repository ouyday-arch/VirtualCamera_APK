package c4;

import b4.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final y f2474a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f2475b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2476c;

    /* renamed from: d, reason: collision with root package name */
    private final long f2477d;

    /* renamed from: e, reason: collision with root package name */
    private final long f2478e;

    /* renamed from: f, reason: collision with root package name */
    private final long f2479f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2480g;

    /* renamed from: h, reason: collision with root package name */
    private final Long f2481h;

    /* renamed from: i, reason: collision with root package name */
    private final long f2482i;

    /* renamed from: j, reason: collision with root package name */
    private final List<y> f2483j;

    public h(y yVar, boolean z4, String str, long j4, long j5, long j6, int i4, Long l4, long j7) {
        e3.f.e(yVar, "canonicalPath");
        e3.f.e(str, "comment");
        this.f2474a = yVar;
        this.f2475b = z4;
        this.f2476c = str;
        this.f2477d = j4;
        this.f2478e = j5;
        this.f2479f = j6;
        this.f2480g = i4;
        this.f2481h = l4;
        this.f2482i = j7;
        this.f2483j = new ArrayList();
    }

    public /* synthetic */ h(y yVar, boolean z4, String str, long j4, long j5, long j6, int i4, Long l4, long j7, int i5, e3.d dVar) {
        this(yVar, (i5 & 2) != 0 ? false : z4, (i5 & 4) != 0 ? "" : str, (i5 & 8) != 0 ? -1L : j4, (i5 & 16) != 0 ? -1L : j5, (i5 & 32) != 0 ? -1L : j6, (i5 & 64) != 0 ? -1 : i4, (i5 & 128) != 0 ? null : l4, (i5 & 256) == 0 ? j7 : -1L);
    }

    public final y a() {
        return this.f2474a;
    }

    public final List<y> b() {
        return this.f2483j;
    }

    public final long c() {
        return this.f2478e;
    }

    public final int d() {
        return this.f2480g;
    }

    public final long e() {
        return this.f2482i;
    }

    public final long f() {
        return this.f2479f;
    }
}
