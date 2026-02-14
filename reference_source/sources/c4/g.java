package c4;

import b4.g0;
import b4.j;
import b4.t;
import b4.y;
import j3.u;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import v2.w;

/* loaded from: classes.dex */
public final class g extends j {

    /* renamed from: h, reason: collision with root package name */
    private static final a f2467h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final y f2468i = y.a.d(y.f2393c, "/", false, 1, null);

    /* renamed from: e, reason: collision with root package name */
    private final ClassLoader f2469e;

    /* renamed from: f, reason: collision with root package name */
    private final j f2470f;

    /* renamed from: g, reason: collision with root package name */
    private final u2.c f2471g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b(y yVar) {
            boolean j4;
            j4 = u.j(yVar.f(), ".class", true);
            return !j4;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends e3.g implements d3.a<List<? extends u2.g<? extends j, ? extends y>>> {
        b() {
            super(0);
        }

        @Override // d3.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List<u2.g<j, y>> d() {
            g gVar = g.this;
            return gVar.h(gVar.f2469e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends e3.g implements d3.b<h, Boolean> {

        /* renamed from: c, reason: collision with root package name */
        public static final c f2473c = new c();

        c() {
            super(1);
        }

        @Override // d3.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean b(h hVar) {
            e3.f.e(hVar, "entry");
            return Boolean.valueOf(g.f2467h.b(hVar.a()));
        }
    }

    public g(ClassLoader classLoader, boolean z4, j jVar) {
        u2.c a5;
        e3.f.e(classLoader, "classLoader");
        e3.f.e(jVar, "systemFileSystem");
        this.f2469e = classLoader;
        this.f2470f = jVar;
        a5 = u2.e.a(new b());
        this.f2471g = a5;
        if (z4) {
            g().size();
        }
    }

    public /* synthetic */ g(ClassLoader classLoader, boolean z4, j jVar, int i4, e3.d dVar) {
        this(classLoader, z4, (i4 & 4) != 0 ? j.f2363b : jVar);
    }

    private final y f(y yVar) {
        return f2468i.j(yVar, true);
    }

    private final List<u2.g<j, y>> g() {
        return (List) this.f2471g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<u2.g<j, y>> h(ClassLoader classLoader) {
        List<u2.g<j, y>> G;
        Enumeration<URL> resources = classLoader.getResources("");
        e3.f.d(resources, "getResources(...)");
        ArrayList<URL> list = Collections.list(resources);
        e3.f.d(list, "list(...)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            e3.f.b(url);
            u2.g<j, y> i4 = i(url);
            if (i4 != null) {
                arrayList.add(i4);
            }
        }
        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
        e3.f.d(resources2, "getResources(...)");
        ArrayList<URL> list2 = Collections.list(resources2);
        e3.f.d(list2, "list(...)");
        ArrayList arrayList2 = new ArrayList();
        for (URL url2 : list2) {
            e3.f.b(url2);
            u2.g<j, y> j4 = j(url2);
            if (j4 != null) {
                arrayList2.add(j4);
            }
        }
        G = w.G(arrayList, arrayList2);
        return G;
    }

    private final u2.g<j, y> i(URL url) {
        if (e3.f.a(url.getProtocol(), "file")) {
            return u2.i.a(this.f2470f, y.a.c(y.f2393c, new File(url.toURI()), false, 1, null));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        r0 = j3.v.S(r9, "!", 0, false, 6, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final u2.g<b4.j, b4.y> j(java.net.URL r9) {
        /*
            r8 = this;
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "toString(...)"
            e3.f.d(r9, r0)
            java.lang.String r0 = "jar:file:"
            r6 = 0
            r1 = 2
            r7 = 0
            boolean r0 = j3.l.x(r9, r0, r6, r1, r7)
            if (r0 != 0) goto L15
            return r7
        L15:
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            java.lang.String r1 = "!"
            r0 = r9
            int r0 = j3.l.S(r0, r1, r2, r3, r4, r5)
            r1 = -1
            if (r0 != r1) goto L24
            return r7
        L24:
            b4.y$a r1 = b4.y.f2393c
            java.io.File r2 = new java.io.File
            r3 = 4
            java.lang.String r9 = r9.substring(r3, r0)
            java.lang.String r0 = "substring(...)"
            e3.f.d(r9, r0)
            java.net.URI r9 = java.net.URI.create(r9)
            r2.<init>(r9)
            r9 = 1
            b4.y r9 = b4.y.a.c(r1, r2, r6, r9, r7)
            b4.j r0 = r8.f2470f
            c4.g$c r1 = c4.g.c.f2473c
            b4.j0 r9 = c4.i.d(r9, r0, r1)
            b4.y r0 = c4.g.f2468i
            u2.g r9 = u2.i.a(r9, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.g.j(java.net.URL):u2.g");
    }

    private final String k(y yVar) {
        return f(yVar).i(f2468i).toString();
    }

    @Override // b4.j
    public b4.h a(y yVar) {
        e3.f.e(yVar, "file");
        if (!f2467h.b(yVar)) {
            throw new FileNotFoundException("file not found: " + yVar);
        }
        String k4 = k(yVar);
        for (u2.g<j, y> gVar : g()) {
            try {
                return gVar.a().a(gVar.b().k(k4));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + yVar);
    }

    @Override // b4.j
    public g0 b(y yVar) {
        g0 f4;
        e3.f.e(yVar, "file");
        if (!f2467h.b(yVar)) {
            throw new FileNotFoundException("file not found: " + yVar);
        }
        y yVar2 = f2468i;
        InputStream resourceAsStream = this.f2469e.getResourceAsStream(y.l(yVar2, yVar, false, 2, null).i(yVar2).toString());
        if (resourceAsStream != null && (f4 = t.f(resourceAsStream)) != null) {
            return f4;
        }
        throw new FileNotFoundException("file not found: " + yVar);
    }
}
