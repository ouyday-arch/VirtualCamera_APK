package b4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class y implements Comparable<y> {

    /* renamed from: c */
    public static final a f2393c = new a(null);

    /* renamed from: d */
    public static final String f2394d;

    /* renamed from: b */
    private final g f2395b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public static /* synthetic */ y c(a aVar, File file, boolean z4, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z4 = false;
            }
            return aVar.a(file, z4);
        }

        public static /* synthetic */ y d(a aVar, String str, boolean z4, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z4 = false;
            }
            return aVar.b(str, z4);
        }

        public final y a(File file, boolean z4) {
            e3.f.e(file, "<this>");
            String file2 = file.toString();
            e3.f.d(file2, "toString(...)");
            return b(file2, z4);
        }

        public final y b(String str, boolean z4) {
            e3.f.e(str, "<this>");
            return c4.c.k(str, z4);
        }
    }

    static {
        String str = File.separator;
        e3.f.d(str, "separator");
        f2394d = str;
    }

    public y(g gVar) {
        e3.f.e(gVar, "bytes");
        this.f2395b = gVar;
    }

    public static /* synthetic */ y l(y yVar, y yVar2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return yVar.j(yVar2, z4);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(y yVar) {
        e3.f.e(yVar, "other");
        return b().compareTo(yVar.b());
    }

    public final g b() {
        return this.f2395b;
    }

    public final y c() {
        int o4;
        o4 = c4.c.o(this);
        if (o4 == -1) {
            return null;
        }
        return new y(b().A(0, o4));
    }

    public final List<g> d() {
        int o4;
        ArrayList arrayList = new ArrayList();
        o4 = c4.c.o(this);
        if (o4 == -1) {
            o4 = 0;
        } else if (o4 < b().y() && b().e(o4) == 92) {
            o4++;
        }
        int y4 = b().y();
        int i4 = o4;
        while (o4 < y4) {
            if (b().e(o4) == 47 || b().e(o4) == 92) {
                arrayList.add(b().A(i4, o4));
                i4 = o4 + 1;
            }
            o4++;
        }
        if (i4 < b().y()) {
            arrayList.add(b().A(i4, b().y()));
        }
        return arrayList;
    }

    public final boolean e() {
        int o4;
        o4 = c4.c.o(this);
        return o4 != -1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof y) && e3.f.a(((y) obj).b(), b());
    }

    public final String f() {
        return g().D();
    }

    public final g g() {
        int l4;
        l4 = c4.c.l(this);
        return l4 != -1 ? g.B(b(), l4 + 1, 0, 2, null) : (n() == null || b().y() != 2) ? b() : g.f2338f;
    }

    public final y h() {
        g gVar;
        g gVar2;
        g gVar3;
        boolean n4;
        int l4;
        y yVar;
        g gVar4;
        g gVar5;
        g b5 = b();
        gVar = c4.c.f2459d;
        if (e3.f.a(b5, gVar)) {
            return null;
        }
        g b6 = b();
        gVar2 = c4.c.f2456a;
        if (e3.f.a(b6, gVar2)) {
            return null;
        }
        g b7 = b();
        gVar3 = c4.c.f2457b;
        if (e3.f.a(b7, gVar3)) {
            return null;
        }
        n4 = c4.c.n(this);
        if (n4) {
            return null;
        }
        l4 = c4.c.l(this);
        if (l4 != 2 || n() == null) {
            if (l4 == 1) {
                g b8 = b();
                gVar5 = c4.c.f2457b;
                if (b8.z(gVar5)) {
                    return null;
                }
            }
            if (l4 != -1 || n() == null) {
                if (l4 == -1) {
                    gVar4 = c4.c.f2459d;
                    return new y(gVar4);
                }
                if (l4 != 0) {
                    return new y(g.B(b(), 0, l4, 1, null));
                }
                yVar = new y(g.B(b(), 0, 1, 1, null));
            } else {
                if (b().y() == 2) {
                    return null;
                }
                yVar = new y(g.B(b(), 0, 2, 1, null));
            }
        } else {
            if (b().y() == 3) {
                return null;
            }
            yVar = new y(g.B(b(), 0, 3, 1, null));
        }
        return yVar;
    }

    public int hashCode() {
        return b().hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
    
        r9 = c4.c.m(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b4.y i(b4.y r9) {
        /*
            r8 = this;
            java.lang.String r0 = "other"
            e3.f.e(r9, r0)
            b4.y r0 = r8.c()
            b4.y r1 = r9.c()
            boolean r0 = e3.f.a(r0, r1)
            java.lang.String r1 = " and "
            if (r0 == 0) goto Lda
            java.util.List r0 = r8.d()
            java.util.List r2 = r9.d()
            int r3 = r0.size()
            int r4 = r2.size()
            int r3 = java.lang.Math.min(r3, r4)
            r4 = 0
            r5 = r4
        L2b:
            if (r5 >= r3) goto L3e
            java.lang.Object r6 = r0.get(r5)
            java.lang.Object r7 = r2.get(r5)
            boolean r6 = e3.f.a(r6, r7)
            if (r6 == 0) goto L3e
            int r5 = r5 + 1
            goto L2b
        L3e:
            r6 = 1
            if (r5 != r3) goto L5d
            b4.g r3 = r8.b()
            int r3 = r3.y()
            b4.g r7 = r9.b()
            int r7 = r7.y()
            if (r3 != r7) goto L5d
            b4.y$a r9 = b4.y.f2393c
            r0 = 0
            java.lang.String r1 = "."
            b4.y r9 = b4.y.a.d(r9, r1, r4, r6, r0)
            goto Lb8
        L5d:
            int r3 = r2.size()
            java.util.List r3 = r2.subList(r5, r3)
            b4.g r7 = c4.c.c()
            int r3 = r3.indexOf(r7)
            r7 = -1
            if (r3 != r7) goto L71
            goto L72
        L71:
            r6 = r4
        L72:
            if (r6 == 0) goto Lb9
            b4.d r1 = new b4.d
            r1.<init>()
            b4.g r9 = c4.c.f(r9)
            if (r9 != 0) goto L8b
            b4.g r9 = c4.c.f(r8)
            if (r9 != 0) goto L8b
            java.lang.String r9 = b4.y.f2394d
            b4.g r9 = c4.c.i(r9)
        L8b:
            int r2 = r2.size()
            r3 = r5
        L90:
            if (r3 >= r2) goto L9f
            b4.g r6 = c4.c.c()
            r1.A(r6)
            r1.A(r9)
            int r3 = r3 + 1
            goto L90
        L9f:
            int r2 = r0.size()
        La3:
            if (r5 >= r2) goto Lb4
            java.lang.Object r3 = r0.get(r5)
            b4.g r3 = (b4.g) r3
            r1.A(r3)
            r1.A(r9)
            int r5 = r5 + 1
            goto La3
        Lb4:
            b4.y r9 = c4.c.q(r1, r4)
        Lb8:
            return r9
        Lb9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Impossible relative path to resolve: "
            r0.append(r2)
            r0.append(r8)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        Lda:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Paths of different roots cannot be relative to each other: "
            r0.append(r2)
            r0.append(r8)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.y.i(b4.y):b4.y");
    }

    public final y j(y yVar, boolean z4) {
        e3.f.e(yVar, "child");
        return c4.c.j(this, yVar, z4);
    }

    public final y k(String str) {
        e3.f.e(str, "child");
        return c4.c.j(this, c4.c.q(new d().x(str), false), false);
    }

    public final File m() {
        return new File(toString());
    }

    public final Character n() {
        g gVar;
        g b5 = b();
        gVar = c4.c.f2456a;
        boolean z4 = false;
        if (g.m(b5, gVar, 0, 2, null) != -1 || b().y() < 2 || b().e(1) != 58) {
            return null;
        }
        char e4 = (char) b().e(0);
        if (!('a' <= e4 && e4 < '{')) {
            if ('A' <= e4 && e4 < '[') {
                z4 = true;
            }
            if (!z4) {
                return null;
            }
        }
        return Character.valueOf(e4);
    }

    public String toString() {
        return b().D();
    }
}
