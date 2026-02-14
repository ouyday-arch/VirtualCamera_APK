package b4;

import b4.y;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2362a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final j f2363b;

    /* renamed from: c, reason: collision with root package name */
    public static final y f2364c;

    /* renamed from: d, reason: collision with root package name */
    public static final j f2365d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    static {
        j rVar;
        try {
            Class.forName("java.nio.file.Files");
            rVar = new s();
        } catch (ClassNotFoundException unused) {
            rVar = new r();
        }
        f2363b = rVar;
        y.a aVar = y.f2393c;
        String property = System.getProperty("java.io.tmpdir");
        e3.f.d(property, "getProperty(...)");
        f2364c = y.a.d(aVar, property, false, 1, null);
        ClassLoader classLoader = c4.g.class.getClassLoader();
        e3.f.d(classLoader, "getClassLoader(...)");
        f2365d = new c4.g(classLoader, false, null, 4, null);
    }

    public abstract h a(y yVar);

    public abstract g0 b(y yVar);
}
