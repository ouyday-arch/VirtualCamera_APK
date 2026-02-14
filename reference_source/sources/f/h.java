package f;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import y.t;
import y.u;
import y.v;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f3692c;

    /* renamed from: d, reason: collision with root package name */
    u f3693d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3694e;

    /* renamed from: b, reason: collision with root package name */
    private long f3691b = -1;

    /* renamed from: f, reason: collision with root package name */
    private final v f3695f = new a();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<t> f3690a = new ArrayList<>();

    /* loaded from: classes.dex */
    class a extends v {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3696a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f3697b = 0;

        a() {
        }

        @Override // y.u
        public void a(View view) {
            int i4 = this.f3697b + 1;
            this.f3697b = i4;
            if (i4 == h.this.f3690a.size()) {
                u uVar = h.this.f3693d;
                if (uVar != null) {
                    uVar.a(null);
                }
                d();
            }
        }

        @Override // y.v, y.u
        public void b(View view) {
            if (this.f3696a) {
                return;
            }
            this.f3696a = true;
            u uVar = h.this.f3693d;
            if (uVar != null) {
                uVar.b(null);
            }
        }

        void d() {
            this.f3697b = 0;
            this.f3696a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f3694e) {
            Iterator<t> it = this.f3690a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f3694e = false;
        }
    }

    void b() {
        this.f3694e = false;
    }

    public h c(t tVar) {
        if (!this.f3694e) {
            this.f3690a.add(tVar);
        }
        return this;
    }

    public h d(t tVar, t tVar2) {
        this.f3690a.add(tVar);
        tVar2.h(tVar.c());
        this.f3690a.add(tVar2);
        return this;
    }

    public h e(long j4) {
        if (!this.f3694e) {
            this.f3691b = j4;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f3694e) {
            this.f3692c = interpolator;
        }
        return this;
    }

    public h g(u uVar) {
        if (!this.f3694e) {
            this.f3693d = uVar;
        }
        return this;
    }

    public void h() {
        if (this.f3694e) {
            return;
        }
        Iterator<t> it = this.f3690a.iterator();
        while (it.hasNext()) {
            t next = it.next();
            long j4 = this.f3691b;
            if (j4 >= 0) {
                next.d(j4);
            }
            Interpolator interpolator = this.f3692c;
            if (interpolator != null) {
                next.e(interpolator);
            }
            if (this.f3693d != null) {
                next.f(this.f3695f);
            }
            next.j();
        }
        this.f3694e = true;
    }
}
