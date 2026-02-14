package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f2108a;

    /* renamed from: b, reason: collision with root package name */
    private final SavedStateRegistry f2109b = new SavedStateRegistry();

    private a(b bVar) {
        this.f2108a = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public SavedStateRegistry b() {
        return this.f2109b;
    }

    public void c(Bundle bundle) {
        d a5 = this.f2108a.a();
        if (a5.b() != d.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        a5.a(new Recreator(this.f2108a));
        this.f2109b.b(a5, bundle);
    }

    public void d(Bundle bundle) {
        this.f2109b.c(bundle);
    }
}
