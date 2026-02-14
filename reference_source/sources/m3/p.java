package m3;

import b4.g;
import b4.w;
import j3.v;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import l3.b0;
import l3.d0;
import l3.u;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f5201a;

    /* renamed from: b, reason: collision with root package name */
    private static final w f5202b;

    /* renamed from: c, reason: collision with root package name */
    private static final u f5203c;

    /* renamed from: d, reason: collision with root package name */
    private static final b0 f5204d;

    /* renamed from: e, reason: collision with root package name */
    private static final d0 f5205e;

    static {
        byte[] bArr = new byte[0];
        f5201a = bArr;
        w.a aVar = w.f2388e;
        g.a aVar2 = b4.g.f2337e;
        f5202b = aVar.d(aVar2.a("efbbbf"), aVar2.a("feff"), aVar2.a("fffe"), aVar2.a("0000ffff"), aVar2.a("ffff0000"));
        f5203c = u.f4793c.a(new String[0]);
        f5204d = b0.a.d(b0.f4582a, bArr, null, 0, 0, 7, null);
        f5205e = d0.a.c(d0.f4640b, bArr, null, 1, null);
    }

    public static final int A(char c5) {
        if ('0' <= c5 && c5 < ':') {
            return c5 - '0';
        }
        char c6 = 'a';
        if (!('a' <= c5 && c5 < 'g')) {
            c6 = 'A';
            if (!('A' <= c5 && c5 < 'G')) {
                return -1;
            }
        }
        return (c5 - c6) + 10;
    }

    public static final int B(b4.f fVar) {
        e3.f.e(fVar, "<this>");
        return b(fVar.H(), 255) | (b(fVar.H(), 255) << 16) | (b(fVar.H(), 255) << 8);
    }

    public static final int C(b4.d dVar, byte b5) {
        e3.f.e(dVar, "<this>");
        int i4 = 0;
        while (!dVar.z() && dVar.N(0L) == b5) {
            i4++;
            dVar.H();
        }
        return i4;
    }

    public static final long D(String str, long j4) {
        e3.f.e(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j4;
        }
    }

    public static final int E(String str, int i4) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i4;
    }

    public static final String F(String str, int i4, int i5) {
        e3.f.e(str, "<this>");
        int r4 = r(str, i4, i5);
        String substring = str.substring(r4, t(str, r4, i5));
        e3.f.d(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String G(String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return F(str, i4, i5);
    }

    public static final Throwable H(Exception exc, List<? extends Exception> list) {
        e3.f.e(exc, "<this>");
        e3.f.e(list, "suppressed");
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            u2.b.a(exc, it.next());
        }
        return exc;
    }

    public static final void I(b4.e eVar, int i4) {
        e3.f.e(eVar, "<this>");
        eVar.B((i4 >>> 16) & 255);
        eVar.B((i4 >>> 8) & 255);
        eVar.B(i4 & 255);
    }

    public static final <E> void a(List<E> list, E e4) {
        e3.f.e(list, "<this>");
        if (list.contains(e4)) {
            return;
        }
        list.add(e4);
    }

    public static final int b(byte b5, int i4) {
        return b5 & i4;
    }

    public static final int c(short s4, int i4) {
        return s4 & i4;
    }

    public static final long d(int i4, long j4) {
        return i4 & j4;
    }

    public static final void e(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException("length=" + j4 + ", offset=" + j5 + ", count=" + j5);
        }
    }

    public static final void f(Closeable closeable) {
        e3.f.e(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e4) {
            throw e4;
        } catch (Exception unused) {
        }
    }

    public static final String[] g(String[] strArr, String str) {
        int q4;
        e3.f.e(strArr, "<this>");
        e3.f.e(str, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        e3.f.d(copyOf, "copyOf(...)");
        String[] strArr2 = (String[]) copyOf;
        q4 = v2.j.q(strArr2);
        strArr2[q4] = str;
        return strArr2;
    }

    public static final int h(String str, char c5, int i4, int i5) {
        e3.f.e(str, "<this>");
        while (i4 < i5) {
            if (str.charAt(i4) == c5) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static final int i(String str, String str2, int i4, int i5) {
        boolean B;
        e3.f.e(str, "<this>");
        e3.f.e(str2, "delimiters");
        while (i4 < i5) {
            B = v.B(str2, str.charAt(i4), false, 2, null);
            if (B) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static /* synthetic */ int j(String str, char c5, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = str.length();
        }
        return h(str, c5, i4, i5);
    }

    public static final u k() {
        return f5203c;
    }

    public static final b0 l() {
        return f5204d;
    }

    public static final d0 m() {
        return f5205e;
    }

    public static final w n() {
        return f5202b;
    }

    public static final boolean o(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        e3.f.e(strArr, "<this>");
        e3.f.e(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    Iterator a5 = e3.b.a(strArr2);
                    while (a5.hasNext()) {
                        if (comparator.compare(str, (String) a5.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final int p(String[] strArr, String str, Comparator<String> comparator) {
        e3.f.e(strArr, "<this>");
        e3.f.e(str, "value");
        e3.f.e(comparator, "comparator");
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (comparator.compare(strArr[i4], str) == 0) {
                return i4;
            }
        }
        return -1;
    }

    public static final int q(String str) {
        e3.f.e(str, "<this>");
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (e3.f.f(charAt, 31) <= 0 || e3.f.f(charAt, 127) >= 0) {
                return i4;
            }
        }
        return -1;
    }

    public static final int r(String str, int i4, int i5) {
        e3.f.e(str, "<this>");
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (!((((charAt == '\t' || charAt == '\n') || charAt == '\f') || charAt == '\r') || charAt == ' ')) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static /* synthetic */ int s(String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return r(str, i4, i5);
    }

    public static final int t(String str, int i4, int i5) {
        e3.f.e(str, "<this>");
        int i6 = i5 - 1;
        if (i4 <= i6) {
            while (true) {
                char charAt = str.charAt(i6);
                if (!((((charAt == '\t' || charAt == '\n') || charAt == '\f') || charAt == '\r') || charAt == ' ')) {
                    return i6 + 1;
                }
                if (i6 == i4) {
                    break;
                }
                i6--;
            }
        }
        return i4;
    }

    public static /* synthetic */ int u(String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return t(str, i4, i5);
    }

    public static final int v(String str, int i4) {
        e3.f.e(str, "<this>");
        int length = str.length();
        while (i4 < length) {
            char charAt = str.charAt(i4);
            if (charAt != ' ' && charAt != '\t') {
                return i4;
            }
            i4++;
        }
        return str.length();
    }

    public static final <T> List<T> w(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        List c5;
        List<T> a5;
        e3.f.e(iterable, "a");
        e3.f.e(iterable2, "b");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends T> it2 = iterable2.iterator();
        c5 = v2.n.c();
        while (true) {
            if (!it.hasNext() && !it2.hasNext()) {
                a5 = v2.n.a(c5);
                return a5;
            }
            if (it.hasNext()) {
                c5.add(it.next());
            }
            if (it2.hasNext()) {
                c5.add(it2.next());
            }
        }
    }

    public static final String[] x(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        e3.f.e(strArr, "<this>");
        e3.f.e(strArr2, "other");
        e3.f.e(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i4]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i4++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean y(String str) {
        boolean l4;
        boolean l5;
        boolean l6;
        boolean l7;
        e3.f.e(str, "name");
        l4 = j3.u.l(str, "Authorization", true);
        if (l4) {
            return true;
        }
        l5 = j3.u.l(str, "Cookie", true);
        if (l5) {
            return true;
        }
        l6 = j3.u.l(str, "Proxy-Authorization", true);
        if (l6) {
            return true;
        }
        l7 = j3.u.l(str, "Set-Cookie", true);
        return l7;
    }

    public static final j3.h z(j3.j jVar, CharSequence charSequence, int i4) {
        e3.f.e(jVar, "<this>");
        e3.f.e(charSequence, "input");
        j3.h a5 = jVar.a(charSequence, i4);
        if (a5 != null && a5.c().a() == i4) {
            return a5;
        }
        return null;
    }
}
