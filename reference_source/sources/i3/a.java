package i3;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class a<T> implements c<T>, b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final c<T> f4144a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4145b;

    /* renamed from: i3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0048a implements Iterator<T>, f3.a {

        /* renamed from: b, reason: collision with root package name */
        private final Iterator<T> f4146b;

        /* renamed from: c, reason: collision with root package name */
        private int f4147c;

        C0048a(a<T> aVar) {
            this.f4146b = ((a) aVar).f4144a.iterator();
            this.f4147c = ((a) aVar).f4145b;
        }

        private final void a() {
            while (this.f4147c > 0 && this.f4146b.hasNext()) {
                this.f4146b.next();
                this.f4147c--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f4146b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f4146b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, int i4) {
        e3.f.e(cVar, "sequence");
        this.f4144a = cVar;
        this.f4145b = i4;
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i4 + '.').toString());
    }

    @Override // i3.b
    public c<T> a(int i4) {
        int i5 = this.f4145b + i4;
        return i5 < 0 ? new a(this, i4) : new a(this.f4144a, i5);
    }

    @Override // i3.c
    public Iterator<T> iterator() {
        return new C0048a(this);
    }
}
