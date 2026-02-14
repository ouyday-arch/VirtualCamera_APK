package e3;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final m f3631a;

    /* renamed from: b, reason: collision with root package name */
    private static final h3.a[] f3632b;

    static {
        m mVar = null;
        try {
            mVar = (m) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (mVar == null) {
            mVar = new m();
        }
        f3631a = mVar;
        f3632b = new h3.a[0];
    }

    public static String a(g gVar) {
        return f3631a.b(gVar);
    }
}
