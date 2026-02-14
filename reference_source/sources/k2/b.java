package k2;

import android.app.Activity;

/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: l, reason: collision with root package name */
    private final k f4396l;

    public b(Activity activity) {
        this.f4396l = new k(activity, (d) this);
    }

    @Override // l2.a
    public void cancel() {
        this.f4396l.g();
    }

    @Override // l2.a
    public void show() {
        this.f4396l.k();
    }
}
