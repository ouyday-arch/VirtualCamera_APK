package s0;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import y0.b;

/* loaded from: classes.dex */
public class a {
    public static int a(Context context, int i4, int i5) {
        TypedValue a5 = b.a(context, i4);
        return a5 != null ? a5.data : i5;
    }

    public static int b(Context context, int i4, String str) {
        return b.c(context, i4, str);
    }

    public static int c(View view, int i4) {
        return b.d(view, i4);
    }

    public static int d(View view, int i4, int i5) {
        return a(view.getContext(), i4, i5);
    }

    public static int e(int i4, int i5) {
        return q.a.b(i5, i4);
    }

    public static int f(int i4, int i5, float f4) {
        return e(i4, q.a.d(i5, Math.round(Color.alpha(i5) * f4)));
    }

    public static int g(View view, int i4, int i5, float f4) {
        return f(c(view, i4), c(view, i5), f4);
    }
}
