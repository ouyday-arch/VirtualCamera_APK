package y2;

import e3.f;
import java.io.Serializable;
import java.lang.Enum;
import v2.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c<T extends Enum<T>> extends v2.b<T> implements a<T>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    private final T[] f6607c;

    public c(T[] tArr) {
        f.e(tArr, "entries");
        this.f6607c = tArr;
    }

    @Override // v2.a
    public int a() {
        return this.f6607c.length;
    }

    public boolean b(T t4) {
        Object r4;
        f.e(t4, "element");
        r4 = j.r(this.f6607c, t4.ordinal());
        return ((Enum) r4) == t4;
    }

    @Override // v2.b, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public T get(int i4) {
        v2.b.f6281b.b(i4, this.f6607c.length);
        return this.f6607c[i4];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v2.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return b((Enum) obj);
        }
        return false;
    }

    public int d(T t4) {
        Object r4;
        f.e(t4, "element");
        int ordinal = t4.ordinal();
        r4 = j.r(this.f6607c, ordinal);
        if (((Enum) r4) == t4) {
            return ordinal;
        }
        return -1;
    }

    public int e(T t4) {
        f.e(t4, "element");
        return indexOf(t4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v2.b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return d((Enum) obj);
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v2.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return e((Enum) obj);
        }
        return -1;
    }
}
