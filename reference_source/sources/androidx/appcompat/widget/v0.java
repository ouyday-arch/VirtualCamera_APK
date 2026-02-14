package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class v0 extends n0 {

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f1188b;

    public v0(Context context, Resources resources) {
        super(resources);
        this.f1188b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.n0, android.content.res.Resources
    public Drawable getDrawable(int i4) {
        Drawable drawable = super.getDrawable(i4);
        Context context = this.f1188b.get();
        if (drawable != null && context != null) {
            m0.g().w(context, i4, drawable);
        }
        return drawable;
    }
}
