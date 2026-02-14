package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements e {

    /* renamed from: b, reason: collision with root package name */
    private static int f321b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f322c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f323d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f324e;

    /* renamed from: a, reason: collision with root package name */
    private Activity f325a;

    private static void h() {
        try {
            f321b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f323d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f324e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f322c = declaredField3;
            declaredField3.setAccessible(true);
            f321b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        if (aVar != d.a.ON_DESTROY) {
            return;
        }
        if (f321b == 0) {
            h();
        }
        if (f321b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f325a.getSystemService("input_method");
            try {
                Object obj = f322c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f323d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f324e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
