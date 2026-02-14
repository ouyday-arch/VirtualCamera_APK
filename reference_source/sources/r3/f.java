package r3;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f5864a = new f();

    private f() {
    }

    public static final boolean a(String str) {
        e3.f.e(str, "method");
        return (e3.f.a(str, "GET") || e3.f.a(str, "HEAD")) ? false : true;
    }

    public static final boolean d(String str) {
        e3.f.e(str, "method");
        return e3.f.a(str, "POST") || e3.f.a(str, "PUT") || e3.f.a(str, "PATCH") || e3.f.a(str, "PROPPATCH") || e3.f.a(str, "REPORT");
    }

    public final boolean b(String str) {
        e3.f.e(str, "method");
        return !e3.f.a(str, "PROPFIND");
    }

    public final boolean c(String str) {
        e3.f.e(str, "method");
        return e3.f.a(str, "PROPFIND");
    }
}
