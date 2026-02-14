package n2;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;

/* loaded from: classes.dex */
final class f implements ComponentCallbacks {

    /* renamed from: b, reason: collision with root package name */
    private int f5340b;

    /* renamed from: c, reason: collision with root package name */
    private a f5341c;

    /* loaded from: classes.dex */
    interface a {
        default void a(int i4) {
        }
    }

    public f(Configuration configuration) {
        this.f5340b = configuration.orientation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, a aVar) {
        context.getApplicationContext().registerComponentCallbacks(this);
        this.f5341c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context) {
        context.getApplicationContext().unregisterComponentCallbacks(this);
        this.f5341c = null;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int i4 = this.f5340b;
        int i5 = configuration.orientation;
        if (i4 == i5) {
            return;
        }
        this.f5340b = i5;
        a aVar = this.f5341c;
        if (aVar == null) {
            return;
        }
        aVar.a(i5);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }
}
