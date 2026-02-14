package q3;

import java.util.LinkedHashSet;
import java.util.Set;
import l3.e0;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final Set<e0> f5738a = new LinkedHashSet();

    public final synchronized void a(e0 e0Var) {
        e3.f.e(e0Var, "route");
        this.f5738a.remove(e0Var);
    }

    public final synchronized void b(e0 e0Var) {
        e3.f.e(e0Var, "failedRoute");
        this.f5738a.add(e0Var);
    }

    public final synchronized boolean c(e0 e0Var) {
        e3.f.e(e0Var, "route");
        return this.f5738a.contains(e0Var);
    }
}
