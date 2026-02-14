package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    int A;
    int B;
    private boolean C;
    d D;
    final a E;
    private final b F;
    private int G;
    private int[] H;

    /* renamed from: s, reason: collision with root package name */
    int f1748s;

    /* renamed from: t, reason: collision with root package name */
    private c f1749t;

    /* renamed from: u, reason: collision with root package name */
    j f1750u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f1751v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f1752w;

    /* renamed from: x, reason: collision with root package name */
    boolean f1753x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f1754y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f1755z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        j f1756a;

        /* renamed from: b, reason: collision with root package name */
        int f1757b;

        /* renamed from: c, reason: collision with root package name */
        int f1758c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1759d;

        /* renamed from: e, reason: collision with root package name */
        boolean f1760e;

        a() {
            e();
        }

        void a() {
            this.f1758c = this.f1759d ? this.f1756a.i() : this.f1756a.m();
        }

        public void b(View view, int i4) {
            this.f1758c = this.f1759d ? this.f1756a.d(view) + this.f1756a.o() : this.f1756a.g(view);
            this.f1757b = i4;
        }

        public void c(View view, int i4) {
            int o4 = this.f1756a.o();
            if (o4 >= 0) {
                b(view, i4);
                return;
            }
            this.f1757b = i4;
            if (this.f1759d) {
                int i5 = (this.f1756a.i() - o4) - this.f1756a.d(view);
                this.f1758c = this.f1756a.i() - i5;
                if (i5 > 0) {
                    int e4 = this.f1758c - this.f1756a.e(view);
                    int m4 = this.f1756a.m();
                    int min = e4 - (m4 + Math.min(this.f1756a.g(view) - m4, 0));
                    if (min < 0) {
                        this.f1758c += Math.min(i5, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g4 = this.f1756a.g(view);
            int m5 = g4 - this.f1756a.m();
            this.f1758c = g4;
            if (m5 > 0) {
                int i6 = (this.f1756a.i() - Math.min(0, (this.f1756a.i() - o4) - this.f1756a.d(view))) - (g4 + this.f1756a.e(view));
                if (i6 < 0) {
                    this.f1758c -= Math.min(m5, -i6);
                }
            }
        }

        boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.b();
        }

        void e() {
            this.f1757b = -1;
            this.f1758c = RecyclerView.UNDEFINED_DURATION;
            this.f1759d = false;
            this.f1760e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1757b + ", mCoordinate=" + this.f1758c + ", mLayoutFromEnd=" + this.f1759d + ", mValid=" + this.f1760e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f1761a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1762b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1763c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1764d;

        protected b() {
        }

        void a() {
            this.f1761a = 0;
            this.f1762b = false;
            this.f1763c = false;
            this.f1764d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        int f1766b;

        /* renamed from: c, reason: collision with root package name */
        int f1767c;

        /* renamed from: d, reason: collision with root package name */
        int f1768d;

        /* renamed from: e, reason: collision with root package name */
        int f1769e;

        /* renamed from: f, reason: collision with root package name */
        int f1770f;

        /* renamed from: g, reason: collision with root package name */
        int f1771g;

        /* renamed from: k, reason: collision with root package name */
        int f1775k;

        /* renamed from: m, reason: collision with root package name */
        boolean f1777m;

        /* renamed from: a, reason: collision with root package name */
        boolean f1765a = true;

        /* renamed from: h, reason: collision with root package name */
        int f1772h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f1773i = 0;

        /* renamed from: j, reason: collision with root package name */
        boolean f1774j = false;

        /* renamed from: l, reason: collision with root package name */
        List<RecyclerView.d0> f1776l = null;

        c() {
        }

        private View e() {
            int size = this.f1776l.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.f1776l.get(i4).f1809a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f1768d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f4 = f(view);
            this.f1768d = f4 == null ? -1 : ((RecyclerView.p) f4.getLayoutParams()).a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(RecyclerView.a0 a0Var) {
            int i4 = this.f1768d;
            return i4 >= 0 && i4 < a0Var.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View d(RecyclerView.v vVar) {
            if (this.f1776l != null) {
                return e();
            }
            View o4 = vVar.o(this.f1768d);
            this.f1768d += this.f1769e;
            return o4;
        }

        public View f(View view) {
            int a5;
            int size = this.f1776l.size();
            View view2 = null;
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < size; i5++) {
                View view3 = this.f1776l.get(i5).f1809a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a5 = (pVar.a() - this.f1768d) * this.f1769e) >= 0 && a5 < i4) {
                    view2 = view3;
                    if (a5 == 0) {
                        break;
                    }
                    i4 = a5;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        int f1778b;

        /* renamed from: c, reason: collision with root package name */
        int f1779c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1780d;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i4) {
                return new d[i4];
            }
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f1778b = parcel.readInt();
            this.f1779c = parcel.readInt();
            this.f1780d = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f1778b = dVar.f1778b;
            this.f1779c = dVar.f1779c;
            this.f1780d = dVar.f1780d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        boolean f() {
            return this.f1778b >= 0;
        }

        void g() {
            this.f1778b = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f1778b);
            parcel.writeInt(this.f1779c);
            parcel.writeInt(this.f1780d ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context, int i4, boolean z4) {
        this.f1748s = 1;
        this.f1752w = false;
        this.f1753x = false;
        this.f1754y = false;
        this.f1755z = true;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        C2(i4);
        D2(z4);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f1748s = 1;
        this.f1752w = false;
        this.f1753x = false;
        this.f1754y = false;
        this.f1755z = true;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.o.d i02 = RecyclerView.o.i0(context, attributeSet, i4, i5);
        C2(i02.f1862a);
        D2(i02.f1864c);
        E2(i02.f1865d);
    }

    private void A2() {
        this.f1753x = (this.f1748s == 1 || !q2()) ? this.f1752w : !this.f1752w;
    }

    private boolean F2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (J() == 0) {
            return false;
        }
        View V = V();
        if (V != null && aVar.d(V, a0Var)) {
            aVar.c(V, h0(V));
            return true;
        }
        if (this.f1751v != this.f1754y) {
            return false;
        }
        View i22 = aVar.f1759d ? i2(vVar, a0Var) : j2(vVar, a0Var);
        if (i22 == null) {
            return false;
        }
        aVar.b(i22, h0(i22));
        if (!a0Var.e() && L1()) {
            if (this.f1750u.g(i22) >= this.f1750u.i() || this.f1750u.d(i22) < this.f1750u.m()) {
                aVar.f1758c = aVar.f1759d ? this.f1750u.i() : this.f1750u.m();
            }
        }
        return true;
    }

    private boolean G2(RecyclerView.a0 a0Var, a aVar) {
        int i4;
        if (!a0Var.e() && (i4 = this.A) != -1) {
            if (i4 >= 0 && i4 < a0Var.b()) {
                aVar.f1757b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.f()) {
                    boolean z4 = this.D.f1780d;
                    aVar.f1759d = z4;
                    aVar.f1758c = z4 ? this.f1750u.i() - this.D.f1779c : this.f1750u.m() + this.D.f1779c;
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z5 = this.f1753x;
                    aVar.f1759d = z5;
                    aVar.f1758c = z5 ? this.f1750u.i() - this.B : this.f1750u.m() + this.B;
                    return true;
                }
                View C = C(this.A);
                if (C == null) {
                    if (J() > 0) {
                        aVar.f1759d = (this.A < h0(I(0))) == this.f1753x;
                    }
                    aVar.a();
                } else {
                    if (this.f1750u.e(C) > this.f1750u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f1750u.g(C) - this.f1750u.m() < 0) {
                        aVar.f1758c = this.f1750u.m();
                        aVar.f1759d = false;
                        return true;
                    }
                    if (this.f1750u.i() - this.f1750u.d(C) < 0) {
                        aVar.f1758c = this.f1750u.i();
                        aVar.f1759d = true;
                        return true;
                    }
                    aVar.f1758c = aVar.f1759d ? this.f1750u.d(C) + this.f1750u.o() : this.f1750u.g(C);
                }
                return true;
            }
            this.A = -1;
            this.B = RecyclerView.UNDEFINED_DURATION;
        }
        return false;
    }

    private void H2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (G2(a0Var, aVar) || F2(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f1757b = this.f1754y ? a0Var.b() - 1 : 0;
    }

    private void I2(int i4, int i5, boolean z4, RecyclerView.a0 a0Var) {
        int m4;
        this.f1749t.f1777m = z2();
        this.f1749t.f1770f = i4;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(a0Var, iArr);
        int max = Math.max(0, this.H[0]);
        int max2 = Math.max(0, this.H[1]);
        boolean z5 = i4 == 1;
        c cVar = this.f1749t;
        int i6 = z5 ? max2 : max;
        cVar.f1772h = i6;
        if (!z5) {
            max = max2;
        }
        cVar.f1773i = max;
        if (z5) {
            cVar.f1772h = i6 + this.f1750u.j();
            View m22 = m2();
            c cVar2 = this.f1749t;
            cVar2.f1769e = this.f1753x ? -1 : 1;
            int h02 = h0(m22);
            c cVar3 = this.f1749t;
            cVar2.f1768d = h02 + cVar3.f1769e;
            cVar3.f1766b = this.f1750u.d(m22);
            m4 = this.f1750u.d(m22) - this.f1750u.i();
        } else {
            View n22 = n2();
            this.f1749t.f1772h += this.f1750u.m();
            c cVar4 = this.f1749t;
            cVar4.f1769e = this.f1753x ? 1 : -1;
            int h03 = h0(n22);
            c cVar5 = this.f1749t;
            cVar4.f1768d = h03 + cVar5.f1769e;
            cVar5.f1766b = this.f1750u.g(n22);
            m4 = (-this.f1750u.g(n22)) + this.f1750u.m();
        }
        c cVar6 = this.f1749t;
        cVar6.f1767c = i5;
        if (z4) {
            cVar6.f1767c = i5 - m4;
        }
        cVar6.f1771g = m4;
    }

    private void J2(int i4, int i5) {
        this.f1749t.f1767c = this.f1750u.i() - i5;
        c cVar = this.f1749t;
        cVar.f1769e = this.f1753x ? -1 : 1;
        cVar.f1768d = i4;
        cVar.f1770f = 1;
        cVar.f1766b = i5;
        cVar.f1771g = RecyclerView.UNDEFINED_DURATION;
    }

    private void K2(a aVar) {
        J2(aVar.f1757b, aVar.f1758c);
    }

    private void L2(int i4, int i5) {
        this.f1749t.f1767c = i5 - this.f1750u.m();
        c cVar = this.f1749t;
        cVar.f1768d = i4;
        cVar.f1769e = this.f1753x ? 1 : -1;
        cVar.f1770f = -1;
        cVar.f1766b = i5;
        cVar.f1771g = RecyclerView.UNDEFINED_DURATION;
    }

    private void M2(a aVar) {
        L2(aVar.f1757b, aVar.f1758c);
    }

    private int O1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.a(a0Var, this.f1750u, Y1(!this.f1755z, true), X1(!this.f1755z, true), this, this.f1755z);
    }

    private int P1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.b(a0Var, this.f1750u, Y1(!this.f1755z, true), X1(!this.f1755z, true), this, this.f1755z, this.f1753x);
    }

    private int Q1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.c(a0Var, this.f1750u, Y1(!this.f1755z, true), X1(!this.f1755z, true), this, this.f1755z);
    }

    private View V1() {
        return d2(0, J());
    }

    private View W1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return h2(vVar, a0Var, 0, J(), a0Var.b());
    }

    private View a2() {
        return d2(J() - 1, -1);
    }

    private View b2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return h2(vVar, a0Var, J() - 1, -1, a0Var.b());
    }

    private View f2() {
        return this.f1753x ? V1() : a2();
    }

    private View g2() {
        return this.f1753x ? a2() : V1();
    }

    private View i2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f1753x ? W1(vVar, a0Var) : b2(vVar, a0Var);
    }

    private View j2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f1753x ? b2(vVar, a0Var) : W1(vVar, a0Var);
    }

    private int k2(int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z4) {
        int i5;
        int i6 = this.f1750u.i() - i4;
        if (i6 <= 0) {
            return 0;
        }
        int i7 = -B2(-i6, vVar, a0Var);
        int i8 = i4 + i7;
        if (!z4 || (i5 = this.f1750u.i() - i8) <= 0) {
            return i7;
        }
        this.f1750u.r(i5);
        return i5 + i7;
    }

    private int l2(int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z4) {
        int m4;
        int m5 = i4 - this.f1750u.m();
        if (m5 <= 0) {
            return 0;
        }
        int i5 = -B2(m5, vVar, a0Var);
        int i6 = i4 + i5;
        if (!z4 || (m4 = i6 - this.f1750u.m()) <= 0) {
            return i5;
        }
        this.f1750u.r(-m4);
        return i5 - m4;
    }

    private View m2() {
        return I(this.f1753x ? 0 : J() - 1);
    }

    private View n2() {
        return I(this.f1753x ? J() - 1 : 0);
    }

    private void t2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i4, int i5) {
        if (!a0Var.g() || J() == 0 || a0Var.e() || !L1()) {
            return;
        }
        List<RecyclerView.d0> k4 = vVar.k();
        int size = k4.size();
        int h02 = h0(I(0));
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            RecyclerView.d0 d0Var = k4.get(i8);
            if (!d0Var.v()) {
                char c5 = (d0Var.m() < h02) != this.f1753x ? (char) 65535 : (char) 1;
                int e4 = this.f1750u.e(d0Var.f1809a);
                if (c5 == 65535) {
                    i6 += e4;
                } else {
                    i7 += e4;
                }
            }
        }
        this.f1749t.f1776l = k4;
        if (i6 > 0) {
            L2(h0(n2()), i4);
            c cVar = this.f1749t;
            cVar.f1772h = i6;
            cVar.f1767c = 0;
            cVar.a();
            U1(vVar, this.f1749t, a0Var, false);
        }
        if (i7 > 0) {
            J2(h0(m2()), i5);
            c cVar2 = this.f1749t;
            cVar2.f1772h = i7;
            cVar2.f1767c = 0;
            cVar2.a();
            U1(vVar, this.f1749t, a0Var, false);
        }
        this.f1749t.f1776l = null;
    }

    private void v2(RecyclerView.v vVar, c cVar) {
        if (!cVar.f1765a || cVar.f1777m) {
            return;
        }
        int i4 = cVar.f1771g;
        int i5 = cVar.f1773i;
        if (cVar.f1770f == -1) {
            x2(vVar, i4, i5);
        } else {
            y2(vVar, i4, i5);
        }
    }

    private void w2(RecyclerView.v vVar, int i4, int i5) {
        if (i4 == i5) {
            return;
        }
        if (i5 <= i4) {
            while (i4 > i5) {
                n1(i4, vVar);
                i4--;
            }
        } else {
            for (int i6 = i5 - 1; i6 >= i4; i6--) {
                n1(i6, vVar);
            }
        }
    }

    private void x2(RecyclerView.v vVar, int i4, int i5) {
        int J = J();
        if (i4 < 0) {
            return;
        }
        int h4 = (this.f1750u.h() - i4) + i5;
        if (this.f1753x) {
            for (int i6 = 0; i6 < J; i6++) {
                View I = I(i6);
                if (this.f1750u.g(I) < h4 || this.f1750u.q(I) < h4) {
                    w2(vVar, 0, i6);
                    return;
                }
            }
            return;
        }
        int i7 = J - 1;
        for (int i8 = i7; i8 >= 0; i8--) {
            View I2 = I(i8);
            if (this.f1750u.g(I2) < h4 || this.f1750u.q(I2) < h4) {
                w2(vVar, i7, i8);
                return;
            }
        }
    }

    private void y2(RecyclerView.v vVar, int i4, int i5) {
        if (i4 < 0) {
            return;
        }
        int i6 = i4 - i5;
        int J = J();
        if (!this.f1753x) {
            for (int i7 = 0; i7 < J; i7++) {
                View I = I(i7);
                if (this.f1750u.d(I) > i6 || this.f1750u.p(I) > i6) {
                    w2(vVar, 0, i7);
                    return;
                }
            }
            return;
        }
        int i8 = J - 1;
        for (int i9 = i8; i9 >= 0; i9--) {
            View I2 = I(i9);
            if (this.f1750u.d(I2) > i6 || this.f1750u.p(I2) > i6) {
                w2(vVar, i8, i9);
                return;
            }
        }
    }

    int B2(int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i4 == 0) {
            return 0;
        }
        T1();
        this.f1749t.f1765a = true;
        int i5 = i4 > 0 ? 1 : -1;
        int abs = Math.abs(i4);
        I2(i5, abs, true, a0Var);
        c cVar = this.f1749t;
        int U1 = cVar.f1771g + U1(vVar, cVar, a0Var, false);
        if (U1 < 0) {
            return 0;
        }
        if (abs > U1) {
            i4 = i5 * U1;
        }
        this.f1750u.r(-i4);
        this.f1749t.f1775k = i4;
        return i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int i4) {
        int J = J();
        if (J == 0) {
            return null;
        }
        int h02 = i4 - h0(I(0));
        if (h02 >= 0 && h02 < J) {
            View I = I(h02);
            if (h0(I) == i4) {
                return I;
            }
        }
        return super.C(i4);
    }

    public void C2(int i4) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i4);
        }
        g(null);
        if (i4 != this.f1748s || this.f1750u == null) {
            j b5 = j.b(this, i4);
            this.f1750u = b5;
            this.E.f1756a = b5;
            this.f1748s = i4;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    public void D2(boolean z4) {
        g(null);
        if (z4 == this.f1752w) {
            return;
        }
        this.f1752w = z4;
        t1();
    }

    public void E2(boolean z4) {
        g(null);
        if (this.f1754y == z4) {
            return;
        }
        this.f1754y = z4;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean G1() {
        return (X() == 1073741824 || p0() == 1073741824 || !q0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.I0(recyclerView, vVar);
        if (this.C) {
            k1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i4) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i4);
        J1(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int R1;
        A2();
        if (J() == 0 || (R1 = R1(i4)) == Integer.MIN_VALUE) {
            return null;
        }
        T1();
        I2(R1, (int) (this.f1750u.n() * 0.33333334f), false, a0Var);
        c cVar = this.f1749t;
        cVar.f1771g = RecyclerView.UNDEFINED_DURATION;
        cVar.f1765a = false;
        U1(vVar, cVar, a0Var, true);
        View g22 = R1 == -1 ? g2() : f2();
        View n22 = R1 == -1 ? n2() : m2();
        if (!n22.hasFocusable()) {
            return g22;
        }
        if (g22 == null) {
            return null;
        }
        return n22;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(Z1());
            accessibilityEvent.setToIndex(c2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.D == null && this.f1751v == this.f1754y;
    }

    protected void M1(RecyclerView.a0 a0Var, int[] iArr) {
        int i4;
        int o22 = o2(a0Var);
        if (this.f1749t.f1770f == -1) {
            i4 = 0;
        } else {
            i4 = o22;
            o22 = 0;
        }
        iArr[0] = o22;
        iArr[1] = i4;
    }

    void N1(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i4 = cVar.f1768d;
        if (i4 < 0 || i4 >= a0Var.b()) {
            return;
        }
        cVar2.a(i4, Math.max(0, cVar.f1771g));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int R1(int i4) {
        if (i4 == 1) {
            return (this.f1748s != 1 && q2()) ? 1 : -1;
        }
        if (i4 == 2) {
            return (this.f1748s != 1 && q2()) ? -1 : 1;
        }
        if (i4 == 17) {
            if (this.f1748s == 0) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i4 == 33) {
            if (this.f1748s == 1) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i4 == 66) {
            if (this.f1748s == 0) {
                return 1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i4 == 130 && this.f1748s == 1) {
            return 1;
        }
        return RecyclerView.UNDEFINED_DURATION;
    }

    c S1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T1() {
        if (this.f1749t == null) {
            this.f1749t = S1();
        }
    }

    int U1(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z4) {
        int i4 = cVar.f1767c;
        int i5 = cVar.f1771g;
        if (i5 != Integer.MIN_VALUE) {
            if (i4 < 0) {
                cVar.f1771g = i5 + i4;
            }
            v2(vVar, cVar);
        }
        int i6 = cVar.f1767c + cVar.f1772h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f1777m && i6 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            s2(vVar, a0Var, cVar, bVar);
            if (!bVar.f1762b) {
                cVar.f1766b += bVar.f1761a * cVar.f1770f;
                if (!bVar.f1763c || cVar.f1776l != null || !a0Var.e()) {
                    int i7 = cVar.f1767c;
                    int i8 = bVar.f1761a;
                    cVar.f1767c = i7 - i8;
                    i6 -= i8;
                }
                int i9 = cVar.f1771g;
                if (i9 != Integer.MIN_VALUE) {
                    int i10 = i9 + bVar.f1761a;
                    cVar.f1771g = i10;
                    int i11 = cVar.f1767c;
                    if (i11 < 0) {
                        cVar.f1771g = i10 + i11;
                    }
                    v2(vVar, cVar);
                }
                if (z4 && bVar.f1764d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i4 - cVar.f1767c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i4;
        int i5;
        int i6;
        int i7;
        int k22;
        int i8;
        View C;
        int g4;
        int i9;
        int i10 = -1;
        if (!(this.D == null && this.A == -1) && a0Var.b() == 0) {
            k1(vVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.f()) {
            this.A = this.D.f1778b;
        }
        T1();
        this.f1749t.f1765a = false;
        A2();
        View V = V();
        a aVar = this.E;
        if (!aVar.f1760e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.f1759d = this.f1753x ^ this.f1754y;
            H2(vVar, a0Var, aVar2);
            this.E.f1760e = true;
        } else if (V != null && (this.f1750u.g(V) >= this.f1750u.i() || this.f1750u.d(V) <= this.f1750u.m())) {
            this.E.c(V, h0(V));
        }
        c cVar = this.f1749t;
        cVar.f1770f = cVar.f1775k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(a0Var, iArr);
        int max = Math.max(0, this.H[0]) + this.f1750u.m();
        int max2 = Math.max(0, this.H[1]) + this.f1750u.j();
        if (a0Var.e() && (i8 = this.A) != -1 && this.B != Integer.MIN_VALUE && (C = C(i8)) != null) {
            if (this.f1753x) {
                i9 = this.f1750u.i() - this.f1750u.d(C);
                g4 = this.B;
            } else {
                g4 = this.f1750u.g(C) - this.f1750u.m();
                i9 = this.B;
            }
            int i11 = i9 - g4;
            if (i11 > 0) {
                max += i11;
            } else {
                max2 -= i11;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.f1759d ? !this.f1753x : this.f1753x) {
            i10 = 1;
        }
        u2(vVar, a0Var, aVar3, i10);
        w(vVar);
        this.f1749t.f1777m = z2();
        this.f1749t.f1774j = a0Var.e();
        this.f1749t.f1773i = 0;
        a aVar4 = this.E;
        if (aVar4.f1759d) {
            M2(aVar4);
            c cVar2 = this.f1749t;
            cVar2.f1772h = max;
            U1(vVar, cVar2, a0Var, false);
            c cVar3 = this.f1749t;
            i5 = cVar3.f1766b;
            int i12 = cVar3.f1768d;
            int i13 = cVar3.f1767c;
            if (i13 > 0) {
                max2 += i13;
            }
            K2(this.E);
            c cVar4 = this.f1749t;
            cVar4.f1772h = max2;
            cVar4.f1768d += cVar4.f1769e;
            U1(vVar, cVar4, a0Var, false);
            c cVar5 = this.f1749t;
            i4 = cVar5.f1766b;
            int i14 = cVar5.f1767c;
            if (i14 > 0) {
                L2(i12, i5);
                c cVar6 = this.f1749t;
                cVar6.f1772h = i14;
                U1(vVar, cVar6, a0Var, false);
                i5 = this.f1749t.f1766b;
            }
        } else {
            K2(aVar4);
            c cVar7 = this.f1749t;
            cVar7.f1772h = max2;
            U1(vVar, cVar7, a0Var, false);
            c cVar8 = this.f1749t;
            i4 = cVar8.f1766b;
            int i15 = cVar8.f1768d;
            int i16 = cVar8.f1767c;
            if (i16 > 0) {
                max += i16;
            }
            M2(this.E);
            c cVar9 = this.f1749t;
            cVar9.f1772h = max;
            cVar9.f1768d += cVar9.f1769e;
            U1(vVar, cVar9, a0Var, false);
            c cVar10 = this.f1749t;
            i5 = cVar10.f1766b;
            int i17 = cVar10.f1767c;
            if (i17 > 0) {
                J2(i15, i4);
                c cVar11 = this.f1749t;
                cVar11.f1772h = i17;
                U1(vVar, cVar11, a0Var, false);
                i4 = this.f1749t.f1766b;
            }
        }
        if (J() > 0) {
            if (this.f1753x ^ this.f1754y) {
                int k23 = k2(i4, vVar, a0Var, true);
                i6 = i5 + k23;
                i7 = i4 + k23;
                k22 = l2(i6, vVar, a0Var, false);
            } else {
                int l22 = l2(i5, vVar, a0Var, true);
                i6 = i5 + l22;
                i7 = i4 + l22;
                k22 = k2(i7, vVar, a0Var, false);
            }
            i5 = i6 + k22;
            i4 = i7 + k22;
        }
        t2(vVar, a0Var, i5, i4);
        if (a0Var.e()) {
            this.E.e();
        } else {
            this.f1750u.s();
        }
        this.f1751v = this.f1754y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View X1(boolean z4, boolean z5) {
        int J;
        int i4;
        if (this.f1753x) {
            J = 0;
            i4 = J();
        } else {
            J = J() - 1;
            i4 = -1;
        }
        return e2(J, i4, z4, z5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.D = null;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.E.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Y1(boolean z4, boolean z5) {
        int i4;
        int J;
        if (this.f1753x) {
            i4 = J() - 1;
            J = -1;
        } else {
            i4 = 0;
            J = J();
        }
        return e2(i4, J, z4, z5);
    }

    public int Z1() {
        View e22 = e2(0, J(), false, true);
        if (e22 == null) {
            return -1;
        }
        return h0(e22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i4) {
        if (J() == 0) {
            return null;
        }
        int i5 = (i4 < h0(I(0))) != this.f1753x ? -1 : 1;
        return this.f1748s == 0 ? new PointF(i5, 0.0f) : new PointF(0.0f, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            t1();
        }
    }

    public int c2() {
        View e22 = e2(J() - 1, -1, false, true);
        if (e22 == null) {
            return -1;
        }
        return h0(e22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        if (this.D != null) {
            return new d(this.D);
        }
        d dVar = new d();
        if (J() > 0) {
            T1();
            boolean z4 = this.f1751v ^ this.f1753x;
            dVar.f1780d = z4;
            if (z4) {
                View m22 = m2();
                dVar.f1779c = this.f1750u.i() - this.f1750u.d(m22);
                dVar.f1778b = h0(m22);
            } else {
                View n22 = n2();
                dVar.f1778b = h0(n22);
                dVar.f1779c = this.f1750u.g(n22) - this.f1750u.m();
            }
        } else {
            dVar.g();
        }
        return dVar;
    }

    View d2(int i4, int i5) {
        int i6;
        int i7;
        T1();
        if ((i5 > i4 ? (char) 1 : i5 < i4 ? (char) 65535 : (char) 0) == 0) {
            return I(i4);
        }
        if (this.f1750u.g(I(i4)) < this.f1750u.m()) {
            i6 = 16644;
            i7 = 16388;
        } else {
            i6 = 4161;
            i7 = 4097;
        }
        return (this.f1748s == 0 ? this.f1846e : this.f1847f).a(i4, i5, i6, i7);
    }

    View e2(int i4, int i5, boolean z4, boolean z5) {
        T1();
        return (this.f1748s == 0 ? this.f1846e : this.f1847f).a(i4, i5, z4 ? 24579 : 320, z5 ? 320 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.D == null) {
            super.g(str);
        }
    }

    View h2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i4, int i5, int i6) {
        T1();
        int m4 = this.f1750u.m();
        int i7 = this.f1750u.i();
        int i8 = i5 > i4 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i4 != i5) {
            View I = I(i4);
            int h02 = h0(I);
            if (h02 >= 0 && h02 < i6) {
                if (((RecyclerView.p) I.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = I;
                    }
                } else {
                    if (this.f1750u.g(I) < i7 && this.f1750u.d(I) >= m4) {
                        return I;
                    }
                    if (view == null) {
                        view = I;
                    }
                }
            }
            i4 += i8;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.f1748s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f1748s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i4, int i5, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.f1748s != 0) {
            i4 = i5;
        }
        if (J() == 0 || i4 == 0) {
            return;
        }
        T1();
        I2(i4 > 0 ? 1 : -1, Math.abs(i4), true, a0Var);
        N1(a0Var, this.f1749t, cVar);
    }

    @Deprecated
    protected int o2(RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            return this.f1750u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i4, RecyclerView.o.c cVar) {
        boolean z4;
        int i5;
        d dVar = this.D;
        if (dVar == null || !dVar.f()) {
            A2();
            z4 = this.f1753x;
            i5 = this.A;
            if (i5 == -1) {
                i5 = z4 ? i4 - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z4 = dVar2.f1780d;
            i5 = dVar2.f1778b;
        }
        int i6 = z4 ? -1 : 1;
        for (int i7 = 0; i7 < this.G && i5 >= 0 && i5 < i4; i7++) {
            cVar.a(i5, 0);
            i5 += i6;
        }
    }

    public int p2() {
        return this.f1748s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return O1(a0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return P1(a0Var);
    }

    public boolean r2() {
        return this.f1755z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return true;
    }

    void s2(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        int f4;
        View d5 = cVar.d(vVar);
        if (d5 == null) {
            bVar.f1762b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) d5.getLayoutParams();
        if (cVar.f1776l == null) {
            if (this.f1753x == (cVar.f1770f == -1)) {
                d(d5);
            } else {
                e(d5, 0);
            }
        } else {
            if (this.f1753x == (cVar.f1770f == -1)) {
                b(d5);
            } else {
                c(d5, 0);
            }
        }
        A0(d5, 0, 0);
        bVar.f1761a = this.f1750u.e(d5);
        if (this.f1748s == 1) {
            if (q2()) {
                f4 = o0() - f0();
                i7 = f4 - this.f1750u.f(d5);
            } else {
                i7 = e0();
                f4 = this.f1750u.f(d5) + i7;
            }
            int i8 = cVar.f1770f;
            int i9 = cVar.f1766b;
            if (i8 == -1) {
                i6 = i9;
                i5 = f4;
                i4 = i9 - bVar.f1761a;
            } else {
                i4 = i9;
                i5 = f4;
                i6 = bVar.f1761a + i9;
            }
        } else {
            int g02 = g0();
            int f5 = this.f1750u.f(d5) + g02;
            int i10 = cVar.f1770f;
            int i11 = cVar.f1766b;
            if (i10 == -1) {
                i5 = i11;
                i4 = g02;
                i6 = f5;
                i7 = i11 - bVar.f1761a;
            } else {
                i4 = g02;
                i5 = bVar.f1761a + i11;
                i6 = f5;
                i7 = i11;
            }
        }
        z0(d5, i7, i4, i5, i6);
        if (pVar.c() || pVar.b()) {
            bVar.f1763c = true;
        }
        bVar.f1764d = d5.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return O1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return P1(a0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i4) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f1748s == 1) {
            return 0;
        }
        return B2(i4, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i4) {
        this.A = i4;
        this.B = RecyclerView.UNDEFINED_DURATION;
        d dVar = this.D;
        if (dVar != null) {
            dVar.g();
        }
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f1748s == 0) {
            return 0;
        }
        return B2(i4, vVar, a0Var);
    }

    boolean z2() {
        return this.f1750u.k() == 0 && this.f1750u.h() == 0;
    }
}
