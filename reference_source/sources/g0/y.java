package g0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static final e0 f3890a;

    /* renamed from: b, reason: collision with root package name */
    static final Property<View, Float> f3891b;

    /* renamed from: c, reason: collision with root package name */
    static final Property<View, Rect> f3892c;

    /* loaded from: classes.dex */
    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(y.c(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f4) {
            y.g(view, f4.floatValue());
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return y.p.n(view);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            y.p.g0(view, rect);
        }
    }

    static {
        f3890a = Build.VERSION.SDK_INT >= 29 ? new d0() : new c0();
        f3891b = new a(Float.class, "translationAlpha");
        f3892c = new b(Rect.class, "clipBounds");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        f3890a.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x b(View view) {
        return new w(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(View view) {
        return f3890a.b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h0 d(View view) {
        return new g0(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(View view) {
        f3890a.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(View view, int i4, int i5, int i6, int i7) {
        f3890a.d(view, i4, i5, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(View view, float f4) {
        f3890a.e(view, f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(View view, int i4) {
        f3890a.f(view, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(View view, Matrix matrix) {
        f3890a.g(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(View view, Matrix matrix) {
        f3890a.h(view, matrix);
    }
}
