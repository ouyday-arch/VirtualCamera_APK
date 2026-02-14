package l3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: j, reason: collision with root package name */
    public static final b f4796j = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f4797a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4798b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4799c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4800d;

    /* renamed from: e, reason: collision with root package name */
    private final int f4801e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f4802f;

    /* renamed from: g, reason: collision with root package name */
    private final List<String> f4803g;

    /* renamed from: h, reason: collision with root package name */
    private final String f4804h;

    /* renamed from: i, reason: collision with root package name */
    private final String f4805i;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f4806a;

        /* renamed from: d, reason: collision with root package name */
        private String f4809d;

        /* renamed from: f, reason: collision with root package name */
        private final List<String> f4811f;

        /* renamed from: g, reason: collision with root package name */
        private List<String> f4812g;

        /* renamed from: h, reason: collision with root package name */
        private String f4813h;

        /* renamed from: b, reason: collision with root package name */
        private String f4807b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f4808c = "";

        /* renamed from: e, reason: collision with root package name */
        private int f4810e = -1;

        public a() {
            List<String> n4;
            n4 = v2.o.n("");
            this.f4811f = n4;
        }

        public final v a() {
            return m3.a.f5185a.a(this);
        }

        public final a b(String str) {
            return m3.a.f5185a.c(this, str);
        }

        public final String c() {
            return this.f4813h;
        }

        public final String d() {
            return this.f4808c;
        }

        public final List<String> e() {
            return this.f4811f;
        }

        public final List<String> f() {
            return this.f4812g;
        }

        public final String g() {
            return this.f4807b;
        }

        public final String h() {
            return this.f4809d;
        }

        public final int i() {
            return this.f4810e;
        }

        public final String j() {
            return this.f4806a;
        }

        public final a k(String str) {
            e3.f.e(str, "host");
            return m3.a.f5185a.f(this, str);
        }

        public final a l(v vVar, String str) {
            e3.f.e(str, "input");
            return m3.a.f5185a.i(this, vVar, str);
        }

        public final a m(String str) {
            e3.f.e(str, "password");
            return m3.a.f5185a.j(this, str);
        }

        public final a n(int i4) {
            return m3.a.f5185a.k(this, i4);
        }

        public final a o() {
            String str = this.f4809d;
            this.f4809d = str != null ? new j3.j("[\"<>^`{|}]").c(str, "") : null;
            int size = this.f4811f.size();
            for (int i4 = 0; i4 < size; i4++) {
                List<String> list = this.f4811f;
                list.set(i4, m3.b.b(m3.b.f5187a, list.get(i4), 0, 0, "[]", true, true, false, false, 99, null));
            }
            List<String> list2 = this.f4812g;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    String str2 = list2.get(i5);
                    list2.set(i5, str2 != null ? m3.b.b(m3.b.f5187a, str2, 0, 0, "\\^`{|}", true, true, true, false, 67, null) : null);
                }
            }
            String str3 = this.f4813h;
            this.f4813h = str3 != null ? m3.b.b(m3.b.f5187a, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, 35, null) : null;
            return this;
        }

        public final a p(String str) {
            e3.f.e(str, "scheme");
            return m3.a.f5185a.n(this, str);
        }

        public final void q(String str) {
            this.f4813h = str;
        }

        public final void r(String str) {
            e3.f.e(str, "<set-?>");
            this.f4808c = str;
        }

        public final void s(List<String> list) {
            this.f4812g = list;
        }

        public final void t(String str) {
            e3.f.e(str, "<set-?>");
            this.f4807b = str;
        }

        public String toString() {
            return m3.a.f5185a.q(this);
        }

        public final void u(String str) {
            this.f4809d = str;
        }

        public final void v(int i4) {
            this.f4810e = i4;
        }

        public final void w(String str) {
            this.f4806a = str;
        }

        public final a x(String str) {
            e3.f.e(str, "username");
            return m3.a.f5185a.r(this, str);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }

        public final int a(String str) {
            e3.f.e(str, "scheme");
            return m3.a.b(str);
        }

        public final v b(String str) {
            e3.f.e(str, "<this>");
            return m3.a.f5185a.o(str);
        }
    }

    public v(String str, String str2, String str3, String str4, int i4, List<String> list, List<String> list2, String str5, String str6) {
        e3.f.e(str, "scheme");
        e3.f.e(str2, "username");
        e3.f.e(str3, "password");
        e3.f.e(str4, "host");
        e3.f.e(list, "pathSegments");
        e3.f.e(str6, "url");
        this.f4797a = str;
        this.f4798b = str2;
        this.f4799c = str3;
        this.f4800d = str4;
        this.f4801e = i4;
        this.f4802f = list;
        this.f4803g = list2;
        this.f4804h = str5;
        this.f4805i = str6;
    }

    public final String a() {
        return m3.a.f5185a.t(this);
    }

    public final String b() {
        return m3.a.f5185a.u(this);
    }

    public final String c() {
        return m3.a.f5185a.v(this);
    }

    public final List<String> d() {
        return m3.a.f5185a.w(this);
    }

    public final String e() {
        return m3.a.f5185a.x(this);
    }

    public boolean equals(Object obj) {
        return m3.a.f5185a.d(this, obj);
    }

    public final String f() {
        return m3.a.f5185a.y(this);
    }

    public final String g() {
        return this.f4804h;
    }

    public final List<String> h() {
        return this.f4803g;
    }

    public int hashCode() {
        return m3.a.f5185a.e(this);
    }

    public final String i() {
        return this.f4805i;
    }

    public final String j() {
        return this.f4800d;
    }

    public final boolean k() {
        return e3.f.a(this.f4797a, "https");
    }

    public final a l() {
        return m3.a.f5185a.g(this);
    }

    public final a m(String str) {
        e3.f.e(str, "link");
        return m3.a.f5185a.h(this, str);
    }

    public final String n() {
        return this.f4799c;
    }

    public final int o() {
        return this.f4801e;
    }

    public final String p() {
        return m3.a.f5185a.z(this);
    }

    public final String q() {
        return m3.a.f5185a.l(this);
    }

    public final v r(String str) {
        e3.f.e(str, "link");
        return m3.a.f5185a.m(this, str);
    }

    public final String s() {
        return this.f4797a;
    }

    public final URI t() {
        String aVar = l().o().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e4) {
            try {
                URI create = URI.create(new j3.j("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").c(aVar, ""));
                e3.f.b(create);
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e4);
            }
        }
    }

    public String toString() {
        return m3.a.f5185a.p(this);
    }

    public final URL u() {
        try {
            return new URL(this.f4805i);
        } catch (MalformedURLException e4) {
            throw new RuntimeException(e4);
        }
    }

    public final String v() {
        return this.f4798b;
    }
}
