package n;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    protected static final Class<?> f5216a;

    /* renamed from: b, reason: collision with root package name */
    protected static final Field f5217b;

    /* renamed from: c, reason: collision with root package name */
    protected static final Field f5218c;

    /* renamed from: d, reason: collision with root package name */
    protected static final Method f5219d;

    /* renamed from: e, reason: collision with root package name */
    protected static final Method f5220e;

    /* renamed from: f, reason: collision with root package name */
    protected static final Method f5221f;

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f5222g = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    static class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f5223b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f5224c;

        a(d dVar, Object obj) {
            this.f5223b = dVar;
            this.f5224c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5223b.f5229a = this.f5224c;
        }
    }

    /* renamed from: n.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class RunnableC0061b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Application f5225b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f5226c;

        RunnableC0061b(Application application, d dVar) {
            this.f5225b = application;
            this.f5226c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5225b.unregisterActivityLifecycleCallbacks(this.f5226c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f5227b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f5228c;

        c(Object obj, Object obj2) {
            this.f5227b = obj;
            this.f5228c = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = b.f5219d;
                if (method != null) {
                    method.invoke(this.f5227b, this.f5228c, Boolean.FALSE, "AppCompat recreation");
                } else {
                    b.f5220e.invoke(this.f5227b, this.f5228c, Boolean.FALSE);
                }
            } catch (RuntimeException e4) {
                if (e4.getClass() == RuntimeException.class && e4.getMessage() != null && e4.getMessage().startsWith("Unable to stop")) {
                    throw e4;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        Object f5229a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f5230b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5231c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5232d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f5233e = false;

        d(Activity activity) {
            this.f5230b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f5230b == activity) {
                this.f5230b = null;
                this.f5232d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f5232d || this.f5233e || this.f5231c || !b.h(this.f5229a, activity)) {
                return;
            }
            this.f5233e = true;
            this.f5229a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f5230b == activity) {
                this.f5231c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a5 = a();
        f5216a = a5;
        f5217b = b();
        f5218c = f();
        f5219d = d(a5);
        f5220e = c(a5);
        f5221f = e(a5);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i4 = Build.VERSION.SDK_INT;
        return i4 == 26 || i4 == 27;
    }

    protected static boolean h(Object obj, Activity activity) {
        try {
            Object obj2 = f5218c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            f5222g.postAtFrontOfQueue(new c(f5217b.get(activity), obj2));
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f5221f == null) {
            return false;
        }
        if (f5220e == null && f5219d == null) {
            return false;
        }
        try {
            Object obj2 = f5218c.get(activity);
            if (obj2 == null || (obj = f5217b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            Handler handler = f5222g;
            handler.post(new a(dVar, obj2));
            try {
                if (g()) {
                    Method method = f5221f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new RunnableC0061b(application, dVar));
                return true;
            } catch (Throwable th) {
                f5222g.post(new RunnableC0061b(application, dVar));
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
