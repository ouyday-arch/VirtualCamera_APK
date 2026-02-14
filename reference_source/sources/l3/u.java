package l3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class u implements Iterable<u2.g<? extends String, ? extends String>>, f3.a {

    /* renamed from: c, reason: collision with root package name */
    public static final b f4793c = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private final String[] f4794b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f4795a = new ArrayList(20);

        public final a a(String str, String str2) {
            e3.f.e(str, "name");
            e3.f.e(str2, "value");
            return m3.h.b(this, str, str2);
        }

        public final a b(String str) {
            int M;
            e3.f.e(str, "line");
            M = j3.v.M(str, ':', 1, false, 4, null);
            if (M != -1) {
                String substring = str.substring(0, M);
                e3.f.d(substring, "substring(...)");
                String substring2 = str.substring(M + 1);
                e3.f.d(substring2, "substring(...)");
                c(substring, substring2);
            } else {
                if (str.charAt(0) == ':') {
                    str = str.substring(1);
                    e3.f.d(str, "substring(...)");
                }
                c("", str);
            }
            return this;
        }

        public final a c(String str, String str2) {
            e3.f.e(str, "name");
            e3.f.e(str2, "value");
            return m3.h.c(this, str, str2);
        }

        public final u d() {
            return m3.h.d(this);
        }

        public final List<String> e() {
            return this.f4795a;
        }

        public final a f(String str) {
            e3.f.e(str, "name");
            return m3.h.l(this, str);
        }

        public final a g(String str, String str2) {
            e3.f.e(str, "name");
            e3.f.e(str2, "value");
            return m3.h.m(this, str, str2);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e3.d dVar) {
            this();
        }

        public final u a(String... strArr) {
            e3.f.e(strArr, "namesAndValues");
            return m3.h.h((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    public u(String[] strArr) {
        e3.f.e(strArr, "namesAndValues");
        this.f4794b = strArr;
    }

    public final String a(String str) {
        e3.f.e(str, "name");
        return m3.h.g(this.f4794b, str);
    }

    public final String[] b() {
        return this.f4794b;
    }

    public final String c(int i4) {
        return m3.h.j(this, i4);
    }

    public final a d() {
        return m3.h.k(this);
    }

    public final String e(int i4) {
        return m3.h.o(this, i4);
    }

    public boolean equals(Object obj) {
        return m3.h.e(this, obj);
    }

    public final List<String> f(String str) {
        e3.f.e(str, "name");
        return m3.h.p(this, str);
    }

    public int hashCode() {
        return m3.h.f(this);
    }

    @Override // java.lang.Iterable
    public Iterator<u2.g<? extends String, ? extends String>> iterator() {
        return m3.h.i(this);
    }

    public final int size() {
        return this.f4794b.length / 2;
    }

    public String toString() {
        return m3.h.n(this);
    }
}
