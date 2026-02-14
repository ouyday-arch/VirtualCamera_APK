package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b, reason: collision with root package name */
    private Bundle f2104b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2105c;

    /* renamed from: a, reason: collision with root package name */
    private i.b<String, b> f2103a = new i.b<>();

    /* renamed from: d, reason: collision with root package name */
    boolean f2106d = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(androidx.savedstate.b bVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (!this.f2105c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f2104b;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f2104b.remove(str);
        if (this.f2104b.isEmpty()) {
            this.f2104b = null;
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar, Bundle bundle) {
        if (this.f2105c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f2104b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        dVar.a(new e() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.e
            public void d(g gVar, d.a aVar) {
                SavedStateRegistry savedStateRegistry;
                boolean z4;
                if (aVar == d.a.ON_START) {
                    savedStateRegistry = SavedStateRegistry.this;
                    z4 = true;
                } else {
                    if (aVar != d.a.ON_STOP) {
                        return;
                    }
                    savedStateRegistry = SavedStateRegistry.this;
                    z4 = false;
                }
                savedStateRegistry.f2106d = z4;
            }
        });
        this.f2105c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2104b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        i.b<String, b>.d d5 = this.f2103a.d();
        while (d5.hasNext()) {
            Map.Entry next = d5.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
