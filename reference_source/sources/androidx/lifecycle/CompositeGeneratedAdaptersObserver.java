package androidx.lifecycle;

import androidx.lifecycle.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements e {

    /* renamed from: a, reason: collision with root package name */
    private final c[] f1674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f1674a = cVarArr;
    }

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        k kVar = new k();
        for (c cVar : this.f1674a) {
            cVar.a(gVar, aVar, false, kVar);
        }
        for (c cVar2 : this.f1674a) {
            cVar2.a(gVar, aVar, true, kVar);
        }
    }
}
