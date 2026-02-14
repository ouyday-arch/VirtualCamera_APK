package m3;

import b4.g0;
import j3.v;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import l3.b0;
import l3.c0;
import l3.d0;
import l3.s;
import l3.u;
import l3.y;
import v2.w;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final u f5209a = p.k();

    /* renamed from: b, reason: collision with root package name */
    public static final b0 f5210b = p.l();

    /* renamed from: c, reason: collision with root package name */
    public static final d0 f5211c = p.m();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeZone f5212d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f5213e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f5214f;

    static {
        String d02;
        String e02;
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        e3.f.b(timeZone);
        f5212d = timeZone;
        f5213e = false;
        String name = y.class.getName();
        e3.f.d(name, "getName(...)");
        d02 = v.d0(name, "okhttp3.");
        e02 = v.e0(d02, "Client");
        f5214f = e02;
    }

    public static final s.c c(final l3.s sVar) {
        e3.f.e(sVar, "<this>");
        return new s.c() { // from class: m3.r
            @Override // l3.s.c
            public final l3.s a(l3.e eVar) {
                l3.s d5;
                d5 = s.d(l3.s.this, eVar);
                return d5;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l3.s d(l3.s sVar, l3.e eVar) {
        e3.f.e(sVar, "$this_asFactory");
        e3.f.e(eVar, "it");
        return sVar;
    }

    public static final boolean e(l3.v vVar, l3.v vVar2) {
        e3.f.e(vVar, "<this>");
        e3.f.e(vVar2, "other");
        return e3.f.a(vVar.j(), vVar2.j()) && vVar.o() == vVar2.o() && e3.f.a(vVar.s(), vVar2.s());
    }

    public static final void f(Socket socket) {
        e3.f.e(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e4) {
            throw e4;
        } catch (RuntimeException e5) {
            if (!e3.f.a(e5.getMessage(), "bio == null")) {
                throw e5;
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean g(g0 g0Var, int i4, TimeUnit timeUnit) {
        e3.f.e(g0Var, "<this>");
        e3.f.e(timeUnit, "timeUnit");
        try {
            return m(g0Var, i4, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String h(String str, Object... objArr) {
        e3.f.e(str, "format");
        e3.f.e(objArr, "args");
        e3.n nVar = e3.n.f3633a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        e3.f.d(format, "format(...)");
        return format;
    }

    public static final long i(c0 c0Var) {
        e3.f.e(c0Var, "<this>");
        String a5 = c0Var.S().a("Content-Length");
        if (a5 != null) {
            return p.D(a5, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> j(T... tArr) {
        List l4;
        e3.f.e(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        l4 = v2.o.l(Arrays.copyOf(objArr, objArr.length));
        List<T> unmodifiableList = Collections.unmodifiableList(l4);
        e3.f.d(unmodifiableList, "unmodifiableList(...)");
        return unmodifiableList;
    }

    public static final boolean k(Socket socket, b4.f fVar) {
        e3.f.e(socket, "<this>");
        e3.f.e(fVar, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z4 = !fVar.z();
                socket.setSoTimeout(soTimeout);
                return z4;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final Charset l(b4.f fVar, Charset charset) {
        e3.f.e(fVar, "<this>");
        e3.f.e(charset, "default");
        int k4 = fVar.k(p.n());
        if (k4 == -1) {
            return charset;
        }
        if (k4 == 0) {
            return j3.d.f4249b;
        }
        if (k4 == 1) {
            return j3.d.f4251d;
        }
        if (k4 == 2) {
            return j3.d.f4252e;
        }
        if (k4 == 3) {
            return j3.d.f4248a.a();
        }
        if (k4 == 4) {
            return j3.d.f4248a.b();
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
    
        if (r5 == Long.MAX_VALUE) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
    
        r11.b().a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x007c, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        r11.b().d(r0 + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
    
        if (r5 != Long.MAX_VALUE) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean m(b4.g0 r11, int r12, java.util.concurrent.TimeUnit r13) {
        /*
            java.lang.String r0 = "<this>"
            e3.f.e(r11, r0)
            java.lang.String r0 = "timeUnit"
            e3.f.e(r13, r0)
            long r0 = java.lang.System.nanoTime()
            b4.h0 r2 = r11.b()
            boolean r2 = r2.e()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L27
            b4.h0 r2 = r11.b()
            long r5 = r2.c()
            long r5 = r5 - r0
            goto L28
        L27:
            r5 = r3
        L28:
            b4.h0 r2 = r11.b()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.d(r12)
            b4.d r12 = new b4.d     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L76
            r12.<init>()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L76
        L3e:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.u(r12, r7)     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L76
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L4e
            r12.I()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L76
            goto L3e
        L4e:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
        L53:
            b4.h0 r11 = r11.b()
            r11.a()
            goto L7c
        L5b:
            b4.h0 r11 = r11.b()
            long r0 = r0 + r5
            r11.d(r0)
            goto L7c
        L64:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            b4.h0 r11 = r11.b()
            if (r13 != 0) goto L71
            r11.a()
            goto L75
        L71:
            long r0 = r0 + r5
            r11.d(r0)
        L75:
            throw r12
        L76:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
            goto L53
        L7c:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.s.m(b4.g0, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static final ThreadFactory n(final String str, final boolean z4) {
        e3.f.e(str, "name");
        return new ThreadFactory() { // from class: m3.q
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread o4;
                o4 = s.o(str, z4, runnable);
                return o4;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread o(String str, boolean z4, Runnable runnable) {
        e3.f.e(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z4);
        return thread;
    }

    public static final List<t3.d> p(u uVar) {
        g3.f h4;
        int r4;
        e3.f.e(uVar, "<this>");
        h4 = g3.l.h(0, uVar.size());
        r4 = v2.p.r(h4, 10);
        ArrayList arrayList = new ArrayList(r4);
        Iterator<Integer> it = h4.iterator();
        while (it.hasNext()) {
            int a5 = ((v2.b0) it).a();
            arrayList.add(new t3.d(uVar.c(a5), uVar.e(a5)));
        }
        return arrayList;
    }

    public static final u q(List<t3.d> list) {
        e3.f.e(list, "<this>");
        u.a aVar = new u.a();
        for (t3.d dVar : list) {
            aVar.c(dVar.a().D(), dVar.b().D());
        }
        return aVar.d();
    }

    public static final String r(l3.v vVar, boolean z4) {
        boolean C;
        String j4;
        e3.f.e(vVar, "<this>");
        C = v.C(vVar.j(), ":", false, 2, null);
        if (C) {
            j4 = '[' + vVar.j() + ']';
        } else {
            j4 = vVar.j();
        }
        if (!z4 && vVar.o() == a.b(vVar.s())) {
            return j4;
        }
        return j4 + ':' + vVar.o();
    }

    public static /* synthetic */ String s(l3.v vVar, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = false;
        }
        return r(vVar, z4);
    }

    public static final <T> List<T> t(List<? extends T> list) {
        List P;
        e3.f.e(list, "<this>");
        P = w.P(list);
        List<T> unmodifiableList = Collections.unmodifiableList(P);
        e3.f.d(unmodifiableList, "unmodifiableList(...)");
        return unmodifiableList;
    }
}
