package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private static Field f488a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f489b;

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f490c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f491d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f492e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f493f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f494g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f495h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Resources resources) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        b(resources);
    }

    private static void b(Resources resources) {
        Object obj;
        if (!f495h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f494g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e4);
            }
            f495h = true;
        }
        Field field = f494g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e5) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e5);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f489b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f488a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e6);
            }
            f489b = true;
        }
        Field field2 = f488a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e7) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e7);
            }
        }
        if (obj2 != null) {
            c(obj2);
        }
    }

    private static void c(Object obj) {
        if (!f491d) {
            try {
                f490c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e4) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e4);
            }
            f491d = true;
        }
        Class<?> cls = f490c;
        if (cls == null) {
            return;
        }
        if (!f493f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f492e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e5);
            }
            f493f = true;
        }
        Field field = f492e;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e6) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e6);
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
