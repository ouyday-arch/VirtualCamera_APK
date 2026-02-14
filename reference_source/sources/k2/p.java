package k2;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private Activity f4445a;

    /* renamed from: b, reason: collision with root package name */
    private Application f4446b;

    /* renamed from: c, reason: collision with root package name */
    private k f4447c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Activity activity) {
        this.f4445a = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Application application) {
        this.f4446b = application;
    }

    public WindowManager a() {
        Activity activity = this.f4445a;
        if (activity != null) {
            if (activity.isDestroyed()) {
                return null;
            }
            return this.f4445a.getWindowManager();
        }
        Application application = this.f4446b;
        if (application != null) {
            return (WindowManager) application.getSystemService("window");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.f4447c = kVar;
        Activity activity = this.f4445a;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            activity.registerActivityLifecycleCallbacks(this);
        } else {
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f4447c = null;
        Activity activity = this.f4445a;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            activity.unregisterActivityLifecycleCallbacks(this);
        } else {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.f4445a != activity) {
            return;
        }
        k kVar = this.f4447c;
        if (kVar != null) {
            kVar.g();
        }
        c();
        this.f4445a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        k kVar;
        if (this.f4445a == activity && (kVar = this.f4447c) != null) {
            kVar.g();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
