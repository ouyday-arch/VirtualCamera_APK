package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    final InterfaceC0016b f1953a;

    /* renamed from: b, reason: collision with root package name */
    final a f1954b = new a();

    /* renamed from: c, reason: collision with root package name */
    final List<View> f1955c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f1956a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f1957b;

        a() {
        }

        private void c() {
            if (this.f1957b == null) {
                this.f1957b = new a();
            }
        }

        void a(int i4) {
            if (i4 < 64) {
                this.f1956a &= ~(1 << i4);
                return;
            }
            a aVar = this.f1957b;
            if (aVar != null) {
                aVar.a(i4 - 64);
            }
        }

        int b(int i4) {
            a aVar = this.f1957b;
            return aVar == null ? i4 >= 64 ? Long.bitCount(this.f1956a) : Long.bitCount(this.f1956a & ((1 << i4) - 1)) : i4 < 64 ? Long.bitCount(this.f1956a & ((1 << i4) - 1)) : aVar.b(i4 - 64) + Long.bitCount(this.f1956a);
        }

        boolean d(int i4) {
            if (i4 < 64) {
                return (this.f1956a & (1 << i4)) != 0;
            }
            c();
            return this.f1957b.d(i4 - 64);
        }

        void e(int i4, boolean z4) {
            if (i4 >= 64) {
                c();
                this.f1957b.e(i4 - 64, z4);
                return;
            }
            long j4 = this.f1956a;
            boolean z5 = (Long.MIN_VALUE & j4) != 0;
            long j5 = (1 << i4) - 1;
            this.f1956a = ((j4 & (~j5)) << 1) | (j4 & j5);
            if (z4) {
                h(i4);
            } else {
                a(i4);
            }
            if (z5 || this.f1957b != null) {
                c();
                this.f1957b.e(0, z5);
            }
        }

        boolean f(int i4) {
            if (i4 >= 64) {
                c();
                return this.f1957b.f(i4 - 64);
            }
            long j4 = 1 << i4;
            long j5 = this.f1956a;
            boolean z4 = (j5 & j4) != 0;
            long j6 = j5 & (~j4);
            this.f1956a = j6;
            long j7 = j4 - 1;
            this.f1956a = (j6 & j7) | Long.rotateRight((~j7) & j6, 1);
            a aVar = this.f1957b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f1957b.f(0);
            }
            return z4;
        }

        void g() {
            this.f1956a = 0L;
            a aVar = this.f1957b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i4) {
            if (i4 < 64) {
                this.f1956a |= 1 << i4;
            } else {
                c();
                this.f1957b.h(i4 - 64);
            }
        }

        public String toString() {
            if (this.f1957b == null) {
                return Long.toBinaryString(this.f1956a);
            }
            return this.f1957b.toString() + "xx" + Long.toBinaryString(this.f1956a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0016b {
        View a(int i4);

        void b(View view);

        void c(int i4);

        void d();

        RecyclerView.d0 e(View view);

        void f(int i4);

        void g(View view);

        void h(View view, int i4, ViewGroup.LayoutParams layoutParams);

        void i(View view, int i4);

        int j(View view);

        int k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InterfaceC0016b interfaceC0016b) {
        this.f1953a = interfaceC0016b;
    }

    private int h(int i4) {
        if (i4 < 0) {
            return -1;
        }
        int k4 = this.f1953a.k();
        int i5 = i4;
        while (i5 < k4) {
            int b5 = i4 - (i5 - this.f1954b.b(i5));
            if (b5 == 0) {
                while (this.f1954b.d(i5)) {
                    i5++;
                }
                return i5;
            }
            i5 += b5;
        }
        return -1;
    }

    private void l(View view) {
        this.f1955c.add(view);
        this.f1953a.b(view);
    }

    private boolean t(View view) {
        if (!this.f1955c.remove(view)) {
            return false;
        }
        this.f1953a.g(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i4, boolean z4) {
        int k4 = i4 < 0 ? this.f1953a.k() : h(i4);
        this.f1954b.e(k4, z4);
        if (z4) {
            l(view);
        }
        this.f1953a.i(view, k4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, boolean z4) {
        a(view, -1, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i4, ViewGroup.LayoutParams layoutParams, boolean z4) {
        int k4 = i4 < 0 ? this.f1953a.k() : h(i4);
        this.f1954b.e(k4, z4);
        if (z4) {
            l(view);
        }
        this.f1953a.h(view, k4, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i4) {
        int h4 = h(i4);
        this.f1954b.f(h4);
        this.f1953a.f(h4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e(int i4) {
        int size = this.f1955c.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f1955c.get(i5);
            RecyclerView.d0 e4 = this.f1953a.e(view);
            if (e4.m() == i4 && !e4.t() && !e4.v()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View f(int i4) {
        return this.f1953a.a(h(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1953a.k() - this.f1955c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View i(int i4) {
        return this.f1953a.a(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f1953a.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(View view) {
        int j4 = this.f1953a.j(view);
        if (j4 >= 0) {
            this.f1954b.h(j4);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(View view) {
        int j4 = this.f1953a.j(view);
        if (j4 == -1 || this.f1954b.d(j4)) {
            return -1;
        }
        return j4 - this.f1954b.b(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f1955c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f1954b.g();
        for (int size = this.f1955c.size() - 1; size >= 0; size--) {
            this.f1953a.g(this.f1955c.get(size));
            this.f1955c.remove(size);
        }
        this.f1953a.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view) {
        int j4 = this.f1953a.j(view);
        if (j4 < 0) {
            return;
        }
        if (this.f1954b.f(j4)) {
            t(view);
        }
        this.f1953a.c(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i4) {
        int h4 = h(i4);
        View a5 = this.f1953a.a(h4);
        if (a5 == null) {
            return;
        }
        if (this.f1954b.f(h4)) {
            t(a5);
        }
        this.f1953a.c(h4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(View view) {
        int j4 = this.f1953a.j(view);
        if (j4 == -1) {
            t(view);
            return true;
        }
        if (!this.f1954b.d(j4)) {
            return false;
        }
        this.f1954b.f(j4);
        t(view);
        this.f1953a.c(j4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(View view) {
        int j4 = this.f1953a.j(view);
        if (j4 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f1954b.d(j4)) {
            this.f1954b.a(j4);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f1954b.toString() + ", hidden list:" + this.f1955c.size();
    }
}
