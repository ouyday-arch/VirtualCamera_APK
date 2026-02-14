package l3;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a */
    public static final a f4582a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public static /* synthetic */ b0 d(a aVar, byte[] bArr, x xVar, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                xVar = null;
            }
            if ((i6 & 2) != 0) {
                i4 = 0;
            }
            if ((i6 & 4) != 0) {
                i5 = bArr.length;
            }
            return aVar.c(bArr, xVar, i4, i5);
        }

        public final b0 a(String str, x xVar) {
            e3.f.e(str, "<this>");
            u2.g<Charset, x> b5 = m3.c.b(xVar);
            Charset a5 = b5.a();
            x b6 = b5.b();
            byte[] bytes = str.getBytes(a5);
            e3.f.d(bytes, "getBytes(...)");
            return c(bytes, b6, 0, bytes.length);
        }

        public final b0 b(x xVar, String str) {
            e3.f.e(str, "content");
            return a(str, xVar);
        }

        public final b0 c(byte[] bArr, x xVar, int i4, int i5) {
            e3.f.e(bArr, "<this>");
            return m3.l.c(bArr, xVar, i4, i5);
        }
    }

    public static final b0 c(x xVar, String str) {
        return f4582a.b(xVar, str);
    }

    public abstract long a();

    public abstract x b();

    public boolean d() {
        return m3.l.a(this);
    }

    public boolean e() {
        return m3.l.b(this);
    }

    public abstract void f(b4.e eVar);
}
