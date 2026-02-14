package l3;

import java.util.Map;
import l3.u;
import v2.g0;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final v f4567a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4568b;

    /* renamed from: c, reason: collision with root package name */
    private final u f4569c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f4570d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<h3.a<?>, Object> f4571e;

    /* renamed from: f, reason: collision with root package name */
    private d f4572f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private v f4573a;

        /* renamed from: b, reason: collision with root package name */
        private String f4574b;

        /* renamed from: c, reason: collision with root package name */
        private u.a f4575c;

        /* renamed from: d, reason: collision with root package name */
        private b0 f4576d;

        /* renamed from: e, reason: collision with root package name */
        private Map<h3.a<?>, ? extends Object> f4577e;

        public a() {
            Map<h3.a<?>, ? extends Object> c5;
            c5 = g0.c();
            this.f4577e = c5;
            this.f4574b = "GET";
            this.f4575c = new u.a();
        }

        public a(a0 a0Var) {
            Map<h3.a<?>, ? extends Object> c5;
            e3.f.e(a0Var, "request");
            c5 = g0.c();
            this.f4577e = c5;
            this.f4573a = a0Var.i();
            this.f4574b = a0Var.g();
            this.f4576d = a0Var.a();
            this.f4577e = a0Var.c().isEmpty() ? g0.c() : g0.g(a0Var.c());
            this.f4575c = a0Var.e().d();
        }

        public a a(String str, String str2) {
            e3.f.e(str, "name");
            e3.f.e(str2, "value");
            return m3.m.b(this, str, str2);
        }

        public a0 b() {
            return new a0(this);
        }

        public final b0 c() {
            return this.f4576d;
        }

        public final u.a d() {
            return this.f4575c;
        }

        public final String e() {
            return this.f4574b;
        }

        public final Map<h3.a<?>, Object> f() {
            return this.f4577e;
        }

        public final v g() {
            return this.f4573a;
        }

        public a h(String str, String str2) {
            e3.f.e(str, "name");
            e3.f.e(str2, "value");
            return m3.m.d(this, str, str2);
        }

        public a i(u uVar) {
            e3.f.e(uVar, "headers");
            return m3.m.e(this, uVar);
        }

        public a j(String str, b0 b0Var) {
            e3.f.e(str, "method");
            return m3.m.f(this, str, b0Var);
        }

        public a k(b0 b0Var) {
            e3.f.e(b0Var, "body");
            return m3.m.g(this, b0Var);
        }

        public a l(String str) {
            e3.f.e(str, "name");
            return m3.m.h(this, str);
        }

        public final void m(b0 b0Var) {
            this.f4576d = b0Var;
        }

        public final void n(u.a aVar) {
            e3.f.e(aVar, "<set-?>");
            this.f4575c = aVar;
        }

        public final void o(String str) {
            e3.f.e(str, "<set-?>");
            this.f4574b = str;
        }

        public a p(String str) {
            e3.f.e(str, "url");
            return q(v.f4796j.b(m3.m.a(str)));
        }

        public a q(v vVar) {
            e3.f.e(vVar, "url");
            this.f4573a = vVar;
            return this;
        }
    }

    public a0(a aVar) {
        Map<h3.a<?>, Object> f4;
        e3.f.e(aVar, "builder");
        v g4 = aVar.g();
        if (g4 == null) {
            throw new IllegalStateException("url == null".toString());
        }
        this.f4567a = g4;
        this.f4568b = aVar.e();
        this.f4569c = aVar.d().d();
        this.f4570d = aVar.c();
        f4 = g0.f(aVar.f());
        this.f4571e = f4;
    }

    public final b0 a() {
        return this.f4570d;
    }

    public final d b() {
        d dVar = this.f4572f;
        if (dVar != null) {
            return dVar;
        }
        d a5 = d.f4616n.a(this.f4569c);
        this.f4572f = a5;
        return a5;
    }

    public final Map<h3.a<?>, Object> c() {
        return this.f4571e;
    }

    public final String d(String str) {
        e3.f.e(str, "name");
        return m3.m.c(this, str);
    }

    public final u e() {
        return this.f4569c;
    }

    public final boolean f() {
        return this.f4567a.k();
    }

    public final String g() {
        return this.f4568b;
    }

    public final a h() {
        return new a(this);
    }

    public final v i() {
        return this.f4567a;
    }

    public String toString() {
        return m3.m.i(this);
    }
}
