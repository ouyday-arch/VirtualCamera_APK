package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1696a;

    /* renamed from: b, reason: collision with root package name */
    private final a.C0012a f1697b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1696a = obj;
        this.f1697b = a.f1699c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        this.f1697b.a(gVar, aVar, this.f1696a);
    }
}
