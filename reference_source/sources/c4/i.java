package c4;

import b4.j0;
import b4.t;
import b4.y;
import e3.j;
import e3.k;
import j3.u;
import j3.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import u2.l;
import v2.g0;
import v2.w;

/* loaded from: classes.dex */
public final class i {

    /* loaded from: classes.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t4, T t5) {
            int a5;
            a5 = x2.b.a(((h) t4).a(), ((h) t5).a());
            return a5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends e3.g implements d3.c<Integer, Long, l> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e3.h f2484c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f2485d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ j f2486e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b4.f f2487f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ j f2488g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ j f2489h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e3.h hVar, long j4, j jVar, b4.f fVar, j jVar2, j jVar3) {
            super(2);
            this.f2484c = hVar;
            this.f2485d = j4;
            this.f2486e = jVar;
            this.f2487f = fVar;
            this.f2488g = jVar2;
            this.f2489h = jVar3;
        }

        @Override // d3.c
        public /* bridge */ /* synthetic */ l a(Integer num, Long l4) {
            c(num.intValue(), l4.longValue());
            return l.f6223a;
        }

        public final void c(int i4, long j4) {
            if (i4 == 1) {
                e3.h hVar = this.f2484c;
                if (hVar.f3627b) {
                    throw new IOException("bad zip: zip64 extra repeated");
                }
                hVar.f3627b = true;
                if (j4 < this.f2485d) {
                    throw new IOException("bad zip: zip64 extra too short");
                }
                j jVar = this.f2486e;
                long j5 = jVar.f3629b;
                if (j5 == 4294967295L) {
                    j5 = this.f2487f.m();
                }
                jVar.f3629b = j5;
                j jVar2 = this.f2488g;
                jVar2.f3629b = jVar2.f3629b == 4294967295L ? this.f2487f.m() : 0L;
                j jVar3 = this.f2489h;
                jVar3.f3629b = jVar3.f3629b == 4294967295L ? this.f2487f.m() : 0L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends e3.g implements d3.c<Integer, Long, l> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b4.f f2490c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k<Long> f2491d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k<Long> f2492e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ k<Long> f2493f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(b4.f fVar, k<Long> kVar, k<Long> kVar2, k<Long> kVar3) {
            super(2);
            this.f2490c = fVar;
            this.f2491d = kVar;
            this.f2492e = kVar2;
            this.f2493f = kVar3;
        }

        @Override // d3.c
        public /* bridge */ /* synthetic */ l a(Integer num, Long l4) {
            c(num.intValue(), l4.longValue());
            return l.f6223a;
        }

        /* JADX WARN: Type inference failed for: r0v13, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r10v12, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r11v3, types: [T, java.lang.Long] */
        public final void c(int i4, long j4) {
            if (i4 == 21589) {
                if (j4 < 1) {
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
                int H = this.f2490c.H() & 255;
                boolean z4 = (H & 1) == 1;
                boolean z5 = (H & 2) == 2;
                boolean z6 = (H & 4) == 4;
                b4.f fVar = this.f2490c;
                long j5 = z4 ? 5L : 1L;
                if (z5) {
                    j5 += 4;
                }
                if (z6) {
                    j5 += 4;
                }
                if (j4 < j5) {
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
                if (z4) {
                    this.f2491d.f3630b = Long.valueOf(fVar.y() * 1000);
                }
                if (z5) {
                    this.f2492e.f3630b = Long.valueOf(this.f2490c.y() * 1000);
                }
                if (z6) {
                    this.f2493f.f3630b = Long.valueOf(this.f2490c.y() * 1000);
                }
            }
        }
    }

    private static final Map<y, h> a(List<h> list) {
        Map<y, h> d5;
        List<h> K;
        y d6 = y.a.d(y.f2393c, "/", false, 1, null);
        d5 = g0.d(u2.i.a(d6, new h(d6, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        K = w.K(list, new a());
        for (h hVar : K) {
            if (d5.put(hVar.a(), hVar) == null) {
                while (true) {
                    y h4 = hVar.a().h();
                    if (h4 != null) {
                        h hVar2 = d5.get(h4);
                        if (hVar2 != null) {
                            hVar2.b().add(hVar.a());
                            break;
                        }
                        h hVar3 = new h(h4, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        d5.put(h4, hVar3);
                        hVar3.b().add(hVar.a());
                        hVar = hVar3;
                    }
                }
            }
        }
        return d5;
    }

    private static final Long b(int i4, int i5) {
        if (i5 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i4 >> 9) & 127) + 1980, ((i4 >> 5) & 15) - 1, i4 & 31, (i5 >> 11) & 31, (i5 >> 5) & 63, (i5 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String c(int i4) {
        int a5;
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        a5 = j3.b.a(16);
        String num = Integer.toString(i4, a5);
        e3.f.d(num, "toString(...)");
        sb.append(num);
        return sb.toString();
    }

    public static final j0 d(y yVar, b4.j jVar, d3.b<? super h, Boolean> bVar) {
        b4.f b5;
        e3.f.e(yVar, "zipPath");
        e3.f.e(jVar, "fileSystem");
        e3.f.e(bVar, "predicate");
        b4.h a5 = jVar.a(yVar);
        try {
            long Q = a5.Q() - 22;
            if (Q < 0) {
                throw new IOException("not a zip: size=" + a5.Q());
            }
            long max = Math.max(Q - 65536, 0L);
            do {
                b4.f b6 = t.b(a5.R(Q));
                try {
                    if (b6.y() == 101010256) {
                        e f4 = f(b6);
                        String e4 = b6.e(f4.b());
                        b6.close();
                        long j4 = Q - 20;
                        if (j4 > 0) {
                            b5 = t.b(a5.R(j4));
                            try {
                                if (b5.y() == 117853008) {
                                    int y4 = b5.y();
                                    long m4 = b5.m();
                                    if (b5.y() != 1 || y4 != 0) {
                                        throw new IOException("unsupported zip: spanned");
                                    }
                                    b5 = t.b(a5.R(m4));
                                    try {
                                        int y5 = b5.y();
                                        if (y5 != 101075792) {
                                            throw new IOException("bad zip: expected " + c(101075792) + " but was " + c(y5));
                                        }
                                        f4 = i(b5, f4);
                                        l lVar = l.f6223a;
                                        c3.a.a(b5, null);
                                    } finally {
                                    }
                                }
                                l lVar2 = l.f6223a;
                                c3.a.a(b5, null);
                            } finally {
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        b5 = t.b(a5.R(f4.a()));
                        try {
                            long c5 = f4.c();
                            for (long j5 = 0; j5 < c5; j5++) {
                                h e5 = e(b5);
                                if (e5.e() >= f4.a()) {
                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                }
                                if (bVar.b(e5).booleanValue()) {
                                    arrayList.add(e5);
                                }
                            }
                            l lVar3 = l.f6223a;
                            c3.a.a(b5, null);
                            j0 j0Var = new j0(yVar, jVar, a(arrayList), e4);
                            c3.a.a(a5, null);
                            return j0Var;
                        } finally {
                            try {
                                throw th;
                            } finally {
                                c3.a.a(b5, th);
                            }
                        }
                    }
                    b6.close();
                    Q--;
                } catch (Throwable th) {
                    b6.close();
                    throw th;
                }
            } while (Q >= max);
            throw new IOException("not a zip: end of central directory signature not found");
        } finally {
        }
    }

    public static final h e(b4.f fVar) {
        boolean B;
        j jVar;
        long j4;
        boolean k4;
        e3.f.e(fVar, "<this>");
        int y4 = fVar.y();
        if (y4 != 33639248) {
            throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(y4));
        }
        fVar.o(4L);
        int f4 = fVar.f() & 65535;
        if ((f4 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(f4));
        }
        int f5 = fVar.f() & 65535;
        Long b5 = b(fVar.f() & 65535, fVar.f() & 65535);
        long y5 = fVar.y() & 4294967295L;
        j jVar2 = new j();
        jVar2.f3629b = fVar.y() & 4294967295L;
        j jVar3 = new j();
        jVar3.f3629b = fVar.y() & 4294967295L;
        int f6 = fVar.f() & 65535;
        int f7 = fVar.f() & 65535;
        int f8 = fVar.f() & 65535;
        fVar.o(8L);
        j jVar4 = new j();
        jVar4.f3629b = fVar.y() & 4294967295L;
        String e4 = fVar.e(f6);
        B = v.B(e4, (char) 0, false, 2, null);
        if (B) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        if (jVar3.f3629b == 4294967295L) {
            j4 = 8 + 0;
            jVar = jVar4;
        } else {
            jVar = jVar4;
            j4 = 0;
        }
        if (jVar2.f3629b == 4294967295L) {
            j4 += 8;
        }
        j jVar5 = jVar;
        if (jVar5.f3629b == 4294967295L) {
            j4 += 8;
        }
        long j5 = j4;
        e3.h hVar = new e3.h();
        g(fVar, f7, new b(hVar, j5, jVar3, fVar, jVar2, jVar5));
        if (j5 > 0 && !hVar.f3627b) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String e5 = fVar.e(f8);
        y k5 = y.a.d(y.f2393c, "/", false, 1, null).k(e4);
        k4 = u.k(e4, "/", false, 2, null);
        return new h(k5, k4, e5, y5, jVar2.f3629b, jVar3.f3629b, f5, b5, jVar5.f3629b);
    }

    private static final e f(b4.f fVar) {
        int f4 = fVar.f() & 65535;
        int f5 = fVar.f() & 65535;
        long f6 = fVar.f() & 65535;
        if (f6 != (fVar.f() & 65535) || f4 != 0 || f5 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        fVar.o(4L);
        return new e(f6, 4294967295L & fVar.y(), fVar.f() & 65535);
    }

    private static final void g(b4.f fVar, int i4, d3.c<? super Integer, ? super Long, l> cVar) {
        long j4 = i4;
        while (j4 != 0) {
            if (j4 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int f4 = fVar.f() & 65535;
            long f5 = fVar.f() & 65535;
            long j5 = j4 - 4;
            if (j5 < f5) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            fVar.w(f5);
            long c02 = fVar.a().c0();
            cVar.a(Integer.valueOf(f4), Long.valueOf(f5));
            long c03 = (fVar.a().c0() + f5) - c02;
            if (c03 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + f4);
            }
            if (c03 > 0) {
                fVar.a().o(c03);
            }
            j4 = j5 - f5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final b4.i h(b4.f fVar, b4.i iVar) {
        k kVar = new k();
        kVar.f3630b = iVar != null ? iVar.a() : 0;
        k kVar2 = new k();
        k kVar3 = new k();
        int y4 = fVar.y();
        if (y4 != 67324752) {
            throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(y4));
        }
        fVar.o(2L);
        int f4 = fVar.f() & 65535;
        if ((f4 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(f4));
        }
        fVar.o(18L);
        int f5 = fVar.f() & 65535;
        fVar.o(fVar.f() & 65535);
        if (iVar == null) {
            fVar.o(f5);
            return null;
        }
        g(fVar, f5, new c(fVar, kVar, kVar2, kVar3));
        return new b4.i(iVar.d(), iVar.c(), null, iVar.b(), (Long) kVar3.f3630b, (Long) kVar.f3630b, (Long) kVar2.f3630b, null, 128, null);
    }

    private static final e i(b4.f fVar, e eVar) {
        fVar.o(12L);
        int y4 = fVar.y();
        int y5 = fVar.y();
        long m4 = fVar.m();
        if (m4 != fVar.m() || y4 != 0 || y5 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        fVar.o(8L);
        return new e(m4, fVar.m(), eVar.b());
    }

    public static final void j(b4.f fVar) {
        e3.f.e(fVar, "<this>");
        h(fVar, null);
    }
}
