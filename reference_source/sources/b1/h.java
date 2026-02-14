package b1;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
public class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(int i4) {
        return i4 != 0 ? i4 != 1 ? b() : new e() : new j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b() {
        return new j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f c() {
        return new f();
    }

    public static void d(View view, float f4) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            ((g) background).U(f4);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            f(view, (g) background);
        }
    }

    public static void f(View view, g gVar) {
        if (gVar.O()) {
            gVar.Y(com.google.android.material.internal.j.b(view));
        }
    }
}
