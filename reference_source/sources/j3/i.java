package j3;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: a, reason: collision with root package name */
    private final Matcher f4269a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f4270b;

    /* renamed from: c, reason: collision with root package name */
    private final g f4271c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f4272d;

    /* loaded from: classes.dex */
    public static final class a extends v2.b<String> {
        a() {
        }

        @Override // v2.a
        public int a() {
            return i.this.e().groupCount() + 1;
        }

        public /* bridge */ boolean b(String str) {
            return super.contains(str);
        }

        @Override // v2.b, java.util.List
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String get(int i4) {
            String group = i.this.e().group(i4);
            return group == null ? "" : group;
        }

        @Override // v2.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        public /* bridge */ int d(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int e(String str) {
            return super.lastIndexOf(str);
        }

        @Override // v2.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return d((String) obj);
            }
            return -1;
        }

        @Override // v2.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return e((String) obj);
            }
            return -1;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends v2.a<f> implements g {

        /* loaded from: classes.dex */
        static final class a extends e3.g implements d3.b<Integer, f> {
            a() {
                super(1);
            }

            @Override // d3.b
            public /* bridge */ /* synthetic */ f b(Integer num) {
                return c(num.intValue());
            }

            public final f c(int i4) {
                return b.this.get(i4);
            }
        }

        b() {
        }

        @Override // v2.a
        public int a() {
            return i.this.e().groupCount() + 1;
        }

        public /* bridge */ boolean b(f fVar) {
            return super.contains(fVar);
        }

        @Override // v2.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof f) {
                return b((f) obj);
            }
            return false;
        }

        @Override // j3.g
        public f get(int i4) {
            g3.f f4;
            f4 = k.f(i.this.e(), i4);
            if (f4.h().intValue() < 0) {
                return null;
            }
            String group = i.this.e().group(i4);
            e3.f.d(group, "group(...)");
            return new f(group, f4);
        }

        @Override // v2.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            g3.f j4;
            i3.c x4;
            i3.c f4;
            j4 = v2.o.j(this);
            x4 = v2.w.x(j4);
            f4 = i3.i.f(x4, new a());
            return f4.iterator();
        }
    }

    public i(Matcher matcher, CharSequence charSequence) {
        e3.f.e(matcher, "matcher");
        e3.f.e(charSequence, "input");
        this.f4269a = matcher;
        this.f4270b = charSequence;
        this.f4271c = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult e() {
        return this.f4269a;
    }

    @Override // j3.h
    public List<String> a() {
        if (this.f4272d == null) {
            this.f4272d = new a();
        }
        List<String> list = this.f4272d;
        e3.f.b(list);
        return list;
    }

    @Override // j3.h
    public g b() {
        return this.f4271c;
    }

    @Override // j3.h
    public g3.f c() {
        g3.f e4;
        e4 = k.e(e());
        return e4;
    }
}
