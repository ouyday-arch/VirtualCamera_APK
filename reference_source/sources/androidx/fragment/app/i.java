package androidx.fragment.app;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: c, reason: collision with root package name */
    static final g f1502c = new g();

    /* renamed from: b, reason: collision with root package name */
    private g f1503b = null;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public abstract n a();

    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public g c() {
        if (this.f1503b == null) {
            this.f1503b = f1502c;
        }
        return this.f1503b;
    }

    public abstract List<Fragment> d();

    public abstract void e(int i4, int i5);

    public abstract boolean f();

    public void g(g gVar) {
        this.f1503b = gVar;
    }
}
