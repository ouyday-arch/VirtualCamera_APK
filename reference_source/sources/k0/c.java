package k0;

import j0.a;
import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;

/* loaded from: classes.dex */
public class c extends j0.b {

    /* renamed from: a, reason: collision with root package name */
    private ProxyControllerBoundaryInterface f4342a;

    private ProxyControllerBoundaryInterface c() {
        if (this.f4342a == null) {
            this.f4342a = e.c().getProxyController();
        }
        return this.f4342a;
    }

    public static String[][] d(List<a.b> list) {
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, list.size(), 2);
        for (int i4 = 0; i4 < list.size(); i4++) {
            strArr[i4][0] = list.get(i4).a();
            strArr[i4][1] = list.get(i4).b();
        }
        return strArr;
    }

    @Override // j0.b
    public void b(j0.a aVar, Executor executor, Runnable runnable) {
        if (!d.PROXY_OVERRIDE.g()) {
            throw d.a();
        }
        c().setProxyOverride(d(aVar.b()), (String[]) aVar.a().toArray(new String[0]), runnable, executor);
    }
}
