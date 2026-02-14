package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    final b f2089a;

    /* renamed from: b, reason: collision with root package name */
    a f2090b = new a();

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f2091a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f2092b;

        /* renamed from: c, reason: collision with root package name */
        int f2093c;

        /* renamed from: d, reason: collision with root package name */
        int f2094d;

        /* renamed from: e, reason: collision with root package name */
        int f2095e;

        a() {
        }

        void a(int i4) {
            this.f2091a = i4 | this.f2091a;
        }

        boolean b() {
            int i4 = this.f2091a;
            if ((i4 & 7) != 0 && (i4 & (c(this.f2094d, this.f2092b) << 0)) == 0) {
                return false;
            }
            int i5 = this.f2091a;
            if ((i5 & 112) != 0 && (i5 & (c(this.f2094d, this.f2093c) << 4)) == 0) {
                return false;
            }
            int i6 = this.f2091a;
            if ((i6 & 1792) != 0 && (i6 & (c(this.f2095e, this.f2092b) << 8)) == 0) {
                return false;
            }
            int i7 = this.f2091a;
            return (i7 & 28672) == 0 || (i7 & (c(this.f2095e, this.f2093c) << 12)) != 0;
        }

        int c(int i4, int i5) {
            if (i4 > i5) {
                return 1;
            }
            return i4 == i5 ? 2 : 4;
        }

        void d() {
            this.f2091a = 0;
        }

        void e(int i4, int i5, int i6, int i7) {
            this.f2092b = i4;
            this.f2093c = i5;
            this.f2094d = i6;
            this.f2095e = i7;
        }
    }

    /* loaded from: classes.dex */
    interface b {
        View a(int i4);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar) {
        this.f2089a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i4, int i5, int i6, int i7) {
        int c5 = this.f2089a.c();
        int b5 = this.f2089a.b();
        int i8 = i5 > i4 ? 1 : -1;
        View view = null;
        while (i4 != i5) {
            View a5 = this.f2089a.a(i4);
            this.f2090b.e(c5, b5, this.f2089a.e(a5), this.f2089a.d(a5));
            if (i6 != 0) {
                this.f2090b.d();
                this.f2090b.a(i6);
                if (this.f2090b.b()) {
                    return a5;
                }
            }
            if (i7 != 0) {
                this.f2090b.d();
                this.f2090b.a(i7);
                if (this.f2090b.b()) {
                    view = a5;
                }
            }
            i4 += i8;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view, int i4) {
        this.f2090b.e(this.f2089a.c(), this.f2089a.b(), this.f2089a.e(view), this.f2089a.d(view));
        if (i4 == 0) {
            return false;
        }
        this.f2090b.d();
        this.f2090b.a(i4);
        return this.f2090b.b();
    }
}
