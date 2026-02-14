package t3;

import java.util.List;

/* loaded from: classes.dex */
public interface m {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6199a = a.f6201a;

    /* renamed from: b, reason: collision with root package name */
    public static final m f6200b = new a.C0081a();

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f6201a = new a();

        /* renamed from: t3.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static final class C0081a implements m {
            @Override // t3.m
            public boolean a(int i4, List<d> list) {
                e3.f.e(list, "requestHeaders");
                return true;
            }

            @Override // t3.m
            public boolean b(int i4, List<d> list, boolean z4) {
                e3.f.e(list, "responseHeaders");
                return true;
            }

            @Override // t3.m
            public void c(int i4, b bVar) {
                e3.f.e(bVar, "errorCode");
            }

            @Override // t3.m
            public boolean d(int i4, b4.f fVar, int i5, boolean z4) {
                e3.f.e(fVar, "source");
                fVar.o(i5);
                return true;
            }
        }

        private a() {
        }
    }

    boolean a(int i4, List<d> list);

    boolean b(int i4, List<d> list, boolean z4);

    void c(int i4, b bVar);

    boolean d(int i4, b4.f fVar, int i5, boolean z4);
}
