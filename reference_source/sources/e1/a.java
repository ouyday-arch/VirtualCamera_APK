package e1;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import f.d;
import m0.b;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f3590a = {R.attr.theme, b.A};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f3591b = {b.f4950r};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3590a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int b(Context context, AttributeSet attributeSet, int i4, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3591b, i4, i5);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i4, int i5) {
        int b5 = b(context, attributeSet, i4, i5);
        boolean z4 = (context instanceof d) && ((d) context).b() == b5;
        if (b5 == 0 || z4) {
            return context;
        }
        d dVar = new d(context, b5);
        int a5 = a(context, attributeSet);
        if (a5 != 0) {
            dVar.getTheme().applyStyle(a5, true);
        }
        return dVar;
    }
}
