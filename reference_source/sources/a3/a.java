package a3;

import e3.f;

/* loaded from: classes.dex */
public class a extends z2.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0001a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0001a f304a = new C0001a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f305b;

        /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
        static {
            /*
                a3.a$a r0 = new a3.a$a
                r0.<init>()
                a3.a.C0001a.f304a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L1f
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L1f
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L1f
                if (r2 == 0) goto L1f
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L1f
                goto L20
            L1f:
                r1 = r0
            L20:
                if (r1 == 0) goto L2e
                int r2 = r1.intValue()
                if (r2 <= 0) goto L2a
                r2 = 1
                goto L2b
            L2a:
                r2 = 0
            L2b:
                if (r2 == 0) goto L2e
                r0 = r1
            L2e:
                a3.a.C0001a.f305b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a3.a.C0001a.<clinit>():void");
        }

        private C0001a() {
        }
    }

    private final boolean b(int i4) {
        Integer num = C0001a.f305b;
        return num == null || num.intValue() >= i4;
    }

    @Override // z2.a
    public void a(Throwable th, Throwable th2) {
        f.e(th, "cause");
        f.e(th2, "exception");
        if (b(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
