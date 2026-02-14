package o3;

import e3.d;
import e3.f;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import l3.a0;
import l3.c0;
import l3.u;
import m3.p;
import r3.c;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f5379c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final a0 f5380a;

    /* renamed from: b, reason: collision with root package name */
    private final c0 f5381b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d dVar) {
            this();
        }

        public final boolean a(c0 c0Var, a0 a0Var) {
            f.e(c0Var, "response");
            f.e(a0Var, "request");
            int M = c0Var.M();
            if (M != 200 && M != 410 && M != 414 && M != 501 && M != 203 && M != 204) {
                if (M != 307) {
                    if (M != 308 && M != 404 && M != 405) {
                        switch (M) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (c0.R(c0Var, "Expires", null, 2, null) == null && c0Var.J().e() == -1 && !c0Var.J().d() && !c0Var.J().c()) {
                    return false;
                }
            }
            return (c0Var.J().j() || a0Var.b().j()) ? false : true;
        }
    }

    /* renamed from: o3.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0064b {

        /* renamed from: a, reason: collision with root package name */
        private final long f5382a;

        /* renamed from: b, reason: collision with root package name */
        private final a0 f5383b;

        /* renamed from: c, reason: collision with root package name */
        private final c0 f5384c;

        /* renamed from: d, reason: collision with root package name */
        private Date f5385d;

        /* renamed from: e, reason: collision with root package name */
        private String f5386e;

        /* renamed from: f, reason: collision with root package name */
        private Date f5387f;

        /* renamed from: g, reason: collision with root package name */
        private String f5388g;

        /* renamed from: h, reason: collision with root package name */
        private Date f5389h;

        /* renamed from: i, reason: collision with root package name */
        private long f5390i;

        /* renamed from: j, reason: collision with root package name */
        private long f5391j;

        /* renamed from: k, reason: collision with root package name */
        private String f5392k;

        /* renamed from: l, reason: collision with root package name */
        private int f5393l;

        public C0064b(long j4, a0 a0Var, c0 c0Var) {
            boolean l4;
            boolean l5;
            boolean l6;
            boolean l7;
            boolean l8;
            f.e(a0Var, "request");
            this.f5382a = j4;
            this.f5383b = a0Var;
            this.f5384c = c0Var;
            this.f5393l = -1;
            if (c0Var != null) {
                this.f5390i = c0Var.a0();
                this.f5391j = c0Var.Y();
                u S = c0Var.S();
                int size = S.size();
                for (int i4 = 0; i4 < size; i4++) {
                    String c5 = S.c(i4);
                    String e4 = S.e(i4);
                    l4 = j3.u.l(c5, "Date", true);
                    if (l4) {
                        this.f5385d = c.a(e4);
                        this.f5386e = e4;
                    } else {
                        l5 = j3.u.l(c5, "Expires", true);
                        if (l5) {
                            this.f5389h = c.a(e4);
                        } else {
                            l6 = j3.u.l(c5, "Last-Modified", true);
                            if (l6) {
                                this.f5387f = c.a(e4);
                                this.f5388g = e4;
                            } else {
                                l7 = j3.u.l(c5, "ETag", true);
                                if (l7) {
                                    this.f5392k = e4;
                                } else {
                                    l8 = j3.u.l(c5, "Age", true);
                                    if (l8) {
                                        this.f5393l = p.E(e4, -1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        private final long a() {
            Date date = this.f5385d;
            long max = date != null ? Math.max(0L, this.f5391j - date.getTime()) : 0L;
            int i4 = this.f5393l;
            if (i4 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i4));
            }
            return max + Math.max(0L, this.f5391j - this.f5390i) + Math.max(0L, this.f5382a - this.f5391j);
        }

        private final b c() {
            if (this.f5384c == null) {
                return new b(this.f5383b, null);
            }
            if ((!this.f5383b.f() || this.f5384c.P() != null) && b.f5379c.a(this.f5384c, this.f5383b)) {
                l3.d b5 = this.f5383b.b();
                if (b5.i() || e(this.f5383b)) {
                    return new b(this.f5383b, null);
                }
                l3.d J = this.f5384c.J();
                long a5 = a();
                long d5 = d();
                if (b5.e() != -1) {
                    d5 = Math.min(d5, TimeUnit.SECONDS.toMillis(b5.e()));
                }
                long j4 = 0;
                long millis = b5.g() != -1 ? TimeUnit.SECONDS.toMillis(b5.g()) : 0L;
                if (!J.h() && b5.f() != -1) {
                    j4 = TimeUnit.SECONDS.toMillis(b5.f());
                }
                if (!J.i()) {
                    long j5 = millis + a5;
                    if (j5 < j4 + d5) {
                        c0.a V = this.f5384c.V();
                        if (j5 >= d5) {
                            V.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (a5 > 86400000 && f()) {
                            V.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new b(null, V.c());
                    }
                }
                String str = this.f5392k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f5387f != null) {
                    str = this.f5388g;
                } else {
                    if (this.f5385d == null) {
                        return new b(this.f5383b, null);
                    }
                    str = this.f5386e;
                }
                u.a d6 = this.f5383b.e().d();
                f.b(str);
                d6.c(str2, str);
                return new b(this.f5383b.h().i(d6.d()).b(), this.f5384c);
            }
            return new b(this.f5383b, null);
        }

        private final long d() {
            c0 c0Var = this.f5384c;
            f.b(c0Var);
            if (c0Var.J().e() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.e());
            }
            Date date = this.f5389h;
            if (date != null) {
                Date date2 = this.f5385d;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.f5391j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f5387f == null || this.f5384c.Z().i().p() != null) {
                return 0L;
            }
            Date date3 = this.f5385d;
            long time2 = date3 != null ? date3.getTime() : this.f5390i;
            Date date4 = this.f5387f;
            f.b(date4);
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / 10;
            }
            return 0L;
        }

        private final boolean e(a0 a0Var) {
            return (a0Var.d("If-Modified-Since") == null && a0Var.d("If-None-Match") == null) ? false : true;
        }

        private final boolean f() {
            c0 c0Var = this.f5384c;
            f.b(c0Var);
            return c0Var.J().e() == -1 && this.f5389h == null;
        }

        public final b b() {
            b c5 = c();
            return (c5.b() == null || !this.f5383b.b().l()) ? c5 : new b(null, null);
        }
    }

    public b(a0 a0Var, c0 c0Var) {
        this.f5380a = a0Var;
        this.f5381b = c0Var;
    }

    public final c0 a() {
        return this.f5381b;
    }

    public final a0 b() {
        return this.f5380a;
    }
}
