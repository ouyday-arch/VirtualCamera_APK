package l3;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final b f4737a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final k f4738b = new a();

    /* loaded from: classes.dex */
    public static final class a extends k {
        a() {
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }

        public final k a() {
            return k.f4738b;
        }
    }

    public void b(j jVar, e0 e0Var, e eVar) {
        e3.f.e(jVar, "connection");
        e3.f.e(e0Var, "route");
        e3.f.e(eVar, "call");
    }

    public void c(e0 e0Var, e eVar, IOException iOException) {
        e3.f.e(e0Var, "route");
        e3.f.e(eVar, "call");
        e3.f.e(iOException, "failure");
    }

    public void d(e0 e0Var, e eVar) {
        e3.f.e(e0Var, "route");
        e3.f.e(eVar, "call");
    }

    public void e(j jVar, e eVar) {
        e3.f.e(jVar, "connection");
        e3.f.e(eVar, "call");
    }

    public void f(j jVar) {
        e3.f.e(jVar, "connection");
    }

    public void g(j jVar, e eVar) {
        e3.f.e(jVar, "connection");
        e3.f.e(eVar, "call");
    }

    public void h(j jVar) {
        e3.f.e(jVar, "connection");
    }
}
