package l3;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f4773a = new p();

    private p() {
    }

    public static final String a(String str, String str2) {
        e3.f.e(str, "username");
        e3.f.e(str2, "password");
        return c(str, str2, null, 4, null);
    }

    public static final String b(String str, String str2, Charset charset) {
        e3.f.e(str, "username");
        e3.f.e(str2, "password");
        e3.f.e(charset, "charset");
        return "Basic " + b4.g.f2337e.b(str + ':' + str2, charset).a();
    }

    public static /* synthetic */ String c(String str, String str2, Charset charset, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            charset = j3.d.f4254g;
        }
        return b(str, str2, charset);
    }
}
