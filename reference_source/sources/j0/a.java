package j0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private List<b> f4173a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f4174b;

    /* renamed from: j0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0049a {

        /* renamed from: a, reason: collision with root package name */
        private List<b> f4175a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private List<String> f4176b = new ArrayList();

        private List<String> c() {
            return this.f4176b;
        }

        private List<b> d() {
            return this.f4175a;
        }

        public C0049a a(String str) {
            this.f4175a.add(new b(str));
            return this;
        }

        public a b() {
            return new a(d(), c());
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private String f4177a;

        /* renamed from: b, reason: collision with root package name */
        private String f4178b;

        public b(String str) {
            this("*", str);
        }

        public b(String str, String str2) {
            this.f4177a = str;
            this.f4178b = str2;
        }

        public String a() {
            return this.f4177a;
        }

        public String b() {
            return this.f4178b;
        }
    }

    public a(List<b> list, List<String> list2) {
        this.f4173a = list;
        this.f4174b = list2;
    }

    public List<String> a() {
        return Collections.unmodifiableList(this.f4174b);
    }

    public List<b> b() {
        return Collections.unmodifiableList(this.f4173a);
    }
}
