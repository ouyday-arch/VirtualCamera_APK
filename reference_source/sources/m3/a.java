package m3;

import j3.u;
import j3.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l3.v;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5185a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f5186b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private a() {
    }

    public static /* synthetic */ String G(a aVar, String str, int i4, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return aVar.F(str, i4, i5, z4);
    }

    public static final int b(String str) {
        e3.f.e(str, "scheme");
        if (e3.f.a(str, "http")) {
            return 80;
        }
        return e3.f.a(str, "https") ? 443 : -1;
    }

    public final char[] A() {
        return f5186b;
    }

    public final boolean B(v.a aVar, String str) {
        boolean l4;
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "input");
        if (e3.f.a(str, ".")) {
            return true;
        }
        l4 = u.l(str, "%2e", true);
        return l4;
    }

    public final boolean C(v.a aVar, String str) {
        boolean l4;
        boolean l5;
        boolean l6;
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "input");
        if (e3.f.a(str, "..")) {
            return true;
        }
        l4 = u.l(str, "%2e.", true);
        if (l4) {
            return true;
        }
        l5 = u.l(str, ".%2e", true);
        if (l5) {
            return true;
        }
        l6 = u.l(str, "%2e%2e", true);
        return l6;
    }

    public final boolean D(String str, int i4, int i5) {
        e3.f.e(str, "<this>");
        int i6 = i4 + 2;
        return i6 < i5 && str.charAt(i4) == '%' && p.A(str.charAt(i4 + 1)) != -1 && p.A(str.charAt(i6)) != -1;
    }

    public final int E(String str, int i4, int i5) {
        e3.f.e(str, "input");
        try {
            int parseInt = Integer.parseInt(b.b(b.f5187a, str, i4, i5, "", false, false, false, false, a.j.J0, null));
            boolean z4 = false;
            if (1 <= parseInt && parseInt < 65536) {
                z4 = true;
            }
            if (z4) {
                return parseInt;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final String F(String str, int i4, int i5, boolean z4) {
        e3.f.e(str, "<this>");
        for (int i6 = i4; i6 < i5; i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '%' || (charAt == '+' && z4)) {
                b4.d dVar = new b4.d();
                dVar.h(str, i4, i6);
                b.f5187a.c(dVar, str, i6, i5, z4);
                return dVar.Z();
            }
        }
        String substring = str.substring(i4, i5);
        e3.f.d(substring, "substring(...)");
        return substring;
    }

    public final void H(v.a aVar) {
        e3.f.e(aVar, "<this>");
        if ((aVar.e().remove(aVar.e().size() - 1).length() == 0) && (!aVar.e().isEmpty())) {
            aVar.e().set(aVar.e().size() - 1, "");
        } else {
            aVar.e().add("");
        }
    }

    public final int I(String str, int i4, int i5) {
        e3.f.e(str, "input");
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (charAt != '[') {
                if (charAt == ':') {
                    return i4;
                }
                i4++;
            }
            do {
                i4++;
                if (i4 < i5) {
                }
                i4++;
            } while (str.charAt(i4) != ']');
            i4++;
        }
        return i5;
    }

    public final void J(v.a aVar, String str, int i4, int i5, boolean z4, boolean z5) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "input");
        String b5 = b.b(b.f5187a, str, i4, i5, " \"<>^`{}|/\\?#", z5, false, false, false, 112, null);
        if (B(aVar, b5)) {
            return;
        }
        if (C(aVar, b5)) {
            H(aVar);
            return;
        }
        if (aVar.e().get(aVar.e().size() - 1).length() == 0) {
            aVar.e().set(aVar.e().size() - 1, b5);
        } else {
            aVar.e().add(b5);
        }
        if (z4) {
            aVar.e().add("");
        }
    }

    public final void K(v.a aVar, String str, int i4, int i5) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "input");
        if (i4 == i5) {
            return;
        }
        char charAt = str.charAt(i4);
        if (charAt == '/' || charAt == '\\') {
            aVar.e().clear();
            aVar.e().add("");
            i4++;
        } else {
            aVar.e().set(aVar.e().size() - 1, "");
        }
        while (true) {
            int i6 = i4;
            while (i6 < i5) {
                i4 = p.i(str, "/\\", i6, i5);
                boolean z4 = i4 < i5;
                J(aVar, str, i6, i4, z4, true);
                if (z4) {
                    i6 = i4 + 1;
                }
            }
            return;
        }
    }

    public final int L(String str, int i4, int i5) {
        e3.f.e(str, "input");
        if (i5 - i4 < 2) {
            return -1;
        }
        char charAt = str.charAt(i4);
        if ((e3.f.f(charAt, 97) >= 0 && e3.f.f(charAt, a.j.L0) <= 0) || (e3.f.f(charAt, 65) >= 0 && e3.f.f(charAt, 90) <= 0)) {
            for (int i6 = i4 + 1; i6 < i5; i6++) {
                char charAt2 = str.charAt(i6);
                if (!(((((('a' <= charAt2 && charAt2 < '{') || ('A' <= charAt2 && charAt2 < '[')) || ('0' <= charAt2 && charAt2 < ':')) || charAt2 == '+') || charAt2 == '-') || charAt2 == '.')) {
                    if (charAt2 == ':') {
                        return i6;
                    }
                    return -1;
                }
            }
        }
        return -1;
    }

    public final int M(String str, int i4, int i5) {
        e3.f.e(str, "<this>");
        int i6 = 0;
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (charAt != '\\' && charAt != '/') {
                break;
            }
            i6++;
            i4++;
        }
        return i6;
    }

    public final void N(List<String> list, StringBuilder sb) {
        e3.f.e(list, "<this>");
        e3.f.e(sb, "out");
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            sb.append('/');
            sb.append(list.get(i4));
        }
    }

    public final List<String> O(String str) {
        int M;
        int M2;
        String str2;
        e3.f.e(str, "<this>");
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 <= str.length()) {
            M = j3.v.M(str, '&', i4, false, 4, null);
            if (M == -1) {
                M = str.length();
            }
            int i5 = M;
            M2 = j3.v.M(str, '=', i4, false, 4, null);
            if (M2 == -1 || M2 > i5) {
                String substring = str.substring(i4, i5);
                e3.f.d(substring, "substring(...)");
                arrayList.add(substring);
                str2 = null;
            } else {
                String substring2 = str.substring(i4, M2);
                e3.f.d(substring2, "substring(...)");
                arrayList.add(substring2);
                str2 = str.substring(M2 + 1, i5);
                e3.f.d(str2, "substring(...)");
            }
            arrayList.add(str2);
            i4 = i5 + 1;
        }
        return arrayList;
    }

    public final void P(List<String> list, StringBuilder sb) {
        g3.f h4;
        g3.d g4;
        e3.f.e(list, "<this>");
        e3.f.e(sb, "out");
        h4 = g3.l.h(0, list.size());
        g4 = g3.l.g(h4, 2);
        int a5 = g4.a();
        int b5 = g4.b();
        int c5 = g4.c();
        if ((c5 <= 0 || a5 > b5) && (c5 >= 0 || b5 > a5)) {
            return;
        }
        while (true) {
            String str = list.get(a5);
            String str2 = list.get(a5 + 1);
            if (a5 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
            if (a5 == b5) {
                return;
            } else {
                a5 += c5;
            }
        }
    }

    public final v a(v.a aVar) {
        int r4;
        ArrayList arrayList;
        int r5;
        e3.f.e(aVar, "<this>");
        String j4 = aVar.j();
        if (j4 == null) {
            throw new IllegalStateException("scheme == null");
        }
        String G = G(this, aVar.g(), 0, 0, false, 7, null);
        String G2 = G(this, aVar.d(), 0, 0, false, 7, null);
        String h4 = aVar.h();
        if (h4 == null) {
            throw new IllegalStateException("host == null");
        }
        int s4 = s(aVar);
        List<String> e4 = aVar.e();
        r4 = v2.p.r(e4, 10);
        ArrayList arrayList2 = new ArrayList(r4);
        Iterator<T> it = e4.iterator();
        while (it.hasNext()) {
            arrayList2.add(G(f5185a, (String) it.next(), 0, 0, false, 7, null));
        }
        List<String> f4 = aVar.f();
        if (f4 != null) {
            r5 = v2.p.r(f4, 10);
            ArrayList arrayList3 = new ArrayList(r5);
            for (String str : f4) {
                arrayList3.add(str != null ? G(f5185a, str, 0, 0, true, 3, null) : null);
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        String c5 = aVar.c();
        return new v(j4, G, G2, h4, s4, arrayList2, arrayList, c5 != null ? G(this, c5, 0, 0, false, 7, null) : null, aVar.toString());
    }

    public final v.a c(v.a aVar, String str) {
        String b5;
        e3.f.e(aVar, "<this>");
        aVar.s((str == null || (b5 = b.b(b.f5187a, str, 0, 0, " \"'<>#", true, false, true, false, 83, null)) == null) ? null : f5185a.O(b5));
        return aVar;
    }

    public final boolean d(v vVar, Object obj) {
        e3.f.e(vVar, "<this>");
        return (obj instanceof v) && e3.f.a(((v) obj).i(), vVar.i());
    }

    public final int e(v vVar) {
        e3.f.e(vVar, "<this>");
        return vVar.i().hashCode();
    }

    public final v.a f(v.a aVar, String str) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "host");
        String k4 = i.k(G(f5185a, str, 0, 0, false, 7, null));
        if (k4 != null) {
            aVar.u(k4);
            return aVar;
        }
        throw new IllegalArgumentException("unexpected host: " + str);
    }

    public final v.a g(v vVar) {
        e3.f.e(vVar, "<this>");
        v.a aVar = new v.a();
        aVar.w(vVar.s());
        aVar.t(vVar.f());
        aVar.r(vVar.b());
        aVar.u(vVar.j());
        aVar.v(vVar.o() != b(vVar.s()) ? vVar.o() : -1);
        aVar.e().clear();
        aVar.e().addAll(vVar.d());
        aVar.b(vVar.e());
        aVar.q(vVar.a());
        return aVar;
    }

    public final v.a h(v vVar, String str) {
        e3.f.e(vVar, "<this>");
        e3.f.e(str, "link");
        try {
            return new v.a().l(vVar, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final v.a i(v.a aVar, v vVar, String str) {
        String str2;
        String p02;
        int i4;
        int i5;
        String str3;
        int i6;
        String str4;
        boolean z4;
        boolean z5;
        boolean z6;
        String str5;
        char c5;
        boolean u4;
        boolean u5;
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "input");
        int s4 = p.s(str, 0, 0, 3, null);
        int u6 = p.u(str, s4, 0, 2, null);
        int L = L(str, s4, u6);
        char c6 = 65535;
        boolean z7 = true;
        if (L != -1) {
            u4 = u.u(str, "https:", s4, true);
            if (u4) {
                aVar.w("https");
                s4 += 6;
            } else {
                u5 = u.u(str, "http:", s4, true);
                if (!u5) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected URL scheme 'http' or 'https' but was '");
                    String substring = str.substring(0, L);
                    e3.f.d(substring, "substring(...)");
                    sb.append(substring);
                    sb.append('\'');
                    throw new IllegalArgumentException(sb.toString());
                }
                aVar.w("http");
                s4 += 5;
            }
        } else {
            if (vVar == null) {
                if (str.length() > 6) {
                    StringBuilder sb2 = new StringBuilder();
                    p02 = x.p0(str, 6);
                    sb2.append(p02);
                    sb2.append("...");
                    str2 = sb2.toString();
                } else {
                    str2 = str;
                }
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + str2);
            }
            aVar.w(vVar.s());
        }
        int M = M(str, s4, u6);
        char c7 = '?';
        char c8 = '#';
        if (M >= 2 || vVar == null || !e3.f.a(vVar.s(), aVar.j())) {
            int i7 = s4 + M;
            boolean z8 = false;
            boolean z9 = false;
            while (true) {
                i4 = p.i(str, "@/\\?#", i7, u6);
                char charAt = i4 != u6 ? str.charAt(i4) : c6;
                if (charAt == c6 || charAt == c8 || charAt == '/' || charAt == '\\' || charAt == c7) {
                    break;
                }
                if (charAt == '@') {
                    if (z8) {
                        z5 = z7;
                        aVar.r(aVar.d() + "%40" + b.b(b.f5187a, str, i7, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null));
                    } else {
                        int h4 = p.h(str, ':', i7, i4);
                        b bVar = b.f5187a;
                        z5 = z7;
                        String b5 = b.b(bVar, str, i7, h4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                        if (z9) {
                            b5 = aVar.g() + "%40" + b5;
                        }
                        aVar.t(b5);
                        if (h4 != i4) {
                            aVar.r(b.b(bVar, str, h4 + 1, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null));
                            z6 = z5;
                        } else {
                            z6 = z8;
                        }
                        z8 = z6;
                        z9 = z5;
                    }
                    i7 = i4 + 1;
                    z7 = z5;
                    c8 = '#';
                    c7 = '?';
                    c6 = 65535;
                }
            }
            boolean z10 = z7;
            int I = I(str, i7, i4);
            int i8 = I + 1;
            if (i8 < i4) {
                i5 = i4;
                str3 = "substring(...)";
                i6 = u6;
                z4 = false;
                str4 = str;
                aVar.u(i.k(G(this, str, i7, I, false, 4, null)));
                aVar.v(E(str4, i8, i5));
                if (!(aVar.i() != -1 ? z10 : false)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Invalid URL port: \"");
                    String substring2 = str4.substring(i8, i5);
                    e3.f.d(substring2, str3);
                    sb3.append(substring2);
                    sb3.append('\"');
                    throw new IllegalArgumentException(sb3.toString().toString());
                }
            } else {
                i5 = i4;
                str3 = "substring(...)";
                i6 = u6;
                str4 = str;
                z4 = false;
                aVar.u(i.k(G(this, str, i7, I, false, 4, null)));
                v.b bVar2 = v.f4796j;
                String j4 = aVar.j();
                e3.f.b(j4);
                aVar.v(bVar2.a(j4));
            }
            if (!(aVar.h() != null ? z10 : z4)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Invalid URL host: \"");
                String substring3 = str4.substring(i7, I);
                e3.f.d(substring3, str3);
                sb4.append(substring3);
                sb4.append('\"');
                throw new IllegalArgumentException(sb4.toString().toString());
            }
            s4 = i5;
        } else {
            aVar.t(vVar.f());
            aVar.r(vVar.b());
            aVar.u(vVar.j());
            aVar.v(vVar.o());
            aVar.e().clear();
            aVar.e().addAll(vVar.d());
            if (s4 == u6 || str.charAt(s4) == '#') {
                aVar.b(vVar.e());
            }
            i6 = u6;
            str4 = str;
        }
        int i9 = i6;
        int i10 = p.i(str4, "?#", s4, i9);
        K(aVar, str4, s4, i10);
        if (i10 >= i9 || str4.charAt(i10) != '?') {
            str5 = str4;
            c5 = '#';
        } else {
            c5 = '#';
            int h5 = p.h(str4, '#', i10, i9);
            str5 = str4;
            aVar.s(O(b.b(b.f5187a, str, i10 + 1, h5, " \"'<>#", true, false, true, false, 80, null)));
            i10 = h5;
        }
        if (i10 < i9 && str5.charAt(i10) == c5) {
            aVar.q(b.b(b.f5187a, str, i10 + 1, i9, "", true, false, false, true, 48, null));
        }
        return aVar;
    }

    public final v.a j(v.a aVar, String str) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "password");
        aVar.r(b.b(b.f5187a, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, a.j.M0, null));
        return aVar;
    }

    public final v.a k(v.a aVar, int i4) {
        e3.f.e(aVar, "<this>");
        boolean z4 = false;
        if (1 <= i4 && i4 < 65536) {
            z4 = true;
        }
        if (z4) {
            aVar.v(i4);
            return aVar;
        }
        throw new IllegalArgumentException(("unexpected port: " + i4).toString());
    }

    public final String l(v vVar) {
        e3.f.e(vVar, "<this>");
        v.a m4 = vVar.m("/...");
        e3.f.b(m4);
        return m4.x("").m("").a().toString();
    }

    public final v m(v vVar, String str) {
        e3.f.e(vVar, "<this>");
        e3.f.e(str, "link");
        v.a m4 = vVar.m(str);
        if (m4 != null) {
            return m4.a();
        }
        return null;
    }

    public final v.a n(v.a aVar, String str) {
        boolean l4;
        boolean l5;
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "scheme");
        String str2 = "http";
        l4 = u.l(str, "http", true);
        if (!l4) {
            str2 = "https";
            l5 = u.l(str, "https", true);
            if (!l5) {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
        }
        aVar.w(str2);
        return aVar;
    }

    public final v o(String str) {
        e3.f.e(str, "<this>");
        return new v.a().l(null, str).a();
    }

    public final String p(v vVar) {
        e3.f.e(vVar, "<this>");
        return vVar.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if ((r7.d().length() > 0) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b9, code lost:
    
        if (r1 != r2.a(r3)) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String q(l3.v.a r7) {
        /*
            r6 = this;
            java.lang.String r0 = "<this>"
            e3.f.e(r7, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r7.j()
            if (r1 == 0) goto L1a
            java.lang.String r1 = r7.j()
            r0.append(r1)
            java.lang.String r1 = "://"
            goto L1c
        L1a:
            java.lang.String r1 = "//"
        L1c:
            r0.append(r1)
            java.lang.String r1 = r7.g()
            int r1 = r1.length()
            r2 = 1
            r3 = 0
            if (r1 <= 0) goto L2d
            r1 = r2
            goto L2e
        L2d:
            r1 = r3
        L2e:
            r4 = 58
            if (r1 != 0) goto L41
            java.lang.String r1 = r7.d()
            int r1 = r1.length()
            if (r1 <= 0) goto L3e
            r1 = r2
            goto L3f
        L3e:
            r1 = r3
        L3f:
            if (r1 == 0) goto L65
        L41:
            java.lang.String r1 = r7.g()
            r0.append(r1)
            java.lang.String r1 = r7.d()
            int r1 = r1.length()
            if (r1 <= 0) goto L53
            goto L54
        L53:
            r2 = r3
        L54:
            if (r2 == 0) goto L60
            r0.append(r4)
            java.lang.String r1 = r7.d()
            r0.append(r1)
        L60:
            r1 = 64
            r0.append(r1)
        L65:
            java.lang.String r1 = r7.h()
            if (r1 == 0) goto L93
            java.lang.String r1 = r7.h()
            e3.f.b(r1)
            r2 = 2
            r5 = 0
            boolean r1 = j3.l.B(r1, r4, r3, r2, r5)
            if (r1 == 0) goto L8c
            r1 = 91
            r0.append(r1)
            java.lang.String r1 = r7.h()
            r0.append(r1)
            r1 = 93
            r0.append(r1)
            goto L93
        L8c:
            java.lang.String r1 = r7.h()
            r0.append(r1)
        L93:
            int r1 = r7.i()
            r2 = -1
            if (r1 != r2) goto La0
            java.lang.String r1 = r7.j()
            if (r1 == 0) goto Lc1
        La0:
            m3.a r1 = m3.a.f5185a
            int r1 = r1.s(r7)
            java.lang.String r2 = r7.j()
            if (r2 == 0) goto Lbb
            l3.v$b r2 = l3.v.f4796j
            java.lang.String r3 = r7.j()
            e3.f.b(r3)
            int r2 = r2.a(r3)
            if (r1 == r2) goto Lc1
        Lbb:
            r0.append(r4)
            r0.append(r1)
        Lc1:
            m3.a r1 = m3.a.f5185a
            java.util.List r2 = r7.e()
            r1.N(r2, r0)
            java.util.List r2 = r7.f()
            if (r2 == 0) goto Ldf
            r2 = 63
            r0.append(r2)
            java.util.List r2 = r7.f()
            e3.f.b(r2)
            r1.P(r2, r0)
        Ldf:
            java.lang.String r1 = r7.c()
            if (r1 == 0) goto Lf1
            r1 = 35
            r0.append(r1)
            java.lang.String r7 = r7.c()
            r0.append(r7)
        Lf1:
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "toString(...)"
            e3.f.d(r7, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.a.q(l3.v$a):java.lang.String");
    }

    public final v.a r(v.a aVar, String str) {
        e3.f.e(aVar, "<this>");
        e3.f.e(str, "username");
        aVar.t(b.b(b.f5187a, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, a.j.M0, null));
        return aVar;
    }

    public final int s(v.a aVar) {
        e3.f.e(aVar, "<this>");
        if (aVar.i() != -1) {
            return aVar.i();
        }
        v.b bVar = v.f4796j;
        String j4 = aVar.j();
        e3.f.b(j4);
        return bVar.a(j4);
    }

    public final String t(v vVar) {
        int M;
        e3.f.e(vVar, "<this>");
        if (vVar.g() == null) {
            return null;
        }
        M = j3.v.M(vVar.i(), '#', 0, false, 6, null);
        String substring = vVar.i().substring(M + 1);
        e3.f.d(substring, "substring(...)");
        return substring;
    }

    public final String u(v vVar) {
        int M;
        int M2;
        e3.f.e(vVar, "<this>");
        if (vVar.n().length() == 0) {
            return "";
        }
        M = j3.v.M(vVar.i(), ':', vVar.s().length() + 3, false, 4, null);
        M2 = j3.v.M(vVar.i(), '@', 0, false, 6, null);
        String substring = vVar.i().substring(M + 1, M2);
        e3.f.d(substring, "substring(...)");
        return substring;
    }

    public final String v(v vVar) {
        int M;
        e3.f.e(vVar, "<this>");
        M = j3.v.M(vVar.i(), '/', vVar.s().length() + 3, false, 4, null);
        String substring = vVar.i().substring(M, p.i(vVar.i(), "?#", M, vVar.i().length()));
        e3.f.d(substring, "substring(...)");
        return substring;
    }

    public final List<String> w(v vVar) {
        int M;
        e3.f.e(vVar, "<this>");
        M = j3.v.M(vVar.i(), '/', vVar.s().length() + 3, false, 4, null);
        int i4 = p.i(vVar.i(), "?#", M, vVar.i().length());
        ArrayList arrayList = new ArrayList();
        while (M < i4) {
            int i5 = M + 1;
            int h4 = p.h(vVar.i(), '/', i5, i4);
            String substring = vVar.i().substring(i5, h4);
            e3.f.d(substring, "substring(...)");
            arrayList.add(substring);
            M = h4;
        }
        return arrayList;
    }

    public final String x(v vVar) {
        int M;
        e3.f.e(vVar, "<this>");
        if (vVar.h() == null) {
            return null;
        }
        M = j3.v.M(vVar.i(), '?', 0, false, 6, null);
        int i4 = M + 1;
        String substring = vVar.i().substring(i4, p.h(vVar.i(), '#', i4, vVar.i().length()));
        e3.f.d(substring, "substring(...)");
        return substring;
    }

    public final String y(v vVar) {
        e3.f.e(vVar, "<this>");
        if (vVar.v().length() == 0) {
            return "";
        }
        int length = vVar.s().length() + 3;
        String substring = vVar.i().substring(length, p.i(vVar.i(), ":@", length, vVar.i().length()));
        e3.f.d(substring, "substring(...)");
        return substring;
    }

    public final String z(v vVar) {
        e3.f.e(vVar, "<this>");
        if (vVar.h() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        P(vVar.h(), sb);
        return sb.toString();
    }
}
