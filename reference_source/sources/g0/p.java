package g0;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import g0.l;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class p extends l {
    int M;
    private ArrayList<l> K = new ArrayList<>();
    private boolean L = true;
    boolean N = false;
    private int O = 0;

    /* loaded from: classes.dex */
    class a extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f3874a;

        a(l lVar) {
            this.f3874a = lVar;
        }

        @Override // g0.l.f
        public void c(l lVar) {
            this.f3874a.U();
            lVar.Q(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends m {

        /* renamed from: a, reason: collision with root package name */
        p f3876a;

        b(p pVar) {
            this.f3876a = pVar;
        }

        @Override // g0.m, g0.l.f
        public void a(l lVar) {
            p pVar = this.f3876a;
            if (pVar.N) {
                return;
            }
            pVar.b0();
            this.f3876a.N = true;
        }

        @Override // g0.l.f
        public void c(l lVar) {
            p pVar = this.f3876a;
            int i4 = pVar.M - 1;
            pVar.M = i4;
            if (i4 == 0) {
                pVar.N = false;
                pVar.q();
            }
            lVar.Q(this);
        }
    }

    private void g0(l lVar) {
        this.K.add(lVar);
        lVar.f3851s = this;
    }

    private void p0() {
        b bVar = new b(this);
        Iterator<l> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.M = this.K.size();
    }

    @Override // g0.l
    public void O(View view) {
        super.O(view);
        int size = this.K.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.K.get(i4).O(view);
        }
    }

    @Override // g0.l
    public void S(View view) {
        super.S(view);
        int size = this.K.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.K.get(i4).S(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g0.l
    public void U() {
        if (this.K.isEmpty()) {
            b0();
            q();
            return;
        }
        p0();
        if (this.L) {
            Iterator<l> it = this.K.iterator();
            while (it.hasNext()) {
                it.next().U();
            }
            return;
        }
        for (int i4 = 1; i4 < this.K.size(); i4++) {
            this.K.get(i4 - 1).a(new a(this.K.get(i4)));
        }
        l lVar = this.K.get(0);
        if (lVar != null) {
            lVar.U();
        }
    }

    @Override // g0.l
    public void W(l.e eVar) {
        super.W(eVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.K.get(i4).W(eVar);
        }
    }

    @Override // g0.l
    public void Y(g gVar) {
        super.Y(gVar);
        this.O |= 4;
        if (this.K != null) {
            for (int i4 = 0; i4 < this.K.size(); i4++) {
                this.K.get(i4).Y(gVar);
            }
        }
    }

    @Override // g0.l
    public void Z(o oVar) {
        super.Z(oVar);
        this.O |= 2;
        int size = this.K.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.K.get(i4).Z(oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g0.l
    public String c0(String str) {
        String c02 = super.c0(str);
        for (int i4 = 0; i4 < this.K.size(); i4++) {
            StringBuilder sb = new StringBuilder();
            sb.append(c02);
            sb.append("\n");
            sb.append(this.K.get(i4).c0(str + "  "));
            c02 = sb.toString();
        }
        return c02;
    }

    @Override // g0.l
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public p a(l.f fVar) {
        return (p) super.a(fVar);
    }

    @Override // g0.l
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public p b(View view) {
        for (int i4 = 0; i4 < this.K.size(); i4++) {
            this.K.get(i4).b(view);
        }
        return (p) super.b(view);
    }

    public p f0(l lVar) {
        g0(lVar);
        long j4 = this.f3836d;
        if (j4 >= 0) {
            lVar.V(j4);
        }
        if ((this.O & 1) != 0) {
            lVar.X(t());
        }
        if ((this.O & 2) != 0) {
            x();
            lVar.Z(null);
        }
        if ((this.O & 4) != 0) {
            lVar.Y(w());
        }
        if ((this.O & 8) != 0) {
            lVar.W(s());
        }
        return this;
    }

    @Override // g0.l
    public void g(r rVar) {
        if (H(rVar.f3881b)) {
            Iterator<l> it = this.K.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (next.H(rVar.f3881b)) {
                    next.g(rVar);
                    rVar.f3882c.add(next);
                }
            }
        }
    }

    public l h0(int i4) {
        if (i4 < 0 || i4 >= this.K.size()) {
            return null;
        }
        return this.K.get(i4);
    }

    public int i0() {
        return this.K.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g0.l
    public void j(r rVar) {
        super.j(rVar);
        int size = this.K.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.K.get(i4).j(rVar);
        }
    }

    @Override // g0.l
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public p Q(l.f fVar) {
        return (p) super.Q(fVar);
    }

    @Override // g0.l
    public void k(r rVar) {
        if (H(rVar.f3881b)) {
            Iterator<l> it = this.K.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (next.H(rVar.f3881b)) {
                    next.k(rVar);
                    rVar.f3882c.add(next);
                }
            }
        }
    }

    @Override // g0.l
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public p R(View view) {
        for (int i4 = 0; i4 < this.K.size(); i4++) {
            this.K.get(i4).R(view);
        }
        return (p) super.R(view);
    }

    @Override // g0.l
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public p V(long j4) {
        ArrayList<l> arrayList;
        super.V(j4);
        if (this.f3836d >= 0 && (arrayList = this.K) != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.K.get(i4).V(j4);
            }
        }
        return this;
    }

    @Override // g0.l
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public p X(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<l> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.K.get(i4).X(timeInterpolator);
            }
        }
        return (p) super.X(timeInterpolator);
    }

    @Override // g0.l
    /* renamed from: n */
    public l clone() {
        p pVar = (p) super.clone();
        pVar.K = new ArrayList<>();
        int size = this.K.size();
        for (int i4 = 0; i4 < size; i4++) {
            pVar.g0(this.K.get(i4).clone());
        }
        return pVar;
    }

    public p n0(int i4) {
        if (i4 == 0) {
            this.L = true;
        } else {
            if (i4 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i4);
            }
            this.L = false;
        }
        return this;
    }

    @Override // g0.l
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public p a0(long j4) {
        return (p) super.a0(j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g0.l
    public void p(ViewGroup viewGroup, s sVar, s sVar2, ArrayList<r> arrayList, ArrayList<r> arrayList2) {
        long z4 = z();
        int size = this.K.size();
        for (int i4 = 0; i4 < size; i4++) {
            l lVar = this.K.get(i4);
            if (z4 > 0 && (this.L || i4 == 0)) {
                long z5 = lVar.z();
                if (z5 > 0) {
                    lVar.a0(z5 + z4);
                } else {
                    lVar.a0(z4);
                }
            }
            lVar.p(viewGroup, sVar, sVar2, arrayList, arrayList2);
        }
    }
}
