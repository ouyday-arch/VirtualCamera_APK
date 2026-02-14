package s2;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import t2.v;
import t2.w;

/* loaded from: classes.dex */
public abstract class b implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public static ExecutorService f5886b = Executors.newCachedThreadPool();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f5887c = false;

    /* loaded from: classes.dex */
    public static abstract class a {
        public static a a() {
            return new t2.a();
        }

        public abstract a b(int i4);

        public abstract a c(long j4);
    }

    /* renamed from: s2.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0076b {
        void a(b bVar);
    }

    /* loaded from: classes.dex */
    public static class c {
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public abstract void I(Executor executor, f fVar);

        public void J(f fVar) {
            I(v.f6002b, fVar);
        }

        public abstract d K(List<String> list);

        public abstract e i();
    }

    /* loaded from: classes.dex */
    public static abstract class e {
        public abstract int a();

        public abstract List<String> b();

        public abstract List<String> c();
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(e eVar);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(OutputStream outputStream, InputStream inputStream, InputStream inputStream2);
    }

    public static d I(String... strArr) {
        return t2.g.h(false, strArr);
    }

    public static b J() {
        return t2.g.c();
    }

    public static void K(InterfaceC0076b interfaceC0076b) {
        t2.g.d(v.f6002b, interfaceC0076b);
    }

    public static void N(a aVar) {
        t2.g.j(aVar);
    }

    public static void i(String str) {
        w.a(str);
    }

    public abstract int L();

    public boolean M() {
        return L() >= 1;
    }
}
