package androidx.loader.app;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import k.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends androidx.loader.app.a {

    /* renamed from: c, reason: collision with root package name */
    static boolean f1733c;

    /* renamed from: a, reason: collision with root package name */
    private final g f1734a;

    /* renamed from: b, reason: collision with root package name */
    private final C0013b f1735b;

    /* loaded from: classes.dex */
    public static class a<D> extends l<D> {

        /* renamed from: k, reason: collision with root package name */
        private final int f1736k;

        /* renamed from: l, reason: collision with root package name */
        private final Bundle f1737l;

        /* renamed from: m, reason: collision with root package name */
        private g f1738m;

        @Override // androidx.lifecycle.LiveData
        protected void d() {
            if (b.f1733c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void e() {
            if (b.f1733c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void f(m<? super D> mVar) {
            super.f(mVar);
            this.f1738m = null;
        }

        @Override // androidx.lifecycle.l, androidx.lifecycle.LiveData
        public void g(D d5) {
            super.g(d5);
        }

        e0.a<D> h(boolean z4) {
            if (b.f1733c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            throw null;
        }

        public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f1736k);
            printWriter.print(" mArgs=");
            printWriter.println(this.f1737l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            throw null;
        }

        void j() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f1736k);
            sb.append(" : ");
            x.a.a(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0013b extends p {

        /* renamed from: e, reason: collision with root package name */
        private static final q.a f1739e = new a();

        /* renamed from: c, reason: collision with root package name */
        private h<a> f1740c = new h<>();

        /* renamed from: d, reason: collision with root package name */
        private boolean f1741d = false;

        /* renamed from: androidx.loader.app.b$b$a */
        /* loaded from: classes.dex */
        static class a implements q.a {
            a() {
            }

            @Override // androidx.lifecycle.q.a
            public <T extends p> T a(Class<T> cls) {
                return new C0013b();
            }
        }

        C0013b() {
        }

        static C0013b e(r rVar) {
            return (C0013b) new q(rVar, f1739e).a(C0013b.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.p
        public void c() {
            super.c();
            int m4 = this.f1740c.m();
            for (int i4 = 0; i4 < m4; i4++) {
                this.f1740c.n(i4).h(true);
            }
            this.f1740c.b();
        }

        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f1740c.m() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i4 = 0; i4 < this.f1740c.m(); i4++) {
                    a n4 = this.f1740c.n(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f1740c.j(i4));
                    printWriter.print(": ");
                    printWriter.println(n4.toString());
                    n4.i(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void f() {
            int m4 = this.f1740c.m();
            for (int i4 = 0; i4 < m4; i4++) {
                this.f1740c.n(i4).j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, r rVar) {
        this.f1734a = gVar;
        this.f1735b = C0013b.e(rVar);
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f1735b.d(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f1735b.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        x.a.a(this.f1734a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
