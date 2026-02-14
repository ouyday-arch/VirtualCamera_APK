package g0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
class t implements u {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f3887a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ViewGroup viewGroup) {
        this.f3887a = viewGroup.getOverlay();
    }

    @Override // g0.u
    public void a(View view) {
        this.f3887a.add(view);
    }

    @Override // g0.x
    public void b(Drawable drawable) {
        this.f3887a.add(drawable);
    }

    @Override // g0.u
    public void c(View view) {
        this.f3887a.remove(view);
    }

    @Override // g0.x
    public void d(Drawable drawable) {
        this.f3887a.remove(drawable);
    }
}
