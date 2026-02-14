package l3;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: e, reason: collision with root package name */
    public static final a f4814e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f4815a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4816b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4817c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f4818d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final x a(String str) {
            e3.f.e(str, "<this>");
            return m3.j.e(str);
        }
    }

    public x(String str, String str2, String str3, String[] strArr) {
        e3.f.e(str, "mediaType");
        e3.f.e(str2, "type");
        e3.f.e(str3, "subtype");
        e3.f.e(strArr, "parameterNamesAndValues");
        this.f4815a = str;
        this.f4816b = str2;
        this.f4817c = str3;
        this.f4818d = strArr;
    }

    public static /* synthetic */ Charset b(x xVar, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = null;
        }
        return xVar.a(charset);
    }

    public static final x f(String str) {
        return f4814e.a(str);
    }

    public final Charset a(Charset charset) {
        String e4 = e("charset");
        if (e4 == null) {
            return charset;
        }
        try {
            return Charset.forName(e4);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public final String c() {
        return this.f4815a;
    }

    public final String[] d() {
        return this.f4818d;
    }

    public final String e(String str) {
        e3.f.e(str, "name");
        return m3.j.c(this, str);
    }

    public boolean equals(Object obj) {
        return m3.j.a(this, obj);
    }

    public int hashCode() {
        return m3.j.b(this);
    }

    public String toString() {
        return m3.j.f(this);
    }
}
