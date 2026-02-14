package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: j, reason: collision with root package name */
    static final Object f1679j = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Object f1680a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private i.b<m<? super T>, LiveData<T>.b> f1681b = new i.b<>();

    /* renamed from: c, reason: collision with root package name */
    int f1682c = 0;

    /* renamed from: d, reason: collision with root package name */
    private volatile Object f1683d;

    /* renamed from: e, reason: collision with root package name */
    volatile Object f1684e;

    /* renamed from: f, reason: collision with root package name */
    private int f1685f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1686g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1687h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f1688i;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.b implements e {

        /* renamed from: e, reason: collision with root package name */
        final g f1689e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveData f1690f;

        @Override // androidx.lifecycle.e
        public void d(g gVar, d.a aVar) {
            if (this.f1689e.a().b() == d.b.DESTROYED) {
                this.f1690f.f(this.f1692a);
            } else {
                h(j());
            }
        }

        @Override // androidx.lifecycle.LiveData.b
        void i() {
            this.f1689e.a().c(this);
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean j() {
            return this.f1689e.a().b().a(d.b.STARTED);
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f1680a) {
                obj = LiveData.this.f1684e;
                LiveData.this.f1684e = LiveData.f1679j;
            }
            LiveData.this.g(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class b {

        /* renamed from: a, reason: collision with root package name */
        final m<? super T> f1692a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1693b;

        /* renamed from: c, reason: collision with root package name */
        int f1694c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LiveData f1695d;

        void h(boolean z4) {
            if (z4 == this.f1693b) {
                return;
            }
            this.f1693b = z4;
            LiveData liveData = this.f1695d;
            int i4 = liveData.f1682c;
            boolean z5 = i4 == 0;
            liveData.f1682c = i4 + (z4 ? 1 : -1);
            if (z5 && z4) {
                liveData.d();
            }
            LiveData liveData2 = this.f1695d;
            if (liveData2.f1682c == 0 && !this.f1693b) {
                liveData2.e();
            }
            if (this.f1693b) {
                this.f1695d.c(this);
            }
        }

        void i() {
        }

        abstract boolean j();
    }

    public LiveData() {
        Object obj = f1679j;
        this.f1683d = obj;
        this.f1684e = obj;
        this.f1685f = -1;
        this.f1688i = new a();
    }

    private static void a(String str) {
        if (h.a.d().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void b(LiveData<T>.b bVar) {
        if (bVar.f1693b) {
            if (!bVar.j()) {
                bVar.h(false);
                return;
            }
            int i4 = bVar.f1694c;
            int i5 = this.f1685f;
            if (i4 >= i5) {
                return;
            }
            bVar.f1694c = i5;
            bVar.f1692a.a((Object) this.f1683d);
        }
    }

    void c(LiveData<T>.b bVar) {
        if (this.f1686g) {
            this.f1687h = true;
            return;
        }
        this.f1686g = true;
        do {
            this.f1687h = false;
            if (bVar != null) {
                b(bVar);
                bVar = null;
            } else {
                i.b<m<? super T>, LiveData<T>.b>.d d5 = this.f1681b.d();
                while (d5.hasNext()) {
                    b((b) d5.next().getValue());
                    if (this.f1687h) {
                        break;
                    }
                }
            }
        } while (this.f1687h);
        this.f1686g = false;
    }

    protected void d() {
    }

    protected void e() {
    }

    public void f(m<? super T> mVar) {
        a("removeObserver");
        LiveData<T>.b g4 = this.f1681b.g(mVar);
        if (g4 == null) {
            return;
        }
        g4.i();
        g4.h(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(T t4) {
        a("setValue");
        this.f1685f++;
        this.f1683d = t4;
        c(null);
    }
}
