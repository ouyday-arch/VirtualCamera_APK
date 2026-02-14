package q3;

import java.io.IOException;
import q3.n;

/* loaded from: classes.dex */
public final class p implements d {

    /* renamed from: a, reason: collision with root package name */
    private final n f5754a;

    public p(n nVar) {
        e3.f.e(nVar, "routePlanner");
        this.f5754a = nVar;
    }

    @Override // q3.d
    public i a() {
        n.b b5;
        IOException iOException = null;
        while (!b().g()) {
            try {
                b5 = b().b();
            } catch (IOException e4) {
                if (iOException == null) {
                    iOException = e4;
                } else {
                    u2.b.a(iOException, e4);
                }
                if (!n.d(b(), null, 1, null)) {
                    throw iOException;
                }
            }
            if (!b5.b()) {
                n.a d5 = b5.d();
                if (d5.f()) {
                    d5 = b5.e();
                }
                n.b a5 = d5.a();
                Throwable b6 = d5.b();
                if (b6 != null) {
                    throw b6;
                }
                if (a5 != null) {
                    b().a().c(a5);
                }
            }
            return b5.f();
        }
        throw new IOException("Canceled");
    }

    @Override // q3.d
    public n b() {
        return this.f5754a;
    }
}
