package t2;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import s2.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends d {

    /* renamed from: g, reason: collision with root package name */
    private final boolean f5974g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5975h = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(boolean z4) {
        this.f5974g = z4;
        K(h.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(Executor executor, b.f fVar, b.e eVar) {
        if (this.f5975h && eVar == m.f5979e) {
            this.f5975h = false;
            I(executor, fVar);
        } else if (fVar != null) {
            fVar.a(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(final Executor executor, final b.f fVar, s2.b bVar) {
        if (this.f5974g && !bVar.M()) {
            close();
            m.f5978d.e(executor, fVar);
        } else {
            if (this.f5955b instanceof h) {
                this.f5955b = fVar == null ? null : new ArrayList();
            }
            this.f5958e = (p) bVar;
            super.I(executor, new b.f() { // from class: t2.j
                @Override // s2.b.f
                public final void a(b.e eVar) {
                    k.this.R(executor, fVar, eVar);
                }
            });
        }
    }

    @Override // t2.d, s2.b.d
    public void I(final Executor executor, final b.f fVar) {
        g.d(null, new b.InterfaceC0076b() { // from class: t2.i
            @Override // s2.b.InterfaceC0076b
            public final void a(s2.b bVar) {
                k.this.S(executor, fVar, bVar);
            }
        });
    }

    @Override // t2.d, s2.b.d
    public b.e i() {
        try {
            p c5 = g.c();
            this.f5958e = c5;
            if (this.f5974g && !c5.M()) {
                close();
                return m.f5978d;
            }
            if (this.f5955b instanceof h) {
                this.f5955b = new ArrayList();
            }
            b.e i4 = super.i();
            if (!this.f5975h || i4 != m.f5979e) {
                return i4;
            }
            this.f5975h = false;
            return i();
        } catch (s2.a unused) {
            close();
            return m.f5978d;
        }
    }
}
