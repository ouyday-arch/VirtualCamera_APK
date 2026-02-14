package androidx.fragment.app;

import androidx.lifecycle.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements androidx.lifecycle.g {

    /* renamed from: b, reason: collision with root package name */
    private androidx.lifecycle.h f1673b = null;

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.d a() {
        e();
        return this.f1673b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d.a aVar) {
        this.f1673b.i(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f1673b == null) {
            this.f1673b = new androidx.lifecycle.h(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f1673b != null;
    }
}
