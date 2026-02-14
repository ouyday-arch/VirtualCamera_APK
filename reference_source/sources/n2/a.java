package n2;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private Activity f5323a;

    /* renamed from: b, reason: collision with root package name */
    private e<?> f5324b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e<?> eVar, Activity activity) {
        this.f5323a = activity;
        this.f5324b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Activity activity = this.f5323a;
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
    public void b() {
        Activity activity = this.f5323a;
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
        if (this.f5323a != activity) {
            return;
        }
        this.f5323a = null;
        e<?> eVar = this.f5324b;
        if (eVar == null) {
            return;
        }
        eVar.q();
        this.f5324b = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        e<?> eVar;
        Activity activity2 = this.f5323a;
        if (activity2 == activity && activity2.isFinishing() && (eVar = this.f5324b) != null && eVar.j()) {
            this.f5324b.e();
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
