package r;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class a {
    public static void a(Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int b(Drawable drawable) {
        return drawable.getLayoutDirection();
    }

    public static boolean c(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void d(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void e(Drawable drawable, boolean z4) {
        drawable.setAutoMirrored(z4);
    }

    public static void f(Drawable drawable, float f4, float f5) {
        drawable.setHotspot(f4, f5);
    }

    public static void g(Drawable drawable, int i4, int i5, int i6, int i7) {
        drawable.setHotspotBounds(i4, i5, i6, i7);
    }

    public static boolean h(Drawable drawable, int i4) {
        return drawable.setLayoutDirection(i4);
    }

    public static void i(Drawable drawable, int i4) {
        drawable.setTint(i4);
    }

    public static void j(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void k(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T l(Drawable drawable) {
        return drawable instanceof b ? (T) ((b) drawable).a() : drawable;
    }

    public static Drawable m(Drawable drawable) {
        return drawable;
    }
}
