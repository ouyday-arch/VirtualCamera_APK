package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class h extends n {

    /* renamed from: d, reason: collision with root package name */
    private j f2072d;

    /* renamed from: e, reason: collision with root package name */
    private j f2073e;

    private float m(RecyclerView.o oVar, j jVar) {
        int J = oVar.J();
        if (J == 0) {
            return 1.0f;
        }
        View view = null;
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i6 = 0; i6 < J; i6++) {
            View I = oVar.I(i6);
            int h02 = oVar.h0(I);
            if (h02 != -1) {
                if (h02 < i5) {
                    view = I;
                    i5 = h02;
                }
                if (h02 > i4) {
                    view2 = I;
                    i4 = h02;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(jVar.d(view), jVar.d(view2)) - Math.min(jVar.g(view), jVar.g(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i4 - i5) + 1);
    }

    private int n(RecyclerView.o oVar, View view, j jVar) {
        return (jVar.g(view) + (jVar.e(view) / 2)) - (jVar.m() + (jVar.n() / 2));
    }

    private int o(RecyclerView.o oVar, j jVar, int i4, int i5) {
        int[] d5 = d(i4, i5);
        float m4 = m(oVar, jVar);
        if (m4 <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(d5[0]) > Math.abs(d5[1]) ? d5[0] : d5[1]) / m4);
    }

    private View p(RecyclerView.o oVar, j jVar) {
        int J = oVar.J();
        View view = null;
        if (J == 0) {
            return null;
        }
        int m4 = jVar.m() + (jVar.n() / 2);
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < J; i5++) {
            View I = oVar.I(i5);
            int abs = Math.abs((jVar.g(I) + (jVar.e(I) / 2)) - m4);
            if (abs < i4) {
                view = I;
                i4 = abs;
            }
        }
        return view;
    }

    private j q(RecyclerView.o oVar) {
        j jVar = this.f2073e;
        if (jVar == null || jVar.f2075a != oVar) {
            this.f2073e = j.a(oVar);
        }
        return this.f2073e;
    }

    private j r(RecyclerView.o oVar) {
        j jVar = this.f2072d;
        if (jVar == null || jVar.f2075a != oVar) {
            this.f2072d = j.c(oVar);
        }
        return this.f2072d;
    }

    @Override // androidx.recyclerview.widget.n
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.k()) {
            iArr[0] = n(oVar, view, q(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.l()) {
            iArr[1] = n(oVar, view, r(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.n
    public View h(RecyclerView.o oVar) {
        j q4;
        if (oVar.l()) {
            q4 = r(oVar);
        } else {
            if (!oVar.k()) {
                return null;
            }
            q4 = q(oVar);
        }
        return p(oVar, q4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.n
    public int i(RecyclerView.o oVar, int i4, int i5) {
        int Y;
        View h4;
        int h02;
        int i6;
        PointF a5;
        int i7;
        int i8;
        if (!(oVar instanceof RecyclerView.z.b) || (Y = oVar.Y()) == 0 || (h4 = h(oVar)) == null || (h02 = oVar.h0(h4)) == -1 || (a5 = ((RecyclerView.z.b) oVar).a(Y - 1)) == null) {
            return -1;
        }
        if (oVar.k()) {
            i7 = o(oVar, q(oVar), i4, 0);
            if (a5.x < 0.0f) {
                i7 = -i7;
            }
        } else {
            i7 = 0;
        }
        if (oVar.l()) {
            i8 = o(oVar, r(oVar), 0, i5);
            if (a5.y < 0.0f) {
                i8 = -i8;
            }
        } else {
            i8 = 0;
        }
        if (oVar.l()) {
            i7 = i8;
        }
        if (i7 == 0) {
            return -1;
        }
        int i9 = h02 + i7;
        int i10 = i9 >= 0 ? i9 : 0;
        return i10 >= Y ? i6 : i10;
    }
}
