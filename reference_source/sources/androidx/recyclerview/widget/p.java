package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    final k.g<RecyclerView.d0, a> f2096a = new k.g<>();

    /* renamed from: b, reason: collision with root package name */
    final k.d<RecyclerView.d0> f2097b = new k.d<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        static x.e<a> f2098d = new x.f(20);

        /* renamed from: a, reason: collision with root package name */
        int f2099a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.l.c f2100b;

        /* renamed from: c, reason: collision with root package name */
        RecyclerView.l.c f2101c;

        private a() {
        }

        static void a() {
            do {
            } while (f2098d.b() != null);
        }

        static a b() {
            a b5 = f2098d.b();
            return b5 == null ? new a() : b5;
        }

        static void c(a aVar) {
            aVar.f2099a = 0;
            aVar.f2100b = null;
            aVar.f2101c = null;
            f2098d.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.d0 d0Var);

        void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    private RecyclerView.l.c l(RecyclerView.d0 d0Var, int i4) {
        a m4;
        RecyclerView.l.c cVar;
        int f4 = this.f2096a.f(d0Var);
        if (f4 >= 0 && (m4 = this.f2096a.m(f4)) != null) {
            int i5 = m4.f2099a;
            if ((i5 & i4) != 0) {
                int i6 = (~i4) & i5;
                m4.f2099a = i6;
                if (i4 == 4) {
                    cVar = m4.f2100b;
                } else {
                    if (i4 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = m4.f2101c;
                }
                if ((i6 & 12) == 0) {
                    this.f2096a.k(f4);
                    a.c(m4);
                }
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f2096a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f2096a.put(d0Var, aVar);
        }
        aVar.f2099a |= 2;
        aVar.f2100b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.d0 d0Var) {
        a aVar = this.f2096a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f2096a.put(d0Var, aVar);
        }
        aVar.f2099a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j4, RecyclerView.d0 d0Var) {
        this.f2097b.j(j4, d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f2096a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f2096a.put(d0Var, aVar);
        }
        aVar.f2101c = cVar;
        aVar.f2099a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f2096a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f2096a.put(d0Var, aVar);
        }
        aVar.f2100b = cVar;
        aVar.f2099a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f2096a.clear();
        this.f2097b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.d0 g(long j4) {
        return this.f2097b.e(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.d0 d0Var) {
        a aVar = this.f2096a.get(d0Var);
        return (aVar == null || (aVar.f2099a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.d0 d0Var) {
        a aVar = this.f2096a.get(d0Var);
        return (aVar == null || (aVar.f2099a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(b bVar) {
        RecyclerView.l.c cVar;
        RecyclerView.l.c cVar2;
        for (int size = this.f2096a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 i4 = this.f2096a.i(size);
            a k4 = this.f2096a.k(size);
            int i5 = k4.f2099a;
            if ((i5 & 3) != 3) {
                if ((i5 & 1) != 0) {
                    cVar = k4.f2100b;
                    cVar2 = cVar != null ? k4.f2101c : null;
                } else {
                    if ((i5 & 14) != 14) {
                        if ((i5 & 12) == 12) {
                            bVar.d(i4, k4.f2100b, k4.f2101c);
                        } else if ((i5 & 4) != 0) {
                            cVar = k4.f2100b;
                        } else if ((i5 & 8) == 0) {
                        }
                        a.c(k4);
                    }
                    bVar.b(i4, k4.f2100b, k4.f2101c);
                    a.c(k4);
                }
                bVar.c(i4, cVar, cVar2);
                a.c(k4);
            }
            bVar.a(i4);
            a.c(k4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerView.d0 d0Var) {
        a aVar = this.f2096a.get(d0Var);
        if (aVar == null) {
            return;
        }
        aVar.f2099a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.d0 d0Var) {
        int m4 = this.f2097b.m() - 1;
        while (true) {
            if (m4 < 0) {
                break;
            }
            if (d0Var == this.f2097b.n(m4)) {
                this.f2097b.l(m4);
                break;
            }
            m4--;
        }
        a remove = this.f2096a.remove(d0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}
