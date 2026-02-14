package y0;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes.dex */
public class b {
    public static TypedValue a(Context context, int i4) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i4, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i4, boolean z4) {
        TypedValue a5 = a(context, i4);
        return (a5 == null || a5.type != 18) ? z4 : a5.data != 0;
    }

    public static int c(Context context, int i4, String str) {
        TypedValue a5 = a(context, i4);
        if (a5 != null) {
            return a5.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i4)));
    }

    public static int d(View view, int i4) {
        return c(view.getContext(), i4, view.getClass().getCanonicalName());
    }
}
