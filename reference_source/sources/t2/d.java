package t2;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import s2.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends b.d implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    protected List<String> f5955b;

    /* renamed from: c, reason: collision with root package name */
    protected List<String> f5956c;

    /* renamed from: e, reason: collision with root package name */
    protected p f5958e;

    /* renamed from: d, reason: collision with root package name */
    private final List<q> f5957d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private boolean f5959f = false;

    private m N() {
        List<String> list;
        boolean z4 = !this.f5959f && this.f5958e.f5989f;
        if (z4) {
            this.f5956c = this.f5955b;
        }
        m mVar = new m();
        List<String> list2 = this.f5955b;
        if (list2 == null || list2 != this.f5956c || w.g(list2)) {
            mVar.f5980a = this.f5955b;
            list = this.f5956c;
        } else {
            list = Collections.synchronizedList(this.f5955b);
            mVar.f5980a = list;
        }
        mVar.f5981b = list;
        try {
            try {
                this.f5958e.P(new t(this.f5957d, mVar));
                close();
                mVar.f5980a = this.f5955b;
                mVar.f5981b = z4 ? null : this.f5956c;
                return mVar;
            } catch (IOException e4) {
                if (e4 instanceof r) {
                    m mVar2 = m.f5979e;
                    close();
                    mVar.f5980a = this.f5955b;
                    mVar.f5981b = z4 ? null : this.f5956c;
                    return mVar2;
                }
                w.c(e4);
                m mVar3 = m.f5978d;
                close();
                mVar.f5980a = this.f5955b;
                mVar.f5981b = z4 ? null : this.f5956c;
                return mVar3;
            }
        } catch (Throwable th) {
            close();
            mVar.f5980a = this.f5955b;
            mVar.f5981b = z4 ? null : this.f5956c;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(Executor executor, b.f fVar) {
        N().e(executor, fVar);
    }

    @Override // s2.b.d
    public void I(final Executor executor, final b.f fVar) {
        this.f5958e.f5988e.execute(new Runnable() { // from class: t2.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.O(executor, fVar);
            }
        });
    }

    @Override // s2.b.d
    public b.d K(List<String> list) {
        this.f5955b = list;
        this.f5956c = null;
        this.f5959f = false;
        return this;
    }

    public b.d M(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.f5957d.add(new b(strArr));
        }
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterator<q> it = this.f5957d.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    @Override // s2.b.d
    public b.e i() {
        return N();
    }
}
