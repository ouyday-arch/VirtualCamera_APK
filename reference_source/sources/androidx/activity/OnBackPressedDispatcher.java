package androidx.activity;

import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f326a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayDeque<b> f327b = new ArrayDeque<>();

    /* loaded from: classes.dex */
    private class LifecycleOnBackPressedCancellable implements e, androidx.activity.a {

        /* renamed from: a, reason: collision with root package name */
        private final d f328a;

        /* renamed from: b, reason: collision with root package name */
        private final b f329b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.activity.a f330c;

        LifecycleOnBackPressedCancellable(d dVar, b bVar) {
            this.f328a = dVar;
            this.f329b = bVar;
            dVar.a(this);
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f328a.c(this);
            this.f329b.e(this);
            androidx.activity.a aVar = this.f330c;
            if (aVar != null) {
                aVar.cancel();
                this.f330c = null;
            }
        }

        @Override // androidx.lifecycle.e
        public void d(g gVar, d.a aVar) {
            if (aVar == d.a.ON_START) {
                this.f330c = OnBackPressedDispatcher.this.b(this.f329b);
                return;
            }
            if (aVar != d.a.ON_STOP) {
                if (aVar == d.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar2 = this.f330c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.a {

        /* renamed from: a, reason: collision with root package name */
        private final b f332a;

        a(b bVar) {
            this.f332a = bVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f327b.remove(this.f332a);
            this.f332a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f326a = runnable;
    }

    public void a(g gVar, b bVar) {
        d a5 = gVar.a();
        if (a5.b() == d.b.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(a5, bVar));
    }

    androidx.activity.a b(b bVar) {
        this.f327b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator<b> descendingIterator = this.f327b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f326a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
