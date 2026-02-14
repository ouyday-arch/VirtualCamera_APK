package b4;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes.dex */
public class g implements Serializable, Comparable<g> {

    /* renamed from: e */
    public static final a f2337e = new a(null);

    /* renamed from: f */
    public static final g f2338f = new g(new byte[0]);

    /* renamed from: b */
    private final byte[] f2339b;

    /* renamed from: c */
    private transient int f2340c;

    /* renamed from: d */
    private transient String f2341d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public static /* synthetic */ g e(a aVar, byte[] bArr, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i4 = 0;
            }
            if ((i6 & 2) != 0) {
                i5 = b.c();
            }
            return aVar.d(bArr, i4, i5);
        }

        public final g a(String str) {
            int e4;
            int e5;
            e3.f.e(str, "<this>");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = i4 * 2;
                e4 = c4.b.e(str.charAt(i5));
                e5 = c4.b.e(str.charAt(i5 + 1));
                bArr[i4] = (byte) ((e4 << 4) + e5);
            }
            return new g(bArr);
        }

        public final g b(String str, Charset charset) {
            e3.f.e(str, "<this>");
            e3.f.e(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            e3.f.d(bytes, "getBytes(...)");
            return new g(bytes);
        }

        public final g c(String str) {
            e3.f.e(str, "<this>");
            g gVar = new g(k0.a(str));
            gVar.v(str);
            return gVar;
        }

        public final g d(byte[] bArr, int i4, int i5) {
            byte[] h4;
            e3.f.e(bArr, "<this>");
            int e4 = b.e(bArr, i5);
            b.b(bArr.length, i4, e4);
            h4 = v2.i.h(bArr, i4, e4 + i4);
            return new g(h4);
        }
    }

    public g(byte[] bArr) {
        e3.f.e(bArr, "data");
        this.f2339b = bArr;
    }

    public static /* synthetic */ g B(g gVar, int i4, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = b.c();
        }
        return gVar.A(i4, i5);
    }

    public static /* synthetic */ int m(g gVar, g gVar2, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return gVar.k(gVar2, i4);
    }

    public static /* synthetic */ int r(g gVar, g gVar2, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i5 & 2) != 0) {
            i4 = b.c();
        }
        return gVar.p(gVar2, i4);
    }

    public g A(int i4, int i5) {
        byte[] h4;
        int d5 = b.d(this, i5);
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (!(d5 <= f().length)) {
            throw new IllegalArgumentException(("endIndex > length(" + f().length + ')').toString());
        }
        if (!(d5 - i4 >= 0)) {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        if (i4 == 0 && d5 == f().length) {
            return this;
        }
        h4 = v2.i.h(f(), i4, d5);
        return new g(h4);
    }

    public g C() {
        for (int i4 = 0; i4 < f().length; i4++) {
            byte b5 = f()[i4];
            if (b5 >= 65 && b5 <= 90) {
                byte[] f4 = f();
                byte[] copyOf = Arrays.copyOf(f4, f4.length);
                e3.f.d(copyOf, "copyOf(...)");
                copyOf[i4] = (byte) (b5 + 32);
                for (int i5 = i4 + 1; i5 < copyOf.length; i5++) {
                    byte b6 = copyOf[i5];
                    if (b6 >= 65 && b6 <= 90) {
                        copyOf[i5] = (byte) (b6 + 32);
                    }
                }
                return new g(copyOf);
            }
        }
        return this;
    }

    public String D() {
        String i4 = i();
        if (i4 != null) {
            return i4;
        }
        String c5 = k0.c(n());
        v(c5);
        return c5;
    }

    public void E(d dVar, int i4, int i5) {
        e3.f.e(dVar, "buffer");
        c4.b.d(this, dVar, i4, i5);
    }

    public String a() {
        return b4.a.b(f(), null, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r0 < r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L33;
     */
    @Override // java.lang.Comparable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(b4.g r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            e3.f.e(r10, r0)
            int r0 = r9.y()
            int r1 = r10.y()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.e(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.e(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = r5
            goto L33
        L32:
            r3 = r6
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.g.compareTo(b4.g):int");
    }

    public g c(String str) {
        e3.f.e(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f2339b, 0, y());
        byte[] digest = messageDigest.digest();
        e3.f.b(digest);
        return new g(digest);
    }

    public final boolean d(g gVar) {
        e3.f.e(gVar, "suffix");
        return s(y() - gVar.y(), gVar, 0, gVar.y());
    }

    public final byte e(int i4) {
        return o(i4);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (gVar.y() == f().length && gVar.t(0, f(), 0, f().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte[] f() {
        return this.f2339b;
    }

    public final int g() {
        return this.f2340c;
    }

    public int h() {
        return f().length;
    }

    public int hashCode() {
        int g4 = g();
        if (g4 != 0) {
            return g4;
        }
        int hashCode = Arrays.hashCode(f());
        u(hashCode);
        return hashCode;
    }

    public final String i() {
        return this.f2341d;
    }

    public String j() {
        String h4;
        char[] cArr = new char[f().length * 2];
        int i4 = 0;
        for (byte b5 : f()) {
            int i5 = i4 + 1;
            cArr[i4] = c4.b.f()[(b5 >> 4) & 15];
            i4 = i5 + 1;
            cArr[i5] = c4.b.f()[b5 & 15];
        }
        h4 = j3.u.h(cArr);
        return h4;
    }

    public final int k(g gVar, int i4) {
        e3.f.e(gVar, "other");
        return l(gVar.n(), i4);
    }

    public int l(byte[] bArr, int i4) {
        e3.f.e(bArr, "other");
        int length = f().length - bArr.length;
        int max = Math.max(i4, 0);
        if (max <= length) {
            while (!b.a(f(), max, bArr, 0, bArr.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public byte[] n() {
        return f();
    }

    public byte o(int i4) {
        return f()[i4];
    }

    public final int p(g gVar, int i4) {
        e3.f.e(gVar, "other");
        return q(gVar.n(), i4);
    }

    public int q(byte[] bArr, int i4) {
        e3.f.e(bArr, "other");
        for (int min = Math.min(b.d(this, i4), f().length - bArr.length); -1 < min; min--) {
            if (b.a(f(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean s(int i4, g gVar, int i5, int i6) {
        e3.f.e(gVar, "other");
        return gVar.t(i5, f(), i4, i6);
    }

    public boolean t(int i4, byte[] bArr, int i5, int i6) {
        e3.f.e(bArr, "other");
        return i4 >= 0 && i4 <= f().length - i6 && i5 >= 0 && i5 <= bArr.length - i6 && b.a(f(), i4, bArr, i5, i6);
    }

    public String toString() {
        int c5;
        String t4;
        String t5;
        String t6;
        StringBuilder sb;
        g gVar;
        byte[] h4;
        String str;
        if (!(f().length == 0)) {
            c5 = c4.b.c(f(), 64);
            if (c5 != -1) {
                String D = D();
                String substring = D.substring(0, c5);
                e3.f.d(substring, "substring(...)");
                t4 = j3.u.t(substring, "\\", "\\\\", false, 4, null);
                t5 = j3.u.t(t4, "\n", "\\n", false, 4, null);
                t6 = j3.u.t(t5, "\r", "\\r", false, 4, null);
                if (c5 >= D.length()) {
                    sb = new StringBuilder();
                    sb.append("[text=");
                    sb.append(t6);
                    sb.append(']');
                    return sb.toString();
                }
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(f().length);
                sb.append(" text=");
                sb.append(t6);
            } else if (f().length <= 64) {
                str = "[hex=" + j() + ']';
            } else {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(f().length);
                sb.append(" hex=");
                int d5 = b.d(this, 64);
                if (!(d5 <= f().length)) {
                    throw new IllegalArgumentException(("endIndex > length(" + f().length + ')').toString());
                }
                if (!(d5 + 0 >= 0)) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                if (d5 == f().length) {
                    gVar = this;
                } else {
                    h4 = v2.i.h(f(), 0, d5);
                    gVar = new g(h4);
                }
                sb.append(gVar.j());
            }
            sb.append("…]");
            return sb.toString();
        }
        str = "[size=0]";
        return str;
    }

    public final void u(int i4) {
        this.f2340c = i4;
    }

    public final void v(String str) {
        this.f2341d = str;
    }

    public final g w() {
        return c("SHA-1");
    }

    public final g x() {
        return c("SHA-256");
    }

    public final int y() {
        return h();
    }

    public final boolean z(g gVar) {
        e3.f.e(gVar, "prefix");
        return s(0, gVar, 0, gVar.y());
    }
}
