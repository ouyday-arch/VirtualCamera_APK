package k2;

import android.app.Application;

/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: l, reason: collision with root package name */
    private final k f4397l;

    public c(Application application) {
        this.f4397l = new k(application, (d) this);
    }

    @Override // l2.a
    public void cancel() {
        this.f4397l.g();
    }

    @Override // l2.a
    public void show() {
        this.f4397l.k();
    }
}
