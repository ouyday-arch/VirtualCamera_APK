package k2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class n implements l2.c {

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f4431g = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private Application f4432a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<l2.a> f4433b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4434c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f4435d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f4436e;

    /* renamed from: f, reason: collision with root package name */
    private volatile long f4437f;

    /* loaded from: classes.dex */
    private class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final m f4438b;

        private b(m mVar) {
            this.f4438b = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            l2.a aVar = n.this.f4433b != null ? (l2.a) n.this.f4433b.get() : null;
            if (aVar != null) {
                aVar.cancel();
            }
            l2.a f4 = n.this.f(this.f4438b.f4428d);
            n.this.f4433b = new WeakReference(f4);
            f4.setDuration(this.f4438b.f4426b);
            f4.setText(this.f4438b.f4425a);
            f4.show();
        }
    }

    public n() {
        this(0);
    }

    public n(int i4) {
        this.f4435d = new Object();
        this.f4436e = new Object();
        this.f4434c = i4;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("Please don't pass non-existent toast show strategy");
        }
    }

    @Override // l2.c
    public void a(Application application) {
        this.f4432a = application;
        k2.a.b().c(application);
    }

    @Override // l2.c
    public void b(m mVar) {
        int i4 = this.f4434c;
        if (i4 == 0) {
            Handler handler = f4431g;
            handler.removeCallbacksAndMessages(this.f4435d);
            handler.postAtTime(new b(mVar), this.f4435d, SystemClock.uptimeMillis() + mVar.f4427c + 200);
            return;
        }
        if (i4 != 1) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() + mVar.f4427c + 200;
        long h4 = h(mVar);
        if (uptimeMillis < this.f4437f + h4) {
            uptimeMillis = this.f4437f + h4;
        }
        f4431g.postAtTime(new b(mVar), this.f4435d, uptimeMillis);
        this.f4437f = uptimeMillis;
    }

    @SuppressLint({"PrivateApi"})
    protected boolean e(Context context) {
        return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
    }

    public l2.a f(l2.d<?> dVar) {
        Activity a5 = k2.a.b().a();
        int i4 = Build.VERSION.SDK_INT;
        l2.a cVar = Settings.canDrawOverlays(this.f4432a) ? new c(this.f4432a) : a5 != null ? new k2.b(a5) : i4 == 25 ? new h(this.f4432a) : (i4 >= 29 || e(this.f4432a)) ? new i(this.f4432a) : new f(this.f4432a);
        if (j(cVar) || !k()) {
            g(cVar, dVar);
        }
        return cVar;
    }

    protected void g(l2.a aVar, l2.d<?> dVar) {
        aVar.setView(dVar.a(this.f4432a));
        aVar.setGravity(dVar.e(), dVar.d(), dVar.f());
        aVar.setMargin(dVar.b(), dVar.c());
    }

    protected int h(m mVar) {
        int i4 = mVar.f4426b;
        if (i4 == 0) {
            return 1000;
        }
        return i4 == 1 ? 1500 : 0;
    }

    @SuppressLint({"PrivateApi"})
    protected boolean i(long j4) {
        if (Build.VERSION.SDK_INT < 30) {
            return true;
        }
        try {
            Method method = Class.forName("android.app.compat.CompatChanges").getMethod("isChangeEnabled", Long.TYPE);
            method.setAccessible(true);
            return Boolean.parseBoolean(String.valueOf(method.invoke(null, Long.valueOf(j4))));
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return false;
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
            return false;
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
            return false;
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
            return false;
        }
    }

    protected boolean j(l2.a aVar) {
        return (aVar instanceof d) || Build.VERSION.SDK_INT < 30 || this.f4432a.getApplicationInfo().targetSdkVersion < 30;
    }

    protected boolean k() {
        return i(147798919L);
    }
}
