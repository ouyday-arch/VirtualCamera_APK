package z3;

import b4.j;
import b4.t;
import b4.y;
import e3.d;
import e3.f;
import i3.c;
import i3.i;
import j3.v;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import m3.p;
import u2.l;
import v2.n;
import v2.w;
import w3.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final C0101a f6693g = new C0101a(null);

    /* renamed from: h, reason: collision with root package name */
    public static final y f6694h = y.a.d(y.f2393c, "/okhttp3/internal/publicsuffix/" + a.class.getSimpleName() + ".gz", false, 1, null);

    /* renamed from: i, reason: collision with root package name */
    private static final byte[] f6695i = {42};

    /* renamed from: j, reason: collision with root package name */
    private static final List<String> f6696j;

    /* renamed from: k, reason: collision with root package name */
    private static final a f6697k;

    /* renamed from: a, reason: collision with root package name */
    private final y f6698a;

    /* renamed from: b, reason: collision with root package name */
    private final j f6699b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f6700c;

    /* renamed from: d, reason: collision with root package name */
    private final CountDownLatch f6701d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f6702e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f6703f;

    /* renamed from: z3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0101a {
        private C0101a() {
        }

        public /* synthetic */ C0101a(d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(byte[] bArr, byte[][] bArr2, int i4) {
            int i5;
            boolean z4;
            int b5;
            int b6;
            int length = bArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = (i6 + length) / 2;
                while (i7 > -1 && bArr[i7] != 10) {
                    i7--;
                }
                int i8 = i7 + 1;
                int i9 = 1;
                while (true) {
                    i5 = i8 + i9;
                    if (bArr[i5] == 10) {
                        break;
                    }
                    i9++;
                }
                int i10 = i5 - i8;
                int i11 = i4;
                boolean z5 = false;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    if (z5) {
                        b5 = 46;
                        z4 = false;
                    } else {
                        z4 = z5;
                        b5 = p.b(bArr2[i11][i12], 255);
                    }
                    b6 = b5 - p.b(bArr[i8 + i13], 255);
                    if (b6 != 0) {
                        break;
                    }
                    i13++;
                    i12++;
                    if (i13 == i10) {
                        break;
                    }
                    if (bArr2[i11].length != i12) {
                        z5 = z4;
                    } else {
                        if (i11 == bArr2.length - 1) {
                            break;
                        }
                        i11++;
                        i12 = -1;
                        z5 = true;
                    }
                }
                if (b6 >= 0) {
                    if (b6 <= 0) {
                        int i14 = i10 - i13;
                        int length2 = bArr2[i11].length - i12;
                        int length3 = bArr2.length;
                        for (int i15 = i11 + 1; i15 < length3; i15++) {
                            length2 += bArr2[i15].length;
                        }
                        if (length2 >= i14) {
                            if (length2 <= i14) {
                                return new String(bArr, i8, i10, j3.d.f4249b);
                            }
                        }
                    }
                    i6 = i5 + 1;
                }
                length = i8 - 1;
            }
            return null;
        }

        public final a c() {
            return a.f6697k;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List<String> d5;
        d5 = n.d("*");
        f6696j = d5;
        f6697k = new a(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public a(y yVar, j jVar) {
        f.e(yVar, "path");
        f.e(jVar, "fileSystem");
        this.f6698a = yVar;
        this.f6699b = jVar;
        this.f6700c = new AtomicBoolean(false);
        this.f6701d = new CountDownLatch(1);
    }

    public /* synthetic */ a(y yVar, j jVar, int i4, d dVar) {
        this((i4 & 1) != 0 ? f6694h : yVar, (i4 & 2) != 0 ? j.f2365d : jVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d9, code lost:
    
        r4 = j3.v.i0(r8, new char[]{'.'}, false, 0, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ef, code lost:
    
        r1 = j3.v.i0(r5, new char[]{'.'}, false, 0, 6, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<java.lang.String> b(java.util.List<java.lang.String> r18) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.a.b(java.util.List):java.util.List");
    }

    private final void d() {
        try {
            b4.f b5 = t.b(new b4.n(this.f6699b.b(this.f6698a)));
            try {
                byte[] C = b5.C(b5.s());
                byte[] C2 = b5.C(b5.s());
                l lVar = l.f6223a;
                c3.a.a(b5, null);
                synchronized (this) {
                    f.b(C);
                    this.f6702e = C;
                    f.b(C2);
                    this.f6703f = C2;
                }
            } finally {
            }
        } finally {
            this.f6701d.countDown();
        }
    }

    private final void e() {
        boolean z4 = false;
        while (true) {
            try {
                try {
                    d();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z4 = true;
                } catch (IOException e4) {
                    h.f6456a.g().j("Failed to read public suffix list", 5, e4);
                    if (z4) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> f(String str) {
        List<String> i02;
        Object F;
        List<String> y4;
        i02 = v.i0(str, new char[]{'.'}, false, 0, 6, null);
        F = w.F(i02);
        if (!f.a(F, "")) {
            return i02;
        }
        y4 = w.y(i02, 1);
        return y4;
    }

    public final String c(String str) {
        c x4;
        c b5;
        String e4;
        f.e(str, "domain");
        String unicode = IDN.toUnicode(str);
        f.b(unicode);
        List<String> f4 = f(unicode);
        List<String> b6 = b(f4);
        if (f4.size() == b6.size() && b6.get(0).charAt(0) != '!') {
            return null;
        }
        char charAt = b6.get(0).charAt(0);
        int size = f4.size();
        int size2 = b6.size();
        if (charAt != '!') {
            size2++;
        }
        x4 = w.x(f(str));
        b5 = i.b(x4, size - size2);
        e4 = i.e(b5, ".", null, null, 0, null, null, 62, null);
        return e4;
    }
}
