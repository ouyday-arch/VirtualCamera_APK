package k3;

import e3.f;
import g3.i;
import j3.v;

/* loaded from: classes.dex */
public final class a implements Comparable<a> {

    /* renamed from: c, reason: collision with root package name */
    public static final C0054a f4448c = new C0054a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final long f4449d = d(0);

    /* renamed from: e, reason: collision with root package name */
    private static final long f4450e;

    /* renamed from: f, reason: collision with root package name */
    private static final long f4451f;

    /* renamed from: b, reason: collision with root package name */
    private final long f4452b;

    /* renamed from: k3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0054a {
        private C0054a() {
        }

        public /* synthetic */ C0054a(e3.d dVar) {
            this();
        }
    }

    static {
        long e4;
        long e5;
        e4 = c.e(4611686018427387903L);
        f4450e = e4;
        e5 = c.e(-4611686018427387903L);
        f4451f = e5;
    }

    private static final void a(long j4, StringBuilder sb, int i4, int i5, int i6, String str, boolean z4) {
        String X;
        sb.append(i4);
        if (i5 != 0) {
            sb.append('.');
            X = v.X(String.valueOf(i5), i6, '0');
            int i7 = -1;
            int length = X.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i8 = length - 1;
                    if (X.charAt(length) != '0') {
                        i7 = length;
                        break;
                    } else if (i8 < 0) {
                        break;
                    } else {
                        length = i8;
                    }
                }
            }
            int i9 = i7 + 1;
            if (z4 || i9 >= 3) {
                i9 = ((i9 + 2) / 3) * 3;
            }
            sb.append((CharSequence) X, 0, i9);
            f.d(sb, "append(...)");
        }
        sb.append(str);
    }

    public static int c(long j4, long j5) {
        long j6 = j4 ^ j5;
        if (j6 < 0 || (((int) j6) & 1) == 0) {
            return f.g(j4, j5);
        }
        int i4 = (((int) j4) & 1) - (((int) j5) & 1);
        return u(j4) ? -i4 : i4;
    }

    public static long d(long j4) {
        if (b.a()) {
            if (s(j4)) {
                if (!new i(-4611686018426999999L, 4611686018426999999L).d(p(j4))) {
                    throw new AssertionError(p(j4) + " ns is out of nanoseconds range");
                }
            } else {
                if (!new i(-4611686018427387903L, 4611686018427387903L).d(p(j4))) {
                    throw new AssertionError(p(j4) + " ms is out of milliseconds range");
                }
                if (new i(-4611686018426L, 4611686018426L).d(p(j4))) {
                    throw new AssertionError(p(j4) + " ms is denormalized");
                }
            }
        }
        return j4;
    }

    public static boolean e(long j4, Object obj) {
        return (obj instanceof a) && j4 == ((a) obj).y();
    }

    public static final long f(long j4) {
        return u(j4) ? x(j4) : j4;
    }

    public static final int g(long j4) {
        if (t(j4)) {
            return 0;
        }
        return (int) (i(j4) % 24);
    }

    public static final long h(long j4) {
        return v(j4, d.f4461i);
    }

    public static final long i(long j4) {
        return v(j4, d.f4460h);
    }

    public static final long j(long j4) {
        return v(j4, d.f4459g);
    }

    public static final long k(long j4) {
        return v(j4, d.f4458f);
    }

    public static final int l(long j4) {
        if (t(j4)) {
            return 0;
        }
        return (int) (j(j4) % 60);
    }

    public static final int m(long j4) {
        if (t(j4)) {
            return 0;
        }
        boolean r4 = r(j4);
        long p4 = p(j4);
        return (int) (r4 ? c.g(p4 % 1000) : p4 % 1000000000);
    }

    public static final int n(long j4) {
        if (t(j4)) {
            return 0;
        }
        return (int) (k(j4) % 60);
    }

    private static final d o(long j4) {
        return s(j4) ? d.f4455c : d.f4457e;
    }

    private static final long p(long j4) {
        return j4 >> 1;
    }

    public static int q(long j4) {
        return Long.hashCode(j4);
    }

    private static final boolean r(long j4) {
        return (((int) j4) & 1) == 1;
    }

    private static final boolean s(long j4) {
        return (((int) j4) & 1) == 0;
    }

    public static final boolean t(long j4) {
        return j4 == f4450e || j4 == f4451f;
    }

    public static final boolean u(long j4) {
        return j4 < 0;
    }

    public static final long v(long j4, d dVar) {
        f.e(dVar, "unit");
        if (j4 == f4450e) {
            return Long.MAX_VALUE;
        }
        if (j4 == f4451f) {
            return Long.MIN_VALUE;
        }
        return e.a(p(j4), o(j4), dVar);
    }

    public static String w(long j4) {
        int i4;
        long j5;
        StringBuilder sb;
        int i5;
        int i6;
        String str;
        boolean z4;
        if (j4 == 0) {
            return "0s";
        }
        if (j4 == f4450e) {
            return "Infinity";
        }
        if (j4 == f4451f) {
            return "-Infinity";
        }
        boolean u4 = u(j4);
        StringBuilder sb2 = new StringBuilder();
        if (u4) {
            sb2.append('-');
        }
        long f4 = f(j4);
        long h4 = h(f4);
        int g4 = g(f4);
        int l4 = l(f4);
        int n4 = n(f4);
        int m4 = m(f4);
        int i7 = 0;
        boolean z5 = h4 != 0;
        boolean z6 = g4 != 0;
        boolean z7 = l4 != 0;
        boolean z8 = (n4 == 0 && m4 == 0) ? false : true;
        if (z5) {
            sb2.append(h4);
            sb2.append('d');
            i7 = 1;
        }
        if (z6 || (z5 && (z7 || z8))) {
            int i8 = i7 + 1;
            if (i7 > 0) {
                sb2.append(' ');
            }
            sb2.append(g4);
            sb2.append('h');
            i7 = i8;
        }
        if (z7 || (z8 && (z6 || z5))) {
            int i9 = i7 + 1;
            if (i7 > 0) {
                sb2.append(' ');
            }
            sb2.append(l4);
            sb2.append('m');
            i7 = i9;
        }
        if (z8) {
            int i10 = i7 + 1;
            if (i7 > 0) {
                sb2.append(' ');
            }
            if (n4 != 0 || z5 || z6 || z7) {
                i4 = 9;
                j5 = j4;
                sb = sb2;
                i5 = n4;
                i6 = m4;
                str = "s";
                z4 = false;
            } else {
                if (m4 >= 1000000) {
                    i5 = m4 / 1000000;
                    i6 = m4 % 1000000;
                    i4 = 6;
                    z4 = false;
                    str = "ms";
                } else if (m4 >= 1000) {
                    i5 = m4 / 1000;
                    i6 = m4 % 1000;
                    i4 = 3;
                    z4 = false;
                    str = "us";
                } else {
                    sb2.append(m4);
                    sb2.append("ns");
                    i7 = i10;
                }
                j5 = j4;
                sb = sb2;
            }
            a(j5, sb, i5, i6, i4, str, z4);
            i7 = i10;
        }
        if (u4 && i7 > 1) {
            sb2.insert(1, '(').append(')');
        }
        String sb3 = sb2.toString();
        f.d(sb3, "toString(...)");
        return sb3;
    }

    public static final long x(long j4) {
        long d5;
        d5 = c.d(-p(j4), ((int) j4) & 1);
        return d5;
    }

    public int b(long j4) {
        return c(this.f4452b, j4);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a aVar) {
        return b(aVar.y());
    }

    public boolean equals(Object obj) {
        return e(this.f4452b, obj);
    }

    public int hashCode() {
        return q(this.f4452b);
    }

    public String toString() {
        return w(this.f4452b);
    }

    public final /* synthetic */ long y() {
        return this.f4452b;
    }
}
