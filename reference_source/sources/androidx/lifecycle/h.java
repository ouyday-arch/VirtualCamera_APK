package androidx.lifecycle;

import androidx.lifecycle.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<g> f1715d;

    /* renamed from: b, reason: collision with root package name */
    private i.a<f, b> f1713b = new i.a<>();

    /* renamed from: e, reason: collision with root package name */
    private int f1716e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1717f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1718g = false;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<d.b> f1719h = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private d.b f1714c = d.b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1720a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1721b;

        static {
            int[] iArr = new int[d.b.values().length];
            f1721b = iArr;
            try {
                iArr[d.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1721b[d.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1721b[d.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1721b[d.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1721b[d.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[d.a.values().length];
            f1720a = iArr2;
            try {
                iArr2[d.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1720a[d.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1720a[d.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1720a[d.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1720a[d.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1720a[d.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1720a[d.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        d.b f1722a;

        /* renamed from: b, reason: collision with root package name */
        e f1723b;

        b(f fVar, d.b bVar) {
            this.f1723b = j.f(fVar);
            this.f1722a = bVar;
        }

        void a(g gVar, d.a aVar) {
            d.b h4 = h.h(aVar);
            this.f1722a = h.l(this.f1722a, h4);
            this.f1723b.d(gVar, aVar);
            this.f1722a = h4;
        }
    }

    public h(g gVar) {
        this.f1715d = new WeakReference<>(gVar);
    }

    private void d(g gVar) {
        Iterator<Map.Entry<f, b>> a5 = this.f1713b.a();
        while (a5.hasNext() && !this.f1718g) {
            Map.Entry<f, b> next = a5.next();
            b value = next.getValue();
            while (value.f1722a.compareTo(this.f1714c) > 0 && !this.f1718g && this.f1713b.contains(next.getKey())) {
                d.a f4 = f(value.f1722a);
                o(h(f4));
                value.a(gVar, f4);
                n();
            }
        }
    }

    private d.b e(f fVar) {
        Map.Entry<f, b> h4 = this.f1713b.h(fVar);
        d.b bVar = null;
        d.b bVar2 = h4 != null ? h4.getValue().f1722a : null;
        if (!this.f1719h.isEmpty()) {
            bVar = this.f1719h.get(r0.size() - 1);
        }
        return l(l(this.f1714c, bVar2), bVar);
    }

    private static d.a f(d.b bVar) {
        int i4 = a.f1721b[bVar.ordinal()];
        if (i4 == 1) {
            throw new IllegalArgumentException();
        }
        if (i4 == 2) {
            return d.a.ON_DESTROY;
        }
        if (i4 == 3) {
            return d.a.ON_STOP;
        }
        if (i4 == 4) {
            return d.a.ON_PAUSE;
        }
        if (i4 == 5) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g(g gVar) {
        i.b<f, b>.d d5 = this.f1713b.d();
        while (d5.hasNext() && !this.f1718g) {
            Map.Entry next = d5.next();
            b bVar = (b) next.getValue();
            while (bVar.f1722a.compareTo(this.f1714c) < 0 && !this.f1718g && this.f1713b.contains(next.getKey())) {
                o(bVar.f1722a);
                bVar.a(gVar, r(bVar.f1722a));
                n();
            }
        }
    }

    static d.b h(d.a aVar) {
        switch (a.f1720a[aVar.ordinal()]) {
            case 1:
            case 2:
                return d.b.CREATED;
            case 3:
            case 4:
                return d.b.STARTED;
            case 5:
                return d.b.RESUMED;
            case 6:
                return d.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private boolean j() {
        if (this.f1713b.size() == 0) {
            return true;
        }
        d.b bVar = this.f1713b.b().getValue().f1722a;
        d.b bVar2 = this.f1713b.e().getValue().f1722a;
        return bVar == bVar2 && this.f1714c == bVar2;
    }

    static d.b l(d.b bVar, d.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void m(d.b bVar) {
        if (this.f1714c == bVar) {
            return;
        }
        this.f1714c = bVar;
        if (this.f1717f || this.f1716e != 0) {
            this.f1718g = true;
            return;
        }
        this.f1717f = true;
        q();
        this.f1717f = false;
    }

    private void n() {
        this.f1719h.remove(r0.size() - 1);
    }

    private void o(d.b bVar) {
        this.f1719h.add(bVar);
    }

    private void q() {
        g gVar = this.f1715d.get();
        if (gVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean j4 = j();
            this.f1718g = false;
            if (j4) {
                return;
            }
            if (this.f1714c.compareTo(this.f1713b.b().getValue().f1722a) < 0) {
                d(gVar);
            }
            Map.Entry<f, b> e4 = this.f1713b.e();
            if (!this.f1718g && e4 != null && this.f1714c.compareTo(e4.getValue().f1722a) > 0) {
                g(gVar);
            }
        }
    }

    private static d.a r(d.b bVar) {
        int i4 = a.f1721b[bVar.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return d.a.ON_START;
            }
            if (i4 == 3) {
                return d.a.ON_RESUME;
            }
            if (i4 == 4) {
                throw new IllegalArgumentException();
            }
            if (i4 != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return d.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.d
    public void a(f fVar) {
        g gVar;
        d.b bVar = this.f1714c;
        d.b bVar2 = d.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = d.b.INITIALIZED;
        }
        b bVar3 = new b(fVar, bVar2);
        if (this.f1713b.i(fVar, bVar3) == null && (gVar = this.f1715d.get()) != null) {
            boolean z4 = this.f1716e != 0 || this.f1717f;
            d.b e4 = e(fVar);
            this.f1716e++;
            while (bVar3.f1722a.compareTo(e4) < 0 && this.f1713b.contains(fVar)) {
                o(bVar3.f1722a);
                bVar3.a(gVar, r(bVar3.f1722a));
                n();
                e4 = e(fVar);
            }
            if (!z4) {
                q();
            }
            this.f1716e--;
        }
    }

    @Override // androidx.lifecycle.d
    public d.b b() {
        return this.f1714c;
    }

    @Override // androidx.lifecycle.d
    public void c(f fVar) {
        this.f1713b.g(fVar);
    }

    public void i(d.a aVar) {
        m(h(aVar));
    }

    @Deprecated
    public void k(d.b bVar) {
        p(bVar);
    }

    public void p(d.b bVar) {
        m(bVar);
    }
}
