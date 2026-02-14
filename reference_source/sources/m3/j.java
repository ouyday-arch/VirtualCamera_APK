package m3;

import j3.u;
import java.util.ArrayList;
import java.util.Locale;
import l3.x;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final j3.j f5192a = new j3.j("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b, reason: collision with root package name */
    private static final j3.j f5193b = new j3.j(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final boolean a(x xVar, Object obj) {
        e3.f.e(xVar, "<this>");
        return (obj instanceof x) && e3.f.a(((x) obj).c(), xVar.c());
    }

    public static final int b(x xVar) {
        e3.f.e(xVar, "<this>");
        return xVar.c().hashCode();
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0024 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String c(l3.x r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "<this>"
            e3.f.e(r4, r0)
            java.lang.String r0 = "name"
            e3.f.e(r5, r0)
            java.lang.String[] r0 = r4.d()
            int r0 = r0.length
            int r0 = r0 + (-1)
            r1 = 0
            r2 = 2
            int r0 = z2.c.c(r1, r0, r2)
            if (r0 < 0) goto L33
        L19:
            java.lang.String[] r2 = r4.d()
            r2 = r2[r1]
            r3 = 1
            boolean r2 = j3.l.l(r2, r5, r3)
            if (r2 == 0) goto L2e
            java.lang.String[] r4 = r4.d()
            int r1 = r1 + r3
            r4 = r4[r1]
            return r4
        L2e:
            if (r1 == r0) goto L33
            int r1 = r1 + 2
            goto L19
        L33:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.j.c(l3.x, java.lang.String):java.lang.String");
    }

    public static final x d(String str) {
        boolean x4;
        boolean k4;
        e3.f.e(str, "<this>");
        j3.h z4 = p.z(f5192a, str, 0);
        if (z4 == null) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String str2 = z4.a().get(1);
        Locale locale = Locale.ROOT;
        String lowerCase = str2.toLowerCase(locale);
        e3.f.d(lowerCase, "toLowerCase(...)");
        String lowerCase2 = z4.a().get(2).toLowerCase(locale);
        e3.f.d(lowerCase2, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        g3.f c5 = z4.c();
        while (true) {
            int b5 = c5.b() + 1;
            if (b5 >= str.length()) {
                return new x(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
            }
            j3.h z5 = p.z(f5193b, str, b5);
            if (!(z5 != null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Parameter is not formatted correctly: \"");
                String substring = str.substring(b5);
                e3.f.d(substring, "substring(...)");
                sb.append(substring);
                sb.append("\" for: \"");
                sb.append(str);
                sb.append('\"');
                throw new IllegalArgumentException(sb.toString().toString());
            }
            j3.f fVar = z5.b().get(1);
            String a5 = fVar != null ? fVar.a() : null;
            if (a5 != null) {
                j3.f fVar2 = z5.b().get(2);
                String a6 = fVar2 != null ? fVar2.a() : null;
                if (a6 == null) {
                    j3.f fVar3 = z5.b().get(3);
                    e3.f.b(fVar3);
                    a6 = fVar3.a();
                } else {
                    x4 = u.x(a6, "'", false, 2, null);
                    if (x4) {
                        k4 = u.k(a6, "'", false, 2, null);
                        if (k4 && a6.length() > 2) {
                            a6 = a6.substring(1, a6.length() - 1);
                            e3.f.d(a6, "substring(...)");
                        }
                    }
                }
                arrayList.add(a5);
                arrayList.add(a6);
            }
            c5 = z5.c();
        }
    }

    public static final x e(String str) {
        e3.f.e(str, "<this>");
        try {
            return d(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final String f(x xVar) {
        e3.f.e(xVar, "<this>");
        return xVar.c();
    }
}
