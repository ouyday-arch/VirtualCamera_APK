package i2;

import g2.h;
import g2.j;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private h f4139a;

    /* renamed from: b, reason: collision with root package name */
    private g2.f f4140b;

    /* renamed from: c, reason: collision with root package name */
    private j f4141c;

    /* renamed from: d, reason: collision with root package name */
    private int f4142d = -1;

    /* renamed from: e, reason: collision with root package name */
    private b f4143e;

    public static boolean b(int i4) {
        return i4 >= 0 && i4 < 8;
    }

    public b a() {
        return this.f4143e;
    }

    public void c(g2.f fVar) {
        this.f4140b = fVar;
    }

    public void d(int i4) {
        this.f4142d = i4;
    }

    public void e(b bVar) {
        this.f4143e = bVar;
    }

    public void f(h hVar) {
        this.f4139a = hVar;
    }

    public void g(j jVar) {
        this.f4141c = jVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f4139a);
        sb.append("\n ecLevel: ");
        sb.append(this.f4140b);
        sb.append("\n version: ");
        sb.append(this.f4141c);
        sb.append("\n maskPattern: ");
        sb.append(this.f4142d);
        if (this.f4143e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f4143e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
