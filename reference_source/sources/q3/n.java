package q3;

import l3.v;

/* loaded from: classes.dex */
public interface n {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final b f5739a;

        /* renamed from: b, reason: collision with root package name */
        private final b f5740b;

        /* renamed from: c, reason: collision with root package name */
        private final Throwable f5741c;

        public a(b bVar, b bVar2, Throwable th) {
            e3.f.e(bVar, "plan");
            this.f5739a = bVar;
            this.f5740b = bVar2;
            this.f5741c = th;
        }

        public /* synthetic */ a(b bVar, b bVar2, Throwable th, int i4, e3.d dVar) {
            this(bVar, (i4 & 2) != 0 ? null : bVar2, (i4 & 4) != 0 ? null : th);
        }

        public final b a() {
            return this.f5740b;
        }

        public final Throwable b() {
            return this.f5741c;
        }

        public final b c() {
            return this.f5740b;
        }

        public final b d() {
            return this.f5739a;
        }

        public final Throwable e() {
            return this.f5741c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return e3.f.a(this.f5739a, aVar.f5739a) && e3.f.a(this.f5740b, aVar.f5740b) && e3.f.a(this.f5741c, aVar.f5741c);
        }

        public final boolean f() {
            return this.f5740b == null && this.f5741c == null;
        }

        public int hashCode() {
            int hashCode = this.f5739a.hashCode() * 31;
            b bVar = this.f5740b;
            int hashCode2 = (hashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
            Throwable th = this.f5741c;
            return hashCode2 + (th != null ? th.hashCode() : 0);
        }

        public String toString() {
            return "ConnectResult(plan=" + this.f5739a + ", nextPlan=" + this.f5740b + ", throwable=" + this.f5741c + ')';
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        b a();

        boolean b();

        void cancel();

        a d();

        a e();

        i f();
    }

    static /* synthetic */ boolean d(n nVar, i iVar, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hasNext");
        }
        if ((i4 & 1) != 0) {
            iVar = null;
        }
        return nVar.f(iVar);
    }

    v2.e<b> a();

    b b();

    boolean c(v vVar);

    l3.a e();

    boolean f(i iVar);

    boolean g();
}
