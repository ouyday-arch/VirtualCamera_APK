package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {

    /* renamed from: a, reason: collision with root package name */
    private x.e<b> f1941a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<b> f1942b;

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<b> f1943c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC0015a f1944d;

    /* renamed from: e, reason: collision with root package name */
    Runnable f1945e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f1946f;

    /* renamed from: g, reason: collision with root package name */
    final i f1947g;

    /* renamed from: h, reason: collision with root package name */
    private int f1948h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0015a {
        void a(int i4, int i5);

        void b(b bVar);

        RecyclerView.d0 c(int i4);

        void d(int i4, int i5);

        void e(int i4, int i5);

        void f(b bVar);

        void g(int i4, int i5);

        void h(int i4, int i5, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f1949a;

        /* renamed from: b, reason: collision with root package name */
        int f1950b;

        /* renamed from: c, reason: collision with root package name */
        Object f1951c;

        /* renamed from: d, reason: collision with root package name */
        int f1952d;

        b(int i4, int i5, int i6, Object obj) {
            this.f1949a = i4;
            this.f1950b = i5;
            this.f1952d = i6;
            this.f1951c = obj;
        }

        String a() {
            int i4 = this.f1949a;
            return i4 != 1 ? i4 != 2 ? i4 != 4 ? i4 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i4 = this.f1949a;
            if (i4 != bVar.f1949a) {
                return false;
            }
            if (i4 == 8 && Math.abs(this.f1952d - this.f1950b) == 1 && this.f1952d == bVar.f1950b && this.f1950b == bVar.f1952d) {
                return true;
            }
            if (this.f1952d != bVar.f1952d || this.f1950b != bVar.f1950b) {
                return false;
            }
            Object obj2 = this.f1951c;
            Object obj3 = bVar.f1951c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1949a * 31) + this.f1950b) * 31) + this.f1952d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1950b + "c:" + this.f1952d + ",p:" + this.f1951c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InterfaceC0015a interfaceC0015a) {
        this(interfaceC0015a, false);
    }

    a(InterfaceC0015a interfaceC0015a, boolean z4) {
        this.f1941a = new x.f(30);
        this.f1942b = new ArrayList<>();
        this.f1943c = new ArrayList<>();
        this.f1948h = 0;
        this.f1944d = interfaceC0015a;
        this.f1946f = z4;
        this.f1947g = new i(this);
    }

    private void c(b bVar) {
        r(bVar);
    }

    private void d(b bVar) {
        r(bVar);
    }

    private void f(b bVar) {
        boolean z4;
        char c5;
        int i4 = bVar.f1950b;
        int i5 = bVar.f1952d + i4;
        char c6 = 65535;
        int i6 = i4;
        int i7 = 0;
        while (i6 < i5) {
            if (this.f1944d.c(i6) != null || h(i6)) {
                if (c6 == 0) {
                    k(b(2, i4, i7, null));
                    z4 = true;
                } else {
                    z4 = false;
                }
                c5 = 1;
            } else {
                if (c6 == 1) {
                    r(b(2, i4, i7, null));
                    z4 = true;
                } else {
                    z4 = false;
                }
                c5 = 0;
            }
            if (z4) {
                i6 -= i7;
                i5 -= i7;
                i7 = 1;
            } else {
                i7++;
            }
            i6++;
            c6 = c5;
        }
        if (i7 != bVar.f1952d) {
            a(bVar);
            bVar = b(2, i4, i7, null);
        }
        if (c6 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    private void g(b bVar) {
        int i4 = bVar.f1950b;
        int i5 = bVar.f1952d + i4;
        int i6 = 0;
        boolean z4 = -1;
        int i7 = i4;
        while (i4 < i5) {
            if (this.f1944d.c(i4) != null || h(i4)) {
                if (!z4) {
                    k(b(4, i7, i6, bVar.f1951c));
                    i7 = i4;
                    i6 = 0;
                }
                z4 = true;
            } else {
                if (z4) {
                    r(b(4, i7, i6, bVar.f1951c));
                    i7 = i4;
                    i6 = 0;
                }
                z4 = false;
            }
            i6++;
            i4++;
        }
        if (i6 != bVar.f1952d) {
            Object obj = bVar.f1951c;
            a(bVar);
            bVar = b(4, i7, i6, obj);
        }
        if (z4) {
            r(bVar);
        } else {
            k(bVar);
        }
    }

    private boolean h(int i4) {
        int size = this.f1943c.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = this.f1943c.get(i5);
            int i6 = bVar.f1949a;
            if (i6 == 8) {
                if (n(bVar.f1952d, i5 + 1) == i4) {
                    return true;
                }
            } else if (i6 == 1) {
                int i7 = bVar.f1950b;
                int i8 = bVar.f1952d + i7;
                while (i7 < i8) {
                    if (n(i7, i5 + 1) == i4) {
                        return true;
                    }
                    i7++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i4;
        int i5 = bVar.f1949a;
        if (i5 == 1 || i5 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int v4 = v(bVar.f1950b, i5);
        int i6 = bVar.f1950b;
        int i7 = bVar.f1949a;
        if (i7 == 2) {
            i4 = 0;
        } else {
            if (i7 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i4 = 1;
        }
        int i8 = 1;
        for (int i9 = 1; i9 < bVar.f1952d; i9++) {
            int v5 = v(bVar.f1950b + (i4 * i9), bVar.f1949a);
            int i10 = bVar.f1949a;
            if (i10 == 2 ? v5 == v4 : i10 == 4 && v5 == v4 + 1) {
                i8++;
            } else {
                b b5 = b(i10, v4, i8, bVar.f1951c);
                l(b5, i6);
                a(b5);
                if (bVar.f1949a == 4) {
                    i6 += i8;
                }
                i8 = 1;
                v4 = v5;
            }
        }
        Object obj = bVar.f1951c;
        a(bVar);
        if (i8 > 0) {
            b b6 = b(bVar.f1949a, v4, i8, obj);
            l(b6, i6);
            a(b6);
        }
    }

    private void r(b bVar) {
        this.f1943c.add(bVar);
        int i4 = bVar.f1949a;
        if (i4 == 1) {
            this.f1944d.g(bVar.f1950b, bVar.f1952d);
            return;
        }
        if (i4 == 2) {
            this.f1944d.e(bVar.f1950b, bVar.f1952d);
            return;
        }
        if (i4 == 4) {
            this.f1944d.h(bVar.f1950b, bVar.f1952d, bVar.f1951c);
        } else {
            if (i4 == 8) {
                this.f1944d.a(bVar.f1950b, bVar.f1952d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int v(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        for (int size = this.f1943c.size() - 1; size >= 0; size--) {
            b bVar = this.f1943c.get(size);
            int i12 = bVar.f1949a;
            if (i12 == 8) {
                int i13 = bVar.f1950b;
                int i14 = bVar.f1952d;
                if (i13 < i14) {
                    i8 = i13;
                    i7 = i14;
                } else {
                    i7 = i13;
                    i8 = i14;
                }
                if (i4 < i8 || i4 > i7) {
                    if (i4 < i13) {
                        if (i5 == 1) {
                            bVar.f1950b = i13 + 1;
                            i9 = i14 + 1;
                        } else if (i5 == 2) {
                            bVar.f1950b = i13 - 1;
                            i9 = i14 - 1;
                        }
                        bVar.f1952d = i9;
                    }
                } else if (i8 == i13) {
                    if (i5 == 1) {
                        i11 = i14 + 1;
                    } else {
                        if (i5 == 2) {
                            i11 = i14 - 1;
                        }
                        i4++;
                    }
                    bVar.f1952d = i11;
                    i4++;
                } else {
                    if (i5 == 1) {
                        i10 = i13 + 1;
                    } else {
                        if (i5 == 2) {
                            i10 = i13 - 1;
                        }
                        i4--;
                    }
                    bVar.f1950b = i10;
                    i4--;
                }
            } else {
                int i15 = bVar.f1950b;
                if (i15 > i4) {
                    if (i5 == 1) {
                        i6 = i15 + 1;
                    } else if (i5 == 2) {
                        i6 = i15 - 1;
                    }
                    bVar.f1950b = i6;
                } else if (i12 == 1) {
                    i4 -= bVar.f1952d;
                } else if (i12 == 2) {
                    i4 += bVar.f1952d;
                }
            }
        }
        for (int size2 = this.f1943c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1943c.get(size2);
            if (bVar2.f1949a == 8) {
                int i16 = bVar2.f1952d;
                if (i16 != bVar2.f1950b && i16 >= 0) {
                }
                this.f1943c.remove(size2);
                a(bVar2);
            } else {
                if (bVar2.f1952d > 0) {
                }
                this.f1943c.remove(size2);
                a(bVar2);
            }
        }
        return i4;
    }

    @Override // androidx.recyclerview.widget.i.a
    public void a(b bVar) {
        if (this.f1946f) {
            return;
        }
        bVar.f1951c = null;
        this.f1941a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.i.a
    public b b(int i4, int i5, int i6, Object obj) {
        b b5 = this.f1941a.b();
        if (b5 == null) {
            return new b(i4, i5, i6, obj);
        }
        b5.f1949a = i4;
        b5.f1950b = i5;
        b5.f1952d = i6;
        b5.f1951c = obj;
        return b5;
    }

    public int e(int i4) {
        int size = this.f1942b.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = this.f1942b.get(i5);
            int i6 = bVar.f1949a;
            if (i6 != 1) {
                if (i6 == 2) {
                    int i7 = bVar.f1950b;
                    if (i7 <= i4) {
                        int i8 = bVar.f1952d;
                        if (i7 + i8 > i4) {
                            return -1;
                        }
                        i4 -= i8;
                    } else {
                        continue;
                    }
                } else if (i6 == 8) {
                    int i9 = bVar.f1950b;
                    if (i9 == i4) {
                        i4 = bVar.f1952d;
                    } else {
                        if (i9 < i4) {
                            i4--;
                        }
                        if (bVar.f1952d <= i4) {
                            i4++;
                        }
                    }
                }
            } else if (bVar.f1950b <= i4) {
                i4 += bVar.f1952d;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int size = this.f1943c.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f1944d.b(this.f1943c.get(i4));
        }
        t(this.f1943c);
        this.f1948h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f1942b.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = this.f1942b.get(i4);
            int i5 = bVar.f1949a;
            if (i5 == 1) {
                this.f1944d.b(bVar);
                this.f1944d.g(bVar.f1950b, bVar.f1952d);
            } else if (i5 == 2) {
                this.f1944d.b(bVar);
                this.f1944d.d(bVar.f1950b, bVar.f1952d);
            } else if (i5 == 4) {
                this.f1944d.b(bVar);
                this.f1944d.h(bVar.f1950b, bVar.f1952d, bVar.f1951c);
            } else if (i5 == 8) {
                this.f1944d.b(bVar);
                this.f1944d.a(bVar.f1950b, bVar.f1952d);
            }
            Runnable runnable = this.f1945e;
            if (runnable != null) {
                runnable.run();
            }
        }
        t(this.f1942b);
        this.f1948h = 0;
    }

    void l(b bVar, int i4) {
        this.f1944d.f(bVar);
        int i5 = bVar.f1949a;
        if (i5 == 2) {
            this.f1944d.d(i4, bVar.f1952d);
        } else {
            if (i5 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f1944d.h(i4, bVar.f1952d, bVar.f1951c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(int i4) {
        return n(i4, 0);
    }

    int n(int i4, int i5) {
        int size = this.f1943c.size();
        while (i5 < size) {
            b bVar = this.f1943c.get(i5);
            int i6 = bVar.f1949a;
            if (i6 == 8) {
                int i7 = bVar.f1950b;
                if (i7 == i4) {
                    i4 = bVar.f1952d;
                } else {
                    if (i7 < i4) {
                        i4--;
                    }
                    if (bVar.f1952d <= i4) {
                        i4++;
                    }
                }
            } else {
                int i8 = bVar.f1950b;
                if (i8 > i4) {
                    continue;
                } else if (i6 == 2) {
                    int i9 = bVar.f1952d;
                    if (i4 < i8 + i9) {
                        return -1;
                    }
                    i4 -= i9;
                } else if (i6 == 1) {
                    i4 += bVar.f1952d;
                }
            }
            i5++;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(int i4) {
        return (i4 & this.f1948h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f1942b.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return (this.f1943c.isEmpty() || this.f1942b.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f1947g.b(this.f1942b);
        int size = this.f1942b.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = this.f1942b.get(i4);
            int i5 = bVar.f1949a;
            if (i5 == 1) {
                c(bVar);
            } else if (i5 == 2) {
                f(bVar);
            } else if (i5 == 4) {
                g(bVar);
            } else if (i5 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f1945e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1942b.clear();
    }

    void t(List<b> list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            a(list.get(i4));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        t(this.f1942b);
        t(this.f1943c);
        this.f1948h = 0;
    }
}
