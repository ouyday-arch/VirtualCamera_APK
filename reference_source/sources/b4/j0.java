package b4;

import b4.y;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class j0 extends j {

    /* renamed from: i, reason: collision with root package name */
    private static final a f2366i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static final y f2367j = y.a.d(y.f2393c, "/", false, 1, null);

    /* renamed from: e, reason: collision with root package name */
    private final y f2368e;

    /* renamed from: f, reason: collision with root package name */
    private final j f2369f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<y, c4.h> f2370g;

    /* renamed from: h, reason: collision with root package name */
    private final String f2371h;

    /* loaded from: classes.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    public j0(y yVar, j jVar, Map<y, c4.h> map, String str) {
        e3.f.e(yVar, "zipPath");
        e3.f.e(jVar, "fileSystem");
        e3.f.e(map, "entries");
        this.f2368e = yVar;
        this.f2369f = jVar;
        this.f2370g = map;
        this.f2371h = str;
    }

    private final y c(y yVar) {
        return f2367j.j(yVar, true);
    }

    @Override // b4.j
    public h a(y yVar) {
        e3.f.e(yVar, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // b4.j
    public g0 b(y yVar) {
        f fVar;
        e3.f.e(yVar, "file");
        c4.h hVar = this.f2370g.get(c(yVar));
        if (hVar == null) {
            throw new FileNotFoundException("no such file: " + yVar);
        }
        h a5 = this.f2369f.a(this.f2368e);
        Throwable th = null;
        try {
            fVar = t.b(a5.R(hVar.e()));
            if (a5 != null) {
                try {
                    a5.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (a5 != null) {
                try {
                    a5.close();
                } catch (Throwable th4) {
                    u2.b.a(th3, th4);
                }
            }
            fVar = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        e3.f.b(fVar);
        c4.i.j(fVar);
        return hVar.d() == 0 ? new c4.f(fVar, hVar.f(), true) : new c4.f(new o(new c4.f(fVar, hVar.c(), true), new Inflater(true)), hVar.f(), false);
    }
}
