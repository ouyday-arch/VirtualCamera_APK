package s3;

import b4.f;
import e3.d;
import l3.u;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0077a f5888c = new C0077a(null);

    /* renamed from: a, reason: collision with root package name */
    private final f f5889a;

    /* renamed from: b, reason: collision with root package name */
    private long f5890b;

    /* renamed from: s3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0077a {
        private C0077a() {
        }

        public /* synthetic */ C0077a(d dVar) {
            this();
        }
    }

    public a(f fVar) {
        e3.f.e(fVar, "source");
        this.f5889a = fVar;
        this.f5890b = 262144L;
    }

    public final u a() {
        u.a aVar = new u.a();
        while (true) {
            String b5 = b();
            if (b5.length() == 0) {
                return aVar.d();
            }
            aVar.b(b5);
        }
    }

    public final String b() {
        String n4 = this.f5889a.n(this.f5890b);
        this.f5890b -= n4.length();
        return n4;
    }
}
