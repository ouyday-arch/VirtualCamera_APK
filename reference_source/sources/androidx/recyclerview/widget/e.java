package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    static final ThreadLocal<e> f2040f = new ThreadLocal<>();

    /* renamed from: g, reason: collision with root package name */
    static Comparator<c> f2041g = new a();

    /* renamed from: c, reason: collision with root package name */
    long f2043c;

    /* renamed from: d, reason: collision with root package name */
    long f2044d;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<RecyclerView> f2042b = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<c> f2045e = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f2053d;
            if ((recyclerView == null) != (cVar2.f2053d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z4 = cVar.f2050a;
            if (z4 != cVar2.f2050a) {
                return z4 ? -1 : 1;
            }
            int i4 = cVar2.f2051b - cVar.f2051b;
            if (i4 != 0) {
                return i4;
            }
            int i5 = cVar.f2052c - cVar2.f2052c;
            if (i5 != 0) {
                return i5;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.o.c {

        /* renamed from: a, reason: collision with root package name */
        int f2046a;

        /* renamed from: b, reason: collision with root package name */
        int f2047b;

        /* renamed from: c, reason: collision with root package name */
        int[] f2048c;

        /* renamed from: d, reason: collision with root package name */
        int f2049d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i4, int i5) {
            if (i4 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i5 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i6 = this.f2049d * 2;
            int[] iArr = this.f2048c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f2048c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i6 >= iArr.length) {
                int[] iArr3 = new int[i6 * 2];
                this.f2048c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f2048c;
            iArr4[i6] = i4;
            iArr4[i6 + 1] = i5;
            this.f2049d++;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f2048c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2049d = 0;
        }

        void c(RecyclerView recyclerView, boolean z4) {
            this.f2049d = 0;
            int[] iArr = this.f2048c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || oVar == null || !oVar.u0()) {
                return;
            }
            if (z4) {
                if (!recyclerView.mAdapterHelper.p()) {
                    oVar.p(recyclerView.mAdapter.c(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                oVar.o(this.f2046a, this.f2047b, recyclerView.mState, this);
            }
            int i4 = this.f2049d;
            if (i4 > oVar.f1854m) {
                oVar.f1854m = i4;
                oVar.f1855n = z4;
                recyclerView.mRecycler.K();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d(int i4) {
            if (this.f2048c != null) {
                int i5 = this.f2049d * 2;
                for (int i6 = 0; i6 < i5; i6 += 2) {
                    if (this.f2048c[i6] == i4) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i4, int i5) {
            this.f2046a = i4;
            this.f2047b = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f2050a;

        /* renamed from: b, reason: collision with root package name */
        public int f2051b;

        /* renamed from: c, reason: collision with root package name */
        public int f2052c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f2053d;

        /* renamed from: e, reason: collision with root package name */
        public int f2054e;

        c() {
        }

        public void a() {
            this.f2050a = false;
            this.f2051b = 0;
            this.f2052c = 0;
            this.f2053d = null;
            this.f2054e = 0;
        }
    }

    private void b() {
        c cVar;
        int size = this.f2042b.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView = this.f2042b.get(i5);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i4 += recyclerView.mPrefetchRegistry.f2049d;
            }
        }
        this.f2045e.ensureCapacity(i4);
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView recyclerView2 = this.f2042b.get(i7);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.f2046a) + Math.abs(bVar.f2047b);
                for (int i8 = 0; i8 < bVar.f2049d * 2; i8 += 2) {
                    if (i6 >= this.f2045e.size()) {
                        cVar = new c();
                        this.f2045e.add(cVar);
                    } else {
                        cVar = this.f2045e.get(i6);
                    }
                    int[] iArr = bVar.f2048c;
                    int i9 = iArr[i8 + 1];
                    cVar.f2050a = i9 <= abs;
                    cVar.f2051b = abs;
                    cVar.f2052c = i9;
                    cVar.f2053d = recyclerView2;
                    cVar.f2054e = iArr[i8];
                    i6++;
                }
            }
        }
        Collections.sort(this.f2045e, f2041g);
    }

    private void c(c cVar, long j4) {
        RecyclerView.d0 i4 = i(cVar.f2053d, cVar.f2054e, cVar.f2050a ? Long.MAX_VALUE : j4);
        if (i4 == null || i4.f1810b == null || !i4.s() || i4.t()) {
            return;
        }
        h(i4.f1810b.get(), j4);
    }

    private void d(long j4) {
        for (int i4 = 0; i4 < this.f2045e.size(); i4++) {
            c cVar = this.f2045e.get(i4);
            if (cVar.f2053d == null) {
                return;
            }
            c(cVar, j4);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i4) {
        int j4 = recyclerView.mChildHelper.j();
        for (int i5 = 0; i5 < j4; i5++) {
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i5));
            if (childViewHolderInt.f1811c == i4 && !childViewHolderInt.t()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j4) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.c(recyclerView, true);
        if (bVar.f2049d != 0) {
            try {
                u.a.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i4 = 0; i4 < bVar.f2049d * 2; i4 += 2) {
                    i(recyclerView, bVar.f2048c[i4], j4);
                }
            } finally {
                u.a.b();
            }
        }
    }

    private RecyclerView.d0 i(RecyclerView recyclerView, int i4, long j4) {
        if (e(recyclerView, i4)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.d0 I = vVar.I(i4, false, j4);
            if (I != null) {
                if (!I.s() || I.t()) {
                    vVar.a(I, false);
                } else {
                    vVar.B(I.f1809a);
                }
            }
            return I;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f2042b.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i4, int i5) {
        if (recyclerView.isAttachedToWindow() && this.f2043c == 0) {
            this.f2043c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.e(i4, i5);
    }

    void g(long j4) {
        b();
        d(j4);
    }

    public void j(RecyclerView recyclerView) {
        this.f2042b.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            u.a.a("RV Prefetch");
            if (!this.f2042b.isEmpty()) {
                int size = this.f2042b.size();
                long j4 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    RecyclerView recyclerView = this.f2042b.get(i4);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j4 = Math.max(recyclerView.getDrawingTime(), j4);
                    }
                }
                if (j4 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j4) + this.f2044d);
                }
            }
        } finally {
            this.f2043c = 0L;
            u.a.b();
        }
    }
}
