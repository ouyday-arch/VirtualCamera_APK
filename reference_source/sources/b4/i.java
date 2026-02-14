package b4;

import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2354a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f2355b;

    /* renamed from: c, reason: collision with root package name */
    private final y f2356c;

    /* renamed from: d, reason: collision with root package name */
    private final Long f2357d;

    /* renamed from: e, reason: collision with root package name */
    private final Long f2358e;

    /* renamed from: f, reason: collision with root package name */
    private final Long f2359f;

    /* renamed from: g, reason: collision with root package name */
    private final Long f2360g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<h3.a<?>, Object> f2361h;

    public i(boolean z4, boolean z5, y yVar, Long l4, Long l5, Long l6, Long l7, Map<h3.a<?>, ? extends Object> map) {
        Map<h3.a<?>, Object> f4;
        e3.f.e(map, "extras");
        this.f2354a = z4;
        this.f2355b = z5;
        this.f2356c = yVar;
        this.f2357d = l4;
        this.f2358e = l5;
        this.f2359f = l6;
        this.f2360g = l7;
        f4 = v2.g0.f(map);
        this.f2361h = f4;
    }

    public /* synthetic */ i(boolean z4, boolean z5, y yVar, Long l4, Long l5, Long l6, Long l7, Map map, int i4, e3.d dVar) {
        this((i4 & 1) != 0 ? false : z4, (i4 & 2) == 0 ? z5 : false, (i4 & 4) != 0 ? null : yVar, (i4 & 8) != 0 ? null : l4, (i4 & 16) != 0 ? null : l5, (i4 & 32) != 0 ? null : l6, (i4 & 64) == 0 ? l7 : null, (i4 & 128) != 0 ? v2.g0.c() : map);
    }

    public final Long a() {
        return this.f2359f;
    }

    public final Long b() {
        return this.f2357d;
    }

    public final boolean c() {
        return this.f2355b;
    }

    public final boolean d() {
        return this.f2354a;
    }

    public String toString() {
        String E;
        ArrayList arrayList = new ArrayList();
        if (this.f2354a) {
            arrayList.add("isRegularFile");
        }
        if (this.f2355b) {
            arrayList.add("isDirectory");
        }
        if (this.f2357d != null) {
            arrayList.add("byteCount=" + this.f2357d);
        }
        if (this.f2358e != null) {
            arrayList.add("createdAt=" + this.f2358e);
        }
        if (this.f2359f != null) {
            arrayList.add("lastModifiedAt=" + this.f2359f);
        }
        if (this.f2360g != null) {
            arrayList.add("lastAccessedAt=" + this.f2360g);
        }
        if (!this.f2361h.isEmpty()) {
            arrayList.add("extras=" + this.f2361h);
        }
        E = v2.w.E(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
        return E;
    }
}
