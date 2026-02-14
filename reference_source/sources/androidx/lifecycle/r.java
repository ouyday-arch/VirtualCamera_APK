package androidx.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, p> f1732a = new HashMap<>();

    public final void a() {
        Iterator<p> it = this.f1732a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f1732a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final p b(String str) {
        return this.f1732a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(String str, p pVar) {
        p put = this.f1732a.put(str, pVar);
        if (put != null) {
            put.c();
        }
    }
}
