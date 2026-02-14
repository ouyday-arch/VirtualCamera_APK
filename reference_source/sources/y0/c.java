package y0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.w0;

/* loaded from: classes.dex */
public class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i4) {
        int resourceId;
        ColorStateList a5;
        return (!typedArray.hasValue(i4) || (resourceId = typedArray.getResourceId(i4, 0)) == 0 || (a5 = c.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i4) : a5;
    }

    public static ColorStateList b(Context context, w0 w0Var, int i4) {
        int n4;
        ColorStateList a5;
        return (!w0Var.r(i4) || (n4 = w0Var.n(i4, 0)) == 0 || (a5 = c.a.a(context, n4)) == null) ? w0Var.c(i4) : a5;
    }

    public static int c(Context context, TypedArray typedArray, int i4, int i5) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i4, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i4, i5);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i5);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(Context context, TypedArray typedArray, int i4) {
        int resourceId;
        Drawable b5;
        return (!typedArray.hasValue(i4) || (resourceId = typedArray.getResourceId(i4, 0)) == 0 || (b5 = c.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i4) : b5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(TypedArray typedArray, int i4, int i5) {
        return typedArray.hasValue(i4) ? i4 : i5;
    }

    public static d f(Context context, TypedArray typedArray, int i4) {
        int resourceId;
        if (!typedArray.hasValue(i4) || (resourceId = typedArray.getResourceId(i4, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }
}
