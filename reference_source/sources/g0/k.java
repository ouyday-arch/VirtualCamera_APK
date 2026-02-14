package g0;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f3832a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f3833b;

    public static k b(ViewGroup viewGroup) {
        return (k) viewGroup.getTag(i.f3830b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ViewGroup viewGroup, k kVar) {
        viewGroup.setTag(i.f3830b, kVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f3832a) != this || (runnable = this.f3833b) == null) {
            return;
        }
        runnable.run();
    }
}
