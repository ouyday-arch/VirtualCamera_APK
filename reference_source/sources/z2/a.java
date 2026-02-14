package z2;

import e3.f;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0100a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0100a f6689a = new C0100a();

        /* renamed from: b, reason: collision with root package name */
        public static final Method f6690b;

        /* renamed from: c, reason: collision with root package name */
        public static final Method f6691c;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003d A[LOOP:0: B:2:0x0013->B:10:0x003d, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0041 A[EDGE_INSN: B:11:0x0041->B:12:0x0041 BREAK  A[LOOP:0: B:2:0x0013->B:10:0x003d], SYNTHETIC] */
        static {
            /*
                z2.a$a r0 = new z2.a$a
                r0.<init>()
                z2.a.C0100a.f6689a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                e3.f.b(r1)
                int r2 = r1.length
                r3 = 0
                r4 = r3
            L13:
                r5 = 0
                if (r4 >= r2) goto L40
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = e3.f.a(r7, r8)
                if (r7 == 0) goto L39
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "getParameterTypes(...)"
                e3.f.d(r7, r8)
                java.lang.Object r7 = v2.f.u(r7)
                boolean r7 = e3.f.a(r7, r0)
                if (r7 == 0) goto L39
                r7 = 1
                goto L3a
            L39:
                r7 = r3
            L3a:
                if (r7 == 0) goto L3d
                goto L41
            L3d:
                int r4 = r4 + 1
                goto L13
            L40:
                r6 = r5
            L41:
                z2.a.C0100a.f6690b = r6
                int r0 = r1.length
            L44:
                if (r3 >= r0) goto L59
                r2 = r1[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = e3.f.a(r4, r6)
                if (r4 == 0) goto L56
                r5 = r2
                goto L59
            L56:
                int r3 = r3 + 1
                goto L44
            L59:
                z2.a.C0100a.f6691c = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z2.a.C0100a.<clinit>():void");
        }

        private C0100a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        f.e(th, "cause");
        f.e(th2, "exception");
        Method method = C0100a.f6690b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
