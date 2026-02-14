package t3;

import b4.g;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f6026d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final b4.g f6027e;

    /* renamed from: f, reason: collision with root package name */
    public static final b4.g f6028f;

    /* renamed from: g, reason: collision with root package name */
    public static final b4.g f6029g;

    /* renamed from: h, reason: collision with root package name */
    public static final b4.g f6030h;

    /* renamed from: i, reason: collision with root package name */
    public static final b4.g f6031i;

    /* renamed from: j, reason: collision with root package name */
    public static final b4.g f6032j;

    /* renamed from: a, reason: collision with root package name */
    public final b4.g f6033a;

    /* renamed from: b, reason: collision with root package name */
    public final b4.g f6034b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6035c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    static {
        g.a aVar = b4.g.f2337e;
        f6027e = aVar.c(":");
        f6028f = aVar.c(":status");
        f6029g = aVar.c(":method");
        f6030h = aVar.c(":path");
        f6031i = aVar.c(":scheme");
        f6032j = aVar.c(":authority");
    }

    public d(b4.g gVar, b4.g gVar2) {
        e3.f.e(gVar, "name");
        e3.f.e(gVar2, "value");
        this.f6033a = gVar;
        this.f6034b = gVar2;
        this.f6035c = gVar.y() + 32 + gVar2.y();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(b4.g gVar, String str) {
        this(gVar, b4.g.f2337e.c(str));
        e3.f.e(gVar, "name");
        e3.f.e(str, "value");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            e3.f.e(r2, r0)
            java.lang.String r0 = "value"
            e3.f.e(r3, r0)
            b4.g$a r0 = b4.g.f2337e
            b4.g r2 = r0.c(r2)
            b4.g r3 = r0.c(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.d.<init>(java.lang.String, java.lang.String):void");
    }

    public final b4.g a() {
        return this.f6033a;
    }

    public final b4.g b() {
        return this.f6034b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return e3.f.a(this.f6033a, dVar.f6033a) && e3.f.a(this.f6034b, dVar.f6034b);
    }

    public int hashCode() {
        return (this.f6033a.hashCode() * 31) + this.f6034b.hashCode();
    }

    public String toString() {
        return this.f6033a.D() + ": " + this.f6034b.D();
    }
}
