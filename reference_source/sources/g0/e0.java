package g0;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
class e0 {

    /* renamed from: a, reason: collision with root package name */
    private static Field f3810a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f3811b;

    public void a(View view) {
        throw null;
    }

    public float b(View view) {
        throw null;
    }

    public void c(View view) {
        throw null;
    }

    public void d(View view, int i4, int i5, int i6, int i7) {
        throw null;
    }

    public void e(View view, float f4) {
        throw null;
    }

    public void f(View view, int i4) {
        if (!f3811b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f3810a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f3811b = true;
        }
        Field field = f3810a;
        if (field != null) {
            try {
                f3810a.setInt(view, i4 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void g(View view, Matrix matrix) {
        throw null;
    }

    public void h(View view, Matrix matrix) {
        throw null;
    }
}
