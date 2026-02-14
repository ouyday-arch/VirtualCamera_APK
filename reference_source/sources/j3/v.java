package j3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v2.b0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends u {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends e3.g implements d3.c<CharSequence, Integer, u2.g<? extends Integer, ? extends Integer>> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ char[] f4280c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f4281d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z4) {
            super(2);
            this.f4280c = cArr;
            this.f4281d = z4;
        }

        @Override // d3.c
        public /* bridge */ /* synthetic */ u2.g<? extends Integer, ? extends Integer> a(CharSequence charSequence, Integer num) {
            return c(charSequence, num.intValue());
        }

        public final u2.g<Integer, Integer> c(CharSequence charSequence, int i4) {
            e3.f.e(charSequence, "$this$$receiver");
            int O = v.O(charSequence, this.f4280c, i4, this.f4281d);
            if (O < 0) {
                return null;
            }
            return u2.i.a(Integer.valueOf(O), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends e3.g implements d3.c<CharSequence, Integer, u2.g<? extends Integer, ? extends Integer>> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f4282c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f4283d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List<String> list, boolean z4) {
            super(2);
            this.f4282c = list;
            this.f4283d = z4;
        }

        @Override // d3.c
        public /* bridge */ /* synthetic */ u2.g<? extends Integer, ? extends Integer> a(CharSequence charSequence, Integer num) {
            return c(charSequence, num.intValue());
        }

        public final u2.g<Integer, Integer> c(CharSequence charSequence, int i4) {
            e3.f.e(charSequence, "$this$$receiver");
            u2.g F = v.F(charSequence, this.f4282c, i4, this.f4283d, false);
            if (F != null) {
                return u2.i.a(F.c(), Integer.valueOf(((String) F.d()).length()));
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends e3.g implements d3.b<g3.f, String> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CharSequence f4284c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.f4284c = charSequence;
        }

        @Override // d3.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final String b(g3.f fVar) {
            e3.f.e(fVar, "it");
            return v.n0(this.f4284c, fVar);
        }
    }

    public static final boolean A(CharSequence charSequence, CharSequence charSequence2, boolean z4) {
        e3.f.e(charSequence, "<this>");
        e3.f.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (l.N(charSequence, (String) charSequence2, 0, z4, 2, null) >= 0) {
                return true;
            }
        } else if (L(charSequence, charSequence2, 0, charSequence.length(), z4, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean B(CharSequence charSequence, char c5, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return z(charSequence, c5, z4);
    }

    public static /* synthetic */ boolean C(CharSequence charSequence, CharSequence charSequence2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return A(charSequence, charSequence2, z4);
    }

    public static final boolean D(CharSequence charSequence, CharSequence charSequence2, boolean z4) {
        e3.f.e(charSequence, "<this>");
        e3.f.e(charSequence2, "suffix");
        return (!z4 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? l.k((String) charSequence, (String) charSequence2, false, 2, null) : c0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z4);
    }

    public static /* synthetic */ boolean E(CharSequence charSequence, CharSequence charSequence2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return D(charSequence, charSequence2, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
    
        return u2.i.a(java.lang.Integer.valueOf(r12), r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final u2.g<java.lang.Integer, java.lang.String> F(java.lang.CharSequence r10, java.util.Collection<java.lang.String> r11, int r12, boolean r13, boolean r14) {
        /*
            r0 = 0
            if (r13 != 0) goto L2d
            int r1 = r11.size()
            r2 = 1
            if (r1 != r2) goto L2d
            java.lang.Object r11 = v2.m.I(r11)
            java.lang.String r11 = (java.lang.String) r11
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            if (r14 != 0) goto L1d
            int r10 = j3.l.N(r1, r2, r3, r4, r5, r6)
            goto L21
        L1d:
            int r10 = j3.l.S(r1, r2, r3, r4, r5, r6)
        L21:
            if (r10 >= 0) goto L24
            goto L2c
        L24:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            u2.g r0 = u2.i.a(r10, r11)
        L2c:
            return r0
        L2d:
            r1 = 0
            if (r14 != 0) goto L3e
            g3.f r14 = new g3.f
            int r12 = g3.j.b(r12, r1)
            int r1 = r10.length()
            r14.<init>(r12, r1)
            goto L4a
        L3e:
            int r14 = H(r10)
            int r12 = g3.j.c(r12, r14)
            g3.d r14 = g3.j.f(r12, r1)
        L4a:
            boolean r12 = r10 instanceof java.lang.String
            if (r12 == 0) goto L96
            int r12 = r14.a()
            int r1 = r14.b()
            int r14 = r14.c()
            if (r14 <= 0) goto L5e
            if (r12 <= r1) goto L62
        L5e:
            if (r14 >= 0) goto Ld4
            if (r1 > r12) goto Ld4
        L62:
            java.util.Iterator r8 = r11.iterator()
        L66:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r2.length()
            r5 = r12
            r7 = r13
            boolean r2 = j3.l.n(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto L66
            goto L85
        L84:
            r9 = r0
        L85:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L92
        L89:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
            u2.g r10 = u2.i.a(r10, r9)
            return r10
        L92:
            if (r12 == r1) goto Ld4
            int r12 = r12 + r14
            goto L62
        L96:
            int r12 = r14.a()
            int r1 = r14.b()
            int r14 = r14.c()
            if (r14 <= 0) goto La6
            if (r12 <= r1) goto Laa
        La6:
            if (r14 >= 0) goto Ld4
            if (r1 > r12) goto Ld4
        Laa:
            java.util.Iterator r8 = r11.iterator()
        Lae:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lca
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            int r6 = r2.length()
            r4 = r10
            r5 = r12
            r7 = r13
            boolean r2 = c0(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto Lae
            goto Lcb
        Lca:
            r9 = r0
        Lcb:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto Ld0
            goto L89
        Ld0:
            if (r12 == r1) goto Ld4
            int r12 = r12 + r14
            goto Laa
        Ld4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.v.F(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):u2.g");
    }

    public static final g3.f G(CharSequence charSequence) {
        e3.f.e(charSequence, "<this>");
        return new g3.f(0, charSequence.length() - 1);
    }

    public static final int H(CharSequence charSequence) {
        e3.f.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int I(CharSequence charSequence, char c5, int i4, boolean z4) {
        e3.f.e(charSequence, "<this>");
        return (z4 || !(charSequence instanceof String)) ? O(charSequence, new char[]{c5}, i4, z4) : ((String) charSequence).indexOf(c5, i4);
    }

    public static final int J(CharSequence charSequence, String str, int i4, boolean z4) {
        e3.f.e(charSequence, "<this>");
        e3.f.e(str, "string");
        return (z4 || !(charSequence instanceof String)) ? L(charSequence, str, i4, charSequence.length(), z4, false, 16, null) : ((String) charSequence).indexOf(str, i4);
    }

    private static final int K(CharSequence charSequence, CharSequence charSequence2, int i4, int i5, boolean z4, boolean z5) {
        g3.d fVar = !z5 ? new g3.f(g3.j.b(i4, 0), g3.j.c(i5, charSequence.length())) : g3.j.f(g3.j.c(i4, H(charSequence)), g3.j.b(i5, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a5 = fVar.a();
            int b5 = fVar.b();
            int c5 = fVar.c();
            if ((c5 <= 0 || a5 > b5) && (c5 >= 0 || b5 > a5)) {
                return -1;
            }
            while (!l.n((String) charSequence2, 0, (String) charSequence, a5, charSequence2.length(), z4)) {
                if (a5 == b5) {
                    return -1;
                }
                a5 += c5;
            }
            return a5;
        }
        int a6 = fVar.a();
        int b6 = fVar.b();
        int c6 = fVar.c();
        if ((c6 <= 0 || a6 > b6) && (c6 >= 0 || b6 > a6)) {
            return -1;
        }
        while (!c0(charSequence2, 0, charSequence, a6, charSequence2.length(), z4)) {
            if (a6 == b6) {
                return -1;
            }
            a6 += c6;
        }
        return a6;
    }

    static /* synthetic */ int L(CharSequence charSequence, CharSequence charSequence2, int i4, int i5, boolean z4, boolean z5, int i6, Object obj) {
        if ((i6 & 16) != 0) {
            z5 = false;
        }
        return K(charSequence, charSequence2, i4, i5, z4, z5);
    }

    public static /* synthetic */ int M(CharSequence charSequence, char c5, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return I(charSequence, c5, i4, z4);
    }

    public static /* synthetic */ int N(CharSequence charSequence, String str, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return J(charSequence, str, i4, z4);
    }

    public static final int O(CharSequence charSequence, char[] cArr, int i4, boolean z4) {
        boolean z5;
        char t4;
        e3.f.e(charSequence, "<this>");
        e3.f.e(cArr, "chars");
        if (!z4 && cArr.length == 1 && (charSequence instanceof String)) {
            t4 = v2.j.t(cArr);
            return ((String) charSequence).indexOf(t4, i4);
        }
        b0 it = new g3.f(g3.j.b(i4, 0), H(charSequence)).iterator();
        while (it.hasNext()) {
            int a5 = it.a();
            char charAt = charSequence.charAt(a5);
            int length = cArr.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z5 = false;
                    break;
                }
                if (j3.c.d(cArr[i5], charAt, z4)) {
                    z5 = true;
                    break;
                }
                i5++;
            }
            if (z5) {
                return a5;
            }
        }
        return -1;
    }

    public static final int P(CharSequence charSequence, char c5, int i4, boolean z4) {
        e3.f.e(charSequence, "<this>");
        return (z4 || !(charSequence instanceof String)) ? T(charSequence, new char[]{c5}, i4, z4) : ((String) charSequence).lastIndexOf(c5, i4);
    }

    public static final int Q(CharSequence charSequence, String str, int i4, boolean z4) {
        e3.f.e(charSequence, "<this>");
        e3.f.e(str, "string");
        return (z4 || !(charSequence instanceof String)) ? K(charSequence, str, i4, 0, z4, true) : ((String) charSequence).lastIndexOf(str, i4);
    }

    public static /* synthetic */ int R(CharSequence charSequence, char c5, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = H(charSequence);
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return P(charSequence, c5, i4, z4);
    }

    public static /* synthetic */ int S(CharSequence charSequence, String str, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = H(charSequence);
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return Q(charSequence, str, i4, z4);
    }

    public static final int T(CharSequence charSequence, char[] cArr, int i4, boolean z4) {
        char t4;
        e3.f.e(charSequence, "<this>");
        e3.f.e(cArr, "chars");
        if (!z4 && cArr.length == 1 && (charSequence instanceof String)) {
            t4 = v2.j.t(cArr);
            return ((String) charSequence).lastIndexOf(t4, i4);
        }
        for (int c5 = g3.j.c(i4, H(charSequence)); -1 < c5; c5--) {
            char charAt = charSequence.charAt(c5);
            int length = cArr.length;
            boolean z5 = false;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                if (j3.c.d(cArr[i5], charAt, z4)) {
                    z5 = true;
                    break;
                }
                i5++;
            }
            if (z5) {
                return c5;
            }
        }
        return -1;
    }

    public static final i3.c<String> U(CharSequence charSequence) {
        e3.f.e(charSequence, "<this>");
        return k0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> V(CharSequence charSequence) {
        e3.f.e(charSequence, "<this>");
        return i3.d.g(U(charSequence));
    }

    public static final CharSequence W(CharSequence charSequence, int i4, char c5) {
        e3.f.e(charSequence, "<this>");
        if (i4 < 0) {
            throw new IllegalArgumentException("Desired length " + i4 + " is less than zero.");
        }
        if (i4 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i4);
        b0 it = new g3.f(1, i4 - charSequence.length()).iterator();
        while (it.hasNext()) {
            it.a();
            sb.append(c5);
        }
        sb.append(charSequence);
        return sb;
    }

    public static String X(String str, int i4, char c5) {
        e3.f.e(str, "<this>");
        return W(str, i4, c5).toString();
    }

    private static final i3.c<g3.f> Y(CharSequence charSequence, char[] cArr, int i4, boolean z4, int i5) {
        f0(i5);
        return new e(charSequence, i4, i5, new a(cArr, z4));
    }

    private static final i3.c<g3.f> Z(CharSequence charSequence, String[] strArr, int i4, boolean z4, int i5) {
        List c5;
        f0(i5);
        c5 = v2.i.c(strArr);
        return new e(charSequence, i4, i5, new b(c5, z4));
    }

    static /* synthetic */ i3.c a0(CharSequence charSequence, char[] cArr, int i4, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return Y(charSequence, cArr, i4, z4, i5);
    }

    static /* synthetic */ i3.c b0(CharSequence charSequence, String[] strArr, int i4, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return Z(charSequence, strArr, i4, z4, i5);
    }

    public static final boolean c0(CharSequence charSequence, int i4, CharSequence charSequence2, int i5, int i6, boolean z4) {
        e3.f.e(charSequence, "<this>");
        e3.f.e(charSequence2, "other");
        if (i5 < 0 || i4 < 0 || i4 > charSequence.length() - i6 || i5 > charSequence2.length() - i6) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (!j3.c.d(charSequence.charAt(i4 + i7), charSequence2.charAt(i5 + i7), z4)) {
                return false;
            }
        }
        return true;
    }

    public static String d0(String str, CharSequence charSequence) {
        e3.f.e(str, "<this>");
        e3.f.e(charSequence, "prefix");
        if (!m0(str, charSequence, false, 2, null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        e3.f.d(substring, "substring(...)");
        return substring;
    }

    public static String e0(String str, CharSequence charSequence) {
        e3.f.e(str, "<this>");
        e3.f.e(charSequence, "suffix");
        if (!E(str, charSequence, false, 2, null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        e3.f.d(substring, "substring(...)");
        return substring;
    }

    public static final void f0(int i4) {
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i4).toString());
    }

    public static final List<String> g0(CharSequence charSequence, char[] cArr, boolean z4, int i4) {
        e3.f.e(charSequence, "<this>");
        e3.f.e(cArr, "delimiters");
        if (cArr.length == 1) {
            return h0(charSequence, String.valueOf(cArr[0]), z4, i4);
        }
        Iterable a5 = i3.d.a(a0(charSequence, cArr, 0, z4, i4, 2, null));
        ArrayList arrayList = new ArrayList(v2.m.r(a5, 10));
        Iterator it = a5.iterator();
        while (it.hasNext()) {
            arrayList.add(n0(charSequence, (g3.f) it.next()));
        }
        return arrayList;
    }

    private static final List<String> h0(CharSequence charSequence, String str, boolean z4, int i4) {
        f0(i4);
        int i5 = 0;
        int J = J(charSequence, str, 0, z4);
        if (J == -1 || i4 == 1) {
            return v2.m.d(charSequence.toString());
        }
        boolean z5 = i4 > 0;
        ArrayList arrayList = new ArrayList(z5 ? g3.j.c(i4, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i5, J).toString());
            i5 = str.length() + J;
            if (z5 && arrayList.size() == i4 - 1) {
                break;
            }
            J = J(charSequence, str, i5, z4);
        } while (J != -1);
        arrayList.add(charSequence.subSequence(i5, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List i0(CharSequence charSequence, char[] cArr, boolean z4, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return g0(charSequence, cArr, z4, i4);
    }

    public static final i3.c<String> j0(CharSequence charSequence, String[] strArr, boolean z4, int i4) {
        e3.f.e(charSequence, "<this>");
        e3.f.e(strArr, "delimiters");
        return i3.d.f(b0(charSequence, strArr, 0, z4, i4, 2, null), new c(charSequence));
    }

    public static /* synthetic */ i3.c k0(CharSequence charSequence, String[] strArr, boolean z4, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return j0(charSequence, strArr, z4, i4);
    }

    public static final boolean l0(CharSequence charSequence, CharSequence charSequence2, boolean z4) {
        e3.f.e(charSequence, "<this>");
        e3.f.e(charSequence2, "prefix");
        return (!z4 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? l.x((String) charSequence, (String) charSequence2, false, 2, null) : c0(charSequence, 0, charSequence2, 0, charSequence2.length(), z4);
    }

    public static /* synthetic */ boolean m0(CharSequence charSequence, CharSequence charSequence2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return l0(charSequence, charSequence2, z4);
    }

    public static final String n0(CharSequence charSequence, g3.f fVar) {
        e3.f.e(charSequence, "<this>");
        e3.f.e(fVar, "range");
        return charSequence.subSequence(fVar.h().intValue(), fVar.g().intValue() + 1).toString();
    }

    public static CharSequence o0(CharSequence charSequence) {
        e3.f.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i4 = 0;
        boolean z4 = false;
        while (i4 <= length) {
            boolean c5 = j3.b.c(charSequence.charAt(!z4 ? i4 : length));
            if (z4) {
                if (!c5) {
                    break;
                }
                length--;
            } else if (c5) {
                i4++;
            } else {
                z4 = true;
            }
        }
        return charSequence.subSequence(i4, length + 1);
    }

    public static final boolean z(CharSequence charSequence, char c5, boolean z4) {
        e3.f.e(charSequence, "<this>");
        return l.M(charSequence, c5, 0, z4, 2, null) >= 0;
    }
}
