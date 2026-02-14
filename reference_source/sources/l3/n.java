package l3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: k, reason: collision with root package name */
    public static final a f4755k = new a(null);

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f4756l = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f4757m = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: n, reason: collision with root package name */
    private static final Pattern f4758n = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: o, reason: collision with root package name */
    private static final Pattern f4759o = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    private final String f4760a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4761b;

    /* renamed from: c, reason: collision with root package name */
    private final long f4762c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4763d;

    /* renamed from: e, reason: collision with root package name */
    private final String f4764e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f4765f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f4766g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f4767h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f4768i;

    /* renamed from: j, reason: collision with root package name */
    private final String f4769j;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x003b, code lost:
        
            if (r0 != ':') goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final int a(java.lang.String r6, int r7, int r8, boolean r9) {
            /*
                r5 = this;
            L0:
                if (r7 >= r8) goto L46
                char r0 = r6.charAt(r7)
                r1 = 32
                r2 = 1
                r3 = 0
                if (r0 >= r1) goto L10
                r1 = 9
                if (r0 != r1) goto L3d
            L10:
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 >= r1) goto L3d
                r1 = 48
                r4 = 58
                if (r1 > r0) goto L1e
                if (r0 >= r4) goto L1e
                r1 = r2
                goto L1f
            L1e:
                r1 = r3
            L1f:
                if (r1 != 0) goto L3d
                r1 = 97
                if (r1 > r0) goto L2b
                r1 = 123(0x7b, float:1.72E-43)
                if (r0 >= r1) goto L2b
                r1 = r2
                goto L2c
            L2b:
                r1 = r3
            L2c:
                if (r1 != 0) goto L3d
                r1 = 65
                if (r1 > r0) goto L38
                r1 = 91
                if (r0 >= r1) goto L38
                r1 = r2
                goto L39
            L38:
                r1 = r3
            L39:
                if (r1 != 0) goto L3d
                if (r0 != r4) goto L3e
            L3d:
                r3 = r2
            L3e:
                r0 = r9 ^ 1
                if (r3 != r0) goto L43
                return r7
            L43:
                int r7 = r7 + 1
                goto L0
            L46:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: l3.n.a.a(java.lang.String, int, int, boolean):int");
        }

        private final boolean b(String str, String str2) {
            boolean k4;
            if (e3.f.a(str, str2)) {
                return true;
            }
            k4 = j3.u.k(str, str2, false, 2, null);
            return k4 && str.charAt((str.length() - str2.length()) - 1) == '.' && !m3.i.a(str);
        }

        private final String f(String str) {
            boolean k4;
            String d02;
            k4 = j3.u.k(str, ".", false, 2, null);
            if (!(!k4)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            d02 = j3.v.d0(str, ".");
            String k5 = m3.i.k(d02);
            if (k5 != null) {
                return k5;
            }
            throw new IllegalArgumentException();
        }

        private final long g(String str, int i4, int i5) {
            int N;
            int a5 = a(str, i4, i5, false);
            Matcher matcher = n.f4759o.matcher(str);
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            while (a5 < i5) {
                int a6 = a(str, a5 + 1, i5, true);
                matcher.region(a5, a6);
                if (i7 == -1 && matcher.usePattern(n.f4759o).matches()) {
                    String group = matcher.group(1);
                    e3.f.d(group, "group(...)");
                    i7 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    e3.f.d(group2, "group(...)");
                    i10 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    e3.f.d(group3, "group(...)");
                    i11 = Integer.parseInt(group3);
                } else if (i8 == -1 && matcher.usePattern(n.f4758n).matches()) {
                    String group4 = matcher.group(1);
                    e3.f.d(group4, "group(...)");
                    i8 = Integer.parseInt(group4);
                } else if (i9 == -1 && matcher.usePattern(n.f4757m).matches()) {
                    String group5 = matcher.group(1);
                    e3.f.d(group5, "group(...)");
                    Locale locale = Locale.US;
                    e3.f.d(locale, "US");
                    String lowerCase = group5.toLowerCase(locale);
                    e3.f.d(lowerCase, "toLowerCase(...)");
                    String pattern = n.f4757m.pattern();
                    e3.f.d(pattern, "pattern(...)");
                    N = j3.v.N(pattern, lowerCase, 0, false, 6, null);
                    i9 = N / 4;
                } else if (i6 == -1 && matcher.usePattern(n.f4756l).matches()) {
                    String group6 = matcher.group(1);
                    e3.f.d(group6, "group(...)");
                    i6 = Integer.parseInt(group6);
                }
                a5 = a(str, a6 + 1, i5, false);
            }
            if (70 <= i6 && i6 < 100) {
                i6 += 1900;
            }
            if (i6 >= 0 && i6 < 70) {
                i6 += 2000;
            }
            if (!(i6 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i9 != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i8 && i8 < 32)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i7 >= 0 && i7 < 24)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i10 >= 0 && i10 < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i11 >= 0 && i11 < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(m3.s.f5212d);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i6);
            gregorianCalendar.set(2, i9 - 1);
            gregorianCalendar.set(5, i8);
            gregorianCalendar.set(11, i7);
            gregorianCalendar.set(12, i10);
            gregorianCalendar.set(13, i11);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long h(String str) {
            boolean x4;
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e4) {
                if (!new j3.j("-?\\d+").b(str)) {
                    throw e4;
                }
                x4 = j3.u.x(str, "-", false, 2, null);
                return x4 ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
        }

        public final n c(v vVar, String str) {
            e3.f.e(vVar, "url");
            e3.f.e(str, "setCookie");
            return d(System.currentTimeMillis(), vVar, str);
        }

        /* JADX WARN: Code restructure failed: missing block: B:89:0x010f, code lost:
        
            if (r1 > 253402300799999L) goto L62;
         */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0121  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x014b  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0167  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0124  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final l3.n d(long r27, l3.v r29, java.lang.String r30) {
            /*
                Method dump skipped, instructions count: 381
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: l3.n.a.d(long, l3.v, java.lang.String):l3.n");
        }

        public final List<n> e(v vVar, u uVar) {
            List<n> i4;
            e3.f.e(vVar, "url");
            e3.f.e(uVar, "headers");
            List<String> f4 = uVar.f("Set-Cookie");
            int size = f4.size();
            ArrayList arrayList = null;
            for (int i5 = 0; i5 < size; i5++) {
                n c5 = c(vVar, f4.get(i5));
                if (c5 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c5);
                }
            }
            if (arrayList == null) {
                i4 = v2.o.i();
                return i4;
            }
            List<n> unmodifiableList = Collections.unmodifiableList(arrayList);
            e3.f.b(unmodifiableList);
            return unmodifiableList;
        }
    }

    private n(String str, String str2, long j4, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7, String str5) {
        this.f4760a = str;
        this.f4761b = str2;
        this.f4762c = j4;
        this.f4763d = str3;
        this.f4764e = str4;
        this.f4765f = z4;
        this.f4766g = z5;
        this.f4767h = z6;
        this.f4768i = z7;
        this.f4769j = str5;
    }

    public /* synthetic */ n(String str, String str2, long j4, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7, String str5, e3.d dVar) {
        this(str, str2, j4, str3, str4, z4, z5, z6, z7, str5);
    }

    public final String e() {
        return this.f4760a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (e3.f.a(nVar.f4760a, this.f4760a) && e3.f.a(nVar.f4761b, this.f4761b) && nVar.f4762c == this.f4762c && e3.f.a(nVar.f4763d, this.f4763d) && e3.f.a(nVar.f4764e, this.f4764e) && nVar.f4765f == this.f4765f && nVar.f4766g == this.f4766g && nVar.f4767h == this.f4767h && nVar.f4768i == this.f4768i && e3.f.a(nVar.f4769j, this.f4769j)) {
                return true;
            }
        }
        return false;
    }

    public final String f(boolean z4) {
        String b5;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4760a);
        sb.append('=');
        sb.append(this.f4761b);
        if (this.f4767h) {
            if (this.f4762c == Long.MIN_VALUE) {
                b5 = "; max-age=0";
            } else {
                sb.append("; expires=");
                b5 = r3.c.b(new Date(this.f4762c));
            }
            sb.append(b5);
        }
        if (!this.f4768i) {
            sb.append("; domain=");
            if (z4) {
                sb.append(".");
            }
            sb.append(this.f4763d);
        }
        sb.append("; path=");
        sb.append(this.f4764e);
        if (this.f4765f) {
            sb.append("; secure");
        }
        if (this.f4766g) {
            sb.append("; httponly");
        }
        if (this.f4769j != null) {
            sb.append("; samesite=");
            sb.append(this.f4769j);
        }
        String sb2 = sb.toString();
        e3.f.d(sb2, "toString(...)");
        return sb2;
    }

    public final String g() {
        return this.f4761b;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int hashCode = (((((((((((((((((527 + this.f4760a.hashCode()) * 31) + this.f4761b.hashCode()) * 31) + Long.hashCode(this.f4762c)) * 31) + this.f4763d.hashCode()) * 31) + this.f4764e.hashCode()) * 31) + Boolean.hashCode(this.f4765f)) * 31) + Boolean.hashCode(this.f4766g)) * 31) + Boolean.hashCode(this.f4767h)) * 31) + Boolean.hashCode(this.f4768i)) * 31;
        String str = this.f4769j;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return f(false);
    }
}
