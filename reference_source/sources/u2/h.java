package u2;

import java.io.Serializable;

/* loaded from: classes.dex */
final class h<T> implements c<T>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    private d3.a<? extends T> f6219b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Object f6220c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f6221d;

    public h(d3.a<? extends T> aVar, Object obj) {
        e3.f.e(aVar, "initializer");
        this.f6219b = aVar;
        this.f6220c = j.f6222a;
        this.f6221d = obj == null ? this : obj;
    }

    public /* synthetic */ h(d3.a aVar, Object obj, int i4, e3.d dVar) {
        this(aVar, (i4 & 2) != 0 ? null : obj);
    }

    public boolean a() {
        return this.f6220c != j.f6222a;
    }

    @Override // u2.c
    public T getValue() {
        T t4;
        T t5 = (T) this.f6220c;
        j jVar = j.f6222a;
        if (t5 != jVar) {
            return t5;
        }
        synchronized (this.f6221d) {
            t4 = (T) this.f6220c;
            if (t4 == jVar) {
                d3.a<? extends T> aVar = this.f6219b;
                e3.f.b(aVar);
                t4 = aVar.d();
                this.f6220c = t4;
                this.f6219b = null;
            }
        }
        return t4;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
