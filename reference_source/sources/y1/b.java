package y1;

import java.util.Objects;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final x1.b f6591a;

    /* renamed from: b, reason: collision with root package name */
    private final x1.b f6592b;

    /* renamed from: c, reason: collision with root package name */
    private final x1.c f6593c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(x1.b bVar, x1.b bVar2, x1.c cVar) {
        this.f6591a = bVar;
        this.f6592b = bVar2;
        this.f6593c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1.c a() {
        return this.f6593c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1.b b() {
        return this.f6591a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1.b c() {
        return this.f6592b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f6592b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f6591a, bVar.f6591a) && Objects.equals(this.f6592b, bVar.f6592b) && Objects.equals(this.f6593c, bVar.f6593c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f6591a) ^ Objects.hashCode(this.f6592b)) ^ Objects.hashCode(this.f6593c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f6591a);
        sb.append(" , ");
        sb.append(this.f6592b);
        sb.append(" : ");
        x1.c cVar = this.f6593c;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
