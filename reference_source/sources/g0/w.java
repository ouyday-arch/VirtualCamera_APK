package g0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes.dex */
class w implements x {

    /* renamed from: a, reason: collision with root package name */
    private final ViewOverlay f3889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(View view) {
        this.f3889a = view.getOverlay();
    }

    @Override // g0.x
    public void b(Drawable drawable) {
        this.f3889a.add(drawable);
    }

    @Override // g0.x
    public void d(Drawable drawable) {
        this.f3889a.remove(drawable);
    }
}
