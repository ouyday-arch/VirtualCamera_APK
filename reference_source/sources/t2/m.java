package t2;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import s2.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends b.e {

    /* renamed from: d, reason: collision with root package name */
    static m f5978d = new m();

    /* renamed from: e, reason: collision with root package name */
    static m f5979e = new m();

    /* renamed from: a, reason: collision with root package name */
    List<String> f5980a;

    /* renamed from: b, reason: collision with root package name */
    List<String> f5981b;

    /* renamed from: c, reason: collision with root package name */
    int f5982c = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(b.f fVar) {
        fVar.a(this);
    }

    @Override // s2.b.e
    public int a() {
        return this.f5982c;
    }

    @Override // s2.b.e
    public List<String> b() {
        List<String> list = this.f5981b;
        return list == null ? Collections.emptyList() : list;
    }

    @Override // s2.b.e
    public List<String> c() {
        List<String> list = this.f5980a;
        return list == null ? Collections.emptyList() : list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Executor executor, final b.f fVar) {
        if (fVar != null) {
            if (executor == null) {
                fVar.a(this);
            } else {
                executor.execute(new Runnable() { // from class: t2.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.this.f(fVar);
                    }
                });
            }
        }
    }
}
