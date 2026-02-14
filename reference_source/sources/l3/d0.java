package l3;

import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class d0 implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4640b = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public static /* synthetic */ d0 c(a aVar, byte[] bArr, x xVar, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                xVar = null;
            }
            return aVar.b(bArr, xVar);
        }

        public final d0 a(b4.f fVar, x xVar, long j4) {
            e3.f.e(fVar, "<this>");
            return m3.n.a(fVar, xVar, j4);
        }

        public final d0 b(byte[] bArr, x xVar) {
            e3.f.e(bArr, "<this>");
            return m3.n.c(bArr, xVar);
        }
    }

    private final Charset I() {
        return m3.c.a(K());
    }

    public abstract long J();

    public abstract x K();

    public abstract b4.f L();

    public final String M() {
        b4.f L = L();
        try {
            String E = L.E(m3.s.l(L, I()));
            c3.a.a(L, null);
            return E;
        } finally {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m3.n.b(this);
    }

    public final InputStream i() {
        return L().G();
    }
}
