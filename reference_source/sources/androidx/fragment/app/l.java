package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.q;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends androidx.lifecycle.p {

    /* renamed from: i, reason: collision with root package name */
    private static final q.a f1563i = new a();

    /* renamed from: f, reason: collision with root package name */
    private final boolean f1567f;

    /* renamed from: c, reason: collision with root package name */
    private final HashSet<Fragment> f1564c = new HashSet<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, l> f1565d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, androidx.lifecycle.r> f1566e = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private boolean f1568g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1569h = false;

    /* loaded from: classes.dex */
    static class a implements q.a {
        a() {
        }

        @Override // androidx.lifecycle.q.a
        public <T extends androidx.lifecycle.p> T a(Class<T> cls) {
            return new l(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(boolean z4) {
        this.f1567f = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l g(androidx.lifecycle.r rVar) {
        return (l) new androidx.lifecycle.q(rVar, f1563i).a(l.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.p
    public void c() {
        if (j.I) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1568g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Fragment fragment) {
        return this.f1564c.add(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment) {
        if (j.I) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        l lVar = this.f1565d.get(fragment.f1413f);
        if (lVar != null) {
            lVar.c();
            this.f1565d.remove(fragment.f1413f);
        }
        androidx.lifecycle.r rVar = this.f1566e.get(fragment.f1413f);
        if (rVar != null) {
            rVar.a();
            this.f1566e.remove(fragment.f1413f);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f1564c.equals(lVar.f1564c) && this.f1565d.equals(lVar.f1565d) && this.f1566e.equals(lVar.f1566e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l f(Fragment fragment) {
        l lVar = this.f1565d.get(fragment.f1413f);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this.f1567f);
        this.f1565d.put(fragment.f1413f, lVar2);
        return lVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Fragment> h() {
        return this.f1564c;
    }

    public int hashCode() {
        return (((this.f1564c.hashCode() * 31) + this.f1565d.hashCode()) * 31) + this.f1566e.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.r i(Fragment fragment) {
        androidx.lifecycle.r rVar = this.f1566e.get(fragment.f1413f);
        if (rVar != null) {
            return rVar;
        }
        androidx.lifecycle.r rVar2 = new androidx.lifecycle.r();
        this.f1566e.put(fragment.f1413f, rVar2);
        return rVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f1568g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(Fragment fragment) {
        return this.f1564c.remove(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(Fragment fragment) {
        if (this.f1564c.contains(fragment)) {
            return this.f1567f ? this.f1568g : !this.f1569h;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1564c.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1565d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1566e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
