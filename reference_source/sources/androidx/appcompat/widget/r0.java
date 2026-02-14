package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r0 {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1159a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    static final int[] f1160b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f1161c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    static final int[] f1162d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f1163e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f1164f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    static final int[] f1165g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    static final int[] f1166h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    static final int[] f1167i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f1168j = new int[1];

    public static int a(Context context, int i4) {
        ColorStateList d5 = d(context, i4);
        if (d5 != null && d5.isStateful()) {
            return d5.getColorForState(f1160b, d5.getDefaultColor());
        }
        TypedValue e4 = e();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, e4, true);
        return c(context, i4, e4.getFloat());
    }

    public static int b(Context context, int i4) {
        int[] iArr = f1168j;
        iArr[0] = i4;
        w0 t4 = w0.t(context, null, iArr);
        try {
            return t4.b(0, 0);
        } finally {
            t4.v();
        }
    }

    static int c(Context context, int i4, float f4) {
        return q.a.d(b(context, i4), Math.round(Color.alpha(r0) * f4));
    }

    public static ColorStateList d(Context context, int i4) {
        int[] iArr = f1168j;
        iArr[0] = i4;
        w0 t4 = w0.t(context, null, iArr);
        try {
            return t4.c(0);
        } finally {
            t4.v();
        }
    }

    private static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = f1159a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
