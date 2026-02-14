package k1;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    static final f f4387e = new f(g.f4392b, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f4388a;

    /* renamed from: b, reason: collision with root package name */
    private final g f4389b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4390c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4391d;

    private f(g gVar, int i4, int i5, int i6) {
        this.f4389b = gVar;
        this.f4388a = i4;
        this.f4390c = i5;
        this.f4391d = i6;
    }

    private static int b(f fVar) {
        int i4 = fVar.f4390c;
        if (i4 > 62) {
            return 21;
        }
        if (i4 > 31) {
            return 20;
        }
        return i4 > 0 ? 10 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f a(int i4) {
        g gVar = this.f4389b;
        int i5 = this.f4388a;
        int i6 = this.f4391d;
        if (i5 == 4 || i5 == 2) {
            int i7 = d.f4380c[i5][0];
            int i8 = 65535 & i7;
            int i9 = i7 >> 16;
            gVar = gVar.a(i8, i9);
            i6 += i9;
            i5 = 0;
        }
        int i10 = this.f4390c;
        f fVar = new f(gVar, i5, i10 + 1, i6 + ((i10 == 0 || i10 == 31) ? 18 : i10 == 62 ? 9 : 8));
        return fVar.f4390c == 2078 ? fVar.c(i4 + 1) : fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f c(int i4) {
        int i5 = this.f4390c;
        return i5 == 0 ? this : new f(this.f4389b.b(i4 - i5, i5), this.f4388a, 0, this.f4391d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f4390c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f4391d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f4388a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(f fVar) {
        int i4 = this.f4391d + (d.f4380c[this.f4388a][fVar.f4388a] >> 16);
        int i5 = this.f4390c;
        int i6 = fVar.f4390c;
        if (i5 < i6) {
            i4 += b(fVar) - b(this);
        } else if (i5 > i6 && i6 > 0) {
            i4 += 10;
        }
        return i4 <= fVar.f4391d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f h(int i4, int i5) {
        int i6 = this.f4391d;
        g gVar = this.f4389b;
        int i7 = this.f4388a;
        if (i4 != i7) {
            int i8 = d.f4380c[i7][i4];
            int i9 = 65535 & i8;
            int i10 = i8 >> 16;
            gVar = gVar.a(i9, i10);
            i6 += i10;
        }
        int i11 = i4 == 2 ? 4 : 5;
        return new f(gVar.a(i5, i11), i4, 0, i6 + i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f i(int i4, int i5) {
        g gVar = this.f4389b;
        int i6 = this.f4388a;
        int i7 = i6 == 2 ? 4 : 5;
        return new f(gVar.a(d.f4382e[i6][i4], i7).a(i5, 5), this.f4388a, 0, this.f4391d + i7 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n1.a j(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (g gVar = c(bArr.length).f4389b; gVar != null; gVar = gVar.d()) {
            linkedList.addFirst(gVar);
        }
        n1.a aVar = new n1.a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f4379b[this.f4388a], Integer.valueOf(this.f4391d), Integer.valueOf(this.f4390c));
    }
}
