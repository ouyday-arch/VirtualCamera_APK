package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f334a;

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f335b = new CopyOnWriteArrayList<>();

    public b(boolean z4) {
        this.f334a = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f335b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f334a;
    }

    public final void d() {
        Iterator<a> it = this.f335b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f335b.remove(aVar);
    }

    public final void f(boolean z4) {
        this.f334a = z4;
    }
}
