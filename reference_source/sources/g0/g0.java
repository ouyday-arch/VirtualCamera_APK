package g0;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
class g0 implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final WindowId f3828a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(View view) {
        this.f3828a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof g0) && ((g0) obj).f3828a.equals(this.f3828a);
    }

    public int hashCode() {
        return this.f3828a.hashCode();
    }
}
