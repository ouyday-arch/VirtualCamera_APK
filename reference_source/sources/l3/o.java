package l3;

import java.util.List;

/* loaded from: classes.dex */
public interface o {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4770a = a.f4772a;

    /* renamed from: b, reason: collision with root package name */
    public static final o f4771b = new a.C0057a();

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f4772a = new a();

        /* renamed from: l3.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static final class C0057a implements o {
            @Override // l3.o
            public List<n> a(v vVar) {
                List<n> i4;
                e3.f.e(vVar, "url");
                i4 = v2.o.i();
                return i4;
            }

            @Override // l3.o
            public void b(v vVar, List<n> list) {
                e3.f.e(vVar, "url");
                e3.f.e(list, "cookies");
            }
        }

        private a() {
        }
    }

    List<n> a(v vVar);

    void b(v vVar, List<n> list);
}
