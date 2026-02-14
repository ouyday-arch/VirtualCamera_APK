package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class f {

    /* renamed from: b, reason: collision with root package name */
    int f2056b;

    /* renamed from: c, reason: collision with root package name */
    int f2057c;

    /* renamed from: d, reason: collision with root package name */
    int f2058d;

    /* renamed from: e, reason: collision with root package name */
    int f2059e;

    /* renamed from: h, reason: collision with root package name */
    boolean f2062h;

    /* renamed from: i, reason: collision with root package name */
    boolean f2063i;

    /* renamed from: a, reason: collision with root package name */
    boolean f2055a = true;

    /* renamed from: f, reason: collision with root package name */
    int f2060f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f2061g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.a0 a0Var) {
        int i4 = this.f2057c;
        return i4 >= 0 && i4 < a0Var.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(RecyclerView.v vVar) {
        View o4 = vVar.o(this.f2057c);
        this.f2057c += this.f2058d;
        return o4;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2056b + ", mCurrentPosition=" + this.f2057c + ", mItemDirection=" + this.f2058d + ", mLayoutDirection=" + this.f2059e + ", mStartLine=" + this.f2060f + ", mEndLine=" + this.f2061g + '}';
    }
}
