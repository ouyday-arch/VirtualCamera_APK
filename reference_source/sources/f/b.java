package f;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: b, reason: collision with root package name */
    private Object f3635b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3636c;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(b bVar, MenuItem menuItem);

        boolean b(b bVar, Menu menu);

        void c(b bVar);

        boolean d(b bVar, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f3635b;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f3636c;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i4);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f3635b = obj;
    }

    public abstract void q(int i4);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z4) {
        this.f3636c = z4;
    }
}
