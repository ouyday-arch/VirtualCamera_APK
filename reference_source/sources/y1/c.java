package y1;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final List<b> f6594a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6595b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6596c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<b> list, int i4, boolean z4) {
        this.f6594a = new ArrayList(list);
        this.f6595b = i4;
        this.f6596c = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> a() {
        return this.f6594a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f6595b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(List<b> list) {
        return this.f6594a.equals(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6594a.equals(cVar.f6594a) && this.f6596c == cVar.f6596c;
    }

    public int hashCode() {
        return this.f6594a.hashCode() ^ Boolean.valueOf(this.f6596c).hashCode();
    }

    public String toString() {
        return "{ " + this.f6594a + " }";
    }
}
