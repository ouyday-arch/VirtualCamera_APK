package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class b1 extends Resources {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f939b;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f940a;

    public b1(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f940a = new WeakReference<>(context);
    }

    public static boolean a() {
        return f939b;
    }

    public static boolean b() {
        a();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable c(int i4) {
        return super.getDrawable(i4);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i4) {
        Context context = this.f940a.get();
        return context != null ? m0.g().s(context, this, i4) : super.getDrawable(i4);
    }
}
