package g0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class r {

    /* renamed from: b, reason: collision with root package name */
    public View f3881b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f3880a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<l> f3882c = new ArrayList<>();

    @Deprecated
    public r() {
    }

    public r(View view) {
        this.f3881b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f3881b == rVar.f3881b && this.f3880a.equals(rVar.f3880a);
    }

    public int hashCode() {
        return (this.f3881b.hashCode() * 31) + this.f3880a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f3881b + "\n") + "    values:";
        for (String str2 : this.f3880a.keySet()) {
            str = str + "    " + str2 + ": " + this.f3880a.get(str2) + "\n";
        }
        return str;
    }
}
