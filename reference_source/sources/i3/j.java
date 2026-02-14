package i3;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class j<T, R> implements c<R> {

    /* renamed from: a, reason: collision with root package name */
    private final c<T> f4149a;

    /* renamed from: b, reason: collision with root package name */
    private final d3.b<T, R> f4150b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<R>, f3.a {

        /* renamed from: b, reason: collision with root package name */
        private final Iterator<T> f4151b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j<T, R> f4152c;

        a(j<T, R> jVar) {
            this.f4152c = jVar;
            this.f4151b = ((j) jVar).f4149a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4151b.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((j) this.f4152c).f4150b.b(this.f4151b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(c<? extends T> cVar, d3.b<? super T, ? extends R> bVar) {
        e3.f.e(cVar, "sequence");
        e3.f.e(bVar, "transformer");
        this.f4149a = cVar;
        this.f4150b = bVar;
    }

    @Override // i3.c
    public Iterator<R> iterator() {
        return new a(this);
    }
}
