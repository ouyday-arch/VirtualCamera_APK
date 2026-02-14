package j3;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f4248a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f4249b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f4250c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f4251d;

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f4252e;

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f4253f;

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f4254g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile Charset f4255h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile Charset f4256i;

    static {
        Charset forName = Charset.forName("UTF-8");
        e3.f.d(forName, "forName(...)");
        f4249b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        e3.f.d(forName2, "forName(...)");
        f4250c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        e3.f.d(forName3, "forName(...)");
        f4251d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        e3.f.d(forName4, "forName(...)");
        f4252e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        e3.f.d(forName5, "forName(...)");
        f4253f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        e3.f.d(forName6, "forName(...)");
        f4254g = forName6;
    }

    private d() {
    }

    public final Charset a() {
        Charset charset = f4256i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        e3.f.d(forName, "forName(...)");
        f4256i = forName;
        return forName;
    }

    public final Charset b() {
        Charset charset = f4255h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        e3.f.d(forName, "forName(...)");
        f4255h = forName;
        return forName;
    }
}
