package t3;

import b4.g0;
import b4.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import m3.p;
import v2.w;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f6036a;

    /* renamed from: b, reason: collision with root package name */
    private static final d[] f6037b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<b4.g, Integer> f6038c;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f6039a;

        /* renamed from: b, reason: collision with root package name */
        private int f6040b;

        /* renamed from: c, reason: collision with root package name */
        private final List<d> f6041c;

        /* renamed from: d, reason: collision with root package name */
        private final b4.f f6042d;

        /* renamed from: e, reason: collision with root package name */
        public d[] f6043e;

        /* renamed from: f, reason: collision with root package name */
        private int f6044f;

        /* renamed from: g, reason: collision with root package name */
        public int f6045g;

        /* renamed from: h, reason: collision with root package name */
        public int f6046h;

        public a(g0 g0Var, int i4, int i5) {
            e3.f.e(g0Var, "source");
            this.f6039a = i4;
            this.f6040b = i5;
            this.f6041c = new ArrayList();
            this.f6042d = t.b(g0Var);
            this.f6043e = new d[8];
            this.f6044f = r2.length - 1;
        }

        public /* synthetic */ a(g0 g0Var, int i4, int i5, int i6, e3.d dVar) {
            this(g0Var, i4, (i6 & 4) != 0 ? i4 : i5);
        }

        private final void a() {
            int i4 = this.f6040b;
            int i5 = this.f6046h;
            if (i4 < i5) {
                if (i4 == 0) {
                    b();
                } else {
                    d(i5 - i4);
                }
            }
        }

        private final void b() {
            v2.i.l(this.f6043e, null, 0, 0, 6, null);
            this.f6044f = this.f6043e.length - 1;
            this.f6045g = 0;
            this.f6046h = 0;
        }

        private final int c(int i4) {
            return this.f6044f + 1 + i4;
        }

        private final int d(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.f6043e.length;
                while (true) {
                    length--;
                    i5 = this.f6044f;
                    if (length < i5 || i4 <= 0) {
                        break;
                    }
                    d dVar = this.f6043e[length];
                    e3.f.b(dVar);
                    int i7 = dVar.f6035c;
                    i4 -= i7;
                    this.f6046h -= i7;
                    this.f6045g--;
                    i6++;
                }
                d[] dVarArr = this.f6043e;
                System.arraycopy(dVarArr, i5 + 1, dVarArr, i5 + 1 + i6, this.f6045g);
                this.f6044f += i6;
            }
            return i6;
        }

        private final b4.g f(int i4) {
            d dVar;
            if (!h(i4)) {
                int c5 = c(i4 - e.f6036a.c().length);
                if (c5 >= 0) {
                    d[] dVarArr = this.f6043e;
                    if (c5 < dVarArr.length) {
                        dVar = dVarArr[c5];
                        e3.f.b(dVar);
                    }
                }
                throw new IOException("Header index too large " + (i4 + 1));
            }
            dVar = e.f6036a.c()[i4];
            return dVar.f6033a;
        }

        private final void g(int i4, d dVar) {
            this.f6041c.add(dVar);
            int i5 = dVar.f6035c;
            if (i4 != -1) {
                d dVar2 = this.f6043e[c(i4)];
                e3.f.b(dVar2);
                i5 -= dVar2.f6035c;
            }
            int i6 = this.f6040b;
            if (i5 > i6) {
                b();
                return;
            }
            int d5 = d((this.f6046h + i5) - i6);
            if (i4 == -1) {
                int i7 = this.f6045g + 1;
                d[] dVarArr = this.f6043e;
                if (i7 > dVarArr.length) {
                    d[] dVarArr2 = new d[dVarArr.length * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    this.f6044f = this.f6043e.length - 1;
                    this.f6043e = dVarArr2;
                }
                int i8 = this.f6044f;
                this.f6044f = i8 - 1;
                this.f6043e[i8] = dVar;
                this.f6045g++;
            } else {
                this.f6043e[i4 + c(i4) + d5] = dVar;
            }
            this.f6046h += i5;
        }

        private final boolean h(int i4) {
            return i4 >= 0 && i4 <= e.f6036a.c().length - 1;
        }

        private final int i() {
            return p.b(this.f6042d.H(), 255);
        }

        private final void l(int i4) {
            if (h(i4)) {
                this.f6041c.add(e.f6036a.c()[i4]);
                return;
            }
            int c5 = c(i4 - e.f6036a.c().length);
            if (c5 >= 0) {
                d[] dVarArr = this.f6043e;
                if (c5 < dVarArr.length) {
                    List<d> list = this.f6041c;
                    d dVar = dVarArr[c5];
                    e3.f.b(dVar);
                    list.add(dVar);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        private final void n(int i4) {
            g(-1, new d(f(i4), j()));
        }

        private final void o() {
            g(-1, new d(e.f6036a.a(j()), j()));
        }

        private final void p(int i4) {
            this.f6041c.add(new d(f(i4), j()));
        }

        private final void q() {
            this.f6041c.add(new d(e.f6036a.a(j()), j()));
        }

        public final List<d> e() {
            List<d> N;
            N = w.N(this.f6041c);
            this.f6041c.clear();
            return N;
        }

        public final b4.g j() {
            int i4 = i();
            boolean z4 = (i4 & 128) == 128;
            long m4 = m(i4, 127);
            if (!z4) {
                return this.f6042d.l(m4);
            }
            b4.d dVar = new b4.d();
            l.f6192a.b(this.f6042d, m4, dVar);
            return dVar.V();
        }

        public final void k() {
            while (!this.f6042d.z()) {
                int b5 = p.b(this.f6042d.H(), 255);
                if (b5 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b5 & 128) == 128) {
                    l(m(b5, 127) - 1);
                } else if (b5 == 64) {
                    o();
                } else if ((b5 & 64) == 64) {
                    n(m(b5, 63) - 1);
                } else if ((b5 & 32) == 32) {
                    int m4 = m(b5, 31);
                    this.f6040b = m4;
                    if (m4 < 0 || m4 > this.f6039a) {
                        throw new IOException("Invalid dynamic table size update " + this.f6040b);
                    }
                    a();
                } else if (b5 == 16 || b5 == 0) {
                    q();
                } else {
                    p(m(b5, 15) - 1);
                }
            }
        }

        public final int m(int i4, int i5) {
            int i6 = i4 & i5;
            if (i6 < i5) {
                return i6;
            }
            int i7 = 0;
            while (true) {
                int i8 = i();
                if ((i8 & 128) == 0) {
                    return i5 + (i8 << i7);
                }
                i5 += (i8 & 127) << i7;
                i7 += 7;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f6047a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f6048b;

        /* renamed from: c, reason: collision with root package name */
        private final b4.d f6049c;

        /* renamed from: d, reason: collision with root package name */
        private int f6050d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f6051e;

        /* renamed from: f, reason: collision with root package name */
        public int f6052f;

        /* renamed from: g, reason: collision with root package name */
        public d[] f6053g;

        /* renamed from: h, reason: collision with root package name */
        private int f6054h;

        /* renamed from: i, reason: collision with root package name */
        public int f6055i;

        /* renamed from: j, reason: collision with root package name */
        public int f6056j;

        public b(int i4, boolean z4, b4.d dVar) {
            e3.f.e(dVar, "out");
            this.f6047a = i4;
            this.f6048b = z4;
            this.f6049c = dVar;
            this.f6050d = Integer.MAX_VALUE;
            this.f6052f = i4;
            this.f6053g = new d[8];
            this.f6054h = r2.length - 1;
        }

        public /* synthetic */ b(int i4, boolean z4, b4.d dVar, int i5, e3.d dVar2) {
            this((i5 & 1) != 0 ? 4096 : i4, (i5 & 2) != 0 ? true : z4, dVar);
        }

        private final void a() {
            int i4 = this.f6052f;
            int i5 = this.f6056j;
            if (i4 < i5) {
                if (i4 == 0) {
                    b();
                } else {
                    c(i5 - i4);
                }
            }
        }

        private final void b() {
            v2.i.l(this.f6053g, null, 0, 0, 6, null);
            this.f6054h = this.f6053g.length - 1;
            this.f6055i = 0;
            this.f6056j = 0;
        }

        private final int c(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.f6053g.length;
                while (true) {
                    length--;
                    i5 = this.f6054h;
                    if (length < i5 || i4 <= 0) {
                        break;
                    }
                    d dVar = this.f6053g[length];
                    e3.f.b(dVar);
                    i4 -= dVar.f6035c;
                    int i7 = this.f6056j;
                    d dVar2 = this.f6053g[length];
                    e3.f.b(dVar2);
                    this.f6056j = i7 - dVar2.f6035c;
                    this.f6055i--;
                    i6++;
                }
                d[] dVarArr = this.f6053g;
                System.arraycopy(dVarArr, i5 + 1, dVarArr, i5 + 1 + i6, this.f6055i);
                d[] dVarArr2 = this.f6053g;
                int i8 = this.f6054h;
                Arrays.fill(dVarArr2, i8 + 1, i8 + 1 + i6, (Object) null);
                this.f6054h += i6;
            }
            return i6;
        }

        private final void d(d dVar) {
            int i4 = dVar.f6035c;
            int i5 = this.f6052f;
            if (i4 > i5) {
                b();
                return;
            }
            c((this.f6056j + i4) - i5);
            int i6 = this.f6055i + 1;
            d[] dVarArr = this.f6053g;
            if (i6 > dVarArr.length) {
                d[] dVarArr2 = new d[dVarArr.length * 2];
                System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                this.f6054h = this.f6053g.length - 1;
                this.f6053g = dVarArr2;
            }
            int i7 = this.f6054h;
            this.f6054h = i7 - 1;
            this.f6053g[i7] = dVar;
            this.f6055i++;
            this.f6056j += i4;
        }

        public final void e(int i4) {
            this.f6047a = i4;
            int min = Math.min(i4, 16384);
            int i5 = this.f6052f;
            if (i5 == min) {
                return;
            }
            if (min < i5) {
                this.f6050d = Math.min(this.f6050d, min);
            }
            this.f6051e = true;
            this.f6052f = min;
            a();
        }

        public final void f(b4.g gVar) {
            int y4;
            int i4;
            e3.f.e(gVar, "data");
            if (this.f6048b) {
                l lVar = l.f6192a;
                if (lVar.d(gVar) < gVar.y()) {
                    b4.d dVar = new b4.d();
                    lVar.c(gVar, dVar);
                    gVar = dVar.V();
                    y4 = gVar.y();
                    i4 = 128;
                    h(y4, 127, i4);
                    this.f6049c.A(gVar);
                }
            }
            y4 = gVar.y();
            i4 = 0;
            h(y4, 127, i4);
            this.f6049c.A(gVar);
        }

        public final void g(List<d> list) {
            int i4;
            int i5;
            e3.f.e(list, "headerBlock");
            if (this.f6051e) {
                int i6 = this.f6050d;
                if (i6 < this.f6052f) {
                    h(i6, 31, 32);
                }
                this.f6051e = false;
                this.f6050d = Integer.MAX_VALUE;
                h(this.f6052f, 31, 32);
            }
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                d dVar = list.get(i7);
                b4.g C = dVar.f6033a.C();
                b4.g gVar = dVar.f6034b;
                e eVar = e.f6036a;
                Integer num = eVar.b().get(C);
                if (num != null) {
                    i5 = num.intValue() + 1;
                    if (2 <= i5 && i5 < 8) {
                        if (e3.f.a(eVar.c()[i5 - 1].f6034b, gVar)) {
                            i4 = i5;
                        } else if (e3.f.a(eVar.c()[i5].f6034b, gVar)) {
                            i5++;
                            i4 = i5;
                        }
                    }
                    i4 = i5;
                    i5 = -1;
                } else {
                    i4 = -1;
                    i5 = -1;
                }
                if (i5 == -1) {
                    int i8 = this.f6054h + 1;
                    int length = this.f6053g.length;
                    while (true) {
                        if (i8 >= length) {
                            break;
                        }
                        d dVar2 = this.f6053g[i8];
                        e3.f.b(dVar2);
                        if (e3.f.a(dVar2.f6033a, C)) {
                            d dVar3 = this.f6053g[i8];
                            e3.f.b(dVar3);
                            if (e3.f.a(dVar3.f6034b, gVar)) {
                                i5 = e.f6036a.c().length + (i8 - this.f6054h);
                                break;
                            } else if (i4 == -1) {
                                i4 = (i8 - this.f6054h) + e.f6036a.c().length;
                            }
                        }
                        i8++;
                    }
                }
                if (i5 != -1) {
                    h(i5, 127, 128);
                } else {
                    if (i4 == -1) {
                        this.f6049c.B(64);
                        f(C);
                    } else if (!C.z(d.f6027e) || e3.f.a(d.f6032j, C)) {
                        h(i4, 63, 64);
                    } else {
                        h(i4, 15, 0);
                        f(gVar);
                    }
                    f(gVar);
                    d(dVar);
                }
            }
        }

        public final void h(int i4, int i5, int i6) {
            int i7;
            b4.d dVar;
            if (i4 < i5) {
                dVar = this.f6049c;
                i7 = i4 | i6;
            } else {
                this.f6049c.B(i6 | i5);
                i7 = i4 - i5;
                while (i7 >= 128) {
                    this.f6049c.B(128 | (i7 & 127));
                    i7 >>>= 7;
                }
                dVar = this.f6049c;
            }
            dVar.B(i7);
        }
    }

    static {
        e eVar = new e();
        f6036a = eVar;
        b4.g gVar = d.f6029g;
        b4.g gVar2 = d.f6030h;
        b4.g gVar3 = d.f6031i;
        b4.g gVar4 = d.f6028f;
        f6037b = new d[]{new d(d.f6032j, ""), new d(gVar, "GET"), new d(gVar, "POST"), new d(gVar2, "/"), new d(gVar2, "/index.html"), new d(gVar3, "http"), new d(gVar3, "https"), new d(gVar4, "200"), new d(gVar4, "204"), new d(gVar4, "206"), new d(gVar4, "304"), new d(gVar4, "400"), new d(gVar4, "404"), new d(gVar4, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d("from", ""), new d("host", ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d("location", ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
        f6038c = eVar.d();
    }

    private e() {
    }

    private final Map<b4.g, Integer> d() {
        d[] dVarArr = f6037b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(dVarArr.length);
        int length = dVarArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            d[] dVarArr2 = f6037b;
            if (!linkedHashMap.containsKey(dVarArr2[i4].f6033a)) {
                linkedHashMap.put(dVarArr2[i4].f6033a, Integer.valueOf(i4));
            }
        }
        Map<b4.g, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        e3.f.d(unmodifiableMap, "unmodifiableMap(...)");
        return unmodifiableMap;
    }

    public final b4.g a(b4.g gVar) {
        e3.f.e(gVar, "name");
        int y4 = gVar.y();
        for (int i4 = 0; i4 < y4; i4++) {
            byte e4 = gVar.e(i4);
            if (65 <= e4 && e4 < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + gVar.D());
            }
        }
        return gVar;
    }

    public final Map<b4.g, Integer> b() {
        return f6038c;
    }

    public final d[] c() {
        return f6037b;
    }
}
